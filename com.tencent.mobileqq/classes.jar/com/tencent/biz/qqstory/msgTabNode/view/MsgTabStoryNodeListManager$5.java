package com.tencent.biz.qqstory.msgTabNode.view;

import android.widget.TextView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.RedPointUtils;

class MsgTabStoryNodeListManager$5
  implements Runnable
{
  MsgTabStoryNodeListManager$5(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void run()
  {
    int i = RedPointUtils.a(52);
    String str = this.this$0.o.e.getText().toString();
    SLog.a(MsgTabStoryNodeListManager.o(), "redpoint update, update count = %s->%d", str, Integer.valueOf(i));
    this.this$0.o.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.5
 * JD-Core Version:    0.7.0.1
 */