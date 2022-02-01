package com.tencent.mobileqq.apollo.sdk;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

final class CmShowRenderView$1
  implements Runnable
{
  CmShowRenderView$1(List paramList) {}
  
  public void run()
  {
    if (!CmShowRenderView.a().isEmpty())
    {
      Iterator localIterator = CmShowRenderView.a().values().iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (WeakReference)localIterator.next();
        if (localObject != null)
        {
          localObject = (CmShowRenderView)((WeakReference)localObject).get();
          if (localObject != null) {
            CmShowRenderView.a((CmShowRenderView)localObject, this.a);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowRenderView.1
 * JD-Core Version:    0.7.0.1
 */