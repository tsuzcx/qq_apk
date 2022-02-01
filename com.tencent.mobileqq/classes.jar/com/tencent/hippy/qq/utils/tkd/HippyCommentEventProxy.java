package com.tencent.hippy.qq.utils.tkd;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class HippyCommentEventProxy
  implements InvocationHandler
{
  private List<TKDCommentDispatcher.HippyCommentEvent> hippyCommentEvents;
  
  public HippyCommentEventProxy(List<TKDCommentDispatcher.HippyCommentEvent> paramList)
  {
    this.hippyCommentEvents = paramList;
  }
  
  public Object invoke(Object paramObject, Method paramMethod, Object[] paramArrayOfObject)
  {
    if (this.hippyCommentEvents != null)
    {
      paramObject = this.hippyCommentEvents.iterator();
      while (paramObject.hasNext()) {
        paramMethod.invoke((TKDCommentDispatcher.HippyCommentEvent)paramObject.next(), paramArrayOfObject);
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.tkd.HippyCommentEventProxy
 * JD-Core Version:    0.7.0.1
 */