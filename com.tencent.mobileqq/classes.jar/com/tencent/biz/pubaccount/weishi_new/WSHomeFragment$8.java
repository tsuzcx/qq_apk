package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow.RedDotBubblePopupListener;

class WSHomeFragment$8
  implements RedDotBubblePopupWindow.RedDotBubblePopupListener
{
  WSHomeFragment$8(WSHomeFragment paramWSHomeFragment) {}
  
  public void a()
  {
    WSPublicAccReport.getInstance().reportMessageBubblePopupClick(WSHomeFragment.f, WSHomeFragment.e(this.a));
    WSHomeFragment.i(this.a);
    ((WSHomeFragmentPresenter)this.a.aO_()).a(this.a.getBaseActivity(), 601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.8
 * JD-Core Version:    0.7.0.1
 */