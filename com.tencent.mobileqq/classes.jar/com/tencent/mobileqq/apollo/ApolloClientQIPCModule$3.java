package com.tencent.mobileqq.apollo;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.GetFrameCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ApolloClientQIPCModule$3
  implements GetFrameCallback
{
  ApolloClientQIPCModule$3(ApolloClientQIPCModule paramApolloClientQIPCModule, int paramInt1, int paramInt2) {}
  
  public void a(boolean paramBoolean, @Nullable String paramString, @NotNull CMSAction paramCMSAction)
  {
    int i = 1;
    ApolloClientQIPCModule.a().remove(paramCMSAction);
    if (QLog.isColorLevel()) {
      QLog.i("cm_res", 1, "recordStaticAvatar onRecordDone actionId:" + this.jdField_a_of_type_Int + " success:" + paramBoolean + " " + paramString + " key: " + paramCMSAction.a(null, null) + " map size:" + ApolloClientQIPCModule.a().size());
    }
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramBoolean) {
      i = 0;
    }
    localEIPCResult.code = i;
    localEIPCResult.data = new Bundle();
    localEIPCResult.data.putString("path", paramString);
    localEIPCResult.data.putString("key", paramCMSAction.a(null, null));
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloClientQIPCModule.callbackResult(this.b, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloClientQIPCModule.3
 * JD-Core Version:    0.7.0.1
 */