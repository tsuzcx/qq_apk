package com.tencent.component.network.module.statistics;

import android.content.Context;
import com.tencent.component.network.NetworkManager;
import com.tencent.component.network.module.statistics.common.FixedLinkedList;
import com.tencent.component.network.utils.NetworkUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import piv;
import piw;

public class ProxyStatistics
{
  private final Map a = new HashMap();
  private final Map b = new HashMap();
  
  public static ProxyStatistics a()
  {
    return piv.a;
  }
  
  private void a(List paramList, String paramString)
  {
    boolean bool2 = true;
    if (paramList == null) {
      return;
    }
    for (;;)
    {
      piw localpiw;
      int i;
      int k;
      int j;
      synchronized (this.b)
      {
        localpiw = (piw)this.b.get(paramString);
        if (localpiw != null) {
          break label223;
        }
        localpiw = new piw();
        this.b.put(paramString, localpiw);
        paramString = localpiw;
        paramList = paramList.iterator();
        i = 0;
        k = 0;
        j = 0;
        if (paramList.hasNext())
        {
          localpiw = (piw)paramList.next();
          if (localpiw == null) {
            continue;
          }
          int m = j + 1;
          j = k;
          if (localpiw.a) {
            j = k + 1;
          }
          if (!localpiw.b) {
            break label220;
          }
          i += 1;
          k = j;
          j = m;
        }
      }
      if (j <= 0) {
        break;
      }
      if (k / j > 0.5F)
      {
        bool1 = true;
        paramString.a = bool1;
        if (i / j <= 0.5F) {
          break label214;
        }
      }
      label214:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        paramString.b = bool1;
        return;
        bool1 = false;
        break;
      }
      label220:
      continue;
      label223:
      paramString = localpiw;
    }
  }
  
  public void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!NetworkUtils.isMobileConnected(paramContext)) {
      return;
    }
    piw localpiw = new piw();
    localpiw.a = paramBoolean1;
    localpiw.b = paramBoolean2;
    synchronized (this.a)
    {
      String str = NetworkManager.getApnValue();
      FixedLinkedList localFixedLinkedList = (FixedLinkedList)this.a.get(str);
      paramContext = localFixedLinkedList;
      if (localFixedLinkedList == null)
      {
        paramContext = new FixedLinkedList(3, false);
        this.a.put(str, paramContext);
      }
      paramContext.add(0, localpiw);
      a(paramContext, str);
      return;
    }
  }
  
  public boolean a()
  {
    String str = NetworkManager.getApnValue();
    synchronized (this.b)
    {
      piw localpiw2 = (piw)this.b.get(str);
      piw localpiw1 = localpiw2;
      if (localpiw2 == null)
      {
        localpiw1 = new piw();
        this.b.put(str, localpiw1);
      }
      return localpiw1.a;
    }
  }
  
  public boolean b()
  {
    String str = NetworkManager.getApnValue();
    synchronized (this.b)
    {
      piw localpiw2 = (piw)this.b.get(str);
      piw localpiw1 = localpiw2;
      if (localpiw2 == null)
      {
        localpiw1 = new piw();
        this.b.put(str, localpiw1);
      }
      return localpiw1.b;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.network.module.statistics.ProxyStatistics
 * JD-Core Version:    0.7.0.1
 */