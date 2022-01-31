package com.tencent.component.media.image.image;

import android.graphics.drawable.Drawable;
import android.util.Log;
import com.tencent.component.media.ILog;
import com.tencent.component.media.ImageManagerEnv;
import com.tencent.component.media.gif.NewGifDecoder.Options;
import com.tencent.component.media.gif.NewGifDrawable;
import com.tencent.component.media.gif.SharpPNewGifDecoder;
import com.tencent.component.media.image.ImageKey;
import java.io.IOException;

public class NewGifImage
  extends Image
{
  private Drawable mDrawable;
  private String url;
  
  public NewGifImage(ImageKey paramImageKey, int paramInt1, int paramInt2)
  {
    try
    {
      NewGifDecoder.Options localOptions = new NewGifDecoder.Options();
      localOptions.inPreferWidth = paramInt1;
      localOptions.inPreferHeight = paramInt2;
      this.mDrawable = new NewGifDrawable(paramImageKey.filePath, localOptions, paramImageKey.url);
      ImageManagerEnv.getLogger().d("NewGifImage", new Object[] { "create NewGifImage url: " + paramImageKey.url });
      return;
    }
    catch (Throwable paramImageKey)
    {
      ImageManagerEnv.getLogger().e("NewGifImage", new Object[] { Log.getStackTraceString(paramImageKey) });
    }
  }
  
  public NewGifImage(String paramString)
  {
    try
    {
      this.mDrawable = new NewGifDrawable(paramString, null);
      return;
    }
    catch (IOException paramString) {}
  }
  
  public NewGifImage(String paramString, int paramInt1, int paramInt2, float paramFloat)
  {
    this.mDrawable = new NewGifDrawable(new SharpPNewGifDecoder(paramString, (int)(paramInt1 / paramFloat), (int)(paramInt2 / paramFloat)));
  }
  
  public NewGifImage(String paramString1, int paramInt1, int paramInt2, float paramFloat, String paramString2)
  {
    this.mDrawable = new NewGifDrawable(new SharpPNewGifDecoder(paramString1, (int)(paramInt1 / paramFloat), (int)(paramInt2 / paramFloat)), paramString2);
  }
  
  public Drawable getDrawable()
  {
    return this.mDrawable;
  }
  
  public boolean isRecycled()
  {
    if ((this.mDrawable != null) && ((this.mDrawable instanceof NewGifDrawable))) {
      return ((NewGifDrawable)this.mDrawable).isRecycled();
    }
    return false;
  }
  
  public void recycle()
  {
    if ((this.mDrawable != null) && ((this.mDrawable instanceof NewGifDrawable))) {
      ((NewGifDrawable)this.mDrawable).recycle();
    }
  }
  
  public int size()
  {
    if ((this.mDrawable != null) && ((this.mDrawable instanceof NewGifDrawable))) {
      return this.mDrawable.getIntrinsicWidth() * this.mDrawable.getIntrinsicHeight() * 4;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.component.media.image.image.NewGifImage
 * JD-Core Version:    0.7.0.1
 */