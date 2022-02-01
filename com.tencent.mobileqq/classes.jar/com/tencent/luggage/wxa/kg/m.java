package com.tencent.luggage.wxa.kg;

import android.bluetooth.BluetoothDevice;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/peripheral/PendingRespStructure;", "", "device", "Landroid/bluetooth/BluetoothDevice;", "requestId", "", "offset", "(Landroid/bluetooth/BluetoothDevice;II)V", "getDevice", "()Landroid/bluetooth/BluetoothDevice;", "getOffset", "()I", "getRequestId", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class m
{
  @NotNull
  private final BluetoothDevice a;
  private final int b;
  private final int c;
  
  public m(@NotNull BluetoothDevice paramBluetoothDevice, int paramInt1, int paramInt2)
  {
    this.a = paramBluetoothDevice;
    this.b = paramInt1;
    this.c = paramInt2;
  }
  
  @NotNull
  public final BluetoothDevice a()
  {
    return this.a;
  }
  
  public final int b()
  {
    return this.b;
  }
  
  public final int c()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kg.m
 * JD-Core Version:    0.7.0.1
 */