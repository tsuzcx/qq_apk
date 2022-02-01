package com.tencent.mobileqq.activity.aio.rebuild;

import android.content.res.Resources;
import android.view.View;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.werewolves.WerewolvesHandler;
import com.tencent.mobileqq.werewolves.WerewolvesPluginInterface;
import com.tencent.mobileqq.werewolves.WerewolvesPluginManager;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;

class GameRoomChatPie$22
  implements ActionSheet.OnButtonClickListener
{
  GameRoomChatPie$22(GameRoomChatPie paramGameRoomChatPie, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
      }
      if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a())) {
        try
        {
          ((WerewolvesHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.jdField_a_of_type_ComTencentMobileqqDataHotChatInfo, new GameRoomChatPie.22.1(this));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.d = new QQProgressDialog(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a(), this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a());
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.d.setContentView(2131562946);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.d.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a().getString(2131692166));
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.d.setCancelable(false);
          this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.d.show();
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.jdField_a_of_type_ComTencentMobileqqWerewolvesWerewolvesPluginManager.a();
          if ((paramView == null) || (!paramView.b())) {
            continue;
          }
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00899", "Grp_wolf", "", "in_game", "run_away", 0, 0, "", "", "", "");
        }
        catch (Exception paramView)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.b, 2, "the sessionInfo.curFriendUin is wrong: " + this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.a);
          continue;
        }
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a(), 2130839715, this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a().getResources().getString(2131694510), 0).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioRebuildGameRoomChatPie.a());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.22
 * JD-Core Version:    0.7.0.1
 */