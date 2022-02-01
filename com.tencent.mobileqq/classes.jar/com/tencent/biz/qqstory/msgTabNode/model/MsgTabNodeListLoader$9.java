package com.tencent.biz.qqstory.msgTabNode.model;

import java.util.ArrayList;
import java.util.Iterator;

class MsgTabNodeListLoader$9
  implements Runnable
{
  public void run()
  {
    synchronized (this.this$0.d)
    {
      Iterator localIterator = this.this$0.d.iterator();
      if (localIterator.hasNext()) {
        ((MsgTabNodeListLoader.OnMsgTabNodeListLoadListener)localIterator.next()).b(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.9
 * JD-Core Version:    0.7.0.1
 */