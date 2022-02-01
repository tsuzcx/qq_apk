package com.tencent.biz.pubaccount.readinjoy.engine;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaInstance;
import org.json.JSONException;
import org.json.JSONObject;
import pmr;
import tlg;

public class ReadInJoyWebRenderEngine$2
  implements Runnable
{
  public void run()
  {
    try
    {
      JSONObject localJSONObject = tlg.a();
      if (localJSONObject != null)
      {
        if (!TextUtils.isEmpty(this.a)) {
          localJSONObject.put("param", this.a);
        }
        localJSONObject.put("url", this.b);
        pmr.a(this.this$0, false);
        pmr.a(this.this$0).render(this.c, localJSONObject.toString());
      }
      return;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("viola.ReadInJoyWebRenderEngine", 1, "onRender JSONException e" + localJSONException.getMessage() + "ms");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyWebRenderEngine.2
 * JD-Core Version:    0.7.0.1
 */