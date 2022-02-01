package com.tencent.hippy.qq.module;

import android.app.Activity;
import com.tencent.mobileqq.jsp.UiApiPlugin;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

class QQUiModule$4
  implements Runnable
{
  QQUiModule$4(QQUiModule paramQQUiModule, Promise paramPromise, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Activity localActivity = this.this$0.getActivity();
    if ((localActivity != null) && (!localActivity.isFinishing()))
    {
      QQUiModule.4.1 local1 = new QQUiModule.4.1(this);
      QQUiModule.4.2 local2 = new QQUiModule.4.2(this);
      UiApiPlugin.a(localActivity, this.val$json, local1, local1, local2);
      return;
    }
    QLog.e("QQUiModule", 1, "showDialog activity is finish");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQUiModule.4
 * JD-Core Version:    0.7.0.1
 */