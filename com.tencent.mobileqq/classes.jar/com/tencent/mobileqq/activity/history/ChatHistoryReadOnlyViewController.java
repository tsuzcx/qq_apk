package com.tencent.mobileqq.activity.history;

import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.widget.FadeIconImageView;

public class ChatHistoryReadOnlyViewController
  extends ChatHistoryCommonViewController
{
  public static final int[] a;
  public static final int[] b = { 2131364495 };
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131690808 };
  }
  
  public ChatHistoryReadOnlyViewController(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetFadeIconImageView.setVisibility(8);
  }
  
  protected int[] a()
  {
    return b;
  }
  
  protected int[] b()
  {
    return jdField_a_of_type_ArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryReadOnlyViewController
 * JD-Core Version:    0.7.0.1
 */