package com.tencent.mobileqq.apollo.aio.panel;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;

class ApolloNewActionFloatViewController$3
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$3(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, ApolloActionData paramApolloActionData, Bundle paramBundle, int paramInt, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    paramView = new ApolloInfo();
    paramView.mAction = this.a;
    paramView.mPackageId = this.b.getInt("pkgId");
    if (ApolloNewActionFloatViewController.b(this.f) != null) {
      ApolloNewActionFloatViewController.b(this.f).a(ApolloNewActionFloatViewController.a(this.f), paramView);
    }
    this.f.a();
    ApolloNewActionFloatViewController.a(this.f, this.a, "action_flame_clickgain");
    ApolloTianshuReportUtil.a(125, String.valueOf(this.c), this.d, this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloNewActionFloatViewController.3
 * JD-Core Version:    0.7.0.1
 */