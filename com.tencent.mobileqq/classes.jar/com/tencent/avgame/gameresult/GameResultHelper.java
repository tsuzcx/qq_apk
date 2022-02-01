package com.tencent.avgame.gameresult;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.listener.SimpleGameResultListener;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.avgame.util.AVGameUtil;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;
import mqq.app.AppRuntime;

public class GameResultHelper
  extends GameResultBaseHelper
{
  private static final String b = "GameResultHelper";
  IAVGameRootContainer a;
  private SimpleGameResultListener c = new GameResultHelper.1(this);
  
  public GameResultHelper(IAVGameRootContainer paramIAVGameRootContainer)
  {
    this.a = paramIAVGameRootContainer;
  }
  
  public void a()
  {
    if (IGameEngine.J()) {
      return;
    }
    EngineData localEngineData = IGameEngine.I().s();
    Object localObject1 = this.a;
    if ((localObject1 instanceof Activity))
    {
      localObject1 = (Activity)localObject1;
      FloatWindowController.c().d();
      Intent localIntent = new Intent((Context)localObject1, QQBrowserActivity.class);
      String str = URLUtil.a("https://ti.qq.com/vgame/result", "id", localEngineData.n());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localEngineData.o());
      ((StringBuilder)localObject2).append("");
      str = URLUtil.a(str, "type", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localEngineData.i());
      ((StringBuilder)localObject2).append("");
      str = URLUtil.a(URLUtil.a(str, "room", ((StringBuilder)localObject2).toString()), "_wv", "16777219");
      localIntent.putExtra("url", str);
      if (QLog.isColorLevel())
      {
        localObject2 = b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("jump result url[");
        localStringBuilder.append(str);
        localStringBuilder.append("]");
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
      }
      ((Activity)localObject1).startActivityForResult(localIntent, 291);
      int j = localEngineData.o();
      int i;
      if (localEngineData.I() <= 2) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B05B", "0X800B05B", j, i, "", "", "", "");
    }
  }
  
  public void b()
  {
    IGameEngine.I().a(this.c);
  }
  
  public void c()
  {
    IGameEngine.I().b(this.c);
  }
  
  public void d()
  {
    EngineData localEngineData = IGameEngine.I().s();
    IGameEngine.I().a(localEngineData.i(), IGameEngine.K().getCurrentAccountUin(), 1, 4);
    IGameEngine.I().a(localEngineData.n());
    IGameEngine.I().s().a(null, null, 0L);
    IGameEngine.I().s().a(null);
    if ((localEngineData.ab()) && (localEngineData.g(IGameEngine.K().getCurrentAccountUin())) && (AVGameUtil.b() == 2))
    {
      IGameEngine.I().c(0);
      localEngineData.f(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultHelper
 * JD-Core Version:    0.7.0.1
 */