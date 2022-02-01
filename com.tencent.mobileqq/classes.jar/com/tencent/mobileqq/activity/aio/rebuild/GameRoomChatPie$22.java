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
  
  public void onClick(View paramView, int paramInt)
  {
    if ((paramInt != 0) || (NetworkUtil.isNetSupport(this.b.aX()))) {}
    try
    {
      ((WerewolvesHandler)this.b.d.getBusinessHandler(BusinessHandlerFactory.WEREWOLVES_HANDLER)).a(this.b.bR, new GameRoomChatPie.22.1(this));
      this.b.bD = new QQProgressDialog(this.b.aX(), this.b.A());
      this.b.bD.setContentView(2131629210);
      this.b.bD.a(this.b.aX().getString(2131889064));
      this.b.bD.setCancelable(false);
      this.b.bD.show();
    }
    catch (Exception paramView)
    {
      label140:
      StringBuilder localStringBuilder;
      break label140;
    }
    if (QLog.isColorLevel())
    {
      paramView = this.b.c;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("the sessionInfo.curFriendUin is wrong: ");
      localStringBuilder.append(this.b.ah.b);
      QLog.e(paramView, 2, localStringBuilder.toString());
    }
    paramView = this.b.bC.c();
    if ((paramView != null) && (paramView.d()))
    {
      ReportController.b(this.b.d, "dc00899", "Grp_wolf", "", "in_game", "run_away", 0, 0, "", "", "", "");
      break label287;
      QQToast.makeText(this.b.aX(), 2130839791, this.b.aX().getResources().getString(2131892157), 0).show(this.b.A());
    }
    try
    {
      label287:
      this.a.dismiss();
      return;
    }
    catch (Exception paramView)
    {
      paramView.printStackTrace();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.GameRoomChatPie.22
 * JD-Core Version:    0.7.0.1
 */