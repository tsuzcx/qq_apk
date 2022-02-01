package com.tencent.luggage.ui;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.ServiceConnection;
import android.util.Log;
import android.view.ContextThemeWrapper;
import androidx.annotation.StyleRes;
import com.tencent.luggage.wxa.qz.o;
import com.tencent.mm.ui.base.k;

public class d
  extends MutableContextWrapper
{
  private boolean a = false;
  private final ContextThemeWrapper b;
  
  public d(Context paramContext, @StyleRes int paramInt)
  {
    super(paramContext);
    this.b = new d.a(paramContext.getApplicationContext(), paramInt);
    if (!(paramContext instanceof ContextThemeWrapper)) {
      super.setBaseContext(this.b);
    } else {
      paramContext.setTheme(paramInt);
    }
    this.a = (paramContext instanceof Activity);
  }
  
  public static d a(Context paramContext)
  {
    return new d(paramContext, 2131952947);
  }
  
  public void setBaseContext(Context paramContext)
  {
    if (paramContext == getBaseContext()) {
      return;
    }
    if (this.a) {
      o.d("MicroMsg.AppBrandRuntimePersistentContextWrapper", "setBaseContext hash:%d, new:%s, old:%s, stack:%s", new Object[] { Integer.valueOf(hashCode()), paramContext, super.getBaseContext(), Log.getStackTraceString(new Throwable()) });
    }
    if ((paramContext instanceof Activity))
    {
      super.setBaseContext(paramContext);
      this.a = true;
      return;
    }
    if ((paramContext instanceof k))
    {
      super.setBaseContext(paramContext);
      return;
    }
    super.setBaseContext(this.b);
  }
  
  public void unbindService(ServiceConnection paramServiceConnection)
  {
    try
    {
      super.unbindService(paramServiceConnection);
      return;
    }
    catch (IllegalArgumentException paramServiceConnection)
    {
      o.a("MicroMsg.AppBrandRuntimePersistentContextWrapper", paramServiceConnection, "[CAPTURED CRASH]", new Object[0]);
    }
  }
  
  public void unregisterReceiver(BroadcastReceiver paramBroadcastReceiver)
  {
    try
    {
      super.unregisterReceiver(paramBroadcastReceiver);
      return;
    }
    catch (IllegalArgumentException paramBroadcastReceiver)
    {
      o.b("MicroMsg.AppBrandRuntimePersistentContextWrapper", "unregisterReceiver IllegalArgumentException %s", new Object[] { paramBroadcastReceiver });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.ui.d
 * JD-Core Version:    0.7.0.1
 */