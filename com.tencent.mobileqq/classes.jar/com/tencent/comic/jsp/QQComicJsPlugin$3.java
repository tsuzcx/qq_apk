package com.tencent.comic.jsp;

import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.comic.utils.AppHelper;
import com.tencent.comic.utils.QQComicPluginBridge;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;
import org.json.JSONObject;

class QQComicJsPlugin$3
  implements Runnable
{
  QQComicJsPlugin$3(QQComicJsPlugin paramQQComicJsPlugin, long paramLong, String paramString1, JSONObject paramJSONObject, String paramString2) {}
  
  public void run()
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("waitPluginAndHandleJsCall start, isReady:");
      ((StringBuilder)localObject).append(QQComicPluginBridge.a);
      QLog.d("QQComicDebug", 2, ((StringBuilder)localObject).toString());
    }
    if (!QQComicPluginBridge.a)
    {
      QQComicPluginBridge.a(AppHelper.a(), false, null);
      for (long l = 0L; (!QQComicPluginBridge.a) && (l < this.jdField_a_of_type_Long); l += 50L) {
        SystemClock.sleep(50L);
      }
      if (QQComicPluginBridge.a) {
        QQComicPluginBridge.a(AppHelper.a());
      }
    }
    if (QQComicPluginBridge.a)
    {
      ThreadManager.getUIHandler().post(new QQComicJsPlugin.3.1(this));
    }
    else if (!TextUtils.isEmpty(this.b))
    {
      localObject = new JSONObject();
      try
      {
        ((JSONObject)localObject).put("code", 2001);
        ((JSONObject)localObject).put("message", "QQComic is not ready");
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      QQComicJsPlugin.b(this.this$0, this.b, new String[] { ((JSONObject)localObject).toString() });
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "waitPluginAndHandleJsCall end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.comic.jsp.QQComicJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */