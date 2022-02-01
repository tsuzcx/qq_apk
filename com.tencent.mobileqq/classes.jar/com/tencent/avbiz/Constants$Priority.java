package com.tencent.avbiz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public abstract interface Constants$Priority
{
  public static final List<HashSet<String>> AUDIO_PRIORITY_LIST;
  public static final HashSet<String> AUDIO_SET_SECOND_LEVEL;
  public static final HashSet<String> AUDIO_SET_THIRD_LEVEL;
  public static final HashSet<String> AUDIO_SET_TOP_LEVEL;
  public static final HashSet<String> AUDIO_SYSTEM_LEVEL = new HashSet(Arrays.asList(new String[] { "系统通话" }));
  public static final List<HashSet<String>> CAMERA_PRIORITY_LIST = new ArrayList(Arrays.asList(new HashSet[] { CAMERA_SET_TOP_LEVEL }));
  public static final HashSet<String> CAMERA_SET_TOP_LEVEL;
  public static final HashMap<Long, List<HashSet<String>>> PRIORITY_MAP = new Constants.Priority.1();
  
  static
  {
    AUDIO_SET_TOP_LEVEL = new HashSet(Arrays.asList(new String[] { "音视频通话", "一起派对", "自习室", "物联设备", "频道通话", "频道直播", "频道观看直播", "游戏组队" }));
    AUDIO_SET_SECOND_LEVEL = new HashSet(Arrays.asList(new String[] { "ptt", "一起听歌", "看点" }));
    AUDIO_SET_THIRD_LEVEL = new HashSet(Arrays.asList(new String[] { "voice_assistant", "QQ直播", "运动", "小世界" }));
    AUDIO_PRIORITY_LIST = new ArrayList(Arrays.asList(new HashSet[] { AUDIO_SYSTEM_LEVEL, AUDIO_SET_TOP_LEVEL, AUDIO_SET_SECOND_LEVEL, AUDIO_SET_THIRD_LEVEL }));
    CAMERA_SET_TOP_LEVEL = new HashSet(Arrays.asList(new String[] { "音视频通话", "一起派对", "自习室", "物联设备", "小世界" }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avbiz.Constants.Priority
 * JD-Core Version:    0.7.0.1
 */