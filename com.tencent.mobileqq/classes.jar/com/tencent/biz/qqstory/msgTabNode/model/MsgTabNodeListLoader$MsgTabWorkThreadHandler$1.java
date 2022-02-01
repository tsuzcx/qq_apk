package com.tencent.biz.qqstory.msgTabNode.model;

import java.util.ArrayList;
import java.util.Iterator;
import wmd;
import wmj;
import wmk;

public class MsgTabNodeListLoader$MsgTabWorkThreadHandler$1
  implements Runnable
{
  public MsgTabNodeListLoader$MsgTabWorkThreadHandler$1(wmj paramwmj) {}
  
  public void run()
  {
    synchronized (this.a.a.d)
    {
      Iterator localIterator = this.a.a.d.iterator();
      if (localIterator.hasNext()) {
        ((wmk)localIterator.next()).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.MsgTabWorkThreadHandler.1
 * JD-Core Version:    0.7.0.1
 */