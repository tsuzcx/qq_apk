package com.tencent.av.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import lyh;

public class ShareChat$SharePanel$5
  extends ResultReceiver
{
  public ShareChat$SharePanel$5(lyh paramlyh, Handler paramHandler, long paramLong, int paramInt)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    QLog.w("ShareChat", 1, "startTroop2DCode.PARAM_ActivityResultReceiver, resultCode[" + paramInt + "], seq[" + this.jdField_a_of_type_Long + "]");
    this.jdField_a_of_type_Lyh.a(5, this.jdField_a_of_type_Int, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.5
 * JD-Core Version:    0.7.0.1
 */