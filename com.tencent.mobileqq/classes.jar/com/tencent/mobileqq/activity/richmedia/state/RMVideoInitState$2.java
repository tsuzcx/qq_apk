package com.tencent.mobileqq.activity.richmedia.state;

import com.tencent.aelight.camera.api.ICameraCompatible;
import com.tencent.aelight.camera.constants.CameraCompatibleConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class RMVideoInitState$2
  implements Runnable
{
  RMVideoInitState$2(RMVideoInitState paramRMVideoInitState) {}
  
  public void run()
  {
    boolean bool = ((ICameraCompatible)QRoute.api(ICameraCompatible.class)).isFoundProductFeature(CameraCompatibleConstants.y);
    if (bool)
    {
      RMVideoStateMgr.a().a(1102, HardCodeUtil.a(2131713376), true);
      return;
    }
    try
    {
      StringBuilder localStringBuilder;
      if ((!this.this$0.d) && (this.this$0.f))
      {
        localRMVideoStateMgr = RMVideoStateMgr.a();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(HardCodeUtil.a(2131713382));
        localStringBuilder.append(1102);
        localRMVideoStateMgr.a(1102, localStringBuilder.toString(), true);
      }
      RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("[ERR_CODE_INIT_TIMEOUT]初始化失败,code=1102 mIsReadAVCodec=");
        localStringBuilder.append(this.this$0.a);
        localStringBuilder.append(" mIsReadCamera=");
        localStringBuilder.append(this.this$0.b);
        localStringBuilder.append(" black=");
        localStringBuilder.append(bool);
        localStringBuilder.append(" rmStateMgr.mIsAudioReady=");
        localStringBuilder.append(localRMVideoStateMgr.d);
        localStringBuilder.append(" rmStateMgr.mVideoFileDir=");
        localStringBuilder.append(localRMVideoStateMgr.a);
        QLog.e("RMVideoInitState", 2, localStringBuilder.toString());
      }
      RMVideoStateMgr.b(null);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.2
 * JD-Core Version:    0.7.0.1
 */