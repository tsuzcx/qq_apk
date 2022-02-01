package com.tencent.ilivesdk.avmediaservice_interface;

public abstract interface MediaServerEventCode
{
  public static final int AVERR_AUD_CONNECT_FAILED = 1002021;
  public static final int AVERR_AUD_CONNECT_REFUSE = 1002022;
  public static final int AVERR_AUD_HELLO_ERROR = 1002024;
  public static final int AVERR_AUD_HELLO_TIMEOUT = 1002019;
  public static final int AVERR_AUD_ON_EOS = 1002020;
  public static final int AVERR_AUD_RECONN_FAILED = 1002023;
  public static final int AVERR_NET_NOT_AVAIBALE = 1002001;
  public static final int AVERR_NET_NOT_AVAILABLE = 1002018;
  public static final int AVERR_NET_NOT_BASE = 1002000;
  public static final int AVERR_SERVER_INVALID = 1002003;
  public static final int AVERR_VIDEO_CONNECT_FAILED = 1002004;
  public static final int AVERR_VIDEO_CONNECT_REFUSE = 1002013;
  public static final int AVERR_VIDEO_ENTER_FAILED = 1002006;
  public static final int AVERR_VIDEO_ENTER_REFUSE = 1002008;
  public static final int AVERR_VIDEO_LIVE_FAILED = 1002009;
  public static final int AVERR_VIDEO_PARAM_ERROR = 1002002;
  public static final int AVERR_VIDEO_PULL_ERROR = 1002014;
  public static final int AVERR_VIDEO_PULL_LOST = 1002017;
  public static final int AVERR_VIDEO_PULL_TIMEOUT = 1002015;
  public static final int AVERR_VIDEO_RECONN_FAILED = 1002005;
  public static final int AVERR_VIDEO_REENTER_FAILED = 1002007;
  public static final int AVERR_VIDEO_UPLOAD_FAILED = 1002010;
  public static final int AVERR_VIDEO_UPLOAD_TIMEOUT = 1002011;
  public static final int EVENT_CAMERA_OPEN_FAILED = 1001031;
  public static final int EVENT_CAMERA_OPEN_SUCCESSED = 1001030;
  public static final int EVENT_CHANNEL_CONNECTED = 1001002;
  public static final int EVENT_CHANNEL_DISCONNECTED = 1001003;
  public static final int EVENT_CHECK_NETWORK_2G = 1001025;
  public static final int EVENT_CHECK_NETWORK_INSTABILITY = 1001026;
  public static final int EVENT_CHECK_NETWORK_RESTORE = 1001027;
  public static final int EVENT_CHECK_RECONNECT_TIMES = 1001028;
  public static final int EVENT_GET_VIDEO_STATE = 1001018;
  public static final int EVENT_GET_VIDEO_URL = 1001017;
  public static final int EVENT_HELLO_TIME_OUT = 1001016;
  public static final int EVENT_HOME_SWITCH_FRONTBACKGROUND = 1001029;
  public static final int EVENT_JOIN_VIDEO_SERVER_FAILED = 1001005;
  public static final int EVENT_JOIN_VIDEO_SERVER_SUCESS = 1001006;
  public static final int EVENT_OPEN_CAMERA_ERROR = 1001019;
  public static final int EVENT_REQUEST_START_SEND_VIDEO = 1001007;
  public static final int EVENT_REQUEST_START_SEND_VIDEO_FAILED = 1001009;
  public static final int EVENT_REQUEST_START_SEND_VIDEO_SUCCESS = 1001008;
  public static final int EVENT_REQUEST_STOP_SEND_VIDEO = 1001010;
  public static final int EVENT_REQUEST_STOP_SEND_VIDEO_FAILED = 1001012;
  public static final int EVENT_REQUEST_STOP_SEND_VIDEO_SUCCESS = 1001011;
  public static final int EVENT_SEND_MEDIA_HEAD_FAILED = 1001015;
  public static final int EVENT_SEND_MEDIA_HEAD_SUCESS = 1001014;
  public static final int EVENT_START_JOIN_VIDEO_SERVER = 1001004;
  public static final int EVENT_START_LIVE = 1001001;
  public static final int EVENT_START_SEND_MEDIA_HEAD = 1001013;
  public static final int EVENT_VIDEOSERVER_BASE = 1001000;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.ilivesdk.avmediaservice_interface.MediaServerEventCode
 * JD-Core Version:    0.7.0.1
 */