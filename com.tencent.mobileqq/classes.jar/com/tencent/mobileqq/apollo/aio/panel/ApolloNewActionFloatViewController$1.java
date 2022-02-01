package com.tencent.mobileqq.apollo.aio.panel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;
import com.tencent.mobileqq.apollo.view.ApolloMainInfo;

class ApolloNewActionFloatViewController$1
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$1(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, ApolloMainInfo paramApolloMainInfo, ApolloActionData paramApolloActionData, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if ((ApolloNewActionFloatViewController.a(this.f) != null) && (ApolloNewActionFloatViewController.a(this.f).d != null) && (ApolloNewActionFloatViewController.b(this.f) != null)) {
      ApolloNewActionFloatViewController.b(this.f).a(ApolloNewActionFloatViewController.a(this.f).bv(), this.a);
    }
    this.f.a();
    ApolloNewActionFloatViewController.a(this.f, this.b, "action_flame_clicksend");
    ApolloTianshuReportUtil.a(102, String.valueOf(this.c), this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloNewActionFloatViewController.1
 * JD-Core Version:    0.7.0.1
 */