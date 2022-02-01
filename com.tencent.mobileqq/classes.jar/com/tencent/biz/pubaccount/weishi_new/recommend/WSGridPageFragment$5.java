package com.tencent.biz.pubaccount.weishi_new.recommend;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.weishi_new.WSRecommendAdapter;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;

class WSGridPageFragment$5
  implements View.OnClickListener
{
  WSGridPageFragment$5(WSGridPageFragment paramWSGridPageFragment) {}
  
  public void onClick(View paramView)
  {
    WSGridPageFragment.f(this.a).clearList();
    ((WSGridPageContract.Presenter)this.a.aO_()).a(true, true);
    ((WSGridPageContract.Presenter)this.a.aO_()).a("");
    this.a.s();
    this.a.r();
    WSReportDc00898.b(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.WSGridPageFragment.5
 * JD-Core Version:    0.7.0.1
 */