package com.tencent.av;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.List;

public class VideoUtils
{
  public static final String a = AppConstants.aJ + "av_image_data/";
  
  public static final boolean a()
  {
    for (;;)
    {
      int j;
      try
      {
        boolean bool = LocalMultiProcConfig.getBool("is_qzone_live_launch", false);
        QLog.d("VideoUtils", 1, "isQzoneLiveExist, isRunning=" + bool);
        if (!bool) {
          return false;
        }
        int i = -2;
        List localList = ((ActivityManager)BaseApplicationImpl.getContext().getSystemService("activity")).getRunningAppProcesses();
        if (localList != null)
        {
          j = 0;
          if (j < localList.size())
          {
            if ("com.tencent.mobileqq:qzonelive".equals(((ActivityManager.RunningAppProcessInfo)localList.get(j)).processName))
            {
              i = ((ActivityManager.RunningAppProcessInfo)localList.get(j)).pid;
              break label184;
            }
          }
          else
          {
            j = LocalMultiProcConfig.getInt("qzone_live_process_id", -1);
            QLog.d("VideoUtils", 1, "isQzoneLiveExist, processId=" + i + ", id=" + j);
            if (i == j)
            {
              bool = true;
              return bool;
            }
            bool = false;
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        QLog.e("VideoUtils", 1, localException, new Object[0]);
        return false;
      }
      return false;
      label184:
      j += 1;
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2)
  {
    return (paramInt2 == 2) || (paramInt2 == 3) || (paramInt1 == 25) || (paramInt1 == 26);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.VideoUtils
 * JD-Core Version:    0.7.0.1
 */