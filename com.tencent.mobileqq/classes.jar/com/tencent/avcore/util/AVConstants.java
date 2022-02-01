package com.tencent.avcore.util;

public abstract interface AVConstants
{
  public static final int AV_RELATION_COMMON_OPEN = 11;
  public static final int AV_RELATION_DISCUSSGROUP = 2;
  public static final int AV_RELATION_DOUBLE_MEETING = 100;
  public static final int AV_RELATION_FRIEND = 3;
  public static final int AV_RELATION_GAME_ROOM = 10;
  public static final int AV_RELATION_GROUP = 1;
  public static final int AV_RELATION_GUILD_MULTI = 9;
  public static final int AV_RELATION_MULTI_RANDOM = 7;
  public static final int AV_RELATION_TEMPSESSION = 4;
  public static final int AV_RELATION_UNKNOWN = 0;
  public static final int DEVICE_PERMISSION_TYPE_CAMERA_NO_DATA = 1;
  public static final int DEVICE_PERMISSION_TYPE_CAMERA_OPEN_FAIL = 2;
  public static final int DEVICE_PERMISSION_TYPE_DEFAULT = 0;
  public static final int DEVICE_PERMISSION_TYPE_MIC = 3;
  public static final int DEVICE_PERMISSION_TYPE_MIC_LESS = 4;
  public static final int DEVICE_PERMISSION_TYPE_MIC_READY = 2048;
  public static final int MULTIAV_ALL = 0;
  public static final int MULTIAV_AUDIO_VIDEO = 1;
  public static final int MULTIAV_COMMON_OPEN = 14;
  public static final int MULTIAV_EDU = 5;
  public static final int MULTIAV_GAME_ROOM = 13;
  public static final int MULTIAV_GROUP_AUDIO = 10;
  @Deprecated
  public static final int MULTIAV_GROUP_OD_VIDEO = 14;
  public static final int MULTIAV_GROUP_VIDEO = 2;
  public static final int MULTIAV_GROUP_VIDEO_AUDIO = 12;
  public static final int MULTIAV_GUILD_AUDIO = 11;
  public static final int MULTIAV_GUILD_TEAM = 199;
  public static final int MULTIAV_QCALLGROUP = 6;
  public static final int MULTIAV_SCREENSHARE_PPT = 3;
  public static final int MULTIAV_SUB_ALL = 0;
  public static final int MULTIAV_SUB_AUDIO = 1;
  public static final int MULTIAV_SUB_FORCE_SHOW_INVITE_MSG_BOX = 6;
  public static final int MULTIAV_SUB_SWITCH_DOUBLE_NORMAL_TO_DOUBLE_MEETING = 5;
  public static final int MULTIAV_SUB_SWITCH_P2PAV = 3;
  public static final int MULTIAV_SUB_SWITCH_P2PSHARE = 4;
  public static final int MULTIAV_SUB_VIDEO = 2;
  public static final int MULTIAV_UN_INIT = -1;
  public static final int MULTIAV_VIDEO_CONFERENCE = 8;
  public static final int MULTIAV_WEGROUPUP = 4;
  public static final String SHARE_TAG = "AVShare";
  public static final int TYPE_ACCOUNT_KICKED = 40;
  public static final int TYPE_CAMERA_ERRO = 11;
  public static final int TYPE_CLOSED_BY_FRIEND = 2;
  public static final int TYPE_CLOSED_BY_FRIEND_FOR_ACCEPT_3RD_REQ = 24;
  public static final int TYPE_CLOSED_BY_SELF = 0;
  public static final int TYPE_CLOSE_BY_DOUBLE2MULTI = 21;
  public static final int TYPE_CONNECT_FAILED = 5;
  public static final int TYPE_DATE_SIG_EXPIRED = 56;
  public static final int TYPE_DISCUSSION_NET_TRAFFIC_SIZE = 44;
  public static final int TYPE_DOUBLE_VIDEO_CREATE_ROOM_FAIL = 64;
  public static final int TYPE_DOUBLE_VIDEO_NOT_ACCEPT = 66;
  public static final int TYPE_DOUBLE_VIDEO_TO_DOUBLE_CONF = 72;
  public static final int TYPE_EXCEPTION_ABORT = 45;
  public static final int TYPE_FRIEND_CANCEL_REQUEST = 10;
  public static final int TYPE_HANDLED_BY_OTHER_DEVICE = 7;
  public static final int TYPE_LIGHTALK_PSTN = 57;
  public static final int TYPE_MULTI_VIDEO_CREATEROOM_ERROR = 17;
  public static final int TYPE_MULTI_VIDEO_CREATEROOM_ERROR_NETWORK_OFFLINE = 70;
  public static final int TYPE_MULTI_VIDEO_CREATEROOM_ERROR_SERVER_BUSY = 71;
  public static final int TYPE_MULTI_VIDEO_DEV_NOTSURPORT = 18;
  public static final int TYPE_MULTI_VIDEO_ENTERROOM_ERROR = 16;
  public static final int TYPE_MULTI_VIDEO_ENTERROOM_ERROR_NETWORK_OFFLINE = 68;
  public static final int TYPE_MULTI_VIDEO_ENTERROOM_ERROR_SERVER_BUSY = 69;
  public static final int TYPE_MULTI_VIDEO_KICKOUT = 20;
  public static final int TYPE_MULTI_VIDEO_NETERROR = 15;
  public static final int TYPE_MULTI_VIDEO_NOTCONNECTED_NETERROR = 22;
  public static final int TYPE_MULTI_VIDEO_QUIT_ROOM_ERROR = 19;
  public static final int TYPE_MULTI_VIDEO_START = 13;
  public static final int TYPE_MULTI_VIDEO_STOP = 14;
  public static final int TYPE_MULTI_VIDEO_STOP_MUTEXT_GROUPCALL = 60;
  public static final int TYPE_MULTI_VIDEO_STOP_MUTEX_QQCALL = 59;
  public static final int TYPE_NETWORK_ERRO = 9;
  public static final int TYPE_NET_TRAFFIC_SIZE = 41;
  public static final int TYPE_PEER_CONN_BROKEN = 62;
  public static final int TYPE_RECEIVED_END = 65;
  public static final int TYPE_RECEIVED_OFFLINE_REQUEST = 6;
  public static final int TYPE_REJECT_BY_FRIEND = 3;
  public static final int TYPE_REJECT_BY_SELF = 1;
  public static final int TYPE_REJECT_BY_SELF_WHEN_ANSWER_3RD = 23;
  public static final int TYPE_REJECT_IS_CALLING = 42;
  public static final int TYPE_REQUEST_TIMEOUT = 12;
  public static final int TYPE_SCORE = 61;
  public static final int TYPE_SDK_NOT_SUPPORT = 8;
  public static final int TYPE_SECURITY_FORBID = 54;
  public static final int TYPE_SELF_CONN_BROKEN = 63;
  public static final int TYPE_SELF_VERSION_NOT_SUPPORT = 4;
  public static final int TYPE_SESSION_AUDIO = 1;
  public static final int TYPE_SESSION_GAUDIO = 3;
  public static final int TYPE_SESSION_GVIDEO = 4;
  public static final int TYPE_SESSION_NONE = 0;
  public static final int TYPE_SESSION_VIDEO = 2;
  public static final int TYPE_SHIELD_BY_FFRIEND = 43;
  public static final int TYPE_SWITCH_TERMINAL_FAIL_NO_INSTANSE = 52;
  public static final int TYPE_SWITCH_TERMINAL_FAIL_PEER_ONSWITCH = 55;
  public static final int TYPE_SWITCH_TERMINAL_FAIL_VERSION = 51;
  public static final int TYPE_SWITCH_TERMINAL_OTHER_TERMINAL_CHATING = 53;
  public static final int TYPE_SWITCH_TO_MULTI = 46;
  public static final int TYPE_SWITCH_TO_MULTI_BY_FRIEND = 47;
  public static final int TYPE_SWITCH_TO_MULTI_BY_SELF = 48;
  public static final int TYPE_SWITCH_TO_OTHER_TERMINAL = 49;
  public static final int TYPE_SWITCH_TO_THIS_TERMINAL_FAIL = 50;
  public static final int TYPE_SYSTEM_CALL = 58;
  public static final int TYPE_VIDEO_CAPA_EXCHANGE_FAILED = 35;
  public static final int TYPE_VIDEO_FRIEND_VERSION_NOT_SUPPORT = 25;
  public static final int TYPE_VIDEO_SELF_OFFLINE = 39;
  public static final int TYPE_VIDEO_WAIT_RELAYINFO_TIMEOUT = 28;
  public static final int TYPE_VIDEO_WAIT_RELAY_CONNECT_TIMEOUT = 29;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.util.AVConstants
 * JD-Core Version:    0.7.0.1
 */