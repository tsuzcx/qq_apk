package com.tencent.avgame.gamelogic.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseAVGameAppInterface;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.avgameshare.AVGameShareUtil;

class GameActivityCenterCtrl$ShowAwardResult
  implements Runnable
{
  private final String a;
  
  GameActivityCenterCtrl$ShowAwardResult(String paramString)
  {
    this.a = paramString;
  }
  
  private void a(Activity paramActivity, String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder(this.a);
    Intent localIntent = new Intent(paramActivity, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("isTransparentTitle", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("avgame_share_link", paramString1);
    localIntent.putExtra("avgame_share_name", paramString2);
    localIntent.putExtra("url", localStringBuilder.toString());
    localIntent.putExtra("big_brother_source_key", "biz_src_jc_av_game");
    paramActivity.startActivity(localIntent);
  }
  
  private void a(Context paramContext)
  {
    BaseAVGameAppInterface localBaseAVGameAppInterface = GameEngine.a().f();
    String str1 = localBaseAVGameAppInterface.getCurrentAccountUin();
    EngineData localEngineData = GameEngine.a().s();
    long l = localEngineData.i();
    String str2 = localEngineData.e().getNick(str1);
    AVGameShareUtil.a().a(localBaseAVGameAppInterface, l, Long.valueOf(str1).longValue(), str2, 3, "", localEngineData.p(), new GameActivityCenterCtrl.ShowAwardResult.1(this, paramContext, str2));
  }
  
  public void run()
  {
    Activity localActivity = GameActivityCenterCtrl.c(GameActivityCenterCtrl.a());
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    if ((localObject != null) && (!TextUtils.isEmpty(this.a))) {
      a((Context)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl.ShowAwardResult
 * JD-Core Version:    0.7.0.1
 */