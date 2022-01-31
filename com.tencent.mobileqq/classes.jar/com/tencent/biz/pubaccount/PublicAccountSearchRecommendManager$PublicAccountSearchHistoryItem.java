package com.tencent.biz.pubaccount;

public class PublicAccountSearchRecommendManager$PublicAccountSearchHistoryItem
{
  public long a;
  public String a;
  public boolean a;
  public String b;
  
  public PublicAccountSearchRecommendManager$PublicAccountSearchHistoryItem(PublicAccountSearchRecommendManager paramPublicAccountSearchRecommendManager, String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String toString()
  {
    return "PublicAccountSearchHistoryItem->uin:" + this.jdField_a_of_type_JavaLangString + ", name:" + this.b + ", isPublicAccount:" + this.jdField_a_of_type_Boolean + ", time:" + this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem
 * JD-Core Version:    0.7.0.1
 */