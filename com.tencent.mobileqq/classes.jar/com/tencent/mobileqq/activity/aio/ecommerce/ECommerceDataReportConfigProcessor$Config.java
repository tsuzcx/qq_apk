package com.tencent.mobileqq.activity.aio.ecommerce;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

public final class ECommerceDataReportConfigProcessor$Config
{
  public HashMap<String, String> a = new HashMap();
  
  private void a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Object localObject;
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("configText : ");
        ((StringBuilder)localObject).append(paramString);
        QLog.d("ECommerceDataReportConfigProcessor", 2, ((StringBuilder)localObject).toString());
      }
      try
      {
        paramString = new JSONObject(paramString);
        localObject = paramString.keys();
        while (((Iterator)localObject).hasNext())
        {
          String str1 = (String)((Iterator)localObject).next();
          if (!TextUtils.isEmpty(str1))
          {
            String str2 = paramString.optString(str1, "");
            if (!TextUtils.isEmpty(str2)) {
              this.a.put(str1, str2);
            }
          }
        }
        return;
      }
      catch (Throwable paramString)
      {
        QLog.e("ECommerceDataReportConfigProcessor", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.ecommerce.ECommerceDataReportConfigProcessor.Config
 * JD-Core Version:    0.7.0.1
 */