package com.tencent.mobileqq.activity.photo;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import com.tencent.image.SafeBitmapFactory;
import com.tencent.image.SafeBitmapFactory.SafeDecodeOption;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class BaseThumbDecoder
{
  protected static boolean checkBitmapValid(LocalMediaInfo paramLocalMediaInfo, Bitmap paramBitmap, int paramInt)
  {
    return (paramInt == 0) && (paramBitmap.getWidth() == paramLocalMediaInfo.thumbWidth) && (paramBitmap.getHeight() == paramLocalMediaInfo.thumbWidth) && (paramBitmap.getConfig() == Bitmap.Config.RGB_565);
  }
  
  protected static Bitmap realDecodeBitmap(LocalMediaInfo paramLocalMediaInfo, BitmapFactory.Options paramOptions, String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    try
    {
      SafeBitmapFactory.SafeDecodeOption localSafeDecodeOption = new SafeBitmapFactory.SafeDecodeOption();
      localObject1 = localObject2;
      localSafeDecodeOption.inOptions = paramOptions;
      localObject1 = localObject2;
      localSafeDecodeOption.inNeedFlashBackTest = true;
      localObject1 = localObject2;
      paramLocalMediaInfo = SafeBitmapFactory.safeDecode(paramLocalMediaInfo.path, localSafeDecodeOption);
      localObject1 = paramLocalMediaInfo;
      if (QLog.isColorLevel())
      {
        localObject1 = paramLocalMediaInfo;
        paramOptions = new StringBuilder();
        localObject1 = paramLocalMediaInfo;
        paramOptions.append("ThumbDecoder regionDecodeInfo:");
        localObject1 = paramLocalMediaInfo;
        paramOptions.append(localSafeDecodeOption.toString());
        localObject1 = paramLocalMediaInfo;
        QLog.d(paramString, 2, paramOptions.toString());
      }
      localObject1 = paramLocalMediaInfo;
      paramOptions = paramLocalMediaInfo;
      if (!localSafeDecodeOption.isInJustDecodeBounds)
      {
        localObject1 = paramLocalMediaInfo;
        paramOptions = paramLocalMediaInfo;
        if (localSafeDecodeOption.needRegionDecode)
        {
          localObject1 = paramLocalMediaInfo;
          paramOptions = localSafeDecodeOption.getInfo();
          localObject1 = paramLocalMediaInfo;
          paramOptions.put("from", paramString);
          localObject1 = paramLocalMediaInfo;
          StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "safeDecode", localSafeDecodeOption.isGetBitmap, localSafeDecodeOption.runTime, localSafeDecodeOption.rawHeight * localSafeDecodeOption.rawWidth, paramOptions, "");
          return paramLocalMediaInfo;
        }
      }
    }
    catch (OutOfMemoryError paramLocalMediaInfo)
    {
      paramLocalMediaInfo.printStackTrace();
      paramOptions = (BitmapFactory.Options)localObject1;
    }
    return paramOptions;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.BaseThumbDecoder
 * JD-Core Version:    0.7.0.1
 */