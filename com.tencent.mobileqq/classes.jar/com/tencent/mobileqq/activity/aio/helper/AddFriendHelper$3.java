package com.tencent.mobileqq.activity.aio.helper;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.stranger.api.IStrangerService;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import java.util.ArrayList;
import java.util.List;

class AddFriendHelper$3
  implements ActionSheet.OnButtonClickListener
{
  AddFriendHelper$3(AddFriendHelper paramAddFriendHelper, ActionSheet paramActionSheet) {}
  
  public void onClick(View paramView, int paramInt)
  {
    Object localObject;
    if (paramInt != 0)
    {
      if (paramInt == 1)
      {
        paramView = new Intent(this.b.c, QQBrowserActivity.class);
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("https://ti.qq.com/friends/unidirection?_wv=2&_wwv=128&tuin=");
        ((StringBuilder)localObject).append(this.b.b());
        paramView.putExtra("url", ((StringBuilder)localObject).toString());
        this.b.c.startActivity(paramView);
        ReportController.b(null, "dc00898", "", "", "0X800ACA4", "0X800ACA4", 0, 0, "", "0", "0", "");
      }
    }
    else
    {
      ReportController.b(this.b.b, "CliOper", "", this.b.e.b, "Manage_stranger", "Manage_str_delete", 0, 0, "", "", "", "");
      ReportController.b(null, "dc00898", "", "", "0X800ACA3", "0X800ACA3", 0, 0, "", "0", "0", "");
      paramView = new ArrayList();
    }
    try
    {
      paramView.add(Long.valueOf(Long.parseLong(this.b.b())));
      localObject = (IStrangerService)this.b.b.getRuntimeService(IStrangerService.class, "all");
      if (localObject != null) {
        ((IStrangerService)localObject).deleteStrangers(paramView);
      }
      if (this.b.f == null)
      {
        paramView = this.b;
        paramView.f = new QQProgressDialog(paramView.d, 0);
      }
      this.b.f.show();
      this.a.dismiss();
      return;
    }
    catch (NumberFormatException paramView)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AddFriendHelper", 2, "delete Stranger parseLong() error", paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.AddFriendHelper.3
 * JD-Core Version:    0.7.0.1
 */