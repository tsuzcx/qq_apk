package com.tencent.biz.pubaccount.weishi_new;

import com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter;
import com.tencent.biz.pubaccount.weishi_new.report.WSPublicAccReport;
import com.tencent.biz.pubaccount.weishi_new.view.WSPopupMenuDialog.MenuItem;
import com.tencent.biz.pubaccount.weishi_new.view.WSPopupMenuDialog.OnClickActionListener;

class WSHomeFragment$4
  implements WSPopupMenuDialog.OnClickActionListener
{
  WSHomeFragment$4(WSHomeFragment paramWSHomeFragment) {}
  
  public void a(WSPopupMenuDialog.MenuItem paramMenuItem)
  {
    if (paramMenuItem != null) {}
    switch (paramMenuItem.a)
    {
    default: 
      return;
    case 2131720715: 
      WSPublicAccReport.getInstance().reportNotificationClick(WSHomeFragment.a, WSHomeFragment.b(this.a));
      WSHomeFragment.d(this.a);
      ((WSHomeFragmentPresenter)this.a.b()).a(this.a.getActivity(), 602);
      return;
    case 2131720714: 
      WSPublicAccReport.getInstance().reportPersonHomeClick(WSHomeFragment.a, WSHomeFragment.b(this.a));
      ((WSHomeFragmentPresenter)this.a.b()).a(this.a.getActivity());
      return;
    }
    ((WSHomeFragmentPresenter)this.a.b()).b(this.a.getActivity());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.WSHomeFragment.4
 * JD-Core Version:    0.7.0.1
 */