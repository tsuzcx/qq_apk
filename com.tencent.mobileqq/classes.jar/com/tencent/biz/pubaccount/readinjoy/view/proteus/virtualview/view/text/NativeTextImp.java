package com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.IView;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.VirtualViewUtils;

public class NativeTextImp
  extends TextView
  implements IView
{
  private int jdField_a_of_type_Int = 0;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private int jdField_b_of_type_Int;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g = -16777216;
  private int h = 1;
  
  public NativeTextImp(Context paramContext)
  {
    super(paramContext);
    getPaint().setAntiAlias(true);
  }
  
  public int a()
  {
    return getMeasuredWidth();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    measure(paramInt1, paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    a(true, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int b()
  {
    return getMeasuredHeight();
  }
  
  public void b(int paramInt1, int paramInt2)
  {
    a(paramInt1, paramInt2);
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    if (this.jdField_a_of_type_Int != 0)
    {
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      }
      this.jdField_a_of_type_AndroidGraphicsPaint.setColor(this.jdField_a_of_type_Int);
      VirtualViewUtils.b(paramCanvas, this.jdField_a_of_type_AndroidGraphicsPaint, getWidth(), getHeight(), this.f, this.jdField_b_of_type_Int, this.c, this.d, this.e);
    }
    super.onDraw(paramCanvas);
    if ((this.f > 0) && (!TextUtils.isEmpty(getText())))
    {
      if (this.jdField_b_of_type_AndroidGraphicsPaint == null)
      {
        this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_b_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
        this.jdField_b_of_type_AndroidGraphicsPaint.setAntiAlias(true);
      }
      this.jdField_b_of_type_AndroidGraphicsPaint.setStrokeWidth(this.f);
      this.jdField_b_of_type_AndroidGraphicsPaint.setColor(this.g);
      VirtualViewUtils.a(paramCanvas, this.jdField_b_of_type_AndroidGraphicsPaint, getWidth(), getHeight(), this.f, this.jdField_b_of_type_Int, this.c, this.d, this.e);
    }
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setBorderBottomLeftRadius(int paramInt)
  {
    this.d = paramInt;
  }
  
  public void setBorderBottomRightRadius(int paramInt)
  {
    this.e = paramInt;
  }
  
  public void setBorderColor(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setBorderTopLeftRadius(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setBorderTopRightRadius(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setBorderWidth(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void setPaintFlags(int paramInt)
  {
    if (this.h == paramInt) {
      return;
    }
    super.setPaintFlags(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp
 * JD-Core Version:    0.7.0.1
 */