package com.tencent.component.media.animwebp;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.tencent.component.media.image.ImageKey;
import com.tencent.component.media.image.image.Image;
import com.tencent.component.media.utils.BitmapUtils;

public class AnimWebpImage
  extends Image
{
  private WebpDrawable drawable;
  
  public AnimWebpImage(ImageKey paramImageKey)
  {
    if ((paramImageKey != null) && (!TextUtils.isEmpty(paramImageKey.filePath))) {
      this.drawable = new WebpDrawable(paramImageKey.filePath);
    }
  }
  
  public AnimWebpImage(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte != null) {
      this.drawable = new WebpDrawable(paramArrayOfByte);
    }
  }
  
  public Drawable getDrawable()
  {
    return this.drawable;
  }
  
  public boolean isRecycled()
  {
    WebpDrawable localWebpDrawable = this.drawable;
    if (localWebpDrawable != null) {
      return localWebpDrawable.isRunning();
    }
    return false;
  }
  
  public void recycle()
  {
    WebpDrawable localWebpDrawable = this.drawable;
    if (localWebpDrawable != null) {
      localWebpDrawable.stop();
    }
  }
  
  public int size()
  {
    WebpDrawable localWebpDrawable = this.drawable;
    if ((localWebpDrawable != null) && (localWebpDrawable.getCurrentBitmap() != null)) {
      return BitmapUtils.getBitmapAllocSize(this.drawable.getCurrentBitmap());
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.animwebp.AnimWebpImage
 * JD-Core Version:    0.7.0.1
 */