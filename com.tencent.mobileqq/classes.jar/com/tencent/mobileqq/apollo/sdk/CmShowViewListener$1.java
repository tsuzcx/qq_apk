package com.tencent.mobileqq.apollo.sdk;

import akxj;
import akxn;
import akyc;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class CmShowViewListener$1
  implements Runnable
{
  public CmShowViewListener$1(akyc paramakyc, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (akyc.a(this.this$0).get() != null) {
      ((akxn)akyc.a(this.this$0).get()).a(akyc.a(this.this$0));
    }
    QLog.d("CmShow_ApolloDrawerInfoViewListener", 1, new Object[] { "onSurfaceReady w:", Integer.valueOf(this.a), " h:", Integer.valueOf(this.b) });
    if (akyc.a(this.this$0) != null) {
      akyc.a(this.this$0).a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowViewListener.1
 * JD-Core Version:    0.7.0.1
 */