package com.tencent.mobileqq.apollo.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

public class FrameGifView
  extends ImageView
  implements SimpleFrameZipDecoder.OnFrameDecodeListener
{
  private FrameGifView.DecoderRunnable a = new FrameGifView.DecoderRunnable();
  FrameGifView.AnimationListener b;
  protected QQFrameZipDecoder c = new QQFrameZipDecoder(this);
  
  public FrameGifView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FrameGifView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FrameGifView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(int paramInt, Bitmap paramBitmap)
  {
    super.setImageBitmap(paramBitmap);
  }
  
  public void b()
  {
    FrameGifView.AnimationListener localAnimationListener = this.b;
    if (localAnimationListener != null) {
      localAnimationListener.a();
    }
  }
  
  public void c()
  {
    QQFrameZipDecoder localQQFrameZipDecoder = this.c;
    if (localQQFrameZipDecoder != null) {
      localQQFrameZipDecoder.b();
    }
  }
  
  public void d()
  {
    QQFrameZipDecoder localQQFrameZipDecoder = this.c;
    if (localQQFrameZipDecoder != null) {
      localQQFrameZipDecoder.c();
    }
  }
  
  public int getState()
  {
    QQFrameZipDecoder localQQFrameZipDecoder = this.c;
    if (localQQFrameZipDecoder != null) {
      return localQQFrameZipDecoder.a();
    }
    return 0;
  }
  
  public void setAnimaListener(FrameGifView.AnimationListener paramAnimationListener)
  {
    this.b = paramAnimationListener;
  }
  
  public void setGifData(int paramInt, Drawable paramDrawable, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (getDrawable() == null) {
      super.setImageDrawable(paramDrawable);
    }
    paramDrawable = this.c;
    if (paramDrawable != null)
    {
      this.a.a(paramDrawable, paramInt, paramString1, paramString2, paramBoolean);
      ThreadManager.getSubThreadHandler().removeCallbacks(this.a);
      ThreadManager.getSubThreadHandler().post(this.a);
    }
  }
  
  public void setPlayLoop(boolean paramBoolean)
  {
    QQFrameZipDecoder localQQFrameZipDecoder = this.c;
    if (localQQFrameZipDecoder != null) {
      localQQFrameZipDecoder.a(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.FrameGifView
 * JD-Core Version:    0.7.0.1
 */