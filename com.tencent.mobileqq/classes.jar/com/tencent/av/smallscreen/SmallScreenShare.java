package com.tencent.av.smallscreen;

import android.content.Context;
import android.content.res.Resources;

public class SmallScreenShare
  extends SmallScreenItemBase
{
  protected static int a;
  
  static
  {
    jdField_a_of_type_Int = 3;
  }
  
  public SmallScreenShare(Context paramContext)
  {
    this.jdField_a_of_type_JavaLangString = "SmallScreenShare";
    this.i = 2131559888;
    this.j = paramContext.getResources().getDimensionPixelSize(2131297971);
    this.k = paramContext.getResources().getDimensionPixelSize(2131297970);
  }
  
  public void a()
  {
    jdField_a_of_type_Int = this.jdField_a_of_type_ComTencentAvSmallscreenSmallScreenRelativeLayout.a();
    super.a();
  }
  
  public void a(boolean paramBoolean, int paramInt)
  {
    super.a(paramBoolean, jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.smallscreen.SmallScreenShare
 * JD-Core Version:    0.7.0.1
 */