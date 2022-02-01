package com.tencent.hotpatch.config;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class NativePatchItemConfig
  extends AbscractPatchItemConfig
{
  private String d;
  private String e;
  private boolean f;
  
  public NativePatchItemConfig(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a = paramJSONObject.optString("patchName", null);
    this.b = paramJSONObject.optString("patchUrl", null);
    this.c = paramJSONObject.optInt("patchSize", 0);
    this.d = paramJSONObject.optString("driverVersion", null);
    this.e = paramJSONObject.optString("previousPatch", null);
    this.f = paramJSONObject.optBoolean("isDelayLoad", false);
  }
  
  public boolean a(String paramString)
  {
    if (TextUtils.isEmpty(this.d))
    {
      QLog.d("PatchLogTag", 1, "NativePatchItemConfig isValidConfig driverVersion is null");
      return false;
    }
    return super.a(paramString);
  }
  
  public String b()
  {
    String str = super.b();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("patchName", this.a);
      ((JSONObject)localObject).put("patchUrl", this.b);
      ((JSONObject)localObject).put("patchSize", this.c);
      ((JSONObject)localObject).put("driverVersion", this.d);
      ((JSONObject)localObject).put("previousPatch", this.e);
      ((JSONObject)localObject).put("isDelayLoad", this.f);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "NativePatchItemConfig writeToJsonString", localJSONException);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hotpatch.config.NativePatchItemConfig
 * JD-Core Version:    0.7.0.1
 */