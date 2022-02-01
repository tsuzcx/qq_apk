package com.tencent.luggage.wxa.km;

import android.annotation.TargetApi;
import android.bluetooth.BluetoothAdapter;
import android.os.Build.VERSION;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.tencent.luggage.wxa.kh.a;
import com.tencent.luggage.wxa.qz.o;
import java.util.List;

@TargetApi(18)
public class b
{
  static final b.e a = new b.a();
  
  static
  {
    int i = Build.VERSION.SDK_INT;
    if (!a.p)
    {
      o.d("MicroMsg.ble.BleScannerCompat", "use 18");
      a = new b.a();
      return;
    }
    if (i >= 21)
    {
      o.d("MicroMsg.ble.BleScannerCompat", "use 21");
      a = new b.c();
      return;
    }
    o.d("MicroMsg.ble.BleScannerCompat", "use 18");
  }
  
  public static boolean a(@NonNull BluetoothAdapter paramBluetoothAdapter, @NonNull e parame)
  {
    return a.a(paramBluetoothAdapter, parame);
  }
  
  public static boolean a(@NonNull BluetoothAdapter paramBluetoothAdapter, @Nullable List<f> paramList, @NonNull i parami, @NonNull e parame)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("scanMode: ");
    localStringBuilder.append(parami.a());
    o.d("MicroMsg.ble.BleScannerCompat", localStringBuilder.toString());
    return a.a(paramBluetoothAdapter, paramList, parami, parame);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.km.b
 * JD-Core Version:    0.7.0.1
 */