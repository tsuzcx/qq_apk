package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedFeature;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class FeedFeatureItem
{
  public String a;
  public int b;
  public int c;
  public int d;
  public boolean e;
  public boolean f;
  
  public void a(qqstory_struct.FeedFeature paramFeedFeature)
  {
    this.a = paramFeedFeature.feed_id.get().toStringUtf8();
    this.b = paramFeedFeature.total_like_num.get();
    this.c = paramFeedFeature.total_comment_num.get();
    this.d = paramFeedFeature.total_viewing_num.get();
    int i = paramFeedFeature.deny_comment.get();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.e = bool1;
    boolean bool1 = bool2;
    if (paramFeedFeature.has_like.get() == 1) {
      bool1 = true;
    }
    this.f = bool1;
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
      paramObject = (FeedFeatureItem)paramObject;
      String str = this.a;
      if (str != null) {
        return str.equals(paramObject.a);
      }
      return paramObject.a == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.a;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeedFeatureItem{feedId='");
    localStringBuilder.append(this.a);
    localStringBuilder.append('\'');
    localStringBuilder.append(", totalLikeCount=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", totalCommentCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", totalViewCount=");
    localStringBuilder.append(this.d);
    localStringBuilder.append(", isDenyComment=");
    localStringBuilder.append(this.e);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.FeedFeatureItem
 * JD-Core Version:    0.7.0.1
 */