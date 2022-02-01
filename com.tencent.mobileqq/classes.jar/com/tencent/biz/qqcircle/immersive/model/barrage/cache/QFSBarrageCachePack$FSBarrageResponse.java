package com.tencent.biz.qqcircle.immersive.model.barrage.cache;

import feedcloud.FeedCloudCommon.StCommonExt;

public class QFSBarrageCachePack$FSBarrageResponse
{
  private boolean a;
  private FeedCloudCommon.StCommonExt b;
  private String c;
  private boolean d;
  
  public static FSBarrageResponse a()
  {
    return new FSBarrageResponse();
  }
  
  public FSBarrageResponse a(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public FSBarrageResponse a(boolean paramBoolean)
  {
    this.a = paramBoolean;
    return this;
  }
  
  public FSBarrageResponse b(boolean paramBoolean)
  {
    this.d = paramBoolean;
    return this;
  }
  
  public boolean b()
  {
    return this.a;
  }
  
  public String c()
  {
    return this.c;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FSCommentResponse{mHasMore=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mCommonExt=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mFeedAttachInfo='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mHasResponse=");
    localStringBuilder.append(this.d);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqcircle.immersive.model.barrage.cache.QFSBarrageCachePack.FSBarrageResponse
 * JD-Core Version:    0.7.0.1
 */