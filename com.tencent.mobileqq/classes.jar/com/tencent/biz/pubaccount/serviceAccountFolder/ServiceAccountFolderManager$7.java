package com.tencent.biz.pubaccount.serviceAccountFolder;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import saz;

public class ServiceAccountFolderManager$7
  implements Runnable
{
  public ServiceAccountFolderManager$7(saz paramsaz, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Object localObject = BaseApplication.getContext().getSharedPreferences("sp_public_account_with_cuin_" + this.a.getCurrentAccountUin(), 0);
    if (localObject != null)
    {
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_last_read_time", saz.b(this.this$0));
      ((SharedPreferences.Editor)localObject).putLong("service_account_folder_last_enter_time", saz.a(this.this$0));
      ((SharedPreferences.Editor)localObject).commit();
      if (QLog.isColorLevel()) {
        QLog.d("ServiceAccountFolderManager", 2, "setFolderLastReadTime->mFolderLastReadTime:" + saz.b(this.this$0) + ", mFolderLastEnterTime:" + saz.a(this.this$0));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.7
 * JD-Core Version:    0.7.0.1
 */