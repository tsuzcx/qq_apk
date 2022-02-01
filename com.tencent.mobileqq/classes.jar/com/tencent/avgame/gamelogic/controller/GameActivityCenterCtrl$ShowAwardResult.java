package com.tencent.avgame.gamelogic.controller;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import aono;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.data.RoomInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import myk;
import myv;
import mze;

public class GameActivityCenterCtrl$ShowAwardResult
  implements Runnable
{
  private final String a;
  
  public GameActivityCenterCtrl$ShowAwardResult(String paramString)
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
    AVGameAppInterface localAVGameAppInterface = myk.a().a();
    String str1 = localAVGameAppInterface.getCurrentAccountUin();
    mze localmze = myk.a().a();
    long l = localmze.a();
    String str2 = localmze.a().getNick(str1);
    aono.a().a(localAVGameAppInterface, l, Long.valueOf(str1).longValue(), str2, 3, "", localmze.d(), new myv(this, paramContext, str2));
  }
  
  public void run()
  {
    Activity localActivity = GameActivityCenterCtrl.a(GameActivityCenterCtrl.a());
    Object localObject = localActivity;
    if (localActivity == null) {
      localObject = BaseApplicationImpl.getContext();
    }
    if ((localObject != null) && (!TextUtils.isEmpty(this.a))) {
      a((Context)localObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.GameActivityCenterCtrl.ShowAwardResult
 * JD-Core Version:    0.7.0.1
 */