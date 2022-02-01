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
    return "PlayVideoChangeEvent{openPlayerSessionId='" + this.jdField_a_of_type_JavaLangString + '\'' + ", groupId=" + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId + ", vid='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.playvideo.lrtbwidget.PlayVideoChangeEvent
 * JD-Core Version:    0.7.0.1
 */