package com.tencent.gdtad.aditem;

import aamt;
import aamu;
import java.lang.ref.WeakReference;

public class GdtAdLoader$2
  implements Runnable
{
  public GdtAdLoader$2(aamt paramaamt) {}
  
  public void run()
  {
    if ((aamt.a(this.this$0) != null) && (aamt.a(this.this$0).get() != null)) {
      ((aamu)aamt.a(this.this$0).get()).onResponse(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.2
 * JD-Core Version:    0.7.0.1
 */