package com.tencent.avgame.gamelogic.gameres;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class CJPreloadConfBean
{
  private AvGameResPreloadManager.ConfInfo a;
  public JSONArray a;
  
  public CJPreloadConfBean()
  {
    this.jdField_a_of_type_OrgJsonJSONArray = new JSONArray();
    this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo = new AvGameResPreloadManager.ConfInfo();
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
  
  public AvGameResPreloadManager.ConfInfo a()
  {
    return this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo;
  }
  
  public void a()
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d("springHb_CJPreloadConfBean", 2, "parseAllConfigJaToResInfo allConfigJa:" + this.jdField_a_of_type_OrgJsonJSONArray);
    }
    if (this.jdField_a_of_type_OrgJsonJSONArray.length() < 0)
    {
      if (QLog.isColorLevel()) {
        QLog.e("springHb_CJPreloadConfBean", 2, "parseAllConfigJaToResInfo allConfigJa length < 0");
      }
      return;
    }
    JSONArray localJSONArray = this.jdField_a_of_type_OrgJsonJSONArray.optJSONObject(0).optJSONArray("resources");
    if (i < localJSONArray.length())
    {
      JSONObject localJSONObject = localJSONArray.optJSONObject(i);
      if (localJSONObject.optString("res_id").equals("res1009Android"))
      {
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.a = localJSONObject.optString("url");
        this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.b = localJSONObject.optString("md5");
      }
      for (;;)
      {
        i += 1;
        break;
        if (localJSONObject.optString("res_id").equals("AVGameVoiceRecogSo"))
        {
          this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.c = localJSONObject.optString("url");
          this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.d = localJSONObject.optString("md5");
          this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.e = localJSONObject.optString("file_md5");
        }
        else if (localJSONObject.optString("res_id").equals("AVGameVoiceRecogModel"))
        {
          this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.f = localJSONObject.optString("url");
          this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.g = localJSONObject.optString("md5");
          this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.h = localJSONObject.optString("file_md5");
        }
        else if (localJSONObject.optString("res_id").equals("AVGameVoiceRecogAILabSo"))
        {
          this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.i = localJSONObject.optString("url");
          this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.j = localJSONObject.optString("md5");
          this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.k = localJSONObject.optString("file_md5");
        }
        else if (localJSONObject.optString("res_id").equals("AVGameVoiceRecogAILabModel"))
        {
          this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.l = localJSONObject.optString("url");
          this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.m = localJSONObject.optString("md5");
          this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo.n = localJSONObject.optString("file_md5");
        }
      }
    }
    QLog.d("springHb_CJPreloadConfBean", 2, "parseAllConfigJaToResInfo mConfInfo:" + this.jdField_a_of_type_ComTencentAvgameGamelogicGameresAvGameResPreloadManager$ConfInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.gamelogic.gameres.CJPreloadConfBean
 * JD-Core Version:    0.7.0.1
 */