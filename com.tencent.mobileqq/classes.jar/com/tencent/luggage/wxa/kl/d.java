package com.tencent.luggage.wxa.kl;

import android.bluetooth.BluetoothDevice;
import android.os.ParcelUuid;
import android.util.Base64;
import android.util.SparseArray;
import com.tencent.luggage.wxa.km.g;
import com.tencent.luggage.wxa.km.h;
import com.tencent.luggage.wxa.qz.af;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.json.JSONArray;
import org.json.JSONObject;

public class d
{
  public String a;
  public String b;
  public int c;
  public SparseArray<byte[]> d;
  public List<ParcelUuid> e;
  public String f;
  public Map<ParcelUuid, byte[]> g;
  private JSONObject h;
  
  public d(h paramh)
  {
    this.a = af.b(paramh.a().getName());
    this.b = af.b(paramh.a().getAddress());
    this.c = paramh.c();
    this.d = paramh.b().b();
    this.e = paramh.b().a();
    this.f = af.b(paramh.b().d());
    this.g = paramh.b().c();
  }
  
  public d(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public JSONObject a()
  {
    if (this.h == null)
    {
      this.h = new JSONObject();
      this.h.put("deviceId", this.b);
      this.h.put("name", this.a);
      this.h.put("RSSI", this.c);
      Object localObject1 = new byte[0];
      Object localObject3 = new StringBuilder();
      SparseArray localSparseArray = this.d;
      Object localObject2 = localObject1;
      if (localSparseArray != null)
      {
        localObject2 = localObject1;
        if (localSparseArray.size() >= 0)
        {
          int i = 0;
          while (i < this.d.size())
          {
            localObject1 = a((byte[])localObject1, a(this.d.keyAt(0)), (byte[])this.d.valueAt(i));
            i += 1;
          }
          localObject2 = localObject1;
        }
      }
      ((StringBuilder)localObject3).append(new String(Base64.encode((byte[])localObject2, 2)));
      this.h.put("advertisData", localObject3);
      localObject1 = new JSONArray();
      localObject2 = this.e;
      if (localObject2 != null)
      {
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          ((JSONArray)localObject1).put(((ParcelUuid)((Iterator)localObject2).next()).getUuid().toString().toUpperCase());
        }
      }
      this.h.put("advertisServiceUUIDs", localObject1);
      this.h.put("localName", this.f);
      localObject1 = new JSONObject();
      localObject2 = this.g;
      if ((localObject2 != null) && (((Map)localObject2).size() > 0))
      {
        localObject2 = this.g.keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (ParcelUuid)((Iterator)localObject2).next();
          ((JSONObject)localObject1).put(((ParcelUuid)localObject3).getUuid().toString().toUpperCase(), new String(Base64.encode((byte[])this.g.get(localObject3), 2)));
        }
      }
      this.h.put("serviceData", localObject1);
    }
    return this.h;
  }
  
  public byte[] a(int paramInt)
  {
    return new byte[] { (byte)(paramInt & 0xFF), (byte)(paramInt >> 8 & 0xFF) };
  }
  
  public byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    byte[] arrayOfByte = new byte[paramArrayOfByte1.length + paramArrayOfByte2.length + paramArrayOfByte3.length];
    System.arraycopy(paramArrayOfByte1, 0, arrayOfByte, 0, paramArrayOfByte1.length);
    System.arraycopy(paramArrayOfByte2, 0, arrayOfByte, paramArrayOfByte1.length, paramArrayOfByte2.length);
    System.arraycopy(paramArrayOfByte3, 0, arrayOfByte, paramArrayOfByte1.length + paramArrayOfByte2.length, paramArrayOfByte3.length);
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kl.d
 * JD-Core Version:    0.7.0.1
 */