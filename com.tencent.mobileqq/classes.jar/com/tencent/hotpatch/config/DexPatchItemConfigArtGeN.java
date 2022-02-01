package com.tencent.hotpatch.config;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DexPatchItemConfigArtGeN
  extends AbscractPatchItemConfig
{
  private int d;
  
  public DexPatchItemConfigArtGeN(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    super.a(paramJSONObject);
    this.a = paramJSONObject.optString("patchName", null);
    this.b = paramJSONObject.optString("patch7zUrl", null);
    this.c = paramJSONObject.optInt("patchSize", 0);
    this.d = paramJSONObject.optInt("patch7zSize", 0);
  }
  
  public boolean a(String paramString)
  {
    return super.a(paramString);
  }
  
  public String b()
  {
    String str = super.b();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("patchName", this.a);
      ((JSONObject)localObject).put("patch7zUrl", this.b);
      ((JSONObject)localObject).put("patchSize", this.c);
      ((JSONObject)localObject).put("patch7zSize", this.d);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "DexPatchItemConfigArtGeN writeToJsonString", localJSONException);
    }
    return str;
  }
  
  public int c()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hotpatch.config.DexPatchItemConfigArtGeN
 * JD-Core Version:    0.7.0.1
 */