package com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report;

import com.tencent.biz.pubaccount.VideoReporter;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.util.RIJAppSetting;
import com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.push.RIJKanDianFolderStatus;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData.SearchWord;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import cooperation.readinjoy.ReadInJoyHelper;
import java.util.Iterator;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

public class RIJTransMergeKanDianReport$ReportR5Builder
{
  int jdField_a_of_type_Int = -1;
  String jdField_a_of_type_JavaLangString = null;
  JSONObject jdField_a_of_type_OrgJsonJSONObject = new JSONObject();
  boolean jdField_a_of_type_Boolean = false;
  int jdField_b_of_type_Int = -1;
  String jdField_b_of_type_JavaLangString = null;
  boolean jdField_b_of_type_Boolean = false;
  int jdField_c_of_type_Int = -1;
  boolean jdField_c_of_type_Boolean = false;
  boolean d = false;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  boolean h = false;
  boolean i = false;
  
  public RIJTransMergeKanDianReport$ReportR5Builder() {}
  
  public RIJTransMergeKanDianReport$ReportR5Builder(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      this.jdField_a_of_type_OrgJsonJSONObject = paramJSONObject;
    }
  }
  
  public ReportR5Builder a()
  {
    this.h = true;
    return this;
  }
  
  public ReportR5Builder a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public ReportR5Builder a(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("algorithm_id", paramLong);
    return this;
  }
  
  public ReportR5Builder a(RelatedSearchData.SearchWord paramSearchWord, int paramInt)
  {
    if (paramSearchWord != null)
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("modelID", paramSearchWord.jdField_a_of_type_Int);
      this.jdField_a_of_type_OrgJsonJSONObject.put("modelName", paramSearchWord.c);
      this.jdField_a_of_type_OrgJsonJSONObject.put("score", paramSearchWord.jdField_a_of_type_Float);
      this.jdField_a_of_type_OrgJsonJSONObject.put("searchWord", paramSearchWord.jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_OrgJsonJSONObject.put("position", paramInt);
    }
    return this;
  }
  
  public ReportR5Builder a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public ReportR5Builder a(String paramString, int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramInt);
    return this;
  }
  
  public ReportR5Builder a(String paramString, long paramLong)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramLong);
      return this;
    }
    catch (JSONException localJSONException)
    {
      AIOUtils.a("RIJTransMergeKanDianReport", "", new IllegalArgumentException(paramString + " : " + paramLong));
    }
    return this;
  }
  
  public ReportR5Builder a(String paramString, Object paramObject)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramObject);
      return this;
    }
    catch (JSONException localJSONException)
    {
      AIOUtils.a("RIJTransMergeKanDianReport", "", new IllegalArgumentException(paramString + " : " + paramObject));
    }
    return this;
  }
  
  public ReportR5Builder a(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put(paramString1, paramString2);
    return this;
  }
  
  public ReportR5Builder a(@NotNull JSONObject paramJSONObject)
  {
    Iterator localIterator = paramJSONObject.keys();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Object localObject = paramJSONObject.opt(str);
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put(str, localObject);
      }
      catch (JSONException localJSONException)
      {
        AIOUtils.a("RIJTransMergeKanDianReport", "", new IllegalArgumentException(str + " : " + localObject));
      }
    }
    return this;
  }
  
  public ReportR5Builder a(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramBoolean) {}
    for (int j = 2;; j = 1)
    {
      localJSONObject.put("reddot", j);
      return this;
    }
  }
  
  public String a()
  {
    int j = 1;
    try
    {
      if (this.jdField_a_of_type_Boolean) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("folder_status", RIJKanDianFolderStatus.jdField_a_of_type_Int);
      }
      if (this.jdField_b_of_type_Boolean) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("time", System.currentTimeMillis());
      }
      if (this.jdField_a_of_type_Int != -1) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("channel_id", this.jdField_a_of_type_Int);
      }
      if (this.jdField_c_of_type_Boolean) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("kandian_mode", RIJAppSetting.a());
      }
      if (this.d) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("kandian_mode_new", VideoReporter.a());
      }
      if (this.e) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("tab_source", RIJTransMergeKanDianReport.a());
      }
      if (this.f) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("session_id", RIJKanDianFolderStatus.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_a_of_type_JavaLangString != null) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("skin_id", this.jdField_a_of_type_JavaLangString);
      }
      if (this.jdField_b_of_type_Int != -1) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("skin_voice", this.jdField_b_of_type_Int);
      }
      if (this.jdField_c_of_type_Int != -1) {
        this.jdField_a_of_type_OrgJsonJSONObject.put("skin_type", this.jdField_c_of_type_Int);
      }
      Object localObject;
      if (this.g)
      {
        localObject = this.jdField_a_of_type_OrgJsonJSONObject;
        if (ReadInJoyHelper.z(BaseApplicationImpl.getApplication().getRuntime()) != 1) {
          break label286;
        }
      }
      for (;;)
      {
        ((JSONObject)localObject).put("reddot_style", j);
        if (this.h) {
          VideoReporter.a(this.jdField_a_of_type_OrgJsonJSONObject);
        }
        if (this.i) {
          this.jdField_a_of_type_OrgJsonJSONObject.put("os", "1");
        }
        localObject = this.jdField_a_of_type_OrgJsonJSONObject.toString();
        return localObject;
        label286:
        j = 0;
      }
      return "";
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
  }
  
  public JSONObject a()
  {
    return this.jdField_a_of_type_OrgJsonJSONObject;
  }
  
  public ReportR5Builder b()
  {
    this.jdField_a_of_type_Boolean = true;
    return this;
  }
  
  public ReportR5Builder b(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("location", paramInt);
    return this;
  }
  
  public ReportR5Builder b(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("strategy_id", paramLong);
    return this;
  }
  
  public ReportR5Builder b(String paramString)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("rowkey", paramString);
    return this;
  }
  
  public ReportR5Builder b(String paramString, int paramInt)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString, paramInt);
      return this;
    }
    catch (JSONException localJSONException)
    {
      AIOUtils.a("RIJTransMergeKanDianReport", "", new IllegalArgumentException(paramString + " : " + paramInt));
    }
    return this;
  }
  
  public ReportR5Builder b(String paramString1, String paramString2)
  {
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put(paramString1, paramString2);
      return this;
    }
    catch (JSONException localJSONException)
    {
      AIOUtils.a("RIJTransMergeKanDianReport", "", new IllegalArgumentException(paramString1 + " : " + paramString2));
    }
    return this;
  }
  
  public ReportR5Builder b(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramBoolean) {}
    for (int j = 0;; j = 1)
    {
      localJSONObject.put("button_state", j);
      return this;
    }
  }
  
  public ReportR5Builder c()
  {
    this.jdField_b_of_type_Boolean = true;
    return this;
  }
  
  public ReportR5Builder c(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("type", paramInt);
    return this;
  }
  
  public ReportR5Builder c(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("article_id", paramLong);
    return this;
  }
  
  public ReportR5Builder c(String paramString)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("algorithm_id", paramString);
    return this;
  }
  
  public ReportR5Builder c(boolean paramBoolean)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramBoolean) {}
    for (int j = 2;; j = 0)
    {
      localJSONObject.put("reddot_status", j);
      return this;
    }
  }
  
  public ReportR5Builder d()
  {
    this.g = true;
    return this;
  }
  
  public ReportR5Builder d(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public ReportR5Builder d(long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("topicid", paramLong);
    return this;
  }
  
  public ReportR5Builder d(String paramString)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("strategy_id", paramString);
    return this;
  }
  
  public ReportR5Builder e()
  {
    this.jdField_c_of_type_Boolean = true;
    return this;
  }
  
  public ReportR5Builder e(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public ReportR5Builder e(String paramString)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("feeds_source", paramString);
    return this;
  }
  
  public ReportR5Builder f()
  {
    this.d = true;
    return this;
  }
  
  public ReportR5Builder f(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("number", paramInt);
    return this;
  }
  
  public ReportR5Builder f(String paramString)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramString != null) {}
    for (;;)
    {
      localJSONObject.put("title", paramString);
      return this;
      paramString = "";
    }
  }
  
  public ReportR5Builder g()
  {
    this.e = true;
    return this;
  }
  
  public ReportR5Builder g(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("words", paramInt);
    return this;
  }
  
  public ReportR5Builder g(String paramString)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramString != null) {}
    for (;;)
    {
      localJSONObject.put("sid", paramString);
      return this;
      paramString = "";
    }
  }
  
  public ReportR5Builder h()
  {
    this.f = true;
    return this;
  }
  
  public ReportR5Builder h(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("likes", paramInt);
    return this;
  }
  
  public ReportR5Builder h(String paramString)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramString != null) {}
    for (;;)
    {
      localJSONObject.put("channel_version", paramString);
      return this;
      paramString = "";
    }
  }
  
  public ReportR5Builder i()
  {
    this.i = true;
    return this;
  }
  
  public ReportR5Builder i(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("comment", paramInt);
    return this;
  }
  
  public ReportR5Builder i(String paramString)
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (paramString != null) {}
    for (;;)
    {
      localJSONObject.put("channel_city", paramString);
      return this;
      paramString = "";
    }
  }
  
  public ReportR5Builder j()
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("imei", RIJAppSetting.b());
    return this;
  }
  
  public ReportR5Builder j(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("biu", paramInt);
    return this;
  }
  
  public ReportR5Builder k()
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("imsi", RIJAppSetting.c());
    return this;
  }
  
  public ReportR5Builder k(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("feeds_type", paramInt);
    return this;
  }
  
  public ReportR5Builder l()
  {
    JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
    if (NetworkUtil.h(null)) {}
    for (int j = 2;; j = 1)
    {
      localJSONObject.put("network_type", j);
      return this;
    }
  }
  
  public ReportR5Builder l(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("reddot_num", paramInt);
    return this;
  }
  
  public ReportR5Builder m()
  {
    return b("version", VideoReporter.jdField_a_of_type_JavaLangString);
  }
  
  public ReportR5Builder m(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("content_type", paramInt);
    return this;
  }
  
  public ReportR5Builder n(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("reddot_status", paramInt + 1);
    return this;
  }
  
  public ReportR5Builder o(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("share_option", paramInt);
    return this;
  }
  
  public ReportR5Builder p(int paramInt)
  {
    this.jdField_a_of_type_OrgJsonJSONObject.put("ad_relative_pos", paramInt);
    return this;
  }
  
  public String toString()
  {
    return a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.decoupling.uilayer.framewrok.report.RIJTransMergeKanDianReport.ReportR5Builder
 * JD-Core Version:    0.7.0.1
 */