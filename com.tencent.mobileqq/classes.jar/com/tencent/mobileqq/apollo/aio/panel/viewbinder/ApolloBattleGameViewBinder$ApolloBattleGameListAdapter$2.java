package com.tencent.mobileqq.apollo.aio.panel.viewbinder;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.model.ApolloBattleGameInfo;

class ApolloBattleGameViewBinder$ApolloBattleGameListAdapter$2
  implements View.OnClickListener
{
  ApolloBattleGameViewBinder$ApolloBattleGameListAdapter$2(ApolloBattleGameViewBinder.ApolloBattleGameListAdapter paramApolloBattleGameListAdapter, boolean paramBoolean, ApolloBattleGameInfo paramApolloBattleGameInfo) {}
  
  public void onClick(View paramView)
  {
    ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.a(this.c, this.a, this.b.hallJumpUrl);
    ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.a(this.c, this.a, this.b.appid, "store_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.aio.panel.viewbinder.ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.2
 * JD-Core Version:    0.7.0.1
 */