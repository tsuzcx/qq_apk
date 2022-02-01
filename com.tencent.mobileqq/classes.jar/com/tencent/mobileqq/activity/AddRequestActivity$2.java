package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.newfriend.api.INewFriendApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddRequestActivity$2
  implements View.OnClickListener
{
  AddRequestActivity$2(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = this.a.getIntent();
    localIntent.putExtra("param_wzry_data", AddRequestActivity.a(this.a));
    INewFriendApi localINewFriendApi = (INewFriendApi)QRoute.api(INewFriendApi.class);
    QQAppInterface localQQAppInterface = this.a.app;
    AddRequestActivity localAddRequestActivity = this.a;
    localINewFriendApi.openProfileCard(localQQAppInterface, localAddRequestActivity, localAddRequestActivity.a, AddRequestActivity.b(this.a), this.a.i, AddRequestActivity.c(this.a), localIntent);
    if (AddRequestActivity.a(this.a) != null) {
      ReportController.b(this.a.app, "CliOper", "", "", "0X800843E", "0X800843E", 0, 0, "", "", "", "");
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X800AA42", "0X800AA42", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.2
 * JD-Core Version:    0.7.0.1
 */