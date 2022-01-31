package com.tencent.hotpatch.config;

import android.content.Context;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class DexPatchConfigArtAfterN
  extends BasePatchConfig
{
  public int c;
  public final String e = "dex";
  
  public DexPatchConfigArtAfterN(String paramString)
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
      ((JSONObject)localObject).put("patchName", this.jdField_c_of_type_JavaLangString);
      ((JSONObject)localObject).put("patchUrlAfterN", this.d);
      ((JSONObject)localObject).put("patchSizeAfterN", this.b);
      ((JSONObject)localObject).put("patch7zSizeAfterN", this.jdField_c_of_type_Int);
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      QLog.d("PatchLogTag", 1, "DexPatchConfigArtAfterN writeToJsonString", localJSONException);
    }
    return str;
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_c_of_type_JavaLangString = paramString.optString("patchName", null);
      this.d = paramString.optString("patchUrlAfterN", null);
      this.b = paramString.optInt("patchSizeAfterN", 0);
      this.jdField_c_of_type_Int = paramString.optInt("patch7zSizeAfterN", 0);
      return;
    }
    catch (JSONException paramString)
    {
      QLog.d("PatchLogTag", 1, "DexPatchConfigArtAfterN readFromJsonString", paramString);
    }
  }
  
  public boolean a(Context paramContext, boolean paramBoolean)
  {
    if (this.jdField_c_of_type_Int <= 0)
    {
      QLog.d("PatchLogTag", 1, "DexPatchConfigArtAfterN isValidConfig patch7zSize is invalid");
      return false;
    }
    return super.a(paramContext, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hotpatch.config.DexPatchConfigArtAfterN
 * JD-Core Version:    0.7.0.1
 */