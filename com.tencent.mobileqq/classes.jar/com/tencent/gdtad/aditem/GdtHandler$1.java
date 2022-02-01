package com.tencent.gdtad.aditem;

import android.content.Context;
import com.tencent.mobileqq.qqfloatingwindow.IQQFloatingWindowBroadcast;
import com.tencent.mobileqq.qroute.QRoute;
import java.lang.ref.WeakReference;

final class GdtHandler$1
  implements Runnable
{
  GdtHandler$1(GdtHandler.Params paramParams) {}
  
  public void run()
  {
    GdtHandler.Params localParams = this.a;
    if ((localParams != null) && (localParams.a != null) && (this.a.a.get() != null)) {
      ((IQQFloatingWindowBroadcast)QRoute.api(IQQFloatingWindowBroadcast.class)).sendWindowClosedBroadcast((Context)this.a.a.get());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.aditem.GdtHandler.1
 * JD-Core Version:    0.7.0.1
 */