package com.tencent.mobileqq.ark.image;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.ark.ArkAppCenter;
import com.tencent.mobileqq.ark.ArkAppSSO;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import mqq.app.AppRuntime;

class ChooseImageIPCModule$1
  implements Runnable
{
  ChooseImageIPCModule$1(ChooseImageIPCModule paramChooseImageIPCModule, AppRuntime paramAppRuntime, int paramInt, Bundle paramBundle) {}
  
  public void run()
  {
    String str = null;
    Object localObject = (ArkAppCenter)this.jdField_a_of_type_MqqAppAppRuntime.getManager(QQManagerFactory.ARK_APP_CENTER_MANAGER);
    if (localObject == null)
    {
      QLog.e("ArkApp.ChooseImageIPCModule", 1, "ArkMultiProc.callSendAppMsg  appCenter is null");
      localObject = new Bundle();
      ((Bundle)localObject).putInt("code", -1);
      localObject = EIPCResult.createResult(-102, (Bundle)localObject);
      this.this$0.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject);
      return;
    }
    ArkAppSSO localArkAppSSO = ((ArkAppCenter)localObject).a();
    if (localArkAppSSO == null)
    {
      QLog.e("ArkApp.ChooseImageIPCModule", 1, "ArkMultiProc.callSendAppMsg  sso is null");
      localObject = new Bundle();
      ((Bundle)localObject).putInt("code", -1);
      localObject = EIPCResult.createResult(-102, (Bundle)localObject);
      this.this$0.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject);
      return;
    }
    int i;
    if (this.jdField_a_of_type_AndroidOsBundle != null)
    {
      localObject = this.jdField_a_of_type_AndroidOsBundle.getString("cmd");
      if (this.jdField_a_of_type_AndroidOsBundle != null) {
        str = this.jdField_a_of_type_AndroidOsBundle.getString("msg");
      }
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        break label242;
      }
      i = this.jdField_a_of_type_AndroidOsBundle.getInt("timeOut");
      label170:
      if (this.jdField_a_of_type_AndroidOsBundle == null) {
        break label247;
      }
    }
    label242:
    label247:
    for (int j = this.jdField_a_of_type_AndroidOsBundle.getInt("notifyType");; j = 0)
    {
      QLog.d("ArkApp.ChooseImageIPCModule", 1, new Object[] { "ArkMultiProc.callSendAppMsg cmd=", localObject, ", msg=", str });
      localArkAppSSO.a((String)localObject, str, i, j, new ChooseImageIPCModule.1.1(this, (String)localObject));
      return;
      localObject = null;
      break;
      i = 0;
      break label170;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.image.ChooseImageIPCModule.1
 * JD-Core Version:    0.7.0.1
 */