package com.tencent.component.media.image;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.utils.ImageManagerLog;
import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;

public class ImageTracer
{
  private static final int LENGTH = 11;
  public static final String TAG = "ImageTracer";
  private static ConcurrentHashMap<String, long[]> mUrl2TimeMap = new ConcurrentHashMap(50, 0.75F, 8);
  
  public static void cancel(String paramString)
  {
    paramString = ImageKey.getUrlKey(paramString, true);
    if ((long[])mUrl2TimeMap.get(paramString) != null) {}
  }
  
  private static void checkAndPrint(String paramString, long[] paramArrayOfLong)
  {
    if ((paramArrayOfLong == null) || (paramArrayOfLong.length != 11)) {}
    long l1;
    do
    {
      do
      {
        return;
        l1 = paramArrayOfLong[5] - paramArrayOfLong[0];
        if ((paramArrayOfLong[1] == 0L) || (paramArrayOfLong[2] == 0L)) {
          break;
        }
      } while (l1 <= 5000L);
      l2 = paramArrayOfLong[2];
      l3 = paramArrayOfLong[1];
      long l4 = paramArrayOfLong[4];
      long l5 = paramArrayOfLong[3];
      ImageManagerLog.w("ImageTracer", "total:" + l1 + " download:" + (l2 - l3) + " image length:" + (paramArrayOfLong[6] >> 10) + "K decode:" + (l4 - l5) + " url:" + paramString);
      return;
    } while (l1 <= 3000L);
    long l2 = paramArrayOfLong[4];
    long l3 = paramArrayOfLong[3];
    ImageManagerLog.w("ImageTracer", "total:" + l1 + " has local file, decode:" + (l2 - l3) + " url:" + paramString);
  }
  
  public static void decodeFail(String paramString)
  {
    Object localObject = ImageKey.getUrlKey(paramString, true);
    localObject = (long[])mUrl2TimeMap.get(localObject);
    if ((localObject != null) && (localObject.length > 4))
    {
      localObject[4] = System.currentTimeMillis();
      ImageManagerLog.e("ImageTracer", "decode return null, url:" + paramString);
    }
  }
  
  public static void downloadFail(String paramString)
  {
    Object localObject = ImageKey.getUrlKey(paramString, true);
    localObject = (long[])mUrl2TimeMap.get(localObject);
    if ((localObject != null) && (localObject.length > 5))
    {
      long l1 = System.currentTimeMillis();
      long l2 = localObject[0];
      long l3 = localObject[1];
      ImageManagerLog.e("ImageTracer", "download fail, total:" + (l1 - l2) + " download:" + (l1 - l3) + " url:" + paramString);
    }
  }
  
  public static void end(String paramString)
  {
    Object localObject = ImageKey.getUrlKey(paramString, true);
    localObject = (long[])mUrl2TimeMap.get(localObject);
    if ((localObject != null) && (localObject.length > 5))
    {
      localObject[5] = System.currentTimeMillis();
      checkAndPrint(paramString, (long[])localObject);
    }
  }
  
  public static void endDecode(String paramString)
  {
    Object localObject = ImageKey.getUrlKey(paramString, true);
    localObject = (long[])mUrl2TimeMap.get(localObject);
    if ((localObject != null) && (localObject.length > 4))
    {
      localObject[4] = System.currentTimeMillis();
      long l1 = localObject[4];
      long l2 = localObject[3];
      ImageManagerLog.w("ImageTracer", "decode cost=" + (l1 - l2) + " url=" + paramString);
    }
  }
  
  public static void endDownlaod(String paramString)
  {
    paramString = ImageKey.getUrlKey(paramString, true);
    paramString = (long[])mUrl2TimeMap.get(paramString);
    if ((paramString != null) && (paramString.length > 2)) {
      paramString[2] = System.currentTimeMillis();
    }
  }
  
