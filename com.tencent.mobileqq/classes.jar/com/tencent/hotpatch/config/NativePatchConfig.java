package com.tencent.hotpatch.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class NativePatchConfig
  extends BasePatchConfig
{
  public boolean b;
  public final String e = "Native";
  public String f;
  public String g;
  
  public NativePatchConfig(String paramString)
  {
    a(paramString);
  }
  
  public String a()
  {
    String str = super.a();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("patchType", "Native");
      ((JSONObject)localObject).put("patchName", this.c);
      ((JSONObject)localObject).put("patchUrl", this.d);
      ((JSONObject)localObject).put("patchSize", this.jdField_b_of_type_Int);
      ((JSONObject)localObject).put("driverVersion", this.f);
      ((JSONObject)localObject).put("previousPatch", this.g);
      ((JSONObject)localObject).put("isDelayLoad", this.jdField_b_of_type_Boolean);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "NativePatchConfig writeToJsonString", localJSONException);
    }
    return str;
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      this.c = paramString.optString("patchName", null);
      this.d = paramString.optString("patchUrl", null);
      this.jdField_b_of_type_Int = paramString.optInt("patchSize", 0);
      this.f = paramString.optString("driverVersion", null);
      this.g = paramString.optString("previousPatch", null);
      this.jdField_b_of_type_Boolean = paramString.optBoolean("previousPatch", false);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("PatchLogTag", 1, "NativePatchConfig readFromJsonString", paramString);
    }
  }
  
  public boolean a(Context paramContext, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(this.f))
    {
      QLog.d("PatchLogTag", 1, "NativePatchConfig isValidConfig driverVersion is null");
      return false;
    }
    return super.a(paramContext, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.config.NativePatchConfig
 * JD-Core Version:    0.7.0.1
 */