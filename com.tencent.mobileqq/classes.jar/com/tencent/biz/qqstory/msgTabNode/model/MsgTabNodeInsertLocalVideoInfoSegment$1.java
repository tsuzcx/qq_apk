package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import java.util.Comparator;

class MsgTabNodeInsertLocalVideoInfoSegment$1
  implements Comparator<MsgTabVideoData>
{
  MsgTabNodeInsertLocalVideoInfoSegment$1(MsgTabNodeInsertLocalVideoInfoSegment paramMsgTabNodeInsertLocalVideoInfoSegment) {}
  
  public int a(MsgTabVideoData paramMsgTabVideoData1, MsgTabVideoData paramMsgTabVideoData2)
  {
    return MsgTabStoryUtil.a(paramMsgTabVideoData1.a.mCreateTime, paramMsgTabVideoData2.a.mCreateTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInsertLocalVideoInfoSegment.1
 * JD-Core Version:    0.7.0.1
 */