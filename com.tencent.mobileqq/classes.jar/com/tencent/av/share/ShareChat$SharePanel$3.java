package com.tencent.av.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import lyh;

public class ShareChat$SharePanel$3
  extends ResultReceiver
{
  public ShareChat$SharePanel$3(lyh paramlyh, Handler paramHandler, long paramLong, int paramInt)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    QLog.w("ShareChat", 1, "shareToMobileQQ.onReceiveResult, resultCode[" + paramInt + "], seq[" + this.jdField_a_of_type_Long + "]");
    paramBundle = this.jdField_a_of_type_Lyh;
    int i = this.jdField_a_of_type_Int;
    if (paramInt == -1) {}
    for (paramInt = 2;; paramInt = 3)
    {
      paramBundle.a(0, i, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.3
 * JD-Core Version:    0.7.0.1
 */