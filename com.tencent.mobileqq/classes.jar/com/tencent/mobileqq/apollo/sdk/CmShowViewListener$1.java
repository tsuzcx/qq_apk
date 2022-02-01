package com.tencent.mobileqq.apollo.sdk;

import angy;
import anhc;
import anhr;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class CmShowViewListener$1
  implements Runnable
{
  public CmShowViewListener$1(anhr paramanhr, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (anhr.a(this.this$0).get() != null) {
      ((anhc)anhr.a(this.this$0).get()).a(anhr.a(this.this$0));
    }
    QLog.d("CmShow_ApolloDrawerInfoViewListener", 1, new Object[] { "onSurfaceReady w:", Integer.valueOf(this.a), " h:", Integer.valueOf(this.b) });
    if (anhr.a(this.this$0) != null) {
      anhr.a(this.this$0).a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowViewListener.1
 * JD-Core Version:    0.7.0.1
 */