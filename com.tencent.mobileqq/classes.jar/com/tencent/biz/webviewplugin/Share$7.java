package com.tencent.biz.webviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.open.appcommon.OpensdkBusinessObserver;
import com.tencent.protofile.getappinfo.GetAppInfoProto.GetAppinfoResponse;
import com.tencent.qphone.base.util.QLog;

class Share$7
  implements OpensdkBusinessObserver
{
  Share$7(Share paramShare) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (!paramBoolean) {
      return;
    }
    byte[] arrayOfByte = paramBundle.getByteArray("data");
    if (arrayOfByte == null) {
      return;
    }
    paramBundle = new GetAppInfoProto.GetAppinfoResponse();
    try
    {
      paramBundle.mergeFrom(arrayOfByte);
    }
    catch (InvalidProtocolBufferMicroException localInvalidProtocolBufferMicroException)
    {
      if (QLog.isColorLevel()) {
        QLog.d(Share.a, 2, localInvalidProtocolBufferMicroException.getMessage());
      }
    }
    ThreadManager.post(new Share.7.1(this, paramBundle), 5, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.webviewplugin.Share.7
 * JD-Core Version:    0.7.0.1
 */