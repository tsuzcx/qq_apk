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
  int jdField_a_of_type_Int;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  final Matrix jdField_a_of_type_AndroidGraphicsMatrix = new Matrix();
  final Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint();
  final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  final Matrix jdField_b_of_type_AndroidGraphicsMatrix = new Matrix();
  final Paint jdField_b_of_type_AndroidGraphicsPaint = new Paint();
  final Rect jdField_b_of_type_AndroidGraphicsRect = new Rect();
  int c;
  int d;
  int e;
  int f;
  
  public ScreenShot$ScreenView(ScreenShot paramScreenShot, Context paramContext)
  {
    super(paramContext);
    setLongClickable(true);
  }
  
  private void a(Canvas paramCanvas)
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap != null))
    {
      this.jdField_a_of_type_Boolean = false;
      try
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(this.jdField_a_of_type_AndroidGraphicsRect.width(), this.jdField_a_of_type_AndroidGraphicsRect.height(), Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
        this.jdField_b_of_type_AndroidGraphicsMatrix.reset();
        this.jdField_b_of_type_AndroidGraphicsMatrix.postConcat(this.jdField_a_of_type_AndroidGraphicsMatrix);
        this.jdField_b_of_type_AndroidGraphicsMatrix.postTranslate(-this.jdField_a_of_type_AndroidGraphicsRect.left, -this.jdField_a_of_type_AndroidGraphicsRect.top);
        if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap != null) {
          localCanvas.drawBitmap(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
        }
      }
      catch (Throwable localThrowable)
      {
        this.jdField_a_of_type_AndroidGraphicsBitmap = null;
        if (QLog.isColorLevel()) {
          QLog.d("ScreenShot", 2, "", localThrowable);
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException)
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsRect.width());
          localStringBuilder.append(":");
          localStringBuilder.append(this.jdField_a_of_type_AndroidGraphicsRect.height());
          QLog.d("ScreenShot", 2, localStringBuilder.toString(), localIllegalArgumentException);
        }
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2147483648);
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      paramCanvas.drawRect(0.0F, 0.0F, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
      ScreenShot.a("save and hide");
      ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot);
      if (this.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidContentContext.getApplicationContext(), 2131718371, 1).show();
        return;
      }
      ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot).obtainMessage(2, 0, 0, this).sendToTarget();
      return;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-2147483648);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
    paramCanvas.drawRect(0.0F, 0.0F, getWidth(), this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(0.0F, this.jdField_a_of_type_AndroidGraphicsRect.bottom, getWidth(), getHeight(), this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(0.0F, this.jdField_a_of_type_AndroidGraphicsRect.top, this.jdField_a_of_type_AndroidGraphicsRect.left, this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect.right, this.jdField_a_of_type_AndroidGraphicsRect.top, getWidth(), this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16847);
    paramCanvas.drawRect(this.jdField_a_of_type_AndroidGraphicsRect, this.jdField_a_of_type_AndroidGraphicsPaint);
    int j;
    int k;
    int m;
    if (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty())
    {
      i = getWidth() / 2 - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
      j = getHeight() / 2 - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
      k = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      m = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + j;
      float f1 = getResources().getDisplayMetrics().density;
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.setBounds(i, j, k + i, m);
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(getResources().getDisplayMetrics().scaledDensity * 20.0F);
      this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      this.jdField_b_of_type_AndroidGraphicsPaint.setTextAlign(Paint.Align.CENTER);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(-1);
      this.jdField_b_of_type_AndroidGraphicsPaint.setShadowLayer(2.0F, 0.0F, f1 * 2.0F, -2147483648);
      paramCanvas.drawText(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidContentContext.getString(2131719171), getWidth() / 2, m + f1 * 26.0F, this.jdField_b_of_type_AndroidGraphicsPaint);
    }
    int i = this.f;
    if ((i != 100001) && (i != 0))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.FILL);
      k = this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
      i = this.jdField_a_of_type_AndroidGraphicsRect.top - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
      m = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      j = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + i;
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, i, m + k, j);
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      k = this.jdField_a_of_type_AndroidGraphicsRect.right - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
      m = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() + k;
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, i, m, j);
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      i = this.jdField_a_of_type_AndroidGraphicsRect.bottom - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() / 2;
      j = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicHeight() + i;
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, i, m, j);
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
      k = this.jdField_a_of_type_AndroidGraphicsRect.left - this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth() / 2;
      m = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.getIntrinsicWidth();
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setBounds(k, i, m + k, j);
      this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsDrawableDrawable.draw(paramCanvas);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    Object localObject;
    if (paramBoolean)
    {
      int i;
      if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsBitmap == null)
      {
        localObject = new Rect();
        this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidViewWindow.getDecorView().getWindowVisibleDisplayFrame((Rect)localObject);
        i = ((Rect)localObject).top;
      }
      else
      {
        i = 0;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap != null) {
        if (this.jdField_a_of_type_AndroidGraphicsMatrix.isIdentity()) {
          this.jdField_a_of_type_AndroidGraphicsRect.set(0, i, this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth(), this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight());
        } else {
          this.jdField_a_of_type_AndroidGraphicsRect.set(i, 0, this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight(), this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth());
        }
      }
    }
    if (this.jdField_a_of_type_AndroidGraphicsRect.isEmpty())
    {
      this.jdField_a_of_type_AndroidGraphicsRect.left = getLeft();
      this.jdField_a_of_type_AndroidGraphicsRect.right = getRight();
      this.jdField_a_of_type_AndroidGraphicsRect.top = getTop();
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = getBottom();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsRect.width() > 0) && (this.jdField_a_of_type_AndroidGraphicsRect.height() > 0))
    {
      this.jdField_a_of_type_Boolean = true;
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
    if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot;
      ((ScreenShot)localObject1).jdField_c_of_type_AndroidGraphicsBitmap = ((ScreenShot)localObject1).jdField_a_of_type_AndroidGraphicsBitmap;
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      localObject1 = getResources().getDisplayMetrics();
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      if ((((DisplayMetrics)localObject1).heightPixels == this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth()) && (((DisplayMetrics)localObject1).widthPixels == this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight()))
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(-this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() / 2, -this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() / 2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(90.0F);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() / 2, this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() / 2);
      }
    }
    else
    {
      i = getWidth();
      int j = getHeight();
      if ((this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap == null) && (i > 0) && (j > 0)) {
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888);
          if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap != null)
          {
            localObject1 = new Canvas(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap);
            this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidViewWindow.getDecorView().draw((Canvas)localObject1);
            this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap = this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidGraphicsBitmap;
          }
        }
        catch (Throwable localThrowable)
        {
          if (QLog.isColorLevel()) {
            QLog.d("mqq", 2, "", localThrowable);
          }
        }
      }
      this.jdField_a_of_type_AndroidGraphicsMatrix.reset();
      if ((this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap != null) && (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() != i))
      {
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(-this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() / 2, -this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() / 2);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postRotate(90.0F);
        this.jdField_a_of_type_AndroidGraphicsMatrix.postTranslate(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getHeight() / 2, this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap.getWidth() / 2);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap != null) {
      paramCanvas.drawBitmap(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_AndroidGraphicsMatrix, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    int i = this.f;
    Object localObject2;
    if ((i != 0) && (i != 100001))
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(3.0F);
      localObject2 = this.jdField_a_of_type_AndroidGraphicsPaint;
      i = this.e + 1;
      this.e = i;
      float f1 = i;
      ((Paint)localObject2).setPathEffect(new DashPathEffect(new float[] { 15.0F, 5.0F, 8.0F, 5.0F }, f1));
      invalidate();
    }
    else
    {
      this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
      this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(null);
      this.e = 0;
    }
    this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16847);
    if (this.jdField_a_of_type_AndroidGraphicsRect.left > this.jdField_a_of_type_AndroidGraphicsRect.right)
    {
      i = this.jdField_a_of_type_AndroidGraphicsRect.left;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject2).left = ((Rect)localObject2).right;
      this.jdField_a_of_type_AndroidGraphicsRect.right = i;
    }
    if (this.jdField_a_of_type_AndroidGraphicsRect.top > this.jdField_a_of_type_AndroidGraphicsRect.bottom)
    {
      i = this.jdField_a_of_type_AndroidGraphicsRect.top;
      localObject2 = this.jdField_a_of_type_AndroidGraphicsRect;
      ((Rect)localObject2).top = ((Rect)localObject2).bottom;
      this.jdField_a_of_type_AndroidGraphicsRect.bottom = i;
    }
    a(paramCanvas);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          this.c = ((int)paramMotionEvent.getX());
          this.d = ((int)paramMotionEvent.getY());
          i = this.f;
          int j;
          Rect localRect;
          if (i == 100004)
          {
            i = this.c;
            j = i - this.jdField_a_of_type_Int;
            int k = this.d;
            int m = k - this.jdField_b_of_type_Int;
            this.jdField_a_of_type_Int = i;
            this.jdField_b_of_type_Int = k;
            if ((this.jdField_a_of_type_AndroidGraphicsRect.left + j >= 0) && (this.jdField_a_of_type_AndroidGraphicsRect.right + j <= getWidth()))
            {
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              localRect.left += j;
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              localRect.right += j;
            }
            if ((this.jdField_a_of_type_AndroidGraphicsRect.top + m >= 0) && (this.jdField_a_of_type_AndroidGraphicsRect.bottom + m <= getHeight()))
            {
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              localRect.top += m;
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              localRect.bottom += m;
            }
          }
          else if (i == 100001)
          {
            localRect = this.jdField_a_of_type_AndroidGraphicsRect;
            localRect.left = this.jdField_a_of_type_Int;
            localRect.top = this.jdField_b_of_type_Int;
            localRect.right = this.c;
            localRect.bottom = this.d;
          }
          else if (i == 100005)
          {
            i = this.c - this.jdField_a_of_type_Int;
            j = this.d - this.jdField_b_of_type_Int;
            this.jdField_a_of_type_AndroidGraphicsRect.set(this.jdField_b_of_type_AndroidGraphicsRect);
            if (this.jdField_a_of_type_Int < this.jdField_a_of_type_AndroidGraphicsRect.left + this.jdField_a_of_type_AndroidGraphicsRect.width() / 2)
            {
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              localRect.left += i;
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              localRect.left = Math.max(localRect.left, 0);
            }
            else
            {
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              localRect.right += i;
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              localRect.right = Math.min(localRect.right, getWidth());
            }
            if (this.jdField_b_of_type_Int < this.jdField_a_of_type_AndroidGraphicsRect.top + this.jdField_a_of_type_AndroidGraphicsRect.height() / 2)
            {
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              localRect.top += j;
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              localRect.top = Math.max(localRect.top, 0);
            }
            else
            {
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              localRect.bottom += j;
              localRect = this.jdField_a_of_type_AndroidGraphicsRect;
              localRect.bottom = Math.min(localRect.bottom, getHeight());
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_a_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_b_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.jdField_c_of_type_AndroidWidgetButton.setVisibility(8);
          this.jdField_a_of_type_ComTencentMobileqqAppScreenShot.d.setVisibility(8);
          invalidate();
        }
      }
      else
      {
        if (Math.abs(this.jdField_a_of_type_AndroidGraphicsRect.width()) < 5)
        {
          this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
          i = 1;
        }
        else
        {
          i = 0;
        }
        if (i == 0)
        {
          this.f = 100002;
          ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot, true);
        }
        else
        {
          this.f = 0;
          ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot, false);
        }
        invalidate();
      }
    }
    else
    {
      this.jdField_a_of_type_Int = ((int)paramMotionEvent.getX());
      this.jdField_b_of_type_Int = ((int)paramMotionEvent.getY());
      if (!this.jdField_a_of_type_AndroidGraphicsRect.isEmpty())
      {
        if (this.jdField_a_of_type_AndroidGraphicsRect.contains(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int))
        {
          this.f = 100004;
        }
        else if (new Rect(this.jdField_a_of_type_AndroidGraphicsRect.left - 20, this.jdField_a_of_type_AndroidGraphicsRect.top - 20, this.jdField_a_of_type_AndroidGraphicsRect.right + 20, this.jdField_a_of_type_AndroidGraphicsRect.bottom + 20).contains(this.jdField_a_of_type_Int, this.jdField_b_of_type_Int))
        {
          this.f = 100005;
          this.jdField_b_of_type_AndroidGraphicsRect.set(this.jdField_a_of_type_AndroidGraphicsRect);
        }
        else
        {
          this.jdField_a_of_type_AndroidGraphicsRect.setEmpty();
          this.f = 100001;
          this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
          this.jdField_a_of_type_AndroidGraphicsPaint.setPathEffect(null);
          ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot, false);
        }
      }
      else
      {
        this.f = 100001;
        ScreenShot.a(this.jdField_a_of_type_ComTencentMobileqqAppScreenShot, false);
      }
      invalidate();
    }
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.ScreenShot.ScreenView
 * JD-Core Version:    0.7.0.1
 */