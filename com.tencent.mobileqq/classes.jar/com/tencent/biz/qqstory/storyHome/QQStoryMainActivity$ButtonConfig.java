package com.tencent.biz.qqstory.storyHome;

import android.text.TextUtils;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class QQStoryMainActivity$ButtonConfig
{
  public int a = 3;
  public String b = null;
  public String c = null;
  public String d = null;
  
  public QQStoryMainActivity$ButtonConfig(String paramString)
  {
    paramString = (String)((StoryConfigManager)SuperManager.a(10)).c(paramString, "");
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        this.a = paramString.optInt("show", 3);
        if (this.a >= 0)
        {
          this.d = paramString.optString("url");
          this.b = paramString.optString("icon");
          this.c = paramString.optString("text");
          return;
        }
      }
      catch (Exception paramString)
      {
        this.a = 3;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("ButtonConfig exc: ");
          localStringBuilder.append(QLog.getStackTraceString(paramString));
          QLog.d("Q.qqstory.home.QQStoryMainActivity", 2, localStringBuilder.toString());
        }
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ButtonConfig: show = ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", iconText = ");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", iconUrl = ");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", jumpUrl = ");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.QQStoryMainActivity.ButtonConfig
 * JD-Core Version:    0.7.0.1
 */