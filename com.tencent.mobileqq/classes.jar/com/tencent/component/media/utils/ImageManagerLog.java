package com.tencent.component.media.utils;

import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;

public class ImageManagerLog
{
  private static final String TAG = "QZoneImageManager";
  
  public static void d(String paramString1, String paramString2)
  {
    paramString1 = "[" + paramString1 + "] " + paramString2;
    ImageManagerEnv.getLogger().d("QZoneImageManager", new Object[] { paramString1 });
  }
  
  public static void e(String paramString1, String paramString2)
  {
    paramString1 = "[" + paramString1 + "] " + paramString2;
    ImageManagerEnv.getLogger().e("QZoneImageManager", new Object[] { paramString1 });
  }
  
  public static void i(String paramString1, String paramString2)
  {
    paramString1 = "[" + paramString1 + "] " + paramString2;
    ImageManagerEnv.getLogger().i("QZoneImageManager", new Object[] { paramString1 });
  }
  
  public static void w(String paramString1, String paramString2)
  {
    paramString1 = "[" + paramString1 + "] " + paramString2;
    ImageManagerEnv.getLogger().w("QZoneImageManager", new Object[] { paramString1 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.utils.ImageManagerLog
 * JD-Core Version:    0.7.0.1
 */