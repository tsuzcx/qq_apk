package com.tencent.mobileqq.ark.api.scheme;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.ark.module.SchemeHandler;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.TranslucentActivity;
import org.json.JSONObject;

public class QzoneSchemeHandler
  implements SchemeHandler
{
  public boolean a(String paramString1, String paramString2, JSONObject paramJSONObject, long paramLong, String paramString3)
  {
    if (paramLong != 0L) {
      return false;
    }
    paramJSONObject = BaseActivity.sTopActivity;
    if (paramJSONObject == null) {
      return false;
    }
    paramString3 = new Intent(paramJSONObject, TranslucentActivity.class);
    paramString3.addFlags(268435456);
    QzonePluginProxyActivity.setActivityNameToIntent(paramString3, "com.qzone.misc.web.QZoneTranslucentActivity");
    paramString3.setAction("action_js2qzone");
    paramString3.putExtra("cmd", "Schema");
    paramString2 = paramString1;
    if (paramString1.startsWith("arouse/detailbyurl?base64url"))
    {
      paramString2 = paramString1;
      if (!paramString1.contains("from"))
      {
        paramString2 = new StringBuilder();
        paramString2.append(paramString1);
        paramString2.append("&from=aio");
        paramString2 = paramString2.toString();
      }
    }
    paramString1 = new StringBuilder();
    paramString1.append("mqzone://");
    paramString1.append(paramString2);
    paramString3.putExtra("schema", paramString1.toString());
    paramString3.putExtra("from", 2);
    paramJSONObject.startActivity(paramString3);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ark.api.scheme.QzoneSchemeHandler
 * JD-Core Version:    0.7.0.1
 */