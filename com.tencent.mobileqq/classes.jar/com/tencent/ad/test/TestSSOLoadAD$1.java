package com.tencent.ad.test;

import android.os.Bundle;
import com.tencent.ad.common.SSOLoadBusinessObserver.SSOLoadListener;
import com.tencent.gdtad.log.GdtLog;
import com.tencent.mobileqq.widget.QQToast;

final class TestSSOLoadAD$1
  implements SSOLoadBusinessObserver.SSOLoadListener
{
  public void a()
  {
    QQToast.a(this.a, "onFailded SSoLoadBusinessObserver", 0).a();
  }
  
  public void a(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("sso_GdtLoadAd_rsp_json");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Observer onReceive ");
    localStringBuilder.append(paramBundle);
    GdtLog.b("GdtSSOLoadAD", localStringBuilder.toString());
    QQToast.a(this.a, "onSucess SSoLoadBusinessObserver", 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.ad.test.TestSSOLoadAD.1
 * JD-Core Version:    0.7.0.1
 */