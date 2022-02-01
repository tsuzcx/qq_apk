package com.tencent.mobileqq.app;

import GeneralSettings.Setting;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigRes;
import KQQ.ResRichSigInfo;
import KQQ.RespItem;
import QQService.BindUin;
import QQService.DeviceItemDes;
import SecurityAccountServer.RespondQueryQQBindingStat;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.av.gaudio.AVNotifyCenter;
import com.tencent.av.utils.CharacterUtil;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.biz.eqq.CrmUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.ims.device_lock_confirm_auth.DeviceInfo;
import com.tencent.ims.device_lock_confirm_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.ReqBody;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareUtil;
import com.tencent.mobileqq.antiphing.DeviceLockItemInfo;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.friendlist.FriendListHandlerUtil;
import com.tencent.mobileqq.app.friendlist.receiver.BaseHandlerReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.DeviceLockAuthReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.DeviceLoginInfoReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.DongtaiPermissionReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.FriendChatReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.FriendGroupReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.FriendInfoReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.FriendListReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.FriendRecommendReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.FriendShieldReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.MakeFriendReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.NetStatusReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.QueryUinFlagRecevier;
import com.tencent.mobileqq.app.friendlist.receiver.SearchFriendReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.SuspiciousOperReceiver;
import com.tencent.mobileqq.app.handler.GreetingMsg;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.MessageForGrayTips;
import com.tencent.mobileqq.data.MessageForText;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.graytip.MessageForUniteGrayTip;
import com.tencent.mobileqq.graytip.UniteGrayTipMsgUtil;
import com.tencent.mobileqq.graytip.UniteGrayTipParam;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.INearbyCardManager;
import com.tencent.mobileqq.newfriend.api.INewFriendService;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.phonecontact.api.IPhoneContactService;
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendData;
import com.tencent.mobileqq.relationx.icebreaking.IceBreakingUtil;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.message.MessageRecordFactory;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactConfig;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.VasExtensionManager;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qidian.QidianManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.DelGroupResp;
import friendlist.EAddFriendSourceID;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
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
import mqq.manager.ServerConfigManager.ConfigType;
import mqq.os.MqqHandler;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ClearFriendIdReq;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.ReqBody;
import tencent.im.oidb.cmd0x5d1.Oidb_0x5d1.SetFriendIdReq;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.ReqBody;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpateBuffer;
import tencent.im.oidb.cmd0x5d6.oidb_0x5d6.SnsUpdateItem;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListReq;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListRsp;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.MsgBox;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.OneFrdData;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.ReqBody;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RspBody;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7.ReqBody;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;
import tencent.im.oidb.cmd0x972.oidb_0x972.ReqBody;
import tencent.im.oidb.cmd0x972.oidb_0x972.RootSearcherRequest;
import tencent.im.oidb.cmd0xaed.cmd0xaed.ReqBody;
import tencent.im.oidb.cmd0xaed.cmd0xaed.RspBody;
import tencent.im.oidb.cmd0xc83.ReqBody;
import tencent.im.oidb.cmd0xc85.ReqBody;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0.ReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.DeleteReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.GetListReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.ReqBody;
import tencent.im.oidb.cmd0xd72.oidb_cmd0xd72.ReqBody;
import tencent.im.oidb.oidb_0xc26.ReqBody;
import tencent.im.oidb.oidb_0xc34.ReqBody;
import tencent.im.oidb.oidb_0xc35.ExposeItem;
import tencent.im.oidb.oidb_0xc35.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x11e.SubMsgType0x11e.MsgBody;

