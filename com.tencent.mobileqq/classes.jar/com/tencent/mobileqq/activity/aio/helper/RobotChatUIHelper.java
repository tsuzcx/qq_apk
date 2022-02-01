package com.tencent.mobileqq.activity.aio.helper;

import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.PatchedButton;

public class RobotChatUIHelper
  extends SimpleUIAIOHelper
{
  private boolean c = false;
  
  public RobotChatUIHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  public int a()
  {
    return 2130846544;
  }
  
  protected void a()
  {
    if (!this.c) {
      return;
    }
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.c) {
      return;
    }
    super.a(paramInt1, paramInt2);
  }
  
  public void a(TextView paramTextView)
  {
    if (!this.c) {
      return;
    }
    super.a(paramTextView);
  }
  
  public void a(Boolean paramBoolean)
  {
    if (!this.c) {
      return;
    }
    super.a(paramBoolean);
  }
  
  public void a(boolean paramBoolean)
  {
    if (!this.c) {
      return;
    }
    super.a(paramBoolean);
  }
  
  public boolean a()
  {
    return true;
  }
  
  protected void b()
  {
    this.b = true;
    if (!this.jdField_a_of_type_Boolean)
    {
      this.c = true;
      this.jdField_a_of_type_Boolean = true;
      return;
    }
    this.c = false;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.c) {}
    boolean bool;
    do
    {
      return;
      super.b(paramBoolean);
      bool = c();
      if (!paramBoolean) {
        break;
      }
    } while (bool);
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.setBackgroundResource(2130838307);
    return;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCoreBaseChatPie.a.setBackgroundResource(2130838307);
  }
  
  public boolean b()
  {
    return this.c;
  }
  
  public void d()
  {
    if (!this.c) {
      return;
    }
    super.d();
  }
  
  public String getTag()
  {
    return "RobotChatUIHelper";
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      ReportController.b(null, "dc00898", "", "", "0X800A48A", "0X800A48A", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.RobotChatUIHelper
 * JD-Core Version:    0.7.0.1
 */