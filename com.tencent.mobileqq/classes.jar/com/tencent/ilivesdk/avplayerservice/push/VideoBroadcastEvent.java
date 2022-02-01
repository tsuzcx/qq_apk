package com.tencent.ilivesdk.avplayerservice.push;

public class VideoBroadcastEvent
{
  public static final int CALLIN_VIDEOEND = -103;
  public static final int CALLOFF_VIDEOSTART = -104;
  public static final int Pause = 3;
  public static final int Restart = 5;
  public static final int Resume = 6;
  public static final int SUPERVISE_KICK_OFF = 10;
  public static final int Start = 1;
  public static final int Stop = 2;
  public static final int Stuck = 4;
  public static final int VIDEO_CATON = 5;
  public static final int VIDEO_CLOSED = 3;
  public static final int VIDEO_CLOSING = 2;
  public static final int VIDEO_LOADING = 1;
  public static final int VIDEO_PASUE = 4;
  public static final int VIDEO_PLAY = 0;
  public static final int VideoCATON = 7;
  public static final int VideoOFF = -2;
  public static final int VideoOK = 8;
  public static final int VideoON = 1;
  public static final int VideoPAUSE = 2;
  public static final int VideoRECOVER = 3;
  public static final int VideoSupervise = 6;
  public String OperReasonNote;
  public int OperReasonType;
  public int avTypeChange;
  public int error;
  public int liveType;
  public int operType;
  public long uin;
  public int value;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.ilivesdk.avplayerservice.push.VideoBroadcastEvent
 * JD-Core Version:    0.7.0.1
 */