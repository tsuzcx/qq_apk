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
  private boolean a;
  private String b;
  private int c;
  private String d;
  private String e;
  private AbscractPatchItemConfig f;
  
  public PatchConfig(JSONObject paramJSONObject)
  {
    a(paramJSONObject);
  }
  
  private void a(JSONObject paramJSONObject)
  {
    int i = 0;
    this.a = paramJSONObject.optBoolean("enable", false);
    this.b = paramJSONObject.optString("patchType", null);
    this.c = paramJSONObject.optInt("patchVersion", 0);
    this.d = paramJSONObject.optString("appVersion", null);
    this.e = paramJSONObject.optString("revision", null);
    paramJSONObject = paramJSONObject.optJSONArray("patchItemConfigs");
    if (paramJSONObject != null) {
      try
      {
        while (i < paramJSONObject.length())
        {
          AbscractPatchItemConfig localAbscractPatchItemConfig = AbscractPatchItemConfig.a(this.b, paramJSONObject.getJSONObject(i));
          if (localAbscractPatchItemConfig != null)
          {
            this.f = localAbscractPatchItemConfig;
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
  
  public boolean a()
  {
    return this.a;
  }
  
  public boolean a(Context paramContext, String paramString)
  {
    if (!this.a)
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig enable is false");
      return false;
    }
    if (!"846a9bfd".equals(this.e))
    {
      QLog.d("PatchLogTag", 1, "PatchConfig isValidConfig revision not match expect: 846a9bfd");
      return false;
    }
    if (!TextUtils.isEmpty(this.d))
    {
      String str = this.d;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(ApkUtils.b(paramContext));
      localStringBuilder.append(".");
      localStringBuilder.append(ApkUtils.a(paramContext));
      if (str.equals(localStringBuilder.toString()))
      {
        paramContext = this.f;
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
    paramString.append(ApkUtils.b(paramContext));
    paramString.append(".");
    paramString.append(ApkUtils.a(paramContext));
    QLog.d("PatchLogTag", 1, paramString.toString());
    return false;
  }
  
  public boolean b()
  {
    AbscractPatchItemConfig localAbscractPatchItemConfig = this.f;
    return (localAbscractPatchItemConfig != null) && (localAbscractPatchItemConfig.a());
  }
  
  public String c()
  {
    return this.b;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public String e()
  {
    AbscractPatchItemConfig localAbscractPatchItemConfig = this.f;
    if (localAbscractPatchItemConfig != null) {
      return localAbscractPatchItemConfig.a;
    }
    return null;
  }
  
  public String f()
  {
    String str = e();
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
  
  public int g()
  {
    AbscractPatchItemConfig localAbscractPatchItemConfig = this.f;
    if (localAbscractPatchItemConfig != null) {
      return localAbscractPatchItemConfig.c;
    }
    return 0;
  }
  
  public int h()
  {
    if ((!b()) && (PatchCommonUtil.isArtGeN()))
    {
      AbscractPatchItemConfig localAbscractPatchItemConfig = this.f;
      if (localAbscractPatchItemConfig != null) {
        return ((DexPatchItemConfigArtGeN)localAbscractPatchItemConfig).c();
      }
    }
    return g();
  }
  
  public String i()
  {
    AbscractPatchItemConfig localAbscractPatchItemConfig = this.f;
    if (localAbscractPatchItemConfig != null) {
      return localAbscractPatchItemConfig.b;
    }
    return null;
  }
  
  public String j()
  {
    try
    {
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("enable", this.a);
      ((JSONObject)localObject).put("patchType", this.b);
      ((JSONObject)localObject).put("patchVersion", this.c);
      ((JSONObject)localObject).put("appVersion", this.d);
      ((JSONObject)localObject).put("revision", this.e);
      if (this.f != null)
      {
        String str = this.f.b();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.hotpatch.config.PatchConfig
 * JD-Core Version:    0.7.0.1
 */