  public static void endSuperResolution(String paramString)
  {
    Object localObject = ImageKey.getUrlKey(paramString, true);
    localObject = (long[])mUrl2TimeMap.get(localObject);
    if ((localObject != null) && (localObject.length > 10))
    {
      localObject[9] = System.currentTimeMillis();
      if (localObject[10] <= 0L) {
        break label198;
      }
      if (localObject[9] > localObject[10])
      {
        int i = (int)(localObject[9] - localObject[10]);
        ImageManagerLog.w("superresolution", "task end after show in screen. delay=" + i);
        ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "super_resolution_time_cost", "sr_end_after_show", i);
        localObject = new HashMap();
        ((HashMap)localObject).put("PhoneType", Build.MODEL);
        ((HashMap)localObject).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
        ((HashMap)localObject).put("isHighScale", String.valueOf(ImageManagerEnv.g().isHighScaleUrl(paramString)));
        ((HashMap)localObject).put("modelId", String.valueOf(ImageManagerEnv.g().getCurrentSuperResolutionModelId()));
        ((HashMap)localObject).put("sr_after_show", "1");
        ((HashMap)localObject).put("sr_after_show_delay", String.valueOf(i));
        ImageManagerEnv.g().statisticCollectorReport("qzone_super_resolution_ex", (HashMap)localObject);
      }
    }
    return;
    label198:
    ImageManagerLog.w("superresolution", "task end before show in screen.");
    ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "super_resolution_time_cost", "sr_end_before_show", 0);
    localObject = new HashMap();
    ((HashMap)localObject).put("PhoneType", Build.MODEL);
    ((HashMap)localObject).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    ((HashMap)localObject).put("isHighScale", String.valueOf(ImageManagerEnv.g().isHighScaleUrl(paramString)));
    ((HashMap)localObject).put("modelId", String.valueOf(ImageManagerEnv.g().getCurrentSuperResolutionModelId()));
    ((HashMap)localObject).put("sr_before_show", "1");
    ImageManagerEnv.g().statisticCollectorReport("qzone_super_resolution_ex", (HashMap)localObject);
  }
  
  public static void notShowInScreen(String paramString)
  {
    paramString = ImageKey.getUrlKey(paramString, true);
    paramString = (long[])mUrl2TimeMap.get(paramString);
    if ((paramString != null) && (paramString.length > 10)) {
      paramString[10] = 0L;
    }
  }
  
  public static void reportDecodeTime(String paramString, boolean paramBoolean)
  {
    Object localObject = ImageKey.getUrlKey(paramString, true);
    long[] arrayOfLong = (long[])mUrl2TimeMap.get(localObject);
    ImageManagerEnv localImageManagerEnv;
    if ((arrayOfLong != null) && (arrayOfLong.length > 4) && (arrayOfLong[3] > 0L) && (arrayOfLong[4] > 0L))
    {
      localImageManagerEnv = ImageManagerEnv.g();
      if (!paramBoolean) {
        break label258;
      }
    }
    label258:
    for (localObject = "decode_time";; localObject = "decode_time_none_sr")
    {
      localImageManagerEnv.reportImageTimeCostMTA("qzone_image_decode", "image_time_cost", (String)localObject, (int)(arrayOfLong[4] - arrayOfLong[3]));
      if ((arrayOfLong.length > 10) && (paramBoolean))
      {
        if (arrayOfLong[10] <= 0L) {
          break;
        }
        if (arrayOfLong[4] > arrayOfLong[10])
        {
          int i = (int)(arrayOfLong[4] - arrayOfLong[10]);
          ImageManagerLog.w("superresolution", "decode end after show in screen. delay=" + i);
          ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "super_resolution_time_cost", "sr_decode_after_show", i);
          localObject = new HashMap();
          ((HashMap)localObject).put("PhoneType", Build.MODEL);
          ((HashMap)localObject).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
          ((HashMap)localObject).put("isHighScale", String.valueOf(ImageManagerEnv.g().isHighScaleUrl(paramString)));
          ((HashMap)localObject).put("modelId", String.valueOf(ImageManagerEnv.g().getCurrentSuperResolutionModelId()));
          ((HashMap)localObject).put("decode_after_show", "1");
          ((HashMap)localObject).put("decode_after_show_delay", String.valueOf(i));
          ImageManagerEnv.g().statisticCollectorReport("qzone_super_resolution_ex", (HashMap)localObject);
        }
      }
      return;
    }
    ImageManagerLog.w("superresolution", "decode end before show in screen.");
    ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "super_resolution_time_cost", "sr_decode_before_show", 0);
    localObject = new HashMap();
    ((HashMap)localObject).put("PhoneType", Build.MODEL);
    ((HashMap)localObject).put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    ((HashMap)localObject).put("isHighScale", String.valueOf(ImageManagerEnv.g().isHighScaleUrl(paramString)));
    ((HashMap)localObject).put("modelId", String.valueOf(ImageManagerEnv.g().getCurrentSuperResolutionModelId()));
    ((HashMap)localObject).put("decode_before_show", "1");
    ImageManagerEnv.g().statisticCollectorReport("qzone_super_resolution_ex", (HashMap)localObject);
  }
  
  public static void reportDownloadTime(String paramString, boolean paramBoolean)
  {
    paramString = ImageKey.getUrlKey(paramString, true);
    long[] arrayOfLong = (long[])mUrl2TimeMap.get(paramString);
    ImageManagerEnv localImageManagerEnv;
    if ((arrayOfLong != null) && (arrayOfLong.length > 2) && (arrayOfLong[1] > 0L) && (arrayOfLong[2] > 0L))
    {
      localImageManagerEnv = ImageManagerEnv.g();
      if (!paramBoolean) {
        break label72;
      }
    }
    label72:
    for (paramString = "download_time";; paramString = "download_time_none_sr")
    {
      localImageManagerEnv.reportImageTimeCostMTA("qzone_image_decode", "image_time_cost", paramString, (int)(arrayOfLong[2] - arrayOfLong[1]));
      return;
    }
  }
  
  public static void requestSuperResolution(String paramString)
  {
    paramString = ImageKey.getUrlKey(paramString, true);
    paramString = (long[])mUrl2TimeMap.get(paramString);
    if ((paramString != null) && (paramString.length > 7)) {
      paramString[7] = System.currentTimeMillis();
    }
  }
  
  public static void setImageLength(String paramString, long paramLong)
  {
    paramString = ImageKey.getUrlKey(paramString, true);
    paramString = (long[])mUrl2TimeMap.get(paramString);
    if ((paramString != null) && (paramString.length > 6)) {
      paramString[6] = paramLong;
    }
  }
  
  public static void start(String paramString)
  {
    String str = ImageKey.getUrlKey(paramString, true);
    long[] arrayOfLong = (long[])mUrl2TimeMap.get(str);
    paramString = arrayOfLong;
    if (arrayOfLong == null)
    {
      paramString = new long[11];
      mUrl2TimeMap.put(str, paramString);
    }
    if ((paramString != null) && (paramString.length > 0)) {
      paramString[0] = System.currentTimeMillis();
    }
  }
  
  public static void startDecode(String paramString)
  {
    paramString = ImageKey.getUrlKey(paramString, true);
    paramString = (long[])mUrl2TimeMap.get(paramString);
    if ((paramString != null) && (paramString.length > 3)) {
      paramString[3] = System.currentTimeMillis();
    }
  }
  
  public static void startDownlaod(String paramString)
  {
    paramString = ImageKey.getUrlKey(paramString, true);
    paramString = (long[])mUrl2TimeMap.get(paramString);
    if ((paramString != null) && (paramString.length > 1)) {
      paramString[1] = System.currentTimeMillis();
    }
  }
  
  public static void startShowInScreen(String paramString)
  {
    paramString = ImageKey.getUrlKey(paramString, true);
    paramString = (long[])mUrl2TimeMap.get(paramString);
    if ((paramString != null) && (paramString.length > 10)) {
      paramString[10] = System.currentTimeMillis();
    }
  }
  
  public static void startSuperResolution(String paramString)
  {
    paramString = ImageKey.getUrlKey(paramString, true);
    paramString = (long[])mUrl2TimeMap.get(paramString);
    if ((paramString != null) && (paramString.length > 8))
    {
      paramString[8] = System.currentTimeMillis();
      long l = paramString[8] - paramString[7];
      ImageManagerLog.w("superresolution", "task wait in queue time=" + l);
      ImageManagerEnv.g().reportImageTimeCostMTA("qzone_image_decode", "super_resolution_time_cost", "queue_time", (int)l);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.component.media.image.ImageTracer
 * JD-Core Version:    0.7.0.1
 */