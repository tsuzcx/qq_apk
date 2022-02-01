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
    return "UpdateMsgTabCoverEvent{, groupId=" + this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoDataproviderIDataProvider$GroupId + ", vid='" + this.jdField_a_of_type_JavaLangString + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.UpdateMsgTabCoverEvent
 * JD-Core Version:    0.7.0.1
 */