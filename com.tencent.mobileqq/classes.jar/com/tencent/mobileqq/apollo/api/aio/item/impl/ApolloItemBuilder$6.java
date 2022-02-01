package com.tencent.mobileqq.apollo.api.aio.item.impl;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.uitls.ApolloConstant;
import com.tencent.mobileqq.apollo.api.uitls.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.comic.VipComicHelper;

class ApolloItemBuilder$6
  implements View.OnClickListener
{
  ApolloItemBuilder$6(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    Object localObject = (IApolloManagerService)this.a.a.getRuntimeService(IApolloManagerService.class, "all");
    if (((IApolloManagerService)localObject).isApolloFuncOpen(this.a.a.getApplication()))
    {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramView.getContext(), null, "aio", ApolloConstant.u, null);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    if (!((IApolloManagerService)localObject).isHardwareSupport(this.a.a.getApplication())) {}
    for (localObject = ApolloConstant.h;; localObject = ApolloConstant.i + VipComicHelper.b)
    {
      Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
      localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
      VasWebviewUtil.openQQBrowserActivity(paramView.getContext(), (String)localObject, -1L, localIntent, false, -1);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.aio.item.impl.ApolloItemBuilder.6
 * JD-Core Version:    0.7.0.1
 */