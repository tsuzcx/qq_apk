package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.observer.GetRedPointExObserver;

class MsgTabStoryNodeListManager$2
  extends GetRedPointExObserver
{
  MsgTabStoryNodeListManager$2(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  protected void a(Object paramObject)
  {
    ThreadManager.post(new MsgTabStoryNodeListManager.2.1(this, paramObject), 5, null, true);
    SLog.b(MsgTabStoryNodeListManager.b(), "freshRedPoint, showStoryNode");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.2
 * JD-Core Version:    0.7.0.1
 */