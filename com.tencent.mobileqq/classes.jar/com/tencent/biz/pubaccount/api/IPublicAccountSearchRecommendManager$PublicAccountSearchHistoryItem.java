package com.tencent.biz.pubaccount.api;

public class IPublicAccountSearchRecommendManager$PublicAccountSearchHistoryItem
{
  public String a;
  public String b;
  public boolean c;
  public long d;
  
  public IPublicAccountSearchRecommendManager$PublicAccountSearchHistoryItem(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
  {
    this.a = paramString1;
    this.b = paramString2;
    this.d = paramLong;
    this.c = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("PublicAccountSearchHistoryItem->uin:");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", name:");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isPublicAccount:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", time:");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.pubaccount.api.IPublicAccountSearchRecommendManager.PublicAccountSearchHistoryItem
 * JD-Core Version:    0.7.0.1
 */