package com.tencent.luggage.wxa.pq;

import android.database.DataSetObserver;

class f$c
  extends DataSetObserver
{
  private f$c(f paramf) {}
  
  public void onChanged()
  {
    if (this.a.g()) {
      this.a.a();
    }
  }
  
  public void onInvalidated()
  {
    this.a.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.f.c
 * JD-Core Version:    0.7.0.1
 */