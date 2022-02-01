package com.tencent.imsdk.common;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMValueCallback;

class IMCallback$2
  implements Runnable
{
  IMCallback$2(IMCallback paramIMCallback, int paramInt, String paramString) {}
  
  public void run()
  {
    if (this.this$0.callback != null)
    {
      this.this$0.callback.onError(this.val$code, this.val$errorMessage);
      return;
    }
    if (this.this$0.valueCallback != null) {
      this.this$0.valueCallback.onError(this.val$code, this.val$errorMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.IMCallback.2
 * JD-Core Version:    0.7.0.1
 */