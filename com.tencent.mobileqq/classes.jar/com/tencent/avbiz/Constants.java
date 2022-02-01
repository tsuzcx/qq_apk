package com.tencent.avbiz;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public abstract interface Constants
{
  public static final HashSet<String> AUDIO_PLAYER_BUSINESS = new Constants.3();
  public static final HashSet<String> AUDIO_RTC_BUSINESS = new Constants.4();
  public static final HashMap<String, Set<String>> PROCESS_BIZ_NAME_MAP;
  public static final HashMap<String, Long> REQUEST_DEVICE_MAP = new Constants.1();
  
  static
  {
    PROCESS_BIZ_NAME_MAP = new Constants.2();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.Constants
 * JD-Core Version:    0.7.0.1
 */