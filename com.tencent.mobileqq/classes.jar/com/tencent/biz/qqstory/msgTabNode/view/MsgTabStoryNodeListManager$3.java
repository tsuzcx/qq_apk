package com.tencent.biz.qqstory.msgTabNode.view;

import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.mobileqq.app.AutomatorObserver;

class MsgTabStoryNodeListManager$3
  extends AutomatorObserver
{
  MsgTabStoryNodeListManager$3(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  protected void a(int paramInt)
  {
    if (paramInt == 1)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(MsgTabStoryNodeListManager.o());
      localStringBuilder.append(".VASH");
      SLog.b(localStringBuilder.toString(), "Friend Cache Inited!");
      MsgTabStoryNodeListManager.B = true;
      this.a.i.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.3
 * JD-Core Version:    0.7.0.1
 */