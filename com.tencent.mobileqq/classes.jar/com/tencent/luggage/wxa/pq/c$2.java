package com.tencent.luggage.wxa.pq;

import android.database.DataSetObserver;

class c$2
  extends DataSetObserver
{
  c$2(c paramc) {}
  
  public void onChanged()
  {
    if (!c.a(this.a).g()) {
      return;
    }
    c.b(this.a, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.c.2
 * JD-Core Version:    0.7.0.1
 */