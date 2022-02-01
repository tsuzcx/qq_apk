package com.tencent.mobileqq.apollo.view.pannel;

import com.tencent.mobileqq.apollo.request.ApolloRequestCallbackManager.ApolloRspCallback;
import com.tencent.qphone.base.util.QLog;
import org.jetbrains.annotations.Nullable;

class ApolloPanel$11
  implements ApolloRequestCallbackManager.ApolloRspCallback
{
  ApolloPanel$11(ApolloPanel paramApolloPanel, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, @Nullable String paramString)
  {
    QLog.i("ApolloPanel", 1, "onOpen cmshow apolloStatus " + this.jdField_a_of_type_Int + " succ " + paramBoolean + " retCode " + paramLong + " errMsg " + paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.view.pannel.ApolloPanel.11
 * JD-Core Version:    0.7.0.1
 */