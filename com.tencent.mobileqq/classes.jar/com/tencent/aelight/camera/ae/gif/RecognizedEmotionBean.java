package com.tencent.aelight.camera.ae.gif;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class RecognizedEmotionBean
{
  public List<String> a;
  public String b = "default";
  public int c = 3;
  public int d = 6;
  
  public RecognizedEmotionBean()
  {
    this.a = new ArrayList();
  }
  
  public RecognizedEmotionBean(List<String> paramList, String paramString, JSONObject paramJSONObject)
  {
    this.a = paramList;
    this.b = paramString;
    if (paramJSONObject != null)
    {
      a(paramJSONObject);
      return;
    }
    this.c = 3;
    this.d = 6;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        if (this.b != null)
        {
          str = this.b;
          paramJSONObject = paramJSONObject.getJSONObject(str);
          this.c = paramJSONObject.getInt("wordNum");
          this.d = paramJSONObject.getInt("pendantNum");
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        paramJSONObject.printStackTrace();
        return;
      }
      String str = "default";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean
 * JD-Core Version:    0.7.0.1
 */