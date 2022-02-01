package com.tencent.biz.qqstory.msgTabNode.network;

import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.msgTabNode.util.MsgTabStoryUtil;
import com.tencent.biz.qqstory.playmode.util.MsgTabVideoData;
import java.util.Comparator;

class MsgTabVideoPreloaderDataProvider$2$1
  implements Comparator<MsgTabVideoData>
{
  MsgTabVideoPreloaderDataProvider$2$1(MsgTabVideoPreloaderDataProvider.2 param2) {}
  
  public int a(MsgTabVideoData paramMsgTabVideoData1, MsgTabVideoData paramMsgTabVideoData2)
  {
    return MsgTabStoryUtil.a(paramMsgTabVideoData1.a.mCreateTime, paramMsgTabVideoData2.a.mCreateTime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.network.MsgTabVideoPreloaderDataProvider.2.1
 * JD-Core Version:    0.7.0.1
 */