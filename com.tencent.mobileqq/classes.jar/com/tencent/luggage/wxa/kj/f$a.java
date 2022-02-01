package com.tencent.luggage.wxa.kj;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.luggage.wxa.kl.j;
import com.tencent.luggage.wxa.kn.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction$PairReceiver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "device", "Landroid/bluetooth/BluetoothDevice;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/bluetooth/sdk/connect/action/PairAction;Landroid/content/Context;Landroid/bluetooth/BluetoothDevice;)V", "onReceive", "", "intent", "Landroid/content/Intent;", "registerSelf", "unregisterSelf", "luggage-commons-jsapi-connectivity-ext_release"}, k=1, mv={1, 1, 16})
final class f$a
  extends BroadcastReceiver
{
  private final Context b;
  private final BluetoothDevice c;
  
  public f$a(Context paramContext, @NotNull BluetoothDevice paramBluetoothDevice)
  {
    this.b = paramBluetoothDevice;
    this.c = localObject;
  }
  
  public final void a()
  {
    a.c(f.a(this.a), "pairReceiver.registerSelf", new Object[0]);
    Context localContext = this.b;
    BroadcastReceiver localBroadcastReceiver = (BroadcastReceiver)this;
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("android.bluetooth.device.action.PAIRING_REQUEST");
    localIntentFilter.addAction("android.bluetooth.device.action.BOND_STATE_CHANGED");
    localContext.registerReceiver(localBroadcastReceiver, localIntentFilter);
  }
  
  public final void b()
  {
    a.c(f.a(this.a), "pairReceiver.unregisterSelf", new Object[0]);
    this.b.unregisterReceiver((BroadcastReceiver)this);
  }
  
  public void onReceive(@Nullable Context paramContext, @Nullable Intent paramIntent)
  {
    Object localObject = this.c;
    if (paramIntent != null) {
      paramContext = paramIntent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
    } else {
      paramContext = null;
    }
    if ((Intrinsics.areEqual(localObject, paramContext) ^ true)) {
      return;
    }
    paramContext = f.a(this.a);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceive, intent: ");
    ((StringBuilder)localObject).append(paramIntent);
    a.c(paramContext, ((StringBuilder)localObject).toString(), new Object[0]);
    if (Intrinsics.areEqual("android.bluetooth.device.action.PAIRING_REQUEST", paramIntent.getAction()))
    {
      if (!paramIntent.hasExtra("android.bluetooth.device.extra.PAIRING_VARIANT"))
      {
        a.b(f.a(this.a), "Cannot find EXTRA_PAIRING_VARIANT", new Object[0]);
        return;
      }
      int i = paramIntent.getIntExtra("android.bluetooth.device.extra.PAIRING_VARIANT", -1);
      if (i != 0)
      {
        if (i != 2) {
          return;
        }
        a.c(f.a(this.a), "PAIRING_VARIANT_PASSKEY_CONFIRMATION", new Object[0]);
        return;
      }
      a.c(f.a(this.a), "PAIRING_VARIANT_PIN", new Object[0]);
      if (f.b(this.a) == null)
      {
        this.a.b(j.t);
        this.a.d();
        return;
      }
      a.c(f.a(this.a), "setPin", new Object[0]);
      this.c.setPin(f.b(this.a));
      return;
    }
    if (Intrinsics.areEqual("android.bluetooth.device.action.BOND_STATE_CHANGED", paramIntent.getAction()))
    {
      if (!paramIntent.hasExtra("android.bluetooth.device.extra.BOND_STATE"))
      {
        a.b(f.a(this.a), "Cannot find EXTRA_BOND_STATE", new Object[0]);
        return;
      }
      switch (paramIntent.getIntExtra("android.bluetooth.device.extra.BOND_STATE", -1))
      {
      default: 
        return;
      case 12: 
        a.c(f.a(this.a), "BOND_BONDED", new Object[0]);
        this.a.b(j.a);
        this.a.d();
        return;
      case 11: 
        a.c(f.a(this.a), "BOND_BONDING", new Object[0]);
        return;
      }
      paramContext = f.a(this.a);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("BOND_NONE, reason: ");
      ((StringBuilder)localObject).append(paramIntent.getIntExtra("android.bluetooth.device.extra.REASON", -1));
      a.c(paramContext, ((StringBuilder)localObject).toString(), new Object[0]);
      this.a.b(j.b);
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.kj.f.a
 * JD-Core Version:    0.7.0.1
 */