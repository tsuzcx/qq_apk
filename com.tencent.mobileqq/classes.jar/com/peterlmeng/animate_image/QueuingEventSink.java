package com.peterlmeng.animate_image;

import io.flutter.plugin.common.EventChannel.EventSink;
import java.util.ArrayList;
import java.util.Iterator;

public final class QueuingEventSink
  implements EventChannel.EventSink
{
  private EventChannel.EventSink delegate;
  private boolean done = false;
  private ArrayList<Object> eventQueue = new ArrayList();
  
  private void enqueue(Object paramObject)
  {
    if (this.done) {
      return;
    }
    this.eventQueue.add(paramObject);
  }
  
  private void maybeFlush()
  {
    if (this.delegate == null) {
      return;
    }
    Iterator localIterator = this.eventQueue.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if ((localObject instanceof QueuingEventSink.EndOfStreamEvent))
      {
        this.delegate.endOfStream();
      }
      else if ((localObject instanceof QueuingEventSink.ErrorEvent))
      {
        localObject = (QueuingEventSink.ErrorEvent)localObject;
        this.delegate.error(((QueuingEventSink.ErrorEvent)localObject).code, ((QueuingEventSink.ErrorEvent)localObject).message, ((QueuingEventSink.ErrorEvent)localObject).details);
      }
      else
      {
        this.delegate.success(localObject);
      }
    }
    this.eventQueue.clear();
  }
  
  public void endOfStream()
  {
    enqueue(new QueuingEventSink.EndOfStreamEvent(null));
    maybeFlush();
    this.done = true;
  }
  
  public void error(String paramString1, String paramString2, Object paramObject)
  {
    enqueue(new QueuingEventSink.ErrorEvent(paramString1, paramString2, paramObject));
    maybeFlush();
  }
  
  public void setDelegate(EventChannel.EventSink paramEventSink)
  {
    this.delegate = paramEventSink;
    maybeFlush();
  }
  
  public void success(Object paramObject)
  {
    enqueue(paramObject);
    maybeFlush();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.peterlmeng.animate_image.QueuingEventSink
 * JD-Core Version:    0.7.0.1
 */