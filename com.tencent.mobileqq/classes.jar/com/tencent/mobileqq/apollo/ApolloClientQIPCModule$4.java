package com.tencent.mobileqq.apollo;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.player.action.CMSAction;
import com.tencent.mobileqq.apollo.player.CMSActionStatus;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ApolloClientQIPCModule$4
  implements ICMSPlayerListener
{
  ApolloClientQIPCModule$4(ApolloClientQIPCModule paramApolloClientQIPCModule, int paramInt1, int paramInt2) {}
  
  public void a(@NotNull CMSAction paramCMSAction) {}
  
  public void a(@NotNull CMSAction paramCMSAction, int paramInt1, @NotNull byte[] paramArrayOfByte, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void a(@NotNull CMSAction paramCMSAction, @NotNull CMSActionStatus paramCMSActionStatus) {}
  
  public void a(@NotNull CMSAction paramCMSAction, boolean paramBoolean, @NotNull String paramString1, @Nullable String paramString2)
  {
    int i = 1;
    ApolloClientQIPCModule.b().remove(paramCMSAction);
    if (QLog.isColorLevel()) {
      QLog.i("cm_res", 1, "recordDynamicAvatar onRecordDone actionId:" + this.jdField_a_of_type_Int + " success:" + paramBoolean + " " + paramString2 + " key: " + paramString1 + " map size:" + ApolloClientQIPCModule.b().size());
    }
    paramCMSAction = new EIPCResult();
    if (paramBoolean) {
      i = 0;
    }
    paramCMSAction.code = i;
    paramCMSAction.data = new Bundle();
    paramCMSAction.data.putString("path", paramString2);
    paramCMSAction.data.putString("key", paramString1);
    this.jdField_a_of_type_ComTencentMobileqqApolloApolloClientQIPCModule.callbackResult(this.b, paramCMSAction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloClientQIPCModule.4
 * JD-Core Version:    0.7.0.1
 */