package com.tencent.avgame.config.data;

import android.text.TextUtils;
import com.tencent.avgame.gamelogic.gameres.IAvGameResPreloadManager.ConfInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class CJPreloadConfBean
{
  public JSONArray a = new JSONArray();
  private IAvGameResPreloadManager.ConfInfo b = new IAvGameResPreloadManager.ConfInfo();
  
  public static CJPreloadConfBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    CJPreloadConfBean localCJPreloadConfBean = new CJPreloadConfBean();
    localCJPreloadConfBean.a = a(new JSONObject(paramString));
    localCJPreloadConfBean.b();
    return localCJPreloadConfBean;
  }
  
  private static JSONArray a(JSONObject paramJSONObject)
  {
    JSONArray localJSONArray = new JSONArray();
    paramJSONObject = paramJSONObject.optJSONArray("module_config");
    int i = 0;
    while (i < paramJSONObject.length())
    {
      localJSONArray.put(paramJSONObject.optJSONObject(i));
      i += 1;
    }
    return localJSONArray;
  }
  
  public IAvGameResPreloadManager.ConfInfo a()
  {
    return this.b;
  }
  
  public void b()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseAllConfigJaToResInfo allConfigJa:");
      ((StringBuilder)localObject).append(this.a);
      QLog.d("CJPreloadConfBean", 2, ((StringBuilder)localObject).toString());
    }
    if (this.a.length() < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CJPreloadConfBean", 2, "parseAllConfigJaToResInfo allConfigJa length < 0");
      }
      return;
    }
    Object localObject = this.a;
    int i = 0;
    localObject = ((JSONArray)localObject).optJSONObject(0).optJSONArray("resources");
    while (i < ((JSONArray)localObject).length())
    {
      JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
      if (localJSONObject.optString("res_id").equals("res1009Android"))
      {
        this.b.a = localJSONObject.optString("url");
        this.b.b = localJSONObject.optString("md5");
      }
      else if (localJSONObject.optString("res_id").equals("AVGameVoiceRecogSo"))
      {
        this.b.c = localJSONObject.optString("url");
        this.b.d = localJSONObject.optString("md5");
        this.b.e = localJSONObject.optString("file_md5");
      }
      else if (localJSONObject.optString("res_id").equals("AVGameVoiceRecogModel"))
      {
        this.b.f = localJSONObject.optString("url");
        this.b.g = localJSONObject.optString("md5");
        this.b.h = localJSONObject.optString("file_md5");
      }
      else if (localJSONObject.optString("res_id").equals("AVGameVoiceRecogAILabSo"))
      {
        this.b.i = localJSONObject.optString("url");
        this.b.j = localJSONObject.optString("md5");
        this.b.k = localJSONObject.optString("file_md5");
      }
      else if (localJSONObject.optString("res_id").equals("AVGameVoiceRecogAILabModel"))
      {
        this.b.l = localJSONObject.optString("url");
        this.b.m = localJSONObject.optString("md5");
        this.b.n = localJSONObject.optString("file_md5");
      }
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseAllConfigJaToResInfo mConfInfo:");
    ((StringBuilder)localObject).append(this.b);
    QLog.d("CJPreloadConfBean", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.config.data.CJPreloadConfBean
 * JD-Core Version:    0.7.0.1
 */