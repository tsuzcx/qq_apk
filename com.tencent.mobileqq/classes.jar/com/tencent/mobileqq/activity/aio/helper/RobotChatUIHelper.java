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
  private boolean a = false;
  
  public RobotChatUIHelper(BaseChatPie paramBaseChatPie)
  {
    super(paramBaseChatPie);
  }
  
  protected void a()
  {
    if (!this.a) {
      return;
    }
    super.a();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (!this.a) {
      return;
    }
    super.a(paramInt1, paramInt2);
  }
  
  public void a(TextView paramTextView)
  {
    if (!this.a) {
      return;
    }
    super.a(paramTextView);
  }
  
  public void a(Boolean paramBoolean)
  {
    if (!this.a) {
      return;
    }
    super.a(paramBoolean);
  }
  
  protected void b()
  {
    this.g = true;
    if (!this.d)
    {
      this.a = true;
      this.d = true;
      return;
    }
    this.a = false;
  }
  
  public void b(boolean paramBoolean)
  {
    if (!this.a) {
      return;
    }
    super.b(paramBoolean);
    boolean bool = o();
    if (paramBoolean)
    {
      if (!bool) {
        this.c.Z.setBackgroundResource(2130838175);
      }
    }
    else {
      this.c.Z.setBackgroundResource(2130838175);
    }
  }
  
  public boolean c()
  {
    return true;
  }
  
  public boolean e()
  {
    return this.a;
  }
  
  public void f()
  {
    if (!this.a) {
      return;
    }
    super.f();
  }
  
  public int g()
  {
    return 2130847892;
  }
  
  public void g_(boolean paramBoolean)
  {
    if (!this.a) {
      return;
    }
    super.g_(paramBoolean);
  }
  
  public String getTag()
  {
    return "RobotChatUIHelper";
  }
  
  public void onClick(View paramView)
  {
    super.onClick(paramView);
    if (paramView.getId() == 2131428843) {
      ReportController.b(null, "dc00898", "", "", "0X800A48A", "0X800A48A", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.RobotChatUIHelper
 * JD-Core Version:    0.7.0.1
 */