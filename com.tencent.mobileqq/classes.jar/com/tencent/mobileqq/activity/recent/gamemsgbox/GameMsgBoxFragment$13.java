package com.tencent.mobileqq.activity.recent.gamemsgbox;

import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QPublicFragmentActivity;
import com.tencent.mobileqq.activity.QPublicFragmentActivity.Launcher;
import com.tencent.mobileqq.activity.recent.gamemsgbox.api.IGameMsgBoxManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.api.IGameMsgHelperApi;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.BaseSharedPreUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class GameMsgBoxFragment$13
  implements View.OnClickListener
{
  GameMsgBoxFragment$13(GameMsgBoxFragment paramGameMsgBoxFragment) {}
  
  public void onClick(View paramView)
  {
    GameMsgBoxFragment.r(this.a).updateRedDot(3, false);
    BaseSharedPreUtil.a(GameMsgBoxFragment.d(this.a).getApp(), GameMsgBoxFragment.d(this.a).getCurrentAccountUin(), true, "key_game_msg_box_setting_red_dot", Boolean.valueOf(false));
    Object localObject = ((IGameMsgBoxManager)GameMsgBoxFragment.d(this.a).getRuntimeService(IGameMsgBoxManager.class, "")).getGameMsgBoxSp();
    if ((((SharedPreferences)localObject).contains("size")) && (((SharedPreferences)localObject).getInt("size", 0) != 0))
    {
      localObject = new Intent();
      ((Intent)localObject).putExtra("hashCode", this.a.hashCode());
      QPublicFragmentActivity.Launcher.a(this.a.getContext(), (Intent)localObject, QPublicFragmentActivity.class, GameMsgBoxSettingFragment.class);
    }
    else
    {
      ((IGameMsgHelperApi)QRoute.api(IGameMsgHelperApi.class)).openGameMsgSettingPage(this.a.getContext(), "GameMsgBoxFragment");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.gamemsgbox.GameMsgBoxFragment.13
 * JD-Core Version:    0.7.0.1
 */