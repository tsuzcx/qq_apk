package com.tencent.biz.qqstory.storyHome.model;

import android.support.annotation.Nullable;

public class FeedCommentSync
{
  public int a;
  public String a;
  public int b;
  public String b;
  
  public FeedCommentSync(String paramString1, int paramInt, @Nullable String paramString2)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public FeedCommentSync(String paramString1, int paramInt1, @Nullable String paramString2, int paramInt2)
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public boolean a()
  {
    int i = this.jdField_a_of_type_Int;
    boolean bool = true;
    if (i != 1)
    {
      if (i != 2) {
        return bool;
      }
      if (this.jdField_b_of_type_Int != 0) {
        return true;
      }
    }
    bool = false;
    return bool;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("FeedCommentSync{feedId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mNextCookie='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", mSource=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.model.FeedCommentSync
 * JD-Core Version:    0.7.0.1
 */