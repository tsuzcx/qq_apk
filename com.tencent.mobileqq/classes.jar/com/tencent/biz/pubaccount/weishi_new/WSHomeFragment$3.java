package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.WSPopupMenuDialog.MenuItem;
import com.tencent.biz.pubaccount.weishi_new.view.WSPopupMenuDialog.OnClickActionListener;

class WSHomeFragment$3
  implements WSPopupMenuDialog.OnClickActionListener
{
  WSHomeFragment$3(WSHomeFragment paramWSHomeFragment) {}
  
  public void a(WSPopupMenuDialog.MenuItem paramMenuItem)
  {
    if (paramMenuItem != null)
    {
      switch (paramMenuItem.a)
      {
      default: 
        return;
      case 2131918115: 
        WSPublicAccReport.getInstance().reportNotificationClick(WSHomeFragment.f, WSHomeFragment.e(this.a));
        WSHomeFragment.i(this.a);
        ((WSHomeFragmentPresenter)this.a.aO_()).a(this.a.getBaseActivity(), 602);
        return;
      case 2131918114: 
        WSPublicAccReport.getInstance().reportPersonHomeClick(WSHomeFragment.f, WSHomeFragment.e(this.a));
        ((WSHomeFragmentPresenter)this.a.aO_()).a(this.a.getBaseActivity());
        return;
      }
      ((WSHomeFragmentPresenter)this.a.aO_()).b(this.a.getActivity());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.3
 * JD-Core Version:    0.7.0.1
 */