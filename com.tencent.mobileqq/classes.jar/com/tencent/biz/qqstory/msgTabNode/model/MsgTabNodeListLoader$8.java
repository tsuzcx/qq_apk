package com.tencent.biz.qqstory.msgTabNode.model;

import java.util.ArrayList;
import java.util.Iterator;
import wvs;
import wvz;

public class MsgTabNodeListLoader$8
  implements Runnable
{
  public MsgTabNodeListLoader$8(wvs paramwvs, boolean paramBoolean) {}
  
  public void run()
  {
    synchronized (this.this$0.d)
    {
      Iterator localIterator = this.this$0.d.iterator();
      if (localIterator.hasNext()) {
        ((wvz)localIterator.next()).a(this.a);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.8
 * JD-Core Version:    0.7.0.1
 */