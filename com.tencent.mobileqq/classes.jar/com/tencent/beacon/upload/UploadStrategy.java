package com.tencent.beacon.upload;

public class UploadStrategy
{
  public static boolean DEFAULT_CC_ENABLE;
  public static int DEFAULT_COMMON_DELAY = 60;
  public static int DEFAULT_COM_NUM_DB;
  public static int DEFAULT_COM_NUM_UPLOAD = 20;
  public static boolean DEFAULT_COM_POLL_UP;
  public static boolean DEFAULT_PAGE_PATH_ENABLE = false;
  public static int DEFAULT_REAL_NUM_UPLOAD;
  public static int DEFAULT_REAL_TIME_DELAY;
  public static boolean DEFAULT_SENSOR_ENABLE;
  
  static
  {
    DEFAULT_CC_ENABLE = false;
    DEFAULT_SENSOR_ENABLE = false;
    DEFAULT_COM_POLL_UP = true;
    DEFAULT_REAL_NUM_UPLOAD = 12;
    DEFAULT_REAL_TIME_DELAY = 60;
    DEFAULT_COM_NUM_DB = 12;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.beacon.upload.UploadStrategy
 * JD-Core Version:    0.7.0.1
 */