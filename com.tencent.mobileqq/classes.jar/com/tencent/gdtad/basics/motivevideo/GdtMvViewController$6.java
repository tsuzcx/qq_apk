package com.tencent.gdtad.basics.motivevideo;

import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class GdtMvViewController$6
  implements SDKInitListener
{
  GdtMvViewController$6(GdtMvViewController paramGdtMvViewController) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSDKInited ");
    localStringBuilder.append(paramBoolean);
    QLog.i("VideoGdtGdtMvViewController", 1, localStringBuilder.toString());
    if (paramBoolean) {
      GdtMvViewController.a(this.a).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.6
 * JD-Core Version:    0.7.0.1
 */