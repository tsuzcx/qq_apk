package com.tencent.luggage.wxa.bm;

class e$d
  implements Runnable
{
  private d a;
  private e.e b;
  
  public void run()
  {
    if (this.a == null) {
      return;
    }
    e.e locale = this.b;
    if (locale != null) {
      locale.release(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.bm.e.d
 * JD-Core Version:    0.7.0.1
 */