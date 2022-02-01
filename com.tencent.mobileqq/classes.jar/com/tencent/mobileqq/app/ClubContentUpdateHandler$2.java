package com.tencent.mobileqq.app;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.ClubContentJsonTask;
import com.tencent.mobileqq.vas.ClubContentJsonTask.TaskInfo;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.MobileQQ;
import org.json.JSONObject;

class ClubContentUpdateHandler$2
  extends DownloadListener
{
  ClubContentUpdateHandler$2(ClubContentUpdateHandler paramClubContentUpdateHandler) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    paramDownloadTask = paramDownloadTask.a();
    if ((paramDownloadTask.containsKey("version")) && (paramDownloadTask.containsKey("json_name")))
    {
      int i = paramDownloadTask.getInt("version", -1);
      paramDownloadTask = paramDownloadTask.getString("json_name");
      if (ClubContentJsonTask.e.d.equals(paramDownloadTask))
      {
        Object localObject = new File(this.a.a.getApplication().getApplicationContext().getFilesDir(), ClubContentJsonTask.e.a);
        if ((((File)localObject).exists()) && (((File)localObject).isFile()))
        {
          localObject = FileUtils.a((File)localObject);
          try
          {
            localObject = new JSONObject((String)localObject);
            long l = ((JSONObject)localObject).getLong("timestamp") / 1000L;
            if (Math.abs(i - l) <= 5L)
            {
              ClubContentJsonTask.a(this.a.a.getApplication().getApplicationContext(), paramDownloadTask, i);
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update success!");
              }
              boolean bool1 = true;
              if (((JSONObject)localObject).has("enableX5Report"))
              {
                boolean bool2 = ((JSONObject)localObject).getBoolean("enableX5Report");
                bool1 = bool2;
                if (QLog.isColorLevel())
                {
                  QLog.i("ClubContentUpdateHandler", 2, "json file got isEnableX5Report: " + bool2);
                  bool1 = bool2;
                }
              }
              paramDownloadTask = this.a.a.getApplication().getApplicationContext().getSharedPreferences("WebView_X5_Report", 4);
              paramDownloadTask.edit().putBoolean("enableX5Report", bool1).commit();
              paramDownloadTask.edit().putLong("read_vas_asyncCookie", 0L).commit();
            }
            for (;;)
            {
              ClubContentUpdateHandler.a(this.a, (JSONObject)localObject);
              return;
              if (QLog.isColorLevel()) {
                QLog.i("ClubContentUpdateHandler", 2, "json file update get old file!");
              }
            }
            return;
          }
          catch (Exception paramDownloadTask)
          {
            if (QLog.isColorLevel()) {
              QLog.e("ClubContentUpdateHandler", 2, "Parse webview josn Exception:" + paramDownloadTask.toString());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.ClubContentUpdateHandler.2
 * JD-Core Version:    0.7.0.1
 */