package com.tencent.biz.pubaccount.readinjoy.view.fastweb.data;

import org.json.JSONObject;

public class MiniAppData
  extends ProteusItemData
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  public String c;
  
  public MiniAppData(int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(JSONObject paramJSONObject)
  {
    String str1;
    if (this.jdField_a_of_type_Boolean)
    {
      str1 = "已添加";
      if (!this.jdField_a_of_type_Boolean) {
        break label43;
      }
    }
    label43:
    for (String str2 = "1";; str2 = "0")
    {
      paramJSONObject.put("watch_later_text", str1);
      paramJSONObject.put("watch_later_selected", str2);
      return;
      str1 = "稍后看";
      break;
    }
  }
  
  public String toString()
  {
    return "MiniAppData{miniProgramName='" + this.jdField_a_of_type_JavaLangString + '\'' + ", miniAppMovieName='" + this.b + '\'' + ", miniRowKey='" + this.c + '\'' + ", isWatchLater=" + this.jdField_a_of_type_Boolean + ", totalTime=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.MiniAppData
 * JD-Core Version:    0.7.0.1
 */