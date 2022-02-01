package com.tencent.mobileqq.activity.recent;

import android.app.Activity;
import android.view.View;
import com.tencent.mobileqq.activity.ChatSettingActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.DeleteRecordDialog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class RecentAdapter$10
  implements ActionSheet.OnButtonClickListener
{
  public void onClick(View paramView, int paramInt)
  {
    if (paramInt == 0)
    {
      RecentAdapter.a(this.f, this.a, this.b, this.c);
      ReportController.b(this.f.d, "dc00898", "", "", "0X800A361", "0X800A361", 0, 0, "1", "", this.c, "");
    }
    else if (paramInt == 1)
    {
      if (this.d)
      {
        ChatSettingActivity.a(this.f.d, (Activity)this.f.c, this.a.getRecentUserUin(), this.a.getRecentUserType(), new RecentAdapter.10.1(this), 1);
      }
      else
      {
        if (this.a.getRecentUserType() == 3000)
        {
          paramView = new DeleteRecordDialog(this.f.c, this.f.d, false);
          paramView.a(new RecentAdapter.10.2(this));
          paramView.a(1);
        }
        else if (this.a.getRecentUserType() == 1)
        {
          paramView = new DeleteRecordDialog(this.f.c, this.f.d, false);
          paramView.a(new RecentAdapter.10.3(this));
          paramView.a(1);
        }
        ReportController.b(this.f.d, "dc00898", "", "", "0X800A362", "0X800A362", 0, 0, "1", "", this.c, "");
      }
    }
    this.e.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentAdapter.10
 * JD-Core Version:    0.7.0.1
 */