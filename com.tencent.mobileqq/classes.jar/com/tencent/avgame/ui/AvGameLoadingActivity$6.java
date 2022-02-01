package com.tencent.avgame.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.IStatusListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class AvGameLoadingActivity$6
  implements AvGameResDownloadManager.IStatusListener
{
  AvGameLoadingActivity$6(AvGameLoadingActivity paramAvGameLoadingActivity) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameLoadingActivity", 2, "onResDownloadStart");
    }
    AvGameLoadingActivity localAvGameLoadingActivity = this.a;
    localAvGameLoadingActivity.jdField_a_of_type_Int = 0;
    AvGameLoadingActivity.a(localAvGameLoadingActivity, localAvGameLoadingActivity.jdField_a_of_type_Int);
    AvGameLoadingActivity.c(this.a, true);
  }
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResDownloadProgress and percent is ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.i("AvGameLoadingActivity", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.a;
    ((AvGameLoadingActivity)localObject).jdField_a_of_type_Int = (paramInt / ((AvGameLoadingActivity)localObject).b);
    localObject = this.a;
    AvGameLoadingActivity.a((AvGameLoadingActivity)localObject, ((AvGameLoadingActivity)localObject).jdField_a_of_type_Int);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameLoadingActivity", 2, "onResDownloadReady");
    }
    if (AvGameLoadingActivity.h(this.a))
    {
      AvGameLoadingActivity.a(this.a);
      AvGameLoadingActivity.c(this.a, false);
    }
    else
    {
      ThreadManager.getUIHandlerV2().postDelayed(new AvGameLoadingActivity.6.1(this), 150L);
    }
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("av_game_sp", 4);
    if (!paramString.endsWith("/"))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramString);
      localStringBuilder.append(File.separator);
      paramString = localStringBuilder.toString();
    }
    localSharedPreferences.edit().putString("resPath", paramString).commit();
    com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.a = paramString;
    ReportController.b(null, "dc00898", "", "", "0X800B043", "0X800B043", 0, 0, "", "", "", "");
  }
  
  public void b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameLoadingActivity", 1, "onResDownloadFailed");
    }
    this.a.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    ReportController.b(null, "dc00898", "", "", "0X800B044", "0X800B044", 0, 0, localStringBuilder.toString(), "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.6
 * JD-Core Version:    0.7.0.1
 */