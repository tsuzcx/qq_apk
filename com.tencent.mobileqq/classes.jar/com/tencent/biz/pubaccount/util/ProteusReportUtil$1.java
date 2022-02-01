package com.tencent.biz.pubaccount.util;

import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;

public final class ProteusReportUtil$1
  implements Runnable
{
  public ProteusReportUtil$1(JSONArray paramJSONArray) {}
  
  public void run()
  {
    int i = 0;
    for (;;)
    {
      if (i < this.a.length()) {
        try
        {
          localObject1 = this.a.get(i);
          if ((localObject1 instanceof String))
          {
            localObject1 = (String)localObject1;
            if (TextUtils.isEmpty((CharSequence)localObject1)) {}
          }
        }
        catch (JSONException localJSONException)
        {
          try
          {
            Object localObject1;
            HttpUtil.openUrl(BaseActivity.sTopActivity, (String)localObject1, "GET", null, null);
            i += 1;
            continue;
            localJSONException = localJSONException;
            localJSONException.printStackTrace();
            Object localObject2 = null;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("ProteusReportUtil", 1, "UG report error" + localException.getMessage());
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ProteusReportUtil.1
 * JD-Core Version:    0.7.0.1
 */