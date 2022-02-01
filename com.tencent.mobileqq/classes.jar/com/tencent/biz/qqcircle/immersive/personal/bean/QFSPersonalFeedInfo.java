package com.tencent.biz.qqcircle.immersive.personal.bean;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import feedcloud.FeedCloudMeta.StFeed;
import feedcloud.FeedCloudMeta.StImage;
import feedcloud.FeedCloudMeta.StLike;
import feedcloud.FeedCloudMeta.StRight;

public class QFSPersonalFeedInfo
{
  private String a = "";
  private final FeedCloudMeta.StFeed b;
  private String c = "";
  private String d = "";
  private String e = "";
  private int f = 0;
  private long g = 0L;
  private int h;
  private int i = 100101;
  
  public QFSPersonalFeedInfo(String paramString, FeedCloudMeta.StFeed paramStFeed, int paramInt)
  {
    this.a = paramString;
    this.b = paramStFeed;
    if (paramStFeed != null)
    {
      this.c = paramStFeed.id.get();
      this.d = paramStFeed.cover.picUrl.get();
      this.e = paramStFeed.right.iconUrl.get();
      this.h = paramInt;
    }
  }
  
  public QFSPersonalFeedInfo(String paramString, FeedCloudMeta.StFeed paramStFeed, int paramInt1, int paramInt2)
  {
    this(paramString, paramStFeed, paramInt1);
    this.i = paramInt2;
  }
  
  public FeedCloudMeta.StFeed a()
  {
    return this.b;
  }
  
  public void a(int paramInt)
  {
    this.f = paramInt;
  }
  
  public void a(long paramLong)
  {
    this.g = paramLong;
  }
  
  public void a(String paramString)
  {
    this.d = paramString;
  }
  
  public String b()
  {
    return this.c;
  }
  
  public void b(int paramInt)
  {
    this.i = paramInt;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public String d()
  {
    return this.e;
  }
  
  public String e()
  {
    return this.a;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {
      return true;
    }
    if (paramObject != null)
    {
      if (getClass() != paramObject.getClass()) {
        return false;
      }
      paramObject = (QFSPersonalFeedInfo)paramObject;
      return (this.b != null) && (this.c.equals(paramObject.c)) && (this.b.commentCount.get() == paramObject.b.commentCount.get()) && (this.b.likeInfo.count.get() == paramObject.b.likeInfo.count.get()) && (this.b.likeInfo.status.get() == paramObject.b.likeInfo.status.get()) && (this.d.equals(paramObject.d));
    }
    return false;
  }
  
  public int f()
  {
    return this.f;
  }
  
  public int g()
  {
    return this.h;
  }
  
  public int h()
  {
    return this.i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("QFSPersonalFeedInfo{ownerUin='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", coverUrl='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", draftCount=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", createTime=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", sourceType=");
    localStringBuilder.append(this.h);
    localStringBuilder.append(", itemType=");
    localStringBuilder.append(this.i);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.personal.bean.QFSPersonalFeedInfo
 * JD-Core Version:    0.7.0.1
 */