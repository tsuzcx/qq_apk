package com.tencent.av.share;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;
import mbc;

public class ShareChat$SharePanel$1
  extends ResultReceiver
{
  public ShareChat$SharePanel$1(mbc parammbc, Handler paramHandler, long paramLong, int paramInt)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    QLog.w("ShareChat", 1, "shareToQzone.onReceiveResult, resultCode[" + paramInt + "], seq[" + this.jdField_a_of_type_Long + "]");
    paramBundle = this.jdField_a_of_type_Mbc;
    int i = this.jdField_a_of_type_Int;
    if (paramInt == -1) {}
    for (paramInt = 2;; paramInt = 3)
    {
      paramBundle.a(1, i, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.av.share.ShareChat.SharePanel.1
 * JD-Core Version:    0.7.0.1
 */