package com.tencent.device.JNICallCenter;

public class DeviceStatus
{
  public static final int AV_TRANSFER_TYPE = 1;
  public static final int DEF_BIAOQING = 2;
  public static final int DEF_GAOQING = 3;
  public static final int DEF_LIUCHANG = 1;
  public static final int DIR_DOWN = 4;
  public static final int DIR_LEFT = 1;
  public static final int DIR_RIGHT = 2;
  public static final int DIR_UP = 3;
  public static final int OP_DEVICE_ACTION = 5;
  public static final int OP_DEVICE_PROPERTY = 6;
  public static final int OP_DEV_LOST_PACKET = 9;
  public static final int OP_DEV_NAME = 10;
  public static final int OP_DEV_XIAOWEI = 11;
  public static final int OP_LOST_PACKET = 8;
  public static final int OP_NONE = 0;
  public static final int OP_SWITCH_DEFINATION = 2;
  public static final int OP_SWITCH_VIDEO = 1;
  public static final int OP_SWITCH_YUNTAI = 3;
  public static final int OP_SWITCH_ZOOM = 7;
  public int historyTimeline;
  public int opValue;
  public String operNickname;
  public long operUin;
  public int operation;
  public int videoDefination;
  public int videoStatus;
  
  public DeviceStatus(long paramLong, String paramString, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    this.operUin = paramLong;
    this.operNickname = paramString;
    this.operation = paramInt1;
    this.opValue = paramInt2;
    this.historyTimeline = paramInt3;
    this.videoStatus = paramInt5;
    this.videoDefination = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.device.JNICallCenter.DeviceStatus
 * JD-Core Version:    0.7.0.1
 */