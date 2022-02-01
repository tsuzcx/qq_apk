package com.tencent.mobileqq.activity.recent;

import android.os.Message;
import com.tencent.mobileqq.applets.AppletsObserver;
import com.tencent.mobileqq.applets.data.AppletsAccountInfo;
import com.tencent.mobileqq.utils.CustomHandler;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AppletsFolderManager$1
  extends AppletsObserver
{
  AppletsFolderManager$1(AppletsFolderManager paramAppletsFolderManager) {}
  
  public void onGetAppletsDetail(boolean paramBoolean, List<AppletsAccountInfo> paramList)
  {
    if ((paramBoolean) && (paramList != null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("AppletsObserver", 2, "onGetAppletsDetail:  isSuccess: " + paramBoolean + ", data.size = " + paramList.size());
      }
      AppletsFolderManager.a(this.a).obtainMessage(2, 0, 0, paramList).sendToTarget();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.AppletsFolderManager.1
 * JD-Core Version:    0.7.0.1
 */