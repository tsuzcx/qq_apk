package com.tencent.mobileqq.apollo.sdk;

import com.tencent.mobileqq.apollo.api.sdk.IRenderViewListener;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class CmShowViewListener$1
  implements Runnable
{
  CmShowViewListener$1(CmShowViewListener paramCmShowViewListener, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    if (CmShowViewListener.a(this.this$0).get() != null) {
      ((CmShowScriptManager)CmShowViewListener.a(this.this$0).get()).a(CmShowViewListener.a(this.this$0));
    }
    QLog.d("CmShow_ApolloDrawerInfoViewListener", 1, new Object[] { "onSurfaceReady w:", Integer.valueOf(this.a), " h:", Integer.valueOf(this.b) });
    if (CmShowViewListener.a(this.this$0) != null) {
      CmShowViewListener.a(this.this$0).a(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.sdk.CmShowViewListener.1
 * JD-Core Version:    0.7.0.1
 */