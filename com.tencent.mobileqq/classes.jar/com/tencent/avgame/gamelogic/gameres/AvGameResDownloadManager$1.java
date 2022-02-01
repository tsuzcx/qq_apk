package com.tencent.avgame.gamelogic.gameres;

import android.text.TextUtils;
import com.tencent.avgame.util.AvGameConfBean;
import com.tencent.mobileqq.config.business.AvGameConfProcessor;
import com.tencent.mobileqq.config.business.AvGameConfProcessor.OnGetConfigListener;
import com.tencent.qphone.base.util.QLog;

class AvGameResDownloadManager$1
  implements AvGameConfProcessor.OnGetConfigListener
{
  AvGameResDownloadManager$1(AvGameResDownloadManager paramAvGameResDownloadManager) {}
  
  public void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AvGameResDownloadManager", 2, "onGetConfigFinished result:" + paramInt);
    }
    if (paramInt == 0)
    {
      String str1 = AvGameConfProcessor.a().a();
      String str2 = AvGameConfProcessor.a().b();
      if (QLog.isColorLevel()) {
        QLog.i("AvGameResDownloadManager", 2, "onGetConfigFinished url:" + str1 + " md5:" + str2);
      }
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        AvGameResDownloadManager.a(this.a).b(110);
        return;
      }
      this.a.a(new AvGameResDownloadManager.ResInfo(str1, str2));
      return;
    }
    AvGameResDownloadManager.a(this.a).b(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.AvGameResDownloadManager.1
 * JD-Core Version:    0.7.0.1
 */