package com.tencent.luggage.wxa.pq;

import android.widget.Filter.FilterListener;

class b$5
  implements Filter.FilterListener
{
  b$5(b paramb) {}
  
  public void onFilterComplete(int paramInt)
  {
    if (paramInt <= 0)
    {
      b.b(this.a).e();
      return;
    }
    if (b.b(this.a).g()) {
      b.b(this.a).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.pq.b.5
 * JD-Core Version:    0.7.0.1
 */