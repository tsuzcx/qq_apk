package com.tencent.avgame.gamelobby.rv;

import android.view.View;
import com.tencent.avgame.gamelobby.IAVGameRoomCenterFragment;
import com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo;
import com.tencent.avgame.gamelobby.data.IBaseData;
import com.tencent.avgame.qav.AsyncExitTask;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AVGameLobbyOnClickListenerFactory$3
  implements BaseViewHolder.OnClickListener
{
  AVGameLobbyOnClickListenerFactory$3(AVGameLobbyOnClickListenerFactory paramAVGameLobbyOnClickListenerFactory) {}
  
  public void a(View paramView, IBaseData paramIBaseData, int paramInt)
  {
    if (paramIBaseData == null) {
      return;
    }
    if (AsyncExitTask.a())
    {
      QQToast.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplicationContext(), 2131690426, 0).a();
      return;
    }
    paramIBaseData = (AVGameLobbySurvivalContentInfo)paramIBaseData;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("getTimeType is ");
    localStringBuilder.append(paramIBaseData.c());
    QLog.d("AVGameLobbyOnClickListenerFactory", 2, localStringBuilder.toString());
    if (paramView.getId() == 2131363236)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVGameLobbyOnClickListenerFactory", 2, "reserve button click");
      }
      if (paramIBaseData.b()) {
        return;
      }
      if (this.a.jdField_a_of_type_ComTencentAvgameGamelobbyIAVGameRoomCenterFragment.a())
      {
        this.a.jdField_a_of_type_ComTencentAvgameGamelobbyIAVGameRoomCenterFragment.a(paramIBaseData.d(), paramIBaseData.b() ^ true);
        paramIBaseData.b(false);
        paramView.setClickable(false);
        ReportController.b(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00898", "", "", "0X800B690", "0X800B690", 0, 0, "", "", "", "");
        return;
      }
      this.a.jdField_a_of_type_ComTencentAvgameGamelobbyIAVGameRoomCenterFragment.b(paramIBaseData.d());
      this.a.jdField_a_of_type_ComTencentAvgameGamelobbyIAVGameRoomCenterFragment.d();
      return;
    }
    if (paramIBaseData.c() == 3)
    {
      if (paramIBaseData.d()) {
        this.a.jdField_a_of_type_ComTencentAvgameGamelobbyIAVGameRoomCenterFragment.a(paramIBaseData.b(), paramIBaseData.d());
      }
      this.a.jdField_a_of_type_ComTencentAvgameGamelobbyIAVGameRoomCenterFragment.c(paramIBaseData.d(), paramIBaseData.d());
      if (QLog.isColorLevel()) {
        QLog.d("AVGameLobbyOnClickListenerFactory", 2, "reserve item click");
      }
    }
    else
    {
      if (paramIBaseData.d()) {
        this.a.jdField_a_of_type_ComTencentAvgameGamelobbyIAVGameRoomCenterFragment.a(paramIBaseData.b(), paramIBaseData.d());
      }
      QQToast.a(this.a.jdField_a_of_type_ComTencentCommonAppAppInterface.getApplicationContext(), 0, 2131690430, 0).a();
      if (QLog.isColorLevel()) {
        QLog.d("AVGameLobbyOnClickListenerFactory", 2, "reserve item click err");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory.3
 * JD-Core Version:    0.7.0.1
 */