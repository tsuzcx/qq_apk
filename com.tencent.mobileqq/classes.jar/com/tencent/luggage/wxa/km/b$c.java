package com.tencent.luggage.wxa.km;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import androidx.collection.SimpleArrayMap;
import com.tencent.luggage.wxa.qz.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SuppressLint({"MissingPermission"})
@TargetApi(21)
class b$c
  implements b.e
{
  static final SimpleArrayMap<e, b.d> a = new SimpleArrayMap();
  
  private b.d a(e parame)
  {
    b.d locald = (b.d)a.get(parame);
    if (locald != null) {
      return locald;
    }
    locald = new b.d(parame);
    a.put(parame, locald);
    return locald;
  }
  
  public boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
  {
    parame = (b.d)a.remove(parame);
    if (parame == null) {
      return false;
    }
    if (paramBluetoothAdapter.getBluetoothLeScanner() == null)
    {
      o.b("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
      return false;
    }
    paramBluetoothAdapter.getBluetoothLeScanner().stopScan(parame);
    return true;
  }
  
  public boolean a(BluetoothAdapter paramBluetoothAdapter, List<f> paramList, i parami, e parame)
  {
    if (paramList != null)
    {
      ArrayList localArrayList = new ArrayList(paramList.size());
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localArrayList;
        if (!localIterator.hasNext()) {
          break;
        }
        localArrayList.add(((f)localIterator.next()).a());
      }
    }
    paramList = null;
    if (parami != null)
    {
      parami = parami.c();
      if (paramBluetoothAdapter.getBluetoothLeScanner() == null)
      {
        o.b("MicroMsg.ble.BleScannerCompat", "bluetoothscanner is null, return");
        return false;
      }
      paramBluetoothAdapter.getBluetoothLeScanner().startScan(paramList, parami, a(parame));
      return true;
    }
    paramBluetoothAdapter = new IllegalStateException("Scan settings are null");
    for (;;)
    {
      throw paramBluetoothAdapter;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.b.c
 * JD-Core Version:    0.7.0.1
 */