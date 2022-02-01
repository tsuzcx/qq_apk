package com.tencent.luggage.wxa.lx;

import android.telephony.PhoneStateListener;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

class f$b
{
  private PhoneStateListener b = null;
  private boolean c = false;
  private List<f.a> d = null;
  
  private f$b(f paramf) {}
  
  @MainThread
  @NonNull
  public PhoneStateListener a()
  {
    try
    {
      if (this.b == null) {
        this.b = new f.b.1(this);
      }
      PhoneStateListener localPhoneStateListener = this.b;
      return localPhoneStateListener;
    }
    finally {}
  }
  
  public void a(@NonNull f.a parama)
  {
    try
    {
      if (this.d == null) {
        this.d = new ArrayList();
      }
      this.d.add(parama);
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    try
    {
      boolean bool = this.c;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.lx.f.b
 * JD-Core Version:    0.7.0.1
 */