package com.tencent.biz.pubaccount.NativeAd.fragment;

import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUtilService;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyNativeAdFragment$4
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyNativeAdFragment$4(ReadInJoyNativeAdFragment paramReadInJoyNativeAdFragment) {}
  
  public void onClick(View paramView, int paramInt)
  {
    if (ReadInJoyNativeAdFragment.h(this.a)) {
      return;
    }
    ReadInJoyNativeAdFragment.a(this.a, true);
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        paramView = "";
      }
      else
      {
        ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(this.a.getBaseActivity().app, ReadInJoyNativeAdFragment.i(this.a), ReadInJoyNativeAdFragment.j(this.a), ReadInJoyNativeAdFragment.k(this.a), 2, 2, 0);
        paramView = this.a.getString(2131915439);
      }
    }
    else
    {
      ((IRIJAdUtilService)QRoute.api(IRIJAdUtilService.class)).doAdReport(this.a.getBaseActivity().app, ReadInJoyNativeAdFragment.i(this.a), ReadInJoyNativeAdFragment.j(this.a), ReadInJoyNativeAdFragment.k(this.a), 2, 1, 0);
      paramView = this.a.getString(2131915437);
    }
    ReadInJoyNativeAdFragment.l(this.a).dismiss();
    QQToast.makeText(this.a.getBaseActivity(), 2, paramView, 0).show(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment.4
 * JD-Core Version:    0.7.0.1
 */