package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mvp.IBasePresenter;
import com.tencent.mvp.IBasePresenterView;
import com.tencent.mvp.SimpleMVPUtils;
import com.tencent.qphone.base.util.QLog;

public class CircleProgressView
  extends ImageView
  implements IBasePresenterView
{
  private Paint a;
  private Bitmap b;
  private Matrix c = new Matrix();
  private RectF d = new RectF();
  private Rect e = new Rect();
  private int f = 0;
  private int g = -1;
  private int h = -9013368;
  private int i = 6;
  private int j = ScreenUtil.dip2px(9.0F);
  private boolean k = false;
  private ICircleProcessViewPresenter l;
  
  public CircleProgressView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public CircleProgressView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = new Paint();
    this.a.setAntiAlias(true);
  }
  
  public IBasePresenter getPresenter()
  {
    return this.l;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int n = getWidth();
    int i1 = getHeight();
    int m = paramCanvas.getSaveCount();
    paramCanvas.save();
    Object localObject1 = this.b;
    if (localObject1 != null) {}
    try
    {
      localObject1 = Bitmap.createBitmap(((Bitmap)localObject1).getWidth(), this.b.getHeight(), Bitmap.Config.ARGB_8888);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label56:
      Object localObject2;
      int i2;
      float f1;
      break label56;
    }
    localObject1 = null;
    localObject2 = this.b;
    if ((localObject2 != null) && (localObject1 != null))
    {
      this.e.set(0, 0, ((Bitmap)localObject2).getWidth(), this.b.getHeight());
      this.a.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
      this.d.set(0.0F, 0.0F, n, i1);
      n = this.f * 360 / 100;
      localObject2 = new Canvas((Bitmap)localObject1);
      ((Canvas)localObject2).drawBitmap(this.b, null, this.e, null);
      ((Canvas)localObject2).drawArc(this.d, n - 90, 360 - n, true, this.a);
      paramCanvas.drawBitmap((Bitmap)localObject1, null, this.e, null);
      ((Bitmap)localObject1).recycle();
    }
    else
    {
      i2 = this.g;
      if (i2 > 0) {
        f1 = i2;
      } else {
        f1 = 3.0F;
      }
      localObject1 = this.d;
      i2 = this.j;
      ((RectF)localObject1).set(i2 + f1, i2 + f1, n - f1 - i2, i1 - f1 - i2);
      this.a.setStyle(Paint.Style.STROKE);
      this.a.setStrokeWidth(this.i);
      this.a.setColor(this.h);
      n = this.f * 360 / 100;
      paramCanvas.drawArc(this.d, 270.0F, n, false, this.a);
    }
    paramCanvas.restoreToCount(m);
    if (this.k) {}
    try
    {
      SimpleMVPUtils.a(this, "startPlayAnim");
      this.k = false;
    }
    catch (Exception localException)
    {
      label371:
      break label371;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("CircleProgressView startPlayAnimByType error e=");
      ((StringBuilder)localObject1).append(toString());
      QLog.e("AIOAudioPanel", 2, ((StringBuilder)localObject1).toString());
    }
    this.k = false;
    super.onDraw(paramCanvas);
  }
  
  public void setAnimFlag(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }
  
  public void setPresenter(IBasePresenter paramIBasePresenter)
  {
    if (paramIBasePresenter == null)
    {
      this.l = null;
      return;
    }
    if ((paramIBasePresenter instanceof ICircleProcessViewPresenter)) {
      this.l = ((ICircleProcessViewPresenter)paramIBasePresenter);
    }
  }
  
  public void setProgress(int paramInt)
  {
    this.f = paramInt;
    invalidate();
  }
  
  public void setProgressBitmap(Bitmap paramBitmap)
  {
    this.b = paramBitmap;
  }
  
  public void setRingColor(int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setRingWidth(int paramInt)
  {
    this.i = paramInt;
  }
  
  public void setStrokeWidth(int paramInt)
  {
    this.g = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CircleProgressView
 * JD-Core Version:    0.7.0.1
 */