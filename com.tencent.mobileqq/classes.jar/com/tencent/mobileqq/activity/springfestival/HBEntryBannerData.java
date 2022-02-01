package com.tencent.mobileqq.activity.springfestival;

import com.tencent.mobileqq.activity.springfestival.entry.helper.SpringHbHelper;
import com.tencent.mobileqq.activity.springfestival.entry.model.MiniAppEntryData;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;

public class HBEntryBannerData
  extends DesktopItemInfo
{
  private String a;
  private String b;
  private boolean c = false;
  private int d = 0;
  private String e = "";
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  private String n;
  private int o;
  private int p;
  private String q;
  
  public HBEntryBannerData() {}
  
  public HBEntryBannerData(MiniAppEntryData paramMiniAppEntryData, int paramInt, String paramString)
  {
    if (paramMiniAppEntryData != null)
    {
      this.b = paramMiniAppEntryData.contentBgUrl;
      this.a = paramMiniAppEntryData.bgUrl;
      this.f = paramMiniAppEntryData.headImgUrl;
      this.i = paramMiniAppEntryData.rightBubbleUrl;
      this.h = paramMiniAppEntryData.leftBubbleUrl;
      this.g = paramMiniAppEntryData.nextLogoUrl;
      this.n = paramMiniAppEntryData.jumpUrl;
      this.o = paramMiniAppEntryData.entryStyle;
      this.j = paramMiniAppEntryData.preWording;
      this.k = paramMiniAppEntryData.endWording;
      this.l = paramMiniAppEntryData.leftBubbleJumpUrl;
      this.m = paramMiniAppEntryData.rightBubbleJumpUrl;
      this.c = paramMiniAppEntryData.isShowFireWork;
      this.d = paramMiniAppEntryData.fireWorkPlayCount;
      this.e = paramMiniAppEntryData.fireworkImgUrl;
    }
    this.q = paramString;
    this.p = paramInt;
    SpringHbHelper.a(this.b);
    SpringHbHelper.a(this.a);
    SpringHbHelper.a(this.f);
    SpringHbHelper.a(this.i);
    SpringHbHelper.a(this.h);
    SpringHbHelper.a(this.g);
  }
  
  public boolean a()
  {
    return this.c;
  }
  
  public int b()
  {
    return this.d;
  }
  
  public String c()
  {
    return this.e;
  }
  
  public String d()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HBEntryBannerData{miniDesktopBackUrl='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerBackgroundUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerPlaqueUrl='");
    localStringBuilder.append(this.f);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerMerchantsIconUrl='");
    localStringBuilder.append(this.g);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerIcon1Url='");
    localStringBuilder.append(this.h);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerIcon2Url='");
    localStringBuilder.append(this.i);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerText1='");
    localStringBuilder.append(this.j);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerText2='");
    localStringBuilder.append(this.k);
    localStringBuilder.append('\'');
    localStringBuilder.append(", entryActivityId='");
    localStringBuilder.append(this.q);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerIconScheme1='");
    localStringBuilder.append(this.l);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerIconScheme2='");
    localStringBuilder.append(this.m);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerClickScheme='");
    localStringBuilder.append(this.n);
    localStringBuilder.append('\'');
    localStringBuilder.append(", bannerLayoutStyle='");
    localStringBuilder.append(this.o);
    localStringBuilder.append('\'');
    localStringBuilder.append(", entryActivityType='");
    localStringBuilder.append(this.p);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public String e()
  {
    return this.a;
  }
  
  public String f()
  {
    return this.b;
  }
  
  public String g()
  {
    return this.f;
  }
  
  public String h()
  {
    return this.g;
  }
  
  public String i()
  {
    return this.h;
  }
  
  public String j()
  {
    return this.i;
  }
  
  public String k()
  {
    return this.j;
  }
  
  public String l()
  {
    return this.k;
  }
  
  public String m()
  {
    return this.l;
  }
  
  public String n()
  {
    return this.m;
  }
  
  public String o()
  {
    return this.n;
  }
  
  public int p()
  {
    return this.o;
  }
  
  public int q()
  {
    return this.p;
  }
  
  public String r()
  {
    return this.q;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryBannerData
 * JD-Core Version:    0.7.0.1
 */