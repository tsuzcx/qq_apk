package com.tencent.luggage.wxa.km;

import android.annotation.TargetApi;
import android.bluetooth.le.ScanRecord;
import android.os.ParcelUuid;
import android.util.Log;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class g
{
  private final int a;
  @Nullable
  private final List<ParcelUuid> b;
  private final SparseArray<byte[]> c;
  private final Map<ParcelUuid, byte[]> d;
  private final int e;
  private final String f;
  private final byte[] g;
  
  @TargetApi(21)
  g(ScanRecord paramScanRecord)
  {
    this.b = paramScanRecord.getServiceUuids();
    this.c = paramScanRecord.getManufacturerSpecificData();
    this.d = paramScanRecord.getServiceData();
    this.f = paramScanRecord.getDeviceName();
    this.a = paramScanRecord.getAdvertiseFlags();
    this.e = paramScanRecord.getTxPowerLevel();
    this.g = paramScanRecord.getBytes();
  }
  
  private g(@Nullable List<ParcelUuid> paramList, SparseArray<byte[]> paramSparseArray, Map<ParcelUuid, byte[]> paramMap, int paramInt1, int paramInt2, String paramString, byte[] paramArrayOfByte)
  {
    this.b = paramList;
    this.c = paramSparseArray;
    this.d = paramMap;
    this.f = paramString;
    this.a = paramInt1;
    this.e = paramInt2;
    this.g = paramArrayOfByte;
  }
  
  private static int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, List<ParcelUuid> paramList)
  {
    while (paramInt2 > 0)
    {
      paramList.add(c.a(a(paramArrayOfByte, paramInt1, paramInt3)));
      paramInt2 -= paramInt3;
      paramInt1 += paramInt3;
    }
    return paramInt1;
  }
  
  public static g a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    int k = 0;
    ArrayList localArrayList = new ArrayList();
    SparseArray localSparseArray = new SparseArray();
    ArrayMap localArrayMap = new ArrayMap();
    Object localObject = null;
    int j = -1;
    int i = -2147483648;
    try
    {
      if (k >= paramArrayOfByte.length) {
        break label204;
      }
      n = k + 1;
      k = paramArrayOfByte[k] & 0xFF;
      if (k != 0) {
        break label302;
      }
    }
    catch (Exception localException)
    {
      int n;
      int m;
      do
      {
        do
        {
          break label243;
          k -= 1;
          m = n + 1;
          n = paramArrayOfByte[n] & 0xFF;
        } while (n == 22);
      } while (n == 255);
      switch (n)
      {
      case 8: 
      case 9: 
      case 6: 
      case 7: 
      case 4: 
      case 5: 
      case 2: 
      case 3: 
      default: 
        break;
      case 10: 
        i = paramArrayOfByte[m];
        break;
      case 1: 
        j = paramArrayOfByte[m] & 0xFF;
      }
      k += m;
    }
    localObject = new String(a(paramArrayOfByte, m, k));
    break label412;
    a(paramArrayOfByte, m, k, 16, localArrayList);
    break label412;
    a(paramArrayOfByte, m, k, 4, localArrayList);
    break label412;
    a(paramArrayOfByte, m, k, 2, localArrayList);
    break label412;
    localSparseArray.put(((paramArrayOfByte[(m + 1)] & 0xFF) << 8) + (0xFF & paramArrayOfByte[m]), a(paramArrayOfByte, m + 2, k - 2));
    break label412;
    localArrayMap.put(c.a(a(paramArrayOfByte, m, 2)), a(paramArrayOfByte, m + 2, k - 2));
    break label412;
    label204:
    if (localArrayList.isEmpty()) {
      localArrayList = null;
    }
    label412:
    for (;;)
    {
      localObject = new g(localArrayList, localSparseArray, localArrayMap, j, i, (String)localObject, paramArrayOfByte);
      return localObject;
      label243:
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("unable to parse scan record: ");
      ((StringBuilder)localObject).append(Arrays.toString(paramArrayOfByte));
      Log.e("ScanRecordCompat", ((StringBuilder)localObject).toString());
      return new g(null, null, null, -1, -2147483648, null, paramArrayOfByte);
      label302:
      break;
    }
  }
  
  static String a(SparseArray<byte[]> paramSparseArray)
  {
    if (paramSparseArray == null) {
      return "null";
    }
    if (paramSparseArray.size() == 0) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('{');
    int i = 0;
    while (i < paramSparseArray.size())
    {
      localStringBuilder.append(paramSparseArray.keyAt(i));
      localStringBuilder.append("=");
      localStringBuilder.append(Arrays.toString((byte[])paramSparseArray.valueAt(i)));
      i += 1;
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  static <T> String a(Map<T, byte[]> paramMap)
  {
    if (paramMap == null) {
      return "null";
    }
    if (paramMap.isEmpty()) {
      return "{}";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append('{');
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = ((Map.Entry)localIterator.next()).getKey();
      localStringBuilder.append(localObject);
      localStringBuilder.append("=");
      localStringBuilder.append(Arrays.toString((byte[])paramMap.get(localObject)));
      if (localIterator.hasNext()) {
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  private static byte[] a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    byte[] arrayOfByte = new byte[paramInt2];
    System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, 0, paramInt2);
    return arrayOfByte;
  }
  
  public List<ParcelUuid> a()
  {
    return this.b;
  }
  
  @Nullable
  public byte[] a(int paramInt)
  {
    return (byte[])this.c.get(paramInt);
  }
  
  @Nullable
  public byte[] a(ParcelUuid paramParcelUuid)
  {
    if (paramParcelUuid == null) {
      return null;
    }
    return (byte[])this.d.get(paramParcelUuid);
  }
  
  public SparseArray<byte[]> b()
  {
    return this.c;
  }
  
  public Map<ParcelUuid, byte[]> c()
  {
    return this.d;
  }
  
  @Nullable
  public String d()
  {
    return this.f;
  }
  
  public byte[] e()
  {
    return this.g;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ScanRecord [mAdvertiseFlags=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", mServiceUuids=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", mManufacturerSpecificData=");
    localStringBuilder.append(a(this.c));
    localStringBuilder.append(", mServiceData=");
    localStringBuilder.append(a(this.d));
    localStringBuilder.append(", mTxPowerLevel=");
    localStringBuilder.append(this.e);
    localStringBuilder.append(", mDeviceName=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.g
 * JD-Core Version:    0.7.0.1
 */