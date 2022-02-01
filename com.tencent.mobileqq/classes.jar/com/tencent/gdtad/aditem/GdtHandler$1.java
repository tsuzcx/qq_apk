package com.tencent.gdtad.aditem;

import android.content.Context;
import bjfr;
import java.lang.ref.WeakReference;

final class GdtHandler$1
  implements Runnable
{
  GdtHandler$1(GdtHandler.Params paramParams) {}
  
  public void run()
  {
    if ((this.a != null) && (this.a.a != null) && (this.a.a.get() != null)) {
      bjfr.a((Context)this.a.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler.1
 * JD-Core Version:    0.7.0.1
 */