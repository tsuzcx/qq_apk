package com.tencent.hotpatch.config;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DexPatchItemConfigArtLM
  extends AbscractPatchItemConfig
{
  public DexPatchItemConfigArtLM(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a = paramJSONObject.optString("patchName", null);
    this.b = paramJSONObject.optString("patchUrl", null);
    this.c = paramJSONObject.optInt("patchSize", 0);
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
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "DexPatchItemConfigArtLM writeToJsonString", localJSONException);
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hotpatch.config.DexPatchItemConfigArtLM
 * JD-Core Version:    0.7.0.1
 */