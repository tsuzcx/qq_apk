package com.tencent.gdtad.basics.motivevideo;

import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;

class GdtMvViewController$7
  implements SDKInitListener
{
  GdtMvViewController$7(GdtMvViewController paramGdtMvViewController) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onSDKInited ");
    localStringBuilder.append(paramBoolean);
    QLog.i("VideoGdtGdtMvViewController", 1, localStringBuilder.toString());
    if (paramBoolean) {
      GdtMvViewController.h(this.a).sendEmptyMessage(3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.gdtad.basics.motivevideo.GdtMvViewController.7
 * JD-Core Version:    0.7.0.1
 */