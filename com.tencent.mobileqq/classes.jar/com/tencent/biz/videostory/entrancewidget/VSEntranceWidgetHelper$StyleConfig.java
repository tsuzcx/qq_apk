package com.tencent.biz.videostory.entrancewidget;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class VSEntranceWidgetHelper$StyleConfig
{
  public String a = "";
  public String b = "";
  public String c = "";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  
  public VSEntranceWidgetHelper$StyleConfig(VSEntranceWidgetHelper paramVSEntranceWidgetHelper, String paramString, JSONObject paramJSONObject)
  {
    this.a = paramString;
    try
    {
      this.b = paramJSONObject.getString("title");
      this.c = paramJSONObject.getString("title_color");
      this.d = paramJSONObject.getString("bg_color");
      this.e = paramJSONObject.getString("bg_border_color");
      return;
    }
    catch (JSONException paramVSEntranceWidgetHelper)
    {
      paramVSEntranceWidgetHelper.printStackTrace();
    }
  }
  
  public void a(String paramString)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(paramString);
    ((StringBuilder)localObject1).append("/");
    ((StringBuilder)localObject1).append(this.a);
    paramString = ((StringBuilder)localObject1).toString();
    localObject1 = new File(paramString);
    if (((File)localObject1).exists())
    {
      localObject1 = Arrays.asList(((File)localObject1).list());
      if (((List)localObject1).contains("take_video@2x.png"))
      {
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append("/");
        ((StringBuilder)localObject2).append("take_video@2x.png");
        localObject2 = ((StringBuilder)localObject2).toString();
        if (new File((String)localObject2).exists()) {
          this.f = ((String)localObject2);
        }
      }
      if (((List)localObject1).contains("take_video_no_bg@2x.png"))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramString);
        ((StringBuilder)localObject1).append("/");
        ((StringBuilder)localObject1).append("take_video_no_bg@2x.png");
        paramString = ((StringBuilder)localObject1).toString();
        if (new File(paramString).exists()) {
          this.g = paramString;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.videostory.entrancewidget.VSEntranceWidgetHelper.StyleConfig
 * JD-Core Version:    0.7.0.1
 */