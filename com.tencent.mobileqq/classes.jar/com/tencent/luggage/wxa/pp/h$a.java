package com.tencent.luggage.wxa.pp;

import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import com.tencent.mm.plugin.appbrand.page.am;

final class h$a
{
  private final SparseIntArray a = new SparseIntArray();
  
  int a(@NonNull am paramam, int paramInt)
  {
    return this.a.get(paramam.hashCode(), paramInt);
  }
  
  void a(@NonNull am paramam)
  {
    this.a.delete(paramam.hashCode());
  }
  
  void b(@NonNull am paramam, int paramInt)
  {
    this.a.put(paramam.hashCode(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pp.h.a
 * JD-Core Version:    0.7.0.1
 */