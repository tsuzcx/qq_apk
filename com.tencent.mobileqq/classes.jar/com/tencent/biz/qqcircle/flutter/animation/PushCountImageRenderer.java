package com.tencent.biz.qqcircle.flutter.animation;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Surface;
import com.qflutter.vistaimage.IRenderer;
import com.qflutter.vistaimage.RendererParams;
import com.tencent.biz.richframework.delegate.impl.RFThreadManager;
import com.tencent.qphone.base.util.QLog;

public class PushCountImageRenderer
  implements IRenderer
{
  private static Bitmap[] b;
  private int a;
  private Surface c;
  private Paint d = new Paint();
  private Rect e;
  private Rect f;
  
  public PushCountImageRenderer(int paramInt)
  {
    this.a = (paramInt - 1);
  }
  
  public static void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PushCountImageRenderer", 2, "[unloadCountBitmaps]");
    }
    b = null;
  }
  
  public static void a(String[] paramArrayOfString)
  {
    try
    {
      BitmapFactory.Options localOptions = new BitmapFactory.Options();
      localOptions.inSampleSize = 2;
      b = new Bitmap[paramArrayOfString.length];
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        b[i] = BitmapFactory.decodeFile(paramArrayOfString[i], localOptions);
        i += 1;
      }
      return;
    }
    catch (Throwable paramArrayOfString)
    {
      QLog.e("PushCountImageRenderer", 1, "[loadCountBitmaps]", paramArrayOfString);
      b = null;
    }
  }
  
  public static void a(String[] paramArrayOfString, PushCountImageRenderer.LoadCountBitmapsListener paramLoadCountBitmapsListener)
  {
    RFThreadManager.execute(new PushCountImageRenderer.1(paramLoadCountBitmapsListener, paramArrayOfString), RFThreadManager.Normal);
  }
  
  public Bitmap b()
  {
    Bitmap[] arrayOfBitmap = b;
    if (arrayOfBitmap == null) {
      return null;
    }
    return arrayOfBitmap[0];
  }
  
  public void clean()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PushCountImageRenderer", 2, "[clean]");
    }
    Surface localSurface = this.c;
    if (localSurface != null)
    {
      if (localSurface.isValid()) {
        this.c.release();
      }
      this.c = null;
    }
  }
  
  public void init(RendererParams paramRendererParams)
  {
    Bitmap[] arrayOfBitmap = b;
    if ((arrayOfBitmap != null) && (arrayOfBitmap.length != 0))
    {
      this.c = paramRendererParams.getSurface();
      this.e = new Rect(0, 0, paramRendererParams.getViewWidth(), paramRendererParams.getViewHeight());
      this.f = new Rect(0, 0, b[0].getWidth(), b[0].getHeight());
      return;
    }
    QLog.w("PushCountImageRenderer", 1, "[init] invalid countBitmaps");
  }
  
  public void render()
  {
    Object localObject = this.c;
    if ((localObject != null) && (((Surface)localObject).isValid()) && (b != null))
    {
      localObject = this.c.lockCanvas(null);
      ((Canvas)localObject).drawColor(0, PorterDuff.Mode.CLEAR);
      ((Canvas)localObject).drawBitmap(b[this.a], this.f, this.e, this.d);
      this.c.unlockCanvasAndPost((Canvas)localObject);
      return;
    }
    QLog.w("PushCountImageRenderer", 1, "[render] invalid surface or countBitmaps");
  }
  
  public void updateDrawable(Drawable paramDrawable) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.flutter.animation.PushCountImageRenderer
 * JD-Core Version:    0.7.0.1
 */