package com.tencent.luggage.wxa.kv;

import android.bluetooth.BluetoothAdapter.LeScanCallback;
import android.bluetooth.BluetoothDevice;
import com.tencent.luggage.wxa.qz.af;
import com.tencent.luggage.wxa.qz.o;
import java.util.Map;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

class a$a$1
  implements BluetoothAdapter.LeScanCallback
{
  a$a$1(a.a parama) {}
  
  private void a(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("handleScanData, device: ");
    ((StringBuilder)localObject1).append(paramBluetoothDevice);
    o.d("MicroMsg.BeaconManager", ((StringBuilder)localObject1).toString());
    int i = 2;
    while (i <= 5)
    {
      if (((paramArrayOfByte[(i + 2)] & 0xFF) == 2) && ((paramArrayOfByte[(i + 3)] & 0xFF) == 21))
      {
        j = 1;
        break label90;
      }
      i += 1;
    }
    int j = 0;
    label90:
    if (j != 0)
    {
      localObject1 = new byte[16];
      System.arraycopy(paramArrayOfByte, i + 4, localObject1, 0, 16);
      localObject1 = b.a((byte[])localObject1, localObject1.length);
      if (af.c((String)localObject1))
      {
        o.b("MicroMsg.BeaconManager", "hexString is null, err");
        return;
      }
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((String)localObject1).substring(0, 8));
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append(((String)localObject1).substring(8, 12));
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append(((String)localObject1).substring(12, 16));
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append(((String)localObject1).substring(16, 20));
      ((StringBuilder)localObject2).append("-");
      ((StringBuilder)localObject2).append(((String)localObject1).substring(20, 32));
      localObject1 = ((StringBuilder)localObject2).toString();
      o.d("MicroMsg.BeaconManager", "strUuid %s", new Object[] { localObject1 });
      localObject1 = UUID.fromString((String)localObject1);
      localObject2 = a.a.a(this.a);
      int k = localObject2.length;
      j = 0;
      while (j < k)
      {
        if (localObject2[j].equals(localObject1))
        {
          j = 1;
          break label340;
        }
        j += 1;
      }
      j = 0;
      if (j == 0)
      {
        o.d("MicroMsg.BeaconManager", "not found beacon!");
        return;
      }
      j = paramArrayOfByte[(i + 20)];
      k = paramArrayOfByte[(i + 21)];
      int m = paramArrayOfByte[(i + 22)];
      int n = paramArrayOfByte[(i + 23)];
      double d = b.a(paramArrayOfByte[(i + 24)], paramInt);
      paramBluetoothDevice = paramBluetoothDevice.getAddress();
      paramArrayOfByte = new JSONObject();
      try
      {
        paramArrayOfByte.put("uuid", localObject1);
        paramArrayOfByte.put("major", (j & 0xFF) * 256 + (k & 0xFF));
        paramArrayOfByte.put("minor", (m & 0xFF) * 256 + (n & 0xFF));
        paramArrayOfByte.put("proximity", 0);
        paramArrayOfByte.put("accuracy", d);
        paramArrayOfByte.put("rssi", paramInt);
        a.a.b(this.a).put(paramBluetoothDevice, paramArrayOfByte);
        a.a.c(this.a).put(paramBluetoothDevice, paramArrayOfByte);
        o.e("MicroMsg.BeaconManager", "found device ibeacon %s", new Object[] { paramArrayOfByte });
      }
      catch (JSONException paramBluetoothDevice)
      {
        o.b("MicroMsg.BeaconManager", "put JSON data error : %s", new Object[] { paramBluetoothDevice });
      }
      long l = System.currentTimeMillis();
      if (l - a.a.d(this.a) > 500L)
      {
        if (a.a.e(this.a) != null) {
          a.a.e(this.a).a(a.a.c(this.a));
        }
        a.a.a(this.a, l);
        a.a.c(this.a).clear();
      }
    }
    label340:
  }
  
  public void onLeScan(BluetoothDevice paramBluetoothDevice, int paramInt, byte[] paramArrayOfByte)
  {
    if (af.a(paramArrayOfByte))
    {
      o.b("MicroMsg.BeaconManager", "valueByte is null or nil");
      return;
    }
    a(paramBluetoothDevice, paramInt, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kv.a.a.1
 * JD-Core Version:    0.7.0.1
 */