public class FriendListHandler
  extends BusinessHandler
{
  public static final String ACTION_GATHER_RESP = "action_gather_resp";
  public static final int BOTH_DONGTAI = 3;
  public static final int CONNECTIONS_GET_DATA_MAX_COUNT = 50;
  private static final long DIFF_TIME_ZONE = 28800000L;
  public static final short FIELD_0X49D_NICK = 20002;
  private static final short FRIENDNICK_MAX_COUNT = 500;
  private static final long GET_FRIEND_INFO_CHECK_INTERVAL_TIME = 60000L;
  private static final long GET_FRIEND_INFO_EXPIRED_TIME = 1800000L;
  private static final long GET_FRIEND_INFO_LIMIT_COUNT = 8L;
  private static final long GET_FRIEND_INFO_TIMEOUT = 5000L;
  private static final int GET_FRIEND_NUM = 200;
  private static final int GET_GROUP_NUM = 100;
  private static final long INTERVAL_ONE_DAY = 86400000L;
  public static final String KEY_IS_GATHER = "key_is_gather";
  public static final String KEY_IS_SUC = "key_is_suc";
  public static final String KEY_SAFETY_FLAG = "safety_flag";
  private static final String KEY_STATUS_ENTRY = "StatusEntry";
  public static final String KEY_UIN = "uin";
  public static final String KEY_UIN_LIST = "key_uin_list";
  private static int MAX_COUNT_REQ_GETHER_MEMBER = 100;
  private static final int MAX_MOVE_FRI = 15;
  public static final long MIN_INTERVAL_GET_ONLINE = 15000L;
  public static final int NOT_ALLOWED_SEE_MY_DONGTAI = 1;
  public static final int OIDB_0X5D1_CONST_OP_CLEAR = 2;
  public static final int OIDB_0X5D1_CONST_OP_SET = 1;
  public static final int OIDB_0X5D1_CONST_SHIELD = 4051;
  public static final int OIDB_IS_HIDE_BIG_CLUB = 42275;
  public static final String PARAMS_FRIEND_START_INDEX = "friendStartIndex";
  public static final String PARAMS_FRIEND_TOTAL_COUNT = "friendTotalCount";
  public static final String PARAM_CHAT_TYPES = "param_chat_types";
  public static final String PARAM_IS_SET_SWITCHES_OF_A_PERSON = "param_is_set_switches_of_a_person";
  public static final String PARAM_NOTIFY_PLUGIN = "param_notify_plugin";
  public static final String PARAM_RING_IDS = "param_ring_ids";
  public static final String PARAM_STATUS_ITEM_LIST = "param_status_item_list";
  public static final String PARAM_SWITCH_STATE = "param_switch_state";
  public static final String PARAM_TYPE = "param_type";
  public static final String PARAM_UIN = "param_uin";
  public static final String PARAM_UINS = "param_uins";
  public static final int PUSH_UPDATE_0X210_0X11E_ALL = 1;
  public static final int PUSH_UPDATE_0X210_0X11E_INCREMENT = 2;
  private static final String QQ_HEAD_FLH = "Q.qqhead.flh";
  public static final int REPORT_RECEIVE_MSGBOX = 4;
  public static final int SHIELD_HIS_DONGTAI = 2;
  public static final int SIG_TYPE_CIRCLE = 1;
  public static final int SIG_TYPE_FRIEND = 0;
  public static final int SIG_TYPE_FRIEND_LIST = 3;
  public static final int SIG_TYPE_STRANGER = 2;
  public static final byte SRC_TYPE_CONTACT_TAB = 1;
  public static final byte SRC_TYPE_DEFAULT = 0;
  public static final byte SRC_TYPE_QCALL_LIST = 2;
  public static final byte SRC_TYPE_SPECIAL_CARE = 3;
  public static final String TAG = "FriendListHandler";
  public static final String TAG_GET_TROOP_MEMBER = "get_troop_member";
  public static final int TYPE_GLOBAL = 1;
  public static final int TYPE_NOTIFICATION_PREVIEW = 1;
  public static final int TYPE_NOTIFICATION_SOUND = 2;
  public static final int TYPE_NOTIFICATION_VIBRATE = 3;
  public static final int TYPE_QZONE = 3;
  public static final int TYPE_SPECIAL_RING = 2;
  public static final int UIN_SAFETY_SERVICE_TYPE_146 = 146;
  public static int getSpecialRecommendStat = -1;
  public QQAppInterface app;
  private long failedStartTime = 0L;
  private int friendCountGeted = 0;
  private Hashtable<String, FriendListHandler.FriendInfoDuplicate> friendInfoDuplicateTable = new Hashtable();
  private long getOnlineFriendLastTimeStamp = 0L;
  private List<BaseHandlerReceiver> handlerReceivers = new ArrayList();
  public long intervalGetOnlineInfo = 15000L;
  private boolean isSyncingAllFriendsRichStatus = false;
  private long lastFriendListUpdateTime = 0L;
  private long lastGreetingTime = 0L;
  private BatchAddFriendData mBatchAddFriendData = null;
  private int mFriendListFailedCount = 0;
  private HashMap<String, GreetingMsg> mGreetingDataMap = new HashMap(10);
  private final Object mGreetingLock = new Object();
  private HashMap<Long, String> mOfflineTips;
  private ArrayList<oidb_0x7df.FriendScore> mRecommendList = new ArrayList();
  private final Object mRecommendLock = new Object();
  private volatile int mShowPcIcon = -1;
  private int mStatusEntry = -1;
  private int retryTotalCount = 0;
  private short shBatchSeqTypeField = 20002;
  private long timeGetOnlineInfo = 0L;
  private String[] updateSignatureList = null;
  
  protected FriendListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    this.app = paramQQAppInterface;
    init();
    registerHandlerReceivers();
  }
  
  private long convertUin(String paramString)
  {
    long l = 0L;
    if (paramString != null) {
      if (paramString.length() <= 0) {
        return 0L;
      }
    }
    try
    {
      l = Long.parseLong(paramString);
      if (l < 10000L) {
        return 0L;
      }
      return l;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  private String convertUin(long paramLong)
  {
    long l = paramLong;
    if (paramLong < 0L) {
      l = paramLong + 4294967296L;
    }
    return String.valueOf(l);
  }
  
  public static void decodePush0x210_0x11e(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        Object localObject = new SubMsgType0x111.MsgBody();
        ((SubMsgType0x111.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (!((SubMsgType0x111.MsgBody)localObject).uint64_type.has()) {
          break label420;
        }
        l1 = ((SubMsgType0x111.MsgBody)localObject).uint64_type.get();
        if (QLog.isColorLevel())
        {
          paramArrayOfByte = new StringBuilder();
          paramArrayOfByte.append("decodePush0x210_0x111,type = ");
          paramArrayOfByte.append(l1);
          QLog.i("FriendListHandler", 2, paramArrayOfByte.toString());
        }
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FRIENDLIST_HANDLER);
        if (l1 == 0L)
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "decodePush0x210_0x111 update list");
          }
          paramQQAppInterface.handleMayKnowRecommendPush((int)l1, null);
          return;
        }
        if (l1 == 1L)
        {
          paramArrayOfByte = new ArrayList();
          if (((SubMsgType0x111.MsgBody)localObject).rpt_msg_add_recommend_persons.has()) {
            paramArrayOfByte.addAll(MayKnowRecommend.covServerPushDataToLocal(((SubMsgType0x111.MsgBody)localObject).rpt_msg_add_recommend_persons.get(), System.currentTimeMillis()));
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("decodePush0x210_0x111 add ");
            ((StringBuilder)localObject).append(paramArrayOfByte);
            QLog.d("FriendListHandler", 2, ((StringBuilder)localObject).toString());
          }
          paramQQAppInterface.handleMayKnowRecommendPush((int)l1, paramArrayOfByte);
          return;
        }
        if (l1 != 2L) {
          break label419;
        }
        ArrayList localArrayList = new ArrayList();
        if (((SubMsgType0x111.MsgBody)localObject).rpt_uint64_del_uins.has()) {
          localArrayList.addAll(((SubMsgType0x111.MsgBody)localObject).rpt_uint64_del_uins.get());
        }
        paramArrayOfByte = new ArrayList();
        localObject = localArrayList.iterator();
        if (((Iterator)localObject).hasNext())
        {
          long l2 = ((Long)((Iterator)localObject).next()).longValue();
          if (l2 <= 0L) {
            continue;
          }
          paramArrayOfByte.add(String.valueOf(l2));
          continue;
        }
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("decodePush0x210_0x111 del ");
          ((StringBuilder)localObject).append(paramArrayOfByte);
          QLog.d("FriendListHandler", 2, ((StringBuilder)localObject).toString());
        }
        paramQQAppInterface.handleMayKnowRecommendPush((int)l1, paramArrayOfByte);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramQQAppInterface)
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("decodePush0x210_0x111 decode error, e=");
        paramArrayOfByte.append(paramQQAppInterface.toString());
        QLog.i("FriendListHandler", 1, paramArrayOfByte.toString());
        return;
      }
      QLog.i("FriendListHandler", 1, "decodePush0x210_0x111 pbData = null");
      label419:
      return;
      label420:
      long l1 = -1L;
    }
  }
  
  private void doGetRichStatus(String[] paramArrayOfString, int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
  {
    if (paramInt1 >= paramArrayOfString.length) {
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("doGetRichStatus uinArray.lenth = ");
      ((StringBuilder)localObject).append(paramArrayOfString.length);
      ((StringBuilder)localObject).append(" reqType = ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append("pos = ");
      ((StringBuilder)localObject).append(paramInt1);
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject).toString());
    }
    int i = Math.min(50, paramArrayOfString.length - paramInt1);
    Object localObject = new String[i];
    System.arraycopy(paramArrayOfString, paramInt1, localObject, 0, i);
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.GetRichSig");
    localToServiceMsg.extraData.putStringArray("totalArray", paramArrayOfString);
    localToServiceMsg.extraData.putInt("nextStartPos", paramInt1 + i);
    localToServiceMsg.extraData.putStringArray("sendArray", (String[])localObject);
    localToServiceMsg.extraData.putInt("reqType", paramInt2);
    localToServiceMsg.extraData.putBoolean("showDateNickname", paramBoolean);
    localToServiceMsg.extraData.putBundle("circleBundle", paramBundle);
    send(localToServiceMsg);
  }
  
  private void handleAddBatchTroopMembers(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    BatchAddFriendData localBatchAddFriendData = this.mBatchAddFriendData;
    if (localBatchAddFriendData == null) {
      return;
    }
    localBatchAddFriendData.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private boolean handleCheckUpdateItem(CheckUpdateItemInterface paramCheckUpdateItemInterface, RespItem paramRespItem)
  {
    if (paramCheckUpdateItemInterface != null)
    {
      if (paramRespItem == null) {
        return false;
      }
      try
      {
        paramCheckUpdateItemInterface.a(paramRespItem);
        return true;
      }
      catch (Throwable paramCheckUpdateItemInterface)
      {
        QLog.d("ProfileService.CheckUpdateReq", 1, paramCheckUpdateItemInterface.getMessage(), paramCheckUpdateItemInterface);
        return true;
      }
      catch (OutOfMemoryError paramCheckUpdateItemInterface)
      {
        QLog.d("ProfileService.CheckUpdateReq", 1, String.format("encounter OutOfMemoryError when handleCheckUpdateItem() sId=%d ret=%d ex=%s \n%s", new Object[] { Integer.valueOf(paramRespItem.eServiceID), Byte.valueOf(paramRespItem.cResult), paramCheckUpdateItemInterface.getMessage(), Log.getStackTraceString(paramCheckUpdateItemInterface) }));
        return true;
      }
    }
    return false;
  }
  
  private void handleFriendRichStatus(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    paramObject = (GetRichSigRes)paramObject;
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((paramObject != null) && (paramObject.cResult == 0) && (paramObject.vstSigInfo != null) && (paramObject.vstSigInfo.size() != 0) && (localFriendsManager != null))
    {
      ArrayList localArrayList1 = new ArrayList(paramObject.vstSigInfo.size());
      ArrayList localArrayList2 = new ArrayList();
      Iterator localIterator = paramObject.vstSigInfo.iterator();
      while (localIterator.hasNext())
      {
        ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)localIterator.next();
        String str = Long.toString(localResRichSigInfo.lUin);
        if (localResRichSigInfo.cStatus == 1)
        {
          Object localObject = localFriendsManager.a(str);
          paramObject = localObject;
          if (localObject == null)
          {
            paramObject = new ExtensionInfo();
            paramObject.uin = str;
          }
          if ((paramObject.richTime != localResRichSigInfo.dwTime) || (!Arrays.equals(paramObject.richBuffer, localResRichSigInfo.vbSigInfo)))
          {
            ExtensionRichStatus.a(paramObject, localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
            paramObject.isAdded2C2C = SignatureManager.a(this.app, str, ExtensionRichStatus.a(paramObject));
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("insertSignMsgIfNeeded from FriendList uin = ");
              ((StringBuilder)localObject).append(str);
              ((StringBuilder)localObject).append(" result = ");
              ((StringBuilder)localObject).append(paramObject.isAdded2C2C);
              QLog.d("FriendListHandler", 2, ((StringBuilder)localObject).toString());
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
        notifyUI(2, true, paramObject);
        localFriendsManager.b(localArrayList1);
      }
      if ((paramToServiceMsg.extraData.getInt("reqType") == 3) && (this.isSyncingAllFriendsRichStatus) && (paramToServiceMsg.extraData.getStringArray("totalArray").length == paramToServiceMsg.extraData.getInt("nextStartPos")))
      {
        this.app.getPreferences().edit().putLong("inccheckupdatetimeStamp13", this.lastFriendListUpdateTime).commit();
        this.isSyncingAllFriendsRichStatus = false;
      }
      relayGetRichStatus(paramToServiceMsg);
      return;
    }
    if (paramToServiceMsg.extraData.getInt("reqType") == 3) {
      this.isSyncingAllFriendsRichStatus = false;
    }
    relayGetRichStatus(paramToServiceMsg);
  }
  
  private void handleGatherContactsResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool3 = true;
    boolean bool2;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    boolean bool4 = paramToServiceMsg.extraData.getBoolean("isGather", true);
    boolean bool5 = paramToServiceMsg.extraData.getBoolean("needNotifyPlugin", false);
    paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("friendUinList");
    boolean bool1 = bool2;
    if (bool2) {}
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          break label397;
        }
        bool1 = true;
        if (bool1)
        {
          paramFromServiceMsg = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          if (bool4) {
            paramFromServiceMsg.e(paramToServiceMsg);
          } else {
            paramFromServiceMsg.d(paramToServiceMsg);
          }
        }
        else
        {
          int i = paramFromServiceMsg.uint32_result.get();
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder();
            paramFromServiceMsg.append("handleGatherContactsResp fail: resultCode = ");
            paramFromServiceMsg.append(i);
            QLog.d("FriendListHandler", 2, paramFromServiceMsg.toString());
          }
        }
      }
      catch (Exception paramFromServiceMsg)
      {
        if (QLog.isColorLevel())
        {
          paramObject = new StringBuilder();
          paramObject.append("handleGatherContactsResp,error: ");
          paramObject.append(paramFromServiceMsg.getMessage());
          QLog.d("FriendListHandler", 2, paramObject.toString());
        }
        bool1 = false;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        paramObject = new StringBuilder();
        paramObject.append("handleGatherContactsResp,error: ");
        paramObject.append(paramFromServiceMsg.getMessage());
        QLog.d("FriendListHandler", 2, paramObject.toString());
        continue;
      }
      if (bool4) {
        notifyUI(88, bool1, paramToServiceMsg);
      } else {
        notifyUI(89, bool1, paramToServiceMsg);
      }
      if (bool5)
      {
        paramFromServiceMsg = new Intent("action_gather_resp");
        paramFromServiceMsg.putStringArrayListExtra("key_uin_list", paramToServiceMsg);
        paramFromServiceMsg.putExtra("key_is_suc", bool1);
        if (bool4)
        {
          if (bool1)
          {
            bool2 = bool3;
            break label380;
          }
        }
        else
        {
          bool2 = bool3;
          if (!bool1) {
            break label380;
          }
        }
        bool2 = false;
        label380:
        paramFromServiceMsg.putExtra("key_is_gather", bool2);
        BaseApplicationImpl.getContext().sendBroadcast(paramFromServiceMsg);
      }
      return;
      label397:
      bool1 = false;
    }
  }
  
  private void handleGetGatheredContactsList(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i = paramFromServiceMsg.getResultCode();
    Boolean localBoolean2 = Boolean.valueOf(true);
    Boolean localBoolean1 = Boolean.valueOf(false);
    if (i != 1000)
    {
      notifyUI(77, false, new Object[] { localBoolean1, localBoolean1 });
      return;
    }
    i = paramToServiceMsg.extraData.getInt("startIndex");
    paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label85:
      int j;
      cmd0x7c4.RspBody localRspBody;
      break label85;
    }
    if (!paramToServiceMsg.uint32_result.has())
    {
      notifyUI(77, false, new Object[] { localBoolean1, localBoolean1 });
      return;
    }
    j = paramToServiceMsg.uint32_result.get();
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("handleGetGatheredContactsList result ");
      paramFromServiceMsg.append(j);
      QLog.i("FriendListHandler", 2, paramFromServiceMsg.toString());
    }
    paramObject = new StringBuilder(1024);
    if (j == 0) {
      localRspBody = new cmd0x7c4.RspBody();
    }
    try
    {
      localRspBody.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
      cmd0x7c4.GetSNFrdListRsp localGetSNFrdListRsp = (cmd0x7c4.GetSNFrdListRsp)localRspBody.msg_get_sn_frd_list_rsp.get();
      localGetSNFrdListRsp.uint64_uin.get();
      j = localGetSNFrdListRsp.uint32_sequence.get();
      int k = localGetSNFrdListRsp.uint32_over.get();
      if (localRspBody.rpt_msg_recommend_reason.has())
      {
        paramToServiceMsg = localRspBody.rpt_msg_recommend_reason.get();
        ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(paramToServiceMsg);
      }
      paramToServiceMsg = localGetSNFrdListRsp.rpt_msg_one_frd_data.get();
      FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      if (paramToServiceMsg != null)
      {
        ArrayList localArrayList = new ArrayList();
        paramToServiceMsg = paramToServiceMsg.iterator();
        if (paramToServiceMsg.hasNext())
        {
          cmd0x7c4.OneFrdData localOneFrdData = (cmd0x7c4.OneFrdData)paramToServiceMsg.next();
          Friends localFriends = new Friends();
          localFriends.uin = String.valueOf(localOneFrdData.uint64_frd_id.get());
          localFriends.age = localOneFrdData.uint32_ages.get();
          if (!localOneFrdData.bytes_smart_remark.has()) {
            break label1009;
          }
          paramFromServiceMsg = localOneFrdData.bytes_smart_remark.get().toStringUtf8();
          localFriends.smartRemark = paramFromServiceMsg;
          localFriends.gender = ((byte)localOneFrdData.uint32_gender.get());
          int m = localOneFrdData.uint32_reason_id.get();
          localFriends.recommReason = localFriendsManager.a(m);
          localArrayList.add(localFriends);
          if (!QLog.isColorLevel()) {
            break label1014;
          }
          paramFromServiceMsg = new StringBuilder();
          paramFromServiceMsg.append("handleGetGatheredContactsList Gather List : ");
          paramFromServiceMsg.append(localFriends.uin);
          paramFromServiceMsg.append(" ; resonId = ");
          paramFromServiceMsg.append(m);
          paramFromServiceMsg.append(" ; f.recommReason =  ");
          paramFromServiceMsg.append(localFriends.recommReason);
          paramFromServiceMsg.append(" ; f.age = ");
          paramFromServiceMsg.append(localFriends.age);
          paramFromServiceMsg.append(" ; f.smartRemark = ");
          paramFromServiceMsg.append(localFriends.smartRemark);
          paramFromServiceMsg.append(" ; f.gender = ");
          paramFromServiceMsg.append(localFriends.gender);
          QLog.i("FriendListHandler", 2, paramFromServiceMsg.toString());
          break label1014;
        }
        localFriendsManager.a(localArrayList, i);
      }
      if (localGetSNFrdListRsp.uint32_recommend_frd_count.has())
      {
        i = localGetSNFrdListRsp.uint32_recommend_frd_count.get();
        paramObject.append("|recommend cnt=");
        paramObject.append(i);
      }
      else
      {
        paramObject.append("|no recommend field");
      }
      boolean bool = localRspBody.msg_box.has();
      this.app.getHandler(Conversation.class);
      if (bool)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. ");
        }
        paramToServiceMsg = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
        bool = paramToServiceMsg.getBoolean("hasPulledRecomGathered", false);
        paramToServiceMsg.edit().putBoolean("hasMsgBox", true).commit();
        paramObject.append("|has no MsgBox hasPulled=");
        paramObject.append(bool);
      }
      else
      {
        paramObject.append("|has no MsgBox");
      }
      if (k == 0)
      {
        i = localGetSNFrdListRsp.uint32_next_start_idx.get();
        paramObject.append("|not Completed. continue to get. startIndex =");
        paramObject.append(i);
        getGatheredContactsList(i);
        notifyUI(77, true, new Object[] { localBoolean1, localBoolean2 });
      }
      else
      {
        paramObject.append("|not Completed. continue to get. Completed.");
        this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit().putInt("GetFrdListReq_seq", j).commit();
        notifyUI(77, true, new Object[] { localBoolean2, localBoolean2 });
        if (localFriendsManager != null) {
          localFriendsManager.f();
        }
      }
      if (!QLog.isColorLevel()) {
        break label996;
      }
      QLog.i("FriendListHandler", 2, paramObject.toString());
      return;
    }
    catch (Exception paramToServiceMsg)
    {
      label925:
      break label925;
    }
    notifyUI(77, false, new Object[] { localBoolean1, localBoolean1 });
    return;
    if (j == 1)
    {
      notifyUI(77, true, new Object[] { localBoolean2, localBoolean1 });
      return;
    }
    notifyUI(77, false, new Object[] { localBoolean1, localBoolean1 });
    label996:
  }
  
  private void handleGetStrangerInfo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    int i;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {
      i = 1;
    } else {
      i = 0;
    }
    if (i == 0)
    {
      notifyUI(65, false, null);
      return;
    }
    try
    {
      paramToServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.get() == 0)) {
        i = 1;
      } else {
        i = 0;
      }
      if (i == 0)
      {
        notifyUI(65, false, null);
        return;
      }
      paramObject = new ArrayList();
      paramFromServiceMsg = new HashSet();
      if ((paramToServiceMsg.bytes_bodybuffer.has()) && (paramToServiceMsg.bytes_bodybuffer.get() != null))
      {
        ByteBuffer localByteBuffer = ByteBuffer.wrap(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
        if (localByteBuffer.getInt() == -1)
        {
          int n = localByteBuffer.getShort();
          FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
          int j = 0;
          while (j < n)
          {
            long l = Utils.a(localByteBuffer.getInt());
            paramToServiceMsg = localFriendsManager.a(String.valueOf(l));
            if (paramToServiceMsg == null)
            {
              paramToServiceMsg = new ExtensionInfo();
              paramToServiceMsg.uin = String.valueOf(l);
              i = 1;
            }
            else
            {
              i = 0;
            }
            int i1 = localByteBuffer.getShort();
            if (i1 > 0)
            {
              int k = 0;
              for (;;)
              {
                boolean bool = i;
                if (k >= i1) {
                  break;
                }
                m = localByteBuffer.getShort();
                i = i | FriendListHandlerUtil.a(localByteBuffer, paramToServiceMsg, m) | FriendListHandlerUtil.b(localByteBuffer, paramToServiceMsg, m) | FriendListHandlerUtil.c(localByteBuffer, paramToServiceMsg, m);
                FriendListHandlerUtil.a(this.app, localByteBuffer, l, m);
                k += 1;
              }
            }
            int m = i;
            if (QLog.isColorLevel())
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("handleGetStrangerInfo, uin=");
              localStringBuilder.append(l);
              localStringBuilder.append(", pendant=");
              localStringBuilder.append(paramToServiceMsg.pendantId);
              localStringBuilder.append(",font=");
              localStringBuilder.append(paramToServiceMsg.uVipFont);
              localStringBuilder.append(", fontType = ");
              localStringBuilder.append(paramToServiceMsg.vipFontType);
              QLog.d("FriendListHandler", 2, localStringBuilder.toString());
            }
            if (m != 0)
            {
              paramToServiceMsg.timestamp = System.currentTimeMillis();
              paramObject.add(paramToServiceMsg);
              paramFromServiceMsg.add(paramToServiceMsg.uin);
            }
            j += 1;
          }
          localFriendsManager.b(paramObject);
        }
      }
      if (paramFromServiceMsg.size() == 0) {
        paramToServiceMsg = null;
      } else {
        paramToServiceMsg = paramFromServiceMsg;
      }
      notifyUI(65, true, paramToServiceMsg);
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("handleGetStrangerInfo. addonId size : ");
        paramToServiceMsg.append(paramObject.size());
        QLog.i("Q.stranger_info", 2, paramToServiceMsg.toString());
      }
      return;
    }
    catch (InvalidProtocolBufferMicroException paramToServiceMsg)
    {
      notifyUI(65, false, null);
      if (QLog.isColorLevel()) {
        QLog.w("Q.stranger_info", 2, paramToServiceMsg.getMessage());
      }
    }
  }
  
  private void handleSetHiddenChatResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FriendListHandler.handleSetHiddenChatResp(). res=");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      ((StringBuilder)localObject).append(", data=");
      ((StringBuilder)localObject).append(paramObject);
      QLog.d("tag_hidden_chat", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = paramToServiceMsg.extraData.getStringArray("param_uins");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("param_chat_types");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
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
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, "parse oidb_sso.OIDBSSOPkg failed.");
        }
        paramFromServiceMsg.printStackTrace();
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        int i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("ssoPkg.uint32_result=");
          paramToServiceMsg.append(i);
          QLog.d("tag_hidden_chat", 2, paramToServiceMsg.toString());
        }
        if (i == 0)
        {
          i = 0;
          while (i < localObject.length)
          {
            paramToServiceMsg = localObject[i];
            k = arrayOfBoolean[i];
            int j = arrayOfInt[i];
            paramToServiceMsg = new FriendsStatusUtil.UpdateFriendStatusItem(paramToServiceMsg, 13581, 21);
            if (k != 0) {
              paramToServiceMsg.a(new byte[1]);
            } else {
              paramToServiceMsg.a(null);
            }
            FriendsStatusUtil.a(this.app, paramToServiceMsg, null);
            i += 1;
          }
          k = 1;
          break label312;
        }
      }
    }
    int k = 0;
    label312:
    notifyUI(127, k, new Object[] { localObject, arrayOfBoolean });
  }
  
  private void handleSetMessageNotificationSettingResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FriendListHandler.handleSetMessageNotificationSettingResp(). res=");
      ((StringBuilder)localObject).append(paramFromServiceMsg);
      ((StringBuilder)localObject).append(", data=");
      ((StringBuilder)localObject).append(paramObject);
      QLog.d("tag_msg_notification", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = MessageNotificationSettingManager.a(this.app);
    int j = paramToServiceMsg.extraData.getInt("param_type");
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_uins");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
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
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, "parse oidb_sso.OIDBSSOPkg failed.");
        }
        paramFromServiceMsg.printStackTrace();
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        int i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel())
        {
          paramToServiceMsg = new StringBuilder();
          paramToServiceMsg.append("ssoPkg.uint32_result=");
          paramToServiceMsg.append(i);
          QLog.d("tag_hidden_chat", 2, paramToServiceMsg.toString());
        }
        if (i == 0)
        {
          i = 0;
          while (i < arrayOfString.length)
          {
            ((MessageNotificationSettingManager)localObject).a(arrayOfString[i], j, arrayOfBoolean[i]);
            i += 1;
          }
          bool = true;
          break label275;
        }
      }
    }
    boolean bool = false;
    label275:
    notifyUI(128, bool, new Object[] { arrayOfString, arrayOfBoolean, Integer.valueOf(j) });
  }
  
  private void handleSetSpecialCareSwitchResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void handleSetSpecialCareSwitchesOfAPersonResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  private void handleStrangerRichStatus(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject = (GetRichSigRes)paramObject;
    paramObject = paramToServiceMsg.extraData.getStringArray("sendArray");
    if ((localObject != null) && (((GetRichSigRes)localObject).cResult == 0) && (((GetRichSigRes)localObject).vstSigInfo != null) && (((GetRichSigRes)localObject).vstSigInfo.size() != 0))
    {
      HashMap localHashMap = new HashMap(paramObject.length);
      localObject = ((GetRichSigRes)localObject).vstSigInfo.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject).next();
        localHashMap.put(Long.toString(localResRichSigInfo.lUin), RichStatus.parseStatus(localResRichSigInfo.vbSigInfo));
      }
      notifyUI(64, true, new Object[] { paramObject, localHashMap });
      relayGetRichStatus(paramToServiceMsg);
      return;
    }
    notifyUI(64, false, new Object[] { paramObject, null });
    relayGetRichStatus(paramToServiceMsg);
  }
  
  public static void initSpecialCareInfo(SpecialCareInfo paramSpecialCareInfo, int paramInt, String paramString)
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
    else if (paramInt == 13573)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramSpecialCareInfo.globalSwitch = 0;
          return;
        }
        paramSpecialCareInfo.globalSwitch = 1;
        return;
      }
      catch (Exception paramSpecialCareInfo)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
      }
      QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramSpecialCareInfo);
    }
    else if (paramInt == 13572)
    {
      try
      {
        if (TextUtils.isEmpty(paramString))
        {
          paramSpecialCareInfo.qzoneSwitch = 0;
          return;
        }
        paramSpecialCareInfo.qzoneSwitch = 1;
        return;
      }
      catch (Exception paramSpecialCareInfo)
      {
        if (QLog.isColorLevel()) {
          QLog.w("FriendListHandler", 2, "initSpecialCareInfo|exception = ", paramSpecialCareInfo);
        }
      }
    }
  }
  
  private Map<String, Integer> makeGrneralPathMap(ArrayList<Setting> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        Setting localSetting = (Setting)paramArrayList.get(i);
        localHashMap.put(localSetting.Path, Integer.valueOf(Integer.parseInt(localSetting.Value)));
        i += 1;
      }
    }
    return localHashMap;
  }
  
  public static oidb_sso.OIDBSSOPkg parseSSOPkg(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg != null) && (paramFromServiceMsg != null))
    {
      if (paramFromServiceMsg.getResultCode() != 1000) {
        return null;
      }
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramToServiceMsg.mergeFrom((byte[])paramObject);
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      label43:
      break label43;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "parseSSOPkg: oidb_sso parseFrom byte InvalidProtocolBufferMicroException ");
    }
    if ((paramToServiceMsg.uint32_result.get() == 0) && (paramToServiceMsg.bytes_bodybuffer.get() != null)) {
      return paramToServiceMsg;
    }
    if (QLog.isColorLevel())
    {
      paramFromServiceMsg = new StringBuilder();
      paramFromServiceMsg.append("parseSSOPkg: oidb_sso ssoPkg.uint32_result.get() ");
      paramFromServiceMsg.append(paramToServiceMsg.uint32_result.get());
      QLog.d("FriendListHandler", 2, paramFromServiceMsg.toString());
    }
    return null;
  }
  
  private void relayGetRichStatus(ToServiceMsg paramToServiceMsg)
  {
    doGetRichStatus(paramToServiceMsg.extraData.getStringArray("totalArray"), paramToServiceMsg.extraData.getInt("nextStartPos"), paramToServiceMsg.extraData.getInt("reqType"), paramToServiceMsg.extraData.getBundle("circleBundle"), paramToServiceMsg.extraData.getBoolean("showDateNickname"));
  }
  
  private boolean shouldReqXMan(String paramString)
  {
    boolean bool2 = paramString.equals(this.app.getCurrentAccountUin());
    boolean bool1 = bool2;
    if (bool2)
    {
      Context localContext = this.app.getApp().getApplicationContext();
      Card localCard = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
      long l1 = ContactConfig.b(localContext, paramString) + 28800000L;
      long l2 = System.currentTimeMillis() + 28800000L;
      long l3 = localCard.iXManScene1DelayTime * 1000;
      long l4 = l1 / 86400000L;
      long l5 = l2 / 86400000L;
      if ((l4 != l5) && (Math.abs(l2 - l1) > 28800000L) && (l2 % 86400000L >= l3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, String.format("shouldReqXMan toReq=%s lastReqTime=%s currentTime=%s reqDelay=%s lastReqDay=%s currentDay=%s lastReqInterval=%s time=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4), Long.valueOf(l5), Long.valueOf(Math.abs(l2 - l1)), Long.valueOf(l2 % 86400000L) }));
      }
    }
    return bool1;
  }
  
  private boolean shouldReqXManScene2(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, String.format("shouldReqXManScene2 friendUin=%s", new Object[] { paramString }));
    }
    boolean bool1 = paramString.equals(this.app.getCurrentAccountUin());
    boolean bool2 = bool1;
    if (bool1)
    {
      Context localContext = this.app.getApp().getApplicationContext();
      Card localCard = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
      long l1 = ContactConfig.c(localContext, paramString);
      long l2 = System.currentTimeMillis();
      long l3 = localCard.iXManScene2DelayTime * 1000;
      if ((l3 >= 0L) && (Math.abs(l2 - l1) > l3)) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        QLog.d("FriendListHandler", 2, String.format("shouldReqXManScene2 toReq=%s lastReqTime=%s currentTime=%s reqDelay=%s", new Object[] { Boolean.valueOf(bool1), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3) }));
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public static boolean updateSnsData_HOT_FRIEND_CHAT_LEVEL_TYPE(String paramString, byte[] paramArrayOfByte, ExtensionInfo paramExtensionInfo)
  {
    return false;
  }
  
  public void addBatchQIMFriends(List<QIMNotifyAddFriend> paramList)
  {
    Object localObject = new cmd0xaed.ReqBody();
    ((cmd0xaed.ReqBody)localObject).uint64_qq_uin.set(Long.valueOf(this.app.getCurrentAccountUin()).longValue());
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
    localObject = createToServiceMsg("OidbSvc.0xaed_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramList.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void addFriendGroup(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("AddFriendGroup :");
      localStringBuilder.append(paramString);
      QLog.d("FriendListHandler", 2, localStringBuilder.toString());
    }
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).addFriendGroup(paramByte, paramString);
  }
  
  public void addFriendTipsMr(String paramString, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("----------addFriendTipsMr friendUin: ");
      ((StringBuilder)???).append(paramString);
      ((StringBuilder)???).append(", sourceId=");
      ((StringBuilder)???).append(paramInt);
      QLog.d("FriendListHandler", 2, ((StringBuilder)???).toString());
    }
    if ((paramInt == 2007) || (paramInt == 3007) || (paramInt == 4007) || (paramInt == 2017) || (paramInt == 3017)) {
      this.app.getAVNotifyCenter().a(Long.valueOf(paramString).longValue(), true, paramInt);
    }
    if (!TextUtils.isEmpty(paramString)) {
      synchronized (this.mGreetingLock)
      {
        paramString = (GreetingMsg)this.mGreetingDataMap.get(paramString);
        if (paramString != null) {
          addGreetingMsg(paramString.jdField_b_of_type_JavaLangString, paramString.jdField_c_of_type_JavaLangString, paramString.jdField_a_of_type_Long, paramString.jdField_a_of_type_JavaLangString, paramString.jdField_b_of_type_Long, paramString.jdField_a_of_type_Int, paramString.jdField_b_of_type_Int, paramString.jdField_c_of_type_Long);
        }
        return;
      }
    }
  }
  
  public boolean addFriendToFriendList(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("addFriendToFriendList ");
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramString2);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject).toString());
    }
    paramString2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
    if (localObject != null) {
      ((IPhoneContactService)localObject).onFriendListChanged();
    }
    paramBoolean1 = paramString2.a(paramString1, paramInt1, paramBoolean2);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("FriendListHandler addFriendToFriendList flag = ");
      ((StringBuilder)localObject).append(paramBoolean1);
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean1)
    {
      this.app.getMessageFacade().a(paramString1, 0);
      if (!((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).isRequestingFriendList()) {
        notifyUI(1, true, Boolean.valueOf(true));
      }
      notifyUI(62, true, paramString1);
      localObject = (INearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      if (localObject != null)
      {
        localObject = ((INearbyCardManager)localObject).a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("");
        localStringBuilder.append(paramString1);
        ((ConcurrentHashMap)localObject).put(localStringBuilder.toString(), Integer.valueOf(1));
      }
      getFriendDetailInfo(paramString1);
      paramString2.a(paramString1, false);
      ((QzoneContactsFeedManager)this.app.getManager(QQManagerFactory.QZONE_CONTACTS_FEED_MANAGER)).a(Long.valueOf(paramString1).longValue());
      if ((QidianManager.a(this.app, paramString1)) || ((!CrmUtils.b(this.app, paramString1)) && (!CrmUtils.a(this.app, paramString1)))) {
        addFriendTipsMr(paramString1, paramInt2);
      }
      FriendListHandlerUtil.a(CrmUtils.b(this.app, paramString1), this.app);
    }
    paramString2 = paramString2.a();
    if (paramString2 != null) {
      paramString2.b(paramString1);
    }
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    ChatActivityFacade.a(this.app, BaseApplication.getContext(), paramString2);
    return paramBoolean1;
  }
  
  public void addGreetingMsg(String paramString1, String paramString2, long paramLong1, String arg5, long paramLong2, int paramInt1, int paramInt2, long paramLong3)
  {
    Object localObject2 = ???;
    if (TextUtils.isEmpty(paramString1))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "addGreetingMsg | uin is empty");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, String.format(Locale.getDefault(), "addGreetingMsg uin=%s, mobile=%s, addationMsg=%s, sourceid=%s, subSourceid=%s, requin=%s", new Object[] { paramString1, paramString2, localObject2, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Long.valueOf(paramLong3) }));
    }
    Object localObject1;
    Object localObject4;
    label1435:
    label1473:
    synchronized (this.mGreetingLock)
    {
      if (paramLong2 == this.lastGreetingTime) {
        return;
      }
      if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString1))
      {
        localObject1 = this.app.getMessageFacade().a(paramString1, 0);
        if ((localObject1 != null) && (((List)localObject1).size() > 0))
        {
          localObject3 = this.app.getCurrentUin();
          localObject4 = this.app.getApp().getString(2131689990);
          localObject2 = ???;
          localObject1 = localObject2;
        }
      }
      try
      {
        localObject3 = new UniteGrayTipParam(paramString1, (String)localObject3, (String)localObject4, 0, -5040, 655362, paramLong2);
        localObject1 = localObject2;
        localObject4 = new MessageForUniteGrayTip();
        localObject1 = localObject2;
        ((MessageForUniteGrayTip)localObject4).initGrayTipMsg(this.app, (UniteGrayTipParam)localObject3);
        localObject1 = localObject2;
        UniteGrayTipMsgUtil.a(this.app, (MessageForUniteGrayTip)localObject4);
      }
      finally
      {
        for (;;)
        {
          Object localObject5;
          Object localObject6;
          int i;
          Bundle localBundle;
          boolean bool;
          paramString2 = (String)localObject1;
          continue;
          break label1435;
          localObject4 = localObject2;
          continue;
          int j = 0;
          localObject2 = ???;
          if ((paramInt1 != 2093) && (paramInt1 != 3093))
          {
            i = 0;
          }
          else
          {
            i = 1;
            continue;
            if (paramInt1 != 3078)
            {
              i = j;
              if (paramInt1 != 3079) {}
            }
            else
            {
              i = 1;
            }
          }
        }
      }
      Object localObject3 = ???;
      localObject1 = localObject3;
      ((INewFriendService)this.app.getRuntimeService(INewFriendService.class, "")).saveNewFriend2Cache(paramString1);
      localObject1 = localObject3;
      localObject5 = (MessageForText)MessageRecordFactory.a(-1000);
      localObject1 = localObject3;
      ((MessageForText)localObject5).frienduin = paramString1;
      localObject1 = localObject3;
      localObject4 = this.app.getApp().getString(2131689991);
      localObject1 = localObject3;
      if (paramLong3 == this.app.getLongAccountUin())
      {
        localObject1 = localObject3;
        localObject2 = HardCodeUtil.a(2131706656);
      }
      localObject1 = localObject3;
      localObject6 = this.app.getCurrentAccountUin();
      localObject1 = localObject3;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = localObject3;
        ((MessageForText)localObject5).init((String)localObject6, paramString1, paramString1, (String)localObject4, paramLong2, -1000, 0, paramLong2);
        localObject1 = localObject3;
        ((MessageForText)localObject5).isread = true;
        if (paramLong1 != -1L)
        {
          localObject1 = localObject3;
          ((MessageForText)localObject5).vipBubbleID = paramLong1;
        }
        localObject1 = localObject3;
        this.app.getMsgHandler().b((MessageRecord)localObject5);
        localObject1 = localObject3;
        if (!TextUtils.isEmpty((CharSequence)localObject2))
        {
          localObject1 = localObject3;
          if (paramLong3 != this.app.getLongAccountUin())
          {
            localObject1 = localObject3;
            localObject4 = ContactUtils.d(this.app, paramString1);
            localObject2 = localObject4;
            localObject1 = localObject3;
            if (TextUtils.isEmpty((CharSequence)localObject4)) {
              localObject2 = paramString1;
            }
            localObject1 = localObject3;
            localObject4 = (MessageForGrayTips)MessageRecordFactory.a(-1013);
            localObject1 = localObject3;
            ((MessageForGrayTips)localObject4).init(this.app.getCurrentAccountUin(), paramString1, paramString1, String.format(HardCodeUtil.a(2131706665), new Object[] { localObject2 }), paramLong2, -1013, 0, paramLong2);
            localObject1 = localObject3;
            ((MessageForGrayTips)localObject4).isread = true;
            localObject1 = localObject3;
            this.app.getMsgHandler().b((MessageRecord)localObject4);
            break label1435;
            if (i == 0) {
              break label1473;
            }
            localObject1 = localObject2;
            localObject4 = HardCodeUtil.a(2131706666);
            localObject1 = localObject2;
            localObject6 = HardCodeUtil.a(2131706661);
            localObject1 = localObject2;
            localObject5 = HardCodeUtil.a(2131706664);
            localObject1 = localObject2;
            localObject3 = new UniteGrayTipParam(paramString1, this.app.getCurrentUin(), (String)localObject4, 0, -5040, 135179, paramLong2);
            localObject1 = localObject2;
            ((UniteGrayTipParam)localObject3).jdField_c_of_type_JavaLangString = ((String)localObject4);
            localObject1 = localObject2;
            localBundle = new Bundle();
            localObject1 = localObject2;
            localBundle.putInt("key_action", 14);
            localObject1 = localObject2;
            localBundle.putString("key_action_DATA", "from_batch_add_frd_for_troop");
            localObject1 = localObject2;
            ((UniteGrayTipParam)localObject3).a(((String)localObject4).indexOf((String)localObject6), ((String)localObject4).indexOf((String)localObject6) + ((String)localObject6).length(), localBundle);
            localObject1 = localObject2;
            localObject6 = new Bundle();
            localObject1 = localObject2;
            ((Bundle)localObject6).putInt("key_action", 13);
            localObject1 = localObject2;
            ((Bundle)localObject6).putString("key_action_DATA", "from_batch_add_frd_for_troop");
            localObject1 = localObject2;
            ((UniteGrayTipParam)localObject3).a(((String)localObject4).indexOf((String)localObject5), ((String)localObject4).indexOf((String)localObject5) + ((String)localObject5).length(), (Bundle)localObject6);
            localObject1 = localObject2;
            localObject4 = new MessageForUniteGrayTip();
            localObject1 = localObject2;
            ((MessageForUniteGrayTip)localObject4).initGrayTipMsg(this.app, (UniteGrayTipParam)localObject3);
            localObject1 = localObject2;
            UniteGrayTipMsgUtil.a(this.app, (MessageForUniteGrayTip)localObject4);
            break label1473;
            localObject1 = localObject2;
            bool = EAddFriendSourceID.a(paramInt1);
            if (i != 0)
            {
              localObject1 = localObject2;
              localObject3 = (MessageForGrayTips)MessageRecordFactory.a(-1013);
              localObject1 = localObject2;
              ((MessageForGrayTips)localObject3).init(this.app.getCurrentAccountUin(), paramString1, paramString1, this.app.getApp().getString(2131689989), paramLong2, -1013, 3, paramLong2);
              localObject1 = localObject2;
              localObject4 = new Bundle();
              localObject1 = localObject2;
              ((Bundle)localObject4).putInt("key_action", 14);
              localObject1 = localObject2;
              ((MessageForGrayTips)localObject3).addHightlightItem(18, 22, (Bundle)localObject4);
              localObject1 = localObject2;
              localObject4 = new Bundle();
              localObject1 = localObject2;
              ((Bundle)localObject4).putInt("key_action", 13);
              localObject1 = localObject2;
              ((MessageForGrayTips)localObject3).addHightlightItem(23, 27, (Bundle)localObject4);
              localObject1 = localObject2;
              ((MessageForGrayTips)localObject3).isread = true;
              localObject1 = localObject2;
              this.app.getMsgHandler().b((MessageRecord)localObject3);
              localObject1 = localObject2;
              ReportController.b(this.app, "dc00898", "", "", "0X8007978", "0X8007978", 0, 0, "", "", "", "");
            }
            if (bool)
            {
              localObject1 = localObject2;
              if (!TextUtils.isEmpty(paramString2))
              {
                localObject1 = localObject2;
                bool = ((IPhoneContactService)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).deletePhoneContactAddInfo(paramString2);
                localObject1 = localObject2;
                if (QLog.isColorLevel())
                {
                  localObject1 = localObject2;
                  localObject3 = new StringBuilder();
                  localObject1 = localObject2;
                  ((StringBuilder)localObject3).append("addGreetingMsg | deleted = ");
                  localObject1 = localObject2;
                  ((StringBuilder)localObject3).append(bool);
                  localObject1 = localObject2;
                  QLog.d("FriendListHandler", 2, ((StringBuilder)localObject3).toString());
                }
                if (bool)
                {
                  localObject1 = localObject2;
                  notifyUI(130, true, paramString2);
                }
              }
            }
            localObject1 = localObject2;
            IceBreakingUtil.a(this.app, paramString1, paramLong2, paramInt1, paramInt2);
            localObject1 = localObject2;
            if (this.mGreetingDataMap.get(paramString1) != null)
            {
              localObject1 = localObject2;
              this.mGreetingDataMap.remove(paramString1);
            }
            localObject1 = localObject2;
            this.lastGreetingTime = paramLong2;
            break label1403;
            localObject3 = ???;
            localObject1 = localObject3;
            localObject4 = new GreetingMsg();
            localObject1 = localObject3;
            ((GreetingMsg)localObject4).jdField_b_of_type_JavaLangString = paramString1;
            localObject1 = localObject3;
            ((GreetingMsg)localObject4).jdField_a_of_type_JavaLangString = ((String)localObject2);
            localObject1 = localObject3;
            ((GreetingMsg)localObject4).jdField_a_of_type_Long = paramLong1;
            localObject1 = localObject3;
            ((GreetingMsg)localObject4).jdField_b_of_type_Long = paramLong2;
            localObject1 = localObject3;
            ((GreetingMsg)localObject4).jdField_a_of_type_Int = paramInt1;
            localObject1 = localObject3;
            ((GreetingMsg)localObject4).jdField_b_of_type_Int = paramInt2;
            localObject1 = localObject3;
            ((GreetingMsg)localObject4).jdField_c_of_type_JavaLangString = paramString2;
            localObject1 = localObject3;
            ((GreetingMsg)localObject4).jdField_c_of_type_Long = paramLong3;
            localObject1 = localObject3;
            this.mGreetingDataMap.put(paramString1, localObject4);
            label1403:
            localObject1 = ???;
            return;
            localObject1 = paramString2;
            throw paramString1;
          }
        }
      }
    }
  }
  
  public void agreeSuspiciousMsg(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("agreeSuspiciousMsg ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("FriendListHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_cmd0xd72.ReqBody();
    ((oidb_cmd0xd72.ReqBody)localObject).doubt_uin.set(paramLong);
    ((oidb_cmd0xd72.ReqBody)localObject).uin.set(this.app.getLongAccountUin());
    localObject = makeOIDBPkg("OidbSvc.0xd72", 3442, 0, ((oidb_cmd0xd72.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("toUin", Long.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public boolean batchAddFriendForTroopMembers(String paramString1, String paramString2, String paramString3, List<String> paramList, boolean paramBoolean, int paramInt1, int paramInt2)
  {
    if (this.mBatchAddFriendData == null) {
      this.mBatchAddFriendData = new BatchAddFriendData();
    }
    paramBoolean = this.mBatchAddFriendData.a(paramString1, paramString2, paramString3, paramList, paramBoolean, paramInt1, paramInt2);
    if (paramBoolean) {
      this.mBatchAddFriendData.a(this);
    }
    return paramBoolean;
  }
  
  public void cancelMayKnowRecommend(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new FriendListHandler.3(this, paramString));
  }
  
  public void changeFriendShieldFlag(long paramLong, boolean paramBoolean)
  {
    send_oidb_0x5d1_0(paramLong, 4051, paramBoolean);
  }
  
  public void condtionalSearchFriendBy0x972(long paramLong, int paramInt1, byte[] paramArrayOfByte, String paramString, int paramInt2, int paramInt3, int paramInt4, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt5, int paramInt6, int paramInt7)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("condtionalSearchFriendBy0x972 seq = ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(",page = ");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",cookie = ");
      ((StringBuilder)localObject).append(paramArrayOfByte);
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_0x972.ReqBody();
    short s2 = (short)paramInt3;
    int j = (short)paramInt4;
    short s1 = s2;
    if (s2 < 0) {
      s1 = 0;
    }
    int i = j;
    if (s1 > j)
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, String.format("handleCondSearchFriend [%s, %s]--[%s, %s]", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Short.valueOf(s1), Short.valueOf(32767) }));
      }
      i = 32767;
    }
    ((oidb_0x972.ReqBody)localObject).key_word.set(ByteStringMicro.copyFromUtf8(paramString));
    ((oidb_0x972.ReqBody)localObject).version.set(ByteStringMicro.copyFromUtf8("8.7.0"));
    oidb_0x972.RootSearcherRequest localRootSearcherRequest = new oidb_0x972.RootSearcherRequest();
    localRootSearcherRequest.page_size.set(25);
    if (paramArrayOfByte != null) {
      localRootSearcherRequest.cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    ((oidb_0x972.ReqBody)localObject).search_request.set(localRootSearcherRequest);
    ((oidb_0x972.ReqBody)localObject).gander.set(paramInt2);
    ((oidb_0x972.ReqBody)localObject).start_age.set(s1);
    ((oidb_0x972.ReqBody)localObject).end_age.set(i);
    ((oidb_0x972.ReqBody)localObject).constellation.set(paramInt6);
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length >= 3))
    {
      ((oidb_0x972.ReqBody)localObject).country_id.set(ConditionSearchManager.a(paramArrayOfString1[0]));
      ((oidb_0x972.ReqBody)localObject).province_id.set(ConditionSearchManager.a(paramArrayOfString1[1]));
      ((oidb_0x972.ReqBody)localObject).city_id.set(ConditionSearchManager.a(paramArrayOfString1[2]));
    }
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length >= 3))
    {
      ((oidb_0x972.ReqBody)localObject).h_country_id.set(ConditionSearchManager.a(paramArrayOfString2[0]));
      ((oidb_0x972.ReqBody)localObject).h_province_id.set(ConditionSearchManager.a(paramArrayOfString2[1]));
      ((oidb_0x972.ReqBody)localObject).h_city_id.set(ConditionSearchManager.a(paramArrayOfString2[2]));
    }
    ((oidb_0x972.ReqBody)localObject).career_id.set(paramInt5);
    paramArrayOfByte = makeOIDBPkg("OidbSvc.0x972_5", 2418, 5, ((oidb_0x972.ReqBody)localObject).toByteArray());
    paramArrayOfByte.extraData.putLong("search_seq", paramLong);
    paramArrayOfByte.extraData.putInt("param_page", paramInt1);
    paramArrayOfByte.extraData.putString("param_keyword", paramString);
    paramArrayOfByte.extraData.putInt("param_sex_index", paramInt2);
    paramArrayOfByte.extraData.putInt("param_age_index1", paramInt3);
    paramArrayOfByte.extraData.putInt("param_age_index2", paramInt4);
    paramArrayOfByte.extraData.putStringArray("param_loc_code", paramArrayOfString1);
    paramArrayOfByte.extraData.putStringArray("param_home_code", paramArrayOfString2);
    paramArrayOfByte.extraData.putInt("param_job_index", paramInt5);
    paramArrayOfByte.extraData.putInt("param_xingzuo_index", paramInt6);
    paramArrayOfByte.extraData.putInt("param_search_from", paramInt7);
    sendPbReq(paramArrayOfByte);
  }
  
  public void confirmContactFriend(int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte, byte paramByte, String paramString, long paramLong3, long paramLong4)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BumpSvc.ReqComfirmContactFriend");
    Object localObject1 = ((IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "")).getSelfBindInfo();
    if (localObject1 != null)
    {
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((RespondQueryQQBindingStat)localObject1).nationCode);
      ((StringBuilder)localObject2).append(((RespondQueryQQBindingStat)localObject1).mobileNo);
      localObject2 = ((StringBuilder)localObject2).toString();
      if ((localObject2 != null) && (((String)localObject2).length() > 0))
      {
        localObject1 = localObject2;
        if (((String)localObject2).startsWith("+")) {
          localObject1 = ((String)localObject2).substring(1);
        }
        l = Long.parseLong((String)localObject1);
        break label137;
      }
    }
    long l = 0L;
    label137:
    localToServiceMsg.extraData.putInt("bType", paramInt);
    localToServiceMsg.extraData.putLong("lToMID", paramLong1);
    localToServiceMsg.extraData.putLong("lFromMobile", l);
    localToServiceMsg.extraData.putLong("lToMobile", paramLong2);
    localToServiceMsg.extraData.putByteArray("vSig", paramArrayOfByte);
    localToServiceMsg.extraData.putByte("bGroupId", paramByte);
    localToServiceMsg.extraData.putString("strNickName", paramString);
    localToServiceMsg.extraData.putLong("infotime", paramLong3);
    localToServiceMsg.extraData.putLong("dbid", paramLong4);
    send(localToServiceMsg);
  }
  
  public void create0x5d6RequestPackage(int paramInt, ArrayList<FriendsStatusUtil.UpdateFriendStatusItem> paramArrayList, String paramString, boolean paramBoolean)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(" create0x5d6SendPackage serType=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.d("FriendListHandler", 4, ((StringBuilder)localObject1).toString());
    }
    int i = 0;
    if ((paramArrayList != null) && (paramArrayList.size() <= 20))
    {
      localObject1 = new ArrayList(1);
      i = 0;
      while (i < paramArrayList.size())
      {
        Object localObject3 = (FriendsStatusUtil.UpdateFriendStatusItem)paramArrayList.get(i);
        localObject2 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(Long.parseLong(((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).jdField_a_of_type_JavaLangString));
        ArrayList localArrayList = new ArrayList(1);
        oidb_0x5d6.SnsUpdateItem localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
        localSnsUpdateItem.uint32_update_sns_type.set(((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).jdField_b_of_type_Int);
        localObject3 = ((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).a();
        if (localObject3 != null) {
          localSnsUpdateItem.bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject3));
        }
        localArrayList.add(localSnsUpdateItem);
        ((oidb_0x5d6.SnsUpateBuffer)localObject2).rpt_msg_sns_update_item.set(localArrayList);
        ((List)localObject1).add(localObject2);
        i += 1;
      }
      Object localObject2 = new oidb_0x5d6.ReqBody();
      ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
      ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(paramInt);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
      paramString = createToServiceMsg(paramString);
      paramString.extraData.putParcelableArrayList("param_status_item_list", paramArrayList);
      paramString.extraData.putInt("param_type", paramInt);
      paramString.extraData.putBoolean("param_notify_plugin", paramBoolean);
      paramString.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      sendPbReq(paramString);
      return;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder("create0x5d6SendPackage serType=");
      paramString.append(paramInt);
      paramString.append(" length=");
      if (paramArrayList == null) {
        paramInt = i;
      } else {
        paramInt = paramArrayList.size();
      }
      paramString.append(paramInt);
      QLog.d("FriendListHandler", 4, paramString.toString());
    }
  }
  
  public void decodePush0x210_0x11e(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        localObject = new SubMsgType0x11e.MsgBody();
        ((SubMsgType0x11e.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (!((SubMsgType0x11e.MsgBody)localObject).uint32_type.has()) {
          break label204;
        }
        l = ((SubMsgType0x11e.MsgBody)localObject).uint32_type.get();
        if (!((SubMsgType0x11e.MsgBody)localObject).str_reason.has()) {
          break label211;
        }
        paramArrayOfByte = ((SubMsgType0x11e.MsgBody)localObject).str_reason.get();
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("decodePush0x210_0x11e,type = ");
          ((StringBuilder)localObject).append(l);
          ((StringBuilder)localObject).append(" reason = ");
          ((StringBuilder)localObject).append(paramArrayOfByte);
          QLog.i("FriendListHandler", 2, ((StringBuilder)localObject).toString());
        }
        if (l == 1L)
        {
          getFriendGroupList(true);
          return;
        }
        if (l != 2L) {
          break label203;
        }
        getCheckUpdate(true, 8);
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decodePush0x210_0x11e decode error, e=");
        ((StringBuilder)localObject).append(paramArrayOfByte.toString());
        QLog.i("FriendListHandler", 1, ((StringBuilder)localObject).toString());
        return;
      }
      QLog.i("FriendListHandler", 1, "decodePush0x210_0x11e pbData = null");
      label203:
      return;
      label204:
      long l = -1L;
      continue;
      label211:
      paramArrayOfByte = null;
    }
  }
  
  public void delAuthDev(String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt, boolean paramBoolean, long paramLong)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 2);
    if (paramBoolean) {
      localToServiceMsg.extraData.putInt("iDelMe", 1);
    } else {
      localToServiceMsg.extraData.putInt("iDelMe", 0);
    }
    localToServiceMsg.extraData.putLong("iAppId", paramLong);
    send(localToServiceMsg);
  }
  
  public void delFriend(String paramString, byte paramByte)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("NO CRASH, JUST FOR GET INFO: ");
    ((StringBuilder)localObject).append(QLog.getStackTraceString(new Throwable()));
    QLog.i("FriendListHandler", 1, ((StringBuilder)localObject).toString());
    localObject = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.delFriend");
    ((ToServiceMsg)localObject).extraData.putString("uin", paramString);
    ((ToServiceMsg)localObject).extraData.putByte("del_type", paramByte);
    send((ToServiceMsg)localObject);
  }
  
  public void delHistoryDev(String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.extraData.putInt("iDelType", 1);
    send(localToServiceMsg);
  }
  
  public void delMultiClient(String paramString, ArrayList<DeviceItemDes> paramArrayList, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.DelDevLoginInfo");
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.addAttribute("vecDeviceItemDes", paramArrayList);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putInt("index", paramInt);
    send(localToServiceMsg);
  }
  
  public void deleteAllSuspiciousMsg()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "deleteAllSuspiciousMsg ");
    }
    Object localObject = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject).cmd_type.set(4);
    localObject = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("cmd", Integer.valueOf(4));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void deleteFriendGroup(byte paramByte)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("DeleteFriendGroup :");
      localStringBuilder.append(paramByte);
      QLog.d("FriendListHandler", 2, localStringBuilder.toString());
    }
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).deleteFriendGroup(paramByte);
  }
  
  public void deleteStrangerInfo(FriendsManager paramFriendsManager)
  {
    Object localObject = QvipSpecialCareUtil.a(this.app);
    if ((paramFriendsManager != null) && (localObject != null) && (((Set)localObject).size() > 0))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramFriendsManager.b(str))
        {
          QvipSpecialCareUtil.b(str, this.app);
          if (QvipSpecialCareUtil.b(str, this.app)) {
            QvipSpecialCareUtil.c(str, this.app);
          }
        }
      }
    }
  }
  
  public void deleteSuspiciousMsg(long paramLong)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("deleteSuspiciousMsg ");
      ((StringBuilder)localObject).append(paramLong);
      QLog.i("FriendListHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject).cmd_type.set(3);
    oidb_cmd0xd69.DeleteReqBody localDeleteReqBody = new oidb_cmd0xd69.DeleteReqBody();
    localDeleteReqBody.doubt_uin.set(paramLong);
    ((oidb_cmd0xd69.ReqBody)localObject).msg_delete_body.set(localDeleteReqBody);
    localObject = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("cmd", Integer.valueOf(3));
    ((ToServiceMsg)localObject).addAttribute("uin", Long.valueOf(paramLong));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void fetchRichStatusIfNeed(ArrayList<String> paramArrayList)
  {
    if (!paramArrayList.isEmpty())
    {
      String[] arrayOfString = new String[paramArrayList.size()];
      paramArrayList.toArray(arrayOfString);
      paramArrayList.clear();
      if (this.app.mAutomator.c())
      {
        getRichStatusForFriendList(arrayOfString);
        return;
      }
      this.updateSignatureList = arrayOfString;
    }
  }
  
  public void gatherContacts(short paramShort, List<String> paramList, boolean paramBoolean)
  {
    gatherContacts(paramShort, paramList, paramBoolean, false);
  }
  
  public void gatherContacts(short paramShort, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
  {
    short s;
    if ((paramShort > 0) && (paramList != null))
    {
      if (paramShort != paramList.size()) {
        return;
      }
      try
      {
        localObject1 = new oidb_sso.OIDBSSOPkg();
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1268);
        ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(5);
        if (!paramBoolean1) {
          break label309;
        }
        s = paramShort * 12;
      }
      catch (Exception paramList)
      {
        Object localObject2;
        if (!QLog.isColorLevel()) {
          break label305;
        }
        Object localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("gatherContacts  Exception ");
        ((StringBuilder)localObject1).append(paramList.getMessage());
        QLog.d("FriendListHandler", 2, ((StringBuilder)localObject1).toString());
      }
      localObject2 = ByteBuffer.allocate(s + 2);
      ((ByteBuffer)localObject2).putShort(paramShort);
      s = 0;
    }
    for (;;)
    {
      if (s < paramShort)
      {
        ((ByteBuffer)localObject2).putInt(Utils.a(Long.parseLong((String)paramList.get(s))));
        if (paramBoolean1)
        {
          ((ByteBuffer)localObject2).putShort((short)2);
          ((ByteBuffer)localObject2).putShort((short)4060).put((byte)1).putShort((short)4057).put((byte)0);
        }
        else
        {
          ((ByteBuffer)localObject2).putShort((short)1);
          ((ByteBuffer)localObject2).putShort((short)4060).put((byte)0);
        }
      }
      else
      {
        ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
        localObject2 = createToServiceMsg("OidbSvc.0x4f4_5");
        ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
        ((ToServiceMsg)localObject2).extraData.putBoolean("isGather", paramBoolean1);
        ((ToServiceMsg)localObject2).extraData.putStringArrayList("friendUinList", (ArrayList)paramList);
        ((ToServiceMsg)localObject2).extraData.putBoolean("needNotifyPlugin", paramBoolean2);
        ((ToServiceMsg)localObject2).setTimeout(10000L);
        sendPbReq((ToServiceMsg)localObject2);
        return;
        label305:
        return;
        for (;;)
        {
          break;
          label309:
          s = paramShort * 9;
        }
      }
      s += 1;
    }
  }
  
  public void getAuthLoginDevList(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 4L);
    send(localToServiceMsg);
  }
  
  public void getCheckUpdate(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getCheckUpdate checkFirstTime = ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(",checkUpdateType = ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = createToServiceMsg("ProfileService.CheckUpdateReq");
    ((ToServiceMsg)localObject).addAttribute("CheckUpdateType", Integer.valueOf(paramInt));
    ((ToServiceMsg)localObject).addAttribute("isFirstTime", Boolean.valueOf(paramBoolean));
    send((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("friendlist.getFriendGroupList");
      this.allowCmdSet.add("friendlist.GetLastLoginInfoReq");
      this.allowCmdSet.add("ProfileService.GetRichSig");
      this.allowCmdSet.add("ProfileService.GetSimpleInfo");
      this.allowCmdSet.add("OidbSvc.0xc34_0");
      this.allowCmdSet.add("OidbSvc.0xc34_1");
      this.allowCmdSet.add("OidbSvc.0xc83");
      this.allowCmdSet.add("OidbSvc.0xc85");
      this.allowCmdSet.add("StatSvc.GetDevLoginInfo");
      this.allowCmdSet.add("StatSvc.DelDevLoginInfo");
      this.allowCmdSet.add("StatSvc.SvcReqKikOut");
      this.allowCmdSet.add("StatSvc.BindUin");
      this.allowCmdSet.add("friendlist.MovGroupMemReq");
      this.allowCmdSet.add("BumpSvc.ReqComfirmContactFriend");
      this.allowCmdSet.add("friendlist.GetSimpleOnlineFriendInfoReq");
      this.allowCmdSet.add("friendlist.GetOnlineInfoReq");
      this.allowCmdSet.add("friendlist.delFriend");
      this.allowCmdSet.add("friendlist.SetGroupReq");
      this.allowCmdSet.add("ProfileService.ChangeFriendName");
      this.allowCmdSet.add("ProfileService.SetRichSig");
      this.allowCmdSet.add("StatSvc.register");
      this.allowCmdSet.add("ProfileService.CheckUpdateReq");
      this.allowCmdSet.add("SummaryCard.ReqSearch");
      this.allowCmdSet.add("SummaryCard.ReqCondSearch");
      this.allowCmdSet.add("OidbSvc.0x972_5");
      this.allowCmdSet.add("OidbSvc.0x5d1_0");
      this.allowCmdSet.add("OidbSvc.0x4fc_30");
      this.allowCmdSet.add("DevLockAuthSvc.RecommendAuth");
      this.allowCmdSet.add("DevLockAuthSvc.ConfirmAuth");
      this.allowCmdSet.add("OidbSvc.0x476_146");
      this.allowCmdSet.add("OidbSvc.0x490_107");
      this.allowCmdSet.add("OidbSvc.0x491_107");
      this.allowCmdSet.add("OidbSvc.0x49d_107");
      this.allowCmdSet.add("OidbSvc.0x7c4_0");
      this.allowCmdSet.add("OidbSvc.0x4f4_5");
      this.allowCmdSet.add("OidbSvc.0x7c6_0");
      this.allowCmdSet.add("OidbSvc.0x7c7_0");
      this.allowCmdSet.add("OidbSvc.0x847_3");
      this.allowCmdSet.add("OidbSvc.0x53b_0");
      this.allowCmdSet.add("OidbSvc.0x6c9_0");
      this.allowCmdSet.add("OidbSvc.0x7df_3");
      this.allowCmdSet.add("OidbSvc.0x5d6_7");
      this.allowCmdSet.add("OidbSvc.0x5d6_19");
      this.allowCmdSet.add("OidbSvc.0x5d6_18");
      this.allowCmdSet.add("OidbSvc.0x77c");
      this.allowCmdSet.add("OidbSvc.0x777");
      this.allowCmdSet.add("OidbSvc.0xc26_0");
      this.allowCmdSet.add("OidbSvc.0xc36_0");
      this.allowCmdSet.add("OidbSvc.0xc35_0");
      this.allowCmdSet.add("OidbSvc.0xcf0_0");
      this.allowCmdSet.add("OidbSvc.0xd69");
      this.allowCmdSet.add("OidbSvc.0xd72");
      this.allowCmdSet.add("OidbSvc.0x5d6_21");
      this.allowCmdSet.add("OidbSvc.0xc26_1");
    }
    return this.allowCmdSet;
  }
  
  public void getConnectionsPerson(int paramInt1, int paramInt2, byte[] paramArrayOfByte, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool = QLog.isColorLevel();
    int i = 1;
    Object localObject;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getConnectionsPerson, entryType=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(" tabID=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(" hasCookie=");
      if (paramArrayOfByte != null) {
        bool = true;
      } else {
        bool = false;
      }
      ((StringBuilder)localObject).append(bool);
      ((StringBuilder)localObject).append(" isFirstPage=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("FriendListHandler", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new oidb_0xc26.ReqBody();
      MayknowRecommendManager localMayknowRecommendManager = (MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if ((localMayknowRecommendManager == null) || (!localMayknowRecommendManager.a())) {
        break label309;
      }
      ((oidb_0xc26.ReqBody)localObject).uint32_phone_book.set(1);
      if (!QLog.isColorLevel()) {
        break label309;
      }
      QLog.i("FriendListHandler", 2, "getMayKnowRecommend uint32_phone_book seted");
    }
    catch (Exception paramArrayOfByte)
    {
      if (!QLog.isColorLevel()) {
        break label308;
      }
      QLog.d("FriendListHandler", 2, paramArrayOfByte.toString());
      return;
    }
    QLog.e("FriendListHandler", 1, "getConnectionsPerson, unknown entry type");
    i = -1;
    for (;;)
    {
      ((oidb_0xc26.ReqBody)localObject).em_entry.set(i);
      ((oidb_0xc26.ReqBody)localObject).uint32_tab_id.set(paramInt2);
      ((oidb_0xc26.ReqBody)localObject).uint32_want.set(50);
      if (paramArrayOfByte != null) {
        ((oidb_0xc26.ReqBody)localObject).bytes_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      paramArrayOfByte = makeOIDBPkg("OidbSvc.0xc26_1", 3110, 0, ((oidb_0xc26.ReqBody)localObject).toByteArray());
      paramArrayOfByte.addAttribute("tabID", Integer.valueOf(paramInt2));
      paramArrayOfByte.addAttribute("isFirstPage", Boolean.valueOf(paramBoolean));
      paramArrayOfByte.addAttribute("extra_bd", paramBundle);
      sendPbReq(paramArrayOfByte);
      return;
      label308:
      switch (paramInt1)
      {
      case 1: 
      default: 
        break;
      case 6: 
        i = 6;
        break;
      case 5: 
        i = 5;
        break;
      case 4: 
        i = 4;
        break;
      case 3: 
        i = 3;
        break;
      case 2: 
        label309:
        i = 2;
      }
    }
  }
  
  public void getDongtaiPermission(String paramString, int paramInt)
  {
    Object localObject = new cmd0x7c7.ReqBody();
    ((cmd0x7c7.ReqBody)localObject).uint64_uin.set(Long.valueOf(paramString).longValue());
    if (paramInt == 1)
    {
      ((cmd0x7c7.ReqBody)localObject).uint32_req_not_see_qzone.set(1);
    }
    else if (paramInt == 2)
    {
      ((cmd0x7c7.ReqBody)localObject).uint32_req_prevent_dynamic.set(1);
    }
    else if (paramInt == 3)
    {
      ((cmd0x7c7.ReqBody)localObject).uint32_req_not_see_qzone.set(1);
      ((cmd0x7c7.ReqBody)localObject).uint32_req_prevent_dynamic.set(1);
    }
    paramString = new oidb_sso.OIDBSSOPkg();
    paramString.uint32_command.set(1991);
    paramString.uint32_result.set(0);
    paramString.uint32_service_type.set(0);
    paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c7.ReqBody)localObject).toByteArray()));
    localObject = createToServiceMsg("OidbSvc.0x7c7_0");
    ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
    if (paramInt == 1) {
      ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 1);
    } else if (paramInt == 2) {
      ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 2);
    } else if (paramInt == 3) {
      ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 3);
    }
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void getFriendDetailInfo(String paramString)
  {
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestFriendInfo(paramString);
  }
  
  public void getFriendGroupList(boolean paramBoolean)
  {
    getFriendGroupList(paramBoolean, false);
  }
  
  public void getFriendGroupList(boolean paramBoolean1, boolean paramBoolean2)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getFriendGroupList| refresh: ");
        localStringBuilder.append(paramBoolean1);
        QLog.d("FriendListHandler", 2, localStringBuilder.toString());
      }
      if (!paramBoolean1)
      {
        if (((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).c())
        {
          notifyUI(1, true, null);
          return;
        }
        return;
      }
      ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestFriendList(paramBoolean2);
      return;
    }
    finally {}
  }
  
  public void getFriendInfo(String paramString)
  {
    getFriendInfo(paramString, false);
  }
  
  public void getFriendInfo(String paramString, boolean paramBoolean)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("uin = ");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("FetchInfoListManager", 2, ((StringBuilder)localObject).toString());
    }
    if ((Friends.isValidUin(paramString)) && (isNeedSendGetFriendInfo(paramString)))
    {
      localObject = new ArrayList(1);
      ((ArrayList)localObject).add(paramString);
      ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.GetSimpleInfo");
      localToServiceMsg.extraData.putStringArrayList("uinList", (ArrayList)localObject);
      localToServiceMsg.extraData.putBoolean("reqSelfLevel", shouldReqLevel(paramString));
      localToServiceMsg.extraData.putBoolean("reqXMan", shouldReqXMan(paramString));
      localToServiceMsg.extraData.putBoolean("reqDateNick", paramBoolean);
      send(localToServiceMsg);
    }
  }
  
  public void getFriendInfoBatch(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList != null) && (!paramArrayList.isEmpty()))
    {
      Object localObject1 = this.app;
      if (localObject1 != null)
      {
        Object localObject2 = ((QQAppInterface)localObject1).getCurrentAccountUin();
        int i = paramArrayList.size() - 1;
        localObject1 = "";
        while (i >= 0)
        {
          String str = (String)paramArrayList.get(i);
          if ((str != null) && (str.length() != 0) && (Friends.isValidUin(str)) && (isNeedSendGetFriendInfo(str)))
          {
            if (str.equals(localObject2)) {
              localObject1 = localObject2;
            }
          }
          else {
            paramArrayList.remove(i);
          }
          i -= 1;
        }
        if (paramArrayList.isEmpty())
        {
          if (QLog.isColorLevel()) {
            QLog.i("FriendListHandler", 2, "getFriendInfoBatch uinList is empty");
          }
          return;
        }
        if (QLog.isDevelopLevel()) {
          QLog.i("FriendListHandler", 4, String.format(Locale.getDefault(), "getFriendInfoBatch size: %d, friendUin: %s", new Object[] { Integer.valueOf(paramArrayList.size()), localObject1 }));
        }
        localObject2 = createToServiceMsg("ProfileService.GetSimpleInfo");
        ((ToServiceMsg)localObject2).extraData.putStringArrayList("uinList", paramArrayList);
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqSelfLevel", shouldReqLevel((String)localObject1));
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqXMan", shouldReqXMan((String)localObject1));
        ((ToServiceMsg)localObject2).extraData.putBoolean("reqDateNick", paramBoolean);
        ((ToServiceMsg)localObject2).extraData.putBoolean("batch_data", true);
        send((ToServiceMsg)localObject2);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getFriendInfoBatch uinList is empty or app is null");
    }
  }
  
  public boolean getFriendNickByBatch(ArrayList<String> paramArrayList)
  {
    short s2 = 0;
    if (paramArrayList != null)
    {
      if (paramArrayList.size() == 0) {
        return false;
      }
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("getFriendNickByBatch|uinsize = ");
        ((StringBuilder)localObject1).append(paramArrayList.size());
        ((StringBuilder)localObject1).append(" time=");
        ((StringBuilder)localObject1).append(System.currentTimeMillis());
        QLog.d("FriendListHandler", 2, ((StringBuilder)localObject1).toString());
      }
      short s1 = (short)paramArrayList.size();
      if (s1 > 500) {
        return false;
      }
      Object localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1181);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(107);
      Object localObject2 = ByteBuffer.allocate(s1 * 4 + 7);
      ((ByteBuffer)localObject2).put((byte)0).putShort((short)1).putShort(this.shBatchSeqTypeField).putShort(s1);
      while (s2 < s1)
      {
        try
        {
          ((ByteBuffer)localObject2).putInt(Utils.a(Long.parseLong((String)paramArrayList.get(s2))));
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("getFriendNickByBatch parseLong err uin=");
            localStringBuilder.append((String)paramArrayList.get(s2));
            QLog.d("FriendListHandler", 2, localStringBuilder.toString(), localException);
          }
        }
        s2 = (short)(s2 + 1);
      }
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject2).array()));
      localObject2 = createToServiceMsg("OidbSvc.0x49d_107");
      ((ToServiceMsg)localObject2).extraData.putStringArrayList("batchuin", paramArrayList);
      ((ToServiceMsg)localObject2).extraData.putShort("uincount", s1);
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      ((ToServiceMsg)localObject2).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject2);
      return true;
    }
    return false;
  }
  
  public void getFriendsHasBindPhone(int paramInt)
  {
    Object localObject = new cmd0xcf0.ReqBody();
    ((cmd0xcf0.ReqBody)localObject).uint32_expect_bind_contacts_frd_num.set(paramInt);
    sendPbReq(makeOIDBPkg("OidbSvc.0xcf0_0", 3312, 0, ((cmd0xcf0.ReqBody)localObject).toByteArray()));
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getFriendsHasBindPhone :");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("FriendListHandler", 2, ((StringBuilder)localObject).toString());
    }
  }
  
  public void getFriendsInfo(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length < 1) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      int k = paramArrayOfString.length;
      int j = 0;
      int i = 0;
      while (i < k)
      {
        String str = paramArrayOfString[i];
        if ((!TextUtils.isEmpty(str)) && (Friends.isValidUin(str)) && (isNeedSendGetFriendInfo(str))) {
          localArrayList.add(str);
        }
        i += 1;
      }
      if (localArrayList.size() < 1) {
        return;
      }
      paramArrayOfString = new String[localArrayList.size()];
      k = localArrayList.size();
      i = j;
      while (i < k)
      {
        paramArrayOfString[i] = ((String)localArrayList.get(i));
        i += 1;
      }
      getRichStatus(paramArrayOfString);
      paramArrayOfString = createToServiceMsg("ProfileService.GetSimpleInfo");
      paramArrayOfString.extraData.putStringArrayList("uinList", localArrayList);
      paramArrayOfString.extraData.putBoolean("batch_data", true);
      send(paramArrayOfString);
    }
  }
  
  public void getGatheredContactsList(int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("OidbSvc.0x7c4_0");
    localToServiceMsg.extraData.putInt("startIndex", paramInt);
    cmd0x7c4.ReqBody localReqBody = new cmd0x7c4.ReqBody();
    Object localObject2 = this.app.getAccount();
    Object localObject1 = new cmd0x7c4.GetSNFrdListReq();
    ((cmd0x7c4.GetSNFrdListReq)localObject1).uint64_uin.set(Long.parseLong((String)localObject2));
    int i = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
    ((cmd0x7c4.GetSNFrdListReq)localObject1).uint32_sequence.set(i);
    ((cmd0x7c4.GetSNFrdListReq)localObject1).uint32_start_idx.set(paramInt);
    ((cmd0x7c4.GetSNFrdListReq)localObject1).uint32_req_num.set(MAX_COUNT_REQ_GETHER_MEMBER);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("FriendListHandler getGatheredContactsList(). startIndex = ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" | seq = ");
      ((StringBuilder)localObject2).append(i);
      QLog.i("FriendListHandler", 2, ((StringBuilder)localObject2).toString());
    }
    localReqBody.msg_get_sn_frd_list_req.set((MessageMicro)localObject1);
    localReqBody.uint32_client_ver.set(2);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1988);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localReqBody.toByteArray()));
    localToServiceMsg.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    localToServiceMsg.setTimeout(30000L);
    sendPbReq(localToServiceMsg);
  }
  
  public void getLastLoginInfo(long paramLong1, long paramLong2, long paramLong3)
  {
    long l = Long.parseLong(this.app.getCurrentAccountUin());
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetLastLoginInfoReq");
    localToServiceMsg.extraData.putLong("uin", l);
    localToServiceMsg.extraData.putLong("total_req_times", paramLong1);
    localToServiceMsg.extraData.putLong("current_req_index", paramLong2);
    localToServiceMsg.extraData.putLong("current_req_uin", paramLong3);
    send(localToServiceMsg);
  }
  
  public boolean getLastLoginInfo()
  {
    if (this.app.getCurrentAccountUin() == null) {
      return false;
    }
    boolean bool = ContactConfig.b(this.app.getApp().getApplicationContext(), this.app.getAccount());
    if (bool) {
      getLastLoginInfo(0L, 0L, 0L);
    }
    return bool;
  }
  
  public void getLoginDevList(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 1L);
    send(localToServiceMsg);
  }
  
  public boolean getMayKnowRecommend(List<Long> paramList1, List<Long> paramList2, int paramInt, Bundle paramBundle)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getMayKnowRecommend, filterUins=");
      if (paramList1 != null) {
        localObject = paramList1;
      } else {
        localObject = "";
      }
      localStringBuilder.append(localObject);
      localStringBuilder.append(", entryType=");
      localStringBuilder.append(paramInt);
      QLog.i("FriendListHandler", 2, localStringBuilder.toString());
    }
    try
    {
      localObject = new oidb_0xc26.ReqBody();
      if (paramList1 != null) {
        ((oidb_0xc26.ReqBody)localObject).rpt_filter_uins.set(paramList1);
      }
      paramList1 = (MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
      if ((paramList1 == null) || (!paramList1.a())) {
        break label267;
      }
      ((oidb_0xc26.ReqBody)localObject).uint32_phone_book.set(1);
      if (!QLog.isColorLevel()) {
        break label267;
      }
      QLog.i("FriendListHandler", 2, "getMayKnowRecommend uint32_phone_book seted");
    }
    catch (Exception paramList1)
    {
      if (!QLog.isColorLevel()) {
        break label265;
      }
      QLog.d("FriendListHandler", 2, paramList1, new Object[0]);
      return true;
    }
    QLog.e("FriendListHandler", 1, "getMayKnowRecommend, unknown entry type");
    int i;
    paramInt = i;
    for (;;)
    {
      ((oidb_0xc26.ReqBody)localObject).em_entry.set(paramInt);
      ((oidb_0xc26.ReqBody)localObject).uint32_fetch_rgroup.set(1);
      if (paramList2 != null) {
        ((oidb_0xc26.ReqBody)localObject).rpt_expected_uins.set(paramList2);
      }
      ((oidb_0xc26.ReqBody)localObject).uint32_tab_id.set(23);
      ((oidb_0xc26.ReqBody)localObject).uint32_want.set(50);
      paramList1 = makeOIDBPkg("OidbSvc.0xc26_0", 3110, 0, ((oidb_0xc26.ReqBody)localObject).toByteArray());
      paramList1.extraData.putBundle("EXTRA:OidbSvc.0xc26_0", paramBundle);
      sendPbReq(paramList1);
      return true;
      label265:
      label267:
      i = -1;
      switch (paramInt)
      {
      default: 
        break;
      case 6: 
        paramInt = 6;
        break;
      case 5: 
        paramInt = 5;
        break;
      case 4: 
        paramInt = 4;
        break;
      case 3: 
        paramInt = 3;
        break;
      case 2: 
        paramInt = 2;
        break;
      case 1: 
        paramInt = 1;
      }
    }
  }
  
  public void getMultiClientList(long paramLong, String paramString)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", 0L);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    send(localToServiceMsg);
  }
  
  public String getOfflineTipsConfig(long paramLong)
  {
    if (this.mOfflineTips == null)
    {
      localObject1 = this.app.getServerConfigValue(ServerConfigManager.ConfigType.app, "offlineTips");
      if ((localObject1 != null) && (((String)localObject1).length() > 0)) {
        this.mOfflineTips = new HashMap();
      }
    }
    try
    {
      localObject1 = ((String)localObject1).split(";");
      int j = localObject1.length;
      int i = 0;
      while (i < j)
      {
        localObject2 = localObject1[i].split(":");
        long l = Long.parseLong(localObject2[0]);
        localObject2 = localObject2[1];
        this.mOfflineTips.put(Long.valueOf(l), localObject2);
        i += 1;
      }
    }
    catch (Exception localException)
    {
      Object localObject2;
      label118:
      break label118;
    }
    Object localObject1 = null;
    localObject2 = this.mOfflineTips;
    if (localObject2 != null) {
      localObject1 = (String)((HashMap)localObject2).get(Long.valueOf(paramLong));
    }
    return localObject1;
  }
  
  public void getOnlineFriend(String paramString, byte paramByte)
  {
    if ((paramByte != 0) && (isGetOnlineListRecently())) {
      return;
    }
    this.getOnlineFriendLastTimeStamp = System.currentTimeMillis();
    paramString = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetSimpleOnlineFriendInfoReq");
    paramString.extraData.putLong("startTime", System.currentTimeMillis());
    paramString.setTimeout(120000L);
    paramString.extraData.putByte("ifShowTermType", (byte)1);
    paramString.extraData.putByte("srcType", paramByte);
    send(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("getOnlineFriend", 2, "send getOnlineFriend");
    }
  }
  
  public void getOnlineInfo(String paramString, boolean paramBoolean)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetOnlineInfoReq");
    if (paramBoolean)
    {
      localToServiceMsg.extraData.putLong("dwReqType", 1L);
      localToServiceMsg.extraData.putString("strMobile", paramString);
    }
    else
    {
      localToServiceMsg.extraData.putLong("dwReqType", 0L);
      localToServiceMsg.extraData.putLong("dwUin", CharacterUtil.a(paramString));
    }
    localToServiceMsg.setTimeout(15000L);
    send(localToServiceMsg);
  }
  
  public void getRecentLoginDevList(long paramLong1, String paramString, long paramLong2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.GetDevLoginInfo");
    localToServiceMsg.extraData.putLong("iLoginType", 1L);
    localToServiceMsg.extraData.putLong("iNextItemIndex", paramLong2);
    localToServiceMsg.extraData.putLong("iRequireMax", 20L);
    localToServiceMsg.extraData.putLong("iTimeStamp", paramLong1);
    localToServiceMsg.extraData.putString("strAppName", paramString);
    localToServiceMsg.extraData.putByteArray("vecGuid", NetConnInfoCenter.GUID);
    localToServiceMsg.extraData.putLong("iGetDevListType", 2L);
    send(localToServiceMsg);
  }
  
  public void getRecommandAuthDeviceList(long paramLong, String paramString, int paramInt)
  {
    device_lock_recommend_auth.ReqBody localReqBody = new device_lock_recommend_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.app.getAppid());
    localReqBody.uint32_subappid.set(paramInt);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    localReqBody.uint32_seq.set(1);
    paramString = createToServiceMsg("DevLockAuthSvc.RecommendAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    sendPbReq(paramString);
  }
  
  public ArrayList<oidb_0x7df.FriendScore> getRecommendList()
  {
    synchronized (this.mRecommendLock)
    {
      ArrayList localArrayList = this.mRecommendList;
      return localArrayList;
    }
  }
  
  public void getRichStatus(String[] paramArrayOfString)
  {
    doGetRichStatus(paramArrayOfString, 0, 0, null, false);
  }
  
  public void getRichStatusForFriendList(String[] paramArrayOfString)
  {
    doGetRichStatus(paramArrayOfString, 0, 3, null, false);
    this.isSyncingAllFriendsRichStatus = true;
  }
  
  public void getSelfXManInfo()
  {
    String str = this.app.getCurrentAccountUin();
    if ((!TextUtils.isEmpty(str)) && (shouldReqXMan(str))) {
      getFriendInfo(str);
    }
  }
  
  public void getSelfXManInfoScene2()
  {
    Object localObject = this.app.getCurrentAccountUin();
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (shouldReqXManScene2((String)localObject)) && (Friends.isValidUin((String)localObject)) && (isNeedSendGetFriendInfo((String)localObject)))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(localObject);
      localObject = createToServiceMsg("ProfileService.GetSimpleInfo");
      ((ToServiceMsg)localObject).extraData.putStringArrayList("uinList", localArrayList);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqSelfLevel", false);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqXMan", true);
      ((ToServiceMsg)localObject).extraData.putBoolean("reqDateNick", false);
      ((ToServiceMsg)localObject).extraData.putInt("getXManInfoScene", 2);
      send((ToServiceMsg)localObject);
    }
  }
  
  public boolean getShowPcOnlineIconConfig()
  {
    i = this.mShowPcIcon;
    boolean bool = false;
    if (i == -1) {}
    try
    {
      if (!ContactConfig.a(this.app.getApp().getApplicationContext(), this.app.getAccount())) {
        break label69;
      }
      i = 1;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        continue;
        i = 0;
      }
    }
    this.mShowPcIcon = i;
    break label53;
    this.mShowPcIcon = 0;
    label53:
    if (this.mShowPcIcon == 1) {
      bool = true;
    }
    return bool;
  }
  
  public boolean getSpecialCareRecommend(int paramInt1, int paramInt2, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge Z and I\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void getStrangerInfo(long[] paramArrayOfLong, int[] paramArrayOfInt)
  {
    if (paramArrayOfLong != null)
    {
      if (paramArrayOfInt == null) {
        return;
      }
      int k = paramArrayOfLong.length;
      ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfInt.length * 2 + 4 + k * 4);
      localByteBuffer.putShort((short)paramArrayOfInt.length);
      int j = 0;
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        localByteBuffer.putShort((short)paramArrayOfInt[i]);
        i += 1;
      }
      localByteBuffer.putShort((short)k);
      i = j;
      while (i < k)
      {
        localByteBuffer.putInt(Utils.a(paramArrayOfLong[i]));
        i += 1;
      }
      paramArrayOfLong = new oidb_sso.OIDBSSOPkg();
      paramArrayOfLong.uint32_command.set(1276);
      paramArrayOfLong.uint32_service_type.set(30);
      paramArrayOfLong.bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
      paramArrayOfInt = createToServiceMsg("OidbSvc.0x4fc_30");
      paramArrayOfInt.putWupBuffer(paramArrayOfLong.toByteArray());
      paramArrayOfInt.setTimeout(10000L);
      sendPbReq(paramArrayOfInt);
    }
  }
  
  public void getStrangerInfo(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = paramArrayOfString.length;
    long[] arrayOfLong = new long[j];
    int i = 0;
    while (i < j)
    {
      try
      {
        arrayOfLong[i] = Long.parseLong(paramArrayOfString[i]);
      }
      catch (NumberFormatException localNumberFormatException)
      {
        label31:
        break label31;
      }
      arrayOfLong[i] = 0L;
      i += 1;
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0)) {
      getStrangerInfo(arrayOfLong, paramArrayOfInt);
    }
  }
  
  public void getStrangerRichStatus(String[] paramArrayOfString, boolean paramBoolean)
  {
    doGetRichStatus(paramArrayOfString, 0, 2, null, paramBoolean);
  }
  
  public void getSuspiciousFriendsUnreadNum()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getSuspiciousFriendsUnreadNum");
    }
    Object localObject = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject).cmd_type.set(2);
    localObject = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("cmd", Integer.valueOf(2));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void getSuspiciousMsgList(int paramInt, byte[] paramArrayOfByte, Object paramObject)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("getSuspiciousMsgList ");
      ((StringBuilder)localObject2).append(paramInt);
      ((StringBuilder)localObject2).append(" ");
      if (paramArrayOfByte == null) {
        localObject1 = " no cookie ";
      } else {
        localObject1 = " has cookie ";
      }
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(paramObject);
      QLog.i("FriendListHandler", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject1 = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject1).cmd_type.set(1);
    Object localObject2 = new oidb_cmd0xd69.GetListReqBody();
    ((oidb_cmd0xd69.GetListReqBody)localObject2).req_num.set(paramInt);
    if (paramArrayOfByte != null) {
      ((oidb_cmd0xd69.GetListReqBody)localObject2).bytes_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    ((oidb_cmd0xd69.ReqBody)localObject1).msg_get_list_body.set((MessageMicro)localObject2);
    paramArrayOfByte = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject1).toByteArray());
    paramArrayOfByte.addAttribute("cmd", Integer.valueOf(1));
    paramArrayOfByte.addAttribute("exactData", paramObject);
    sendPbReq(paramArrayOfByte);
  }
  
  public VasFaceManager getVaseFaceManager()
  {
    return ((VasExtensionManager)this.app.getManager(QQManagerFactory.VAS_EXTENSION_MANAGER)).a;
  }
  
  public void getVisibilityForNetWorkStatus()
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1168);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(4);
    ((ByteBuffer)localObject).putInt((int)Long.parseLong(this.app.getCurrentAccountUin()));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x490_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void handleAddBatchQIMFriends(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.QIM", 2, "handleAddBatchQIMFriends");
    }
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000))
    {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
        paramToServiceMsg = paramFromServiceMsg;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
      }
      if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
      {
        paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
        paramFromServiceMsg = new cmd0xaed.RspBody();
        try
        {
          paramFromServiceMsg.mergeFrom(paramToServiceMsg);
          paramToServiceMsg = paramFromServiceMsg.rpt_uint64_succ_qim_uins.get();
          if (QLog.isColorLevel())
          {
            paramFromServiceMsg = new StringBuilder("handleAddBatchQIMFriends success ");
            paramObject = paramToServiceMsg.iterator();
            while (paramObject.hasNext())
            {
              Long localLong = (Long)paramObject.next();
              paramFromServiceMsg.append(", ");
              paramFromServiceMsg.append(localLong);
            }
            QLog.d("FriendListHandler.QIM", 2, paramFromServiceMsg.toString());
          }
          notifyUI(108, false, paramToServiceMsg);
          return;
        }
        catch (InvalidProtocolBufferMicroException paramToServiceMsg)
        {
          paramToServiceMsg.printStackTrace();
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler.QIM", 2, "handleAddBatchQIMFriends false ");
    }
    notifyUI(108, false, null);
  }
  
  public void handleCheckUpdate(CheckUpdateResp paramCheckUpdateResp)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("FriendListHandler, handleCheckUpdate, ");
    int i;
    if (paramCheckUpdateResp != null) {
      i = paramCheckUpdateResp.result;
    } else {
      i = -1;
    }
    ((StringBuilder)localObject1).append(i);
    QLog.i("ProfileService.CheckUpdateReq", 1, ((StringBuilder)localObject1).toString());
    if ((paramCheckUpdateResp != null) && (paramCheckUpdateResp.result == 0))
    {
      Iterator localIterator = paramCheckUpdateResp.vecResPkg.iterator();
      paramCheckUpdateResp = null;
      localObject1 = null;
      while (localIterator.hasNext())
      {
        RespItem localRespItem = (RespItem)localIterator.next();
        if (localRespItem != null)
        {
          if (QLog.isColorLevel())
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("FriendListHandler::handleCheckUpdate item eServiceId = ");
            ((StringBuilder)localObject2).append(localRespItem.eServiceID);
            ((StringBuilder)localObject2).append(",result=");
            ((StringBuilder)localObject2).append(localRespItem.cResult);
            QLog.d("ProfileService.CheckUpdateReq", 2, ((StringBuilder)localObject2).toString());
          }
          Object localObject2 = this.app.mAutomator.a(localRespItem.eServiceID);
          if (localRespItem.eServiceID == 101)
          {
            localObject1 = localRespItem;
            paramCheckUpdateResp = (CheckUpdateResp)localObject2;
          }
          else
          {
            handleCheckUpdateItem((CheckUpdateItemInterface)localObject2, localRespItem);
          }
        }
      }
      handleCheckUpdateItem(paramCheckUpdateResp, (RespItem)localObject1);
    }
    this.app.mAutomator.a();
  }
  
  public void handleDelGroupResp(DelGroupResp paramDelGroupResp, boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if (paramBoolean) {
      localFriendsManager.a(paramDelGroupResp.cGroupid);
    }
    notifyUI(21, paramBoolean, paramGroupActionResp);
  }
  
  /* Error */
  public void handleFriendInfo(ToServiceMsg paramToServiceMsg, ArrayList<String> paramArrayList, FromServiceMsg paramFromServiceMsg, ArrayList<KQQ.ProfSmpInfoRes> paramArrayList1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 245	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: getstatic 550	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   7: invokevirtual 554	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10: checkcast 556	com/tencent/mobileqq/app/FriendsManager
    //   13: astore 13
    //   15: aload 13
    //   17: invokevirtual 2500	com/tencent/mobileqq/app/FriendsManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   20: astore 11
    //   22: new 196	java/util/ArrayList
    //   25: dup
    //   26: invokespecial 198	java/util/ArrayList:<init>	()V
    //   29: astore_3
    //   30: new 196	java/util/ArrayList
    //   33: dup
    //   34: invokespecial 198	java/util/ArrayList:<init>	()V
    //   37: astore 12
    //   39: aload_3
    //   40: astore 10
    //   42: aload 11
    //   44: invokevirtual 2505	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   47: aload_3
    //   48: astore 10
    //   50: aload 4
    //   52: invokevirtual 565	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   55: astore 14
    //   57: aload_3
    //   58: astore 10
    //   60: aload 14
    //   62: invokeinterface 396 1 0
    //   67: ifeq +433 -> 500
    //   70: aload_3
    //   71: astore 10
    //   73: aload 14
    //   75: invokeinterface 400 1 0
    //   80: checkcast 2507	KQQ/ProfSmpInfoRes
    //   83: astore 15
    //   85: aload_3
    //   86: astore 10
    //   88: aload 15
    //   90: getfield 2509	KQQ/ProfSmpInfoRes:dwUin	J
    //   93: invokestatic 274	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   96: astore 16
    //   98: aload_3
    //   99: astore 10
    //   101: aload_2
    //   102: aload 16
    //   104: invokevirtual 2512	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   107: ifne +6 -> 113
    //   110: goto -53 -> 57
    //   113: aload_3
    //   114: astore 10
    //   116: aload 15
    //   118: aload 16
    //   120: aload_0
    //   121: getfield 245	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   124: invokevirtual 1135	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   127: invokevirtual 1137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: aload_0
    //   131: getfield 245	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   134: aload 16
    //   136: invokestatic 2515	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:a	(LKQQ/ProfSmpInfoRes;ZLcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   139: aload_3
    //   140: astore 10
    //   142: aload 15
    //   144: getfield 2518	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   147: ifge +24 -> 171
    //   150: aload_3
    //   151: astore 10
    //   153: ldc 128
    //   155: iconst_1
    //   156: ldc_w 2520
    //   159: invokestatic 324	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   162: aload_3
    //   163: astore 10
    //   165: aload 15
    //   167: iconst_0
    //   168: putfield 2518	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   171: aload_3
    //   172: astore 10
    //   174: aload 15
    //   176: getfield 2518	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   179: invokestatic 2521	com/tencent/biz/eqq/CrmUtils:a	(I)Z
    //   182: ifne +17 -> 199
    //   185: aload_3
    //   186: astore 10
    //   188: aload 15
    //   190: getfield 2518	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   193: invokestatic 2523	com/tencent/qidian/QidianManager:b	(I)Z
    //   196: ifeq +33 -> 229
    //   199: aload_3
    //   200: astore 10
    //   202: aload_3
    //   203: aload 16
    //   205: invokeinterface 407 2 0
    //   210: pop
    //   211: aload_3
    //   212: astore 10
    //   214: aload 15
    //   216: getfield 2518	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   219: invokestatic 2521	com/tencent/biz/eqq/CrmUtils:a	(I)Z
    //   222: aload_0
    //   223: getfield 245	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   226: invokestatic 1358	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:a	(ZLcom/tencent/mobileqq/app/QQAppInterface;)V
    //   229: aload_3
    //   230: astore 10
    //   232: aload 15
    //   234: getfield 2509	KQQ/ProfSmpInfoRes:dwUin	J
    //   237: lstore 8
    //   239: aload_3
    //   240: astore 10
    //   242: aload 15
    //   244: getfield 2526	KQQ/ProfSmpInfoRes:strNick	Ljava/lang/String;
    //   247: astore 17
    //   249: aload_3
    //   250: astore 10
    //   252: aload 15
    //   254: getfield 2518	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   257: istore 5
    //   259: aload_3
    //   260: astore 10
    //   262: aload 15
    //   264: getfield 2529	KQQ/ProfSmpInfoRes:cSex	B
    //   267: i2s
    //   268: istore 7
    //   270: aload_3
    //   271: astore 10
    //   273: aload 15
    //   275: getfield 2532	KQQ/ProfSmpInfoRes:wAge	B
    //   278: istore 6
    //   280: aload 13
    //   282: lload 8
    //   284: invokestatic 274	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   287: aload 17
    //   289: iload 5
    //   291: iload 7
    //   293: iload 6
    //   295: invokevirtual 2535	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;Ljava/lang/String;BSB)V
    //   298: aload 13
    //   300: aload 16
    //   302: invokevirtual 1144	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   305: astore 10
    //   307: aload_0
    //   308: getfield 245	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   311: aload 15
    //   313: aload 10
    //   315: aload 16
    //   317: aload_2
    //   318: invokestatic 2538	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;LKQQ/ProfSmpInfoRes;Lcom/tencent/mobileqq/data/Card;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   321: invokestatic 304	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   324: ifeq +126 -> 450
    //   327: new 2540	java/lang/StringBuffer
    //   330: dup
    //   331: sipush 200
    //   334: invokespecial 2541	java/lang/StringBuffer:<init>	(I)V
    //   337: astore 17
    //   339: aload 17
    //   341: ldc_w 2543
    //   344: invokevirtual 2546	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   347: pop
    //   348: aload 17
    //   350: aload 15
    //   352: getfield 2549	KQQ/ProfSmpInfoRes:isShowXMan	I
    //   355: invokevirtual 2552	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   358: pop
    //   359: aload 17
    //   361: ldc_w 2554
    //   364: invokevirtual 2546	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   367: pop
    //   368: aload 17
    //   370: aload 15
    //   372: getfield 2557	KQQ/ProfSmpInfoRes:dwLoginDay	J
    //   375: invokevirtual 2560	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   378: pop
    //   379: aload 17
    //   381: ldc_w 2562
    //   384: invokevirtual 2546	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   387: pop
    //   388: aload 17
    //   390: aload 15
    //   392: getfield 2565	KQQ/ProfSmpInfoRes:dwPhoneQQXManDay	J
    //   395: invokevirtual 2560	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   398: pop
    //   399: aload 17
    //   401: ldc_w 2567
    //   404: invokevirtual 2546	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   407: pop
    //   408: aload 17
    //   410: aload 10
    //   412: getfield 2570	com/tencent/mobileqq/data/Card:allowClick	Z
    //   415: invokevirtual 2573	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   418: pop
    //   419: aload 17
    //   421: ldc_w 2575
    //   424: invokevirtual 2546	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   427: pop
    //   428: aload 17
    //   430: aload 10
    //   432: getfield 2578	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   435: invokevirtual 2573	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   438: pop
    //   439: ldc 128
    //   441: iconst_2
    //   442: aload 17
    //   444: invokevirtual 2579	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   447: invokestatic 340	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   450: aload 13
    //   452: aload 10
    //   454: invokevirtual 2582	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   457: pop
    //   458: aload_0
    //   459: aload_1
    //   460: aload 15
    //   462: aload 12
    //   464: aload 16
    //   466: invokestatic 2585	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:a	(Lcom/tencent/mobileqq/app/FriendListHandler;Lcom/tencent/qphone/base/remote/ToServiceMsg;LKQQ/ProfSmpInfoRes;Ljava/util/List;Ljava/lang/String;)V
    //   469: aload_0
    //   470: getfield 245	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   473: aload_1
    //   474: aload 15
    //   476: invokestatic 2588	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/qphone/base/remote/ToServiceMsg;LKQQ/ProfSmpInfoRes;)V
    //   479: aload_0
    //   480: getfield 245	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   483: aload_1
    //   484: aload 15
    //   486: invokestatic 2590	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/qphone/base/remote/ToServiceMsg;LKQQ/ProfSmpInfoRes;)V
    //   489: aload_0
    //   490: iconst_3
    //   491: iconst_1
    //   492: aload 16
    //   494: invokevirtual 634	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   497: goto -440 -> 57
    //   500: aload_3
    //   501: astore_2
    //   502: aload 11
    //   504: invokevirtual 2592	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   507: aload_2
    //   508: astore_3
    //   509: aload 11
    //   511: ifnull +50 -> 561
    //   514: goto +40 -> 554
    //   517: aload_3
    //   518: astore_2
    //   519: astore_3
    //   520: goto +11 -> 531
    //   523: astore_1
    //   524: goto +77 -> 601
    //   527: astore_3
    //   528: aload 10
    //   530: astore_2
    //   531: invokestatic 304	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   534: ifeq +13 -> 547
    //   537: ldc 128
    //   539: iconst_2
    //   540: ldc_w 2594
    //   543: aload_3
    //   544: invokestatic 2596	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   547: aload_2
    //   548: astore_3
    //   549: aload 11
    //   551: ifnull +10 -> 561
    //   554: aload 11
    //   556: invokevirtual 2599	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   559: aload_2
    //   560: astore_3
    //   561: aload_0
    //   562: getfield 245	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   565: aload_3
    //   566: invokestatic 2602	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   569: aload_0
    //   570: getfield 245	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   573: aload 12
    //   575: invokestatic 2604	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   578: aload_1
    //   579: getfield 449	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   582: ldc_w 2203
    //   585: invokevirtual 1129	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   588: ifeq +12 -> 600
    //   591: aload_0
    //   592: bipush 66
    //   594: iconst_1
    //   595: aload 4
    //   597: invokevirtual 634	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   600: return
    //   601: aload 11
    //   603: ifnull +8 -> 611
    //   606: aload 11
    //   608: invokevirtual 2599	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   611: goto +5 -> 616
    //   614: aload_1
    //   615: athrow
    //   616: goto -2 -> 614
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	619	0	this	FriendListHandler
    //   0	619	1	paramToServiceMsg	ToServiceMsg
    //   0	619	2	paramArrayList	ArrayList<String>
    //   0	619	3	paramFromServiceMsg	FromServiceMsg
    //   0	619	4	paramArrayList1	ArrayList<KQQ.ProfSmpInfoRes>
    //   257	33	5	b1	byte
    //   278	16	6	b2	byte
    //   268	24	7	s	short
    //   237	46	8	l	long
    //   40	489	10	localObject1	Object
    //   20	587	11	localEntityTransaction	com.tencent.mobileqq.persistence.EntityTransaction
    //   37	537	12	localArrayList	ArrayList
    //   13	438	13	localFriendsManager	FriendsManager
    //   55	19	14	localIterator	Iterator
    //   83	402	15	localProfSmpInfoRes	KQQ.ProfSmpInfoRes
    //   96	397	16	str	String
    //   247	196	17	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   280	450	517	java/lang/Exception
    //   450	497	517	java/lang/Exception
    //   502	507	517	java/lang/Exception
    //   42	47	523	finally
    //   50	57	523	finally
    //   60	70	523	finally
    //   73	85	523	finally
    //   88	98	523	finally
    //   101	110	523	finally
    //   116	139	523	finally
    //   142	150	523	finally
    //   153	162	523	finally
    //   165	171	523	finally
    //   174	185	523	finally
    //   188	199	523	finally
    //   202	211	523	finally
    //   214	229	523	finally
    //   232	239	523	finally
    //   242	249	523	finally
    //   252	259	523	finally
    //   262	270	523	finally
    //   273	280	523	finally
    //   280	450	523	finally
    //   450	497	523	finally
    //   502	507	523	finally
    //   531	547	523	finally
    //   42	47	527	java/lang/Exception
    //   50	57	527	java/lang/Exception
    //   60	70	527	java/lang/Exception
    //   73	85	527	java/lang/Exception
    //   88	98	527	java/lang/Exception
    //   101	110	527	java/lang/Exception
    //   116	139	527	java/lang/Exception
    //   142	150	527	java/lang/Exception
    //   153	162	527	java/lang/Exception
    //   165	171	527	java/lang/Exception
    //   174	185	527	java/lang/Exception
    //   188	199	527	java/lang/Exception
    //   202	211	527	java/lang/Exception
    //   214	229	527	java/lang/Exception
    //   232	239	527	java/lang/Exception
    //   242	249	527	java/lang/Exception
    //   252	259	527	java/lang/Exception
    //   262	270	527	java/lang/Exception
    //   273	280	527	java/lang/Exception
  }
  
  public <T> void handleMayKnowRecommendPush(int paramInt, List<T> paramList)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleMayKnowRecommendPush: ");
      localStringBuilder.append(paramList);
      localStringBuilder.append(", opType: ");
      localStringBuilder.append(paramInt);
      QLog.d("FriendListHandler", 2, localStringBuilder.toString());
    }
    if (paramInt != 0)
    {
      if (paramInt == 1) {
        break label136;
      }
      if (paramInt != 2) {
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "decodePush0x210_0x111, do del mayknow list");
      }
      try
      {
        notifyUI(112, ((MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b(true, paramList), paramList);
        return;
      }
      catch (Throwable paramList)
      {
        QLog.e("FriendListHandler", 1, paramList, new Object[0]);
        return;
      }
    }
    ThreadManager.getSubThreadHandler().post(new FriendListHandler.2(this));
    label136:
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "decodePush0x210_0x111, do add mayknow list");
    }
    try
    {
      notifyUI(111, ((MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(true, paramList), paramList);
      return;
    }
    catch (Throwable paramList)
    {
      QLog.e("FriendListHandler", 1, paramList, new Object[0]);
    }
  }
  
  protected void init()
  {
    ThreadManager.excute(new FriendListHandler.1(this), 16, null, false);
  }
  
  public boolean isGetOnlineListRecently()
  {
    long l = System.currentTimeMillis() - this.getOnlineFriendLastTimeStamp;
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getOnlineFriend  | intervalTime = ");
      localStringBuilder.append(l);
      localStringBuilder.append(" | sGetOnlineFriendDelay = ");
      localStringBuilder.append(QQAppInterface.sGetOnlineFriendDelay);
      QLog.i("FriendListHandler", 2, localStringBuilder.toString());
    }
    return (this.getOnlineFriendLastTimeStamp > 0L) && ((l < QQAppInterface.sGetOnlineFriendDelay) || (l > QQAppInterface.sNextGetOnlineFriendDelay - QQAppInterface.sGetOnlineFriendDelay));
  }
  
  public boolean isNeedSendGetFriendInfo(String paramString)
  {
    long l1 = System.currentTimeMillis();
    int i;
    label383:
    synchronized (this.friendInfoDuplicateTable)
    {
      if (this.friendInfoDuplicateTable.containsKey(paramString))
      {
        paramString = (FriendListHandler.FriendInfoDuplicate)this.friendInfoDuplicateTable.get(paramString);
        long l2 = Math.abs(l1 - paramString.startTime);
        if (paramString.expiredTime > 0L)
        {
          if (l1 < paramString.expiredTime) {
            return false;
          }
          paramString.expiredTime = 0L;
          paramString.startTime = l1;
          paramString.count = 1L;
          return true;
        }
        if (l2 < 5000L) {
          return false;
        }
        paramString.count += 1L;
        if ((paramString.count >= 8L) && (l2 < 120000L))
        {
          paramString.expiredTime = (l1 + 1800000L);
        }
        else if (l2 > 60000L)
        {
          paramString.expiredTime = 0L;
          paramString.startTime = l1;
          paramString.count = 1L;
        }
      }
      else
      {
        if (this.friendInfoDuplicateTable.size() > 20)
        {
          localObject1 = new ArrayList();
          Object localObject2 = this.friendInfoDuplicateTable.keys();
          if (!((Enumeration)localObject2).hasMoreElements()) {
            break label389;
          }
          String str = (String)((Enumeration)localObject2).nextElement();
          FriendListHandler.FriendInfoDuplicate localFriendInfoDuplicate = (FriendListHandler.FriendInfoDuplicate)this.friendInfoDuplicateTable.get(str);
          if (localFriendInfoDuplicate.expiredTime != 0L) {
            break label383;
          }
          if (l1 - localFriendInfoDuplicate.startTime <= 60000L) {
            if ((localFriendInfoDuplicate.expiredTime <= 0L) || (l1 <= localFriendInfoDuplicate.expiredTime)) {
              break label386;
            }
          }
          ((ArrayList)localObject1).add(str);
          break label386;
          while (i < ((ArrayList)localObject1).size())
          {
            localObject2 = (String)((ArrayList)localObject1).get(i);
            this.friendInfoDuplicateTable.remove(localObject2);
            i += 1;
          }
        }
        Object localObject1 = new FriendListHandler.FriendInfoDuplicate();
        ((FriendListHandler.FriendInfoDuplicate)localObject1).startTime = l1;
        ((FriendListHandler.FriendInfoDuplicate)localObject1).count = 1L;
        this.friendInfoDuplicateTable.put(paramString, localObject1);
      }
      return true;
    }
  }
  
  public boolean isStatusEntryVisible()
  {
    if (this.mStatusEntry == -1)
    {
      String str = this.app.getServerConfigValue(ServerConfigManager.ConfigType.app, "StatusEntry");
      if ((str != null) && (str.length() > 0)) {
        try
        {
          this.mStatusEntry = Integer.parseInt(str);
        }
        catch (Exception localException)
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("isStatusEntryVisible ");
            localStringBuilder.append(this.mStatusEntry);
            localStringBuilder.append(", ");
            localStringBuilder.append(localException.toString());
            QLog.d("Q.richstatus.mate", 2, localStringBuilder.toString());
          }
        }
      }
    }
    return this.mStatusEntry == 1;
  }
  
  public boolean isSyncingAllFriendsRichStatus()
  {
    return this.isSyncingAllFriendsRichStatus;
  }
  
  public void kickOutDev(long paramLong, byte paramByte, byte[] paramArrayOfByte, int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.SvcReqKikOut");
    localToServiceMsg.extraData.putLong("appid", paramLong);
    localToServiceMsg.extraData.putByte("cKeyType", paramByte);
    localToServiceMsg.extraData.putLong("lUin", Long.parseLong(this.app.getAccount()));
    localToServiceMsg.extraData.putByteArray("sKey", paramArrayOfByte);
    localToServiceMsg.extraData.putInt("index", paramInt);
    localToServiceMsg.setIsSupportRetry(true);
    send(localToServiceMsg);
  }
  
  public void moveFriendToGroup(String paramString, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.MovGroupMemReq");
    localToServiceMsg.extraData.putByte("move_fri_type", (byte)0);
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("group_id", paramByte1);
    localToServiceMsg.extraData.putByte("away_group_id", paramByte2);
    send(localToServiceMsg);
  }
  
  public void moveFriendsToGroup(String[] paramArrayOfString, byte paramByte1, byte paramByte2)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.MovGroupMemReq");
    localToServiceMsg.extraData.putByte("move_fri_type", (byte)1);
    localToServiceMsg.extraData.putByte("group_id", paramByte1);
    localToServiceMsg.extraData.putByte("away_group_id", paramByte2);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (paramArrayOfString.length - i < 15) {
        j = paramArrayOfString.length - i;
      } else {
        j = 15;
      }
      String[] arrayOfString = new String[j];
      int j = 0;
      while (j < 15)
      {
        int k = i + j;
        if (k >= paramArrayOfString.length) {
          break;
        }
        arrayOfString[j] = paramArrayOfString[k];
        j += 1;
      }
      localToServiceMsg.extraData.putStringArray("uins", arrayOfString);
      send(localToServiceMsg);
      i += 15;
    }
  }
  
  public void notifySyncSignature()
  {
    String[] arrayOfString = this.updateSignatureList;
    if (arrayOfString != null)
    {
      getRichStatusForFriendList(arrayOfString);
      this.updateSignatureList = null;
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return IFriendObserver.class;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
  }
  
  public void onGetSpecialCareRecommend(List<oidb_0x7df.FriendScore> paramList)
  {
    synchronized (this.mRecommendLock)
    {
      this.mRecommendList.clear();
      this.mRecommendList.addAll(paramList);
      return;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd()))
    {
      if (QLog.isColorLevel())
      {
        paramToServiceMsg = new StringBuilder();
        paramToServiceMsg.append("cmdfilter error=");
        paramToServiceMsg.append(paramFromServiceMsg.getServiceCmd());
        QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
      }
      return;
    }
    Object localObject = this.handlerReceivers.iterator();
    while (((Iterator)localObject).hasNext())
    {
      BaseHandlerReceiver localBaseHandlerReceiver = (BaseHandlerReceiver)((Iterator)localObject).next();
      if (localBaseHandlerReceiver.a(paramFromServiceMsg.getServiceCmd()))
      {
        localBaseHandlerReceiver.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
    }
    if (paramFromServiceMsg.getServiceCmd().equals("ProfileService.GetRichSig"))
    {
      if (!paramFromServiceMsg.isSuccess()) {
        return;
      }
      int i = paramToServiceMsg.extraData.getInt("reqType", 0);
      if ((i != 0) && (i != 3))
      {
        handleStrangerRichStatus(paramToServiceMsg, paramObject);
        return;
      }
      handleFriendRichStatus(paramToServiceMsg, paramObject);
      return;
    }
    if ("ProfileService.GetSimpleInfo".equals(paramFromServiceMsg.getServiceCmd()))
    {
      localObject = paramToServiceMsg.extraData.getStringArrayList("uinList");
      if (paramFromServiceMsg.isSuccess())
      {
        paramObject = (ArrayList)paramObject;
        if ((paramObject != null) && (localObject != null)) {
          handleFriendInfo(paramToServiceMsg, (ArrayList)localObject, paramFromServiceMsg, paramObject);
        }
      }
    }
    else
    {
      if ("OidbSvc.0x4fc_30".equals(paramFromServiceMsg.getServiceCmd()))
      {
        handleGetStrangerInfo(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x7c4_0".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        handleGetGatheredContactsList(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x4f4_5".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        handleGatherContactsResp(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x5d6_7".equalsIgnoreCase(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getBoolean("param_is_set_switches_of_a_person"))
        {
          handleSetSpecialCareSwitchesOfAPersonResp(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        handleSetSpecialCareSwitchResp(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x777".equals(paramFromServiceMsg.getServiceCmd())) {
        handleAddBatchTroopMembers(paramToServiceMsg, paramFromServiceMsg, paramObject);
      }
    }
  }
  
  public void queryUinSafetyFlag(String paramString, long paramLong, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("send_oidb_0x476 ");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_command.set(1142);
    ((oidb_sso.OIDBSSOPkg)localObject).uint32_service_type.set(paramInt);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(6);
    localByteBuffer.putShort((short)1);
    localByteBuffer.putInt((int)paramLong);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.setHasFlag(true);
    ((oidb_sso.OIDBSSOPkg)localObject).bytes_bodybuffer.set(ByteStringMicro.copyFrom(localByteBuffer.array()));
    paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), paramString);
    paramString.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
    paramString.extraData.putLong("uin", paramLong);
    sendPbReq(paramString);
  }
  
  protected void registerHandlerReceivers()
  {
    this.handlerReceivers.add(new FriendGroupReceiver(this.app, this));
    this.handlerReceivers.add(new FriendInfoReceiver(this.app, this));
    this.handlerReceivers.add(new FriendChatReceiver(this.app, this));
    this.handlerReceivers.add(new FriendListReceiver(this.app, this));
    this.handlerReceivers.add(new MakeFriendReceiver(this.app, this));
    this.handlerReceivers.add(new FriendRecommendReceiver(this.app, this));
    this.handlerReceivers.add(new DeviceLockAuthReceiver(this.app, this));
    this.handlerReceivers.add(new DeviceLoginInfoReceiver(this.app, this));
    this.handlerReceivers.add(new QueryUinFlagRecevier(this.app, this));
    this.handlerReceivers.add(new SearchFriendReceiver(this.app, this));
    this.handlerReceivers.add(new NetStatusReceiver(this.app, this));
    this.handlerReceivers.add(new DongtaiPermissionReceiver(this.app, this));
    this.handlerReceivers.add(new FriendShieldReceiver(this.app, this));
    this.handlerReceivers.add(new SuspiciousOperReceiver(this.app, this));
  }
  
  public void renameFriendGroup(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("RenameFriendGroup :");
      localStringBuilder.append(paramByte);
      QLog.d("FriendListHandler", 2, localStringBuilder.toString());
    }
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).renameFriendGroup(paramByte, paramString);
  }
  
  public void reportMayknowRecommendExplosure(ConcurrentHashMap<String, MayKnowExposure> paramConcurrentHashMap)
  {
    if (paramConcurrentHashMap != null)
    {
      if (paramConcurrentHashMap.size() == 0) {
        return;
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("reportMayknowRecommendExplosure, needReportCnt=");
        ((StringBuilder)localObject).append(paramConcurrentHashMap.size());
        QLog.d("FriendListHandler", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        localObject = new ArrayList();
        paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
        int i = 0;
        while ((paramConcurrentHashMap.hasNext()) && (i < 99))
        {
          MayKnowExposure localMayKnowExposure = (MayKnowExposure)((Map.Entry)paramConcurrentHashMap.next()).getValue();
          oidb_0xc35.ExposeItem localExposeItem = new oidb_0xc35.ExposeItem();
          localExposeItem.uint64_friend.set(Long.parseLong(localMayKnowExposure.uin));
          localExposeItem.uint32_action_id.set(localMayKnowExposure.actionId);
          localExposeItem.uint32_entrance_Id.set(localMayKnowExposure.entranceId);
          localExposeItem.uint32_expose_count.set(localMayKnowExposure.exposeCnt);
          localExposeItem.uint32_expose_time.set(localMayKnowExposure.exposeTime);
          localExposeItem.uint32_page_id.set(localMayKnowExposure.pageId);
          if (localMayKnowExposure.acBuffer != null) {
            localExposeItem.bytes_algo_buffer.set(ByteStringMicro.copyFrom(localMayKnowExposure.acBuffer));
          }
          if (localMayKnowExposure.additive != null) {
            localExposeItem.bytes_addition.set(ByteStringMicro.copyFrom(localMayKnowExposure.additive));
          }
          ((List)localObject).add(localExposeItem);
          i += 1;
        }
        paramConcurrentHashMap = new oidb_0xc35.ReqBody();
        paramConcurrentHashMap.uint64_uin.set(l);
        paramConcurrentHashMap.rpt_msg_expose_info.set((List)localObject);
        sendPbReq(makeOIDBPkg("OidbSvc.0xc35_0", 3125, 0, paramConcurrentHashMap.toByteArray()));
        if (QLog.isColorLevel())
        {
          paramConcurrentHashMap = new StringBuilder();
          paramConcurrentHashMap.append("reportMayknowRecommendExplosure, realReportCnt=");
          paramConcurrentHashMap.append(i);
          QLog.d("FriendListHandler", 2, paramConcurrentHashMap.toString());
          return;
        }
      }
      catch (Exception paramConcurrentHashMap)
      {
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure", paramConcurrentHashMap);
        }
      }
    }
  }
  
  public void reqHideConversationMayknowRecommend()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "reqHideConversationMayknowRecommend ");
    }
    try
    {
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      oidb_0xc34.ReqBody localReqBody = new oidb_0xc34.ReqBody();
      localReqBody.uint64_uin.set(l);
      sendPbReq(makeOIDBPkg("OidbSvc.0xc34_0", 3124, 0, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "reqHideConversationMayknowRecommend exception", localException);
      }
    }
  }
  
  public void reqHideConversationTroopRecommend()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "reqHideConversationTroopRecommend ");
    }
    try
    {
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      oidb_0xc34.ReqBody localReqBody = new oidb_0xc34.ReqBody();
      localReqBody.uint64_uin.set(l);
      sendPbReq(makeOIDBPkg("OidbSvc.0xc34_1", 3124, 1, localReqBody.toByteArray()));
      return;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "reqHideConversationTroopRecommend exception", localException);
      }
    }
  }
  
  public void reqLastChatTime(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("IceBreak.FriendListHandler", 2, String.format("reqLastChatTime frdUin=%s daysForward=%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    try
    {
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      Object localObject = new cmd0xc85.ReqBody();
      ((cmd0xc85.ReqBody)localObject).uint64_from_uin.set(l);
      ((cmd0xc85.ReqBody)localObject).uint64_to_uin.set(Long.valueOf(paramString).longValue());
      ((cmd0xc85.ReqBody)localObject).uint32_op.set(2);
      ((cmd0xc85.ReqBody)localObject).uint32_interval_days.set(paramInt);
      localObject = makeOIDBPkg("OidbSvc.0xc85", 3205, 0, ((cmd0xc85.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("selfUin", this.app.getCurrentAccountUin());
      ((ToServiceMsg)localObject).extraData.putString("frdUin", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "reqRecheckInHotReactive exception", paramString);
      }
    }
  }
  
  public void reqRecheckInHotReactive(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("reqRecheckInHotReactive frdUin=");
      ((StringBuilder)localObject).append(paramString);
      QLog.d("FriendReactive.FriendListHandler", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      localObject = new cmd0xc83.ReqBody();
      ((cmd0xc83.ReqBody)localObject).uint64_from_uin.set(l);
      ((cmd0xc83.ReqBody)localObject).uint64_to_uin.set(Long.valueOf(paramString).longValue());
      ((cmd0xc83.ReqBody)localObject).uint32_op.set(2);
      localObject = makeOIDBPkg("OidbSvc.0xc83", 3203, 0, ((cmd0xc83.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("selfUin", this.app.getCurrentAccountUin());
      ((ToServiceMsg)localObject).extraData.putString("frdUin", paramString);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "reqRecheckInHotReactive exception", paramString);
      }
    }
  }
  
  public void resortFriendGroup(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).resortFriendGroup(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void saveShowPcIconIfNeccessary(byte paramByte)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void searchFriend(String paramString1, String paramString2, int paramInt1, int paramInt2, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, int paramInt3, long paramLong)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("SummaryCard.ReqSearch");
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
    if (QLog.isDevelopLevel())
    {
      paramString1 = new StringBuilder();
      paramString1.append("search friend with filter:");
      paramString1.append(paramInt3);
      QLog.d("FriendListHandler", 4, paramString1.toString());
    }
    send(localToServiceMsg);
  }
  
  public void searchFriend(String paramString1, String paramString2, int paramInt1, int paramInt2, int[] paramArrayOfInt, double paramDouble1, double paramDouble2, boolean paramBoolean, long paramLong)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("SummaryCard.ReqSearch");
    localToServiceMsg.extraData.putString("param_keyword", paramString1);
    localToServiceMsg.extraData.putString("param_country_code", paramString2);
    localToServiceMsg.extraData.putInt("search_page", paramInt2);
    localToServiceMsg.extraData.putIntArray("search_list", paramArrayOfInt);
    localToServiceMsg.extraData.putInt("search_version", paramInt1);
    localToServiceMsg.extraData.putDouble("search_longtitude", paramDouble1);
    localToServiceMsg.extraData.putDouble("search_latitude", paramDouble2);
    localToServiceMsg.extraData.putBoolean("search_decode", paramBoolean);
    localToServiceMsg.extraData.putLong("session_id", paramLong);
    send(localToServiceMsg);
  }
  
  public void searchFriendCondtional(long paramLong1, int paramInt1, long paramLong2, String paramString, int paramInt2, int paramInt3, int paramInt4, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt5, int paramInt6, int paramInt7)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("SummaryCard.ReqCondSearch");
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
    send(localToServiceMsg);
  }
  
  public void sendReadReportSuspicious()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "sendReadReportSuspicious ");
    }
    Object localObject = new oidb_cmd0xd69.ReqBody();
    ((oidb_cmd0xd69.ReqBody)localObject).cmd_type.set(5);
    localObject = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).addAttribute("cmd", Integer.valueOf(5));
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public void send_oidb_0x5d1_0(long paramLong, int paramInt, boolean paramBoolean)
  {
    int i;
    if (paramBoolean) {
      i = 1;
    } else {
      i = 2;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("FriendShield : send_oidb_0x5d1_0 : uin : ");
      ((StringBuilder)localObject1).append(paramLong);
      ((StringBuilder)localObject1).append(" setId:");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" isSet:");
      ((StringBuilder)localObject1).append(paramBoolean);
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new Oidb_0x5d1.ReqBody();
    ((Oidb_0x5d1.ReqBody)localObject1).uint32_cmd.set(i);
    ((Oidb_0x5d1.ReqBody)localObject1).uint32_id.set(paramInt);
    long l = this.app.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("FriendListHandler.send_oidb_0x5d1_0 ");
      ((StringBuilder)localObject2).append(l);
      QLog.d("Q.contacts.", 2, ((StringBuilder)localObject2).toString());
    }
    if (paramBoolean)
    {
      localObject2 = new Oidb_0x5d1.SetFriendIdReq();
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).uint64_seq.set(l);
      ((Oidb_0x5d1.SetFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_set_friend_id.set((MessageMicro)localObject2);
    }
    else
    {
      localObject2 = new Oidb_0x5d1.ClearFriendIdReq();
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint32_if_check_seq.set(0);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).uint64_seq.set(l);
      ((Oidb_0x5d1.ClearFriendIdReq)localObject2).rpt_uint64_friends.add(Long.valueOf(paramLong));
      ((Oidb_0x5d1.ReqBody)localObject1).msg_clear_friend_id.set((MessageMicro)localObject2);
    }
    Object localObject2 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1489);
    ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((Oidb_0x5d1.ReqBody)localObject1).toByteArray()));
    localObject1 = createToServiceMsg("OidbSvc.0x5d1_0");
    ((ToServiceMsg)localObject1).extraData.putLong("friendUin", paramLong);
    ((ToServiceMsg)localObject1).extraData.putBoolean("isSet", paramBoolean);
    ((ToServiceMsg)localObject1).extraData.putInt("setId", paramInt);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void setBindUinStatus(byte paramByte, ArrayList<BindUin> paramArrayList)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.BindUin");
    localToServiceMsg.extraData.putByte("cCmd", paramByte);
    localToServiceMsg.addAttribute("vecBindUin", paramArrayList);
    send(localToServiceMsg);
  }
  
  public void setDongtaiPermission(boolean paramBoolean, String paramString, int paramInt)
  {
    throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.useAs(TypeTransformer.java:868)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.enexpr(TypeTransformer.java:668)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:719)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.exExpr(TypeTransformer.java:703)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.s1stmt(TypeTransformer.java:810)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.sxStmt(TypeTransformer.java:840)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:206)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
  }
  
  public void setFriendComment(String paramString1, String paramString2, boolean paramBoolean)
  {
    setFriendComment(paramString1, paramString2, paramBoolean, false);
  }
  
  public void setFriendComment(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!paramBoolean1)
    {
      localObject = createToServiceMsg("ProfileService.ChangeFriendName");
      ((ToServiceMsg)localObject).extraData.putString("com_value", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      ((ToServiceMsg)localObject).extraData.putBoolean("notify_plugin", paramBoolean2);
      send((ToServiceMsg)localObject);
      return;
    }
    Object localObject = paramString2;
    if (paramString2 == null) {
      localObject = "";
    }
    paramString2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Card localCard = paramString2.b(paramString1);
    localCard.strReMark = ((String)localObject);
    paramString2.a(localCard);
    paramString2.b(paramString1, (String)localObject);
    ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).b(paramString1, (String)localObject);
    paramString1 = (IPhoneContactService)this.app.getRuntimeService(IPhoneContactService.class, "");
    if (paramString1 != null) {
      paramString1.notifyContactChanged();
    }
  }
  
  public void setHiddenChat(String[] paramArrayOfString, boolean[] paramArrayOfBoolean, int[] paramArrayOfInt)
  {
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("FriendListHandler.setHiddenChat(). uin size=");
      int j = -1;
      if (paramArrayOfString == null) {
        i = -1;
      } else {
        i = paramArrayOfString.length;
      }
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", switch size=");
      if (paramArrayOfBoolean == null) {
        i = j;
      } else {
        i = paramArrayOfBoolean.length;
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("tag_hidden_chat", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0))
    {
      if (paramArrayOfString.length != paramArrayOfBoolean.length) {
        return;
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < paramArrayOfString.length)
      {
        localObject2 = paramArrayOfString[i];
        int k = paramArrayOfBoolean[i];
        Object localObject3 = new oidb_0x5d6.SnsUpdateItem();
        ArrayList localArrayList = new ArrayList();
        if (k != 0)
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13581);
          byte[] arrayOfByte = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
          localArrayList.add(localObject3);
        }
        else
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13581);
          localArrayList.add(localObject3);
        }
        localObject3 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).uint64_uin.set(Long.parseLong((String)localObject2));
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.set(localArrayList);
        ((List)localObject1).add(localObject3);
        i += 1;
      }
      Object localObject2 = new oidb_0x5d6.ReqBody();
      ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(1);
      ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
      ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
      localObject1 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(21);
      ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
      localObject2 = createToServiceMsg("OidbSvc.0x5d6_21");
      ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
      ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
      ((ToServiceMsg)localObject2).extraData.putIntArray("param_chat_types", paramArrayOfInt);
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      sendPbReq((ToServiceMsg)localObject2);
    }
  }
  
  public void setMessageNotificationSetting(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("FriendListHandler.setMessageNotificationSetting(). uin size=");
      int j = -1;
      if (paramArrayOfString == null) {
        i = -1;
      } else {
        i = paramArrayOfString.length;
      }
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", switch size=");
      if (paramArrayOfBoolean == null) {
        i = j;
      } else {
        i = paramArrayOfBoolean.length;
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("tag_msg_notification", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0))
    {
      if (paramArrayOfString.length != paramArrayOfBoolean.length) {
        return;
      }
      Object localObject2 = new ArrayList();
      localObject1 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      i = 0;
      boolean bool = false;
      while (i < paramArrayOfString.length)
      {
        String str = paramArrayOfString[i];
        Object localObject3 = ((FriendsManager)localObject1).a(str, false);
        if (localObject3 == null)
        {
          QLog.d("FriendListHandler", 1, new Object[] { "setMessageNotificationSetting: invoked. ", " extensionInfo: ", localObject3 });
        }
        else
        {
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, new Object[] { "setMessageNotificationSetting: invoked. ", " type: ", Integer.valueOf(paramInt), " uin: ", str, " isSwitchOn: ", Boolean.valueOf(bool) });
          }
          Object localObject5 = MessageNotificationSettingManager.a((ExtensionInfo)localObject3);
          int k = paramArrayOfBoolean[i];
          Object localObject4 = new oidb_0x5d6.SnsUpdateItem();
          localObject3 = new ArrayList();
          byte[] arrayOfByte = new byte[2];
          if (paramInt == 1) {
            ((ExtensionInfo)localObject5).messageEnablePreviewNew = (k ^ 0x1);
          } else if (paramInt == 3) {
            ((ExtensionInfo)localObject5).messageEnableVibrateNew = (k ^ 0x1);
          } else if (paramInt == 2) {
            ((ExtensionInfo)localObject5).messageEnableSoundNew = (k ^ 0x1);
          }
          localObject5 = MessageNotificationSettingManager.a((ExtensionInfo)localObject5);
          ((oidb_0x5d6.SnsUpdateItem)localObject4).uint32_update_sns_type.set(13582);
          ((oidb_0x5d6.SnsUpdateItem)localObject4).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject5));
          ((List)localObject3).add(localObject4);
          localObject4 = new oidb_0x5d6.SnsUpateBuffer();
          ((oidb_0x5d6.SnsUpateBuffer)localObject4).uint64_uin.set(Long.parseLong(str));
          ((oidb_0x5d6.SnsUpateBuffer)localObject4).rpt_msg_sns_update_item.set((List)localObject3);
          ((List)localObject2).add(localObject4);
        }
        i += 1;
      }
      localObject1 = new oidb_0x5d6.ReqBody();
      ((oidb_0x5d6.ReqBody)localObject1).uint32_domain.set(1);
      ((oidb_0x5d6.ReqBody)localObject1).uint32_seq.set(0);
      ((oidb_0x5d6.ReqBody)localObject1).rpt_msg_update_buffer.set((List)localObject2);
      localObject2 = new oidb_sso.OIDBSSOPkg();
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_command.set(1494);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_result.set(0);
      ((oidb_sso.OIDBSSOPkg)localObject2).uint32_service_type.set(21);
      ((oidb_sso.OIDBSSOPkg)localObject2).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject1).toByteArray()));
      localObject1 = createToServiceMsg("OidbSvc.0x5d6_21");
      ((ToServiceMsg)localObject1).extraData.putInt("param_type", paramInt);
      ((ToServiceMsg)localObject1).extraData.putStringArray("param_uins", paramArrayOfString);
      ((ToServiceMsg)localObject1).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      sendPbReq((ToServiceMsg)localObject1);
    }
  }
  
  public void setShowBigClubSwitch(QQAppInterface paramQQAppInterface, boolean paramBoolean, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    try
    {
      long l = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
      byte[] arrayOfByte = new byte[13];
      PkgTools.dWord2Byte(arrayOfByte, 0, l);
      arrayOfByte[4] = 0;
      PkgTools.word2Byte(arrayOfByte, 5, (short)1);
      PkgTools.dWordTo2Bytes(arrayOfByte, 7, 42275);
      PkgTools.word2Byte(arrayOfByte, 9, (short)2);
      PkgTools.word2Byte(arrayOfByte, 11, (short)(paramBoolean ^ true));
      ProtoUtils.a(paramQQAppInterface, paramTroopProtocolObserver, arrayOfByte, "OidbSvc.0x4ff_9", 1279, 9);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.dating", 2, "send_oidb_0x4ff_9 error", paramQQAppInterface);
      }
    }
  }
  
  public void setSpecialCareSwitch(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    Object localObject1;
    int i;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("FriendListHandler.setSpecialCareSwitch(). type=");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(", uin size=");
      int j = -1;
      if (paramArrayOfString == null) {
        i = -1;
      } else {
        i = paramArrayOfString.length;
      }
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(", switch size=");
      if (paramArrayOfBoolean == null) {
        i = j;
      } else {
        i = paramArrayOfBoolean.length;
      }
      ((StringBuilder)localObject1).append(i);
      QLog.d("set_special_care_switch", 2, ((StringBuilder)localObject1).toString());
    }
    if ((paramInt >= 1) && (paramInt <= 3) && (paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0))
    {
      if (paramArrayOfString.length != paramArrayOfBoolean.length) {
        return;
      }
      localObject1 = new ArrayList();
      i = 0;
      while (i < paramArrayOfString.length)
      {
        localObject2 = paramArrayOfString[i];
        int k = paramArrayOfBoolean[i];
        Object localObject3 = new oidb_0x5d6.SnsUpdateItem();
        ArrayList localArrayList = new ArrayList();
        byte[] arrayOfByte;
        if (paramInt != 1)
        {
          if (paramInt != 2)
          {
            if (paramInt == 3)
            {
              ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
              if (k != 0)
              {
                arrayOfByte = "1".getBytes();
                ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom(arrayOfByte));
              }
              localArrayList.add(localObject3);
            }
          }
          else
          {
            ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
            if (k != 0)
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
          }
        }
        else if (k != 0)
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
        }
        localObject3 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).uint64_uin.set(Long.parseLong((String)localObject2));
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.set(localArrayList);
        ((List)localObject1).add(localObject3);
        i += 1;
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
      localObject2 = createToServiceMsg("OidbSvc.0x5d6_7");
      ((ToServiceMsg)localObject2).extraData.putInt("param_type", paramInt);
      ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
      ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
      ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
      sendPbReq((ToServiceMsg)localObject2);
    }
  }
  
  public void setSpecialCareSwitchesOfAPerson(String paramString, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean, String[] paramArrayOfString)
  {
    Object localObject3;
    Object localObject1;
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("uin=");
      ((StringBuilder)localObject3).append(paramString);
      ((StringBuilder)localObject3).append(", type size=");
      if (paramArrayOfInt == null) {
        localObject1 = "";
      } else {
        localObject1 = Integer.valueOf(paramArrayOfInt.length);
      }
      ((StringBuilder)localObject3).append(localObject1);
      ((StringBuilder)localObject3).append(", switchState size=");
      localObject2 = "null";
      if (paramArrayOfBoolean == null) {
        localObject1 = "null";
      } else {
        localObject1 = Integer.valueOf(paramArrayOfBoolean.length);
      }
      ((StringBuilder)localObject3).append(localObject1);
      ((StringBuilder)localObject3).append(", ringId size=");
      if (paramArrayOfString == null) {
        localObject1 = localObject2;
      } else {
        localObject1 = Integer.valueOf(paramArrayOfString.length);
      }
      ((StringBuilder)localObject3).append(localObject1);
      QLog.d("set_special_care_switches_of_a_person", 2, ((StringBuilder)localObject3).toString());
    }
    if ((!StringUtil.a(paramString)) && (paramArrayOfInt != null) && (paramArrayOfBoolean != null) && (paramArrayOfString != null) && (paramArrayOfInt.length == paramArrayOfBoolean.length))
    {
      if (paramArrayOfBoolean.length != paramArrayOfString.length) {
        return;
      }
      localObject2 = new ArrayList();
      localObject1 = new oidb_0x5d6.SnsUpateBuffer();
      ((oidb_0x5d6.SnsUpateBuffer)localObject1).uint64_uin.set(Long.parseLong(paramString));
      int i = 0;
      while (i < paramArrayOfInt.length)
      {
        int j = paramArrayOfInt[i];
        int k = paramArrayOfBoolean[i];
        Object localObject4 = paramArrayOfString[i];
        localObject3 = new oidb_0x5d6.SnsUpdateItem();
        if (j != 1)
        {
          if (j != 2)
          {
            if (j == 3)
            {
              ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
              if (k != 0)
              {
                localObject4 = "1".getBytes();
                ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject4));
              }
              ((List)localObject2).add(localObject3);
            }
          }
          else
          {
            ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
            if (k != 0) {
              if (!StringUtil.a((String)localObject4))
              {
                localObject4 = ((String)localObject4).getBytes();
                ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject4));
              }
              else
              {
                throw new IllegalArgumentException("special ring id can not be empty!");
              }
            }
            ((List)localObject2).add(localObject3);
            localObject3 = new oidb_0x5d6.SnsUpdateItem();
            ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
            localObject4 = "1".getBytes();
            ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject4));
            ((List)localObject2).add(localObject3);
          }
        }
        else if (k != 0)
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          localObject4 = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject4));
          ((List)localObject2).add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          localObject4 = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject4));
          ((List)localObject2).add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          localObject4 = "1".getBytes();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject4));
          ((List)localObject2).add(localObject3);
        }
        else
        {
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13573);
          ((List)localObject2).add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13568);
          ((List)localObject2).add(localObject3);
          localObject3 = new oidb_0x5d6.SnsUpdateItem();
          ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13572);
          ((List)localObject2).add(localObject3);
        }
        i += 1;
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
      localObject1 = createToServiceMsg("OidbSvc.0x5d6_7");
      ((ToServiceMsg)localObject1).extraData.putString("param_uin", paramString);
      ((ToServiceMsg)localObject1).extraData.putIntArray("param_type", paramArrayOfInt);
      ((ToServiceMsg)localObject1).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
      ((ToServiceMsg)localObject1).extraData.putStringArray("param_ring_ids", paramArrayOfString);
      ((ToServiceMsg)localObject1).extraData.putBoolean("param_is_set_switches_of_a_person", true);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      sendPbReq((ToServiceMsg)localObject1);
    }
  }
  
  public void setVisibilityForNetWorkStatus(boolean paramBoolean)
  {
    oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
    localOIDBSSOPkg.uint32_command.set(1169);
    localOIDBSSOPkg.uint32_service_type.set(107);
    Object localObject = ByteBuffer.allocate(1);
    ((ByteBuffer)localObject).put((byte)(paramBoolean ^ true));
    localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
    localObject = createToServiceMsg("OidbSvc.0x491_107");
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).extraData.putBoolean("key_show_to_friends", paramBoolean);
    ((ToServiceMsg)localObject).setTimeout(10000L);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public boolean shouldGetOnlineInfo()
  {
    long l1 = System.currentTimeMillis();
    long l2 = l1 - this.timeGetOnlineInfo;
    long l3 = this.intervalGetOnlineInfo;
    boolean bool;
    if ((l2 < l3) && (l2 > -l3)) {
      bool = true;
    } else {
      bool = false;
    }
    if (!bool) {
      this.timeGetOnlineInfo = l1;
    }
    return bool;
  }
  
  public boolean shouldReqLevel(String paramString)
  {
    boolean bool1 = paramString.equals(this.app.getCurrentAccountUin());
    boolean bool2 = bool1;
    if (bool1)
    {
      long l = ContactConfig.a(this.app.getApp().getApplicationContext(), this.app.getCurrentAccountUin());
      if (Math.abs(System.currentTimeMillis() - l) > 86400000L) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      bool2 = bool1;
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("$shouldReqLevel | lastReqTime = ");
        paramString.append(l);
        paramString.append(" | currentTime = ");
        paramString.append(System.currentTimeMillis());
        QLog.d("FriendListHandler", 2, paramString.toString());
        bool2 = bool1;
      }
    }
    return bool2;
  }
  
  public void updateTrustDeviceList(long paramLong, int paramInt1, String paramString, int paramInt2, ArrayList<DeviceLockItemInfo> paramArrayList)
  {
    device_lock_confirm_auth.ReqBody localReqBody = new device_lock_confirm_auth.ReqBody();
    localReqBody.uint64_uin.set(paramLong);
    localReqBody.bytes_guid.set(ByteStringMicro.copyFrom(NetConnInfoCenter.GUID));
    localReqBody.uint32_appid.set(this.app.getAppid());
    localReqBody.uint32_subappid.set(paramInt1);
    localReqBody.uint32_seq.set(paramInt2);
    localReqBody.bytes_appname.set(ByteStringMicro.copyFrom(paramString.getBytes()));
    int i = paramArrayList.size();
    paramString = new ArrayList();
    paramInt2 = 0;
    while (paramInt2 < i)
    {
      device_lock_confirm_auth.DeviceInfo localDeviceInfo = new device_lock_confirm_auth.DeviceInfo();
      DeviceLockItemInfo localDeviceLockItemInfo = (DeviceLockItemInfo)paramArrayList.get(paramInt2);
      if (localDeviceLockItemInfo != null)
      {
        localDeviceInfo.bytes_appname.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_c_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_name.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_a_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_typeinfo.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_b_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_guid.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.jdField_a_of_type_ArrayOfByte));
        localDeviceInfo.uint32_appid.set(localDeviceLockItemInfo.jdField_a_of_type_Int);
        localDeviceInfo.uint32_auth_status.set(localDeviceLockItemInfo.jdField_c_of_type_Int);
        localDeviceInfo.uint32_subappid.set(paramInt1);
        paramString.add(localDeviceInfo);
      }
      paramInt2 += 1;
    }
    if (paramString.size() > 0) {
      localReqBody.rpt_msg_devicelist.set(paramString);
    }
    paramString = createToServiceMsg("DevLockAuthSvc.ConfirmAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    sendPbReq(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler
 * JD-Core Version:    0.7.0.1
 */