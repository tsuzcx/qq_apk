package com.tencent.hippy.qq.module;

import android.text.TextUtils;
import com.tencent.biz.common.offline.AsyncBack;
import com.tencent.biz.common.util.Util;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class QQOfflineModule$1
  implements AsyncBack
{
  QQOfflineModule$1(QQOfflineModule paramQQOfflineModule, JSONObject paramJSONObject, Promise paramPromise) {}
  
  public void loaded(String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        this.val$resultJSON.put("retcode", -1);
        this.val$resultJSON.put("msg", "error");
        QQOfflineModule.access$000(this.this$0, this.val$promise, this.val$resultJSON);
        return;
      }
      catch (JSONException paramString)
      {
        QLog.d("QQOfflineModule", 1, "OfflinePlugin, batchCheckUpdate, JSONException1 :" + paramString);
        return;
      }
    }
    try
    {
      this.val$resultJSON.put("retcode", 0);
      this.val$resultJSON.put("data", Util.a(paramString));
      return;
    }
    catch (Throwable paramString)
    {
      QLog.e("QQOfflineModule", 1, "OfflinePlugin, batchCheckUpdate,toJsStringException :" + paramString);
      try
      {
        this.val$resultJSON.put("retcode", -1);
        this.val$resultJSON.put("msg", "error");
        return;
      }
      catch (JSONException paramString)
      {
        for (;;)
        {
          QLog.e("QQOfflineModule", 1, paramString, new Object[0]);
        }
      }
    }
    finally
    {
      QQOfflineModule.access$000(this.this$0, this.val$promise, this.val$resultJSON);
    }
  }
  
  public void progress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQOfflineModule.1
 * JD-Core Version:    0.7.0.1
 */