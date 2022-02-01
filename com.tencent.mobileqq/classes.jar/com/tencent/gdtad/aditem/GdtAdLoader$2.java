package com.tencent.gdtad.aditem;

import acaf;
import acag;
import java.lang.ref.WeakReference;

public class GdtAdLoader$2
  implements Runnable
{
  public GdtAdLoader$2(acaf paramacaf) {}
  
  public void run()
  {
    if ((acaf.a(this.this$0) != null) && (acaf.a(this.this$0).get() != null)) {
      ((acag)acaf.a(this.this$0).get()).onResponse(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtAdLoader.2
 * JD-Core Version:    0.7.0.1
 */