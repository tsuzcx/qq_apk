package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.Pair;

class MsgProxyBannerProcessor$1
  implements View.OnClickListener
{
  MsgProxyBannerProcessor$1(MsgProxyBannerProcessor paramMsgProxyBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(MsgProxyBannerProcessor.a(this.a), QQBrowserActivity.class);
    localIntent.putExtra("uin", ((QQAppInterface)MsgProxyBannerProcessor.b(this.a).getAppRuntime()).getCurrentAccountUin());
    Pair localPair = (Pair)paramView.getTag();
    if (localPair != null) {
      MsgProxyBannerProcessor.c(this.a).startActivity(localIntent.putExtra("url", "https://qzs.qq.com/iot/mobile/xiaowei-qq-proxy/index.html?din=" + ((Long)localPair.first).longValue() + "&deviceRemark=" + (String)localPair.second));
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.MsgProxyBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */