package com.tencent.mobileqq.activity.bless;

import aiqs;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import bhcl;

public class CountDownView
  extends ImageView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130838924, 2130838923, 2130838922 };
  private int jdField_a_of_type_Int;
  private aiqs jdField_a_of_type_Aiqs;
  private Runnable jdField_a_of_type_JavaLangRunnable = new CountDownView.1(this);
  private boolean jdField_a_of_type_Boolean;
  
  public CountDownView(Context paramContext)
  {
    super(paramContext);
  }
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CountDownView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void b()
  {
    bhcl.a();
    bhcl.a(2131230746, 1, null, null);
  }
  
  public void a()
  {
    setImageResource(jdField_a_of_type_ArrayOfInt[0]);
    this.jdField_a_of_type_Boolean = false;
    Handler localHandler = getHandler();
    if (localHandler != null) {
      localHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    }
    this.jdField_a_of_type_Int = 0;
    setVisibility(4);
  }
  
  public void setListener(aiqs paramaiqs)
  {
    this.jdField_a_of_type_Aiqs = paramaiqs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.CountDownView
 * JD-Core Version:    0.7.0.1
 */