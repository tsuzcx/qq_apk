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
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
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
import com.tencent.mobileqq.app.friendlist.receiver.GeneralSettingsReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.MakeFriendReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.NetStatusReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.QueryUinFlagRecevier;
import com.tencent.mobileqq.app.friendlist.receiver.SearchFriendReceiver;
import com.tencent.mobileqq.app.friendlist.receiver.SuspiciousOperReceiver;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;
import com.tencent.mobileqq.chat.MessageNotificationSettingManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.friend.api.IFriendHandlerService;
import com.tencent.mobileqq.friend.observer.IFriendObserver;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.NearbyCardManager;
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
import com.tencent.mobileqq.qzonestatus.QzoneContactsFeedManager;
import com.tencent.mobileqq.relationx.addFrd.AddFrdStateMng;
import com.tencent.mobileqq.relationx.addFrd.AddFrdTokenHelper;
import com.tencent.mobileqq.relationx.batchAdd.BatchAddFriendData;
import com.tencent.mobileqq.richstatus.ExtensionRichStatus;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.service.profile.CheckUpdateItemInterface;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.ContactConfig;
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
import tencent.im.oidb.cmd0x5e1.oidb_0x5e1.ReqBody;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListReq;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.GetSNFrdListRsp;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.MsgBox;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.OneFrdData;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.ReqBody;
import tencent.im.oidb.cmd0x7c4.cmd0x7c4.RspBody;
import tencent.im.oidb.cmd0x7c6.cmd0x7c6.ReqBody;
import tencent.im.oidb.cmd0x7c7.cmd0x7c7.ReqBody;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.FriendScore;
import tencent.im.oidb.cmd0x7df.oidb_0x7df.ReqBody;
import tencent.im.oidb.cmd0x829.oidb_0x829.ReqBody;
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
  public static final String ATTR_PACKAGE = "package";
  public static final String ATTR_PHONES = "phones";
  public static final String ATTR_RESULT_LIST = "resultList";
  public static final String ATTR_SOURCE_ID = "sourceId";
  public static final String ATTR_VERIFY_MSG = "verifyMsg";
  public static final int BOTH_DONGTAI = 3;
  public static final int CONNECTIONS_GET_DATA_MAX_COUNT = 50;
  public static final int CONNECTIONS_TAB_ID_INVILIAD_RET = 1205;
  private static final long DIFF_TIME_ZONE = 28800000L;
  public static final short FIELD_0X49D_NICK = 20002;
  private static final int FIRST_GET_FRIEND_NUM = 20;
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
  public static final int MAX_ADD_COUNT = 30;
  private static int MAX_COUNT_REQ_GETHER_MEMBER = 100;
  private static final int MAX_MOVE_FRI = 15;
  public static final long MIN_INTERVAL_GET_ONLINE = 15000L;
  public static final int NOTIFY_TYPE_GET_GATHERED_CONTACTS_LIST = 79;
  public static final int NOTIFY_TYPE_GET_RECOMM_GATHERED_CONTACTS_LIST = 80;
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
  public static final int SEARCH_TYPE_ACCURATE = 87;
  public static final int SEARCH_TYPE_FUZZY = 88;
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
  public static final int TYPE_ADD_BATCH_PHONE_FRIEND = 109;
  public static final int TYPE_ADD_QIMFRIENDS = 110;
  public static final int TYPE_BATCH_ADD_TROOP_MEMBERS = 111;
  public static final int TYPE_CANCEL_MAYKNOW_RECOMMEND = 93;
  public static final int TYPE_COND_SEARCH_FRIEND = 73;
  public static final int TYPE_CONVERSATION_RECOMMEND_TYPE_CHANGE = 122;
  public static final int TYPE_DEL_AUTH_DEV = 61;
  public static final int TYPE_DEL_DEVLOGININFO = 51;
  public static final int TYPE_DEL_HISTORY_DEV = 62;
  public static final int TYPE_FRIEND_LIST_ADD = 63;
  public static final int TYPE_GET_ADD_FRIEND_SECCHECK = 119;
  public static final int TYPE_GET_AUTH_DEV_LIST = 60;
  public static final int TYPE_GET_AUTO_INFO = 33;
  public static final int TYPE_GET_BOTH_DONGTAI_PERMISSIONS = 86;
  public static final int TYPE_GET_CIRCLE_RICH_STATUS = 64;
  public static final int TYPE_GET_CONNECTIONS_PERSON = 131;
  public static final int TYPE_GET_DATENICK = 89;
  public static final int TYPE_GET_DEVLOGININFO = 50;
  public static final int TYPE_GET_FRDS_HAS_BIND_PHONE = 120;
  public static final int TYPE_GET_FRIENDNICK_BATCH = 75;
  public static final int TYPE_GET_FRIEND_INFO = 3;
  public static final int TYPE_GET_FRIEND_INFO_FINISHED = 67;
  public static final int TYPE_GET_FRIEND_LIST = 1;
  public static final int TYPE_GET_GENERAL_SETTINGS = 35;
  public static final int TYPE_GET_HISTORY_DEV_LIST = 59;
  public static final int TYPE_GET_LAST_LOGIN_INFO = 48;
  public static final int TYPE_GET_LOGIN_DEV_LIST = 58;
  public static final int TYPE_GET_MAYKNOW_RECOMMEND = 92;
  public static final int TYPE_GET_NOT_ALLOWED_SEE_MYDONGTAI = 82;
  public static final int TYPE_GET_ONLINE_INFO_BY_UIN_OR_MOBILE = 68;
  public static final int TYPE_GET_RECENT_LIST = 7;
  public static final int TYPE_GET_RECOMMEND_AUTH_DEVICE_LIST = 69;
  public static final int TYPE_GET_SHIELD_HISDONGTAI = 84;
  public static final int TYPE_GET_SIGNATURE = 2;
  public static final int TYPE_GET_SIG_ZAN_INFO = 94;
  public static final int TYPE_GET_SPECIAL_CARE_LIST = 99;
  public static final int TYPE_GET_SPECIAL_CARE_RECOMMEND = 95;
  public static final int TYPE_GET_STORE_FACE = 46;
  public static final int TYPE_GET_STRANGER_INFO = 66;
  public static final int TYPE_GET_STRANGER_RICH_STATUS = 65;
  public static final int TYPE_GET_TROOP_HEAD_URL = 53;
  public static final int TYPE_GET_TROOP_NEWS = 55;
  public static final int TYPE_GET_TROOP_TAG = 57;
  public static final int TYPE_GLOBAL = 1;
  public static final int TYPE_HIDDEN_CHAT_SWITCH = 129;
  public static final int TYPE_HIDE_CONVERSATION_MAYKNOW_RECOMMEND = 115;
  public static final int TYPE_INFO_OPENID = 74;
  public static final int TYPE_KICKOUT_DEV = 52;
  public static final int TYPE_MAYKNOW_ENTRY_STATE_CHANGED = 112;
  public static final int TYPE_MAYKNOW_LIST_PUSHED_ADD = 113;
  public static final int TYPE_MAYKNOW_LIST_PUSHED_DEL = 114;
  public static final int TYPE_NEW_SEARCH_FRIEND = 49;
  public static final int TYPE_NOTIFICATION_PREVIEW = 1;
  public static final int TYPE_NOTIFICATION_SOUND = 2;
  public static final int TYPE_NOTIFICATION_VIBRATE = 3;
  public static final int TYPE_NOTIFY_ADDREQ_STATES_CHANGED = 104;
  public static final int TYPE_NOTIFY_CHAT_HOT_DAY_UPDATE = 106;
  public static final int TYPE_NOTIFY_GROUP_INITED = 103;
  public static final int TYPE_NOTIFY_MAYKNOW_STATE_CHANGED = 107;
  public static final int TYPE_NOTIFY_OLYMPIC_TORCH_UPDATE = 105;
  public static final int TYPE_NOTIFY_PULL_IPAD_STATE = 102;
  public static final int TYPE_NOTIFY_PUSH_RECOMMEND_FRIEND = 108;
  public static final int TYPE_OIDB_0X476_146 = 71;
  public static final int TYPE_OIDB_0X476_147 = 72;
  public static final int TYPE_OIDB_0X88D_1 = 54;
  public static final int TYPE_QZONE = 3;
  public static final int TYPE_RECOMMEND_TROOP_JOINED_OR_DELETED = 121;
  public static final int TYPE_REQ_GET_SHOW_NETWORK_STATUS_TO_FRIENDS = 77;
  public static final int TYPE_REQ_LAST_CHAT_TIME = 117;
  public static final int TYPE_REQ_RECHECKIN_HOTREACTIVE = 116;
  public static final int TYPE_REQ_SET_COMMENT = 27;
  public static final int TYPE_REQ_SET_SHOW_NETWORK_STATUS_TO_FRIENDS = 76;
  public static final int TYPE_REQ_SET_SIGNATURE = 28;
  public static final int TYPE_REQ_SHIELD_FRIENDS_LIST = 118;
  public static final int TYPE_SETAS_NORMAL_CONTACTS = 91;
  public static final int TYPE_SETAS_UNCOMMONLY_USED_CONTACTS = 90;
  public static final int TYPE_SET_BOTH_DONGTAI_PERMISSIONS = 85;
  public static final int TYPE_SET_GENERAL_SETTINGS = 37;
  public static final int TYPE_SET_GENERAL_SETTINGS_ALL_RING = 43;
  public static final int TYPE_SET_GENERAL_SETTINGS_ALL_VIBRATE = 44;
  public static final int TYPE_SET_GENERAL_SETTINGS_C2C_ROAMING_SETTINGS = 47;
  public static final int TYPE_SET_GENERAL_SETTINGS_TROOPFILTER = 38;
  public static final int TYPE_SET_GENERAL_SETTINGS_TROOP_RING = 41;
  public static final int TYPE_SET_GENERAL_SETTINGS_TROOP_VIBRATE = 42;
  public static final int TYPE_SET_GROUP_ADD = 18;
  public static final int TYPE_SET_GROUP_DEL = 21;
  public static final int TYPE_SET_GROUP_RENAME = 19;
  public static final int TYPE_SET_GROUP_RESORT = 22;
  public static final int TYPE_SET_MESSAGE_NOTIFICATION_SWITCH = 130;
  public static final int TYPE_SET_MESSAGE_ROAM = 101;
  public static final int TYPE_SET_NOT_ALLOWED_SEE_MYDONGTAI = 81;
  public static final int TYPE_SET_SHIELD_HISDONGTAI = 83;
  public static final int TYPE_SET_SPECIAL_CARE_RING = 78;
  public static final int TYPE_SET_SPECIAL_CARE_SWITCHES_OF_A_PERSON = 100;
  public static final int TYPE_SET_SPECIAL_CARE_SWITCH_GLOBAL = 96;
  public static final int TYPE_SET_SPECIAL_CARE_SWITCH_QZONE = 98;
  public static final int TYPE_SET_SPECIAL_CARE_SWITCH_SPECIAL_RING = 97;
  public static final int TYPE_SPECIAL_RING = 2;
  public static final int TYPE_SUSPICIOUS_AGREE = 128;
  public static final int TYPE_SUSPICIOUS_CLEAR = 126;
  public static final int TYPE_SUSPICIOUS_DELETE_UIN = 125;
  public static final int TYPE_SUSPICIOUS_GET_LIST = 124;
  public static final int TYPE_SUSPICIOUS_GET_UNREAD_NUM = 123;
  public static final int TYPE_SUSPICIOUS_REPORT = 127;
  public static final int TYPE_UPDATE_FRIEND_SHIELD_FLAG = 56;
  public static final int TYPE_UPDATE_SERVER_AUTH_DEVICE_LIST = 70;
  public static final int TYPR_GET_ADD_FRIEND = 11;
  public static final int TYPR_GET_ADD_FRIEND_SETTING = 12;
  public static final int TYPR_GET_ANSWER_ADDED_FRIEND = 10;
  public static final int TYPR_GET_C2C_CHAT_STATUS = 8;
  public static final int TYPR_GET_DELFRIEND = 15;
  public static final int TYPR_GET_MOVE_GROUP = 9;
  public static final int TYPR_GET_ONLINEFRIEND = 13;
  public static final int TYPR_GET_TROOP_GETREMARK = 16;
  public static final int TYPR_GET_VIDEO_ABILITY = 14;
  public static final int UIN_FORBIDENED = 1;
  public static final int UIN_FRAUD = 2;
  public static final int UIN_IMPEACHED_AS_AD = 4;
  public static final int UIN_IMPEACHED_AS_CHEATER = 5;
  public static final int UIN_IMPEACHED_MANY_TIMES = 3;
  public static final int UIN_SAFETY_SERVICE_TYPE_146 = 146;
  public static final int UIN_SAFETY_SERVICE_TYPE_147 = 147;
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
  private final AddFrdTokenHelper mAddFrdTokenHelper = new AddFrdTokenHelper();
  private BatchAddFriendData mBatchAddFriendData = null;
  private int mFriendListFailedCount = 0;
  private HashMap<Long, String> mOfflineTips;
  private ArrayList<oidb_0x7df.FriendScore> mRecommendList = new ArrayList();
  private final Object mRecommendLock = new Object();
  private volatile int mShowPcIcon = -1;
  private int mStatusEntry = -1;
  public ArrayList<PhoneContact> requestingPhoneArr = null;
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
  
  private void addFriendInternal(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2, String paramString6, Bundle paramBundle, boolean paramBoolean3)
  {
    Object localObject2;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      if (paramBundle != null) {
        paramBundle.getString("troop_uin");
      }
      localObject2 = new StringBuilder(300);
      localStringBuilder = ((StringBuilder)localObject2).append("addFriendInternal, uin:").append(paramString1).append(", sourceID:").append(paramInt2).append(", subSourceId:").append(paramInt3).append(", extraUin:").append(paramString2).append(", friendSetting:").append(paramInt1).append(", groupId:").append(paramByte1).append(", msg:").append(paramString3).append(", autoSend:").append(paramBoolean1).append(", isContactBothWay:").append(paramBoolean2).append(", remark:").append(paramString4).append(", sourceName:").append(paramString5).append(", myCard:").append(paramByte2).append(", extraParam:").append(paramBundle).append(", isSupportSecurityTips:").append(paramBoolean3).append(", sig:");
      if (paramArrayOfByte != null) {
        break label552;
      }
      localObject1 = "null";
      localStringBuilder = localStringBuilder.append(localObject1).append(", ticket:");
      if (paramString6 != null) {
        break label563;
      }
    }
    label552:
    label563:
    for (Object localObject1 = "null";; localObject1 = Integer.valueOf(paramString6.length()))
    {
      localStringBuilder.append(localObject1);
      QLog.d("addFriendTag", 2, ((StringBuilder)localObject2).toString());
      localObject1 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.addFriend");
      localObject2 = ((ToServiceMsg)localObject1).extraData;
      ((Bundle)localObject2).putString("uin", paramString1);
      ((Bundle)localObject2).putInt("friend_setting", paramInt1);
      ((Bundle)localObject2).putByte("group_id", paramByte1);
      ((Bundle)localObject2).putString("msg", paramString3);
      ((Bundle)localObject2).putInt("source_id", paramInt2);
      ((Bundle)localObject2).putByte("show_my_card", paramByte2);
      ((Bundle)localObject2).putInt("sub_source_id", paramInt3);
      ((Bundle)localObject2).putString("extra", paramString2);
      ((Bundle)localObject2).putBoolean("auto_send", paramBoolean1);
      ((Bundle)localObject2).putByteArray("sig", paramArrayOfByte);
      ((Bundle)localObject2).putBoolean("contact_bothway", paramBoolean2);
      ((Bundle)localObject2).putString("remark", paramString4);
      ((Bundle)localObject2).putString("src_name", paramString5);
      if (paramBundle != null)
      {
        ((Bundle)localObject2).putString("troop_uin", paramBundle.getString("troop_uin"));
        ((Bundle)localObject2).putString("troop_code", paramBundle.getString("troop_code"));
        ((Bundle)localObject2).putInt("flc_notify_type", paramBundle.getInt("flc_notify_type"));
        ((Bundle)localObject2).putString("flc_recommend_uin", paramBundle.getString("flc_recommend_uin"));
        paramString2 = paramBundle.getByteArray("friend_src_desc");
        if (paramString2 != null) {
          ((Bundle)localObject2).putByteArray("friend_src_desc", paramString2);
        }
      }
      paramString1 = this.mAddFrdTokenHelper.a(paramString1, paramInt2, paramInt3);
      if ((paramString1 != null) && (paramString1.length > 0)) {
        ((Bundle)localObject2).putByteArray("flc_add_frd_token", paramString1);
      }
      ((Bundle)localObject2).putString("security_ticket", paramString6);
      ((Bundle)localObject2).putBoolean("security_ticket_support", paramBoolean3);
      send((ToServiceMsg)localObject1);
      return;
      localObject1 = Integer.valueOf(paramArrayOfByte.length);
      break;
    }
  }
  
  private long convertUin(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    for (;;)
    {
      return 0L;
      try
      {
        long l = Long.parseLong(paramString);
        if (l >= 10000L) {
          return l;
        }
      }
      catch (NumberFormatException paramString) {}
    }
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
      Object localObject;
      try
      {
        localObject = new SubMsgType0x111.MsgBody();
        ((SubMsgType0x111.MsgBody)localObject).mergeFrom(paramArrayOfByte);
        if (!((SubMsgType0x111.MsgBody)localObject).uint64_type.has()) {
          break label383;
        }
        l1 = ((SubMsgType0x111.MsgBody)localObject).uint64_type.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "decodePush0x210_0x111,type = " + l1);
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
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "decodePush0x210_0x111 add " + paramArrayOfByte);
          }
          paramQQAppInterface.handleMayKnowRecommendPush((int)l1, paramArrayOfByte);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramQQAppInterface)
      {
        QLog.i("FriendListHandler", 1, "decodePush0x210_0x111 decode error, e=" + paramQQAppInterface.toString());
        return;
      }
      if (l1 == 2L)
      {
        paramArrayOfByte = new ArrayList();
        if (((SubMsgType0x111.MsgBody)localObject).rpt_uint64_del_uins.has()) {
          paramArrayOfByte.addAll(((SubMsgType0x111.MsgBody)localObject).rpt_uint64_del_uins.get());
        }
        localObject = new ArrayList();
        paramArrayOfByte = paramArrayOfByte.iterator();
        while (paramArrayOfByte.hasNext())
        {
          long l2 = ((Long)paramArrayOfByte.next()).longValue();
          if (l2 > 0L) {
            ((List)localObject).add(String.valueOf(l2));
          }
        }
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "decodePush0x210_0x111 del " + localObject);
        }
        paramQQAppInterface.handleMayKnowRecommendPush((int)l1, (List)localObject);
        return;
        QLog.i("FriendListHandler", 1, "decodePush0x210_0x111 pbData = null");
      }
      return;
      label383:
      long l1 = -1L;
    }
  }
  
  private void doGetRichStatus(String[] paramArrayOfString, int paramInt1, int paramInt2, Bundle paramBundle, boolean paramBoolean)
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
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.GetRichSig");
    localToServiceMsg.extraData.putStringArray("totalArray", paramArrayOfString);
    localToServiceMsg.extraData.putInt("nextStartPos", i + paramInt1);
    localToServiceMsg.extraData.putStringArray("sendArray", arrayOfString);
    localToServiceMsg.extraData.putInt("reqType", paramInt2);
    localToServiceMsg.extraData.putBoolean("showDateNickname", paramBoolean);
    localToServiceMsg.extraData.putBundle("circleBundle", paramBundle);
    send(localToServiceMsg);
  }
  
  private void handleAddBatchTroopMembers(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (this.mBatchAddFriendData == null) {
      return;
    }
    this.mBatchAddFriendData.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private boolean handleCheckUpdateItem(CheckUpdateItemInterface paramCheckUpdateItemInterface, RespItem paramRespItem)
  {
    if ((paramCheckUpdateItemInterface == null) || (paramRespItem == null)) {
      return false;
    }
    try
    {
      paramCheckUpdateItemInterface.a(paramRespItem);
      return true;
    }
    catch (OutOfMemoryError paramCheckUpdateItemInterface)
    {
      QLog.d("ProfileService.CheckUpdateReq", 1, String.format("encounter OutOfMemoryError when handleCheckUpdateItem() sId=%d ret=%d ex=%s \n%s", new Object[] { Integer.valueOf(paramRespItem.eServiceID), Byte.valueOf(paramRespItem.cResult), paramCheckUpdateItemInterface.getMessage(), Log.getStackTraceString(paramCheckUpdateItemInterface) }));
      return true;
    }
    catch (Throwable paramCheckUpdateItemInterface)
    {
      QLog.d("ProfileService.CheckUpdateReq", 1, paramCheckUpdateItemInterface.getMessage(), paramCheckUpdateItemInterface);
    }
    return true;
  }
  
  private void handleFriendRichStatus(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    paramObject = (GetRichSigRes)paramObject;
    FriendsManager localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    if ((paramObject == null) || (paramObject.cResult != 0) || (paramObject.vstSigInfo == null) || (paramObject.vstSigInfo.size() == 0) || (localFriendsManager == null))
    {
      if (paramToServiceMsg.extraData.getInt("reqType") == 3) {
        this.isSyncingAllFriendsRichStatus = false;
      }
      relayGetRichStatus(paramToServiceMsg);
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
        if ((paramObject.richTime != localResRichSigInfo.dwTime) || (!Arrays.equals(paramObject.richBuffer, localResRichSigInfo.vbSigInfo)))
        {
          ExtensionRichStatus.a(paramObject, localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
          paramObject.isAdded2C2C = SignatureManager.a(this.app, str, ExtensionRichStatus.a(paramObject));
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
      notifyUI(2, true, paramObject);
      localFriendsManager.b(localArrayList1);
    }
    if ((paramToServiceMsg.extraData.getInt("reqType") == 3) && (this.isSyncingAllFriendsRichStatus) && (paramToServiceMsg.extraData.getStringArray("totalArray").length == paramToServiceMsg.extraData.getInt("nextStartPos")))
    {
      this.app.getPreferences().edit().putLong("inccheckupdatetimeStamp13", this.lastFriendListUpdateTime).commit();
      this.isSyncingAllFriendsRichStatus = false;
    }
    relayGetRichStatus(paramToServiceMsg);
  }
  
  private void handleGatherContactsResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    bool3 = true;
    boolean bool4;
    boolean bool5;
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool2 = true;
      bool4 = paramToServiceMsg.extraData.getBoolean("isGather", true);
      bool5 = paramToServiceMsg.extraData.getBoolean("needNotifyPlugin", false);
      paramToServiceMsg = paramToServiceMsg.extraData.getStringArrayList("friendUinList");
      bool1 = bool2;
      if (!bool2) {}
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = new oidb_sso.OIDBSSOPkg();
        paramFromServiceMsg.mergeFrom((byte[])paramObject);
        if ((paramFromServiceMsg == null) || (paramFromServiceMsg.uint32_result.get() != 0)) {
          continue;
        }
        bool1 = true;
        if (!bool1) {
          continue;
        }
        paramFromServiceMsg = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
        if (!bool4) {
          continue;
        }
        paramFromServiceMsg.e(paramToServiceMsg);
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGatherContactsResp,error: " + paramFromServiceMsg.getMessage());
        bool1 = false;
        continue;
        if (paramFromServiceMsg == null) {
          continue;
        }
        int i = paramFromServiceMsg.uint32_result.get();
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGatherContactsResp fail: resultCode = " + i);
        continue;
      }
      catch (Exception paramFromServiceMsg)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGatherContactsResp,error: " + paramFromServiceMsg.getMessage());
        bool1 = false;
        continue;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, "handleGatherContactsResp ssoPkg is null");
        continue;
        notifyUI(91, bool1, paramToServiceMsg);
        continue;
        bool2 = false;
        continue;
        bool2 = bool3;
        if (!bool1) {
          continue;
        }
        bool2 = false;
        continue;
      }
      if (!bool4) {
        continue;
      }
      notifyUI(90, bool1, paramToServiceMsg);
      if (bool5)
      {
        paramFromServiceMsg = new Intent("action_gather_resp");
        paramFromServiceMsg.putStringArrayListExtra("key_uin_list", paramToServiceMsg);
        paramFromServiceMsg.putExtra("key_is_suc", bool1);
        if (!bool4) {
          continue;
        }
        if (!bool1) {
          continue;
        }
        bool2 = bool3;
        paramFromServiceMsg.putExtra("key_is_gather", bool2);
        BaseApplicationImpl.getContext().sendBroadcast(paramFromServiceMsg);
      }
      return;
      bool2 = false;
      break;
      bool1 = false;
      continue;
      paramFromServiceMsg.d(paramToServiceMsg);
    }
  }
  
  private void handleGetGatheredContactsList(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg.getResultCode() != 1000) {
      notifyUI(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
    }
    for (;;)
    {
      return;
      int i = paramToServiceMsg.extraData.getInt("startIndex");
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom((byte[])paramObject);
        paramToServiceMsg = paramFromServiceMsg;
        label73:
        if (!paramToServiceMsg.uint32_result.has())
        {
          notifyUI(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        break label73;
        int j = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList result " + j);
        }
        paramFromServiceMsg = new StringBuilder(1024);
        if (j == 0)
        {
          paramObject = new cmd0x7c4.RspBody();
          cmd0x7c4.GetSNFrdListRsp localGetSNFrdListRsp;
          int k;
          FriendsManager localFriendsManager;
          ArrayList localArrayList;
          for (;;)
          {
            try
            {
              paramObject.mergeFrom(paramToServiceMsg.bytes_bodybuffer.get().toByteArray());
              localGetSNFrdListRsp = (cmd0x7c4.GetSNFrdListRsp)paramObject.msg_get_sn_frd_list_rsp.get();
              localGetSNFrdListRsp.uint64_uin.get();
              j = localGetSNFrdListRsp.uint32_sequence.get();
              k = localGetSNFrdListRsp.uint32_over.get();
              if (paramObject.rpt_msg_recommend_reason.has())
              {
                paramToServiceMsg = paramObject.rpt_msg_recommend_reason.get();
                ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).f(paramToServiceMsg);
              }
              paramToServiceMsg = localGetSNFrdListRsp.rpt_msg_one_frd_data.get();
              localFriendsManager = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
              if (paramToServiceMsg == null) {
                break label595;
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
              notifyUI(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
              return;
            }
          }
          localFriendsManager.a(localArrayList, i);
          label595:
          if (localGetSNFrdListRsp.uint32_recommend_frd_count.has())
          {
            i = localGetSNFrdListRsp.uint32_recommend_frd_count.get();
            paramFromServiceMsg.append("|recommend cnt=").append(i);
            label629:
            boolean bool = paramObject.msg_box.has();
            this.app.getHandler(Conversation.class);
            if (!bool) {
              break label821;
            }
            if (QLog.isColorLevel()) {
              QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. ");
            }
            paramToServiceMsg = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
            bool = paramToServiceMsg.getBoolean("hasPulledRecomGathered", false);
            paramToServiceMsg.edit().putBoolean("hasMsgBox", true).commit();
            paramFromServiceMsg.append("|has no MsgBox hasPulled=").append(bool);
            label734:
            if (k != 0) {
              break label832;
            }
            i = localGetSNFrdListRsp.uint32_next_start_idx.get();
            paramFromServiceMsg.append("|not Completed. continue to get. startIndex =").append(i);
            getGatheredContactsList(i);
            notifyUI(79, true, new Object[] { Boolean.valueOf(false), Boolean.valueOf(true) });
          }
          while (QLog.isColorLevel())
          {
            QLog.i("FriendListHandler", 2, paramFromServiceMsg.toString());
            return;
            paramFromServiceMsg.append("|no recommend field");
            break label629;
            label821:
            paramFromServiceMsg.append("|has no MsgBox");
            break label734;
            label832:
            paramFromServiceMsg.append("|not Completed. continue to get. Completed.");
            this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit().putInt("GetFrdListReq_seq", j).commit();
            notifyUI(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
            if (localFriendsManager != null) {
              localFriendsManager.f();
            }
          }
        }
        if (j == 1)
        {
          notifyUI(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(false) });
          return;
        }
        notifyUI(79, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false) });
      }
    }
  }
  
  private void handleGetStrangerInfo(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null)) {}
    for (int i = 1; i == 0; i = 0)
    {
      notifyUI(66, false, null);
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
        notifyUI(66, false, null);
        return;
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        notifyUI(66, false, null);
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
    ArrayList localArrayList = new ArrayList();
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
          i = 0;
          long l = Utils.a(localByteBuffer.getInt());
          paramObject = localFriendsManager.a(String.valueOf(l));
          paramToServiceMsg = paramObject;
          if (paramObject == null)
          {
            paramToServiceMsg = new ExtensionInfo();
            paramToServiceMsg.uin = String.valueOf(l);
            i = 1;
          }
          int i1 = localByteBuffer.getShort();
          int m = i;
          if (i1 > 0)
          {
            int k = 0;
            for (;;)
            {
              m = i;
              if (k >= i1) {
                break;
              }
              m = localByteBuffer.getShort();
              boolean bool1 = FriendListHandlerUtil.a(localByteBuffer, paramToServiceMsg, m);
              boolean bool2 = FriendListHandlerUtil.b(localByteBuffer, paramToServiceMsg, m);
              boolean bool3 = FriendListHandlerUtil.c(localByteBuffer, paramToServiceMsg, m);
              FriendListHandlerUtil.a(this.app, localByteBuffer, l, m);
              k += 1;
              i = bool3 | i | bool1 | bool2;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("FriendListHandler", 2, "handleGetStrangerInfo, uin=" + l + ", pendant=" + paramToServiceMsg.pendantId + ",font=" + paramToServiceMsg.uVipFont + ", fontType = " + paramToServiceMsg.vipFontType);
          }
          if (m != 0)
          {
            paramToServiceMsg.timestamp = System.currentTimeMillis();
            localArrayList.add(paramToServiceMsg);
            paramFromServiceMsg.add(paramToServiceMsg.uin);
          }
          j += 1;
        }
        localFriendsManager.b(localArrayList);
      }
    }
    if (paramFromServiceMsg.size() == 0) {}
    for (paramToServiceMsg = null;; paramToServiceMsg = paramFromServiceMsg)
    {
      notifyUI(66, true, paramToServiceMsg);
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.stranger_info", 2, "handleGetStrangerInfo. addonId size : " + localArrayList.size());
      return;
    }
  }
  
  private void handleSetHiddenChatResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("tag_hidden_chat", 2, "FriendListHandler.handleSetHiddenChatResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    String[] arrayOfString = paramToServiceMsg.extraData.getStringArray("param_uins");
    int[] arrayOfInt = paramToServiceMsg.extraData.getIntArray("param_chat_types");
    boolean[] arrayOfBoolean = paramToServiceMsg.extraData.getBooleanArray("param_switch_state");
    int k;
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
        for (;;)
        {
          int i;
          if (QLog.isColorLevel()) {
            QLog.d("tag_hidden_chat", 2, "parse oidb_sso.OIDBSSOPkg failed.");
          }
          paramFromServiceMsg.printStackTrace();
          continue;
          paramToServiceMsg.a(null);
        }
        k = 1;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, "ssoPkg.uint32_result=" + i);
        }
        if (i == 0)
        {
          i = 0;
          for (;;)
          {
            if (i >= arrayOfString.length) {
              break label281;
            }
            paramToServiceMsg = arrayOfString[i];
            k = arrayOfBoolean[i];
            int j = arrayOfInt[i];
            paramToServiceMsg = new FriendsStatusUtil.UpdateFriendStatusItem(paramToServiceMsg, 13581, 21);
            if (k == 0) {
              break;
            }
            paramToServiceMsg.a(new byte[1]);
            FriendsStatusUtil.a(this.app, paramToServiceMsg, null);
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      label281:
      notifyUI(129, k, new Object[] { arrayOfString, arrayOfBoolean });
      return;
      int m = 0;
    }
  }
  
  private void handleSetMessageNotificationSettingResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("tag_msg_notification", 2, "FriendListHandler.handleSetMessageNotificationSettingResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    MessageNotificationSettingManager localMessageNotificationSettingManager = MessageNotificationSettingManager.a(this.app);
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
        for (;;)
        {
          int i;
          if (QLog.isColorLevel()) {
            QLog.d("tag_hidden_chat", 2, "parse oidb_sso.OIDBSSOPkg failed.");
          }
          paramFromServiceMsg.printStackTrace();
        }
        bool = true;
      }
      if (paramToServiceMsg.uint32_result.has())
      {
        i = paramToServiceMsg.uint32_result.get();
        if (QLog.isColorLevel()) {
          QLog.d("tag_hidden_chat", 2, "ssoPkg.uint32_result=" + i);
        }
        if (i == 0)
        {
          i = 0;
          while (i < arrayOfString.length)
          {
            localMessageNotificationSettingManager.a(arrayOfString[i], j, arrayOfBoolean[i]);
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      notifyUI(130, bool, new Object[] { arrayOfString, arrayOfBoolean, Integer.valueOf(j) });
      return;
      boolean bool = false;
    }
  }
  
  private void handleSetSpecialCareSwitchResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
              QvipSpecialCareManager.a(paramFromServiceMsg, "1", this.app);
            }
            else
            {
              paramToServiceMsg.e(paramFromServiceMsg);
            }
          }
          paramObject = paramToServiceMsg.a(paramFromServiceMsg);
          if (paramObject != null) {
            if (m == 0) {
              break label391;
            }
          }
          for (j = 1;; j = 0)
          {
            paramObject.specialRingSwitch = j;
            paramToServiceMsg.a(paramObject);
            if (m == 0) {
              break;
            }
            QvipSpecialCareManager.a(paramFromServiceMsg, "1", this.app);
            break;
          }
          paramFromServiceMsg = paramToServiceMsg.a(paramFromServiceMsg);
        } while (paramFromServiceMsg == null);
        if (m == 0) {
          break label429;
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
          paramToServiceMsg = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
      label391:
      label429:
      paramToServiceMsg = new Object[3];
      paramToServiceMsg[0] = Integer.valueOf(k);
      paramToServiceMsg[1] = arrayOfString;
      paramToServiceMsg[2] = arrayOfBoolean;
      switch (k)
      {
      default: 
        return;
      case 1: 
        notifyUI(96, m, paramToServiceMsg);
        return;
      case 2: 
        notifyUI(97, m, paramToServiceMsg);
        return;
      }
      notifyUI(98, m, paramToServiceMsg);
      return;
      int n = 0;
    }
  }
  
  private void handleSetSpecialCareSwitchesOfAPersonResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
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
              QvipSpecialCareManager.a(str, "1", this.app);
            }
            else
            {
              paramToServiceMsg.e(str);
            }
          }
          paramObject = paramToServiceMsg.a(str);
          if (paramObject != null) {
            if (m == 0) {
              break label432;
            }
          }
          for (k = 1;; k = 0)
          {
            paramObject.specialRingSwitch = k;
            paramToServiceMsg.a(paramObject);
            if (m == 0) {
              break;
            }
            QvipSpecialCareManager.a(str, paramFromServiceMsg, this.app);
            break;
          }
          paramFromServiceMsg = paramToServiceMsg.a(str);
        } while (paramFromServiceMsg == null);
        if (m == 0) {
          break label471;
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
          paramToServiceMsg = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
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
      label432:
      label471:
      notifyUI(100, m, new Object[] { Integer.valueOf(i), str, arrayOfInt, arrayOfBoolean, arrayOfString });
      return;
      int n = 0;
      continue;
      n = 0;
      i = -1;
    }
  }
  
  private void handleStrangerRichStatus(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    Object localObject = (GetRichSigRes)paramObject;
    paramObject = paramToServiceMsg.extraData.getStringArray("sendArray");
    if ((localObject == null) || (((GetRichSigRes)localObject).cResult != 0) || (((GetRichSigRes)localObject).vstSigInfo == null) || (((GetRichSigRes)localObject).vstSigInfo.size() == 0))
    {
      notifyUI(65, false, new Object[] { paramObject, null });
      relayGetRichStatus(paramToServiceMsg);
      return;
    }
    HashMap localHashMap = new HashMap(paramObject.length);
    localObject = ((GetRichSigRes)localObject).vstSigInfo.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ResRichSigInfo localResRichSigInfo = (ResRichSigInfo)((Iterator)localObject).next();
      localHashMap.put(Long.toString(localResRichSigInfo.lUin), RichStatus.parseStatus(localResRichSigInfo.vbSigInfo));
    }
    notifyUI(65, true, new Object[] { paramObject, localHashMap });
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
  
  private void relayGetRichStatus(ToServiceMsg paramToServiceMsg)
  {
    doGetRichStatus(paramToServiceMsg.extraData.getStringArray("totalArray"), paramToServiceMsg.extraData.getInt("nextStartPos"), paramToServiceMsg.extraData.getInt("reqType"), paramToServiceMsg.extraData.getBundle("circleBundle"), paramToServiceMsg.extraData.getBoolean("showDateNickname"));
  }
  
  private boolean shouldReqXMan(String paramString)
  {
    boolean bool1 = paramString.equals(this.app.getCurrentAccountUin());
    boolean bool2 = bool1;
    long l1;
    long l2;
    long l3;
    if (bool1)
    {
      Context localContext = this.app.getApp().getApplicationContext();
      Card localCard = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
      l1 = ContactConfig.b(localContext, paramString) + 28800000L;
      l2 = System.currentTimeMillis() + 28800000L;
      l3 = localCard.iXManScene1DelayTime * 1000;
      if ((l1 / 86400000L == l2 / 86400000L) || (Math.abs(l2 - l1) <= 28800000L) || (l2 % 86400000L < l3)) {
        break label239;
      }
    }
    label239:
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
  
  private boolean shouldReqXManScene2(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, String.format("shouldReqXManScene2 friendUin=%s", new Object[] { paramString }));
    }
    boolean bool1 = paramString.equals(this.app.getCurrentAccountUin());
    boolean bool2 = bool1;
    long l1;
    long l2;
    long l3;
    if (bool1)
    {
      Context localContext = this.app.getApp().getApplicationContext();
      Card localCard = ((FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER)).b(paramString);
      l1 = ContactConfig.c(localContext, paramString);
      l2 = System.currentTimeMillis();
      l3 = localCard.iXManScene2DelayTime * 1000;
      if ((l3 < 0L) || (Math.abs(l2 - l1) <= l3)) {
        break label182;
      }
    }
    label182:
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
  
  public static boolean updateSnsData_HOT_FRIEND_CHAT_LEVEL_TYPE(String paramString, byte[] paramArrayOfByte, ExtensionInfo paramExtensionInfo)
  {
    return false;
  }
  
  public void addBatchPhoneFriend(ArrayList<PhoneContact> paramArrayList, String paramString, int paramInt1, int paramInt2, ArrayList<FriendListHandler.AddBatchPhoneFriendResult> paramArrayList1)
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
    int i = paramArrayList.size() - k;
    int j;
    if (i > 30)
    {
      j = k + 30;
      i = paramInt1 + 1;
    }
    while (k < j)
    {
      ((List)localObject2).add(ByteStringMicro.copyFrom(((PhoneContact)paramArrayList.get(k)).unifiedCode.getBytes()));
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
      QLog.d("addFriendTag", 2, String.format("addBatchPhoneFriend sourceId:%s, pkgIndex:%s, verifyMsg:%s ", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1), paramString }));
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
    localObject1 = createToServiceMsg("OidbSvc.0x829_1");
    ((ToServiceMsg)localObject1).extraData.putSerializable("phones", paramArrayList);
    ((ToServiceMsg)localObject1).extraData.putInt("package", i);
    ((ToServiceMsg)localObject1).extraData.putString("verifyMsg", paramString);
    ((ToServiceMsg)localObject1).extraData.putSerializable("resultList", paramArrayList1);
    ((ToServiceMsg)localObject1).extraData.putInt("sourceId", paramInt2);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    ((ToServiceMsg)localObject1).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject1);
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
  
  public void addFriend(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5)
  {
    addFriendInternal(paramString1, paramString2, paramInt1, paramByte, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, (byte)0, "", null, false);
  }
  
  public void addFriend(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, Bundle paramBundle, boolean paramBoolean3)
  {
    addFriendInternal(paramString1, paramString2, paramInt1, paramByte, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, (byte)0, "", paramBundle, paramBoolean3);
  }
  
  public void addFriendGroup(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "AddFriendGroup :" + paramString);
    }
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).addFriendGroup(paramByte, paramString);
  }
  
  public boolean addFriendToFriendList(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriendToFriendList " + paramString1 + ", " + paramInt1 + ", " + paramInt2 + ", " + paramString2 + ", " + paramBoolean1);
    }
    paramString2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    Object localObject = (PhoneContactManagerImp)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
    if (localObject != null) {
      ((PhoneContactManagerImp)localObject).b();
    }
    paramBoolean1 = paramString2.a(paramString1, paramInt1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler addFriendToFriendList flag = " + paramBoolean1);
    }
    if (paramBoolean1)
    {
      this.app.getMessageFacade().b(paramString1, 0);
      if (!((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).isRequestingFriendList()) {
        notifyUI(1, true, Boolean.valueOf(true));
      }
      notifyUI(63, true, paramString1);
      localObject = (NearbyCardManager)this.app.getManager(QQManagerFactory.NEARBY_CARD_MANAGER);
      if (localObject != null) {
        ((NearbyCardManager)localObject).d.put("" + paramString1, Integer.valueOf(1));
      }
      getFriendDetailInfo(paramString1);
      paramString2.a(paramString1, false);
      ((QzoneContactsFeedManager)this.app.getManager(QQManagerFactory.QZONE_CONTACTS_FEED_MANAGER)).a(Long.valueOf(paramString1).longValue());
      if ((QidianManager.b(this.app, paramString1)) || ((!CrmUtils.b(this.app, paramString1)) && (!CrmUtils.c(this.app, paramString1)))) {
        this.app.getMsgHandler().a(paramString1, paramInt2);
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
  
  public void addFriendWithMyCard(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2, String paramString6, Bundle paramBundle, boolean paramBoolean3)
  {
    addFriendInternal(paramString1, paramString2, paramInt1, paramByte1, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, paramByte2, paramString6, paramBundle, paramBoolean3);
  }
  
  public void agreeSuspiciousMsg(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "agreeSuspiciousMsg " + paramLong);
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
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "condtionalSearchFriendBy0x972 seq = " + paramLong + ",page = " + paramInt1 + ",cookie = " + paramArrayOfByte);
    }
    oidb_0x972.ReqBody localReqBody = new oidb_0x972.ReqBody();
    short s2 = (short)paramInt3;
    int j = (short)paramInt4;
    short s1 = s2;
    if (s2 < 0) {
      s1 = 0;
    }
    int i = j;
    if (s1 > j)
    {
      j = 32767;
      i = j;
      if (QLog.isColorLevel())
      {
        QLog.i("FriendListHandler", 2, String.format("handleCondSearchFriend [%s, %s]--[%s, %s]", new Object[] { Integer.valueOf(paramInt3), Integer.valueOf(paramInt4), Short.valueOf(s1), Short.valueOf(32767) }));
        i = j;
      }
    }
    localReqBody.key_word.set(ByteStringMicro.copyFromUtf8(paramString));
    localReqBody.version.set(ByteStringMicro.copyFromUtf8("8.5.5"));
    oidb_0x972.RootSearcherRequest localRootSearcherRequest = new oidb_0x972.RootSearcherRequest();
    localRootSearcherRequest.page_size.set(25);
    if (paramArrayOfByte != null) {
      localRootSearcherRequest.cookie.set(ByteStringMicro.copyFrom(paramArrayOfByte));
    }
    localReqBody.search_request.set(localRootSearcherRequest);
    localReqBody.gander.set(paramInt2);
    localReqBody.start_age.set(s1);
    localReqBody.end_age.set(i);
    localReqBody.constellation.set(paramInt6);
    if ((paramArrayOfString1 != null) && (paramArrayOfString1.length >= 3))
    {
      localReqBody.country_id.set(ConditionSearchManager.a(paramArrayOfString1[0]));
      localReqBody.province_id.set(ConditionSearchManager.a(paramArrayOfString1[1]));
      localReqBody.city_id.set(ConditionSearchManager.a(paramArrayOfString1[2]));
    }
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length >= 3))
    {
      localReqBody.h_country_id.set(ConditionSearchManager.a(paramArrayOfString2[0]));
      localReqBody.h_province_id.set(ConditionSearchManager.a(paramArrayOfString2[1]));
      localReqBody.h_city_id.set(ConditionSearchManager.a(paramArrayOfString2[2]));
    }
    localReqBody.career_id.set(paramInt5);
    paramArrayOfByte = makeOIDBPkg("OidbSvc.0x972_5", 2418, 5, localReqBody.toByteArray());
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
    Object localObject = ((PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER)).a();
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
      send(localToServiceMsg);
      return;
    }
  }
  
  public void create0x5d6RequestPackage(int paramInt, ArrayList<FriendsStatusUtil.UpdateFriendStatusItem> paramArrayList, String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 4, " create0x5d6SendPackage serType=" + paramInt);
    }
    if ((paramArrayList == null) || (paramArrayList.size() > 20))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder("create0x5d6SendPackage serType=").append(paramInt).append(" length=");
        if (paramArrayList != null) {
          break label93;
        }
      }
      label93:
      for (paramInt = 0;; paramInt = paramArrayList.size())
      {
        QLog.d("FriendListHandler", 4, paramInt);
        return;
      }
    }
    Object localObject1 = new ArrayList(1);
    int i = 0;
    while (i < paramArrayList.size())
    {
      Object localObject3 = (FriendsStatusUtil.UpdateFriendStatusItem)paramArrayList.get(i);
      localObject2 = new oidb_0x5d6.SnsUpateBuffer();
      ((oidb_0x5d6.SnsUpateBuffer)localObject2).uint64_uin.set(Long.parseLong(((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).jdField_a_of_type_JavaLangString));
      ArrayList localArrayList = new ArrayList(1);
      oidb_0x5d6.SnsUpdateItem localSnsUpdateItem = new oidb_0x5d6.SnsUpdateItem();
      localSnsUpdateItem.uint32_update_sns_type.set(((FriendsStatusUtil.UpdateFriendStatusItem)localObject3).b);
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
  }
  
  public void decodePush0x210_0x11e(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {}
    for (;;)
    {
      try
      {
        SubMsgType0x11e.MsgBody localMsgBody = new SubMsgType0x11e.MsgBody();
        localMsgBody.mergeFrom(paramArrayOfByte);
        if (!localMsgBody.uint32_type.has()) {
          break label172;
        }
        l = localMsgBody.uint32_type.get();
        if (!localMsgBody.str_reason.has()) {
          break label179;
        }
        paramArrayOfByte = localMsgBody.str_reason.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "decodePush0x210_0x11e,type = " + l + " reason = " + paramArrayOfByte);
        }
        if (l == 1L)
        {
          getFriendGroupList(true);
          return;
        }
        if (l != 2L) {
          break label171;
        }
        getCheckUpdate(true, 8);
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        QLog.i("FriendListHandler", 1, "decodePush0x210_0x11e decode error, e=" + paramArrayOfByte.toString());
        return;
      }
      QLog.i("FriendListHandler", 1, "decodePush0x210_0x11e pbData = null");
      label171:
      return;
      label172:
      long l = -1L;
      continue;
      label179:
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
    }
    for (;;)
    {
      localToServiceMsg.extraData.putLong("iAppId", paramLong);
      send(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putInt("iDelMe", 0);
    }
  }
  
  public void delFriend(String paramString, byte paramByte)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.delFriend");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("del_type", paramByte);
    send(localToServiceMsg);
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
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "DeleteFriendGroup :" + paramByte);
    }
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).deleteFriendGroup(paramByte);
  }
  
  public void deleteStrangerInfo(FriendsManager paramFriendsManager)
  {
    Object localObject = QvipSpecialCareManager.a(this.app);
    if ((paramFriendsManager != null) && (localObject != null) && (((Set)localObject).size() > 0))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramFriendsManager.b(str))
        {
          QvipSpecialCareManager.b(str, this.app);
          if (QvipSpecialCareManager.b(str, this.app)) {
            QvipSpecialCareManager.c(str, this.app);
          }
        }
      }
    }
  }
  
  public void deleteSuspiciousMsg(long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "deleteSuspiciousMsg " + paramLong);
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
    String[] arrayOfString;
    if (!paramArrayList.isEmpty())
    {
      arrayOfString = new String[paramArrayList.size()];
      paramArrayList.toArray(arrayOfString);
      paramArrayList.clear();
      if (this.app.mAutomator.c()) {
        getRichStatusForFriendList(arrayOfString);
      }
    }
    else
    {
      return;
    }
    this.updateSignatureList = arrayOfString;
  }
  
  public void gatherContacts(short paramShort, List<String> paramList, boolean paramBoolean)
  {
    gatherContacts(paramShort, paramList, paramBoolean, false);
  }
  
  public void gatherContacts(short paramShort, List<String> paramList, boolean paramBoolean1, boolean paramBoolean2)
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
        if (!paramBoolean1) {
          break label302;
        }
        s = paramShort * 12 + 2;
        localObject = ByteBuffer.allocate(s);
        ((ByteBuffer)localObject).putShort(paramShort);
        s = 0;
        if (s >= paramShort) {
          break label203;
        }
        ((ByteBuffer)localObject).putInt(Utils.a(Long.parseLong((String)paramList.get(s))));
        if (paramBoolean1)
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
      Object localObject = createToServiceMsg("OidbSvc.0x4f4_5");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).extraData.putBoolean("isGather", paramBoolean1);
      ((ToServiceMsg)localObject).extraData.putStringArrayList("friendUinList", (ArrayList)paramList);
      ((ToServiceMsg)localObject).extraData.putBoolean("needNotifyPlugin", paramBoolean2);
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
      s += 1;
      continue;
      label302:
      short s = paramShort * 9 + 2;
    }
  }
  
  public AddFrdTokenHelper getAddFrdTokenHelper()
  {
    return this.mAddFrdTokenHelper;
  }
  
  public void getAllGeneralSettings(int paramInt1, long paramLong, int paramInt2, boolean paramBoolean)
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
    getGeneralSettings(localArrayList, paramInt1, paramLong, paramInt2, 100, paramBoolean);
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
  
  public void getAutoInfo(String paramString, int paramInt1, int paramInt2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.GetAutoInfoReq");
    localToServiceMsg.extraData.putString("uin", paramString);
    localToServiceMsg.extraData.putByte("cType", (byte)1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    send(localToServiceMsg);
  }
  
  public void getCheckUpdate(boolean paramBoolean, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getCheckUpdate checkFirstTime = " + paramBoolean + ",checkUpdateType = " + paramInt);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.CheckUpdateReq");
    localToServiceMsg.addAttribute("CheckUpdateType", Integer.valueOf(paramInt));
    localToServiceMsg.addAttribute("isFirstTime", Boolean.valueOf(paramBoolean));
    send(localToServiceMsg);
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
      this.allowCmdSet.add("ProfileService.ReqGetSettings");
      this.allowCmdSet.add("ProfileService.ReqSetSettings");
      this.allowCmdSet.add("friendlist.MovGroupMemReq");
      this.allowCmdSet.add("BumpSvc.ReqComfirmContactFriend");
      this.allowCmdSet.add("friendlist.addFriend");
      this.allowCmdSet.add("friendlist.getUserAddFriendSetting");
      this.allowCmdSet.add("friendlist.GetSimpleOnlineFriendInfoReq");
      this.allowCmdSet.add("friendlist.GetOnlineInfoReq");
      this.allowCmdSet.add("friendlist.delFriend");
      this.allowCmdSet.add("friendlist.SetGroupReq");
      this.allowCmdSet.add("ProfileService.ChangeFriendName");
      this.allowCmdSet.add("ProfileService.SetRichSig");
      this.allowCmdSet.add("StatSvc.register");
      this.allowCmdSet.add("friendlist.GetAutoInfoReq");
      this.allowCmdSet.add("ProfileService.CheckUpdateReq");
      this.allowCmdSet.add("SummaryCard.ReqSearch");
      this.allowCmdSet.add("SummaryCard.ReqCondSearch");
      this.allowCmdSet.add("OidbSvc.0x972_5");
      this.allowCmdSet.add("OidbSvc.0x5d1_0");
      this.allowCmdSet.add("OidbSvc.0x4fc_30");
      this.allowCmdSet.add("DevLockAuthSvc.RecommendAuth");
      this.allowCmdSet.add("DevLockAuthSvc.ConfirmAuth");
      this.allowCmdSet.add("OidbSvc.0x476_146");
      this.allowCmdSet.add("OidbSvc.0x476_147");
      this.allowCmdSet.add("OidbSvc.0x490_107");
      this.allowCmdSet.add("OidbSvc.0x491_107");
      this.allowCmdSet.add("OidbSvc.0x5e1_8");
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
      this.allowCmdSet.add("OidbSvc.0x829_1");
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
    boolean bool = false;
    int i = 1;
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder().append("getConnectionsPerson, entryType=").append(paramInt1).append(" tabID=").append(paramInt2).append(" hasCookie=");
      if (paramArrayOfByte != null) {
        bool = true;
      }
      QLog.i("FriendListHandler", 2, bool + " isFirstPage=" + paramBoolean);
    }
    for (;;)
    {
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
          continue;
        }
        QLog.d("FriendListHandler", 2, paramArrayOfByte.toString());
        return;
      }
      QLog.e("FriendListHandler", 1, "getConnectionsPerson, unknown entry type");
      i = -1;
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
      i = 2;
      continue;
      i = 3;
      continue;
      i = 4;
      continue;
      i = 5;
      continue;
      i = 6;
      continue;
      label309:
      switch (paramInt1)
      {
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
      paramString = new oidb_sso.OIDBSSOPkg();
      paramString.uint32_command.set(1991);
      paramString.uint32_result.set(0);
      paramString.uint32_service_type.set(0);
      paramString.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((cmd0x7c7.ReqBody)localObject).toByteArray()));
      localObject = createToServiceMsg("OidbSvc.0x7c7_0");
      ((ToServiceMsg)localObject).putWupBuffer(paramString.toByteArray());
      if (paramInt != 1) {
        break label168;
      }
      ((ToServiceMsg)localObject).extraData.putInt("key_permission_opcode", 1);
    }
    for (;;)
    {
      ((ToServiceMsg)localObject).setTimeout(10000L);
      sendPbReq((ToServiceMsg)localObject);
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
  
  public void getFriendDetailInfo(String paramString)
  {
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).requestFriendInfo(paramString);
  }
  
  public void getFriendGroupList(boolean paramBoolean)
  {
    getFriendGroupList(paramBoolean, false);
  }
  
  /* Error */
  public void getFriendGroupList(boolean paramBoolean1, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: invokestatic 507	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   5: ifeq +29 -> 34
    //   8: ldc 157
    //   10: iconst_2
    //   11: new 517	java/lang/StringBuilder
    //   14: dup
    //   15: invokespecial 722	java/lang/StringBuilder:<init>	()V
    //   18: ldc_w 2439
    //   21: invokevirtual 526	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: iload_1
    //   25: invokevirtual 546	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   28: invokevirtual 573	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 577	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   34: iload_1
    //   35: ifne +32 -> 67
    //   38: aload_0
    //   39: getfield 493	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   42: getstatic 919	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   45: invokevirtual 923	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   48: checkcast 925	com/tencent/mobileqq/app/FriendsManager
    //   51: invokevirtual 2440	com/tencent/mobileqq/app/FriendsManager:c	()Z
    //   54: ifeq +10 -> 64
    //   57: aload_0
    //   58: iconst_1
    //   59: iconst_1
    //   60: aconst_null
    //   61: invokevirtual 1003	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   64: aload_0
    //   65: monitorexit
    //   66: return
    //   67: aload_0
    //   68: getfield 493	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   71: ldc_w 1672
    //   74: invokevirtual 1676	com/tencent/mobileqq/app/QQAppInterface:getRuntimeService	(Ljava/lang/Class;)Lmqq/app/api/IRuntimeService;
    //   77: checkcast 1672	com/tencent/mobileqq/friend/api/IFriendHandlerService
    //   80: iload_2
    //   81: invokeinterface 2443 2 0
    //   86: goto -22 -> 64
    //   89: astore_3
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_3
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	FriendListHandler
    //   0	94	1	paramBoolean1	boolean
    //   0	94	2	paramBoolean2	boolean
    //   89	4	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	34	89	finally
    //   38	64	89	finally
    //   67	86	89	finally
  }
  
  public void getFriendInfo(String paramString)
  {
    getFriendInfo(paramString, false);
  }
  
  public void getFriendInfo(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FetchInfoListManager", 2, "uin = " + paramString);
    }
    if ((Friends.isValidUin(paramString)) && (isNeedSendGetFriendInfo(paramString)))
    {
      ArrayList localArrayList = new ArrayList(1);
      localArrayList.add(paramString);
      ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.GetSimpleInfo");
      localToServiceMsg.extraData.putStringArrayList("uinList", localArrayList);
      localToServiceMsg.extraData.putBoolean("reqSelfLevel", shouldReqLevel(paramString));
      localToServiceMsg.extraData.putBoolean("reqXMan", shouldReqXMan(paramString));
      localToServiceMsg.extraData.putBoolean("reqDateNick", paramBoolean);
      send(localToServiceMsg);
    }
  }
  
  public void getFriendInfoBatch(ArrayList<String> paramArrayList, boolean paramBoolean)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty()) || (this.app == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "getFriendInfoBatch uinList is empty or app is null");
      }
      return;
    }
    Object localObject2 = this.app.getCurrentAccountUin();
    Object localObject1 = "";
    int i = paramArrayList.size() - 1;
    label55:
    String str;
    if (i >= 0)
    {
      str = (String)paramArrayList.get(i);
      if ((str == null) || (str.length() == 0) || (!Friends.isValidUin(str)) || (!isNeedSendGetFriendInfo(str))) {
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
  }
  
  public boolean getFriendNickByBatch(ArrayList<String> paramArrayList)
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
    ((ByteBuffer)localObject).put((byte)0).putShort((short)1).putShort(this.shBatchSeqTypeField).putShort(s1);
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
    localObject = createToServiceMsg("OidbSvc.0x49d_107");
    ((ToServiceMsg)localObject).extraData.putStringArrayList("batchuin", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putShort("uincount", s1);
    ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
    ((ToServiceMsg)localObject).setTimeout(30000L);
    sendPbReq((ToServiceMsg)localObject);
    return true;
  }
  
  public void getFriendsHasBindPhone(int paramInt)
  {
    cmd0xcf0.ReqBody localReqBody = new cmd0xcf0.ReqBody();
    localReqBody.uint32_expect_bind_contacts_frd_num.set(paramInt);
    sendPbReq(makeOIDBPkg("OidbSvc.0xcf0_0", 3312, 0, localReqBody.toByteArray()));
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getFriendsHasBindPhone :" + paramInt);
    }
  }
  
  public void getFriendsInfo(String[] paramArrayOfString)
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
          if ((Friends.isValidUin(str)) && (isNeedSendGetFriendInfo(str))) {
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
    getRichStatus(paramArrayOfString);
    paramArrayOfString = createToServiceMsg("ProfileService.GetSimpleInfo");
    paramArrayOfString.extraData.putStringArrayList("uinList", localArrayList);
    paramArrayOfString.extraData.putBoolean("batch_data", true);
    send(paramArrayOfString);
  }
  
  public void getGatheredContactsList(int paramInt)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("OidbSvc.0x7c4_0");
    localToServiceMsg.extraData.putInt("startIndex", paramInt);
    cmd0x7c4.ReqBody localReqBody = new cmd0x7c4.ReqBody();
    Object localObject = this.app.getAccount();
    cmd0x7c4.GetSNFrdListReq localGetSNFrdListReq = new cmd0x7c4.GetSNFrdListReq();
    localGetSNFrdListReq.uint64_uin.set(Long.parseLong((String)localObject));
    int i = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).getInt("GetFrdListReq_seq", 0);
    localGetSNFrdListReq.uint32_sequence.set(i);
    localGetSNFrdListReq.uint32_start_idx.set(paramInt);
    localGetSNFrdListReq.uint32_req_num.set(MAX_COUNT_REQ_GETHER_MEMBER);
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
    sendPbReq(localToServiceMsg);
  }
  
  public void getGeneralSettings(ArrayList<String> paramArrayList, int paramInt1, long paramLong1, int paramInt2, long paramLong2, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "GeneralSettings getGeneralSettings start offset =" + paramLong1);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("ProfileService.ReqGetSettings");
    localToServiceMsg.extraData.putSerializable("Paths", paramArrayList);
    localToServiceMsg.extraData.putInt("Revision", paramInt1);
    localToServiceMsg.extraData.putLong("Offset", paramLong1);
    localToServiceMsg.extraData.putLong("Count", paramLong2);
    localToServiceMsg.extraData.putInt("respRevision", paramInt2);
    localToServiceMsg.extraData.putBoolean("needTroopSettings", paramBoolean);
    send(localToServiceMsg);
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
    boolean bool1;
    if (this.app.getCurrentAccountUin() == null) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      bool2 = ContactConfig.b(this.app.getApp().getApplicationContext(), this.app.getAccount());
      bool1 = bool2;
    } while (!bool2);
    getLastLoginInfo(0L, 0L, 0L);
    return bool2;
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
      StringBuilder localStringBuilder = new StringBuilder().append("getMayKnowRecommend, filterUins=");
      if (paramList1 == null) {
        break label227;
      }
      localObject = paramList1;
      QLog.i("FriendListHandler", 2, localObject + ", entryType=" + paramInt);
    }
    for (;;)
    {
      try
      {
        localObject = new oidb_0xc26.ReqBody();
        if (paramList1 != null) {
          ((oidb_0xc26.ReqBody)localObject).rpt_filter_uins.set(paramList1);
        }
        paramList1 = (MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER);
        if ((paramList1 == null) || (!paramList1.a())) {
          break label286;
        }
        ((oidb_0xc26.ReqBody)localObject).uint32_phone_book.set(1);
        if (!QLog.isColorLevel()) {
          break label286;
        }
        QLog.i("FriendListHandler", 2, "getMayKnowRecommend uint32_phone_book seted");
      }
      catch (Exception paramList1)
      {
        label227:
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("FriendListHandler", 2, paramList1, new Object[0]);
        return true;
      }
      QLog.e("FriendListHandler", 1, "getMayKnowRecommend, unknown entry type");
      paramInt = i;
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
      localObject = "";
      break;
      paramInt = 1;
      continue;
      paramInt = 2;
      continue;
      paramInt = 3;
      continue;
      paramInt = 4;
      continue;
      paramInt = 5;
      continue;
      paramInt = 6;
      continue;
      label286:
      int i = -1;
      switch (paramInt)
      {
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
    int i = 0;
    if (this.mOfflineTips == null)
    {
      Object localObject1 = this.app.getServerConfigValue(ServerConfigManager.ConfigType.app, "offlineTips");
      if ((localObject1 != null) && (((String)localObject1).length() > 0))
      {
        this.mOfflineTips = new HashMap();
        try
        {
          localObject1 = ((String)localObject1).split(";");
          int j = localObject1.length;
          while (i < j)
          {
            Object localObject2 = localObject1[i].split(":");
            long l = Long.parseLong(localObject2[0]);
            localObject2 = localObject2[1];
            this.mOfflineTips.put(Long.valueOf(l), localObject2);
            i += 1;
          }
          str = null;
        }
        catch (Exception localException) {}
      }
    }
    String str;
    if (this.mOfflineTips != null) {
      str = (String)this.mOfflineTips.get(Long.valueOf(paramLong));
    }
    return str;
  }
  
  public void getOnlineFriend(String paramString, byte paramByte)
  {
    if ((paramByte != 0) && (isGetOnlineListRecently())) {}
    do
    {
      return;
      this.getOnlineFriendLastTimeStamp = System.currentTimeMillis();
      paramString = new ToServiceMsg("mobileqq.service", paramString, "friendlist.GetSimpleOnlineFriendInfoReq");
      paramString.extraData.putLong("startTime", System.currentTimeMillis());
      paramString.setTimeout(120000L);
      paramString.extraData.putByte("ifShowTermType", (byte)1);
      paramString.extraData.putByte("srcType", paramByte);
      send(paramString);
    } while (!QLog.isColorLevel());
    QLog.d("getOnlineFriend", 2, "send getOnlineFriend");
  }
  
  public void getOnlineInfo(String paramString, boolean paramBoolean)
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
      send(localToServiceMsg);
      return;
      localToServiceMsg.extraData.putLong("dwReqType", 0L);
      localToServiceMsg.extraData.putLong("dwUin", CharacterUtil.a(paramString));
    }
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
    if (this.mShowPcIcon == -1) {}
    for (;;)
    {
      try
      {
        if (!ContactConfig.a(this.app.getApp().getApplicationContext(), this.app.getAccount())) {
          continue;
        }
        i = 1;
        this.mShowPcIcon = i;
      }
      catch (Exception localException)
      {
        int i;
        this.mShowPcIcon = 0;
        continue;
      }
      if (this.mShowPcIcon != 1) {
        break label62;
      }
      return true;
      i = 0;
    }
    label62:
    return false;
  }
  
  public boolean getSpecialCareRecommend(int paramInt1, int paramInt2, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2)
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
      paramArrayList = createToServiceMsg("OidbSvc.0x7df_3");
      paramArrayList.putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject).toByteArray());
      sendPbReq(paramArrayList);
      getSpecialRecommendStat = 3;
      return true;
    }
  }
  
  public void getStrangerInfo(long[] paramArrayOfLong, int[] paramArrayOfInt)
  {
    int j = 0;
    if ((paramArrayOfLong == null) || (paramArrayOfInt == null)) {
      return;
    }
    int k = paramArrayOfLong.length;
    ByteBuffer localByteBuffer = ByteBuffer.allocate(paramArrayOfInt.length * 2 + 4 + k * 4);
    localByteBuffer.putShort((short)paramArrayOfInt.length);
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
  
  public void getStrangerInfo(String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int j = paramArrayOfString.length;
    long[] arrayOfLong = new long[j];
    int i = 0;
    for (;;)
    {
      if (i < j) {
        try
        {
          arrayOfLong[i] = Long.parseLong(paramArrayOfString[i]);
          i += 1;
        }
        catch (NumberFormatException localNumberFormatException)
        {
          for (;;)
          {
            arrayOfLong[i] = 0L;
          }
        }
      }
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
    Object localObject2;
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("getSuspiciousMsgList ").append(paramInt).append(" ");
      if (paramArrayOfByte != null) {
        break label166;
      }
    }
    label166:
    for (Object localObject1 = " no cookie ";; localObject1 = " has cookie ")
    {
      QLog.i("FriendListHandler", 2, (String)localObject1 + paramObject);
      localObject1 = new oidb_cmd0xd69.ReqBody();
      ((oidb_cmd0xd69.ReqBody)localObject1).cmd_type.set(1);
      localObject2 = new oidb_cmd0xd69.GetListReqBody();
      ((oidb_cmd0xd69.GetListReqBody)localObject2).req_num.set(paramInt);
      if (paramArrayOfByte != null) {
        ((oidb_cmd0xd69.GetListReqBody)localObject2).bytes_cookies.set(ByteStringMicro.copyFrom(paramArrayOfByte));
      }
      ((oidb_cmd0xd69.ReqBody)localObject1).msg_get_list_body.set((MessageMicro)localObject2);
      paramArrayOfByte = makeOIDBPkg("OidbSvc.0xd69", 3433, 0, ((oidb_cmd0xd69.ReqBody)localObject1).toByteArray());
      paramArrayOfByte.addAttribute("cmd", Integer.valueOf(1));
      paramArrayOfByte.addAttribute("exactData", paramObject);
      sendPbReq(paramArrayOfByte);
      return;
    }
  }
  
  public void getUserAddFriendSetting(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    getUserAddFriendSetting(paramString1, paramInt1, paramInt2, paramString2, 0);
  }
  
  public void getUserAddFriendSetting(String paramString1, int paramInt1, int paramInt2, String paramString2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "getUserAddFriendSetting " + paramString1 + ", " + paramInt1 + ", " + paramString2);
    }
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "friendlist.getUserAddFriendSetting");
    localToServiceMsg.extraData.putString("uin", paramString1);
    localToServiceMsg.extraData.putInt("source_id", paramInt1);
    localToServiceMsg.extraData.putInt("sub_source_id", paramInt2);
    localToServiceMsg.extraData.putInt("random_key", paramInt3);
    if ((paramString2 != null) && (paramString2.length() > 0)) {
      localToServiceMsg.extraData.putString("extra", paramString2);
    }
    send(localToServiceMsg);
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
    if ((paramFromServiceMsg != null) && (paramFromServiceMsg.getResultCode() == 1000)) {
      paramToServiceMsg = new oidb_sso.OIDBSSOPkg();
    }
    try
    {
      paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)paramToServiceMsg.mergeFrom(paramFromServiceMsg.getWupBuffer());
      paramToServiceMsg = paramFromServiceMsg;
    }
    catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
    {
      for (;;)
      {
        paramFromServiceMsg.printStackTrace();
      }
      QLog.d("FriendListHandler.QIM", 2, paramFromServiceMsg.toString());
      notifyUI(110, false, paramToServiceMsg);
    }
    if ((paramToServiceMsg != null) && (paramToServiceMsg.uint32_result.has()) && (paramToServiceMsg.uint32_result.get() == 0))
    {
      paramToServiceMsg = paramToServiceMsg.bytes_bodybuffer.get().toByteArray();
      paramFromServiceMsg = new cmd0xaed.RspBody();
      try
      {
        paramFromServiceMsg.mergeFrom(paramToServiceMsg);
        paramToServiceMsg = paramFromServiceMsg.rpt_uint64_succ_qim_uins.get();
        if (!QLog.isColorLevel()) {
          break label220;
        }
        paramFromServiceMsg = new StringBuilder("handleAddBatchQIMFriends success ");
        paramObject = paramToServiceMsg.iterator();
        while (paramObject.hasNext())
        {
          Long localLong = (Long)paramObject.next();
          paramFromServiceMsg.append(", ");
          paramFromServiceMsg.append(localLong);
        }
        if (!QLog.isColorLevel()) {
          break label192;
        }
      }
      catch (InvalidProtocolBufferMicroException paramToServiceMsg)
      {
        paramToServiceMsg.printStackTrace();
      }
    }
    else
    {
      QLog.d("FriendListHandler.QIM", 2, "handleAddBatchQIMFriends false ");
    }
    label192:
    notifyUI(110, false, null);
    return;
    label220:
  }
  
  public void handleCheckUpdate(CheckUpdateResp paramCheckUpdateResp)
  {
    Object localObject1 = null;
    Object localObject2 = new StringBuilder().append("FriendListHandler, handleCheckUpdate, ");
    int i;
    label64:
    CheckUpdateItemInterface localCheckUpdateItemInterface;
    if (paramCheckUpdateResp != null)
    {
      i = paramCheckUpdateResp.result;
      QLog.i("ProfileService.CheckUpdateReq", 1, i);
      if ((paramCheckUpdateResp == null) || (paramCheckUpdateResp.result != 0)) {
        break label218;
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
      localCheckUpdateItemInterface = this.app.mAutomator.a(((RespItem)localObject2).eServiceID);
      if (((RespItem)localObject2).eServiceID != 101) {
        break label191;
      }
      localObject1 = localCheckUpdateItemInterface;
      paramCheckUpdateResp = (CheckUpdateResp)localObject2;
    }
    for (;;)
    {
      localObject2 = localObject1;
      localObject1 = paramCheckUpdateResp;
      paramCheckUpdateResp = (CheckUpdateResp)localObject2;
      break label64;
      i = -1;
      break;
      label191:
      handleCheckUpdateItem(localCheckUpdateItemInterface, (RespItem)localObject2);
      localObject2 = paramCheckUpdateResp;
      paramCheckUpdateResp = (CheckUpdateResp)localObject1;
      localObject1 = localObject2;
    }
    handleCheckUpdateItem(paramCheckUpdateResp, (RespItem)localObject1);
    label218:
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
    //   1: getfield 493	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: getstatic 919	com/tencent/mobileqq/app/QQManagerFactory:FRIENDS_MANAGER	I
    //   7: invokevirtual 923	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   10: checkcast 925	com/tencent/mobileqq/app/FriendsManager
    //   13: astore 7
    //   15: aload 7
    //   17: invokevirtual 2836	com/tencent/mobileqq/app/FriendsManager:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   20: astore_3
    //   21: new 448	java/util/ArrayList
    //   24: dup
    //   25: invokespecial 450	java/util/ArrayList:<init>	()V
    //   28: astore 5
    //   30: new 448	java/util/ArrayList
    //   33: dup
    //   34: invokespecial 450	java/util/ArrayList:<init>	()V
    //   37: astore 6
    //   39: aload_3
    //   40: invokevirtual 2841	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   43: aload 4
    //   45: invokevirtual 937	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   48: astore 8
    //   50: aload 8
    //   52: invokeinterface 797 1 0
    //   57: ifeq +429 -> 486
    //   60: aload 8
    //   62: invokeinterface 801 1 0
    //   67: checkcast 2843	KQQ/ProfSmpInfoRes
    //   70: astore 9
    //   72: aload 9
    //   74: getfield 2845	KQQ/ProfSmpInfoRes:dwUin	J
    //   77: invokestatic 697	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   80: astore 10
    //   82: aload_2
    //   83: aload 10
    //   85: invokevirtual 2848	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   88: ifeq -38 -> 50
    //   91: aload 9
    //   93: aload 10
    //   95: aload_0
    //   96: getfield 493	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   99: invokevirtual 586	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   102: invokevirtual 1518	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   105: aload_0
    //   106: getfield 493	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   109: aload 10
    //   111: invokestatic 2851	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:a	(LKQQ/ProfSmpInfoRes;ZLcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   114: aload 9
    //   116: getfield 2854	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   119: ifge +18 -> 137
    //   122: ldc 157
    //   124: iconst_1
    //   125: ldc_w 2856
    //   128: invokestatic 730	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   131: aload 9
    //   133: iconst_0
    //   134: putfield 2854	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   137: aload 9
    //   139: getfield 2854	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   142: invokestatic 2859	com/tencent/biz/eqq/CrmUtils:a	(I)Z
    //   145: ifne +14 -> 159
    //   148: aload 9
    //   150: getfield 2854	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   153: invokestatic 2861	com/tencent/qidian/QidianManager:b	(I)Z
    //   156: ifeq +28 -> 184
    //   159: aload 5
    //   161: aload 10
    //   163: invokeinterface 808 2 0
    //   168: pop
    //   169: aload 9
    //   171: getfield 2854	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   174: invokestatic 2859	com/tencent/biz/eqq/CrmUtils:a	(I)Z
    //   177: aload_0
    //   178: getfield 493	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   181: invokestatic 1750	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:a	(ZLcom/tencent/mobileqq/app/QQAppInterface;)V
    //   184: aload 7
    //   186: aload 9
    //   188: getfield 2845	KQQ/ProfSmpInfoRes:dwUin	J
    //   191: invokestatic 697	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   194: aload 9
    //   196: getfield 2864	KQQ/ProfSmpInfoRes:strNick	Ljava/lang/String;
    //   199: aload 9
    //   201: getfield 2854	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   204: aload 9
    //   206: getfield 2867	KQQ/ProfSmpInfoRes:cSex	B
    //   209: i2s
    //   210: aload 9
    //   212: getfield 2870	KQQ/ProfSmpInfoRes:wAge	B
    //   215: invokevirtual 2873	com/tencent/mobileqq/app/FriendsManager:a	(Ljava/lang/String;Ljava/lang/String;BSB)V
    //   218: aload 7
    //   220: aload 10
    //   222: invokevirtual 1525	com/tencent/mobileqq/app/FriendsManager:b	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   225: astore 11
    //   227: aload_0
    //   228: getfield 493	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   231: aload 9
    //   233: aload 11
    //   235: aload 10
    //   237: aload_2
    //   238: invokestatic 2876	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;LKQQ/ProfSmpInfoRes;Lcom/tencent/mobileqq/data/Card;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   241: invokestatic 507	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   244: ifeq +126 -> 370
    //   247: new 2878	java/lang/StringBuffer
    //   250: dup
    //   251: sipush 200
    //   254: invokespecial 2879	java/lang/StringBuffer:<init>	(I)V
    //   257: astore 12
    //   259: aload 12
    //   261: ldc_w 2881
    //   264: invokevirtual 2884	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   267: pop
    //   268: aload 12
    //   270: aload 9
    //   272: getfield 2887	KQQ/ProfSmpInfoRes:isShowXMan	I
    //   275: invokevirtual 2890	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   278: pop
    //   279: aload 12
    //   281: ldc_w 2892
    //   284: invokevirtual 2884	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   287: pop
    //   288: aload 12
    //   290: aload 9
    //   292: getfield 2895	KQQ/ProfSmpInfoRes:dwLoginDay	J
    //   295: invokevirtual 2898	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   298: pop
    //   299: aload 12
    //   301: ldc_w 2900
    //   304: invokevirtual 2884	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   307: pop
    //   308: aload 12
    //   310: aload 9
    //   312: getfield 2903	KQQ/ProfSmpInfoRes:dwPhoneQQXManDay	J
    //   315: invokevirtual 2898	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   318: pop
    //   319: aload 12
    //   321: ldc_w 2905
    //   324: invokevirtual 2884	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   327: pop
    //   328: aload 12
    //   330: aload 11
    //   332: getfield 2908	com/tencent/mobileqq/data/Card:allowClick	Z
    //   335: invokevirtual 2911	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   338: pop
    //   339: aload 12
    //   341: ldc_w 2913
    //   344: invokevirtual 2884	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   347: pop
    //   348: aload 12
    //   350: aload 11
    //   352: getfield 2916	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   355: invokevirtual 2911	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   358: pop
    //   359: ldc 157
    //   361: iconst_2
    //   362: aload 12
    //   364: invokevirtual 2917	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   367: invokestatic 577	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   370: aload 7
    //   372: aload 11
    //   374: invokevirtual 2920	com/tencent/mobileqq/app/FriendsManager:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   377: pop
    //   378: aload_0
    //   379: aload_1
    //   380: aload 9
    //   382: aload 6
    //   384: aload 10
    //   386: invokestatic 2923	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:a	(Lcom/tencent/mobileqq/app/FriendListHandler;Lcom/tencent/qphone/base/remote/ToServiceMsg;LKQQ/ProfSmpInfoRes;Ljava/util/List;Ljava/lang/String;)V
    //   389: aload_0
    //   390: getfield 493	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   393: aload_1
    //   394: aload 9
    //   396: invokestatic 2926	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/qphone/base/remote/ToServiceMsg;LKQQ/ProfSmpInfoRes;)V
    //   399: aload_0
    //   400: getfield 493	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   403: aload_1
    //   404: aload 9
    //   406: invokestatic 2928	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/qphone/base/remote/ToServiceMsg;LKQQ/ProfSmpInfoRes;)V
    //   409: aload_0
    //   410: iconst_3
    //   411: iconst_1
    //   412: aload 10
    //   414: invokevirtual 1003	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   417: goto -367 -> 50
    //   420: astore_2
    //   421: invokestatic 507	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   424: ifeq +13 -> 437
    //   427: ldc 157
    //   429: iconst_2
    //   430: ldc_w 2930
    //   433: aload_2
    //   434: invokestatic 2932	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   437: aload_3
    //   438: ifnull +7 -> 445
    //   441: aload_3
    //   442: invokevirtual 2935	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   445: aload_0
    //   446: getfield 493	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   449: aload 5
    //   451: invokestatic 2938	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   454: aload_0
    //   455: getfield 493	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   458: aload 6
    //   460: invokestatic 2940	com/tencent/mobileqq/app/friendlist/FriendListHandlerUtil:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   463: aload_1
    //   464: getfield 595	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   467: ldc_w 2494
    //   470: invokevirtual 1513	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   473: ifeq +12 -> 485
    //   476: aload_0
    //   477: bipush 67
    //   479: iconst_1
    //   480: aload 4
    //   482: invokevirtual 1003	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   485: return
    //   486: aload_3
    //   487: invokevirtual 2942	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   490: aload_3
    //   491: ifnull -46 -> 445
    //   494: aload_3
    //   495: invokevirtual 2935	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   498: goto -53 -> 445
    //   501: astore_1
    //   502: aload_3
    //   503: ifnull +7 -> 510
    //   506: aload_3
    //   507: invokevirtual 2935	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   510: aload_1
    //   511: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	512	0	this	FriendListHandler
    //   0	512	1	paramToServiceMsg	ToServiceMsg
    //   0	512	2	paramArrayList	ArrayList<String>
    //   0	512	3	paramFromServiceMsg	FromServiceMsg
    //   0	512	4	paramArrayList1	ArrayList<KQQ.ProfSmpInfoRes>
    //   28	422	5	localArrayList1	ArrayList
    //   37	422	6	localArrayList2	ArrayList
    //   13	358	7	localFriendsManager	FriendsManager
    //   48	13	8	localIterator	Iterator
    //   70	335	9	localProfSmpInfoRes	KQQ.ProfSmpInfoRes
    //   80	333	10	str	String
    //   225	148	11	localCard	Card
    //   257	106	12	localStringBuffer	java.lang.StringBuffer
    // Exception table:
    //   from	to	target	type
    //   39	50	420	java/lang/Exception
    //   50	137	420	java/lang/Exception
    //   137	159	420	java/lang/Exception
    //   159	184	420	java/lang/Exception
    //   184	370	420	java/lang/Exception
    //   370	417	420	java/lang/Exception
    //   486	490	420	java/lang/Exception
    //   39	50	501	finally
    //   50	137	501	finally
    //   137	159	501	finally
    //   159	184	501	finally
    //   184	370	501	finally
    //   370	417	501	finally
    //   421	437	501	finally
    //   486	490	501	finally
  }
  
  public <T> void handleMayKnowRecommendPush(int paramInt, List<T> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handleMayKnowRecommendPush: " + paramList + ", opType: " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      ThreadManager.getSubThreadHandler().post(new FriendListHandler.2(this));
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "decodePush0x210_0x111, do add mayknow list");
      }
      try
      {
        notifyUI(113, ((MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).a(true, paramList), paramList);
        return;
      }
      catch (Throwable paramList)
      {
        QLog.e("FriendListHandler", 1, paramList, new Object[0]);
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "decodePush0x210_0x111, do del mayknow list");
    }
    try
    {
      notifyUI(114, ((MayknowRecommendManager)this.app.getManager(QQManagerFactory.MAYKNOW_RECOMMEND_MANAGER)).b(true, paramList), paramList);
      return;
    }
    catch (Throwable paramList)
    {
      QLog.e("FriendListHandler", 1, paramList, new Object[0]);
    }
  }
  
  public void infoOpenId(String paramString1, String paramString2)
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
    paramString2 = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "OidbSvc.0x5e1_8");
    paramString2.putWupBuffer(localOIDBSSOPkg.toByteArray());
    paramString2.extraData.putString("uin", paramString1);
    sendPbReq(paramString2);
  }
  
  protected void init()
  {
    ThreadManager.excute(new FriendListHandler.1(this), 16, null, false);
  }
  
  public boolean isGetOnlineListRecently()
  {
    long l = System.currentTimeMillis() - this.getOnlineFriendLastTimeStamp;
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getOnlineFriend  | intervalTime = " + l + " | sGetOnlineFriendDelay = " + QQAppInterface.sGetOnlineFriendDelay);
    }
    return (this.getOnlineFriendLastTimeStamp > 0L) && ((l < QQAppInterface.sGetOnlineFriendDelay) || (l > QQAppInterface.sNextGetOnlineFriendDelay - QQAppInterface.sGetOnlineFriendDelay));
  }
  
  public boolean isNeedSendGetFriendInfo(String paramString)
  {
    long l1 = System.currentTimeMillis();
    long l2;
    synchronized (this.friendInfoDuplicateTable)
    {
      if (!this.friendInfoDuplicateTable.containsKey(paramString)) {
        break label181;
      }
      paramString = (FriendListHandler.FriendInfoDuplicate)this.friendInfoDuplicateTable.get(paramString);
      l2 = Math.abs(l1 - paramString.startTime);
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
    }
    if (l2 < 5000L) {
      return false;
    }
    paramString.count += 1L;
    if ((paramString.count >= 8L) && (l2 < 120000L)) {
      paramString.expiredTime = (l1 + 1800000L);
    }
    for (;;)
    {
      return true;
      if (l2 > 60000L)
      {
        paramString.expiredTime = 0L;
        paramString.startTime = l1;
        paramString.count = 1L;
      }
    }
    label181:
    Object localObject1;
    Object localObject2;
    if (this.friendInfoDuplicateTable.size() > 20)
    {
      localObject1 = new ArrayList();
      localObject2 = this.friendInfoDuplicateTable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        FriendListHandler.FriendInfoDuplicate localFriendInfoDuplicate = (FriendListHandler.FriendInfoDuplicate)this.friendInfoDuplicateTable.get(str);
        if (((localFriendInfoDuplicate.expiredTime == 0L) && (l1 - localFriendInfoDuplicate.startTime > 60000L)) || ((localFriendInfoDuplicate.expiredTime > 0L) && (l1 > localFriendInfoDuplicate.expiredTime))) {
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
        this.friendInfoDuplicateTable.remove(localObject2);
        i += 1;
      }
      else
      {
        localObject1 = new FriendListHandler.FriendInfoDuplicate();
        ((FriendListHandler.FriendInfoDuplicate)localObject1).startTime = l1;
        ((FriendListHandler.FriendInfoDuplicate)localObject1).count = 1L;
        this.friendInfoDuplicateTable.put(paramString, localObject1);
        break;
        i = 0;
      }
    }
  }
  
  public boolean isStatusEntryVisible()
  {
    String str;
    if (this.mStatusEntry == -1)
    {
      str = this.app.getServerConfigValue(ServerConfigManager.ConfigType.app, "StatusEntry");
      if ((str == null) || (str.length() <= 0)) {}
    }
    try
    {
      this.mStatusEntry = Integer.parseInt(str);
      if (this.mStatusEntry == 1) {
        return true;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.richstatus.mate", 2, "isStatusEntryVisible " + this.mStatusEntry + ", " + localException.toString());
        }
      }
    }
    return false;
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
    if (i < paramArrayOfString.length)
    {
      int j;
      label85:
      String[] arrayOfString;
      if (paramArrayOfString.length - i < 15)
      {
        j = paramArrayOfString.length - i;
        arrayOfString = new String[j];
        j = 0;
      }
      for (;;)
      {
        if ((j >= 15) || (i + j >= paramArrayOfString.length))
        {
          localToServiceMsg.extraData.putStringArray("uins", arrayOfString);
          send(localToServiceMsg);
          i += 15;
          break;
          j = 15;
          break label85;
        }
        arrayOfString[j] = paramArrayOfString[(i + j)];
        j += 1;
      }
    }
  }
  
  public void notifySyncSignature()
  {
    if (this.updateSignatureList != null)
    {
      getRichStatusForFriendList(this.updateSignatureList);
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
    if (msgCmdFilter(paramFromServiceMsg.getServiceCmd())) {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      }
    }
    do
    {
      Object localObject;
      do
      {
        do
        {
          do
          {
            return;
            localObject = this.handlerReceivers.iterator();
            while (((Iterator)localObject).hasNext())
            {
              BaseHandlerReceiver localBaseHandlerReceiver = (BaseHandlerReceiver)((Iterator)localObject).next();
              if (localBaseHandlerReceiver.a(paramFromServiceMsg.getServiceCmd()))
              {
                localBaseHandlerReceiver.a(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
            }
            if (!paramFromServiceMsg.getServiceCmd().equals("ProfileService.GetRichSig")) {
              break;
            }
          } while (!paramFromServiceMsg.isSuccess());
          int i = paramToServiceMsg.extraData.getInt("reqType", 0);
          if ((i == 0) || (i == 3))
          {
            handleFriendRichStatus(paramToServiceMsg, paramObject);
            return;
          }
          handleStrangerRichStatus(paramToServiceMsg, paramObject);
          return;
          if (!"ProfileService.GetSimpleInfo".equals(paramFromServiceMsg.getServiceCmd())) {
            break;
          }
          localObject = paramToServiceMsg.extraData.getStringArrayList("uinList");
        } while (!paramFromServiceMsg.isSuccess());
        paramObject = (ArrayList)paramObject;
      } while ((paramObject == null) || (localObject == null));
      handleFriendInfo(paramToServiceMsg, (ArrayList)localObject, paramFromServiceMsg, paramObject);
      return;
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
    } while (!"OidbSvc.0x777".equals(paramFromServiceMsg.getServiceCmd()));
    handleAddBatchTroopMembers(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  public void queryUinSafetyFlag(String paramString, long paramLong, int paramInt)
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
    paramString = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), paramString);
    paramString.putWupBuffer(localOIDBSSOPkg.toByteArray());
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
    this.handlerReceivers.add(new GeneralSettingsReceiver(this.app, this));
    this.handlerReceivers.add(new QueryUinFlagRecevier(this.app, this));
    this.handlerReceivers.add(new SearchFriendReceiver(this.app, this));
    this.handlerReceivers.add(new NetStatusReceiver(this.app, this));
    this.handlerReceivers.add(new DongtaiPermissionReceiver(this.app, this));
    this.handlerReceivers.add(new FriendShieldReceiver(this.app, this));
    this.handlerReceivers.add(new SuspiciousOperReceiver(this.app, this));
  }
  
  public void renameFriendGroup(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "RenameFriendGroup :" + paramByte);
    }
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).renameFriendGroup(paramByte, paramString);
  }
  
  public void reportMayknowRecommendExplosure(ConcurrentHashMap<String, MayKnowExposure> paramConcurrentHashMap)
  {
    if ((paramConcurrentHashMap == null) || (paramConcurrentHashMap.size() == 0)) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure, needReportCnt=" + paramConcurrentHashMap.size());
    }
    for (;;)
    {
      ArrayList localArrayList;
      int i;
      try
      {
        long l = Long.parseLong(this.app.getCurrentAccountUin());
        localArrayList = new ArrayList();
        paramConcurrentHashMap = paramConcurrentHashMap.entrySet().iterator();
        i = 0;
        if ((paramConcurrentHashMap.hasNext()) && (i < 99)) {
          break label189;
        }
        paramConcurrentHashMap = new oidb_0xc35.ReqBody();
        paramConcurrentHashMap.uint64_uin.set(l);
        paramConcurrentHashMap.rpt_msg_expose_info.set(localArrayList);
        sendPbReq(makeOIDBPkg("OidbSvc.0xc35_0", 3125, 0, paramConcurrentHashMap.toByteArray()));
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure, realReportCnt=" + i);
        return;
      }
      catch (Exception paramConcurrentHashMap) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("FriendListHandler", 2, "reportMayknowRecommendExplosure", paramConcurrentHashMap);
      return;
      label189:
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
      localArrayList.add(localExposeItem);
      i += 1;
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
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "reqHideConversationMayknowRecommend exception", localException);
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
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "reqHideConversationTroopRecommend exception", localException);
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
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "reqRecheckInHotReactive exception", paramString);
    }
  }
  
  public void reqRecheckInHotReactive(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendReactive.FriendListHandler", 2, "reqRecheckInHotReactive frdUin=" + paramString);
    }
    try
    {
      long l = Long.parseLong(this.app.getCurrentAccountUin());
      Object localObject = new cmd0xc83.ReqBody();
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
      while (!QLog.isColorLevel()) {}
      QLog.d("FriendListHandler", 2, "reqRecheckInHotReactive exception", paramString);
    }
  }
  
  public void resortFriendGroup(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    ((IFriendHandlerService)this.app.getRuntimeService(IFriendHandlerService.class)).resortFriendGroup(paramArrayOfByte1, paramArrayOfByte2);
  }
  
  public void saveShowPcIconIfNeccessary(byte paramByte)
  {
    byte b = 1;
    boolean bool;
    if ((paramByte == 0) || (paramByte == 1))
    {
      if (paramByte != 1) {
        break label59;
      }
      bool = true;
      if (bool != getShowPcOnlineIconConfig()) {
        if (!bool) {
          break label64;
        }
      }
    }
    label59:
    label64:
    for (paramByte = b;; paramByte = 0)
    {
      this.mShowPcIcon = paramByte;
      ContactConfig.a(this.app.getApp().getApplicationContext(), this.app.getAccount(), bool);
      return;
      bool = false;
      break;
    }
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
    if (QLog.isDevelopLevel()) {
      QLog.d("FriendListHandler", 4, "search friend with filter:" + paramInt3);
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
      l = this.app.getPreferences().getLong(Constants.Key.SvcRegister_timeStamp.toString(), 0L);
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
      localObject1 = createToServiceMsg("OidbSvc.0x5d1_0");
      ((ToServiceMsg)localObject1).extraData.putLong("friendUin", paramLong);
      ((ToServiceMsg)localObject1).extraData.putBoolean("isSet", paramBoolean);
      ((ToServiceMsg)localObject1).extraData.putInt("setId", paramInt);
      ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
      ((ToServiceMsg)localObject1).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject1);
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
  
  public void setALLRingGeneralSettings(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.ring.switch");
    localArrayList2.add(String.valueOf(paramInt));
    setGeneralSettings(localArrayList1, localArrayList2, 4);
  }
  
  public void setALLVibrateGeneralSettings(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.vibrate.switch");
    localArrayList2.add(String.valueOf(paramInt));
    setGeneralSettings(localArrayList1, localArrayList2, 5);
  }
  
  public void setBindUinStatus(byte paramByte, ArrayList<BindUin> paramArrayList)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("StatSvc.BindUin");
    localToServiceMsg.extraData.putByte("cCmd", paramByte);
    localToServiceMsg.addAttribute("vecBindUin", paramArrayList);
    send(localToServiceMsg);
  }
  
  public void setC2CRoamingGeneralSettings(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("sync.c2c_message");
    localArrayList2.add(String.valueOf(paramInt));
    setGeneralSettings(localArrayList1, localArrayList2, 6);
  }
  
  public void setDongtaiPermission(boolean paramBoolean, String paramString, int paramInt)
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
        localObject = createToServiceMsg("OidbSvc.0x7c6_0");
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
      sendPbReq((ToServiceMsg)localObject);
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
  
  public void setFriendComment(String paramString1, String paramString2, boolean paramBoolean)
  {
    setFriendComment(paramString1, paramString2, paramBoolean, false);
  }
  
  public void setFriendComment(String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    Object localObject;
    if (!paramBoolean1)
    {
      localObject = createToServiceMsg("ProfileService.ChangeFriendName");
      ((ToServiceMsg)localObject).extraData.putString("com_value", paramString2);
      ((ToServiceMsg)localObject).extraData.putString("uin", paramString1);
      ((ToServiceMsg)localObject).extraData.putBoolean("notify_plugin", paramBoolean2);
      send((ToServiceMsg)localObject);
    }
    do
    {
      return;
      localObject = paramString2;
      if (paramString2 == null) {
        localObject = "";
      }
      paramString2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
      Card localCard = paramString2.b(paramString1);
      localCard.strReMark = ((String)localObject);
      paramString2.a(localCard);
      paramString2.b(paramString1, (String)localObject);
      ((DiscussionManager)this.app.getManager(QQManagerFactory.DISCUSSION_MANAGER)).b(paramString1, (String)localObject);
      paramString1 = (PhoneContactManager)this.app.getManager(QQManagerFactory.CONTACT_MANAGER);
    } while (paramString1 == null);
    paramString1.f();
  }
  
  protected void setGeneralSettings(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2, int paramInt)
  {
    if ((paramArrayList1 == null) || (paramArrayList2 == null) || (paramArrayList1.size() != paramArrayList2.size())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayList1.size())
    {
      localArrayList.add(new Setting((String)paramArrayList1.get(i), (String)paramArrayList2.get(i)));
      i += 1;
    }
    paramArrayList1 = createToServiceMsg("ProfileService.ReqSetSettings");
    paramArrayList1.extraData.putSerializable("Settings", localArrayList);
    paramArrayList1.extraData.putInt("local_type", paramInt);
    send(paramArrayList1);
  }
  
  public void setHiddenChat(String[] paramArrayOfString, boolean[] paramArrayOfBoolean, int[] paramArrayOfInt)
  {
    int j = -1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("FriendListHandler.setHiddenChat(). uin size=");
      if (paramArrayOfString != null) {
        break label92;
      }
      i = -1;
      localObject1 = ((StringBuilder)localObject1).append(i).append(", switch size=");
      if (paramArrayOfBoolean != null) {
        break label99;
      }
    }
    label92:
    label99:
    for (int i = j;; i = paramArrayOfBoolean.length)
    {
      QLog.d("tag_hidden_chat", 2, i);
      if ((paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0) && (paramArrayOfString.length == paramArrayOfBoolean.length)) {
        break label106;
      }
      return;
      i = paramArrayOfString.length;
      break;
    }
    label106:
    Object localObject1 = new ArrayList();
    i = 0;
    if (i < paramArrayOfString.length)
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
      for (;;)
      {
        localObject3 = new oidb_0x5d6.SnsUpateBuffer();
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).uint64_uin.set(Long.parseLong((String)localObject2));
        ((oidb_0x5d6.SnsUpateBuffer)localObject3).rpt_msg_sns_update_item.set(localArrayList);
        ((List)localObject1).add(localObject3);
        i += 1;
        break;
        ((oidb_0x5d6.SnsUpdateItem)localObject3).uint32_update_sns_type.set(13581);
        localArrayList.add(localObject3);
      }
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
  
  public void setMessageNotificationSetting(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder().append("FriendListHandler.setMessageNotificationSetting(). uin size=");
      if (paramArrayOfString != null) {
        break label88;
      }
      i = -1;
      localObject1 = ((StringBuilder)localObject1).append(i).append(", switch size=");
      if (paramArrayOfBoolean != null) {
        break label95;
      }
    }
    label88:
    label95:
    for (int i = -1;; i = paramArrayOfBoolean.length)
    {
      QLog.d("tag_msg_notification", 2, i);
      if ((paramArrayOfString != null) && (paramArrayOfBoolean != null) && (paramArrayOfString.length != 0) && (paramArrayOfString.length == paramArrayOfBoolean.length)) {
        break label102;
      }
      return;
      i = paramArrayOfString.length;
      break;
    }
    label102:
    Object localObject1 = new ArrayList();
    Object localObject2 = (FriendsManager)this.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    i = 0;
    boolean bool = false;
    while (i < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i];
      Object localObject3 = ((FriendsManager)localObject2).a(str, false);
      if (localObject3 == null)
      {
        QLog.d("FriendListHandler", 1, new Object[] { "setMessageNotificationSetting: invoked. ", " extensionInfo: ", localObject3 });
        i += 1;
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
          if (k != 0)
          {
            j = 0;
            label307:
            ((ExtensionInfo)localObject5).messageEnablePreviewNew = j;
          }
        }
        do
        {
          localObject5 = MessageNotificationSettingManager.a((ExtensionInfo)localObject5);
          ((oidb_0x5d6.SnsUpdateItem)localObject4).uint32_update_sns_type.set(13582);
          ((oidb_0x5d6.SnsUpdateItem)localObject4).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject5));
          ((List)localObject3).add(localObject4);
          localObject4 = new oidb_0x5d6.SnsUpateBuffer();
          ((oidb_0x5d6.SnsUpateBuffer)localObject4).uint64_uin.set(Long.parseLong(str));
          ((oidb_0x5d6.SnsUpateBuffer)localObject4).rpt_msg_sns_update_item.set((List)localObject3);
          ((List)localObject1).add(localObject4);
          break;
          j = 1;
          break label307;
          if (paramInt == 3)
          {
            if (k != 0) {}
            for (j = 0;; j = 1)
            {
              ((ExtensionInfo)localObject5).messageEnableVibrateNew = j;
              break;
            }
          }
        } while (paramInt != 2);
        if (k != 0) {}
        for (int j = 0;; j = 1)
        {
          ((ExtensionInfo)localObject5).messageEnableSoundNew = j;
          break;
        }
      }
    }
    localObject2 = new oidb_0x5d6.ReqBody();
    ((oidb_0x5d6.ReqBody)localObject2).uint32_domain.set(1);
    ((oidb_0x5d6.ReqBody)localObject2).uint32_seq.set(0);
    ((oidb_0x5d6.ReqBody)localObject2).rpt_msg_update_buffer.set((List)localObject1);
    localObject1 = new oidb_sso.OIDBSSOPkg();
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_command.set(1494);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_result.set(0);
    ((oidb_sso.OIDBSSOPkg)localObject1).uint32_service_type.set(21);
    ((oidb_sso.OIDBSSOPkg)localObject1).bytes_bodybuffer.set(ByteStringMicro.copyFrom(((oidb_0x5d6.ReqBody)localObject2).toByteArray()));
    localObject2 = createToServiceMsg("OidbSvc.0x5d6_21");
    ((ToServiceMsg)localObject2).extraData.putInt("param_type", paramInt);
    ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
    ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void setRoamSettingNewValue(int paramInt, ConcurrentHashMap<String, Integer> paramConcurrentHashMap)
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
      paramConcurrentHashMap.add(new Setting((String)localEntry.getKey(), ((Integer)localEntry.getValue()).toString()));
    }
    localObject = createToServiceMsg("ProfileService.ReqSetSettings");
    ((ToServiceMsg)localObject).extraData.putSerializable("Settings", paramConcurrentHashMap);
    ((ToServiceMsg)localObject).extraData.putSerializable("localRevision", Integer.valueOf(paramInt));
    send((ToServiceMsg)localObject);
  }
  
  public void setShowBigClubSwitch(QQAppInterface paramQQAppInterface, boolean paramBoolean, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    for (int i = 0;; i = 1) {
      try
      {
        long l = Long.parseLong(paramQQAppInterface.getCurrentAccountUin());
        byte[] arrayOfByte = new byte[13];
        PkgTools.DWord2Byte(arrayOfByte, 0, l);
        arrayOfByte[4] = 0;
        PkgTools.Word2Byte(arrayOfByte, 5, (short)1);
        PkgTools.DWordTo2Bytes(arrayOfByte, 7, 42275);
        PkgTools.Word2Byte(arrayOfByte, 9, (short)2);
        if (paramBoolean)
        {
          PkgTools.Word2Byte(arrayOfByte, 11, (short)i);
          ProtoUtils.a(paramQQAppInterface, paramTroopProtocolObserver, arrayOfByte, "OidbSvc.0x4ff_9", 1279, 9);
          return;
        }
      }
      catch (Exception paramQQAppInterface)
      {
        while (!QLog.isColorLevel()) {}
        QLog.w("Q.dating", 2, "send_oidb_0x4ff_9 error", paramQQAppInterface);
        return;
      }
    }
  }
  
  public void setSpecialCareSwitch(int paramInt, String[] paramArrayOfString, boolean[] paramArrayOfBoolean)
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
    localObject2 = createToServiceMsg("OidbSvc.0x5d6_7");
    ((ToServiceMsg)localObject2).extraData.putInt("param_type", paramInt);
    ((ToServiceMsg)localObject2).extraData.putStringArray("param_uins", paramArrayOfString);
    ((ToServiceMsg)localObject2).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject2).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject1).toByteArray());
    sendPbReq((ToServiceMsg)localObject2);
  }
  
  public void setSpecialCareSwitchesOfAPerson(String paramString, int[] paramArrayOfInt, boolean[] paramArrayOfBoolean, String[] paramArrayOfString)
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
    localObject1 = createToServiceMsg("OidbSvc.0x5d6_7");
    ((ToServiceMsg)localObject1).extraData.putString("param_uin", paramString);
    ((ToServiceMsg)localObject1).extraData.putIntArray("param_type", paramArrayOfInt);
    ((ToServiceMsg)localObject1).extraData.putBooleanArray("param_switch_state", paramArrayOfBoolean);
    ((ToServiceMsg)localObject1).extraData.putStringArray("param_ring_ids", paramArrayOfString);
    ((ToServiceMsg)localObject1).extraData.putBoolean("param_is_set_switches_of_a_person", true);
    ((ToServiceMsg)localObject1).putWupBuffer(((oidb_sso.OIDBSSOPkg)localObject2).toByteArray());
    sendPbReq((ToServiceMsg)localObject1);
  }
  
  public void setTroopFilterGeneralSettings(ArrayList<String> paramArrayList, ArrayList<Integer> paramArrayList1)
  {
    if ((paramArrayList == null) || (paramArrayList1 == null) || (paramArrayList.size() != paramArrayList1.size())) {
      return;
    }
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      int j = ((Integer)paramArrayList1.get(i)).intValue();
      localArrayList1.add("message.group.policy." + str);
      localArrayList2.add(String.valueOf(j));
      i += 1;
    }
    setGeneralSettings(localArrayList1, localArrayList2, 1);
  }
  
  public void setTroopRingGeneralSettings(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.group.ring");
    localArrayList2.add(String.valueOf(paramInt));
    setGeneralSettings(localArrayList1, localArrayList2, 2);
  }
  
  public void setTroopVibrateGeneralSettings(int paramInt)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    localArrayList1.add("message.group.vibrate");
    localArrayList2.add(String.valueOf(paramInt));
    setGeneralSettings(localArrayList1, localArrayList2, 3);
  }
  
  public void setVisibilityForNetWorkStatus(boolean paramBoolean)
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
    if ((l2 < this.intervalGetOnlineInfo) && (l2 > -this.intervalGetOnlineInfo)) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        this.timeGetOnlineInfo = l1;
      }
      return bool;
    }
  }
  
  public boolean shouldReqLevel(String paramString)
  {
    boolean bool1 = paramString.equals(this.app.getCurrentAccountUin());
    boolean bool2 = bool1;
    long l;
    if (bool1)
    {
      l = ContactConfig.a(this.app.getApp().getApplicationContext(), this.app.getCurrentAccountUin());
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
        localDeviceInfo.bytes_device_typeinfo.set(ByteStringMicro.copyFrom(localDeviceLockItemInfo.b.getBytes()));
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
    paramString = createToServiceMsg("DevLockAuthSvc.ConfirmAuth");
    paramString.putWupBuffer(localReqBody.toByteArray());
    paramString.setTimeout(4000L);
    sendPbReq(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler
 * JD-Core Version:    0.7.0.1
 */