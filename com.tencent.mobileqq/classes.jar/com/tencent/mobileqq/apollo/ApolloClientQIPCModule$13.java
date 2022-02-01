package com.tencent.mobileqq.apollo;

import android.os.Bundle;
import com.tencent.mobileqq.apollo.player.ICMSRecordCallback;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class ApolloClientQIPCModule$13
  implements EIPCResultCallback
{
  ApolloClientQIPCModule$13(ICMSRecordCallback paramICMSRecordCallback, int paramInt) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    String str1 = paramEIPCResult.data.getString("path");
    String str2 = paramEIPCResult.data.getString("key");
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSRecordCallback.a(paramEIPCResult.isSuccess(), str1, str2, this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloClientQIPCModule.13
 * JD-Core Version:    0.7.0.1
 */