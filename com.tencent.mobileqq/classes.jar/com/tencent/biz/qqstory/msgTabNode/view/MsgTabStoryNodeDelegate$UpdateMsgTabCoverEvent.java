package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.biz.qqstory.base.BaseEvent;
import com.tencent.biz.qqstory.playvideo.dataprovider.IDataProvider.GroupId;

public class MsgTabStoryNodeDelegate$UpdateMsgTabCoverEvent
  extends BaseEvent
{
  public IDataProvider.GroupId a;
  public String a;
  
  public MsgTabStoryNodeDelegate$UpdateMsgTabCoverEvent(IDataProvider.GroupId paramGroupId, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId = paramGroupId;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("UpdateMsgTabCoverEvent{, groupId=");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId);
    localStringBuilder.append(", vid='");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append('\'');
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.UpdateMsgTabCoverEvent
 * JD-Core Version:    0.7.0.1
 */