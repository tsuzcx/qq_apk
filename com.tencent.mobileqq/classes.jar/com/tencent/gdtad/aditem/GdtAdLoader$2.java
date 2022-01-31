package com.tencent.gdtad.aditem;

import aaie;
import aaif;
import java.lang.ref.WeakReference;

public class GdtAdLoader$2
  implements Runnable
{
  public GdtAdLoader$2(aaie paramaaie) {}
  
  public void run()
  {
    if ((aaie.a(this.this$0) != null) && (aaie.a(this.this$0).get() != null)) {
      ((aaif)aaie.a(this.this$0).get()).onResponse(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.2
 * JD-Core Version:    0.7.0.1
 */