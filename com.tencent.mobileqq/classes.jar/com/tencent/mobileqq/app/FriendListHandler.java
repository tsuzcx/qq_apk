package com.tencent.mobileqq.app;

import AvatarInfo.QQHeadInfo;
import AvatarInfo.QQHeadUrlReq;
import AvatarInfo.QQHeadUrlResp;
import KQQ.CheckUpdateResp;
import KQQ.GetRichSigRes;
import KQQ.ResRichSigInfo;
import KQQ.RespItem;
import QQService.BindUin;
import QQService.DeviceItemDes;
import SecurityAccountServer.RespondQueryQQBindingStat;
import acvv;
import alem;
import alnb;
import amrb;
import amsu;
import amsw;
import amvo;
import amzf;
import anbx;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import anho;
import anii;
import anik;
import anil;
import anim;
import anin;
import anio;
import anip;
import aniq;
import anir;
import anis;
import anit;
import aniu;
import aniv;
import aniw;
import anix;
import aniy;
import aniz;
import anja;
import anjb;
import anjc;
import anjd;
import anje;
import anjf;
import anjg;
import anwp;
import apka;
import aric;
import arid;
import avsy;
import awhw;
import azjk;
import azsx;
import azwd;
import azwf;
import azwg;
import bbnm;
import bftf;
import bful;
import bgga;
import bily;
import bjun;
import com.qq.taf.jce.JceOutputStream;
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
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.ims.device_lock_confirm_auth.DeviceInfo;
import com.tencent.ims.device_lock_confirm_auth.ReqBody;
import com.tencent.ims.device_lock_recommend_auth.ReqBody;
import com.tencent.mobileqq.activity.contact.phonecontact.PhoneContactManagerImp;
import com.tencent.mobileqq.activity.home.Conversation;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.face.FaceDownloader;
import com.tencent.mobileqq.app.face.FaceInfo;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.app.friendlist.batchupdate.FriendInfoBatchUpdater;
import com.tencent.mobileqq.app.friendlist.batchupdate.FriendInfoBatchUpdater.FriendListSaveCallback;
import com.tencent.mobileqq.app.proxy.GroupActionResp;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil;
import com.tencent.mobileqq.app.utils.FriendsStatusUtil.UpdateFriendStatusItem;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.ExtensionInfo;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.MayKnowExposure;
import com.tencent.mobileqq.data.MayKnowRecommend;
import com.tencent.mobileqq.data.PhoneContact;
import com.tencent.mobileqq.data.QIMNotifyAddFriend;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
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
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityTransaction;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.util.SystemUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.mobileqq.vas.avatar.VasFaceManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.FriendInfo;
import friendlist.FriendListSubSrvRspCode;
import friendlist.GetFriendListResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;
import friendlist.SetGroupResp;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.ArrayList<Lcom.tencent.mobileqq.app.FriendListHandler.QQHeadDetails;>;
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
import mrb;
import nmb;
import nmf;
import npt;
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
import tencent.im.oidb.cmd0xaed.cmd0xaed.ReqBody;
import tencent.im.oidb.cmd0xaed.cmd0xaed.RspBody;
import tencent.im.oidb.cmd0xc83.ReqBody;
import tencent.im.oidb.cmd0xc85.ReqBody;
import tencent.im.oidb.cmd0xcf0.cmd0xcf0.ReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.DeleteReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.GetListReqBody;
import tencent.im.oidb.cmd0xd69.oidb_cmd0xd69.ReqBody;
import tencent.im.oidb.cmd0xd72.oidb_cmd0xd72.ReqBody;
import tencent.im.oidb.cmd0xedb.oidb_0xedb.ReqBody;
import tencent.im.oidb.oidb_0xc26.ReqBody;
import tencent.im.oidb.oidb_0xc34.ReqBody;
import tencent.im.oidb.oidb_0xc35.ExposeItem;
import tencent.im.oidb.oidb_0xc35.ReqBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.submsgtype0x111.SubMsgType0x111.MsgBody;
import tencent.im.s2c.msgtype0x210.submsgtype0x11e.SubMsgType0x11e.MsgBody;

