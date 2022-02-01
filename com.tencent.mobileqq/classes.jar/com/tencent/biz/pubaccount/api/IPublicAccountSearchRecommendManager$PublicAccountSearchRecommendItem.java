package com.tencent.biz.pubaccount.api;

public class IPublicAccountSearchRecommendManager$PublicAccountSearchRecommendItem
{
  public String a;
  public String b;
  public boolean c;
  
  public IPublicAccountSearchRecommendManager$PublicAccountSearchRecommendItem(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.c = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PublicAccountSearchRecommendItem->uin:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isPublicAccount:");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.PublicAccountSearchRecommendItem
 * JD-Core Version:    0.7.0.1
 */