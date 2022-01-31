package com.tencent.hlyyb.common.a;

import android.content.Context;
import android.content.IntentFilter;

final class d
  implements Runnable
{
  public final void run()
  {
    try
    {
      a.d();
      IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
      com.tencent.hlyyb.common.a.a().registerReceiver(a.j(), localIntentFilter);
      return;
    }
    catch (Throwable localThrowable) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.hlyyb.common.a.d
 * JD-Core Version:    0.7.0.1
 */