package com.tencent.mobileqq.ark.debug;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.ark.share.IArkMessagePreprocessorCallback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ArkAsyncShareMiniAppTest$1$1
  implements Runnable
{
  ArkAsyncShareMiniAppTest$1$1(ArkAsyncShareMiniAppTest.1 param1, JSONObject paramJSONObject, IArkMessagePreprocessorCallback paramIArkMessagePreprocessorCallback, Object paramObject) {}
  
  public void run()
  {
    if ((this.a != null) && (this.b != null))
    {
      Object localObject1 = this.c;
      if ((localObject1 != null) && ((localObject1 instanceof Bundle)))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.process engine res =", "test" });
        }
        boolean bool;
        try
        {
          long l = ((Bundle)this.c).getLong("key_process_message_uniseq");
          if (!TextUtils.isEmpty("test"))
          {
            JSONObject localJSONObject = new JSONObject(this.a.getString("forward_ark_app_meta"));
            Object localObject2 = localJSONObject.optJSONObject("intro");
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = localJSONObject.optJSONObject("detail");
            }
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("uniseq=");
            ((StringBuilder)localObject2).append(String.valueOf(l));
            ((StringBuilder)localObject2).append(", 更新metaData接口测试,测试更新meta中的desc");
            ((JSONObject)localObject1).put("desc", ((StringBuilder)localObject2).toString());
            this.a.put("forward_ark_app_meta", localJSONObject.toString());
            bool = true;
          }
        }
        catch (JSONException localJSONException)
        {
          QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, "AAShare.mArkMessagePreprocessor process e =", localJSONException);
          bool = false;
        }
        QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.process isProcessed=", Boolean.valueOf(bool), ", msgJson=", this.a.toString() });
        IArkMessagePreprocessorCallback localIArkMessagePreprocessorCallback = this.b;
        if (localIArkMessagePreprocessorCallback != null) {
          localIArkMessagePreprocessorCallback.a(bool, this.a, this.c);
        }
        return;
      }
    }
    QLog.e("ArkApp.ArkAsyncShareMiniAppTest", 2, new Object[] { "AAShare.process return callback=", this.b });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ark.debug.ArkAsyncShareMiniAppTest.1.1
 * JD-Core Version:    0.7.0.1
 */