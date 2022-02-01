package com.tencent.hippy.qq.utils.tkd;

import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

public class HippyCommentEventProxy
  implements InvocationHandler
{
  private static final String TAG = "HippyCommentEventProxy";
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
      while (paramObject.hasNext())
      {
        TKDCommentDispatcher.HippyCommentEvent localHippyCommentEvent = (TKDCommentDispatcher.HippyCommentEvent)paramObject.next();
        try
        {
          paramMethod.invoke(localHippyCommentEvent, paramArrayOfObject);
        }
        catch (Throwable localThrowable)
        {
          QLog.w("HippyCommentEventProxy", 1, "#invoke ", localThrowable);
        }
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.hippy.qq.utils.tkd.HippyCommentEventProxy
 * JD-Core Version:    0.7.0.1
 */