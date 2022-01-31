package com.tencent.mobileqq.activity.aio.item;

import aciy;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.support.annotation.DrawableRes;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.qphone.base.util.QLog;

public class PttAudioPlayView
  extends View
{
  private final int jdField_a_of_type_Int = 12;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = PorterDuff.Mode.SRC_ATOP;
  private Xfermode jdField_a_of_type_AndroidGraphicsXfermode;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private int jdField_c_of_type_Int = -1;
  Bitmap jdField_c_of_type_AndroidGraphicsBitmap;
  private int d = 8;
  private int e;
  private int f = 1;
  private int g;
  private int h = 2130838034;
  
  public PttAudioPlayView(Context paramContext)
  {
    super(paramContext);
    a(12);
  }
  
  public PttAudioPlayView(Context paramContext, int paramInt)
  {
    super(paramContext);
    a(paramInt);
  }
  
  public PttAudioPlayView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(12);
  }
  
  public PttAudioPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    a(paramInt);
  }
  
  public PttAudioPlayView(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1);
    a(paramInt2);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.f);
    this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
    this.d = aciy.a(paramInt, getContext().getResources());
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
    }
    if ((this.jdField_c_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_c_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_c_of_type_AndroidGraphicsBitmap = null;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_c_of_type_Int < 0)
    {
      this.jdField_b_of_type_Int = ((getMeasuredWidth() - getPaddingRight() + getPaddingLeft()) / 2);
      this.jdField_c_of_type_Int = ((getMeasuredHeight() + getPaddingTop() - getPaddingBottom()) / 2);
      if (this.jdField_b_of_type_Int < 0) {
        this.jdField_b_of_type_Int = 0;
      }
      if (this.jdField_c_of_type_Int < 0) {
        this.jdField_c_of_type_Int = 0;
      }
      this.jdField_a_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
      this.jdField_b_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), this.h);
      this.jdField_c_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), 2130838035);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    if (this.e != 0) {
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
    }
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight(), null, 31);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    RectF localRectF = new RectF(this.jdField_b_of_type_Int - this.d, this.jdField_c_of_type_Int - this.d, this.jdField_b_of_type_Int + this.d, this.jdField_c_of_type_Int + this.d);
    if (!this.jdField_a_of_type_Boolean)
    {
      if ((this.jdField_c_of_type_AndroidGraphicsBitmap == null) || (this.jdField_c_of_type_AndroidGraphicsBitmap.isRecycled()))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PttAudioPlayView", 2, "onDraw bitmapPlay is null or Recycled");
        }
        return;
      }
      paramCanvas.drawBitmap(this.jdField_c_of_type_AndroidGraphicsBitmap, null, localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
    for (;;)
    {
      if (this.g != 0)
      {
        if ((this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()))
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("PttAudioPlayView", 2, "onDraw bitmapSrc is null or Recycled");
          return;
          if ((this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()))
          {
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.d("PttAudioPlayView", 2, "onDraw bitmapPause is null or Recycled");
            return;
          }
          paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, null, localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
          continue;
        }
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
        localRectF = new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.g);
        this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect(localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsXfermode);
        paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, this.jdField_b_of_type_Int - this.d, this.jdField_c_of_type_Int - this.d, this.jdField_a_of_type_AndroidGraphicsPaint);
        this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
      }
    }
    paramCanvas.restoreToCount(i);
  }
  
  public void setPlayState(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    invalidate();
  }
  
  public void setPttPauseOrStopDrawable(@DrawableRes int paramInt)
  {
    this.h = paramInt;
  }
  
  public void setThemeColor(int paramInt)
  {
    int i = 0;
    if (this.g != paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttAudioPlayView", 2, "selectColor " + Integer.toHexString(this.g) + "this=" + this);
      }
      this.g = paramInt;
      i = 1;
    }
    if (i != 0) {
      invalidate();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioPlayView
 * JD-Core Version:    0.7.0.1
 */