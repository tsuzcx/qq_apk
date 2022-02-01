package com.tencent.mobileqq.activity.recent.bannerprocessor;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.banner.BannerManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BrowserBannerProcessor$1
  implements View.OnClickListener
{
  BrowserBannerProcessor$1(BrowserBannerProcessor paramBrowserBannerProcessor, Bundle paramBundle) {}
  
  public void onClick(View paramView)
  {
    Object localObject2 = BannerManager.a();
    int i = BrowserBannerProcessor.a;
    Object localObject1 = null;
    ((BannerManager)localObject2).a(i, 0, null);
    localObject2 = (String)this.a.getCharSequence("activity");
    if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    try
    {
      localObject2 = Class.forName((String)localObject2);
      localObject1 = localObject2;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      label51:
      break label51;
    }
    if (localObject1 != null)
    {
      localObject1 = new Intent(BrowserBannerProcessor.a(this.b).getApplicationContext(), (Class)localObject1);
      localObject2 = (String)this.a.getCharSequence("action");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((Intent)localObject1).setAction((String)localObject2);
      }
      localObject2 = (String)this.a.getCharSequence("category");
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {
        ((Intent)localObject1).addCategory((String)localObject2);
      }
      ((Intent)localObject1).setFlags(this.a.getInt("flags", 0));
      BrowserBannerProcessor.b(this.b).startActivity((Intent)localObject1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.bannerprocessor.BrowserBannerProcessor.1
 * JD-Core Version:    0.7.0.1
 */