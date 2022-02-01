package com.tencent.mobileqq.activity.aio.audiopanel;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mvp.IBasePresenter;
import com.tencent.mvp.IBasePresenterView;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class MoveDistIndicateView
  extends ImageView
  implements IBasePresenterView
{
  public int a;
  public int b;
  private Paint c;
  private int d;
  private Bitmap e;
  private Bitmap f;
  private Matrix g = new Matrix();
  private Rect h = new Rect();
  private int i = 0;
  private int j = 0;
  private IThemeViewPresenter k;
  
  public MoveDistIndicateView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.c = new Paint();
    this.c.setAntiAlias(true);
    this.a = ViewUtils.dip2px(29.0F);
    this.b = ViewUtils.dip2px(42.0F);
    this.j = ViewUtils.dip2px(10.0F);
    this.d = this.a;
    if (QLog.isDevelopLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("init(), mRaidusMin:");
      paramContext.append(this.a);
      paramContext.append(",mRaidusMax:");
      paramContext.append(this.b);
      QLog.d("MoveDistIndicateView", 4, paramContext.toString());
    }
  }
  
  public IBasePresenter getPresenter()
  {
    return this.k;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    int m = getWidth();
    int n = getHeight();
    int i2 = m / 2;
    int i3 = n / 2;
    int i1 = paramCanvas.getSaveCount();
    paramCanvas.save();
    int i4 = this.d;
    int i5 = this.a;
    float f1;
    if (i4 > this.j + i5)
    {
      if (this.f != null)
      {
        f1 = this.b / i5;
        this.g.reset();
        i2 = this.f.getWidth();
        i3 = this.f.getHeight();
        this.g.setScale(f1, f1);
        this.g.postTranslate((m - i2 * f1) / 2.0F, (n - i3 * f1) / 2.0F);
        this.h.set(0, 0, i2, i3);
        paramCanvas.concat(this.g);
        paramCanvas.drawBitmap(this.f, null, this.h, null);
      }
      else
      {
        if (this.i == 1) {
          this.c.setColor(getResources().getColor(2131168158));
        } else {
          this.c.setColor(getResources().getColor(2131168159));
        }
        this.c.setStyle(Paint.Style.FILL_AND_STROKE);
        this.c.setStrokeWidth(1.0F);
        paramCanvas.drawCircle(i2, i3, this.d, this.c);
      }
    }
    else if (i4 > i5)
    {
      this.c.setColor(getResources().getColor(2131167992));
      this.c.setStyle(Paint.Style.FILL_AND_STROKE);
      this.c.setStrokeWidth(1.0F);
      paramCanvas.drawCircle(i2, i3, this.a, this.c);
    }
    else
    {
      Object localObject;
      if (this.e != null)
      {
        f1 = i4 / i5;
        this.g.reset();
        i2 = this.e.getWidth();
        i3 = this.e.getHeight();
        float f2 = (m - i2 * f1) * 0.5F + 0.5F;
        float f3 = (n - i3 * f1) * 0.5F + 0.5F;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("dx is:");
          ((StringBuilder)localObject).append(f2);
          ((StringBuilder)localObject).append(",dy is:");
          ((StringBuilder)localObject).append(f3);
          QLog.d("AIOAudioPanel", 2, ((StringBuilder)localObject).toString());
        }
        this.g.setScale(f1, f1);
        this.g.postTranslate(f2, f3);
        this.h.set(0, 0, i2, i3);
        paramCanvas.concat(this.g);
        paramCanvas.drawBitmap(this.e, null, this.h, null);
      }
      else
      {
        localObject = this.k;
        if ((localObject != null) && (((IThemeViewPresenter)localObject).a(MobileQQ.sMobileQQ.peekAppRuntime(), false, null))) {
          this.c.setColor(-16711423);
        } else {
          this.c.setColor(-1);
        }
        this.c.setStyle(Paint.Style.FILL);
        this.c.setStrokeWidth(1.0F);
        paramCanvas.drawCircle(i2, i3, this.d, this.c);
      }
    }
    paramCanvas.restoreToCount(i1);
    super.onDraw(paramCanvas);
  }
  
  public void setAfterBitmap(Bitmap paramBitmap)
  {
    this.f = paramBitmap;
  }
  
  public void setLevel(int paramInt)
  {
    int m = this.a;
    this.d = (m + (this.b - m) * paramInt / 100);
    if (QLog.isDevelopLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setLevel(), max=");
      localStringBuilder.append(this.b);
      localStringBuilder.append(" min=");
      localStringBuilder.append(this.a);
      localStringBuilder.append(" mRadius=");
      localStringBuilder.append(this.d);
      localStringBuilder.append(" type =");
      localStringBuilder.append(this.i);
      localStringBuilder.append(" level=");
      localStringBuilder.append(paramInt);
      QLog.d("MoveDistIndicateView", 4, localStringBuilder.toString());
    }
    if (this.d > this.a + this.j) {
      setPressed(true);
    } else {
      setPressed(false);
    }
    invalidate();
  }
  
  public void setPresenter(IBasePresenter paramIBasePresenter)
  {
    if ((paramIBasePresenter != null) && ((paramIBasePresenter instanceof IThemeViewPresenter))) {
      this.k = ((IThemeViewPresenter)paramIBasePresenter);
    }
    if (paramIBasePresenter == null) {
      this.k = null;
    }
  }
  
  public void setScaleBitmap(Bitmap paramBitmap)
  {
    this.e = paramBitmap;
  }
  
  public void setType(int paramInt)
  {
    this.i = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.MoveDistIndicateView
 * JD-Core Version:    0.7.0.1
 */