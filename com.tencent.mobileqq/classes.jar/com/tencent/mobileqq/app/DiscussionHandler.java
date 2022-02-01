package com.tencent.mobileqq.app;

import QQService.AddDiscussMemberInfo;
import QQService.DiscussInfo;
import QQService.DiscussRespHeader;
import QQService.InteRemarkInfo;
import QQService.RespAddDiscussMember;
import QQService.RespChangeDiscussName;
import QQService.RespCreateDiscuss;
import QQService.RespGetDiscussInfo;
import QQService.RespGetDiscussInteRemark;
import QQService.RespJoinDiscuss;
import QQService.RespQuitDiscuss;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.service.discussion.DiscussionReceiver.RespPackage;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.troop.discussion.IDiscussionObserver;
import com.tencent.mobileqq.util.MessageRecordUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.QAVHrMeeting;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlRequest;
import com.tencent.protofile.discuss.FlyTicket.DiscussGetUrlResponse;
import com.tencent.protofile.discuss.FlyTicket.DiscussSigDecodeRequest;
import com.tencent.protofile.discuss.FlyTicket.DiscussSigDecodeResponse;
import com.tencent.protofile.discuss.FlyTicket.RetInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.NewIntent;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x44c.cmd0x44c.ModifyConfInfoReq;
import tencent.im.oidb.cmd0x44c.cmd0x44c.ReqBody;
import tencent.im.oidb.cmd0x44c.cmd0x44c.RspBody;
import tencent.im.oidb.cmd0x58a.cmd0x58a.ConfBaseInfo;
import tencent.im.oidb.cmd0x58a.cmd0x58a.ReqBody;
import tencent.im.oidb.cmd0x58b.cmd0x58b.ConfBaseInfo;
import tencent.im.oidb.cmd0x58b.cmd0x58b.ConfMemberInfo;
import tencent.im.oidb.cmd0x58b.cmd0x58b.GetMultiConfInfoReq;
import tencent.im.oidb.cmd0x58b.cmd0x58b.ReqBody;
import tencent.im.oidb.cmd0x751.oidb_0x751.CheckIsConfMemberResult;
import tencent.im.oidb.cmd0x751.oidb_0x751.RspBody;
import tencent.im.oidb.cmd0x751.oidb_0x751.RspCheckIsConfMember;
import tencent.im.oidb.cmd0x921.cmd0x921.GetAtAllRemain;
import tencent.im.oidb.cmd0x921.cmd0x921.GetAtAllRemainRsp;
import tencent.im.oidb.cmd0x921.cmd0x921.ReqBody;
import tencent.im.oidb.cmd0x921.cmd0x921.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;

