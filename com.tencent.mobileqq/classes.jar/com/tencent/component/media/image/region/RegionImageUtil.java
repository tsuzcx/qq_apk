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
    } else {
      i = localThrowable.intValue();
    }
    return i % 360;
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
    if (mImageTypeMap.containsKey(paramString))
    {
      paramString = (String)mImageTypeMap.get(paramString);
    }
    else
    {
      localObject = BitmapUtils.getOptions();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(paramString, (BitmapFactory.Options)localObject);
      localObject = ((BitmapFactory.Options)localObject).outMimeType;
      if ((paramString != null) && (localObject != null)) {
        mImageTypeMap.put(paramString, localObject);
      }
      paramString = (String)localObject;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("isValidRegionImageFormat for mimeType: ");
    ((StringBuilder)localObject).append(paramString);
    ImageManagerLog.i("RegionImageUtil", ((StringBuilder)localObject).toString());
    if ((!"image/jpeg".equalsIgnoreCase(paramString)) && (!"image/png".equalsIgnoreCase(paramString))) {
      return "image/jpg".equalsIgnoreCase(paramString);
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.region.RegionImageUtil
 * JD-Core Version:    0.7.0.1
 */