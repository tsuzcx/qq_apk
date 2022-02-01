package com.tencent.biz.qqstory.msgTabNode.model;

import java.util.ArrayList;
import java.util.Iterator;

class MsgTabNodeListLoader$MsgTabWorkThreadHandler$1
  implements Runnable
{
  MsgTabNodeListLoader$MsgTabWorkThreadHandler$1(MsgTabNodeListLoader.MsgTabWorkThreadHandler paramMsgTabWorkThreadHandler) {}
  
  public void run()
  {
    synchronized (this.a.a.d)
    {
      Iterator localIterator = this.a.a.d.iterator();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.MsgTabWorkThreadHandler.1
 * JD-Core Version:    0.7.0.1
 */