package com.tencent.gdtad.aditem;

import java.lang.ref.WeakReference;

class GdtAdLoader$2
  implements Runnable
{
  GdtAdLoader$2(GdtAdLoader paramGdtAdLoader) {}
  
  public void run()
  {
    if ((GdtAdLoader.c(this.this$0) != null) && (GdtAdLoader.c(this.this$0).get() != null)) {
      ((GdtAdLoader.Listener)GdtAdLoader.c(this.this$0).get()).onResponse(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.2
 * JD-Core Version:    0.7.0.1
 */