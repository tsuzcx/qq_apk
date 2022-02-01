package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApolloGameBannerProcessor$2
  implements View.OnClickListener
{
  ApolloGameBannerProcessor$2(ApolloGameBannerProcessor paramApolloGameBannerProcessor) {}
  
  public void onClick(View paramView)
  {
    try
    {
      DialogUtil.a(ApolloGameBannerProcessor.c(this.a), 0, null, HardCodeUtil.a(2131700994), 2131690800, 2131694615, new ApolloGameBannerProcessor.2.1(this), new ApolloGameBannerProcessor.2.2(this)).show();
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.e("Q.recent.banner", 1, "show dialog err, errInfo->" + localThrowable.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.ApolloGameBannerProcessor.2
 * JD-Core Version:    0.7.0.1
 */