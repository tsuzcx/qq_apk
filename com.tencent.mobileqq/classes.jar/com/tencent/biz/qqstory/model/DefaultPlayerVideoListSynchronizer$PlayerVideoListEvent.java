package com.tencent.biz.qqstory.model;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.database.LiveVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.ArrayList;
import java.util.List;

public class DefaultPlayerVideoListSynchronizer$PlayerVideoListEvent
  extends BaseEvent
{
  public int a;
  public long a;
  public LiveVideoEntry a;
  public String a;
  public List<StoryVideoItem> a;
  public boolean a;
  public long b;
  public String b;
  public List<String> b;
  public boolean b;
  public String c;
  public boolean c;
  
  public DefaultPlayerVideoListSynchronizer$PlayerVideoListEvent()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayerVideoListEvent{context='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", uid='");
    localStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", label='");
    localStringBuilder.append(this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", topicId=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", mStoryVideoItems=");
    localStringBuilder.append(this.jdField_a_of_type_JavaUtilList);
    localStringBuilder.append(", totalTime=");
    localStringBuilder.append(this.jdField_b_of_type_Long);
    localStringBuilder.append(", videoCount=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", isFromCache=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", isEnd=");
    localStringBuilder.append(this.jdField_b_of_type_Boolean);
    localStringBuilder.append(", interactStatus=");
    localStringBuilder.append(this.jdField_c_of_type_Boolean);
    localStringBuilder.append(", liveVideoInfo=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryDatabaseLiveVideoEntry);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.DefaultPlayerVideoListSynchronizer.PlayerVideoListEvent
 * JD-Core Version:    0.7.0.1
 */