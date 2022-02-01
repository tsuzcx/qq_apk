package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.AutomatorObserver;

class MsgTabStoryNodeListManager$3
  extends AutomatorObserver
{
  MsgTabStoryNodeListManager$3(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void a(int paramInt)
  {
    if (paramInt == 1)
    {
      SLog.b(MsgTabStoryNodeListManager.b() + ".VASH", "Friend Cache Inited!");
      MsgTabStoryNodeListManager.h = true;
      this.a.a.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.3
 * JD-Core Version:    0.7.0.1
 */