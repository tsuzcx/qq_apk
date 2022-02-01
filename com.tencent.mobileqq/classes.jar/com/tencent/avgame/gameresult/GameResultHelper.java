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
  private static final String jdField_a_of_type_JavaLangString = "GameResultHelper";
  private SimpleGameResultListener jdField_a_of_type_ComTencentAvgameGamelogicListenerSimpleGameResultListener = new GameResultHelper.1(this);
  IAVGameRootContainer jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer;
  
  public GameResultHelper(IAVGameRootContainer paramIAVGameRootContainer)
  {
    this.jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer = paramIAVGameRootContainer;
  }
  
  public void a()
  {
    if (IGameEngine.k()) {
      return;
    }
    EngineData localEngineData = IGameEngine.a().a();
    Object localObject1 = this.jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer;
    if ((localObject1 instanceof Activity))
    {
      localObject1 = (Activity)localObject1;
      FloatWindowController.a().c();
      Intent localIntent = new Intent((Context)localObject1, QQBrowserActivity.class);
      String str = URLUtil.a("https://ti.qq.com/vgame/result", "id", localEngineData.b());
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localEngineData.c());
      ((StringBuilder)localObject2).append("");
      str = URLUtil.a(str, "type", ((StringBuilder)localObject2).toString());
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localEngineData.a());
      ((StringBuilder)localObject2).append("");
      str = URLUtil.a(URLUtil.a(str, "room", ((StringBuilder)localObject2).toString()), "_wv", "16777219");
      localIntent.putExtra("url", str);
      if (QLog.isColorLevel())
      {
        localObject2 = jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("jump result url[");
        localStringBuilder.append(str);
        localStringBuilder.append("]");
        QLog.i((String)localObject2, 2, localStringBuilder.toString());
      }
      ((Activity)localObject1).startActivityForResult(localIntent, 291);
      int j = localEngineData.c();
      int i;
      if (localEngineData.h() <= 2) {
        i = 1;
      } else {
        i = 2;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B05B", "0X800B05B", j, i, "", "", "", "");
    }
  }
  
  public void b()
  {
    IGameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSimpleGameResultListener);
  }
  
  public void c()
  {
    IGameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSimpleGameResultListener);
  }
  
  public void d()
  {
    EngineData localEngineData = IGameEngine.a().a();
    IGameEngine.a().a(localEngineData.a(), IGameEngine.a().getCurrentAccountUin(), 1, 4);
    IGameEngine.a().a(localEngineData.b());
    IGameEngine.a().a().a(null, null, 0L);
    IGameEngine.a().a().a(null);
    if ((localEngineData.j()) && (localEngineData.e(IGameEngine.a().getCurrentAccountUin())) && (AVGameUtil.b() == 2))
    {
      IGameEngine.a().c(0);
      localEngineData.e(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultHelper
 * JD-Core Version:    0.7.0.1
 */