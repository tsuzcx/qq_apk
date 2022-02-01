package com.tencent.imsdk.common;

import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMValueCallback;

class IMCallback$1
  implements Runnable
{
  IMCallback$1(IMCallback paramIMCallback, Object paramObject) {}
  
  public void run()
  {
    if (this.this$0.callback != null)
    {
      this.this$0.callback.onSuccess();
      return;
    }
    if (this.this$0.valueCallback != null) {
      this.this$0.valueCallback.onSuccess(this.val$data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.common.IMCallback.1
 * JD-Core Version:    0.7.0.1
 */