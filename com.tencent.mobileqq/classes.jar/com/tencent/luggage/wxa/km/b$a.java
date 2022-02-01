package com.tencent.luggage.wxa.km;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import androidx.collection.SimpleArrayMap;
import java.util.List;

@TargetApi(18)
class b$a
  implements b.e
{
  static final SimpleArrayMap<e, b.b> a = new SimpleArrayMap();
  
  private b.b a(List<f> paramList, e parame)
  {
    b.b localb = (b.b)a.get(parame);
    if (localb != null) {
      return localb;
    }
    paramList = new b.b(paramList, parame);
    a.put(parame, paramList);
    return paramList;
  }
  
  public boolean a(BluetoothAdapter paramBluetoothAdapter, e parame)
  {
    parame = (b.b)a.remove(parame);
    if (parame == null) {
      return false;
    }
    paramBluetoothAdapter.stopLeScan(parame);
    return true;
  }
  
  public boolean a(BluetoothAdapter paramBluetoothAdapter, List<f> paramList, i parami, e parame)
  {
    return paramBluetoothAdapter.startLeScan(a(paramList, parame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.b.a
 * JD-Core Version:    0.7.0.1
 */