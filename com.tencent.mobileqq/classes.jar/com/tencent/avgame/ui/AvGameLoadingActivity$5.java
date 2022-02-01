package com.tencent.avgame.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.IStatusListener;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.ResInfo;
import com.tencent.avgame.gamelogic.gameres.CJPreloadMonitorReporter;
import com.tencent.avgame.gameroom.festivalreport.CJSurvivalFestivalReporter;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AvGameLoadingActivity$5
  implements AvGameResDownloadManager.IStatusListener
{
  AvGameLoadingActivity$5(AvGameLoadingActivity paramAvGameLoadingActivity, AvGameResDownloadManager.ResInfo paramResInfo) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "onResDownloadStart");
    }
    this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity.jdField_a_of_type_Int = 0;
    AvGameLoadingActivity.a(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity, this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity.jdField_a_of_type_Int);
    AvGameLoadingActivity.c(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity, true);
    if (AvGameLoadingActivity.g(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity)) {
      CJSurvivalFestivalReporter.a(2, false, this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$ResInfo.a, null, false);
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "onResDownloadProgress and percent is " + paramInt);
    }
    this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity.jdField_a_of_type_Int = (paramInt / this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity.b);
    AvGameLoadingActivity.a(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity, this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity.jdField_a_of_type_Int);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 2, "onResDownloadReady");
    }
    SharedPreferences localSharedPreferences;
    if (AvGameLoadingActivity.h(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity))
    {
      AvGameLoadingActivity.a(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity);
      AvGameLoadingActivity.c(this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity, false);
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4);
      if (!paramString.endsWith("/")) {
        break label141;
      }
    }
    for (;;)
    {
      localSharedPreferences.edit().putString("resPath", paramString).commit();
      com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.a = paramString;
      ReportController.b(null, "dc00898", "", "", "0X800B043", "0X800B043", 0, 0, "", "", "", "");
      CJPreloadMonitorReporter.a(0, this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$ResInfo.a, 0);
      return;
      ThreadManager.getUIHandlerV2().postDelayed(new AvGameLoadingActivity.5.1(this), 150L);
      break;
      label141:
      paramString = paramString + File.separator;
    }
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameManagerAvGameLoadingActivity", 1, "onResDownloadFailed");
    }
    this.jdField_a_of_type_ComTencentAvgameUiAvGameLoadingActivity.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    ReportController.b(null, "dc00898", "", "", "0X800B044", "0X800B044", 0, 0, "" + paramInt, "", "", "");
    CJPreloadMonitorReporter.a(1, this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResDownloadManager$ResInfo.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.5
 * JD-Core Version:    0.7.0.1
 */