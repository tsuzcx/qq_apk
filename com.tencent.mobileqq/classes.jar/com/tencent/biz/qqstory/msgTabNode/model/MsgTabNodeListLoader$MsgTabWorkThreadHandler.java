package com.tencent.biz.qqstory.msgTabNode.model;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;
import java.util.Set;

class MsgTabNodeListLoader$MsgTabWorkThreadHandler
  extends Handler
{
  public MsgTabNodeListLoader$MsgTabWorkThreadHandler(MsgTabNodeListLoader paramMsgTabNodeListLoader, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    super.handleMessage(paramMessage);
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2) {
        return;
      }
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader.workHandler", "handleMessage() MSG_SCHEDULE_REQUIRE_USER_ITEM");
      paramMessage = (String)paramMessage.obj;
      if (!this.a.h.contains(paramMessage))
      {
        this.a.h.add(paramMessage);
        sendEmptyMessageDelayed(1, 2500L);
      }
    }
    else
    {
      removeMessages(1);
      SLog.b("Q.qqstory.msgTab.MsgTabNodeListLoader.workHandler", "handleMessage() MSG_LOAD_USER_ITEM_FROM_UI");
      paramMessage = new ArrayList(this.a.h);
      this.a.h.clear();
      if (MsgTabNodeListLoader.a(this.a, paramMessage, false)) {
        this.a.k.post(new MsgTabNodeListLoader.MsgTabWorkThreadHandler.1(this));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.MsgTabWorkThreadHandler
 * JD-Core Version:    0.7.0.1
 */