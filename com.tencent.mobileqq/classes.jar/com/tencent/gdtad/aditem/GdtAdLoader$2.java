package com.tencent.gdtad.aditem;

import java.lang.ref.WeakReference;
import ysn;
import yso;

public class GdtAdLoader$2
  implements Runnable
{
  public GdtAdLoader$2(ysn paramysn) {}
  
  public void run()
  {
    if ((ysn.a(this.this$0) != null) && (ysn.a(this.this$0).get() != null)) {
      ((yso)ysn.a(this.this$0).get()).onResponse(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.2
 * JD-Core Version:    0.7.0.1
 */