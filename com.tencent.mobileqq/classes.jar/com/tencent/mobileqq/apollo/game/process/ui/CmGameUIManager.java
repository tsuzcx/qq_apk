package com.tencent.mobileqq.apollo.game.process.ui;

import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.apollo.game.ApolloGameStateMachine;
import com.tencent.mobileqq.apollo.game.process.CmGameClientQIPCModule;
import com.tencent.mobileqq.apollo.model.ApolloGameData;
import com.tencent.mobileqq.apollo.model.StartCheckParam;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

public class CmGameUIManager
  implements Handler.Callback, View.OnClickListener
{
  private static int jdField_a_of_type_Int = 600000;
  private StartCheckParam jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
  private WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler;
  private int b;
  
  public void a()
  {
    ApolloGameStateMachine.a().a(5, "CmGame.onDestroy");
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeCallbacksAndMessages(null);
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameUIManager", 2, "uimanager onDestroy");
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(25);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityResume mGameId:");
    localStringBuilder.append(this.b);
    QLog.d("cmgame_process.CmGameUIManager", 2, localStringBuilder.toString());
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.removeMessages(25);
    this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.sendEmptyMessageDelayed(25, jdField_a_of_type_Int);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onActivityStop mGameId:");
    localStringBuilder.append(this.b);
    QLog.d("cmgame_process.CmGameUIManager", 2, localStringBuilder.toString());
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what != 25) {
      return false;
    }
    paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam;
    if (paramMessage != null)
    {
      if (paramMessage.game == null) {
        paramMessage = "";
      } else {
        paramMessage = this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam.game.name;
      }
      VipUtils.a(null, "cmshow", "Apollo", "game_shutdown", 0, 0, new String[] { paramMessage });
    }
    CmGameClientQIPCModule.a(this.b);
    paramMessage = new StringBuilder();
    paramMessage.append("MSG_CODE_CLOSE_GAME_TIMEOUT timeout colsegame mGameParams:");
    paramMessage.append(this.jdField_a_of_type_ComTencentMobileqqApolloModelStartCheckParam);
    QLog.i("cmgame_process.CmGameUIManager", 1, paramMessage.toString());
    return false;
  }
  
  public void onClick(View paramView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.ui.CmGameUIManager
 * JD-Core Version:    0.7.0.1
 */