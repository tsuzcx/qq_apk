package com.tencent.hippy.qq.app;

import android.text.TextUtils;
import com.tencent.mtt.hippy.utils.LogUtils;

class HippyQQEngine$1$1
  implements Runnable
{
  HippyQQEngine$1$1(HippyQQEngine.1 param1, int paramInt, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str;
    if (this.val$result == 0) {
      if ((!TextUtils.isEmpty(this.val$filePath)) && (HippyQQEngine.access$000(this.this$1.this$0) <= 0))
      {
        str = this.val$filePath + "/" + "index.android.jsbundle";
        HippyQQEngine.access$100(this.this$1.this$0, str);
      }
    }
    do
    {
      return;
      str = "check package update error: " + this.val$msg;
      LogUtils.e("hippy", str);
    } while ((HippyQQEngine.access$000(this.this$1.this$0) > 0) || (HippyQQEngine.access$200(this.this$1.this$0) == null));
    HippyQQEngine.access$200(this.this$1.this$0).onError(this.val$result, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.app.HippyQQEngine.1.1
 * JD-Core Version:    0.7.0.1
 */