package com.tencent.mobileqq.activity.aio.photo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.mobileqq.richmedia.RichmediaService;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class PhotoListPanelUtils
{
  protected static boolean a(Intent paramIntent)
  {
    return RichmediaService.a(paramIntent);
  }
  
  protected static boolean a(boolean paramBoolean, int paramInt, Intent paramIntent)
  {
    int i = 0;
    if (paramBoolean)
    {
      if (paramInt == 2)
      {
        paramIntent = BaseApplication.getContext();
        paramInt = i;
        if (Build.VERSION.SDK_INT > 10) {
          paramInt = 4;
        }
        paramIntent = paramIntent.getSharedPreferences("presend_config_sp", paramInt);
        if ((paramIntent != null) && (paramIntent.edit() != null))
        {
          paramIntent.edit().putBoolean("key_presend_off_flag", true).commit();
          paramIntent.edit().putLong("key_presend_off_time", System.currentTimeMillis()).commit();
        }
        return true;
      }
      if (a(paramIntent))
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy,  addPresendMgrHandlerToIntent OK");
        }
        return true;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy,  addPresendMgrHandlerToIntent failed");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoListPanel", 2, "sendMedias,start sendPhotoAcitivy, not presend");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.PhotoListPanelUtils
 * JD-Core Version:    0.7.0.1
 */