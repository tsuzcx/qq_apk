package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.statistics.ReportController;

public class GivingHeartItemBuilder$QuickBackClickListener
  implements View.OnClickListener
{
  public GivingHeartItemBuilder$QuickBackClickListener(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  public void onClick(View paramView)
  {
    paramView = (MessageForPoke)((GivingHeartItemBuilder.Holder)AIOUtils.a(paramView)).a;
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8008913", "0X8008913", 0, 0, "", "", "", "");
    switch (paramView.interactType)
    {
    }
    do
    {
      return;
      ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, "", "");
      return;
      ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 2, "", "");
      return;
      ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 3, "", "");
      return;
      ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, "", "");
      return;
      ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, "", "");
      return;
      ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 6, "", "");
      return;
      ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 5, "", "");
      return;
    } while (PokeItemHelper.a);
    PokeItemHelper.a = true;
    PokeItemHelper.a(this.a.b, paramView.subId, paramView.name, -1, paramView.minVersion, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.QuickBackClickListener
 * JD-Core Version:    0.7.0.1
 */