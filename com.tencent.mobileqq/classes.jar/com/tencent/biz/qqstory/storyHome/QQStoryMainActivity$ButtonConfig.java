package com.tencent.biz.qqstory.storyHome;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQStoryMainActivity$ButtonConfig
{
  public int a;
  public String a;
  public String b;
  public String c;
  
  public QQStoryMainActivity$ButtonConfig(String paramString)
  {
    this.jdField_a_of_type_Int = 3;
    paramString = (String)((StoryConfigManager)SuperManager.a(10)).b(paramString, "");
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      paramString = new JSONObject(paramString);
      this.jdField_a_of_type_Int = paramString.optInt("show", 3);
      if (this.jdField_a_of_type_Int > 0)
      {
        this.c = paramString.optString("url");
        this.jdField_a_of_type_JavaLangString = paramString.optString("icon");
        this.b = paramString.optString("text");
      }
      return;
    }
    catch (Exception paramString)
    {
      do
      {
        this.jdField_a_of_type_Int = 3;
      } while (!QLog.isColorLevel());
      QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, "ButtonConfig exc: " + QLog.getStackTraceString(paramString));
    }
  }
  
  public String toString()
  {
    return "ButtonConfig: show = " + this.jdField_a_of_type_Int + ", iconText = " + this.b + ", iconUrl = " + this.jdField_a_of_type_JavaLangString + ", jumpUrl = " + this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainActivity.ButtonConfig
 * JD-Core Version:    0.7.0.1
 */