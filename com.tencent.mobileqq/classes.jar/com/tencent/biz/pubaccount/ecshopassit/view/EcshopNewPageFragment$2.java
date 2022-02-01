package com.tencent.biz.pubaccount.ecshopassit.view;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;

class EcshopNewPageFragment$2
  implements OnItemSelectListener
{
  EcshopNewPageFragment$2(EcshopNewPageFragment paramEcshopNewPageFragment) {}
  
  public void onItemSelect(View paramView, int paramInt)
  {
    if ((paramInt == 5) || (paramInt == 4))
    {
      paramView = new ActivityURIRequest(this.a.getActivity(), "/pubaccount/detail");
      paramView.extra().putString("uin", "3046055438");
      paramView.extra().putInt("source", 5);
      QRoute.startUri(paramView, null);
    }
    while (paramInt != 1) {
      return;
    }
    this.a.getActivity().finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.view.EcshopNewPageFragment.2
 * JD-Core Version:    0.7.0.1
 */