package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import GeneralSettings.RespGetSettings;
import GeneralSettings.RespSetSettings;
import KQQ.ChangeFriendNameRes;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigRes;
import KQQ.ProfSmpInfoRes;
import KQQ.ResRichSigInfo;
import KQQ.RespItem;
import KQQ.SetRichSigRes;
import QQService.BindUinResult;
import QQService.EVIPSPEC;
import QQService.SvcDevLoginInfo;
import QQService.SvcRespKikOut;
import QQService.SvcRspBindUin;
import QQService.SvcRspDelLoginInfo;
import QQService.SvcRspGetDevLoginInfo;
import QQService.VipBaseInfo;
import QQService.VipOpenInfo;
import SecurityAccountServer.RespondQueryQQBindingStat;
import SummaryCard.RespCondSearch;
import SummaryCard.RespHead;
import SummaryCard.RespSearch;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Pair;
import com.etrump.mixlayout.FontManager;
import com.qq.taf.jce.JceOutputStream;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlReq;
import com.tencent.avatarinfo.MultiHeadUrl.MultiBusidUrlRsp;
import com.tencent.avatarinfo.MultiHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspHeadInfo;
import com.tencent.avatarinfo.MultiHeadUrl.RspUsrHeadInfo;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlReq;
import com.tencent.avatarinfo.QQHeadUrl.QQHeadUrlRsp;
import com.tencent.avatarinfo.QQHeadUrl.ReqUsrInfo;
import com.tencent.avatarinfo.QQHeadUrl.RspHeadInfo;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.ims.device_lock_confirm_auth.DeviceInfo;
import com.tencent.ims.device_lock_confirm_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.DeviceInfo;
import com.tencent.ims.device_lock_recommend_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.RspBody;
import com.tencent.mobileqq.activity.AutoRemarkActivity;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.aio.HotReactiveHelper;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.app.proxy.FTSDBManager;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.app.utils.BatchAddFriendData;
import com.tencent.mobileqq.app.utils.ClassicHeadActivityManager;
import com.tencent.mobileqq.avatar.dynamicavatar.VasFaceManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.businessCard.BusinessCardManager;
import com.tencent.mobileqq.businessCard.BusinessCardServlet;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyCardManager;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.qcall.UinUtils;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactConfig;
import com.tencent.mobileqq.utils.DBUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.RoamSettingController;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.TraceUtils;
import friendlist.AddFriendResp;
import friendlist.AddGroupResp;
import friendlist.DelFriendResp;
import friendlist.DelGroupResp;
import friendlist.EAddFriendSourceID;
import friendlist.FriendInfo;
import friendlist.GetAutoInfoResp;
import friendlist.GetFriendListResp;
import friendlist.GetLastLoginInfoResp;
import friendlist.GetOnlineInfoResp;
import friendlist.GetSimpleOnlineFriendInfoResp;
import friendlist.GetUserAddFriendSettingResp;
import friendlist.GroupInfo;
import friendlist.LastLoginInfo;
import friendlist.LastLoginPageInfo;
import friendlist.MovGroupMemResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;
import friendlist.SetGroupResp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mqq.app.Constants.Key;
import mqq.app.Constants.PropertiesKey;
import mqq.app.MobileQQ;
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d0.Oidb_0x5d0.SnsUpdateItem;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdRsp;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ReqBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.RspBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdRsp;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.ReqBody;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.RspBody;
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.UdcUinData;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListReq;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListRsp;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.MsgBox;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.OneFrdData;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.ReqBody;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RspBody;
import tencent.im.oidb.cmd0x7c6.cmd0x7c6.ReqBody;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7.ReqBody;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7.RspBody;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.ReqBody;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.RspBody;
import tencent.im.oidb.cmd0x829.oidb_0x829.AddFrdInfo;
import tencent.im.oidb.cmd0x829.oidb_0x829.ReqBody;
import tencent.im.oidb.cmd0x829.oidb_0x829.RspBody;
import tencent.im.oidb.cmd0xaed.cmd0xaed.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import zkv;
import zkw;
import zkx;
import zky;
import zkz;
import zla;
import zlc;

