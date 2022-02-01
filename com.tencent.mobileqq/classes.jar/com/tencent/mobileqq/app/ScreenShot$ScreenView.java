package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

class ScreenShot$ScreenView
  extends View
{
  Bitmap a;
  final Paint b = new Paint();
  final Paint c = new Paint();
  final Rect d = new Rect();
  final Rect e = new Rect();
  final Matrix f = new Matrix();
  final Matrix g = new Matrix();
  int h;
  int i;
  int j;
  int k;
  int l;
  boolean m;
  int n;
  
  public ScreenShot$ScreenView(ScreenShot paramScreenShot, Context paramContext)
  {
    super(paramContext);
    setLongClickable(true);
  }
  
  private void a(Canvas paramCanvas)
  {
    if ((this.m) && (this.o.i != null))
    {
      this.m = false;
      try
      {
        this.a = Bitmap.createBitmap(this.d.width(), this.d.height(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(this.a);
        this.g.reset();
        this.g.postConcat(this.f);
        this.g.postTranslate(-this.d.left, -this.d.top);
        if (this.o.i != null) {
          localCanvas.drawBitmap(this.o.i, this.g, this.b);
        }
      }
      catch (Throwable localThrowable)
      {
        this.a = null;
        if (QLog.isColorLevel()) {
          QLog.d("ScreenShot", 2, "", localThrowable);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.d.width());
          localStringBuilder.append(":");
          localStringBuilder.append(this.d.height());
          QLog.d("ScreenShot", 2, localStringBuilder.toString(), localIllegalArgumentException);
        }
      }
      this.b.setColor(-2147483648);
      this.b.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.b);
      ScreenShot.a("save and hide");
      ScreenShot.a(this.o);
      if (this.a == null)
      {
        Toast.makeText(this.o.a.getApplicationContext(), 2131915863, 1).show();
        return;
      }
      ScreenShot.b(this.o).obtainMessage(2, 0, 0, this).sendToTarget();
      return;
    }
    this.b.setColor(-2147483648);
    this.b.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.d.top, this.b);
    paramCanvas.drawRect(0.0F, this.d.bottom, getWidth(), getHeight(), this.b);
    paramCanvas.drawRect(0.0F, this.d.top, this.d.left, this.d.bottom, this.b);
    paramCanvas.drawRect(this.d.right, this.d.top, getWidth(), this.d.bottom, this.b);
    this.b.setStyle(Paint.Style.STROKE);
    this.b.setColor(-16847);
    paramCanvas.drawRect(this.d, this.b);
    int i2;
    int i3;
    int i4;
    if (this.d.isEmpty())
    {
      i1 = getWidth() / 2 - this.o.l.getIntrinsicWidth() / 2;
      i2 = getHeight() / 2 - this.o.l.getIntrinsicHeight() / 2;
      i3 = this.o.l.getIntrinsicWidth();
      i4 = this.o.l.getIntrinsicHeight() + i2;
      float f1 = getResources().getDisplayMetrics().density;
      this.o.l.setBounds(i1, i2, i3 + i1, i4);
      this.o.l.draw(paramCanvas);
      this.c.setTextSize(getResources().getDisplayMetrics().scaledDensity * 20.0F);
      this.c.setAntiAlias(true);
      this.c.setTextAlign(Paint.Align.CENTER);
      this.c.setColor(-1);
      this.c.setShadowLayer(2.0F, 0.0F, f1 * 2.0F, -2147483648);
      paramCanvas.drawText(this.o.a.getString(2131916713), getWidth() / 2, i4 + f1 * 26.0F, this.c);
    }
    int i1 = this.n;
    if ((i1 != 100001) && (i1 != 0))
    {
      this.b.setStyle(Paint.Style.FILL);
      i3 = this.d.left - this.o.m.getIntrinsicWidth() / 2;
      i1 = this.d.top - this.o.m.getIntrinsicHeight() / 2;
      i4 = this.o.m.getIntrinsicWidth();
      i2 = this.o.m.getIntrinsicHeight() + i1;
      this.o.m.setBounds(i3, i1, i4 + i3, i2);
      this.o.m.draw(paramCanvas);
      i3 = this.d.right - this.o.m.getIntrinsicWidth() / 2;
      i4 = this.o.m.getIntrinsicWidth() + i3;
      this.o.m.setBounds(i3, i1, i4, i2);
      this.o.m.draw(paramCanvas);
      i1 = this.d.bottom - this.o.m.getIntrinsicHeight() / 2;
      i2 = this.o.m.getIntrinsicHeight() + i1;
      this.o.m.setBounds(i3, i1, i4, i2);
      this.o.m.draw(paramCanvas);
      i3 = this.d.left - this.o.m.getIntrinsicWidth() / 2;
      i4 = this.o.m.getIntrinsicWidth();
      this.o.m.setBounds(i3, i1, i4 + i3, i2);
      this.o.m.draw(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      int i1;
      if (this.o.g == null)
      {
        localObject = new Rect();
        this.o.b.getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
        i1 = ((Rect)localObject).top;
      }
      else
      {
        i1 = 0;
      }
      if (this.o.i != null) {
        if (this.f.isIdentity()) {
          this.d.set(0, i1, this.o.i.getWidth(), this.o.i.getHeight());
        } else {
          this.d.set(i1, 0, this.o.i.getHeight(), this.o.i.getWidth());
        }
      }
    }
    if (this.d.isEmpty())
    {
      this.d.left = getLeft();
      this.d.right = getRight();
      this.d.top = getTop();
      this.d.bottom = getBottom();
    }
    if ((this.d.width() > 0) && (this.d.height() > 0))
    {
      this.m = true;
      if (paramBoolean) {
        localObject = "1";
      } else {
        localObject = "0";
      }
      ReportController.b(null, "CliOper", "", "", "0X8005007", "0X8005007", 0, 0, (String)localObject, "", "", "");
      invalidate();
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    Object localObject1;
    if (this.o.g != null)
    {
      localObject1 = this.o;
      ((ScreenShot)localObject1).i = ((ScreenShot)localObject1).g;
      this.f.reset();
      localObject1 = getResources().getDisplayMetrics();
      this.f.reset();
      if ((((DisplayMetrics)localObject1).heightPixels == this.o.i.getWidth()) && (((DisplayMetrics)localObject1).widthPixels == this.o.i.getHeight()))
      {
        this.f.postTranslate(-this.o.i.getWidth() / 2, -this.o.i.getHeight() / 2);
        this.f.postRotate(90.0F);
        this.f.postTranslate(this.o.i.getHeight() / 2, this.o.i.getWidth() / 2);
      }
    }
    else
    {
      i1 = getWidth();
      int i2 = getHeight();
      if ((this.o.h == null) && (i1 > 0) && (i2 > 0)) {
        try
        {
          this.o.h = Bitmap.createBitmap(i1, i2, Bitmap.Config.ARGB_8888);
          if (this.o.h != null)
          {
            localObject1 = new Canvas(this.o.h);
            this.o.b.getDecorView().draw((Canvas)localObject1);
            this.o.i = this.o.h;
          }
        }
        catch (Throwable localThrowable)
        {
          if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "", localThrowable);
          }
        }
      }
      this.f.reset();
      if ((this.o.i != null) && (this.o.i.getWidth() != i1))
      {
        this.f.postTranslate(-this.o.i.getWidth() / 2, -this.o.i.getHeight() / 2);
        this.f.postRotate(90.0F);
        this.f.postTranslate(this.o.i.getHeight() / 2, this.o.i.getWidth() / 2);
      }
    }
    if (this.o.i != null) {
      paramCanvas.drawBitmap(this.o.i, this.f, this.b);
    }
    int i1 = this.n;
    Object localObject2;
    if ((i1 != 0) && (i1 != 100001))
    {
      this.b.setStrokeWidth(3.0F);
      localObject2 = this.b;
      i1 = this.l + 1;
      this.l = i1;
      float f1 = i1;
      ((Paint)localObject2).setPathEffect(new DashPathEffect(new float[] { 15.0F, 5.0F, 8.0F, 5.0F }, f1));
      invalidate();
    }
    else
    {
      this.b.setStrokeWidth(1.0F);
      this.b.setPathEffect(null);
      this.l = 0;
    }
    this.b.setColor(-16847);
    if (this.d.left > this.d.right)
    {
      i1 = this.d.left;
      localObject2 = this.d;
      ((Rect)localObject2).left = ((Rect)localObject2).right;
      this.d.right = i1;
    }
    if (this.d.top > this.d.bottom)
    {
      i1 = this.d.top;
      localObject2 = this.d;
      ((Rect)localObject2).top = ((Rect)localObject2).bottom;
      this.d.bottom = i1;
    }
    a(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1 = paramMotionEvent.getAction();
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        if (i1 == 2)
        {
          this.j = ((int)paramMotionEvent.getX());
          this.k = ((int)paramMotionEvent.getY());
          i1 = this.n;
          int i2;
          Rect localRect;
          if (i1 == 100004)
          {
            i1 = this.j;
            i2 = i1 - this.h;
            int i3 = this.k;
            int i4 = i3 - this.i;
            this.h = i1;
            this.i = i3;
            if ((this.d.left + i2 >= 0) && (this.d.right + i2 <= getWidth()))
            {
              localRect = this.d;
              localRect.left += i2;
              localRect = this.d;
              localRect.right += i2;
            }
            if ((this.d.top + i4 >= 0) && (this.d.bottom + i4 <= getHeight()))
            {
              localRect = this.d;
              localRect.top += i4;
              localRect = this.d;
              localRect.bottom += i4;
            }
          }
          else if (i1 == 100001)
          {
            localRect = this.d;
            localRect.left = this.h;
            localRect.top = this.i;
            localRect.right = this.j;
            localRect.bottom = this.k;
          }
          else if (i1 == 100005)
          {
            i1 = this.j - this.h;
            i2 = this.k - this.i;
            this.d.set(this.e);
            if (this.h < this.d.left + this.d.width() / 2)
            {
              localRect = this.d;
              localRect.left += i1;
              localRect = this.d;
              localRect.left = Math.max(localRect.left, 0);
            }
            else
            {
              localRect = this.d;
              localRect.right += i1;
              localRect = this.d;
              localRect.right = Math.min(localRect.right, getWidth());
            }
            if (this.i < this.d.top + this.d.height() / 2)
            {
              localRect = this.d;
              localRect.top += i2;
              localRect = this.d;
              localRect.top = Math.max(localRect.top, 0);
            }
            else
            {
              localRect = this.d;
              localRect.bottom += i2;
              localRect = this.d;
              localRect.bottom = Math.min(localRect.bottom, getHeight());
            }
          }
          this.o.c.setVisibility(8);
          this.o.d.setVisibility(8);
          this.o.e.setVisibility(8);
          this.o.f.setVisibility(8);
          invalidate();
        }
      }
      else
      {
        if (Math.abs(this.d.width()) < 5)
        {
          this.d.setEmpty();
          i1 = 1;
        }
        else
        {
          i1 = 0;
        }
        if (i1 == 0)
        {
          this.n = 100002;
          ScreenShot.a(this.o, true);
        }
        else
        {
          this.n = 0;
          ScreenShot.a(this.o, false);
        }
        invalidate();
      }
    }
    else
    {
      this.h = ((int)paramMotionEvent.getX());
      this.i = ((int)paramMotionEvent.getY());
      if (!this.d.isEmpty())
      {
        if (this.d.contains(this.h, this.i))
        {
          this.n = 100004;
        }
        else if (new Rect(this.d.left - 20, this.d.top - 20, this.d.right + 20, this.d.bottom + 20).contains(this.h, this.i))
        {
          this.n = 100005;
          this.e.set(this.d);
        }
        else
        {
          this.d.setEmpty();
          this.n = 100001;
          this.b.setStrokeWidth(1.0F);
          this.b.setPathEffect(null);
          ScreenShot.a(this.o, false);
        }
      }
      else
      {
        this.n = 100001;
        ScreenShot.a(this.o, false);
      }
      invalidate();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ScreenShot.ScreenView
 * JD-Core Version:    0.7.0.1
 */