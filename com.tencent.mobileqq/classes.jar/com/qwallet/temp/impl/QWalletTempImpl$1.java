package com.qwallet.temp.impl;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.tencent.mobileqq.microapp.sdk.OnUpdateListener;

class QWalletTempImpl$1
  implements OnUpdateListener
{
  QWalletTempImpl$1(QWalletTempImpl paramQWalletTempImpl, ResultReceiver paramResultReceiver) {}
  
  public void onCheckForUpdate(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action", 0);
      localBundle.putBoolean("res", paramBoolean);
      this.jdField_a_of_type_AndroidOsResultReceiver.send(0, localBundle);
    }
  }
  
  public void onUpdateSucc(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidOsResultReceiver != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("action", 1);
      localBundle.putBoolean("res", paramBoolean);
      this.jdField_a_of_type_AndroidOsResultReceiver.send(0, localBundle);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.qwallet.temp.impl.QWalletTempImpl.1
 * JD-Core Version:    0.7.0.1
 */