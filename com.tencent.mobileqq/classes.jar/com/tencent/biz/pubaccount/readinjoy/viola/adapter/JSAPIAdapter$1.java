package com.tencent.biz.pubaccount.readinjoy.viola.adapter;

import android.app.Application;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaEnvironment;
import org.json.JSONException;
import org.json.JSONObject;
import tmc;

public class JSAPIAdapter$1
  implements Runnable
{
  public JSAPIAdapter$1(tmc paramtmc, JSONObject paramJSONObject) {}
  
  public void run()
  {
    Application localApplication = ViolaEnvironment.getApplication();
    if (localApplication == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          if (this.a.has("url"))
          {
            String str = (String)this.a.get("url");
            if (!TextUtils.isEmpty(str))
            {
              tmc.a(localApplication.getApplicationContext(), str, null);
              return;
            }
          }
        }
        catch (JSONException localJSONException) {}
      }
    } while (!QLog.isColorLevel());
    QLog.e("JSAPIAdapter", 2, "METHOD_OPEN_URL JSONException" + localJSONException.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.adapter.JSAPIAdapter.1
 * JD-Core Version:    0.7.0.1
 */