package com.tencent.aelight.camera.ae.gif;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class RecognizedEmotionBean
{
  public int a;
  public String a;
  public List<String> a;
  public int b = 6;
  
  public RecognizedEmotionBean()
  {
    this.jdField_a_of_type_JavaLangString = "default";
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public RecognizedEmotionBean(List<String> paramList, String paramString, JSONObject paramJSONObject)
  {
    this.jdField_a_of_type_JavaLangString = "default";
    this.jdField_a_of_type_Int = 3;
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_JavaLangString = paramString;
    if (paramJSONObject != null)
    {
      a(paramJSONObject);
      return;
    }
    this.jdField_a_of_type_Int = 3;
    this.b = 6;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    for (;;)
    {
      try
      {
        if (this.jdField_a_of_type_JavaLangString != null)
        {
          str = this.jdField_a_of_type_JavaLangString;
          paramJSONObject = paramJSONObject.getJSONObject(str);
          this.jdField_a_of_type_Int = paramJSONObject.getInt("wordNum");
          this.b = paramJSONObject.getInt("pendantNum");
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.aelight.camera.ae.gif.RecognizedEmotionBean
 * JD-Core Version:    0.7.0.1
 */