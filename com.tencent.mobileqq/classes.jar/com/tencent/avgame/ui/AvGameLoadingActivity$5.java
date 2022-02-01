package com.tencent.avgame.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.IStatusListener;
import com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.ResInfo;
import com.tencent.avgame.gamelogic.gameres.CJPreloadMonitorReporter;
import com.tencent.avgame.report.exception.AVGameExceptionReporter;
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
      QLog.i("AvGameLoadingActivity", 2, "onResDownloadStart");
    }
    AvGameLoadingActivity localAvGameLoadingActivity = this.b;
    localAvGameLoadingActivity.e = 0;
    AvGameLoadingActivity.e(localAvGameLoadingActivity, localAvGameLoadingActivity.e);
    AvGameLoadingActivity.c(this.b, true);
    if (AvGameLoadingActivity.k(this.b)) {
      AVGameExceptionReporter.a().a(2, this.a.a, null, null);
    }
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
    Object localObject = this.b;
    ((AvGameLoadingActivity)localObject).e = (paramInt / ((AvGameLoadingActivity)localObject).f);
    localObject = this.b;
    AvGameLoadingActivity.e((AvGameLoadingActivity)localObject, ((AvGameLoadingActivity)localObject).e);
  }
  
  public void a(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameLoadingActivity", 2, "onResDownloadReady");
    }
    if (AvGameLoadingActivity.l(this.b))
    {
      AvGameLoadingActivity.m(this.b);
      AvGameLoadingActivity.c(this.b, false);
    }
    else
    {
      ThreadManager.getUIHandlerV2().postDelayed(new AvGameLoadingActivity.5.1(this), 150L);
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
    this.b.b.sendEmptyMessage(1);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramInt);
    ReportController.b(null, "dc00898", "", "", "0X800B044", "0X800B044", 0, 0, localStringBuilder.toString(), "", "", "");
    CJPreloadMonitorReporter.a(1, this.a.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.ui.AvGameLoadingActivity.5
 * JD-Core Version:    0.7.0.1
 */