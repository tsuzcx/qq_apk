package com.tencent.biz.qqcircle.publish.model;

import FileUpload.MarkUinInfoBeforeUpload;
import NS_MOBILE_OPERATION.PicInfo;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import cooperation.qzone.LbsDataV2.PoiInfo;
import java.util.HashMap;
import java.util.List;

public class ShuoshuoContent
{
  protected HashMap<String, MarkUinInfoBeforeUpload> a = new HashMap();
  protected HashMap<String, Boolean> b = new HashMap();
  protected HashMap<String, Boolean> c = new HashMap();
  private LbsDataV2.PoiInfo d;
  private HashMap<String, PicInfo> e;
  private boolean f = false;
  private String g;
  private String h;
  private LbsDataV2.PoiInfo i;
  private List<String> j;
  private HashMap<String, PicInfo> k;
  private HashMap<String, LocalMediaInfo> l;
  private ShuoshuoVideoInfo m;
  private HashMap<String, Integer> n = new HashMap();
  private int o;
  private HashMap<String, ShuoshuoVideoInfo> p;
  private HashMap<String, HashMap<String, Integer>> q = new HashMap();
  private HashMap<String, ShuoshuoVideoInfo> r;
  private HashMap<String, HashMap<String, Integer>> s = new HashMap();
  private int t = 0;
  private String u;
  private String v;
  private int w;
  
  public LbsDataV2.PoiInfo a()
  {
    return this.d;
  }
  
  public void a(String paramString)
  {
    this.v = paramString;
  }
  
  public void a(HashMap<String, LocalMediaInfo> paramHashMap)
  {
    this.l = paramHashMap;
  }
  
  public void a(List<String> paramList)
  {
    this.j = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.t |= 0x1;
      return;
    }
    this.t &= 0xFFFFFFFE;
  }
  
  public HashMap<String, PicInfo> b()
  {
    return this.e;
  }
  
  public String c()
  {
    return this.g;
  }
  
  public String d()
  {
    return this.h;
  }
  
  public LbsDataV2.PoiInfo e()
  {
    return this.i;
  }
  
  public List<String> f()
  {
    return this.j;
  }
  
  public HashMap<String, PicInfo> g()
  {
    return this.k;
  }
  
  public HashMap<String, LocalMediaInfo> h()
  {
    return this.l;
  }
  
  public ShuoshuoVideoInfo i()
  {
    return this.m;
  }
  
  public int j()
  {
    return this.o;
  }
  
  public int k()
  {
    return this.t;
  }
  
  public String l()
  {
    return this.u;
  }
  
  public String m()
  {
    return this.v;
  }
  
  public int n()
  {
    return this.w;
  }
  
  public HashMap<String, ShuoshuoVideoInfo> o()
  {
    return this.p;
  }
  
  public HashMap<String, ShuoshuoVideoInfo> p()
  {
    return this.r;
  }
  
  public HashMap<String, Boolean> q()
  {
    return this.c;
  }
  
  public HashMap<String, MarkUinInfoBeforeUpload> r()
  {
    return this.a;
  }
  
  public HashMap<String, Boolean> s()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.publish.model.ShuoshuoContent
 * JD-Core Version:    0.7.0.1
 */