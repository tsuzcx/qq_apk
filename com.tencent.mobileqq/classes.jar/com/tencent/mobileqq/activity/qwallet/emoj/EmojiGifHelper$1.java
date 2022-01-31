package com.tencent.mobileqq.activity.qwallet.emoj;

import android.os.Bundle;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;

final class EmojiGifHelper$1
  implements EIPCResultCallback
{
  EmojiGifHelper$1(EmojiGifHelper.OnConvertListener paramOnConvertListener) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    if ((paramEIPCResult != null) && (paramEIPCResult.isSuccess()) && (paramEIPCResult.data != null))
    {
      bool = paramEIPCResult.data.getBoolean("res", false);
      paramEIPCResult = paramEIPCResult.data.getString("path", "");
      if (this.val$l != null) {
        this.val$l.onConvertResult(bool, paramEIPCResult);
      }
    }
    while (this.val$l == null)
    {
      boolean bool;
      return;
    }
    this.val$l.onConvertResult(false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.emoj.EmojiGifHelper.1
 * JD-Core Version:    0.7.0.1
 */