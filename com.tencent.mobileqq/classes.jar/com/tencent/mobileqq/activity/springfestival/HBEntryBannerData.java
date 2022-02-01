package com.tencent.mobileqq.activity.springfestival;

import com.tencent.mobileqq.activity.springfestival.entry.helper.SpringHbHelper;
import com.tencent.mobileqq.activity.springfestival.entry.model.MiniAppEntryData;
import com.tencent.mobileqq.mini.entry.desktop.item.DesktopItemInfo;

public class HBEntryBannerData
  extends DesktopItemInfo
{
  private int jdField_a_of_type_Int = 0;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private String d;
  private String e;
  private String f;
  private String g;
  private String h;
  private String i;
  private String j;
  private String k;
  private String l;
  private String m;
  
  public HBEntryBannerData() {}
  
  public HBEntryBannerData(MiniAppEntryData paramMiniAppEntryData, int paramInt, String paramString)
  {
    if (paramMiniAppEntryData != null)
    {
      this.jdField_b_of_type_JavaLangString = paramMiniAppEntryData.contentBgUrl;
      this.jdField_a_of_type_JavaLangString = paramMiniAppEntryData.bgUrl;
      this.d = paramMiniAppEntryData.headImgUrl;
      this.g = paramMiniAppEntryData.rightBubbleUrl;
      this.f = paramMiniAppEntryData.leftBubbleUrl;
      this.e = paramMiniAppEntryData.nextLogoUrl;
      this.l = paramMiniAppEntryData.jumpUrl;
      this.jdField_b_of_type_Int = paramMiniAppEntryData.entryStyle;
      this.h = paramMiniAppEntryData.preWording;
      this.i = paramMiniAppEntryData.endWording;
      this.j = paramMiniAppEntryData.leftBubbleJumpUrl;
      this.k = paramMiniAppEntryData.rightBubbleJumpUrl;
      this.jdField_a_of_type_Boolean = paramMiniAppEntryData.isShowFireWork;
      this.jdField_a_of_type_Int = paramMiniAppEntryData.fireWorkPlayCount;
      this.jdField_c_of_type_JavaLangString = paramMiniAppEntryData.fireworkImgUrl;
    }
    this.m = paramString;
    this.jdField_c_of_type_Int = paramInt;
    SpringHbHelper.a(this.jdField_b_of_type_JavaLangString);
    SpringHbHelper.a(this.jdField_a_of_type_JavaLangString);
    SpringHbHelper.a(this.d);
    SpringHbHelper.a(this.g);
    SpringHbHelper.a(this.f);
    SpringHbHelper.a(this.e);
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String a()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public String b()
  {
    return "HBEntryBannerData{miniDesktopBackUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", bannerBackgroundUrl='" + this.jdField_b_of_type_JavaLangString + '\'' + ", bannerPlaqueUrl='" + this.d + '\'' + ", bannerMerchantsIconUrl='" + this.e + '\'' + ", bannerIcon1Url='" + this.f + '\'' + ", bannerIcon2Url='" + this.g + '\'' + ", bannerText1='" + this.h + '\'' + ", bannerText2='" + this.i + '\'' + ", entryActivityId='" + this.m + '\'' + ", bannerIconScheme1='" + this.j + '\'' + ", bannerIconScheme2='" + this.k + '\'' + ", bannerClickScheme='" + this.l + '\'' + ", bannerLayoutStyle='" + this.jdField_b_of_type_Int + '\'' + ", entryActivityType='" + this.jdField_c_of_type_Int + '\'' + '}';
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String e()
  {
    return this.d;
  }
  
  public String f()
  {
    return this.e;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.springfestival.HBEntryBannerData
 * JD-Core Version:    0.7.0.1
 */