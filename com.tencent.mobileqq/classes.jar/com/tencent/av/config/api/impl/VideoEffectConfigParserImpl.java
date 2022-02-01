package com.tencent.av.config.api.impl;

import android.os.Build.VERSION;
import com.tencent.av.config.api.IConfigParser;
import com.tencent.av.config.api.IVideoEffectConfigParser;
import com.tencent.avcore.util.ArrayUtils;
import com.tencent.qphone.base.util.QLog;

public class VideoEffectConfigParserImpl
  implements IVideoEffectConfigParser
{
  private static final String KEY_ROOT = "sharp/video_effect/";
  private static final String KEY_TEST = "sharp/video_effect/test/";
  private static final String KEY_TEST_DISABLE_SDK = "sharp/video_effect/test/disable_sdk";
  private static final String KEY_TEST_FLAG = "sharp/video_effect/test/flag";
  private static final String KEY_TEST_MINSDK = "sharp/video_effect/test/min_sdk";
  private static final String STR_DISABLE_SDK = "disable_sdk";
  private static final String STR_FLAG = "flag";
  private static final String STR_MIN_SDK = "min_sdk";
  static final String TAG = "VideoEffectConfigParser";
  
  public int getVideoEffectTestFlag(IConfigParser paramIConfigParser)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getVideoEffectTestFlag sdk: ");
      ((StringBuilder)localObject).append(Build.VERSION.SDK_INT);
      QLog.d("VideoEffectConfigParser", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = paramIConfigParser.getIntValues("sharp/video_effect/test/flag");
      if (localObject != null)
      {
        if ((localObject[0] & 0x1) != 1) {
          return 0;
        }
        localObject = paramIConfigParser.getIntValues("sharp/video_effect/test/min_sdk");
        if (localObject != null)
        {
          if (Build.VERSION.SDK_INT < localObject[0]) {
            return 0;
          }
          boolean bool = ArrayUtils.contains(paramIConfigParser.getIntValues("sharp/video_effect/test/disable_sdk"), Build.VERSION.SDK_INT);
          if (bool) {
            return 0;
          }
          return 1;
        }
      }
      return 0;
    }
    catch (Exception paramIConfigParser) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.config.api.impl.VideoEffectConfigParserImpl
 * JD-Core Version:    0.7.0.1
 */