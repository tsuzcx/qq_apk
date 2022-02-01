package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import android.os.Bundle;
import java.util.List;

public class WSVerticalPageOpenParams
{
  private int jdField_a_of_type_Int;
  private stCollection jdField_a_of_type_UserGrowthStCollection;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private final String jdField_a_of_type_JavaLangString;
  private List<stSimpleMetaFeed> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString = "";
  private boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString = "";
  private boolean jdField_d_of_type_Boolean = false;
  private String e = "";
  private String f = "";
  private String g = "";
  
  public WSVerticalPageOpenParams(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public WSVerticalPageOpenParams(String paramString1, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public stCollection a()
  {
    return this.jdField_a_of_type_UserGrowthStCollection;
  }
  
  public Context a()
  {
    return this.jdField_a_of_type_AndroidContentContext;
  }
  
  public Bundle a()
  {
    return this.jdField_a_of_type_AndroidOsBundle;
  }
  
  public WSVerticalPageOpenParams a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public WSVerticalPageOpenParams a(Bundle paramBundle)
  {
    this.jdField_a_of_type_AndroidOsBundle = paramBundle;
    return this;
  }
  
  public WSVerticalPageOpenParams a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
    return this;
  }
  
  public WSVerticalPageOpenParams a(List<stSimpleMetaFeed> paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    return this;
  }
  
  public WSVerticalPageOpenParams a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public List<stSimpleMetaFeed> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public WSVerticalPageOpenParams b(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public WSVerticalPageOpenParams b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
    return this;
  }
  
  public WSVerticalPageOpenParams b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public WSVerticalPageOpenParams c(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
    return this;
  }
  
  public WSVerticalPageOpenParams c(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public WSVerticalPageOpenParams c(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public WSVerticalPageOpenParams d(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public WSVerticalPageOpenParams d(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
    return this;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
  
  public WSVerticalPageOpenParams e(String paramString)
  {
    this.g = paramString;
    return this;
  }
  
  public String e()
  {
    return this.e;
  }
  
  public String f()
  {
    return this.f;
  }
  
  public String g()
  {
    return this.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSVerticalPageOpenParams{from='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", playScene='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", subTabId='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", needScrollToPosition=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", clearTop=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", isNeedCalcDeltaTime=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", collection=");
    localStringBuilder.append(this.jdField_a_of_type_UserGrowthStCollection);
    localStringBuilder.append(", collectionId=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", feeds=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", context=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidContentContext);
    localStringBuilder.append(", extBundle=");
    localStringBuilder.append(this.jdField_a_of_type_AndroidOsBundle);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams
 * JD-Core Version:    0.7.0.1
 */