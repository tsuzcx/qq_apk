package com.tencent.biz.pubaccount.readinjoy;

import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoyRefreshManager;
import com.tencent.biz.pubaccount.readinjoy.skin.ReadInJoySkinManager;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.ReadInJoyAnimBaseManager.PullRefreshComplete;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import lap;
import laq;

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
        ReadInJoyRefreshManager localReadInJoyRefreshManager = (ReadInJoyRefreshManager)localAppInterface.getManager(269);
        if ((localReadInJoyRefreshManager.a() != 1) || (!localReadInJoyRefreshManager.a())) {
          break label87;
        }
        ThreadManager.post(new lap(this), 8, null, true);
      }
    }
    label87:
    while (((ReadInJoySkinManager)localAppInterface.getManager(260)).a() != 1) {
      return;
    }
    ThreadManager.post(new laq(this), 8, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.KanDianViewController.PullRefreshCompleteListener
 * JD-Core Version:    0.7.0.1
 */