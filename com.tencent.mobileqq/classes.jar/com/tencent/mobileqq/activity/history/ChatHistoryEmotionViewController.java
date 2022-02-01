package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ChatHistoryEmotionViewController
  extends ChatHistoryCommonViewController
{
  public static final int[] a;
  public static final int[] b = { 2131364506 };
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 2131690813 };
  }
  
  public ChatHistoryEmotionViewController(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  protected int[] a()
  {
    return b;
  }
  
  protected int[] b()
  {
    return jdField_a_of_type_ArrayOfInt;
  }
  
  protected void g()
  {
    super.g();
    ReportController.b(null, "dc00898", "", "", "0X800B71F", "0X800B71F", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if ((paramView.getId() == 2131369233) && (this.c == 2)) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(2131690730);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionViewController
 * JD-Core Version:    0.7.0.1
 */