public class DiscussionHandler
  extends BusinessHandler
{
  private long jdField_a_of_type_Long = 0L;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private GroupIconHelper jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper;
  private ArrayList<Pair<Boolean, String>> jdField_a_of_type_JavaUtilArrayList = null;
  private LinkedHashMap<String, DiscussionHandler.ReqDiscussInfo> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(100);
  private long jdField_b_of_type_Long = 0L;
  private LinkedHashMap<String, DiscussionHandler.ReqDiscussInfo> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  DiscussionHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper = new GroupIconHelper(paramQQAppInterface.getCurrentAccountUin(), this);
  }
  
  DiscussionHandler(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (!paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER));
    }
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper = new GroupIconHelper(paramQQAppInterface.getCurrentAccountUin(), this);
  }
  
  private DiscussionMemberInfo a(DiscussionInfo paramDiscussionInfo, cmd0x58b.ConfMemberInfo paramConfMemberInfo)
  {
    DiscussionMemberInfo localDiscussionMemberInfo = new DiscussionMemberInfo();
    localDiscussionMemberInfo.discussionUin = paramDiscussionInfo.uin;
    localDiscussionMemberInfo.memberUin = String.valueOf(paramConfMemberInfo.uint64_uin.get());
    localDiscussionMemberInfo.flag = ((byte)paramConfMemberInfo.uint32_flag.get());
    localDiscussionMemberInfo.dataTime = System.currentTimeMillis();
    if (!paramDiscussionInfo.isDiscussHrMeeting())
    {
      if ((paramConfMemberInfo.bytes_member_interemark.has()) && (!TextUtils.isEmpty(paramConfMemberInfo.bytes_member_interemark.get().toStringUtf8())))
      {
        localDiscussionMemberInfo.inteRemark = paramConfMemberInfo.bytes_member_interemark.get().toStringUtf8();
        localDiscussionMemberInfo.inteRemarkSource = paramConfMemberInfo.uint32_interemark_source.get();
        return localDiscussionMemberInfo;
      }
      paramDiscussionInfo = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramDiscussionInfo != null)
      {
        paramDiscussionInfo = paramDiscussionInfo.b(localDiscussionMemberInfo.memberUin);
        if ((paramDiscussionInfo != null) && (paramDiscussionInfo.isFriend()))
        {
          localDiscussionMemberInfo.memberName = paramDiscussionInfo.name;
          if (TextUtils.isEmpty(paramDiscussionInfo.remark)) {
            paramDiscussionInfo = paramDiscussionInfo.name;
          } else {
            paramDiscussionInfo = paramDiscussionInfo.remark;
          }
          localDiscussionMemberInfo.inteRemark = paramDiscussionInfo;
          localDiscussionMemberInfo.inteRemarkSource = 129L;
          return localDiscussionMemberInfo;
        }
        localDiscussionMemberInfo.inteRemarkSource = 0L;
      }
    }
    return localDiscussionMemberInfo;
  }
  
  private void a(int paramInt)
  {
    String str;
    if (paramInt != 110) {
      switch (paramInt)
      {
      default: 
        str = BaseApplicationImpl.getApplication().getResources().getString(2131691776);
        break;
      case 102: 
        str = BaseApplicationImpl.getApplication().getResources().getString(2131691777);
        break;
      case 101: 
        str = BaseApplicationImpl.getApplication().getResources().getString(2131691780);
        break;
      case 100: 
      case 103: 
      case 104: 
      case 105: 
        str = BaseApplicationImpl.getApplication().getResources().getString(2131691779);
        break;
      }
    } else {
      str = BaseApplicationImpl.getApplication().getResources().getString(2131691778);
    }
    ThreadManager.getUIHandler().post(new DiscussionHandler.1(this, str));
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    MessageRecord localMessageRecord = MessageRecordFactory.a(-1004);
    localMessageRecord.init(paramLong1, paramLong2, paramLong2, paramString, NetConnInfoCenter.getServerTime(), -1004, 3000, NetConnInfoCenter.getServerTime());
    localMessageRecord.isread = true;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("----------addMsgToDB after analysis friendUin: ");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append(" msgType: ");
      localStringBuilder.append(-1004);
      localStringBuilder.append(" friendType: ");
      localStringBuilder.append(3000);
      localStringBuilder.append(" msgContent: ");
      localStringBuilder.append(MessageRecordUtil.a(paramString));
      QLog.d("DiscussionHandler", 2, localStringBuilder.toString());
    }
    paramString = (MessageHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.MESSAGE_HANDLER);
    if (!MessageHandlerUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localMessageRecord, false)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(localMessageRecord, String.valueOf(paramLong1));
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<---handleError serviceCmd:");
      localStringBuilder.append(str);
      QLog.d("DiscussionHandler", 2, localStringBuilder.toString());
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str))
    {
      h(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str))
    {
      g(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str))
    {
      f(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x58a".equalsIgnoreCase(str))
    {
      e(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str)) {
      return;
    }
    if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str))
    {
      d(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str))
    {
      c(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str))
    {
      b(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QRCodeSvc.discuss_geturl".equals(str))
    {
      d(paramToServiceMsg, paramFromServiceMsg, null);
      return;
    }
    if ("QRCodeSvc.discuss_decode".equals(str))
    {
      e(paramToServiceMsg, paramFromServiceMsg, null);
      return;
    }
    if ("QQServiceDiscussSvc.ReqJoinDiscuss".equals(str))
    {
      g(paramToServiceMsg, paramFromServiceMsg, null);
      return;
    }
    if ("OidbSvc.0x921_0".equals(str))
    {
      notifyUI(1018, false, new Object[] { paramToServiceMsg.extraData.getString("discUid"), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) });
      return;
    }
    if ("OidbSvc.0x58b_0".equals(str))
    {
      x(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x751".equalsIgnoreCase(str))
    {
      q(paramToServiceMsg, paramFromServiceMsg, null);
      return;
    }
    if ("OidbSvc.0x44c".equals(str)) {
      o(paramToServiceMsg, paramFromServiceMsg, null);
    }
  }
  
  private void a(String paramString, DiscussionInfo paramDiscussionInfo)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleGetDiscussInfoRespV2, new info, disUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], DiscussionFlag[");
      localStringBuilder.append(paramDiscussionInfo.DiscussionFlag);
      localStringBuilder.append("]");
      QLog.d("Q.contacttab.dscs", 2, localStringBuilder.toString());
    }
  }
  
  private void a(String paramString, cmd0x58b.ConfBaseInfo paramConfBaseInfo, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(512);
      localStringBuilder.append("handleGetDiscussInfoRespV2, server data:");
      localStringBuilder.append(" disUin[");
      localStringBuilder.append(paramString);
      localStringBuilder.append("], owner[");
      localStringBuilder.append(paramConfBaseInfo.uint64_owner_uin.get());
      localStringBuilder.append("], errCode[");
      localStringBuilder.append(paramInt2);
      localStringBuilder.append("], flag[");
      localStringBuilder.append(paramConfBaseInfo.uint32_flag.get());
      localStringBuilder.append("], createTime[");
      localStringBuilder.append(paramConfBaseInfo.uint32_create_time.get());
      localStringBuilder.append("], disName[");
      localStringBuilder.append(MessageRecordUtil.a(paramConfBaseInfo.bytes_conf_name.get().toStringUtf8()));
      localStringBuilder.append("], infoseq[");
      localStringBuilder.append(paramInt3);
      localStringBuilder.append("], timesec[");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append("], discOrigin[");
      localStringBuilder.append(paramLong1);
      localStringBuilder.append("], discOriginExtra[");
      localStringBuilder.append(paramLong2);
      localStringBuilder.append("]");
      QLog.d("Q.contacttab.dscs", 2, new Object[] { localStringBuilder });
    }
  }
  
  private void a(String paramString1, cmd0x58b.ConfBaseInfo paramConfBaseInfo, int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString2, DiscussionManager paramDiscussionManager, DiscussionInfo paramDiscussionInfo)
  {
    paramDiscussionInfo.createTime = paramConfBaseInfo.uint32_create_time.get();
    paramDiscussionInfo.ownerUin = String.valueOf(paramConfBaseInfo.uint64_owner_uin.get());
    paramDiscussionInfo.inheritOwnerUin = String.valueOf(paramConfBaseInfo.uint64_inherit_owner_uin.get());
    paramDiscussionInfo.timeSec = paramInt1;
    paramDiscussionInfo.groupUin = paramConfBaseInfo.uint64_group_uin.get();
    paramDiscussionInfo.groupCode = paramConfBaseInfo.uint64_group_code.get();
    paramDiscussionInfo.mOrigin = paramLong1;
    paramDiscussionInfo.mOriginExtra = paramLong2;
    paramLong1 = paramInt2;
    if ((0x40 & paramLong1) == 0L)
    {
      paramDiscussionInfo.discussionName = paramString2;
      paramDiscussionInfo.DiscussionFlag = (paramLong1 | 0x20000000);
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramConfBaseInfo = new StringBuilder();
        paramConfBaseInfo.append("handleGetDiscussInfoRespV2 disUin=");
        paramConfBaseInfo.append(paramString1);
        paramConfBaseInfo.append(" old flag=");
        paramConfBaseInfo.append(paramDiscussionInfo.DiscussionFlag);
        QLog.d("DiscussionHandler", 2, paramConfBaseInfo.toString());
      }
      paramDiscussionInfo.DiscussionFlag = paramLong1;
      paramDiscussionInfo.DiscussionFlag |= 0x20000000;
      paramDiscussionInfo.discussionName = paramString2;
    }
    paramDiscussionManager.a(paramDiscussionInfo);
  }
  
  private void a(String paramString, cmd0x58b.ConfBaseInfo paramConfBaseInfo, List<cmd0x58b.ConfMemberInfo> paramList, FriendsManager paramFriendsManager, DiscussionManager paramDiscussionManager, DiscussionInfo paramDiscussionInfo)
  {
    HashMap localHashMap = new HashMap();
    long l = System.currentTimeMillis();
    Map localMap = paramDiscussionManager.a(paramString);
    QAVHrMeeting.a("handleGetDiscussInfoRespV2", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDiscussionInfo);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      cmd0x58b.ConfMemberInfo localConfMemberInfo = (cmd0x58b.ConfMemberInfo)localIterator.next();
      String str = String.valueOf(localConfMemberInfo.uint64_uin.get());
      if (QLog.isColorLevel())
      {
        localStringBuffer.append("handleGetDiscussInfoRespV2, memberUin=");
        localStringBuffer.append(str.toString());
        localStringBuffer.append("flag=");
        localStringBuffer.append(localConfMemberInfo.uint32_flag.get());
        localStringBuffer.append("inteRemark=");
        localStringBuffer.append(MessageRecordUtil.a(localConfMemberInfo.bytes_member_interemark.get().toStringUtf8()));
        localStringBuffer.append("Source=");
        localStringBuffer.append(localConfMemberInfo.uint32_interemark_source.get());
        localStringBuffer.append("\r\n");
      }
      paramList = null;
      if (localMap != null) {
        paramList = (DiscussionMemberInfo)localMap.get(str);
      }
      Object localObject = paramList;
      if (paramList == null)
      {
        localObject = new DiscussionMemberInfo();
        ((DiscussionMemberInfo)localObject).discussionUin = paramString;
        ((DiscussionMemberInfo)localObject).memberUin = str;
      }
      ((DiscussionMemberInfo)localObject).flag = ((byte)localConfMemberInfo.uint32_flag.get());
      ((DiscussionMemberInfo)localObject).dataTime = l;
      if ((localConfMemberInfo.bytes_member_interemark.has()) && (!TextUtils.isEmpty(localConfMemberInfo.bytes_member_interemark.get().toStringUtf8())))
      {
        ((DiscussionMemberInfo)localObject).inteRemark = localConfMemberInfo.bytes_member_interemark.get().toStringUtf8();
      }
      else if (TextUtils.isEmpty(((DiscussionMemberInfo)localObject).inteRemark))
      {
        paramList = paramFriendsManager.b(((DiscussionMemberInfo)localObject).memberUin);
        if ((paramList != null) && (paramList.isFriend()))
        {
          ((DiscussionMemberInfo)localObject).memberName = paramList.name;
          if (TextUtils.isEmpty(paramList.remark)) {
            paramList = paramList.name;
          } else {
            paramList = paramList.remark;
          }
          ((DiscussionMemberInfo)localObject).inteRemark = paramList;
          ((DiscussionMemberInfo)localObject).inteRemarkSource = 129L;
        }
        else
        {
          ((DiscussionMemberInfo)localObject).inteRemarkSource = 0L;
        }
      }
      QAVHrMeeting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramDiscussionInfo, (DiscussionMemberInfo)localObject);
      localHashMap.put(((DiscussionMemberInfo)localObject).memberUin, localObject);
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, localStringBuffer.toString());
    }
    paramDiscussionManager.a(paramString, paramDiscussionInfo, paramConfBaseInfo.uint32_info_seq.get(), localHashMap, l);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.c(paramDiscussionInfo.uin);
  }
  
  private void a(ArrayList<Object> paramArrayList, int paramInt1, String paramString1, List<cmd0x58b.ConfMemberInfo> paramList, long paramLong1, long paramLong2, int paramInt2, String paramString2, DiscussionManager paramDiscussionManager, DiscussionInfo paramDiscussionInfo)
  {
    Map localMap = paramDiscussionManager.a(paramString1);
    paramArrayList.set(paramInt1 * 2 + 1, Boolean.valueOf(a(paramDiscussionInfo, paramList, localMap)));
    long l = paramInt2;
    if ((l & 0x40) == 0L)
    {
      if (!paramDiscussionInfo.discussionName.equals(paramString2))
      {
        paramDiscussionInfo.DiscussionFlag = (l | 0x20000000);
        paramDiscussionInfo.discussionName = paramString2;
        if (QLog.isColorLevel())
        {
          paramArrayList = new StringBuilder();
          paramArrayList.append("handleGetDiscussInfoRespV2 disUin=");
          paramArrayList.append(paramString1);
          paramArrayList.append(" name need server name| local name=");
          paramArrayList.append(MessageRecordUtil.a(paramDiscussionInfo.discussionName));
          QLog.d("Q.contacttab.dscs", 2, paramArrayList.toString());
        }
      }
      else
      {
        paramInt1 = 0;
        break label243;
      }
    }
    else
    {
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("handleGetDiscussInfoRespV2 disUin=");
        paramArrayList.append(paramString1);
        paramArrayList.append(" old flag=");
        paramArrayList.append(paramDiscussionInfo.DiscussionFlag);
        QLog.d("Q.contacttab.dscs", 2, paramArrayList.toString());
      }
      paramDiscussionInfo.DiscussionFlag = l;
      paramDiscussionInfo.DiscussionFlag |= 0x20000000;
      ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString1, paramDiscussionInfo, localMap, false);
    }
    paramInt1 = 1;
    label243:
    if ((paramLong1 != paramDiscussionInfo.mOrigin) || (paramLong2 != paramDiscussionInfo.mOriginExtra))
    {
      if (QQAudioHelper.c())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("handleGetDiscussInfoRespV2, update mOrigin[");
        paramArrayList.append(paramDiscussionInfo.mOrigin);
        paramArrayList.append("->");
        paramArrayList.append(paramLong1);
        paramArrayList.append("], mOriginExtra[");
        paramArrayList.append(paramDiscussionInfo.mOriginExtra);
        paramArrayList.append("->");
        paramArrayList.append(paramLong2);
        paramArrayList.append("]");
        QLog.w("DiscussionHandler", 1, paramArrayList.toString());
      }
      paramInt1 = 1;
      paramDiscussionInfo.mOrigin = paramLong1;
      paramDiscussionInfo.mOriginExtra = paramLong2;
    }
    if (paramInt1 != 0) {
      paramDiscussionManager.a(paramDiscussionInfo);
    }
  }
  
  private void a(ArrayList<Long> paramArrayList, ArrayList<Object> paramArrayList1, HashMap<String, DiscussionHandler.ReqDiscussInfo> paramHashMap)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Long localLong = (Long)paramArrayList.next();
        DiscussionHandler.ReqDiscussInfo localReqDiscussInfo = (DiscussionHandler.ReqDiscussInfo)this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(String.valueOf(localLong));
        if (localReqDiscussInfo != null)
        {
          localReqDiscussInfo.jdField_a_of_type_Int += 1;
          paramHashMap.put(String.valueOf(localLong), localReqDiscussInfo);
          paramArrayList1.add(String.valueOf(localLong));
          paramArrayList1.add(Boolean.valueOf(false));
        }
      }
    }
  }
  
  private boolean a()
  {
    return this.jdField_b_of_type_JavaUtilLinkedHashMap.size() > 0;
  }
  
  private boolean a(DiscussionInfo paramDiscussionInfo, List<cmd0x58b.ConfMemberInfo> paramList, Map<String, DiscussionMemberInfo> paramMap)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    ArrayList localArrayList = new ArrayList();
    long l;
    if ((paramList != null) && (paramMap != null))
    {
      l = System.currentTimeMillis();
      paramList = paramList.iterator();
    }
    while (paramList.hasNext())
    {
      cmd0x58b.ConfMemberInfo localConfMemberInfo = (cmd0x58b.ConfMemberInfo)paramList.next();
      if ((localConfMemberInfo.bytes_member_interemark.has()) && (!TextUtils.isEmpty(localConfMemberInfo.bytes_member_interemark.get().toStringUtf8())))
      {
        String str = String.valueOf(localConfMemberInfo.uint64_uin.get());
        Object localObject = (DiscussionMemberInfo)paramMap.get(str);
        if (localObject == null)
        {
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("warning dbMemberInfo is null uin=");
            ((StringBuilder)localObject).append(str);
            QLog.d("DiscussionHandler", 2, ((StringBuilder)localObject).toString());
          }
          localArrayList.add(a(paramDiscussionInfo, localConfMemberInfo));
        }
        else if ((!paramDiscussionInfo.isDiscussHrMeeting()) && (!TextUtils.isEmpty(((DiscussionMemberInfo)localObject).memberUin)) && (((DiscussionMemberInfo)localObject).memberUin.equals(str)) && (!TextUtils.isEmpty(((DiscussionMemberInfo)localObject).inteRemark)) && (!((DiscussionMemberInfo)localObject).inteRemark.equals(localConfMemberInfo.bytes_member_interemark.get().toStringUtf8())))
        {
          ((DiscussionMemberInfo)localObject).dataTime = l;
          ((DiscussionMemberInfo)localObject).inteRemark = localConfMemberInfo.bytes_member_interemark.get().toStringUtf8();
          ((DiscussionMemberInfo)localObject).inteRemarkSource = localConfMemberInfo.uint32_interemark_source.get();
          localArrayList.add(localObject);
          break;
          if ((paramList != null) && (paramMap == null))
          {
            System.currentTimeMillis();
            paramList = paramList.iterator();
            while (paramList.hasNext()) {
              localArrayList.add(a(paramDiscussionInfo, (cmd0x58b.ConfMemberInfo)paramList.next()));
            }
          }
        }
      }
    }
    if (localArrayList.size() > 0)
    {
      localDiscussionManager.b(localArrayList);
      return true;
    }
    return false;
  }
  
  private boolean a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramFromServiceMsg.getResultCode() == 1002)
    {
      int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
      if (i < 1)
      {
        paramToServiceMsg.extraData.putInt("retryTime", i + 1);
        send(paramToServiceMsg);
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMemberTimeoutOrErrorResult retry timeout!");
      }
      return true;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleCheckIsDiscussionMemberTimeoutOrErrorResult failCode:");
        paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
        QLog.d("DiscussionHandler", 2, paramToServiceMsg.toString());
      }
      return true;
    }
    return false;
  }
  
  private boolean a(boolean paramBoolean, List<cmd0x58a.ConfBaseInfo> paramList, List<Long> paramList1)
  {
    Object localObject2 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a();
    Object localObject1 = new HashMap(((ArrayList)localObject2).size());
    localObject2 = ((ArrayList)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (DiscussionInfo)((Iterator)localObject2).next();
      ((HashMap)localObject1).put(((DiscussionInfo)localObject3).uin, localObject3);
    }
    localObject2 = new ArrayList(paramList.size());
    Object localObject3 = new ArrayList();
    paramList = paramList.iterator();
    Object localObject4;
    while (paramList.hasNext())
    {
      localObject4 = (cmd0x58a.ConfBaseInfo)paramList.next();
      DiscussionInfo localDiscussionInfo = new DiscussionInfo();
      localDiscussionInfo.uin = String.valueOf(((cmd0x58a.ConfBaseInfo)localObject4).uint64_conf_uin.get());
      localDiscussionInfo.infoSeq = ((cmd0x58a.ConfBaseInfo)localObject4).uint32_info_seq.get();
      localDiscussionInfo.mUnreliableMemberCount = ((cmd0x58a.ConfBaseInfo)localObject4).uint32_member_num.get();
      ((ArrayList)localObject2).add(localDiscussionInfo);
      if (((cmd0x58a.ConfBaseInfo)localObject4).uint32_is_favorite.get() == 1) {
        ((ArrayList)localObject3).add(localDiscussionInfo.uin);
      }
      if (((HashMap)localObject1).containsKey(localDiscussionInfo.uin)) {
        ((HashMap)localObject1).remove(localDiscussionInfo.uin);
      }
    }
    if ((paramList1 != null) && (paramList1.size() > 0))
    {
      if (QLog.isColorLevel())
      {
        paramList = new StringBuilder();
        paramList.append("handleGetDiscussResp bakUinList size = ");
        paramList.append(paramList1.size());
        QLog.d("DiscussionHandler", 2, paramList.toString());
      }
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        paramList1 = String.valueOf((Long)paramList.next());
        if (((HashMap)localObject1).containsKey(paramList1))
        {
          if (QLog.isColorLevel())
          {
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append("handleGetDiscussResp uin: ");
            ((StringBuilder)localObject4).append(paramList1);
            ((StringBuilder)localObject4).append(" is in bakUinList,can not delete");
            QLog.d("DiscussionHandler", 2, ((StringBuilder)localObject4).toString());
          }
          ((HashMap)localObject1).remove(paramList1);
        }
      }
    }
    paramList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMsgCache();
    paramList1 = new StringBuilder(100);
    paramList1.append("need delete dis ");
    localObject1 = ((HashMap)localObject1).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (String)((Iterator)localObject1).next();
      paramList1.append((String)localObject4);
      paramList1.append(";");
      a((String)localObject4);
      if (paramList.b((String)localObject4) != null) {
        paramList.d((String)localObject4);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, paramList1.toString());
    }
    if (QLog.isColorLevel())
    {
      paramList = new StringBuilder();
      paramList.append("GetDiscussList dis_cnt=");
      paramList.append(((ArrayList)localObject2).size());
      paramList.append(" fav_cnt=");
      paramList.append(((ArrayList)localObject3).size());
      QLog.d("DiscussionVerify", 2, paramList.toString());
    }
    return a((ArrayList)localObject2, (ArrayList)localObject3);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1004, false, String.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1000, false, null);
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[2] = Integer.valueOf(-1);
    notifyUI(1002, false, paramToServiceMsg);
  }
  
  private void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1005, false, String.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
  }
  
  private void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1003, false, new Object[] { String.valueOf(paramToServiceMsg.extraData.getLong("discussUin")), Integer.valueOf(-1), null });
  }
  
  private void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<---handleTimeOut serviceCmd:");
      localStringBuilder.append(str);
      QLog.d("DiscussionHandler", 2, localStringBuilder.toString());
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str))
    {
      w(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str))
    {
      v(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str))
    {
      u(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x58a".equalsIgnoreCase(str))
    {
      t(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str))
    {
      s(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str))
    {
      r(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str))
    {
      q(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str))
    {
      p(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QRCodeSvc.discuss_geturl".equals(str))
    {
      d(paramToServiceMsg, paramFromServiceMsg, null);
      return;
    }
    if ("QRCodeSvc.discuss_decode".equals(str))
    {
      e(paramToServiceMsg, paramFromServiceMsg, null);
      return;
    }
    if ("QQServiceDiscussSvc.ReqJoinDiscuss".equals(str))
    {
      g(paramToServiceMsg, paramFromServiceMsg, null);
      return;
    }
    if ("OidbSvc.0x865_3".equals(str))
    {
      m(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x870_4".equals(str))
    {
      o(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x870_5".equals(str))
    {
      n(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x921_0".equals(str))
    {
      notifyUI(1018, false, new Object[] { paramToServiceMsg.extraData.getString("discUid"), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0) });
      return;
    }
    if ("OidbSvc.0x58b_0".equalsIgnoreCase(str))
    {
      y(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("OidbSvc.0x751".equalsIgnoreCase(str))
    {
      q(paramToServiceMsg, paramFromServiceMsg, null);
      return;
    }
    if ("OidbSvc.0x44c".equals(str)) {
      o(paramToServiceMsg, paramFromServiceMsg, null);
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getLong("dwDelMemberUin");
    notifyUI(1015, false, new long[] { Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin")).longValue(), Long.valueOf(l).longValue() });
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1017, false, Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin")));
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    notifyUI(1016, false, Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin")));
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    j(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    k(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    l(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg) {}
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    d(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject;
    if (paramToServiceMsg != null)
    {
      if (paramFromServiceMsg == null) {
        return;
      }
      paramFromServiceMsg = paramToServiceMsg.extraData.getString("discUid");
      paramToServiceMsg = new Object[4];
      paramToServiceMsg[0] = paramFromServiceMsg;
      paramToServiceMsg[1] = Boolean.valueOf(false);
      paramToServiceMsg[2] = Integer.valueOf(0);
      paramToServiceMsg[3] = Integer.valueOf(0);
      localObject = new oidb_sso.OIDBSSOPkg();
    }
    label261:
    label281:
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
      if ((paramObject != null) && (paramObject.uint32_result.has()) && (paramObject.uint32_result.get() == 0) && (paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null)) {
        localObject = new cmd0x921.RspBody();
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      boolean bool;
      label190:
      label220:
      break label281;
    }
    try
    {
      ((cmd0x921.RspBody)localObject).mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
      bool = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.bool_priviledge.get();
      if (!((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_uin_remain.has()) {
        break label299;
      }
      i = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_uin_remain.get();
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      break label261;
      i = 0;
      break label190;
      j = 0;
      break label220;
    }
    if (((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_discuss_uin_remain.has())
    {
      j = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_discuss_uin_remain.get();
      notifyUI(1018, true, new Object[] { paramFromServiceMsg, Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
      return;
      notifyUI(1018, false, paramToServiceMsg);
      return;
      notifyUI(1018, false, paramToServiceMsg);
      return;
      notifyUI(1018, false, paramToServiceMsg);
      return;
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    Object localObject1 = (RespGetDiscussInteRemark)paramObject.b;
    long l = ((RespGetDiscussInteRemark)localObject1).DiscussUin;
    paramToServiceMsg = (DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<<---handleGetDiscussInteRemarkResp header.Result");
      ((StringBuilder)localObject2).append(paramToServiceMsg.Result);
      QLog.d("DiscussionHandler", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramToServiceMsg.Result != 0)
    {
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder();
        paramFromServiceMsg.append("header failed code: ");
        paramFromServiceMsg.append(paramToServiceMsg.Result);
        QLog.w("DiscussionHandler", 2, paramFromServiceMsg.toString());
      }
      notifyUI(1010, false, Long.valueOf(l));
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject.jdField_a_of_type_Boolean))
    {
      paramToServiceMsg = ((RespGetDiscussInteRemark)localObject1).InteRemarks;
      paramFromServiceMsg = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      paramObject = paramFromServiceMsg.a(String.valueOf(l));
      if ((paramToServiceMsg != null) && (paramObject != null))
      {
        paramToServiceMsg.keySet();
        localObject1 = paramToServiceMsg.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject3 = (Long)((Iterator)localObject1).next();
          localObject2 = (DiscussionMemberInfo)paramObject.get(String.valueOf(localObject3));
          if (localObject2 != null)
          {
            localObject3 = (InteRemarkInfo)paramToServiceMsg.get(localObject3);
            ((DiscussionMemberInfo)localObject2).inteRemark = ((InteRemarkInfo)localObject3).StrValue;
            ((DiscussionMemberInfo)localObject2).inteRemarkSource = ((InteRemarkInfo)localObject3).Source;
            paramFromServiceMsg.a((DiscussionMemberInfo)localObject2);
          }
        }
        notifyUI(1010, true, Long.valueOf(l));
      }
      return;
    }
    notifyUI(1010, false, Long.valueOf(l));
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    e(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    f(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    g(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      send(paramToServiceMsg);
      return;
    }
    h(paramToServiceMsg, paramFromServiceMsg);
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getString("signature") != null) {
      return;
    }
    paramFromServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("discussUin");
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("handleGetDiscussInfoErrorV2 disUin: ");
      if (paramFromServiceMsg == null) {
        paramToServiceMsg = "null";
      } else {
        paramToServiceMsg = paramFromServiceMsg.toString();
      }
      ((StringBuilder)localObject).append(paramToServiceMsg);
      QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
    {
      paramToServiceMsg = new ArrayList(paramFromServiceMsg.size() * 2);
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext())
      {
        localObject = (Long)paramFromServiceMsg.next();
        this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(String.valueOf(localObject));
        paramToServiceMsg.add(localObject);
        paramToServiceMsg.add(Boolean.valueOf(false));
      }
      notifyUI(1001, false, paramToServiceMsg);
    }
    if (a()) {
      c();
    }
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    int i = paramToServiceMsg.extraData.getInt("retryTime", 0);
    if (i < 1)
    {
      paramToServiceMsg.extraData.putInt("retryTime", i + 1);
      sendPbReq(paramToServiceMsg);
      return;
    }
    x(paramToServiceMsg, paramFromServiceMsg);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject = null;
    int k;
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return null;
      }
      float f2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getResources().getDisplayMetrics().density;
      double d = 50.0F * f2;
      Double.isNaN(d);
      k = (int)(d + 0.5D);
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 4;
      float f1;
      if (j <= 1) {
        f1 = 117.0F;
      }
      int m;
      for (;;)
      {
        m = (int)(f2 * f1);
        break;
        if (paramString.length <= 4) {
          f1 = 53.0F;
        } else {
          f1 = 34.0F;
        }
      }
      if (paramString.length <= 4) {
        i = paramString.length;
      }
      localObject = new Bitmap[i];
      j = 0;
      while (j < i)
      {
        localObject[j] = ((Bitmap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getScaledFaceBitmap(paramString[j], 1, m, m).second);
        j += 1;
      }
    }
    try
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.a(k, (Bitmap[])localObject);
      return localObject;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) || (paramBoolean))
    {
      try
      {
        return ImageUtil.e();
      }
      catch (Throwable paramString)
      {
        Bitmap localBitmap;
        if (!QLog.isColorLevel()) {
          break label97;
        }
        QLog.e("DiscussionHandler", 2, "getDiscussionFaceIcon error", paramString);
      }
      if (GroupIconHelper.a(paramString)) {
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(1001, paramString, (byte)3, false, (byte)1, 0);
      } else {
        localBitmap = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getFaceBitmap(101, paramString, (byte)3, false, (byte)1, 0);
      }
      if (localBitmap == null)
      {
        a(paramString, true);
        if (paramBoolean) {
          return ImageUtil.e();
        }
      }
      else
      {
        a(paramString, false);
        return localBitmap;
      }
      label97:
      return null;
    }
    return null;
  }
  
  public Drawable a(String paramString, boolean paramBoolean)
  {
    paramString = a(paramString, paramBoolean);
    if (paramString != null) {
      return new BitmapDrawable(paramString);
    }
    return null;
  }
  
  public GroupIconHelper a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper;
  }
  
  public void a()
  {
    notifyUI(1008, true, null);
  }
  
  public void a(long paramLong)
  {
    if (!a(paramLong))
    {
      localObject = new ArrayList(2);
      ((ArrayList)localObject).add(Long.valueOf(paramLong));
      ((ArrayList)localObject).add(Boolean.valueOf(false));
      notifyUI(1001, false, localObject);
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDiscussInfo ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    DiscussionHandler.ReqDiscussInfo localReqDiscussInfo = new DiscussionHandler.ReqDiscussInfo();
    localReqDiscussInfo.jdField_a_of_type_JavaLangString = String.valueOf(paramLong);
    localReqDiscussInfo.b = ((DiscussionManager)localObject).a(localReqDiscussInfo.jdField_a_of_type_JavaLangString);
    a(localReqDiscussInfo);
  }
  
  public void a(long paramLong, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqSetDiscussFlag");
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    localToServiceMsg.extraData.putByte("flag", paramByte1);
    localToServiceMsg.extraData.putByte("infoflag", paramByte2);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("--->>set discuss flag uin: ");
      localStringBuilder.append(paramLong);
      localStringBuilder.append(" req: ");
      localStringBuilder.append(localToServiceMsg);
      QLog.d("DiscussionHandler", 2, localStringBuilder.toString());
    }
    send(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt)
  {
    long l1 = QQAudioHelper.b();
    Object localObject1 = String.valueOf(paramLong);
    Object localObject2 = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a((String)localObject1);
    if (localObject2 == null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("[DiscussionInfo为空], ");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    for (;;)
    {
      break;
      if ((((DiscussionInfo)localObject2).mOrigin & 0x2) != 2L)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("");
        ((StringBuilder)localObject1).append("mOrigin[");
        ((StringBuilder)localObject1).append(((DiscussionInfo)localObject2).mOrigin);
        ((StringBuilder)localObject1).append("], ");
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        int i = ((DiscussionInfo)localObject2).getHrExtra();
        if ((paramInt == 1) && (i != 0))
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append("hrExtra[");
          ((StringBuilder)localObject1).append(i);
          ((StringBuilder)localObject1).append("], ");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
        else
        {
          cmd0x44c.ReqBody localReqBody = new cmd0x44c.ReqBody();
          localReqBody.uint32_subcmd.set(1);
          cmd0x44c.ModifyConfInfoReq localModifyConfInfoReq = new cmd0x44c.ModifyConfInfoReq();
          localModifyConfInfoReq.uint64_conf_uin.set(paramLong);
          long l2 = ((DiscussionInfo)localObject2).mOriginExtra;
          long l3 = paramInt & 0x3;
          localModifyConfInfoReq.uint32_conf_meeting_option.set((int)(l3 | l2 & 0xFFFFFFFC));
          localReqBody.msg_modify_conf_info_req.set(localModifyConfInfoReq);
          localObject2 = makeOIDBPkg("OidbSvc.0x44c", 1100, 2, localReqBody.toByteArray());
          ((ToServiceMsg)localObject2).extraData.putLong("debugSeq", l1);
          ((ToServiceMsg)localObject2).extraData.putString("uin", (String)localObject1);
          ((ToServiceMsg)localObject2).extraData.putInt("value", paramInt);
          sendPbReq((ToServiceMsg)localObject2);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("");
          ((StringBuilder)localObject1).append("reqAppSeq[");
          ((StringBuilder)localObject1).append(((ToServiceMsg)localObject2).getAppSeq());
          ((StringBuilder)localObject1).append("], reqSsoSeq[");
          ((StringBuilder)localObject1).append(((ToServiceMsg)localObject2).getRequestSsoSeq());
          ((StringBuilder)localObject1).append("], ");
          localObject1 = ((StringBuilder)localObject1).toString();
        }
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("setHrConfExtraInfo, discUin[");
    ((StringBuilder)localObject2).append(paramLong);
    ((StringBuilder)localObject2).append("], discHrExtraValue[");
    ((StringBuilder)localObject2).append(paramInt);
    ((StringBuilder)localObject2).append("], debugSeq[");
    ((StringBuilder)localObject2).append(l1);
    ((StringBuilder)localObject2).append("], ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.w("DiscussionHandler", 1, ((StringBuilder)localObject2).toString());
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong1);
    localStringBuilder.append("");
    if (localDiscussionManager.a(localStringBuilder.toString()) == null)
    {
      a(paramLong1);
      return;
    }
    if (localDiscussionManager.a(String.valueOf(paramLong1), String.valueOf(paramLong2)) == null) {
      a(paramLong1);
    }
  }
  
  public void a(long paramLong, String paramString)
  {
    if (paramString != null)
    {
      ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqChangeDiscussName");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      localToServiceMsg.extraData.putString("newName", paramString);
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("--->>change discuss name uin: ");
        paramString.append(paramLong);
        paramString.append(" req: ");
        paramString.append(localToServiceMsg);
        QLog.d("DiscussionHandler", 2, paramString.toString());
      }
      send(localToServiceMsg);
    }
  }
  
  public void a(long paramLong, String paramString, List<String> paramList, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("notifyMemberChange disUin=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(" cmdUin=");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(" opType=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" uinsize=");
      ((StringBuilder)localObject).append(paramList.size());
      QLog.d("DiscussionHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(AVNotifyCenter.class);
    if (localObject != null)
    {
      Message localMessage = ((MqqHandler)localObject).obtainMessage(paramInt);
      localMessage.obj = new Object[] { Long.valueOf(paramLong), paramString, (String[])paramList.toArray(new String[paramList.size()]) };
      ((MqqHandler)localObject).sendMessage(localMessage);
    }
  }
  
  public void a(long paramLong, ArrayList<AddDiscussMemberInfo> paramArrayList)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqAddDiscussMember");
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    int j = paramArrayList.size();
    long[] arrayOfLong1 = new long[j];
    int[] arrayOfInt = new int[j];
    long[] arrayOfLong2 = new long[j];
    String[] arrayOfString = new String[j];
    int i = 0;
    while (i < j)
    {
      arrayOfLong1[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).Uin;
      arrayOfInt[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).Type;
      arrayOfLong2[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).RefUin;
      arrayOfString[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).RefStr;
      i += 1;
    }
    localToServiceMsg.extraData.putLongArray("uin", arrayOfLong1);
    localToServiceMsg.extraData.putIntArray("type", arrayOfInt);
    localToServiceMsg.extraData.putLongArray("refUin", arrayOfLong2);
    localToServiceMsg.extraData.putStringArray("refStr", arrayOfString);
    if (QLog.isColorLevel())
    {
      paramArrayList = new StringBuilder();
      paramArrayList.append("--->>add discuss member uin: ");
      paramArrayList.append(paramLong);
      paramArrayList.append(" req: ");
      paramArrayList.append(localToServiceMsg);
      QLog.d("DiscussionHandler", 2, paramArrayList.toString());
    }
    send(localToServiceMsg);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_a_of_type_Long < 120000L)) {
      return;
    }
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = createToServiceMsg("QRCodeSvc.discuss_geturl");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    FlyTicket.DiscussGetUrlRequest localDiscussGetUrlRequest = new FlyTicket.DiscussGetUrlRequest();
    localDiscussGetUrlRequest.conf_uin.set((int)paramLong);
    localDiscussGetUrlRequest.is_need_long_link.set(paramBoolean);
    localToServiceMsg.putWupBuffer(localDiscussGetUrlRequest.toByteArray());
    send(localToServiceMsg);
  }
  
  public void a(@NonNull DiscussionHandler.ReqDiscussInfo paramReqDiscussInfo)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("getDiscussInfo2 ");
      ((StringBuilder)???).append(paramReqDiscussInfo.jdField_a_of_type_JavaLangString);
      QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_b_of_type_JavaUtilLinkedHashMap)
    {
      if ((!this.jdField_b_of_type_JavaUtilLinkedHashMap.containsKey(paramReqDiscussInfo.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramReqDiscussInfo.jdField_a_of_type_JavaLangString)))
      {
        this.jdField_b_of_type_JavaUtilLinkedHashMap.put(paramReqDiscussInfo.jdField_a_of_type_JavaLangString, paramReqDiscussInfo);
      }
      else if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDiscussionInfo filtered ");
        localStringBuilder.append(paramReqDiscussInfo.jdField_a_of_type_JavaLangString);
        QLog.d("Q.contacttab.dscs", 2, localStringBuilder.toString());
      }
      c();
      return;
    }
  }
  
  public void a(DiscussionInfo paramDiscussionInfo, boolean paramBoolean)
  {
    RecentUserProxy localRecentUserProxy = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a();
    paramDiscussionInfo = localRecentUserProxy.a(paramDiscussionInfo.uin, 3000);
    if (paramDiscussionInfo != null)
    {
      if (paramBoolean) {
        paramDiscussionInfo.showUpTime = (System.currentTimeMillis() / 1000L);
      } else {
        paramDiscussionInfo.showUpTime = 0L;
      }
      localRecentUserProxy.b(paramDiscussionInfo);
      paramDiscussionInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (paramDiscussionInfo != null) {
        paramDiscussionInfo.sendMessage(paramDiscussionInfo.obtainMessage(1009));
      }
    }
  }
  
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleKickoutMemberResp");
    }
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    } else {
      bool = false;
    }
    paramFromServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("dwDelMemberUin"));
    Long localLong = Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin"));
    if (bool) {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        i = paramToServiceMsg.uint32_result.get();
        if (i == 0) {
          bool = true;
        } else {
          bool = false;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.w("kickOutMemberFromDiscussion", 2, paramToServiceMsg.getMessage());
        }
        bool = false;
      }
    }
    paramObject = new long[2];
    paramObject[0] = localLong.longValue();
    paramObject[1] = paramFromServiceMsg.longValue();
    paramToServiceMsg = ContactUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, String.valueOf(localLong), String.valueOf(paramFromServiceMsg));
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(HardCodeUtil.a(2131703518));
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getString(2131691798, new Object[] { paramToServiceMsg }));
    paramToServiceMsg = ((StringBuilder)localObject).toString();
    try
    {
      long l1 = Long.parseLong(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      long l2 = localLong.longValue();
      long l3 = localLong.longValue();
      try
      {
        a(l1, l2, l3, paramToServiceMsg);
      }
      catch (NumberFormatException paramToServiceMsg) {}
      if (!QLog.isColorLevel()) {
        break label292;
      }
    }
    catch (NumberFormatException paramToServiceMsg) {}
    QLog.d("DiscussionHandler", 2, "handleKickoutMemberResp exception ", paramToServiceMsg);
    label292:
    paramToServiceMsg = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(String.valueOf(localLong));
    if (paramToServiceMsg != null)
    {
      localObject = paramToServiceMsg.faceUinSet;
      if ((localObject != null) && (!((String)localObject).trim().equals("")))
      {
        localObject = ((String)localObject).split(";");
        if (localObject != null)
        {
          int j = localObject.length;
          i = 0;
          while (i < j)
          {
            if (localObject[i].equals(String.valueOf(paramFromServiceMsg)))
            {
              i = 1;
              break label406;
            }
            i += 1;
          }
        }
      }
    }
    int i = 0;
    label406:
    localObject = String.valueOf(localLong);
    HashSet localHashSet = new HashSet();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramFromServiceMsg);
    localStringBuilder.append("");
    localHashSet.add(localStringBuilder.toString());
    a((String)localObject, localHashSet);
    localObject = new ArrayList();
    ((List)localObject).add(String.valueOf(paramFromServiceMsg));
    a(localLong.longValue(), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), (List)localObject, 2);
    if (i != 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.c(paramToServiceMsg.uin);
    }
    notifyUI(1015, bool, paramObject);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.d(paramString);
    ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).c(paramString);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().a(paramString, 3000);
    notifyUI(1004, true, paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    if ((this.jdField_b_of_type_Long > 0L) && (System.currentTimeMillis() - this.jdField_b_of_type_Long < 120000L)) {
      return;
    }
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqJoinDiscuss");
    localToServiceMsg.extraData.putString("signature", paramString);
    localToServiceMsg.extraData.putInt("addDisSource", paramInt);
    send(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    DiscussionInfo localDiscussionInfo = localDiscussionManager.a(paramString1);
    if (localDiscussionInfo != null)
    {
      localDiscussionInfo.discussionName = paramString2;
      localDiscussionInfo.DiscussionFlag &= 0xFFFFFFBF;
      localDiscussionManager.a(localDiscussionInfo);
      notifyUI(1005, true, paramString1);
    }
  }
  
  public void a(String paramString, ArrayList<AddDiscussMemberInfo> paramArrayList, int paramInt)
  {
    a(paramString, paramArrayList, paramInt, 0L);
  }
  
  public void a(String paramString, ArrayList<AddDiscussMemberInfo> paramArrayList, int paramInt, long paramLong)
  {
    if ((paramString != null) && (paramArrayList != null))
    {
      Object localObject1 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      Object localObject2 = ((DiscussionManager)localObject1).a(paramArrayList);
      int i = 0;
      int j = 0;
      if (localObject2 != null)
      {
        notifyUI(1002, true, new Object[] { Long.valueOf(Long.parseLong(((DiscussionInfo)localObject2).uin)), ((DiscussionInfo)localObject2).discussionName, Integer.valueOf(0) });
        localObject4 = ((DiscussionManager)localObject1).a(((DiscussionInfo)localObject2).uin);
        localObject3 = new ArrayList();
        paramString = null;
        paramInt = 0;
        while (paramInt < ((ArrayList)localObject4).size())
        {
          localObject5 = (DiscussionMemberInfo)((ArrayList)localObject4).get(paramInt);
          localObject1 = paramString;
          if (localObject5 != null)
          {
            if (((DiscussionMemberInfo)localObject5).memberUin != null)
            {
              if (((DiscussionMemberInfo)localObject5).memberUin.equals(((DiscussionInfo)localObject2).inheritOwnerUin)) {}
              while (((DiscussionMemberInfo)localObject5).memberUin.equals(((DiscussionInfo)localObject2).ownerUin))
              {
                i = 1;
                break;
              }
              i = 0;
              if (i != 0)
              {
                localObject1 = new DiscussionMemberInfo();
                ((DiscussionMemberInfo)localObject1).memberUin = ((DiscussionMemberInfo)localObject5).memberUin;
                ((DiscussionMemberInfo)localObject1).memberName = ContactUtils.a((DiscussionMemberInfo)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
                break label313;
              }
              if (((DiscussionMemberInfo)localObject5).memberUin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
              {
                localObject1 = paramString;
                break label313;
              }
            }
            localObject1 = new DiscussionMemberInfo();
            ((DiscussionMemberInfo)localObject1).memberUin = ((DiscussionMemberInfo)localObject5).memberUin;
            ((DiscussionMemberInfo)localObject1).memberName = ContactUtils.a((DiscussionMemberInfo)localObject5, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
            ((DiscussionMemberInfo)localObject1).discussionUin = ChnToSpell.a(((DiscussionMemberInfo)localObject1).memberName, 1);
            ((List)localObject3).add(localObject1);
            localObject1 = paramString;
          }
          label313:
          paramInt += 1;
          paramString = (String)localObject1;
        }
        Collections.sort((List)localObject3, new ContactSorter.DiscussionMemberComparator());
        if (paramString != null) {
          ((List)localObject3).add(0, paramString);
        }
        paramString = new StringBuffer();
        paramString.append("你与");
        paramInt = j;
        while ((paramInt < ((List)localObject3).size()) && (paramInt < 3))
        {
          localObject1 = (DiscussionMemberInfo)((List)localObject3).get(paramInt);
          if (!((DiscussionMemberInfo)localObject1).memberUin.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
          {
            paramString.append(((DiscussionMemberInfo)localObject1).memberName);
            paramString.append("、");
          }
          paramInt += 1;
        }
        paramString.deleteCharAt(paramString.length() - 1);
        if (((List)localObject3).size() > 3) {
          paramString.append("等");
        }
        paramString.append(paramArrayList.size());
        paramString.append("个成员已有该多人聊天。");
        paramArrayList = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        paramString = new UniteGrayTipParam(((DiscussionInfo)localObject2).uin, paramArrayList, paramString.toString(), 3000, -5040, 65560, MessageCache.a());
        paramArrayList = new MessageForUniteGrayTip();
        paramArrayList.initGrayTipMsg(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramString);
        UniteGrayTipMsgUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramArrayList);
        return;
      }
      localObject1 = createToServiceMsg("QQServiceDiscussSvc.ReqCreateDiscuss");
      j = paramArrayList.size();
      localObject2 = new long[j];
      Object localObject3 = new int[j];
      Object localObject4 = new long[j];
      Object localObject5 = new String[j];
      while (i < j)
      {
        localObject2[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).Uin;
        localObject3[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).Type;
        localObject4[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).RefUin;
        localObject5[i] = ((AddDiscussMemberInfo)paramArrayList.get(i)).RefStr;
        i += 1;
      }
      ((ToServiceMsg)localObject1).extraData.putLongArray("uin", (long[])localObject2);
      ((ToServiceMsg)localObject1).extraData.putIntArray("type", (int[])localObject3);
      ((ToServiceMsg)localObject1).extraData.putLongArray("refUin", (long[])localObject4);
      ((ToServiceMsg)localObject1).extraData.putStringArray("refStr", (String[])localObject5);
      ((ToServiceMsg)localObject1).extraData.putString("name", paramString);
      ((ToServiceMsg)localObject1).extraData.putInt("from", paramInt);
      ((ToServiceMsg)localObject1).extraData.putLong("uiControlFlag", paramLong);
      if (QLog.isColorLevel())
      {
        paramArrayList = new StringBuilder();
        paramArrayList.append("--->>create discuss name: ");
        paramArrayList.append(paramString);
        paramArrayList.append(" req: ");
        paramArrayList.append(localObject1);
        QLog.d("DiscussionHandler", 2, paramArrayList.toString());
      }
      send((ToServiceMsg)localObject1);
    }
  }
  
  public void a(String paramString, HashSet<String> paramHashSet)
  {
    if ((paramString != null) && (paramHashSet != null))
    {
      if (paramHashSet.size() == 0) {
        return;
      }
      DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      DiscussionInfo localDiscussionInfo = localDiscussionManager.a(paramString);
      if (localDiscussionInfo != null) {
        localDiscussionInfo.DiscussionFlag |= 0x20000000;
      }
      localDiscussionManager.a(paramString, paramHashSet);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.c())
    {
      if (paramBoolean)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.a(paramString);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.b(paramString);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramString = new Pair(Boolean.valueOf(paramBoolean), paramString);
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void a(@NonNull Collection<DiscussionHandler.ReqDiscussInfo> paramCollection)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("getDiscussInfo");
      ((StringBuilder)???).append(paramCollection.size());
      QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)???).toString());
    }
    synchronized (this.jdField_b_of_type_JavaUtilLinkedHashMap)
    {
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        DiscussionHandler.ReqDiscussInfo localReqDiscussInfo = (DiscussionHandler.ReqDiscussInfo)paramCollection.next();
        if ((!this.jdField_b_of_type_JavaUtilLinkedHashMap.containsKey(localReqDiscussInfo.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localReqDiscussInfo.jdField_a_of_type_JavaLangString)) && (localReqDiscussInfo.jdField_a_of_type_Int <= 1))
        {
          this.jdField_b_of_type_JavaUtilLinkedHashMap.put(localReqDiscussInfo.jdField_a_of_type_JavaLangString, localReqDiscussInfo);
        }
        else if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("getDiscussionInfo2 filtered ");
          localStringBuilder.append(localReqDiscussInfo.jdField_a_of_type_JavaLangString);
          QLog.d("Q.contacttab.dscs", 2, localStringBuilder.toString());
        }
      }
      c();
      return;
    }
    for (;;)
    {
      throw paramCollection;
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    notifyUI(1007, paramBoolean1, Pair.create(Boolean.valueOf(paramBoolean2), paramString));
  }
  
  public void a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    NewIntent localNewIntent = new NewIntent(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), DiscussionServlet.class);
    localNewIntent.putExtra("key_cmd", 0);
    localNewIntent.putExtra("field_id", paramArrayOfString1);
    localNewIntent.putExtra("uin_list", paramArrayOfString2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.startServlet(localNewIntent);
  }
  
  public boolean a(long paramLong)
  {
    return paramLong > 1000000L;
  }
  
  public boolean a(DiscussionInfo paramDiscussionInfo)
  {
    paramDiscussionInfo = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getProxyManager().a().a(paramDiscussionInfo.uin, 3000);
    boolean bool = false;
    if (paramDiscussionInfo == null) {
      return false;
    }
    if (paramDiscussionInfo.showUpTime != 0L) {
      bool = true;
    }
    return bool;
  }
  
  public boolean a(ArrayList<DiscussInfo> paramArrayList)
  {
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addOrUpdateDiscussion ");
      if (paramArrayList != null) {
        i = paramArrayList.size();
      } else {
        i = -1;
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject1).toString());
    }
    long l = System.currentTimeMillis();
    if (paramArrayList == null) {
      return true;
    }
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DiscusstionIconVersion");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject2 = ((StringBuilder)localObject2).toString();
      i = ((SharedPreferences)localObject1).getInt((String)localObject2, -1);
      DiscussInfo localDiscussInfo;
      Object localObject3;
      if (i != 1)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, 1);
        ((SharedPreferences.Editor)localObject1).commit();
        if (i != -1) {
          try
          {
            localObject1 = new String[2];
            localObject1[0] = AppConstants.PATH_HEAD_HD;
            localObject1[1] = "/data/data/com.tencent.mobileqq/files/head/_hd/";
            int k = localObject1.length;
            i = 0;
            while (i < k)
            {
              localObject2 = new File(localObject1[i]);
              if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
              {
                localObject2 = ((File)localObject2).listFiles();
                int m = localObject2.length;
                int j = 0;
                while (j < m)
                {
                  localDiscussInfo = localObject2[j];
                  if (localDiscussInfo.getName().startsWith("discussion_"))
                  {
                    localDiscussInfo.delete();
                    if (QLog.isColorLevel())
                    {
                      localObject3 = new StringBuilder();
                      ((StringBuilder)localObject3).append("del discussion icon. name=");
                      ((StringBuilder)localObject3).append(localDiscussInfo.getName());
                      ((StringBuilder)localObject3).append(",");
                      ((StringBuilder)localObject3).append(localDiscussInfo.lastModified());
                      QLog.d("DiscussionHandler", 2, ((StringBuilder)localObject3).toString());
                    }
                  }
                  j += 1;
                }
              }
              i += 1;
            }
            localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      DiscussionManager localDiscussionManager;
      localObject2 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localDiscussInfo = (DiscussInfo)paramArrayList.next();
        localObject3 = localDiscussionManager.a(String.valueOf(localDiscussInfo.DiscussUin));
        if (localObject3 == null)
        {
          localObject3 = new DiscussionInfo();
          ((DiscussionInfo)localObject3).uin = String.valueOf(localDiscussInfo.DiscussUin);
          ((DiscussionInfo)localObject3).infoSeq = -1L;
          ((DiscussionInfo)localObject3).timeSec = l;
          a(Long.parseLong(((DiscussionInfo)localObject3).uin));
          ((ArrayList)localObject2).add(localObject3);
        }
        else
        {
          if (((DiscussionInfo)localObject3).infoSeq != localDiscussInfo.InfoSeq) {
            a(Long.parseLong(((DiscussionInfo)localObject3).uin));
          } else {
            ((ArrayList)localObject2).add(localObject3);
          }
          ((DiscussionInfo)localObject3).timeSec = l;
        }
      }
      boolean bool = localDiscussionManager.a((ArrayList)localObject2, l, true);
      return bool;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    return false;
  }
  
  public boolean a(@NonNull ArrayList<DiscussionInfo> paramArrayList, @NonNull ArrayList<String> paramArrayList1)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("addOrUpdateDiscussionWithCollectData");
      ((StringBuilder)localObject1).append(paramArrayList.size());
      ((StringBuilder)localObject1).append(", ");
      ((StringBuilder)localObject1).append(paramArrayList1.size());
      QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject1).toString());
    }
    long l = System.currentTimeMillis();
    try
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("DiscusstionIconVersion");
      ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject2 = ((StringBuilder)localObject2).toString();
      int i = ((SharedPreferences)localObject1).getInt((String)localObject2, -1);
      Object localObject3;
      Object localObject4;
      if (i != 1)
      {
        localObject1 = ((SharedPreferences)localObject1).edit();
        ((SharedPreferences.Editor)localObject1).putInt((String)localObject2, 1);
        ((SharedPreferences.Editor)localObject1).commit();
        if (i != -1) {
          try
          {
            localObject1 = new String[2];
            localObject1[0] = AppConstants.PATH_HEAD_HD;
            localObject1[1] = "/data/data/com.tencent.mobileqq/files/head/_hd/";
            int m = localObject1.length;
            i = 0;
            while (i < m)
            {
              localObject2 = new File(localObject1[i]);
              if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
              {
                localObject2 = ((File)localObject2).listFiles();
                int j = localObject2.length;
                int k = 0;
                while (k < j)
                {
                  localObject3 = localObject2[k];
                  if (((File)localObject3).getName().startsWith("discussion_"))
                  {
                    ((File)localObject3).delete();
                    if (QLog.isColorLevel())
                    {
                      localObject4 = new StringBuilder();
                      ((StringBuilder)localObject4).append("del discussion icon. name=");
                      ((StringBuilder)localObject4).append(((File)localObject3).getName());
                      ((StringBuilder)localObject4).append(",");
                      ((StringBuilder)localObject4).append(((File)localObject3).lastModified());
                      QLog.d("DiscussionHandler", 2, ((StringBuilder)localObject4).toString());
                    }
                  }
                  k += 1;
                }
              }
              i += 1;
            }
            localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      DiscussionManager localDiscussionManager;
      localObject2 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        localObject3 = (DiscussionInfo)paramArrayList.next();
        localObject4 = localDiscussionManager.a(((DiscussionInfo)localObject3).uin);
        if (localObject4 == null)
        {
          localObject4 = new DiscussionInfo();
          ((DiscussionInfo)localObject4).uin = ((DiscussionInfo)localObject3).uin;
          ((DiscussionInfo)localObject4).infoSeq = -1L;
          ((DiscussionInfo)localObject4).timeSec = l;
          if (paramArrayList1.contains(((DiscussionInfo)localObject3).uin)) {
            ((DiscussionInfo)localObject4).hasCollect = true;
          } else {
            ((DiscussionInfo)localObject4).hasCollect = false;
          }
          localObject3 = new DiscussionHandler.ReqDiscussInfo();
          ((DiscussionHandler.ReqDiscussInfo)localObject3).jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject4).uin;
          ((DiscussionHandler.ReqDiscussInfo)localObject3).b = ((DiscussionInfo)localObject4).mUnreliableMemberCount;
          a((DiscussionHandler.ReqDiscussInfo)localObject3);
        }
        else
        {
          if (paramArrayList1.contains(((DiscussionInfo)localObject3).uin)) {
            ((DiscussionInfo)localObject4).hasCollect = true;
          } else {
            ((DiscussionInfo)localObject4).hasCollect = false;
          }
          if (((DiscussionInfo)localObject4).infoSeq != ((DiscussionInfo)localObject3).infoSeq)
          {
            localObject3 = new DiscussionHandler.ReqDiscussInfo();
            ((DiscussionHandler.ReqDiscussInfo)localObject3).jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject4).uin;
            ((DiscussionHandler.ReqDiscussInfo)localObject3).b = ((DiscussionInfo)localObject4).mUnreliableMemberCount;
            a((DiscussionHandler.ReqDiscussInfo)localObject3);
          }
          else
          {
            ((ArrayList)localObject2).add(localObject4);
          }
          ((DiscussionInfo)localObject4).timeSec = l;
        }
      }
      boolean bool = localDiscussionManager.a((ArrayList)localObject2, l, false);
      return bool;
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.mAutomator.c())
    {
      Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
      if ((localObject != null) && (!((ArrayList)localObject).isEmpty()))
      {
        int i = 0;
        while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
        {
          localObject = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          if ((localObject != null) && (((Pair)localObject).first != null) && (((Pair)localObject).second != null)) {
            if (((Boolean)((Pair)localObject).first).booleanValue()) {
              a((String)((Pair)localObject).second, false);
            } else {
              this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.b((String)((Pair)localObject).second);
            }
          }
          i += 1;
        }
        this.jdField_a_of_type_JavaUtilArrayList = null;
      }
    }
  }
  
  public void b(long paramLong)
  {
    DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramLong);
    localStringBuilder.append("");
    if (localDiscussionManager.a(localStringBuilder.toString()) == null) {
      a(paramLong);
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2149);
    localOIDBSSOPkg.uint32_service_type.set(3);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(Utils.a(paramLong1)).putShort((short)1).putInt(Utils.a(paramLong2));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x865_3");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong1);
    ((ToServiceMsg)localObject).extraData.putShort("wUinNum", (short)1);
    ((ToServiceMsg)localObject).extraData.putLong("dwDelMemberUin", paramLong2);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void b(long paramLong, ArrayList<AddDiscussMemberInfo> paramArrayList)
  {
    if (a(paramLong))
    {
      DiscussionInfo localDiscussionInfo = ((DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER)).a(String.valueOf(paramLong));
      if ((localDiscussionInfo != null) && (localDiscussionInfo.isDiscussHrMeeting()))
      {
        c(paramLong, paramArrayList);
        return;
      }
      a(paramLong, paramArrayList);
      return;
    }
    notifyUI(1003, false, new Object[] { String.valueOf(paramLong), Integer.valueOf(-1) });
  }
  
  protected void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleCollectDisucssionResp");
    }
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin"));
    boolean bool1 = bool2;
    if (bool2) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label201;
        }
        bool2 = true;
        bool1 = bool2;
        if (bool2)
        {
          paramFromServiceMsg = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          paramObject = paramFromServiceMsg.a(String.valueOf(paramToServiceMsg));
          bool1 = bool2;
          if (paramObject != null)
          {
            long l = System.currentTimeMillis();
            paramObject.hasCollect = true;
            paramObject.timeSec = l;
            paramFromServiceMsg.a(paramObject);
            paramFromServiceMsg.b(paramObject);
            bool1 = bool2;
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.w("handleCollectDisucssionResp", 2, paramFromServiceMsg.getMessage());
        }
        bool1 = false;
      }
      notifyUI(1016, bool1, paramToServiceMsg);
      return;
      label201:
      bool2 = false;
    }
  }
  
  public void b(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("QRCodeSvc.discuss_decode");
    localToServiceMsg.extraData.putBoolean("req_pb_protocol_flag", true);
    localToServiceMsg.extraData.putString("signature", paramString);
    FlyTicket.DiscussSigDecodeRequest localDiscussSigDecodeRequest = new FlyTicket.DiscussSigDecodeRequest();
    localDiscussSigDecodeRequest.sig.set(paramString);
    localToServiceMsg.putWupBuffer(localDiscussSigDecodeRequest.toByteArray());
    send(localToServiceMsg);
  }
  
  public void b(String paramString1, String paramString2)
  {
    Object localObject = new cmd0x921.ReqBody();
    ((cmd0x921.ReqBody)localObject).uint32_subcmd.set(1);
    try
    {
      cmd0x921.GetAtAllRemain localGetAtAllRemain = new cmd0x921.GetAtAllRemain();
      localGetAtAllRemain.uint64_uin.set(Long.parseLong(paramString1));
      localGetAtAllRemain.uint64_discuss_uin.set(Long.parseLong(paramString2));
      ((cmd0x921.ReqBody)localObject).msg_get_at_all_remain.set(localGetAtAllRemain);
      paramString1 = makeOIDBPkg("OidbSvc.0x921_0", 2337, 0, ((cmd0x921.ReqBody)localObject).toByteArray());
      paramString1.extraData.putString("discUid", paramString2);
      sendPbReq(paramString1);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      label91:
      break label91;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getAnonymousChatNick error, NumberFormatException, uin : ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", discUin : ");
      ((StringBuilder)localObject).append(paramString2);
      QLog.d("DiscussionHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void c()
  {
    ArrayList localArrayList = new ArrayList(50);
    synchronized (this.jdField_b_of_type_JavaUtilLinkedHashMap)
    {
      if (QLog.isColorLevel())
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("startGetDiscussionInfoWorkV2, discussionUinListofGetinfo[");
        ((StringBuilder)localObject3).append(this.jdField_b_of_type_JavaUtilLinkedHashMap.size());
        ((StringBuilder)localObject3).append("], mGettingDiscussUins[");
        ((StringBuilder)localObject3).append(this.jdField_a_of_type_JavaUtilLinkedHashMap.size());
        ((StringBuilder)localObject3).append("]");
        QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject3).toString());
      }
      if (this.jdField_b_of_type_JavaUtilLinkedHashMap.size() == 0) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 100) {
        return;
      }
      Object localObject3 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      Object localObject4 = this.jdField_b_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
      int j = 0;
      int i = 0;
      int m;
      for (int k = 0; ((Iterator)localObject4).hasNext(); k = m)
      {
        DiscussionHandler.ReqDiscussInfo localReqDiscussInfo = (DiscussionHandler.ReqDiscussInfo)((Map.Entry)((Iterator)localObject4).next()).getValue();
        if ((localReqDiscussInfo.b + j > 500) || (i >= 50)) {
          break;
        }
        ((Iterator)localObject4).remove();
        DiscussionInfo localDiscussionInfo = ((DiscussionManager)localObject3).a(localReqDiscussInfo.jdField_a_of_type_JavaLangString);
        m = k;
        if (localDiscussionInfo != null)
        {
          m = k;
          if (k > (int)localDiscussionInfo.timeSec) {
            m = (int)localDiscussionInfo.timeSec;
          }
        }
        this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localReqDiscussInfo.jdField_a_of_type_JavaLangString, localReqDiscussInfo);
        localArrayList.add(Long.valueOf(Long.parseLong(localReqDiscussInfo.jdField_a_of_type_JavaLangString)));
        j += localReqDiscussInfo.b;
        i += 1;
      }
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("updateBatchDiscussInfo dis_cnt=%tu mem_cnt=%tu");
      ((StringBuilder)localObject3).append(i);
      ((StringBuilder)localObject3).append(" mem_cnt=");
      ((StringBuilder)localObject3).append(j);
      QLog.d("DiscussionVerify", 2, ((StringBuilder)localObject3).toString());
      if (QLog.isColorLevel())
      {
        ??? = new StringBuilder();
        ((StringBuilder)???).append("startGetDiscussionInfoWorkV2, disUin[");
        ((StringBuilder)???).append(localArrayList.toString());
        ((StringBuilder)???).append("]");
        QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)???).toString());
      }
      ??? = new cmd0x58b.ReqBody();
      ((cmd0x58b.ReqBody)???).uint32_subcmd.set(3);
      try
      {
        localObject3 = new cmd0x58b.GetMultiConfInfoReq();
        ((cmd0x58b.GetMultiConfInfoReq)localObject3).uint64_conf_uin.set(localArrayList);
        localObject4 = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
        ((cmd0x58b.GetMultiConfInfoReq)localObject3).uint32_interemark_timestamp.set(k);
        localObject4 = new cmd0x58b.ConfBaseInfo();
        ((cmd0x58b.ConfBaseInfo)localObject4).bytes_conf_name.set(ByteStringMicro.copyFromUtf8(""));
        ((cmd0x58b.ConfBaseInfo)localObject4).uint32_create_time.set(0);
        ((cmd0x58b.ConfBaseInfo)localObject4).uint64_owner_uin.set(0L);
        ((cmd0x58b.ConfBaseInfo)localObject4).uint32_info_seq.set(0);
        ((cmd0x58b.ConfBaseInfo)localObject4).uint32_last_info_time.set(0);
        ((cmd0x58b.ConfBaseInfo)localObject4).uint32_msg_seq.set(0);
        ((cmd0x58b.ConfBaseInfo)localObject4).uint32_last_msg_time.set(0);
        ((cmd0x58b.ConfBaseInfo)localObject4).uint32_member_num.set(0);
        ((cmd0x58b.ConfBaseInfo)localObject4).uint32_flag.set(0);
        ((cmd0x58b.ConfBaseInfo)localObject4).uint64_inherit_owner_uin.set(0L);
        ((cmd0x58b.ConfBaseInfo)localObject4).uint64_group_code.set(0L);
        ((cmd0x58b.ConfBaseInfo)localObject4).uint64_group_uin.set(0L);
        ((cmd0x58b.ConfBaseInfo)localObject4).uint32_conf_meeting_origin.set(0);
        ((cmd0x58b.ConfBaseInfo)localObject4).uint32_conf_meeting_option.set(0);
        ((cmd0x58b.GetMultiConfInfoReq)localObject3).msg_conf_base_info.set((MessageMicro)localObject4);
        localObject4 = new cmd0x58b.ConfMemberInfo();
        ((cmd0x58b.ConfMemberInfo)localObject4).uint32_join_time.set(0);
        ((cmd0x58b.ConfMemberInfo)localObject4).uint32_flag.set(0);
        ((cmd0x58b.ConfMemberInfo)localObject4).uint32_read_msg_seq.set(0);
        ((cmd0x58b.ConfMemberInfo)localObject4).bytes_member_interemark.set(ByteStringMicro.copyFromUtf8(""));
        ((cmd0x58b.ConfMemberInfo)localObject4).uint32_interemark_source.set(0);
        ((cmd0x58b.GetMultiConfInfoReq)localObject3).msg_conf_mem_info.set((MessageMicro)localObject4);
        ((cmd0x58b.ReqBody)???).msg_get_multi_conf_info.set((MessageMicro)localObject3);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("startGetDiscussionInfoWorkV2 disUin:");
          ((StringBuilder)localObject4).append(localArrayList.toString());
          ((StringBuilder)localObject4).append(" error:");
          ((StringBuilder)localObject4).append(localException.toString());
          QLog.e("DiscussionHandler", 2, ((StringBuilder)localObject4).toString());
        }
      }
      ??? = makeOIDBPkg("OidbSvc.0x58b_0", 1419, 0, ((cmd0x58b.ReqBody)???).toByteArray());
      ((ToServiceMsg)???).extraData.putSerializable("discussUin", localArrayList);
      sendPbReq((ToServiceMsg)???);
      return;
    }
    for (;;)
    {
      throw localObject1;
    }
  }
  
  public void c(long paramLong)
  {
    if (a(paramLong))
    {
      ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqQuitDiscuss");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("--->>quit discuss uin: ");
        localStringBuilder.append(paramLong);
        QLog.d("DiscussionHandler", 2, localStringBuilder.toString());
      }
      send(localToServiceMsg);
      return;
    }
    notifyUI(1004, false, String.valueOf(paramLong));
  }
  
  void c(long paramLong, ArrayList<AddDiscussMemberInfo> paramArrayList)
  {
    ThreadManager.post(new DiscussionHandler.2(this, paramLong, paramArrayList), 5, null, false);
  }
  
  protected void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleUncollectDisucssionResp");
    }
    boolean bool1 = paramFromServiceMsg.isSuccess();
    boolean bool3 = true;
    if ((bool1) && (paramObject != null)) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin"));
    boolean bool2 = bool1;
    if (bool1) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label201;
        }
        bool1 = bool3;
        if (bool1)
        {
          paramFromServiceMsg = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
          paramObject = paramFromServiceMsg.a(String.valueOf(paramToServiceMsg));
          if (paramObject != null)
          {
            long l = System.currentTimeMillis();
            paramObject.hasCollect = false;
            paramObject.timeSec = l;
            paramFromServiceMsg.a(paramObject);
            paramFromServiceMsg.b(paramObject);
          }
        }
        bool2 = bool1;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.w("handleUncollectDisucssionResp", 2, paramFromServiceMsg.getMessage());
        }
        bool2 = false;
      }
      notifyUI(1017, bool2, paramToServiceMsg);
      return;
      label201:
      bool1 = false;
    }
  }
  
  public void c(String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqGetDiscussInfo");
    localToServiceMsg.extraData.putString("signature", paramString);
    send(localToServiceMsg);
  }
  
  public void d(long paramLong)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2160);
    localOIDBSSOPkg.uint32_service_type.set(4);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(Utils.a(paramLong)).putInt(0).putShort((short)4).putInt(Utils.a(paramLong));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x870_4");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleGetFlyTicket");
    }
    this.jdField_a_of_type_Long = 0L;
    long l2 = -1L;
    FlyTicket.DiscussGetUrlResponse localDiscussGetUrlResponse = new FlyTicket.DiscussGetUrlResponse();
    long l1 = l2;
    paramObject = localDiscussGetUrlResponse;
    if (paramFromServiceMsg != null)
    {
      l1 = l2;
      paramObject = localDiscussGetUrlResponse;
      if (paramFromServiceMsg.isSuccess())
      {
        try
        {
          paramFromServiceMsg = (FlyTicket.DiscussGetUrlResponse)localDiscussGetUrlResponse.mergeFrom(paramFromServiceMsg.getWupBuffer());
        }
        catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
          paramFromServiceMsg = null;
        }
        l1 = l2;
        paramObject = paramFromServiceMsg;
        if (paramFromServiceMsg != null)
        {
          l1 = l2;
          paramObject = paramFromServiceMsg;
          if (paramFromServiceMsg.ret_info.get() != null)
          {
            l1 = ((FlyTicket.RetInfo)paramFromServiceMsg.ret_info.get()).ret_code.get();
            paramObject = paramFromServiceMsg;
          }
        }
      }
    }
    boolean bool = true;
    l2 = paramToServiceMsg.extraData.getLong("discussUin");
    if (l1 != 0L) {
      bool = false;
    }
    notifyUI(1011, bool, new Object[] { String.valueOf(l1), paramObject, Long.valueOf(l2) });
  }
  
  public void e(long paramLong)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2160);
    localOIDBSSOPkg.uint32_service_type.set(5);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(Utils.a(paramLong)).putInt(0).putShort((short)4).putInt(Utils.a(paramLong));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x870_5");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleDecodeFlyTicket");
    }
    paramToServiceMsg = null;
    boolean bool2 = false;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      paramObject = new FlyTicket.DiscussSigDecodeResponse();
      try
      {
        paramFromServiceMsg = (FlyTicket.DiscussSigDecodeResponse)paramObject.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      boolean bool1 = bool2;
      if (paramToServiceMsg != null)
      {
        bool1 = bool2;
        if (paramToServiceMsg.ret_info.get() != null)
        {
          bool1 = bool2;
          if (((FlyTicket.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.get() == 0) {
            bool1 = true;
          }
        }
      }
      notifyUI(1012, bool1, paramToServiceMsg);
      return;
    }
    notifyUI(1012, false, null);
  }
  
  public void f(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getDiscuss");
      ((StringBuilder)localObject).append(paramLong);
      QLog.d("Q.contacttab.dscs", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new cmd0x58a.ReqBody();
    ((cmd0x58a.ReqBody)localObject).uint32_subcmd.set(1);
    sendPbReq(makeOIDBPkg("OidbSvc.0x58a", 1418, 0, ((cmd0x58a.ReqBody)localObject).toByteArray()));
  }
  
  protected void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = -1L;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = (DiscussionReceiver.RespPackage)paramObject;
      DiscussRespHeader localDiscussRespHeader = (DiscussRespHeader)paramToServiceMsg.jdField_a_of_type_JavaLangObject;
      paramObject = (RespGetDiscussInfo)paramToServiceMsg.b;
      paramToServiceMsg = paramObject;
      if (localDiscussRespHeader != null)
      {
        l = localDiscussRespHeader.Result;
        paramToServiceMsg = paramObject;
      }
    }
    else
    {
      paramToServiceMsg = null;
    }
    paramObject = new Object[2];
    paramObject[0] = String.valueOf(l);
    paramObject[1] = paramToServiceMsg;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (l == 0L))
    {
      notifyUI(1013, true, paramObject);
      return;
    }
    notifyUI(1013, false, paramObject);
  }
  
  protected void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    this.jdField_b_of_type_Long = 0L;
    long l3 = -1L;
    long l2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (DiscussionReceiver.RespPackage)paramObject;
      paramToServiceMsg = (DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject;
      paramObject = (RespJoinDiscuss)paramObject.b;
      long l1;
      if (paramToServiceMsg != null) {
        l1 = paramToServiceMsg.Result;
      } else {
        l1 = -1L;
      }
      l2 = l1;
      if (paramObject != null)
      {
        l3 = paramObject.DiscussUin;
        l2 = l1;
      }
    }
    else
    {
      l2 = -1L;
    }
    paramToServiceMsg = new Long[2];
    paramToServiceMsg[0] = Long.valueOf(l2);
    paramToServiceMsg[1] = Long.valueOf(l3);
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (l2 == 0L) && (l3 > 0L))
    {
      notifyUI(1014, true, paramToServiceMsg);
      return;
    }
    notifyUI(1014, false, paramToServiceMsg);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqAddDiscussMember");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqChangeDiscussName");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqCreateDiscuss");
      this.allowCmdSet.add("OidbSvc.0x58a");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqGetDiscussInfo");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqQuitDiscuss");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqSetDiscussAttr");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqSetDiscussFlag");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqGetDiscussInteRemark");
      this.allowCmdSet.add("QRCodeSvc.discuss_geturl");
      this.allowCmdSet.add("QRCodeSvc.discuss_decode");
      this.allowCmdSet.add("QQServiceDiscussSvc.ReqJoinDiscuss");
      this.allowCmdSet.add("OidbSvc.0x865_3");
      this.allowCmdSet.add("OidbSvc.0x870_4");
      this.allowCmdSet.add("OidbSvc.0x870_5");
      this.allowCmdSet.add("OidbSvc.0x921_0");
      this.allowCmdSet.add("OidbSvc.0x58b_0");
      this.allowCmdSet.add("OidbSvc.0x751");
      this.allowCmdSet.add("OidbSvc.0x44c");
    }
    return this.allowCmdSet;
  }
  
  protected void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    paramToServiceMsg = Byte.valueOf(paramToServiceMsg.extraData.getByte("infoflag"));
    if (QLog.isColorLevel())
    {
      paramObject = new StringBuilder();
      paramObject.append("handleSetDiscussFlagResp dis=");
      paramObject.append(paramFromServiceMsg);
      paramObject.append(" flag=");
      paramObject.append(paramToServiceMsg);
      QLog.d("DiscussionHandler", 2, paramObject.toString());
    }
    paramObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
    paramFromServiceMsg = paramObject.a(String.valueOf(paramFromServiceMsg), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    if (paramFromServiceMsg != null)
    {
      paramFromServiceMsg.flag = paramToServiceMsg.byteValue();
      paramObject.a(paramFromServiceMsg);
    }
  }
  
  protected void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<<---handle set discuss attr req: ");
      localStringBuilder.append(paramToServiceMsg);
      localStringBuilder.append(" ~~resp: ");
      localStringBuilder.append(paramFromServiceMsg);
      localStringBuilder.append(" ~~ data: ");
      localStringBuilder.append(paramObject);
      QLog.d("DiscussionHandler", 2, localStringBuilder.toString());
    }
  }
  
  protected void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleQuitDiscussResp");
    }
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    Object localObject = (RespQuitDiscuss)paramObject.b;
    localObject = (DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject;
    String str1 = String.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    int i = ((DiscussRespHeader)localObject).Result;
    String str2 = ((DiscussRespHeader)localObject).ResultDesc;
    if (((DiscussRespHeader)localObject).Result != 0)
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("header failed! failed code: ");
        paramToServiceMsg.append(((DiscussRespHeader)localObject).Result);
        QLog.w("DiscussionHandler", 2, paramToServiceMsg.toString());
      }
      notifyUI(2000, true, new Object[] { str1, Integer.valueOf(i), str2 });
      notifyUI(1004, false, str1);
      return;
    }
    if ((paramFromServiceMsg.isSuccess()) && (paramObject.jdField_a_of_type_Boolean))
    {
      a(str1);
      paramFromServiceMsg = new ArrayList();
      paramFromServiceMsg.add(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      a(paramToServiceMsg.extraData.getLong("discussUin"), this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramFromServiceMsg, 10009);
      return;
    }
    notifyUI(1004, false, str1);
  }
  
  protected void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      boolean bool1;
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = new DiscussionHandler.HandleGetDiscussRespCheck(this, paramToServiceMsg).a();
        if (paramToServiceMsg.a()) {
          return;
        }
        bool1 = a(false, paramToServiceMsg.a(), paramToServiceMsg.b());
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("merge fail ");
          paramFromServiceMsg.append(paramToServiceMsg.toString());
          QLog.e("Q.contacttab.dscs", 2, paramFromServiceMsg.toString());
        }
        notifyUI(1000, false, null);
        return;
      }
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      bool1 = bool2;
      if (QLog.isColorLevel())
      {
        QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussRespV2 excep", paramToServiceMsg);
        bool1 = bool2;
      }
      notifyUI(1000, bool1, null);
    }
  }
  
  protected void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleChangeDiscussNameResp");
    }
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    paramFromServiceMsg = (RespChangeDiscussName)paramObject.b;
    Object localObject = (DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject;
    paramFromServiceMsg = String.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    int i = ((DiscussRespHeader)localObject).Result;
    String str = ((DiscussRespHeader)localObject).ResultDesc;
    if (((DiscussRespHeader)localObject).Result != 0)
    {
      notifyUI(2000, true, new Object[] { paramFromServiceMsg, Integer.valueOf(i), str });
      notifyUI(1005, false, paramFromServiceMsg);
      return;
    }
    if (paramObject.jdField_a_of_type_Boolean)
    {
      paramObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      localObject = paramObject.a(paramFromServiceMsg);
      if (localObject != null)
      {
        ((DiscussionInfo)localObject).discussionName = paramToServiceMsg.extraData.getString("newName");
        ((DiscussionInfo)localObject).DiscussionFlag &= 0xFFFFFFBF;
        paramObject.a((DiscussionInfo)localObject);
      }
      notifyUI(1005, true, paramFromServiceMsg);
      return;
    }
    notifyUI(1005, false, paramFromServiceMsg);
  }
  
  protected void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleCreateDiscussResp ");
    }
    Object[] arrayOfObject = new Object[3];
    paramObject = (DiscussionReceiver.RespPackage)paramObject;
    arrayOfObject[2] = Integer.valueOf(((DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject).Result);
    if ((paramFromServiceMsg.isSuccess()) && (paramObject.jdField_a_of_type_Boolean))
    {
      paramFromServiceMsg = (RespCreateDiscuss)paramObject.b;
      if (!a(paramFromServiceMsg.DiscussUin))
      {
        if (QLog.isColorLevel()) {
          QLog.d("DiscussionHandler", 2, "create discussion fail: invalid discussion uin");
        }
        notifyUI(1002, false, arrayOfObject);
        return;
      }
      if (QLog.isColorLevel())
      {
        paramObject = new StringBuilder();
        paramObject.append("create discussion succeeded ");
        paramObject.append(paramFromServiceMsg.DiscussUin);
        QLog.d("DiscussionHandler", 2, paramObject.toString());
      }
      paramObject = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      DiscussionManager localDiscussionManager = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      Object localObject2 = new DiscussionInfo();
      ((DiscussionInfo)localObject2).uin = String.valueOf(paramFromServiceMsg.DiscussUin);
      ((DiscussionInfo)localObject2).discussionName = paramToServiceMsg.extraData.getString("name");
      ((DiscussionInfo)localObject2).infoSeq = -1L;
      ((DiscussionInfo)localObject2).createFrom = paramToServiceMsg.extraData.getInt("from", 0);
      ((DiscussionInfo)localObject2).uiControlFlag = paramToServiceMsg.extraData.getLong("uiControlFlag", 0L);
      if (((DiscussionInfo)localObject2).isUIControlFlag_Hidden_RecentUser())
      {
        localObject1 = localDiscussionManager.a(((DiscussionInfo)localObject2).uin);
        if (localObject1 != null)
        {
          int j = ((ArrayList)localObject1).size();
          int i = 0;
          while (i < j)
          {
            localObject3 = (DiscussionMemberInfo)((ArrayList)localObject1).get(i);
            if (localObject3 != null)
            {
              localObject3 = ((DiscussionMemberInfo)localObject3).memberUin;
              if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (!((String)localObject3).equals(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
              {
                ((DiscussionInfo)localObject2).removeUIControlFlag_Hidden_RecentUser();
                if (!QLog.isDevelopLevel()) {
                  break;
                }
                QLog.d("DiscussionHandler", 4, "不是单人多人聊天");
                break;
              }
            }
            i += 1;
          }
        }
      }
      Object localObject1 = paramFromServiceMsg.AddResult;
      Object localObject3 = new DiscussionHandler.ReqDiscussInfo();
      ((DiscussionHandler.ReqDiscussInfo)localObject3).jdField_a_of_type_JavaLangString = String.valueOf(paramFromServiceMsg.DiscussUin);
      ((DiscussionHandler.ReqDiscussInfo)localObject3).b = ((Map)localObject1).size();
      localDiscussionManager.a((DiscussionInfo)localObject2);
      a((DiscussionHandler.ReqDiscussInfo)localObject3);
      localObject3 = ((Map)localObject1).keySet();
      localObject2 = new ArrayList();
      localObject3 = ((Set)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        Object localObject4 = (Long)((Iterator)localObject3).next();
        if (((Integer)((Map)localObject1).get(localObject4)).intValue() == 0)
        {
          DiscussionMemberInfo localDiscussionMemberInfo = new DiscussionMemberInfo();
          localDiscussionMemberInfo.discussionUin = String.valueOf(paramFromServiceMsg.DiscussUin);
          localDiscussionMemberInfo.memberUin = String.valueOf(localObject4);
          localDiscussionMemberInfo.flag = 0;
          localObject4 = paramObject.b(localDiscussionMemberInfo.memberUin);
          if ((localObject4 != null) && (((Friends)localObject4).isFriend())) {
            localDiscussionMemberInfo.memberName = ((Friends)localObject4).name;
          } else {
            this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.getFriendInfo(localDiscussionMemberInfo.memberUin);
          }
          ((List)localObject2).add(localDiscussionMemberInfo);
        }
      }
      localDiscussionManager.b((List)localObject2);
      arrayOfObject[0] = Long.valueOf(paramFromServiceMsg.DiscussUin);
      arrayOfObject[1] = paramToServiceMsg.extraData.getString("name");
      arrayOfObject[2] = Integer.valueOf(0);
      notifyUI(1002, true, arrayOfObject);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("create discussion fail, result code: ");
      paramToServiceMsg.append(paramFromServiceMsg.getResultCode());
      paramToServiceMsg.append(" errMsg: ");
      paramToServiceMsg.append(paramFromServiceMsg.getBusinessFailMsg());
      paramToServiceMsg.append(" respPackage.bSuccess: ");
      paramToServiceMsg.append(paramObject.jdField_a_of_type_Boolean);
      QLog.d("DiscussionHandler", 2, paramToServiceMsg.toString());
    }
    notifyUI(1002, false, arrayOfObject);
  }
  
  protected void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleAddDiscussMemberResp");
    }
    Object localObject2 = (DiscussionReceiver.RespPackage)paramObject;
    RespAddDiscussMember localRespAddDiscussMember = (RespAddDiscussMember)((DiscussionReceiver.RespPackage)localObject2).b;
    paramObject = (DiscussRespHeader)((DiscussionReceiver.RespPackage)localObject2).jdField_a_of_type_JavaLangObject;
    Object localObject1 = String.valueOf(Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
    int i = paramObject.Result;
    paramToServiceMsg = paramObject.ResultDesc;
    if (paramObject.Result != 0)
    {
      notifyUI(2000, true, new Object[] { localObject1, Integer.valueOf(i), paramToServiceMsg });
      return;
    }
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = localObject1;
    paramToServiceMsg[1] = Integer.valueOf(paramObject.Result);
    if ((paramFromServiceMsg.isSuccess()) && (((DiscussionReceiver.RespPackage)localObject2).jdField_a_of_type_Boolean))
    {
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.FRIENDS_MANAGER);
      paramObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      localObject1 = paramObject.a((String)localObject1);
      if (localObject1 == null)
      {
        paramToServiceMsg[0] = String.valueOf(localRespAddDiscussMember.DiscussUin);
        notifyUI(1003, false, paramToServiceMsg);
        return;
      }
      paramFromServiceMsg = ((DiscussionInfo)localObject1).faceUinSet;
      if ((paramFromServiceMsg != null) && (!paramFromServiceMsg.trim().equals(""))) {
        i = paramFromServiceMsg.split(";").length;
      } else {
        i = 0;
      }
      if (4 - i > 0) {
        i = 1;
      } else {
        i = 0;
      }
      Object localObject3 = localRespAddDiscussMember.AddResult;
      Set localSet = ((Map)localObject3).keySet();
      ArrayList localArrayList1 = new ArrayList(localSet.size());
      ArrayList localArrayList2 = new ArrayList();
      StringBuffer localStringBuffer = new StringBuffer();
      Iterator localIterator = localSet.iterator();
      paramFromServiceMsg = paramToServiceMsg;
      paramToServiceMsg = (ToServiceMsg)localObject2;
      localObject2 = localObject3;
      while (localIterator.hasNext())
      {
        localObject3 = (Long)localIterator.next();
        int j = ((Integer)((Map)localObject2).get(localObject3)).intValue();
        Object localObject4;
        if (QLog.isColorLevel())
        {
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("discussUin: ");
          ((StringBuilder)localObject4).append(localRespAddDiscussMember.DiscussUin);
          ((StringBuilder)localObject4).append(" memberUin: ");
          ((StringBuilder)localObject4).append(((Long)localObject3).longValue());
          ((StringBuilder)localObject4).append(" value: ");
          ((StringBuilder)localObject4).append(j);
          localStringBuffer.append(((StringBuilder)localObject4).toString());
          localStringBuffer.append("\n");
        }
        if (j != 0)
        {
          if (localSet.size() == 1) {
            a(j);
          }
        }
        else
        {
          localObject4 = new DiscussionMemberInfo();
          ((DiscussionMemberInfo)localObject4).discussionUin = String.valueOf(localRespAddDiscussMember.DiscussUin);
          ((DiscussionMemberInfo)localObject4).memberUin = String.valueOf(localObject3);
          ((DiscussionMemberInfo)localObject4).flag = 0;
          Object localObject5 = new StringBuilder();
          ((StringBuilder)localObject5).append(localObject3);
          ((StringBuilder)localObject5).append("");
          localObject5 = localFriendsManager.e(((StringBuilder)localObject5).toString());
          if ((localObject5 != null) && (((Friends)localObject5).name != null)) {
            ((DiscussionMemberInfo)localObject4).memberName = ((Friends)localObject5).name;
          }
          localArrayList1.add(String.valueOf(localObject3));
          localArrayList2.add(localObject4);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, localStringBuffer.toString());
      }
      a(localRespAddDiscussMember.DiscussUin, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), localArrayList1, 1);
      ((DiscussionInfo)localObject1).DiscussionFlag |= 0x20000000;
      paramObject.b(localArrayList2);
      if (i != 0) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.c(((DiscussionInfo)localObject1).uin);
      }
      paramFromServiceMsg[2] = paramToServiceMsg.b;
      notifyUI(1003, true, paramFromServiceMsg);
      return;
    }
    paramToServiceMsg[2] = null;
    notifyUI(1003, false, paramToServiceMsg);
  }
  
  void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = -1;
    long l;
    int j;
    Object localObject;
    if (paramToServiceMsg == null)
    {
      paramToServiceMsg = new StringBuilder();
      paramToServiceMsg.append("");
      paramToServiceMsg.append("req为空, ");
      paramToServiceMsg = paramToServiceMsg.toString();
      l = 0L;
      paramFromServiceMsg = null;
      j = 0;
    }
    else
    {
      l = paramToServiceMsg.extraData.getLong("debugSeq");
      localObject = paramToServiceMsg.extraData.getString("uin");
      j = paramToServiceMsg.extraData.getInt("value");
      if (paramFromServiceMsg == null)
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("");
        paramToServiceMsg.append("res为空, ");
        paramToServiceMsg = paramToServiceMsg.toString();
        paramFromServiceMsg = (FromServiceMsg)localObject;
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append("isSuccess[");
        localStringBuilder.append(paramFromServiceMsg.isSuccess());
        localStringBuilder.append("], reqAppSeq[");
        localStringBuilder.append(paramToServiceMsg.getAppSeq());
        localStringBuilder.append("], reqSsoSeq[");
        localStringBuilder.append(paramToServiceMsg.getRequestSsoSeq());
        localStringBuilder.append("], resAppSeq[");
        localStringBuilder.append(paramFromServiceMsg.getAppSeq());
        localStringBuilder.append("], resSsoSeq[");
        localStringBuilder.append(paramFromServiceMsg.getRequestSsoSeq());
        localStringBuilder.append("], ");
        paramToServiceMsg = localStringBuilder.toString();
        if (paramObject == null)
        {
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append(paramToServiceMsg);
          paramFromServiceMsg.append("data为空, ");
          paramToServiceMsg = paramFromServiceMsg.toString();
          paramFromServiceMsg = (FromServiceMsg)localObject;
        }
        else
        {
          paramObject = (cmd0x44c.RspBody)BusinessHandlerUtil.decodeOIDB("DiscussionHandler", (byte[])paramObject, cmd0x44c.RspBody.class);
          if (paramObject == null)
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append(paramToServiceMsg);
            paramFromServiceMsg.append("rspBody为空, ");
            paramToServiceMsg = paramFromServiceMsg.toString();
            paramFromServiceMsg = (FromServiceMsg)localObject;
          }
          else
          {
            i = paramObject.uint32_code.get();
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append(paramToServiceMsg);
            paramFromServiceMsg.append("uint32_code[");
            paramFromServiceMsg.append(i);
            paramFromServiceMsg.append("], bytes_err_msg[");
            if (paramObject.bytes_err_msg.get() != null) {
              paramToServiceMsg = paramObject.bytes_err_msg.get().toStringUtf8();
            } else {
              paramToServiceMsg = "null";
            }
            paramFromServiceMsg.append(paramToServiceMsg);
            paramFromServiceMsg.append("]");
            paramToServiceMsg = paramFromServiceMsg.toString();
            paramFromServiceMsg = (FromServiceMsg)localObject;
          }
        }
      }
    }
    if ((i == 0) && (!TextUtils.isEmpty(paramFromServiceMsg)))
    {
      paramObject = (DiscussionManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.DISCUSSION_MANAGER);
      localObject = paramObject.a(paramFromServiceMsg);
      if ((localObject != null) && (((DiscussionInfo)localObject).getHrExtra() != j))
      {
        ((DiscussionInfo)localObject).mOriginExtra &= 0xFFFFFFFC;
        ((DiscussionInfo)localObject).mOriginExtra |= j & 0x3;
        paramObject.a((DiscussionInfo)localObject);
        QAVHrMeeting.a("handle_0x44c_rsp", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (DiscussionInfo)localObject);
        QAVHrMeeting.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramFromServiceMsg);
      }
    }
    paramObject = new StringBuilder();
    paramObject.append("handle_0x44c_rsp, debugSeq[");
    paramObject.append(l);
    paramObject.append("], strDiscUin[");
    paramObject.append(paramFromServiceMsg);
    paramObject.append("], discHrExtraValue[");
    paramObject.append(j);
    paramObject.append("], ");
    paramObject.append(paramToServiceMsg);
    QLog.w("DiscussionHandler", 1, paramObject.toString());
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return IDiscussionObserver.class;
  }
  
  public void onDestroy()
  {
    GroupIconHelper localGroupIconHelper = this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper;
    if (localGroupIconHelper != null) {
      localGroupIconHelper.a();
    }
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(str);
        QLog.d("DiscussionHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    if (paramFromServiceMsg.getResultCode() == 1002)
    {
      i(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str))
    {
      n(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQServiceDiscussSvc.ReqChangeDiscussName".equalsIgnoreCase(str))
    {
      l(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQServiceDiscussSvc.ReqCreateDiscuss".equalsIgnoreCase(str))
    {
      m(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("OidbSvc.0x58a".equalsIgnoreCase(str))
    {
      k(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
    }
    if ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str))
    {
      if (paramToServiceMsg.extraData.getString("signature") != null) {
        f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
    else
    {
      if ("QQServiceDiscussSvc.ReqQuitDiscuss".equalsIgnoreCase(str))
      {
        j(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussAttr".equalsIgnoreCase(str))
      {
        i(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqSetDiscussFlag".equalsIgnoreCase(str))
      {
        h(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqGetDiscussInteRemark".equalsIgnoreCase(str))
      {
        s(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QRCodeSvc.discuss_geturl".equalsIgnoreCase(str))
      {
        d(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QRCodeSvc.discuss_decode".equalsIgnoreCase(str))
      {
        e(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("QQServiceDiscussSvc.ReqJoinDiscuss".equalsIgnoreCase(str))
      {
        g(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x865_3".equalsIgnoreCase(str))
      {
        a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x870_4".equalsIgnoreCase(str))
      {
        b(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x870_5".equalsIgnoreCase(str))
      {
        c(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x921_0".equalsIgnoreCase(str))
      {
        r(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x58b_0".equalsIgnoreCase(str))
      {
        p(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x751".equalsIgnoreCase(str))
      {
        q(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x44c".equalsIgnoreCase(str)) {
        o(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  /* Error */
  protected void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: astore 17
    //   3: aload_1
    //   4: getfield 382	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   7: ldc_w 752
    //   10: invokevirtual 911	android/os/Bundle:getSerializable	(Ljava/lang/String;)Ljava/io/Serializable;
    //   13: checkcast 597	java/util/ArrayList
    //   16: astore_2
    //   17: aload_2
    //   18: ifnull +14 -> 32
    //   21: aload_2
    //   22: invokevirtual 626	java/util/ArrayList:size	()I
    //   25: iconst_2
    //   26: imul
    //   27: istore 4
    //   29: goto +6 -> 35
    //   32: iconst_0
    //   33: istore 4
    //   35: new 597	java/util/ArrayList
    //   38: dup
    //   39: iload 4
    //   41: invokespecial 687	java/util/ArrayList:<init>	(I)V
    //   44: astore_1
    //   45: aload_2
    //   46: ifnonnull +9 -> 55
    //   49: iconst_0
    //   50: istore 4
    //   52: goto +9 -> 61
    //   55: aload_2
    //   56: invokevirtual 626	java/util/ArrayList:size	()I
    //   59: istore 4
    //   61: new 521	java/util/HashMap
    //   64: dup
    //   65: iload 4
    //   67: invokespecial 686	java/util/HashMap:<init>	(I)V
    //   70: astore 16
    //   72: aload 17
    //   74: aload_2
    //   75: aload_1
    //   76: aload 16
    //   78: invokespecial 2020	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/HashMap;)V
    //   81: aload_1
    //   82: astore_2
    //   83: new 2022	com/tencent/mobileqq/app/DiscussionHandler$HandleGetDiscussInfoRespV2Parse2GetConfInfoList
    //   86: dup
    //   87: aload 17
    //   89: aload_3
    //   90: checkcast 824	[B
    //   93: checkcast 824	[B
    //   96: aload_1
    //   97: aload 16
    //   99: invokespecial 2025	com/tencent/mobileqq/app/DiscussionHandler$HandleGetDiscussInfoRespV2Parse2GetConfInfoList:<init>	(Lcom/tencent/mobileqq/app/DiscussionHandler;[BLjava/util/ArrayList;Ljava/util/HashMap;)V
    //   102: invokevirtual 2028	com/tencent/mobileqq/app/DiscussionHandler$HandleGetDiscussInfoRespV2Parse2GetConfInfoList:a	()Lcom/tencent/mobileqq/app/DiscussionHandler$HandleGetDiscussInfoRespV2Parse2GetConfInfoList;
    //   105: astore_3
    //   106: aload_1
    //   107: astore_2
    //   108: aload_3
    //   109: invokevirtual 2029	com/tencent/mobileqq/app/DiscussionHandler$HandleGetDiscussInfoRespV2Parse2GetConfInfoList:a	()Z
    //   112: istore 9
    //   114: iload 9
    //   116: ifeq +15 -> 131
    //   119: aload_0
    //   120: invokespecial 918	com/tencent/mobileqq/app/DiscussionHandler:a	()Z
    //   123: ifeq +7 -> 130
    //   126: aload_0
    //   127: invokevirtual 920	com/tencent/mobileqq/app/DiscussionHandler:c	()V
    //   130: return
    //   131: aload_1
    //   132: astore_2
    //   133: aload_3
    //   134: invokevirtual 2030	com/tencent/mobileqq/app/DiscussionHandler$HandleGetDiscussInfoRespV2Parse2GetConfInfoList:a	()Ljava/util/List;
    //   137: astore_3
    //   138: iconst_0
    //   139: istore 4
    //   141: aload_1
    //   142: astore_2
    //   143: aload_3
    //   144: invokeinterface 655 1 0
    //   149: istore 5
    //   151: iload 4
    //   153: iload 5
    //   155: if_icmpge +529 -> 684
    //   158: aload_3
    //   159: iload 4
    //   161: invokeinterface 1356 2 0
    //   166: checkcast 2032	tencent/im/oidb/cmd0x58b/cmd0x58b$GetConfInfoRsp
    //   169: astore_2
    //   170: aload_2
    //   171: getfield 2033	tencent/im/oidb/cmd0x58b/cmd0x58b$GetConfInfoRsp:uint64_conf_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   174: invokevirtual 93	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   177: invokestatic 99	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   180: astore 18
    //   182: aload_2
    //   183: getfield 2034	tencent/im/oidb/cmd0x58b/cmd0x58b$GetConfInfoRsp:msg_conf_base_info	Ltencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo;
    //   186: invokevirtual 2035	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo:get	()Lcom/tencent/mobileqq/pb/MessageMicro;
    //   189: checkcast 439	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo
    //   192: astore 19
    //   194: aload_2
    //   195: getfield 2039	tencent/im/oidb/cmd0x58b/cmd0x58b$GetConfInfoRsp:rpt_msg_member_info	Lcom/tencent/mobileqq/pb/PBRepeatMessageField;
    //   198: invokevirtual 2043	com/tencent/mobileqq/pb/PBRepeatMessageField:get	()Ljava/util/List;
    //   201: astore 20
    //   203: aload_2
    //   204: getfield 2046	tencent/im/oidb/cmd0x58b/cmd0x58b$GetConfInfoRsp:uint32_server_remark_timestamp	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   207: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   210: istore 5
    //   212: aload 19
    //   214: getfield 2049	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo:uint32_err_code	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   217: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   220: istore 7
    //   222: aload 19
    //   224: getfield 583	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo:uint32_info_seq	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   227: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   230: istore 6
    //   232: aload 19
    //   234: getfield 1698	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo:uint32_conf_meeting_origin	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   237: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   240: sipush 255
    //   243: iand
    //   244: i2l
    //   245: lstore 10
    //   247: aload 19
    //   249: getfield 1699	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo:uint32_conf_meeting_option	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   252: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   255: istore 8
    //   257: iload 8
    //   259: ldc_w 2050
    //   262: iand
    //   263: i2l
    //   264: lstore 12
    //   266: aload_0
    //   267: aload 18
    //   269: aload 19
    //   271: iload 5
    //   273: iload 7
    //   275: iload 6
    //   277: lload 10
    //   279: lload 12
    //   281: invokespecial 2052	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/lang/String;Ltencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo;IIIJJ)V
    //   284: iload 7
    //   286: ifeq +35 -> 321
    //   289: iload 7
    //   291: iconst_1
    //   292: if_icmpne +26 -> 318
    //   295: aload 16
    //   297: aload 18
    //   299: invokevirtual 710	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   302: pop
    //   303: goto +15 -> 318
    //   306: astore 16
    //   308: aload_0
    //   309: astore_2
    //   310: aload_1
    //   311: astore_3
    //   312: aload 16
    //   314: astore_1
    //   315: goto +467 -> 782
    //   318: goto +528 -> 846
    //   321: aload 16
    //   323: aload 18
    //   325: invokevirtual 710	java/util/HashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   328: pop
    //   329: aload 19
    //   331: getfield 447	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo:uint32_flag	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   334: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   337: istore 7
    //   339: aload 19
    //   341: getfield 457	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo:bytes_conf_name	Lcom/tencent/mobileqq/pb/PBBytesField;
    //   344: invokevirtual 139	com/tencent/mobileqq/pb/PBBytesField:get	()Lcom/tencent/mobileqq/pb/ByteStringMicro;
    //   347: invokevirtual 144	com/tencent/mobileqq/pb/ByteStringMicro:toStringUtf8	()Ljava/lang/String;
    //   350: astore 23
    //   352: aload_0
    //   353: astore_2
    //   354: aload_2
    //   355: getfield 39	com/tencent/mobileqq/app/DiscussionHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   358: getstatic 165	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   361: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   364: checkcast 171	com/tencent/mobileqq/app/FriendsManager
    //   367: astore 21
    //   369: aload_2
    //   370: getfield 39	com/tencent/mobileqq/app/DiscussionHandler:jdField_a_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   373: getstatic 648	com/tencent/mobileqq/app/QQManagerFactory:DISCUSSION_MANAGER	I
    //   376: invokevirtual 169	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   379: checkcast 515	com/tencent/mobileqq/app/DiscussionManager
    //   382: astore 22
    //   384: aload 22
    //   386: aload 18
    //   388: invokevirtual 1051	com/tencent/mobileqq/app/DiscussionManager:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   391: astore 17
    //   393: aload 17
    //   395: ifnonnull +176 -> 571
    //   398: new 75	com/tencent/mobileqq/data/DiscussionInfo
    //   401: dup
    //   402: invokespecial 690	com/tencent/mobileqq/data/DiscussionInfo:<init>	()V
    //   405: astore 17
    //   407: aload 17
    //   409: aload 18
    //   411: putfield 78	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   414: aload 17
    //   416: aload 19
    //   418: getfield 452	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo:uint32_create_time	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   421: invokevirtual 111	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   424: i2l
    //   425: putfield 472	com/tencent/mobileqq/data/DiscussionInfo:createTime	J
    //   428: aload 17
    //   430: aload 23
    //   432: putfield 507	com/tencent/mobileqq/data/DiscussionInfo:discussionName	Ljava/lang/String;
    //   435: aload 17
    //   437: aload 19
    //   439: getfield 442	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo:uint64_owner_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   442: invokevirtual 93	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   445: invokestatic 99	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   448: putfield 475	com/tencent/mobileqq/data/DiscussionInfo:ownerUin	Ljava/lang/String;
    //   451: aload 17
    //   453: aload 19
    //   455: getfield 478	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo:uint64_inherit_owner_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   458: invokevirtual 93	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   461: invokestatic 99	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   464: putfield 481	com/tencent/mobileqq/data/DiscussionInfo:inheritOwnerUin	Ljava/lang/String;
    //   467: aload 17
    //   469: iload 5
    //   471: i2l
    //   472: putfield 484	com/tencent/mobileqq/data/DiscussionInfo:timeSec	J
    //   475: aload 17
    //   477: aload 19
    //   479: getfield 493	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo:uint64_group_code	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   482: invokevirtual 93	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   485: putfield 496	com/tencent/mobileqq/data/DiscussionInfo:groupCode	J
    //   488: aload 17
    //   490: aload 19
    //   492: getfield 487	tencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo:uint64_group_uin	Lcom/tencent/mobileqq/pb/PBUInt64Field;
    //   495: invokevirtual 93	com/tencent/mobileqq/pb/PBUInt64Field:get	()J
    //   498: putfield 490	com/tencent/mobileqq/data/DiscussionInfo:groupUin	J
    //   501: aload 17
    //   503: lload 10
    //   505: putfield 499	com/tencent/mobileqq/data/DiscussionInfo:mOrigin	J
    //   508: aload 17
    //   510: lload 12
    //   512: putfield 502	com/tencent/mobileqq/data/DiscussionInfo:mOriginExtra	J
    //   515: aload 17
    //   517: getfield 425	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   520: lstore 10
    //   522: aload 17
    //   524: iload 7
    //   526: i2l
    //   527: putfield 425	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   530: aload 17
    //   532: lload 10
    //   534: ldc2_w 508
    //   537: land
    //   538: aload 17
    //   540: getfield 425	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   543: lor
    //   544: putfield 425	com/tencent/mobileqq/data/DiscussionInfo:DiscussionFlag	J
    //   547: aload_2
    //   548: aload 18
    //   550: aload 17
    //   552: invokespecial 2054	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/lang/String;Lcom/tencent/mobileqq/data/DiscussionInfo;)V
    //   555: aload 17
    //   557: astore_2
    //   558: goto +93 -> 651
    //   561: astore 16
    //   563: aload_1
    //   564: astore_3
    //   565: aload 16
    //   567: astore_1
    //   568: goto +214 -> 782
    //   571: aload 17
    //   573: getfield 697	com/tencent/mobileqq/data/DiscussionInfo:infoSeq	J
    //   576: lstore 14
    //   578: lload 14
    //   580: iload 6
    //   582: i2l
    //   583: lcmp
    //   584: ifne +42 -> 626
    //   587: aload 17
    //   589: astore_2
    //   590: aload_0
    //   591: aload_1
    //   592: iload 4
    //   594: aload 18
    //   596: aload 20
    //   598: lload 10
    //   600: lload 12
    //   602: iload 7
    //   604: aload 23
    //   606: aload 22
    //   608: aload_2
    //   609: invokespecial 2056	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/util/ArrayList;ILjava/lang/String;Ljava/util/List;JJILjava/lang/String;Lcom/tencent/mobileqq/app/DiscussionManager;Lcom/tencent/mobileqq/data/DiscussionInfo;)V
    //   612: aload_2
    //   613: invokevirtual 127	com/tencent/mobileqq/data/DiscussionInfo:isDiscussHrMeeting	()Z
    //   616: istore 9
    //   618: iload 9
    //   620: ifne +220 -> 840
    //   623: goto -305 -> 318
    //   626: aload_0
    //   627: aload 18
    //   629: aload 19
    //   631: iload 5
    //   633: lload 10
    //   635: lload 12
    //   637: iload 7
    //   639: aload 23
    //   641: aload 22
    //   643: aload 17
    //   645: invokespecial 2058	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/lang/String;Ltencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo;IJJILjava/lang/String;Lcom/tencent/mobileqq/app/DiscussionManager;Lcom/tencent/mobileqq/data/DiscussionInfo;)V
    //   648: goto +192 -> 840
    //   651: aload_0
    //   652: aload 18
    //   654: aload 19
    //   656: aload 20
    //   658: aload 21
    //   660: aload 22
    //   662: aload_2
    //   663: invokespecial 2060	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/lang/String;Ltencent/im/oidb/cmd0x58b/cmd0x58b$ConfBaseInfo;Ljava/util/List;Lcom/tencent/mobileqq/app/FriendsManager;Lcom/tencent/mobileqq/app/DiscussionManager;Lcom/tencent/mobileqq/data/DiscussionInfo;)V
    //   666: aload_1
    //   667: iload 4
    //   669: iconst_2
    //   670: imul
    //   671: iconst_1
    //   672: iadd
    //   673: iconst_1
    //   674: invokestatic 393	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   677: invokevirtual 601	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   680: pop
    //   681: goto +165 -> 846
    //   684: aload_1
    //   685: astore_3
    //   686: aload 16
    //   688: invokevirtual 2061	java/util/HashMap:size	()I
    //   691: istore 4
    //   693: iload 4
    //   695: ifle +29 -> 724
    //   698: aload 16
    //   700: invokevirtual 2065	java/util/HashMap:values	()Ljava/util/Collection;
    //   703: astore_1
    //   704: aload_0
    //   705: astore_2
    //   706: aload_2
    //   707: aload_1
    //   708: invokevirtual 2067	com/tencent/mobileqq/app/DiscussionHandler:a	(Ljava/util/Collection;)V
    //   711: goto +13 -> 724
    //   714: astore_1
    //   715: goto +67 -> 782
    //   718: astore_1
    //   719: aload_0
    //   720: astore_2
    //   721: goto +61 -> 782
    //   724: aload_0
    //   725: astore_2
    //   726: aload_2
    //   727: sipush 1001
    //   730: iconst_1
    //   731: aload_3
    //   732: invokevirtual 402	com/tencent/mobileqq/app/DiscussionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   735: aload_0
    //   736: invokespecial 918	com/tencent/mobileqq/app/DiscussionHandler:a	()Z
    //   739: ifeq +80 -> 819
    //   742: goto +73 -> 815
    //   745: astore_1
    //   746: goto +36 -> 782
    //   749: astore_1
    //   750: goto +71 -> 821
    //   753: astore_2
    //   754: aload_1
    //   755: astore_3
    //   756: aload_0
    //   757: astore 16
    //   759: aload_2
    //   760: astore_1
    //   761: aload 16
    //   763: astore_2
    //   764: goto +18 -> 782
    //   767: astore_1
    //   768: goto +53 -> 821
    //   771: astore 16
    //   773: aload_0
    //   774: astore_1
    //   775: aload_2
    //   776: astore_3
    //   777: aload_1
    //   778: astore_2
    //   779: aload 16
    //   781: astore_1
    //   782: invokestatic 254	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   785: ifeq +14 -> 799
    //   788: ldc_w 429
    //   791: iconst_2
    //   792: ldc_w 2069
    //   795: aload_1
    //   796: invokestatic 1299	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   799: aload_2
    //   800: sipush 1001
    //   803: iconst_0
    //   804: aload_3
    //   805: invokevirtual 402	com/tencent/mobileqq/app/DiscussionHandler:notifyUI	(IZLjava/lang/Object;)V
    //   808: aload_0
    //   809: invokespecial 918	com/tencent/mobileqq/app/DiscussionHandler:a	()Z
    //   812: ifeq +7 -> 819
    //   815: aload_0
    //   816: invokevirtual 920	com/tencent/mobileqq/app/DiscussionHandler:c	()V
    //   819: return
    //   820: astore_1
    //   821: aload_0
    //   822: invokespecial 918	com/tencent/mobileqq/app/DiscussionHandler:a	()Z
    //   825: ifeq +7 -> 832
    //   828: aload_0
    //   829: invokevirtual 920	com/tencent/mobileqq/app/DiscussionHandler:c	()V
    //   832: goto +5 -> 837
    //   835: aload_1
    //   836: athrow
    //   837: goto -2 -> 835
    //   840: aload 17
    //   842: astore_2
    //   843: goto -192 -> 651
    //   846: iload 4
    //   848: iconst_1
    //   849: iadd
    //   850: istore 4
    //   852: goto -711 -> 141
    //   855: astore_2
    //   856: goto -102 -> 754
    //   859: astore_2
    //   860: goto -106 -> 754
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	863	0	this	DiscussionHandler
    //   0	863	1	paramToServiceMsg	ToServiceMsg
    //   0	863	2	paramFromServiceMsg	FromServiceMsg
    //   0	863	3	paramObject	Object
    //   27	824	4	i	int
    //   149	483	5	j	int
    //   230	351	6	k	int
    //   220	418	7	m	int
    //   255	8	8	n	int
    //   112	507	9	bool	boolean
    //   245	389	10	l1	long
    //   264	372	12	l2	long
    //   576	3	14	l3	long
    //   70	226	16	localHashMap	HashMap
    //   306	16	16	localException1	Exception
    //   561	138	16	localException2	Exception
    //   757	5	16	localDiscussionHandler	DiscussionHandler
    //   771	9	16	localException3	Exception
    //   1	840	17	localObject	Object
    //   180	473	18	str1	String
    //   192	463	19	localConfBaseInfo	cmd0x58b.ConfBaseInfo
    //   201	456	20	localList	List
    //   367	292	21	localFriendsManager	FriendsManager
    //   382	279	22	localDiscussionManager	DiscussionManager
    //   350	290	23	str2	String
    // Exception table:
    //   from	to	target	type
    //   295	303	306	java/lang/Exception
    //   590	618	306	java/lang/Exception
    //   398	555	561	java/lang/Exception
    //   706	711	714	java/lang/Exception
    //   698	704	718	java/lang/Exception
    //   726	735	745	java/lang/Exception
    //   158	257	749	finally
    //   266	284	749	finally
    //   295	303	749	finally
    //   321	352	749	finally
    //   354	393	749	finally
    //   571	578	749	finally
    //   590	618	749	finally
    //   626	648	749	finally
    //   651	666	749	finally
    //   666	681	749	finally
    //   686	693	749	finally
    //   698	704	749	finally
    //   666	681	753	java/lang/Exception
    //   686	693	753	java/lang/Exception
    //   83	106	767	finally
    //   108	114	767	finally
    //   133	138	767	finally
    //   143	151	767	finally
    //   398	555	767	finally
    //   83	106	771	java/lang/Exception
    //   108	114	771	java/lang/Exception
    //   133	138	771	java/lang/Exception
    //   143	151	771	java/lang/Exception
    //   706	711	820	finally
    //   726	735	820	finally
    //   782	799	820	finally
    //   799	808	820	finally
    //   266	284	855	java/lang/Exception
    //   321	352	855	java/lang/Exception
    //   354	393	855	java/lang/Exception
    //   571	578	855	java/lang/Exception
    //   626	648	855	java/lang/Exception
    //   651	666	855	java/lang/Exception
    //   158	257	859	java/lang/Exception
  }
  
  public void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = System.currentTimeMillis();
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (a(paramToServiceMsg, paramFromServiceMsg)) {
        return;
      }
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
      if ((paramObject != null) && (paramObject.uint32_result.has()) && (paramObject.uint32_result.get() == 0) && (paramObject.bytes_bodybuffer.has()) && (paramObject.bytes_bodybuffer.get() != null))
      {
        paramFromServiceMsg = new oidb_0x751.RspBody();
        int n = 1;
        int k;
        try
        {
          paramFromServiceMsg.mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
          k = paramFromServiceMsg.uint32_err_code.get();
          if (k != 0) {}
          for (;;)
          {
            try
            {
              if (QLog.isColorLevel())
              {
                paramObject = new StringBuilder();
                paramObject.append("handleCheckIsDiscussionMember handle rspBody error! resultCode:");
                paramObject.append(k);
                paramObject.append(" ,errMsg:");
                paramObject.append(paramFromServiceMsg.bytes_err_msg.get().toString());
                QLog.d("DiscussionHandler", 2, paramObject.toString());
              }
            }
            catch (Exception paramFromServiceMsg)
            {
              i = 0;
              j = 0;
            }
            break label448;
            try
            {
              if (paramFromServiceMsg.msg_rsp_check_is_conf_member.has())
              {
                paramFromServiceMsg = (oidb_0x751.RspCheckIsConfMember)paramFromServiceMsg.msg_rsp_check_is_conf_member.get();
                if (paramFromServiceMsg.msg_check_is_conf_member_result.has())
                {
                  paramFromServiceMsg = paramFromServiceMsg.msg_check_is_conf_member_result.get().iterator();
                  i = 0;
                  j = 0;
                  for (;;)
                  {
                    m = j;
                    try
                    {
                      if (paramFromServiceMsg.hasNext())
                      {
                        m = j;
                        Object localObject = (oidb_0x751.CheckIsConfMemberResult)paramFromServiceMsg.next();
                        m = j;
                        paramObject = String.valueOf(((oidb_0x751.CheckIsConfMemberResult)localObject).uint64_conf_uin.get());
                        m = j;
                        if (((oidb_0x751.CheckIsConfMemberResult)localObject).uint32_is_conf_member.get() == 0)
                        {
                          j += 1;
                          m = j;
                          if (QLog.isColorLevel())
                          {
                            m = j;
                            localObject = new StringBuilder();
                            m = j;
                            ((StringBuilder)localObject).append("handleCheckIsDiscussionMember. Need to deleteDiscuss:");
                            m = j;
                            ((StringBuilder)localObject).append(paramObject);
                            m = j;
                            QLog.d("DiscussionHandler", 2, ((StringBuilder)localObject).toString());
                          }
                          try
                          {
                            a(paramObject);
                          }
                          catch (Exception paramFromServiceMsg)
                          {
                            break label448;
                          }
                        }
                        i += 1;
                      }
                    }
                    catch (Exception paramFromServiceMsg)
                    {
                      j = m;
                    }
                  }
                }
              }
            }
            catch (Exception paramFromServiceMsg)
            {
              break label442;
            }
          }
          i = 0;
          j = 0;
          m = 0;
        }
        catch (Exception paramFromServiceMsg)
        {
          k = 0;
        }
        label442:
        int i = 0;
        int j = 0;
        label448:
        QLog.i("DiscussionHandler", 1, "handleCheckIsDiscussionMember handle rspBody exception!", paramFromServiceMsg);
        int m = n;
        l = System.currentTimeMillis() - l;
        n = paramToServiceMsg.extraData.getInt("checkDiscCount");
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("handleCheckIsDiscussionMember end! resultCode:");
          paramToServiceMsg.append(k);
          paramToServiceMsg.append(" ,totalCount:");
          paramToServiceMsg.append(n);
          paramToServiceMsg.append(" ,validCount:");
          paramToServiceMsg.append(i);
          paramToServiceMsg.append(" ,invalidCount:");
          paramToServiceMsg.append(j);
          paramToServiceMsg.append(" ,cost:");
          paramToServiceMsg.append(l);
          QLog.d("DiscussionHandler", 2, paramToServiceMsg.toString());
        }
        paramToServiceMsg = new HashMap();
        paramToServiceMsg.put("pm_totalCount", String.valueOf(n));
        paramToServiceMsg.put("pm_validCount", String.valueOf(i));
        paramToServiceMsg.put("pm_inValidCount", String.valueOf(j));
        paramToServiceMsg.put("pm_resultCode", String.valueOf(k));
        if (m != 0) {
          paramToServiceMsg.put("pm_exceptionHappen", "true");
        }
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "checkIsDiscussionMember", true, l, 0L, paramToServiceMsg, null);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember ssoPkg invalid!");
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      label696:
      break label696;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember merge ssopkg exception!");
    }
    return;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember req or res is null!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.DiscussionHandler
 * JD-Core Version:    0.7.0.1
 */