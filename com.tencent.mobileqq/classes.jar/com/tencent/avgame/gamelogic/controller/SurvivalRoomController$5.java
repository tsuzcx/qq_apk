package com.tencent.avgame.gamelogic.controller;

import android.text.TextUtils;
import com.tencent.avgame.app.IAVGameAppInterface;
import com.tencent.avgame.gamelogic.IGameEngine;
import com.tencent.avgame.ipc.AVGameClientQIPCModule;
import com.tencent.avgame.report.exception.AVGameExceptionReporter;
import com.tencent.avgame.ui.IAVGameRootContainer;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;

class SurvivalRoomController$5
  implements Runnable
{
  SurvivalRoomController$5(SurvivalRoomController paramSurvivalRoomController, QBaseActivity paramQBaseActivity, int paramInt) {}
  
  public void run()
  {
    String str = ((IAVGameRootContainer)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).getRoomId();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onEnterRoom run mGameExited:");
    localStringBuilder.append(((IAVGameRootContainer)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).getGameExitStatus());
    localStringBuilder.append(" retCode:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" mRoomId:");
    localStringBuilder.append(str);
    QLog.i("SurvivalRoomController", 1, localStringBuilder.toString());
    if (((IAVGameRootContainer)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).getGameExitStatus()) {
      return;
    }
    int i = this.jdField_a_of_type_Int;
    if (i == 0)
    {
      if ((!TextUtils.isEmpty(str)) && (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime() != null)) {
        ((IAVGameAppInterface)this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).a().a(1, str);
      }
    }
    else if (i != 5)
    {
      if (i == 6) {
        return;
      }
      if ((IGameEngine.a().i()) && (IGameEngine.a().g())) {
        AVGameExceptionReporter.a().a(8, null, String.valueOf(this.jdField_a_of_type_Int), null);
      }
      SurvivalRoomController.a(this.this$0, this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2, this.jdField_a_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.controller.SurvivalRoomController.5
 * JD-Core Version:    0.7.0.1
 */