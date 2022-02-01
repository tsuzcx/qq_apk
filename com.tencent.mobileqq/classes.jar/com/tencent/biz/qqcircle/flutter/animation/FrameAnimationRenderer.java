package com.tencent.biz.qqcircle.flutter.animation;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.os.Handler;
import android.os.SystemClock;
import android.view.Surface;
import androidx.annotation.NonNull;
import com.qflutter.vistaimage.IRenderer;
import com.qflutter.vistaimage.RendererParams;
import com.tencent.biz.richframework.animation.drawable.QQAnimationDrawable;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;

public class FrameAnimationRenderer
  implements Drawable.Callback, IRenderer
{
  private Bitmap a;
  private Surface b;
  private QQAnimationDrawable c = new QQAnimationDrawable();
  private String d;
  
  public FrameAnimationRenderer(String paramString, QCircleFlutterAnimationLoader.AnimationParam paramAnimationParam, int paramInt1, int paramInt2)
  {
    this.c.a(paramAnimationParam.a);
    this.c.a(paramAnimationParam.b);
    this.c.b(true);
    this.c.setCallback(this);
    this.c.setBounds(0, 0, paramInt1, paramInt2);
    this.a = Bitmap.createBitmap(1, 1, Bitmap.Config.RGB_565);
    this.d = paramString;
  }
  
  private void a(Drawable paramDrawable)
  {
    Object localObject = this.b;
    if ((localObject != null) && (((Surface)localObject).isValid())) {
      try
      {
        localObject = this.b.lockCanvas(null);
        ((Canvas)localObject).drawColor(0, PorterDuff.Mode.CLEAR);
        paramDrawable.draw((Canvas)localObject);
        this.b.unlockCanvasAndPost((Canvas)localObject);
        return;
      }
      catch (Exception paramDrawable)
      {
        QLog.e("FrameAnimationRenderer", 1, "[renderFrame]", paramDrawable);
        return;
      }
    }
    paramDrawable = new StringBuilder();
    paramDrawable.append("[render] name=");
    paramDrawable.append(this.d);
    paramDrawable.append(", invalid surface");
    QLog.w("FrameAnimationRenderer", 1, paramDrawable.toString());
  }
  
  public Bitmap a()
  {
    return this.a;
  }
  
  public void clean()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[clean] name=");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("FrameAnimationRenderer", 1, ((StringBuilder)localObject).toString());
    }
    this.c.stop();
    this.c.e();
    this.c.a(null);
    Object localObject = this.b;
    if (localObject != null)
    {
      ((Surface)localObject).release();
      this.b = null;
    }
  }
  
  public void init(RendererParams paramRendererParams)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[init] name=");
      localStringBuilder.append(this.d);
      QLog.d("FrameAnimationRenderer", 1, localStringBuilder.toString());
    }
    this.b = paramRendererParams.getSurface();
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    a(paramDrawable);
  }
  
  public void render()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[render] name=");
      ((StringBuilder)localObject).append(this.d);
      QLog.d("FrameAnimationRenderer", 1, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.b;
    if ((localObject != null) && (((Surface)localObject).isValid()))
    {
      localObject = this.b.lockCanvas(null);
      ((Canvas)localObject).drawColor(0, PorterDuff.Mode.CLEAR);
      this.b.unlockCanvasAndPost((Canvas)localObject);
      this.c.start();
      return;
    }
    QLog.w("FrameAnimationRenderer", 1, "[render] invalid surface");
  }
  
  public void scheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    RFThreadManager.getUIHandler().postDelayed(paramRunnable, paramLong - l - 10L);
  }
  
  public void unscheduleDrawable(@NonNull Drawable paramDrawable, @NonNull Runnable paramRunnable)
  {
    if (QLog.isColorLevel())
    {
      paramDrawable = new StringBuilder();
      paramDrawable.append("[unscheduleDrawable] name=");
      paramDrawable.append(this.d);
      QLog.d("FrameAnimationRenderer", 1, paramDrawable.toString());
    }
  }
  
  public void updateDrawable(Drawable paramDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.FrameAnimationRenderer
 * JD-Core Version:    0.7.0.1
 */