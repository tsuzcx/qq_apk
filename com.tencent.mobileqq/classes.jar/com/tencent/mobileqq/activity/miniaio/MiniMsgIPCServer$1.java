package com.tencent.mobileqq.activity.miniaio;

import android.os.Bundle;
import com.tencent.mobileqq.mini.api.IMiniCallback;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class MiniMsgIPCServer$1
  implements IMiniCallback
{
  MiniMsgIPCServer$1(MiniMsgIPCServer paramMiniMsgIPCServer, Bundle paramBundle, int paramInt) {}
  
  public void onCallbackResult(boolean paramBoolean, Bundle paramBundle)
  {
    EIPCResult localEIPCResult = new EIPCResult();
    if (paramBoolean)
    {
      paramBundle = paramBundle.getString("imageUrl", "").replaceFirst("https*://", "");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("doMiniShareUploadImage newImagePath: ");
      localStringBuilder.append(paramBundle);
      QLog.d("mini_msg_IPCServer", 1, localStringBuilder.toString());
      this.jdField_a_of_type_AndroidOsBundle.putString("preview", paramBundle);
    }
    localEIPCResult.data = this.jdField_a_of_type_AndroidOsBundle;
    this.jdField_a_of_type_ComTencentMobileqqActivityMiniaioMiniMsgIPCServer.callbackResult(this.jdField_a_of_type_Int, localEIPCResult);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.miniaio.MiniMsgIPCServer.1
 * JD-Core Version:    0.7.0.1
 */