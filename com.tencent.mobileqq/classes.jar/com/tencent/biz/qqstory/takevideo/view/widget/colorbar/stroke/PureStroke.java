package com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.UIUtils;

public class PureStroke
  extends Stroke
{
  public static final int[] a;
  public static final int[] b;
  private Drawable a;
  private Drawable b;
  private Drawable c;
  private int h;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -3866832, -10233288, -9576193, -16745729, -15975749, -6989057, -31233, -37737, -845543, -27392, -274353, -1, -16777216 };
    jdField_b_of_type_ArrayOfInt = new int[] { 2130843678, 2130843679, 2130843680, 2130843681, 2130843682, 2130843683, 2130843684, 2130843685, 2130843686, 2130843687, 2130843688, 2130843689, 2130843691 };
  }
  
  public PureStroke(Context paramContext, int paramInt)
  {
    super(paramContext, UIUtils.a(paramContext, 14.0F), UIUtils.a(paramContext, 14.0F));
    this.h = paramInt;
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BitmapFactory.decodeResource(paramContext.getResources(), jdField_b_of_type_ArrayOfInt[this.h]));
      this.jdField_b_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BitmapFactory.decodeResource(paramContext.getResources(), 2130843408));
      this.c = new BitmapDrawable(BitmapFactory.decodeResource(paramContext.getResources(), 2130843399));
      return;
    }
    catch (OutOfMemoryError paramContext)
    {
      paramContext.printStackTrace();
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public Drawable a()
  {
    return this.jdField_a_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public Drawable a(float paramFloat1, float paramFloat2)
  {
    this.jdField_b_of_type_AndroidGraphicsDrawableDrawable.setColorFilter(jdField_a_of_type_ArrayOfInt[this.h], PorterDuff.Mode.SRC_IN);
    return this.jdField_b_of_type_AndroidGraphicsDrawableDrawable;
  }
  
  public void a()
  {
    if (this.h != jdField_b_of_type_ArrayOfInt.length - 1)
    {
      SLog.e("Personality", "wrong position");
      return;
    }
    try
    {
      this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130843690));
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      localOutOfMemoryError.printStackTrace();
    }
  }
  
  public int b()
  {
    return jdField_a_of_type_ArrayOfInt[this.h];
  }
  
  public Drawable b(float paramFloat1, float paramFloat2)
  {
    this.c.setColorFilter(jdField_a_of_type_ArrayOfInt[this.h], PorterDuff.Mode.SRC_IN);
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.PureStroke
 * JD-Core Version:    0.7.0.1
 */