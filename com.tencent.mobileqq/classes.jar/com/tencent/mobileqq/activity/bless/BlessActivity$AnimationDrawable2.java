package com.tencent.mobileqq.activity.bless;

import ahcn;
import android.graphics.drawable.AnimationDrawable;

public class BlessActivity$AnimationDrawable2
  extends AnimationDrawable
{
  private ahcn jdField_a_of_type_Ahcn;
  private boolean jdField_a_of_type_Boolean;
  
  public BlessActivity$AnimationDrawable2(BlessActivity paramBlessActivity) {}
  
  public void a()
  {
    stop();
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a(ahcn paramahcn)
  {
    this.jdField_a_of_type_Ahcn = paramahcn;
  }
  
  public boolean selectDrawable(int paramInt)
  {
    boolean bool = super.selectDrawable(paramInt);
    if ((paramInt != 0) && (paramInt == getNumberOfFrames() - 1) && (!this.jdField_a_of_type_Boolean))
    {
      this.jdField_a_of_type_Boolean = true;
      if (this.jdField_a_of_type_Ahcn != null) {
        this.jdField_a_of_type_Ahcn.a();
      }
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.BlessActivity.AnimationDrawable2
 * JD-Core Version:    0.7.0.1
 */