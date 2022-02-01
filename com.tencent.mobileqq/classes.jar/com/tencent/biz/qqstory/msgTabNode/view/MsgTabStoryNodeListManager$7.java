package com.tencent.biz.qqstory.msgTabNode.view;

import android.database.DataSetObserver;
import com.tencent.mobileqq.app.ThreadManager;
import mqq.os.MqqHandler;

class MsgTabStoryNodeListManager$7
  extends DataSetObserver
{
  MsgTabStoryNodeListManager$7(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void onChanged()
  {
    if (this.a.a == 0) {
      ThreadManager.getUIHandler().post(new MsgTabStoryNodeListManager.7.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager.7
 * JD-Core Version:    0.7.0.1
 */