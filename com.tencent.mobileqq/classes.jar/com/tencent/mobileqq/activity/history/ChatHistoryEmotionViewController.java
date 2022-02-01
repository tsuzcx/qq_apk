package com.tencent.mobileqq.activity.history;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ChatHistoryEmotionViewController
  extends ChatHistoryCommonViewController
{
  public static final int[] e = { 2131887743 };
  public static final int[] f = { 2131430563 };
  
  public ChatHistoryEmotionViewController(BaseActivity paramBaseActivity)
  {
    super(paramBaseActivity);
  }
  
  protected int[] k()
  {
    return f;
  }
  
  protected int[] l()
  {
    return e;
  }
  
  protected void n()
  {
    super.n();
    ReportController.b(null, "dc00898", "", "", "0X800B71F", "0X800B71F", 0, 0, "", "", "", "");
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if ((paramView.getId() == 2131436211) && (this.j == 2)) {
      this.n.setText(2131887650);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.history.ChatHistoryEmotionViewController
 * JD-Core Version:    0.7.0.1
 */