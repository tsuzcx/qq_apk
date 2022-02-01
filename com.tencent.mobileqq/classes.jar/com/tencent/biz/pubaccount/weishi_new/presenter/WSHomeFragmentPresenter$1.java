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
    if ((this.a.a() != null) && (paramWeishiTask != null) && (paramWeishiTask.a()) && (paramWeishiTask.a != null) && ((paramWeishiTask.a instanceof stRedDotRsp)))
    {
      paramWeishiTask = (stRedDotRsp)paramWeishiTask.a;
      WSHomeFragmentPresenter.a(this.a, paramWeishiTask.notificationReddot);
      WSHomeFragmentPresenter.b(this.a, paramWeishiTask.menu);
      if (this.a.a() != null) {
        ((IWSHomeView)this.a.a()).a(paramWeishiTask);
      }
    }
    else if (this.a.a() != null)
    {
      ((IWSHomeView)this.a.a()).b();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.presenter.WSHomeFragmentPresenter.1
 * JD-Core Version:    0.7.0.1
 */