package com.tencent.luggage.wxa.kn;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import com.tencent.luggage.wxa.qz.r;
import java.lang.reflect.Method;
import java.util.UUID;

public class c
{
  public static BluetoothManager a()
  {
    try
    {
      BluetoothManager localBluetoothManager = (BluetoothManager)r.a().getSystemService("bluetooth");
      return localBluetoothManager;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static boolean a(int paramInt)
  {
    return (paramInt & 0x2) > 0;
  }
  
  @TargetApi(18)
  public static boolean a(BluetoothGatt paramBluetoothGatt)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramBluetoothGatt != null) {}
    try
    {
      Method localMethod = BluetoothGatt.class.getMethod("refresh", new Class[0]);
      bool1 = bool2;
      if (localMethod != null)
      {
        localMethod.setAccessible(true);
        bool1 = ((Boolean)localMethod.invoke(paramBluetoothGatt, new Object[0])).booleanValue();
      }
      return bool1;
    }
    catch (Exception paramBluetoothGatt) {}
    return false;
  }
  
  public static boolean a(String paramString)
  {
    return ContextCompat.checkSelfPermission(r.a(), paramString) == 0;
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte != null) && (paramArrayOfByte.length != 0)) {
      return paramArrayOfByte;
    }
    a.a("MicroMsg.Ble.BleHelper", "data is null", new Object[0]);
    return new byte[0];
  }
  
  @SuppressLint({"MissingPermission", "NewApi"})
  @Nullable
  public static BluetoothAdapter b()
  {
    try
    {
      Object localObject1 = a();
      if (localObject1 != null)
      {
        localObject1 = ((BluetoothManager)localObject1).getAdapter();
        return localObject1;
      }
      a.a("MicroMsg.Ble.BleHelper", "BluetoothManager is null err", new Object[0]);
      return null;
    }
    finally {}
  }
  
  public static boolean b(int paramInt)
  {
    return (paramInt & 0x8) > 0;
  }
  
  public static boolean b(String paramString)
  {
    try
    {
      UUID.fromString(paramString);
      return true;
    }
    catch (Exception paramString)
    {
      label7:
      break label7;
    }
    return false;
  }
  
  public static boolean c()
  {
    return (!com.tencent.luggage.wxa.hg.c.b(18)) && (g());
  }
  
  public static boolean c(int paramInt)
  {
    return (paramInt & 0x4) > 0;
  }
  
  public static boolean d()
  {
    Object localObject = (LocationManager)r.a().getSystemService("location");
    boolean bool4 = false;
    boolean bool2;
    boolean bool1;
    if (localObject != null)
    {
      bool2 = ((LocationManager)localObject).isProviderEnabled("gps");
      bool1 = ((LocationManager)localObject).isProviderEnabled("network");
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("isGPSEnable ");
      ((StringBuilder)localObject).append(bool2);
      ((StringBuilder)localObject).append(", isNetworkEnable:");
      ((StringBuilder)localObject).append(bool1);
      a.c("MicroMsg.Ble.BleHelper", ((StringBuilder)localObject).toString(), new Object[0]);
    }
    else
    {
      bool1 = false;
      bool2 = false;
    }
    boolean bool3 = bool4;
    if (bool2)
    {
      bool3 = bool4;
      if (bool1) {
        bool3 = true;
      }
    }
    return bool3;
  }
  
  public static boolean d(int paramInt)
  {
    return (paramInt & 0x10) > 0;
  }
  
  public static boolean e()
  {
    return (a("android.permission.ACCESS_COARSE_LOCATION")) || (a("android.permission.ACCESS_FINE_LOCATION"));
  }
  
  public static boolean e(int paramInt)
  {
    return (paramInt & 0x20) > 0;
  }
  
  public static boolean f()
  {
    if (b() == null) {
      return false;
    }
    return b().isEnabled();
  }
  
  private static boolean g()
  {
    return r.a().getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kn.c
 * JD-Core Version:    0.7.0.1
 */