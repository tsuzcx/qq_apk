package com.tencent.mobileqq.apollo.process;

import amwf;
import ando;
import android.os.Bundle;
import com.tencent.mobileqq.apollo.sdk.IPCSpriteContext;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

public class CmGameServerQIPCModule$3
  implements Runnable
{
  public CmGameServerQIPCModule$3(amwf paramamwf, IPCSpriteContext paramIPCSpriteContext, int paramInt) {}
  
  public void run()
  {
    Object localObject = ando.a(this.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext);
    Bundle localBundle = new Bundle();
    localBundle.putParcelable("IPCSpriteContext", this.jdField_a_of_type_ComTencentMobileqqApolloSdkIPCSpriteContext);
    localBundle.putString("js_content", (String)localObject);
    localObject = EIPCResult.createSuccessResult(localBundle);
    this.this$0.callbackResult(this.jdField_a_of_type_Int, (EIPCResult)localObject);
    QLog.i("cmgame_process.CmGameServerQIPCModule", 1, "CmShow_receive initAvatar ipc req");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.CmGameServerQIPCModule.3
 * JD-Core Version:    0.7.0.1
 */