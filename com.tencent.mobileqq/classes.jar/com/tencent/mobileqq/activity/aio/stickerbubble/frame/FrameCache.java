package com.tencent.mobileqq.activity.aio.stickerbubble.frame;

import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.Nullable;
import com.tencent.mobileqq.utils.CommonImageCacheHelper;
import com.tencent.qphone.base.util.QLog;

public class FrameCache
{
  private static int a;
  
  @Nullable
  public static FrameCache.CacheItem a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("StickerBubbleGifCache_");
    localStringBuilder.append(paramString);
    return (FrameCache.CacheItem)CommonImageCacheHelper.a(localStringBuilder.toString());
  }
  
  public static void a()
  {
    a += 1;
  }
  
  public static void a(String paramString, BitmapDrawable[] paramArrayOfBitmapDrawable, int paramInt)
  {
    if (a())
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("putFramesToCache: ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" / ");
        ((StringBuilder)localObject).append(paramArrayOfBitmapDrawable);
        QLog.d("StickerBubble_FrameCache", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("StickerBubbleGifCache_");
      ((StringBuilder)localObject).append(paramString);
      localObject = ((StringBuilder)localObject).toString();
      if (CommonImageCacheHelper.a((String)localObject) == null) {
        CommonImageCacheHelper.a((String)localObject, new FrameCache.CacheItem(paramString, paramArrayOfBitmapDrawable, paramInt));
      }
    }
  }
  
  private static boolean a()
  {
    return a > 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.stickerbubble.frame.FrameCache
 * JD-Core Version:    0.7.0.1
 */