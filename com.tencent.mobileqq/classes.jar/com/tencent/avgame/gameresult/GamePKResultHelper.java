package com.tencent.avgame.gameresult;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.data.SurvivalPkResultInfo;
import com.tencent.avgame.qav.videorecord.SimpleGameRoomStatusListener;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

public class GamePKResultHelper
  extends GameResultBaseHelper
{
  private static final String c = "GamePKResultHelper";
  IAVGameRootContainer a;
  protected SimpleGameRoomStatusListener b = new GamePKResultHelper.1(this);
  private final int d = 1;
  private final int e = 2;
  
  public GamePKResultHelper(IAVGameRootContainer paramIAVGameRootContainer)
  {
    this.a = paramIAVGameRootContainer;
  }
  
  public void a()
  {
    Object localObject = IGameEngine.I().s();
    if (((this.a instanceof Activity)) && (!TextUtils.isEmpty(((EngineData)localObject).Z().awardUrl)))
    {
      Activity localActivity = (Activity)this.a;
      FloatWindowController.c().d();
      Intent localIntent = new Intent(localActivity, QQBrowserActivity.class);
      String str = ((EngineData)localObject).Z().awardUrl;
      int i;
      if (((EngineData)localObject).O()) {
        i = 1;
      } else {
        i = 2;
      }
      str = URLUtil.a(str, "id", ((EngineData)localObject).n());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((EngineData)localObject).o());
      localStringBuilder.append("");
      str = URLUtil.a(str, "type", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((EngineData)localObject).i());
      localStringBuilder.append("");
      str = URLUtil.a(str, "room", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((EngineData)localObject).Q());
      localStringBuilder.append("");
      str = URLUtil.a(str, "pkid", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((EngineData)localObject).P());
      localStringBuilder.append("");
      str = URLUtil.a(str, "poolid", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(i);
      localStringBuilder.append("");
      str = URLUtil.a(str, "answer", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((EngineData)localObject).Y());
      localStringBuilder.append("");
      str = URLUtil.a(str, "roundid", localStringBuilder.toString());
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((EngineData)localObject).ah());
      localStringBuilder.append("");
      str = URLUtil.a(str, "businessid", localStringBuilder.toString());
      localObject = str;
      if (URLUtil.a(URLUtil.a(str), "_wv") == null) {
        localObject = URLUtil.a(str, "_wv", "16777217");
      }
      localIntent.putExtra("url", (String)localObject);
      if (QLog.isColorLevel())
      {
        str = c;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("jump result url[");
        localStringBuilder.append((String)localObject);
        localStringBuilder.append("]");
        QLog.i(str, 2, localStringBuilder.toString());
      }
      localActivity.startActivityForResult(localIntent, 291);
    }
  }
  
  public void b()
  {
    IGameEngine.I().a(this.b);
  }
  
  public void c()
  {
    IGameEngine.I().b(this.b);
  }
  
  public void d()
  {
    IGameEngine.I().s().c();
    IGameEngine.I().x();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GamePKResultHelper
 * JD-Core Version:    0.7.0.1
 */