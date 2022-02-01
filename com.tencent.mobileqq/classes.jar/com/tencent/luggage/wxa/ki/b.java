package com.tencent.luggage.wxa.ki;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.kl.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class b
  implements e
{
  @Nullable
  private volatile Queue<com.tencent.luggage.wxa.kl.a> a;
  @Nullable
  private volatile com.tencent.luggage.wxa.kl.a b;
  @Nullable
  private volatile List<com.tencent.luggage.wxa.kl.a> c;
  private final Handler d = new Handler(Looper.getMainLooper());
  
  private void c()
  {
    try
    {
      Object localObject1 = this.b;
      if (localObject1 != null)
      {
        boolean bool = ((com.tencent.luggage.wxa.kl.a)localObject1).o;
        if (!bool) {
          return;
        }
      }
      localObject1 = this.a;
      if ((localObject1 != null) && (((Queue)localObject1).size() > 0))
      {
        localObject1 = (com.tencent.luggage.wxa.kl.a)((Queue)localObject1).poll();
        if (localObject1 == null)
        {
          com.tencent.luggage.wxa.kn.a.b("MicroMsg.Ble.BleConnectDispatcher", "curSerialAction is null, err", new Object[0]);
          return;
        }
        this.b = ((com.tencent.luggage.wxa.kl.a)localObject1);
        if (((com.tencent.luggage.wxa.kl.a)localObject1).j) {
          this.d.postDelayed(new b.2(this, (com.tencent.luggage.wxa.kl.a)localObject1), ((com.tencent.luggage.wxa.kl.a)localObject1).m);
        } else {
          ((com.tencent.luggage.wxa.kl.a)localObject1).c();
        }
      }
      return;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      this.a = new ConcurrentLinkedQueue();
      this.c = new ArrayList();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.kl.a)localObject).a(paramBluetoothGatt, paramInt);
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.kl.a locala = (com.tencent.luggage.wxa.kl.a)((Iterator)localObject).next();
        if (locala.o) {
          locala.a(paramBluetoothGatt, paramInt);
        }
      }
    }
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.kl.a)localObject).a(paramBluetoothGatt, paramInt1, paramInt2);
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.kl.a locala = (com.tencent.luggage.wxa.kl.a)((Iterator)localObject).next();
        if (locala.o) {
          locala.a(paramBluetoothGatt, paramInt1, paramInt2);
        }
      }
    }
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.kl.a)localObject).a(paramBluetoothGatt, paramBluetoothGattCharacteristic);
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.kl.a locala = (com.tencent.luggage.wxa.kl.a)((Iterator)localObject).next();
        if (locala.o) {
          locala.a(paramBluetoothGatt, paramBluetoothGattCharacteristic);
        }
      }
    }
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    com.tencent.luggage.wxa.kl.a locala = this.b;
    if (locala != null) {
      locala.a(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    }
    paramBluetoothGattCharacteristic = this.c;
    if (paramBluetoothGattCharacteristic != null)
    {
      paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.iterator();
      while (paramBluetoothGattCharacteristic.hasNext())
      {
        locala = (com.tencent.luggage.wxa.kl.a)paramBluetoothGattCharacteristic.next();
        if (locala.o) {
          locala.a(paramBluetoothGatt, paramInt);
        }
      }
    }
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.kl.a)localObject).a(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.kl.a locala = (com.tencent.luggage.wxa.kl.a)((Iterator)localObject).next();
        if (locala.o) {
          locala.a(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
        }
      }
    }
  }
  
  public void a(@NonNull com.tencent.luggage.wxa.kl.a parama)
  {
    com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.BleConnectDispatcher", "doAction %s", new Object[] { parama });
    if (parama.k)
    {
      Queue localQueue = this.a;
      if (localQueue == null) {
        return;
      }
      localQueue.add(parama);
      c();
      return;
    }
    if (parama.j)
    {
      this.d.postDelayed(new b.1(this, parama), parama.m);
      return;
    }
    parama.c();
  }
  
  public void a(com.tencent.luggage.wxa.kl.a parama, j paramj)
  {
    if (paramj == null) {
      paramj = "";
    }
    com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback action:%s result:%s", new Object[] { parama, paramj });
    if (parama != null)
    {
      if (parama.k)
      {
        c();
        return;
      }
      paramj = this.c;
      if (paramj != null)
      {
        paramj.remove(parama);
        return;
      }
      com.tencent.luggage.wxa.kn.a.c("MicroMsg.Ble.BleConnectDispatcher", "actionCompleteCallback, runActions is null", new Object[0]);
    }
  }
  
  public void b()
  {
    try
    {
      Object localObject1 = this.a;
      if (localObject1 != null)
      {
        ((Queue)localObject1).clear();
        this.a = null;
      }
      localObject1 = this.c;
      if (localObject1 != null)
      {
        ((List)localObject1).clear();
        this.c = null;
      }
      return;
    }
    finally {}
  }
  
  public void b(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.kl.a)localObject).b(paramBluetoothGatt, paramInt);
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.kl.a locala = (com.tencent.luggage.wxa.kl.a)((Iterator)localObject).next();
        if (locala.o) {
          locala.b(paramBluetoothGatt, paramInt);
        }
      }
    }
  }
  
  public void b(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.kl.a)localObject).b(paramBluetoothGatt, paramInt1, paramInt2);
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.kl.a locala = (com.tencent.luggage.wxa.kl.a)((Iterator)localObject).next();
        if (locala.o) {
          locala.a(paramBluetoothGatt, paramInt2);
        }
      }
    }
  }
  
  public void b(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.kl.a)localObject).b(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.kl.a locala = (com.tencent.luggage.wxa.kl.a)((Iterator)localObject).next();
        if (locala.o) {
          locala.b(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
        }
      }
    }
  }
  
  public void b(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.kl.a)localObject).b(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.kl.a locala = (com.tencent.luggage.wxa.kl.a)((Iterator)localObject).next();
        if (locala.o) {
          locala.b(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
        }
      }
    }
  }
  
  public void c(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    Object localObject = this.b;
    if (localObject != null) {
      ((com.tencent.luggage.wxa.kl.a)localObject).c(paramBluetoothGatt, paramInt1, paramInt2);
    }
    localObject = this.c;
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        com.tencent.luggage.wxa.kl.a locala = (com.tencent.luggage.wxa.kl.a)((Iterator)localObject).next();
        if (locala.o) {
          locala.c(paramBluetoothGatt, paramInt1, paramInt2);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ki.b
 * JD-Core Version:    0.7.0.1
 */