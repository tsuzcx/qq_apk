package com.tencent.biz.richframework.eventbus;

import java.util.ArrayList;

public abstract interface SimpleEventReceiver<T extends SimpleBaseEvent>
{
  public abstract ArrayList<Class<T>> getEventClass();
  
  public abstract void onReceiveEvent(SimpleBaseEvent paramSimpleBaseEvent);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.biz.richframework.eventbus.SimpleEventReceiver
 * JD-Core Version:    0.7.0.1
 */