package com.tencent.mobileqq.activity.aio.helper;

import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopHandler;
import com.tencent.mobileqq.util.TroopReportor;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopGameGuideHelper$5
  implements View.OnClickListener
{
  TroopGameGuideHelper$5(TroopGameGuideHelper paramTroopGameGuideHelper) {}
  
  public void onClick(View paramView)
  {
    this.a.jdField_a_of_type_AndroidAppDialog.dismiss();
    if ((TroopGameGuideHelper.a(this.a) == null) || (TroopGameGuideHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo == null) || (TroopGameGuideHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler == null) {
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler = ((TroopHandler)TroopGameGuideHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.TROOP_HANDLER));
      }
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler != null)
      {
        TroopGameGuideHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(TroopGameGuideHelper.a(this.a));
        this.a.jdField_a_of_type_ComTencentMobileqqAppTroopHandler.g(TroopGameGuideHelper.a(this.a).jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, true);
      }
      TroopReportor.a("Grp_AIO", "AIO_clk", "game_tips_clk_on", 0, 0, new String[] { this.a.b });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopGameGuideHelper.5
 * JD-Core Version:    0.7.0.1
 */