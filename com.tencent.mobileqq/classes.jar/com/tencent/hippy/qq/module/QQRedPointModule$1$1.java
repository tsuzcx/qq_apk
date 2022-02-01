package com.tencent.hippy.qq.module;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mtt.hippy.modules.Promise;
import java.util.HashMap;

class QQRedPointModule$1$1
  implements Runnable
{
  QQRedPointModule$1$1(QQRedPointModule.1 param1, HashMap paramHashMap) {}
  
  public void run()
  {
    Object localObject = this.this$1.val$promise.getCallId();
    Bundle localBundle = (Bundle)this.val$finalMapResult.get("req");
    String str = (String)this.val$finalMapResult.get("jsonResult");
    this.this$1.val$promise.resolve(str);
    localObject = DataFactory.a("redTouch_getAppInfo_report", (String)localObject, this.this$1.this$0.mOnRemoteResp.key, localBundle);
    this.this$1.this$0.sendRemoteReq((Bundle)localObject, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hippy.qq.module.QQRedPointModule.1.1
 * JD-Core Version:    0.7.0.1
 */