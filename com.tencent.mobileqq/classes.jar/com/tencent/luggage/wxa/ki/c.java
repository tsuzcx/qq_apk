package com.tencent.luggage.wxa.ki;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.kl.b;
import com.tencent.luggage.wxa.kl.e;
import com.tencent.luggage.wxa.kl.g;
import com.tencent.luggage.wxa.kl.h;
import com.tencent.luggage.wxa.qz.af;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public class c
{
  @Nullable
  private final Context a;
  @Nullable
  private Map<String, d> b;
  @Nullable
  private volatile h c;
  @Nullable
  private volatile g d;
  
  public c(@Nullable Context paramContext)
  {
    this.a = paramContext;
  }
  
  private static boolean a(@NonNull List<String> paramList1, @NonNull List<String> paramList2)
  {
    String str;
    Iterator localIterator;
    do
    {
      paramList1 = paramList1.iterator();
      while (!localIterator.hasNext())
      {
        if (!paramList1.hasNext()) {
          break;
        }
        str = (String)paramList1.next();
        localIterator = paramList2.iterator();
      }
    } while (!Objects.equals(str, (String)localIterator.next()));
    return true;
    return false;
  }
  
  @Nullable
  private d c(String paramString)
  {
    try
    {
      if (this.b == null)
      {
        com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.BleConnectMgr", "getWorker, connectWorkers is null", new Object[0]);
        return null;
      }
      d locald2 = (d)this.b.get(paramString);
      d locald1 = locald2;
      if (locald2 == null)
      {
        locald1 = new d(this.a, paramString, this);
        locald1.a();
        locald1.a(new c.1(this));
        locald1.a(new c.2(this));
        this.b.put(paramString, locald1);
      }
      return locald1;
    }
    finally {}
  }
  
  public com.tencent.luggage.wxa.kl.c a(String paramString1, String paramString2, String paramString3)
  {
    Map localMap = this.b;
    if (localMap == null)
    {
      com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.BleConnectMgr", "getCharacteristic, connectWorkers is null", new Object[0]);
      return null;
    }
    paramString1 = (d)localMap.get(paramString1);
    if (paramString1 == null)
    {
      com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.BleConnectMgr", "getCharacteristic, connectWorker is null", new Object[0]);
      return null;
    }
    return paramString1.a(paramString2, paramString3);
  }
  
  public List<com.tencent.luggage.wxa.kl.c> a(String paramString1, String paramString2)
  {
    Map localMap = this.b;
    if (localMap == null)
    {
      com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorkers is null", new Object[0]);
      return null;
    }
    paramString1 = (d)localMap.get(paramString1);
    if (paramString1 == null)
    {
      com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.BleConnectMgr", "getCharacteristics, connectWorker is null", new Object[0]);
      return null;
    }
    return paramString1.a(paramString2);
  }
  
  public List<com.tencent.luggage.wxa.kl.d> a(List<String> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      ArrayList localArrayList1 = new ArrayList();
      Object localObject1 = this.b;
      if (localObject1 == null)
      {
        com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, connectWorkers is null", new Object[0]);
        return localArrayList1;
      }
      localObject1 = ((Map)localObject1).values().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        d locald = (d)((Iterator)localObject1).next();
        BluetoothGatt localBluetoothGatt = locald.c();
        if (localBluetoothGatt != null)
        {
          Object localObject2 = locald.e();
          if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
          {
            ArrayList localArrayList2 = new ArrayList(((List)localObject2).size());
            localObject2 = ((List)localObject2).iterator();
            while (((Iterator)localObject2).hasNext())
            {
              e locale = (e)((Iterator)localObject2).next();
              if (locale.b) {
                localArrayList2.add(locale.a);
              }
            }
            if (a(paramList, localArrayList2)) {
              localArrayList1.add(new com.tencent.luggage.wxa.kl.d(af.b(localBluetoothGatt.getDevice().getName()), locald.a));
            }
          }
          else
          {
            com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, services is empty", new Object[0]);
          }
        }
      }
      return localArrayList1;
    }
    return c();
  }
  
  public void a()
  {
    try
    {
      com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.BleConnectMgr", "init", new Object[0]);
      if (this.b == null) {
        this.b = new ConcurrentHashMap();
      }
      this.b.clear();
      return;
    }
    finally {}
  }
  
  public void a(@NonNull g paramg)
  {
    this.d = paramg;
  }
  
  public void a(@NonNull h paramh)
  {
    this.c = paramh;
  }
  
  void a(String paramString)
  {
    Map localMap = this.b;
    if (localMap == null)
    {
      com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.BleConnectMgr", "removeWorker, connectWorkers is null", new Object[0]);
      return;
    }
    localMap.remove(paramString);
  }
  
  public void a(String paramString, @NonNull com.tencent.luggage.wxa.kl.a parama, @NonNull b paramb)
  {
    paramString = c(paramString);
    if (paramString != null) {
      paramString.a(parama, paramb);
    }
  }
  
  public List<e> b(String paramString)
  {
    Map localMap = this.b;
    if (localMap == null)
    {
      com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorkers is null", new Object[0]);
      return null;
    }
    paramString = (d)localMap.get(paramString);
    if (paramString == null)
    {
      com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.BleConnectMgr", "getServices, connectWorker is null", new Object[0]);
      return null;
    }
    return paramString.e();
  }
  
  public void b()
  {
    try
    {
      com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.BleConnectMgr", "uninit", new Object[0]);
      if (this.b != null)
      {
        Iterator localIterator = this.b.values().iterator();
        while (localIterator.hasNext()) {
          ((d)localIterator.next()).b();
        }
        this.b.clear();
        this.b = null;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject;
    }
  }
  
  public List<com.tencent.luggage.wxa.kl.d> c()
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = this.b;
    if (localObject == null)
    {
      com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.BleConnectMgr", "getConnectedBleDevices, connectWorkers is null", new Object[0]);
      return localArrayList;
    }
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      d locald = (d)((Iterator)localObject).next();
      BluetoothGatt localBluetoothGatt = locald.c();
      if (localBluetoothGatt != null) {
        localArrayList.add(new com.tencent.luggage.wxa.kl.d(af.b(localBluetoothGatt.getDevice().getName()), locald.a));
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ki.c
 * JD-Core Version:    0.7.0.1
 */