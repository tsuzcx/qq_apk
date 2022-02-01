package com.tencent.luggage.wxa.kj;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import com.tencent.luggage.wxa.ki.d;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.kn.c;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Action;", "deviceId", "", "pin", "", "timeoutMs", "", "forcePair", "", "(Ljava/lang/String;[BJZ)V", "myTag", "pairReceiver", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "doActionImpl", "", "getName", "onDone", "result", "Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/model/Result;", "PairReceiver", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
public final class f
  extends com.tencent.luggage.wxa.kl.a
{
  private final String a;
  private f.a b;
  private final String c;
  private final byte[] d;
  private final boolean e;
  
  public f(@NotNull String paramString, @Nullable byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    this.c = paramString;
    this.d = paramArrayOfByte;
    this.e = paramBoolean;
    paramString = new StringBuilder();
    paramString.append("MicroMsg.AppBrand.PairAction#");
    paramString.append(hashCode());
    this.a = paramString.toString();
    this.l = paramLong;
  }
  
  public void a()
  {
    if (!c.f())
    {
      com.tencent.luggage.wxa.kn.a.b(this.a, "Bluetooth is not enable.", new Object[0]);
      b(j.d);
      d();
      return;
    }
    if (!BluetoothAdapter.checkBluetoothAddress(this.c))
    {
      com.tencent.luggage.wxa.kn.a.b(this.a, "Invalid deviceId", new Object[0]);
      b(j.r);
      d();
      return;
    }
    Object localObject2 = c.b();
    if (localObject2 == null)
    {
      com.tencent.luggage.wxa.kn.a.b(this.a, "Bluetooth is not enable.", new Object[0]);
      b(j.d);
      d();
      return;
    }
    Object localObject1 = ((BluetoothAdapter)localObject2).getRemoteDevice(this.c);
    if (!this.e)
    {
      localObject2 = ((BluetoothAdapter)localObject2).getBondedDevices();
      if ((localObject2 != null) && (true == ((Set)localObject2).contains(localObject1)))
      {
        com.tencent.luggage.wxa.kn.a.c(this.a, "already paired", new Object[0]);
        b(j.a);
        d();
        return;
      }
    }
    com.tencent.luggage.wxa.kn.a.c(this.a, "createBond", new Object[0]);
    if (!((BluetoothDevice)localObject1).createBond())
    {
      com.tencent.luggage.wxa.kn.a.b(this.a, "startPairing is false", new Object[0]);
      b(j.k);
      d();
      return;
    }
    localObject2 = this.f;
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "worker");
    localObject2 = ((d)localObject2).d();
    if (localObject2 == null)
    {
      com.tencent.luggage.wxa.kn.a.b(this.a, "context is null", new Object[0]);
      b(j.k);
      d();
      return;
    }
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "device");
    this.b = new f.a(this, (Context)localObject2, (BluetoothDevice)localObject1);
    localObject1 = this.b;
    if (localObject1 != null) {
      ((f.a)localObject1).a();
    }
  }
  
  public void a(@Nullable j paramj)
  {
    super.a(paramj);
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDone, result: ");
    localStringBuilder.append(paramj);
    com.tencent.luggage.wxa.kn.a.c(str, localStringBuilder.toString(), new Object[0]);
    paramj = this.b;
    if (paramj != null) {
      paramj.b();
    }
    this.b = ((f.a)null);
  }
  
  @NotNull
  public String b()
  {
    return "PairAction";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kj.f
 * JD-Core Version:    0.7.0.1
 */