package com.tencent.luggage.wxa.qa;

import android.widget.LinearLayout;
import java.util.LinkedList;

class a$13
  implements Runnable
{
  a$13(a parama) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.a.f.size())
    {
      a locala = this.a;
      locala.a(locala.b.getChildAt(i), (a.a)this.a.f.get(i));
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.luggage.wxa.qa.a.13
 * JD-Core Version:    0.7.0.1
 */