package com.tencent.mobileqq.activity.bless;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.AudioUtil;
import wlg;

public class CountDownView
  extends ImageView
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 2130838229, 2130838228, 2130838227 };
  private int jdField_a_of_type_Int;
  private CountDownView.CountDownFinishedListener jdField_a_of_type_ComTencentMobileqqActivityBlessCountDownView$CountDownFinishedListener;
  private Runnable jdField_a_of_type_JavaLangRunnable = new wlg(this);
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
    AudioUtil.a();
    AudioUtil.a(2131230746, 1, null, null);
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
  
  public void setListener(CountDownView.CountDownFinishedListener paramCountDownFinishedListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityBlessCountDownView$CountDownFinishedListener = paramCountDownFinishedListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.bless.CountDownView
 * JD-Core Version:    0.7.0.1
 */