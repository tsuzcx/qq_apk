package com.tencent.biz.qqstory.msgTabNode.view;

import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader;
import com.tencent.biz.qqstory.network.handler.GetShareGroupInfoHandler.GetShareGroupInfoEvent;
import com.tencent.biz.qqstory.shareGroup.model.ShareGroupItem;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.QQUIEventReceiver;

public class MsgTabStoryNodeDelegate$GetGroupInfoEventReceiver
  extends QQUIEventReceiver<MsgTabStoryNodeDelegate, GetShareGroupInfoHandler.GetShareGroupInfoEvent>
{
  public MsgTabStoryNodeDelegate$GetGroupInfoEventReceiver(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate)
  {
    super(paramMsgTabStoryNodeDelegate);
  }
  
  public void a(@NonNull MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, @NonNull GetShareGroupInfoHandler.GetShareGroupInfoEvent paramGetShareGroupInfoEvent)
  {
    if (paramGetShareGroupInfoEvent.g.isSuccess())
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver isSuccess sharegroupInfo: ");
        localStringBuilder.append(paramGetShareGroupInfoEvent.b);
        QLog.i("zivonchen", 2, localStringBuilder.toString());
      }
      if (paramGetShareGroupInfoEvent.b != null) {
        paramMsgTabStoryNodeDelegate.a(paramMsgTabStoryNodeDelegate.a.a(8, paramGetShareGroupInfoEvent.b.shareGroupId));
      }
    }
    else if (QLog.isColorLevel())
    {
      paramMsgTabStoryNodeDelegate = new StringBuilder();
      paramMsgTabStoryNodeDelegate.append("MsgTabStoryNodeDelegate#GetGroupInfoEventReceiver errorInfo: ");
      paramMsgTabStoryNodeDelegate.append(paramGetShareGroupInfoEvent.g);
      paramMsgTabStoryNodeDelegate.append(", sharegroupInfo = ");
      paramMsgTabStoryNodeDelegate.append(paramGetShareGroupInfoEvent.b);
      QLog.i("zivonchen", 2, paramMsgTabStoryNodeDelegate.toString());
    }
  }
  
  public Class acceptEventClass()
  {
    return GetShareGroupInfoHandler.GetShareGroupInfoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate.GetGroupInfoEventReceiver
 * JD-Core Version:    0.7.0.1
 */