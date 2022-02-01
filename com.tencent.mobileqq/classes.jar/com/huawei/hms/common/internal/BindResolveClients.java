package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class BindResolveClients
{
  private static final Object LOCK_INST = new Object();
  private ArrayList<ResolveClientBean> mClientList = new ArrayList();
  
  public static BindResolveClients getInstance()
  {
    return BindResolveClients.SingletonManager.access$100();
  }
  
  boolean isClientRegistered(ResolveClientBean paramResolveClientBean)
  {
    synchronized (LOCK_INST)
    {
      boolean bool = this.mClientList.contains(paramResolveClientBean);
      return bool;
    }
  }
  
  public void notifyClientReconnect()
  {
    synchronized (LOCK_INST)
    {
      ListIterator localListIterator = this.mClientList.listIterator();
      while (localListIterator.hasNext()) {
        ((ResolveClientBean)localListIterator.next()).clientReconnect();
      }
      this.mClientList.clear();
      return;
    }
    for (;;)
    {
      throw localObject2;
    }
  }
  
  void register(ResolveClientBean paramResolveClientBean)
  {
    if (paramResolveClientBean == null) {
      return;
    }
    synchronized (LOCK_INST)
    {
      if (!this.mClientList.contains(paramResolveClientBean)) {
        this.mClientList.add(paramResolveClientBean);
      }
      return;
    }
  }
  
  void unRegister(ResolveClientBean paramResolveClientBean)
  {
    if (paramResolveClientBean == null) {
      return;
    }
    synchronized (LOCK_INST)
    {
      if (this.mClientList.contains(paramResolveClientBean))
      {
        ListIterator localListIterator = this.mClientList.listIterator();
        while (localListIterator.hasNext()) {
          if (paramResolveClientBean.equals(localListIterator.next())) {
            localListIterator.remove();
          }
        }
      }
      return;
    }
    for (;;)
    {
      throw paramResolveClientBean;
    }
  }
  
  public void unRegisterAll()
  {
    synchronized (LOCK_INST)
    {
      this.mClientList.clear();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.hms.common.internal.BindResolveClients
 * JD-Core Version:    0.7.0.1
 */