package com.tencent.avgame.gameresult;

import android.content.Intent;
import com.tencent.avgame.floatwindow.FloatWindowController;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.avgame.videorecord.SimpleGameRoomStatusListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.URLUtil;

public class GamePKResultHelper
  extends GameResultBaseHelper
{
  private static final String jdField_a_of_type_JavaLangString = GamePKResultHelper.class.getSimpleName();
  private final int jdField_a_of_type_Int = 1;
  IAVGameRootContainer jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer;
  protected SimpleGameRoomStatusListener a;
  private final int b = 2;
  
  public GamePKResultHelper(IAVGameRootContainer paramIAVGameRootContainer)
  {
    this.jdField_a_of_type_ComTencentAvgameVideorecordSimpleGameRoomStatusListener = new GamePKResultHelper.1(this);
    this.jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer = paramIAVGameRootContainer;
  }
  
  public void a()
  {
    AVGameActivity localAVGameActivity;
    Intent localIntent;
    if ((this.jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer instanceof AVGameActivity))
    {
      localAVGameActivity = (AVGameActivity)this.jdField_a_of_type_ComTencentAvgameUiIAVGameRootContainer;
      FloatWindowController.a().c();
      localIntent = new Intent(localAVGameActivity, QQBrowserActivity.class);
      if (!GameEngine.a().g()) {
        break label343;
      }
    }
    label343:
    for (int i = 1;; i = 2)
    {
      String str = URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a(URLUtil.a("https://ti.qq.com/hb2021/gameresult", "id", GameEngine.a().a().b()), "type", GameEngine.a().a().c() + ""), "room", GameEngine.a().a().a() + ""), "pkid", GameEngine.a().a().k() + ""), "poolid", GameEngine.a().a().j() + ""), "answer", i + ""), "roundid", GameEngine.a().a().p() + ""), "businessid", GameEngine.a().a().r() + ""), "_wv", "16777219");
      localIntent.putExtra("url", str);
      if (QLog.isColorLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 2, "jump result url[" + str + "]");
      }
      localAVGameActivity.startActivityForResult(localIntent, 291);
      return;
    }
  }
  
  public void b()
  {
    GameEngine.a().a(this.jdField_a_of_type_ComTencentAvgameVideorecordSimpleGameRoomStatusListener);
  }
  
  public void c()
  {
    GameEngine.a().b(this.jdField_a_of_type_ComTencentAvgameVideorecordSimpleGameRoomStatusListener);
  }
  
  public void d()
  {
    GameEngine.a().a().c();
    GameEngine.a().l();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gameresult.GamePKResultHelper
 * JD-Core Version:    0.7.0.1
 */