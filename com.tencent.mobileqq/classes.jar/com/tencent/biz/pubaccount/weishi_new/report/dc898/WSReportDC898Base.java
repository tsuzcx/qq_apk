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
  private String a;
  private String b;
  private final IWSDCParam c;
  
  WSReportDC898Base(IWSDCParam paramIWSDCParam)
  {
    this.c = paramIWSDCParam;
  }
  
  private boolean d(int paramInt)
  {
    return (paramInt == 100) || (paramInt == 104) || (paramInt == 103) || (paramInt == 102) || (paramInt == 101) || (paramInt == 300) || (paramInt == 501) || (paramInt == 601) || (paramInt == 602) || (paramInt == 603);
  }
  
  private String h()
  {
    Map localMap = a();
    if (localMap == null) {
      return "";
    }
    return new Gson().toJson(localMap);
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
    if ((!TextUtils.isEmpty(this.a)) && (!TextUtils.isEmpty(this.b)))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("play_scene", this.a);
      localHashMap.put("sop_name", this.b);
      return localHashMap;
    }
    return null;
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
    if (localMap != null)
    {
      localMap.putAll(paramMap);
      paramMap = new Gson().toJson(localMap);
    }
    else
    {
      paramMap = new Gson().toJson(paramMap);
    }
    b("video_play", 0, 0, 0L, 0L, paramMap);
  }
  
  public void b()
  {
    b("videoplay_close", 0, 0, 0L, 0L, h());
  }
  
  public void b(int paramInt)
  {
    String str;
    if (!d(paramInt)) {
      str = h();
    } else {
      str = "";
    }
    a(WSReportDc00898.a(paramInt, true), 0, 0, 0L, 0L, str);
  }
  
  public void b(String paramString)
  {
    this.a = paramString;
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
    b("videoplay_more_clk", 0, 0, 0L, 0L, h());
  }
  
  public void c(int paramInt)
  {
    String str;
    if (!d(paramInt)) {
      str = h();
    } else {
      str = "";
    }
    a(WSReportDc00898.a(paramInt, false), 0, 0, 0L, 0L, str);
  }
  
  public void c(String paramString)
  {
    a(paramString, 0, 0, 0L, 0L, h());
  }
  
  public void c(String paramString, int paramInt1, int paramInt2)
  {
    Map localMap = a();
    if (localMap != null)
    {
      localMap.put("url", paramString);
      paramString = new Gson().toJson(localMap);
    }
    else
    {
      paramString = "";
    }
    b("blockpage_exp", paramInt1, 0, 0L, paramInt2, paramString);
  }
  
  public void d()
  {
    a("follow_entry_clk", 0, 0, 0L, 0L, h());
  }
  
  public void e()
  {
    b("profpic_clkc", 0, 0, 0L, 0L, h());
  }
  
  public void f()
  {
    String str2 = h();
    a("videoplay_title_clk", 0, 0, 0L, 0L, str2);
    String str1;
    if (WeishiGuideUtils.a(BaseApplicationImpl.sApplication)) {
      str1 = "videoplay_title_clk_ws";
    } else {
      str1 = "videoplay_title_dl_ws";
    }
    a(str1, 0, 0, 0L, 0L, str2);
  }
  
  public void g()
  {
    b("fullscreen_exp", 0, 0, 0L, 0L, h());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.report.dc898.WSReportDC898Base
 * JD-Core Version:    0.7.0.1
 */