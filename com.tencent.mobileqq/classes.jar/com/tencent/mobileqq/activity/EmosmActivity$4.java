package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.emosm.EmosmUtils;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class EmosmActivity$4
  implements View.OnClickListener
{
  EmosmActivity$4(EmosmActivity paramEmosmActivity) {}
  
  public void onClick(View paramView)
  {
    if ((!this.a.mRedirect) && (EmosmUtils.a(this.a)))
    {
      this.a.mRedirect = true;
      ((IEmosmService)QRoute.api(IEmosmService.class)).openEmojiHomePage((Activity)this.a.mActivity.get(), this.a.app.getAccount(), 2);
      ReportController.b(this.a.app, "CliOper", "", "", "EmosSetting", "ForwardEmojiHome", 0, 0, "", "", "", "");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmActivity.4
 * JD-Core Version:    0.7.0.1
 */