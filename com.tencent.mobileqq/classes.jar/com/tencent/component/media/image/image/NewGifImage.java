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
      Object localObject = new NewGifDecoder.Options();
      ((NewGifDecoder.Options)localObject).inPreferWidth = paramInt1;
      ((NewGifDecoder.Options)localObject).inPreferHeight = paramInt2;
      this.mDrawable = new NewGifDrawable(paramImageKey.filePath, (NewGifDecoder.Options)localObject, paramImageKey.url);
      localObject = ImageManagerEnv.getLogger();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("create NewGifImage url: ");
      localStringBuilder.append(paramImageKey.url);
      ((ILog)localObject).d("NewGifImage", new Object[] { localStringBuilder.toString() });
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
    Drawable localDrawable = this.mDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof NewGifDrawable))) {
      return ((NewGifDrawable)localDrawable).isRecycled();
    }
    return false;
  }
  
  public void recycle()
  {
    Drawable localDrawable = this.mDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof NewGifDrawable))) {
      ((NewGifDrawable)localDrawable).recycle();
    }
  }
  
  public int size()
  {
    Drawable localDrawable = this.mDrawable;
    if ((localDrawable != null) && ((localDrawable instanceof NewGifDrawable))) {
      return localDrawable.getIntrinsicWidth() * this.mDrawable.getIntrinsicHeight() * 4;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.component.media.image.image.NewGifImage
 * JD-Core Version:    0.7.0.1
 */