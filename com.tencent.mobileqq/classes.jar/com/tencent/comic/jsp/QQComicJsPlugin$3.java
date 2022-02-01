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
    boolean bool2 = QQComicPluginBridge.a;
    long l2 = 0L;
    boolean bool1 = false;
    long l1;
    if (!bool2)
    {
      QQComicPluginBridge.a(AppHelper.b(), false, null);
      for (l1 = 0L; (!QQComicPluginBridge.a) && (l1 < this.a); l1 += 50L) {
        SystemClock.sleep(50L);
      }
      if (QQComicPluginBridge.a) {
        QQComicPluginBridge.a(AppHelper.a());
      }
    }
    if (QQComicPluginBridge.a)
    {
      for (l1 = l2; (QQComicPluginBridge.b == null) && (l1 < 500L); l1 += 50L) {
        SystemClock.sleep(50L);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("waitPluginAndHandleJsCall calljs, jsready:");
        if (QQComicPluginBridge.b != null) {
          bool1 = true;
        }
        ((StringBuilder)localObject).append(bool1);
        QLog.d("QQComicDebug", 2, ((StringBuilder)localObject).toString());
      }
      ThreadManager.getUIHandler().post(new QQComicJsPlugin.3.1(this));
    }
    else if (!TextUtils.isEmpty(this.d))
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
      QQComicJsPlugin.b(this.this$0, this.d, new String[] { ((JSONObject)localObject).toString() });
    }
    if (QLog.isColorLevel()) {
      QLog.d("QQComicDebug", 2, "waitPluginAndHandleJsCall end");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.jsp.QQComicJsPlugin.3
 * JD-Core Version:    0.7.0.1
 */