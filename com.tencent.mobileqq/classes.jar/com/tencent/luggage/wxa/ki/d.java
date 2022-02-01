package com.tencent.luggage.wxa.ki;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.bluetooth.BluetoothGattService;
import android.content.Context;
import android.util.Base64;
import androidx.annotation.NonNull;
import com.tencent.luggage.wxa.kl.f;
import com.tencent.luggage.wxa.kl.g;
import com.tencent.luggage.wxa.kl.h;
import com.tencent.luggage.wxa.qz.af;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(18)
public class d
  implements e
{
  public String a;
  private final String b;
  private Context c;
  private b d;
  private BluetoothGatt e;
  private List<com.tencent.luggage.wxa.kl.e> f;
  private Map<String, List<com.tencent.luggage.wxa.kl.c>> g;
  private h h;
  private g i;
  @NonNull
  private final c j;
  
  public d(Context paramContext, String paramString, @NonNull c paramc)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("MicroMsg.Ble.BleConnectWorker#");
    localStringBuilder.append(hashCode());
    this.b = localStringBuilder.toString();
    this.c = paramContext;
    this.a = paramString;
    this.j = paramc;
  }
  
  private b b(String paramString)
  {
    if (this.d == null)
    {
      this.d = new b();
      this.d.a();
    }
    return this.d;
  }
  
  private void b(boolean paramBoolean)
  {
    try
    {
      if (this.e != null)
      {
        com.tencent.luggage.wxa.kn.a.c(this.b, "deviceId:%s innerCloseMyself", new Object[] { this.a });
        if (paramBoolean) {
          a(this.a, false);
        }
        if (com.tencent.luggage.wxa.kh.a.a.o) {
          com.tencent.luggage.wxa.kn.c.a(this.e);
        }
        this.e.close();
        this.e = null;
      }
      return;
    }
    finally {}
  }
  
  public com.tencent.luggage.wxa.kl.c a(String paramString1, String paramString2)
  {
    BluetoothGatt localBluetoothGatt = this.e;
    if (localBluetoothGatt == null)
    {
      com.tencent.luggage.wxa.kn.a.a(this.b, "[getCharacteristic] bluetoothGatt is null, err", new Object[0]);
      return null;
    }
    if ((!af.c(paramString1)) && (!af.c(paramString2)))
    {
      if (!com.tencent.luggage.wxa.kn.c.b(paramString1))
      {
        com.tencent.luggage.wxa.kn.a.a(this.b, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
        return null;
      }
      if (!com.tencent.luggage.wxa.kn.c.b(paramString2))
      {
        com.tencent.luggage.wxa.kn.a.a(this.b, "[getCharacteristics] characteristicId is illegal, err", new Object[0]);
        return null;
      }
      paramString1 = localBluetoothGatt.getService(UUID.fromString(paramString1));
      if (paramString1 == null)
      {
        com.tencent.luggage.wxa.kn.a.b(this.b, "[getCharacteristic] bluetoothGattServices is null, err", new Object[0]);
        return null;
      }
      paramString1 = paramString1.getCharacteristic(UUID.fromString(paramString2));
      if (paramString1 == null)
      {
        com.tencent.luggage.wxa.kn.a.b(this.b, "[getCharacteristic] characteristics is null, err", new Object[0]);
        return null;
      }
      paramString2 = new com.tencent.luggage.wxa.kl.c();
      paramString2.a = paramString1.getUuid().toString().toUpperCase();
      int k = paramString1.getProperties();
      paramString2.b = com.tencent.luggage.wxa.kn.c.a(k);
      paramString2.c = com.tencent.luggage.wxa.kn.c.b(k);
      paramString2.d = com.tencent.luggage.wxa.kn.c.c(k);
      paramString2.e = com.tencent.luggage.wxa.kn.c.d(k);
      paramString2.f = com.tencent.luggage.wxa.kn.c.e(k);
      if (this.e == null) {
        return null;
      }
      return paramString2;
    }
    com.tencent.luggage.wxa.kn.a.a(this.b, "[getCharacteristic] serviceId is null, err", new Object[0]);
    return null;
  }
  
  public List<com.tencent.luggage.wxa.kl.c> a(String paramString)
  {
    Object localObject2 = this.e;
    if (localObject2 == null)
    {
      com.tencent.luggage.wxa.kn.a.a(this.b, "[getCharacteristics] bluetoothGatt is null, err", new Object[0]);
      return null;
    }
    if (af.c(paramString))
    {
      com.tencent.luggage.wxa.kn.a.a(this.b, "[getCharacteristics] serviceId is null, err", new Object[0]);
      return null;
    }
    if (!com.tencent.luggage.wxa.kn.c.b(paramString))
    {
      com.tencent.luggage.wxa.kn.a.a(this.b, "[getCharacteristics] serviceId is illegal, err", new Object[0]);
      return null;
    }
    Object localObject1 = this.g;
    if (localObject1 == null)
    {
      com.tencent.luggage.wxa.kn.a.a(this.b, "[getCharacteristics] bluetoothCharacteristics is null, err", new Object[0]);
      return null;
    }
    localObject1 = (List)((Map)localObject1).get(paramString);
    if (localObject1 == null)
    {
      localObject1 = ((BluetoothGatt)localObject2).getService(UUID.fromString(paramString));
      if (localObject1 == null)
      {
        com.tencent.luggage.wxa.kn.a.b(this.b, "[getCharacteristics] bluetoothGattServices is null, err", new Object[0]);
        return null;
      }
      localObject2 = ((BluetoothGattService)localObject1).getCharacteristics();
      if (localObject2 == null)
      {
        com.tencent.luggage.wxa.kn.a.b(this.b, "[getCharacteristics] characteristics is null, err", new Object[0]);
        return null;
      }
      localObject1 = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        BluetoothGattCharacteristic localBluetoothGattCharacteristic = (BluetoothGattCharacteristic)((Iterator)localObject2).next();
        com.tencent.luggage.wxa.kl.c localc = new com.tencent.luggage.wxa.kl.c();
        localc.a = localBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
        int k = localBluetoothGattCharacteristic.getProperties();
        localc.b = com.tencent.luggage.wxa.kn.c.a(k);
        localc.c = com.tencent.luggage.wxa.kn.c.b(k);
        localc.d = com.tencent.luggage.wxa.kn.c.c(k);
        localc.e = com.tencent.luggage.wxa.kn.c.d(k);
        localc.f = com.tencent.luggage.wxa.kn.c.e(k);
        ((List)localObject1).add(localc);
      }
      this.g.put(paramString, localObject1);
      paramString = (String)localObject1;
    }
    else
    {
      com.tencent.luggage.wxa.kn.a.c(this.b, "[getCharacteristics] use cache", new Object[0]);
      paramString = (String)localObject1;
    }
    if (this.e == null) {
      return null;
    }
    return paramString;
  }
  
  public void a()
  {
    com.tencent.luggage.wxa.kn.a.c(this.b, "init deviceId:%s", new Object[] { this.a });
    this.d = b(this.a);
    this.g = new ConcurrentHashMap();
  }
  
  public void a(BluetoothGatt paramBluetoothGatt)
  {
    this.e = paramBluetoothGatt;
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    String str2 = this.b;
    String str1;
    if (paramBluetoothGatt != null) {
      str1 = paramBluetoothGatt.getDevice().getAddress();
    } else {
      str1 = "";
    }
    com.tencent.luggage.wxa.kn.a.c(str2, "[onServicesDiscovered]gatt deviceId:%s status:%s", new Object[] { str1, f.a(paramInt) });
    this.d.a(paramBluetoothGatt, paramInt);
    if (paramInt == 0) {
      a(paramBluetoothGatt.getDevice().getAddress(), true);
    }
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    String str3 = this.b;
    String str1;
    if (paramBluetoothGatt != null) {
      str1 = paramBluetoothGatt.getDevice().getAddress();
    } else {
      str1 = "";
    }
    String str4 = f.a(paramInt1);
    String str2;
    if (paramInt2 == 2) {
      str2 = "CONNECTED";
    } else {
      str2 = "DISCONNECTED";
    }
    com.tencent.luggage.wxa.kn.a.c(str3, "[onConnectionStateChange]gatt deviceId:%s gattStatus:%s, newState:%s", new Object[] { str1, str4, str2 });
    this.d.a(paramBluetoothGatt, paramInt1, paramInt2);
    if (paramInt1 == 0)
    {
      if (paramInt2 == 2) {
        return;
      }
      if (paramInt2 == 0) {
        a(true);
      }
    }
    else
    {
      a(true);
    }
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic)
  {
    String str3 = this.b;
    String str2 = "";
    String str1;
    if (paramBluetoothGatt != null) {
      str1 = paramBluetoothGatt.getDevice().getAddress();
    } else {
      str1 = "";
    }
    if (paramBluetoothGattCharacteristic != null) {
      str2 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
    }
    com.tencent.luggage.wxa.kn.a.c(str3, "[onCharacteristicChanged]gatt deviceId:%s characteristicId:%s", new Object[] { str1, str2 });
    this.d.a(paramBluetoothGatt, paramBluetoothGattCharacteristic);
    if (this.i != null)
    {
      str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
      paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
      str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
      paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
      com.tencent.luggage.wxa.kn.a.c(this.b, "[change]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
      this.i.a(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
    }
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    String str3 = this.b;
    String str2 = "";
    String str1;
    if (paramBluetoothGatt != null) {
      str1 = paramBluetoothGatt.getDevice().getAddress();
    } else {
      str1 = "";
    }
    if (paramBluetoothGattCharacteristic != null) {
      str2 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
    }
    com.tencent.luggage.wxa.kn.a.c(str3, "[onCharacteristicRead]gatt deviceId:%s characteristicId:%s status:%s", new Object[] { str1, str2, f.a(paramInt) });
    this.d.a(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
    if (paramInt == 0)
    {
      str1 = new String(Base64.encode(paramBluetoothGattCharacteristic.getValue(), 2));
      paramBluetoothGatt = paramBluetoothGatt.getDevice().getAddress();
      str2 = paramBluetoothGattCharacteristic.getService().getUuid().toString().toUpperCase();
      paramBluetoothGattCharacteristic = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
      com.tencent.luggage.wxa.kn.a.c(this.b, "[read]deviceId %s, serviceId %s, characteristicId %s, value %s", new Object[] { paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1 });
      this.i.a(paramBluetoothGatt, str2, paramBluetoothGattCharacteristic, str1);
    }
  }
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    String str3 = this.b;
    String str2 = "";
    String str1;
    if (paramBluetoothGatt != null) {
      str1 = paramBluetoothGatt.getDevice().getAddress();
    } else {
      str1 = "";
    }
    if (paramBluetoothGattDescriptor != null) {
      str2 = paramBluetoothGattDescriptor.getUuid().toString().toUpperCase();
    }
    com.tencent.luggage.wxa.kn.a.c(str3, "[onDescriptorRead]gatt deviceId:%s descriptorId:%s", new Object[] { str1, str2 });
    this.d.a(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
  }
  
  public void a(com.tencent.luggage.wxa.kl.a parama, com.tencent.luggage.wxa.kl.b paramb)
  {
    com.tencent.luggage.wxa.kn.a.c(this.b, "deviceId:%s aciton:%s", new Object[] { this.a, parama });
    if (this.d == null) {
      return;
    }
    parama.a(this);
    parama.a(this.d);
    parama.a(paramb);
    this.d.a(parama);
  }
  
  public void a(g paramg)
  {
    this.i = paramg;
  }
  
  public void a(h paramh)
  {
    this.h = paramh;
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    h localh = this.h;
    if (localh != null) {
      localh.a(paramString, paramBoolean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      com.tencent.luggage.wxa.kn.a.c(this.b, "closeMyself deviceId:%s", new Object[] { this.a });
      b(paramBoolean);
      if (this.d != null)
      {
        this.d.b();
        this.d = null;
      }
      if (this.f != null)
      {
        this.f.clear();
        this.f = null;
      }
      if (this.g != null)
      {
        this.g.clear();
        this.g = null;
      }
      this.j.a(this.a);
      return;
    }
    finally {}
  }
  
  public void b()
  {
    try
    {
      com.tencent.luggage.wxa.kn.a.c(this.b, "uninit deviceId:%s", new Object[] { this.a });
      b(true);
      if (this.d != null)
      {
        this.d.b();
        this.d = null;
      }
      if (this.f != null)
      {
        this.f.clear();
        this.f = null;
      }
      if (this.g != null)
      {
        this.g.clear();
        this.g = null;
      }
      return;
    }
    finally {}
  }
  
  public void b(BluetoothGatt paramBluetoothGatt, int paramInt)
  {
    String str2 = this.b;
    String str1;
    if (paramBluetoothGatt != null) {
      str1 = paramBluetoothGatt.getDevice().getAddress();
    } else {
      str1 = "";
    }
    com.tencent.luggage.wxa.kn.a.c(str2, "[onReliableWriteCompleted]gatt deviceId:%s status:%s", new Object[] { str1, f.a(paramInt) });
    this.d.b(paramBluetoothGatt, paramInt);
  }
  
  public void b(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    String str2 = this.b;
    String str1;
    if (paramBluetoothGatt != null) {
      str1 = paramBluetoothGatt.getDevice().getAddress();
    } else {
      str1 = "";
    }
    com.tencent.luggage.wxa.kn.a.c(str2, "[onReadRemoteRssi]gatt deviceId:%s rssi:%d status:%s", new Object[] { str1, Integer.valueOf(paramInt1), f.a(paramInt2) });
    this.d.b(paramBluetoothGatt, paramInt1, paramInt2);
  }
  
  public void b(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt)
  {
    String str3 = this.b;
    Object localObject = "";
    String str1;
    if (paramBluetoothGatt != null) {
      str1 = paramBluetoothGatt.getDevice().getAddress();
    } else {
      str1 = "";
    }
    String str2;
    if (paramBluetoothGattCharacteristic != null) {
      str2 = paramBluetoothGattCharacteristic.getUuid().toString().toUpperCase();
    } else {
      str2 = "";
    }
    if (paramBluetoothGattCharacteristic != null) {
      localObject = Arrays.asList(new byte[][] { paramBluetoothGattCharacteristic.getValue() });
    }
    com.tencent.luggage.wxa.kn.a.c(str3, "[onCharacteristicWrite]gatt deviceId:%s characteristicId:%s value:%s, status:%s", new Object[] { str1, str2, localObject, f.a(paramInt) });
    this.d.b(paramBluetoothGatt, paramBluetoothGattCharacteristic, paramInt);
  }
  
  public void b(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt)
  {
    String str3 = this.b;
    String str2 = "";
    String str1;
    if (paramBluetoothGatt != null) {
      str1 = paramBluetoothGatt.getDevice().getAddress();
    } else {
      str1 = "";
    }
    if (paramBluetoothGattDescriptor != null) {
      str2 = paramBluetoothGattDescriptor.getUuid().toString().toUpperCase();
    }
    com.tencent.luggage.wxa.kn.a.c(str3, "[onDescriptorWrite]gatt deviceId:%s descriptorId:%s", new Object[] { str1, str2 });
    this.d.b(paramBluetoothGatt, paramBluetoothGattDescriptor, paramInt);
  }
  
  public BluetoothGatt c()
  {
    return this.e;
  }
  
  public void c(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2)
  {
    String str2 = this.b;
    String str1;
    if (paramBluetoothGatt != null) {
      str1 = paramBluetoothGatt.getDevice().getAddress();
    } else {
      str1 = "";
    }
    com.tencent.luggage.wxa.kn.a.c(str2, "[onMtuChanged]gatt deviceId:%s mtu:%d status:%s", new Object[] { str1, Integer.valueOf(paramInt1), f.a(paramInt2) });
    this.d.c(paramBluetoothGatt, paramInt1, paramInt2);
  }
  
  public Context d()
  {
    return this.c;
  }
  
  public List<com.tencent.luggage.wxa.kl.e> e()
  {
    if (this.e == null)
    {
      com.tencent.luggage.wxa.kn.a.a(this.b, "[getServices] bluetoothGatt is null, err", new Object[0]);
      return null;
    }
    if (af.c(this.a))
    {
      com.tencent.luggage.wxa.kn.a.a(this.b, "[getServices] deviceId is null, err", new Object[0]);
      return null;
    }
    if (this.f == null)
    {
      Object localObject = this.e.getServices();
      if (localObject == null)
      {
        com.tencent.luggage.wxa.kn.a.b(this.b, "[getServices] bluetoothGattServices is null, err", new Object[0]);
        return null;
      }
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        BluetoothGattService localBluetoothGattService = (BluetoothGattService)((Iterator)localObject).next();
        com.tencent.luggage.wxa.kl.e locale = new com.tencent.luggage.wxa.kl.e();
        locale.a = localBluetoothGattService.getUuid().toString().toUpperCase();
        boolean bool;
        if (localBluetoothGattService.getType() == 0) {
          bool = true;
        } else {
          bool = false;
        }
        locale.b = bool;
        if ((!locale.a.equals("00001800-0000-1000-8000-00805F9B34FB")) && (!locale.a.equals("00001801-0000-1000-8000-00805F9B34FB"))) {
          localArrayList1.add(locale);
        } else {
          localArrayList2.add(locale);
        }
      }
      if (localArrayList2.size() > 0) {
        localArrayList1.addAll(localArrayList2);
      }
      this.f = localArrayList1;
    }
    else
    {
      com.tencent.luggage.wxa.kn.a.c(this.b, "[getServices] use cache", new Object[0]);
    }
    return this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.ki.d
 * JD-Core Version:    0.7.0.1
 */