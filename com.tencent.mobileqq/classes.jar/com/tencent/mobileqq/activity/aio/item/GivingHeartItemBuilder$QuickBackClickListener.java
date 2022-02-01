package com.tencent.mobileqq.activity.aio.item;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityFacade;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class GivingHeartItemBuilder$QuickBackClickListener
  implements View.OnClickListener
{
  public GivingHeartItemBuilder$QuickBackClickListener(GivingHeartItemBuilder paramGivingHeartItemBuilder) {}
  
  public void onClick(View paramView)
  {
    MessageForPoke localMessageForPoke = (MessageForPoke)((GivingHeartItemBuilder.Holder)AIOUtils.a(paramView)).a;
    ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "CliOper", "", this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a, "0X8008913", "0X8008913", 0, 0, "", "", "", "");
    int i = localMessageForPoke.interactType;
    if (i != 126)
    {
      switch (i)
      {
      default: 
        break;
      case 6: 
        ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 6, "", "");
        break;
      case 5: 
        ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 5, "", "");
        break;
      case 4: 
        ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 4, "", "");
        break;
      case 3: 
        ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 3, "", "");
        break;
      case 2: 
        ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 2, "", "");
        break;
      case 1: 
        ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, "", "");
        break;
      case 0: 
        ChatActivityFacade.a(this.a.b, BaseApplicationImpl.getContext(), this.a.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo, 1, "", "");
        break;
      }
    }
    else if (!PokeItemHelper.a)
    {
      PokeItemHelper.a = true;
      PokeItemHelper.a(this.a.b, localMessageForPoke.subId, localMessageForPoke.name, -1, localMessageForPoke.minVersion, 1);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.GivingHeartItemBuilder.QuickBackClickListener
 * JD-Core Version:    0.7.0.1
 */