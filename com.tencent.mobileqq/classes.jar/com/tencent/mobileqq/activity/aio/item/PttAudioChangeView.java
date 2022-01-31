package com.tencent.mobileqq.activity.aio.item;

import aepi;
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
import android.view.View;

public class PttAudioChangeView
  extends View
{
  private int jdField_a_of_type_Int = -1;
  Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  Canvas jdField_a_of_type_AndroidGraphicsCanvas;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private PorterDuff.Mode jdField_a_of_type_AndroidGraphicsPorterDuff$Mode = PorterDuff.Mode.SRC_ATOP;
  private Xfermode jdField_a_of_type_AndroidGraphicsXfermode;
  private int jdField_b_of_type_Int = -1;
  Bitmap jdField_b_of_type_AndroidGraphicsBitmap;
  private int c = -1;
  private int d = 1;
  private int e;
  private int f;
  
  public PttAudioChangeView(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.f = paramInt1;
    a(paramInt2);
  }
  
  private void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
    this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(this.d);
    this.jdField_a_of_type_AndroidGraphicsXfermode = new PorterDuffXfermode(this.jdField_a_of_type_AndroidGraphicsPorterDuff$Mode);
    this.c = aepi.a(paramInt, getContext().getResources());
  }
  
  public void a()
  {
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_b_of_type_AndroidGraphicsBitmap.recycle();
    }
    if ((this.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
    this.jdField_b_of_type_AndroidGraphicsBitmap = null;
    this.jdField_a_of_type_AndroidGraphicsBitmap = null;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_b_of_type_Int < 0)
    {
      this.jdField_a_of_type_Int = ((getMeasuredWidth() - getPaddingRight() + getPaddingLeft()) / 2);
      this.jdField_b_of_type_Int = ((getMeasuredHeight() + getPaddingTop() - getPaddingBottom()) / 2);
      if (this.jdField_a_of_type_Int < 0) {
        this.jdField_a_of_type_Int = 0;
      }
      if (this.jdField_b_of_type_Int < 0) {
        this.jdField_b_of_type_Int = 0;
      }
      this.jdField_b_of_type_AndroidGraphicsBitmap = Bitmap.createBitmap(getMeasuredWidth(), getMeasuredHeight(), Bitmap.Config.ARGB_8888);
      this.jdField_a_of_type_AndroidGraphicsBitmap = BitmapFactory.decodeResource(getResources(), this.f);
      this.jdField_a_of_type_AndroidGraphicsCanvas = new Canvas(this.jdField_b_of_type_AndroidGraphicsBitmap);
    }
    if ((this.jdField_b_of_type_AndroidGraphicsBitmap == null) || (this.jdField_b_of_type_AndroidGraphicsBitmap.isRecycled()) || (this.jdField_a_of_type_AndroidGraphicsBitmap == null) || (this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      return;
    }
    RectF localRectF = new RectF(this.jdField_a_of_type_Int - this.c, this.jdField_b_of_type_Int - this.c, this.jdField_a_of_type_Int + this.c, this.jdField_b_of_type_Int + this.c);
    int i = paramCanvas.saveLayer(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight(), null, 31);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
    this.jdField_a_of_type_AndroidGraphicsCanvas.drawPaint(this.jdField_a_of_type_AndroidGraphicsPaint);
    this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    paramCanvas.drawBitmap(this.jdField_a_of_type_AndroidGraphicsBitmap, null, localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
    if (this.e != 0)
    {
      localRectF = new RectF(0.0F, 0.0F, getMeasuredWidth(), getMeasuredHeight());
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.e);
      this.jdField_a_of_type_AndroidGraphicsCanvas.drawRect(localRectF, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(this.jdField_a_of_type_AndroidGraphicsXfermode);
      paramCanvas.drawBitmap(this.jdField_b_of_type_AndroidGraphicsBitmap, this.jdField_a_of_type_Int - this.c, this.jdField_b_of_type_Int - this.c, this.jdField_a_of_type_AndroidGraphicsPaint);
      this.jdField_a_of_type_AndroidGraphicsPaint.setXfermode(null);
    }
    paramCanvas.restoreToCount(i);
  }
  
  public void setThemeColor(int paramInt)
  {
    this.e = paramInt;
    invalidate();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.PttAudioChangeView
 * JD-Core Version:    0.7.0.1
 */