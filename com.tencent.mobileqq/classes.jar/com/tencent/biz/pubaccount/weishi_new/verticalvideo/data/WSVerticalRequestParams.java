package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;

public class WSVerticalRequestParams
{
  private final int jdField_a_of_type_Int;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private final boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString = "";
  private final boolean jdField_b_of_type_Boolean;
  
  public WSVerticalRequestParams(int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public WSVerticalRequestParams a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
    return this;
  }
  
  public WSVerticalRequestParams a(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public WSVerticalRequestParams a(ArrayList<String> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
    return this;
  }
  
  public Object a()
  {
    return this.jdField_a_of_type_JavaLangObject;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public ArrayList<String> a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public WSVerticalRequestParams b(String paramString)
  {
    if (!this.jdField_b_of_type_Boolean) {
      paramString = "";
    }
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSVerticalRequestParams{mScene=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", mIsRefresh=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mIsFirst=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", mPushInfo='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mContextFeedIds=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilArrayList);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalRequestParams
 * JD-Core Version:    0.7.0.1
 */