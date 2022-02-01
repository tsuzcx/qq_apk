package com.tencent.mobileqq.apollo.aio.panel;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.model.ApolloInfo;
import com.tencent.mobileqq.apollo.statistics.ApolloTianshuReportUtil;

class ApolloNewActionFloatViewController$5
  implements View.OnClickListener
{
  ApolloNewActionFloatViewController$5(ApolloNewActionFloatViewController paramApolloNewActionFloatViewController, ApolloActionData paramApolloActionData, int paramInt1, int paramInt2, String paramString1, String paramString2) {}
  
  public void onClick(View paramView)
  {
    if (ApolloNewActionFloatViewController.b(this.f) != null)
    {
      paramView = new ApolloInfo();
      paramView.mAction = this.a;
      ApolloNewActionFloatViewController.b(this.f).b(ApolloNewActionFloatViewController.a(this.f), paramView);
    }
    if (this.b == ApolloNewActionFloatViewController.b()) {
      ApolloTianshuReportUtil.a(124, String.valueOf(this.c), this.d, this.e);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.ApolloNewActionFloatViewController.5
 * JD-Core Version:    0.7.0.1
 */