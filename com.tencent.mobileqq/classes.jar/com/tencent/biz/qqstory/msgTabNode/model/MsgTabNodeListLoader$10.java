package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class MsgTabNodeListLoader$10
  implements Runnable
{
  MsgTabNodeListLoader$10(MsgTabNodeListLoader paramMsgTabNodeListLoader, ArrayList paramArrayList, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3) {}
  
  public void run()
  {
    synchronized (this.this$0.j)
    {
      Iterator localIterator = this.this$0.j.iterator();
      while (localIterator.hasNext()) {
        ((MsgTabNodeListLoader.OnMsgTabNodeListLoadListener)localIterator.next()).a(this.a, this.b, this.c, this.d);
      }
      if ((QLog.isDevelopLevel()) && (this.this$0.j.isEmpty())) {
        QLog.d("Q.qqstory.msgTab.MsgTabNodeListLoader", 2, "mListeners is empty!");
      }
      return;
    }
    for (;;)
    {
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.10
 * JD-Core Version:    0.7.0.1
 */