package com.tencent.biz.pubaccount.weishi_new.verticalvideo.data;

import com.tencent.biz.pubaccount.weishi_new.data.FetcherParams;

public class WSCollectionRequestParams
  extends FetcherParams
{
  public int a;
  public String a;
  public boolean a;
  public String b;
  public boolean b;
  
  public WSCollectionRequestParams()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WSCollectionRequestParams{isFirst=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", isRefresh=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", cid='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", pageOrder=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSCollectionRequestParams
 * JD-Core Version:    0.7.0.1
 */