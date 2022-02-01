package com.tencent.aelight.camera.aioeditor.shortvideo;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;

public class QIMBeautyManager
{
  private static QIMBeautyManager a;
  public static String a = "QIMBeautyManager";
  
  private QIMBeautyManager()
  {
    a();
  }
  
  public static QIMBeautyManager a()
  {
    if (jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMBeautyManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMBeautyManager == null) {
          jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMBeautyManager = new QIMBeautyManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentAelightCameraAioeditorShortvideoQIMBeautyManager;
  }
  
  private String a()
  {
    String str1 = BaseApplicationImpl.getApplication().getSharedPreferences("short_video_beauty_config", 0).getString("short_video_beauty_content", "");
    if (QLog.isColorLevel())
    {
      String str2 = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("take  config content= ");
      localStringBuilder.append(str1);
      QLog.d(str2, 2, localStringBuilder.toString());
    }
    return str1;
  }
  
  public int a(Context paramContext)
  {
    return paramContext.getSharedPreferences("short_video_beauty_config", 0).getInt("short_video_beauty_version", 0);
  }
  
  public void a()
  {
    for (;;)
    {
      try
      {
        Object localObject1 = a();
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          return;
        }
        localObject1 = new JSONObject((String)localObject1);
        if (((JSONObject)localObject1).has("category"))
        {
          localObject1 = ((JSONObject)localObject1).getJSONArray("category");
          if (localObject1 != null)
          {
            if (((JSONArray)localObject1).length() > 0) {
              break label154;
            }
            return;
            if (i < ((JSONArray)localObject1).length())
            {
              Object localObject2 = ((JSONArray)localObject1).getJSONObject(i);
              if (((JSONObject)localObject2).has("downloadInfo"))
              {
                WeishiGuideUtils.jdField_a_of_type_JavaLangString = ((JSONObject)localObject2).getString("downloadInfo");
                if (QLog.isColorLevel())
                {
                  localObject2 = jdField_a_of_type_JavaLangString;
                  StringBuilder localStringBuilder = new StringBuilder();
                  localStringBuilder.append("QIMBeautyManager WeishiGuideUtils.DOWNLOAD_JSON=  ");
                  localStringBuilder.append(WeishiGuideUtils.jdField_a_of_type_JavaLangString);
                  QLog.e((String)localObject2, 2, localStringBuilder.toString());
                }
              }
              i += 1;
              continue;
            }
          }
          else
          {
            return;
          }
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 2, "parseConfig error", localException);
        }
      }
      return;
      label154:
      int i = 0;
    }
  }
  
  public boolean a(String paramString, int paramInt, Context paramContext)
  {
    if (QLog.isColorLevel())
    {
      String str = jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("saveBeautyConfig :  ");
      localStringBuilder.append(paramString);
      QLog.d(str, 2, localStringBuilder.toString());
    }
    paramContext = paramContext.getSharedPreferences("short_video_beauty_config", 0).edit();
    paramContext.putString("short_video_beauty_content", paramString);
    paramContext.putInt("short_video_beauty_version", paramInt);
    paramContext.commit();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.shortvideo.QIMBeautyManager
 * JD-Core Version:    0.7.0.1
 */