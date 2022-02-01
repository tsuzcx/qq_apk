package com.tencent.biz.qqstory.playvideo.lrtbwidget;

import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;

public class PlayVideoChangeEvent
  extends BaseEvent
{
  public IDataProvider.GroupId a;
  public String a;
  public String b;
  
  public PlayVideoChangeEvent(@Nullable String paramString1, IDataProvider.GroupId paramGroupId, String paramString2)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramGroupId;
    this.b = paramString2;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PlayVideoChangeEvent{openPlayerSessionId='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append(", groupId=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.b);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayVideoChangeEvent
 * JD-Core Version:    0.7.0.1
 */