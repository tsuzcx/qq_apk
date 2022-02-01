package com.tencent.biz.pubaccount.readinjoyAd.ad.data;

import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public class SmallMiniGameInfo
{
  public int a;
  public String a;
  public CopyOnWriteArrayList<SmallMiniGameInfo.SmallMiniGameData> a;
  public JSONArray a;
  public int b;
  public String b;
  public String c = "2";
  public String d = "";
  public String e = "";
  public String f = "";
  public String g = "";
  public String h = "";
  public String i = "";
  public String j = "";
  public String k = "";
  public String l = "";
  public String m = "";
  public String n = "";
  public String o = "";
  public String p = "";
  public String q;
  public String r;
  public String s;
  public String t;
  public String u;
  
  public SmallMiniGameInfo()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
  }
  
  public static SmallMiniGameInfo a(String paramString)
  {
    SmallMiniGameInfo localSmallMiniGameInfo = new SmallMiniGameInfo();
    try
    {
      paramString = new JSONObject(paramString);
      localSmallMiniGameInfo.jdField_a_of_type_JavaLangString = paramString.optString("more_btn_url");
      localSmallMiniGameInfo.jdField_b_of_type_JavaLangString = paramString.optString("trace_id");
      localSmallMiniGameInfo.d = paramString.optString("md_style");
      localSmallMiniGameInfo.f = paramString.optString("game_tips");
      localSmallMiniGameInfo.g = paramString.optString("game_tips_icon");
      localSmallMiniGameInfo.j = paramString.optString("game_id");
      localSmallMiniGameInfo.o = paramString.optString("game_name");
      localSmallMiniGameInfo.l = paramString.optString("game_icon");
      localSmallMiniGameInfo.m = paramString.optString("game_desc");
      localSmallMiniGameInfo.n = paramString.optString("game_btn_text");
      localSmallMiniGameInfo.k = paramString.optString("game_jump_url");
      localSmallMiniGameInfo.jdField_a_of_type_OrgJsonJSONArray = paramString.optJSONArray("app_picthree");
      localSmallMiniGameInfo.p = paramString.optString("article_title");
      localSmallMiniGameInfo.jdField_b_of_type_Int = paramString.optInt("card_size");
      localSmallMiniGameInfo.jdField_a_of_type_Int = paramString.optInt("style_type");
      localSmallMiniGameInfo.h = paramString.optString("left_big_img_url");
      localSmallMiniGameInfo.i = paramString.optString("background_img_url");
      localSmallMiniGameInfo.q = paramString.optString("guide_icon");
      localSmallMiniGameInfo.t = paramString.optString("guide_jump_url");
      localSmallMiniGameInfo.u = paramString.optString("guide_name");
      localSmallMiniGameInfo.s = paramString.optString("guide_btn_unsubscribed");
      localSmallMiniGameInfo.r = paramString.optString("guide_btn_subscribed");
      int i1 = paramString.optInt("obj_type");
      if (i1 != 0) {
        localSmallMiniGameInfo.c = String.valueOf(i1);
      }
      if (localSmallMiniGameInfo.jdField_b_of_type_Int > 0)
      {
        a(paramString, localSmallMiniGameInfo.jdField_b_of_type_Int, localSmallMiniGameInfo);
        return localSmallMiniGameInfo;
      }
      a(paramString, 5, localSmallMiniGameInfo);
      return localSmallMiniGameInfo;
    }
    catch (Exception paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.e("SmallMiniGameInfo", 2, "json error:" + paramString.getMessage());
      }
    }
    return localSmallMiniGameInfo;
  }
  
  private static void a(JSONObject paramJSONObject, int paramInt, SmallMiniGameInfo paramSmallMiniGameInfo)
  {
    paramSmallMiniGameInfo.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
    int i1 = 1;
    while (i1 <= paramInt)
    {
      SmallMiniGameInfo.SmallMiniGameData localSmallMiniGameData = new SmallMiniGameInfo.SmallMiniGameData();
      localSmallMiniGameData.jdField_a_of_type_JavaLangString = paramJSONObject.optString("game_id" + i1);
      localSmallMiniGameData.c = paramJSONObject.optString("game_slot_type" + i1);
      localSmallMiniGameData.d = paramJSONObject.optString("game_title" + i1);
      localSmallMiniGameData.jdField_b_of_type_JavaLangString = paramJSONObject.optString("game_url" + i1);
      paramSmallMiniGameInfo.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(localSmallMiniGameData);
      i1 += 1;
    }
  }
  
  public String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null) && (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.iterator();
      while (localIterator.hasNext()) {
        localStringBuilder.append(((SmallMiniGameInfo.SmallMiniGameData)localIterator.next()).jdField_a_of_type_JavaLangString).append(",");
      }
    }
    return localStringBuilder.toString();
  }
  
  public String a(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > paramInt) {
        str1 = ((SmallMiniGameInfo.SmallMiniGameData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_a_of_type_JavaLangString;
      }
    }
    return str1;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Int == 0;
  }
  
  public String b(int paramInt)
  {
    String str2 = "";
    String str1 = str2;
    if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList != null)
    {
      str1 = str2;
      if (this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.size() > paramInt) {
        str1 = ((SmallMiniGameInfo.SmallMiniGameData)this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.get(paramInt)).jdField_b_of_type_JavaLangString;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoyAd.ad.data.SmallMiniGameInfo
 * JD-Core Version:    0.7.0.1
 */