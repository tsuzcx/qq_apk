package com.tencent.biz.qqstory.base.videoupload;

import com.tencent.biz.qqstory.base.BaseEvent;

public class VideoCompositeManager$CompositeResult
  extends BaseEvent
{
  public String a;
  public String b;
  
  public VideoCompositeManager$CompositeResult(VideoCompositeManager paramVideoCompositeManager) {}
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("CompositeVideoEvent{vid='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", errorInfo='");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage);
    localStringBuilder.append('\'');
    localStringBuilder.append(", videoUrl='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.videoupload.VideoCompositeManager.CompositeResult
 * JD-Core Version:    0.7.0.1
 */