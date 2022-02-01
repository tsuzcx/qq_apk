package com.tencent.biz.pubaccount.weishi_new.verticalvideo;

import UserGrowth.stCollection;
import UserGrowth.stSimpleMetaFeed;
import android.content.Context;
import java.util.List;

public class WSVerticalPageOpenParams
{
  private int jdField_a_of_type_Int;
  private stCollection jdField_a_of_type_UserGrowthStCollection;
  private final Context jdField_a_of_type_AndroidContentContext;
  private final String jdField_a_of_type_JavaLangString;
  private List<stSimpleMetaFeed> jdField_a_of_type_JavaUtilList;
  private boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  
  public WSVerticalPageOpenParams(Context paramContext, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
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
  
  public WSVerticalPageOpenParams a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public WSVerticalPageOpenParams a(stCollection paramstCollection)
  {
    this.jdField_a_of_type_UserGrowthStCollection = paramstCollection;
    return this;
  }
  
  public WSVerticalPageOpenParams a(String paramString)
  {
    this.c = paramString;
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
  
  public String c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageOpenParams
 * JD-Core Version:    0.7.0.1
 */