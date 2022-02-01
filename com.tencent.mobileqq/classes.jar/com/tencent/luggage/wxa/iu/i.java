package com.tencent.luggage.wxa.iu;

import android.util.SparseArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.List;

public final class i
{
  private final SparseArray<List<i.b>> a = new SparseArray();
  private final SparseIntArray b = new SparseIntArray();
  
  public static i a()
  {
    return i.a.a;
  }
  
  private void a(int paramInt, @NonNull List<i.b> paramList)
  {
    if (this.b.size() <= 0) {
      return;
    }
    int i = 0;
    o.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify pending : %d", new Object[] { Integer.valueOf(paramInt) });
    if (this.b.indexOfKey(paramInt) < 0)
    {
      o.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "not in pending notify");
      return;
    }
    this.b.delete(paramInt);
    paramInt = i;
    while (paramInt < paramList.size())
    {
      ((i.b)paramList.get(paramInt)).a();
      paramInt += 1;
    }
  }
  
  public void a(@NonNull h paramh)
  {
    int j = paramh.getComponentId();
    int i = 0;
    o.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify service:%d", new Object[] { Integer.valueOf(j) });
    try
    {
      paramh = (List)this.a.get(j);
      if (paramh == null)
      {
        o.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "notify listenerList empty");
        this.b.put(j, 1);
        return;
      }
      while (i < paramh.size())
      {
        ((i.b)paramh.get(i)).a();
        i += 1;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw paramh;
    }
  }
  
  public void a(@NonNull h paramh, @NonNull i.b paramb)
  {
    int i = paramh.getComponentId();
    o.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "addListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      List localList = (List)this.a.get(i);
      paramh = localList;
      if (localList == null)
      {
        paramh = new ArrayList();
        this.a.put(i, paramh);
      }
      paramh.add(paramb);
      a(i, paramh);
      return;
    }
    finally {}
  }
  
  public void b(@NonNull h paramh, @NonNull i.b paramb)
  {
    int i = paramh.getComponentId();
    o.d("MicroMsg.AppBrandServiceOnRuntimeReadyListenerMgr", "removeListener service:%d", new Object[] { Integer.valueOf(i) });
    try
    {
      paramh = (List)this.a.get(i);
      if (paramh == null) {
        return;
      }
      paramh.remove(paramb);
      if (paramh.isEmpty()) {
        this.a.remove(i);
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.iu.i
 * JD-Core Version:    0.7.0.1
 */