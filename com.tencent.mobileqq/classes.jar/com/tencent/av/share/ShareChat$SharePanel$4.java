package com.tencent.av.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import lyh;
import lym;

public class ShareChat$SharePanel$4
  extends ResultReceiver
{
  public ShareChat$SharePanel$4(lyh paramlyh, Handler paramHandler, long paramLong, int paramInt)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    QLog.w("ShareChat", 1, "startTroop2DCode.PARAM_QRForwardReceiver, resultCode[" + paramInt + "], seq[" + this.jdField_a_of_type_Long + "], mIHandle[" + this.jdField_a_of_type_Lyh.a + "]");
    int i;
    if (this.jdField_a_of_type_Lyh.a != null)
    {
      paramBundle = this.jdField_a_of_type_Lyh.a;
      i = this.jdField_a_of_type_Int;
      if (paramInt != -1) {
        break label97;
      }
    }
    label97:
    for (paramInt = 2;; paramInt = 3)
    {
      paramBundle.b(5, i, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.4
 * JD-Core Version:    0.7.0.1
 */