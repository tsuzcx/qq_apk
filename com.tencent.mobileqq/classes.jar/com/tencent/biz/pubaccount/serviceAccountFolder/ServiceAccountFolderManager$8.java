package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

class ServiceAccountFolderManager$8
  implements Runnable
{
  ServiceAccountFolderManager$8(ServiceAccountFolderManager paramServiceAccountFolderManager, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("sp_public_account_with_cuin_");
    localStringBuilder.append(this.a.getCurrentAccountUin());
    localObject = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_display_time", ServiceAccountFolderManager.d(this.this$0));
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_time", ServiceAccountFolderManager.e(this.this$0));
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_operation_time", ServiceAccountFolderManager.f(this.this$0));
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_brief", ServiceAccountFolderManager.g(this.this$0).toString());
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_extend", ServiceAccountFolderManager.h(this.this$0));
      ((SharedPreferences.Editor)localObject).putInt("service_account_folder_unreadnum", ServiceAccountFolderManager.i(this.this$0));
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_maxunreadtime", ServiceAccountFolderManager.j(this.this$0));
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("saveFolderLocalData->mFolderDisplayTime:");
        ((StringBuilder)localObject).append(ServiceAccountFolderManager.d(this.this$0));
        ((StringBuilder)localObject).append(", mFolderShowTime:");
        ((StringBuilder)localObject).append(ServiceAccountFolderManager.e(this.this$0));
        ((StringBuilder)localObject).append(", mFolderOperationTime:");
        ((StringBuilder)localObject).append(ServiceAccountFolderManager.f(this.this$0));
        ((StringBuilder)localObject).append(", mFolderMsgBrief:");
        ((StringBuilder)localObject).append(ServiceAccountFolderManager.g(this.this$0));
        QLog.d("ServiceAccountFolderManager", 2, ((StringBuilder)localObject).toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.8
 * JD-Core Version:    0.7.0.1
 */