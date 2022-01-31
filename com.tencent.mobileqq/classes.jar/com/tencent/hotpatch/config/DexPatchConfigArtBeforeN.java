package com.tencent.hotpatch.config;

import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DexPatchConfigArtBeforeN
  extends BasePatchConfig
{
  public final String e = "dex";
  
  public DexPatchConfigArtBeforeN(String paramString)
  {
    a(paramString);
  }
  
  public String a()
  {
    String str = super.a();
    try
    {
      Object localObject = new JSONObject(str);
      ((JSONObject)localObject).put("patchType", "dex");
      ((JSONObject)localObject).put("patchName", this.c);
      ((JSONObject)localObject).put("patchUrl", this.d);
      ((JSONObject)localObject).put("patchSize", this.b);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "DexPatchConfigArtBeforeN writeToJsonString", localJSONException);
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
      this.b = paramString.optInt("patchSize", 0);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("PatchLogTag", 1, "DexPatchConfigArtBeforeN readFromJsonString", paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.config.DexPatchConfigArtBeforeN
 * JD-Core Version:    0.7.0.1
 */