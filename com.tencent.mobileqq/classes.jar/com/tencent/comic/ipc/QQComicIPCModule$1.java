package com.tencent.comic.ipc;

import android.os.Bundle;
import com.tencent.comic.hippy.BoodoHippyBirdge.ICheckPluginListener;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;

class QQComicIPCModule$1
  implements BoodoHippyBirdge.ICheckPluginListener
{
  QQComicIPCModule$1(QQComicIPCModule paramQQComicIPCModule, int paramInt) {}
  
  public void onResult(int paramInt, String paramString)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("checkPluginInstall onResult retCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" msg:");
    ((StringBuilder)localObject).append(paramString);
    QLog.i("QQComicIPCModule", 1, ((StringBuilder)localObject).toString());
    localObject = new Bundle();
    ((Bundle)localObject).putInt("retCode", paramInt);
    ((Bundle)localObject).putString("msg", paramString);
    paramString = EIPCResult.createSuccessResult((Bundle)localObject);
    this.jdField_a_of_type_ComTencentComicIpcQQComicIPCModule.callbackResult(this.jdField_a_of_type_Int, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.ipc.QQComicIPCModule.1
 * JD-Core Version:    0.7.0.1
 */