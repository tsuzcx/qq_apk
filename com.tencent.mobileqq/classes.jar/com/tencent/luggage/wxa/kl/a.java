package com.tencent.luggage.wxa.kl;

import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattDescriptor;
import android.os.Handler;
import android.os.Looper;
import com.tencent.luggage.wxa.ki.d;
import com.tencent.luggage.wxa.ki.e;

public abstract class a
  implements e
{
  private b a;
  private final Runnable b = new a.1(this);
  protected d f;
  protected com.tencent.luggage.wxa.ki.b g;
  protected final Handler h = new Handler(Looper.getMainLooper());
  public boolean i = com.tencent.luggage.wxa.kh.a.a.f;
  public boolean j = com.tencent.luggage.wxa.kh.a.a.h;
  public boolean k = com.tencent.luggage.wxa.kh.a.a.j;
  public long l = com.tencent.luggage.wxa.kh.a.a.d;
  public long m = com.tencent.luggage.wxa.kh.a.a.n;
  public j n;
  public volatile boolean o = false;
  protected int p = hashCode();
  
  private void e()
  {
    junit.framework.a.a(this.f);
    junit.framework.a.a(this.g);
    junit.framework.a.a(this.a);
  }
  
  public abstract void a();
  
  public void a(BluetoothGatt paramBluetoothGatt, int paramInt) {}
  
  public void a(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2) {}
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic) {}
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt) {}
  
  public void a(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt) {}
  
  public void a(com.tencent.luggage.wxa.ki.b paramb)
  {
    this.g = paramb;
  }
  
  public void a(d paramd)
  {
    this.f = paramd;
  }
  
  public void a(b paramb)
  {
    this.a = paramb;
  }
  
  public void a(j paramj) {}
  
  public abstract String b();
  
  public void b(BluetoothGatt paramBluetoothGatt, int paramInt) {}
  
  public void b(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2) {}
  
  public void b(BluetoothGatt paramBluetoothGatt, BluetoothGattCharacteristic paramBluetoothGattCharacteristic, int paramInt) {}
  
  public void b(BluetoothGatt paramBluetoothGatt, BluetoothGattDescriptor paramBluetoothGattDescriptor, int paramInt) {}
  
  public void b(j paramj)
  {
    this.n = paramj;
    if (this.j)
    {
      this.h.post(new a.2(this, paramj));
      return;
    }
    this.a.a(paramj);
  }
  
  public void c()
  {
    e();
    this.h.postDelayed(this.b, this.l);
    a();
  }
  
  public void c(BluetoothGatt paramBluetoothGatt, int paramInt1, int paramInt2) {}
  
  public void d()
  {
    this.h.removeCallbacks(this.b);
    this.o = true;
    a(this.n);
    this.g.a(this, this.n);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Action#");
    localStringBuilder.append(this.p);
    localStringBuilder.append("{action='");
    localStringBuilder.append(b());
    localStringBuilder.append('\'');
    localStringBuilder.append(", debug=");
    localStringBuilder.append(this.i);
    localStringBuilder.append(", mainThread=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", serial=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kl.a
 * JD-Core Version:    0.7.0.1
 */