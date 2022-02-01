package com.tencent.mobileqq.apollo.process.data;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.apollo.api.IApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.CmGameUtil;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class CmGameOpenIdFinder$1
  implements EIPCResultCallback
{
  CmGameOpenIdFinder$1(String paramString, long paramLong) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    paramEIPCResult = paramEIPCResult.data;
    int i = paramEIPCResult.getInt("type");
    if (i == 1)
    {
      paramEIPCResult = paramEIPCResult.getString("nickName");
      CmGameUtil.a().callbackGetNick(paramEIPCResult, this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_Long);
    }
    while (i != 2) {
      return;
    }
    paramEIPCResult = (Bitmap)paramEIPCResult.getParcelable("head");
    CmGameUtil.a().callbackGetHead(paramEIPCResult, this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.data.CmGameOpenIdFinder.1
 * JD-Core Version:    0.7.0.1
 */