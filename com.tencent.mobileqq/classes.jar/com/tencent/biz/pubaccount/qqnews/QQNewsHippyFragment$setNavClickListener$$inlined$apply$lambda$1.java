package com.tencent.biz.pubaccount.qqnews;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/qqnews/QQNewsHippyFragment$setNavClickListener$1$1", "Lcom/tencent/mobileqq/widget/navbar/OnItemSelectListener;", "onItemLonClick", "", "v", "Landroid/view/View;", "item", "", "onItemSelect", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QQNewsHippyFragment$setNavClickListener$$inlined$apply$lambda$1
  implements OnItemSelectListener
{
  QQNewsHippyFragment$setNavClickListener$$inlined$apply$lambda$1(QQNewsHippyFragment paramQQNewsHippyFragment) {}
  
  public void onItemSelect(@Nullable View paramView, int paramInt)
  {
    if (4 == paramInt)
    {
      paramView = new ActivityURIRequest((Context)this.a.getActivity(), "/pubaccount/detail");
      paramView.extra().putBoolean("fromQQNewsPubNew", true);
      paramView.extra().putString("uin", "2909288299");
      QRoute.startUri((URIRequest)paramView, null);
      return;
    }
    if (1 == paramInt)
    {
      paramView = this.a.getActivity();
      if (paramView != null) {
        paramView.finish();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.qqnews.QQNewsHippyFragment.setNavClickListener..inlined.apply.lambda.1
 * JD-Core Version:    0.7.0.1
 */