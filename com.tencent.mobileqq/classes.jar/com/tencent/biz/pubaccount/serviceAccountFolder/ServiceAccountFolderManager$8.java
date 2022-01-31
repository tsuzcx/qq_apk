package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import ssp;

public class ServiceAccountFolderManager$8
  implements Runnable
{
  public ServiceAccountFolderManager$8(ssp paramssp, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.a.getCurrentAccountUin(), 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_display_time", ssp.c(this.this$0));
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_time", ssp.a(this.this$0));
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_operation_time", ssp.d(this.this$0));
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_brief", ssp.a(this.this$0).toString());
      ((SharedPreferences.Editor)localObject).putString("service_account_folder_extend", ssp.b(this.this$0));
      ((SharedPreferences.Editor)localObject).putInt("service_account_folder_unreadnum", ssp.a(this.this$0));
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_maxunreadtime", ssp.e(this.this$0));
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "saveFolderLocalData->mFolderDisplayTime:" + ssp.c(this.this$0) + ", mFolderShowTime:" + ssp.a(this.this$0) + ", mFolderOperationTime:" + ssp.d(this.this$0) + ", mFolderMsgBrief:" + ssp.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.8
 * JD-Core Version:    0.7.0.1
 */