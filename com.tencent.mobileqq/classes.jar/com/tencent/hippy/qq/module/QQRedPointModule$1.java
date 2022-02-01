package com.tencent.hippy.qq.module;

import com.tencent.common.app.AppInterface;
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
    Object localObject1 = this.this$0.getActivity();
    if (!(localObject1 instanceof BaseActivity)) {
      QLog.e("QQRedPointModule", 1, "getAppInfo activity isvnot BaseActivity");
    }
    BaseActivity localBaseActivity;
    Object localObject2;
    do
    {
      return;
      localBaseActivity = (BaseActivity)localObject1;
      localObject2 = this.this$0.getAppInterface();
    } while (localObject2 == null);
    for (localObject1 = null;; localObject1 = localObject2)
    {
      try
      {
        if (!new JSONObject(this.val$param).has("pathList")) {
          break label95;
        }
        localObject2 = RedTouchWebviewHandler.parseGetAppInfoList((AppInterface)localObject2, this.val$start, this.val$param);
        localObject1 = localObject2;
      }
      catch (JSONException localJSONException)
      {
        label77:
        label95:
        break label77;
      }
      if (localObject1 == null) {
        break;
      }
      localBaseActivity.runOnUiThread(new QQRedPointModule.1.1(this, (HashMap)localObject1));
      return;
      localObject2 = RedTouchWebviewHandler.parseGetAppInfo((AppInterface)localObject2, this.val$start, this.val$param);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQRedPointModule.1
 * JD-Core Version:    0.7.0.1
 */