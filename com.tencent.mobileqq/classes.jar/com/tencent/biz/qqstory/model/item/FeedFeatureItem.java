package com.tencent.biz.qqstory.model.item;

import com.tencent.biz.qqstory.network.pb.qqstory_struct.FeedFeature;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class FeedFeatureItem
{
  public int a;
  public String a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  
  public void a(qqstory_struct.FeedFeature paramFeedFeature)
  {
    this.jdField_a_of_type_JavaLangString = paramFeedFeature.feed_id.get().toStringUtf8();
    this.jdField_a_of_type_Int = paramFeedFeature.total_like_num.get();
    this.jdField_b_of_type_Int = paramFeedFeature.total_comment_num.get();
    this.c = paramFeedFeature.total_viewing_num.get();
    int i = paramFeedFeature.deny_comment.get();
    boolean bool2 = false;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.jdField_a_of_type_Boolean = bool1;
    boolean bool1 = bool2;
    if (paramFeedFeature.has_like.get() == 1) {
      bool1 = true;
    }
    this.jdField_b_of_type_Boolean = bool1;
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
      String str = this.jdField_a_of_type_JavaLangString;
      if (str != null) {
        return str.equals(paramObject.jdField_a_of_type_JavaLangString);
      }
      return paramObject.jdField_a_of_type_JavaLangString == null;
    }
    return false;
  }
  
  public int hashCode()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    if (str != null) {
      return str.hashCode();
    }
    return 0;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeedFeatureItem{feedId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", totalLikeCount=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", totalCommentCount=");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", totalViewCount=");
    localStringBuilder.append(this.c);
    localStringBuilder.append(", isDenyComment=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.item.FeedFeatureItem
 * JD-Core Version:    0.7.0.1
 */