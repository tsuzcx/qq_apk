package com.tencent.mobileqq.activity.qwallet.preload;

import android.os.Bundle;
import com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper.OnConvertListener;
import eipc.EIPCResult;

class QWalletIPCModule$4
  implements EmojiGifHelper.OnConvertListener
{
  QWalletIPCModule$4(QWalletIPCModule paramQWalletIPCModule, int paramInt) {}
  
  public void onConvertResult(boolean paramBoolean, String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("res", paramBoolean);
    localBundle.putString("path", paramString);
    this.jdField_a_of_type_ComTencentMobileqqActivityQwalletPreloadQWalletIPCModule.callbackResult(this.jdField_a_of_type_Int, EIPCResult.createSuccessResult(localBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.preload.QWalletIPCModule.4
 * JD-Core Version:    0.7.0.1
 */