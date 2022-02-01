package com.tencent.gdtad.views.video;

import android.content.Context;
import android.os.Handler;
import com.tencent.mobileqq.videoplatform.SDKInitListener;
import com.tencent.qphone.base.util.QLog;

class GdtVideoCommonView$3
  implements SDKInitListener
{
  GdtVideoCommonView$3(GdtVideoCommonView paramGdtVideoCommonView, Context paramContext) {}
  
  public void onSDKInited(boolean paramBoolean)
  {
    QLog.i("VideoGdtGdtVideoCommonView", 1, "onSDKInited " + paramBoolean);
    if (paramBoolean) {
      GdtVideoCommonView.a(this.jdField_a_of_type_ComTencentGdtadViewsVideoGdtVideoCommonView).post(new GdtVideoCommonView.3.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.gdtad.views.video.GdtVideoCommonView.3
 * JD-Core Version:    0.7.0.1
 */