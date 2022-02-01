package com.tencent.luggage.wxa.kv;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.luggage.wxa.qz.r;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class a$a
{
  private BluetoothAdapter a;
  private Map<String, JSONObject> b = new ConcurrentHashMap();
  private UUID[] c = null;
  private a.a.a d;
  private volatile boolean e = false;
  private long f = 0L;
  private Map<String, JSONObject> g = new ConcurrentHashMap();
  private BluetoothAdapter.LeScanCallback h = new a.a.1(this);
  
  public a$a()
  {
    d();
  }
  
  private void d()
  {
    Object localObject = (BluetoothManager)r.a().getSystemService("bluetooth");
    if (localObject == null)
    {
      o.b("MicroMsg.BeaconManager", "bluetoothManager is null!");
      return;
    }
    this.a = ((BluetoothManager)localObject).getAdapter();
    localObject = this.a;
    if (localObject == null)
    {
      o.b("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
      return;
    }
    a.c = ((BluetoothAdapter)localObject).isEnabled();
  }
  
  private boolean e()
  {
    try
    {
      boolean bool = this.e;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public Map<String, JSONObject> a()
  {
    return this.b;
  }
  
  public void a(a.a.a parama)
  {
    this.d = parama;
  }
  
  public void a(boolean paramBoolean)
  {
    if ((e()) && (!paramBoolean)) {
      c();
    }
    a.a.a locala = this.d;
    if (locala != null) {
      locala.a(paramBoolean);
    }
  }
  
  public void a(UUID[] paramArrayOfUUID)
  {
    this.c = paramArrayOfUUID;
  }
  
  public com.tencent.luggage.wxa.rr.c<Integer, String> b()
  {
    o.d("MicroMsg.BeaconManager", "BeaconWorker:%d start", new Object[] { Integer.valueOf(hashCode()) });
    boolean bool = e();
    Integer localInteger = Integer.valueOf(11003);
    if (bool)
    {
      o.d("MicroMsg.BeaconManager", "BeaconWorker:%d, already start", new Object[] { Integer.valueOf(hashCode()) });
      return com.tencent.luggage.wxa.rr.c.a(localInteger, "fail:already start");
    }
    if (com.tencent.luggage.wxa.hg.c.b(18))
    {
      o.b("MicroMsg.BeaconManager", "API version is below 18!");
      return com.tencent.luggage.wxa.rr.c.a(Integer.valueOf(11000), "fail:not support");
    }
    BluetoothAdapter localBluetoothAdapter = this.a;
    if (localBluetoothAdapter == null)
    {
      o.b("MicroMsg.BeaconManager", "bluetoothAdapter is null!");
      return com.tencent.luggage.wxa.rr.c.a(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
    }
    if (!localBluetoothAdapter.isEnabled())
    {
      o.b("MicroMsg.BeaconManager", "bluetoothAdapter is not enabled!");
      return com.tencent.luggage.wxa.rr.c.a(Integer.valueOf(11001), "fail:bluetooth service is unavailable");
    }
    if (this.a.isDiscovering())
    {
      o.b("MicroMsg.BeaconManager", "bluetoothAdapter is Discovering!");
      return com.tencent.luggage.wxa.rr.c.a(localInteger, "fail:already start");
    }
    this.b.clear();
    bool = this.a.startLeScan(this.h);
    o.d("MicroMsg.BeaconManager", "startLeScan:%b", new Object[] { Boolean.valueOf(bool) });
    if (!bool) {
      return com.tencent.luggage.wxa.rr.c.a(Integer.valueOf(11005), "fail:system error");
    }
    this.e = true;
    return com.tencent.luggage.wxa.rr.c.a(Integer.valueOf(0), "");
  }
  
  public boolean c()
  {
    o.d("MicroMsg.BeaconManager", "BeaconWorker:%d stop", new Object[] { Integer.valueOf(hashCode()) });
    if (!e())
    {
      o.d("MicroMsg.BeaconManager", "BeaconWorker:%d, already stop", new Object[] { Integer.valueOf(hashCode()) });
      return false;
    }
    this.b.clear();
    this.a.stopLeScan(this.h);
    this.e = false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kv.a.a
 * JD-Core Version:    0.7.0.1
 */