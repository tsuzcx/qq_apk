package com.tencent.hotpatch.config;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.cooperation.ApkUtils;
import com.tencent.mobileqq.msf.core.net.patch.PatchCommonUtil;
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
    if (paramJSONObject != null) {
      try
      {
        while (i < paramJSONObject.length())
        {
          AbscractPatchItemConfig localAbscractPatchItemConfig = AbscractPatchItemConfig.a(this.jdField_a_of_type_JavaLangString, paramJSONObject.getJSONObject(i));
          if (localAbscractPatchItemConfig != null)
          {
            this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig = localAbscractPatchItemConfig;
            return;
          }
          i += 1;
        }
        return;
      }
      catch (JSONException paramJSONObject)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PatchLogTag", 2, "PatchConfig readFromJsonString", paramJSONObject);
        }
      }
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
  
  public boolean a(Context paramContext, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig enable is false");
      return false;
    }
    if (!"01328a87".equals(this.c))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig revision not match expect: 01328a87");
      return false;
    }
    if (!TextUtils.isEmpty(this.b))
    {
      String str = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ApkUtils.a(paramContext));
      localStringBuilder.append(".");
      localStringBuilder.append(ApkUtils.a(paramContext));
      if (str.equals(localStringBuilder.toString()))
      {
        paramContext = this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig;
        if ((paramContext != null) && (paramContext.a(paramString)))
        {
          QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig return true");
          return true;
        }
        QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig patchItemConfig null or invalid");
        return false;
      }
    }
    paramString = new StringBuilder();
    paramString.append("PatchConfig isValidConfig app version not match expect: ");
    paramString.append(ApkUtils.a(paramContext));
    paramString.append(".");
    paramString.append(ApkUtils.a(paramContext));
    QLog.d("PatchLogTag", 1, paramString.toString());
    return false;
  }
  
  public int b()
  {
    AbscractPatchItemConfig localAbscractPatchItemConfig = this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig;
    if (localAbscractPatchItemConfig != null) {
      return localAbscractPatchItemConfig.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public String b()
  {
    AbscractPatchItemConfig localAbscractPatchItemConfig = this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig;
    if (localAbscractPatchItemConfig != null) {
      return localAbscractPatchItemConfig.jdField_a_of_type_JavaLangString;
    }
    return null;
  }
  
  public boolean b()
  {
    AbscractPatchItemConfig localAbscractPatchItemConfig = this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig;
    return (localAbscractPatchItemConfig != null) && (localAbscractPatchItemConfig.a());
  }
  
  public int c()
  {
    if ((!b()) && (PatchCommonUtil.isArtGeN()))
    {
      AbscractPatchItemConfig localAbscractPatchItemConfig = this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig;
      if (localAbscractPatchItemConfig != null) {
        return ((DexPatchItemConfigArtGeN)localAbscractPatchItemConfig).a();
      }
    }
    return b();
  }
  
  public String c()
  {
    String str = b();
    if (b()) {
      return str;
    }
    if (PatchCommonUtil.isArtGeO())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("androidO7z_");
      ((StringBuilder)localObject).append(str);
      return ((StringBuilder)localObject).toString();
    }
    Object localObject = str;
    if (PatchCommonUtil.isArtGeN())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("androidN7z_");
      ((StringBuilder)localObject).append(str);
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public boolean c()
  {
    AbscractPatchItemConfig localAbscractPatchItemConfig = this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig;
    return (localAbscractPatchItemConfig != null) && (localAbscractPatchItemConfig.b());
  }
  
  public String d()
  {
    AbscractPatchItemConfig localAbscractPatchItemConfig = this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig;
    if (localAbscractPatchItemConfig != null) {
      return localAbscractPatchItemConfig.b;
    }
    return null;
  }
  
  public String e()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("enable", this.jdField_a_of_type_Boolean);
      ((JSONObject)localObject).put("patchType", this.jdField_a_of_type_JavaLangString);
      ((JSONObject)localObject).put("patchVersion", this.jdField_a_of_type_Int);
      ((JSONObject)localObject).put("appVersion", this.b);
      ((JSONObject)localObject).put("revision", this.c);
      if (this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig != null)
      {
        String str = this.jdField_a_of_type_ComTencentHotpatchConfigAbscractPatchItemConfig.a();
        JSONArray localJSONArray = new JSONArray();
        localJSONArray.put(0, new JSONObject(str));
        ((JSONObject)localObject).put("patchItemConfigs", localJSONArray);
      }
      localObject = ((JSONObject)localObject).toString();
      return localObject;
    }
    catch (JSONException localJSONException)
    {
      if (QLog.isColorLevel()) {
        QLog.e("PatchLogTag", 2, "PatchConfig writeToJsonString", localJSONException);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.hotpatch.config.PatchConfig
 * JD-Core Version:    0.7.0.1
 */