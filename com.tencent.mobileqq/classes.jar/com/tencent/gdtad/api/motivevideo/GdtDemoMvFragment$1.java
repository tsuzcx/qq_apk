package com.tencent.gdtad.api.motivevideo;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.tencent.qphone.base.util.QLog;

class GdtDemoMvFragment$1
  extends ResultReceiver
{
  GdtDemoMvFragment$1(GdtDemoMvFragment paramGdtDemoMvFragment, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    super.onReceiveResult(paramInt, paramBundle);
    QLog.i("GdtDemoMvFragment", 1, "onReceiveResult() called with: resultCode = [" + paramInt + "], resultData = [" + paramBundle + "]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.gdtad.api.motivevideo.GdtDemoMvFragment.1
 * JD-Core Version:    0.7.0.1
 */