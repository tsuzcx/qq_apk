package com.tencent.biz.pubaccount.NativeAd.fragment;

import android.support.v4.app.FragmentActivity;
import android.view.View;
import com.tencent.biz.pubaccount.NativeAd.util.NativeAdUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class ReadInJoyNativeAdFragment$4
  implements ActionSheet.OnButtonClickListener
{
  ReadInJoyNativeAdFragment$4(ReadInJoyNativeAdFragment paramReadInJoyNativeAdFragment) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (ReadInJoyNativeAdFragment.a(this.a)) {
      return;
    }
    ReadInJoyNativeAdFragment.a(this.a, true);
    paramView = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      ReadInJoyNativeAdFragment.a(this.a).dismiss();
      QQToast.a(this.a.getActivity(), 2, paramView, 0).b(0);
      return;
      NativeAdUtils.a(this.a.getActivity().app, ReadInJoyNativeAdFragment.a(this.a), ReadInJoyNativeAdFragment.b(this.a), ReadInJoyNativeAdFragment.c(this.a), 2, 1, 0);
      paramView = this.a.getString(2131718292);
      continue;
      NativeAdUtils.a(this.a.getActivity().app, ReadInJoyNativeAdFragment.a(this.a), ReadInJoyNativeAdFragment.b(this.a), ReadInJoyNativeAdFragment.c(this.a), 2, 2, 0);
      paramView = this.a.getString(2131718294);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.NativeAd.fragment.ReadInJoyNativeAdFragment.4
 * JD-Core Version:    0.7.0.1
 */