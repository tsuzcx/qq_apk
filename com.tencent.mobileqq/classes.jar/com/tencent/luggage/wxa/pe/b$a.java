package com.tencent.luggage.wxa.pe;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

class b$a
  extends BroadcastReceiver
{
  private b$a(b paramb) {}
  
  public void onReceive(Context arg1, Intent paramIntent)
  {
    synchronized (b.a(this.a))
    {
      b.a(this.a, paramIntent);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pe.b.a
 * JD-Core Version:    0.7.0.1
 */