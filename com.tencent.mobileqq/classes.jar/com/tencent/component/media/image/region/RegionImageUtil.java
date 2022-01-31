package com.tencent.component.media.image.region;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.image.DecodeImageTask;
import com.tencent.component.media.utils.BitmapUtils;
import com.tencent.component.media.utils.ImageManagerLog;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;

public class RegionImageUtil
{
  private static final String TAG = "RegionImageUtil";
  private static ConcurrentHashMap<String, String> mImageTypeMap = new ConcurrentHashMap();
  
  public static int getRotation(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    Integer localInteger = DecodeImageTask.getImagePath2Rotation(paramString);
    int i;
    if (localInteger == null) {
      try
      {
        boolean bool = new File(paramString).exists();
        if (!bool) {
          return -1;
        }
      }
      catch (Throwable localThrowable)
      {
        ImageManagerEnv.getLogger().e("RegionImageUtil", new Object[] { Log.getStackTraceString(localThrowable) });
        i = ImageManagerEnv.g().getRotationDegree(paramString);
        DecodeImageTask.putImagePath2Rotation(paramString, i);
      }
    }
    for (;;)
    {
      return i % 360;
      i = localThrowable.intValue();
    }
  }
  
  public static boolean isNeedPieceLoad(int paramInt1, int paramInt2)
  {
    return (paramInt1 * paramInt2 >= ImageManagerEnv.g().getScreenWidth() * ImageManagerEnv.g().getScreenHeight() << 2) && (ImageManagerEnv.g().isWNSSupportPieceLoad());
  }
  
  public static boolean isValidRegionImageFormat(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    Object localObject;
    if (mImageTypeMap.containsKey(paramString)) {
      localObject = (String)mImageTypeMap.get(paramString);
    }
    for (;;)
    {
      ImageManagerLog.i("RegionImageUtil", "isValidRegionImageFormat for mimeType: " + (String)localObject);
      if ((!"image/jpeg".equalsIgnoreCase((String)localObject)) && (!"image/png".equalsIgnoreCase((String)localObject)) && (!"image/jpg".equalsIgnoreCase((String)localObject))) {
        break;
      }
      return true;
      localObject = BitmapUtils.getOptions();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      String str = ((BitmapFactory.Options)localObject).outMimeType;
      localObject = str;
      if (paramString != null)
      {
        localObject = str;
        if (str != null)
        {
          mImageTypeMap.put(paramString, str);
          localObject = str;
        }
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionImageUtil
 * JD-Core Version:    0.7.0.1
 */