public class FriendListHandler
  extends BusinessHandler
{
  public static int a;
  private static int h = 100;
  private long jdField_a_of_type_Long;
  private QQHeadDownloadHandler jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler;
  private BatchAddFriendData jdField_a_of_type_ComTencentMobileqqAppUtilsBatchAddFriendData;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private ArrayList jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private Hashtable jdField_a_of_type_JavaUtilHashtable = new Hashtable();
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler;
  private short jdField_a_of_type_Short = 20002;
  private boolean jdField_a_of_type_Boolean;
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private Hashtable jdField_b_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private final Object jdField_c_of_type_JavaLangObject = new Object();
  private Hashtable jdField_c_of_type_JavaUtilHashtable = new Hashtable();
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private Hashtable jdField_d_of_type_JavaUtilHashtable = new Hashtable();
  private int jdField_e_of_type_Int;
  private long jdField_e_of_type_Long = 15000L;
  private int jdField_f_of_type_Int = -1;
  private long jdField_f_of_type_Long;
  private volatile int g = -1;
  
  static
  {
    jdField_a_of_type_Int = -1;
  }
  
  public FriendListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.jdField_a_of_type_MqqOsMqqHandler = new zkv(this, paramQQAppInterface.getApp().getMainLooper());
    ThreadManager.post(new zkw(this), 2, null, false);
  }
  
  private void A(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((QLog.isColorLevel()) && (paramFromServiceMsg != null)) {
      QLog.d("FriendListHandler", 2, "FriendListHandler.handleBatchAddPhoneFriend sso resp: " + paramFromServiceMsg + ", data: " + paramObject);
    }
    boolean bool2;
    oidb_0x829.RspBody localRspBody;
    ArrayList localArrayList1;
    int j;
    ArrayList localArrayList2;
    String str;
    int k;
    int m;
    PhoneContactManagerImp localPhoneContactManagerImp;
    boolean bool1;
    int i;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      localRspBody = new oidb_0x829.RspBody();
      localArrayList1 = (ArrayList)paramToServiceMsg.extraData.getSerializable("phones");
      j = Integer.valueOf(paramToServiceMsg.extraData.getInt("package", -1)).intValue();
      localArrayList2 = (ArrayList)paramToServiceMsg.extraData.getSerializable("resultList");
      str = paramToServiceMsg.extraData.getString("verifyMsg");
      k = Integer.valueOf(paramToServiceMsg.extraData.getInt("sourceId")).intValue();
      m = j * 30;
      localPhoneContactManagerImp = (PhoneContactManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      bool1 = bool2;
      if (bool2)
      {
        paramToServiceMsg = a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        if (paramToServiceMsg == null) {
          break label465;
        }
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "FriendListHandler.handleBatchAddPhoneFriend oidb result code: " + i);
        }
        if (i != 0) {
          break label433;
        }
        bool2 = true;
        label235:
        bool1 = bool2;
        if (!bool2) {}
      }
    }
    for (;;)
    {
      try
      {
        localRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        bool1 = bool2;
      }
      catch (Exception paramToServiceMsg)
      {
        label433:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "FriendListHandler.handleBatchAddPhoneFriend RspBody mergeFrom failed.");
        bool1 = false;
        paramToServiceMsg.printStackTrace();
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendListHandler.handleBatchAddPhoneFriend isSuccess: " + bool1);
      }
      if (!bool1) {
        break label544;
      }
      if (!localRspBody.rpt_add_frd_info.has()) {
        break label471;
      }
      i = 0;
      if (i >= localRspBody.rpt_add_frd_info.size()) {
        break label471;
      }
      paramToServiceMsg = (oidb_0x829.AddFrdInfo)localRspBody.rpt_add_frd_info.get(i);
      paramFromServiceMsg = new FriendListHandler.AddBatchPhoneFriendResult();
      paramFromServiceMsg.mobile = paramToServiceMsg.bytes_mobile.get().toStringUtf8();
      paramFromServiceMsg.remark = paramToServiceMsg.bytes_remark.get().toStringUtf8();
      paramFromServiceMsg.allowType = paramToServiceMsg.uint32_allow_type.get();
      paramFromServiceMsg.sendReqFlag = paramToServiceMsg.uint32_send_req_flag.get();
      paramFromServiceMsg.sendResult = paramToServiceMsg.uint32_send_result.get();
      localArrayList2.add(paramFromServiceMsg);
      i += 1;
      continue;
      bool2 = false;
      break;
      bool2 = false;
      break label235;
      label465:
      bool1 = false;
    }
    label471:
    if ((j != -1) && (localArrayList1 != null) && (localArrayList2 != null) && (m < localArrayList1.size()))
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new zky(this, localArrayList1, str, j, k, localArrayList2));
      return;
    }
    localPhoneContactManagerImp.a(localArrayList1, localArrayList2, k);
    a(110, true, localArrayList2);
    return;
    label544:
    if ((j != -1) && (localArrayList1 != null) && (localArrayList2 != null) && (m < localArrayList1.size()))
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.runOnUiThread(new zkz(this, localArrayList1, str, j, k, localArrayList2));
      return;
    }
    if ((localArrayList2 != null) && (localArrayList2.size() > 0))
    {
      localPhoneContactManagerImp.a(localArrayList1, localArrayList2, k);
      a(110, true, localArrayList2);
      return;
    }
    a(110, false, null);
  }
  
  private void B(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsBatchAddFriendData == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppUtilsBatchAddFriendData.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public static int a(VipBaseInfo paramVipBaseInfo, int paramInt1, int paramInt2)
  {
    if ((paramVipBaseInfo != null) && (paramVipBaseInfo.mOpenInfo != null))
    {
      paramVipBaseInfo = (VipOpenInfo)paramVipBaseInfo.mOpenInfo.get(Integer.valueOf(paramInt1));
      if ((paramVipBaseInfo != null) && (paramVipBaseInfo.iVipLevel != -1) && (paramVipBaseInfo.iVipType != -1)) {}
    }
    else
    {
      return paramInt2;
    }
    if (paramVipBaseInfo.bOpen) {}
    for (paramInt1 = 1;; paramInt1 = 0) {
      return (paramInt1 << 8 | (byte)paramVipBaseInfo.iVipType & 0xFF) << 16 | (short)paramVipBaseInfo.iVipLevel;
    }
  }
  
  private int a(ToServiceMsg paramToServiceMsg)
  {
    int i = 0;
    try
    {
      Object localObject = ByteBuffer.wrap(paramToServiceMsg.getWupBuffer());
      paramToServiceMsg = new byte[((ByteBuffer)localObject).getInt() - 4];
      ((ByteBuffer)localObject).get(paramToServiceMsg);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).mergeFrom(paramToServiceMsg);
      int j = ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.get();
      i = j;
    }
    catch (Exception paramToServiceMsg)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "getServiceTypeFromToServiceMsg error:" + paramToServiceMsg.getMessage());
    }
    return i;
    return 0;
  }
  
  private Map a(ArrayList paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      int i = 0;
      if (i < paramArrayList.size())
      {
        GeneralSettings.Setting localSetting = (GeneralSettings.Setting)paramArrayList.get(i);
        Object localObject = localSetting.Path;
        if ((localObject == null) || (((String)localObject).length() == 0)) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((String)localObject).split("\\.");
          if ((localObject != null) && (localObject.length != 0)) {
            localHashMap.put(localObject[(localObject.length - 1)], Integer.valueOf(Integer.parseInt(localSetting.Value)));
          }
        }
      }
    }
    return localHashMap;
  }
  
  private static oidb_sso.OIDBSSOPkg a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000)) {
      paramToServiceMsg = null;
    }
    for (;;)
    {
      return paramToServiceMsg;
      paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg.bytes_bodybuffer.get() != null) {
            continue;
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso ssoPkg.uint32_result.get() " + paramFromServiceMsg.uint32_result.get());
        }
        return null;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
          }
        }
      }
    }
  }
  
  private void a(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new zkx(this, paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramBoolean), 8, null, false);
      return;
    }
    b(paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramBoolean);
  }
  
  private void a(int paramInt, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
    localMultiBusidUrlReq.srcUidType.set(0);
    localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(16));
    localMultiBusidUrlReq.dstUidType.set(0);
    int i = 0;
    for (;;)
    {
      if (i >= paramArrayList.size()) {
        break label171;
      }
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(i);
      MultiHeadUrl.ReqUsrInfo localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
      try
      {
        localReqUsrInfo.dstUin.set(UinUtils.b(localQQHeadDetails.jdField_a_of_type_JavaLangString));
        a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
        localMultiBusidUrlReq.dstUsrInfos.add(localReqUsrInfo);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("ERROR", 2, localException.getMessage());
          }
        }
      }
      i += 1;
    }
    label171:
    new HashMap().put("connum", String.valueOf(paramArrayList.size()));
    ToServiceMsg localToServiceMsg = a("MultibusidURLSvr.HeadUrlReq", null);
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("idType", paramInt);
    localToServiceMsg.extraData.putInt("qqHeadType", 16);
    localToServiceMsg.putWupBuffer(localMultiBusidUrlReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.flh", 2, "realGetQQHead_QCall .  idType = " + paramInt);
    }
    b(localToServiceMsg);
  }
  
  private void a(long paramLong, int paramInt, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = a("AvatarInfoSvr.QQHeadUrlReq", null);
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(i);
      ((ArrayList)localObject).add(localQQHeadDetails.a());
      a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
      i += 1;
    }
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    paramArrayList = new QQHeadUrlReq(paramLong, (ArrayList)localObject, (byte)paramInt);
    localObject = new JceOutputStream();
    ((JceOutputStream)localObject).setServerEncoding("UTF-8");
    paramArrayList.writeTo((JceOutputStream)localObject);
    localToServiceMsg.extraData.putByteArray("QQHeadUrlReq", ((JceOutputStream)localObject).toByteArray());
    a(localToServiceMsg);
  }
  
  private void a(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ToServiceMsg localToServiceMsg = a("friendlist.GetLastLoginInfoReq");
    localToServiceMsg.extraData.putLong("uin", l);
    localToServiceMsg.extraData.putLong("total_req_times", paramLong1);
    localToServiceMsg.extraData.putLong("current_req_index", paramLong2);
    localToServiceMsg.extraData.putLong("current_req_uin", paramLong3);
    a(localToServiceMsg);
  }
  
  private void a(FriendsManager paramFriendsManager)
  {
    Object localObject = QvipSpecialCareManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if ((paramFriendsManager != null) && (localObject != null) && (((Set)localObject).size() > 0))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramFriendsManager.b(str))
        {
          QvipSpecialCareManager.b(str, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          if (QvipSpecialCareManager.b(str, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
            QvipSpecialCareManager.c(str, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          }
        }
      }
    }
  }
  
  public static void a(SpecialCareInfo paramSpecialCareInfo, int paramInt, String paramString)
  {
    if (paramInt == 13568)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramSpecialCareInfo.specialRingSwitch = 0;
          return;
        }
        if (!Pattern.compile("[0-9]*").matcher(paramString).matches()) {
          return;
        }
        paramSpecialCareInfo.friendRingId = Integer.parseInt(paramString);
        paramSpecialCareInfo.specialRingSwitch = 1;
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramString);
        }
        paramSpecialCareInfo.specialRingSwitch = 0;
        return;
      }
    }
    else
    {
      if (paramInt == 13573)
      {
        try
        {
          if (!TextUtils.isEmpty(paramString)) {
            break label111;
          }
          paramSpecialCareInfo.globalSwitch = 0;
          return;
        }
        catch (Exception paramSpecialCareInfo)
        {
          if (!QLog.isColorLevel()) {
            return;
          }
        }
        QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramSpecialCareInfo);
        return;
        label111:
        paramSpecialCareInfo.globalSwitch = 1;
        return;
      }
      if (paramInt == 13572) {
        try
        {
          if (TextUtils.isEmpty(paramString))
          {
            paramSpecialCareInfo.qzoneSwitch = 0;
            return;
          }
        }
        catch (Exception paramSpecialCareInfo)
        {
          if (QLog.isColorLevel())
          {
            QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramSpecialCareInfo);
            return;
            paramSpecialCareInfo.qzoneSwitch = 1;
          }
        }
      }
    }
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, DelFriendResp paramDelFriendResp)
  {
    if (paramDelFriendResp.errorCode != 0)
    {
      a(15, false, null);
      return;
    }
    paramFromServiceMsg = (PhoneContactManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.b();
    }
    ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).d(String.valueOf(paramDelFriendResp.deluin));
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a().a(String.valueOf(paramDelFriendResp.deluin), true);
    paramFromServiceMsg = (NearbyCardManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
    if (paramFromServiceMsg != null) {
      paramFromServiceMsg.d.put("" + paramDelFriendResp.deluin, Integer.valueOf(1));
    }
    a(15, true, Long.valueOf(paramDelFriendResp.deluin));
  }
  
  private void a(FromServiceMsg paramFromServiceMsg, GetLastLoginInfoResp paramGetLastLoginInfoResp)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramGetLastLoginInfoResp != null) && (paramGetLastLoginInfoResp.errorCode == 0))
    {
      paramFromServiceMsg = paramGetLastLoginInfoResp.stPageInfo;
      ArrayList localArrayList = paramGetLastLoginInfoResp.vecLastLoginInfo;
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      b(localArrayList);
      if (paramFromServiceMsg.dwCurrentReqIndex == paramFromServiceMsg.dwTotalReqTimes)
      {
        ContactConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), paramGetLastLoginInfoResp.iRefreshIntervalMin);
        a(48, true, Boolean.valueOf(true));
      }
      while (paramFromServiceMsg.dwCurrentReqIndex >= paramFromServiceMsg.dwTotalReqTimes) {
        return;
      }
      a(48, true, Boolean.valueOf(false));
      a(paramFromServiceMsg.dwTotalReqTimes, paramFromServiceMsg.dwCurrentReqIndex, paramFromServiceMsg.dwCurrentReqUin);
      return;
    }
    a(48, false, Boolean.valueOf(true));
  }
  
  private void a(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject = localStringBuilder.append("handleGetQQHeadError, result=").append(paramInt).append(", uinListSize=");
    if (localArrayList != null) {}
    for (int i = localArrayList.size();; i = -1)
    {
      ((StringBuilder)localObject).append(i);
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        break;
      }
      QLog.i("Q.qqhead.flh", 1, localStringBuilder.toString());
      return;
    }
    i = 0;
    if (i < localArrayList.size())
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)localArrayList.get(i);
      String str = localQQHeadDetails.jdField_a_of_type_Int + "_" + localQQHeadDetails.jdField_a_of_type_JavaLangString;
      int j;
      if (localQQHeadDetails.jdField_a_of_type_Int == 32)
      {
        j = paramToServiceMsg.extraData.getInt("subtype");
        localObject = "stranger_" + j + "_" + str;
      }
      for (;;)
      {
        b((String)localObject, true);
        a(9201, (String)localObject, localQQHeadDetails.jdField_a_of_type_Int, 2, 0, null, paramInt, 0L);
        if (localQQHeadDetails != null) {
          localStringBuilder.append("; uin=").append((String)localObject).append(", timestamp=").append(localQQHeadDetails.jdField_a_of_type_Long);
        }
        localObject = (ClassicHeadActivityManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(198);
        if ((localObject != null) && (((ClassicHeadActivityManager)localObject).a())) {
          ((ClassicHeadActivityManager)localObject).a(localQQHeadDetails.jdField_a_of_type_JavaLangString);
        }
        i += 1;
        break;
        localObject = str;
        if (localQQHeadDetails.jdField_a_of_type_Int == 16)
        {
          j = paramToServiceMsg.extraData.getInt("subtype");
          localObject = "qcall_" + j + "_" + str;
        }
      }
    }
    QLog.i("Q.qqhead.flh", 1, localStringBuilder.toString());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    if (paramToServiceMsg.extraData.getInt("setId") == 4051) {
      b(paramToServiceMsg, paramFromServiceMsg);
    }
  }
  
  private void a(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, QQHeadUrlResp paramQQHeadUrlResp)
  {
    int i;
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramQQHeadUrlResp == null) || (paramQQHeadUrlResp.result != 0) || (paramQQHeadUrlResp.UserHeadInfoList == null))
    {
      i = 65535;
      if (paramQQHeadUrlResp != null) {
        i = paramQQHeadUrlResp.result;
      }
    }
    label262:
    do
    {
      for (;;)
      {
        a(???, i);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleQQHead handleResp for QQHeadInfo appear error and error code =" + i);
        }
        return;
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.getResultCode();
        }
      }
      paramFromServiceMsg = ???.extraData.getParcelableArrayList("uinList");
      Object localObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        ??? = new ArrayList();
        paramFromServiceMsg = paramFromServiceMsg.iterator();
        for (;;)
        {
          if (!paramFromServiceMsg.hasNext()) {
            break label262;
          }
          localObject = (FriendListHandler.QQHeadDetails)paramFromServiceMsg.next();
          Iterator localIterator = paramQQHeadUrlResp.UserHeadInfoList.iterator();
          if (localIterator.hasNext())
          {
            QQHeadInfo localQQHeadInfo = (QQHeadInfo)localIterator.next();
            if (((localQQHeadInfo.dstUsrType == 11) || (!((FriendListHandler.QQHeadDetails)localObject).jdField_a_of_type_JavaLangString.equals(Long.toString(localQQHeadInfo.uin)))) && ((localQQHeadInfo.dstUsrType != 11) || (!((FriendListHandler.QQHeadDetails)localObject).jdField_a_of_type_JavaLangString.equals(localQQHeadInfo.phoneNum)))) {
              break;
            }
            localQQHeadInfo.headLevel = ((FriendListHandler.QQHeadDetails)localObject).jdField_a_of_type_Byte;
            ???.add(localQQHeadInfo);
          }
        }
        paramQQHeadUrlResp.UserHeadInfoList = ???;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        ??? = new StringBuilder("handleQQHead handleResp for QQHeadInfo");
        i = 0;
        if (i < paramQQHeadUrlResp.UserHeadInfoList.size())
        {
          paramFromServiceMsg = (QQHeadInfo)paramQQHeadUrlResp.UserHeadInfoList.get(i);
          a(0, a(paramFromServiceMsg.dstUsrType, paramFromServiceMsg.uin, paramFromServiceMsg.phoneNum), paramFromServiceMsg.dstUsrType, 2);
          ???.append(" qqHeadUrlResp id=").append(i).append(" QQHeadInfo.uin=").append(StringUtil.d(Long.toString(paramFromServiceMsg.uin))).append(" QQHeadInfo.systemId=").append(paramFromServiceMsg.systemHeadID).append("  QQHeadInfo.headtype=").append(paramFromServiceMsg.cHeadType).append("|");
          localObject = new FaceInfo();
          ((FaceInfo)localObject).jdField_a_of_type_AvatarInfoQQHeadInfo = paramFromServiceMsg;
          this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.a((FaceInfo)localObject);
          i += 1;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("FriendListHandler", 2, ???.toString());
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespGetSettings paramRespGetSettings)
  {
    if (QLog.isColorLevel()) {
      QLog.d("RoamSetting", 2, "handleGetGeneralSettingAll cmd=" + paramFromServiceMsg.getMsfCommand() + " resp.isSucc=" + paramFromServiceMsg.isSuccess() + " resultCode=" + paramFromServiceMsg.getResultCode());
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      int k = paramToServiceMsg.extraData.getInt("Revision");
      int j = paramToServiceMsg.extraData.getInt("respRevision", -1);
      boolean bool = paramToServiceMsg.extraData.getBoolean("needTroopSettings");
      long l = paramToServiceMsg.extraData.getLong("Offset");
      paramToServiceMsg = (ArrayList)paramToServiceMsg.extraData.getSerializable("Paths");
      if (paramRespGetSettings == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "handlerGetGeneralSettingAll, data == null");
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g(false, true);
        a(35, false, new Object[] { Boolean.valueOf(true) });
        return;
      }
      if ((paramRespGetSettings.Settings == null) || (paramRespGetSettings.Settings.size() == 0))
      {
        if (QLog.isColorLevel())
        {
          paramFromServiceMsg = new StringBuilder().append("handlerGetGeneralSettingAll, data.Settings=");
          if (paramRespGetSettings.Settings != null) {
            break label289;
          }
        }
        label289:
        for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size()))
        {
          QLog.d("RoamSetting", 2, paramToServiceMsg);
          DBUtils.a().a(paramRespGetSettings.Revision, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g(true, true);
          a(35, true, new Object[] { Boolean.valueOf(true) });
          return;
        }
      }
      if ((j != -1) && (j < paramRespGetSettings.Revision))
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "respRevision != data.Revision, load settings again, respRev=" + j + " data.Rev=" + paramRespGetSettings.Revision);
        }
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g(false, false);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(bool);
        a(35, true, new Object[] { Boolean.valueOf(false) });
        return;
      }
      int i = j;
      if (j == -1) {
        i = paramRespGetSettings.Revision;
      }
      if (QLog.isColorLevel())
      {
        paramFromServiceMsg = new StringBuilder().append("oldRevision=").append(k).append(" lastRespRevision=").append(i).append(" total=").append(paramRespGetSettings.Total).append(" offset=").append(l).append(" data.settings.size=");
        if (paramRespGetSettings.Settings != null) {
          break label591;
        }
      }
      label591:
      for (paramToServiceMsg = "null";; paramToServiceMsg = Integer.valueOf(paramRespGetSettings.Settings.size()))
      {
        QLog.d("RoamSetting", 2, paramToServiceMsg);
        DBUtils.a().a(paramRespGetSettings.Settings, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
        l += paramRespGetSettings.Settings.size();
        if (paramRespGetSettings.Total <= l) {
          break;
        }
        ((RoamSettingController)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(30)).a(k, l, i, bool, null);
        a(35, true, new Object[] { Boolean.valueOf(false) });
        return;
      }
      DBUtils.a().a(paramRespGetSettings.Revision, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g(true, true);
      a(35, true, new Object[] { Boolean.valueOf(true) });
      return;
    }
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.g(false, true);
    a(35, false, new Object[] { Boolean.valueOf(true) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, RespSetSettings paramRespSetSettings)
  {
    Object localObject1 = (ArrayList)paramToServiceMsg.extraData.getSerializable("Settings");
    int i = paramToServiceMsg.extraData.getInt("localRevision");
    Object localObject2;
    boolean bool2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("handlerUploadRoamSettingNewValue isSuccess = ").append(paramFromServiceMsg.isSuccess()).append(" reqLocalRevision=").append(i).append(" data.Revision=");
      if (paramRespSetSettings == null)
      {
        paramToServiceMsg = "null";
        QLog.d("FriendListHandler", 2, paramToServiceMsg);
      }
    }
    else
    {
      paramToServiceMsg = (RoamSettingController)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(30);
      if (!paramFromServiceMsg.isSuccess()) {
        break label216;
      }
      if (paramRespSetSettings == null) {
        break label1220;
      }
      if (i + 1 != paramRespSetSettings.Revision) {
        break label201;
      }
      DBUtils.a().a((ArrayList)localObject1, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      DBUtils.a().a(paramRespSetSettings.Revision, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.h(true, false);
      bool2 = true;
    }
    for (;;)
    {
      if (localObject1 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("RoamSetting", 2, "handlerUploadRoamSettingNewValue  settings is null.");
        }
        return;
        paramToServiceMsg = Integer.valueOf(paramRespSetSettings.Revision);
        break;
        label201:
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.h(true, true);
        bool2 = true;
        continue;
        label216:
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.h(false, false);
        bool2 = false;
        continue;
      }
      paramFromServiceMsg = a((ArrayList)localObject1);
      paramRespSetSettings = ((ArrayList)localObject1).iterator();
      boolean bool1 = false;
      label247:
      if (paramRespSetSettings.hasNext())
      {
        localObject1 = (GeneralSettings.Setting)paramRespSetSettings.next();
        if (((GeneralSettings.Setting)localObject1).Path == null) {
          break label1217;
        }
        if (!((GeneralSettings.Setting)localObject1).Path.startsWith("message.group.policy.")) {
          break label494;
        }
        if ((bool1) || ((!bool2) && ((bool2) || (!paramToServiceMsg.a())))) {
          break label405;
        }
        localObject1 = paramFromServiceMsg.keySet().iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          Boolean localBoolean = (Boolean)paramToServiceMsg.c.get(localObject2);
          if ((localBoolean != null) && (localBoolean.booleanValue())) {
            paramToServiceMsg.c.put(localObject2, Boolean.valueOf(false));
          }
        }
        a(38, bool2, paramFromServiceMsg);
        bool1 = true;
      }
      label405:
      label1217:
      for (;;)
      {
        break label247;
        break;
        if (QLog.isColorLevel())
        {
          QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + " hasNotifyTroop=" + bool1 + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
          continue;
          label494:
          if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.ring.switch"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
              a(43, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.vibrate.switch"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
              a(44, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("sync.c2c_message"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
              a(47, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.group.ring"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
              a(41, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.group.vibrate"))
          {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
              a(42, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
            }
          }
          else if (((GeneralSettings.Setting)localObject1).Path.startsWith("message.ring.care")) {
            if ((bool2) || ((!bool2) && (paramToServiceMsg.a()))) {
              a(78, bool2, paramFromServiceMsg);
            } else if (QLog.isColorLevel()) {
              QLog.d("RoamSetting", 2, "-->handleUploadRoamsSettingNewValue not notifyUI, path=" + ((GeneralSettings.Setting)localObject1).Path + " value=" + ((GeneralSettings.Setting)localObject1).Value + "uploadSuccess=" + bool2 + " enableRetry=" + paramToServiceMsg.a());
            }
          }
        }
      }
      label1220:
      bool2 = true;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRespKikOut paramSvcRespKikOut)
  {
    int i = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerKickOutDev index = " + i);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRespKikOut == null)
      {
        a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i) });
        return;
      }
      a(52, true, new Object[] { Long.valueOf(paramSvcRespKikOut.appid), Integer.valueOf(paramSvcRespKikOut.result), Integer.valueOf(i) });
      return;
    }
    if (paramSvcRespKikOut == null)
    {
      a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i) });
      return;
    }
    a(52, false, new Object[] { Long.valueOf(-1L), Integer.valueOf(-1), Integer.valueOf(i) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspBindUin paramSvcRspBindUin)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SUB_ACCOUNT", 2, "handlerBindUinStaus() success");
      }
      if (paramSvcRspBindUin != null)
      {
        paramToServiceMsg = paramSvcRspBindUin.vecResult;
        if (paramToServiceMsg != null)
        {
          int i = 0;
          if (i < paramToServiceMsg.size())
          {
            paramFromServiceMsg = (BindUinResult)paramToServiceMsg.get(i);
            if (paramFromServiceMsg == null) {}
            for (;;)
            {
              i += 1;
              break;
              if (QLog.isColorLevel()) {
                QLog.d("SUB_ACCOUNT", 2, "result iResult = " + paramFromServiceMsg.iResult + "; lUin = " + paramFromServiceMsg.lUin + "; strResult = " + paramFromServiceMsg.strResult);
              }
            }
          }
        }
      }
    }
    else if (QLog.isColorLevel())
    {
      QLog.d("FriendListHandler", 2, "handlerBindUinStaus res no success");
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + i);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(61, false, new Object[] { null, Integer.valueOf(i) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(61, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
        return;
      }
      a(61, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(61, false, new Object[] { null, Integer.valueOf(i) });
      return;
    }
    a(61, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(50, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        int i;
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          i = 0;
          if (i < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i);
            if (paramToServiceMsg != null) {}
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramToServiceMsg.vecGuid == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "handlerMultiClientList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
            }
          }
          else
          {
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList NetConnInfoCenter.GUID is null");
              }
            }
            while (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
            {
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i);
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList Arrays true");
              }
              a(50, true, new Object[] { paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo, paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo });
              return;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerMultiClientList NetConnInfoCenter.GUID =" + PkgTools.a(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.a(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
      }
      a(50, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(50, false, null);
      return;
    }
    a(50, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte)
  {
    bool2 = false;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleInfoOpenId ").append(paramFromServiceMsg.isSuccess()).append(", ");
      if (paramArrayOfByte == null) {
        break label225;
      }
    }
    label225:
    for (int i = paramArrayOfByte.length;; i = -1)
    {
      QLog.d("FriendListHandler", 2, i);
      paramToServiceMsg = paramToServiceMsg.extraData;
      bool1 = bool2;
      if (paramFromServiceMsg.isSuccess()) {}
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom(paramArrayOfByte);
        if ((!paramFromServiceMsg.uint32_result.has()) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          break;
        }
        paramArrayOfByte = new oidb_0x5e1.RspBody();
        paramArrayOfByte.mergeFrom(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (paramArrayOfByte.rpt_msg_uin_data.size() <= 0) {
          break;
        }
        paramFromServiceMsg = new String(((oidb_0x5e1.UdcUinData)paramArrayOfByte.rpt_msg_uin_data.get(0)).bytes_nick.get().toByteArray());
        paramToServiceMsg.putString("nick_name", paramFromServiceMsg);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleInfoOpenId " + paramFromServiceMsg);
        }
        bool1 = true;
      }
      catch (Throwable paramFromServiceMsg)
      {
        for (;;)
        {
          bool1 = bool2;
          if (QLog.isColorLevel())
          {
            QLog.d("FriendListHandler", 2, "", paramFromServiceMsg);
            bool1 = bool2;
            continue;
            bool1 = false;
          }
        }
      }
      a(74, bool1, paramToServiceMsg);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetFriendListResp paramGetFriendListResp)
  {
    if ((paramGetFriendListResp.result == 1) || (paramGetFriendListResp.vecFriendInfo == null) || (paramGetFriendListResp.vecFriendInfo.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo failed");
      }
      return;
    }
    Object localObject = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    VasFaceManager localVasFaceManager = ((VasExtensionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a;
    FriendInfo localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
    Friends localFriends1 = new Friends();
    localFriends1.name = localFriendInfo.nick;
    localFriends1.remark = localFriendInfo.remark;
    localFriends1.uin = String.valueOf(localFriendInfo.friendUin);
    localFriends1.groupid = localFriendInfo.groupId;
    localFriends1.cSpecialFlag = localFriendInfo.cSpecialFlag;
    if (255 == localFriendInfo.cSpecialFlag)
    {
      QLog.i("FriendListHandler", 1, "infoResp.cSpecialFlag is 0xFF");
      localFriends1.cSpecialFlag = 0;
    }
    localFriends1.detalStatusFlag = localFriendInfo.detalStatusFlag;
    localFriends1.alias = localFriendInfo.sShowName;
    localFriends1.iTermType = localFriendInfo.iTermType;
    localFriends1.abilityBits = localFriendInfo.uAbiFlag;
    localFriends1.netTypeIconId = localFriendInfo.eIconType;
    localFriends1.strTermDesc = localFriendInfo.strTermDesc;
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "handleGetFriendDetailInfo uin=" + localFriends1.uin + ", cSpecialFlag=" + localFriends1.cSpecialFlag);
    }
    if (localFriends1.eNetwork != localFriendInfo.eNetworkType)
    {
      localFriends1.eNetwork = localFriendInfo.eNetworkType;
      a(13, true, null);
    }
    localFriends1.setShieldFlag(false);
    paramToServiceMsg = ((FriendsManager)localObject).c(localFriends1.uin);
    if (paramToServiceMsg != null)
    {
      if (paramToServiceMsg.gathtertype != 1) {
        break label1495;
      }
      localFriends1.gathtertype = 1;
      localFriends1.age = paramToServiceMsg.age;
      localFriends1.smartRemark = paramToServiceMsg.smartRemark;
      localFriends1.gender = paramToServiceMsg.gender;
      localFriends1.recommReason = paramToServiceMsg.recommReason;
      if (((paramToServiceMsg.gathtertype == 1) || (paramToServiceMsg.gathtertype == 2)) && (QLog.isColorLevel())) {
        QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendDetailInfo  friend.gathtertype = " + localFriends1.gathtertype + " | friend.age = " + localFriends1.age + " | friend.recommReason = " + localFriends1.recommReason);
      }
    }
    Friends localFriends2 = ((FriendsManager)localObject).c(localFriends1.uin);
    paramToServiceMsg = localFriendInfo.oVipInfo;
    int j = EVIPSPEC.E_SP_QQVIP.value();
    int i;
    label503:
    boolean bool;
    label540:
    label577:
    label632:
    SpecialCareInfo localSpecialCareInfo;
    if (localFriends2 != null)
    {
      i = localFriends2.qqVipInfo;
      localFriends1.qqVipInfo = a(paramToServiceMsg, j, i);
      paramToServiceMsg = localFriendInfo.oVipInfo;
      j = EVIPSPEC.E_SP_SUPERQQ.value();
      if (localFriends2 == null) {
        break label1517;
      }
      i = localFriends2.superQqInfo;
      localFriends1.superQqInfo = a(paramToServiceMsg, j, i);
      paramToServiceMsg = localFriendInfo.oVipInfo;
      j = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localFriends2 == null) {
        break label1522;
      }
      i = localFriends2.superVipInfo;
      localFriends1.superVipInfo = a(paramToServiceMsg, j, i);
      localFriends1.namePlateOfKingGameId = localFriendInfo.uGameAppid;
      localFriends1.namePlateOfKingLoginTime = localFriendInfo.uGameLastLoginTime;
      localFriends1.namePlateOfKingDan = ((int)localFriendInfo.ulKingOfGloryRank);
      if (localFriendInfo.cKingOfGloryFlag != 1) {
        break label1527;
      }
      bool = true;
      localFriends1.namePlateOfKingDanDisplatSwitch = bool;
      if ((!TextUtils.isEmpty(localFriends1.uin)) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(localFriends1.uin))) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(), localFriends1.namePlateOfKingDanDisplatSwitch).apply();
      }
      if (localFriends2 != null)
      {
        localFriends1.datetime = localFriends2.datetime;
        localFriends1.lastLoginType = localFriends2.lastLoginType;
        if (localFriends2.gathtertype == 1)
        {
          localFriends1.gender = localFriends2.gender;
          localFriends1.age = localFriends2.age;
          localFriends1.smartRemark = localFriends2.smartRemark;
          localFriends1.recommReason = localFriends2.recommReason;
        }
      }
      QidianManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, localFriends1);
      paramGetFriendListResp = ((FriendsManager)localObject).a(localFriends1.uin);
      paramToServiceMsg = paramGetFriendListResp;
      if (paramGetFriendListResp == null)
      {
        paramToServiceMsg = new ExtensionInfo();
        paramToServiceMsg.uin = localFriends1.uin;
      }
      paramToServiceMsg.pendantId = localFriendInfo.ulFaceAddonId;
      paramToServiceMsg.uVipFont = FontManager.a(localFriendInfo.uFounderFont);
      paramToServiceMsg.vipFontType = FontManager.b(localFriendInfo.uFounderFont);
      paramToServiceMsg.colorRingId = localFriendInfo.uColorRing;
      paramToServiceMsg.magicFont = (localFriendInfo.cSpecialFlag >> 3 & 0x1);
      paramToServiceMsg.faceId = ((int)localFriendInfo.uFaceStoreId);
      paramToServiceMsg.faceIdUpdateTime = NetConnInfoCenter.getServerTime();
      paramToServiceMsg.timestamp = System.currentTimeMillis();
      paramToServiceMsg.latestPLUpdateTimestamp = localFriendInfo.uTagUpdateTime;
      paramToServiceMsg.medalUpdateTimestamp = localFriendInfo.uLastMedalUpdateTime;
      paramToServiceMsg.fontEffect = ((int)localFriendInfo.uFontEffect);
      paramToServiceMsg.fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      localSpecialCareInfo = new SpecialCareInfo();
      a(localFriendInfo.vecRing, paramToServiceMsg, localFriends1, localSpecialCareInfo, 0L);
      if (localSpecialCareInfo != null) {
        ((FriendsManager)localObject).a(localSpecialCareInfo);
      }
      ((FriendsManager)localObject).b(localFriends1);
      ((FriendsManager)localObject).a(paramToServiceMsg);
      localVasFaceManager.a(paramToServiceMsg);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder().append("handleGetFriendDetailInfo, Get ExtensionInfo, uin=");
        if (localFriends2 == null) {
          break label1533;
        }
      }
    }
    label1495:
    label1517:
    label1522:
    label1527:
    label1533:
    for (paramGetFriendListResp = localFriends2.uin;; paramGetFriendListResp = "")
    {
      QLog.d("FriendListHandler", 2, paramGetFriendListResp + ", id=" + paramToServiceMsg.pendantId + ",font=" + paramToServiceMsg.uVipFont + ", fontType = " + paramToServiceMsg.vipFontType + ", magicfont = " + paramToServiceMsg.magicFont + ",latestplNewsTs=" + paramToServiceMsg.latestPLUpdateTimestamp + ",medalUpdateTimestamp=" + paramToServiceMsg.medalUpdateTimestamp + ",fontEffect=" + paramToServiceMsg.fontEffect + ",fontEffectLastUpdateTime=" + paramToServiceMsg.fontEffectLastUpdateTime);
      if (localFriends2 != null)
      {
        paramToServiceMsg = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
        paramGetFriendListResp = paramToServiceMsg.b(localFriends2.uin);
        if ((paramGetFriendListResp.apolloStatus != localFriendInfo.cApolloFlag) || (paramGetFriendListResp.apolloServerTS != localFriendInfo.uApolloTimestamp) || (paramGetFriendListResp.apolloSignValidTS != localFriendInfo.uApolloSignTime))
        {
          paramGetFriendListResp.apolloStatus = localFriendInfo.cApolloFlag;
          paramGetFriendListResp.apolloServerTS = localFriendInfo.uApolloTimestamp;
          paramGetFriendListResp.apolloSignValidTS = localFriendInfo.uApolloSignTime;
          paramGetFriendListResp.apolloSignStr = "";
          paramToServiceMsg.a(paramGetFriendListResp);
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo, update apollo info uin=" + localFriends2.uin + "apollo status: " + localFriendInfo.cApolloFlag + ", apollo svr TS: " + localFriendInfo.uApolloTimestamp + ", sign TS: " + localFriendInfo.uApolloSignTime);
          }
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "$handleGetFriendDetailInfo | uin = " + localFriends1.uin + " | group = " + localFriends1.groupid);
      }
      if (this.jdField_b_of_type_Long == 0L) {
        a(1, true, Boolean.valueOf(true));
      }
      paramToServiceMsg = new ArrayList();
      paramToServiceMsg.add(localSpecialCareInfo);
      a(99, true, new Object[] { Boolean.valueOf(true), paramToServiceMsg });
      paramToServiceMsg = (PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (paramToServiceMsg != null) {
        paramToServiceMsg.d();
      }
      b(new String[] { localFriends1.uin });
      return;
      if (paramToServiceMsg.gathtertype != 2) {
        break;
      }
      localFriends1.gathtertype = 2;
      break;
      i = 0;
      break label503;
      i = 0;
      break label540;
      i = 0;
      break label577;
      bool = false;
      break label632;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, GetUserAddFriendSettingResp paramGetUserAddFriendSettingResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    if ((paramGetUserAddFriendSettingResp != null) && (paramGetUserAddFriendSettingResp.result == 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleAddFriendSetting " + paramGetUserAddFriendSettingResp.queryuinsetting + ", " + paramGetUserAddFriendSettingResp.contact_bothway_friend + ", " + paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      }
      paramToServiceMsg.putInt("friend_setting", paramGetUserAddFriendSettingResp.queryuinsetting);
      paramToServiceMsg.putLong("query_friend_uin", paramGetUserAddFriendSettingResp.queryuin);
      paramToServiceMsg.putStringArrayList("user_question", paramGetUserAddFriendSettingResp.vecStrUserQuestion);
      paramToServiceMsg.putBoolean("contact_bothway", paramGetUserAddFriendSettingResp.contact_bothway_friend);
      a(12, true, paramToServiceMsg);
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("handleAddFriendSetting ");
      if (paramGetUserAddFriendSettingResp == null) {
        break label184;
      }
    }
    label184:
    for (int i = paramGetUserAddFriendSettingResp.result;; i = -10000)
    {
      QLog.d("FriendListHandler", 2, i);
      a(12, false, paramToServiceMsg);
      return;
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, MovGroupMemResp paramMovGroupMemResp)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    String str = paramToServiceMsg.getString("uin");
    byte b1 = paramToServiceMsg.getByte("group_id");
    byte b2 = paramToServiceMsg.getByte("away_group_id");
    if (paramMovGroupMemResp.result == 0)
    {
      ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(str, b1);
      a(9, true, new Object[] { str, Byte.valueOf(b1), Byte.valueOf(b2) });
      return;
    }
    a(9, false, null);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, SetGroupResp paramSetGroupResp)
  {
    boolean bool;
    int i;
    if (paramSetGroupResp.result == 0)
    {
      bool = true;
      i = paramToServiceMsg.extraData.getInt("set_type", -1);
      if (i == paramSetGroupResp.reqtype) {
        break label675;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleSetGroupResp | unmatched reqtype, local = " + i + ", remote = " + paramSetGroupResp.reqtype);
      }
      bool = false;
    }
    label675:
    for (;;)
    {
      Object localObject1 = ByteBuffer.wrap(paramSetGroupResp.vecBody);
      FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      Object localObject2;
      switch (i)
      {
      default: 
        return;
        bool = false;
        break;
      case 0: 
        localObject2 = new AddGroupResp();
        if (bool)
        {
          ((AddGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((AddGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          ((AddGroupResp)localObject2).cGroupId = ((ByteBuffer)localObject1).get();
          ((AddGroupResp)localObject2).cSortId = ((ByteBuffer)localObject1).get();
          localObject1 = localFriendsManager.a(((AddGroupResp)localObject2).cGroupId + "");
          if (localObject1 == null) {
            break label301;
          }
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject2).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject2).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
        for (paramToServiceMsg = (ToServiceMsg)localObject1;; paramToServiceMsg = (ToServiceMsg)localObject1)
        {
          localFriendsManager.a(paramToServiceMsg);
          a(18, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (AddGroupResp)localObject2));
          return;
          localObject1 = new Groups();
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject2).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject2).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
      case 1: 
        localObject2 = new RenameGroupResp();
        if (bool)
        {
          ((RenameGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((RenameGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          i = ((ByteBuffer)localObject1).get();
          ((RenameGroupResp)localObject2).cLen = ((ByteBuffer)localObject1).get();
          paramToServiceMsg = new byte[((RenameGroupResp)localObject2).cLen];
          ((ByteBuffer)localObject1).get(paramToServiceMsg, 0, ((RenameGroupResp)localObject2).cLen);
          ((RenameGroupResp)localObject2).sGroupName = new String(paramToServiceMsg);
          paramToServiceMsg = localFriendsManager.a(String.valueOf(i));
          if (paramToServiceMsg == null) {
            break label492;
          }
        }
        for (paramToServiceMsg.group_name = ((RenameGroupResp)localObject2).sGroupName;; paramToServiceMsg.group_name = ((RenameGroupResp)localObject2).sGroupName)
        {
          localFriendsManager.a(paramToServiceMsg);
          a(19, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (RenameGroupResp)localObject2));
          return;
          paramToServiceMsg = new Groups();
          paramToServiceMsg.group_id = ((int)((RenameGroupResp)localObject2).dwSequence);
        }
      case 2: 
        paramToServiceMsg = new DelGroupResp();
        if (bool)
        {
          paramToServiceMsg.dwToUin = ((ByteBuffer)localObject1).getInt();
          paramToServiceMsg.dwSequence = ((ByteBuffer)localObject1).getInt();
          paramToServiceMsg.cGroupid = ((ByteBuffer)localObject1).get();
        }
        a(paramToServiceMsg, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, paramToServiceMsg));
        return;
      case 3: 
        label301:
        label492:
        localObject2 = new ReSortGroupResp();
        if (bool)
        {
          ((ReSortGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((ReSortGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          localFriendsManager.a(paramToServiceMsg.extraData.getByteArray("group_id_list"), paramToServiceMsg.extraData.getByteArray("sort_id_list"));
        }
        a(22, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (ReSortGroupResp)localObject2));
        return;
      }
    }
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject = (GetRichSigRes)paramObject;
    paramObject = paramToServiceMsg.extraData.getStringArray("sendArray");
    if ((localObject == null) || (((GetRichSigRes)localObject).cResult != 0) || (((GetRichSigRes)localObject).vstSigInfo == null) || (((GetRichSigRes)localObject).vstSigInfo.size() == 0))
    {
      a(65, false, new Object[] { paramObject, null });
      c(paramToServiceMsg);
      return;
    }
    HashMap localHashMap = new HashMap(paramObject.length);
    localObject = ((GetRichSigRes)localObject).vstSigInfo.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject).next();
      localHashMap.put(Long.toString(localResRichSigInfo.lUin), RichStatus.parseStatus(localResRichSigInfo.vbSigInfo));
    }
    a(65, true, new Object[] { paramObject, localHashMap });
    c(paramToServiceMsg);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, Oidb_0x5d1.RspBody paramRspBody)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    int i = paramRspBody.uint32_cmd.get();
    long l1 = paramToServiceMsg.extraData.getLong("friendUin");
    String str = "";
    long l2;
    int j;
    boolean bool1;
    label258:
    boolean bool2;
    if ((i == 1) && (paramRspBody.msg_set_friend_id.has()))
    {
      paramToServiceMsg = (Oidb_0x5d1.SetFriendIdRsp)paramRspBody.msg_set_friend_id.get();
      l2 = paramToServiceMsg.uint64_seq.get();
      j = paramToServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + l1 + " cmd:" + i + "result : " + j + " newSeq:" + l2);
      }
      if (j == 0)
      {
        paramRspBody = localFriendsManager.c(String.valueOf(l1));
        paramToServiceMsg = str;
        if (paramRspBody != null)
        {
          paramRspBody.setShieldFlag(true);
          localFriendsManager.a(paramRspBody);
          paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          l2 = MessageCache.a();
          paramRspBody = MessageRecordFactory.a(-2012);
          paramRspBody.init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, "你已屏蔽%s的会话", l2, 0, 0, l2);
          paramRspBody.msgtype = -2012;
          paramRspBody.isread = true;
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRspBody, paramToServiceMsg);
          paramToServiceMsg = str;
        }
        if (j != 0) {
          break label327;
        }
        bool1 = true;
        if (j != 0) {
          break label333;
        }
        bool2 = true;
        label266:
        a(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(true), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
      }
    }
    label327:
    label333:
    label625:
    label631:
    do
    {
      return;
      paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
      break;
      bool1 = false;
      break label258;
      bool2 = false;
      break label266;
      if ((i == 2) && (paramRspBody.msg_clear_friend_id.has()))
      {
        paramToServiceMsg = (Oidb_0x5d1.ClearFriendIdRsp)paramRspBody.msg_clear_friend_id.get();
        l2 = paramToServiceMsg.uint64_seq.get();
        j = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagResp : uin : " + l1 + " cmd:" + i + "result : " + j + " newSeq:" + l2);
        }
        if (j == 0)
        {
          paramToServiceMsg = localFriendsManager.c(String.valueOf(l1));
          if (paramToServiceMsg != null)
          {
            paramToServiceMsg.setShieldFlag(false);
            localFriendsManager.a(paramToServiceMsg);
            paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
            l2 = MessageCache.a();
            paramRspBody = MessageRecordFactory.a(-2012);
            paramRspBody.init(paramToServiceMsg, String.valueOf(l1), paramToServiceMsg, "你已允许接收%s的会话", l2, 0, 0, l2);
            paramRspBody.msgtype = -2012;
            paramRspBody.isread = true;
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramRspBody, paramToServiceMsg);
          }
          paramToServiceMsg = "";
          if (j != 0) {
            break label625;
          }
          bool1 = true;
          if (j != 0) {
            break label631;
          }
        }
        for (bool2 = true;; bool2 = false)
        {
          a(56, bool1, new Object[] { Long.valueOf(l1), Boolean.valueOf(false), Boolean.valueOf(bool2), Boolean.valueOf(false), paramToServiceMsg });
          return;
          paramToServiceMsg = paramToServiceMsg.bytes_error_msg.get().toStringUtf8();
          break;
          bool1 = false;
          break label556;
        }
      }
    } while (!QLog.isColorLevel());
    label556:
    QLog.d("FriendListHandler", 2, "<---handleSetFriendShieldFlagResp : cmd:" + i);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, boolean paramBoolean)
  {
    int j = paramToServiceMsg.extraData.getInt("bType");
    String str = String.valueOf(paramToServiceMsg.extraData.getLong("lToMID"));
    int k = paramToServiceMsg.extraData.getByte("bGroupId");
    int i = j;
    if (j == 1) {
      i = 2;
    }
    if (i == 0)
    {
      paramToServiceMsg.extraData.getString("strNickName");
      a(str, k, 3999, null, false, false, -1L);
    }
    paramToServiceMsg = str + "_answer_added_" + paramToServiceMsg.extraData.getLong("infotime", 0L) + paramToServiceMsg.extraData.getLong("dbid", 0L);
    ContactConfig.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), paramToServiceMsg, i);
    a(10, true, new Object[] { str, Integer.valueOf(i) });
  }
  
  private void a(AddFriendResp paramAddFriendResp, ToServiceMsg paramToServiceMsg)
  {
    Bundle localBundle = new Bundle();
    localBundle.putAll(paramToServiceMsg.extraData);
    if (paramAddFriendResp == null)
    {
      a(11, false, localBundle);
      return;
    }
    localBundle.putInt("resultCode", paramAddFriendResp.result);
    localBundle.putString("ErrorString", paramAddFriendResp.ErrorString);
    if (paramAddFriendResp.result == 0)
    {
      paramToServiceMsg = paramToServiceMsg.extraData;
      boolean bool1 = paramToServiceMsg.getBoolean("auto_send", false);
      int j = paramToServiceMsg.getInt("source_id");
      String str1 = paramToServiceMsg.getString("uin");
      int k = paramToServiceMsg.getInt("friend_setting");
      boolean bool2 = paramToServiceMsg.getBoolean("contact_bothway");
      String str2 = paramToServiceMsg.getString("remark");
      int i;
      if ((bool1) && (AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, j, bool2)))
      {
        i = 1;
        if ((!bool1) || (i == 0) || (paramAddFriendResp.adduin == 0L)) {
          break label348;
        }
        a(String.valueOf(paramAddFriendResp.adduin), paramAddFriendResp.myfriendgroupid, j, paramToServiceMsg.getString("src_name"), true, false, -1L);
        label192:
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("$handleAddFriend|autoSend=").append(bool1).append(",uin").append(paramAddFriendResp.adduin).append(",sourceId=").append(j).append(",beBothWay=").append(bool2).append(",successDirectly=").append(AutoRemarkActivity.a(paramAddFriendResp.adduinsetting, j, bool2));
          QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
        }
        localBundle.putByteArray("sig", paramAddFriendResp.sig);
        localBundle.putString("result_uin", String.valueOf(paramAddFriendResp.adduin));
        if ((!bool1) || (i == 0)) {
          break label380;
        }
      }
      label348:
      label380:
      for (bool1 = true;; bool1 = false)
      {
        localBundle.putBoolean("addDirect", bool1);
        a(11, true, localBundle);
        return;
        i = 0;
        break;
        if (!EAddFriendSourceID.a(j)) {
          break label192;
        }
        ((PhoneContactManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(str1, k, str2);
        break label192;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "ErrorString" + paramAddFriendResp.ErrorString + "resultCode" + paramAddFriendResp.result);
    }
    a(11, true, localBundle);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2, short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getFriendGroupList " + paramBoolean1 + ", " + paramString + ", " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ", " + paramLong);
    }
    if (!paramBoolean1)
    {
      if (((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).e()) {
        a(1, true, null);
      }
    }
    else {
      a(1, true, Boolean.valueOf(false));
    }
    paramString = a("friendlist.getFriendGroupList");
    paramString.setEnableFastResend(true);
    paramString.extraData.putLong("timeStamp", paramLong);
    paramString.extraData.putStringArrayList("uinList", paramArrayList);
    paramString.extraData.putShort("friendStartIndex", (short)paramInt1);
    paramString.extraData.putShort("friendTotalCount", paramShort);
    paramString.extraData.putShort("friendCount", (short)paramInt2);
    paramString.extraData.putByte("groupStartIndex", (byte)paramInt3);
    paramString.extraData.getByte("groupCount", (byte)paramInt4);
    paramString.extraData.putLong("startTime", System.currentTimeMillis());
    paramString.extraData.putByte("ifShowTermType", (byte)1);
    paramString.extraData.putBoolean("is_manual_pull_refresh", paramBoolean2);
    a(paramString);
  }
  
  private void a(String paramString, GetFriendListResp paramGetFriendListResp, ToServiceMsg paramToServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getLong("timeStamp");
    ArrayList localArrayList1 = paramToServiceMsg.extraData.getStringArrayList("uinList");
    boolean bool3 = paramToServiceMsg.extraData.getBoolean("is_manual_pull_refresh");
    int k = paramGetFriendListResp.startIndex;
    int m = paramGetFriendListResp.friend_count;
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "handleGetFriendList " + paramGetFriendListResp.result + ", " + paramGetFriendListResp.serverTime + ", " + k + ", " + m + " totalCount=" + paramGetFriendListResp.totoal_friend_count);
    }
    int i;
    if (paramGetFriendListResp.result == 1)
    {
      QLog.e("FriendListHandler", 2, "handleGetFriendList fail code");
      a(1, false, Boolean.valueOf(false));
      a(99, false, null);
      if (paramToServiceMsg.extraData.getShort("friendTotalCount") == 0) {}
      for (i = paramGetFriendListResp.totoal_friend_count;; i = paramToServiceMsg.extraData.getShort("friendTotalCount"))
      {
        a(false, i, paramToServiceMsg.extraData.getShort("friendStartIndex"), 1);
        return;
      }
    }
    TraceUtils.a("handleGetFriendList");
    if (k == 0)
    {
      this.jdField_d_of_type_Int = 0;
      l = System.currentTimeMillis();
    }
    b(paramGetFriendListResp.cShowPcIcon);
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    ApolloManager localApolloManager = (ApolloManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(152);
    VasFaceManager localVasFaceManager = ((VasExtensionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(234)).a;
    Object localObject3 = (FontManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(41);
    Object localObject2;
    if ((paramGetFriendListResp.stSelfInfo != null) && (k == 0))
    {
      localObject4 = paramGetFriendListResp.stSelfInfo;
      localObject2 = localFriendsManager.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject2 = new Friends();
        ((Friends)localObject2).name = ((FriendInfo)localObject4).nick;
        ((Friends)localObject2).remark = ((FriendInfo)localObject4).remark;
        ((Friends)localObject2).uin = String.valueOf(((FriendInfo)localObject4).friendUin);
        ((Friends)localObject2).cSpecialFlag = ((FriendInfo)localObject4).cSpecialFlag;
        ((Friends)localObject2).detalStatusFlag = ((FriendInfo)localObject4).detalStatusFlag;
        ((Friends)localObject2).alias = ((FriendInfo)localObject4).sShowName;
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("FriendListHandler", 2, "handleGetFriendList uin=" + ((Friends)localObject2).uin + ", cSpecialFlag=" + ((Friends)localObject2).cSpecialFlag);
          localObject1 = localObject2;
        }
      }
      ((Friends)localObject1).abilityBits = ((FriendInfo)localObject4).uAbiFlag;
      ((Friends)localObject1).eNetwork = ((FriendInfo)localObject4).eNetworkType;
      ((Friends)localObject1).groupid = -1;
      ((Friends)localObject1).qqVipInfo = a(((FriendInfo)localObject4).oVipInfo, EVIPSPEC.E_SP_QQVIP.value(), ((Friends)localObject1).qqVipInfo);
      ((Friends)localObject1).superQqInfo = a(((FriendInfo)localObject4).oVipInfo, EVIPSPEC.E_SP_SUPERQQ.value(), ((Friends)localObject1).superQqInfo);
      ((Friends)localObject1).superVipInfo = a(((FriendInfo)localObject4).oVipInfo, EVIPSPEC.E_SP_SUPERVIP.value(), ((Friends)localObject1).superVipInfo);
      ((Friends)localObject1).namePlateOfKingGameId = ((FriendInfo)localObject4).uGameAppid;
      ((Friends)localObject1).namePlateOfKingLoginTime = ((FriendInfo)localObject4).uGameLastLoginTime;
      ((Friends)localObject1).namePlateOfKingDan = ((int)((FriendInfo)localObject4).ulKingOfGloryRank);
      if (((FriendInfo)localObject4).cKingOfGloryFlag != 1) {
        break label885;
      }
    }
    int j;
    label885:
    for (boolean bool1 = true;; bool1 = false)
    {
      ((Friends)localObject1).namePlateOfKingDanDisplatSwitch = bool1;
      localFriendsManager.a((Friends)localObject1);
      localVasFaceManager.b(((Friends)localObject1).uin, (int)((FriendInfo)localObject4).uFaceStoreId);
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler.selfFontEffect", 2, "self fontEffect: " + (int)((FriendInfo)localObject4).uFontEffect);
      }
      ((FontManager)localObject3).a(((Friends)localObject1).uin, (int)((FriendInfo)localObject4).uFontEffect);
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(), ((Friends)localObject1).namePlateOfKingDanDisplatSwitch).apply();
      if (paramGetFriendListResp.vecGroupInfo == null) {
        break label998;
      }
      j = paramGetFriendListResp.vecGroupInfo.size();
      localObject1 = new Groups[j];
      i = 0;
      while (i < j)
      {
        localObject2 = (GroupInfo)paramGetFriendListResp.vecGroupInfo.get(i);
        localObject3 = new Groups();
        ((Groups)localObject3).group_id = ((GroupInfo)localObject2).groupId;
        ((Groups)localObject3).group_name = ((GroupInfo)localObject2).groupname;
        ((Groups)localObject3).group_friend_count = ((GroupInfo)localObject2).friend_count;
        ((Groups)localObject3).seqid = ((GroupInfo)localObject2).seqid;
        ((Groups)localObject3).datetime = l;
        localObject1[i] = localObject3;
        i += 1;
      }
    }
    if ((j > 0) && (QLog.isColorLevel()))
    {
      localObject2 = (GroupInfo)paramGetFriendListResp.vecGroupInfo.get(0);
      QLog.d("Q.contacttab.friend", 2, "handleGetFriendList " + Utils.a(((GroupInfo)localObject2).groupname) + ", " + ((GroupInfo)localObject2).friend_count + ", " + ((GroupInfo)localObject2).sqqOnLine_count + ", " + ((GroupInfo)localObject2).seqid);
    }
    localFriendsManager.a((Groups[])localObject1);
    label998:
    int n = paramGetFriendListResp.vecFriendInfo.size();
    this.jdField_d_of_type_Int += n;
    localObject3 = new Friends[n];
    Object localObject4 = new ArrayList(n);
    ArrayList localArrayList2 = new ArrayList(n);
    Object localObject7;
    ArrayList localArrayList3;
    ArrayList localArrayList4;
    HashMap localHashMap;
    ArrayList localArrayList5;
    ArrayList localArrayList6;
    Object localObject6;
    Object localObject5;
    label1137:
    FriendInfo localFriendInfo;
    Friends localFriends;
    boolean bool2;
    if (k + m >= paramGetFriendListResp.totoal_friend_count)
    {
      bool1 = true;
      localObject7 = QvipSpecialCareManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      localArrayList3 = new ArrayList();
      localArrayList4 = new ArrayList();
      localHashMap = new HashMap();
      localArrayList5 = new ArrayList();
      localArrayList6 = new ArrayList();
      localObject6 = new ArrayList();
      localObject5 = new ArrayList();
      i = 0;
      if (i >= n) {
        break label2797;
      }
      localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(i);
      localFriends = new Friends();
      localObject3[i] = localFriends;
      localFriends.name = localFriendInfo.nick;
      localFriends.remark = localFriendInfo.remark;
      localFriends.uin = String.valueOf(localFriendInfo.friendUin);
      localArrayList1.add(localFriends.uin);
      localFriends.groupid = localFriendInfo.groupId;
      localFriends.cSpecialFlag = localFriendInfo.cSpecialFlag;
      localFriends.detalStatusFlag = localFriendInfo.detalStatusFlag;
      localFriends.datetime = l;
      localFriends.alias = localFriendInfo.sShowName;
      localFriends.abilityBits = localFriendInfo.uAbiFlag;
      localFriends.eNetwork = localFriendInfo.eNetworkType;
      localFriends.netTypeIconId = localFriendInfo.eIconType;
      localFriends.strTermDesc = localFriendInfo.strTermDesc;
      localFriends.setShieldFlag(false);
      localFriends.namePlateOfKingGameId = localFriendInfo.uGameAppid;
      localFriends.namePlateOfKingLoginTime = localFriendInfo.uGameLastLoginTime;
      localFriends.namePlateOfKingDan = ((int)localFriendInfo.ulKingOfGloryRank);
      if (localFriendInfo.cKingOfGloryFlag != 1) {
        break label2479;
      }
      bool2 = true;
      label1354:
      localFriends.namePlateOfKingDanDisplatSwitch = bool2;
      localFriends.strMasterUin = localFriendInfo.strMasterUin;
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "handleGetFriendList 2 uin=" + localFriends.uin + ", cSpecialFlag=" + localFriends.cSpecialFlag);
      }
      if ((!TextUtils.isEmpty(localFriends.uin)) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c().equals(localFriends.uin))) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences("sp_plate_of_king", 0).edit().putBoolean("plate_of_king_display_switch_" + this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(), localFriends.namePlateOfKingDanDisplatSwitch).apply();
      }
      if (localFriendInfo.cOlympicTorch != 1) {
        break label2485;
      }
      bool2 = true;
      label1522:
      localFriends.setOlympicTorchFlag(bool2);
      localObject1 = localFriendsManager.c(localFriends.uin);
      localFriends.iTermType = localFriendInfo.iTermType;
      localObject2 = localFriendInfo.oVipInfo;
      int i1 = EVIPSPEC.E_SP_QQVIP.value();
      if (localObject1 == null) {
        break label2491;
      }
      j = ((Friends)localObject1).qqVipInfo;
      label1578:
      localFriends.qqVipInfo = a((VipBaseInfo)localObject2, i1, j);
      localObject2 = localFriendInfo.oVipInfo;
      i1 = EVIPSPEC.E_SP_SUPERQQ.value();
      if (localObject1 == null) {
        break label2497;
      }
      j = ((Friends)localObject1).superQqInfo;
      label1619:
      localFriends.superQqInfo = a((VipBaseInfo)localObject2, i1, j);
      localObject2 = localFriendInfo.oVipInfo;
      i1 = EVIPSPEC.E_SP_SUPERVIP.value();
      if (localObject1 == null) {
        break label2503;
      }
      j = ((Friends)localObject1).superVipInfo;
      label1660:
      localFriends.superVipInfo = a((VipBaseInfo)localObject2, i1, j);
      if (localObject1 != null)
      {
        localFriends.showLoginClient = ((Friends)localObject1).showLoginClient;
        localFriends.lastLoginType = ((Friends)localObject1).lastLoginType;
      }
      if ((localObject1 != null) && (QQProfileItem.a(localFriends.name, ((Friends)localObject1).name)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.friend", 2, "handleGetFriendList friend Name changed.oldName " + ((Friends)localObject1).name + ",newName " + localFriends.name + ",oldRemark " + ((Friends)localObject1).remark + ",newRemark =" + localFriends.remark);
        }
        ((ArrayList)localObject6).add(localFriends);
      }
      if ((localObject1 != null) && (!TextUtils.isEmpty(localFriendInfo.nick)) && (!localFriendInfo.nick.equals(localFriendInfo.remark)) && (QQProfileItem.b(localFriends.remark, ((Friends)localObject1).remark)))
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.contacttab.friend", 2, "handleGetFriendList friend remark changed.oldName " + ((Friends)localObject1).name + ",newName " + localFriends.name + ",oldRemark " + ((Friends)localObject1).remark + ",newRemark =" + localFriends.remark);
        }
        ((ArrayList)localObject5).add(localFriends);
      }
      if (localObject1 != null)
      {
        if (((Friends)localObject1).gathtertype != 1) {
          break label2509;
        }
        localFriends.gathtertype = 1;
        label1962:
        localFriends.age = ((Friends)localObject1).age;
        localFriends.smartRemark = ((Friends)localObject1).smartRemark;
        localFriends.gender = ((Friends)localObject1).gender;
        localFriends.recommReason = ((Friends)localObject1).recommReason;
      }
      localObject2 = localFriendsManager.a(String.valueOf(localFriends.uin));
      j = localFriendInfo.cSpecialFlag >> 3 & 0x1;
      if (localObject2 != null) {
        break label2527;
      }
      localObject1 = new ExtensionInfo();
      ((ExtensionInfo)localObject1).uin = String.valueOf(localFriends.uin);
      ((ExtensionInfo)localObject1).pendantId = localFriendInfo.ulFaceAddonId;
      ((ExtensionInfo)localObject1).uVipFont = FontManager.a(localFriendInfo.uFounderFont);
      ((ExtensionInfo)localObject1).vipFontType = FontManager.b(localFriendInfo.uFounderFont);
      ((ExtensionInfo)localObject1).magicFont = j;
      ((ExtensionInfo)localObject1).colorRingId = localFriendInfo.uColorRing;
      ((ExtensionInfo)localObject1).timestamp = l;
      ((ExtensionInfo)localObject1).fontEffect = ((int)localFriendInfo.uFontEffect);
      ((ExtensionInfo)localObject1).fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      ((ArrayList)localObject4).add(localObject1);
      label2142:
      ((ExtensionInfo)localObject1).faceId = ((int)localFriendInfo.uFaceStoreId);
      ((ExtensionInfo)localObject1).faceIdUpdateTime = NetConnInfoCenter.getServerTime();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendList, Get Extension, uin=" + ((ExtensionInfo)localObject1).uin + ", id=" + ((ExtensionInfo)localObject1).pendantId + ",font=" + ((ExtensionInfo)localObject1).uVipFont + ", fontType = " + ((ExtensionInfo)localObject1).vipFontType + ", magicfont = " + j + ",latestplNewsTs=" + ((ExtensionInfo)localObject1).latestPLUpdateTimestamp + ",medalUpdateTimestamp=" + ((ExtensionInfo)localObject1).medalUpdateTimestamp + ",fontEffect=" + ((ExtensionInfo)localObject1).fontEffect + ",fontEffectLastUpdateTime=" + ((ExtensionInfo)localObject1).fontEffectLastUpdateTime);
      }
      localObject2 = new SpecialCareInfo();
      a(localFriendInfo.vecRing, (ExtensionInfo)localObject1, localFriends, (Set)localObject7, localArrayList3, localArrayList4, localHashMap, localArrayList5, (SpecialCareInfo)localObject2, l);
      if (((SpecialCareInfo)localObject2).globalSwitch != 0) {
        localArrayList6.add(localObject2);
      }
      localObject1 = localApolloManager.b(localFriends.uin);
      if (localObject1 == null) {
        break label2758;
      }
      if ((((ApolloBaseInfo)localObject1).apolloStatus != localFriendInfo.cApolloFlag) || (((ApolloBaseInfo)localObject1).apolloServerTS != localFriendInfo.uApolloTimestamp) || (((ApolloBaseInfo)localObject1).apolloSignValidTS != localFriendInfo.uApolloSignTime))
      {
        ((ApolloBaseInfo)localObject1).apolloStatus = localFriendInfo.cApolloFlag;
        ((ApolloBaseInfo)localObject1).apolloServerTS = localFriendInfo.uApolloTimestamp;
        ((ApolloBaseInfo)localObject1).apolloSignValidTS = localFriendInfo.uApolloSignTime;
        ((ApolloBaseInfo)localObject1).apolloSignStr = "";
        localArrayList2.add(localObject1);
      }
    }
    for (;;)
    {
      i += 1;
      break label1137;
      bool1 = false;
      break;
      label2479:
      bool2 = false;
      break label1354;
      label2485:
      bool2 = false;
      break label1522;
      label2491:
      j = 0;
      break label1578;
      label2497:
      j = 0;
      break label1619;
      label2503:
      j = 0;
      break label1660;
      label2509:
      if (((Friends)localObject1).gathtertype != 2) {
        break label1962;
      }
      localFriends.gathtertype = 2;
      break label1962;
      label2527:
      if ((((ExtensionInfo)localObject2).pendantId == localFriendInfo.ulFaceAddonId) && (((ExtensionInfo)localObject2).uVipFont == FontManager.a(localFriendInfo.uFounderFont)) && (((ExtensionInfo)localObject2).vipFontType == FontManager.b(localFriendInfo.uFounderFont)) && (((ExtensionInfo)localObject2).colorRingId == localFriendInfo.uColorRing) && (((ExtensionInfo)localObject2).magicFont == j) && (((ExtensionInfo)localObject2).latestPLUpdateTimestamp == localFriendInfo.uTagUpdateTime) && (((ExtensionInfo)localObject2).medalUpdateTimestamp == localFriendInfo.uLastMedalUpdateTime))
      {
        localObject1 = localObject2;
        if (((ExtensionInfo)localObject2).fontEffect == (int)localFriendInfo.uFontEffect) {
          break label2142;
        }
      }
      ((ExtensionInfo)localObject2).pendantId = localFriendInfo.ulFaceAddonId;
      ((ExtensionInfo)localObject2).uVipFont = FontManager.a(localFriendInfo.uFounderFont);
      ((ExtensionInfo)localObject2).vipFontType = FontManager.b(localFriendInfo.uFounderFont);
      ((ExtensionInfo)localObject2).magicFont = j;
      ((ExtensionInfo)localObject2).colorRingId = localFriendInfo.uColorRing;
      ((ExtensionInfo)localObject2).timestamp = l;
      ((ExtensionInfo)localObject2).latestPLUpdateTimestamp = localFriendInfo.uTagUpdateTime;
      ((ExtensionInfo)localObject2).medalUpdateTimestamp = localFriendInfo.uLastMedalUpdateTime;
      ((ExtensionInfo)localObject2).fontEffect = ((int)localFriendInfo.uFontEffect);
      ((ExtensionInfo)localObject2).fontEffectLastUpdateTime = NetConnInfoCenter.getServerTime();
      ((ArrayList)localObject4).add(localObject2);
      localObject1 = localObject2;
      break label2142;
      label2758:
      if (QLog.isColorLevel()) {
        QLog.e("FriendListHandler", 2, "apolloBaseInfo return null uin: " + localFriends.uin);
      }
    }
    label2797:
    Object localObject1 = (DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52);
    if (((ArrayList)localObject6).size() > 0)
    {
      localObject2 = ((ArrayList)localObject6).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject6 = (Friends)((Iterator)localObject2).next();
        localObject7 = ((Friends)localObject6).name;
        QQProfileItem.a(Long.parseLong(((Friends)localObject6).uin), (String)localObject7, (DiscussionManager)localObject1);
      }
    }
    if (((ArrayList)localObject5).size() > 0)
    {
      localObject2 = ((ArrayList)localObject5).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject5 = (Friends)((Iterator)localObject2).next();
        localObject6 = ((Friends)localObject5).remark;
        QQProfileItem.b(Long.parseLong(((Friends)localObject5).uin), (String)localObject6, (DiscussionManager)localObject1);
      }
    }
    if ((n > 0) && (QLog.isColorLevel()))
    {
      localObject1 = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
      QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendList uin=" + ((FriendInfo)localObject1).friendUin + " | eNetwork=" + ((FriendInfo)localObject1).eNetworkType + " | iTermType=" + ((FriendInfo)localObject1).iTermType + " | abilityBits=" + ((FriendInfo)localObject1).uAbiFlag + " | name=" + Utils.a(((FriendInfo)localObject1).nick) + " | netTypeIconId=" + ((FriendInfo)localObject1).eIconType + " | detalStatusFlag=" + ((FriendInfo)localObject1).detalStatusFlag + " | isMqqOnLine=" + ((FriendInfo)localObject1).isMqqOnLine + " | netTypeIconIdIphoneOrWphoneNoWifi=" + ((FriendInfo)localObject1).eIconType + " | hasTorch=" + ((FriendInfo)localObject1).cOlympicTorch);
    }
    QidianManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, (Friends[])localObject3);
    localFriendsManager.a((Friends[])localObject3, l, bool1);
    localFriendsManager.b((List)localObject4);
    localVasFaceManager.a((Collection)localObject4);
    localFriendsManager.a(localArrayList6, l, bool1);
    localApolloManager.b(localArrayList2);
    QvipSpecialCareManager.a(localArrayList3, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    QvipSpecialCareManager.b(localArrayList4, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    QvipSpecialCareManager.a(localHashMap, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    QvipSpecialCareManager.c(localArrayList5, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    TraceUtils.a();
    if (!bool1)
    {
      a(paramString, k + m, 200, 0, 0, l, localArrayList1, true, bool3, paramGetFriendListResp.totoal_friend_count);
      a(1, true, Boolean.valueOf(false));
      a(99, true, new Object[] { Boolean.valueOf(false), null });
      return;
    }
    if (paramToServiceMsg.extraData.getShort("friendTotalCount") == 0)
    {
      i = paramGetFriendListResp.totoal_friend_count;
      a(true, i, paramToServiceMsg.extraData.getShort("friendStartIndex"), 0);
      this.jdField_b_of_type_Long = 0L;
      this.jdField_d_of_type_Int = 0;
      paramString = new StringBuilder().append("actual friend count is ");
      if (this.jdField_d_of_type_Int != paramGetFriendListResp.totoal_friend_count) {
        break label3584;
      }
      bool1 = true;
      label3348:
      QLog.d("FriendListHandler", 2, bool1);
      paramString = (PhoneContactManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
      if (paramString != null)
      {
        paramString.d();
        if (!bool3) {
          paramString.b();
        }
      }
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.y();
      a(1, true, Boolean.valueOf(true));
      a(99, true, new Object[] { Boolean.valueOf(true), null });
      if (!localArrayList1.isEmpty())
      {
        paramString = new String[localArrayList1.size()];
        localArrayList1.toArray(paramString);
        localArrayList1.clear();
        if (!this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a.c()) {
          break label3590;
        }
        a(paramString);
      }
    }
    for (;;)
    {
      a(localFriendsManager);
      l = paramGetFriendListResp.serverTime;
      this.jdField_c_of_type_Long = l;
      i = 1;
      while (i < 16)
      {
        if (i != 13) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("inccheckupdatetimeStamp" + i, l).commit();
        }
        i += 1;
      }
      i = paramToServiceMsg.extraData.getShort("friendTotalCount");
      break;
      label3584:
      bool1 = false;
      break label3348;
      label3590:
      this.jdField_a_of_type_ArrayOfJavaLangString = paramString;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler in handleGetFriendList() to getGatheredContactsList()");
    }
    a(0);
  }
  
  private static void a(String paramString, byte[] paramArrayOfByte, ExtensionInfo paramExtensionInfo)
  {
    int i8 = paramArrayOfByte.length;
    int j = 0;
    int i = 0;
    if (i8 >= 3)
    {
      j = paramArrayOfByte[0] & 0xFF;
      i = (paramArrayOfByte[1] << 8 & 0xFF00) + (paramArrayOfByte[2] & 0xFF);
      paramExtensionInfo.praiseHotLevel = j;
      paramExtensionInfo.praiseDays = i;
    }
    int m = 0;
    int k = 0;
    if (i8 >= 6)
    {
      m = paramArrayOfByte[3] & 0xFF;
      k = (paramArrayOfByte[4] << 8 & 0xFF00) + (paramArrayOfByte[5] & 0xFF);
      paramExtensionInfo.chatHotLevel = m;
      paramExtensionInfo.chatDays = k;
    }
    int i1 = 0;
    int n = 0;
    if (i8 >= 9)
    {
      i1 = paramArrayOfByte[6] & 0xFF;
      n = (paramArrayOfByte[7] << 8 & 0xFF00) + (paramArrayOfByte[8] & 0xFF);
      paramExtensionInfo.bestIntimacyType = i1;
      paramExtensionInfo.bestIntimacyDays = n;
    }
    int i2 = 0;
    if (i8 >= 11)
    {
      i2 = (paramArrayOfByte[9] << 8 & 0xFF00) + (paramArrayOfByte[10] & 0xFF);
      paramExtensionInfo.lastpraiseTime = (86400 * i2 - 28800);
    }
    int i3 = 0;
    if (i8 >= 13)
    {
      i3 = (paramArrayOfByte[11] << 8 & 0xFF00) + (paramArrayOfByte[12] & 0xFF);
      paramExtensionInfo.lastChatTime = (86400 * i3 - 28800);
    }
    int i6 = 0;
    int i5 = 0;
    int i4 = 0;
    if (i8 >= 18)
    {
      i6 = paramArrayOfByte[13] & 0xFF;
      i4 = paramArrayOfByte[14];
      i5 = (paramArrayOfByte[15] & 0xFF) + (i4 << 8 & 0xFF00);
      i4 = (paramArrayOfByte[16] << 8 & 0xFF00) + (paramArrayOfByte[17] & 0xFF);
      paramExtensionInfo.qzoneVisitType = i6;
      paramExtensionInfo.qzoneHotDays = i5;
      paramExtensionInfo.lastQzoneVisitTime = (86400 * i4 - 28800);
    }
    if (i8 >= 24)
    {
      i7 = paramArrayOfByte[18];
      int i9 = paramArrayOfByte[19];
      int i10 = paramArrayOfByte[20];
      int i11 = paramArrayOfByte[21];
      int i12 = paramArrayOfByte[22];
      int i13 = paramArrayOfByte[23];
      paramExtensionInfo.loverChatLevel = (i7 & 0xFF);
      paramExtensionInfo.loverChatDays = ((i9 << 8 & 0xFF00) + (i10 & 0xFF));
      paramExtensionInfo.loverLastChatTime = (86400 * ((i11 << 8 & 0xFF00) + (i12 & 0xFF)) - 28800);
      paramExtensionInfo.loverFlag = (i13 & 0xFF);
    }
    if (i8 >= 25) {}
    for (int i7 = paramArrayOfByte[24] & 0xFF;; i7 = 0)
    {
      if (i7 != 0) {}
      for (boolean bool = true;; bool = false)
      {
        paramExtensionInfo.loverTransFlag = bool;
        if (HotReactiveHelper.a())
        {
          paramExtensionInfo.hasRemindChat = false;
          paramExtensionInfo.hasRemindPraise = false;
          paramExtensionInfo.hasRemindQzoneVisit = false;
          paramExtensionInfo.hasRemindLoverChat = false;
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append(" FriendListHandler=== hotFriend uin: ").append(paramString).append(",dataLen=").append(i8).append(", praiseData=").append(j).append("|").append(i).append(",chatData=").append(m).append("|").append(k).append(",closeData=").append(i1).append("|").append(n).append(",lastpraiseTime=").append(i2).append(",lastChatTime=").append(i3).append(",qzoneLevel=").append(i6).append(",qzoneDay=").append(i5).append(",lastQzoneDay=").append(i4).append(",cLoverLevel=").append(paramExtensionInfo.loverChatLevel).append(",wLoverDay=").append(paramExtensionInfo.loverChatDays).append(",wLstLoverDay=").append(paramExtensionInfo.loverLastChatTime).append(",cLoverFlag=").append(paramExtensionInfo.loverFlag).append(",cTransFlag=").append(i7).append(",hasRemindChat=").append(paramExtensionInfo.hasRemindChat).append(",hasRemindPraise=").append(paramExtensionInfo.hasRemindPraise).append(",hasRemindQzoneVisit=").append(paramExtensionInfo.hasRemindQzoneVisit).append(",hasRemindLoverChat=").append(paramExtensionInfo.hasRemindLoverChat);
          QLog.i("FriendReactive", 2, paramArrayOfByte.toString());
        }
        return;
      }
    }
  }
  
  private void a(boolean paramBoolean, int paramInt1, short paramShort, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("reqGetStatus", str);
      localHashMap.put("currNetStatus", HttpUtil.a());
      localHashMap.put("friendListCount", "" + paramInt1);
      localHashMap.put("fromIndex", "" + paramShort);
      localHashMap.put("reqCountEveryPage", "200");
      localHashMap.put("retryCount", "" + this.jdField_c_of_type_Int);
      localHashMap.put("totalConsume", "" + (System.currentTimeMillis() - this.jdField_b_of_type_Long));
      localHashMap.put("errorCode", "" + paramInt2);
      StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "QQFriendListReqGetEvent", true, 0L, 0L, localHashMap, null);
      this.jdField_c_of_type_Int = 0;
      if (paramBoolean) {
        break;
      }
      this.jdField_b_of_type_Int += 1;
      if (this.jdField_a_of_type_Long == 0L) {
        this.jdField_a_of_type_Long = this.jdField_b_of_type_Long;
      }
      return;
    }
    g();
  }
  
  private void a(byte[] paramArrayOfByte, ExtensionInfo paramExtensionInfo, Friends paramFriends, SpecialCareInfo paramSpecialCareInfo, long paramLong)
  {
    Object localObject = new Oidb_0x5d0.SnsUpateBuffer();
    try
    {
      ((Oidb_0x5d0.SnsUpateBuffer)localObject).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.rpt_msg_sns_update_item.has())) {
        break label496;
      }
      localObject = paramArrayOfByte.rpt_msg_sns_update_item.get().iterator();
      while (((Iterator)localObject).hasNext())
      {
        Oidb_0x5d0.SnsUpdateItem localSnsUpdateItem = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject).next();
        if ((localSnsUpdateItem != null) && (localSnsUpdateItem.uint32_update_sns_type.has()) && (localSnsUpdateItem.bytes_value.has()))
        {
          paramSpecialCareInfo.uin = paramFriends.uin;
          paramSpecialCareInfo.dateTime = paramLong;
          int i = localSnsUpdateItem.uint32_update_sns_type.get();
          String str = localSnsUpdateItem.bytes_value.get().toStringUtf8();
          switch (i)
          {
          case 13569: 
          case 13570: 
          case 13571: 
          case 13574: 
          default: 
            break;
          case 13568: 
            QvipSpecialCareManager.a(String.valueOf(paramArrayOfByte.uint64_uin.get()), localSnsUpdateItem.bytes_value.get().toStringUtf8(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
            try
            {
              if (!TextUtils.isEmpty(str)) {
                break label336;
              }
              paramSpecialCareInfo.specialRingSwitch = 0;
            }
            catch (Exception localException1)
            {
              if (QLog.isColorLevel()) {
                QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", localException1);
              }
              paramSpecialCareInfo.specialRingSwitch = 0;
            }
            continue;
            if (Pattern.compile("[0-9]*").matcher(str).matches())
            {
              paramSpecialCareInfo.friendRingId = Integer.parseInt(str);
              paramSpecialCareInfo.specialRingSwitch = 1;
            }
            break;
          case 13573: 
            try
            {
              if (!TextUtils.isEmpty(str)) {
                break label411;
              }
              paramSpecialCareInfo.globalSwitch = 0;
            }
            catch (Exception localException2) {}
            if (QLog.isColorLevel())
            {
              QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", localException2);
              continue;
              paramSpecialCareInfo.globalSwitch = 1;
            }
            break;
          case 13572: 
            try
            {
              label411:
              if (!TextUtils.isEmpty(str)) {
                break label459;
              }
              paramSpecialCareInfo.qzoneSwitch = 0;
            }
            catch (Exception localException3) {}
            if (QLog.isColorLevel())
            {
              QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", localException3);
              continue;
              label459:
              paramSpecialCareInfo.qzoneSwitch = 1;
            }
            break;
          case 13575: 
            label336:
            a(String.valueOf(paramArrayOfByte.uint64_uin.get()), localException3.bytes_value.get().toByteArray(), paramExtensionInfo);
          }
        }
      }
      label496:
      paramArrayOfByte = paramFriends.uin;
      if (!QvipSpecialCareManager.a(paramArrayOfByte, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
        break label520;
      }
      QvipSpecialCareManager.b(paramArrayOfByte, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
      label520:
      if (!QvipSpecialCareManager.b(paramArrayOfByte, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
        return;
      }
      QvipSpecialCareManager.c(paramArrayOfByte, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.rpt_uin32_idlist.has()))
    {
      localObject = paramArrayOfByte.rpt_uin32_idlist.get().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (((Integer)((Iterator)localObject).next()).intValue() == 4051) {
          paramFriends.setShieldFlag(true);
        }
      }
    }
  }
  
  private void a(byte[] paramArrayOfByte, ExtensionInfo paramExtensionInfo, Friends paramFriends, Set paramSet, List paramList1, List paramList2, Map paramMap, List paramList3, SpecialCareInfo paramSpecialCareInfo, long paramLong)
  {
    Object localObject1 = new Oidb_0x5d0.SnsUpateBuffer();
    try
    {
      ((Oidb_0x5d0.SnsUpateBuffer)localObject1).mergeFrom(paramArrayOfByte);
      paramArrayOfByte = (byte[])localObject1;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        paramArrayOfByte = null;
      }
      if ((paramArrayOfByte == null) || (!paramArrayOfByte.rpt_msg_sns_update_item.has())) {
        break label802;
      }
      localObject1 = paramArrayOfByte.rpt_msg_sns_update_item.get().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (Oidb_0x5d0.SnsUpdateItem)((Iterator)localObject1).next();
        if ((localObject2 != null) && (((Oidb_0x5d0.SnsUpdateItem)localObject2).uint32_update_sns_type.has()) && (((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.has()))
        {
          paramSpecialCareInfo.uin = paramFriends.uin;
          paramSpecialCareInfo.dateTime = paramLong;
          int i = ((Oidb_0x5d0.SnsUpdateItem)localObject2).uint32_update_sns_type.get();
          String str1 = ((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.get().toStringUtf8();
          String str2 = String.valueOf(paramArrayOfByte.uint64_uin.get());
          label475:
          byte[] arrayOfByte;
          switch (i)
          {
          default: 
            break;
          case 13568: 
            localObject2 = ((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.get().toStringUtf8();
            if ((localObject2 == null) || (((String)localObject2).length() == 0))
            {
              if ((paramSet != null) && (paramSet.contains(str2))) {
                paramList2.add(str2);
              }
              if (QvipSpecialCareManager.b(str2, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
                paramList3.add(str2);
              }
            }
            for (;;)
            {
              try
              {
                if (!TextUtils.isEmpty(str1)) {
                  break label475;
                }
                paramSpecialCareInfo.specialRingSwitch = 0;
              }
              catch (Exception localException1)
              {
                if (QLog.isColorLevel()) {
                  QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", localException1);
                }
                paramSpecialCareInfo.specialRingSwitch = 0;
              }
              break;
              try
              {
                i = Integer.parseInt((String)localObject2);
                paramList1.add(str2);
                paramMap.put(str2, Integer.valueOf(i));
              }
              catch (Exception localException4) {}
              if (QLog.isColorLevel()) {
                QLog.i("FriendListHandler", 2, "dealWithRespSound|exception = " + localException4.toString());
              }
            }
            if (Pattern.compile("[0-9]*").matcher(localException1).matches())
            {
              paramSpecialCareInfo.friendRingId = Integer.parseInt(localException1);
              paramSpecialCareInfo.specialRingSwitch = 1;
            }
            break;
          case 13824: 
            arrayOfByte = ((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.get().toByteArray();
            int j = 0;
            i = j;
            if (arrayOfByte != null)
            {
              i = j;
              if (arrayOfByte.length >= 1)
              {
                j = arrayOfByte[0] & 0x2;
                i = j;
                if (j == 2)
                {
                  paramFriends.friendType = 1;
                  i = j;
                }
              }
            }
            if (QLog.isColorLevel()) {
              QLog.d("Q.contacttab.friend", 2, "handleGetFriendList | friend.uin : " + paramFriends.uin + " | friend.friendType : " + paramFriends.friendType + " | itemType : " + i);
            }
            break;
          case 13573: 
            try
            {
              if (!TextUtils.isEmpty(arrayOfByte)) {
                break label725;
              }
              paramSpecialCareInfo.globalSwitch = 0;
              if ((paramSet != null) && (paramSet.contains(localException4))) {
                paramList2.add(localException4);
              }
              if (!QvipSpecialCareManager.b(localException4, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
                continue;
              }
              paramList3.add(localException4);
            }
            catch (Exception localException2) {}
            if (QLog.isColorLevel())
            {
              QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", localException2);
              continue;
              paramSpecialCareInfo.globalSwitch = 1;
            }
            break;
          case 13572: 
            try
            {
              if (!TextUtils.isEmpty(localException2)) {
                break label773;
              }
              paramSpecialCareInfo.qzoneSwitch = 0;
            }
            catch (Exception localException3) {}
            if (QLog.isColorLevel())
            {
              QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", localException3);
              continue;
              label773:
              paramSpecialCareInfo.qzoneSwitch = 1;
            }
            break;
          case 13575: 
            label725:
            a(localException4, ((Oidb_0x5d0.SnsUpdateItem)localObject2).bytes_value.get().toByteArray(), paramExtensionInfo);
          }
        }
      }
      label802:
      paramArrayOfByte = paramFriends.uin;
      if ((paramSet == null) || (!paramSet.contains(paramArrayOfByte))) {
        break label832;
      }
      paramList2.add(paramArrayOfByte);
      label832:
      if (!QvipSpecialCareManager.b(paramArrayOfByte, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)) {
        return;
      }
      paramList3.add(paramArrayOfByte);
    }
    if ((paramArrayOfByte != null) && (paramArrayOfByte.rpt_uin32_idlist.has()))
    {
      localObject1 = paramArrayOfByte.rpt_uin32_idlist.get().iterator();
      while (((Iterator)localObject1).hasNext()) {
        if (((Integer)((Iterator)localObject1).next()).intValue() == 4051) {
          paramFriends.setShieldFlag(true);
        }
      }
    }
  }
  
  private void a(String[] paramArrayOfString, int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramInt1 >= paramArrayOfString.length) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "doGetRichStatus uinArray.lenth = " + paramArrayOfString.length + " reqType = " + paramInt2 + "pos = " + paramInt1);
    }
    int i = Math.min(50, paramArrayOfString.length - paramInt1);
    String[] arrayOfString = new String[i];
    System.arraycopy(paramArrayOfString, paramInt1, arrayOfString, 0, i);
    ToServiceMsg localToServiceMsg = a("ProfileService.GetRichSig");
    localToServiceMsg.extraData.putStringArray("totalArray", paramArrayOfString);
    localToServiceMsg.extraData.putInt("nextStartPos", i + paramInt1);
    localToServiceMsg.extraData.putStringArray("sendArray", arrayOfString);
    localToServiceMsg.extraData.putInt("reqType", paramInt2);
    localToServiceMsg.extraData.putBoolean("showDateNickname", paramBoolean);
    localToServiceMsg.extraData.putBundle("circleBundle", paramBundle);
    a(localToServiceMsg);
  }
  
  private void b(byte paramByte)
  {
    byte b1 = 1;
    boolean bool;
    if ((paramByte == 0) || (paramByte == 1))
    {
      if (paramByte != 1) {
        break label59;
      }
      bool = true;
      if (bool != d()) {
        if (!bool) {
          break label64;
        }
      }
    }
    label59:
    label64:
    for (paramByte = b1;; paramByte = 0)
    {
      this.g = paramByte;
      ContactConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), bool);
      return;
      bool = false;
      break;
    }
  }
  
  private void b(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    label103:
    Object localObject;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.flh", 2, "getQQHead, uin=" + paramString + ",headType=" + paramInt1 + ",idType=" + paramInt2 + ",level=" + paramByte1 + ",faceFileType=" + paramByte2);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramInt1 != 1) {
          break label103;
        }
        paramBoolean = Friends.isValidUin(paramString);
        if (paramBoolean) {
          break label103;
        }
      }
      for (;;)
      {
        return;
        localObject = paramInt1 + "_" + paramString;
        if (paramInt1 == 32) {
          localObject = "stranger_" + Integer.toString(paramInt2) + "_" + paramString;
        }
        if (paramInt1 == 16) {
          localObject = "qcall_" + Integer.toString(paramInt2) + "_" + paramString;
        }
        if (d((String)localObject)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead, noNeedDownload= " + (String)localObject);
        }
      }
      b((String)localObject, false);
    }
    finally {}
    boolean bool;
    label295:
    label356:
    int i;
    if ((this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a != null) && (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a.b()))
    {
      bool = true;
      if (!QLog.isColorLevel()) {
        break label614;
      }
      QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead end keyStr = " + (String)localObject + ",isImmediatelyGet=" + this.jdField_c_of_type_Boolean + ",InActionLoginB=" + bool);
      break label614;
      this.jdField_e_of_type_Int += 1;
      localObject = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i));
      if (localObject != null) {
        break label605;
      }
      localObject = new ArrayList();
      this.jdField_a_of_type_JavaUtilHashtable.put(Integer.valueOf(i), localObject);
      if (!QLog.isColorLevel()) {
        break label626;
      }
      QLog.d("Q.qqhead.flh", 2, "QQHEAD_TYPE_QCALL destQQHeadInfoTable.put(keyType, destQQHeadInfoList); keyType = " + i + "destQQHeadInfoTable.size = " + this.jdField_a_of_type_JavaUtilHashtable.size());
      break label626;
    }
    for (;;)
    {
      paramBoolean = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, paramString, paramInt2);
      for (;;)
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramBoolean)
        {
          Pair localPair = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(paramInt1, paramString, paramInt2);
          l1 = l2;
          if (localPair != null)
          {
            l1 = l2;
            if (localPair.second != null) {
              l1 = ((com.tencent.mobileqq.data.Setting)localPair.second).headImgTimestamp;
            }
          }
        }
        ((ArrayList)localObject).add(new FriendListHandler.QQHeadDetails(paramInt1, paramString, l1, paramByte1));
        if ((!this.jdField_c_of_type_Boolean) && (bool) && (!TextUtils.equals(paramString, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))) {
          break;
        }
        h();
        break;
        bool = false;
        break label295;
        paramBoolean = true;
        continue;
        paramBoolean = false;
      }
      label605:
      break label626;
      label614:
      do
      {
        i = paramInt1;
        break;
      } while (paramInt1 != 32);
      i = paramInt2;
      break label356;
      label626:
      switch (paramByte2)
      {
      }
    }
  }
  
  private void b(int paramInt, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i;
    switch (paramInt)
    {
    case 203: 
    default: 
      i = 0;
    }
    MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq;
    label321:
    for (;;)
    {
      localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
      localMultiBusidUrlReq.srcUidType.set(0);
      localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(1));
      localMultiBusidUrlReq.dstUsrType.add(Integer.valueOf(32));
      localMultiBusidUrlReq.dstUidType.set(i);
      int j = 0;
      label115:
      if (j < paramArrayList.size())
      {
        FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(j);
        MultiHeadUrl.ReqUsrInfo localReqUsrInfo = new MultiHeadUrl.ReqUsrInfo();
        if (i == 0) {}
        try
        {
          localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
          for (;;)
          {
            a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
            localMultiBusidUrlReq.dstUsrInfos.add(localReqUsrInfo);
            if (QLog.isColorLevel()) {
              QLog.i("multiBusidUrlReq.dstUsrInfos", 2, " multiBusidUrlReq.dstUsrInfos reqUsrInfo.dstUin = " + localReqUsrInfo.dstUin + " ,reqUsrInfo.dstTid = " + localReqUsrInfo.dstTid + " ,reqUsrInfo.dstOpenid = " + localReqUsrInfo.dstOpenid);
            }
            j += 1;
            break label115;
            i = 2;
            break;
            i = 1;
            break;
            if (i != 1) {
              break label321;
            }
            localReqUsrInfo.dstTid.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
          }
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel())
            {
              QLog.i("ERROR", 2, localException.getMessage());
              continue;
              if (i == 2) {
                localReqUsrInfo.dstOpenid.set(localException.jdField_a_of_type_JavaLangString);
              }
            }
          }
        }
      }
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("connum", String.valueOf(paramArrayList.size()));
    StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "actNearbyHeadConNum", true, 0L, 0L, (HashMap)localObject, "");
    localObject = a("MultibusidURLSvr.HeadUrlReq", null);
    ((ToServiceMsg)localObject).extraData.putParcelableArrayList("uinList", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putLong("startTime", System.currentTimeMillis());
    ((ToServiceMsg)localObject).extraData.putInt("idType", paramInt);
    ((ToServiceMsg)localObject).putWupBuffer(localMultiBusidUrlReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.flh", 2, "realGetQQHead_Stranger .  idType = " + paramInt);
    }
    b((ToServiceMsg)localObject);
  }
  
  private void b(long paramLong, int paramInt, ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i = paramInt;
    if (paramInt == 4) {
      i = 8;
    }
    ToServiceMsg localToServiceMsg = a("IncreaseURLSvr.QQHeadUrlReq", null);
    QQHeadUrl.QQHeadUrlReq localQQHeadUrlReq = new QQHeadUrl.QQHeadUrlReq();
    localQQHeadUrlReq.srcUsrType.set(1);
    localQQHeadUrlReq.srcUin.set(Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localQQHeadUrlReq.dstUsrType.set(i);
    paramInt = 0;
    while (paramInt < paramArrayList.size())
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(paramInt);
      QQHeadUrl.ReqUsrInfo localReqUsrInfo = new QQHeadUrl.ReqUsrInfo();
      try
      {
        localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.jdField_a_of_type_JavaLangString));
        a(0, localQQHeadDetails.jdField_a_of_type_JavaLangString, localQQHeadDetails.jdField_a_of_type_Int, 1);
        localReqUsrInfo.timestamp.set((int)localQQHeadDetails.jdField_a_of_type_Long);
        localQQHeadUrlReq.dstUsrInfos.add(localReqUsrInfo);
      }
      catch (Exception localException)
      {
        label169:
        break label169;
      }
      paramInt += 1;
    }
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.putWupBuffer(localQQHeadUrlReq.toByteArray());
    b(localToServiceMsg);
  }
  
  private void b(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramObject instanceof GetSimpleOnlineFriendInfoResp))
    {
      paramFromServiceMsg = (GetSimpleOnlineFriendInfoResp)paramObject;
      if (paramFromServiceMsg == null) {
        a(13, false, null);
      }
    }
    else
    {
      return;
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.result == 1))
    {
      a(13, false, null);
      return;
    }
    if (paramFromServiceMsg.shClickInterval > 30)
    {
      i = paramFromServiceMsg.shClickInterval * 1000;
      QQAppInterface.jdField_f_of_type_Int = i;
      if (paramFromServiceMsg.intervalTimeMin <= 3) {
        break label179;
      }
    }
    label179:
    for (int i = paramFromServiceMsg.intervalTimeMin * 60 * 1000;; i = 180000)
    {
      QQAppInterface.jdField_e_of_type_Int = i;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "Next Get Online Friend Delay " + QQAppInterface.jdField_e_of_type_Int);
      }
      b(paramFromServiceMsg.cShowPcIcon);
      if (paramFromServiceMsg.vecFriendInfo.size() <= 0) {
        break label186;
      }
      ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramFromServiceMsg.vecFriendInfo);
      a(13, true, null);
      return;
      i = 30000;
      break;
    }
    label186:
    a(13, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getLong("friendUin");
    boolean bool = paramToServiceMsg.extraData.getBoolean("isSet");
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendShield : handleSetFriendShieldFlagError : uin : " + l + " isSet:" + bool);
    }
    a(56, false, new Object[] { Long.valueOf(l), Boolean.valueOf(bool), Boolean.valueOf(false), Boolean.valueOf(false), "" });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + i);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(62, false, new Object[] { null, Integer.valueOf(i) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(62, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
        return;
      }
      a(62, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(62, false, new Object[] { null, Integer.valueOf(i) });
      return;
    }
    a(62, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(58, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        int i;
        if ((paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size() > 0))
        {
          i = 0;
          if (i < paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.get(i);
            if (paramToServiceMsg != null) {}
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramToServiceMsg.vecGuid == null)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "handlerLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
            }
          }
          else
          {
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerLoginDevList NetConnInfoCenter.GUID is null");
              }
            }
            while (Arrays.equals(paramToServiceMsg.vecGuid, NetConnInfoCenter.GUID))
            {
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.remove(i);
              paramSvcRspGetDevLoginInfo.vecCurrentLoginDevInfo.add(0, paramToServiceMsg);
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerMultiClientList Arrays true");
              }
              a(58, true, paramSvcRspGetDevLoginInfo);
              return;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerLoginDevList NetConnInfoCenter.GUID =" + PkgTools.a(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.a(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
      }
      a(58, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(58, false, null);
      return;
    }
    a(58, false, null);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    paramToServiceMsg = paramToServiceMsg.extraData;
    paramObject = (GetAutoInfoResp)paramObject;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && (paramObject.errorCode == 0))
    {
      paramToServiceMsg.putInt("group_id", paramObject.cGroupID);
      paramToServiceMsg.putString("nick_name", paramObject.strRemark);
      a(33, true, paramToServiceMsg);
      return;
    }
    a(33, false, paramToServiceMsg);
  }
  
  private void b(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    paramObject = (GetRichSigRes)paramObject;
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if ((paramObject == null) || (paramObject.cResult != 0) || (paramObject.vstSigInfo == null) || (paramObject.vstSigInfo.size() == 0) || (localFriendsManager == null))
    {
      if (paramToServiceMsg.extraData.getInt("reqType") == 3) {
        this.jdField_b_of_type_Boolean = false;
      }
      c(paramToServiceMsg);
      return;
    }
    ArrayList localArrayList1 = new ArrayList(paramObject.vstSigInfo.size());
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator = paramObject.vstSigInfo.iterator();
    while (localIterator.hasNext())
    {
      ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)localIterator.next();
      String str = Long.toString(localResRichSigInfo.lUin);
      if (localResRichSigInfo.cStatus == 1)
      {
        ExtensionInfo localExtensionInfo = localFriendsManager.a(str);
        paramObject = localExtensionInfo;
        if (localExtensionInfo == null)
        {
          paramObject = new ExtensionInfo();
          paramObject.uin = str;
        }
        if (paramObject.richTime != localResRichSigInfo.dwTime)
        {
          paramObject.setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
          paramObject.isAdded2C2C = SignatureManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, str, paramObject.getRichStatus());
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "insertSignMsgIfNeeded from FriendList uin = " + str + " result = " + paramObject.isAdded2C2C);
          }
          localArrayList1.add(paramObject);
          localArrayList2.add(str);
        }
      }
    }
    if (localArrayList2.size() > 0)
    {
      paramObject = new String[localArrayList2.size()];
      localArrayList2.toArray(paramObject);
      a(2, true, paramObject);
      localFriendsManager.b(localArrayList1);
    }
    if ((paramToServiceMsg.extraData.getInt("reqType") == 3) && (this.jdField_b_of_type_Boolean) && (paramToServiceMsg.extraData.getStringArray("totalArray").length == paramToServiceMsg.extraData.getInt("nextStartPos")))
    {
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().edit().putLong("inccheckupdatetimeStamp13", this.jdField_c_of_type_Long).commit();
      this.jdField_b_of_type_Boolean = false;
    }
    c(paramToServiceMsg);
  }
  
  private void b(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("addFriendTag", 2, "addFriendInternal  friendUin " + paramString1 + ";friendSetting " + paramInt1 + ";groupId " + paramByte1 + ";msg " + paramString3 + ";sourceID " + paramInt2 + ";subSourceId " + paramInt3 + ";autoSend " + paramBoolean1 + ";extraUin " + paramString2 + ";isContactBothWay " + paramBoolean2 + ";remark " + paramString4 + ";srcName " + paramString5);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendlist.addFriend");
    Bundle localBundle = localToServiceMsg.extraData;
    localBundle.putString("uin", paramString1);
    localBundle.putInt("friend_setting", paramInt1);
    localBundle.putByte("group_id", paramByte1);
    localBundle.putString("msg", paramString3);
    localBundle.putInt("source_id", paramInt2);
    localBundle.putByte("show_my_card", paramByte2);
    localBundle.putInt("sub_source_id", paramInt3);
    localBundle.putString("extra", paramString2);
    localBundle.putBoolean("auto_send", paramBoolean1);
    localBundle.putByteArray("sig", paramArrayOfByte);
    localBundle.putBoolean("contact_bothway", paramBoolean2);
    localBundle.putString("remark", paramString4);
    localBundle.putString("src_name", paramString5);
    a(localToServiceMsg);
  }
  
  private void b(List paramList)
  {
    Object localObject1;
    Object localObject2;
    ArrayList localArrayList;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("saveLastLoginInfos begin ");
      if (paramList != null)
      {
        i = paramList.size();
        QLog.d("FriendListHandler", 2, i);
      }
    }
    else
    {
      localObject1 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      localObject2 = ((FriendsManager)localObject1).c();
      if ((paramList == null) || (localObject2 == null)) {
        break label335;
      }
      localArrayList = new ArrayList(((ArrayList)localObject2).size());
      if (paramList.size() != 0) {
        break label188;
      }
      paramList = ((ArrayList)localObject2).iterator();
      label102:
      while (paramList.hasNext())
      {
        localObject2 = (Friends)paramList.next();
        if (localObject2 != null)
        {
          if (((Friends)localObject2).lastLoginType == 0L) {
            break label356;
          }
          ((Friends)localObject2).lastLoginType = 0L;
        }
      }
    }
    label188:
    label335:
    label351:
    label356:
    for (int i = 1;; i = 0)
    {
      if (((Friends)localObject2).showLoginClient != 0L)
      {
        ((Friends)localObject2).showLoginClient = 0L;
        i = 1;
      }
      if (i == 0) {
        break label102;
      }
      localArrayList.add(localObject2);
      break label102;
      i = -1;
      break;
      paramList = paramList.iterator();
      Friends localFriends;
      while (paramList.hasNext())
      {
        localObject2 = (LastLoginInfo)paramList.next();
        localFriends = ((FriendsManager)localObject1).c(String.valueOf(((LastLoginInfo)localObject2).dwFriendUin));
        if (localFriends != null)
        {
          if (localFriends.showLoginClient == ((LastLoginInfo)localObject2).dwClient) {
            break label351;
          }
          localFriends.showLoginClient = ((LastLoginInfo)localObject2).dwClient;
        }
      }
      for (i = 1;; i = 0)
      {
        if (localFriends.lastLoginType != ((LastLoginInfo)localObject2).dwLastLoginType)
        {
          localFriends.lastLoginType = ((LastLoginInfo)localObject2).dwLastLoginType;
          i = 1;
        }
        if (i == 0) {
          break;
        }
        localArrayList.add(localFriends);
        break;
        ((FriendsManager)localObject1).a((Friends[])localArrayList.toArray(new Friends[localArrayList.size()]), localArrayList.size());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "saveLastLoginInfos ends ");
        }
        return;
      }
    }
  }
  
  private void c(ToServiceMsg paramToServiceMsg)
  {
    a(paramToServiceMsg.extraData.getStringArray("totalArray"), paramToServiceMsg.extraData.getInt("nextStartPos"), paramToServiceMsg.extraData.getInt("reqType"), paramToServiceMsg.extraData.getBundle("circleBundle"), paramToServiceMsg.extraData.getBoolean("showDateNickname"));
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspDelLoginInfo paramSvcRspDelLoginInfo)
  {
    int i = paramToServiceMsg.extraData.getInt("index", -1);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handlerDelMultiClient index = " + i);
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspDelLoginInfo == null)
      {
        a(51, false, new Object[] { null, Integer.valueOf(i) });
        return;
      }
      if (paramSvcRspDelLoginInfo.iResult == 0)
      {
        a(51, true, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
        return;
      }
      a(51, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
      return;
    }
    if (paramSvcRspDelLoginInfo == null)
    {
      a(51, false, new Object[] { null, Integer.valueOf(i) });
      return;
    }
    a(51, false, new Object[] { paramSvcRspDelLoginInfo.strResult, Integer.valueOf(i) });
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(59, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size() > 0))
        {
          int j = 0;
          int i = 0;
          if (i < paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecHistoryLoginDevInfo.get(i);
            int k;
            if (paramToServiceMsg == null) {
              k = j;
            }
            for (;;)
            {
              i += 1;
              j = k;
              break;
              if (paramToServiceMsg.vecGuid != null) {
                break label153;
              }
              k = j;
              if (QLog.isColorLevel())
              {
                QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
                k = j;
              }
            }
            label153:
            if (NetConnInfoCenter.GUID == null) {
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID is null");
              }
            }
            for (;;)
            {
              k = j;
              if (System.currentTimeMillis() / 1000L - paramToServiceMsg.iLoginTime >= 2592000L) {
                break;
              }
              k = j;
              if (j != 0) {
                break;
              }
              k = j;
              if (paramToServiceMsg.iTerType != 3L) {
                break;
              }
              k = 1;
              a(102, true, null);
              break;
              try
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerRecentLoginDevList NetConnInfoCenter.GUID =" + PkgTools.a(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.a(paramToServiceMsg.vecGuid));
                }
              }
              catch (Exception paramFromServiceMsg)
              {
                paramFromServiceMsg.printStackTrace();
              }
            }
          }
        }
        a(59, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      a(59, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(59, false, null);
      return;
    }
    a(59, false, null);
  }
  
  private void c(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch success=" + bool);
      }
      if (!bool) {
        break label793;
      }
    }
    label793:
    label799:
    label809:
    label815:
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramToServiceMsg == null)
        {
          return;
          bool = false;
          break;
        }
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label809;
        }
        bool = true;
        j = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch result=" + bool);
        }
        if ((bool) && (paramToServiceMsg.bytes_bodybuffer != null) && (paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          i = paramToServiceMsg.get();
          int k = paramToServiceMsg.getInt();
          j = paramToServiceMsg.getShort();
          paramFromServiceMsg = new HashMap(j);
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch cNickCut=" + i + " dwNextUin=" + k + " wSimpleInfoNum=" + j);
          }
          if (k == -1)
          {
            paramObject = new StringBuffer();
            i = 0;
            if (i < j)
            {
              String str = String.valueOf(Utils.a(paramToServiceMsg.getInt()));
              k = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                paramObject.append(" wFieldNum=");
                paramObject.append(k);
              }
              if (k != 1) {
                break label799;
              }
              k = paramToServiceMsg.getShort();
              if (QLog.isColorLevel())
              {
                paramObject.append(" wFieldID=");
                paramObject.append(k);
              }
              if (k != this.jdField_a_of_type_Short) {
                break label799;
              }
              Object localObject = new byte[paramToServiceMsg.getShort()];
              paramToServiceMsg.get((byte[])localObject);
              localObject = new String((byte[])localObject);
              if (QLog.isColorLevel())
              {
                paramObject.append(" uin=");
                paramObject.append(str.substring(0, 4));
                paramObject.append(" nick=");
                paramObject.append(Utils.a((String)localObject));
              }
              paramFromServiceMsg.put(str, localObject);
              break label799;
            }
            if (!QLog.isColorLevel()) {
              break label815;
            }
            QLog.d("FriendListHandler", 2, paramObject.toString());
            break label815;
            a(75, bool, paramFromServiceMsg);
            return;
          }
          bool = false;
          continue;
        }
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
          i = j;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        j = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler", 2, "handleGetFriendNickBatch e", paramToServiceMsg);
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
        i = j;
        continue;
      }
      catch (Exception paramToServiceMsg)
      {
        j = 1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.w("FriendListHandler", 2, "handleGetFriendNickBatch ex", paramToServiceMsg);
        i = j;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
        i = j;
        continue;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGetFriendNickBatch over time=" + System.currentTimeMillis());
      }
      a(75, false, Integer.valueOf(i));
      return;
      int j = 0;
      continue;
      int i = (short)(i + 1);
      continue;
      bool = false;
    }
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, SvcRspGetDevLoginInfo paramSvcRspGetDevLoginInfo)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      if (paramSvcRspGetDevLoginInfo == null)
      {
        a(60, false, null);
        return;
      }
      if (paramSvcRspGetDevLoginInfo.iResult == 0)
      {
        if ((paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo != null) && (paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size() > 0))
        {
          int i = 0;
          if (i < paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.size())
          {
            paramToServiceMsg = (SvcDevLoginInfo)paramSvcRspGetDevLoginInfo.vecAuthLoginDevInfo.get(i);
            if (paramToServiceMsg == null) {}
            for (;;)
            {
              i += 1;
              break;
              if (paramToServiceMsg.vecGuid == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList info.vecGuid is null n =" + paramToServiceMsg.strDeviceTypeInfo);
                }
              }
              else if (NetConnInfoCenter.GUID == null)
              {
                if (QLog.isColorLevel()) {
                  QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList NetConnInfoCenter.GUID is null");
                }
              }
              else {
                try
                {
                  if (QLog.isColorLevel()) {
                    QLog.d("FriendListHandler", 2, "handlerAuthLoginDevList NetConnInfoCenter.GUID =" + PkgTools.a(NetConnInfoCenter.GUID) + "; info.guid = " + PkgTools.a(paramToServiceMsg.vecGuid));
                  }
                }
                catch (Exception paramToServiceMsg)
                {
                  paramToServiceMsg.printStackTrace();
                }
              }
            }
          }
        }
        a(60, true, paramSvcRspGetDevLoginInfo);
        return;
      }
      a(60, false, null);
      return;
    }
    if (paramSvcRspGetDevLoginInfo == null)
    {
      a(60, false, null);
      return;
    }
    a(60, false, null);
  }
  
  private void d(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("set_special_care_switch", 2, "FriendListHandler.handleSetSpecialCareSwitchResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    int k = paramToServiceMsg.extraData.getInt("param_type");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_uins");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    int m;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        do
        {
          for (;;)
          {
            int i;
            if (QLog.isColorLevel()) {
              QLog.d("set_special_care_switch", 2, "parse oidb_sso.OIDBSSOPkg failed.");
            }
            paramFromServiceMsg.printStackTrace();
            continue;
            if (m != 0)
            {
              paramToServiceMsg.e(paramFromServiceMsg);
              paramObject = new SpecialCareInfo();
              paramObject.globalSwitch = 1;
              paramObject.specialRingSwitch = 1;
              paramObject.friendRingId = 1;
              paramObject.qzoneSwitch = 1;
              paramObject.uin = paramFromServiceMsg;
              paramToServiceMsg.a(paramObject);
              QvipSpecialCareManager.a(paramFromServiceMsg, "1", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            else
            {
              paramToServiceMsg.e(paramFromServiceMsg);
            }
          }
          paramObject = paramToServiceMsg.a(paramFromServiceMsg);
          if (paramObject != null) {
            if (m == 0) {
              break label395;
            }
          }
          for (j = 1;; j = 0)
          {
            paramObject.specialRingSwitch = j;
            paramToServiceMsg.a(paramObject);
            if (m == 0) {
              break;
            }
            QvipSpecialCareManager.a(paramFromServiceMsg, "1", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
            break;
          }
          paramFromServiceMsg = paramToServiceMsg.a(paramFromServiceMsg);
        } while (paramFromServiceMsg == null);
        if (m == 0) {
          break label433;
        }
        for (j = 1;; j = 0)
        {
          paramFromServiceMsg.qzoneSwitch = j;
          paramToServiceMsg.a(paramFromServiceMsg);
          break;
        }
        m = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("set_special_care_switch", 2, "ssoPkg.uint32_result=" + i);
        }
        if (i == 0)
        {
          paramToServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          i = 0;
          while (i < arrayOfString.length)
          {
            paramFromServiceMsg = arrayOfString[i];
            m = arrayOfBoolean[i];
            switch (k)
            {
            default: 
              i += 1;
            }
          }
        }
      }
    }
    for (;;)
    {
      int j;
      label395:
      label433:
      paramToServiceMsg = new Object[3];
      paramToServiceMsg[0] = Integer.valueOf(k);
      paramToServiceMsg[1] = arrayOfString;
      paramToServiceMsg[2] = arrayOfBoolean;
      switch (k)
      {
      default: 
        return;
      case 1: 
        a(96, m, paramToServiceMsg);
        return;
      case 2: 
        a(97, m, paramToServiceMsg);
        return;
      }
      a(98, m, paramToServiceMsg);
      return;
      int n = 0;
    }
  }
  
  private void e(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("set_special_care_switches_of_a_person", 2, "FriendListHandler.handleSetSpecialCareSwitchesOfAPersonResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    String str = paramToServiceMsg.extraData.getString("param_uin");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("param_type");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_ring_ids");
    int i;
    int m;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        do
        {
          for (;;)
          {
            int j;
            if (QLog.isColorLevel()) {
              QLog.d("set_special_care_switches_of_a_person", 2, "parse oidb_sso.OIDBSSOPkg failed.");
            }
            paramFromServiceMsg.printStackTrace();
            continue;
            if (m != 0)
            {
              paramToServiceMsg.e(str);
              paramFromServiceMsg = new SpecialCareInfo();
              paramFromServiceMsg.globalSwitch = 1;
              paramFromServiceMsg.uin = str;
              paramToServiceMsg.a(paramFromServiceMsg);
              QvipSpecialCareManager.a(str, "1", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
            }
            else
            {
              paramToServiceMsg.e(str);
            }
          }
          paramObject = paramToServiceMsg.a(str);
          if (paramObject != null) {
            if (m == 0) {
              break label436;
            }
          }
          for (k = 1;; k = 0)
          {
            paramObject.specialRingSwitch = k;
            paramToServiceMsg.a(paramObject);
            if (m == 0) {
              break;
            }
            QvipSpecialCareManager.a(str, paramFromServiceMsg, this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
            break;
          }
          paramFromServiceMsg = paramToServiceMsg.a(str);
        } while (paramFromServiceMsg == null);
        if (m == 0) {
          break label475;
        }
        for (int k = 1;; k = 0)
        {
          paramFromServiceMsg.qzoneSwitch = k;
          paramToServiceMsg.a(paramFromServiceMsg);
          break;
        }
        m = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("set_special_care_switches_of_a_person", 2, "ssoPkg.uint32_result=" + i);
        }
        if (i == 0)
        {
          paramToServiceMsg = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          if ((arrayOfBoolean != null) && (arrayOfInt != null) && (arrayOfString != null) && (arrayOfBoolean.length >= arrayOfInt.length) && (arrayOfString.length >= arrayOfInt.length))
          {
            j = 0;
            while (j < arrayOfInt.length)
            {
              k = arrayOfInt[j];
              m = arrayOfBoolean[j];
              paramFromServiceMsg = arrayOfString[j];
              switch (k)
              {
              default: 
                j += 1;
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      label436:
      label475:
      a(100, m, new Object[] { Integer.valueOf(i), str, arrayOfInt, arrayOfBoolean, arrayOfString });
      return;
      int n = 0;
      continue;
      n = 0;
      i = -1;
    }
  }
  
  private boolean e(String paramString)
  {
    boolean bool1 = paramString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    boolean bool2 = bool1;
    long l1;
    long l2;
    long l3;
    if (bool1)
    {
      Context localContext = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
      Card localCard = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramString);
      l1 = ContactConfig.b(localContext, paramString) + 28800000L;
      l2 = System.currentTimeMillis() + 28800000L;
      l3 = localCard.iXManScene1DelayTime * 1000;
      if ((l1 / 86400000L == l2 / 86400000L) || (Math.abs(l2 - l1) <= 28800000L) || (l2 % 86400000L < l3)) {
        break label238;
      }
    }
    label238:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, String.format("shouldReqXMan toReq=%s lastReqTime=%s currentTime=%s reqDelay=%s lastReqDay=%s currentDay=%s lastReqInterval=%s time=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l1 / 86400000L), Long.valueOf(l2 / 86400000L), Long.valueOf(Math.abs(l2 - l1)), Long.valueOf(l2 % 86400000L) }));
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  private void f(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      a(66, false, null);
      return;
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg == null) || (paramToServiceMsg.uint32_result.get() != 0)) {
          break label113;
        }
        i = 1;
        if (i != 0) {
          break label119;
        }
        a(66, false, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        a(66, false, null);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.w("Q.stranger_info", 2, paramToServiceMsg.getMessage());
      return;
      label113:
      i = 0;
    }
    label119:
    if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
    {
      ByteBuffer localByteBuffer = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      if (localByteBuffer.getInt() == -1)
      {
        int n = localByteBuffer.getShort();
        paramFromServiceMsg = new ArrayList(n);
        paramObject = new HashSet(n);
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        int k = 0;
        while (k < n)
        {
          long l1 = Utils.a(localByteBuffer.getInt());
          paramToServiceMsg = localFriendsManager.a(String.valueOf(l1));
          if (paramToServiceMsg != null) {
            break label785;
          }
          paramToServiceMsg = new ExtensionInfo();
          paramToServiceMsg.uin = String.valueOf(l1);
          i = 1;
          int i1 = localByteBuffer.getShort();
          int j;
          if (i1 > 0)
          {
            int m = 0;
            j = i;
            if (m < i1)
            {
              int i2 = localByteBuffer.getShort();
              long l2;
              if (i2 == 27025)
              {
                if (localByteBuffer.getShort() != 8) {
                  break label782;
                }
                l2 = localByteBuffer.getLong();
                if (paramToServiceMsg.pendantId == l2) {
                  break label782;
                }
                paramToServiceMsg.pendantId = l2;
                paramToServiceMsg.lastUpdateTime = NetConnInfoCenter.getServerTime();
                i = 1;
                j = i;
              }
              for (;;)
              {
                m += 1;
                i = j;
                break;
                if (i2 == 27201)
                {
                  j = i;
                  if (localByteBuffer.getShort() == 4)
                  {
                    l2 = localByteBuffer.getInt();
                    if (paramToServiceMsg.uVipFont == FontManager.a(l2))
                    {
                      j = i;
                      if (paramToServiceMsg.vipFontType == FontManager.b(l2)) {}
                    }
                    else
                    {
                      paramToServiceMsg.uVipFont = FontManager.a(l2);
                      paramToServiceMsg.vipFontType = FontManager.b(l2);
                      paramToServiceMsg.lastUpdateTime = NetConnInfoCenter.getServerTime();
                      j = 1;
                    }
                  }
                }
                else if (i2 == 27041)
                {
                  j = i;
                  if (localByteBuffer.getShort() == 4)
                  {
                    i2 = localByteBuffer.getInt();
                    j = i;
                    if (paramToServiceMsg.colorRingId != i2)
                    {
                      paramToServiceMsg.colorRingId = i2;
                      j = 1;
                    }
                  }
                }
                else
                {
                  j = i;
                  if (i2 == 20059)
                  {
                    j = i;
                    if (localByteBuffer.getShort() == 4)
                    {
                      i2 = localByteBuffer.getInt();
                      j = i;
                      if (i2 >= 0)
                      {
                        j = i;
                        if (String.valueOf(l1).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()))
                        {
                          ((BubbleManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(43)).a(i2, true);
                          ((SVIPHandler)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(i2);
                          j = i;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          else
          {
            j = i;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetStrangerInfo, uin=" + l1 + ", pendant=" + paramToServiceMsg.pendantId + ",font=" + paramToServiceMsg.uVipFont + ", fontType = " + paramToServiceMsg.vipFontType);
          }
          if (j != 0)
          {
            paramToServiceMsg.timestamp = System.currentTimeMillis();
            paramFromServiceMsg.add(paramToServiceMsg);
            paramObject.add(paramToServiceMsg.uin);
          }
          k += 1;
        }
        localFriendsManager.b(paramFromServiceMsg);
        paramToServiceMsg = paramObject;
      }
    }
    for (;;)
    {
      label259:
      label343:
      a(66, true, paramToServiceMsg);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.stranger_info", 2, "handleGetStrangerInfo. addonId size : " + paramFromServiceMsg.size());
      return;
      label782:
      break label343;
      label785:
      i = 0;
      break label259;
      paramToServiceMsg = null;
      paramFromServiceMsg = null;
    }
  }
  
  private boolean f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, String.format("shouldReqXManScene2 friendUin=%s", new Object[] { paramString }));
    }
    boolean bool1 = paramString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    boolean bool2 = bool1;
    long l1;
    long l2;
    long l3;
    if (bool1)
    {
      Context localContext = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
      Card localCard = ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).b(paramString);
      l1 = ContactConfig.c(localContext, paramString);
      l2 = System.currentTimeMillis();
      l3 = localCard.iXManScene2DelayTime * 1000;
      if ((l3 < 0L) || (Math.abs(l2 - l1) <= l3)) {
        break label181;
      }
    }
    label181:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, String.format("shouldReqXManScene2 toReq=%s lastReqTime=%s currentTime=%s reqDelay=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) }));
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  private void g()
  {
    if ((this.jdField_a_of_type_Long != 0L) && (this.jdField_b_of_type_Int != 0))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("mFriendListFailedCount", this.jdField_b_of_type_Int + "");
      localHashMap.put("failedTime", System.currentTimeMillis() - this.jdField_a_of_type_Long + "");
      StatisticCollector.a(BaseApplicationImpl.getApplication()).a(null, "QQFriendListReqFailedStatistics", true, 0L, 0L, localHashMap, null);
      this.jdField_b_of_type_Int = 0;
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  private void g(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "handleQQHead_QCall ....");
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg != null) {
      localObject1 = localObject2;
    }
    int i;
    List localList;
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localObject2;
        if (paramObject != null)
        {
          localObject1 = new MultiHeadUrl.MultiBusidUrlRsp();
          ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
      paramObject = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramObject = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + localException.getMessage());
        }
        localException.printStackTrace();
        continue;
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.getResultCode();
        }
      }
      localList = paramObject.dstUsrHeadInfos.get();
      localArrayList = new ArrayList();
      paramFromServiceMsg = ???.extraData.getParcelableArrayList("uinList");
      localObject2 = new ArrayList();
      paramObject.dstUidType.get();
      k = ???.extraData.getInt("idType");
      paramObject = paramFromServiceMsg.iterator();
    }
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
    {
      i = 65535;
      if (paramObject != null)
      {
        i = paramObject.result.get();
        a(???, i);
        return;
      }
    }
    ArrayList localArrayList;
    int k;
    FriendListHandler.QQHeadDetails localQQHeadDetails;
    label282:
    String str;
    if (paramObject.hasNext())
    {
      localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramObject.next();
      Iterator localIterator1 = localList.iterator();
      for (;;)
      {
        if (localIterator1.hasNext())
        {
          ??? = (MultiHeadUrl.RspUsrHeadInfo)localIterator1.next();
          str = UinUtils.a(???.dstUin.get());
          if (localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(str))
          {
            paramFromServiceMsg = ???.dstHeadInfos.get();
            ??? = null;
            Iterator localIterator2 = paramFromServiceMsg.iterator();
            label346:
            if (localIterator2.hasNext())
            {
              paramFromServiceMsg = (MultiHeadUrl.RspHeadInfo)localIterator2.next();
              paramFromServiceMsg.usrType.get();
              if (paramFromServiceMsg.faceType.get() == 0) {
                break label1104;
              }
              ??? = paramFromServiceMsg;
            }
          }
        }
      }
    }
    for (;;)
    {
      break label346;
      if (??? != null)
      {
        label394:
        paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(16, str, k);
        if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(16, str, k)) {
          break label671;
        }
        int j = 1;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.qqhead.", 2, "handleQQHead_QCALL file not exist.id=" + str + ",idType=" + k);
          i = j;
        }
        label480:
        if (i == 0) {
          break label784;
        }
        paramFromServiceMsg = new QQHeadInfo();
        paramFromServiceMsg.headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
        paramFromServiceMsg.idType = k;
        paramFromServiceMsg.phoneNum = str;
        paramFromServiceMsg.dwTimestamp = ???.timestamp.get();
        paramFromServiceMsg.cHeadType = ((byte)???.faceType.get());
        paramFromServiceMsg.dstUsrType = 16;
        paramFromServiceMsg.dwFaceFlgas = ((byte)???.faceFlag.get());
        paramFromServiceMsg.downLoadUrl = ???.url.get();
        paramFromServiceMsg.systemHeadID = ((short)???.sysid.get());
        paramFromServiceMsg.originUsrType = ???.usrType.get();
        if (!???.headVerify.has()) {
          break label786;
        }
      }
      label784:
      label786:
      for (??? = ???.headVerify.get();; ??? = "")
      {
        paramFromServiceMsg.headVerify = ???;
        ((List)localObject2).add(paramFromServiceMsg);
        break label282;
        if (0 != 0)
        {
          ??? = null;
          break label394;
        }
        if (!QLog.isColorLevel()) {
          break label282;
        }
        QLog.d("headqcall", 2, "there is no headinfo uin=" + str);
        break label282;
        break;
        label671:
        if (paramFromServiceMsg != null)
        {
          paramFromServiceMsg = (com.tencent.mobileqq.data.Setting)paramFromServiceMsg.second;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.", 2, "handleQQHead_QCALL setting=" + paramFromServiceMsg + "targetInfo.timestamp=" + ???.timestamp.get());
          }
          if (paramFromServiceMsg == null)
          {
            i = 1;
            break label480;
          }
          if (paramFromServiceMsg.headImgTimestamp != ???.timestamp.get())
          {
            i = 1;
            break label480;
          }
          localArrayList.add(localQQHeadDetails);
          i = 0;
          break label480;
        }
        i = 1;
        break label480;
        break label282;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
      synchronized (this.jdField_b_of_type_JavaLangObject)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
        }
        i = 0;
        if (i < ((List)localObject2).size())
        {
          ??? = (QQHeadInfo)((List)localObject2).get(i);
          a(0, a(???.uin, ???.phoneNum), ???.dstUsrType, 2);
          paramFromServiceMsg = new FaceInfo();
          paramFromServiceMsg.jdField_a_of_type_JavaLangString = ???.phoneNum;
          paramFromServiceMsg.jdField_b_of_type_Int = ???.idType;
          paramFromServiceMsg.jdField_a_of_type_Int = ???.dstUsrType;
          paramFromServiceMsg.jdField_a_of_type_AvatarInfoQQHeadInfo = ???;
          this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.a(paramFromServiceMsg);
          i += 1;
        }
      }
      if (localArrayList.size() <= 0) {
        break;
      }
      paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
      ??? = paramFromServiceMsg.a();
      ???.a();
      i = 0;
      try
      {
        while (i < localArrayList.size())
        {
          paramObject = (FriendListHandler.QQHeadDetails)localArrayList.get(i);
          paramObject = "qcall_" + String.valueOf(k) + "_" + paramObject.jdField_a_of_type_JavaLangString;
          localObject2 = (com.tencent.mobileqq.data.Setting)paramFromServiceMsg.a(com.tencent.mobileqq.data.Setting.class, paramObject);
          if (localObject2 != null)
          {
            ((com.tencent.mobileqq.data.Setting)localObject2).updateTimestamp = System.currentTimeMillis();
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((com.tencent.mobileqq.data.Setting)localObject2);
            paramFromServiceMsg.a((Entity)localObject2);
          }
          b(paramObject, true);
          i += 1;
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        ???.c();
        ???.b();
        return;
      }
    }
  }
  
  private void h()
  {
    label470:
    for (;;)
    {
      long l;
      int i;
      ArrayList localArrayList;
      StringBuilder localStringBuilder;
      try
      {
        this.jdField_a_of_type_MqqOsMqqHandler.removeMessages(0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead start !!! ");
        }
        Object localObject1;
        if (this.jdField_e_of_type_Int > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead destQQHeadInfoCount = " + this.jdField_e_of_type_Int);
          }
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          if (localObject1 == null) {
            break label485;
          }
        }
        try
        {
          l = Long.valueOf((String)localObject1).longValue();
          if (l == -1L)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead|myUin error: myUin=" + (String)localObject1);
            }
            return;
          }
        }
        catch (Exception localException)
        {
          l = -1L;
          continue;
          localObject1 = this.jdField_a_of_type_JavaUtilHashtable.keys();
          if (!((Enumeration)localObject1).hasMoreElements()) {
            break label470;
          }
        }
        i = ((Integer)((Enumeration)localObject1).nextElement()).intValue();
        localArrayList = (ArrayList)this.jdField_a_of_type_JavaUtilHashtable.get(Integer.valueOf(i));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "em.hasMoreElements() QQHeadDetails head_or_id = " + i);
        }
        if (!QLog.isColorLevel()) {
          break label343;
        }
        localStringBuilder = new StringBuilder("doExecuteGetQQHead sendRequests for QQHeadInfo head_or_id=").append(i);
        Iterator localIterator = localArrayList.iterator();
        if (localIterator.hasNext())
        {
          FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator.next();
          localStringBuilder.append(" QQheadDetail uinOrMobile").append(StringUtil.d(localQQHeadDetails.jdField_a_of_type_JavaLangString)).append("|");
          continue;
        }
        localStringBuilder.append(" QQHeadDetailList length = ").append(localArrayList.size());
      }
      finally {}
      QLog.d("FriendListHandler", 2, localStringBuilder.toString());
      label343:
      if (i == 11)
      {
        a(l, i, localArrayList);
      }
      else if (i >= 200)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "realGetQQHead_Stranger = " + i);
        }
        b(i, localArrayList);
      }
      else if (i == 16)
      {
        a(i, localArrayList);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "QQHEAD_TYPE_QCALL = " + i);
        }
      }
      else
      {
        b(l, i, localArrayList);
        continue;
        this.jdField_e_of_type_Int = 0;
        this.jdField_a_of_type_JavaUtilHashtable.clear();
        continue;
        label485:
        l = -1L;
      }
    }
  }
  
  private void h(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger ....");
    }
    ArrayList localArrayList1 = null;
    Object localObject1 = localArrayList1;
    if (paramFromServiceMsg != null) {
      localObject1 = localArrayList1;
    }
    int i;
    List localList;
    ArrayList localArrayList2;
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localArrayList1;
        if (paramObject != null)
        {
          localObject1 = new MultiHeadUrl.MultiBusidUrlRsp();
          ((MultiHeadUrl.MultiBusidUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
      paramObject = localObject1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        paramObject = null;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + localException.getMessage());
        }
        localException.printStackTrace();
        continue;
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.getResultCode();
        }
      }
      localList = paramObject.dstUsrHeadInfos.get();
      localArrayList1 = new ArrayList();
      paramFromServiceMsg = ???.extraData.getParcelableArrayList("uinList");
      localArrayList2 = new ArrayList();
      k = paramObject.dstUidType.get();
      j = ???.extraData.getInt("idType");
      localIterator1 = paramFromServiceMsg.iterator();
    }
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
    {
      i = 65535;
      if (paramObject != null)
      {
        i = paramObject.result.get();
        a(???, i);
        return;
      }
    }
    int k;
    int j;
    Iterator localIterator1;
    FriendListHandler.QQHeadDetails localQQHeadDetails;
    label286:
    label323:
    Object localObject2;
    if (localIterator1.hasNext())
    {
      localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = localList.iterator();
      if (localIterator2.hasNext())
      {
        ??? = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
        if (k == 0)
        {
          paramObject = String.valueOf(???.dstUin.get());
          if (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(paramObject)) {
            break label430;
          }
          localObject2 = ???.dstHeadInfos.get();
          paramFromServiceMsg = null;
          ??? = null;
          Iterator localIterator3 = ((List)localObject2).iterator();
          label357:
          if (!localIterator3.hasNext()) {
            break label456;
          }
          localObject2 = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
          i = ((MultiHeadUrl.RspHeadInfo)localObject2).usrType.get();
          if (i != 1) {
            break label432;
          }
          paramFromServiceMsg = (FromServiceMsg)localObject2;
        }
      }
    }
    label680:
    for (;;)
    {
      break label357;
      if (k == 1)
      {
        paramObject = String.valueOf(???.dstTid.get());
        break label323;
      }
      paramObject = ???.dstOpenid.get();
      break label323;
      label430:
      break label286;
      label432:
      if ((i == 32) && (((MultiHeadUrl.RspHeadInfo)localObject2).faceType.get() != 0))
      {
        ??? = (ToServiceMsg)localObject2;
        continue;
        label456:
        if (??? != null)
        {
          label460:
          paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(32, paramObject, j);
          if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(32, paramObject, j)) {
            break label680;
          }
          i = 1;
          label491:
          if (i == 0) {
            break label744;
          }
          paramFromServiceMsg = new QQHeadInfo();
          paramFromServiceMsg.headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
          paramFromServiceMsg.idType = j;
          paramFromServiceMsg.phoneNum = paramObject;
          paramFromServiceMsg.dwTimestamp = ???.timestamp.get();
          paramFromServiceMsg.cHeadType = ((byte)???.faceType.get());
          paramFromServiceMsg.dstUsrType = 32;
          paramFromServiceMsg.dwFaceFlgas = ((byte)???.faceFlag.get());
          paramFromServiceMsg.downLoadUrl = ???.url.get();
          paramFromServiceMsg.systemHeadID = ((short)???.sysid.get());
          paramFromServiceMsg.originUsrType = ???.usrType.get();
          if (!???.headVerify.has()) {
            break label746;
          }
        }
        label744:
        label746:
        for (??? = ???.headVerify.get();; ??? = "")
        {
          paramFromServiceMsg.headVerify = ???;
          localArrayList2.add(paramFromServiceMsg);
          break label286;
          if (paramFromServiceMsg != null)
          {
            ??? = paramFromServiceMsg;
            break label460;
          }
          if (!QLog.isColorLevel()) {
            break label286;
          }
          QLog.d("headstranger", 2, "there is no headinfo uin=" + paramObject);
          break label286;
          break;
          if (paramFromServiceMsg != null)
          {
            paramFromServiceMsg = (com.tencent.mobileqq.data.Setting)paramFromServiceMsg.second;
            if (paramFromServiceMsg == null)
            {
              i = 1;
              break label491;
            }
            if (paramFromServiceMsg.headImgTimestamp != ???.timestamp.get())
            {
              i = 1;
              break label491;
            }
            localArrayList1.add(localQQHeadDetails);
            i = 0;
            break label491;
          }
          i = 1;
          break label491;
          break label286;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
        synchronized (this.jdField_b_of_type_JavaLangObject)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
            this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
          }
          i = 0;
          if (i < localArrayList2.size())
          {
            ??? = (QQHeadInfo)localArrayList2.get(i);
            a(0, a(???.uin, ???.phoneNum), ???.dstUsrType, 2);
            paramFromServiceMsg = new FaceInfo();
            paramFromServiceMsg.jdField_a_of_type_JavaLangString = ???.phoneNum;
            paramFromServiceMsg.jdField_b_of_type_Int = ???.idType;
            paramFromServiceMsg.jdField_a_of_type_Int = ???.dstUsrType;
            paramFromServiceMsg.jdField_a_of_type_AvatarInfoQQHeadInfo = ???;
            this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.a(paramFromServiceMsg);
            i += 1;
          }
        }
        if (localArrayList1.size() <= 0) {
          break;
        }
        paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
        ??? = paramFromServiceMsg.a();
        ???.a();
        i = 0;
        try
        {
          while (i < localArrayList1.size())
          {
            paramObject = (FriendListHandler.QQHeadDetails)localArrayList1.get(i);
            paramObject = "stranger_" + String.valueOf(j) + "_" + paramObject.jdField_a_of_type_JavaLangString;
            localObject2 = (com.tencent.mobileqq.data.Setting)paramFromServiceMsg.a(com.tencent.mobileqq.data.Setting.class, paramObject);
            if (localObject2 != null)
            {
              ((com.tencent.mobileqq.data.Setting)localObject2).updateTimestamp = System.currentTimeMillis();
              this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a((com.tencent.mobileqq.data.Setting)localObject2);
              paramFromServiceMsg.a((Entity)localObject2);
            }
            b(paramObject, true);
            i += 1;
          }
        }
        catch (Exception paramFromServiceMsg)
        {
          ???.c();
          ???.b();
          return;
        }
      }
    }
  }
  
  private void i(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    localObject3 = null;
    Object localObject1 = localObject3;
    if (paramFromServiceMsg != null) {
      localObject1 = localObject3;
    }
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localObject3;
        if (paramObject != null)
        {
          localObject1 = new QQHeadUrl.QQHeadUrlRsp();
          ((QQHeadUrl.QQHeadUrlRsp)localObject1).mergeFrom((byte[])paramObject);
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i;
        Object localObject2 = null;
        continue;
        if (paramFromServiceMsg != null)
        {
          i = paramFromServiceMsg.getResultCode();
          continue;
          i = ((QQHeadUrl.QQHeadUrlRsp)localObject2).dstUsrType.get();
          if (i == 8) {
            i = 4;
          }
          for (;;)
          {
            int k = (byte)((QQHeadUrl.QQHeadUrlRsp)localObject2).dstEncryptType.get();
            paramObject = new ArrayList();
            paramFromServiceMsg = new ArrayList();
            ??? = ???.extraData.getParcelableArrayList("uinList");
            if ((??? != null) && (???.size() > 0))
            {
              localObject2 = ((QQHeadUrl.QQHeadUrlRsp)localObject2).dstHeadInfos.get();
              localObject3 = ???.iterator();
            }
            for (;;)
            {
              FriendListHandler.QQHeadDetails localQQHeadDetails;
              Object localObject4;
              QQHeadUrl.RspHeadInfo localRspHeadInfo;
              int j;
              if (((Iterator)localObject3).hasNext())
              {
                localQQHeadDetails = (FriendListHandler.QQHeadDetails)((Iterator)localObject3).next();
                localObject4 = ((List)localObject2).iterator();
                for (;;)
                {
                  if (((Iterator)localObject4).hasNext())
                  {
                    localRspHeadInfo = (QQHeadUrl.RspHeadInfo)((Iterator)localObject4).next();
                    if (k == 1)
                    {
                      ??? = localRspHeadInfo.dstUid.get();
                      if (QLog.isColorLevel()) {
                        QLog.d("FriendListHandler", 2, "handleQQHead_New rspUinOrMobile=" + StringUtil.d(???) + " detail.uinOrMobile" + StringUtil.d(localQQHeadDetails.jdField_a_of_type_JavaLangString));
                      }
                      if (!localQQHeadDetails.jdField_a_of_type_JavaLangString.equals(???)) {
                        continue;
                      }
                      localObject4 = new QQHeadInfo();
                      ((QQHeadInfo)localObject4).headLevel = localQQHeadDetails.jdField_a_of_type_Byte;
                      if (k != 1) {
                        break label574;
                      }
                      ((QQHeadInfo)localObject4).phoneNum = localRspHeadInfo.dstUid.get();
                      ((QQHeadInfo)localObject4).dwTimestamp = localRspHeadInfo.timestamp.get();
                      ((QQHeadInfo)localObject4).cHeadType = ((byte)localRspHeadInfo.faceType.get());
                      ((QQHeadInfo)localObject4).dstUsrType = ((byte)i);
                      ((QQHeadInfo)localObject4).dwFaceFlgas = ((byte)localRspHeadInfo.faceFlag.get());
                      ((QQHeadInfo)localObject4).downLoadUrl = localRspHeadInfo.url.get();
                      ((QQHeadInfo)localObject4).systemHeadID = ((short)localRspHeadInfo.sysid.get());
                      if (!localRspHeadInfo.headVerify.has()) {
                        break label590;
                      }
                      ??? = localRspHeadInfo.headVerify.get();
                      ((QQHeadInfo)localObject4).headVerify = ???;
                      paramObject.add(localObject4);
                      j = 1;
                    }
                  }
                }
              }
              for (;;)
              {
                if (j != 0) {
                  break label943;
                }
                paramFromServiceMsg.add(localQQHeadDetails);
                break label257;
                ??? = String.valueOf(localRspHeadInfo.dstUin.get());
                break label325;
                ((QQHeadInfo)localObject4).uin = localRspHeadInfo.dstUin.get();
                break label427;
                ??? = "";
                break label524;
                if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
                synchronized (this.jdField_b_of_type_JavaLangObject)
                {
                  if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
                    this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
                  }
                  j = 0;
                  if (j < paramObject.size())
                  {
                    ??? = (QQHeadInfo)paramObject.get(j);
                    a(0, a(???.uin, ???.phoneNum), ???.dstUsrType, 2);
                    localObject2 = new FaceInfo();
                    ((FaceInfo)localObject2).jdField_a_of_type_JavaLangString = ???.phoneNum;
                    ((FaceInfo)localObject2).jdField_b_of_type_Int = ???.idType;
                    ((FaceInfo)localObject2).jdField_a_of_type_Int = ???.dstUsrType;
                    ((FaceInfo)localObject2).jdField_a_of_type_AvatarInfoQQHeadInfo = ???;
                    this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.a((FaceInfo)localObject2);
                    j += 1;
                  }
                }
                if (paramFromServiceMsg.size() <= 0) {
                  break;
                }
                localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getEntityManagerFactory().createEntityManager();
                paramObject = ((EntityManager)localObject2).a();
                paramObject.a();
                j = 0;
                try
                {
                  if (j < paramFromServiceMsg.size())
                  {
                    localObject3 = (FriendListHandler.QQHeadDetails)paramFromServiceMsg.get(j);
                    if (i == 4) {}
                    for (??? = "troop_" + ((FriendListHandler.QQHeadDetails)localObject3).jdField_a_of_type_JavaLangString;; ??? = ((FriendListHandler.QQHeadDetails)localObject3).jdField_a_of_type_JavaLangString)
                    {
                      ??? = (com.tencent.mobileqq.data.Setting)((EntityManager)localObject2).a(com.tencent.mobileqq.data.Setting.class, ???);
                      if (??? != null)
                      {
                        ???.updateTimestamp = System.currentTimeMillis();
                        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(???);
                        ((EntityManager)localObject2).a(???);
                      }
                      b(i + "_" + ((FriendListHandler.QQHeadDetails)localObject3).jdField_a_of_type_JavaLangString, true);
                      j += 1;
                      break;
                    }
                  }
                  j = 0;
                }
                catch (Exception ???)
                {
                  paramObject.c();
                  paramObject.b();
                  return;
                }
              }
            }
          }
        }
        else
        {
          i = 65535;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handleQQHead_New qqHeadUrlResp=" + localObject1 + " qqHeadUrlRespData = " + paramObject);
    }
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (localObject1 == null) || (((QQHeadUrl.QQHeadUrlRsp)localObject1).result.get() != 0)) {
      if (localObject1 != null)
      {
        i = ((QQHeadUrl.QQHeadUrlRsp)localObject1).result.get();
        a(???, i);
        return;
      }
    }
  }
  
  private void j(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("search_version");
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (i != 2) {
        break label170;
      }
      bool1 &= paramObject instanceof RespSearch;
      i = 87;
    }
    for (;;)
    {
      label45:
      Object localObject = null;
      int j;
      label90:
      boolean bool2;
      if (bool1)
      {
        paramFromServiceMsg = (RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
        if (paramFromServiceMsg != null)
        {
          j = paramFromServiceMsg.iResult;
          paramFromServiceMsg = paramFromServiceMsg.strErrorMsg;
          bool2 = paramToServiceMsg.extraData.getBoolean("search_decode");
        }
      }
      for (;;)
      {
        a(49, bool1, new Object[] { Integer.valueOf(i), paramObject, Integer.valueOf(j), paramFromServiceMsg, Boolean.valueOf(bool2), Long.valueOf(paramToServiceMsg.extraData.getLong("session_id")) });
        return;
        bool1 = false;
        break;
        label170:
        if (i != 3) {
          break label215;
        }
        bool1 &= paramObject instanceof ArrayList;
        i = 88;
        break label45;
        paramFromServiceMsg = null;
        bool1 = false;
        j = 0;
        break label90;
        bool2 = false;
        j = 0;
        paramFromServiceMsg = localObject;
      }
      label215:
      i = -1;
    }
  }
  
  private void k(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null) && ((paramObject instanceof RespCondSearch)))
    {
      bool = true;
      if (!bool) {
        break label135;
      }
      paramFromServiceMsg = (RespHead)a(paramFromServiceMsg.getWupBuffer(), "RespHead", new RespHead());
      if (paramFromServiceMsg == null) {
        break label126;
      }
      i = paramFromServiceMsg.iResult;
      paramFromServiceMsg = paramFromServiceMsg.strErrorMsg;
    }
    for (;;)
    {
      a(73, bool, new Object[] { Long.valueOf(paramToServiceMsg.extraData.getLong("search_seq")), paramObject, Integer.valueOf(i), Integer.valueOf(paramToServiceMsg.extraData.getInt("param_search_from")) });
      return;
      bool = false;
      break;
      label126:
      i = 0;
      bool = false;
      continue;
      label135:
      i = 0;
    }
  }
  
  private void l(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    long l = paramToServiceMsg.extraData.getLong("dwReqType", 1L);
    if (l == 0L)
    {
      paramToServiceMsg = String.valueOf(paramToServiceMsg.extraData.getLong("dwUin"));
      if (paramObject != null) {
        break label76;
      }
      a(68, false, new Object[] { Long.valueOf(l), paramToServiceMsg });
    }
    label76:
    while (!(paramObject instanceof GetOnlineInfoResp))
    {
      return;
      paramToServiceMsg = paramToServiceMsg.extraData.getString("strMobile");
      break;
    }
    paramFromServiceMsg = (GetOnlineInfoResp)paramObject;
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handleOnlineInfo, uin = " + StringUtil.d(paramToServiceMsg) + ", result = " + paramFromServiceMsg.result + ", itermType = " + paramFromServiceMsg.iTermType + ", netType = " + paramFromServiceMsg.eNetworkType + ", abi = " + paramFromServiceMsg.uAbiFlag);
    }
    if ((l == 0L) && (paramFromServiceMsg.result == 0)) {
      ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).a(paramToServiceMsg, paramFromServiceMsg);
    }
    for (;;)
    {
      paramFromServiceMsg.dwInterval *= 1000L;
      if (paramFromServiceMsg.dwInterval < 15000L) {
        paramFromServiceMsg.dwInterval = 15000L;
      }
      this.jdField_e_of_type_Long = paramFromServiceMsg.dwInterval;
      a(68, true, new Object[] { Long.valueOf(l), paramToServiceMsg, paramFromServiceMsg });
      return;
      if ((l == 1L) && (paramFromServiceMsg.result == 0)) {
        ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a(paramToServiceMsg, paramFromServiceMsg);
      }
    }
  }
  
  private void m(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    String str = paramToServiceMsg.extraData.getString("uin");
    paramToServiceMsg = paramToServiceMsg.extraData.getString("com_value");
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = str;
    arrayOfObject[1] = paramToServiceMsg;
    if (1000 == paramFromServiceMsg.getResultCode())
    {
      paramFromServiceMsg = (ChangeFriendNameRes)paramObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.cResult == 0))
      {
        a(str, paramToServiceMsg, true);
        arrayOfObject[2] = Byte.valueOf(paramFromServiceMsg.cResult);
        a(27, true, arrayOfObject);
        return;
      }
      if (paramFromServiceMsg != null) {
        arrayOfObject[2] = Byte.valueOf(paramFromServiceMsg.cResult);
      }
      for (;;)
      {
        a(27, false, arrayOfObject);
        return;
        arrayOfObject[2] = Byte.valueOf(-1);
      }
    }
    arrayOfObject[2] = Byte.valueOf(-1);
    a(27, false, arrayOfObject);
  }
  
  private void n(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      paramObject = (SetRichSigRes)paramObject;
      if (paramObject.cResult == 0)
      {
        FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
        if (localFriendsManager != null)
        {
          byte[] arrayOfByte = paramToServiceMsg.extraData.getByteArray("sig_value");
          if (paramObject.dwTime == 0L) {
            paramObject.dwTime = 1L;
          }
          paramFromServiceMsg = localFriendsManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
          paramToServiceMsg = paramFromServiceMsg;
          if (paramFromServiceMsg == null)
          {
            paramToServiceMsg = new ExtensionInfo();
            paramToServiceMsg.uin = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
          }
          if (paramToServiceMsg.timestamp != paramObject.dwTime)
          {
            paramToServiceMsg.setRichBuffer(arrayOfByte, paramObject.dwTime);
            localFriendsManager.a(paramToServiceMsg);
          }
        }
        a(28, true, null);
        return;
      }
      a(28, false, Integer.valueOf(paramObject.cResult));
      return;
    }
    a(28, false, null);
  }
  
  private void o(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Oidb_0x5d1.RspBody localRspBody = new Oidb_0x5d1.RspBody();
    if ((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013) || (paramFromServiceMsg.getResultCode() != 1000))
    {
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
    }
    for (paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();; paramFromServiceMsg = localRspBody)
    {
      label174:
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result.has()))
        {
          i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel()) {
            QLog.i("Q.troopgetnews.", 2, "handle_oidb_0x5d1_0|oidb_sso.OIDBSSOPkg.result = " + i);
          }
        }
        if ((paramFromServiceMsg == null) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.bytes_bodybuffer.get().toByteArray();
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg) {}
      try
      {
        localRspBody.mergeFrom((byte[])paramFromServiceMsg);
        paramFromServiceMsg = localRspBody;
      }
      catch (Exception paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        paramFromServiceMsg = null;
        break label174;
      }
      if (paramFromServiceMsg == null) {
        break;
      }
      int i = paramFromServiceMsg.uint32_id.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : setId:" + i + "hex:" + "");
      }
      if (i != 4051) {
        break;
      }
      a(paramToServiceMsg, paramFromServiceMsg);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.troopgetnews.", 2, "handle_oidb_0x5d1_0| oidb_sso parseFrom byte " + paramToServiceMsg.toString());
      return;
    }
  }
  
  private void p(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = a(paramToServiceMsg);
    Bundle localBundle = new Bundle();
    localBundle.putLong("uin", paramToServiceMsg.extraData.getLong("uin"));
    if (i == 147) {}
    for (i = 72;; i = 71)
    {
      if ((paramObject == null) || (!paramFromServiceMsg.isSuccess()))
      {
        a(i, false, localBundle);
        return;
      }
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          long l = paramToServiceMsg.getInt();
          paramToServiceMsg.getShort();
          paramFromServiceMsg = new byte[4];
          paramToServiceMsg.get(paramFromServiceMsg);
          l = Utils.a(paramFromServiceMsg, 0);
          int j = paramToServiceMsg.get();
          localBundle.putLong("uin", l);
          localBundle.putInt("safety_flag", j & 0x1F);
          a(i, true, localBundle);
          return;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handle_oidb_0x476 error:" + paramToServiceMsg.getMessage());
        }
        a(i, false, localBundle);
        return;
      }
    }
  }
  
  private void q(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1;
    boolean bool2;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      bool2 = paramToServiceMsg.extraData.getBoolean("key_show_to_friends", true);
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "set network switch isSuccess = " + bool1 + "; isShowedToFriends = " + bool2);
      }
      if (!bool1) {
        break label192;
      }
    }
    label192:
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        if (bool1) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(bool2, false);
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handleSetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        bool1 = false;
        continue;
        continue;
      }
      if (!bool1)
      {
        bool2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
        a(76, bool1, Boolean.valueOf(bool2));
        return;
        bool1 = false;
        break;
        bool1 = false;
        continue;
      }
    }
  }
  
  private void r(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool5 = true;
    boolean bool6 = true;
    boolean bool4 = true;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool3 = true;
      bool1 = bool5;
      bool2 = bool3;
      if (bool3) {
        bool2 = bool6;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        bool2 = bool6;
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        bool2 = bool6;
        if (paramToServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool3 = true;
        bool1 = bool5;
        bool2 = bool3;
        if (bool3)
        {
          bool2 = bool6;
          paramToServiceMsg = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          bool2 = bool6;
          long l = paramToServiceMsg.getInt();
          bool2 = bool6;
          if (paramToServiceMsg.get() != 0) {
            continue;
          }
          bool1 = bool4;
          bool2 = bool1;
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(bool1, false);
          bool2 = bool3;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("handleGetShowNetworkToFriendResp", 2, paramToServiceMsg.getMessage());
        bool3 = false;
        bool1 = bool2;
        bool2 = bool3;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "get network switch isSuccess = " + bool2 + "; isShowedToFriends = " + bool1);
      }
      if (!bool2) {
        bool1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.c(false);
      }
      a(77, bool2, Boolean.valueOf(bool1));
      return;
      bool3 = false;
      break;
      bool3 = false;
      continue;
      bool1 = false;
    }
  }
  
  private void s(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() != 1000)
    {
      a(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
      return;
    }
    int i = paramToServiceMsg.extraData.getInt("startIndex");
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label73:
      break label73;
      int j = paramToServiceMsg.uint32_result.get();
      if (!QLog.isColorLevel()) {
        break label155;
      }
      QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList result " + j);
      if (j != 0) {
        break label961;
      }
      paramFromServiceMsg = new cmd0x7c4.RspBody();
      int k;
      FriendsManager localFriendsManager;
      ArrayList localArrayList;
      for (;;)
      {
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          paramObject = (cmd0x7c4.GetSNFrdListRsp)paramFromServiceMsg.msg_get_sn_frd_list_rsp.get();
          paramObject.uint64_uin.get();
          j = paramObject.uint32_sequence.get();
          k = paramObject.uint32_over.get();
          if (paramFromServiceMsg.rpt_msg_recommend_reason.has())
          {
            paramToServiceMsg = paramFromServiceMsg.rpt_msg_recommend_reason.get();
            ((FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50)).f(paramToServiceMsg);
          }
          paramToServiceMsg = paramObject.rpt_msg_one_frd_data.get();
          localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
          if (paramToServiceMsg == null) {
            break label577;
          }
          localArrayList = new ArrayList();
          Iterator localIterator = paramToServiceMsg.iterator();
          if (!localIterator.hasNext()) {
            break;
          }
          cmd0x7c4.OneFrdData localOneFrdData = (cmd0x7c4.OneFrdData)localIterator.next();
          Friends localFriends = new Friends();
          localFriends.uin = String.valueOf(localOneFrdData.uint64_frd_id.get());
          localFriends.age = localOneFrdData.uint32_ages.get();
          if (localOneFrdData.bytes_smart_remark.has())
          {
            paramToServiceMsg = localOneFrdData.bytes_smart_remark.get().toStringUtf8();
            localFriends.smartRemark = paramToServiceMsg;
            localFriends.gender = ((byte)localOneFrdData.uint32_gender.get());
            int m = localOneFrdData.uint32_reason_id.get();
            localFriends.recommReason = localFriendsManager.a(m);
            localArrayList.add(localFriends);
            if (QLog.isColorLevel()) {
              QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList Gather List : " + localFriends.uin + " ; resonId = " + m + " ; f.recommReason =  " + localFriends.recommReason + " ; f.age = " + localFriends.age + " ; f.smartRemark = " + localFriends.smartRemark + " ; f.gender = " + localFriends.gender);
            }
          }
          else
          {
            paramToServiceMsg = null;
          }
        }
        catch (Exception paramToServiceMsg)
        {
          a(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
          return;
        }
      }
      localFriendsManager.a(localArrayList, i);
      if (!paramObject.uint32_recommend_frd_count.has()) {
        break label827;
      }
      i = paramObject.uint32_recommend_frd_count.get();
      if (!QLog.isColorLevel()) {
        break label629;
      }
      QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  推荐人数 : " + i);
      localFriendsManager.b(i);
      boolean bool = paramFromServiceMsg.msg_box.has();
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getHandler(Conversation.class);
      if (!bool) {
        break label863;
      }
      if (!QLog.isColorLevel()) {
        break label676;
      }
      QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. ");
      paramToServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0);
      bool = paramToServiceMsg.getBoolean("hasPulledRecomGathered", false);
      paramToServiceMsg.edit().putBoolean("hasMsgBox", true).commit();
      if (!bool) {
        break label845;
      }
      if (!QLog.isColorLevel()) {
        break label748;
      }
      QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. hasPulled. ");
      for (;;)
      {
        if (k != 0) {
          break label881;
        }
        i = paramObject.uint32_next_start_idx.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "FriendListHandler handleGetGatheredContactsList. not Completed. continue to get. startIndex = " + i);
        }
        a(i);
        a(79, true, new Object[] { Boolean.valueOf(false), Boolean.valueOf(true) });
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  no recommended field. ");
        break;
        if (QLog.isColorLevel())
        {
          QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. hasPulled. go to get.");
          continue;
          if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList no has MsgBox. ");
          }
        }
      }
      if (!QLog.isColorLevel()) {
        break label896;
      }
      QLog.i("FriendListHandler", 2, "FriendListHandler handleGetGatheredContactsList. Completed.");
      this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).edit().putInt("GetFrdListReq_seq", j).commit();
      a(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
      return;
      if (j != 1) {
        break label993;
      }
      a(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(false) });
      return;
      a(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
    }
    if (!paramToServiceMsg.uint32_result.has())
    {
      a(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
      return;
    }
    label155:
    label577:
    label629:
    return;
  }
  
  private void t(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramToServiceMsg.extraData.getInt("key_permission_opcode");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("key_dongtai_permission", false);
    boolean bool1;
    if (a(paramToServiceMsg, paramFromServiceMsg, paramObject) == null)
    {
      if (!QLog.isColorLevel()) {
        break label167;
      }
      QLog.d("FriendListHandler", 2, "handleSetDongtaiPermission: ssoPkg parse failed");
      bool1 = false;
    }
    for (;;)
    {
      if (!bool1) {
        if (i == 1) {
          bool2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d(false);
        }
      }
      label257:
      for (;;)
      {
        label73:
        if (i == 1) {
          a(81, bool1, Boolean.valueOf(bool2));
        }
        label167:
        do
        {
          return;
          if (i == 1) {}
          try
          {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(bool2, false);
          }
          catch (Exception paramToServiceMsg)
          {
            if (!QLog.isColorLevel()) {
              break label167;
            }
            QLog.d("FriendListHandler", 2, "handleSetDongtaiPermission " + paramToServiceMsg.getMessage());
          }
          if (i == 2)
          {
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f(bool2, false);
            break label260;
            bool1 = false;
            break;
          }
          if (i != 3) {
            break label260;
          }
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(bool2, false);
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f(bool2, false);
          break label260;
          if (i != 2) {
            break label257;
          }
          bool2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(false);
          break label73;
          if (i == 2)
          {
            a(83, bool1, Boolean.valueOf(bool2));
            return;
          }
        } while (i != 3);
        a(85, bool1, null);
        return;
      }
      label260:
      bool1 = true;
    }
  }
  
  private void u(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool4 = true;
    boolean bool1;
    int i;
    Object localObject;
    if ((paramObject != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool1 = true;
      i = paramToServiceMsg.extraData.getInt("key_permission_opcode");
      paramFromServiceMsg = null;
      localObject = null;
      if (!bool1) {
        break label702;
      }
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.get() == 0))
        {
          bool2 = true;
          if (!bool2) {
            continue;
          }
          paramObject = new cmd0x7c7.RspBody();
          paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
          if (i != 1) {
            continue;
          }
          j = paramObject.uint32_not_see_qzone.get();
          if (j != 1) {
            continue;
          }
          bool1 = true;
          bool3 = bool1;
        }
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          if (paramObject.uint32_not_see_qzone.get() == 1)
          {
            bool1 = true;
            paramToServiceMsg.add(Boolean.valueOf(bool1));
            if (paramObject.uint32_prevent_dynamic.get() == 1)
            {
              bool1 = true;
              paramToServiceMsg.add(Boolean.valueOf(bool1));
              paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramObject.uint32_not_see_qzone.get() != 1) {
                continue;
              }
              bool1 = true;
              paramFromServiceMsg.e(bool1, false);
              paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface;
              if (paramObject.uint32_prevent_dynamic.get() != 1) {
                continue;
              }
              bool1 = true;
              paramFromServiceMsg.f(bool1, false);
              bool1 = true;
            }
          }
          else
          {
            bool1 = false;
            continue;
          }
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          bool1 = false;
          continue;
          if (paramToServiceMsg == null) {
            continue;
          }
          int j = paramToServiceMsg.uint32_result.get();
          paramToServiceMsg = localObject;
          bool1 = bool4;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("FriendListHandler", 2, "handleGetDongtaiPermission  fail resultCode : " + j);
          paramToServiceMsg = localObject;
          bool1 = bool4;
        }
        catch (Exception paramObject)
        {
          paramFromServiceMsg = paramToServiceMsg;
          paramToServiceMsg = paramObject;
          bool1 = bool3;
          continue;
        }
        paramToServiceMsg = paramToServiceMsg;
        bool1 = bool3;
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleGetDongtaiPermission Exception " + paramToServiceMsg.getMessage());
        }
        paramToServiceMsg = paramFromServiceMsg;
        bool2 = false;
        continue;
        paramToServiceMsg = localObject;
        bool1 = bool4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "ssoPkg is null");
        paramToServiceMsg = localObject;
        bool1 = bool4;
        continue;
        if (i == 2)
        {
          bool3 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(false);
          paramFromServiceMsg = paramToServiceMsg;
          continue;
        }
        paramFromServiceMsg = paramToServiceMsg;
        bool3 = bool1;
        if (i != 3) {
          continue;
        }
        paramFromServiceMsg = new ArrayList();
        paramFromServiceMsg.add(Boolean.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d(false)));
        paramFromServiceMsg.add(Boolean.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(false)));
        bool3 = bool1;
        continue;
        if (i == 2)
        {
          a(84, bool2, Boolean.valueOf(bool3));
          return;
        }
        if (i != 3) {
          continue;
        }
        a(86, bool2, paramFromServiceMsg);
        return;
      }
      try
      {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.e(bool1, false);
        paramToServiceMsg = null;
      }
      catch (Exception paramToServiceMsg)
      {
        bool1 = bool3;
        continue;
        paramToServiceMsg = null;
        bool1 = true;
        continue;
      }
      paramFromServiceMsg = paramToServiceMsg;
      bool3 = bool1;
      if (!bool2)
      {
        if (i == 1)
        {
          bool3 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d(false);
          paramFromServiceMsg = paramToServiceMsg;
        }
      }
      else
      {
        if (i != 1) {
          continue;
        }
        a(82, bool2, Boolean.valueOf(bool3));
        return;
        bool1 = false;
        break;
        bool2 = false;
        continue;
        bool1 = false;
        continue;
        if (i == 2)
        {
          j = paramObject.uint32_prevent_dynamic.get();
          if (j == 1)
          {
            bool1 = true;
            bool3 = bool1;
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.f(bool1, false);
            paramToServiceMsg = null;
            continue;
          }
          bool1 = false;
          continue;
        }
        if (i != 3) {
          break label694;
        }
        paramToServiceMsg = new ArrayList();
      }
      label694:
      label702:
      bool3 = true;
      boolean bool2 = bool1;
      paramToServiceMsg = null;
      bool1 = bool3;
    }
  }
  
  /* Error */
  private void v(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 6
    //   3: aload_2
    //   4: ifnull +138 -> 142
    //   7: aload_2
    //   8: invokevirtual 139	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   11: ifeq +131 -> 142
    //   14: aload_3
    //   15: ifnull +127 -> 142
    //   18: iconst_1
    //   19: istore 5
    //   21: aload_1
    //   22: getfield 148	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   25: ldc_w 3321
    //   28: iconst_1
    //   29: invokevirtual 1844	android/os/Bundle:getBoolean	(Ljava/lang/String;Z)Z
    //   32: istore 7
    //   34: aconst_null
    //   35: astore_2
    //   36: aconst_null
    //   37: astore 8
    //   39: aconst_null
    //   40: astore 9
    //   42: iload 5
    //   44: ifeq +316 -> 360
    //   47: new 199	tencent/im/oidb/oidb_sso$OIDBSSOPkg
    //   50: dup
    //   51: invokespecial 365	tencent/im/oidb/oidb_sso$OIDBSSOPkg:<init>	()V
    //   54: astore 9
    //   56: aload 9
    //   58: aload_3
    //   59: checkcast 414	[B
    //   62: checkcast 414	[B
    //   65: invokevirtual 366	tencent/im/oidb/oidb_sso$OIDBSSOPkg:mergeFrom	([B)Lcom/tencent/mobileqq/pb/MessageMicro;
    //   68: pop
    //   69: aload 9
    //   71: ifnull +77 -> 148
    //   74: aload 9
    //   76: getfield 203	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   79: invokevirtual 208	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   82: ifne +66 -> 148
    //   85: iconst_1
    //   86: istore 5
    //   88: iload 5
    //   90: ifeq +125 -> 215
    //   93: aload_1
    //   94: getfield 148	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   97: ldc_w 3323
    //   100: invokevirtual 1931	android/os/Bundle:getStringArrayList	(Ljava/lang/String;)Ljava/util/ArrayList;
    //   103: astore_1
    //   104: aload_0
    //   105: getfield 188	com/tencent/mobileqq/app/FriendListHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   108: bipush 50
    //   110: invokevirtual 192	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   113: checkcast 629	com/tencent/mobileqq/app/FriendsManager
    //   116: astore_2
    //   117: iload 7
    //   119: ifeq +35 -> 154
    //   122: aload_2
    //   123: aload_1
    //   124: invokevirtual 3325	com/tencent/mobileqq/app/FriendsManager:e	(Ljava/util/List;)V
    //   127: iload 7
    //   129: ifeq +211 -> 340
    //   132: aload_0
    //   133: bipush 90
    //   135: iload 5
    //   137: aload_1
    //   138: invokevirtual 316	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   141: return
    //   142: iconst_0
    //   143: istore 5
    //   145: goto -124 -> 21
    //   148: iconst_0
    //   149: istore 5
    //   151: goto -63 -> 88
    //   154: aload_2
    //   155: aload_1
    //   156: invokevirtual 3327	com/tencent/mobileqq/app/FriendsManager:d	(Ljava/util/List;)V
    //   159: goto -32 -> 127
    //   162: astore_3
    //   163: aload_1
    //   164: astore_2
    //   165: iload 6
    //   167: istore 5
    //   169: aload_2
    //   170: astore_1
    //   171: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   174: ifeq -47 -> 127
    //   177: ldc 113
    //   179: iconst_2
    //   180: new 115	java/lang/StringBuilder
    //   183: dup
    //   184: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   187: ldc_w 3329
    //   190: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   193: aload_3
    //   194: invokevirtual 2798	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException:getMessage	()Ljava/lang/String;
    //   197: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   200: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   203: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   206: iload 6
    //   208: istore 5
    //   210: aload_2
    //   211: astore_1
    //   212: goto -85 -> 127
    //   215: aload 9
    //   217: ifnull +49 -> 266
    //   220: aload 9
    //   222: getfield 203	tencent/im/oidb/oidb_sso$OIDBSSOPkg:uint32_result	Lcom/tencent/mobileqq/pb/PBUInt32Field;
    //   225: invokevirtual 208	com/tencent/mobileqq/pb/PBUInt32Field:get	()I
    //   228: istore 4
    //   230: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   233: ifeq +133 -> 366
    //   236: ldc 113
    //   238: iconst_2
    //   239: new 115	java/lang/StringBuilder
    //   242: dup
    //   243: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   246: ldc_w 3331
    //   249: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: iload 4
    //   254: invokevirtual 213	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   257: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   260: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   263: goto +103 -> 366
    //   266: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   269: ifeq +12 -> 281
    //   272: ldc 113
    //   274: iconst_2
    //   275: ldc_w 3333
    //   278: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   281: aconst_null
    //   282: astore_1
    //   283: goto -156 -> 127
    //   286: astore_3
    //   287: aload 8
    //   289: astore_2
    //   290: iload 6
    //   292: istore 5
    //   294: aload_2
    //   295: astore_1
    //   296: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   299: ifeq -172 -> 127
    //   302: ldc 113
    //   304: iconst_2
    //   305: new 115	java/lang/StringBuilder
    //   308: dup
    //   309: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   312: ldc_w 3329
    //   315: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: aload_3
    //   319: invokevirtual 374	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   322: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   328: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   331: iload 6
    //   333: istore 5
    //   335: aload_2
    //   336: astore_1
    //   337: goto -210 -> 127
    //   340: aload_0
    //   341: bipush 91
    //   343: iload 5
    //   345: aload_1
    //   346: invokevirtual 316	com/tencent/mobileqq/app/FriendListHandler:a	(IZLjava/lang/Object;)V
    //   349: return
    //   350: astore_3
    //   351: aload_1
    //   352: astore_2
    //   353: goto -63 -> 290
    //   356: astore_3
    //   357: goto -192 -> 165
    //   360: aload 9
    //   362: astore_1
    //   363: goto -236 -> 127
    //   366: aconst_null
    //   367: astore_1
    //   368: goto -241 -> 127
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	FriendListHandler
    //   0	371	1	paramToServiceMsg	ToServiceMsg
    //   0	371	2	paramFromServiceMsg	FromServiceMsg
    //   0	371	3	paramObject	Object
    //   228	25	4	i	int
    //   19	325	5	bool1	boolean
    //   1	331	6	bool2	boolean
    //   32	96	7	bool3	boolean
    //   37	251	8	localObject	Object
    //   40	321	9	localOIDBSSOPkg	oidb_sso.OIDBSSOPkg
    // Exception table:
    //   from	to	target	type
    //   104	117	162	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   122	127	162	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   154	159	162	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   47	69	286	java/lang/Exception
    //   74	85	286	java/lang/Exception
    //   93	104	286	java/lang/Exception
    //   220	263	286	java/lang/Exception
    //   266	281	286	java/lang/Exception
    //   104	117	350	java/lang/Exception
    //   122	127	350	java/lang/Exception
    //   154	159	350	java/lang/Exception
    //   47	69	356	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   74	85	356	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   93	104	356	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   220	263	356	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
    //   266	281	356	com/tencent/mobileqq/pb/InvalidProtocolBufferMicroException
  }
  
  private void w(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool = true;
    }
    int i;
    int j;
    label302:
    int k;
    int m;
    ArrayList localArrayList;
    label510:
    MayKnowRecommend localMayKnowRecommend;
    int i2;
    for (;;)
    {
      i = 0;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleMayKnowRecommend success=" + bool);
      }
      paramToServiceMsg = new StringBuilder();
      if (!bool) {
        break label1444;
      }
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg != null) && (paramFromServiceMsg.uint32_result != null)) {}
        for (bool = true;; bool = false)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleMayKnowRecommend isSuccess=" + bool + " result=" + 0);
          }
          if (bool)
          {
            j = paramFromServiceMsg.uint32_result.get();
            i = j;
            if (QLog.isColorLevel())
            {
              QLog.d("FriendListHandler", 2, "handleMayKnowRecommend result=" + j);
              i = j;
            }
          }
          if ((i & 0xFF) != 132) {
            break label302;
          }
          ((MayknowRecommendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(158)).a(new ArrayList());
          a(92, true, null);
          return;
          bool = false;
          break;
        }
        if ((!bool) || (i != 0) || (paramFromServiceMsg.bytes_bodybuffer == null) || (!paramFromServiceMsg.bytes_bodybuffer.has()) || (paramFromServiceMsg.bytes_bodybuffer.get() == null)) {
          break label1444;
        }
        paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
        i = paramFromServiceMsg.get();
        j = paramFromServiceMsg.getShort();
        k = paramFromServiceMsg.get();
        if (k == 1) {}
        m = paramFromServiceMsg.getShort();
        int n = paramFromServiceMsg.getShort();
        new HashMap(n);
        paramObject = new StringBuffer(1024);
        if (QLog.isColorLevel())
        {
          paramObject.append("handleMayKnowRecommend cFlag=");
          paramObject.append(i);
          paramObject.append(" wTotalUinNum=");
          paramObject.append(j);
          paramObject.append(" cEndFlag=");
          paramObject.append(k);
          paramObject.append(" wEndPos=");
          paramObject.append(m);
          paramObject.append(" wUinNum=");
          paramObject.append(n);
        }
        localArrayList = new ArrayList(n);
        if (n <= 0) {
          break label1367;
        }
        i = 0;
        if (i >= n) {
          break label1351;
        }
        localMayKnowRecommend = new MayKnowRecommend();
        paramFromServiceMsg.getShort();
        localObject = String.valueOf(Utils.a(paramFromServiceMsg.getInt()));
        localMayKnowRecommend.uin = ((String)localObject);
        if (QLog.isColorLevel())
        {
          paramObject.append(" \nuin=");
          paramObject.append((String)localObject);
        }
        paramFromServiceMsg.get();
        int i1 = paramFromServiceMsg.get();
        j = 0;
        if (j >= i1) {
          break label1333;
        }
        i2 = paramFromServiceMsg.get();
        m = paramFromServiceMsg.get();
        if (!QLog.isColorLevel()) {
          break label1497;
        }
        paramToServiceMsg.append(" len = ").append(m).append("\n");
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          break label730;
        }
        QLog.w("FriendListHandler", 2, "handleMayKnowRecommend e", paramFromServiceMsg);
        if (!QLog.isColorLevel()) {
          break label764;
        }
        QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
        if (!QLog.isColorLevel()) {
          break label780;
        }
        QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
        a(92, false, null);
        return;
        localMayKnowRecommend.recommendReason = new String((byte[])localObject);
        if (!QLog.isColorLevel()) {
          break label1580;
        }
        paramObject.append(" reason=");
        paramObject.append(localMayKnowRecommend.recommendReason);
      }
      catch (Exception paramFromServiceMsg)
      {
        for (;;)
        {
          label632:
          if (QLog.isColorLevel()) {
            QLog.w("FriendListHandler", 2, "handleMayKnowRecommend ex", paramFromServiceMsg);
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
          }
        }
        localMayKnowRecommend.age = Utils.a((byte[])localObject, 0);
        if (!QLog.isColorLevel()) {
          break label1580;
        }
        paramObject.append(" age=");
        paramObject.append(localMayKnowRecommend.age);
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          break label973;
        }
        QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
        if (!QLog.isColorLevel()) {
          break label989;
        }
        QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
      }
    }
    Object localObject = new byte[k];
    paramFromServiceMsg.get((byte[])localObject, 0, k);
    if (QLog.isColorLevel())
    {
      paramObject.append(" type=");
      paramObject.append(i2);
      break label1517;
      localMayKnowRecommend.remark = new String((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1580;
      }
      paramObject.append(" remark=");
      paramObject.append(localMayKnowRecommend.remark);
      break label1580;
      label730:
      label764:
      localMayKnowRecommend.gender = Utils.a((byte[])localObject, 0);
      label780:
      label973:
      label989:
      if (!QLog.isColorLevel()) {
        break label1580;
      }
      paramObject.append(" gender=");
      paramObject.append(localMayKnowRecommend.gender);
      break label1580;
      localMayKnowRecommend.country = new String((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1580;
      }
      paramObject.append(" country=");
      paramObject.append(localMayKnowRecommend.country);
      break label1580;
      localMayKnowRecommend.province = new String((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1580;
      }
      paramObject.append(" province=");
      paramObject.append(localMayKnowRecommend.province);
      break label1580;
      localMayKnowRecommend.city = new String((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1580;
      }
      paramObject.append(" city=");
      paramObject.append(localMayKnowRecommend.city);
      break label1580;
      localMayKnowRecommend.nick = new String((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1580;
      }
      paramObject.append(" nick=");
      paramObject.append(localMayKnowRecommend.nick);
      break label1580;
      localMayKnowRecommend.category = new String((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1580;
      }
      paramObject.append(" category=");
      paramObject.append(localMayKnowRecommend.category);
      break label1580;
      localMayKnowRecommend.algBuffer = ((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1580;
      }
      paramObject.append(" algBuffer=");
      paramObject.append(new String(localMayKnowRecommend.algBuffer));
      break label1580;
      localMayKnowRecommend.richSingature = ((byte[])localObject);
      if (!QLog.isColorLevel()) {
        break label1580;
      }
      paramObject.append(" richSingature=");
      break label1580;
    }
    for (;;)
    {
      localMayKnowRecommend.hasQZoneUpdate = bool;
      if (QLog.isColorLevel())
      {
        paramObject.append(" hasQZoneUpdate=");
        paramObject.append(localMayKnowRecommend.hasQZoneUpdate);
        break label1580;
        label1333:
        localArrayList.add(localMayKnowRecommend);
        i = (short)(i + 1);
        break label510;
        label1351:
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, paramObject.toString());
        }
        label1367:
        ((MayknowRecommendManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(158)).a(localArrayList);
        a(92, true, null);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
        }
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
        return;
        label1444:
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleMayKnowRecommend over time=" + System.currentTimeMillis());
        }
        if (!QLog.isColorLevel()) {
          break label780;
        }
        QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
        break label780;
        label1497:
        k = m;
        if (m >= 0) {
          break label632;
        }
        k = m + 256;
        break label632;
      }
      switch (i2)
      {
      case 6: 
      case 7: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 15: 
      case 16: 
      default: 
        j = (byte)(j + 1);
        break;
      case 17: 
        label1517:
        if (localObject[0] == 0) {
          bool = false;
        } else {
          bool = true;
        }
        label1580:
        break;
      }
    }
  }
  
  private void x(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if ((!bool1) && (QLog.isColorLevel())) {
        QLog.d("FriendListHandler", 2, "handleCancelMayKnowRecommend failed uin=" + paramToServiceMsg.extraData.getString("uin"));
      }
      bool2 = bool1;
      if (bool1)
      {
        bool2 = bool1;
        if (paramObject != null) {
          paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        }
      }
      try
      {
        paramObject = (oidb_sso.OIDBSSOPkg)paramFromServiceMsg.mergeFrom((byte[])paramObject);
        paramFromServiceMsg = paramObject;
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        for (;;)
        {
          int i;
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleCancelMayKnowRecommend", paramObject);
          }
          paramObject.printStackTrace();
          continue;
          bool2 = false;
        }
      }
      if (!paramFromServiceMsg.uint32_result.has()) {
        break label237;
      }
      i = paramFromServiceMsg.uint32_result.get();
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleCancelMayKnowRecommend" + i);
      }
      if (i != 0) {
        break label237;
      }
      ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(158)).b(paramToServiceMsg.extraData.getString("uin"));
      bool2 = true;
      a(93, bool2, paramToServiceMsg.extraData.getString("uin"));
      return;
    }
  }
  
  private void y(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()))
    {
      bool = true;
      if ((!bool) && (QLog.isColorLevel())) {
        QLog.d("FriendListHandler", 2, "handleReportMayknowExplosure failed");
      }
      if ((bool) && (paramObject != null)) {
        paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      }
    }
    else
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        for (;;)
        {
          int i;
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleReportMayknowExplosure", paramFromServiceMsg);
          }
          paramFromServiceMsg.printStackTrace();
          continue;
          bool = false;
        }
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleReportMayknowExplosure" + i);
        }
        if (i == 0) {
          bool = true;
        }
      }
    }
    for (;;)
    {
      ((MayknowRecommendManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(158)).a(bool);
      return;
      bool = false;
      break;
    }
  }
  
  private void z(ToServiceMsg arg1, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend resp: " + paramFromServiceMsg + ", data: " + paramObject);
    }
    boolean bool;
    Object localObject;
    if ((??? != null) && (paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool = true;
      if (!bool) {
        break label735;
      }
      jdField_a_of_type_Int = 0;
      localObject = new oidb_0x7df.RspBody();
      ??? = a(???, paramFromServiceMsg, paramObject);
      if (??? == null) {
        break label372;
      }
    }
    int i;
    label372:
    label378:
    do
    {
      for (;;)
      {
        try
        {
          ((oidb_0x7df.RspBody)localObject).mergeFrom(???.bytes_bodybuffer.get().toByteArray());
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend isSuccess: " + bool);
          }
          if (!bool) {
            break label735;
          }
          a(95, true, localObject);
          if (QLog.isColorLevel())
          {
            ??? = new StringBuilder().append("FriendListHandler.handleSpecialCareRecommend isOver: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_over.has()) {
              break label378;
            }
            i = ((oidb_0x7df.RspBody)localObject).uint32_over.get();
            ??? = ???.append(i).append(", next: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_next_start.has()) {
              break label384;
            }
            i = ((oidb_0x7df.RspBody)localObject).uint32_next_start.get();
            ??? = ???.append(i).append(", total: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_total.has()) {
              break label390;
            }
            i = ((oidb_0x7df.RspBody)localObject).uint32_total.get();
            ??? = ???.append(i).append(", lowest: ");
            if (!((oidb_0x7df.RspBody)localObject).uint32_low_score.has()) {
              break label396;
            }
            i = ((oidb_0x7df.RspBody)localObject).uint32_low_score.get();
            QLog.d("FriendListHandler", 2, i);
          }
          if (((oidb_0x7df.RspBody)localObject).rpt_msg_friend_score.has()) {
            break label402;
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend rpt_msg_friend_score has no data.");
          }
          return;
          bool = false;
        }
        catch (Exception ???)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend RspBody mergeFrom failed.");
          }
          ???.printStackTrace();
          bool = false;
          continue;
        }
        bool = false;
        continue;
        i = -1;
        continue;
        i = -1;
        continue;
        i = -1;
        continue;
        i = -1;
      }
      paramFromServiceMsg = ((oidb_0x7df.RspBody)localObject).rpt_msg_friend_score.get();
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0)) {
        break label440;
      }
    } while (!QLog.isColorLevel());
    label384:
    label390:
    label396:
    label402:
    QLog.d("FriendListHandler", 2, "FriendListHandler.handleSpecialCareRecommend friendList is null or has no data.");
    return;
    label440:
    paramObject = paramFromServiceMsg.iterator();
    while (paramObject.hasNext())
    {
      localObject = (oidb_0x7df.FriendScore)paramObject.next();
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("FriendListHandler.handleSpecialCareRecommend uin: ");
        if (((oidb_0x7df.FriendScore)localObject).uint64_friend_uin.has())
        {
          ??? = String.valueOf(((oidb_0x7df.FriendScore)localObject).uint64_friend_uin.get());
          label511:
          ??? = localStringBuilder.append(???).append(", score: ");
          if (!((oidb_0x7df.FriendScore)localObject).uint32_friend_score.has()) {
            break label678;
          }
          i = ((oidb_0x7df.FriendScore)localObject).uint32_friend_score.get();
          label545:
          localStringBuilder = ???.append(i).append(", relation: ");
          if (!((oidb_0x7df.FriendScore)localObject).bytes_relation_name.has()) {
            break label684;
          }
          ??? = ((oidb_0x7df.FriendScore)localObject).bytes_relation_name.get().toStringUtf8();
          label582:
          ??? = localStringBuilder.append(???).append(", rank: ");
          if (!((oidb_0x7df.FriendScore)localObject).uint32_rank.has()) {
            break label691;
          }
          i = ((oidb_0x7df.FriendScore)localObject).uint32_rank.get();
          label616:
          localStringBuilder = ???.append(i).append(", nick: ");
          if (!((oidb_0x7df.FriendScore)localObject).bytes_nick.has()) {
            break label697;
          }
        }
        label678:
        label684:
        label691:
        label697:
        for (??? = ((oidb_0x7df.FriendScore)localObject).bytes_nick.get().toStringUtf8();; ??? = "")
        {
          QLog.d("FriendListHandler", 2, ???);
          break;
          ??? = "";
          break label511;
          i = -1;
          break label545;
          ??? = "";
          break label582;
          i = -1;
          break label616;
        }
      }
    }
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaUtilArrayList.clear();
      this.jdField_a_of_type_JavaUtilArrayList.addAll(paramFromServiceMsg);
      return;
    }
    label735:
    jdField_a_of_type_Int = 1;
    a(95, false, null);
  }
  
  public QQHeadDownloadHandler a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler;
    }
  }
  
  protected Class a()
  {
    return FriendListObserver.class;
  }
  
  public String a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.a();
    }
  }
  
  public String a(int paramInt, long paramLong, String paramString)
  {
    if (paramInt == 11) {
      return paramString;
    }
    return Long.toString(paramLong);
  }
  
  public String a(long paramLong)
  {
    int i = 0;
    if (this.jdField_a_of_type_JavaUtilHashMap == null)
    {
      Object localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(ServerConfigManager.ConfigType.app, "offlineTips");
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
        try
        {
          localObject1 = ((String)localObject1).split(";");
          int j = localObject1.length;
          while (i < j)
          {
            Object localObject2 = localObject1[i].split(":");
            long l = Long.parseLong(localObject2[0]);
            localObject2 = localObject2[1];
            this.jdField_a_of_type_JavaUtilHashMap.put(Long.valueOf(l), localObject2);
            i += 1;
          }
          str = null;
        }
        catch (Exception localException) {}
      }
    }
    String str;
    if (this.jdField_a_of_type_JavaUtilHashMap != null) {
      str = (String)this.jdField_a_of_type_JavaUtilHashMap.get(Long.valueOf(paramLong));
    }
    return str;
  }
  
  public String a(long paramLong, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    return String.valueOf(paramLong);
  }
  
  public ArrayList a()
  {
    synchronized (this.jdField_c_of_type_JavaLangObject)
    {
      ArrayList localArrayList = this.jdField_a_of_type_JavaUtilArrayList;
      return localArrayList;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.a();
    }
    g();
    super.a();
  }
  
  public void a(byte paramByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "DeleteFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 2);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    a(localToServiceMsg);
  }
  
  public void a(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "AddFriendGroup :" + paramString);
    }
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 0);
    localToServiceMsg.extraData.putByte("sort_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    a(localToServiceMsg);
  }
  
  public void a(byte paramByte, ArrayList paramArrayList)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.BindUin");
    localToServiceMsg.extraData.putByte("cCmd", paramByte);
    localToServiceMsg.addAttribute("vecBindUin", paramArrayList);
    a(localToServiceMsg);
  }
  
  public void a(int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("OidbSvc.0x7c4_0");
    localToServiceMsg.extraData.putInt("startIndex", paramInt);
    cmd0x7c4.ReqBody localReqBody = new cmd0x7c4.ReqBody();
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount();
    cmd0x7c4.GetSNFrdListReq localGetSNFrdListReq = new cmd0x7c4.GetSNFrdListReq();
    localGetSNFrdListReq.uint64_uin.set(Long.parseLong((String)localObject));
    int i = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getSharedPreferences(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
    localGetSNFrdListReq.uint32_sequence.set(i);
    localGetSNFrdListReq.uint32_start_idx.set(paramInt);
    localGetSNFrdListReq.uint32_req_num.set(h);
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "FriendListHandler getGatheredContactsList(). startIndex = " + paramInt + " | seq = " + i);
    }
    localReqBody.msg_get_sn_frd_list_req.set(localGetSNFrdListReq);
    localReqBody.uint32_client_ver.set(2);
    localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1988);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    localToServiceMsg.setTimeout(30000L);
    b(localToServiceMsg);
  }
  
  public void a(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getAllGeneralSettings.localRevision=" + paramInt1 + " offset=" + paramLong + " respRevision=" + paramInt2 + " isNeedGetTroopMsgFilter=" + paramBoolean);
    }
    ArrayList localArrayList = new ArrayList();
    if (paramBoolean) {
      localArrayList.add("message.group.policy.*");
    }
    localArrayList.add("message.group.policy_pc.*");
    localArrayList.add("sync.c2c_message");
    localArrayList.add("message.group.ring");
    localArrayList.add("message.group.vibrate");
    localArrayList.add("message.ring.switch");
    localArrayList.add("message.vibrate.switch");
    localArrayList.add("message.ring.care");
    a(localArrayList, paramInt1, paramLong, paramInt2, 100, paramBoolean);
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte, byte paramByte, String paramString, long paramLong3, long paramLong4)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "BumpSvc.ReqComfirmContactFriend");
    Object localObject = ((PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10)).a();
    if (localObject != null)
    {
      String str = ((RespondQueryQQBindingStat)localObject).nationCode + ((RespondQueryQQBindingStat)localObject).mobileNo;
      if ((str != null) && (str.length() > 0))
      {
        localObject = str;
        if (str.startsWith("+")) {
          localObject = str.substring(1);
        }
      }
    }
    for (long l = Long.parseLong((String)localObject);; l = 0L)
    {
      localToServiceMsg.extraData.putInt("bType", paramInt);
      localToServiceMsg.extraData.putLong("lToMID", paramLong1);
      localToServiceMsg.extraData.putLong("lFromMobile", l);
      localToServiceMsg.extraData.putLong("lToMobile", paramLong2);
      localToServiceMsg.extraData.putByteArray("vSig", paramArrayOfByte);
      localToServiceMsg.extraData.putByte("bGroupId", paramByte);
      localToServiceMsg.extraData.putString("strNickName", paramString);
      localToServiceMsg.extraData.putLong("infotime", paramLong3);
      localToServiceMsg.extraData.putLong("dbid", paramLong4);
      a(localToServiceMsg);
      return;
    }
  }
  
  public void a(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramString, paramInt2, paramInt3, 0, null, 0, 0L);
  }
  
  public void a(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5, long paramLong)
  {
    boolean bool;
    long l1;
    if (paramInt1 == 0)
    {
      bool = true;
      l1 = paramLong;
      if (paramLong == 0L) {
        l1 = System.currentTimeMillis();
      }
      if (paramInt3 != 1) {
        break label654;
      }
      if (this.jdField_c_of_type_JavaUtilHashtable.containsKey(paramString1)) {
        this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
      }
      paramString2 = new zlc(this);
      paramString2.jdField_a_of_type_Long = l1;
      paramString2.jdField_b_of_type_Int = paramInt2;
      this.jdField_c_of_type_JavaUtilHashtable.put(paramString1, paramString2);
    }
    for (;;)
    {
      long l2;
      Object localObject;
      if (((!bool) || (paramInt3 == 4)) && (paramString2 != null))
      {
        l2 = paramString2.jdField_b_of_type_Long - paramString2.jdField_a_of_type_Long;
        l1 = 0L;
        paramLong = l1;
        if (paramString2.jdField_c_of_type_Long > paramString2.jdField_b_of_type_Long)
        {
          paramLong = l1;
          if (paramString2.jdField_b_of_type_Long > 0L) {
            paramLong = paramString2.jdField_c_of_type_Long - paramString2.jdField_b_of_type_Long;
          }
        }
        l1 = paramString2.jdField_d_of_type_Long - paramString2.jdField_c_of_type_Long;
        if ((QLog.isColorLevel()) || ((bool) && (paramInt3 == 4) && (paramString2.jdField_e_of_type_Long > 3000L)))
        {
          localObject = new StringBuffer(200);
          ((StringBuffer)localObject).append("===QQHeadStat resultCode=").append(paramInt1);
          ((StringBuffer)localObject).append(", uin=").append(String.format("%11s", new Object[] { paramString1 }));
          ((StringBuffer)localObject).append(", totalTime=").append(String.format("%-5s", new Object[] { Long.valueOf(paramString2.jdField_e_of_type_Long) }));
          ((StringBuffer)localObject).append(", picSize=").append(String.format("%-6s", new Object[] { Integer.valueOf(paramString2.jdField_a_of_type_Int) }));
          ((StringBuffer)localObject).append(", downInfoTime=").append(l2);
          ((StringBuffer)localObject).append(", intervalTime=").append(paramLong);
          ((StringBuffer)localObject).append(", downPicTime=").append(l1);
          ((StringBuffer)localObject).append(", reasonCode=").append(paramInt5);
          ((StringBuffer)localObject).append(", downUrl=").append(paramString2.jdField_a_of_type_JavaLangString);
          if (!QLog.isColorLevel()) {
            break label826;
          }
        }
      }
      label654:
      label826:
      for (paramInt3 = 2;; paramInt3 = 1)
      {
        QLog.d("QQHeadCostTime", paramInt3, ((StringBuffer)localObject).toString());
        if (NetworkUtil.d(BaseApplication.getContext()))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("qqhead_uin", paramString1);
          ((HashMap)localObject).put("downInfo_time", String.valueOf(l2));
          ((HashMap)localObject).put("interval_time", String.valueOf(paramLong));
          ((HashMap)localObject).put("downPic_time", String.valueOf(l1));
          ((HashMap)localObject).put("downPic_size", String.valueOf(paramString2.jdField_a_of_type_Int));
          ((HashMap)localObject).put("download_url", paramString2.jdField_a_of_type_JavaLangString);
          ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInt1));
          ((HashMap)localObject).put("fail_reason", Integer.toString(paramInt5));
          ((HashMap)localObject).put("param_threadOpId", String.valueOf(ThreadOptimizer.a().a()));
          paramString1 = FaceDownloader.a(paramInt2);
          if (!TextUtils.isEmpty(paramString1)) {
            StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, bool, paramString2.jdField_e_of_type_Long, paramString2.jdField_a_of_type_Int, (HashMap)localObject, "");
          }
          paramString1 = FaceDownloader.b(paramInt2);
          StatisticCollector.a(BaseApplication.getContext()).a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString1, bool, paramString2.jdField_e_of_type_Long, paramString2.jdField_a_of_type_Int, (HashMap)localObject, "");
        }
        do
        {
          return;
          bool = false;
          break;
          if (!this.jdField_c_of_type_JavaUtilHashtable.containsKey(paramString1)) {
            break label832;
          }
          localObject = (zlc)this.jdField_c_of_type_JavaUtilHashtable.get(paramString1);
        } while (localObject == null);
        switch (paramInt3)
        {
        }
        for (;;)
        {
          paramString2 = (String)localObject;
          break;
          ((zlc)localObject).jdField_b_of_type_Long = l1;
          if (!bool) {
            this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
          }
          ((zlc)localObject).jdField_e_of_type_Long = (((zlc)localObject).jdField_b_of_type_Long - ((zlc)localObject).jdField_a_of_type_Long);
          paramString2 = (String)localObject;
          break;
          ((zlc)localObject).jdField_c_of_type_Long = l1;
          paramString2 = (String)localObject;
          break;
          ((zlc)localObject).jdField_d_of_type_Long = l1;
          ((zlc)localObject).jdField_a_of_type_Int = paramInt4;
          ((zlc)localObject).jdField_a_of_type_JavaLangString = paramString2;
          ((zlc)localObject).jdField_e_of_type_Long = (((zlc)localObject).jdField_d_of_type_Long - ((zlc)localObject).jdField_a_of_type_Long);
          this.jdField_c_of_type_JavaUtilHashtable.remove(paramString1);
        }
      }
      label832:
      paramString2 = null;
    }
  }
  
  public void a(int paramInt, ConcurrentHashMap paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap == null) || (paramConcurrentHashMap.size() == 0)) {
      return;
    }
    Object localObject = new ConcurrentHashMap();
    ((Map)localObject).putAll(paramConcurrentHashMap);
    paramConcurrentHashMap = new ArrayList();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      Map.Entry localEntry = (Map.Entry)((Iterator)localObject).next();
      paramConcurrentHashMap.add(new GeneralSettings.Setting((String)localEntry.getKey(), ((Integer)localEntry.getValue()).toString()));
    }
    localObject = a("ProfileService.ReqSetSettings");
    ((ToServiceMsg)localObject).extraData.putSerializable("Settings", paramConcurrentHashMap);
    ((ToServiceMsg)localObject).extraData.putSerializable("localRevision", Integer.valueOf(paramInt));
    a((ToServiceMsg)localObject);
  }
  
  public void a(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("FriendListHandler.setSpecialCareSwitch(). type=").append(paramInt).append(", uin size=");
      if (paramArrayOfString != null) {
        break label108;
      }
      i = -1;
      localObject1 = ((StringBuilder)localObject1).append(i).append(", switch size=");
      if (paramArrayOfBoolean != null) {
        break label115;
      }
    }
    label108:
    label115:
    for (int i = -1;; i = paramArrayOfBoolean.length)
    {
      QLog.d("set_special_care_switch", 2, i);
      if ((paramInt >= 1) && (paramInt <= 3) && (paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0) && (paramArrayOfString.length == paramArrayOfBoolean.length)) {
        break label122;
      }
      return;
      i = paramArrayOfString.length;
      break;
    }
    label122:
    Object localObject1 = new ArrayList();
    i = 0;
    if (i < paramArrayOfString.length)
    {
      localObject2 = paramArrayOfString[i];
      int j = paramArrayOfBoolean[i];
      Object localObject3 = new oidb_0x5d6.SnsUpdateItem();
      ArrayList localArrayList = new ArrayList();
      switch (paramInt)
      {
      }
      for (;;)
      {
        localObject3 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).uint64_uin.set(Long.parseLong((String)localObject2));
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.set(localArrayList);
        ((List)localObject1).add(localObject3);
        i += 1;
        break;
        byte[] arrayOfByte;
        if (j != 0)
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
        }
        else
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          localArrayList.add(localObject3);
          continue;
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          if (j != 0)
          {
            arrayOfByte = "1".getBytes();
            ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          }
          localArrayList.add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
          continue;
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          if (j != 0)
          {
            arrayOfByte = "1".getBytes();
            ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          }
          localArrayList.add(localObject3);
        }
      }
    }
    Object localObject2 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(7);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
    localObject2 = a("OidbSvc.0x5d6_7");
    ((ToServiceMsg)localObject2).extraData.putInt("param_type", paramInt);
    ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
    ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    b((ToServiceMsg)localObject2);
  }
  
  public void a(long paramLong, byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.SvcReqKikOut");
    localToServiceMsg.extraData.putLong("appid", paramLong);
    localToServiceMsg.extraData.putByte("cKeyType", paramByte);
    localToServiceMsg.extraData.putLong("lUin", Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount()));
    localToServiceMsg.extraData.putByteArray("sKey", paramArrayOfByte);
    localToServiceMsg.extraData.putInt("index", paramInt);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2, int paramInt3, int paramInt4, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt5, int paramInt6, int paramInt7)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.ReqCondSearch");
    localToServiceMsg.extraData.putLong("search_seq", paramLong1);
    localToServiceMsg.extraData.putInt("param_page", paramInt1);
    localToServiceMsg.extraData.putLong("param_session_id", paramLong2);
    localToServiceMsg.extraData.putString("param_keyword", paramString);
    localToServiceMsg.extraData.putInt("param_sex_index", paramInt2);
    localToServiceMsg.extraData.putInt("param_age_index1", paramInt3);
    localToServiceMsg.extraData.putInt("param_age_index2", paramInt4);
    localToServiceMsg.extraData.putStringArray("param_loc_code", paramArrayOfString1);
    localToServiceMsg.extraData.putStringArray("param_home_code", paramArrayOfString2);
    localToServiceMsg.extraData.putInt("param_job_index", paramInt5);
    localToServiceMsg.extraData.putInt("param_xingzuo_index", paramInt6);
    localToServiceMsg.extraData.putInt("param_search_from", paramInt7);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, int paramInt1, String paramString, int paramInt2, ArrayList paramArrayList)
  {
    device_lock_confirm_auth.ReqBody localReqBody = new device_lock_confirm_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    localReqBody.uint32_subappid.set(paramInt1);
    localReqBody.uint32_seq.set(paramInt2);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    int i = paramArrayList.size();
    paramString = new ArrayList();
    paramInt2 = 0;
    if (paramInt2 < i)
    {
      device_lock_confirm_auth.DeviceInfo localDeviceInfo = new device_lock_confirm_auth.DeviceInfo();
      DeviceLockItemInfo localDeviceLockItemInfo = (DeviceLockItemInfo)paramArrayList.get(paramInt2);
      if (localDeviceLockItemInfo == null) {}
      for (;;)
      {
        paramInt2 += 1;
        break;
        localDeviceInfo.bytes_appname.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_c_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_name.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_a_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_typeinfo.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_b_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_guid.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_a_of_type_ArrayOfByte));
        localDeviceInfo.uint32_appid.set(localDeviceLockItemInfo.jdField_a_of_type_Int);
        localDeviceInfo.uint32_auth_status.set(localDeviceLockItemInfo.jdField_c_of_type_Int);
        localDeviceInfo.uint32_subappid.set(paramInt1);
        paramString.add(localDeviceInfo);
      }
    }
    if (paramString.size() > 0) {
      localReqBody.rpt_msg_devicelist.set(paramString);
    }
    paramString = a("DevLockAuthSvc.ConfirmAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    b(paramString);
  }
  
  public void a(long paramLong, int paramInt, boolean paramBoolean)
  {
    int i;
    Object localObject1;
    long l;
    Object localObject2;
    if (paramBoolean)
    {
      i = 1;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendShield : send_oidb_0x5d1_0 : uin : " + paramLong + " setId:" + paramInt + " isSet:" + paramBoolean);
      }
      localObject1 = new Oidb_0x5d1.ReqBody();
      ((Oidb_0x5d1.ReqBody)localObject1).uint32_cmd.set(i);
      ((Oidb_0x5d1.ReqBody)localObject1).uint32_id.set(paramInt);
      l = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacts.", 2, "FriendListHandler.send_oidb_0x5d1_0 " + l);
      }
      if (!paramBoolean) {
        break label321;
      }
      localObject2 = new Oidb_0x5d1.SetFriendIdReq();
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint64_seq.set(l);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_set_friend_id.set((MessageMicro)localObject2);
    }
    for (;;)
    {
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1489);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x5d1.ReqBody)localObject1).toByteArray()));
      localObject1 = a("OidbSvc.0x5d1_0");
      ((ToServiceMsg)localObject1).extraData.putLong("friendUin", paramLong);
      ((ToServiceMsg)localObject1).extraData.putBoolean("isSet", paramBoolean);
      ((ToServiceMsg)localObject1).extraData.putInt("setId", paramInt);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      b((ToServiceMsg)localObject1);
      return;
      i = 2;
      break;
      label321:
      localObject2 = new Oidb_0x5d1.ClearFriendIdReq();
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint64_seq.set(l);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_clear_friend_id.set((MessageMicro)localObject2);
    }
  }
  
  public void a(long paramLong, String paramString, int paramInt)
  {
    device_lock_recommend_auth.ReqBody localReqBody = new device_lock_recommend_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAppid());
    localReqBody.uint32_subappid.set(paramInt);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localReqBody.uint32_seq.set(1);
    paramString = a("DevLockAuthSvc.RecommendAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    b(paramString);
  }
  
  public void a(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 1L);
    a(localToServiceMsg);
  }
  
  public void a(long paramLong, boolean paramBoolean)
  {
    a(paramLong, 4051, paramBoolean);
  }
  
  public void a(CheckUpdateResp paramCheckUpdateResp)
  {
    Object localObject1 = null;
    Object localObject2;
    int i;
    label70:
    CheckUpdateItemInterface localCheckUpdateItemInterface;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("FriendListHandler, handleCheckUpdate, ");
      if (paramCheckUpdateResp != null)
      {
        i = paramCheckUpdateResp.result;
        QLog.d("ProfileService.CheckUpdateReq", 2, i);
      }
    }
    else
    {
      if ((paramCheckUpdateResp == null) || (paramCheckUpdateResp.result != 0)) {
        break label237;
      }
      Iterator localIterator = paramCheckUpdateResp.vecResPkg.iterator();
      paramCheckUpdateResp = null;
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localObject2 = (RespItem)localIterator.next();
      } while (localObject2 == null);
      if (QLog.isColorLevel()) {
        QLog.d("ProfileService.CheckUpdateReq", 2, "FriendListHandler::handleCheckUpdate item eServiceId = " + ((RespItem)localObject2).eServiceID + ",result=" + ((RespItem)localObject2).cResult);
      }
      localCheckUpdateItemInterface = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a.a(((RespItem)localObject2).eServiceID);
      if (localCheckUpdateItemInterface == null) {
        break label211;
      }
      if (((RespItem)localObject2).eServiceID != 101) {
        break label202;
      }
      localObject1 = localCheckUpdateItemInterface;
      paramCheckUpdateResp = (CheckUpdateResp)localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramCheckUpdateResp;
      paramCheckUpdateResp = (CheckUpdateResp)localObject2;
      break label70;
      i = -1;
      break;
      label202:
      localCheckUpdateItemInterface.a((RespItem)localObject2);
      label211:
      localObject2 = paramCheckUpdateResp;
      paramCheckUpdateResp = (CheckUpdateResp)localObject1;
      localObject1 = localObject2;
    }
    if ((paramCheckUpdateResp != null) && (localObject1 != null)) {
      paramCheckUpdateResp.a((RespItem)localObject1);
    }
    label237:
    this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a.b();
  }
  
  public void a(FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.isSuccess()) {
      if (QLog.isColorLevel()) {
        QLog.d("TAG", 2, "onReceive: onReceive handleRecommendDeviceList");
      }
    }
    for (paramFromServiceMsg = new device_lock_recommend_auth.RspBody();; paramFromServiceMsg = null)
    {
      try
      {
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint64_uin.has()) {
          paramFromServiceMsg.uint64_uin.get();
        }
        if (paramFromServiceMsg.uint32_seq.has()) {
          paramFromServiceMsg.uint32_seq.get();
        }
        if (paramFromServiceMsg.uint32_ret.has()) {
          paramFromServiceMsg.uint32_ret.get();
        }
        if (!paramFromServiceMsg.rpt_msg_devicelist.has()) {
          continue;
        }
        paramFromServiceMsg = paramFromServiceMsg.rpt_msg_devicelist.get();
        paramObject = new ArrayList();
        if (paramFromServiceMsg == null) {}
      }
      catch (InvalidProtocolBufferMicroException paramObject)
      {
        try
        {
          int j = paramFromServiceMsg.size();
          int i = 0;
          label137:
          if (i < j)
          {
            device_lock_recommend_auth.DeviceInfo localDeviceInfo = (device_lock_recommend_auth.DeviceInfo)paramFromServiceMsg.get(i);
            if (localDeviceInfo == null) {}
            for (;;)
            {
              i += 1;
              break label137;
              paramObject = paramObject;
              if (QLog.isColorLevel()) {
                QLog.d("FriendListHandler", 2, "onReceive: onReceive sec_server package:sigResult parse fail");
              }
              paramObject.printStackTrace();
              break;
              DeviceLockItemInfo localDeviceLockItemInfo = new DeviceLockItemInfo();
              if (localDeviceInfo.bytes_appname.has())
              {
                localDeviceLockItemInfo.jdField_c_of_type_JavaLangString = new String(localDeviceInfo.bytes_appname.get().toByteArray(), "UTF-8");
                if (localDeviceInfo.bytes_guid.has())
                {
                  localDeviceLockItemInfo.jdField_a_of_type_ArrayOfByte = localDeviceInfo.bytes_guid.get().toByteArray();
                  if (localDeviceInfo.bytes_device_typeinfo.has())
                  {
                    localDeviceLockItemInfo.jdField_b_of_type_JavaLangString = new String(localDeviceInfo.bytes_device_typeinfo.get().toByteArray(), "UTF-8");
                    new StringBuffer();
                    if (localDeviceInfo.bytes_device_name.has())
                    {
                      localDeviceLockItemInfo.jdField_a_of_type_JavaLangString = new String(localDeviceInfo.bytes_device_name.get().toByteArray(), "UTF-8");
                      if (localDeviceInfo.uint32_auth_status.has())
                      {
                        localDeviceLockItemInfo.jdField_c_of_type_Int = localDeviceInfo.uint32_auth_status.get();
                        if (localDeviceInfo.uint32_appid.has())
                        {
                          localDeviceLockItemInfo.jdField_a_of_type_Int = localDeviceInfo.uint32_appid.get();
                          if (localDeviceInfo.uint32_subappid.has())
                          {
                            localDeviceLockItemInfo.jdField_b_of_type_Int = localDeviceInfo.uint32_subappid.get();
                            paramObject.add(localDeviceLockItemInfo);
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
          if (paramObject.size() <= 0) {
            break label444;
          }
        }
        catch (Exception paramFromServiceMsg) {}
        a(69, true, paramObject);
        return;
      }
      label444:
      a(69, false, null);
      return;
    }
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool = true;
    int i = 0;
    if (a(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    label227:
    do
    {
      do
      {
        do
        {
          do
          {
            Object localObject;
            do
            {
              do
              {
                do
                {
                  do
                  {
                    short s;
                    do
                    {
                      do
                      {
                        return;
                        if (!paramFromServiceMsg.getServiceCmd().equals("friendlist.getFriendGroupList")) {
                          break label526;
                        }
                        if (!paramFromServiceMsg.isSuccess()) {
                          break label227;
                        }
                        paramObject = (GetFriendListResp)paramObject;
                        if (paramObject == null) {
                          break;
                        }
                        if (paramToServiceMsg.extraData.getBoolean("getSingleFriend"))
                        {
                          a(paramToServiceMsg, paramObject);
                          return;
                        }
                        if (paramToServiceMsg.extraData.getByte("ifShowTermType", (byte)0).byteValue() == 1)
                        {
                          a(paramFromServiceMsg.getUin(), paramObject, paramToServiceMsg);
                          return;
                        }
                      } while (!QLog.isColorLevel());
                      QLog.d("FriendListHandler", 1, "handleGetFriendList unknow request!");
                      return;
                      if (!paramToServiceMsg.extraData.getBoolean("getSingleFriend"))
                      {
                        s = paramToServiceMsg.extraData.getShort("friendStartIndex");
                        i = paramToServiceMsg.extraData.getShort("friendTotalCount");
                        QLog.e("FriendListHandler", 1, "friend list unserialize error");
                        a(false, i, s, paramFromServiceMsg.getResultCode());
                        this.jdField_b_of_type_Long = 0L;
                      }
                      a(1, false, null);
                      a(99, false, null);
                      return;
                      if ((paramFromServiceMsg.getResultCode() != 2901) || (paramToServiceMsg == null) || (paramToServiceMsg.extraData == null)) {
                        break label419;
                      }
                      i = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
                      if (QLog.isColorLevel()) {
                        QLog.d("FriendListHandler", 2, "k_resend_cnt" + i);
                      }
                      if (i >= 2) {
                        break;
                      }
                      paramToServiceMsg.extraData.putInt("k_resend_cnt", i + 1);
                      a(paramToServiceMsg);
                    } while (paramToServiceMsg.extraData.getBoolean("getSingleFriend"));
                    this.jdField_c_of_type_Int += 1;
                    return;
                    if (!paramToServiceMsg.extraData.getBoolean("getSingleFriend"))
                    {
                      QLog.e("FriendListHandler", 1, "getFriendList timeout");
                      s = paramToServiceMsg.extraData.getShort("friendStartIndex");
                      a(false, paramToServiceMsg.extraData.getShort("friendTotalCount"), s, paramFromServiceMsg.getResultCode());
                      this.jdField_b_of_type_Long = 0L;
                    }
                    a(1, false, null);
                    a(99, false, null);
                    return;
                    if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null) && (!paramToServiceMsg.extraData.getBoolean("getSingleFriend")))
                    {
                      QLog.e("FriendListHandler", 1, "getFriendList fail " + paramFromServiceMsg.getResultCode());
                      s = paramToServiceMsg.extraData.getShort("friendStartIndex");
                      a(false, paramToServiceMsg.extraData.getShort("friendTotalCount"), s, paramFromServiceMsg.getResultCode());
                      this.jdField_b_of_type_Long = 0L;
                    }
                    a(1, false, null);
                    a(99, false, null);
                    return;
                    if (paramFromServiceMsg.getServiceCmd().equals("DevLockAuthSvc.RecommendAuth"))
                    {
                      a(paramFromServiceMsg, paramObject);
                      return;
                    }
                    if (paramFromServiceMsg.getServiceCmd().equals("DevLockAuthSvc.ConfirmAuth"))
                    {
                      b(paramFromServiceMsg.isSuccess());
                      return;
                    }
                    if (paramFromServiceMsg.getServiceCmd().equals("friendlist.GetLastLoginInfoReq"))
                    {
                      a(paramFromServiceMsg, (GetLastLoginInfoResp)paramObject);
                      return;
                    }
                    if (!paramFromServiceMsg.getServiceCmd().equals("ProfileService.GetRichSig")) {
                      break;
                    }
                  } while (!paramFromServiceMsg.isSuccess());
                  i = paramToServiceMsg.extraData.getInt("reqType", 0);
                  if ((i == 0) || (i == 3))
                  {
                    b(paramToServiceMsg, paramObject);
                    return;
                  }
                  a(paramToServiceMsg, paramObject);
                  return;
                  if (!"ProfileService.GetSimpleInfo".equals(paramFromServiceMsg.getServiceCmd())) {
                    break;
                  }
                  localObject = paramToServiceMsg.extraData.getStringArrayList("uinList");
                } while (!paramFromServiceMsg.isSuccess());
                paramObject = (ArrayList)paramObject;
              } while ((paramObject == null) || (localObject == null));
              a(paramToServiceMsg, (ArrayList)localObject, paramFromServiceMsg, paramObject);
              return;
              if ("OidbSvc.0x4fc_30".equals(paramFromServiceMsg.getServiceCmd()))
              {
                f(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if ("AvatarInfoSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
              {
                a(paramToServiceMsg, paramFromServiceMsg, (QQHeadUrlResp)paramObject);
                return;
              }
              if ("IncreaseURLSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
              {
                i(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if ("MultibusidURLSvr.HeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
              {
                if (paramToServiceMsg.extraData.getInt("qqHeadType") == 16)
                {
                  g(paramToServiceMsg, paramFromServiceMsg, paramObject);
                  return;
                }
                h(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
              if ("StatSvc.GetDevLoginInfo".equals(paramFromServiceMsg.getServiceCmd()))
              {
                if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 1L)
                {
                  b(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 2L)
                {
                  c(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getLong("iGetDevListType") == 4L)
                {
                  d(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                  return;
                }
                a(paramToServiceMsg, paramFromServiceMsg, (SvcRspGetDevLoginInfo)paramObject);
                return;
              }
              if ("StatSvc.DelDevLoginInfo".equals(paramFromServiceMsg.getServiceCmd()))
              {
                if (paramToServiceMsg.extraData.getInt("iDelType") == 1)
                {
                  b(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
                  return;
                }
                if (paramToServiceMsg.extraData.getInt("iDelType") == 2)
                {
                  a(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
                  return;
                }
                c(paramToServiceMsg, paramFromServiceMsg, (SvcRspDelLoginInfo)paramObject);
                return;
              }
              if ("StatSvc.SvcReqKikOut".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
              {
                a(paramToServiceMsg, paramFromServiceMsg, (SvcRespKikOut)paramObject);
                return;
              }
              if ("StatSvc.BindUin".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
              {
                a(paramToServiceMsg, paramFromServiceMsg, (SvcRspBindUin)paramObject);
                return;
              }
              if ("ProfileService.ReqGetSettings".equals(paramFromServiceMsg.getServiceCmd()))
              {
                a(paramToServiceMsg, paramFromServiceMsg, (RespGetSettings)paramObject);
                return;
              }
              if ("ProfileService.ReqSetSettings".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
              {
                a(paramToServiceMsg, paramFromServiceMsg, (RespSetSettings)paramObject);
                return;
              }
              if (!"friendlist.MovGroupMemReq".equals(paramFromServiceMsg.getServiceCmd())) {
                break;
              }
              i = paramToServiceMsg.extraData.getByte("move_fri_type");
              if (i == 0)
              {
                if (paramObject != null)
                {
                  a(paramToServiceMsg, (MovGroupMemResp)paramObject);
                  return;
                }
                a(9, false, null);
                return;
              }
            } while ((i != 1) || (paramObject == null));
            paramToServiceMsg = (MovGroupMemResp)paramObject;
            return;
            if ("BumpSvc.ReqComfirmContactFriend".equals(paramFromServiceMsg.getServiceCmd()))
            {
              if (paramFromServiceMsg.isSuccess())
              {
                a(paramToServiceMsg, true);
                return;
              }
              a(10, false, null);
              return;
            }
            if ("friendlist.addFriend".equals(paramFromServiceMsg.getServiceCmd()))
            {
              a((AddFriendResp)paramObject, paramToServiceMsg);
              return;
            }
            if ("friendlist.getUserAddFriendSetting".equals(paramFromServiceMsg.getServiceCmd()))
            {
              a(paramToServiceMsg, (GetUserAddFriendSettingResp)paramObject);
              return;
            }
            if ("friendlist.GetSimpleOnlineFriendInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
            {
              if (paramObject != null)
              {
                b(paramFromServiceMsg, paramObject);
                return;
              }
              a(13, false, null);
              return;
            }
            if ("friendlist.GetOnlineInfoReq".equals(paramFromServiceMsg.getServiceCmd()))
            {
              l(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("friendlist.delFriend".equals(paramFromServiceMsg.getServiceCmd()))
            {
              if (paramObject != null)
              {
                a(paramFromServiceMsg, (DelFriendResp)paramObject);
                return;
              }
              a(15, false, null);
              return;
            }
            if ("friendlist.SetGroupReq".equals(paramFromServiceMsg.getServiceCmd()))
            {
              if (QLog.isColorLevel())
              {
                localObject = new StringBuilder().append("onSetGroupCmd :").append(paramToServiceMsg.extraData.getInt("set_type", -1000)).append(", ").append(paramFromServiceMsg.isSuccess()).append(", ");
                if (paramObject == null) {
                  break label1444;
                }
              }
              for (;;)
              {
                QLog.d("FriendListHandler", 2, bool);
                if (!paramFromServiceMsg.isSuccess()) {
                  break label1450;
                }
                paramFromServiceMsg = (SetGroupResp)paramObject;
                if (paramFromServiceMsg == null) {
                  break;
                }
                a(paramToServiceMsg, paramFromServiceMsg);
                return;
                bool = false;
              }
              switch (paramToServiceMsg.extraData.getInt("set_type", -1))
              {
              default: 
                return;
              case 0: 
                a(18, false, null);
                return;
              case 1: 
                a(19, false, null);
                return;
              case 2: 
                a(21, false, null);
                return;
              }
              a(22, false, null);
              return;
            }
            if ("ProfileService.ChangeFriendName".equals(paramFromServiceMsg.getServiceCmd()))
            {
              m(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if ("ProfileService.SetRichSig".equals(paramFromServiceMsg.getServiceCmd()))
            {
              n(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (paramFromServiceMsg.getServiceCmd().equalsIgnoreCase("friendlist.GetAutoInfoReq"))
            {
              b(paramToServiceMsg, paramFromServiceMsg, paramObject);
              return;
            }
            if (!"ProfileService.CheckUpdateReq".equals(paramFromServiceMsg.getServiceCmd())) {
              break;
            }
            if ((paramFromServiceMsg.getResultCode() == 1000) && (QLog.isColorLevel())) {
              QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate ok resultcode = " + paramFromServiceMsg.getResultCode());
            }
            if (((paramFromServiceMsg.getResultCode() == 1002) || (paramFromServiceMsg.getResultCode() == 1013)) && (QLog.isColorLevel())) {
              QLog.d("ProfileService.CheckUpdateReq", 2, "getCheckUpdate timeout resultcode = " + paramFromServiceMsg.getResultCode());
            }
            a((CheckUpdateResp)paramObject);
            this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a();
          } while ((!FTSDBManager.jdField_a_of_type_Boolean) || (!SQLiteFTSUtils.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface)));
          if (SQLiteFTSUtils.c()) {
            i = 1;
          }
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(i);
        } while (i != 1);
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a();
        return;
        if ("SummaryCard.ReqSearch".equals(paramFromServiceMsg.getServiceCmd()))
        {
          j(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x5d1_0".equals(paramFromServiceMsg.getServiceCmd()))
        {
          o(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if (("OidbSvc.0x476_146".equals(paramFromServiceMsg.getServiceCmd())) || ("OidbSvc.0x476_147".equals(paramFromServiceMsg.getServiceCmd())))
        {
          p(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("SummaryCard.ReqCondSearch".equals(paramFromServiceMsg.getServiceCmd()))
        {
          k(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x491_107".equals(paramFromServiceMsg.getServiceCmd()))
        {
          q(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x490_107".equals(paramFromServiceMsg.getServiceCmd()))
        {
          r(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x5e1_8".equals(paramFromServiceMsg.getServiceCmd()))
        {
          a(paramToServiceMsg, paramFromServiceMsg, (byte[])paramObject);
          return;
        }
        if ("OidbSvc.0x49d_107".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          c(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x7c4_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          s(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x4f4_5".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          v(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x7c6_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          t(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x7c7_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          u(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x847_3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          w(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x53b_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          x(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x6c9_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          y(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x7df_3".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          z(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        if ("OidbSvc.0x5d6_7".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
        {
          if (paramToServiceMsg.extraData.getBoolean("param_is_set_switches_of_a_person"))
          {
            e(paramToServiceMsg, paramFromServiceMsg, paramObject);
            return;
          }
          d(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
      } while ("OidbSvc.0x77c".equals(paramFromServiceMsg.getServiceCmd()));
      if ("OidbSvc.0x829_1".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        A(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    } while (!"OidbSvc.0x777".equals(paramFromServiceMsg.getServiceCmd()));
    label419:
    label1444:
    label1450:
    B(paramToServiceMsg, paramFromServiceMsg, paramObject);
    label526:
  }
  
  public void a(ToServiceMsg paramToServiceMsg, ArrayList paramArrayList1, FromServiceMsg paramFromServiceMsg, ArrayList paramArrayList2)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    EntityTransaction localEntityTransaction = localFriendsManager.a();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList1 = new ArrayList();
    for (;;)
    {
      try
      {
        localEntityTransaction.a();
        Iterator localIterator = paramArrayList2.iterator();
        if (!localIterator.hasNext()) {
          continue;
        }
        localProfSmpInfoRes = (ProfSmpInfoRes)localIterator.next();
        localObject2 = String.valueOf(localProfSmpInfoRes.dwUin);
        if (!paramArrayList1.contains(localObject2)) {
          continue;
        }
        if (((String)localObject2).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().setProperty(Constants.PropertiesKey.nickName.toString() + (String)localObject2, localProfSmpInfoRes.strNick);
        }
        if (255 == localProfSmpInfoRes.cSpecialFlag)
        {
          QLog.i("FriendListHandler", 1, "Info.cSpecialFlag is 0xFF");
          localProfSmpInfoRes.cSpecialFlag = 0;
        }
        if ((CrmUtils.a(localProfSmpInfoRes.cSpecialFlag)) || (QidianManager.b(localProfSmpInfoRes.cSpecialFlag))) {
          localArrayList2.add(localObject2);
        }
        localFriendsManager.a(String.valueOf(localProfSmpInfoRes.dwUin), localProfSmpInfoRes.strNick, localProfSmpInfoRes.cSpecialFlag, (short)localProfSmpInfoRes.cSex, localProfSmpInfoRes.wAge);
        paramFromServiceMsg = localFriendsManager.b((String)localObject2);
        paramFromServiceMsg.nFaceID = localProfSmpInfoRes.wFace;
        paramFromServiceMsg.shGender = ((short)localProfSmpInfoRes.cSex);
        paramFromServiceMsg.age = localProfSmpInfoRes.wAge;
        paramFromServiceMsg.shAge = ((short)localProfSmpInfoRes.wAge);
        if (localProfSmpInfoRes.strNick != null) {
          paramFromServiceMsg.strNick = localProfSmpInfoRes.strNick;
        }
        if (localProfSmpInfoRes.sCountry != null) {
          paramFromServiceMsg.strCountry = localProfSmpInfoRes.sCountry;
        }
        if (localProfSmpInfoRes.sProvince != null) {
          paramFromServiceMsg.strProvince = localProfSmpInfoRes.sProvince;
        }
        if (localProfSmpInfoRes.sCity != null) {
          paramFromServiceMsg.strCity = localProfSmpInfoRes.sCity;
        }
        if ((localProfSmpInfoRes.cBusiCardFlag == 1) && (((String)localObject2).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())))
        {
          localObject1 = (BusinessCardManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(111);
          if (localObject1 != null)
          {
            int i = ((BusinessCardManager)localObject1).a();
            BusinessCardServlet.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, i, 0, true);
            ((BusinessCardManager)localObject1).a(1, true);
          }
        }
        if ((((String)localObject2).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) && (localProfSmpInfoRes.wLevel != 0)) {
          paramFromServiceMsg.iQQLevel = localProfSmpInfoRes.wLevel;
        }
        if ((localProfSmpInfoRes.isShowXMan == -1) || (localProfSmpInfoRes.dwLoginDay < 0L) || (localProfSmpInfoRes.dwPhoneQQXManDay <= 0L)) {
          continue;
        }
        if (!((String)localObject2).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          continue;
        }
        paramFromServiceMsg.lLoginDays = localProfSmpInfoRes.dwLoginDay;
        paramFromServiceMsg.lQQMasterLogindays = localProfSmpInfoRes.dwPhoneQQXManDay;
        paramFromServiceMsg.iXManScene1DelayTime = localProfSmpInfoRes.iXManScene1DelayTime;
        paramFromServiceMsg.iXManScene2DelayTime = localProfSmpInfoRes.iXManScene2DelayTime;
        if (localProfSmpInfoRes.isShowXMan != 1) {
          continue;
        }
        bool = true;
      }
      catch (Exception paramArrayList1)
      {
        ProfSmpInfoRes localProfSmpInfoRes;
        Object localObject2;
        Object localObject1;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("FriendListHandler", 2, "handleFriendInfo err", paramArrayList1);
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.b();
        paramArrayList1 = localArrayList2.iterator();
        if (!paramArrayList1.hasNext()) {
          break label1358;
        }
        paramFromServiceMsg = (String)paramArrayList1.next();
        try
        {
          localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFromServiceMsg, 0);
          if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
            continue;
          }
          localObject1 = ((List)localObject1).iterator();
          if (!((Iterator)localObject1).hasNext()) {
            continue;
          }
          localObject2 = (MessageRecord)((Iterator)localObject1).next();
          if ((((MessageRecord)localObject2).msgtype != -1013) && (((MessageRecord)localObject2).msgtype != -1019) && (((MessageRecord)localObject2).msgtype != -1018) && (((MessageRecord)localObject2).msgtype != -2019)) {
            continue;
          }
          this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().b(paramFromServiceMsg, 0, ((MessageRecord)localObject2).uniseq);
          continue;
        }
        catch (Exception paramFromServiceMsg)
        {
          paramFromServiceMsg.printStackTrace();
        }
        boolean bool = false;
        continue;
        localEntityTransaction.c();
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.b();
        continue;
      }
      finally
      {
        if (localEntityTransaction == null) {
          continue;
        }
        localEntityTransaction.b();
      }
      paramFromServiceMsg.setXManFlag(bool);
      if (paramArrayList1.size() == 1)
      {
        if (!((String)localObject2).equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin())) {
          paramFromServiceMsg.allowPeopleSee = localProfSmpInfoRes.bOpenLoginDays;
        }
        paramFromServiceMsg.allowClick = localProfSmpInfoRes.bXManIconClick;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuffer(200);
        ((StringBuffer)localObject1).append("Info.isShowXMan=");
        ((StringBuffer)localObject1).append(localProfSmpInfoRes.isShowXMan);
        ((StringBuffer)localObject1).append(";Info.dwLoginDay=");
        ((StringBuffer)localObject1).append(localProfSmpInfoRes.dwLoginDay);
        ((StringBuffer)localObject1).append(";Info.dwPhoneQQXManDay=");
        ((StringBuffer)localObject1).append(localProfSmpInfoRes.dwPhoneQQXManDay);
        ((StringBuffer)localObject1).append(";card.allowClick=");
        ((StringBuffer)localObject1).append(paramFromServiceMsg.allowClick);
        ((StringBuffer)localObject1).append(";card.allowPeopleSee= ");
        ((StringBuffer)localObject1).append(paramFromServiceMsg.allowPeopleSee);
        QLog.d("FriendListHandler", 2, ((StringBuffer)localObject1).toString());
      }
      localFriendsManager.a(paramFromServiceMsg);
      if (paramToServiceMsg.extraData.getBoolean("reqDateNick", false))
      {
        localObject1 = localProfSmpInfoRes.sDateNick;
        paramFromServiceMsg = (FromServiceMsg)localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          paramFromServiceMsg = localProfSmpInfoRes.strNick;
        }
        localObject1 = paramFromServiceMsg;
        if (TextUtils.isEmpty(paramFromServiceMsg)) {
          localObject1 = localObject2;
        }
        localArrayList1.add(new Object[] { localObject2, localObject1, Byte.valueOf(localProfSmpInfoRes.cSex) });
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo add to nickSaveList| uin=" + (String)localObject2 + " | datenick = " + localProfSmpInfoRes.sDateNick + " | nick=" + localProfSmpInfoRes.strNick);
        }
        a(89, true, new Object[] { localObject2, localObject1 });
      }
      if (paramToServiceMsg.extraData.getBoolean("reqSelfLevel", false))
      {
        ContactConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), System.currentTimeMillis());
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | iQQLevel = " + localProfSmpInfoRes.wLevel);
        }
      }
      if (paramToServiceMsg.extraData.getBoolean("reqXMan", false))
      {
        paramFromServiceMsg = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext();
        localObject1 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
        ContactConfig.b(paramFromServiceMsg, (String)localObject1, System.currentTimeMillis());
        if (paramToServiceMsg.extraData.getInt("getXManInfoScene", 0) == 2) {
          ContactConfig.c(paramFromServiceMsg, (String)localObject1, System.currentTimeMillis());
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "$handleFriendInfo | dwLoginDay=" + localProfSmpInfoRes.dwLoginDay + " | dwPhoneQQXManDay=" + localProfSmpInfoRes.dwPhoneQQXManDay + " | isShowXMan=" + localProfSmpInfoRes.isShowXMan + " | iXManScene1DelayTime=" + localProfSmpInfoRes.iXManScene1DelayTime + " | iXManScene2DelayTime=" + localProfSmpInfoRes.iXManScene2DelayTime);
        }
      }
      a(3, true, localObject2);
    }
    label1358:
    paramArrayList1 = localArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      paramFromServiceMsg = (Object[])paramArrayList1.next();
      try
      {
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "handleFriendInfo handle nickSaveList:" + paramFromServiceMsg[0] + ", " + paramFromServiceMsg[1] + ", " + paramFromServiceMsg[2]);
        }
        localFriendsManager.a((String)paramFromServiceMsg[0], (String)paramFromServiceMsg[1], ((Byte)paramFromServiceMsg[2]).byteValue());
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel()) {
          QLog.e("FriendListHandler", 2, "handleFriendInfo saveDateNickByUin err" + paramFromServiceMsg, paramFromServiceMsg);
        } else {
          QLog.i("FriendListHandler", 1, "handleFriendInfo saveDateNickByUin err" + paramFromServiceMsg);
        }
      }
    }
    if (paramToServiceMsg.extraData.getBoolean("batch_data")) {
      a(67, true, paramArrayList2);
    }
  }
  
  public void a(DelGroupResp paramDelGroupResp, boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    if (paramBoolean) {
      localFriendsManager.a(paramDelGroupResp.cGroupid);
    }
    a(21, paramBoolean, paramGroupActionResp);
  }
  
  public void a(String paramString)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.getFriendGroupList");
    localToServiceMsg.extraData.putBoolean("getSingleFriend", true);
    localToServiceMsg.extraData.putString("targetUin", paramString);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, byte paramByte)
  {
    a(4, paramString, 0, (byte)0, paramByte, false);
  }
  
  public void a(String paramString, byte paramByte1, byte paramByte2)
  {
    a(1, paramString, 0, paramByte1, paramByte2, false);
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new cmd0x7c7.ReqBody();
    ((cmd0x7c7.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    if (paramInt == 1)
    {
      ((cmd0x7c7.ReqBody)localObject).uint32_req_not_see_qzone.set(1);
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(1991);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(0);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c7.ReqBody)localObject).toByteArray()));
      localObject = a("OidbSvc.0x7c7_0");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      if (paramInt != 1) {
        break label168;
      }
      ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 1);
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
      if (paramInt == 2)
      {
        ((cmd0x7c7.ReqBody)localObject).uint32_req_prevent_dynamic.set(1);
        break;
      }
      if (paramInt != 3) {
        break;
      }
      ((cmd0x7c7.ReqBody)localObject).uint32_req_not_see_qzone.set(1);
      ((cmd0x7c7.ReqBody)localObject).uint32_req_prevent_dynamic.set(1);
      break;
      label168:
      if (paramInt == 2) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 2);
      } else if (paramInt == 3) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 3);
      }
    }
  }
  
  public void a(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    a(32, paramString, paramInt, paramByte1, paramByte2, true);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.GetAutoInfoReq");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("cType", (byte)1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    a(paramString1, paramInt1, paramInt2, paramString2, 0);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getUserAddFriendSetting " + paramString1 + ", " + paramInt1 + ", " + paramString2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendlist.getUserAddFriendSetting");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    localToServiceMsg.extraData.putInt("random_key", paramInt3);
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localToServiceMsg.extraData.putString("extra", paramString2);
    }
    a(localToServiceMsg);
  }
  
  public void a(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "send_oidb_0x476 " + paramLong + paramInt);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1142);
    localOIDBSSOPkg.uint32_service_type.set(paramInt);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.putShort((short)1);
    localByteBuffer.putInt((int)paramLong);
    localOIDBSSOPkg.bytes_bodybuffer.setHasFlag(true);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString.extraData.putLong("uin", paramLong);
    b(paramString);
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "infoOpenId " + paramString1 + ", " + paramString2);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1505);
    localOIDBSSOPkg.uint32_service_type.set(8);
    oidb_0x5e1.ReqBody localReqBody = new oidb_0x5e1.ReqBody();
    localReqBody.rpt_bytes_openid.add(ByteStringMicro.copyFrom(paramString1.getBytes()));
    localReqBody.uint32_appid.set((int)Long.parseLong(paramString2));
    localReqBody.uint32_req_nick.set(1);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    paramString2 = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "OidbSvc.0x5e1_8");
    paramString2.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString2.extraData.putString("uin", paramString1);
    b(paramString2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5)
  {
    b(paramString1, paramString2, paramInt1, paramByte, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, (byte)0);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2)
  {
    b(paramString1, paramString2, paramInt1, paramByte1, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, paramByte2);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt3, long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.ReqSearch");
    localToServiceMsg.extraData.putString("param_keyword", paramString1);
    localToServiceMsg.extraData.putString("param_country_code", paramString2);
    localToServiceMsg.extraData.putInt("search_page", paramInt2);
    localToServiceMsg.extraData.putIntArray("search_list", paramArrayOfInt);
    localToServiceMsg.extraData.putInt("search_version", paramInt1);
    localToServiceMsg.extraData.putDouble("search_longtitude", paramDouble1);
    localToServiceMsg.extraData.putDouble("search_latitude", paramDouble2);
    localToServiceMsg.extraData.putBoolean("search_decode", paramBoolean);
    localToServiceMsg.extraData.putInt("filter_type", paramInt3);
    localToServiceMsg.extraData.putLong("session_id", paramLong);
    if (QLog.isDevelopLevel()) {
      QLog.d("FriendListHandler", 4, "search friend with filter:" + paramInt3);
    }
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("SummaryCard.ReqSearch");
    localToServiceMsg.extraData.putString("param_keyword", paramString1);
    localToServiceMsg.extraData.putString("param_country_code", paramString2);
    localToServiceMsg.extraData.putInt("search_page", paramInt2);
    localToServiceMsg.extraData.putIntArray("search_list", paramArrayOfInt);
    localToServiceMsg.extraData.putInt("search_version", paramInt1);
    localToServiceMsg.extraData.putDouble("search_longtitude", paramDouble1);
    localToServiceMsg.extraData.putDouble("search_latitude", paramDouble2);
    localToServiceMsg.extraData.putBoolean("search_decode", paramBoolean);
    localToServiceMsg.extraData.putLong("session_id", paramLong);
    a(localToServiceMsg);
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    Object localObject;
    if (!paramBoolean)
    {
      localObject = a("ProfileService.ChangeFriendName");
      ((ToServiceMsg)localObject).extraData.putString("com_value", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      a((ToServiceMsg)localObject);
    }
    do
    {
      return;
      localObject = paramString2;
      if (paramString2 == null) {
        localObject = "";
      }
      paramString2 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
      Card localCard = paramString2.b(paramString1);
      localCard.strReMark = ((String)localObject);
      paramString2.a(localCard);
      paramString2.b(paramString1, (String)localObject);
      ((DiscussionManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(52)).b(paramString1, (String)localObject);
      paramString1 = (PhoneContactManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    } while (paramString1 == null);
    paramString1.d();
  }
  
  public void a(String paramString, ArrayList paramArrayList, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 1);
    a(localToServiceMsg);
  }
  
  public void a(String paramString, ArrayList paramArrayList, int paramInt, boolean paramBoolean, long paramLong)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 2);
    if (paramBoolean) {
      localToServiceMsg.extraData.putInt("iDelMe", 1);
    }
    for (;;)
    {
      localToServiceMsg.extraData.putLong("iAppId", paramLong);
      a(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putInt("iDelMe", 0);
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FetchInfoListManager", 2, "uin = " + paramString);
    }
    if ((Friends.isValidUin(paramString)) && (b(paramString)))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramString);
      ToServiceMsg localToServiceMsg = a("ProfileService.GetSimpleInfo");
      localToServiceMsg.extraData.putStringArrayList("uinList", localArrayList);
      localToServiceMsg.extraData.putBoolean("reqSelfLevel", c(paramString));
      localToServiceMsg.extraData.putBoolean("reqXMan", e(paramString));
      localToServiceMsg.extraData.putBoolean("reqDateNick", paramBoolean);
      a(localToServiceMsg);
    }
  }
  
  public void a(String paramString, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("uin=").append(paramString).append(", type size=");
      if (paramArrayOfInt != null) {
        break label142;
      }
      localObject1 = "";
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", switchState size=");
      if (paramArrayOfBoolean != null) {
        break label152;
      }
      localObject1 = "null";
      label64:
      localObject2 = ((StringBuilder)localObject2).append(localObject1).append(", ringId size=");
      if (paramArrayOfString != null) {
        break label162;
      }
    }
    label142:
    label152:
    label162:
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramArrayOfString.length))
    {
      QLog.d("set_special_care_switches_of_a_person", 2, localObject1);
      if ((!StringUtil.a(paramString)) && (paramArrayOfInt != null) && (paramArrayOfBoolean != null) && (paramArrayOfString != null) && (paramArrayOfInt.length == paramArrayOfBoolean.length) && (paramArrayOfBoolean.length == paramArrayOfString.length)) {
        break label173;
      }
      return;
      localObject1 = Integer.valueOf(paramArrayOfInt.length);
      break;
      localObject1 = Integer.valueOf(paramArrayOfBoolean.length);
      break label64;
    }
    label173:
    Object localObject2 = new ArrayList();
    localObject1 = new oidb_0x5d6.SnsUpateBuffer();
    ((oidb_0x5d6.SnsUpateBuffer)localObject1).uint64_uin.set(Long.parseLong(paramString));
    int i = 0;
    if (i < paramArrayOfInt.length)
    {
      int j = paramArrayOfInt[i];
      int k = paramArrayOfBoolean[i];
      Object localObject3 = paramArrayOfString[i];
      oidb_0x5d6.SnsUpdateItem localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
      switch (j)
      {
      }
      for (;;)
      {
        i += 1;
        break;
        if (k != 0)
        {
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
        }
        else
        {
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          ((List)localObject2).add(localSnsUpdateItem);
          continue;
          localSnsUpdateItem.uint32_update_sns_type.set(13568);
          if (k != 0)
          {
            if (StringUtil.a((String)localObject3)) {
              throw new IllegalArgumentException("special ring id can not be empty!");
            }
            localObject3 = ((String)localObject3).getBytes();
            localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          }
          ((List)localObject2).add(localSnsUpdateItem);
          localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
          localSnsUpdateItem.uint32_update_sns_type.set(13573);
          localObject3 = "1".getBytes();
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          ((List)localObject2).add(localSnsUpdateItem);
          continue;
          localSnsUpdateItem.uint32_update_sns_type.set(13572);
          if (k != 0)
          {
            localObject3 = "1".getBytes();
            localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
          }
          ((List)localObject2).add(localSnsUpdateItem);
        }
      }
    }
    ((oidb_0x5d6.SnsUpateBuffer)localObject1).rpt_msg_sns_update_item.set((List)localObject2);
    localObject2 = new ArrayList();
    ((List)localObject2).add(localObject1);
    localObject1 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject1).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject1).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject1).rpt_msg_update_buffer.set((List)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(7);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x5d6_7");
    ((ToServiceMsg)localObject1).extraData.putString("param_uin", paramString);
    ((ToServiceMsg)localObject1).extraData.putIntArray("param_type", paramArrayOfInt);
    ((ToServiceMsg)localObject1).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject1).extraData.putStringArray("param_ring_ids", paramArrayOfString);
    ((ToServiceMsg)localObject1).extraData.putBoolean("param_is_set_switches_of_a_person", true);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    b((ToServiceMsg)localObject1);
  }
  
  public void a(ArrayList paramArrayList, int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "GeneralSettings getGeneralSettings start offset =" + paramLong1);
    }
    ToServiceMsg localToServiceMsg = a("ProfileService.ReqGetSettings");
    localToServiceMsg.extraData.putSerializable("Paths", paramArrayList);
    localToServiceMsg.extraData.putInt("Revision", paramInt1);
    localToServiceMsg.extraData.putLong("Offset", paramLong1);
    localToServiceMsg.extraData.putLong("Count", paramLong2);
    localToServiceMsg.extraData.putInt("respRevision", paramInt2);
    localToServiceMsg.extraData.putBoolean("needTroopSettings", paramBoolean);
    a(localToServiceMsg);
  }
  
  public void a(ArrayList paramArrayList1, String paramString, int paramInt1, int paramInt2, ArrayList paramArrayList2)
  {
    if ((paramInt2 != 3078) && (paramInt2 != 3079))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "addBatchPhoneFriend, sourceId=" + paramInt2 + " is invalid.");
      }
      return;
    }
    Object localObject2 = new ArrayList(30);
    int k = paramInt1 * 30;
    int i = paramArrayList1.size() - k;
    int j;
    if (i > 30)
    {
      j = k + 30;
      i = paramInt1 + 1;
    }
    while (k < j)
    {
      ((List)localObject2).add(ByteStringMicro.copyFrom(((PhoneContact)paramArrayList1.get(k)).unifiedCode.getBytes()));
      k += 1;
      continue;
      if (i == 30)
      {
        j = k + 30;
        i = -1;
      }
      else
      {
        j = i + k;
        i = -1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addBatchPhoneFriend ," + paramInt1 + ", " + paramString + ", " + ((List)localObject2).size());
    }
    Object localObject1 = new oidb_0x829.ReqBody();
    ((oidb_0x829.ReqBody)localObject1).uint32_source_id.set(paramInt2);
    ((oidb_0x829.ReqBody)localObject1).uint32_sub_source_id.set(1);
    ((oidb_0x829.ReqBody)localObject1).bytes_msg.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    ((oidb_0x829.ReqBody)localObject1).rpt_bytes_mobiles.set((List)localObject2);
    localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(2089);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(1);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x829.ReqBody)localObject1).toByteArray()));
    localObject1 = a("OidbSvc.0x829_1");
    ((ToServiceMsg)localObject1).extraData.putSerializable("phones", paramArrayList1);
    ((ToServiceMsg)localObject1).extraData.putInt("package", i);
    ((ToServiceMsg)localObject1).extraData.putString("verifyMsg", paramString);
    ((ToServiceMsg)localObject1).extraData.putSerializable("resultList", paramArrayList2);
    ((ToServiceMsg)localObject1).extraData.putInt("sourceId", paramInt2);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    b((ToServiceMsg)localObject1);
  }
  
  public void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "getFriendInfoBatch uinList is empty or app is null");
      }
      return;
    }
    Object localObject2 = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    Object localObject1 = "";
    int i = paramArrayList.size() - 1;
    label55:
    String str;
    if (i >= 0)
    {
      str = (String)paramArrayList.get(i);
      if ((str == null) || (str.length() == 0) || (!Friends.isValidUin(str)) || (!b(str))) {
        paramArrayList.remove(i);
      }
    }
    for (;;)
    {
      i -= 1;
      break label55;
      if (str.equals(localObject2))
      {
        localObject1 = localObject2;
        continue;
        if (paramArrayList.isEmpty())
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("FriendListHandler", 2, "getFriendInfoBatch uinList is empty");
          return;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("FriendListHandler", 4, String.format(Locale.getDefault(), "getFriendInfoBatch size: %d, friendUin: %s", new Object[] { Integer.valueOf(paramArrayList.size()), localObject1 }));
        }
        localObject2 = a("ProfileService.GetSimpleInfo");
        ((ToServiceMsg)localObject2).extraData.putStringArrayList("uinList", paramArrayList);
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqSelfLevel", c((String)localObject1));
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqXMan", e((String)localObject1));
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqDateNick", paramBoolean);
        ((ToServiceMsg)localObject2).extraData.putBoolean("batch_data", true);
        a((ToServiceMsg)localObject2);
        return;
      }
    }
  }
  
  public void a(List paramList)
  {
    Object localObject = new cmd0xaed.ReqBody();
    ((cmd0xaed.ReqBody)localObject).uint64_qq_uin.set(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()).longValue());
    StringBuilder localStringBuilder = new StringBuilder("addBatchQIMFriends ");
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      QIMNotifyAddFriend localQIMNotifyAddFriend = (QIMNotifyAddFriend)paramList.next();
      ((cmd0xaed.ReqBody)localObject).rpt_uint64_add_qim_uins.add(Long.valueOf(localQIMNotifyAddFriend.uin));
      if (QLog.isColorLevel())
      {
        localStringBuilder.append(", ");
        localStringBuilder.append(localQIMNotifyAddFriend.uin);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.QIM", 2, localStringBuilder.toString());
    }
    paramList = new oidb_sso.OIDBSSOPkg();
    paramList.uint32_command.set(2797);
    paramList.uint32_service_type.set(0);
    paramList.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0xaed.ReqBody)localObject).toByteArray()));
    localObject = a("OidbSvc.0xaed_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
  }
  
  public void a(ConcurrentHashMap paramConcurrentHashMap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure " + paramConcurrentHashMap.size());
    }
    if (paramConcurrentHashMap.size() == 0) {
      return;
    }
    for (;;)
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
      Object localObject;
      int i;
      try
      {
        long l = Long.parseLong(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin());
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1737);
        localOIDBSSOPkg.uint32_service_type.set(0);
        localObject = paramConcurrentHashMap.entrySet().iterator();
        i = 10;
        if (((Iterator)localObject).hasNext())
        {
          localMayKnowExposure = (MayKnowExposure)((Map.Entry)((Iterator)localObject).next()).getValue();
          i += 30;
          if ((localMayKnowExposure.acBuffer == null) || (localMayKnowExposure.acBuffer.length <= 0)) {
            break label396;
          }
          i = localMayKnowExposure.acBuffer.length + i;
          break label396;
        }
        localObject = ByteBuffer.allocate(i);
        ((ByteBuffer)localObject).putLong(l).putShort((short)paramConcurrentHashMap.size());
        paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
        if (!paramConcurrentHashMap.hasNext()) {
          break label350;
        }
        MayKnowExposure localMayKnowExposure = (MayKnowExposure)((Map.Entry)paramConcurrentHashMap.next()).getValue();
        ((ByteBuffer)localObject).putLong(Long.parseLong(localMayKnowExposure.uin)).putInt(localMayKnowExposure.pageId).putInt(localMayKnowExposure.entranceId).putInt(localMayKnowExposure.actionId).putInt(localMayKnowExposure.exposeCnt).putInt(localMayKnowExposure.exposeTime);
        if ((localMayKnowExposure.acBuffer == null) || (localMayKnowExposure.acBuffer.length <= 0)) {
          break label340;
        }
        ((ByteBuffer)localObject).putShort((short)localMayKnowExposure.acBuffer.length).put(localMayKnowExposure.acBuffer);
        ((ByteBuffer)localObject).putShort((short)0);
        continue;
        if (!QLog.isColorLevel()) {
          break;
        }
      }
      catch (Exception paramConcurrentHashMap) {}
      QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure", paramConcurrentHashMap);
      return;
      label340:
      ((ByteBuffer)localObject).putShort((short)0);
      continue;
      label350:
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      paramConcurrentHashMap = a("OidbSvc.0x6c9_0");
      paramConcurrentHashMap.putWupBuffer(localOIDBSSOPkg.toByteArray());
      paramConcurrentHashMap.setTimeout(30000L);
      b(paramConcurrentHashMap);
      return;
      label396:
      i += 2;
    }
  }
  
  public void a(short paramShort, List paramList, boolean paramBoolean)
  {
    if ((paramShort <= 0) || (paramList == null) || (paramShort != paramList.size())) {
      return;
    }
    for (;;)
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg;
      try
      {
        localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
        localOIDBSSOPkg.uint32_command.set(1268);
        localOIDBSSOPkg.uint32_service_type.set(5);
        if (!paramBoolean) {
          break label289;
        }
        s = paramShort * 12 + 2;
        localObject = ByteBuffer.allocate(s);
        ((ByteBuffer)localObject).putShort(paramShort);
        s = 0;
        if (s >= paramShort) {
          break label203;
        }
        ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong((String)paramList.get(s))));
        if (paramBoolean)
        {
          ((ByteBuffer)localObject).putShort((short)2);
          ((ByteBuffer)localObject).putShort((short)4060).put((byte)1).putShort((short)4057).put((byte)0);
        }
        else
        {
          ((ByteBuffer)localObject).putShort((short)1);
          ((ByteBuffer)localObject).putShort((short)4060).put((byte)0);
        }
      }
      catch (Exception paramList) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FriendListHandler", 2, "gatherContacts  Exception " + paramList.getMessage());
      return;
      label203:
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      Object localObject = a("OidbSvc.0x4f4_5");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("isGather", paramBoolean);
      ((ToServiceMsg)localObject).extraData.putStringArrayList("friendUinList", (ArrayList)paramList);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
      s += 1;
      continue;
      label289:
      short s = paramShort * 9 + 2;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    a(paramBoolean, false);
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    ToServiceMsg localToServiceMsg = a("ProfileService.CheckUpdateReq");
    localToServiceMsg.addAttribute("CheckUpdateType", Integer.valueOf(paramInt));
    localToServiceMsg.addAttribute("isFirstTime", Boolean.valueOf(paramBoolean));
    a(localToServiceMsg);
  }
  
  public void a(boolean paramBoolean, String paramString, int paramInt)
  {
    Object localObject = new cmd0x7c6.ReqBody();
    ((cmd0x7c6.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    int i;
    if (paramInt == 1)
    {
      paramString = ((cmd0x7c6.ReqBody)localObject).uint32_not_see_qzone;
      if (paramBoolean)
      {
        i = 1;
        paramString.set(i);
        label48:
        paramString = new oidb_sso.OIDBSSOPkg();
        paramString.uint32_command.set(1990);
        paramString.uint32_result.set(0);
        paramString.uint32_service_type.set(0);
        paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c6.ReqBody)localObject).toByteArray()));
        localObject = a("OidbSvc.0x7c6_0");
        ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
        if (paramInt != 1) {
          break label290;
        }
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 1);
      }
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).extraData.putBoolean("key_dongtai_permission", paramBoolean);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      b((ToServiceMsg)localObject);
      return;
      i = 0;
      break;
      if (paramInt == 2)
      {
        paramString = ((cmd0x7c6.ReqBody)localObject).uint32_prevent_dynamic;
        if (paramBoolean) {}
        for (i = 1;; i = 0)
        {
          paramString.set(i);
          break;
        }
      }
      if (paramInt == 3)
      {
        paramString = ((cmd0x7c6.ReqBody)localObject).uint32_not_see_qzone;
        if (paramBoolean)
        {
          i = 1;
          label216:
          paramString.set(i);
          paramString = ((cmd0x7c6.ReqBody)localObject).uint32_prevent_dynamic;
          if (!paramBoolean) {
            break label250;
          }
        }
        label250:
        for (i = 1;; i = 0)
        {
          paramString.set(i);
          break;
          i = 0;
          break label216;
        }
      }
      if (paramInt != 4) {
        break label48;
      }
      paramString = ((cmd0x7c6.ReqBody)localObject).uint32_recv_msg_box;
      if (paramBoolean == true) {}
      for (i = 1;; i = 0)
      {
        paramString.set(i);
        break;
      }
      label290:
      if (paramInt == 2) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 2);
      } else if (paramInt == 3) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 3);
      } else if (paramInt == 4) {
        ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 4);
      }
    }
  }
  
  /* Error */
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 533	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: invokestatic 111	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +43 -> 52
    //   12: ldc_w 1891
    //   15: iconst_2
    //   16: new 115	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 116	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 1893
    //   26: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_3
    //   30: invokevirtual 724	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc_w 1139
    //   36: invokevirtual 122	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 1523	com/tencent/mobileqq/app/FriendListHandler:jdField_b_of_type_Long	J
    //   43: invokevirtual 724	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: invokevirtual 131	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 134	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 1523	com/tencent/mobileqq/app/FriendListHandler:jdField_b_of_type_Long	J
    //   56: lconst_0
    //   57: lcmp
    //   58: ifle +23 -> 81
    //   61: aload_0
    //   62: getfield 1523	com/tencent/mobileqq/app/FriendListHandler:jdField_b_of_type_Long	J
    //   65: lstore 5
    //   67: lload_3
    //   68: lload 5
    //   70: lsub
    //   71: ldc2_w 4716
    //   74: lcmp
    //   75: ifge +6 -> 81
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: aload_0
    //   82: lload_3
    //   83: putfield 1523	com/tencent/mobileqq/app/FriendListHandler:jdField_b_of_type_Long	J
    //   86: new 66	java/util/ArrayList
    //   89: dup
    //   90: invokespecial 67	java/util/ArrayList:<init>	()V
    //   93: astore 7
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 188	com/tencent/mobileqq/app/FriendListHandler:jdField_b_of_type_ComTencentMobileqqAppQQAppInterface	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   100: invokevirtual 456	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   103: iconst_0
    //   104: bipush 20
    //   106: iconst_0
    //   107: bipush 100
    //   109: lconst_0
    //   110: aload 7
    //   112: iload_1
    //   113: iload_2
    //   114: iconst_0
    //   115: invokespecial 2116	com/tencent/mobileqq/app/FriendListHandler:a	(Ljava/lang/String;IIIIJLjava/util/ArrayList;ZZS)V
    //   118: goto -40 -> 78
    //   121: astore 7
    //   123: aload_0
    //   124: monitorexit
    //   125: aload 7
    //   127: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	128	0	this	FriendListHandler
    //   0	128	1	paramBoolean1	boolean
    //   0	128	2	paramBoolean2	boolean
    //   5	78	3	l1	long
    //   65	4	5	l2	long
    //   93	18	7	localArrayList	ArrayList
    //   121	5	7	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	52	121	finally
    //   52	67	121	finally
    //   81	118	121	finally
  }
  
  public void a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 3);
    localToServiceMsg.extraData.putByteArray("group_id_list", paramArrayOfByte1);
    localToServiceMsg.extraData.putByteArray("sort_id_list", paramArrayOfByte2);
    a(localToServiceMsg);
  }
  
  public void a(String[] paramArrayOfString)
  {
    a(paramArrayOfString, 0, 3, null, false);
    this.jdField_b_of_type_Boolean = true;
  }
  
  public void a(String[] paramArrayOfString, boolean paramBoolean)
  {
    a(paramArrayOfString, 0, 2, null, paramBoolean);
  }
  
  public boolean a()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public boolean a(int paramInt1, int paramInt2, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler.getSpecialCareRecommend: start: " + paramInt1 + ", count: " + paramInt2 + ", uinList: " + paramArrayList + ", isSort: " + paramBoolean1 + ", reqNick: " + paramBoolean2);
    }
    if (((paramArrayList == null) || (paramArrayList.size() <= 0)) && ((paramInt1 < 0) || (paramInt2 <= 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "FriendListHandler.getSpecialCareRecommend: input invalid.");
      }
      return false;
    }
    paramArrayList = new oidb_0x7df.ReqBody();
    paramArrayList.uint32_seq.set(0);
    paramArrayList.uint32_start_index.set(paramInt1);
    paramArrayList.uint32_req_num.set(paramInt2);
    Object localObject = paramArrayList.uint32_sort;
    if (paramBoolean1) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      ((PBUInt32Field)localObject).set(paramInt1);
      localObject = paramArrayList.uint32_nick;
      paramInt1 = i;
      if (paramBoolean2) {
        paramInt1 = 1;
      }
      ((PBUInt32Field)localObject).set(paramInt1);
      localObject = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(2015);
      ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(3);
      ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(paramArrayList.toByteArray()));
      paramArrayList = a("OidbSvc.0x7df_3");
      paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      b(paramArrayList);
      jdField_a_of_type_Int = 3;
      return true;
    }
  }
  
  protected boolean a(String paramString)
  {
    if (this.jdField_b_of_type_JavaUtilSet == null)
    {
      this.jdField_b_of_type_JavaUtilSet = new HashSet();
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.getFriendGroupList");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.GetLastLoginInfoReq");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.GetRichSig");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.GetSimpleInfo");
      this.jdField_b_of_type_JavaUtilSet.add("AvatarInfoSvr.QQHeadUrlReq");
      this.jdField_b_of_type_JavaUtilSet.add("IncreaseURLSvr.QQHeadUrlReq");
      this.jdField_b_of_type_JavaUtilSet.add("StatSvc.GetDevLoginInfo");
      this.jdField_b_of_type_JavaUtilSet.add("StatSvc.DelDevLoginInfo");
      this.jdField_b_of_type_JavaUtilSet.add("StatSvc.SvcReqKikOut");
      this.jdField_b_of_type_JavaUtilSet.add("StatSvc.BindUin");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.ReqGetSettings");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.ReqSetSettings");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.MovGroupMemReq");
      this.jdField_b_of_type_JavaUtilSet.add("BumpSvc.ReqComfirmContactFriend");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.addFriend");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.getUserAddFriendSetting");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.GetSimpleOnlineFriendInfoReq");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.GetOnlineInfoReq");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.delFriend");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.SetGroupReq");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.ChangeFriendName");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.SetRichSig");
      this.jdField_b_of_type_JavaUtilSet.add("StatSvc.register");
      this.jdField_b_of_type_JavaUtilSet.add("friendlist.GetAutoInfoReq");
      this.jdField_b_of_type_JavaUtilSet.add("ProfileService.CheckUpdateReq");
      this.jdField_b_of_type_JavaUtilSet.add("SummaryCard.ReqSearch");
      this.jdField_b_of_type_JavaUtilSet.add("SummaryCard.ReqCondSearch");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5d1_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4fc_30");
      this.jdField_b_of_type_JavaUtilSet.add("DevLockAuthSvc.RecommendAuth");
      this.jdField_b_of_type_JavaUtilSet.add("DevLockAuthSvc.ConfirmAuth");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x476_146");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x476_147");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x490_107");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x491_107");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5e1_8");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x49d_107");
      this.jdField_b_of_type_JavaUtilSet.add("MultibusidURLSvr.HeadUrlReq");
      this.jdField_b_of_type_JavaUtilSet.add("MultibusidURLSvr.HeadUrlReq");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x7c4_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x4f4_5");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x7c6_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x7c7_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x847_3");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x53b_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x6c9_0");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x7df_3");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x5d6_7");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x77c");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x829_1");
      this.jdField_b_of_type_JavaUtilSet.add("OidbSvc.0x777");
    }
    return !this.jdField_b_of_type_JavaUtilSet.contains(paramString);
  }
  
  public boolean a(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriendToFriendList " + paramString1 + ", " + paramInt1 + ", " + paramInt2 + ", " + paramString2 + ", " + paramBoolean1);
    }
    paramString2 = (FriendsManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(50);
    Object localObject = (PhoneContactManagerImp)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(10);
    if (localObject != null) {
      ((PhoneContactManagerImp)localObject).b();
    }
    paramBoolean1 = paramString2.a(paramString1, paramInt1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler addFriendToFriendList flag = " + paramBoolean1);
    }
    if (paramBoolean1)
    {
      if (this.jdField_b_of_type_Long == 0L) {
        a(1, true, Boolean.valueOf(true));
      }
      a(63, true, paramString1);
      localObject = (NearbyCardManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(105);
      if (localObject != null) {
        ((NearbyCardManager)localObject).d.put("" + paramString1, Integer.valueOf(1));
      }
      a(paramString1);
      paramString2.a(paramString1, false);
      ((QzoneContactsFeedManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(90)).a(Long.valueOf(paramString1).longValue());
      if ((QidianManager.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) || ((!CrmUtils.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)) && (!CrmUtils.c(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, paramString1)))) {
        this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramString1, paramInt2);
      }
    }
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    ChatActivityFacade.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, BaseApplication.getContext(), paramString2);
    return paramBoolean1;
  }
  
  public boolean a(String paramString1, String paramString2, String paramString3, List paramList, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppUtilsBatchAddFriendData == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsBatchAddFriendData = new BatchAddFriendData();
    }
    paramBoolean = this.jdField_a_of_type_ComTencentMobileqqAppUtilsBatchAddFriendData.a(paramString1, paramString2, paramString3, paramList, paramBoolean, paramInt1, paramInt2);
    if (paramBoolean) {
      this.jdField_a_of_type_ComTencentMobileqqAppUtilsBatchAddFriendData.a(this);
    }
    return paramBoolean;
  }
  
  public boolean a(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    short s1;
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "getFriendNickByBatch|uinsize = " + paramArrayList.size() + " time=" + System.currentTimeMillis());
      }
      s1 = (short)paramArrayList.size();
    } while (s1 > 500);
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1181);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(s1 * 4 + 7);
    ((ByteBuffer)localObject).put((byte)0).putShort((short)1).putShort(this.jdField_a_of_type_Short).putShort(s1);
    short s2 = 0;
    for (;;)
    {
      if (s2 < s1) {
        try
        {
          ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong((String)paramArrayList.get(s2))));
          s2 = (short)(s2 + 1);
        }
        catch (Exception localException)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("FriendListHandler", 2, "getFriendNickByBatch parseLong err uin=" + (String)paramArrayList.get(s2), localException);
            }
          }
        }
      }
    }
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x49d_107");
    ((ToServiceMsg)localObject).extraData.putStringArrayList("batchuin", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putShort("uincount", s1);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public boolean a(short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getMayKnowRecommend|expected = " + paramShort);
    }
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(2119);
    localOIDBSSOPkg.uint32_service_type.set(3);
    Object localObject = ByteBuffer.allocate(12);
    ((ByteBuffer)localObject).put((byte)32).put((byte)1).putInt(0).putShort((short)0);
    ((ByteBuffer)localObject).putShort((short)0).putShort(paramShort);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x847_3");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    b((ToServiceMsg)localObject);
    return true;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {}
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler == null) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler = new QQHeadDownloadHandler(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface, this);
      }
      return this.jdField_a_of_type_ComTencentMobileqqAppQQHeadDownloadHandler.b();
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ArrayOfJavaLangString != null)
    {
      a(this.jdField_a_of_type_ArrayOfJavaLangString);
      this.jdField_a_of_type_ArrayOfJavaLangString = null;
    }
  }
  
  public void b(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "RenameFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = a("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 1);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    a(localToServiceMsg);
  }
  
  public void b(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 2L);
    a(localToServiceMsg);
  }
  
  public void b(String paramString)
  {
    a(paramString, false);
  }
  
  public void b(String paramString, byte paramByte)
  {
    a(11, paramString, 0, (byte)0, paramByte, false);
  }
  
  public void b(String paramString, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendlist.MovGroupMemReq");
    localToServiceMsg.extraData.putByte("move_fri_type", (byte)0);
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("group_id", paramByte1);
    localToServiceMsg.extraData.putByte("away_group_id", paramByte2);
    a(localToServiceMsg);
  }
  
  public void b(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "getQCallHead QQHEAD_TYPE_QCALL uin = " + paramString + " idType = " + paramInt + ", level =  faceFileType = " + paramByte2);
    }
    a(16, paramString, paramInt, paramByte1, paramByte2, true);
  }
  
  public void b(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead, uinOrMobile= " + paramString + ",isRemove=" + paramBoolean + "downloadSize=" + this.jdField_b_of_type_JavaUtilHashtable.size());
    }
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject1 = this.jdField_a_of_type_JavaLangObject;
    if (paramBoolean) {
      try
      {
        this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
        return;
      }
      finally {}
    }
    ArrayList localArrayList;
    Object localObject2;
    if (this.jdField_b_of_type_JavaUtilHashtable.size() > 30)
    {
      long l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = this.jdField_b_of_type_JavaUtilHashtable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        if (Math.abs(l - ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(str)).longValue()) > 60000L) {
          localArrayList.add(str);
        }
      }
    }
    for (;;)
    {
      int i;
      if (i < localArrayList.size())
      {
        localObject2 = (String)localArrayList.get(i);
        this.jdField_b_of_type_JavaUtilHashtable.remove(localObject2);
        a(9205, (String)localObject2, -1, 4);
        i += 1;
      }
      else
      {
        this.jdField_b_of_type_JavaUtilHashtable.put(paramString, Long.valueOf(System.currentTimeMillis()));
        break;
        i = 0;
      }
    }
  }
  
  public void b(boolean paramBoolean) {}
  
  public void b(String[] paramArrayOfString)
  {
    a(paramArrayOfString, 0, 0, null, false);
  }
  
  public boolean b()
  {
    long l = System.currentTimeMillis() - this.jdField_d_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getOnlineFriend  | intervalTime = " + l + " | sGetOnlineFriendDelay = " + QQAppInterface.jdField_f_of_type_Int);
    }
    return (this.jdField_d_of_type_Long > 0L) && ((l < QQAppInterface.jdField_f_of_type_Int) || (l > QQAppInterface.jdField_e_of_type_Int - QQAppInterface.jdField_f_of_type_Int));
  }
  
  public boolean b(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2;
    synchronized (this.jdField_d_of_type_JavaUtilHashtable)
    {
      if (!this.jdField_d_of_type_JavaUtilHashtable.containsKey(paramString)) {
        break label181;
      }
      paramString = (zla)this.jdField_d_of_type_JavaUtilHashtable.get(paramString);
      l2 = Math.abs(l1 - paramString.jdField_a_of_type_Long);
      if (paramString.jdField_c_of_type_Long > 0L)
      {
        if (l1 < paramString.jdField_c_of_type_Long) {
          return false;
        }
        paramString.jdField_c_of_type_Long = 0L;
        paramString.jdField_a_of_type_Long = l1;
        paramString.jdField_b_of_type_Long = 1L;
        return true;
      }
    }
    if (l2 < 5000L) {
      return false;
    }
    paramString.jdField_b_of_type_Long += 1L;
    if ((paramString.jdField_b_of_type_Long >= 8L) && (l2 < 120000L)) {
      paramString.jdField_c_of_type_Long = (l1 + 1800000L);
    }
    for (;;)
    {
      return true;
      if (l2 > 60000L)
      {
        paramString.jdField_c_of_type_Long = 0L;
        paramString.jdField_a_of_type_Long = l1;
        paramString.jdField_b_of_type_Long = 1L;
      }
    }
    label181:
    Object localObject1;
    Object localObject2;
    if (this.jdField_d_of_type_JavaUtilHashtable.size() > 20)
    {
      localObject1 = new ArrayList();
      localObject2 = this.jdField_d_of_type_JavaUtilHashtable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        zla localzla = (zla)this.jdField_d_of_type_JavaUtilHashtable.get(str);
        if (((localzla.jdField_c_of_type_Long == 0L) && (l1 - localzla.jdField_a_of_type_Long > 60000L)) || ((localzla.jdField_c_of_type_Long > 0L) && (l1 > localzla.jdField_c_of_type_Long))) {
          ((ArrayList)localObject1).add(str);
        }
      }
    }
    for (;;)
    {
      int i;
      if (i < ((ArrayList)localObject1).size())
      {
        localObject2 = (String)((ArrayList)localObject1).get(i);
        this.jdField_d_of_type_JavaUtilHashtable.remove(localObject2);
        i += 1;
      }
      else
      {
        localObject1 = new zla();
        ((zla)localObject1).jdField_a_of_type_Long = l1;
        ((zla)localObject1).jdField_b_of_type_Long = 1L;
        this.jdField_d_of_type_JavaUtilHashtable.put(paramString, localObject1);
        break;
        i = 0;
      }
    }
  }
  
  public void c()
  {
    String str = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(str)) && (e(str))) {
      b(str);
    }
  }
  
  public void c(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = a("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 4L);
    a(localToServiceMsg);
  }
  
  public void c(String paramString)
  {
    a(1, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void c(String paramString, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin(), "friendlist.delFriend");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("del_type", paramByte);
    a(localToServiceMsg);
  }
  
  public void c(String paramString, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetOnlineInfoReq");
    if (paramBoolean)
    {
      localToServiceMsg.extraData.putLong("dwReqType", 1L);
      localToServiceMsg.extraData.putString("strMobile", paramString);
    }
    for (;;)
    {
      localToServiceMsg.setTimeout(15000L);
      a(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putLong("dwReqType", 0L);
      localToServiceMsg.extraData.putLong("dwUin", CharacterUtil.a(paramString));
    }
  }
  
  public void c(boolean paramBoolean)
  {
    int i = 1;
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(1);
    if (paramBoolean) {
      i = 0;
    }
    ((ByteBuffer)localObject).put((byte)i);
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x491_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_show_to_friends", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    b((ToServiceMsg)localObject);
  }
  
  public void c(String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 1)) {}
    ArrayList localArrayList;
    do
    {
      return;
      localArrayList = new ArrayList();
      j = paramArrayOfString.length;
      i = 0;
      if (i < j)
      {
        String str = paramArrayOfString[i];
        if (TextUtils.isEmpty(str)) {}
        for (;;)
        {
          i += 1;
          break;
          if ((Friends.isValidUin(str)) && (b(str))) {
            localArrayList.add(str);
          }
        }
      }
    } while (localArrayList.size() < 1);
    paramArrayOfString = new String[localArrayList.size()];
    int j = localArrayList.size();
    int i = 0;
    while (i < j)
    {
      paramArrayOfString[i] = ((String)localArrayList.get(i));
      i += 1;
    }
    b(paramArrayOfString);
    paramArrayOfString = a("ProfileService.GetSimpleInfo");
    paramArrayOfString.extraData.putStringArrayList("uinList", localArrayList);
    paramArrayOfString.extraData.putBoolean("batch_data", true);
    a(paramArrayOfString);
  }
  
  public boolean c()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.jdField_f_of_type_Long;
    if ((l2 < this.jdField_e_of_type_Long) && (l2 > -this.jdField_e_of_type_Long)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.jdField_f_of_type_Long = l1;
      }
      return bool;
    }
  }
  
  public boolean c(String paramString)
  {
    boolean bool1 = paramString.equals(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    boolean bool2 = bool1;
    long l;
    if (bool1)
    {
      l = ContactConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
      if (Math.abs(System.currentTimeMillis() - l) <= 86400000L) {
        break label109;
      }
    }
    label109:
    for (bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, "$shouldReqLevel | lastReqTime = " + l + " | currentTime = " + System.currentTimeMillis());
        bool2 = bool1;
      }
      return bool2;
    }
  }
  
  public void d()
  {
    Object localObject = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (f((String)localObject)) && (Friends.isValidUin((String)localObject)) && (b((String)localObject)))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      localObject = a("ProfileService.GetSimpleInfo");
      ((ToServiceMsg)localObject).extraData.putStringArrayList("uinList", localArrayList);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqSelfLevel", false);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqXMan", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqDateNick", false);
      ((ToServiceMsg)localObject).extraData.putInt("getXManInfoScene", 2);
      a((ToServiceMsg)localObject);
    }
  }
  
  public void d(String paramString)
  {
    a(4, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void d(String paramString, byte paramByte)
  {
    if ((paramByte != 0) && (b())) {}
    do
    {
      return;
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      paramString = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetSimpleOnlineFriendInfoReq");
      paramString.extraData.putLong("startTime", System.currentTimeMillis());
      paramString.setTimeout(120000L);
      paramString.extraData.putByte("ifShowTermType", (byte)1);
      paramString.extraData.putByte("srcType", paramByte);
      a(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("getOnlineFriend", 2, "send getOnlineFriend");
  }
  
  public boolean d()
  {
    if (this.g == -1) {}
    for (;;)
    {
      try
      {
        if (!ContactConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount())) {
          continue;
        }
        i = 1;
        this.g = i;
      }
      catch (Exception localException)
      {
        int i;
        this.g = 0;
        continue;
      }
      if (this.g != 1) {
        break label62;
      }
      return true;
      i = 0;
    }
    label62:
    return false;
  }
  
  public boolean d(String paramString)
  {
    for (;;)
    {
      int i;
      boolean bool1;
      boolean bool3;
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        if (!this.jdField_b_of_type_JavaUtilHashtable.containsKey(paramString)) {
          break label275;
        }
        long l = ((Long)this.jdField_b_of_type_JavaUtilHashtable.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) > 60000L)
        {
          this.jdField_b_of_type_JavaUtilHashtable.remove(paramString);
          a(9205, paramString, -1, 4);
          i = 0;
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            bool3 = SystemUtil.a();
            if (((bool3) && (SystemUtil.a() < 2048L)) || ((!bool3) && (SystemUtil.b() < 102400L)))
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.qqhead.flh", 2, "getQQHead|fail, storage is not enough. uinOrMobile=" + paramString + ", isExistSDCard=" + bool3);
              }
              bool2 = false;
            }
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead, whatIf= " + i + ", NeedDownload=" + bool2);
            }
            return bool2;
          }
        }
        else
        {
          i = 1;
          bool1 = false;
        }
      }
      boolean bool2 = bool1;
      if (!bool3)
      {
        bool2 = bool1;
        if (!this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = true;
          ContactConfig.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), true);
          bool2 = bool1;
          continue;
          label275:
          i = -1;
          bool1 = true;
        }
      }
    }
  }
  
  public void e()
  {
    Message localMessage = this.jdField_a_of_type_MqqOsMqqHandler.obtainMessage();
    localMessage.what = 0;
    this.jdField_a_of_type_MqqOsMqqHandler.sendMessage(localMessage);
  }
  
  public void e(String paramString)
  {
    a(11, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public boolean e()
  {
    boolean bool1;
    if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin() == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = ContactConfig.b(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getApp().getApplicationContext(), this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getAccount());
      bool1 = bool2;
    } while (!bool2);
    a(0L, 0L, 0L);
    return bool2;
  }
  
  public void f()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = a("OidbSvc.0x490_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    b((ToServiceMsg)localObject);
  }
  
  public void f(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "cancelMayKnowRecommend|uin = " + paramString);
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(1339);
      localOIDBSSOPkg.uint32_service_type.set(0);
      long l = Long.parseLong(paramString);
      Object localObject = ByteBuffer.allocate(6);
      ((ByteBuffer)localObject).put((byte)7).putInt(Utils.a(l)).put((byte)0);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = a("OidbSvc.0x53b_0");
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString);
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      b((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "cancelMayKnowRecommend", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler
 * JD-Core Version:    0.7.0.1
 */