public class FriendListHandler
  extends BusinessHandler
  implements FriendInfoBatchUpdater.FriendListSaveCallback
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
  public static final int ID_OPENID = 204;
  public static final int ID_TINYID = 202;
  public static final int ID_UIN = 200;
  private static final long INTERVAL_ONE_DAY = 86400000L;
  private static final boolean IS_USE_NEW_QQHEAD_SERVER = true;
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
  private static final int MSG_GET_HEAD = 0;
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
  public static final int QQHEAD_DOWNLOAD_TIMEOUT = 60000;
  public static final byte QQHEAD_FILE_TYPE_DELETED = 2;
  public static final byte QQHEAD_FILE_TYPE_EXIST = 1;
  public static final byte QQHEAD_FILE_TYPE_UNKNOW = 0;
  public static final byte QQHEAD_LEVEL_FOREVER = 0;
  public static final byte QQHEAD_LEVEL_TEMPORARY = 1;
  public static final long QQHEAD_SDCARD_MIN_STORAGE_SIZE = 2048L;
  public static final long QQHEAD_SYSTEM_MIN_STORAGE_SIZE = 102400L;
  public static final int QQHEAD_TYPE_APOLLO = 116;
  public static final int QQHEAD_TYPE_BLESS = 108;
  public static final int QQHEAD_TYPE_DATALINE = 102;
  public static final int QQHEAD_TYPE_DATALINE_IPAD = 107;
  public static final int QQHEAD_TYPE_DEVICE = 104;
  public static final int QQHEAD_TYPE_DISUSSION = 101;
  public static final int QQHEAD_TYPE_GROUP = 4;
  public static final int QQHEAD_TYPE_GROUP_NEW = 8;
  public static final int QQHEAD_TYPE_IMAX_AD = 114;
  public static final int QQHEAD_TYPE_MERGE_KANDIAN = 111;
  public static final int QQHEAD_TYPE_MOBILE_NUMBER = 11;
  public static final int QQHEAD_TYPE_NEW_TROOP = 113;
  public static final int QQHEAD_TYPE_PSTN_DISCUSSION = 1001;
  public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT = 115;
  public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT_ECSHOP = 106;
  public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT_SUBSCRIPT = 105;
  public static final int QQHEAD_TYPE_PUBLIC_ACCOUNT_XIN_KANDIAN = 110;
  public static final int QQHEAD_TYPE_QCALL = 16;
  public static final int QQHEAD_TYPE_SERVICE_ACCOUNT_FOLDER = 112;
  public static final int QQHEAD_TYPE_STRANGER = 32;
  public static final int QQHEAD_TYPE_SUBACCOUNT = 103;
  public static final int QQHEAD_TYPE_USER = 1;
  private static final String QQ_HEAD_FLH = "Q.qqhead.flh";
  public static final int REPORT_RECEIVE_MSGBOX = 4;
  public static final int RESULT_CODE_QQHEAD_DOWNLOAD_PIC_EXCEPTION = 9204;
  public static final int RESULT_CODE_QQHEAD_DOWNLOAD_PIC_FAIL = 9203;
  public static final int RESULT_CODE_QQHEAD_DOWNLOAD_PIC_HTTP_RESPONSE_FAIL = 9207;
  public static final int RESULT_CODE_QQHEAD_DOWNLOAD_PIC_NETWORK_FAIL = 9206;
  public static final int RESULT_CODE_QQHEAD_GET_URL_FAIL = 9201;
  public static final int RESULT_CODE_QQHEAD_SAVE_FILE_FAIL = 9202;
  public static final int RESULT_CODE_QQHEAD_STORGE_EXCEPTION = 9208;
  public static final int RESULT_CODE_QQHEAD_SUCCESS = 0;
  public static final int RESULT_CODE_QQHEAD_TIME_OUT = 9205;
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
  public static final int TYPE_ADD_BATCH_PHONE_FRIEND = 110;
  public static final int TYPE_ADD_QIMFRIENDS = 111;
  public static final int TYPE_BATCH_ADD_TROOP_MEMBERS = 112;
  public static final int TYPE_CANCEL_MAYKNOW_RECOMMEND = 93;
  public static final int TYPE_COND_SEARCH_FRIEND = 73;
  public static final int TYPE_CONVERSATION_RECOMMEND_TYPE_CHANGE = 123;
  public static final int TYPE_DEL_AUTH_DEV = 61;
  public static final int TYPE_DEL_DEVLOGININFO = 51;
  public static final int TYPE_DEL_HISTORY_DEV = 62;
  public static final int TYPE_FRIEND_LIST_ADD = 63;
  public static final int TYPE_GET_ADD_FRIEND_SECCHECK = 120;
  public static final int TYPE_GET_APOLLO_HEAD = 135;
  public static final int TYPE_GET_APOLLO_HEAD_INFO = 134;
  public static final int TYPE_GET_AUTH_DEV_LIST = 60;
  public static final int TYPE_GET_AUTO_INFO = 33;
  public static final int TYPE_GET_BOTH_DONGTAI_PERMISSIONS = 86;
  public static final int TYPE_GET_CIRCLE_RICH_STATUS = 64;
  public static final int TYPE_GET_CONNECTIONS_PERSON = 132;
  public static final int TYPE_GET_CUSTOM_HEAD = 4;
  public static final int TYPE_GET_DATENICK = 89;
  public static final int TYPE_GET_DEVLOGININFO = 50;
  public static final int TYPE_GET_FRDS_HAS_BIND_PHONE = 121;
  public static final int TYPE_GET_FRIENDNICK_BATCH = 75;
  public static final int TYPE_GET_FRIEND_INFO = 3;
  public static final int TYPE_GET_FRIEND_INFO_FINISHED = 67;
  public static final int TYPE_GET_FRIEND_LIST = 1;
  public static final int TYPE_GET_GENERAL_SETTINGS = 35;
  public static final int TYPE_GET_HEAD_INFO = 45;
  public static final int TYPE_GET_HEAD_INFO_FAIL = 133;
  public static final int TYPE_GET_HISTORY_DEV_LIST = 59;
  public static final int TYPE_GET_LAST_LOGIN_INFO = 48;
  public static final int TYPE_GET_LOGIN_DEV_LIST = 58;
  public static final int TYPE_GET_MAYKNOW_RECOMMEND = 92;
  public static final int TYPE_GET_MOBILE_QQHEAD = 39;
  public static final int TYPE_GET_NOT_ALLOWED_SEE_MYDONGTAI = 82;
  public static final int TYPE_GET_ONLINE_INFO_BY_UIN_OR_MOBILE = 68;
  public static final int TYPE_GET_QCALL_HEAD = 6;
  public static final int TYPE_GET_RECENT_LIST = 7;
  public static final int TYPE_GET_RECOMMEND_AUTH_DEVICE_LIST = 69;
  public static final int TYPE_GET_SHIELD_HISDONGTAI = 84;
  public static final int TYPE_GET_SIGNATURE = 2;
  public static final int TYPE_GET_SIG_ZAN_INFO = 94;
  public static final int TYPE_GET_SPECIAL_CARE_LIST = 99;
  public static final int TYPE_GET_SPECIAL_CARE_RECOMMEND = 95;
  public static final int TYPE_GET_STORE_FACE = 46;
  public static final int TYPE_GET_STRANGER_HEAD = 5;
  public static final int TYPE_GET_STRANGER_INFO = 66;
  public static final int TYPE_GET_STRANGER_RICH_STATUS = 65;
  public static final int TYPE_GET_TROOP_HEAD = 30;
  public static final int TYPE_GET_TROOP_HEAD_URL = 53;
  public static final int TYPE_GET_TROOP_NEWS = 55;
  public static final int TYPE_GET_TROOP_TAG = 57;
  public static final int TYPE_GLOBAL = 1;
  public static final int TYPE_HIDDEN_CHAT_SWITCH = 130;
  public static final int TYPE_HIDE_CONVERSATION_MAYKNOW_RECOMMEND = 116;
  public static final int TYPE_INFO_OPENID = 74;
  public static final int TYPE_KICKOUT_DEV = 52;
  public static final int TYPE_MAYKNOW_ENTRY_STATE_CHANGED = 113;
  public static final int TYPE_MAYKNOW_LIST_PUSHED_ADD = 114;
  public static final int TYPE_MAYKNOW_LIST_PUSHED_DEL = 115;
  public static final int TYPE_NEW_SEARCH_FRIEND = 49;
  public static final int TYPE_NOTIFICATION_PREVIEW = 1;
  public static final int TYPE_NOTIFICATION_SOUND = 2;
  public static final int TYPE_NOTIFICATION_VIBRATE = 3;
  public static final int TYPE_NOTIFY_ADDREQ_STATES_CHANGED = 105;
  public static final int TYPE_NOTIFY_CHAT_HOT_DAY_UPDATE = 107;
  public static final int TYPE_NOTIFY_GROUP_INITED = 103;
  public static final int TYPE_NOTIFY_MAYKNOW_STATE_CHANGED = 108;
  public static final int TYPE_NOTIFY_OLYMPIC_TORCH_UPDATE = 106;
  public static final int TYPE_NOTIFY_PULL_IPAD_STATE = 102;
  public static final int TYPE_NOTIFY_PUSH_RECOMMEND_FRIEND = 109;
  public static final int TYPE_NOTIFY_STRANGER_DOWNLOADURL_READY = 104;
  public static final int TYPE_OIDB_0X476_146 = 71;
  public static final int TYPE_OIDB_0X476_147 = 72;
  public static final int TYPE_OIDB_0X88D_1 = 54;
  public static final int TYPE_QZONE = 3;
  public static final int TYPE_RECOMMEND_TROOP_JOINED_OR_DELETED = 122;
  public static final int TYPE_REQ_GET_SHOW_NETWORK_STATUS_TO_FRIENDS = 77;
  public static final int TYPE_REQ_LAST_CHAT_TIME = 118;
  public static final int TYPE_REQ_RECHECKIN_HOTREACTIVE = 117;
  public static final int TYPE_REQ_SET_COMMENT = 27;
  public static final int TYPE_REQ_SET_SHOW_NETWORK_STATUS_TO_FRIENDS = 76;
  public static final int TYPE_REQ_SET_SIGNATURE = 28;
  public static final int TYPE_REQ_SHIELD_FRIENDS_LIST = 119;
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
  public static final int TYPE_SET_MESSAGE_NOTIFICATION_SWITCH = 131;
  public static final int TYPE_SET_MESSAGE_ROAM = 101;
  public static final int TYPE_SET_NOT_ALLOWED_SEE_MYDONGTAI = 81;
  public static final int TYPE_SET_SHIELD_HISDONGTAI = 83;
  public static final int TYPE_SET_SPECIAL_CARE_RING = 78;
  public static final int TYPE_SET_SPECIAL_CARE_SWITCHES_OF_A_PERSON = 100;
  public static final int TYPE_SET_SPECIAL_CARE_SWITCH_GLOBAL = 96;
  public static final int TYPE_SET_SPECIAL_CARE_SWITCH_QZONE = 98;
  public static final int TYPE_SET_SPECIAL_CARE_SWITCH_SPECIAL_RING = 97;
  public static final int TYPE_SPECIAL_RING = 2;
  public static final int TYPE_SUSPICIOUS_AGREE = 129;
  public static final int TYPE_SUSPICIOUS_CLEAR = 127;
  public static final int TYPE_SUSPICIOUS_DELETE_UIN = 126;
  public static final int TYPE_SUSPICIOUS_GET_LIST = 125;
  public static final int TYPE_SUSPICIOUS_GET_UNREAD_NUM = 124;
  public static final int TYPE_SUSPICIOUS_REPORT = 128;
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
  private int destQQHeadInfoCount;
  private Hashtable<Integer, ArrayList<FriendListHandler.QQHeadDetails>> destQQHeadInfoTable = new Hashtable();
  private Hashtable<String, Long> downloadedQQHeadTable = new Hashtable();
  private Object downloadedQQHeadTableLock = new Object();
  private long failedStartTime;
  private int friendCountGeted;
  private Hashtable<String, FriendListHandler.FriendInfoDuplicate> friendInfoDuplicateTable = new Hashtable();
  private long getFriendGroupListTimeStamp;
  private long getOnlineFriendLastTimeStamp;
  private MqqHandler handler;
  private List<anio> handlerReceivers = new ArrayList();
  public long intervalGetOnlineInfo = 15000L;
  private boolean isDoneSaveQQHeadToStorage;
  private boolean isImmediatelyGet;
  private boolean isSyncingAllFriendsRichStatus;
  private long lastFriendListUpdateTime;
  private final azwf mAddFrdTokenHelper = new azwf();
  private azwg mBatchAddFriendData;
  private int mFriendListFailedCount;
  private HashMap<Long, String> mOfflineTips;
  private ArrayList<oidb_0x7df.FriendScore> mRecommendList = new ArrayList();
  private final Object mRecommendLock = new Object();
  private volatile int mShowPcIcon = -1;
  private int mStatusEntry = -1;
  private QQHeadDownloadHandler qqHeadDownload;
  private Object qqHeadDownloadLock = new Object();
  public ArrayList<PhoneContact> requestingPhoneArr;
  private int retryTotalCount;
  private short shBatchSeqTypeField = 20002;
  private Hashtable<String, FriendListHandler.QQHeadStat> statGetQQHeadTime = new Hashtable();
  private long timeGetOnlineInfo;
  private String[] updateSignatureList;
  
  protected FriendListHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
    init();
    registerHandlerReceivers();
  }
  
  private void addFriendInternal(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2, String paramString6, Bundle paramBundle)
  {
    Object localObject2;
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      if (paramBundle != null) {
        paramBundle.getString("troop_uin");
      }
      localObject2 = new StringBuilder(300);
      localStringBuilder = ((StringBuilder)localObject2).append("addFriendInternal, uin:").append(paramString1).append(", sourceID:").append(paramInt2).append(", subSourceId:").append(paramInt3).append(", extraUin:").append(paramString2).append(", friendSetting:").append(paramInt1).append(", groupId:").append(paramByte1).append(", msg:").append(paramString3).append(", autoSend:").append(paramBoolean1).append(", isContactBothWay:").append(paramBoolean2).append(", remark:").append(paramString4).append(", sourceName:").append(paramString5).append(", myCard:").append(paramByte2).append(", extraParam:").append(paramBundle).append(", sig:");
      if (paramArrayOfByte != null) {
        break label531;
      }
      localObject1 = "null";
      localStringBuilder = localStringBuilder.append(localObject1).append(", ticket:");
      if (paramString6 != null) {
        break label542;
      }
    }
    label531:
    label542:
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
          break label381;
        }
        l1 = ((SubMsgType0x111.MsgBody)localObject).uint64_type.get();
        if (QLog.isColorLevel()) {
          QLog.i("FriendListHandler", 2, "decodePush0x210_0x111,type = " + l1);
        }
        paramQQAppInterface = (FriendListHandler)paramQQAppInterface.getBusinessHandler(1);
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
      label381:
      long l1 = -1L;
    }
  }
  
  private void deleteStrangerInfo(amsw paramamsw)
  {
    Object localObject = alem.a(this.app);
    if ((paramamsw != null) && (localObject != null) && (((Set)localObject).size() > 0))
    {
      localObject = ((Set)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str = (String)((Iterator)localObject).next();
        if (!paramamsw.b(str))
        {
          alem.b(str, this.app);
          if (alem.b(str, this.app)) {
            alem.c(str, this.app);
          }
        }
      }
    }
  }
  
  private void doExecuteGetQQHead()
  {
    for (;;)
    {
      label152:
      int i;
      Object localObject3;
      try
      {
        this.handler.removeMessages(0);
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead start !!! ");
        }
        if (this.destQQHeadInfoCount > 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.qqhead.flh", 2, "doExecuteGetQQHead destQQHeadInfoCount = " + this.destQQHeadInfoCount);
          }
          localObject1 = this.app.getCurrentAccountUin();
          if (localObject1 == null) {
            break label587;
          }
        }
        Enumeration localEnumeration;
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
          localEnumeration = this.destQQHeadInfoTable.keys();
        }
        if (!localEnumeration.hasMoreElements()) {
          break label566;
        }
        i = ((Integer)localEnumeration.nextElement()).intValue();
        Object localObject1 = (List)this.destQQHeadInfoTable.get(Integer.valueOf(i));
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "em.hasMoreElements() QQHeadDetails head_or_id = " + i);
        }
        if (!QLog.isColorLevel()) {
          break label357;
        }
        localObject3 = new StringBuilder("doExecuteGetQQHead sendRequests for QQHeadInfo head_or_id=").append(i);
        Iterator localIterator = ((List)localObject1).iterator();
        if (localIterator.hasNext())
        {
          FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator.next();
          ((StringBuilder)localObject3).append(" QQheadDetail uinOrMobile=").append(StringUtil.getSimpleUinForPrint(localQQHeadDetails.uinOrMobile)).append(",Timestamp=").append(localQQHeadDetails.headImgTimestamp).append("|");
          continue;
        }
        ((StringBuilder)localObject3).append(" QQHeadDetailList length = ").append(localList.size());
      }
      finally {}
      QLog.d("FriendListHandler", 2, ((StringBuilder)localObject3).toString());
      label357:
      if ((localList != null) && (!localList.isEmpty())) {}
      for (Object localObject2 = anho.a(localList, 50);; localObject2 = null)
      {
        if (localObject2 == null) {
          break label585;
        }
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = new ArrayList((List)((Iterator)localObject2).next());
          if (i == 11)
          {
            realGetQQHead(l, i, (ArrayList)localObject3);
          }
          else if (i == 116)
          {
            realGetQQHead_Apollo(l, i, (ArrayList)localObject3);
          }
          else if (i >= 200)
          {
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "realGetQQHead_Stranger = " + i);
            }
            realGetQQHead_Stranger(i, (ArrayList)localObject3);
          }
          else if (i == 16)
          {
            realGetQQHead_QCall(i, (ArrayList)localObject3);
            if (QLog.isColorLevel()) {
              QLog.d("Q.qqhead.flh", 2, "QQHEAD_TYPE_QCALL = " + i);
            }
          }
          else
          {
            realGetQQHead_New(l, i, (ArrayList)localObject3);
          }
        }
        break label152;
        label566:
        this.destQQHeadInfoCount = 0;
        this.destQQHeadInfoTable.clear();
        break;
      }
      label585:
      continue;
      label587:
      long l = -1L;
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
  
  private void fetchRichStatusIfNeed(ArrayList<String> paramArrayList)
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
  
  private void getChangedQQHeadList_New(byte paramByte1, byte paramByte2, QQHeadUrl.QQHeadUrlRsp paramQQHeadUrlRsp, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList, List<FriendListHandler.QQHeadDetails> paramList, List<QQHeadInfo> paramList1)
  {
    List localList;
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      localList = paramQQHeadUrlRsp.dstHeadInfos.get();
      paramArrayList = paramArrayList.iterator();
    }
    label60:
    label320:
    for (;;)
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails;
      Object localObject;
      QQHeadUrl.RspHeadInfo localRspHeadInfo;
      if (paramArrayList.hasNext())
      {
        localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.next();
        localObject = localList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label316;
        }
        localRspHeadInfo = (QQHeadUrl.RspHeadInfo)((Iterator)localObject).next();
        if (paramByte2 == 1)
        {
          paramQQHeadUrlRsp = localRspHeadInfo.dstUid.get();
          label96:
          if (!localQQHeadDetails.uinOrMobile.equals(paramQQHeadUrlRsp)) {
            break label290;
          }
          localObject = new QQHeadInfo();
          ((QQHeadInfo)localObject).headLevel = localQQHeadDetails.level;
          if (paramByte2 != 1) {
            break label292;
          }
          ((QQHeadInfo)localObject).phoneNum = localRspHeadInfo.dstUid.get();
          ((QQHeadInfo)localObject).dwTimestamp = localRspHeadInfo.timestamp.get();
          ((QQHeadInfo)localObject).cHeadType = ((byte)localRspHeadInfo.faceType.get());
          ((QQHeadInfo)localObject).dstUsrType = paramByte1;
          ((QQHeadInfo)localObject).dwFaceFlgas = ((byte)localRspHeadInfo.faceFlag.get());
          ((QQHeadInfo)localObject).downLoadUrl = localRspHeadInfo.url.get();
          ((QQHeadInfo)localObject).systemHeadID = ((short)localRspHeadInfo.sysid.get());
          if (!localRspHeadInfo.headVerify.has()) {
            break label308;
          }
          paramQQHeadUrlRsp = localRspHeadInfo.headVerify.get();
          label240:
          ((QQHeadInfo)localObject).headVerify = paramQQHeadUrlRsp;
          paramList1.add(localObject);
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          break label320;
        }
        paramList.add(localQQHeadDetails);
        break;
        paramQQHeadUrlRsp = String.valueOf(localRspHeadInfo.dstUin.get());
        break label96;
        break label60;
        ((QQHeadInfo)localObject).uin = localRspHeadInfo.dstUin.get();
        break label145;
        paramQQHeadUrlRsp = "";
        break label240;
        return;
      }
    }
  }
  
  private void getChangedQQHeadList_QCall(int paramInt, List<MultiHeadUrl.RspUsrHeadInfo> paramList, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList, List<FriendListHandler.QQHeadDetails> paramList1, List<QQHeadInfo> paramList2)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    FriendListHandler.QQHeadDetails localQQHeadDetails;
    label36:
    String str;
    Object localObject;
    if (localIterator1.hasNext())
    {
      localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      for (;;)
      {
        if (localIterator2.hasNext())
        {
          paramArrayList = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
          str = azjk.a(paramArrayList.dstUin.get());
          if (localQQHeadDetails.uinOrMobile.equals(str))
          {
            localObject = paramArrayList.dstHeadInfos.get();
            paramArrayList = null;
            Iterator localIterator3 = ((List)localObject).iterator();
            label102:
            if (localIterator3.hasNext())
            {
              localObject = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
              ((MultiHeadUrl.RspHeadInfo)localObject).usrType.get();
              if (((MultiHeadUrl.RspHeadInfo)localObject).faceType.get() == 0) {
                break label571;
              }
              paramArrayList = (ArrayList<FriendListHandler.QQHeadDetails>)localObject;
            }
          }
        }
      }
    }
    label154:
    label442:
    label571:
    for (;;)
    {
      break label102;
      int i;
      if (paramArrayList != null)
      {
        localObject = this.app.getQQHeadSetting(16, str, paramInt);
        if (this.app.isFaceFileExist(16, str, paramInt, 0)) {
          break label442;
        }
        int j = 1;
        i = j;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.qqhead.", 2, "handleQQHead_QCALL file not exist.id=" + str + ",idType=" + paramInt);
          i = j;
        }
        label239:
        if (i == 0) {
          break label561;
        }
        localObject = new QQHeadInfo();
        ((QQHeadInfo)localObject).headLevel = localQQHeadDetails.level;
        ((QQHeadInfo)localObject).idType = paramInt;
        ((QQHeadInfo)localObject).phoneNum = str;
        ((QQHeadInfo)localObject).dwTimestamp = paramArrayList.timestamp.get();
        ((QQHeadInfo)localObject).cHeadType = ((byte)paramArrayList.faceType.get());
        ((QQHeadInfo)localObject).dstUsrType = 16;
        ((QQHeadInfo)localObject).dwFaceFlgas = ((byte)paramArrayList.faceFlag.get());
        ((QQHeadInfo)localObject).downLoadUrl = paramArrayList.url.get();
        ((QQHeadInfo)localObject).systemHeadID = ((short)paramArrayList.sysid.get());
        ((QQHeadInfo)localObject).originUsrType = paramArrayList.usrType.get();
        if (!paramArrayList.headVerify.has()) {
          break label563;
        }
      }
      for (paramArrayList = paramArrayList.headVerify.get();; paramArrayList = "")
      {
        ((QQHeadInfo)localObject).headVerify = paramArrayList;
        paramList2.add(localObject);
        break label36;
        if (0 != 0)
        {
          paramArrayList = null;
          break label154;
        }
        if (!QLog.isColorLevel()) {
          break label36;
        }
        QLog.d("headqcall", 2, "there is no headinfo uin=" + str);
        break label36;
        break;
        if (localObject != null)
        {
          localObject = (com.tencent.mobileqq.data.Setting)((Pair)localObject).second;
          if (QLog.isColorLevel()) {
            QLog.i("Q.qqhead.", 2, "handleQQHead_QCALL setting=" + localObject + "targetInfo.timestamp=" + paramArrayList.timestamp.get());
          }
          if (localObject == null)
          {
            i = 1;
            break label239;
          }
          if (((com.tencent.mobileqq.data.Setting)localObject).headImgTimestamp != paramArrayList.timestamp.get())
          {
            i = 1;
            break label239;
          }
          paramList1.add(localQQHeadDetails);
          i = 0;
          break label239;
        }
        i = 1;
        break label239;
        break label36;
      }
      return;
    }
  }
  
  private void getChangedQQHeadList_Stranger(int paramInt1, int paramInt2, List<MultiHeadUrl.RspUsrHeadInfo> paramList, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList, List<FriendListHandler.QQHeadDetails> paramList1, List<QQHeadInfo> paramList2)
  {
    Iterator localIterator1 = paramArrayList.iterator();
    FriendListHandler.QQHeadDetails localQQHeadDetails;
    label37:
    String str;
    label76:
    Object localObject2;
    Object localObject1;
    label114:
    int i;
    if (localIterator1.hasNext())
    {
      localQQHeadDetails = (FriendListHandler.QQHeadDetails)localIterator1.next();
      Iterator localIterator2 = paramList.iterator();
      if (localIterator2.hasNext())
      {
        paramArrayList = (MultiHeadUrl.RspUsrHeadInfo)localIterator2.next();
        if (paramInt2 == 0)
        {
          str = String.valueOf(paramArrayList.dstUin.get());
          if (!localQQHeadDetails.uinOrMobile.equals(str)) {
            break label191;
          }
          localObject2 = paramArrayList.dstHeadInfos.get();
          localObject1 = null;
          paramArrayList = null;
          Iterator localIterator3 = ((List)localObject2).iterator();
          if (!localIterator3.hasNext()) {
            break label218;
          }
          localObject2 = (MultiHeadUrl.RspHeadInfo)localIterator3.next();
          i = ((MultiHeadUrl.RspHeadInfo)localObject2).usrType.get();
          if (i != 1) {
            break label193;
          }
          localObject1 = localObject2;
        }
      }
    }
    label256:
    label544:
    label552:
    for (;;)
    {
      break label114;
      if (paramInt2 == 1)
      {
        str = String.valueOf(paramArrayList.dstTid.get());
        break label76;
      }
      str = paramArrayList.dstOpenid.get();
      break label76;
      label191:
      break label37;
      label193:
      if ((i == 32) && (((MultiHeadUrl.RspHeadInfo)localObject2).faceType.get() != 0))
      {
        paramArrayList = (ArrayList<FriendListHandler.QQHeadDetails>)localObject2;
        continue;
        label218:
        if (paramArrayList != null)
        {
          label223:
          localObject1 = this.app.getQQHeadSetting(32, str, paramInt1);
          if (this.app.isFaceFileExist(32, str, paramInt1, 0)) {
            break label472;
          }
          i = 1;
          if (i == 0) {
            break label552;
          }
          localObject1 = new QQHeadInfo();
          ((QQHeadInfo)localObject1).headLevel = localQQHeadDetails.level;
          ((QQHeadInfo)localObject1).idType = paramInt1;
          ((QQHeadInfo)localObject1).phoneNum = str;
          ((QQHeadInfo)localObject1).dwTimestamp = paramArrayList.timestamp.get();
          ((QQHeadInfo)localObject1).cHeadType = ((byte)paramArrayList.faceType.get());
          ((QQHeadInfo)localObject1).dstUsrType = 32;
          ((QQHeadInfo)localObject1).dwFaceFlgas = ((byte)paramArrayList.faceFlag.get());
          ((QQHeadInfo)localObject1).downLoadUrl = paramArrayList.url.get();
          ((QQHeadInfo)localObject1).systemHeadID = ((short)paramArrayList.sysid.get());
          ((QQHeadInfo)localObject1).originUsrType = paramArrayList.usrType.get();
          if (!paramArrayList.headVerify.has()) {
            break label544;
          }
        }
        for (paramArrayList = paramArrayList.headVerify.get();; paramArrayList = "")
        {
          ((QQHeadInfo)localObject1).headVerify = paramArrayList;
          paramList2.add(localObject1);
          break;
          if (localObject1 != null)
          {
            paramArrayList = (ArrayList<FriendListHandler.QQHeadDetails>)localObject1;
            break label223;
          }
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("headstranger", 2, "there is no headinfo uin=" + str);
          break;
          label472:
          if (localObject1 != null)
          {
            localObject1 = (com.tencent.mobileqq.data.Setting)((Pair)localObject1).second;
            if (localObject1 == null)
            {
              i = 1;
              break label256;
            }
            if (((com.tencent.mobileqq.data.Setting)localObject1).headImgTimestamp != paramArrayList.timestamp.get())
            {
              i = 1;
              break label256;
            }
            paramList1.add(localQQHeadDetails);
            i = 0;
            break label256;
          }
          i = 1;
          break label256;
        }
        notifyUI(5, true, new Object[] { localQQHeadDetails.uinOrMobile, Integer.valueOf(paramInt1), Boolean.valueOf(true) });
        break label37;
        break;
        return;
      }
    }
  }
  
  private void getFriendList(String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, long paramLong, ArrayList<String> paramArrayList, boolean paramBoolean1, boolean paramBoolean2, short paramShort)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.contacttab.friend", 2, "getFriendGroupList " + paramBoolean1 + ", " + paramString + ", " + paramInt1 + ", " + paramInt2 + ", " + paramInt3 + ", " + paramInt4 + ", " + paramLong);
    }
    if (!paramBoolean1)
    {
      if (((amsw)this.app.getManager(51)).c()) {
        notifyUI(1, true, null);
      }
    }
    else {
      notifyUI(1, true, Boolean.valueOf(false));
    }
    paramString = createToServiceMsg("friendlist.getFriendGroupList");
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
    send(paramString);
  }
  
  private void getQQHead(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, int paramInt3, boolean paramBoolean)
  {
    label102:
    Object localObject;
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.qqhead.flh", 2, "getQQHead, uin=" + paramString + ",headType=" + paramInt1 + ",idType=" + paramInt2 + ",level=" + paramByte1 + ",faceFileType=" + paramByte2);
      }
      if (!TextUtils.isEmpty(paramString))
      {
        if (paramInt1 != 1) {
          break label102;
        }
        paramBoolean = Friends.isValidUin(paramString);
        if (paramBoolean) {
          break label102;
        }
      }
      for (;;)
      {
        return;
        localObject = QQAppInterface.getFaceDownKey(paramInt1, paramString, paramInt2, paramInt3);
        if (isNeedDownloadedQQHead((String)localObject)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead, noNeedDownload= " + (String)localObject);
        }
      }
      markDownloadedQQHead((String)localObject, false);
    }
    finally {}
    boolean bool;
    label195:
    label255:
    int i;
    if ((this.app.mAutomator != null) && (this.app.mAutomator.b()))
    {
      bool = true;
      if (!QLog.isColorLevel()) {
        break label516;
      }
      QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead end keyStr = " + (String)localObject + ",isImmediatelyGet=" + this.isImmediatelyGet + ",InActionLoginB=" + bool);
      break label516;
      this.destQQHeadInfoCount += 1;
      localObject = (ArrayList)this.destQQHeadInfoTable.get(Integer.valueOf(i));
      if (localObject != null) {
        break label507;
      }
      localObject = new ArrayList();
      this.destQQHeadInfoTable.put(Integer.valueOf(i), localObject);
      if (!QLog.isColorLevel()) {
        break label528;
      }
      QLog.d("Q.qqhead.flh", 2, "QQHEAD_TYPE_QCALL destQQHeadInfoTable.put(keyType, destQQHeadInfoList); keyType = " + i + "destQQHeadInfoTable.size = " + this.destQQHeadInfoTable.size());
      break label528;
    }
    for (;;)
    {
      paramBoolean = this.app.isFaceFileExist(paramInt1, paramString, paramInt2, paramInt3);
      for (;;)
      {
        long l2 = 0L;
        long l1 = l2;
        if (paramBoolean)
        {
          Pair localPair = this.app.getQQHeadSetting(paramInt1, paramString, paramInt2);
          l1 = l2;
          if (localPair != null)
          {
            l1 = l2;
            if (localPair.second != null) {
              l1 = ((com.tencent.mobileqq.data.Setting)localPair.second).headImgTimestamp;
            }
          }
        }
        ((ArrayList)localObject).add(new FriendListHandler.QQHeadDetails(paramInt1, paramString, l1, paramByte1, paramInt3));
        if ((!this.isImmediatelyGet) && (bool) && (!TextUtils.equals(paramString, this.app.getCurrentAccountUin()))) {
          break;
        }
        doExecuteGetQQHead();
        break;
        bool = false;
        break label195;
        paramBoolean = true;
        continue;
        paramBoolean = false;
      }
      label507:
      break label528;
      label516:
      do
      {
        i = paramInt1;
        break;
      } while (paramInt1 != 32);
      i = paramInt2;
      break label255;
      label528:
      switch (paramByte2)
      {
      }
    }
  }
  
  private void getQQHeadInSubThread(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, int paramInt3, boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new FriendListHandler.4(this, paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramInt3, paramBoolean), 8, null, false);
      return;
    }
    getQQHead(paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramInt3, paramBoolean);
  }
  
  private void getQQHeadInSubThread(int paramInt1, String paramString, int paramInt2, byte paramByte1, byte paramByte2, boolean paramBoolean)
  {
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      ThreadManager.post(new FriendListHandler.3(this, paramInt1, paramString, paramInt2, paramByte1, paramByte2, paramBoolean), 8, null, false);
      return;
    }
    getQQHead(paramInt1, paramString, paramInt2, paramByte1, paramByte2, 0, paramBoolean);
  }
  
  private void handleAddBatchTroopMembers(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (this.mBatchAddFriendData == null) {
      return;
    }
    this.mBatchAddFriendData.a(this, paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
  
  private boolean handleCheckUpdateItem(bbnm parambbnm, RespItem paramRespItem)
  {
    if ((parambbnm == null) || (paramRespItem == null)) {
      return false;
    }
    try
    {
      parambbnm.a(paramRespItem);
      return true;
    }
    catch (OutOfMemoryError parambbnm)
    {
      QLog.d("ProfileService.CheckUpdateReq", 1, String.format("encounter OutOfMemoryError when handleCheckUpdateItem() sId=%d ret=%d ex=%s \n%s", new Object[] { Integer.valueOf(paramRespItem.eServiceID), Byte.valueOf(paramRespItem.cResult), parambbnm.getMessage(), Log.getStackTraceString(parambbnm) }));
      return true;
    }
    catch (Throwable parambbnm)
    {
      QLog.d("ProfileService.CheckUpdateReq", 1, parambbnm.getMessage(), parambbnm);
    }
    return true;
  }
  
  private void handleFriendRichStatus(ToServiceMsg paramToServiceMsg, Object paramObject)
  {
    paramObject = (GetRichSigRes)paramObject;
    amsw localamsw = (amsw)this.app.getManager(51);
    if ((paramObject == null) || (paramObject.cResult != 0) || (paramObject.vstSigInfo == null) || (paramObject.vstSigInfo.size() == 0) || (localamsw == null))
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
        ExtensionInfo localExtensionInfo = localamsw.a(str);
        paramObject = localExtensionInfo;
        if (localExtensionInfo == null)
        {
          paramObject = new ExtensionInfo();
          paramObject.uin = str;
        }
        if ((paramObject.richTime != localResRichSigInfo.dwTime) || (!Arrays.equals(paramObject.richBuffer, localResRichSigInfo.vbSigInfo)))
        {
          paramObject.setRichBuffer(localResRichSigInfo.vbSigInfo, localResRichSigInfo.dwTime);
          paramObject.isAdded2C2C = SignatureManager.a(this.app, str, paramObject.getRichStatus());
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
      localamsw.b(localArrayList1);
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
        paramFromServiceMsg = (amsw)this.app.getManager(51);
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
  
  private void handleGetFriendDetailInfo(ToServiceMsg paramToServiceMsg, GetFriendListResp paramGetFriendListResp)
  {
    if ((paramGetFriendListResp.result == 1) || (paramGetFriendListResp.vecFriendInfo == null) || (paramGetFriendListResp.vecFriendInfo.isEmpty()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleGetFriendDetailInfo failed");
      }
      return;
    }
    FriendInfo localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
    paramToServiceMsg = new Friends();
    anjg localanjg = new anjg(this.app, this);
    localanjg.a(paramToServiceMsg, localFriendInfo);
    anjf localanjf = new anjf(this.app, this);
    localanjf.a(paramToServiceMsg, localFriendInfo, paramGetFriendListResp);
    paramGetFriendListResp = new anje(this.app);
    paramGetFriendListResp.a(paramToServiceMsg, localFriendInfo);
    localanjg.a(paramToServiceMsg);
    localanjf.a();
    paramGetFriendListResp.a();
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "$handleGetFriendDetailInfo | uin = " + paramToServiceMsg.uin + " | group = " + paramToServiceMsg.groupid);
    }
    if (this.getFriendGroupListTimeStamp == 0L) {
      notifyUI(1, true, Boolean.valueOf(true));
    }
    paramGetFriendListResp = (avsy)this.app.getManager(11);
    if (paramGetFriendListResp != null) {
      paramGetFriendListResp.f();
    }
    getRichStatus(new String[] { paramToServiceMsg.uin });
  }
  
  private void handleGetFriendList(String paramString, GetFriendListResp paramGetFriendListResp, ToServiceMsg paramToServiceMsg)
  {
    long l = paramToServiceMsg.extraData.getLong("timeStamp");
    ArrayList localArrayList = paramToServiceMsg.extraData.getStringArrayList("uinList");
    boolean bool2 = paramToServiceMsg.extraData.getBoolean("is_manual_pull_refresh");
    int m = paramGetFriendListResp.startIndex;
    int n = paramGetFriendListResp.friend_count;
    int k = paramGetFriendListResp.wGetExtSnsRspCode;
    int i = 0;
    if (paramGetFriendListResp.stSubSrvRspCode != null) {
      i = paramGetFriendListResp.stSubSrvRspCode.wGetMutualMarkRspCode;
    }
    for (int j = paramGetFriendListResp.stSubSrvRspCode.wGetIntimateInfoRspCode;; j = 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.contacttab.friend", 2, "handleGetFriendList " + paramGetFriendListResp.result + ", " + paramGetFriendListResp.serverTime + ", " + m + ", " + n + " totalCount=" + paramGetFriendListResp.totoal_friend_count + " wGetExtSnsRspCode:" + k + " wGetMutualMarkRspCode:" + i + " wGetIntimateInfoRspCode:" + j);
      }
      if (paramGetFriendListResp.result == 1)
      {
        QLog.e("FriendListHandler", 2, "handleGetFriendList fail code");
        notifyUI(1, false, Boolean.valueOf(false));
        notifyUI(99, false, null);
        if (paramToServiceMsg.extraData.getShort("friendTotalCount") == 0) {}
        for (i = paramGetFriendListResp.totoal_friend_count;; i = paramToServiceMsg.extraData.getShort("friendTotalCount"))
        {
          reportGetFriendList(false, i, paramToServiceMsg.extraData.getShort("friendStartIndex"), 1);
          return;
        }
      }
      bjun.a("handleGetFriendList");
      if (m == 0)
      {
        this.friendCountGeted = 0;
        l = System.currentTimeMillis();
      }
      saveShowPcIconIfNeccessary(paramGetFriendListResp.cShowPcIcon);
      amsw localamsw = (amsw)this.app.getManager(51);
      anim.a(this.app, paramGetFriendListResp);
      anim.a(this.app, paramGetFriendListResp, l);
      if (m + n >= paramGetFriendListResp.totoal_friend_count) {}
      int i1;
      Object localObject;
      FriendInfoBatchUpdater localFriendInfoBatchUpdater;
      anil localanil;
      anik localanik;
      for (boolean bool1 = true;; bool1 = false)
      {
        i1 = paramGetFriendListResp.vecFriendInfo.size();
        this.friendCountGeted += i1;
        localObject = new Friends[i1];
        localFriendInfoBatchUpdater = new FriendInfoBatchUpdater(this.app, (Friends[])localObject, l, bool1, this);
        localanil = new anil(this.app, i1, l, bool1, k, i);
        localanik = new anik(this.app, i1);
        k = 0;
        while (k < i1)
        {
          FriendInfo localFriendInfo = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(k);
          Friends localFriends = new Friends();
          localFriendInfoBatchUpdater.update(localFriends, localFriendInfo);
          localanil.a(localFriends, localFriendInfo);
          localanik.a(localFriends, localFriendInfo);
          localObject[k] = localFriends;
          localArrayList.add(localFriends.uin);
          k += 1;
        }
      }
      bily.a(this.app, (Friends[])localObject);
      localFriendInfoBatchUpdater.saveInBatch();
      localanil.a();
      localanik.a();
      if ((i1 > 0) && (QLog.isColorLevel()))
      {
        localObject = (FriendInfo)paramGetFriendListResp.vecFriendInfo.get(0);
        QLog.i("FriendListHandler", 2, "FriendListHandler handleGetFriendList uin=" + ((FriendInfo)localObject).friendUin + " | eNetwork=" + ((FriendInfo)localObject).eNetworkType + " | iTermType=" + ((FriendInfo)localObject).iTermType + " | abilityBits=" + ((FriendInfo)localObject).uAbiFlag + " | name=" + bftf.a(((FriendInfo)localObject).nick) + " | netTypeIconId=" + ((FriendInfo)localObject).eIconType + " | detalStatusFlag=" + ((FriendInfo)localObject).detalStatusFlag + " | isMqqOnLine=" + ((FriendInfo)localObject).isMqqOnLine + " | netTypeIconIdIphoneOrWphoneNoWifi=" + ((FriendInfo)localObject).eIconType + " | hasTorch=" + ((FriendInfo)localObject).cOlympicTorch);
      }
      bjun.a();
      if (!bool1)
      {
        getFriendList(paramString, m + n, 200, 0, 0, l, localArrayList, true, bool2, paramGetFriendListResp.totoal_friend_count);
        notifyUI(1, true, Boolean.valueOf(false));
        notifyUI(99, true, new Object[] { Boolean.valueOf(false), null });
        return;
      }
      if (paramToServiceMsg.extraData.getShort("friendTotalCount") == 0)
      {
        k = paramGetFriendListResp.totoal_friend_count;
        reportGetFriendList(true, k, paramToServiceMsg.extraData.getShort("friendStartIndex"), 0);
        this.getFriendGroupListTimeStamp = 0L;
        this.friendCountGeted = 0;
        paramString = new StringBuilder().append("actual friend count is ");
        if (this.friendCountGeted != paramGetFriendListResp.totoal_friend_count) {
          break label1068;
        }
        bool1 = true;
        label885:
        QLog.d("FriendListHandler", 2, bool1);
        paramString = (PhoneContactManagerImp)this.app.getManager(11);
        paramString.f();
        if (!bool2) {
          paramString.b();
        }
        this.app.notifyFriendListSynced();
        notifyUI(1, true, Boolean.valueOf(true));
        notifyUI(99, true, new Object[] { Boolean.valueOf(true), null });
        fetchRichStatusIfNeed(localArrayList);
        deleteStrangerInfo(localamsw);
        amzf.a(this.app, "775_hot_friend_new_boat_clear_version");
        amzf.a(this.app, "top_position_and_disturb_clear_version");
        amzf.a(this.app, "check_message_preview_version_clear");
        this.lastFriendListUpdateTime = paramGetFriendListResp.serverTime;
        paramString = this.app;
        if (i != 0) {
          break label1074;
        }
        bool1 = true;
        label1028:
        if (j != 0) {
          break label1080;
        }
      }
      label1068:
      label1074:
      label1080:
      for (bool2 = true;; bool2 = false)
      {
        anim.a(paramString, bool1, bool2, paramGetFriendListResp.serverTime);
        getGatheredContactsList(0);
        return;
        k = paramToServiceMsg.extraData.getShort("friendTotalCount");
        break;
        bool1 = false;
        break label885;
        bool1 = false;
        break label1028;
      }
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
          amsw localamsw;
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
                ((amsw)this.app.getManager(51)).f(paramToServiceMsg);
              }
              paramToServiceMsg = localGetSNFrdListRsp.rpt_msg_one_frd_data.get();
              localamsw = (amsw)this.app.getManager(51);
              if (paramToServiceMsg == null) {
                break label593;
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
                localFriends.recommReason = localamsw.a(m);
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
          localamsw.a(localArrayList, i);
          label593:
          if (localGetSNFrdListRsp.uint32_recommend_frd_count.has())
          {
            i = localGetSNFrdListRsp.uint32_recommend_frd_count.get();
            paramFromServiceMsg.append("|recommend cnt=").append(i);
            localamsw.b(i);
            label634:
            boolean bool = paramObject.msg_box.has();
            this.app.getHandler(Conversation.class);
            if (!bool) {
              break label826;
            }
            if (QLog.isColorLevel()) {
              QLog.i("FriendListHandler", 2, "handleGetGatheredContactsList  has MsgBox. ");
            }
            paramToServiceMsg = this.app.getApp().getSharedPreferences(this.app.getAccount(), 0);
            bool = paramToServiceMsg.getBoolean("hasPulledRecomGathered", false);
            paramToServiceMsg.edit().putBoolean("hasMsgBox", true).commit();
            paramFromServiceMsg.append("|has no MsgBox hasPulled=").append(bool);
            label739:
            if (k != 0) {
              break label837;
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
            break label634;
            label826:
            paramFromServiceMsg.append("|has no MsgBox");
            break label739;
            label837:
            paramFromServiceMsg.append("|not Completed. continue to get. Completed.");
            this.app.getApp().getSharedPreferences(this.app.getAccount(), 0).edit().putInt("GetFrdListReq_seq", j).commit();
            notifyUI(79, true, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true) });
            if (localamsw != null) {
              localamsw.h();
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
  
  private void handleGetQQHeadError(ToServiceMsg paramToServiceMsg, int paramInt)
  {
    ArrayList localArrayList = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject1 = localStringBuilder.append("handleGetQQHeadError, result=").append(paramInt).append(", uinListSize=");
    if (localArrayList != null) {}
    for (int i = localArrayList.size();; i = -1)
    {
      ((StringBuilder)localObject1).append(i);
      if ((localArrayList != null) && (localArrayList.size() != 0)) {
        break;
      }
      QLog.i("Q.qqhead.flh", 1, localStringBuilder.toString());
      return;
    }
    i = 0;
    while (i < localArrayList.size())
    {
      localObject1 = (FriendListHandler.QQHeadDetails)localArrayList.get(i);
      int j = paramToServiceMsg.extraData.getInt("idType", 0);
      Object localObject2 = QQAppInterface.getFaceDownKey(((FriendListHandler.QQHeadDetails)localObject1).userType, ((FriendListHandler.QQHeadDetails)localObject1).uinOrMobile, j, 0);
      markDownloadedQQHead((String)localObject2, true);
      statGetQQHeadCostTime(9201, (String)localObject2, ((FriendListHandler.QQHeadDetails)localObject1).userType, 2, 0, null, paramInt, 0L);
      localStringBuilder.append("; uin=").append((String)localObject2).append(", timestamp=").append(((FriendListHandler.QQHeadDetails)localObject1).headImgTimestamp);
      localObject2 = (anwp)this.app.getManager(199);
      if ((localObject2 != null) && (((anwp)localObject2).a())) {
        ((anwp)localObject2).a(((FriendListHandler.QQHeadDetails)localObject1).uinOrMobile);
      }
      i += 1;
    }
    QLog.i("Q.qqhead.flh", 1, localStringBuilder.toString());
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
        amsw localamsw = (amsw)this.app.getManager(51);
        int j = 0;
        while (j < n)
        {
          i = 0;
          long l = bftf.a(localByteBuffer.getInt());
          paramObject = localamsw.a(String.valueOf(l));
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
              boolean bool1 = anii.a(localByteBuffer, paramToServiceMsg, m);
              boolean bool2 = anii.b(localByteBuffer, paramToServiceMsg, m);
              boolean bool3 = anii.c(localByteBuffer, paramToServiceMsg, m);
              anii.a(this.app, localByteBuffer, l, m);
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
        localamsw.b(localArrayList);
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
  
  private void handleOnReceiveGetFriendGroupList(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, GetFriendListResp paramGetFriendListResp)
  {
    if (paramFromServiceMsg.isSuccess()) {
      if (paramGetFriendListResp != null) {
        if (paramToServiceMsg.extraData.getBoolean("getSingleFriend")) {
          handleGetFriendDetailInfo(paramToServiceMsg, paramGetFriendListResp);
        }
      }
    }
    short s;
    do
    {
      do
      {
        return;
        if (paramToServiceMsg.extraData.getByte("ifShowTermType", (byte)0).byteValue() == 1)
        {
          handleGetFriendList(paramFromServiceMsg.getUin(), paramGetFriendListResp, paramToServiceMsg);
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
        reportGetFriendList(false, i, s, paramFromServiceMsg.getResultCode());
        this.getFriendGroupListTimeStamp = 0L;
      }
      notifyUI(1, false, null);
      notifyUI(99, false, null);
      return;
      if ((paramFromServiceMsg.getResultCode() != 2901) || (paramToServiceMsg == null) || (paramToServiceMsg.extraData == null)) {
        break label344;
      }
      int i = paramToServiceMsg.extraData.getInt("k_resend_cnt", 0);
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "k_resend_cnt" + i);
      }
      if (i >= 2) {
        break;
      }
      paramToServiceMsg.extraData.putInt("k_resend_cnt", i + 1);
      send(paramToServiceMsg);
    } while (paramToServiceMsg.extraData.getBoolean("getSingleFriend"));
    this.retryTotalCount += 1;
    return;
    if (!paramToServiceMsg.extraData.getBoolean("getSingleFriend"))
    {
      QLog.e("FriendListHandler", 1, "getFriendList timeout");
      s = paramToServiceMsg.extraData.getShort("friendStartIndex");
      reportGetFriendList(false, paramToServiceMsg.extraData.getShort("friendTotalCount"), s, paramFromServiceMsg.getResultCode());
      this.getFriendGroupListTimeStamp = 0L;
    }
    notifyUI(1, false, null);
    notifyUI(99, false, null);
    return;
    label344:
    if ((paramToServiceMsg != null) && (paramToServiceMsg.extraData != null) && (!paramToServiceMsg.extraData.getBoolean("getSingleFriend")))
    {
      QLog.e("FriendListHandler", 1, "getFriendList fail " + paramFromServiceMsg.getResultCode());
      s = paramToServiceMsg.extraData.getShort("friendStartIndex");
      reportGetFriendList(false, paramToServiceMsg.extraData.getShort("friendTotalCount"), s, paramFromServiceMsg.getResultCode());
      this.getFriendGroupListTimeStamp = 0L;
    }
    notifyUI(1, false, null);
    notifyUI(99, false, null);
  }
  
  private void handleQQHead(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, QQHeadUrlResp paramQQHeadUrlResp)
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
        handleGetQQHeadError(paramToServiceMsg, i);
        if (QLog.isColorLevel()) {
          QLog.d("FriendListHandler", 2, "handleQQHead handleResp for QQHeadInfo appear error and error code =" + i);
        }
        return;
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.getResultCode();
        }
      }
      paramFromServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      Object localObject;
      if ((paramFromServiceMsg != null) && (paramFromServiceMsg.size() > 0))
      {
        paramToServiceMsg = new ArrayList();
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
            if (((localQQHeadInfo.dstUsrType == 11) || (!((FriendListHandler.QQHeadDetails)localObject).uinOrMobile.equals(Long.toString(localQQHeadInfo.uin)))) && ((localQQHeadInfo.dstUsrType != 11) || (!((FriendListHandler.QQHeadDetails)localObject).uinOrMobile.equals(localQQHeadInfo.phoneNum)))) {
              break;
            }
            localQQHeadInfo.headLevel = ((FriendListHandler.QQHeadDetails)localObject).level;
            paramToServiceMsg.add(localQQHeadInfo);
          }
        }
        paramQQHeadUrlResp.UserHeadInfoList = paramToServiceMsg;
      }
      insureInitQQHeadDownloadHandler();
      paramToServiceMsg = new StringBuilder("handleQQHead handleResp for QQHeadInfo");
      i = 0;
      while (i < paramQQHeadUrlResp.UserHeadInfoList.size())
      {
        paramFromServiceMsg = (QQHeadInfo)paramQQHeadUrlResp.UserHeadInfoList.get(i);
        statGetQQHeadCostTime(0, getUinOrMobile(paramFromServiceMsg.dstUsrType, paramFromServiceMsg.uin, paramFromServiceMsg.phoneNum), paramFromServiceMsg.dstUsrType, 2);
        paramToServiceMsg.append(" qqHeadUrlResp id=").append(i).append(" QQHeadInfo.uin=").append(StringUtil.getSimpleUinForPrint(Long.toString(paramFromServiceMsg.uin))).append(" QQHeadInfo.systemId=").append(paramFromServiceMsg.systemHeadID).append("  QQHeadInfo.headtype=").append(paramFromServiceMsg.cHeadType).append("|");
        localObject = new FaceInfo();
        ((FaceInfo)localObject).jdField_a_of_type_AvatarInfoQQHeadInfo = paramFromServiceMsg;
        this.qqHeadDownload.addDownloadRequest((FaceInfo)localObject);
        i += 1;
      }
    } while (!QLog.isColorLevel());
    QLog.d("FriendListHandler", 2, paramToServiceMsg.toString());
  }
  
  private void handleQQHeadNoChangeList(int paramInt1, int paramInt2, List<FriendListHandler.QQHeadDetails> paramList)
  {
    if (paramList.size() > 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FriendListHandler", 2, "handleQQHead_New noChangeQQHeadInfoList");
      }
      EntityManager localEntityManager = this.app.getEntityManagerFactory().createEntityManager();
      EntityTransaction localEntityTransaction = localEntityManager.getTransaction();
      localEntityTransaction.begin();
      int i = 0;
      try
      {
        while (i < paramList.size())
        {
          FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramList.get(i);
          com.tencent.mobileqq.data.Setting localSetting = (com.tencent.mobileqq.data.Setting)localEntityManager.find(com.tencent.mobileqq.data.Setting.class, QQAppInterface.getFaceSettingKey(paramInt1, localQQHeadDetails.uinOrMobile, paramInt2));
          if (localSetting != null)
          {
            localSetting.updateTimestamp = System.currentTimeMillis();
            this.app.updateSettingTableCache(localSetting);
            localEntityManager.update(localSetting);
          }
          markDownloadedQQHead(QQAppInterface.getFaceDownKey(paramInt1, localQQHeadDetails.uinOrMobile, paramInt2, localQQHeadDetails.sizeType), true);
          i += 1;
        }
        return;
      }
      catch (Exception paramList)
      {
        localEntityTransaction.commit();
        localEntityTransaction.end();
      }
    }
  }
  
  private void handleQQHead_New(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramFromServiceMsg != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramFromServiceMsg.getResultCode() == 1000)
      {
        localObject1 = localObject2;
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
        localQQHeadUrlRsp = null;
        continue;
        if (paramFromServiceMsg != null) {
          i = paramFromServiceMsg.getResultCode();
        }
      }
      notifyUI(133, false, new Object[] { Integer.valueOf(0), paramToServiceMsg });
    }
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "handleQQHead_New qqHeadUrlResp=" + localObject1 + " qqHeadUrlRespData = " + paramObject);
    }
    QQHeadUrl.QQHeadUrlRsp localQQHeadUrlRsp;
    if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (localObject1 == null) || (((QQHeadUrl.QQHeadUrlRsp)localObject1).result.get() != 0))
    {
      i = 65535;
      if (localObject1 != null)
      {
        i = ((QQHeadUrl.QQHeadUrlRsp)localObject1).result.get();
        handleGetQQHeadError(paramToServiceMsg, i);
        i = paramToServiceMsg.extraData.getInt("dstUsrType", 1);
        if ((i != 1) && (i != 32)) {
          break label297;
        }
        paramFromServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
        paramToServiceMsg = new ArrayList();
        if (!(paramFromServiceMsg instanceof ArrayList)) {
          break label274;
        }
        paramFromServiceMsg = ((ArrayList)paramFromServiceMsg).iterator();
        while (paramFromServiceMsg.hasNext())
        {
          paramObject = paramFromServiceMsg.next();
          if ((paramObject instanceof FriendListHandler.QQHeadDetails)) {
            paramToServiceMsg.add(((FriendListHandler.QQHeadDetails)paramObject).uinOrMobile);
          }
        }
      }
      label274:
      label297:
      return;
    }
    int i = localQQHeadUrlRsp.dstUsrType.get();
    if (i == 8) {
      i = 4;
    }
    for (;;)
    {
      byte b = (byte)localQQHeadUrlRsp.dstEncryptType.get();
      paramObject = new ArrayList();
      paramFromServiceMsg = new ArrayList();
      paramToServiceMsg = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
      getChangedQQHeadList_New((byte)i, b, localQQHeadUrlRsp, paramToServiceMsg, paramFromServiceMsg, paramObject);
      startDownloadQQHead(paramObject, false);
      handleQQHeadNoChangeList(i, 0, paramFromServiceMsg);
      if ((paramFromServiceMsg.size() <= 0) || ((i != 1) && (i != 32))) {
        break;
      }
      paramToServiceMsg = new ArrayList(paramFromServiceMsg.size());
      paramFromServiceMsg = paramFromServiceMsg.iterator();
      while (paramFromServiceMsg.hasNext()) {
        paramToServiceMsg.add(((FriendListHandler.QQHeadDetails)paramFromServiceMsg.next()).uinOrMobile);
      }
      notifyUI(133, true, new Object[] { Integer.valueOf(0), paramToServiceMsg });
      return;
    }
  }
  
  private void handleQQHead_QCall(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ArrayList localArrayList1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "handleQQHead_QCall ....");
    }
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {
          break label263;
        }
        localObject = new MultiHeadUrl.MultiBusidUrlRsp();
        ((MultiHeadUrl.MultiBusidUrlRsp)localObject).mergeFrom((byte[])paramObject);
        paramObject = localObject;
      }
      catch (Exception paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + paramObject.getMessage());
        paramObject.printStackTrace();
        paramObject = localArrayList1;
        continue;
        if (paramFromServiceMsg == null) {
          continue;
        }
        int i = paramFromServiceMsg.getResultCode();
        continue;
        paramFromServiceMsg = paramObject.dstUsrHeadInfos.get();
        localArrayList1 = new ArrayList();
        Object localObject = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
        ArrayList localArrayList2 = new ArrayList();
        paramObject.dstUidType.get();
        i = paramToServiceMsg.extraData.getInt("idType");
        getChangedQQHeadList_QCall(i, paramFromServiceMsg, (ArrayList)localObject, localArrayList1, localArrayList2);
        startDownloadQQHead(localArrayList2, true);
        handleQQHeadNoChangeList(16, i, localArrayList1);
        return;
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
      {
        i = 65535;
        if (paramObject != null)
        {
          i = paramObject.result.get();
          handleGetQQHeadError(paramToServiceMsg, i);
          return;
        }
      }
      label263:
      paramObject = null;
    }
  }
  
  private void handleQQHead_Stranger(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    ArrayList localArrayList1 = null;
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger ....");
    }
    if (paramFromServiceMsg != null) {}
    for (;;)
    {
      try
      {
        if ((paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null)) {
          break label266;
        }
        localObject = new MultiHeadUrl.MultiBusidUrlRsp();
        ((MultiHeadUrl.MultiBusidUrlRsp)localObject).mergeFrom((byte[])paramObject);
        paramObject = localObject;
      }
      catch (Exception paramObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.qqhead.flh", 2, "handleQQHead_Stranger multiBusidUrlRsp mergeFrom exception..." + paramObject.getMessage());
        paramObject.printStackTrace();
        paramObject = localArrayList1;
        continue;
        if (paramFromServiceMsg == null) {
          continue;
        }
        int i = paramFromServiceMsg.getResultCode();
        continue;
        paramFromServiceMsg = paramObject.dstUsrHeadInfos.get();
        localArrayList1 = new ArrayList();
        Object localObject = paramToServiceMsg.extraData.getParcelableArrayList("uinList");
        ArrayList localArrayList2 = new ArrayList();
        i = paramObject.dstUidType.get();
        int j = paramToServiceMsg.extraData.getInt("idType");
        getChangedQQHeadList_Stranger(j, i, paramFromServiceMsg, (ArrayList)localObject, localArrayList1, localArrayList2);
        startDownloadQQHead(localArrayList2, true);
        handleQQHeadNoChangeList(32, j, localArrayList1);
        return;
      }
      if ((paramFromServiceMsg == null) || (paramFromServiceMsg.getResultCode() != 1000) || (paramObject == null) || (paramObject.result.get() != 0))
      {
        i = 65535;
        if (paramObject != null)
        {
          i = paramObject.result.get();
          handleGetQQHeadError(paramToServiceMsg, i);
          return;
        }
      }
      label266:
      paramObject = null;
    }
  }
  
  private void handleSetGroupResp(ToServiceMsg paramToServiceMsg, SetGroupResp paramSetGroupResp)
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
      amsw localamsw = (amsw)this.app.getManager(51);
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
          localObject1 = localamsw.a(((AddGroupResp)localObject2).cGroupId + "");
          if (localObject1 == null) {
            break label301;
          }
          ((Groups)localObject1).group_id = ((AddGroupResp)localObject2).cGroupId;
          ((Groups)localObject1).seqid = ((AddGroupResp)localObject2).cSortId;
          ((Groups)localObject1).group_name = paramToServiceMsg.extraData.getString("group_name");
        }
        for (paramToServiceMsg = (ToServiceMsg)localObject1;; paramToServiceMsg = (ToServiceMsg)localObject1)
        {
          localamsw.a(paramToServiceMsg);
          notifyUI(18, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (AddGroupResp)localObject2));
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
          paramToServiceMsg = localamsw.a(String.valueOf(i));
          if (paramToServiceMsg == null) {
            break label492;
          }
        }
        for (paramToServiceMsg.group_name = ((RenameGroupResp)localObject2).sGroupName;; paramToServiceMsg.group_name = ((RenameGroupResp)localObject2).sGroupName)
        {
          localamsw.a(paramToServiceMsg);
          notifyUI(19, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (RenameGroupResp)localObject2));
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
        handleDelGroupResp(paramToServiceMsg, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, paramToServiceMsg));
        return;
      case 3: 
        label301:
        label492:
        localObject2 = new ReSortGroupResp();
        if (bool)
        {
          ((ReSortGroupResp)localObject2).dwToUin = ((ByteBuffer)localObject1).getInt();
          ((ReSortGroupResp)localObject2).dwSequence = ((ByteBuffer)localObject1).getInt();
          localamsw.a(paramToServiceMsg.extraData.getByteArray("group_id_list"), paramToServiceMsg.extraData.getByteArray("sort_id_list"));
        }
        notifyUI(22, bool, new GroupActionResp(paramSetGroupResp.result, paramSetGroupResp.ErrorString, (ReSortGroupResp)localObject2));
        return;
      }
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
      notifyUI(130, k, new Object[] { arrayOfString, arrayOfBoolean });
      return;
      int m = 0;
    }
  }
  
  private void handleSetMessageNotificationSettingResp(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("tag_msg_notification", 2, "FriendListHandler.handleSetMessageNotificationSettingResp(). res=" + paramFromServiceMsg + ", data=" + paramObject);
    }
    apka localapka = apka.a(this.app);
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
            localapka.a(arrayOfString[i], j, arrayOfBoolean[i]);
            i += 1;
          }
        }
      }
    }
    for (;;)
    {
      notifyUI(131, bool, new Object[] { arrayOfString, arrayOfBoolean, Integer.valueOf(j) });
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
              alem.a(paramFromServiceMsg, "1", this.app);
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
            alem.a(paramFromServiceMsg, "1", this.app);
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
          paramToServiceMsg = (amsw)this.app.getManager(51);
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
              alem.a(str, "1", this.app);
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
            alem.a(str, paramFromServiceMsg, this.app);
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
          paramToServiceMsg = (amsw)this.app.getManager(51);
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
  
  private void insureInitQQHeadDownloadHandler()
  {
    if (this.qqHeadDownload == null) {
      synchronized (this.qqHeadDownloadLock)
      {
        if (this.qqHeadDownload == null) {
          this.qqHeadDownload = new QQHeadDownloadHandler(this.app, this);
        }
        return;
      }
    }
  }
  
  private Map<String, Integer> makeGrneralPathMap(ArrayList<GeneralSettings.Setting> paramArrayList)
  {
    HashMap localHashMap = new HashMap();
    if (paramArrayList != null)
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        GeneralSettings.Setting localSetting = (GeneralSettings.Setting)paramArrayList.get(i);
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
  
  private void realGetQQHead(long paramLong, int paramInt, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("AvatarInfoSvr.QQHeadUrlReq", null);
    Object localObject = new ArrayList();
    int i = 0;
    while (i < paramArrayList.size())
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(i);
      ((ArrayList)localObject).add(localQQHeadDetails.getDestQQHeadInfo());
      statGetQQHeadCostTime(0, localQQHeadDetails.uinOrMobile, localQQHeadDetails.userType, 1);
      i += 1;
    }
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    paramArrayList = new QQHeadUrlReq(paramLong, (ArrayList)localObject, (byte)paramInt);
    localObject = new JceOutputStream();
    ((JceOutputStream)localObject).setServerEncoding("UTF-8");
    paramArrayList.writeTo((JceOutputStream)localObject);
    localToServiceMsg.extraData.putByteArray("QQHeadUrlReq", ((JceOutputStream)localObject).toByteArray());
    send(localToServiceMsg);
  }
  
  private void realGetQQHead_Apollo(long paramLong, int paramInt, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList)
  {
    if (QLog.isColorLevel())
    {
      localObject = new ArrayList();
      if (paramArrayList != null)
      {
        Iterator localIterator = paramArrayList.iterator();
        while (localIterator.hasNext()) {
          ((List)localObject).add(((FriendListHandler.QQHeadDetails)localIterator.next()).uinOrMobile);
        }
      }
      QLog.d("FriendListHandler", 2, String.format("realGetQQHead_Apollo selfUin=%s headType=%s uinList=%s", new Object[] { Long.valueOf(paramLong), Integer.valueOf(paramInt), Arrays.toString(((List)localObject).toArray()) }));
    }
    Object localObject = anin.a(paramArrayList);
    if (localObject != null)
    {
      localObject = makeOIDBPkg("OidbSvc.0xedb", 3803, 0, ((oidb_0xedb.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putParcelableArrayList("key_request_list", paramArrayList);
      sendPbReq((ToServiceMsg)localObject);
    }
  }
  
  private void realGetQQHead_New(long paramLong, int paramInt, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    int i = paramInt;
    if (paramInt == 4) {
      i = 8;
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("IncreaseURLSvr.QQHeadUrlReq", null);
    QQHeadUrl.QQHeadUrlReq localQQHeadUrlReq = new QQHeadUrl.QQHeadUrlReq();
    localQQHeadUrlReq.srcUsrType.set(1);
    localQQHeadUrlReq.srcUin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localQQHeadUrlReq.dstUsrType.set(i);
    paramInt = 0;
    while (paramInt < paramArrayList.size())
    {
      FriendListHandler.QQHeadDetails localQQHeadDetails = (FriendListHandler.QQHeadDetails)paramArrayList.get(paramInt);
      QQHeadUrl.ReqUsrInfo localReqUsrInfo = new QQHeadUrl.ReqUsrInfo();
      try
      {
        localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.uinOrMobile));
        statGetQQHeadCostTime(0, localQQHeadDetails.uinOrMobile, localQQHeadDetails.userType, 1);
        localReqUsrInfo.timestamp.set((int)localQQHeadDetails.headImgTimestamp);
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
    localToServiceMsg.extraData.putInt("dstUsrType", i);
    localToServiceMsg.putWupBuffer(localQQHeadUrlReq.toByteArray());
    sendPbReq(localToServiceMsg);
  }
  
  private void realGetQQHead_QCall(int paramInt, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {
      return;
    }
    MultiHeadUrl.MultiBusidUrlReq localMultiBusidUrlReq = new MultiHeadUrl.MultiBusidUrlReq();
    localMultiBusidUrlReq.srcUidType.set(0);
    localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.app.getCurrentAccountUin()));
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
        localReqUsrInfo.dstUin.set(azjk.b(localQQHeadDetails.uinOrMobile));
        statGetQQHeadCostTime(0, localQQHeadDetails.uinOrMobile, localQQHeadDetails.userType, 1);
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
    ToServiceMsg localToServiceMsg = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
    localToServiceMsg.extraData.putParcelableArrayList("uinList", paramArrayList);
    localToServiceMsg.extraData.putLong("startTime", System.currentTimeMillis());
    localToServiceMsg.extraData.putInt("idType", paramInt);
    localToServiceMsg.extraData.putInt("qqHeadType", 16);
    localToServiceMsg.putWupBuffer(localMultiBusidUrlReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.flh", 2, "realGetQQHead_QCall .  idType = " + paramInt);
    }
    sendPbReq(localToServiceMsg);
  }
  
  private void realGetQQHead_Stranger(int paramInt, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList)
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
      localMultiBusidUrlReq.srcUin.set(Long.parseLong(this.app.getCurrentAccountUin()));
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
          localReqUsrInfo.dstUin.set(Long.parseLong(localQQHeadDetails.uinOrMobile));
          for (;;)
          {
            statGetQQHeadCostTime(0, localQQHeadDetails.uinOrMobile, localQQHeadDetails.userType, 1);
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
            localReqUsrInfo.dstTid.set(Long.parseLong(localQQHeadDetails.uinOrMobile));
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
                localReqUsrInfo.dstOpenid.set(localException.uinOrMobile);
              }
            }
          }
        }
      }
    }
    Object localObject = new HashMap();
    ((HashMap)localObject).put("connum", String.valueOf(paramArrayList.size()));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), "actNearbyHeadConNum", true, 0L, 0L, (HashMap)localObject, "");
    localObject = createToServiceMsg("MultibusidURLSvr.HeadUrlReq", null);
    ((ToServiceMsg)localObject).extraData.putParcelableArrayList("uinList", paramArrayList);
    ((ToServiceMsg)localObject).extraData.putLong("startTime", System.currentTimeMillis());
    ((ToServiceMsg)localObject).extraData.putInt("idType", paramInt);
    ((ToServiceMsg)localObject).putWupBuffer(localMultiBusidUrlReq.toByteArray());
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.flh", 2, "realGetQQHead_Stranger .  idType = " + paramInt);
    }
    sendPbReq((ToServiceMsg)localObject);
  }
  
  private void relayGetRichStatus(ToServiceMsg paramToServiceMsg)
  {
    doGetRichStatus(paramToServiceMsg.extraData.getStringArray("totalArray"), paramToServiceMsg.extraData.getInt("nextStartPos"), paramToServiceMsg.extraData.getInt("reqType"), paramToServiceMsg.extraData.getBundle("circleBundle"), paramToServiceMsg.extraData.getBoolean("showDateNickname"));
  }
  
  private void reportFailedDetails()
  {
    if ((this.failedStartTime != 0L) && (this.mFriendListFailedCount != 0))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("mFriendListFailedCount", this.mFriendListFailedCount + "");
      localHashMap.put("failedTime", System.currentTimeMillis() - this.failedStartTime + "");
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "QQFriendListReqFailedStatistics", true, 0L, 0L, localHashMap, null);
      this.mFriendListFailedCount = 0;
      this.failedStartTime = 0L;
    }
  }
  
  private void reportGetFriendList(boolean paramBoolean, int paramInt1, short paramShort, int paramInt2)
  {
    HashMap localHashMap = new HashMap();
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      localHashMap.put("reqGetStatus", str);
      localHashMap.put("currNetStatus", HttpUtil.getNetWorkTypeByStr());
      localHashMap.put("friendListCount", "" + paramInt1);
      localHashMap.put("fromIndex", "" + paramShort);
      localHashMap.put("reqCountEveryPage", "200");
      localHashMap.put("retryCount", "" + this.retryTotalCount);
      localHashMap.put("totalConsume", "" + (System.currentTimeMillis() - this.getFriendGroupListTimeStamp));
      localHashMap.put("errorCode", "" + paramInt2);
      StatisticCollector.getInstance(BaseApplicationImpl.getApplication()).collectPerformance(null, "QQFriendListReqGetEvent", true, 0L, 0L, localHashMap, null);
      this.retryTotalCount = 0;
      if (paramBoolean) {
        break;
      }
      this.mFriendListFailedCount += 1;
      if (this.failedStartTime == 0L) {
        this.failedStartTime = this.getFriendGroupListTimeStamp;
      }
      return;
    }
    reportFailedDetails();
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
      Card localCard = ((amsw)this.app.getManager(51)).c(paramString);
      l1 = bful.b(localContext, paramString) + 28800000L;
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
      Card localCard = ((amsw)this.app.getManager(51)).c(paramString);
      l1 = bful.c(localContext, paramString);
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
  
  private void startDownloadQQHead(List<QQHeadInfo> paramList, boolean paramBoolean)
  {
    insureInitQQHeadDownloadHandler();
    int i = 0;
    if (i < paramList.size())
    {
      QQHeadInfo localQQHeadInfo = (QQHeadInfo)paramList.get(i);
      statGetQQHeadCostTime(0, getUinOrMobile(localQQHeadInfo.uin, localQQHeadInfo.phoneNum), localQQHeadInfo.dstUsrType, 2);
      FaceInfo localFaceInfo = new FaceInfo();
      if (paramBoolean) {}
      for (String str = localQQHeadInfo.phoneNum;; str = String.valueOf(localQQHeadInfo.uin))
      {
        localFaceInfo.jdField_a_of_type_JavaLangString = str;
        localFaceInfo.b = localQQHeadInfo.idType;
        localFaceInfo.jdField_a_of_type_Int = localQQHeadInfo.dstUsrType;
        localFaceInfo.d = localQQHeadInfo.sizeType;
        localFaceInfo.jdField_a_of_type_AvatarInfoQQHeadInfo = localQQHeadInfo;
        localFaceInfo.jdField_c_of_type_Int = arid.b(arid.a(localFaceInfo.d), arid.b(localFaceInfo.d));
        this.qqHeadDownload.addDownloadRequest(localFaceInfo);
        i += 1;
        break;
      }
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
    addFriendInternal(paramString1, paramString2, paramInt1, paramByte, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, (byte)0, "", null);
  }
  
  public void addFriend(String paramString1, String paramString2, int paramInt1, byte paramByte, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, Bundle paramBundle)
  {
    addFriendInternal(paramString1, paramString2, paramInt1, paramByte, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, (byte)0, "", paramBundle);
  }
  
  public void addFriendGroup(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "AddFriendGroup :" + paramString);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 0);
    localToServiceMsg.extraData.putByte("sort_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    send(localToServiceMsg);
  }
  
  public boolean addFriendToFriendList(String paramString1, int paramInt1, int paramInt2, String paramString2, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "addFriendToFriendList " + paramString1 + ", " + paramInt1 + ", " + paramInt2 + ", " + paramString2 + ", " + paramBoolean1);
    }
    paramString2 = (amsw)this.app.getManager(51);
    Object localObject = (PhoneContactManagerImp)this.app.getManager(11);
    if (localObject != null) {
      ((PhoneContactManagerImp)localObject).b();
    }
    paramBoolean1 = paramString2.a(paramString1, paramInt1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "FriendListHandler addFriendToFriendList flag = " + paramBoolean1);
    }
    if (paramBoolean1)
    {
      this.app.getMessageFacade().getMsgList(paramString1, 0);
      if (this.getFriendGroupListTimeStamp == 0L) {
        notifyUI(1, true, Boolean.valueOf(true));
      }
      notifyUI(63, true, paramString1);
      localObject = (awhw)this.app.getManager(106);
      if (localObject != null) {
        ((awhw)localObject).d.put("" + paramString1, Integer.valueOf(1));
      }
      getFriendDetailInfo(paramString1);
      paramString2.a(paramString1, false);
      ((azsx)this.app.getManager(91)).a(Long.valueOf(paramString1).longValue());
      if ((bily.b(this.app, paramString1)) || ((!npt.b(this.app, paramString1)) && (!npt.c(this.app, paramString1)))) {
        this.app.getMsgHandler().a(paramString1, paramInt2);
      }
      anii.a(npt.b(this.app, paramString1), this.app);
    }
    paramString2 = paramString2.a();
    if (paramString2 != null) {
      paramString2.b(paramString1);
    }
    paramString2 = new ArrayList();
    paramString2.add(paramString1);
    acvv.a(this.app, BaseApplication.getContext(), paramString2);
    return paramBoolean1;
  }
  
  public void addFriendWithMyCard(String paramString1, String paramString2, int paramInt1, byte paramByte1, String paramString3, int paramInt2, int paramInt3, boolean paramBoolean1, byte[] paramArrayOfByte, boolean paramBoolean2, String paramString4, String paramString5, byte paramByte2, String paramString6, Bundle paramBundle)
  {
    addFriendInternal(paramString1, paramString2, paramInt1, paramByte1, paramString3, paramInt2, paramInt3, paramBoolean1, paramArrayOfByte, paramBoolean2, paramString4, paramString5, paramByte2, paramString6, paramBundle);
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
      this.mBatchAddFriendData = new azwg();
    }
    paramBoolean = this.mBatchAddFriendData.a(paramString1, paramString2, paramString3, paramList, paramBoolean, paramInt1, paramInt2);
    if (paramBoolean) {
      this.mBatchAddFriendData.a(this);
    }
    return paramBoolean;
  }
  
  public void cancelMayKnowRecommend(String paramString)
  {
    ThreadManager.getSubThreadHandler().post(new FriendListHandler.6(this, paramString));
  }
  
  public void changeFriendShieldFlag(long paramLong, boolean paramBoolean)
  {
    send_oidb_0x5d1_0(paramLong, 4051, paramBoolean);
  }
  
  public void confirmContactFriend(int paramInt, long paramLong1, long paramLong2, byte[] paramArrayOfByte, byte paramByte, String paramString, long paramLong3, long paramLong4)
  {
    ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "BumpSvc.ReqComfirmContactFriend");
    Object localObject = ((avsy)this.app.getManager(11)).a();
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
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 2);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    send(localToServiceMsg);
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
  
  public void downloadHeadDirectly(QQHeadInfo paramQQHeadInfo)
  {
    if (paramQQHeadInfo == null) {
      return;
    }
    insureInitQQHeadDownloadHandler();
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
        ((ByteBuffer)localObject).putInt(bftf.a(Long.parseLong((String)paramList.get(s))));
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
  
  public azwf getAddFrdTokenHelper()
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
  
  public void getApolloHead(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, String.format("getApolloHead(1) uin=%s", new Object[] { paramString }));
    }
    getQQHeadInSubThread(116, paramString, 200, (byte)1, (byte)0, aric.jdField_a_of_type_Int, false);
  }
  
  public void getApolloHead(String paramString, byte paramByte1, byte paramByte2, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, String.format("getApolloHead(2) uin=%s sizeType=%d", new Object[] { paramString, Integer.valueOf(paramInt) }));
    }
    getQQHeadInSubThread(116, paramString, 200, paramByte1, paramByte2, paramInt, false);
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
  
  public String getChoosedIP()
  {
    insureInitQQHeadDownloadHandler();
    return this.qqHeadDownload.getChoosedIP();
  }
  
  public String getChoosedStrangerGroupIP()
  {
    insureInitQQHeadDownloadHandler();
    return this.qqHeadDownload.getChoosedStrangerGroupIp();
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
        amvo localamvo = (amvo)this.app.getManager(159);
        if ((localamvo == null) || (!localamvo.a())) {
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
  
  public void getCustomHead(String paramString)
  {
    getQQHeadInSubThread(1, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void getCustomHead(String paramString, byte paramByte1, byte paramByte2)
  {
    getQQHeadInSubThread(1, paramString, 0, paramByte1, paramByte2, false);
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
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.getFriendGroupList");
    localToServiceMsg.extraData.putBoolean("getSingleFriend", true);
    localToServiceMsg.extraData.putString("targetUin", paramString);
    send(localToServiceMsg);
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
    //   2: invokestatic 845	java/lang/System:currentTimeMillis	()J
    //   5: lstore_3
    //   6: invokestatic 597	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   9: ifeq +43 -> 52
    //   12: ldc_w 1265
    //   15: iconst_2
    //   16: new 607	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 812	java/lang/StringBuilder:<init>	()V
    //   23: ldc_w 1267
    //   26: invokevirtual 616	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: lload_3
    //   30: invokevirtual 817	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   33: ldc_w 1269
    //   36: invokevirtual 616	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: aload_0
    //   40: getfield 1670	com/tencent/mobileqq/app/FriendListHandler:getFriendGroupListTimeStamp	J
    //   43: invokevirtual 817	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   46: invokevirtual 661	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   49: invokestatic 665	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   52: aload_0
    //   53: getfield 1670	com/tencent/mobileqq/app/FriendListHandler:getFriendGroupListTimeStamp	J
    //   56: lconst_0
    //   57: lcmp
    //   58: ifle +23 -> 81
    //   61: aload_0
    //   62: getfield 1670	com/tencent/mobileqq/app/FriendListHandler:getFriendGroupListTimeStamp	J
    //   65: lstore 5
    //   67: lload_3
    //   68: lload 5
    //   70: lsub
    //   71: ldc2_w 3390
    //   74: lcmp
    //   75: ifge +6 -> 81
    //   78: aload_0
    //   79: monitorexit
    //   80: return
    //   81: aload_0
    //   82: lload_3
    //   83: putfield 1670	com/tencent/mobileqq/app/FriendListHandler:getFriendGroupListTimeStamp	J
    //   86: new 533	java/util/ArrayList
    //   89: dup
    //   90: invokespecial 535	java/util/ArrayList:<init>	()V
    //   93: astore 7
    //   95: aload_0
    //   96: aload_0
    //   97: getfield 673	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   100: invokevirtual 678	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   103: iconst_0
    //   104: bipush 20
    //   106: iconst_0
    //   107: bipush 100
    //   109: lconst_0
    //   110: aload 7
    //   112: iload_1
    //   113: iload_2
    //   114: iconst_0
    //   115: invokespecial 1839	com/tencent/mobileqq/app/FriendListHandler:getFriendList	(Ljava/lang/String;IIIIJLjava/util/ArrayList;ZZS)V
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
          ((ByteBuffer)localObject).putInt(bftf.a(Long.parseLong((String)paramArrayList.get(s2))));
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
      bool2 = bful.b(this.app.getApp().getApplicationContext(), this.app.getAccount());
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
        paramList1 = (amvo)this.app.getManager(159);
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
  
  public void getMobileQQHead(String paramString)
  {
    getQQHeadInSubThread(11, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void getMobileQQHead(String paramString, byte paramByte)
  {
    getQQHeadInSubThread(11, paramString, 0, (byte)0, paramByte, false);
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
      localToServiceMsg.extraData.putLong("dwUin", mrb.a(paramString));
    }
  }
  
  public void getQCallHead(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "getQCallHead QQHEAD_TYPE_QCALL uin = " + paramString + " idType = " + paramInt + ", level =  faceFileType = " + paramByte2);
    }
    getQQHeadInSubThread(16, paramString, paramInt, paramByte1, paramByte2, true);
  }
  
  public QQHeadDownloadHandler getQQHeadDownload()
  {
    insureInitQQHeadDownloadHandler();
    return this.qqHeadDownload;
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
        if (!bful.a(this.app.getApp().getApplicationContext(), this.app.getAccount())) {
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
  
  public void getStrangerHead(String paramString, int paramInt, byte paramByte1, byte paramByte2)
  {
    getQQHeadInSubThread(32, paramString, paramInt, paramByte1, paramByte2, true);
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
      localByteBuffer.putInt(bftf.a(paramArrayOfLong[i]));
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
  
  public void getTroopHead(String paramString)
  {
    getQQHeadInSubThread(4, paramString, 0, (byte)0, (byte)0, false);
  }
  
  public void getTroopHead(String paramString, byte paramByte)
  {
    getQQHeadInSubThread(4, paramString, 0, (byte)0, paramByte, false);
  }
  
  public String getUinOrMobile(int paramInt, long paramLong, String paramString)
  {
    if (paramInt == 11) {
      return paramString;
    }
    return Long.toString(paramLong);
  }
  
  public String getUinOrMobile(long paramLong, String paramString)
  {
    if ((paramString != null) && (paramString.length() > 0)) {
      return paramString;
    }
    return String.valueOf(paramLong);
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
    return ((bgga)this.app.getManager(235)).a;
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
      notifyUI(111, false, paramToServiceMsg);
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
    notifyUI(111, false, null);
    return;
    label220:
  }
  
  public void handleCheckUpdate(CheckUpdateResp paramCheckUpdateResp)
  {
    Object localObject1 = null;
    Object localObject2;
    int i;
    label70:
    bbnm localbbnm;
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
        break label224;
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
      localbbnm = this.app.mAutomator.a(((RespItem)localObject2).eServiceID);
      if (((RespItem)localObject2).eServiceID != 101) {
        break label197;
      }
      localObject1 = localbbnm;
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
      label197:
      handleCheckUpdateItem(localbbnm, (RespItem)localObject2);
      localObject2 = paramCheckUpdateResp;
      paramCheckUpdateResp = (CheckUpdateResp)localObject1;
      localObject1 = localObject2;
    }
    handleCheckUpdateItem(paramCheckUpdateResp, (RespItem)localObject1);
    label224:
    this.app.mAutomator.a();
  }
  
  public void handleDelGroupResp(DelGroupResp paramDelGroupResp, boolean paramBoolean, GroupActionResp paramGroupActionResp)
  {
    amsw localamsw = (amsw)this.app.getManager(51);
    if (paramBoolean) {
      localamsw.a(paramDelGroupResp.cGroupid);
    }
    notifyUI(21, paramBoolean, paramGroupActionResp);
  }
  
  /* Error */
  public void handleFriendInfo(ToServiceMsg paramToServiceMsg, ArrayList<String> paramArrayList, FromServiceMsg paramFromServiceMsg, ArrayList<KQQ.ProfSmpInfoRes> paramArrayList1)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 673	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   4: bipush 51
    //   6: invokevirtual 1273	com/tencent/mobileqq/app/QQAppInterface:getManager	(I)Lmqq/manager/Manager;
    //   9: checkcast 914	amsw
    //   12: astore 7
    //   14: aload 7
    //   16: invokevirtual 3793	amsw:a	()Lcom/tencent/mobileqq/persistence/EntityTransaction;
    //   19: astore_3
    //   20: new 533	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 535	java/util/ArrayList:<init>	()V
    //   27: astore 5
    //   29: new 533	java/util/ArrayList
    //   32: dup
    //   33: invokespecial 535	java/util/ArrayList:<init>	()V
    //   36: astore 6
    //   38: aload_3
    //   39: invokevirtual 2220	com/tencent/mobileqq/persistence/EntityTransaction:begin	()V
    //   42: aload 4
    //   44: invokevirtual 1106	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   47: astore 8
    //   49: aload 8
    //   51: invokeinterface 882 1 0
    //   56: ifeq +429 -> 485
    //   59: aload 8
    //   61: invokeinterface 886 1 0
    //   66: checkcast 3795	KQQ/ProfSmpInfoRes
    //   69: astore 9
    //   71: aload 9
    //   73: getfield 3797	KQQ/ProfSmpInfoRes:dwUin	J
    //   76: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   79: astore 10
    //   81: aload_2
    //   82: aload 10
    //   84: invokevirtual 3800	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   87: ifeq -38 -> 49
    //   90: aload 9
    //   92: aload 10
    //   94: aload_0
    //   95: getfield 673	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   98: invokevirtual 678	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   101: invokevirtual 1119	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   104: aload_0
    //   105: getfield 673	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   108: aload 10
    //   110: invokestatic 3803	anii:a	(LKQQ/ProfSmpInfoRes;ZLcom/tencent/mobileqq/app/QQAppInterface;Ljava/lang/String;)V
    //   113: aload 9
    //   115: getfield 3806	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   118: ifge +18 -> 136
    //   121: ldc 239
    //   123: iconst_1
    //   124: ldc_w 3808
    //   127: invokestatic 820	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   130: aload 9
    //   132: iconst_0
    //   133: putfield 3806	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   136: aload 9
    //   138: getfield 3806	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   141: invokestatic 3811	npt:a	(I)Z
    //   144: ifne +14 -> 158
    //   147: aload 9
    //   149: getfield 3806	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   152: invokestatic 3813	bily:b	(I)Z
    //   155: ifeq +28 -> 183
    //   158: aload 5
    //   160: aload 10
    //   162: invokeinterface 893 2 0
    //   167: pop
    //   168: aload 9
    //   170: getfield 3806	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   173: invokestatic 3811	npt:a	(I)Z
    //   176: aload_0
    //   177: getfield 673	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   180: invokestatic 2970	anii:a	(ZLcom/tencent/mobileqq/app/QQAppInterface;)V
    //   183: aload 7
    //   185: aload 9
    //   187: getfield 3797	KQQ/ProfSmpInfoRes:dwUin	J
    //   190: invokestatic 787	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   193: aload 9
    //   195: getfield 3816	KQQ/ProfSmpInfoRes:strNick	Ljava/lang/String;
    //   198: aload 9
    //   200: getfield 3806	KQQ/ProfSmpInfoRes:cSpecialFlag	B
    //   203: aload 9
    //   205: getfield 3819	KQQ/ProfSmpInfoRes:cSex	B
    //   208: i2s
    //   209: aload 9
    //   211: getfield 3822	KQQ/ProfSmpInfoRes:wAge	B
    //   214: invokevirtual 3825	amsw:a	(Ljava/lang/String;Ljava/lang/String;BSB)V
    //   217: aload 7
    //   219: aload 10
    //   221: invokevirtual 2769	amsw:c	(Ljava/lang/String;)Lcom/tencent/mobileqq/data/Card;
    //   224: astore 11
    //   226: aload_0
    //   227: getfield 673	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   230: aload 9
    //   232: aload 11
    //   234: aload 10
    //   236: aload_2
    //   237: invokestatic 3828	anii:a	(Lcom/tencent/mobileqq/app/QQAppInterface;LKQQ/ProfSmpInfoRes;Lcom/tencent/mobileqq/data/Card;Ljava/lang/String;Ljava/util/ArrayList;)V
    //   240: invokestatic 597	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   243: ifeq +126 -> 369
    //   246: new 3830	java/lang/StringBuffer
    //   249: dup
    //   250: sipush 200
    //   253: invokespecial 3831	java/lang/StringBuffer:<init>	(I)V
    //   256: astore 12
    //   258: aload 12
    //   260: ldc_w 3833
    //   263: invokevirtual 3836	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   266: pop
    //   267: aload 12
    //   269: aload 9
    //   271: getfield 3839	KQQ/ProfSmpInfoRes:isShowXMan	I
    //   274: invokevirtual 3842	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   277: pop
    //   278: aload 12
    //   280: ldc_w 3844
    //   283: invokevirtual 3836	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   286: pop
    //   287: aload 12
    //   289: aload 9
    //   291: getfield 3847	KQQ/ProfSmpInfoRes:dwLoginDay	J
    //   294: invokevirtual 3850	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   297: pop
    //   298: aload 12
    //   300: ldc_w 3852
    //   303: invokevirtual 3836	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   306: pop
    //   307: aload 12
    //   309: aload 9
    //   311: getfield 3855	KQQ/ProfSmpInfoRes:dwPhoneQQXManDay	J
    //   314: invokevirtual 3850	java/lang/StringBuffer:append	(J)Ljava/lang/StringBuffer;
    //   317: pop
    //   318: aload 12
    //   320: ldc_w 3857
    //   323: invokevirtual 3836	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   326: pop
    //   327: aload 12
    //   329: aload 11
    //   331: getfield 3860	com/tencent/mobileqq/data/Card:allowClick	Z
    //   334: invokevirtual 3863	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   337: pop
    //   338: aload 12
    //   340: ldc_w 3865
    //   343: invokevirtual 3836	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   346: pop
    //   347: aload 12
    //   349: aload 11
    //   351: getfield 3868	com/tencent/mobileqq/data/Card:allowPeopleSee	Z
    //   354: invokevirtual 3863	java/lang/StringBuffer:append	(Z)Ljava/lang/StringBuffer;
    //   357: pop
    //   358: ldc 239
    //   360: iconst_2
    //   361: aload 12
    //   363: invokevirtual 3869	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   366: invokestatic 665	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   369: aload 7
    //   371: aload 11
    //   373: invokevirtual 3872	amsw:a	(Lcom/tencent/mobileqq/data/Card;)Z
    //   376: pop
    //   377: aload_0
    //   378: aload_1
    //   379: aload 9
    //   381: aload 6
    //   383: aload 10
    //   385: invokestatic 3875	anii:a	(Lcom/tencent/mobileqq/app/FriendListHandler;Lcom/tencent/qphone/base/remote/ToServiceMsg;LKQQ/ProfSmpInfoRes;Ljava/util/List;Ljava/lang/String;)V
    //   388: aload_0
    //   389: getfield 673	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   392: aload_1
    //   393: aload 9
    //   395: invokestatic 3878	anii:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/qphone/base/remote/ToServiceMsg;LKQQ/ProfSmpInfoRes;)V
    //   398: aload_0
    //   399: getfield 673	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   402: aload_1
    //   403: aload 9
    //   405: invokestatic 3880	anii:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Lcom/tencent/qphone/base/remote/ToServiceMsg;LKQQ/ProfSmpInfoRes;)V
    //   408: aload_0
    //   409: iconst_3
    //   410: iconst_1
    //   411: aload 10
    //   413: invokevirtual 1260	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   416: goto -367 -> 49
    //   419: astore_2
    //   420: invokestatic 597	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   423: ifeq +13 -> 436
    //   426: ldc 239
    //   428: iconst_2
    //   429: ldc_w 3882
    //   432: aload_2
    //   433: invokestatic 3884	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   436: aload_3
    //   437: ifnull +7 -> 444
    //   440: aload_3
    //   441: invokevirtual 2247	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   444: aload_0
    //   445: getfield 673	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   448: aload 5
    //   450: invokestatic 3887	anii:b	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   453: aload_0
    //   454: getfield 673	com/tencent/mobileqq/app/FriendListHandler:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   457: aload 6
    //   459: invokestatic 3889	anii:a	(Lcom/tencent/mobileqq/app/QQAppInterface;Ljava/util/List;)V
    //   462: aload_1
    //   463: getfield 687	com/tencent/qphone/base/remote/ToServiceMsg:extraData	Landroid/os/Bundle;
    //   466: ldc_w 3439
    //   469: invokevirtual 1684	android/os/Bundle:getBoolean	(Ljava/lang/String;)Z
    //   472: ifeq +12 -> 484
    //   475: aload_0
    //   476: bipush 67
    //   478: iconst_1
    //   479: aload 4
    //   481: invokevirtual 1260	com/tencent/mobileqq/app/FriendListHandler:notifyUI	(IZLjava/lang/Object;)V
    //   484: return
    //   485: aload_3
    //   486: invokevirtual 2244	com/tencent/mobileqq/persistence/EntityTransaction:commit	()V
    //   489: aload_3
    //   490: ifnull -46 -> 444
    //   493: aload_3
    //   494: invokevirtual 2247	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   497: goto -53 -> 444
    //   500: astore_1
    //   501: aload_3
    //   502: ifnull +7 -> 509
    //   505: aload_3
    //   506: invokevirtual 2247	com/tencent/mobileqq/persistence/EntityTransaction:end	()V
    //   509: aload_1
    //   510: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	511	0	this	FriendListHandler
    //   0	511	1	paramToServiceMsg	ToServiceMsg
    //   0	511	2	paramArrayList	ArrayList<String>
    //   0	511	3	paramFromServiceMsg	FromServiceMsg
    //   0	511	4	paramArrayList1	ArrayList<KQQ.ProfSmpInfoRes>
    //   27	422	5	localArrayList1	ArrayList
    //   36	422	6	localArrayList2	ArrayList
    //   12	358	7	localamsw	amsw
    //   47	13	8	localIterator	Iterator
    //   69	335	9	localProfSmpInfoRes	KQQ.ProfSmpInfoRes
    //   79	333	10	str	String
    //   224	148	11	localCard	Card
    //   256	106	12	localStringBuffer	StringBuffer
    // Exception table:
    //   from	to	target	type
    //   38	49	419	java/lang/Exception
    //   49	136	419	java/lang/Exception
    //   136	158	419	java/lang/Exception
    //   158	183	419	java/lang/Exception
    //   183	369	419	java/lang/Exception
    //   369	416	419	java/lang/Exception
    //   485	489	419	java/lang/Exception
    //   38	49	500	finally
    //   49	136	500	finally
    //   136	158	500	finally
    //   158	183	500	finally
    //   183	369	500	finally
    //   369	416	500	finally
    //   420	436	500	finally
    //   485	489	500	finally
  }
  
  public void handleGetQQHead_Apollo(boolean paramBoolean, ArrayList<FriendListHandler.QQHeadDetails> paramArrayList, ArrayList<QQHeadInfo> paramArrayList1)
  {
    if (paramBoolean)
    {
      startDownloadQQHead(paramArrayList1, false);
      handleQQHeadNoChangeList(116, 200, paramArrayList);
    }
    paramArrayList = paramArrayList.iterator();
    Object localObject;
    String str;
    if (paramArrayList.hasNext())
    {
      localObject = (FriendListHandler.QQHeadDetails)paramArrayList.next();
      str = ((FriendListHandler.QQHeadDetails)localObject).uinOrMobile;
      localObject = (com.tencent.mobileqq.data.Setting)this.app.getQQHeadSetting(((FriendListHandler.QQHeadDetails)localObject).userType, ((FriendListHandler.QQHeadDetails)localObject).uinOrMobile, 200).second;
      if (localObject == null) {
        break label180;
      }
    }
    label180:
    for (byte b = ((com.tencent.mobileqq.data.Setting)localObject).bHeadType;; b = 0)
    {
      notifyUI(134, paramBoolean, new Object[] { str, Byte.valueOf(b) });
      break;
      paramArrayList = paramArrayList1.iterator();
      while (paramArrayList.hasNext())
      {
        paramArrayList1 = (QQHeadInfo)paramArrayList.next();
        notifyUI(134, paramBoolean, new Object[] { String.valueOf(paramArrayList1.uin), Byte.valueOf(paramArrayList1.cHeadType) });
      }
      return;
    }
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
      ThreadManager.getSubThreadHandler().post(new FriendListHandler.5(this));
    case 1: 
      if (QLog.isColorLevel()) {
        QLog.i("FriendListHandler", 2, "decodePush0x210_0x111, do add mayknow list");
      }
      try
      {
        notifyUI(114, ((amvo)this.app.getManager(159)).a(true, paramList), paramList);
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
      notifyUI(115, ((amvo)this.app.getManager(159)).b(true, paramList), paramList);
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
    this.handler = new FriendListHandler.1(this, this.app.getApp().getMainLooper());
    ThreadManager.excute(new FriendListHandler.2(this), 16, null, false);
  }
  
  public boolean isGetOnlineListRecently()
  {
    long l = System.currentTimeMillis() - this.getOnlineFriendLastTimeStamp;
    if (QLog.isColorLevel()) {
      QLog.i("FriendListHandler", 2, "getOnlineFriend  | intervalTime = " + l + " | sGetOnlineFriendDelay = " + QQAppInterface.sGetOnlineFriendDelay);
    }
    return (this.getOnlineFriendLastTimeStamp > 0L) && ((l < QQAppInterface.sGetOnlineFriendDelay) || (l > QQAppInterface.sNextGetOnlineFriendDelay - QQAppInterface.sGetOnlineFriendDelay));
  }
  
  public boolean isNeedDownloadedQQHead(String paramString)
  {
    for (;;)
    {
      int i;
      boolean bool1;
      boolean bool3;
      synchronized (this.downloadedQQHeadTableLock)
      {
        if (!this.downloadedQQHeadTable.containsKey(paramString)) {
          break label273;
        }
        long l = ((Long)this.downloadedQQHeadTable.get(paramString)).longValue();
        if (Math.abs(System.currentTimeMillis() - l) > 60000L)
        {
          this.downloadedQQHeadTable.remove(paramString);
          statGetQQHeadCostTime(9205, paramString, -1, 4);
          i = 0;
          bool1 = true;
          bool2 = bool1;
          if (bool1)
          {
            bool3 = SystemUtil.isExistSDCard();
            if (((bool3) && (SystemUtil.getSDCardAvailableSize() < 2048L)) || ((!bool3) && (SystemUtil.getSystemAvailableSize() < 102400L)))
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
        if (!this.isDoneSaveQQHeadToStorage)
        {
          this.isDoneSaveQQHeadToStorage = true;
          bful.a(this.app.getApp().getApplicationContext(), true);
          bool2 = bool1;
          continue;
          label273:
          i = -1;
          bool1 = true;
        }
      }
    }
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
  
  public void markDownloadedQQHead(String paramString, boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.qqhead.flh", 2, "markDownloadedQQHead, uinOrMobile= " + paramString + ",isRemove=" + paramBoolean + "downloadSize=" + this.downloadedQQHeadTable.size());
    }
    if ((paramString == null) || (TextUtils.isEmpty(paramString))) {
      return;
    }
    Object localObject1 = this.downloadedQQHeadTableLock;
    if (paramBoolean) {
      try
      {
        this.downloadedQQHeadTable.remove(paramString);
        return;
      }
      finally {}
    }
    ArrayList localArrayList;
    Object localObject2;
    if (this.downloadedQQHeadTable.size() > 30)
    {
      long l = System.currentTimeMillis();
      localArrayList = new ArrayList();
      localObject2 = this.downloadedQQHeadTable.keys();
      while (((Enumeration)localObject2).hasMoreElements())
      {
        String str = (String)((Enumeration)localObject2).nextElement();
        if (Math.abs(l - ((Long)this.downloadedQQHeadTable.get(str)).longValue()) > 60000L) {
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
        this.downloadedQQHeadTable.remove(localObject2);
        statGetQQHeadCostTime(9205, (String)localObject2, -1, 4);
        i += 1;
      }
      else
      {
        this.downloadedQQHeadTable.put(paramString, Long.valueOf(System.currentTimeMillis()));
        break;
        i = 0;
      }
    }
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
  
  protected boolean msgCmdFilter(String paramString)
  {
    if (this.allowCmdSet == null)
    {
      this.allowCmdSet = new HashSet();
      this.allowCmdSet.add("friendlist.getFriendGroupList");
      this.allowCmdSet.add("friendlist.GetLastLoginInfoReq");
      this.allowCmdSet.add("ProfileService.GetRichSig");
      this.allowCmdSet.add("ProfileService.GetSimpleInfo");
      this.allowCmdSet.add("AvatarInfoSvr.QQHeadUrlReq");
      this.allowCmdSet.add("IncreaseURLSvr.QQHeadUrlReq");
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
      this.allowCmdSet.add("MultibusidURLSvr.HeadUrlReq");
      this.allowCmdSet.add("MultibusidURLSvr.HeadUrlReq");
      this.allowCmdSet.add("OidbSvc.0xedb");
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
      this.allowCmdSet.add("OidbSvc.0xedb");
    }
    return !this.allowCmdSet.contains(paramString);
  }
  
  public void notifySyncQQHead()
  {
    Message localMessage = this.handler.obtainMessage();
    localMessage.what = 0;
    this.handler.sendMessage(localMessage);
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
    return amsu.class;
  }
  
  public void onDestroy()
  {
    if (this.qqHeadDownload != null) {
      this.qqHeadDownload.close();
    }
    reportFailedDetails();
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
              anio localanio = (anio)((Iterator)localObject).next();
              if (localanio.a(paramFromServiceMsg.getServiceCmd()))
              {
                localanio.b(paramToServiceMsg, paramFromServiceMsg, paramObject);
                return;
              }
            }
            if (paramFromServiceMsg.getServiceCmd().equals("friendlist.getFriendGroupList"))
            {
              handleOnReceiveGetFriendGroupList(paramToServiceMsg, paramFromServiceMsg, (GetFriendListResp)paramObject);
              return;
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
      if ("AvatarInfoSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        handleQQHead(paramToServiceMsg, paramFromServiceMsg, (QQHeadUrlResp)paramObject);
        return;
      }
      if ("IncreaseURLSvr.QQHeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        handleQQHead_New(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("MultibusidURLSvr.HeadUrlReq".equals(paramFromServiceMsg.getServiceCmd()))
      {
        if (paramToServiceMsg.extraData.getInt("qqHeadType") == 16)
        {
          handleQQHead_QCall(paramToServiceMsg, paramFromServiceMsg, paramObject);
          return;
        }
        handleQQHead_Stranger(paramToServiceMsg, paramFromServiceMsg, paramObject);
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
  
  public void onSaveFriendsList(Friends[] paramArrayOfFriends, long paramLong, boolean paramBoolean)
  {
    ((amsw)this.app.getManager(51)).a(paramArrayOfFriends, paramLong, paramBoolean);
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
    this.handlerReceivers.add(new anit(this.app, this));
    this.handlerReceivers.add(new aniu(this.app, this));
    this.handlerReceivers.add(new anis(this.app, this));
    this.handlerReceivers.add(new aniv(this.app, this));
    this.handlerReceivers.add(new aniz(this.app, this));
    this.handlerReceivers.add(new aniw(this.app, this));
    this.handlerReceivers.add(new anip(this.app, this));
    this.handlerReceivers.add(new aniq(this.app, this));
    this.handlerReceivers.add(new aniy(this.app, this));
    this.handlerReceivers.add(new anjb(this.app, this));
    this.handlerReceivers.add(new anjc(this.app, this));
    this.handlerReceivers.add(new anja(this.app, this));
    this.handlerReceivers.add(new anir(this.app, this));
    this.handlerReceivers.add(new anix(this.app, this));
    this.handlerReceivers.add(new anjd(this.app, this));
    this.handlerReceivers.add(new anin(this.app, this));
  }
  
  public void renameFriendGroup(byte paramByte, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FriendListHandler", 2, "RenameFriendGroup :" + paramByte);
    }
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 1);
    localToServiceMsg.extraData.putByte("group_id", paramByte);
    localToServiceMsg.extraData.putString("group_name", paramString);
    send(localToServiceMsg);
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
        long l = Long.parseLong(this.mApp.getCurrentAccountUin());
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
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
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
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
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
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
      Object localObject = new cmd0xc85.ReqBody();
      ((cmd0xc85.ReqBody)localObject).uint64_from_uin.set(l);
      ((cmd0xc85.ReqBody)localObject).uint64_to_uin.set(Long.valueOf(paramString).longValue());
      ((cmd0xc85.ReqBody)localObject).uint32_op.set(2);
      ((cmd0xc85.ReqBody)localObject).uint32_interval_days.set(paramInt);
      localObject = makeOIDBPkg("OidbSvc.0xc85", 3205, 0, ((cmd0xc85.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("selfUin", this.mApp.getCurrentAccountUin());
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
      long l = Long.parseLong(this.mApp.getCurrentAccountUin());
      Object localObject = new cmd0xc83.ReqBody();
      ((cmd0xc83.ReqBody)localObject).uint64_from_uin.set(l);
      ((cmd0xc83.ReqBody)localObject).uint64_to_uin.set(Long.valueOf(paramString).longValue());
      ((cmd0xc83.ReqBody)localObject).uint32_op.set(2);
      localObject = makeOIDBPkg("OidbSvc.0xc83", 3203, 0, ((cmd0xc83.ReqBody)localObject).toByteArray());
      ((ToServiceMsg)localObject).extraData.putString("selfUin", this.mApp.getCurrentAccountUin());
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
    ToServiceMsg localToServiceMsg = createToServiceMsg("friendlist.SetGroupReq");
    localToServiceMsg.extraData.putInt("set_type", 3);
    localToServiceMsg.extraData.putByteArray("group_id_list", paramArrayOfByte1);
    localToServiceMsg.extraData.putByteArray("sort_id_list", paramArrayOfByte2);
    send(localToServiceMsg);
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
      bful.a(this.app.getApp().getApplicationContext(), this.app.getAccount(), bool);
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
      paramString2 = (amsw)this.app.getManager(51);
      Card localCard = paramString2.c(paramString1);
      localCard.strReMark = ((String)localObject);
      paramString2.a(localCard);
      paramString2.b(paramString1, (String)localObject);
      ((amrb)this.app.getManager(53)).b(paramString1, (String)localObject);
      paramString1 = (avsy)this.app.getManager(11);
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
      localArrayList.add(new GeneralSettings.Setting((String)paramArrayList1.get(i), (String)paramArrayList2.get(i)));
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
  
  public void setImmediatelyCustomHead(boolean paramBoolean)
  {
    this.isImmediatelyGet = paramBoolean;
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
    Object localObject2 = (amsw)this.app.getManager(51);
    i = 0;
    boolean bool = false;
    while (i < paramArrayOfString.length)
    {
      String str = paramArrayOfString[i];
      Object localObject3 = ((amsw)localObject2).a(str, false);
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
        Object localObject5 = apka.a((ExtensionInfo)localObject3);
        int k = paramArrayOfBoolean[i];
        Object localObject4 = new oidb_0x5d6.SnsUpdateItem();
        localObject3 = new ArrayList();
        byte[] arrayOfByte = new byte[2];
        if (paramInt == 1) {
          if (k != 0)
          {
            j = 0;
            label306:
            ((ExtensionInfo)localObject5).messageEnablePreviewNew = j;
          }
        }
        do
        {
          localObject5 = apka.a((ExtensionInfo)localObject5);
          ((oidb_0x5d6.SnsUpdateItem)localObject4).uint32_update_sns_type.set(13582);
          ((oidb_0x5d6.SnsUpdateItem)localObject4).bytes_value.set(ByteStringMicro.copyFrom((byte[])localObject5));
          ((List)localObject3).add(localObject4);
          localObject4 = new oidb_0x5d6.SnsUpateBuffer();
          ((oidb_0x5d6.SnsUpateBuffer)localObject4).uint64_uin.set(Long.parseLong(str));
          ((oidb_0x5d6.SnsUpateBuffer)localObject4).rpt_msg_sns_update_item.set((List)localObject3);
          ((List)localObject1).add(localObject4);
          break;
          j = 1;
          break label306;
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
      paramConcurrentHashMap.add(new GeneralSettings.Setting((String)localEntry.getKey(), ((Integer)localEntry.getValue()).toString()));
    }
    localObject = createToServiceMsg("ProfileService.ReqSetSettings");
    ((ToServiceMsg)localObject).extraData.putSerializable("Settings", paramConcurrentHashMap);
    ((ToServiceMsg)localObject).extraData.putSerializable("localRevision", Integer.valueOf(paramInt));
    send((ToServiceMsg)localObject);
  }
  
  public void setShowBigClubSwitch(QQAppInterface paramQQAppInterface, boolean paramBoolean, nmf paramnmf)
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
          nmb.a(paramQQAppInterface, paramnmf, arrayOfByte, "OidbSvc.0x4ff_9", 1279, 9);
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
      if ((!StringUtil.isEmpty(paramString)) && (paramArrayOfInt != null) && (paramArrayOfBoolean != null) && (paramArrayOfString != null) && (paramArrayOfInt.length == paramArrayOfBoolean.length) && (paramArrayOfBoolean.length == paramArrayOfString.length)) {
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
            if (StringUtil.isEmpty((String)localObject3)) {
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
      l = bful.a(this.app.getApp().getApplicationContext(), this.app.getCurrentAccountUin());
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
  
  public void statGetQQHeadCostTime(int paramInt1, String paramString, int paramInt2, int paramInt3)
  {
    statGetQQHeadCostTime(paramInt1, paramString, paramInt2, paramInt3, 0, null, 0, 0L);
  }
  
  public void statGetQQHeadCostTime(int paramInt1, String paramString1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5, long paramLong)
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
      if (this.statGetQQHeadTime.containsKey(paramString1)) {
        this.statGetQQHeadTime.remove(paramString1);
      }
      paramString2 = new FriendListHandler.QQHeadStat(this);
      paramString2.beginDownInfoTime = l1;
      paramString2.headType = paramInt2;
      this.statGetQQHeadTime.put(paramString1, paramString2);
    }
    for (;;)
    {
      long l2;
      Object localObject;
      if (((!bool) || (paramInt3 == 4)) && (paramString2 != null))
      {
        l2 = paramString2.endDownInfoTime - paramString2.beginDownInfoTime;
        l1 = 0L;
        paramLong = l1;
        if (paramString2.beginDownPicTime > paramString2.endDownInfoTime)
        {
          paramLong = l1;
          if (paramString2.endDownInfoTime > 0L) {
            paramLong = paramString2.beginDownPicTime - paramString2.endDownInfoTime;
          }
        }
        l1 = paramString2.endDownPicTime - paramString2.beginDownPicTime;
        if ((QLog.isColorLevel()) || ((bool) && (paramInt3 == 4) && (paramString2.costTime > 3000L)))
        {
          localObject = new StringBuffer(200);
          ((StringBuffer)localObject).append("===QQHeadStat resultCode=").append(paramInt1);
          ((StringBuffer)localObject).append(", uin=").append(String.format("%11s", new Object[] { paramString1 }));
          ((StringBuffer)localObject).append(", totalTime=").append(String.format("%-5s", new Object[] { Long.valueOf(paramString2.costTime) }));
          ((StringBuffer)localObject).append(", picSize=").append(String.format("%-6s", new Object[] { Integer.valueOf(paramString2.size) }));
          ((StringBuffer)localObject).append(", downInfoTime=").append(l2);
          ((StringBuffer)localObject).append(", intervalTime=").append(paramLong);
          ((StringBuffer)localObject).append(", downPicTime=").append(l1);
          ((StringBuffer)localObject).append(", reasonCode=").append(paramInt5);
          ((StringBuffer)localObject).append(", downUrl=").append(paramString2.downUrl);
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
        if (NetworkUtil.isNetSupport(BaseApplication.getContext()))
        {
          localObject = new HashMap();
          ((HashMap)localObject).put("qqhead_uin", paramString1);
          ((HashMap)localObject).put("downInfo_time", String.valueOf(l2));
          ((HashMap)localObject).put("interval_time", String.valueOf(paramLong));
          ((HashMap)localObject).put("downPic_time", String.valueOf(l1));
          ((HashMap)localObject).put("downPic_size", String.valueOf(paramString2.size));
          ((HashMap)localObject).put("download_url", paramString2.downUrl);
          ((HashMap)localObject).put("param_FailCode", Integer.toString(paramInt1));
          ((HashMap)localObject).put("fail_reason", Integer.toString(paramInt5));
          ((HashMap)localObject).put("param_threadOpId", String.valueOf(anbx.a().a()));
          paramString1 = FaceDownloader.getHeadActionTagWithNetWork(paramInt2);
          if (!TextUtils.isEmpty(paramString1)) {
            StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), paramString1, bool, paramString2.costTime, paramString2.size, (HashMap)localObject, "");
          }
          paramString1 = FaceDownloader.getHeadActionTag(paramInt2);
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(this.app.getCurrentAccountUin(), paramString1, bool, paramString2.costTime, paramString2.size, (HashMap)localObject, "");
        }
        do
        {
          return;
          bool = false;
          break;
          if (!this.statGetQQHeadTime.containsKey(paramString1)) {
            break label832;
          }
          localObject = (FriendListHandler.QQHeadStat)this.statGetQQHeadTime.get(paramString1);
        } while (localObject == null);
        switch (paramInt3)
        {
        }
        for (;;)
        {
          paramString2 = (String)localObject;
          break;
          ((FriendListHandler.QQHeadStat)localObject).endDownInfoTime = l1;
          if (!bool) {
            this.statGetQQHeadTime.remove(paramString1);
          }
          ((FriendListHandler.QQHeadStat)localObject).costTime = (((FriendListHandler.QQHeadStat)localObject).endDownInfoTime - ((FriendListHandler.QQHeadStat)localObject).beginDownInfoTime);
          paramString2 = (String)localObject;
          break;
          ((FriendListHandler.QQHeadStat)localObject).beginDownPicTime = l1;
          paramString2 = (String)localObject;
          break;
          ((FriendListHandler.QQHeadStat)localObject).endDownPicTime = l1;
          ((FriendListHandler.QQHeadStat)localObject).size = paramInt4;
          ((FriendListHandler.QQHeadStat)localObject).downUrl = paramString2;
          ((FriendListHandler.QQHeadStat)localObject).costTime = (((FriendListHandler.QQHeadStat)localObject).endDownPicTime - ((FriendListHandler.QQHeadStat)localObject).beginDownInfoTime);
          this.statGetQQHeadTime.remove(paramString1);
        }
      }
      label832:
      paramString2 = null;
    }
  }
  
  public void updateTrustDeviceList(long paramLong, int paramInt1, String paramString, int paramInt2, ArrayList<alnb> paramArrayList)
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
      alnb localalnb = (alnb)paramArrayList.get(paramInt2);
      if (localalnb == null) {}
      for (;;)
      {
        paramInt2 += 1;
        break;
        localDeviceInfo.bytes_appname.set(ByteStringMicro.copyFrom(localalnb.jdField_c_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_name.set(ByteStringMicro.copyFrom(localalnb.jdField_a_of_type_JavaLangString.getBytes()));
        localDeviceInfo.bytes_device_typeinfo.set(ByteStringMicro.copyFrom(localalnb.b.getBytes()));
        localDeviceInfo.bytes_guid.set(ByteStringMicro.copyFrom(localalnb.jdField_a_of_type_ArrayOfByte));
        localDeviceInfo.uint32_appid.set(localalnb.jdField_a_of_type_Int);
        localDeviceInfo.uint32_auth_status.set(localalnb.jdField_c_of_type_Int);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.FriendListHandler
 * JD-Core Version:    0.7.0.1
 */