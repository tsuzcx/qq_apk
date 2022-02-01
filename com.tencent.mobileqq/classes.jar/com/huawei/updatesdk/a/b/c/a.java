package com.huawei.updatesdk.a.b.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public abstract class a
  extends BroadcastReceiver
{
  public abstract void a(Context paramContext, b paramb);
  
  public final void onReceive(Context paramContext, Intent paramIntent)
  {
    a(paramContext, b.a(paramIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.c.a
 * JD-Core Version:    0.7.0.1
 */