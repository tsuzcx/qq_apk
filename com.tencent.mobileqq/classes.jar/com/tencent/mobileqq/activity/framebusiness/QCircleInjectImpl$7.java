package com.tencent.mobileqq.activity.framebusiness;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.biz.richframework.network.observer.VSDispatchObserver.onVSRspCallBack;
import com.tencent.biz.richframework.network.request.BaseRequest;
import com.tencent.mobileqq.activity.qcircle.QCircleThirdTabConfig;
import com.tencent.mobileqq.app.FrameFragment;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import qqcircle.QQCircleSwitch.GetCircleTabBucketRsp;

final class QCircleInjectImpl$7
  implements VSDispatchObserver.onVSRspCallBack<QQCircleSwitch.GetCircleTabBucketRsp>
{
  QCircleInjectImpl$7(SharedPreferences paramSharedPreferences, String paramString, long paramLong) {}
  
  public void a(BaseRequest paramBaseRequest, boolean paramBoolean, long paramLong, String paramString, QQCircleSwitch.GetCircleTabBucketRsp paramGetCircleTabBucketRsp)
  {
    if ((paramLong == 0L) && (paramBoolean) && (paramGetCircleTabBucketRsp != null))
    {
      QCircleThirdTabConfig.a(paramGetCircleTabBucketRsp.sws.get());
      this.a.edit().putString(this.b, String.valueOf(this.c)).commit();
      if (QCircleInjectImpl.i() != null) {
        QCircleInjectImpl.l((FrameFragment)QCircleInjectImpl.i().get());
      }
      QLog.i("QCBT-QCircleInjectImpl", 1, "BuildNum set success");
      return;
    }
    QLog.i("QCBT-QCircleInjectImpl", 1, "request filed not set build num");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.framebusiness.QCircleInjectImpl.7
 * JD-Core Version:    0.7.0.1
 */