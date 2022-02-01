package com.tencent.biz.pubaccount.weishi_new.presenter;

import UserGrowth.stRedDotRsp;
import com.tencent.biz.pubaccount.weishi_new.net.IWeishiServiceListener;
import com.tencent.biz.pubaccount.weishi_new.net.WeishiTask;
import com.tencent.biz.pubaccount.weishi_new.presenter.view.IWSHomeView;

class WSHomeFragmentPresenter$1
  implements IWeishiServiceListener
{
  WSHomeFragmentPresenter$1(WSHomeFragmentPresenter paramWSHomeFragmentPresenter) {}
  
  public void a(WeishiTask paramWeishiTask)
  {
    if ((this.a.getView() != null) && (paramWeishiTask != null) && (paramWeishiTask.b()) && (paramWeishiTask.m != null) && ((paramWeishiTask.m instanceof stRedDotRsp)))
    {
      paramWeishiTask = (stRedDotRsp)paramWeishiTask.m;
      WSHomeFragmentPresenter.a(this.a, paramWeishiTask.notificationReddot);
      WSHomeFragmentPresenter.b(this.a, paramWeishiTask.menu);
      WSHomeFragmentPresenter.a(this.a, paramWeishiTask.user);
      if (this.a.getView() != null) {
        ((IWSHomeView)this.a.getView()).a(paramWeishiTask);
      }
    }
    else if (this.a.getView() != null)
    {
      ((IWSHomeView)this.a.getView()).o();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter.1
 * JD-Core Version:    0.7.0.1
 */