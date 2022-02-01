package com.tencent.ad.common;

import android.os.Bundle;
import com.tencent.gdtad.log.GdtLog;
import mqq.observer.BusinessObserver;

public class SSOLoadBusinessObserver
  implements BusinessObserver
{
  public SSOLoadBusinessObserver.SSOLoadListener a;
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onReceive i ");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" success ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" bundle ");
    ((StringBuilder)localObject).append(paramBundle);
    GdtLog.b("GdtSSOLoadAD", ((StringBuilder)localObject).toString());
    if (paramInt != 1) {
      return;
    }
    if (paramBoolean)
    {
      localObject = this.a;
      if (localObject != null) {
        ((SSOLoadBusinessObserver.SSOLoadListener)localObject).a(paramBundle);
      }
    }
    else
    {
      paramBundle = this.a;
      if (paramBundle != null) {
        paramBundle.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.common.SSOLoadBusinessObserver
 * JD-Core Version:    0.7.0.1
 */