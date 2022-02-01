package com.tencent.biz.pubaccount.weishi_new;

import android.text.TextUtils;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.biz.pubaccount.weishi_new.recommend.data.WSSubTabData;
import com.tencent.biz.pubaccount.weishi_new.view.WSFeedsLinearLayout;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabBeaconReport;
import com.tencent.biz.pubaccount.weishi_new.view.tabLayout.WSTabLayout;

class WSRecommendFragment$3
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  WSRecommendFragment$3(WSRecommendFragment paramWSRecommendFragment, WSSubTabData paramWSSubTabData) {}
  
  public void onGlobalLayout()
  {
    WSRecommendFragment.b(this.b).getViewTreeObserver().removeGlobalOnLayoutListener(this);
    WSSubTabData localWSSubTabData = this.a;
    if (localWSSubTabData == null) {
      return;
    }
    boolean bool2 = TextUtils.equals(localWSSubTabData.b, "2");
    boolean bool1 = true;
    if (bool2)
    {
      WSRecommendFragment.c(this.b).b(false);
      this.b.e(false);
      bool1 = false;
    }
    else
    {
      WSRecommendFragment.c(this.b).a(false);
      this.b.e(true);
    }
    WSTabBeaconReport.a(bool1, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSRecommendFragment.3
 * JD-Core Version:    0.7.0.1
 */