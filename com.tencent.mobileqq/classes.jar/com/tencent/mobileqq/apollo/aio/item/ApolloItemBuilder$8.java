package com.tencent.mobileqq.apollo.aio.item;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.res.api.impl.ApolloGifDownloaderImpl;
import com.tencent.mobileqq.apollo.statistics.product.ApolloAioBubbleReportUtil;
import com.tencent.mobileqq.apollo.utils.ApolloConstant;
import com.tencent.mobileqq.apollo.utils.ApolloHardWareTester;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import java.io.File;

class ApolloItemBuilder$8
  implements View.OnClickListener
{
  ApolloItemBuilder$8(ApolloItemBuilder paramApolloItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (this.a.c()) {
      return;
    }
    ApolloItemBuilder.Holder localHolder = (ApolloItemBuilder.Holder)AIOUtils.b(paramView);
    if ((localHolder != null) && (localHolder.q != null))
    {
      if (localHolder.t == null) {
        return;
      }
      int i = localHolder.a;
      boolean bool = paramView instanceof TextView;
      Object localObject1 = "1";
      Object localObject2;
      Object localObject3;
      if (bool)
      {
        localObject2 = (IApolloManagerService)this.a.d.getRuntimeService(IApolloManagerService.class, "all");
        if (((IApolloManagerService)localObject2).isApolloSupport(this.a.d.getApplication()))
        {
          ((IApolloUtil)QRoute.api(IApolloUtil.class)).openApolloStore(paramView.getContext(), null, "aio", ApolloConstant.H, null);
        }
        else
        {
          if (!ApolloHardWareTester.a(this.a.d.getApplication()))
          {
            localObject1 = ApolloConstant.u;
          }
          else
          {
            localObject1 = new StringBuilder();
            ((StringBuilder)localObject1).append(ApolloConstant.v);
            ((StringBuilder)localObject1).append(i);
            localObject1 = ((StringBuilder)localObject1).toString();
          }
          localObject3 = new Intent(paramView.getContext(), QQBrowserActivity.class);
          ((Intent)localObject3).putExtra("big_brother_source_key", "biz_src_zf_lmx");
          VasWebviewUtil.a(paramView.getContext(), (String)localObject1, -1L, (Intent)localObject3, false, -1);
          localObject1 = "0";
        }
        ApolloAioBubbleReportUtil.a.a(this.a.d, localHolder, (String)localObject1, (IApolloManagerService)localObject2);
        return;
      }
      if (new File(ApolloGifDownloaderImpl.getApolloGifFilePath(i)).exists())
      {
        paramView = this.a;
        ApolloItemBuilder.a(paramView, paramView.e, localHolder.t, (MessageForApollo)localHolder.q, this.a.f);
        localObject2 = "0";
      }
      else
      {
        localObject3 = localHolder.t.getDrawable();
        localObject2 = localObject1;
        if (localObject3 != null)
        {
          localObject2 = localObject1;
          if ((localObject3 instanceof URLDrawable))
          {
            localObject3 = (URLDrawable)localObject3;
            if (((URLDrawable)localObject3).getStatus() != 3)
            {
              localObject2 = localObject1;
              if (((URLDrawable)localObject3).getStatus() != 2) {}
            }
            else
            {
              if (NetworkUtil.isNetworkAvailable(paramView.getContext())) {
                this.a.a(localHolder, paramView.getResources(), true);
              }
              return;
            }
          }
        }
      }
      ApolloAioBubbleReportUtil.a.a(this.a.d, localHolder, i, (String)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.item.ApolloItemBuilder.8
 * JD-Core Version:    0.7.0.1
 */