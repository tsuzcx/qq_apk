package com.tencent.mobileqq.activity.aio.rebuild.panel;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.core.AIOContext;
import com.tencent.mobileqq.app.BaseActivity;

class HotTroopFlashPicPanelProvider$2
  implements DialogInterface.OnClickListener
{
  HotTroopFlashPicPanelProvider$2(HotTroopFlashPicPanelProvider paramHotTroopFlashPicPanelProvider) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(HotTroopFlashPicPanelProvider.a(this.a).b(), QQBrowserActivity.class);
    paramDialogInterface.putExtra("url", "https://qun.qq.com/qqweb/m/nearby/charm_level/index.html?_wv=1027&_bid=2747");
    HotTroopFlashPicPanelProvider.a(this.a).b().startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.panel.HotTroopFlashPicPanelProvider.2
 * JD-Core Version:    0.7.0.1
 */