package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimBaseManager.PullRefreshComplete;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;

public class KanDianViewController$PullRefreshCompleteListener
  implements ReadInJoyAnimBaseManager.PullRefreshComplete
{
  public KanDianViewController$PullRefreshCompleteListener(KanDianViewController paramKanDianViewController) {}
  
  public void a(boolean paramBoolean)
  {
    AppInterface localAppInterface;
    if ((KanDianViewController.a(this.a) instanceof BaseActivity))
    {
      localAppInterface = ((BaseActivity)KanDianViewController.a(this.a)).getAppInterface();
      if ((localAppInterface != null) && (KanDianViewController.a(this.a) != null) && (!paramBoolean))
      {
        ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)localAppInterface.getManager(QQManagerFactory.READ_INJOY_REFRESH_MANAGER);
        if ((localReadInJoyRefreshManager.a() != 1) || (!localReadInJoyRefreshManager.b())) {
          break label87;
        }
        ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.1(this), 8, null, true);
      }
    }
    label87:
    while (((ReadInJoySkinManager)localAppInterface.getManager(QQManagerFactory.READ_INJOY_SKIN_MANAGER)).a() != 1) {
      return;
    }
    ThreadManager.post(new KanDianViewController.PullRefreshCompleteListener.2(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener
 * JD-Core Version:    0.7.0.1
 */