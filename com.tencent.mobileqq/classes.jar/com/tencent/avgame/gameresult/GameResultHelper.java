package com.tencent.avgame.gameresult;

import android.content.Intent;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gamelogic.listener.SimpleGameResultListener;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.avgame.util.AVGameUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

public class GameResultHelper
  extends GameResultBaseHelper
{
  private static final String jdField_a_of_type_JavaLangString = GameResultHelper.class.getSimpleName();
  private SimpleGameResultListener jdField_a_of_type_ComTencentAvgameGamelogicListenerSimpleGameResultListener = new GameResultHelper.1(this);
  IAVGameRootContainer jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer;
  
  public GameResultHelper(IAVGameRootContainer paramIAVGameRootContainer)
  {
    this.jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer = paramIAVGameRootContainer;
  }
  
  public void a()
  {
    int i = 2;
    if ((this.jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer instanceof AVGameActivity))
    {
      AVGameActivity localAVGameActivity = (AVGameActivity)this.jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer;
      FloatWindowController.a().c();
      Intent localIntent = new Intent(localAVGameActivity, QQBrowserActivity.class);
      String str = URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://ti.qq.com/vgame/result", "id", GameEngine.a().a().b()), "type", GameEngine.a().a().c() + ""), "room", GameEngine.a().a().a() + ""), "_wv", "16777219");
      localIntent.putExtra("url", str);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "jump result url[" + str + "]");
      }
      localAVGameActivity.startActivityForResult(localIntent, 291);
      int j = GameEngine.a().a().c();
      if (GameEngine.a().a().h() <= 2) {
        i = 1;
      }
      ReportController.b(null, "dc00898", "", "", "0X800B05B", "0X800B05B", j, i, "", "", "", "");
    }
  }
  
  public void b()
  {
    GameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSimpleGameResultListener);
  }
  
  public void c()
  {
    GameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameGamelogicListenerSimpleGameResultListener);
  }
  
  public void d()
  {
    EngineData localEngineData = GameEngine.a().a();
    GameEngine.a().a(localEngineData.a(), GameEngine.a().a().getAccount(), 1, 4);
    GameEngine.a().a(localEngineData.b());
    GameEngine.a().a().a(null, null, 0L);
    GameEngine.a().a().a(null);
    if ((localEngineData.j()) && (localEngineData.e(GameEngine.a().a().getCurrentAccountUin())) && (AVGameUtils.b() == 2))
    {
      GameEngine.a().c(0);
      localEngineData.e(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GameResultHelper
 * JD-Core Version:    0.7.0.1
 */