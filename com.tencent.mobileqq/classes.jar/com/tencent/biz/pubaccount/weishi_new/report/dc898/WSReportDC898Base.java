package com.tencent.biz.pubaccount.weishi_new.report.dc898;

import android.text.TextUtils;
import com.google.gson.Gson;
import com.tencent.biz.pubaccount.weishi_new.report.WSReportDc00898;
import com.tencent.biz.qqstory.utils.WeishiGuideUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class WSReportDC898Base
  implements WSReportDC898Const
{
  private final IWSDCParam jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportDc898IWSDCParam;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  WSReportDC898Base(IWSDCParam paramIWSDCParam)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newReportDc898IWSDCParam = paramIWSDCParam;
  }
  
  private String a()
  {
    Map localMap = a();
    if (localMap == null) {
      return "";
    }
    return new Gson().toJson(localMap);
  }
  
  private boolean a(int paramInt)
  {
    return (paramInt == 100) || (paramInt == 104) || (paramInt == 103) || (paramInt == 102) || (paramInt == 101) || (paramInt == 300) || (paramInt == 501) || (paramInt == 601) || (paramInt == 602) || (paramInt == 603);
  }
  
  public String a(int paramInt)
  {
    Map localMap = a();
    if (localMap == null) {
      return String.valueOf(paramInt);
    }
    localMap.put("op_id", String.valueOf(paramInt));
    return new Gson().toJson(localMap);
  }
  
  public Map<String, String> a()
  {
    if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (TextUtils.isEmpty(this.b))) {
      return null;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("play_scene", this.jdField_a_of_type_JavaLangString);
    localHashMap.put("sop_name", this.b);
    return localHashMap;
  }
  
  public void a()
  {
    b("videoplay_close", 0, 0, 0L, 0L, a());
  }
  
  public void a(int paramInt)
  {
    String str = "";
    if (!a(paramInt)) {
      str = a();
    }
    a(WSReportDc00898.a(paramInt, true), 0, 0, 0L, 0L, str);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a("videolay_tag_entry_exp", paramInt1, 0, 0L, 0L, a(paramInt2));
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    String str = a(paramInt2);
    a("videolay_tag_clk", paramInt1, 0, 0L, 0L, str);
    a(paramString, paramInt1, 0, 0L, 0L, str);
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new WSReportDC898Base.1(this, paramString1, paramInt1, paramInt2, paramLong1, paramLong2, paramString2));
  }
  
  public void a(Map<String, String> paramMap)
  {
    Map localMap = a();
    if (localMap != null) {
      localMap.putAll(paramMap);
    }
    for (paramMap = new Gson().toJson(localMap);; paramMap = new Gson().toJson(paramMap))
    {
      b("video_play", 0, 0, 0L, 0L, paramMap);
      return;
    }
  }
  
  public void b()
  {
    b("videoplay_more_clk", 0, 0, 0L, 0L, a());
  }
  
  public void b(int paramInt)
  {
    String str = "";
    if (!a(paramInt)) {
      str = a();
    }
    a(WSReportDc00898.a(paramInt, false), 0, 0, 0L, 0L, str);
  }
  
  public void b(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void b(String paramString, int paramInt1, int paramInt2)
  {
    a(paramString, paramInt1, 0, 0L, 0L, a(paramInt2));
  }
  
  public void b(String paramString1, int paramInt1, int paramInt2, long paramLong1, long paramLong2, String paramString2)
  {
    ThreadManager.getSubThreadHandler().post(new WSReportDC898Base.2(this, paramString1, paramInt1, paramInt2, paramLong1, paramLong2, paramString2));
  }
  
  public void c()
  {
    a("follow_entry_clk", 0, 0, 0L, 0L, a());
  }
  
  public void c(String paramString)
  {
    a(paramString, 0, 0, 0L, 0L, a());
  }
  
  public void c(String paramString, int paramInt1, int paramInt2)
  {
    Map localMap = a();
    String str = "";
    if (localMap != null)
    {
      localMap.put("url", paramString);
      str = new Gson().toJson(localMap);
    }
    b("blockpage_exp", paramInt1, 0, 0L, paramInt2, str);
  }
  
  public void d()
  {
    b("profpic_clkc", 0, 0, 0L, 0L, a());
  }
  
  public void e()
  {
    String str2 = a();
    a("videoplay_title_clk", 0, 0, 0L, 0L, str2);
    if (WeishiGuideUtils.a(BaseApplicationImpl.sApplication)) {}
    for (String str1 = "videoplay_title_clk_ws";; str1 = "videoplay_title_dl_ws")
    {
      a(str1, 0, 0, 0L, 0L, str2);
      return;
    }
  }
  
  public void f()
  {
    b("fullscreen_exp", 0, 0, 0L, 0L, a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Base
 * JD-Core Version:    0.7.0.1
 */