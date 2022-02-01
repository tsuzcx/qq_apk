package com.tencent.biz.pubaccount.weishi_new.event;

import java.util.ArrayList;

public abstract interface WSSimpleEventReceiver<T extends WSSimpleBaseEvent>
{
  public abstract ArrayList<Class<T>> a();
  
  public abstract void a(WSSimpleBaseEvent paramWSSimpleBaseEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes17.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.event.WSSimpleEventReceiver
 * JD-Core Version:    0.7.0.1
 */