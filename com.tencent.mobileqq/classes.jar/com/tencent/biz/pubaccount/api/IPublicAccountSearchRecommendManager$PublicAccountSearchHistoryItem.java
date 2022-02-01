package com.tencent.biz.pubaccount.api;

public class IPublicAccountSearchRecommendManager$PublicAccountSearchHistoryItem
{
  public long a;
  public String a;
  public boolean a;
  public String b;
  
  public IPublicAccountSearchRecommendManager$PublicAccountSearchHistoryItem(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PublicAccountSearchHistoryItem->uin:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", name:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isPublicAccount:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", time:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem
 * JD-Core Version:    0.7.0.1
 */