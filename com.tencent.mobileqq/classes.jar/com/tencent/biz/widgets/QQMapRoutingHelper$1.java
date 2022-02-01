package com.tencent.biz.widgets;

import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import org.json.JSONObject;

class QQMapRoutingHelper$1
  implements HttpWebCgiAsyncTask.Callback
{
  QQMapRoutingHelper$1(QQMapRoutingHelper paramQQMapRoutingHelper) {}
  
  public void a(JSONObject paramJSONObject, int paramInt, Bundle paramBundle)
  {
    this.a.a.post(new QQMapRoutingHelper.1.1(this, paramJSONObject, paramBundle));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.widgets.QQMapRoutingHelper.1
 * JD-Core Version:    0.7.0.1
 */