package com.tencent.mobileqq.activity;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.FriendsManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AddRequestActivity$8
  implements View.OnClickListener
{
  AddRequestActivity$8(AddRequestActivity paramAddRequestActivity) {}
  
  public void onClick(View paramView)
  {
    ReportController.b(this.a.app, "CliOper", "", "", "Verification_msg", "Vfc_answ_clk", 0, 0, "", "", "", "");
    Object localObject1 = this.a;
    if (AddRequestActivity.a((AddRequestActivity)localObject1) == 3999) {
      i = 3041;
    } else {
      i = AddRequestActivity.a(this.a);
    }
    AddRequestActivity.a((AddRequestActivity)localObject1, i);
    Object localObject2 = (FriendsManager)this.a.app.getManager(QQManagerFactory.FRIENDS_MANAGER);
    boolean bool = ((FriendsManager)localObject2).b(this.a.a);
    localObject1 = AIOUtils.a(new Intent(this.a, SplashActivity.class), null);
    ((Intent)localObject1).putExtra("uin", this.a.a);
    ((Intent)localObject1).putExtra("add_friend_source_id", AddRequestActivity.a(this.a));
    if (bool)
    {
      localObject2 = ((FriendsManager)localObject2).e(this.a.a);
      if (localObject2 != null)
      {
        ((Intent)localObject1).putExtra("cSpecialFlag", ((Friends)localObject2).cSpecialFlag);
        ((Intent)localObject1).putExtra("uinname", ContactUtils.a((Friends)localObject2));
      }
    }
    else
    {
      ((Intent)localObject1).putExtra("uinname", this.a.b);
      ((Intent)localObject1).putExtra("param_wzry_data", AddRequestActivity.a(this.a));
    }
    int i = 1022;
    if (bool) {
      i = 0;
    } else if ((AddRequestActivity.a(this.a) != 2007) && (AddRequestActivity.a(this.a) != 3007) && (AddRequestActivity.a(this.a) != 4007))
    {
      if ((AddRequestActivity.a(this.a) == 2019) || (AddRequestActivity.a(this.a) == 3019)) {
        i = 1010;
      }
    }
    else {
      i = 1001;
    }
    ((Intent)localObject1).putExtra("uintype", i);
    this.a.startActivity((Intent)localObject1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.8
 * JD-Core Version:    0.7.0.1
 */