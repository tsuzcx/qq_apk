package com.tencent.avgame.config.data;

import android.text.TextUtils;
import com.tencent.avgame.gamelogic.gameres.IAvGameResPreloadManager.ConfInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class CJPreloadConfBean
{
  private IAvGameResPreloadManager.ConfInfo a;
  public JSONArray a;
  
  public CJPreloadConfBean()
  {
    this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo = new IAvGameResPreloadManager.ConfInfo();
  }
  
  public static CJPreloadConfBean a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    CJPreloadConfBean localCJPreloadConfBean = new CJPreloadConfBean();
    localCJPreloadConfBean.jdField_a_of_type_OrgJsonJSONArray = a(new JSONObject(paramString));
    localCJPreloadConfBean.a();
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
    return this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo;
  }
  
  public void a()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseAllConfigJaToResInfo allConfigJa:");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_OrgJsonJSONArray);
      QLog.d("CJPreloadConfBean", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_OrgJsonJSONArray.length() < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("CJPreloadConfBean", 2, "parseAllConfigJaToResInfo allConfigJa length < 0");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_OrgJsonJSONArray;
    int i = 0;
    localObject = ((JSONArray)localObject).optJSONObject(0).optJSONArray("resources");
    while (i < ((JSONArray)localObject).length())
    {
      JSONObject localJSONObject = ((JSONArray)localObject).optJSONObject(i);
      if (localJSONObject.optString("res_id").equals("res1009Android"))
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.a = localJSONObject.optString("url");
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.b = localJSONObject.optString("md5");
      }
      else if (localJSONObject.optString("res_id").equals("AVGameVoiceRecogSo"))
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.c = localJSONObject.optString("url");
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.d = localJSONObject.optString("md5");
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.e = localJSONObject.optString("file_md5");
      }
      else if (localJSONObject.optString("res_id").equals("AVGameVoiceRecogModel"))
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.f = localJSONObject.optString("url");
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.g = localJSONObject.optString("md5");
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.h = localJSONObject.optString("file_md5");
      }
      else if (localJSONObject.optString("res_id").equals("AVGameVoiceRecogAILabSo"))
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.i = localJSONObject.optString("url");
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.j = localJSONObject.optString("md5");
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.k = localJSONObject.optString("file_md5");
      }
      else if (localJSONObject.optString("res_id").equals("AVGameVoiceRecogAILabModel"))
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.l = localJSONObject.optString("url");
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.m = localJSONObject.optString("md5");
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo.n = localJSONObject.optString("file_md5");
      }
      i += 1;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("parseAllConfigJaToResInfo mConfInfo:");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentAvgameGamelogicGameresIAvGameResPreloadManager$ConfInfo);
    QLog.d("CJPreloadConfBean", 2, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.config.data.CJPreloadConfBean
 * JD-Core Version:    0.7.0.1
 */