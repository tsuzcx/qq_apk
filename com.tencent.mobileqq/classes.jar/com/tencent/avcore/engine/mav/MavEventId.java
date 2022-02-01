package com.tencent.avcore.engine.mav;

public abstract interface MavEventId
{
  public static final int EM_SDK_EVENT_ID_ALL_CAN_GO_ON_STAGE = 103;
  public static final int EM_SDK_EVENT_ID_ALL_MEM_UPDATE = 44;
  public static final int EM_SDK_EVENT_ID_ALL_ONLINE_NOTICE = 16;
  public static final int EM_SDK_EVENT_ID_AUDIO_ENGINE_READY = 179;
  public static final int EM_SDK_EVENT_ID_AUDIO_PLAYBACK_FAILURE = 175;
  public static final int EM_SDK_EVENT_ID_AUDIO_RECORD_FAILURE = 174;
  public static final int EM_SDK_EVENT_ID_AUTHORITY_CHANGED = 173;
  public static final int EM_SDK_EVENT_ID_CAMERAQOS_FPS_CHANGE = 171;
  public static final int EM_SDK_EVENT_ID_CHANGE_MIC_ORDER = 151;
  public static final int EM_SDK_EVENT_ID_CHECK_SHARE_SCREEN_AVAILABLE_RSP = 178;
  public static final int EM_SDK_EVENT_ID_CONN_TIMEOUT = 39;
  public static final int EM_SDK_EVENT_ID_CREATE_FAIL = 31;
  public static final int EM_SDK_EVENT_ID_CREATE_ROOM_FAILED = 138;
  public static final int EM_SDK_EVENT_ID_CREATE_SUC = 30;
  public static final int EM_SDK_EVENT_ID_CREATE_TIMEOUT = 32;
  public static final int EM_SDK_EVENT_ID_DESTORY = 11;
  public static final int EM_SDK_EVENT_ID_DETECT_USER_AUDIO_HOWLING = 153;
  public static final int EM_SDK_EVENT_ID_DETECT_USER_AUDIO_NOISY = 145;
  public static final int EM_SDK_EVENT_ID_ENTER_FAIL = 34;
  public static final int EM_SDK_EVENT_ID_ENTER_ROOM_FAILED = 139;
  public static final int EM_SDK_EVENT_ID_ENTER_SUC = 33;
  public static final int EM_SDK_EVENT_ID_ENTER_TIMEOUT = 35;
  public static final int EM_SDK_EVENT_ID_GET_MUL_ROOM_INFO = 9;
  public static final int EM_SDK_EVENT_ID_GET_ROOM_INFO = 8;
  public static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_FAIL = 94;
  public static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_SUC = 93;
  public static final int EM_SDK_EVENT_ID_GO_OFF_STAGE_TIMEOUT = 95;
  public static final int EM_SDK_EVENT_ID_GO_ON_STAGE_FAIL = 91;
  public static final int EM_SDK_EVENT_ID_GO_ON_STAGE_SUC = 90;
  public static final int EM_SDK_EVENT_ID_GO_ON_STAGE_TIMEOUT = 92;
  public static final int EM_SDK_EVENT_ID_GROUP_VIDEO_MODE_FREE_MODE = 107;
  public static final int EM_SDK_EVENT_ID_GROUP_VIDEO_MODE_MIC_ORDER_MODE = 108;
  public static final int EM_SDK_EVENT_ID_GROUP_VIDEO_SRC_TYPE_CHANGE = 109;
  public static final int EM_SDK_EVENT_ID_HAS_GETTED_SHARP_CONFIG_PAYLOAD = 123;
  public static final int EM_SDK_EVENT_ID_KICK_OUT_FAIL = 22;
  public static final int EM_SDK_EVENT_ID_KICK_OUT_SUC = 21;
  public static final int EM_SDK_EVENT_ID_MEETINGCONTROLMODE_CHANGE = 142;
  public static final int EM_SDK_EVENT_ID_MEM_AUDIO_IN = 141;
  public static final int EM_SDK_EVENT_ID_MEM_AUDIO_OUT = 140;
  public static final int EM_SDK_EVENT_ID_MEM_BAN_AUDIO = 74;
  public static final int EM_SDK_EVENT_ID_MEM_CANCEL_BAN_AUDIO = 75;
  public static final int EM_SDK_EVENT_ID_MEM_GET_OUT = 71;
  public static final int EM_SDK_EVENT_ID_MEM_KICKED_OUT = 45;
  public static final int EM_SDK_EVENT_ID_MEM_POS_CHANGE = 80;
  public static final int EM_SDK_EVENT_ID_MEM_PPT_IN = 76;
  public static final int EM_SDK_EVENT_ID_MEM_PPT_OUT = 77;
  public static final int EM_SDK_EVENT_ID_MEM_SCREEN_IN = 78;
  public static final int EM_SDK_EVENT_ID_MEM_SCREEN_OUT = 79;
  public static final int EM_SDK_EVENT_ID_MEM_VIDEO_IN = 72;
  public static final int EM_SDK_EVENT_ID_MEM_VIDEO_OUT = 73;
  public static final int EM_SDK_EVENT_ID_MICOFFBYSELF_NOTIFY = 157;
  public static final int EM_SDK_EVENT_ID_MICONBYADMINFAIL_NOTIFY = 158;
  public static final int EM_SDK_EVENT_ID_NEW_GET_IN = 70;
  public static final int EM_SDK_EVENT_ID_NEW_SPEAKING = 42;
  public static final int EM_SDK_EVENT_ID_NOTIFY_AI_DENOISE_TIPS = 180;
  public static final int EM_SDK_EVENT_ID_OFFLINE_RECV_INVITE = 5;
  public static final int EM_SDK_EVENT_ID_OLD_STOP_SPEAKING = 43;
  public static final int EM_SDK_EVENT_ID_ONLINE_NOTICE = 13;
  public static final int EM_SDK_EVENT_ID_ONLY_MANAGER_CAN_GO_ON_STAGE = 102;
  public static final int EM_SDK_EVENT_ID_ONLY_MANAGER_STAGER_CAN_SPEAK = 104;
  public static final int EM_SDK_EVENT_ID_OPENSDK_RECV_AUDIO = 170;
  public static final int EM_SDK_EVENT_ID_OTHER_TERM_ENTER = 12;
  public static final int EM_SDK_EVENT_ID_PB_INVITE_RSP = 20;
  public static final int EM_SDK_EVENT_ID_PB_INVITE_RSP_CALL_BACK = 24;
  public static final int EM_SDK_EVENT_ID_PB_PSTN_STRATEGY_RSP = 23;
  public static final int EM_SDK_EVENT_ID_PLAY_MEDIA_FILE = 105;
  public static final int EM_SDK_EVENT_ID_PPT_UPLOAD_STATE = 110;
  public static final int EM_SDK_EVENT_ID_PROTOCOL_ERR = 7;
  public static final int EM_SDK_EVENT_ID_PSTN_BILL = 19;
  public static final int EM_SDK_EVENT_ID_RECV_INVITE = 6;
  public static final int EM_SDK_EVENT_ID_RECV_INVITE_SWITCH_FROM_P2PAV = 25;
  public static final int EM_SDK_EVENT_ID_RECV_INVITE_SWITCH_FROM_P2PSHARE = 26;
  public static final int EM_SDK_EVENT_ID_RECV_NET_TRAFFIC_DATA_SIZE = 50;
  public static final int EM_SDK_EVENT_ID_REQUEST_MICDATA = 150;
  public static final int EM_SDK_EVENT_ID_ROOM_INFO_CHANGE = 10;
  public static final int EM_SDK_EVENT_ID_SELF_SPEAKING = 176;
  public static final int EM_SDK_EVENT_ID_SEND_EMBED_CHNNEL = 152;
  public static final int EM_SDK_EVENT_ID_SEND_NET_TRAFFIC_DATA_SIZE = 51;
  public static final int EM_SDK_EVENT_ID_SERVER_REFUSED = 46;
  public static final int EM_SDK_EVENT_ID_SETMICBYADMIN_NOTIFY = 143;
  public static final int EM_SDK_EVENT_ID_SETMICFAIL_NOTIFY = 144;
  public static final int EM_SDK_EVENT_ID_SHARE_QOS = 177;
  public static final int EM_SDK_EVENT_ID_SMARTDEVICE_AUDIO_DATA = 124;
  public static final int EM_SDK_EVENT_ID_SMARTDEVICE_VIDEO_DATA = 159;
  public static final int EM_SDK_EVENT_ID_SPEAK_MODE_PRESS_SPEAK = 101;
  public static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_FAIL = 97;
  public static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_SUC = 96;
  public static final int EM_SDK_EVENT_ID_START_REMOTE_VIDEO_TIMEOUT = 98;
  public static final int EM_SDK_EVENT_ID_START_SHARE_FAIL = 85;
  public static final int EM_SDK_EVENT_ID_START_SHARE_SUC = 84;
  public static final int EM_SDK_EVENT_ID_START_SHARE_TIMEOUT = 86;
  public static final int EM_SDK_EVENT_ID_STOP_PLAY_MEDIA_FILE = 106;
  public static final int EM_SDK_EVENT_ID_STOP_SHARE_FAIL = 88;
  public static final int EM_SDK_EVENT_ID_STOP_SHARE_SUC = 87;
  public static final int EM_SDK_EVENT_ID_STOP_SHARE_TIMEOUT = 89;
  public static final int EM_SDK_EVENT_ID_TOTAL_NET_TRAFFIC_DATA_SIZE = 52;
  public static final int EM_SDK_EVENT_ID_TRANSFER_MSG = 125;
  public static final int EM_SDK_EVENT_ID_VIDEOCHANNEL_CTRL_CHANGE = 172;
  public static final int EM_SDK_EVENT_ID_VIDEO_DEC_FRAME_DATA = 61;
  public static final int EV_GA_SDK_DETECT_AUDIO_DATA_LESS = 122;
  public static final int EV_GA_SDK_DETECT_AUDIO_DATA_NULL = 121;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avcore.engine.mav.MavEventId
 * JD-Core Version:    0.7.0.1
 */