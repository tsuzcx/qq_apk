package com.tencent.comic.jsp;

import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

class QQComicJsPlugin$4
  implements Runnable
{
  QQComicJsPlugin$4(QQComicJsPlugin paramQQComicJsPlugin) {}
  
  public void run()
  {
    Object localObject = QQComicJsPlugin.c();
    if (localObject != null)
    {
      long l1 = System.currentTimeMillis();
      FileUtils.deleteFile(new File((String)localObject));
      long l2 = System.currentTimeMillis();
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("clean cache cost ");
        ((StringBuilder)localObject).append(l2 - l1);
        ((StringBuilder)localObject).append(" ms");
        QLog.d("QQComicJsPlugin", 2, ((StringBuilder)localObject).toString());
      }
    }
    QQComicJsPlugin.d().set(false);
    localObject = new JSONObject();
    try
    {
      ((JSONObject)localObject).put("result", 0);
      ((JSONObject)localObject).put("message", "ok");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("size", this.this$0.a());
      ((JSONObject)localObject).put("data", localJSONObject);
      label150:
      this.this$0.callJs(QQComicJsPlugin.e(), new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (Exception localException)
    {
      break label150;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.comic.jsp.QQComicJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */