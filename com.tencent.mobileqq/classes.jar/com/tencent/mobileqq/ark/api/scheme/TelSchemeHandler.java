package com.tencent.mobileqq.ark.api.scheme;

import android.text.TextUtils;
import com.tencent.mobileqq.ark.api.IArkThreadManager;
import com.tencent.mobileqq.ark.module.SchemeHandler;
import com.tencent.mobileqq.qroute.QRoute;
import org.json.JSONObject;

public class TelSchemeHandler
  implements SchemeHandler
{
  protected void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).postToMainThread(new TelSchemeHandler.1(this, paramString));
  }
  
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    ((IArkThreadManager)QRoute.api(IArkThreadManager.class)).sendToAppThread(paramString3, new TelSchemeHandler.2(this, paramString3, paramString1, paramLong, paramString2));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.TelSchemeHandler
 * JD-Core Version:    0.7.0.1
 */