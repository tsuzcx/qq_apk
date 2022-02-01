package com.tencent.avgame.gamelogic.controller;

import android.text.TextUtils;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.avgame.gamelogic.GameEngine;
import com.tencent.avgame.gamelogic.data.EngineData;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.ui.AVGameActivity;
import com.tencent.qphone.base.util.QLog;

class SurvivalRoomController$5
  implements Runnable
{
  SurvivalRoomController$5(SurvivalRoomController paramSurvivalRoomController, AVGameActivity paramAVGameActivity, int paramInt) {}
  
  public void run()
  {
    String str = this.jdField_a_of_type_ComTencentAvgameUiAVGameActivity.a();
    QLog.i("SurvivalRoomController", 1, "onEnterRoom run mGameExited:" + this.jdField_a_of_type_ComTencentAvgameUiAVGameActivity.a() + " retCode:" + this.jdField_a_of_type_Int + " mRoomId:" + str);
    if (this.jdField_a_of_type_ComTencentAvgameUiAVGameActivity.a()) {}
    do
    {
      do
      {
        return;
        if (this.jdField_a_of_type_Int != 0) {
          break;
        }
      } while ((TextUtils.isEmpty(str)) || (this.jdField_a_of_type_ComTencentAvgameUiAVGameActivity.getAppInterface() == null));
      ((AVGameAppInterface)this.jdField_a_of_type_ComTencentAvgameUiAVGameActivity.getAppInterface()).a().a(1, str);
      return;
    } while ((this.jdField_a_of_type_Int == 5) || (this.jdField_a_of_type_Int == 6));
    int i;
    if ((GameEngine.a().i()) && (GameEngine.a().g()))
    {
      i = this.jdField_a_of_type_Int;
      if (GameEngine.a().a().m()) {
        break label197;
      }
    }
    label197:
    for (boolean bool = true;; bool = false)
    {
      CJSurvivalFestivalReporter.a(8, true, String.valueOf(i), null, bool);
      SurvivalRoomController.a(this.this$0, this.jdField_a_of_type_ComTencentAvgameUiAVGameActivity, 2, this.jdField_a_of_type_Int);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SurvivalRoomController.5
 * JD-Core Version:    0.7.0.1
 */