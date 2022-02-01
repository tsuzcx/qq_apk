package com.tencent.avgame.gamelobby.rv;

import android.view.View;
import com.tencent.avgame.gamelobby.data.AVGameLobbySurvivalContentInfo;
import com.tencent.avgame.gamelobby.data.IBaseData;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.avgame.qav.AsyncExitTask;
import com.tencent.avgame.ui.AVGameRoomCenterFragment;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class AVGameLobbyOnClickListenerFactory$3
  implements BaseViewHolder.OnClickListener
{
  AVGameLobbyOnClickListenerFactory$3(AVGameLobbyOnClickListenerFactory paramAVGameLobbyOnClickListenerFactory) {}
  
  public void a(View paramView, IBaseData paramIBaseData, int paramInt)
  {
    boolean bool = true;
    if (paramIBaseData == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if (AsyncExitTask.a())
          {
            QQToast.a(this.a.jdField_a_of_type_ComTencentAvgameUiAVGameRoomCenterFragment.getActivity(), 2131690501, 0).a();
            return;
          }
          paramIBaseData = (AVGameLobbySurvivalContentInfo)paramIBaseData;
          QLog.d(AVGameRoomCenterFragment.jdField_a_of_type_JavaLangString, 2, "getTimeType is " + paramIBaseData.c());
          if (paramView.getId() != 2131363304) {
            break;
          }
          if (QLog.isColorLevel()) {
            QLog.d(AVGameRoomCenterFragment.jdField_a_of_type_JavaLangString, 2, "reserve button click");
          }
        } while (paramIBaseData.b());
        if (this.a.jdField_a_of_type_ComTencentAvgameUiAVGameRoomCenterFragment.a())
        {
          AVGameRoomCenterFragment localAVGameRoomCenterFragment = this.a.jdField_a_of_type_ComTencentAvgameUiAVGameRoomCenterFragment;
          paramInt = paramIBaseData.d();
          if (!paramIBaseData.b()) {}
          for (;;)
          {
            localAVGameRoomCenterFragment.a(paramInt, bool);
            paramIBaseData.b(false);
            paramView.setClickable(false);
            ReportController.b(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "dc00898", "", "", "0X800B690", "0X800B690", 0, 0, "", "", "", "");
            return;
            bool = false;
          }
        }
        this.a.jdField_a_of_type_ComTencentAvgameUiAVGameRoomCenterFragment.jdField_a_of_type_Int = paramIBaseData.d();
        this.a.jdField_a_of_type_ComTencentAvgameUiAVGameRoomCenterFragment.e();
        return;
        if (paramIBaseData.c() != 3) {
          break;
        }
        if (paramIBaseData.d()) {
          CJSurvivalFestivalReporter.a(1, 1, true, 0, false, paramIBaseData.d(), "0", false);
        }
        this.a.jdField_a_of_type_ComTencentAvgameUiAVGameRoomCenterFragment.c(paramIBaseData.d(), paramIBaseData.d());
      } while (!QLog.isColorLevel());
      QLog.d(AVGameRoomCenterFragment.jdField_a_of_type_JavaLangString, 2, "reserve item click");
      return;
      if (paramIBaseData.d()) {
        CJSurvivalFestivalReporter.a(1, 1, true, 0, true, paramIBaseData.d(), "0", false);
      }
      QQToast.a(this.a.jdField_a_of_type_ComTencentAvgameUiAVGameRoomCenterFragment.getActivity(), 0, 2131690505, 0).a();
    } while (!QLog.isColorLevel());
    QLog.d(AVGameRoomCenterFragment.jdField_a_of_type_JavaLangString, 2, "reserve item click err");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelobby.rv.AVGameLobbyOnClickListenerFactory.3
 * JD-Core Version:    0.7.0.1
 */