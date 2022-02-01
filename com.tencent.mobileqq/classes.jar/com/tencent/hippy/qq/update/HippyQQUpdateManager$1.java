package com.tencent.hippy.qq.update;

import com.tencent.hippy.qq.update.sign.HippySign;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class HippyQQUpdateManager$1
  implements Runnable
{
  HippyQQUpdateManager$1(HippyQQUpdateManager paramHippyQQUpdateManager, JSONObject paramJSONObject, ReqCallBack paramReqCallBack) {}
  
  public void run()
  {
    String str = HippySign.getSign("mqq", "jV7Y5YGCkMY7lJt9B%@RkCDiXP8EjaFOjbQ4uytoy@JA3UNrV5YOoUFCdOz5cVLG");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("sign:");
    ((StringBuilder)localObject).append(str);
    QLog.i("MyUpdate", 1, ((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("req:");
    ((StringBuilder)localObject).append(this.val$req.toString());
    QLog.i("MyUpdate", 1, ((StringBuilder)localObject).toString());
    str = HttpClient.doPost("https://hippy.html5.qq.com/update", this.val$req.toString(), str, HippyQQUpdateManager.access$000(this.this$0));
    localObject = this.val$reqCallBack;
    if (localObject != null) {
      ((ReqCallBack)localObject).onResponse(str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.update.HippyQQUpdateManager.1
 * JD-Core Version:    0.7.0.1
 */