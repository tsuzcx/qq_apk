package com.tencent.biz.qqstory.msgTabNode.model;

import java.util.ArrayList;
import java.util.Iterator;

class MsgTabNodeListLoader$13
  implements Runnable
{
  MsgTabNodeListLoader$13(MsgTabNodeListLoader paramMsgTabNodeListLoader) {}
  
  public void run()
  {
    synchronized (this.this$0.j)
    {
      Iterator localIterator = this.this$0.j.iterator();
      while (localIterator.hasNext()) {
        ((MsgTabNodeListLoader.OnMsgTabNodeListLoadListener)localIterator.next()).a();
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
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.13
 * JD-Core Version:    0.7.0.1
 */