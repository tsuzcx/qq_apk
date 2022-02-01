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
    Object localObject = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.a.getCurrentAccountUin(), 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_display_time", ServiceAccountFolderManager.c(this.this$0));
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_time", ServiceAccountFolderManager.a(this.this$0));
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_operation_time", ServiceAccountFolderManager.d(this.this$0));
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_brief", ServiceAccountFolderManager.a(this.this$0).toString());
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_extend", ServiceAccountFolderManager.b(this.this$0));
      ((SharedPreferences.Editor)localObject).putInt("service_account_folder_unreadnum", ServiceAccountFolderManager.a(this.this$0));
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_maxunreadtime", ServiceAccountFolderManager.e(this.this$0));
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "saveFolderLocalData->mFolderDisplayTime:" + ServiceAccountFolderManager.c(this.this$0) + ", mFolderShowTime:" + ServiceAccountFolderManager.a(this.this$0) + ", mFolderOperationTime:" + ServiceAccountFolderManager.d(this.this$0) + ", mFolderMsgBrief:" + ServiceAccountFolderManager.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.8
 * JD-Core Version:    0.7.0.1
 */