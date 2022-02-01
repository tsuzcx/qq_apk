package com.tencent.mobileqq.apollo.lightGame;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.ICmGameConfirmListener;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker.StartCheckParam;
import com.tencent.mobileqq.apollo.utils.ApolloGameUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CmGameLoadingView$2$1
  implements View.OnClickListener
{
  CmGameLoadingView$2$1(CmGameLoadingView.2 param2) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(4);
    this.a.this$0.jdField_a_of_type_AndroidWidgetButton.setVisibility(4);
    this.a.this$0.setProgressViewVisibility(true);
    if (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$ICmGameConfirmListener != null) {
      this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$ICmGameConfirmListener.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    }
    if ((this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam != null) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam.mLoadingOnMainProcess)) {
      ApolloGameUtil.a(this.a.jdField_a_of_type_ComTencentMobileqqApolloCmgameCmGameStartChecker$StartCheckParam);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView.2.1
 * JD-Core Version:    0.7.0.1
 */