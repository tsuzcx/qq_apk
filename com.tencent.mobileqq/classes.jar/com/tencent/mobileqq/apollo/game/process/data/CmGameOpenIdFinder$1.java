package com.tencent.mobileqq.apollo.game.process.data;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
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
      ApolloCmdChannel.getInstance().callbackGetNick(paramEIPCResult, this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_Long);
      return;
    }
    if (i == 2)
    {
      paramEIPCResult = (Bitmap)paramEIPCResult.getParcelable("head");
      ApolloCmdChannel.getInstance().callbackGetHead(paramEIPCResult, this.jdField_a_of_type_JavaLangString, i, this.jdField_a_of_type_Long);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.process.data.CmGameOpenIdFinder.1
 * JD-Core Version:    0.7.0.1
 */