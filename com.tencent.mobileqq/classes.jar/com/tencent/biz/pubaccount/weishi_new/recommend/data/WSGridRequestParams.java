package com.tencent.biz.pubaccount.weishi_new.recommend.data;

import android.text.TextUtils;
import java.util.ArrayList;

public class WSGridRequestParams
{
  private final long jdField_a_of_type_Long;
  private String jdField_a_of_type_JavaLangString;
  private final boolean jdField_a_of_type_Boolean;
  private String jdField_b_of_type_JavaLangString;
  private final boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private final boolean jdField_c_of_type_Boolean;
  private String d;
  
  public WSGridRequestParams(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.jdField_b_of_type_Boolean = paramBoolean2;
    this.jdField_c_of_type_Boolean = paramBoolean3;
    this.jdField_a_of_type_Long = System.currentTimeMillis();
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public WSGridRequestParams a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public ArrayList<String> a()
  {
    ArrayList localArrayList = new ArrayList();
    if (!TextUtils.isEmpty(this.d)) {
      localArrayList.add(this.d);
    }
    return localArrayList;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public WSGridRequestParams b(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
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
  
  public WSGridRequestParams c(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
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
  
  public WSGridRequestParams d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public String toString()
  {
    return "WSGridRequestParams{mIsRefresh=" + this.jdField_a_of_type_Boolean + ", mIsFirstFromService=" + this.jdField_b_of_type_Boolean + ", mIsRedDotCacheValid=" + this.jdField_c_of_type_Boolean + ", mStartLoadTimestamp=" + this.jdField_a_of_type_Long + ", mSubTabId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", mPushInfo='" + this.jdField_b_of_type_JavaLangString + '\'' + ", mRowKey='" + this.jdField_c_of_type_JavaLangString + '\'' + ", mLastFeedId='" + this.d + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.recommend.data.WSGridRequestParams
 * JD-Core Version:    0.7.0.1
 */