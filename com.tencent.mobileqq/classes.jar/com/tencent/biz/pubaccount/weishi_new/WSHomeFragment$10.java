package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.RedDotBubblePopupWindow.RedDotBubblePopupListener;

class WSHomeFragment$10
  implements RedDotBubblePopupWindow.RedDotBubblePopupListener
{
  WSHomeFragment$10(WSHomeFragment paramWSHomeFragment) {}
  
  public void a()
  {
    WSPublicAccReport.getInstance().reportMessageBubblePopupClick(WSHomeFragment.a, WSHomeFragment.b(this.a));
    WSHomeFragment.d(this.a);
    ((WSHomeFragmentPresenter)this.a.b()).a(this.a.getBaseActivity(), 601);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.10
 * JD-Core Version:    0.7.0.1
 */