package com.tencent.hotpatch.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.hotpatch.utils.PatchCommonUtil;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class PatchConfig
{
  private int jdField_a_of_type_Int;
  private AbscractPatchItemConfig jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean;
  private String b;
  private String c;
  
  public PatchConfig(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i = 0;
    this.jdField_a_of_type_Boolean = paramJSONObject.optBoolean("enable", false);
    this.jdField_a_of_type_JavaLangString = paramJSONObject.optString("patchType", null);
    this.jdField_a_of_type_Int = paramJSONObject.optInt("patchVersion", 0);
    this.b = paramJSONObject.optString("appVersion", null);
    this.c = paramJSONObject.optString("revision", null);
    paramJSONObject = paramJSONObject.optJSONArray("patchItemConfigs");
    if (paramJSONObject != null) {}
    for (;;)
    {
      try
      {
        if (i < paramJSONObject.length())
        {
          AbscractPatchItemConfig localAbscractPatchItemConfig = AbscractPatchItemConfig.a(this.jdField_a_of_type_JavaLangString, paramJSONObject.getJSONObject(i));
          if (localAbscractPatchItemConfig != null) {
            this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig = localAbscractPatchItemConfig;
          }
        }
        else
        {
          return;
        }
      }
      catch (JSONException paramJSONObject)
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e("PatchLogTag", 2, "PatchConfig readFromJsonString", paramJSONObject);
      }
      i += 1;
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public AbscractPatchItemConfig a()
  {
    return this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(Context paramContext, boolean paramBoolean)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig enable is false");
      return false;
    }
    if (!"355371".equals(this.c))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig revision not match");
      return false;
    }
    if ((TextUtils.isEmpty(this.b)) || (!this.b.equals(ApkUtils.a(paramContext) + "." + ApkUtils.a(paramContext))))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig app version not match");
      return false;
    }
    if ((this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig == null) || (!this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig.a(paramBoolean)))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig patchItemConfig null or invalid");
      return false;
    }
    QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig return true");
    return true;
  }
  
  public int b()
  {
    if (this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig != null) {
      return this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public String b()
  {
    if (this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig != null) {
      return this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public int c()
  {
    if ((PatchCommonUtil.c()) && (this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig != null)) {
      return ((DexPatchItemConfigArtGeN)this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig).a();
    }
    return b();
  }
  
  public String c()
  {
    String str2 = b();
    String str1;
    if (PatchCommonUtil.d()) {
      str1 = "androidO7z_" + str2;
    }
    do
    {
      return str1;
      str1 = str2;
    } while (!PatchCommonUtil.c());
    return "androidN7z_" + str2;
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig != null) {
      return this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig.b;
    }
    return null;
  }
  
  public String e()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("enable", this.jdField_a_of_type_Boolean);
      ((JSONObject)localObject2).put("patchType", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject2).put("patchVersion", this.jdField_a_of_type_Int);
      ((JSONObject)localObject2).put("appVersion", this.b);
      ((JSONObject)localObject2).put("revision", this.c);
      if (this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig != null)
      {
        String str = this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig.a();
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(0, new JSONObject(str));
        ((JSONObject)localObject2).put("patchItemConfigs", localJSONArray);
      }
      localObject2 = ((JSONObject)localObject2).toString();
      localObject1 = localObject2;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("PatchLogTag", 2, "PatchConfig writeToJsonString", localJSONException);
    }
    return localObject1;
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.hotpatch.config.PatchConfig
 * JD-Core Version:    0.7.0.1
 */