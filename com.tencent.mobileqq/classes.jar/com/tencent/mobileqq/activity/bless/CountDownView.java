package com.tencent.mobileqq.activity.bless;

import afbt;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import bbcf;

public class CountDownView
  extends ImageView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130838527, 2130838526, 2130838525 };
  private int jdField_a_of_type_Int;
  private afbt jdField_a_of_type_Afbt;
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
    bbcf.a();
    bbcf.a(2131230746, 1, null, null);
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
  
  public void setListener(afbt paramafbt)
  {
    this.jdField_a_of_type_Afbt = paramafbt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.CountDownView
 * JD-Core Version:    0.7.0.1
 */