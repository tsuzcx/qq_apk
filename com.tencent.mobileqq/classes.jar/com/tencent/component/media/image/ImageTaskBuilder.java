package com.tencent.component.media.image;

import android.content.Context;
import android.util.Log;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.sharpP.SharpPUtils;
import java.util.HashMap;
import java.util.Map;

public class ImageTaskBuilder
{
  private static Context mContext = ;
  public static Map<String, Long> stampMap = new HashMap();
  public static Map<String, Long> stampMap2 = new HashMap();
  
  public static ImageTask buildImageTask(ImageKey paramImageKey)
  {
    if (paramImageKey.flag == 3) {
      return RecycleResourceTask.obtain(UICallbackTask.obtain(MessageQueueDownloadMultiplexTask.obtain(DownloadImageTask.obtain(paramImageKey))));
    }
    if (paramImageKey.flag == 1) {
      return RecycleResourceTask.obtain(UICallbackTask.obtain(FetchCachedImageTask.obtain(MessageQueueDecodeMultiplexTask.obtain(CancelableDecodeImageTask.obtain(paramImageKey)))));
    }
    if (paramImageKey.flag == 2)
    {
      if ((paramImageKey.options != null) && (paramImageKey.options.isGifPlayWhileDownloading) && (!SharpPUtils.isSharpP(paramImageKey.url)))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("isSharpp:");
        localStringBuilder.append(SharpPUtils.isSharpP(paramImageKey.url));
        localStringBuilder.append(" isGifPlayWhileDownloading:");
        localStringBuilder.append(paramImageKey.options.isGifPlayWhileDownloading);
        localStringBuilder.append("  hashCodeEx:");
        localStringBuilder.append(paramImageKey.hashCodeEx());
        localStringBuilder.append(" url:");
        localStringBuilder.append(paramImageKey.url);
        Log.d("kaedelin", localStringBuilder.toString());
        return RecycleResourceTask.obtain(UICallbackTask.obtain(FetchCachedImageTask.obtain(MessageQueueDecodeMultiplexTask.obtain(CancelStreamDecodeGifTask.obtain(MessageQueueDownloadMultiplexTask.obtain(DownloadImageTask.obtain(paramImageKey)))))));
      }
      return RecycleResourceTask.obtain(UICallbackTask.obtain(FetchCachedImageTask.obtain(MessageQueueDecodeMultiplexTask.obtain(CancelableDecodeImageTask.obtain(MessageQueueDownloadMultiplexTask.obtain(DownloadImageTask.obtain(paramImageKey)))))));
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageTaskBuilder
 * JD-Core Version:    0.7.0.1
 */