package com.tencent.av.ui.funchat.record;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class QavRecordButtonView
  extends View
{
  private Paint a = null;
  private RectF b = null;
  private Rect c = null;
  private int d = 1;
  private float e = 0.0F;
  private Bitmap f = null;
  private QavRecordButtonView.ShowStateChangeListener g;
  
  public QavRecordButtonView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public QavRecordButtonView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public QavRecordButtonView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private Bitmap a(int paramInt)
  {
    try
    {
      Bitmap localBitmap = BitmapFactory.decodeResource(getResources(), paramInt);
      return localBitmap;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("QavRecordButtonView", 1, "decodeBitmap Throwable", localThrowable);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("QavRecordButtonView", 1, "decodeBitmap oom", localOutOfMemoryError);
    }
    return null;
  }
  
  private void a()
  {
    this.a = new Paint();
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.STROKE);
    this.b = new RectF();
    this.c = new Rect();
    this.f = a(2130843248);
    super.setOnTouchListener(new QavRecordButtonView.1(this));
  }
  
  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    int i = getWidth();
    int j = getHeight();
    int k = this.d;
    if ((k != 1) && (k != 2))
    {
      if (k != 3) {
        return;
      }
      Object localObject = this.f;
      if (localObject != null)
      {
        this.c.set(0, 0, ((Bitmap)localObject).getWidth(), this.f.getHeight());
        this.b.set(0.0F, 0.0F, i, j);
        paramCanvas.drawBitmap(this.f, this.c, this.b, this.a);
      }
      float f1 = i;
      float f2 = 0.08571429F * f1;
      f1 = Math.min(i, j) / 2 - f2 - f1 * 0.002857143F;
      this.a.setStrokeWidth(f2);
      localObject = this.b;
      f2 = i / 2;
      float f3 = j / 2;
      ((RectF)localObject).set(f2 - f1, f3 - f1, f2 + f1, f3 + f1);
      f1 = this.e;
      this.a.setColor(-1);
      paramCanvas.drawArc(this.b, 0.0F, 360.0F, false, this.a);
      this.a.setColor(-48606);
      paramCanvas.drawArc(this.b, -90.0F, 360.0F - (1.0F - f1) * 360.0F, false, this.a);
    }
  }
  
  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
  }
  
  public int getShowState()
  {
    return this.d;
  }
  
  public void setListener(QavRecordButtonView.ShowStateChangeListener paramShowStateChangeListener)
  {
    this.g = paramShowStateChangeListener;
  }
  
  public void setProgress(long paramLong1, long paramLong2)
  {
    this.e = Math.min(1.0F, Math.max((float)paramLong1 * 1.0F / (float)paramLong2, 0.0F));
    if (this.d == 3) {
      invalidate();
    }
  }
  
  public void setShowState(int paramInt, boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setShowState, state=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(", talkBack=");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.i("QavRecordButtonView", 2, ((StringBuilder)localObject).toString());
    }
    if (paramInt == this.d) {
      return;
    }
    this.d = paramInt;
    paramInt = this.d;
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt == 3)
        {
          if (paramBoolean) {
            super.setContentDescription(getResources().getString(2131893538));
          }
          this.e = 0.0F;
        }
      }
      else if (paramBoolean) {
        super.setContentDescription(getResources().getString(2131893537));
      }
    }
    else
    {
      super.setAlpha(1.0F);
      if (paramBoolean) {
        super.setContentDescription("");
      }
    }
    invalidate();
    Object localObject = this.g;
    if (localObject != null) {
      ((QavRecordButtonView.ShowStateChangeListener)localObject).e(this.d);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.av.ui.funchat.record.QavRecordButtonView
 * JD-Core Version:    0.7.0.1
 */