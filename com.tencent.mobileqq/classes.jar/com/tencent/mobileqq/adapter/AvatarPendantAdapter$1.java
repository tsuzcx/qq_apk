package com.tencent.mobileqq.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.pendant.AvatarPendantActivity;
import com.tencent.mobileqq.activity.pendant.PendantMarketConfig.EntryConfig;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AvatarPendantAdapter$1
  implements View.OnClickListener
{
  AvatarPendantAdapter$1(AvatarPendantAdapter paramAvatarPendantAdapter, PendantMarketConfig.EntryConfig paramEntryConfig, int paramInt) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(this.c.a, QQBrowserActivity.class);
    localIntent.putExtra("url", this.a.c);
    localIntent.putExtra("isShowAd", false);
    this.c.a.startActivity(localIntent);
    if ((this.c.a instanceof AvatarPendantActivity)) {
      ((AvatarPendantActivity)this.c.a).N = -1L;
    }
    if (this.b == 1) {
      VasWebviewUtil.a("", "faceaddon", "0X8008486", "", 1, 0, 0, "", "", "");
    } else {
      ReportController.b(this.c.b, "CliOper", "", "", "0X8006334", "0X8006334", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.adapter.AvatarPendantAdapter.1
 * JD-Core Version:    0.7.0.1
 */