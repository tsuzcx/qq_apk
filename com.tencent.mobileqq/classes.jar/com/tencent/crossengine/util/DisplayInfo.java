package com.tencent.crossengine.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class DisplayInfo
{
  private float jdField_a_of_type_Float = 1.0F;
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean = false;
  private int b;
  
  public DisplayInfo(Context paramContext, boolean paramBoolean)
  {
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = paramContext.widthPixels;
    this.b = paramContext.heightPixels;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.crossengine.util.DisplayInfo
 * JD-Core Version:    0.7.0.1
 */