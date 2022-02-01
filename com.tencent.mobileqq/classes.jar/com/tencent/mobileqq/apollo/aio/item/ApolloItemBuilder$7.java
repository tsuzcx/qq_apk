package com.tencent.mobileqq.apollo.aio.item;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.comic.api.IQQComicUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;

class ApolloItemBuilder$7
  implements View.OnClickListener
{
  ApolloItemBuilder$7(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (((IApolloManagerService)this.a.d.getRuntimeService(IApolloManagerService.class, "all")).isApolloSupport(this.a.d.getApplication()))
    {
      ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramView.getContext(), null, "aio", ApolloConstant.H, null);
      return;
    }
    Object localObject;
    if (!ApolloHardWareTester.a(this.a.d.getApplication()))
    {
      localObject = ApolloConstant.u;
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ApolloConstant.v);
      ((StringBuilder)localObject).append(((IQQComicUtil)QRoute.api(IQQComicUtil.class)).getActionId());
      localObject = ((StringBuilder)localObject).toString();
    }
    Intent localIntent = new Intent(paramView.getContext(), QQBrowserActivity.class);
    localIntent.putExtra("big_brother_source_key", "biz_src_zf_lmx");
    VasWebviewUtil.a(paramView.getContext(), (String)localObject, -1L, localIntent, false, -1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */