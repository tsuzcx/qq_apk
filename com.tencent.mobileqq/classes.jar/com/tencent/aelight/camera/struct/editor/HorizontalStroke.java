package com.tencent.aelight.camera.struct.editor;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.HardCodeUtil;

public class HorizontalStroke
{
  public static final int[] a;
  public static final int[] b;
  public int a;
  public Drawable a;
  public String a;
  public int b;
  public String b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { -1, -2148308, -1009097, -8136876, -13338378 };
    jdField_b_of_type_ArrayOfInt = new int[] { -16777216, -1, -2148308, -1009097, -8136876, -13338378 };
  }
  
  public HorizontalStroke(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    if (paramInt1 == 0) {
      this.jdField_b_of_type_JavaLangString = a(paramInt2);
    }
  }
  
  public HorizontalStroke(Drawable paramDrawable, int paramInt, String paramString)
  {
    this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramDrawable;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_b_of_type_Int = Color.parseColor(paramString);
  }
  
  public static int a(boolean paramBoolean)
  {
    if (paramBoolean) {
      return jdField_b_of_type_ArrayOfInt[2];
    }
    return jdField_a_of_type_ArrayOfInt[1];
  }
  
  public static String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case -1: 
      return HardCodeUtil.a(2131702344);
    case -274353: 
      return HardCodeUtil.a(2131702341);
    case -1009097: 
    case -27392: 
      return HardCodeUtil.a(2131702349);
    case -2148308: 
    case -845543: 
      return HardCodeUtil.a(2131702346);
    case -5789785: 
      return HardCodeUtil.a(2131702342);
    case -6989057: 
      return HardCodeUtil.a(2131702343);
    case -10233288: 
    case -8136876: 
      return HardCodeUtil.a(2131702347);
    case -13338378: 
    case -9576193: 
      return HardCodeUtil.a(2131702348);
    }
    return HardCodeUtil.a(2131702350);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.aelight.camera.struct.editor.HorizontalStroke
 * JD-Core Version:    0.7.0.1
 */