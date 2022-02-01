package com.tencent.component.media.image;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.tencent.component.media.utils.ImageManagerLog;

class DecodeImageTask$DecodeTask
  implements Comparable<DecodeTask>, Runnable
{
  private ImageKey key = null;
  
  public DecodeImageTask$DecodeTask(DecodeImageTask paramDecodeImageTask, ImageKey paramImageKey)
  {
    this.key = paramImageKey;
  }
  
  public int compareTo(DecodeTask paramDecodeTask)
  {
    if ((this.this$0.mImageKey != null) && (this.this$0.mImageKey.options != null) && (this.this$0.mImageKey.options.priority)) {
      return 1;
    }
    return 0;
  }
  
  public void run()
  {
    System.currentTimeMillis();
    if (this.this$0.mImageKey != null)
    {
      ImageTaskTracer.removeImageDecodeThreadPendingRecord(this.this$0.mImageKey.hashCodeEx());
      ImageTaskTracer.addImageDecodeThreadDecodingRecord(this.this$0.mImageKey.hashCodeEx());
    }
    try
    {
      Drawable localDrawable = ImageManager.getInstance().getDrawbleFromCache(this.this$0.mImageKey);
      if (localDrawable != null) {
        this.this$0.setResult(11, new Object[] { localDrawable });
      } else {
        DecodeImageTask.access$000(this.this$0, this.key);
      }
    }
    catch (Throwable localThrowable)
    {
      ImageManagerLog.e(DecodeImageTask.access$100(), Log.getStackTraceString(localThrowable));
      if ((this.this$0.mImageKey != null) && (this.this$0.mImageKey.options != null)) {
        this.this$0.mImageKey.options.errCode = ImageManager.getErrorString(this.this$0.mImageKey, 101);
      }
      this.this$0.setResult(9, new Object[0]);
      ImageKey localImageKey = this.key;
      if (localImageKey != null)
      {
        ImageTaskTracer.addImageDecodeFailedRecord(localImageKey.hashCodeEx());
        ImageTaskTracer.removeImageDecodeThreadDecodingRecord(this.key.hashCodeEx());
      }
    }
    System.currentTimeMillis();
    ImageManager.getInstance().nocachedDeleteLocalFile(this.key);
    this.key = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.DecodeImageTask.DecodeTask
 * JD-Core Version:    0.7.0.1
 */