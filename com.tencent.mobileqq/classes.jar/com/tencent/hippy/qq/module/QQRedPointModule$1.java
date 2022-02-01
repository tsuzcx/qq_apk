package com.tencent.hippy.qq.module;

import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.redtouch.RedTouchWebviewHandler;
import com.tencent.mtt.hippy.modules.Promise;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

class QQRedPointModule$1
  implements Runnable
{
  QQRedPointModule$1(QQRedPointModule paramQQRedPointModule, String paramString, long paramLong, Promise paramPromise) {}
  
  public void run()
  {
    Object localObject = this.this$0.getActivity();
    if (!(localObject instanceof BaseActivity))
    {
      QLog.e("QQRedPointModule", 1, "getAppInfo activity isvnot BaseActivity");
      return;
    }
    BaseActivity localBaseActivity = (BaseActivity)localObject;
    for (localObject = null;; localObject = localHashMap)
    {
      try
      {
        if (!new JSONObject(this.val$param).has("pathList")) {
          break label86;
        }
        localHashMap = RedTouchWebviewHandler.parseGetAppInfoList(localBaseActivity.getAppInterface(), this.val$start, this.val$param);
        localObject = localHashMap;
      }
      catch (JSONException localJSONException)
      {
        HashMap localHashMap;
        label68:
        label86:
        break label68;
      }
      if (localObject == null) {
        break;
      }
      localBaseActivity.runOnUiThread(new QQRedPointModule.1.1(this, (HashMap)localObject));
      return;
      localHashMap = RedTouchWebviewHandler.parseGetAppInfo(localBaseActivity.getAppInterface(), this.val$start, this.val$param);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQRedPointModule.1
 * JD-Core Version:    0.7.0.1
 */