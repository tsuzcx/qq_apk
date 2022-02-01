package com.tencent.biz.qqstory.msgTabNode.model;

import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.handler.GetUserInfoHandler.UpdateUserInfoEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class MsgTabNodeListLoader$1$1
  implements Runnable
{
  MsgTabNodeListLoader$1$1(MsgTabNodeListLoader.1 param1, GetUserInfoHandler.UpdateUserInfoEvent paramUpdateUserInfoEvent) {}
  
  public void run()
  {
    if (this.a.a != null) {
      this.b.a.a(this.a.a);
    }
    Object localObject2;
    if (this.a.b != null)
    {
      ??? = this.a.b.iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (QQUserUIItem)((Iterator)???).next();
        this.b.a.a(this.a.a);
      }
    }
    synchronized (this.b.a.j)
    {
      localObject2 = this.b.a.j.iterator();
      while (((Iterator)localObject2).hasNext()) {
        ((MsgTabNodeListLoader.OnMsgTabNodeListLoadListener)((Iterator)localObject2).next()).a();
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeListLoader.1.1
 * JD-Core Version:    0.7.0.1
 */