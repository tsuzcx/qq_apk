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
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.DiscussionHandler.1;
import com.tencent.mobileqq.app.DiscussionHandler.2;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.GroupIconHelper;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.DiscussionMemberInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
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
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ChnToSpell;
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
import tencent.im.oidb.cmd0x58b.cmd0x58b.GetConfInfoRsp;
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

public class anwo
  extends anud
{
  private long jdField_a_of_type_Long;
  private FriendListHandler jdField_a_of_type_ComTencentMobileqqAppFriendListHandler;
  private GroupIconHelper jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper;
  private ArrayList<Pair<Boolean, String>> jdField_a_of_type_JavaUtilArrayList;
  private LinkedHashMap<String, anwr> jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap(100);
  private long jdField_b_of_type_Long;
  private LinkedHashMap<String, anwr> jdField_b_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
  
  anwo(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler = ((FriendListHandler)paramQQAppInterface.a(1));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper = new GroupIconHelper(paramQQAppInterface.getCurrentAccountUin(), this);
  }
  
  private void a(int paramInt)
  {
    String str;
    switch (paramInt)
    {
    case 106: 
    case 107: 
    case 108: 
    case 109: 
    default: 
      str = BaseApplicationImpl.getApplication().getResources().getString(2131691609);
    }
    for (;;)
    {
      ThreadManager.getUIHandler().post(new DiscussionHandler.1(this, str));
      return;
      str = BaseApplicationImpl.getApplication().getResources().getString(2131691612);
      continue;
      str = BaseApplicationImpl.getApplication().getResources().getString(2131691613);
      continue;
      str = BaseApplicationImpl.getApplication().getResources().getString(2131691610);
      continue;
      str = BaseApplicationImpl.getApplication().getResources().getString(2131691611);
    }
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3, String paramString)
  {
    MessageRecord localMessageRecord = bcry.a(-1004);
    localMessageRecord.init(paramLong1, paramLong2, paramLong2, paramString, NetConnInfoCenter.getServerTime(), -1004, 3000, NetConnInfoCenter.getServerTime());
    localMessageRecord.isread = true;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "----------addMsgToDB after analysis friendUin: " + paramLong2 + " msgType: " + -1004 + " friendType: " + 3000 + " msgContent: " + bhjx.a(paramString));
    }
    paramString = (MessageHandler)this.app.a(0);
    if (!aoci.a(this.app, localMessageRecord, false)) {
      this.app.a().a(localMessageRecord, String.valueOf(paramLong1));
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleError serviceCmd:" + str);
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str)) {
      h(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      do
      {
        return;
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
      } while ("QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str));
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
    } while (!"OidbSvc.0x44c".equals(str));
    o(paramToServiceMsg, paramFromServiceMsg, null);
  }
  
  private void a(String paramString, DiscussionInfo paramDiscussionInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2, new info, disUin[" + paramString + "], DiscussionFlag[" + paramDiscussionInfo.DiscussionFlag + "]");
    }
  }
  
  private void a(String paramString, cmd0x58b.ConfBaseInfo paramConfBaseInfo, int paramInt1, int paramInt2, int paramInt3, long paramLong1, long paramLong2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder(512);
      localStringBuilder.append("handleGetDiscussInfoRespV2, server data:");
      localStringBuilder.append(" disUin[").append(paramString);
      localStringBuilder.append("], owner[").append(paramConfBaseInfo.uint64_owner_uin.get());
      localStringBuilder.append("], errCode[").append(paramInt2);
      localStringBuilder.append("], flag[").append(paramConfBaseInfo.uint32_flag.get());
      localStringBuilder.append("], createTime[").append(paramConfBaseInfo.uint32_create_time.get());
      localStringBuilder.append("], disName[").append(bhjx.a(paramConfBaseInfo.bytes_conf_name.get().toStringUtf8()));
      localStringBuilder.append("], infoseq[").append(paramInt3);
      localStringBuilder.append("], timesec[").append(paramInt1);
      localStringBuilder.append("], discOrigin[").append(paramLong1);
      localStringBuilder.append("], discOriginExtra[").append(paramLong2);
      localStringBuilder.append("]");
      QLog.d("Q.contacttab.dscs", 2, new Object[] { localStringBuilder });
    }
  }
  
  private void a(String paramString1, cmd0x58b.ConfBaseInfo paramConfBaseInfo, int paramInt1, long paramLong1, long paramLong2, int paramInt2, String paramString2, anws paramanws, DiscussionInfo paramDiscussionInfo)
  {
    paramDiscussionInfo.createTime = paramConfBaseInfo.uint32_create_time.get();
    paramDiscussionInfo.ownerUin = String.valueOf(paramConfBaseInfo.uint64_owner_uin.get());
    paramDiscussionInfo.inheritOwnerUin = String.valueOf(paramConfBaseInfo.uint64_inherit_owner_uin.get());
    paramDiscussionInfo.timeSec = paramInt1;
    paramDiscussionInfo.groupUin = paramConfBaseInfo.uint64_group_uin.get();
    paramDiscussionInfo.groupCode = paramConfBaseInfo.uint64_group_code.get();
    paramDiscussionInfo.mOrigin = paramLong1;
    paramDiscussionInfo.mOriginExtra = paramLong2;
    if ((paramInt2 & 0x40) == 0L)
    {
      paramDiscussionInfo.discussionName = paramString2;
      paramDiscussionInfo.DiscussionFlag = (paramInt2 | 0x20000000);
    }
    for (;;)
    {
      paramanws.a(paramDiscussionInfo);
      return;
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleGetDiscussInfoRespV2 disUin=" + paramString1 + " old flag=" + paramDiscussionInfo.DiscussionFlag);
      }
      paramDiscussionInfo.DiscussionFlag = paramInt2;
      paramDiscussionInfo.DiscussionFlag |= 0x20000000;
      paramDiscussionInfo.discussionName = paramString2;
    }
  }
  
  private void a(String paramString, cmd0x58b.ConfBaseInfo paramConfBaseInfo, List<cmd0x58b.ConfMemberInfo> paramList, anyw paramanyw, anws paramanws, DiscussionInfo paramDiscussionInfo)
  {
    HashMap localHashMap = new HashMap();
    long l = System.currentTimeMillis();
    Map localMap = paramanws.a(paramString);
    bhoq.a("handleGetDiscussInfoRespV2", this.app, paramDiscussionInfo);
    StringBuffer localStringBuffer = new StringBuffer();
    Iterator localIterator = paramList.iterator();
    if (localIterator.hasNext())
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
        localStringBuffer.append(bhjx.a(localConfMemberInfo.bytes_member_interemark.get().toStringUtf8()));
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
      if ((localConfMemberInfo.bytes_member_interemark.has()) && (!TextUtils.isEmpty(localConfMemberInfo.bytes_member_interemark.get().toStringUtf8()))) {
        ((DiscussionMemberInfo)localObject).inteRemark = localConfMemberInfo.bytes_member_interemark.get().toStringUtf8();
      }
      for (;;)
      {
        bhoq.a(this.app, paramDiscussionInfo, (DiscussionMemberInfo)localObject);
        localHashMap.put(((DiscussionMemberInfo)localObject).memberUin, localObject);
        break;
        if (TextUtils.isEmpty(((DiscussionMemberInfo)localObject).inteRemark))
        {
          paramList = paramanyw.b(((DiscussionMemberInfo)localObject).memberUin);
          if ((paramList != null) && (paramList.isFriend()))
          {
            ((DiscussionMemberInfo)localObject).memberName = paramList.name;
            if (TextUtils.isEmpty(paramList.remark)) {}
            for (paramList = paramList.name;; paramList = paramList.remark)
            {
              ((DiscussionMemberInfo)localObject).inteRemark = paramList;
              ((DiscussionMemberInfo)localObject).inteRemarkSource = 129L;
              break;
            }
          }
          ((DiscussionMemberInfo)localObject).inteRemarkSource = 0L;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, localStringBuffer.toString());
    }
    paramanws.a(paramString, paramDiscussionInfo, paramConfBaseInfo.uint32_info_seq.get(), localHashMap, l);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.c(paramDiscussionInfo.uin);
  }
  
  private void a(ArrayList<Object> paramArrayList, int paramInt1, String paramString1, List<cmd0x58b.ConfMemberInfo> paramList, long paramLong1, long paramLong2, int paramInt2, String paramString2, anws paramanws, DiscussionInfo paramDiscussionInfo)
  {
    Map localMap = paramanws.a(paramString1);
    paramArrayList.set(paramInt1 * 2 + 1, Boolean.valueOf(a(paramDiscussionInfo, paramList, localMap)));
    paramInt1 = 0;
    if ((paramInt2 & 0x40) == 0L) {
      if (!paramDiscussionInfo.discussionName.equals(paramString2))
      {
        paramDiscussionInfo.DiscussionFlag = (paramInt2 | 0x20000000);
        paramDiscussionInfo.discussionName = paramString2;
        paramInt2 = 1;
        paramInt1 = paramInt2;
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 disUin=" + paramString1 + " name need server name| local name=" + bhjx.a(paramDiscussionInfo.discussionName));
        }
      }
    }
    for (paramInt1 = paramInt2;; paramInt1 = 1)
    {
      if ((paramLong1 != paramDiscussionInfo.mOrigin) || (paramLong2 != paramDiscussionInfo.mOriginExtra))
      {
        if (AudioHelper.f()) {
          QLog.w("DiscussionHandler", 1, "handleGetDiscussInfoRespV2, update mOrigin[" + paramDiscussionInfo.mOrigin + "->" + paramLong1 + "], mOriginExtra[" + paramDiscussionInfo.mOriginExtra + "->" + paramLong2 + "]");
        }
        paramDiscussionInfo.mOrigin = paramLong1;
        paramDiscussionInfo.mOriginExtra = paramLong2;
        paramInt1 = 1;
      }
      if (paramInt1 != 0) {
        paramanws.a(paramDiscussionInfo);
      }
      return;
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 disUin=" + paramString1 + " old flag=" + paramDiscussionInfo.DiscussionFlag);
      }
      paramDiscussionInfo.DiscussionFlag = paramInt2;
      paramDiscussionInfo.DiscussionFlag |= 0x20000000;
      bhlg.a(this.app, paramString1, paramDiscussionInfo, localMap, false);
    }
  }
  
  private void a(ArrayList<Long> paramArrayList, ArrayList<Object> paramArrayList1, HashMap<String, anwr> paramHashMap)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Long localLong = (Long)paramArrayList.next();
        anwr localanwr = (anwr)this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(String.valueOf(localLong));
        if (localanwr != null)
        {
          localanwr.jdField_a_of_type_Int += 1;
          paramHashMap.put(String.valueOf(localLong), localanwr);
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
    boolean bool2 = false;
    anws localanws = (anws)this.app.getManager(53);
    ArrayList localArrayList = new ArrayList();
    long l;
    Object localObject1;
    Object localObject2;
    boolean bool1;
    if ((paramList != null) && (paramMap != null))
    {
      l = System.currentTimeMillis();
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        localObject1 = (cmd0x58b.ConfMemberInfo)paramList.next();
        if ((((cmd0x58b.ConfMemberInfo)localObject1).bytes_member_interemark.has()) && (!TextUtils.isEmpty(((cmd0x58b.ConfMemberInfo)localObject1).bytes_member_interemark.get().toStringUtf8())))
        {
          localObject2 = String.valueOf(((cmd0x58b.ConfMemberInfo)localObject1).uint64_uin.get());
          DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramMap.get(localObject2);
          if (localDiscussionMemberInfo == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("DiscussionHandler", 2, "warning dbMemberInfo is null uin=" + (String)localObject2);
            }
          }
          else if ((!paramDiscussionInfo.isDiscussHrMeeting()) && (!TextUtils.isEmpty(localDiscussionMemberInfo.memberUin)) && (localDiscussionMemberInfo.memberUin.equals(localObject2)) && (!TextUtils.isEmpty(localDiscussionMemberInfo.inteRemark)) && (!localDiscussionMemberInfo.inteRemark.equals(((cmd0x58b.ConfMemberInfo)localObject1).bytes_member_interemark.get().toStringUtf8())))
          {
            localDiscussionMemberInfo.dataTime = l;
            localDiscussionMemberInfo.inteRemark = ((cmd0x58b.ConfMemberInfo)localObject1).bytes_member_interemark.get().toStringUtf8();
            localDiscussionMemberInfo.inteRemarkSource = ((cmd0x58b.ConfMemberInfo)localObject1).uint32_interemark_source.get();
            localArrayList.add(localDiscussionMemberInfo);
            bool1 = true;
          }
        }
      }
    }
    for (;;)
    {
      if (localArrayList.size() > 0) {
        localanws.b(localArrayList);
      }
      return bool1;
      bool1 = bool2;
      if (paramList != null)
      {
        bool1 = bool2;
        if (paramMap == null)
        {
          l = System.currentTimeMillis();
          paramMap = (anyw)this.app.getManager(51);
          localObject1 = paramList.iterator();
          do
          {
            bool1 = bool2;
            if (!((Iterator)localObject1).hasNext()) {
              break;
            }
            paramList = (cmd0x58b.ConfMemberInfo)((Iterator)localObject1).next();
            localObject2 = new DiscussionMemberInfo();
            ((DiscussionMemberInfo)localObject2).discussionUin = paramDiscussionInfo.uin;
            ((DiscussionMemberInfo)localObject2).memberUin = String.valueOf(paramList.uint64_uin.get());
            ((DiscussionMemberInfo)localObject2).flag = ((byte)paramList.uint32_flag.get());
            ((DiscussionMemberInfo)localObject2).dataTime = l;
          } while (paramDiscussionInfo.isDiscussHrMeeting());
          if ((paramList.bytes_member_interemark.has()) && (!TextUtils.isEmpty(paramList.bytes_member_interemark.get().toStringUtf8())))
          {
            ((DiscussionMemberInfo)localObject2).inteRemark = paramList.bytes_member_interemark.get().toStringUtf8();
            ((DiscussionMemberInfo)localObject2).inteRemarkSource = paramList.uint32_interemark_source.get();
          }
          for (;;)
          {
            localArrayList.add(localObject2);
            break;
            paramList = paramMap.b(((DiscussionMemberInfo)localObject2).memberUin);
            if ((paramList != null) && (paramList.isFriend()))
            {
              ((DiscussionMemberInfo)localObject2).memberName = paramList.name;
              if (TextUtils.isEmpty(paramList.remark)) {}
              for (paramList = paramList.name;; paramList = paramList.remark)
              {
                ((DiscussionMemberInfo)localObject2).inteRemark = paramList;
                ((DiscussionMemberInfo)localObject2).inteRemarkSource = 129L;
                break;
              }
            }
            ((DiscussionMemberInfo)localObject2).inteRemarkSource = 0L;
          }
          bool1 = false;
        }
      }
    }
  }
  
  private boolean a(boolean paramBoolean, List<cmd0x58a.ConfBaseInfo> paramList, List<Long> paramList1)
  {
    Object localObject2 = ((anws)this.app.getManager(53)).a();
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
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleGetDiscussResp bakUinList size = " + paramList1.size());
      }
      paramList = paramList1.iterator();
      while (paramList.hasNext())
      {
        paramList1 = String.valueOf((Long)paramList.next());
        if (((HashMap)localObject1).containsKey(paramList1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleGetDiscussResp uin: " + paramList1 + " is in bakUinList,can not delete");
          }
          ((HashMap)localObject1).remove(paramList1);
        }
      }
    }
    paramList = this.app.a();
    paramList1 = new StringBuilder(100);
    paramList1.append("need delete dis ");
    localObject1 = ((HashMap)localObject1).keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (String)((Iterator)localObject1).next();
      paramList1.append((String)localObject4).append(";");
      a((String)localObject4);
      if (paramList.b((String)localObject4) != null) {
        paramList.d((String)localObject4);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, paramList1.toString());
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionVerify", 2, "GetDiscussList dis_cnt=" + ((ArrayList)localObject2).size() + " fav_cnt=" + ((ArrayList)localObject3).size());
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
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleTimeOut serviceCmd:" + str);
    }
    if ("QQServiceDiscussSvc.ReqAddDiscussMember".equalsIgnoreCase(str)) {
      w(paramToServiceMsg, paramFromServiceMsg);
    }
    do
    {
      return;
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
    } while (!"OidbSvc.0x44c".equals(str));
    o(paramToServiceMsg, paramFromServiceMsg, null);
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
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    paramFromServiceMsg = paramToServiceMsg.extraData.getString("discUid");
    paramToServiceMsg = new Object[4];
    paramToServiceMsg[0] = paramFromServiceMsg;
    paramToServiceMsg[1] = Boolean.valueOf(false);
    paramToServiceMsg[2] = Integer.valueOf(0);
    paramToServiceMsg[3] = Integer.valueOf(0);
    Object localObject = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramObject = (oidb_sso.OIDBSSOPkg)((oidb_sso.OIDBSSOPkg)localObject).mergeFrom((byte[])paramObject);
      if ((paramObject == null) || (!paramObject.uint32_result.has()) || (paramObject.uint32_result.get() != 0) || (!paramObject.bytes_bodybuffer.has()) || (paramObject.bytes_bodybuffer.get() == null))
      {
        notifyUI(1018, false, paramToServiceMsg);
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      notifyUI(1018, false, paramToServiceMsg);
      return;
    }
    localObject = new cmd0x921.RspBody();
    for (;;)
    {
      try
      {
        ((cmd0x921.RspBody)localObject).mergeFrom(paramObject.bytes_bodybuffer.get().toByteArray());
        boolean bool = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.bool_priviledge.get();
        if (!((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_uin_remain.has()) {
          break label289;
        }
        i = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_uin_remain.get();
        if (((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_discuss_uin_remain.has())
        {
          j = ((cmd0x921.RspBody)localObject).msg_get_at_all_remain.uint32_discuss_uin_remain.get();
          notifyUI(1018, true, new Object[] { paramFromServiceMsg, Boolean.valueOf(bool), Integer.valueOf(i), Integer.valueOf(j) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        notifyUI(1018, false, paramToServiceMsg);
        return;
      }
      int j = 0;
      continue;
      label289:
      int i = 0;
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
    paramToServiceMsg = (bcql)paramObject;
    paramObject = (RespGetDiscussInteRemark)paramToServiceMsg.b;
    long l = paramObject.DiscussUin;
    Object localObject1 = (DiscussRespHeader)paramToServiceMsg.jdField_a_of_type_JavaLangObject;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleGetDiscussInteRemarkResp header.Result" + ((DiscussRespHeader)localObject1).Result);
    }
    if (((DiscussRespHeader)localObject1).Result != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("DiscussionHandler", 2, "header failed code: " + ((DiscussRespHeader)localObject1).Result);
      }
      notifyUI(1010, false, Long.valueOf(l));
    }
    do
    {
      return;
      if ((!paramFromServiceMsg.isSuccess()) || (!paramToServiceMsg.jdField_a_of_type_Boolean))
      {
        notifyUI(1010, false, Long.valueOf(l));
        return;
      }
      paramToServiceMsg = paramObject.InteRemarks;
      paramFromServiceMsg = (anws)this.app.getManager(53);
      paramObject = paramFromServiceMsg.a(String.valueOf(l));
    } while ((paramToServiceMsg == null) || (paramObject == null));
    paramToServiceMsg.keySet();
    localObject1 = paramToServiceMsg.keySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = (Long)((Iterator)localObject1).next();
      DiscussionMemberInfo localDiscussionMemberInfo = (DiscussionMemberInfo)paramObject.get(String.valueOf(localObject2));
      if (localDiscussionMemberInfo != null)
      {
        localObject2 = (InteRemarkInfo)paramToServiceMsg.get(localObject2);
        localDiscussionMemberInfo.inteRemark = ((InteRemarkInfo)localObject2).StrValue;
        localDiscussionMemberInfo.inteRemarkSource = ((InteRemarkInfo)localObject2).Source;
        paramFromServiceMsg.a(localDiscussionMemberInfo);
      }
    }
    notifyUI(1010, true, Long.valueOf(l));
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
    if (paramToServiceMsg.extraData.getString("signature") != null) {}
    label150:
    label167:
    do
    {
      return;
      paramFromServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("discussUin");
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("handleGetDiscussInfoErrorV2 disUin: ");
        if (paramFromServiceMsg != null) {
          break label150;
        }
      }
      for (paramToServiceMsg = "null";; paramToServiceMsg = paramFromServiceMsg.toString())
      {
        QLog.d("Q.contacttab.dscs", 2, paramToServiceMsg);
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.size() <= 0)) {
          break label167;
        }
        paramToServiceMsg = new ArrayList(paramFromServiceMsg.size() * 2);
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        while (paramFromServiceMsg.hasNext())
        {
          localObject = (Long)paramFromServiceMsg.next();
          this.jdField_a_of_type_JavaUtilLinkedHashMap.remove(String.valueOf(localObject));
          paramToServiceMsg.add(localObject);
          paramToServiceMsg.add(Boolean.valueOf(false));
        }
      }
      notifyUI(1001, false, paramToServiceMsg);
    } while (!a());
    c();
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
    int j = 4;
    if ((paramString == null) || (paramString.length() == 0)) {
      return null;
    }
    float f = this.app.getApp().getResources().getDisplayMetrics().density;
    int m = (int)(50.0F * f + 0.5D);
    paramString = paramString.split(";");
    int i;
    if (paramString.length <= 1)
    {
      i = (int)(f * 117.0F);
      if (paramString.length <= 4) {
        break label150;
      }
    }
    Bitmap[] arrayOfBitmap;
    for (;;)
    {
      arrayOfBitmap = new Bitmap[j];
      int k = 0;
      while (k < j)
      {
        arrayOfBitmap[k] = ((Bitmap)this.app.a(paramString[k], 1, i, i).second);
        k += 1;
      }
      if (paramString.length <= 4)
      {
        i = (int)(f * 53.0F);
        break;
      }
      i = (int)(f * 34.0F);
      break;
      label150:
      j = paramString.length;
    }
    try
    {
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.a(m, arrayOfBitmap);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public Bitmap a(String paramString, boolean paramBoolean)
  {
    Bitmap localBitmap;
    if ((paramString != null) || (paramBoolean))
    {
      try
      {
        return bhmq.h();
      }
      catch (Throwable paramString)
      {
        if (!QLog.isColorLevel()) {
          break label107;
        }
        QLog.e("DiscussionHandler", 2, "getDiscussionFaceIcon error", paramString);
        return null;
        label102:
        localBitmap = null;
      }
      if (GroupIconHelper.a(paramString)) {}
      for (localBitmap = this.app.a(1001, paramString, (byte)3, false, (byte)1, 0); localBitmap == null; localBitmap = this.app.a(101, paramString, (byte)3, false, (byte)1, 0))
      {
        a(paramString, true);
        if (!paramBoolean) {
          break label102;
        }
        return bhmq.h();
      }
      a(paramString, false);
    }
    else
    {
      label107:
      return null;
    }
    return localBitmap;
  }
  
  public Drawable a(String paramString, boolean paramBoolean)
  {
    Object localObject = null;
    Bitmap localBitmap = a(paramString, paramBoolean);
    paramString = localObject;
    if (localBitmap != null) {
      paramString = new BitmapDrawable(localBitmap);
    }
    return paramString;
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
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscussInfo " + paramLong);
    }
    Object localObject = (anws)this.app.getManager(53);
    anwr localanwr = new anwr();
    localanwr.jdField_a_of_type_JavaLangString = String.valueOf(paramLong);
    localanwr.b = ((anws)localObject).a(localanwr.jdField_a_of_type_JavaLangString);
    a(localanwr);
  }
  
  public void a(long paramLong, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqSetDiscussFlag");
    localToServiceMsg.extraData.putLong("discussUin", paramLong);
    localToServiceMsg.extraData.putByte("flag", paramByte1);
    localToServiceMsg.extraData.putByte("infoflag", paramByte2);
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "--->>set discuss flag uin: " + paramLong + " req: " + localToServiceMsg);
    }
    send(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt)
  {
    long l1 = AudioHelper.b();
    String str = String.valueOf(paramLong);
    Object localObject = ((anws)this.app.getManager(53)).a(str);
    if (localObject == null) {
      str = "" + "[DiscussionInfo为空], ";
    }
    for (;;)
    {
      QLog.w("DiscussionHandler", 1, "setHrConfExtraInfo, discUin[" + paramLong + "], discHrExtraValue[" + paramInt + "], debugSeq[" + l1 + "], " + str);
      return;
      if ((((DiscussionInfo)localObject).mOrigin & 0x2) != 2L)
      {
        str = "" + "mOrigin[" + ((DiscussionInfo)localObject).mOrigin + "], ";
      }
      else
      {
        int i = ((DiscussionInfo)localObject).getHrExtra();
        if ((paramInt == 1) && (i != 0))
        {
          str = "" + "hrExtra[" + i + "], ";
        }
        else
        {
          cmd0x44c.ReqBody localReqBody = new cmd0x44c.ReqBody();
          localReqBody.uint32_subcmd.set(1);
          cmd0x44c.ModifyConfInfoReq localModifyConfInfoReq = new cmd0x44c.ModifyConfInfoReq();
          localModifyConfInfoReq.uint64_conf_uin.set(paramLong);
          long l2 = ((DiscussionInfo)localObject).mOriginExtra;
          long l3 = paramInt & 0x3;
          localModifyConfInfoReq.uint32_conf_meeting_option.set((int)(l2 & 0xFFFFFFFC | l3));
          localReqBody.msg_modify_conf_info_req.set(localModifyConfInfoReq);
          localObject = makeOIDBPkg("OidbSvc.0x44c", 1100, 2, localReqBody.toByteArray());
          ((ToServiceMsg)localObject).extraData.putLong("debugSeq", l1);
          ((ToServiceMsg)localObject).extraData.putString("uin", str);
          ((ToServiceMsg)localObject).extraData.putInt("value", paramInt);
          sendPbReq((ToServiceMsg)localObject);
          str = "" + "reqAppSeq[" + ((ToServiceMsg)localObject).getAppSeq() + "], reqSsoSeq[" + ((ToServiceMsg)localObject).getRequestSsoSeq() + "], ";
        }
      }
    }
  }
  
  public void a(long paramLong1, long paramLong2)
  {
    anws localanws = (anws)this.app.getManager(53);
    if (localanws.a(paramLong1 + "") == null) {
      a(paramLong1);
    }
    while (localanws.a(String.valueOf(paramLong1), String.valueOf(paramLong2)) != null) {
      return;
    }
    a(paramLong1);
  }
  
  public void a(long paramLong, String paramString)
  {
    if (paramString != null)
    {
      ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqChangeDiscussName");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      localToServiceMsg.extraData.putString("newName", paramString);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "--->>change discuss name uin: " + paramLong + " req: " + localToServiceMsg);
      }
      send(localToServiceMsg);
    }
  }
  
  public void a(long paramLong, String paramString, List<String> paramList, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "notifyMemberChange disUin=" + paramLong + " cmdUin=" + paramString + " opType=" + paramInt + " uinsize=" + paramList.size());
    }
    MqqHandler localMqqHandler = this.app.getHandler(AVNotifyCenter.class);
    if (localMqqHandler != null)
    {
      Message localMessage = localMqqHandler.obtainMessage(paramInt);
      localMessage.obj = new Object[] { Long.valueOf(paramLong), paramString, (String[])paramList.toArray(new String[paramList.size()]) };
      localMqqHandler.sendMessage(localMessage);
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
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "--->>add discuss member uin: " + paramLong + " req: " + localToServiceMsg);
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
  
  public void a(@NonNull anwr paramanwr)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscussInfo2 " + paramanwr.jdField_a_of_type_JavaLangString);
    }
    synchronized (this.jdField_b_of_type_JavaUtilLinkedHashMap)
    {
      if ((!this.jdField_b_of_type_JavaUtilLinkedHashMap.containsKey(paramanwr.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(paramanwr.jdField_a_of_type_JavaLangString))) {
        this.jdField_b_of_type_JavaUtilLinkedHashMap.put(paramanwr.jdField_a_of_type_JavaLangString, paramanwr);
      }
      while (!QLog.isColorLevel())
      {
        c();
        return;
      }
      QLog.d("Q.contacttab.dscs", 2, "getDiscussionInfo filtered " + paramanwr.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(DiscussionInfo paramDiscussionInfo, boolean paramBoolean)
  {
    apaw localapaw = this.app.a().a();
    paramDiscussionInfo = (RecentUser)localapaw.findRecentUserByUin(paramDiscussionInfo.uin, 3000);
    if (paramDiscussionInfo != null) {
      if (!paramBoolean) {
        break label78;
      }
    }
    label78:
    for (paramDiscussionInfo.showUpTime = (System.currentTimeMillis() / 1000L);; paramDiscussionInfo.showUpTime = 0L)
    {
      localapaw.saveRecentUser(paramDiscussionInfo);
      paramDiscussionInfo = this.app.getHandler(Conversation.class);
      if (paramDiscussionInfo != null) {
        paramDiscussionInfo.sendMessage(paramDiscussionInfo.obtainMessage(1009));
      }
      return;
    }
  }
  
  /* Error */
  protected void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +12 -> 15
    //   6: ldc 118
    //   8: iconst_2
    //   9: ldc_w 1230
    //   12: invokestatic 151	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   15: aload_2
    //   16: invokevirtual 849	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   19: ifeq +429 -> 448
    //   22: aload_3
    //   23: ifnull +425 -> 448
    //   26: iconst_1
    //   27: istore 9
    //   29: aload_1
    //   30: getfield 250	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   33: ldc_w 749
    //   36: invokevirtual 704	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   39: invokestatic 754	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   42: astore_2
    //   43: aload_1
    //   44: getfield 250	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   47: ldc_w 751
    //   50: invokevirtual 704	android/os/Bundle:getLong	(Ljava/lang/String;)J
    //   53: invokestatic 754	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   56: astore_1
    //   57: iload 9
    //   59: istore 8
    //   61: iload 9
    //   63: ifeq +426 -> 489
    //   66: new 783	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   69: dup
    //   70: invokespecial 784	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   73: astore 14
    //   75: aload 14
    //   77: aload_3
    //   78: checkcast 786	[B
    //   81: checkcast 786	[B
    //   84: invokevirtual 790	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   87: pop
    //   88: aload 14
    //   90: getfield 793	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   93: invokevirtual 331	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   96: istore 4
    //   98: iload 4
    //   100: ifne +354 -> 454
    //   103: iconst_1
    //   104: istore 8
    //   106: aload_1
    //   107: invokevirtual 757	java/lang/Long:longValue	()J
    //   110: lstore 10
    //   112: aload_2
    //   113: invokevirtual 757	java/lang/Long:longValue	()J
    //   116: lstore 12
    //   118: aload_0
    //   119: getfield 155	anwo:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   122: aload_1
    //   123: invokestatic 600	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   126: aload_2
    //   127: invokestatic 600	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   130: invokestatic 1233	bhlg:c	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   133: astore_3
    //   134: new 120	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 1234
    //   144: invokestatic 1238	anzj:a	(I)Ljava/lang/String;
    //   147: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload_0
    //   151: getfield 155	anwo:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   154: invokevirtual 895	com/tencent/mobileqq/app/QQAppInterface:getApp	()Lcom/tencent/qphone/base/util/BaseApplication;
    //   157: ldc_w 1239
    //   160: iconst_1
    //   161: anewarray 244	java/lang/Object
    //   164: dup
    //   165: iconst_0
    //   166: aload_3
    //   167: aastore
    //   168: invokevirtual 1242	com/tencent/qphone/base/util/BaseApplication:getString	(I[Ljava/lang/Object;)Ljava/lang/String;
    //   171: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   177: astore_3
    //   178: aload_0
    //   179: aload_0
    //   180: getfield 155	anwo:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   183: invokevirtual 44	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   186: invokestatic 1245	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   189: aload_1
    //   190: invokevirtual 757	java/lang/Long:longValue	()J
    //   193: aload_1
    //   194: invokevirtual 757	java/lang/Long:longValue	()J
    //   197: aload_3
    //   198: invokespecial 1247	anwo:a	(JJJLjava/lang/String;)V
    //   201: aload_0
    //   202: getfield 155	anwo:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   205: bipush 53
    //   207: invokevirtual 618	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   210: checkcast 407	anws
    //   213: aload_1
    //   214: invokestatic 600	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   217: invokevirtual 1005	anws:a	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/DiscussionInfo;
    //   220: astore_3
    //   221: iconst_0
    //   222: istore 6
    //   224: iload 6
    //   226: istore 5
    //   228: aload_3
    //   229: ifnull +92 -> 321
    //   232: aload_3
    //   233: getfield 1250	com/tencent/mobileqq/data/DiscussionInfo:faceUinSet	Ljava/lang/String;
    //   236: astore 14
    //   238: iload 6
    //   240: istore 5
    //   242: aload 14
    //   244: ifnull +77 -> 321
    //   247: iload 6
    //   249: istore 5
    //   251: aload 14
    //   253: invokevirtual 1253	java/lang/String:trim	()Ljava/lang/String;
    //   256: ldc_w 1007
    //   259: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   262: ifne +59 -> 321
    //   265: aload 14
    //   267: ldc_w 679
    //   270: invokevirtual 915	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   273: astore 14
    //   275: iload 6
    //   277: istore 5
    //   279: aload 14
    //   281: ifnull +40 -> 321
    //   284: aload 14
    //   286: arraylength
    //   287: istore 7
    //   289: iconst_0
    //   290: istore 4
    //   292: iload 6
    //   294: istore 5
    //   296: iload 4
    //   298: iload 7
    //   300: if_icmpge +21 -> 321
    //   303: aload 14
    //   305: iload 4
    //   307: aaload
    //   308: aload_2
    //   309: invokestatic 600	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   312: invokevirtual 229	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   315: ifeq +197 -> 512
    //   318: iconst_1
    //   319: istore 5
    //   321: aload_1
    //   322: invokestatic 600	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   325: astore 14
    //   327: new 1255	java/util/HashSet
    //   330: dup
    //   331: invokespecial 1256	java/util/HashSet:<init>	()V
    //   334: astore 15
    //   336: aload 15
    //   338: new 120	java/lang/StringBuilder
    //   341: dup
    //   342: invokespecial 121	java/lang/StringBuilder:<init>	()V
    //   345: aload_2
    //   346: invokevirtual 999	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   349: ldc_w 1007
    //   352: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: invokevirtual 147	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   358: invokevirtual 1257	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   361: pop
    //   362: aload_0
    //   363: aload 14
    //   365: aload 15
    //   367: invokevirtual 1260	anwo:a	(Ljava/lang/String;Ljava/util/HashSet;)V
    //   370: new 565	java/util/ArrayList
    //   373: dup
    //   374: invokespecial 619	java/util/ArrayList:<init>	()V
    //   377: astore 14
    //   379: aload 14
    //   381: aload_2
    //   382: invokestatic 600	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   385: invokeinterface 625 2 0
    //   390: pop
    //   391: aload_0
    //   392: aload_1
    //   393: invokevirtual 757	java/lang/Long:longValue	()J
    //   396: aload_0
    //   397: getfield 155	anwo:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   400: invokevirtual 44	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   403: aload 14
    //   405: iconst_2
    //   406: invokevirtual 1262	anwo:a	(JLjava/lang/String;Ljava/util/List;I)V
    //   409: iload 5
    //   411: ifeq +14 -> 425
    //   414: aload_0
    //   415: getfield 49	anwo:jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper	Lcom/tencent/mobileqq/app/face/GroupIconHelper;
    //   418: aload_3
    //   419: getfield 554	com/tencent/mobileqq/data/DiscussionInfo:uin	Ljava/lang/String;
    //   422: invokevirtual 557	com/tencent/mobileqq/app/face/GroupIconHelper:c	(Ljava/lang/String;)V
    //   425: aload_0
    //   426: sipush 1015
    //   429: iload 8
    //   431: iconst_2
    //   432: newarray long
    //   434: dup
    //   435: iconst_0
    //   436: lload 10
    //   438: lastore
    //   439: dup
    //   440: iconst_1
    //   441: lload 12
    //   443: lastore
    //   444: invokevirtual 270	anwo:notifyUI	(IZLjava/lang/Object;)V
    //   447: return
    //   448: iconst_0
    //   449: istore 9
    //   451: goto -422 -> 29
    //   454: iconst_0
    //   455: istore 8
    //   457: goto -351 -> 106
    //   460: astore_3
    //   461: iconst_0
    //   462: istore 9
    //   464: iload 9
    //   466: istore 8
    //   468: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   471: ifeq +18 -> 489
    //   474: ldc_w 1264
    //   477: iconst_2
    //   478: aload_3
    //   479: invokevirtual 1267	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   482: invokestatic 584	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   485: iload 9
    //   487: istore 8
    //   489: goto -383 -> 106
    //   492: astore_3
    //   493: invokestatic 116	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   496: ifeq -295 -> 201
    //   499: ldc 118
    //   501: iconst_2
    //   502: ldc_w 1269
    //   505: aload_3
    //   506: invokestatic 1271	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   509: goto -308 -> 201
    //   512: iload 4
    //   514: iconst_1
    //   515: iadd
    //   516: istore 4
    //   518: goto -226 -> 292
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	521	0	this	anwo
    //   0	521	1	paramToServiceMsg	ToServiceMsg
    //   0	521	2	paramFromServiceMsg	FromServiceMsg
    //   0	521	3	paramObject	Object
    //   96	421	4	i	int
    //   226	184	5	j	int
    //   222	71	6	k	int
    //   287	14	7	m	int
    //   59	429	8	bool1	boolean
    //   27	459	9	bool2	boolean
    //   110	327	10	l1	long
    //   116	326	12	l2	long
    //   73	331	14	localObject	Object
    //   334	32	15	localHashSet	HashSet
    // Exception table:
    //   from	to	target	type
    //   66	98	460	java/lang/Exception
    //   178	201	492	java/lang/NumberFormatException
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.d(paramString);
    ((anws)this.app.getManager(53)).c(paramString);
    this.app.a().a(paramString, 3000);
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
    anws localanws = (anws)this.app.getManager(53);
    DiscussionInfo localDiscussionInfo = localanws.a(paramString1);
    if (localDiscussionInfo != null)
    {
      localDiscussionInfo.discussionName = paramString2;
      localDiscussionInfo.DiscussionFlag &= 0xFFFFFFBF;
      localanws.a(localDiscussionInfo);
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
      localObject2 = (anws)this.app.getManager(53);
      localObject1 = ((anws)localObject2).a(paramArrayList);
      if (localObject1 != null)
      {
        notifyUI(1002, true, new Object[] { Long.valueOf(Long.parseLong(((DiscussionInfo)localObject1).uin)), ((DiscussionInfo)localObject1).discussionName, Integer.valueOf(0) });
        localObject3 = ((anws)localObject2).a(((DiscussionInfo)localObject1).uin);
        localObject2 = new ArrayList();
        paramString = null;
        i = 0;
        if (i < ((ArrayList)localObject3).size())
        {
          localObject4 = (DiscussionMemberInfo)((ArrayList)localObject3).get(i);
          if (localObject4 != null) {
            if (((DiscussionMemberInfo)localObject4).memberUin != null)
            {
              paramInt = 0;
              if (((DiscussionMemberInfo)localObject4).memberUin.equals(((DiscussionInfo)localObject1).inheritOwnerUin))
              {
                paramInt = 1;
                label157:
                if (paramInt == 0) {
                  break label221;
                }
                paramString = new DiscussionMemberInfo();
                paramString.memberUin = ((DiscussionMemberInfo)localObject4).memberUin;
                paramString.memberName = bhlg.a((DiscussionMemberInfo)localObject4, this.app);
              }
            }
          }
          for (;;)
          {
            i += 1;
            break;
            if (!((DiscussionMemberInfo)localObject4).memberUin.equals(((DiscussionInfo)localObject1).ownerUin)) {
              break label157;
            }
            paramInt = 1;
            break label157;
            label221:
            if (!((DiscussionMemberInfo)localObject4).memberUin.equalsIgnoreCase(this.app.getCurrentAccountUin()))
            {
              localObject5 = new DiscussionMemberInfo();
              ((DiscussionMemberInfo)localObject5).memberUin = ((DiscussionMemberInfo)localObject4).memberUin;
              ((DiscussionMemberInfo)localObject5).memberName = bhlg.a((DiscussionMemberInfo)localObject4, this.app);
              ((DiscussionMemberInfo)localObject5).discussionUin = ChnToSpell.a(((DiscussionMemberInfo)localObject5).memberName, 1);
              ((List)localObject2).add(localObject5);
            }
          }
        }
        Collections.sort((List)localObject2, new anvr());
        if (paramString != null) {
          ((List)localObject2).add(0, paramString);
        }
        paramString = new StringBuffer();
        paramString.append("你与");
        paramInt = 0;
        while ((paramInt < ((List)localObject2).size()) && (paramInt < 3))
        {
          localObject3 = (DiscussionMemberInfo)((List)localObject2).get(paramInt);
          if (!((DiscussionMemberInfo)localObject3).memberUin.equalsIgnoreCase(this.app.getCurrentAccountUin()))
          {
            paramString.append(((DiscussionMemberInfo)localObject3).memberName);
            paramString.append("、");
          }
          paramInt += 1;
        }
        paramString.deleteCharAt(paramString.length() - 1);
        if (((List)localObject2).size() > 3) {
          paramString.append("等");
        }
        paramString.append(paramArrayList.size());
        paramString.append("个成员已有该多人聊天。");
        paramArrayList = this.app.getCurrentAccountUin();
        paramString = new avpd(((DiscussionInfo)localObject1).uin, paramArrayList, paramString.toString(), 3000, -5040, 65560, bcrg.a());
        paramArrayList = new MessageForUniteGrayTip();
        paramArrayList.initGrayTipMsg(this.app, paramString);
        avpe.a(this.app, paramArrayList);
      }
    }
    else
    {
      return;
    }
    Object localObject1 = createToServiceMsg("QQServiceDiscussSvc.ReqCreateDiscuss");
    int j = paramArrayList.size();
    Object localObject2 = new long[j];
    Object localObject3 = new int[j];
    Object localObject4 = new long[j];
    Object localObject5 = new String[j];
    int i = 0;
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
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "--->>create discuss name: " + paramString + " req: " + localObject1);
    }
    send((ToServiceMsg)localObject1);
  }
  
  public void a(String paramString, HashSet<String> paramHashSet)
  {
    if ((paramString == null) || (paramHashSet == null) || (paramHashSet.size() == 0)) {
      return;
    }
    anws localanws = (anws)this.app.getManager(53);
    DiscussionInfo localDiscussionInfo = localanws.a(paramString);
    if (localDiscussionInfo != null) {
      localDiscussionInfo.DiscussionFlag |= 0x20000000;
    }
    localanws.a(paramString, paramHashSet);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (this.app.a.c())
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
  
  public void a(@NonNull Collection<anwr> paramCollection)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscussInfo" + paramCollection.size());
    }
    for (;;)
    {
      anwr localanwr;
      synchronized (this.jdField_b_of_type_JavaUtilLinkedHashMap)
      {
        paramCollection = paramCollection.iterator();
        if (!paramCollection.hasNext()) {
          break;
        }
        localanwr = (anwr)paramCollection.next();
        if ((!this.jdField_b_of_type_JavaUtilLinkedHashMap.containsKey(localanwr.jdField_a_of_type_JavaLangString)) && (!this.jdField_a_of_type_JavaUtilLinkedHashMap.containsKey(localanwr.jdField_a_of_type_JavaLangString)) && (localanwr.jdField_a_of_type_Int <= 1)) {
          this.jdField_b_of_type_JavaUtilLinkedHashMap.put(localanwr.jdField_a_of_type_JavaLangString, localanwr);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "getDiscussionInfo2 filtered " + localanwr.jdField_a_of_type_JavaLangString);
      }
    }
    c();
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    notifyUI(1007, paramBoolean1, Pair.create(Boolean.valueOf(paramBoolean2), paramString));
  }
  
  public void a(String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    NewIntent localNewIntent = new NewIntent(this.app.getApp(), anwu.class);
    localNewIntent.putExtra("key_cmd", 0);
    localNewIntent.putExtra("field_id", paramArrayOfString1);
    localNewIntent.putExtra("uin_list", paramArrayOfString2);
    this.app.startServlet(localNewIntent);
  }
  
  public boolean a(long paramLong)
  {
    return paramLong > 1000000L;
  }
  
  public boolean a(DiscussionInfo paramDiscussionInfo)
  {
    paramDiscussionInfo = (RecentUser)this.app.a().a().findRecentUserByUin(paramDiscussionInfo.uin, 3000);
    if (paramDiscussionInfo == null) {
      return false;
    }
    if (paramDiscussionInfo.showUpTime != 0L) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  public boolean a(ArrayList<DiscussInfo> paramArrayList)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("addOrUpdateDiscussion ");
      if (paramArrayList == null) {
        break label57;
      }
    }
    long l;
    label57:
    for (int i = paramArrayList.size();; i = -1)
    {
      QLog.d("Q.contacttab.dscs", 2, i);
      l = System.currentTimeMillis();
      if (paramArrayList != null) {
        break;
      }
      return true;
    }
    Object localObject2;
    anws localanws;
    DiscussionInfo localDiscussionInfo;
    try
    {
      localObject2 = this.app.getPreferences();
      localObject1 = "DiscusstionIconVersion" + this.app.getCurrentAccountUin();
      i = ((SharedPreferences)localObject2).getInt((String)localObject1, -1);
      DiscussInfo localDiscussInfo;
      if (i != 1)
      {
        localObject2 = ((SharedPreferences)localObject2).edit();
        ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, 1);
        ((SharedPreferences.Editor)localObject2).commit();
        if (i != -1) {
          try
          {
            localObject1 = new String[2];
            localObject1[0] = antf.bM;
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
                    if (QLog.isColorLevel()) {
                      QLog.d("DiscussionHandler", 2, "del discussion icon. name=" + localDiscussInfo.getName() + "," + localDiscussInfo.lastModified());
                    }
                  }
                  j += 1;
                }
              }
              i += 1;
            }
            localanws = (anws)this.app.getManager(53);
          }
          catch (Exception localException)
          {
            localException.printStackTrace();
          }
        }
      }
      localObject2 = new ArrayList();
      paramArrayList = paramArrayList.iterator();
      for (;;)
      {
        if (!paramArrayList.hasNext()) {
          break label509;
        }
        localDiscussInfo = (DiscussInfo)paramArrayList.next();
        localDiscussionInfo = localanws.a(String.valueOf(localDiscussInfo.DiscussUin));
        if (localDiscussionInfo != null) {
          break;
        }
        localDiscussionInfo = new DiscussionInfo();
        localDiscussionInfo.uin = String.valueOf(localDiscussInfo.DiscussUin);
        localDiscussionInfo.infoSeq = -1L;
        localDiscussionInfo.timeSec = l;
        a(Long.parseLong(localDiscussionInfo.uin));
        ((ArrayList)localObject2).add(localDiscussionInfo);
      }
      if (localDiscussionInfo.infoSeq == localDiscussInfo.InfoSeq) {
        break label498;
      }
    }
    catch (Exception paramArrayList)
    {
      paramArrayList.printStackTrace();
      return false;
    }
    a(Long.parseLong(localDiscussionInfo.uin));
    for (;;)
    {
      localDiscussionInfo.timeSec = l;
      break;
      label498:
      ((ArrayList)localObject2).add(localDiscussionInfo);
    }
    label509:
    boolean bool = localanws.a((ArrayList)localObject2, l, true);
    return bool;
  }
  
  public boolean a(@NonNull ArrayList<DiscussionInfo> paramArrayList, @NonNull ArrayList<String> paramArrayList1)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "addOrUpdateDiscussionWithCollectData" + paramArrayList.size() + ", " + paramArrayList1.size());
    }
    long l = System.currentTimeMillis();
    Object localObject2;
    Object localObject3;
    anws localanws;
    DiscussionInfo localDiscussionInfo;
    for (;;)
    {
      try
      {
        localObject2 = this.app.getPreferences();
        Object localObject1 = "DiscusstionIconVersion" + this.app.getCurrentAccountUin();
        int i = ((SharedPreferences)localObject2).getInt((String)localObject1, -1);
        if (i != 1)
        {
          localObject2 = ((SharedPreferences)localObject2).edit();
          ((SharedPreferences.Editor)localObject2).putInt((String)localObject1, 1);
          ((SharedPreferences.Editor)localObject2).commit();
          if (i != -1) {
            try
            {
              localObject1 = new String[2];
              localObject1[0] = antf.bM;
              localObject1[1] = "/data/data/com.tencent.mobileqq/files/head/_hd/";
              int k = localObject1.length;
              i = 0;
              if (i < k)
              {
                localObject2 = new File(localObject1[i]);
                if ((((File)localObject2).exists()) && (((File)localObject2).isDirectory()))
                {
                  localObject2 = ((File)localObject2).listFiles();
                  int m = localObject2.length;
                  int j = 0;
                  if (j < m)
                  {
                    localObject3 = localObject2[j];
                    if (((File)localObject3).getName().startsWith("discussion_"))
                    {
                      ((File)localObject3).delete();
                      if (QLog.isColorLevel()) {
                        QLog.d("DiscussionHandler", 2, "del discussion icon. name=" + ((File)localObject3).getName() + "," + ((File)localObject3).lastModified());
                      }
                    }
                    j += 1;
                    continue;
                  }
                }
                i += 1;
                continue;
              }
              localanws = (anws)this.app.getManager(53);
            }
            catch (Exception localException)
            {
              localException.printStackTrace();
            }
          }
        }
        localObject2 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        if (!paramArrayList.hasNext()) {
          break label592;
        }
        localObject3 = (DiscussionInfo)paramArrayList.next();
        localDiscussionInfo = localanws.a(((DiscussionInfo)localObject3).uin);
        if (localDiscussionInfo != null) {
          break;
        }
        localDiscussionInfo = new DiscussionInfo();
        localDiscussionInfo.uin = ((DiscussionInfo)localObject3).uin;
        localDiscussionInfo.infoSeq = -1L;
        localDiscussionInfo.timeSec = l;
        if (paramArrayList1.contains(((DiscussionInfo)localObject3).uin))
        {
          localDiscussionInfo.hasCollect = true;
          localObject3 = new anwr();
          ((anwr)localObject3).jdField_a_of_type_JavaLangString = localDiscussionInfo.uin;
          ((anwr)localObject3).b = localDiscussionInfo.mUnreliableMemberCount;
          a((anwr)localObject3);
        }
        else
        {
          localDiscussionInfo.hasCollect = false;
        }
      }
      catch (Exception paramArrayList)
      {
        paramArrayList.printStackTrace();
        return false;
      }
    }
    if (paramArrayList1.contains(((DiscussionInfo)localObject3).uin))
    {
      localDiscussionInfo.hasCollect = true;
      label513:
      if (localDiscussionInfo.infoSeq == ((DiscussionInfo)localObject3).infoSeq) {
        break label581;
      }
      localObject3 = new anwr();
      ((anwr)localObject3).jdField_a_of_type_JavaLangString = localDiscussionInfo.uin;
      ((anwr)localObject3).b = localDiscussionInfo.mUnreliableMemberCount;
      a((anwr)localObject3);
    }
    for (;;)
    {
      localDiscussionInfo.timeSec = l;
      break;
      localDiscussionInfo.hasCollect = false;
      break label513;
      label581:
      ((ArrayList)localObject2).add(localDiscussionInfo);
    }
    label592:
    boolean bool = localanws.a((ArrayList)localObject2, l, false);
    return bool;
  }
  
  public void b()
  {
    if ((this.app.a.c()) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty()))
    {
      int i = 0;
      if (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        if ((localPair == null) || (localPair.first == null) || (localPair.second == null)) {}
        for (;;)
        {
          i += 1;
          break;
          if (((Boolean)localPair.first).booleanValue()) {
            a((String)localPair.second, false);
          } else {
            this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.b((String)localPair.second);
          }
        }
      }
      this.jdField_a_of_type_JavaUtilArrayList = null;
    }
  }
  
  public void b(long paramLong)
  {
    if (((anws)this.app.getManager(53)).a(paramLong + "") == null) {
      a(paramLong);
    }
  }
  
  public void b(long paramLong1, long paramLong2)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2149);
    localOIDBSSOPkg.uint32_service_type.set(3);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(bhjx.a(paramLong1)).putShort((short)1).putInt(bhjx.a(paramLong2));
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
      DiscussionInfo localDiscussionInfo = ((anws)this.app.getManager(53)).a(String.valueOf(paramLong));
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
    boolean bool3 = true;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleCollectDisucssionResp");
    }
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin"));
      if (!bool1) {
        break label198;
      }
    }
    label198:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = bool3;
        if (bool1)
        {
          paramFromServiceMsg = (anws)this.app.getManager(53);
          paramObject = paramFromServiceMsg.a(String.valueOf(paramToServiceMsg));
          if (paramObject != null)
          {
            long l = System.currentTimeMillis();
            paramObject.hasCollect = true;
            paramObject.timeSec = l;
            paramFromServiceMsg.a(paramObject);
            paramFromServiceMsg.b(paramObject);
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("handleCollectDisucssionResp", 2, paramFromServiceMsg.getMessage());
        bool1 = bool2;
        continue;
      }
      notifyUI(1016, bool1, paramToServiceMsg);
      return;
      bool1 = false;
      break;
      bool1 = false;
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
    cmd0x921.ReqBody localReqBody = new cmd0x921.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    try
    {
      cmd0x921.GetAtAllRemain localGetAtAllRemain = new cmd0x921.GetAtAllRemain();
      localGetAtAllRemain.uint64_uin.set(Long.parseLong(paramString1));
      localGetAtAllRemain.uint64_discuss_uin.set(Long.parseLong(paramString2));
      localReqBody.msg_get_at_all_remain.set(localGetAtAllRemain);
      paramString1 = makeOIDBPkg("OidbSvc.0x921_0", 2337, 0, localReqBody.toByteArray());
      paramString1.extraData.putString("discUid", paramString2);
      sendPbReq(paramString1);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("DiscussionHandler", 2, "getAnonymousChatNick error, NumberFormatException, uin : " + paramString1 + ", discUin : " + paramString2);
    }
  }
  
  public void c()
  {
    ArrayList localArrayList = new ArrayList(50);
    synchronized (this.jdField_b_of_type_JavaUtilLinkedHashMap)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "startGetDiscussionInfoWorkV2, discussionUinListofGetinfo[" + this.jdField_b_of_type_JavaUtilLinkedHashMap.size() + "], mGettingDiscussUins[" + this.jdField_a_of_type_JavaUtilLinkedHashMap.size() + "]");
      }
      if (this.jdField_b_of_type_JavaUtilLinkedHashMap.size() == 0) {
        return;
      }
      if (this.jdField_a_of_type_JavaUtilLinkedHashMap.size() >= 100) {
        return;
      }
    }
    Object localObject2 = (anws)this.app.getManager(53);
    Object localObject3 = this.jdField_b_of_type_JavaUtilLinkedHashMap.entrySet().iterator();
    int i = 0;
    int j = 0;
    int m;
    for (int k = 0; ((Iterator)localObject3).hasNext(); k = m)
    {
      anwr localanwr = (anwr)((Map.Entry)((Iterator)localObject3).next()).getValue();
      if ((localanwr.b + j > 500) || (i >= 50)) {
        break;
      }
      ((Iterator)localObject3).remove();
      DiscussionInfo localDiscussionInfo = ((anws)localObject2).a(localanwr.jdField_a_of_type_JavaLangString);
      m = k;
      if (localDiscussionInfo != null)
      {
        m = k;
        if (k > (int)localDiscussionInfo.timeSec) {
          m = (int)localDiscussionInfo.timeSec;
        }
      }
      this.jdField_a_of_type_JavaUtilLinkedHashMap.put(localanwr.jdField_a_of_type_JavaLangString, localanwr);
      localList.add(Long.valueOf(Long.parseLong(localanwr.jdField_a_of_type_JavaLangString)));
      j += localanwr.b;
      i += 1;
    }
    QLog.d("DiscussionVerify", 2, "updateBatchDiscussInfo dis_cnt=%tu mem_cnt=%tu" + i + " mem_cnt=" + j);
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "startGetDiscussionInfoWorkV2, disUin[" + localList.toString() + "]");
    }
    ??? = new cmd0x58b.ReqBody();
    ((cmd0x58b.ReqBody)???).uint32_subcmd.set(3);
    try
    {
      localObject2 = new cmd0x58b.GetMultiConfInfoReq();
      ((cmd0x58b.GetMultiConfInfoReq)localObject2).uint64_conf_uin.set(localList);
      localObject3 = (anws)this.app.getManager(53);
      ((cmd0x58b.GetMultiConfInfoReq)localObject2).uint32_interemark_timestamp.set(k);
      localObject3 = new cmd0x58b.ConfBaseInfo();
      ((cmd0x58b.ConfBaseInfo)localObject3).bytes_conf_name.set(ByteStringMicro.copyFromUtf8(""));
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_create_time.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint64_owner_uin.set(0L);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_info_seq.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_last_info_time.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_msg_seq.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_last_msg_time.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_member_num.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_flag.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint64_inherit_owner_uin.set(0L);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint64_group_code.set(0L);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint64_group_uin.set(0L);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_conf_meeting_origin.set(0);
      ((cmd0x58b.ConfBaseInfo)localObject3).uint32_conf_meeting_option.set(0);
      ((cmd0x58b.GetMultiConfInfoReq)localObject2).msg_conf_base_info.set((MessageMicro)localObject3);
      localObject3 = new cmd0x58b.ConfMemberInfo();
      ((cmd0x58b.ConfMemberInfo)localObject3).uint32_join_time.set(0);
      ((cmd0x58b.ConfMemberInfo)localObject3).uint32_flag.set(0);
      ((cmd0x58b.ConfMemberInfo)localObject3).uint32_read_msg_seq.set(0);
      ((cmd0x58b.ConfMemberInfo)localObject3).bytes_member_interemark.set(ByteStringMicro.copyFromUtf8(""));
      ((cmd0x58b.ConfMemberInfo)localObject3).uint32_interemark_source.set(0);
      ((cmd0x58b.GetMultiConfInfoReq)localObject2).msg_conf_mem_info.set((MessageMicro)localObject3);
      ((cmd0x58b.ReqBody)???).msg_get_multi_conf_info.set((MessageMicro)localObject2);
      ??? = makeOIDBPkg("OidbSvc.0x58b_0", 1419, 0, ((cmd0x58b.ReqBody)???).toByteArray());
      ((ToServiceMsg)???).extraData.putSerializable("discussUin", localList);
      sendPbReq((ToServiceMsg)???);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.e("DiscussionHandler", 2, "startGetDiscussionInfoWorkV2 disUin:" + localList.toString() + " error:" + localException.toString());
        }
      }
    }
  }
  
  public void c(long paramLong)
  {
    if (a(paramLong))
    {
      ToServiceMsg localToServiceMsg = createToServiceMsg("QQServiceDiscussSvc.ReqQuitDiscuss");
      localToServiceMsg.extraData.putLong("discussUin", paramLong);
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "--->>quit discuss uin: " + paramLong);
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
    boolean bool3 = true;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleUncollectDisucssionResp");
    }
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      paramToServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("dwConfUin"));
      if (!bool1) {
        break label198;
      }
    }
    label198:
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = bool3;
        if (bool1)
        {
          paramFromServiceMsg = (anws)this.app.getManager(53);
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
      }
      catch (Exception paramFromServiceMsg)
      {
        bool1 = bool2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("handleUncollectDisucssionResp", 2, paramFromServiceMsg.getMessage());
        bool1 = bool2;
        continue;
      }
      notifyUI(1017, bool1, paramToServiceMsg);
      return;
      bool1 = false;
      break;
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
    ((ByteBuffer)localObject).putInt(bhjx.a(paramLong)).putInt(0).putShort((short)4).putInt(bhjx.a(paramLong));
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
    paramObject = localDiscussGetUrlResponse;
    long l1 = l2;
    if (paramFromServiceMsg != null)
    {
      paramObject = localDiscussGetUrlResponse;
      l1 = l2;
      if (!paramFromServiceMsg.isSuccess()) {}
    }
    try
    {
      paramFromServiceMsg = (FlyTicket.DiscussGetUrlResponse)localDiscussGetUrlResponse.mergeFrom(paramFromServiceMsg.getWupBuffer());
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.ret_info.get() != null))
      {
        l1 = ((FlyTicket.RetInfo)paramFromServiceMsg.ret_info.get()).ret_code.get();
        paramObject = paramFromServiceMsg;
        l2 = paramToServiceMsg.extraData.getLong("discussUin");
        if (l1 == 0L)
        {
          bool = true;
          notifyUI(1011, bool, new Object[] { String.valueOf(l1), paramObject, Long.valueOf(l2) });
          return;
        }
      }
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
        continue;
        boolean bool = false;
        continue;
        paramObject = paramFromServiceMsg;
        l1 = l2;
      }
    }
  }
  
  public void e(long paramLong)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2160);
    localOIDBSSOPkg.uint32_service_type.set(5);
    Object localObject = ByteBuffer.allocate(20);
    ((ByteBuffer)localObject).putInt(bhjx.a(paramLong)).putInt(0).putShort((short)4).putInt(bhjx.a(paramLong));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x870_5");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putLong("dwConfUin", paramLong);
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  protected void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = null;
    boolean bool2 = false;
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleDecodeFlyTicket");
    }
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
        for (;;)
        {
          paramFromServiceMsg.printStackTrace();
          continue;
          boolean bool1 = false;
        }
      }
      bool1 = bool2;
      if (paramToServiceMsg != null)
      {
        bool1 = bool2;
        if (paramToServiceMsg.ret_info.get() != null)
        {
          if (((FlyTicket.RetInfo)paramToServiceMsg.ret_info.get()).ret_code.get() != 0) {
            break label116;
          }
          bool1 = true;
        }
      }
      notifyUI(1012, bool1, paramToServiceMsg);
      return;
    }
    label116:
    notifyUI(1012, false, null);
  }
  
  public void f(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.dscs", 2, "getDiscuss" + paramLong);
    }
    cmd0x58a.ReqBody localReqBody = new cmd0x58a.ReqBody();
    localReqBody.uint32_subcmd.set(1);
    sendPbReq(makeOIDBPkg("OidbSvc.0x58a", 1418, 0, localReqBody.toByteArray()));
  }
  
  protected void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l2 = -1L;
    DiscussRespHeader localDiscussRespHeader = null;
    paramToServiceMsg = localDiscussRespHeader;
    long l1 = l2;
    if (paramFromServiceMsg != null)
    {
      paramToServiceMsg = localDiscussRespHeader;
      l1 = l2;
      if (paramFromServiceMsg.isSuccess())
      {
        paramToServiceMsg = localDiscussRespHeader;
        l1 = l2;
        if (paramObject != null)
        {
          paramToServiceMsg = (bcql)paramObject;
          localDiscussRespHeader = (DiscussRespHeader)paramToServiceMsg.jdField_a_of_type_JavaLangObject;
          paramObject = (RespGetDiscussInfo)paramToServiceMsg.b;
          paramToServiceMsg = paramObject;
          l1 = l2;
          if (localDiscussRespHeader != null)
          {
            l1 = localDiscussRespHeader.Result;
            paramToServiceMsg = paramObject;
          }
        }
      }
    }
    paramObject = new Object[2];
    paramObject[0] = String.valueOf(l1);
    paramObject[1] = paramToServiceMsg;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (l1 == 0L))
    {
      notifyUI(1013, true, paramObject);
      return;
    }
    notifyUI(1013, false, paramObject);
  }
  
  protected void g(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l2 = -1L;
    this.jdField_b_of_type_Long = 0L;
    long l1;
    long l3;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (bcql)paramObject;
      paramToServiceMsg = (DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject;
      paramObject = (RespJoinDiscuss)paramObject.b;
      if (paramToServiceMsg != null)
      {
        l1 = paramToServiceMsg.Result;
        if (paramObject != null)
        {
          l3 = paramObject.DiscussUin;
          l2 = l1;
          l1 = l3;
        }
      }
    }
    for (;;)
    {
      paramToServiceMsg = new Long[2];
      paramToServiceMsg[0] = Long.valueOf(l2);
      paramToServiceMsg[1] = Long.valueOf(l1);
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (l2 == 0L) && (l1 > 0L))
      {
        notifyUI(1014, true, paramToServiceMsg);
        return;
      }
      notifyUI(1014, false, paramToServiceMsg);
      return;
      l3 = -1L;
      l2 = l1;
      l1 = l3;
      continue;
      l1 = -1L;
      break;
      l1 = -1L;
    }
  }
  
  protected void h(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramFromServiceMsg = Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    paramToServiceMsg = Byte.valueOf(paramToServiceMsg.extraData.getByte("infoflag"));
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "handleSetDiscussFlagResp dis=" + paramFromServiceMsg + " flag=" + paramToServiceMsg);
    }
    paramObject = (anws)this.app.getManager(53);
    paramFromServiceMsg = paramObject.a(String.valueOf(paramFromServiceMsg), this.app.getCurrentAccountUin());
    if (paramFromServiceMsg != null)
    {
      paramFromServiceMsg.flag = paramToServiceMsg.byteValue();
      paramObject.a(paramFromServiceMsg);
    }
  }
  
  protected void i(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handle set discuss attr req: " + paramToServiceMsg + " ~~resp: " + paramFromServiceMsg + " ~~ data: " + paramObject);
    }
  }
  
  protected void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleQuitDiscussResp");
    }
    paramObject = (bcql)paramObject;
    Object localObject = (RespQuitDiscuss)paramObject.b;
    localObject = (DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject;
    String str1 = String.valueOf(paramToServiceMsg.extraData.getLong("discussUin"));
    int i = ((DiscussRespHeader)localObject).Result;
    String str2 = ((DiscussRespHeader)localObject).ResultDesc;
    if (((DiscussRespHeader)localObject).Result != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.w("DiscussionHandler", 2, "header failed! failed code: " + ((DiscussRespHeader)localObject).Result);
      }
      notifyUI(2000, true, new Object[] { str1, Integer.valueOf(i), str2 });
      notifyUI(1004, false, str1);
      return;
    }
    if ((!paramFromServiceMsg.isSuccess()) || (!paramObject.jdField_a_of_type_Boolean))
    {
      notifyUI(1004, false, str1);
      return;
    }
    a(str1);
    paramFromServiceMsg = new ArrayList();
    paramFromServiceMsg.add(this.app.getCurrentAccountUin());
    a(paramToServiceMsg.extraData.getLong("discussUin"), this.app.getCurrentAccountUin(), paramFromServiceMsg, 10009);
  }
  
  protected void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    try
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = new anwq(this, paramToServiceMsg).a();
        if (!paramToServiceMsg.a()) {
          break label123;
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("Q.contacttab.dscs", 2, "merge fail " + paramToServiceMsg.toString());
        }
        notifyUI(1000, false, null);
        return;
      }
      notifyUI(1000, bool, null);
    }
    catch (Exception paramToServiceMsg)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussRespV2 excep", paramToServiceMsg);
      }
      bool = false;
    }
    for (;;)
    {
      return;
      label123:
      bool = a(false, paramToServiceMsg.a(), paramToServiceMsg.b());
    }
  }
  
  protected void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleChangeDiscussNameResp");
    }
    paramObject = (bcql)paramObject;
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
      paramObject = (anws)this.app.getManager(53);
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
    paramObject = (bcql)paramObject;
    arrayOfObject[2] = Integer.valueOf(((DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject).Result);
    if ((!paramFromServiceMsg.isSuccess()) || (!paramObject.jdField_a_of_type_Boolean))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "create discussion fail, result code: " + paramFromServiceMsg.getResultCode() + " errMsg: " + paramFromServiceMsg.getBusinessFailMsg() + " respPackage.bSuccess: " + paramObject.jdField_a_of_type_Boolean);
      }
      notifyUI(1002, false, arrayOfObject);
      return;
    }
    paramFromServiceMsg = (RespCreateDiscuss)paramObject.b;
    if (!a(paramFromServiceMsg.DiscussUin))
    {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "create discussion fail: invalid discussion uin");
      }
      notifyUI(1002, false, arrayOfObject);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "create discussion succeeded " + paramFromServiceMsg.DiscussUin);
    }
    paramObject = (anyw)this.app.getManager(51);
    anws localanws = (anws)this.app.getManager(53);
    Object localObject2 = new DiscussionInfo();
    ((DiscussionInfo)localObject2).uin = String.valueOf(paramFromServiceMsg.DiscussUin);
    ((DiscussionInfo)localObject2).discussionName = paramToServiceMsg.extraData.getString("name");
    ((DiscussionInfo)localObject2).infoSeq = -1L;
    ((DiscussionInfo)localObject2).createFrom = paramToServiceMsg.extraData.getInt("from", 0);
    ((DiscussionInfo)localObject2).uiControlFlag = paramToServiceMsg.extraData.getLong("uiControlFlag", 0L);
    if (((DiscussionInfo)localObject2).isUIControlFlag_Hidden_RecentUser())
    {
      localObject1 = localanws.a(((DiscussionInfo)localObject2).uin);
      if (localObject1 != null)
      {
        int j = ((ArrayList)localObject1).size();
        i = 0;
        if (i < j)
        {
          localObject3 = (DiscussionMemberInfo)((ArrayList)localObject1).get(i);
          if (localObject3 == null) {
            break label633;
          }
          localObject3 = ((DiscussionMemberInfo)localObject3).memberUin;
          if ((TextUtils.isEmpty((CharSequence)localObject3)) || (((String)localObject3).equals(this.app.getCurrentAccountUin()))) {
            break label633;
          }
          ((DiscussionInfo)localObject2).removeUIControlFlag_Hidden_RecentUser();
          if (QLog.isDevelopLevel()) {
            QLog.d("DiscussionHandler", 4, "不是单人多人聊天");
          }
        }
      }
    }
    Object localObject1 = paramFromServiceMsg.AddResult;
    Object localObject3 = new anwr();
    ((anwr)localObject3).jdField_a_of_type_JavaLangString = String.valueOf(paramFromServiceMsg.DiscussUin);
    ((anwr)localObject3).b = ((Map)localObject1).size();
    localanws.a((DiscussionInfo)localObject2);
    a((anwr)localObject3);
    localObject3 = ((Map)localObject1).keySet();
    localObject2 = new ArrayList();
    localObject3 = ((Set)localObject3).iterator();
    int i = 0;
    label503:
    DiscussionMemberInfo localDiscussionMemberInfo;
    if (((Iterator)localObject3).hasNext())
    {
      Object localObject4 = (Long)((Iterator)localObject3).next();
      if (((Integer)((Map)localObject1).get(localObject4)).intValue() != 0) {
        break label708;
      }
      localDiscussionMemberInfo = new DiscussionMemberInfo();
      localDiscussionMemberInfo.discussionUin = String.valueOf(paramFromServiceMsg.DiscussUin);
      localDiscussionMemberInfo.memberUin = String.valueOf(localObject4);
      localDiscussionMemberInfo.flag = 0;
      localObject4 = paramObject.b(localDiscussionMemberInfo.memberUin);
      if ((localObject4 != null) && (((Friends)localObject4).isFriend()))
      {
        localDiscussionMemberInfo.memberName = ((Friends)localObject4).name;
        label614:
        ((List)localObject2).add(localDiscussionMemberInfo);
        i += 1;
      }
    }
    label708:
    for (;;)
    {
      break label503;
      label633:
      i += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqAppFriendListHandler.b(localDiscussionMemberInfo.memberUin);
      break label614;
      localanws.b((List)localObject2);
      arrayOfObject[0] = Long.valueOf(paramFromServiceMsg.DiscussUin);
      arrayOfObject[1] = paramToServiceMsg.extraData.getString("name");
      arrayOfObject[2] = Integer.valueOf(0);
      notifyUI(1002, true, arrayOfObject);
      return;
    }
  }
  
  protected boolean msgCmdFilter(String paramString)
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
    return !this.allowCmdSet.contains(paramString);
  }
  
  protected void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, "<<---handleAddDiscussMemberResp");
    }
    paramObject = (bcql)paramObject;
    RespAddDiscussMember localRespAddDiscussMember = (RespAddDiscussMember)paramObject.b;
    Object localObject1 = (DiscussRespHeader)paramObject.jdField_a_of_type_JavaLangObject;
    Object localObject2 = String.valueOf(Long.valueOf(paramToServiceMsg.extraData.getLong("discussUin")));
    int i = ((DiscussRespHeader)localObject1).Result;
    paramToServiceMsg = ((DiscussRespHeader)localObject1).ResultDesc;
    if (((DiscussRespHeader)localObject1).Result != 0)
    {
      notifyUI(2000, true, new Object[] { localObject2, Integer.valueOf(i), paramToServiceMsg });
      return;
    }
    paramToServiceMsg = new Object[3];
    paramToServiceMsg[0] = localObject2;
    paramToServiceMsg[1] = Integer.valueOf(((DiscussRespHeader)localObject1).Result);
    if ((!paramFromServiceMsg.isSuccess()) || (!paramObject.jdField_a_of_type_Boolean))
    {
      paramToServiceMsg[2] = null;
      notifyUI(1003, false, paramToServiceMsg);
      return;
    }
    paramFromServiceMsg = (anyw)this.app.getManager(51);
    localObject1 = (anws)this.app.getManager(53);
    localObject2 = ((anws)localObject1).a((String)localObject2);
    if (localObject2 == null)
    {
      paramToServiceMsg[0] = String.valueOf(localRespAddDiscussMember.DiscussUin);
      notifyUI(1003, false, paramToServiceMsg);
      return;
    }
    Object localObject3 = ((DiscussionInfo)localObject2).faceUinSet;
    int j = 0;
    i = j;
    if (localObject3 != null)
    {
      i = j;
      if (!((String)localObject3).trim().equals("")) {
        i = ((String)localObject3).split(";").length;
      }
    }
    Set localSet;
    ArrayList localArrayList1;
    ArrayList localArrayList2;
    StringBuffer localStringBuffer;
    Iterator localIterator;
    if (4 - i > 0)
    {
      i = 1;
      localObject3 = localRespAddDiscussMember.AddResult;
      localSet = ((Map)localObject3).keySet();
      localArrayList1 = new ArrayList(localSet.size());
      localArrayList2 = new ArrayList();
      localStringBuffer = new StringBuffer();
      localIterator = localSet.iterator();
    }
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label589;
      }
      Long localLong = (Long)localIterator.next();
      j = ((Integer)((Map)localObject3).get(localLong)).intValue();
      if (QLog.isColorLevel())
      {
        localStringBuffer.append("discussUin: " + localRespAddDiscussMember.DiscussUin + " memberUin: " + localLong.longValue() + " value: " + j);
        localStringBuffer.append("\n");
      }
      if (j != 0)
      {
        if (localSet.size() != 1) {
          continue;
        }
        a(j);
        continue;
        i = 0;
        break;
      }
      DiscussionMemberInfo localDiscussionMemberInfo = new DiscussionMemberInfo();
      localDiscussionMemberInfo.discussionUin = String.valueOf(localRespAddDiscussMember.DiscussUin);
      localDiscussionMemberInfo.memberUin = String.valueOf(localLong);
      localDiscussionMemberInfo.flag = 0;
      Friends localFriends = paramFromServiceMsg.e(localLong + "");
      if ((localFriends != null) && (localFriends.name != null)) {
        localDiscussionMemberInfo.memberName = localFriends.name;
      }
      localArrayList1.add(String.valueOf(localLong));
      localArrayList2.add(localDiscussionMemberInfo);
    }
    label589:
    if (QLog.isColorLevel()) {
      QLog.d("DiscussionHandler", 2, localStringBuffer.toString());
    }
    a(localRespAddDiscussMember.DiscussUin, this.app.getCurrentAccountUin(), localArrayList1, 1);
    ((DiscussionInfo)localObject2).DiscussionFlag |= 0x20000000;
    ((anws)localObject1).b(localArrayList2);
    if (i != 0) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.c(((DiscussionInfo)localObject2).uin);
    }
    paramToServiceMsg[2] = paramObject.b;
    notifyUI(1003, true, paramToServiceMsg);
  }
  
  void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = 0L;
    Object localObject = null;
    int j = 0;
    if (paramToServiceMsg == null)
    {
      paramToServiceMsg = "" + "req为空, ";
      i = -1;
      paramFromServiceMsg = (FromServiceMsg)localObject;
    }
    for (;;)
    {
      if ((i == 0) && (!TextUtils.isEmpty(paramFromServiceMsg)))
      {
        paramObject = (anws)this.app.getManager(53);
        localObject = paramObject.a(paramFromServiceMsg);
        if ((localObject != null) && (((DiscussionInfo)localObject).getHrExtra() != j))
        {
          ((DiscussionInfo)localObject).mOriginExtra &= 0xFFFFFFFC;
          ((DiscussionInfo)localObject).mOriginExtra |= j & 0x3;
          paramObject.a((DiscussionInfo)localObject);
          bhoq.a("handle_0x44c_rsp", this.app, (DiscussionInfo)localObject);
          bhoq.a(this.app, paramFromServiceMsg);
        }
      }
      QLog.w("DiscussionHandler", 1, "handle_0x44c_rsp, debugSeq[" + l + "], strDiscUin[" + paramFromServiceMsg + "], discHrExtraValue[" + j + "], " + paramToServiceMsg);
      return;
      l = paramToServiceMsg.extraData.getLong("debugSeq");
      localObject = paramToServiceMsg.extraData.getString("uin");
      j = paramToServiceMsg.extraData.getInt("value");
      if (paramFromServiceMsg == null)
      {
        paramToServiceMsg = "" + "res为空, ";
        i = -1;
        paramFromServiceMsg = (FromServiceMsg)localObject;
      }
      else
      {
        paramToServiceMsg = "" + "isSuccess[" + paramFromServiceMsg.isSuccess() + "], reqAppSeq[" + paramToServiceMsg.getAppSeq() + "], reqSsoSeq[" + paramToServiceMsg.getRequestSsoSeq() + "], resAppSeq[" + paramFromServiceMsg.getAppSeq() + "], resSsoSeq[" + paramFromServiceMsg.getRequestSsoSeq() + "], ";
        if (paramObject == null)
        {
          paramToServiceMsg = paramToServiceMsg + "data为空, ";
          i = -1;
          paramFromServiceMsg = (FromServiceMsg)localObject;
        }
        else
        {
          paramObject = (cmd0x44c.RspBody)decodeOidb("DiscussionHandler", (byte[])paramObject, cmd0x44c.RspBody.class);
          if (paramObject != null) {
            break;
          }
          paramToServiceMsg = paramToServiceMsg + "rspBody为空, ";
          i = -1;
          paramFromServiceMsg = (FromServiceMsg)localObject;
        }
      }
    }
    int i = paramObject.uint32_code.get();
    paramFromServiceMsg = new StringBuilder().append(paramToServiceMsg).append("uint32_code[").append(i).append("], bytes_err_msg[");
    if (paramObject.bytes_err_msg.get() != null) {}
    for (paramToServiceMsg = paramObject.bytes_err_msg.get().toStringUtf8();; paramToServiceMsg = "null")
    {
      paramToServiceMsg = paramToServiceMsg + "]";
      paramFromServiceMsg = (FromServiceMsg)localObject;
      break;
    }
  }
  
  protected Class<? extends anui> observerClass()
  {
    return anwt.class;
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceGroupIconHelper.a();
    }
    super.onDestroy();
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramFromServiceMsg.getServiceCmd();
    if (msgCmdFilter(str)) {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "cmdfilter error=" + str);
      }
    }
    do
    {
      do
      {
        return;
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
        if (!"QQServiceDiscussSvc.ReqGetDiscussInfo".equalsIgnoreCase(str)) {
          break;
        }
      } while (paramToServiceMsg.extraData.getString("signature") == null);
      f(paramToServiceMsg, paramFromServiceMsg, paramObject);
      return;
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
    } while (!"OidbSvc.0x44c".equalsIgnoreCase(str));
    o(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  protected void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("discussUin");
    if (paramToServiceMsg != null)
    {
      i = paramToServiceMsg.size() * 2;
      paramFromServiceMsg = new ArrayList(i);
      if (paramToServiceMsg != null) {
        break label113;
      }
    }
    HashMap localHashMap;
    label113:
    for (int i = 0;; i = paramToServiceMsg.size())
    {
      localHashMap = new HashMap(i);
      a(paramToServiceMsg, paramFromServiceMsg, localHashMap);
      try
      {
        paramToServiceMsg = new anwp(this, (byte[])paramObject, paramFromServiceMsg, localHashMap).a();
        boolean bool = paramToServiceMsg.a();
        if (!bool) {
          break label122;
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        List localList;
        int k;
        anyw localanyw;
        if (!QLog.isColorLevel()) {
          break label548;
        }
        QLog.d("Q.contacttab.dscs", 2, "handleGetDiscussInfoRespV2 excep", paramToServiceMsg);
        notifyUI(1001, false, paramFromServiceMsg);
        return;
        if (paramToServiceMsg.infoSeq != k) {
          break label612;
        }
        a(paramFromServiceMsg, i, str1, localList, l1, l2, m, str2, localanws, paramToServiceMsg);
        if (!paramToServiceMsg.isDiscussHrMeeting()) {
          break label688;
        }
      }
      finally
      {
        String str1;
        cmd0x58b.ConfBaseInfo localConfBaseInfo;
        int j;
        int m;
        long l1;
        long l2;
        String str2;
        anws localanws;
        if (!a()) {
          break label648;
        }
        c();
      }
      i = 0;
      break;
    }
    label122:
    paramObject = paramToServiceMsg.a();
    i = 0;
    label130:
    if (i < paramObject.size())
    {
      paramToServiceMsg = (cmd0x58b.GetConfInfoRsp)paramObject.get(i);
      str1 = String.valueOf(paramToServiceMsg.uint64_conf_uin.get());
      localConfBaseInfo = (cmd0x58b.ConfBaseInfo)paramToServiceMsg.msg_conf_base_info.get();
      localList = paramToServiceMsg.rpt_msg_member_info.get();
      j = paramToServiceMsg.uint32_server_remark_timestamp.get();
      m = localConfBaseInfo.uint32_err_code.get();
      k = localConfBaseInfo.uint32_info_seq.get();
      l1 = localConfBaseInfo.uint32_conf_meeting_origin.get() & 0xFF;
      l2 = localConfBaseInfo.uint32_conf_meeting_option.get() & 0xFFFF;
      a(str1, localConfBaseInfo, j, m, k, l1, l2);
      if (m != 0)
      {
        if (m != 1) {
          break label688;
        }
        localHashMap.remove(str1);
        break label688;
      }
      localHashMap.remove(str1);
      m = localConfBaseInfo.uint32_flag.get();
      str2 = localConfBaseInfo.bytes_conf_name.get().toStringUtf8();
      localanyw = (anyw)this.app.getManager(51);
      localanws = (anws)this.app.getManager(53);
      paramToServiceMsg = localanws.a(str1);
      if (paramToServiceMsg == null)
      {
        paramToServiceMsg = new DiscussionInfo();
        paramToServiceMsg.uin = str1;
        paramToServiceMsg.createTime = localConfBaseInfo.uint32_create_time.get();
        paramToServiceMsg.discussionName = str2;
        paramToServiceMsg.ownerUin = String.valueOf(localConfBaseInfo.uint64_owner_uin.get());
        paramToServiceMsg.inheritOwnerUin = String.valueOf(localConfBaseInfo.uint64_inherit_owner_uin.get());
        paramToServiceMsg.timeSec = j;
        paramToServiceMsg.groupCode = localConfBaseInfo.uint64_group_code.get();
        paramToServiceMsg.groupUin = localConfBaseInfo.uint64_group_uin.get();
        paramToServiceMsg.mOrigin = l1;
        paramToServiceMsg.mOriginExtra = l2;
        l1 = paramToServiceMsg.DiscussionFlag;
        paramToServiceMsg.DiscussionFlag = m;
        paramToServiceMsg.DiscussionFlag = (l1 & 0x20000000 | paramToServiceMsg.DiscussionFlag);
        a(str1, paramToServiceMsg);
      }
    }
    for (;;)
    {
      a(str1, localConfBaseInfo, localList, localanyw, localanws, paramToServiceMsg);
      paramFromServiceMsg.set(i * 2 + 1, Boolean.valueOf(true));
      break label688;
      label548:
      label612:
      notifyUI(1001, true, paramFromServiceMsg);
      label648:
      if (!a()) {
        break;
      }
      c();
      return;
      label688:
      i += 1;
      break label130;
    }
  }
  
  public void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = System.currentTimeMillis();
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember req or res is null!");
      }
    }
    do
    {
      for (;;)
      {
        return;
        if (paramFromServiceMsg.getResultCode() == 1002)
        {
          i = paramToServiceMsg.extraData.getInt("retryTime", 0);
          if (i < 1)
          {
            paramToServiceMsg.extraData.putInt("retryTime", i + 1);
            send(paramToServiceMsg);
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember retry timeout!");
          }
        }
        else if (paramFromServiceMsg.getResultCode() != 1000)
        {
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember failCode:" + paramFromServiceMsg.getResultCode());
          }
        }
        else
        {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
          try
          {
            paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
            if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()) && (paramFromServiceMsg.uint32_result.get() == 0) && (paramFromServiceMsg.bytes_bodybuffer.has()) && (paramFromServiceMsg.bytes_bodybuffer.get() != null)) {
              break label240;
            }
            if (QLog.isColorLevel())
            {
              QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember ssoPkg invalid!");
              return;
            }
          }
          catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember merge ssopkg exception!");
    return;
    label240:
    k = 0;
    int i5 = 0;
    int i6 = 0;
    i = 0;
    int j = 0;
    int i7 = 0;
    int i4 = 0;
    paramObject = new oidb_0x751.RspBody();
    int m = i7;
    i1 = i6;
    int i3 = k;
    for (;;)
    {
      try
      {
        paramObject.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        m = i7;
        i1 = i6;
        i3 = k;
        k = paramObject.uint32_err_code.get();
        if (k != 0)
        {
          n = i4;
          i2 = i;
          m = i7;
          i1 = i6;
          i3 = k;
          if (QLog.isColorLevel())
          {
            m = i7;
            i1 = i6;
            i3 = k;
            QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember handle rspBody error! resultCode:" + k + " ,errMsg:" + paramObject.bytes_err_msg.get().toString());
            i2 = i;
            n = i4;
          }
          j = 0;
          i = k;
          i1 = i2;
          m = n;
          l = System.currentTimeMillis() - l;
          k = paramToServiceMsg.extraData.getInt("checkDiscCount");
          if (QLog.isColorLevel()) {
            QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember end! resultCode:" + i + " ,totalCount:" + k + " ,validCount:" + i1 + " ,invalidCount:" + m + " ,cost:" + l);
          }
          paramToServiceMsg = new HashMap();
          paramToServiceMsg.put("pm_totalCount", String.valueOf(k));
          paramToServiceMsg.put("pm_validCount", String.valueOf(i1));
          paramToServiceMsg.put("pm_inValidCount", String.valueOf(m));
          paramToServiceMsg.put("pm_resultCode", String.valueOf(i));
          if (j != 0) {
            paramToServiceMsg.put("pm_exceptionHappen", "true");
          }
          bdmc.a(BaseApplication.getContext()).a(null, "checkIsDiscussionMember", true, l, 0L, paramToServiceMsg, null);
          return;
        }
        int n = i4;
        int i2 = i;
        m = i7;
        i1 = i6;
        i3 = k;
        if (!paramObject.msg_rsp_check_is_conf_member.has()) {
          continue;
        }
        m = i7;
        i1 = i6;
        i3 = k;
        paramFromServiceMsg = (oidb_0x751.RspCheckIsConfMember)paramObject.msg_rsp_check_is_conf_member.get();
        n = i4;
        i2 = i;
        m = i7;
        i1 = i6;
        i3 = k;
        if (!paramFromServiceMsg.msg_check_is_conf_member_result.has()) {
          continue;
        }
        m = i7;
        i1 = i6;
        i3 = k;
        paramFromServiceMsg = paramFromServiceMsg.msg_check_is_conf_member_result.get().iterator();
        i = i5;
        n = j;
        i2 = i;
        m = j;
        i1 = i;
        i3 = k;
        if (!paramFromServiceMsg.hasNext()) {
          continue;
        }
        m = j;
        i1 = i;
        i3 = k;
        paramObject = (oidb_0x751.CheckIsConfMemberResult)paramFromServiceMsg.next();
        m = j;
        i1 = i;
        i3 = k;
        str = String.valueOf(paramObject.uint64_conf_uin.get());
        m = j;
        i1 = i;
        i3 = k;
        n = paramObject.uint32_is_conf_member.get();
        if (n == 0) {
          m = j + 1;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        String str;
        i = i3;
      }
      try
      {
        if (QLog.isColorLevel()) {
          QLog.d("DiscussionHandler", 2, "handleCheckIsDiscussionMember. Need to deleteDiscuss:" + str);
        }
        a(str);
        j = i;
        i = m;
        m = j;
        j = i;
        i = m;
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          i1 = i;
          i = k;
        }
      }
      m = i + 1;
      i = j;
      j = m;
      continue;
      QLog.i("DiscussionHandler", 1, "handleCheckIsDiscussionMember handle rspBody exception!", paramFromServiceMsg);
      j = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anwo
 * JD-Core Version:    0.7.0.1
 */