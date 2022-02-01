package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.apollo.model.ApolloActionData;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApolloListenerManager
{
  private List<WeakReference<IResDownloadListener>> a = new ArrayList();
  
  public void a()
  {
    List localList = this.a;
    if (localList != null) {
      localList.clear();
    }
  }
  
  public void a(ApolloActionData paramApolloActionData)
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (this.a.get(i) != null)
        {
          IResDownloadListener localIResDownloadListener = (IResDownloadListener)((WeakReference)this.a.get(i)).get();
          if (localIResDownloadListener != null) {
            localIResDownloadListener.a(paramApolloActionData);
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(IResDownloadListener paramIResDownloadListener)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        WeakReference localWeakReference = (WeakReference)((Iterator)localObject).next();
        if ((localWeakReference != null) && (localWeakReference.get() == paramIResDownloadListener)) {
          return;
        }
      }
      this.a.add(new WeakReference(paramIResDownloadListener));
    }
  }
  
  public void a(Boolean paramBoolean)
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (this.a.get(i) != null)
        {
          IResDownloadListener localIResDownloadListener = (IResDownloadListener)((WeakReference)this.a.get(i)).get();
          if (localIResDownloadListener != null) {
            localIResDownloadListener.a(paramBoolean);
          }
        }
        i += 1;
      }
    }
  }
  
  public void b()
  {
    if (this.a != null)
    {
      int i = 0;
      while (i < this.a.size())
      {
        if (this.a.get(i) != null)
        {
          IResDownloadListener localIResDownloadListener = (IResDownloadListener)((WeakReference)this.a.get(i)).get();
          if (localIResDownloadListener != null) {
            localIResDownloadListener.a();
          }
        }
        i += 1;
      }
    }
  }
  
  public void b(IResDownloadListener paramIResDownloadListener)
  {
    List localList = this.a;
    if (localList != null) {
      localList.remove(paramIResDownloadListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloListenerManager
 * JD-Core Version:    0.7.0.1
 */