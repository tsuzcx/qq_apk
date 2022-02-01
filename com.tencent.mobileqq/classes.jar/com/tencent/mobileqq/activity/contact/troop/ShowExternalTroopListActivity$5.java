package com.tencent.mobileqq.activity.contact.troop;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.net.URLEncoder;
import mqq.app.AppRuntime;

class ShowExternalTroopListActivity$5
  implements View.OnClickListener
{
  ShowExternalTroopListActivity$5(ShowExternalTroopListActivity paramShowExternalTroopListActivity) {}
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if (!NetworkUtil.isNetworkAvailable(this.a.jdField_a_of_type_AndroidAppActivity))
    {
      localObject1 = this.a;
      QQToast.a((Context)localObject1, 1, ((ShowExternalTroopListActivity)localObject1).getString(2131692112), 0).b(this.a.getTitleBarHeight());
    }
    else
    {
      localObject1 = ((TextView)paramView).getText().toString();
      Object localObject2 = new Intent(this.a.jdField_a_of_type_AndroidAppActivity, QQBrowserActivity.class);
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("https://qqweb.qq.com/m/relativegroup/index.html?_bid=165&_wv=4194304&source=qun_tag&keyword=");
      ((StringBuilder)localObject3).append(URLEncoder.encode((String)localObject1));
      ((Intent)localObject2).putExtra("url", ((StringBuilder)localObject3).toString());
      ((Intent)localObject2).putExtra("hide_operation_bar", true);
      ((Intent)localObject2).putExtra("hide_more_button", true);
      this.a.startActivity((Intent)localObject2);
      localObject2 = this.a.app;
      localObject3 = this.a.jdField_a_of_type_JavaLangString;
      if (this.a.jdField_a_of_type_Boolean) {
        localObject1 = "0";
      } else {
        localObject1 = "1";
      }
      ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_join", "", "person_data", "Clk_quntag", 0, 0, (String)localObject3, (String)localObject1, "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.5
 * JD-Core Version:    0.7.0.1
 */