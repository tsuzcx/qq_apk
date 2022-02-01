package com.tencent.mobileqq.apollo.view.pannel.viewbinder;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.api.model.ApolloBattleGameInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ApolloBattleGameViewBinder$ApolloBattleGameListAdapter$1
  implements View.OnClickListener
{
  ApolloBattleGameViewBinder$ApolloBattleGameListAdapter$1(ApolloBattleGameViewBinder.ApolloBattleGameListAdapter paramApolloBattleGameListAdapter, ApolloBattleGameInfo paramApolloBattleGameInfo) {}
  
  public void onClick(View paramView)
  {
    ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBattleGameInfo);
    ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBattleGameInfo, "game_click");
    ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.a(this.jdField_a_of_type_ComTencentMobileqqApolloViewPannelViewbinderApolloBattleGameViewBinder$ApolloBattleGameListAdapter, this.jdField_a_of_type_ComTencentMobileqqApolloApiModelApolloBattleGameInfo, 102);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.viewbinder.ApolloBattleGameViewBinder.ApolloBattleGameListAdapter.1
 * JD-Core Version:    0.7.0.1
 */