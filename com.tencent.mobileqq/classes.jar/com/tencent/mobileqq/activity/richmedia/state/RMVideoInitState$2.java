package com.tencent.mobileqq.activity.richmedia.state;

import altg;
import anvx;
import bdaw;
import com.tencent.qphone.base.util.QLog;

public class RMVideoInitState$2
  implements Runnable
{
  public RMVideoInitState$2(altg paramaltg) {}
  
  public void run()
  {
    boolean bool = bdaw.a(bdaw.y);
    if (bool)
    {
      RMVideoStateMgr.a().a(1102, anvx.a(2131712912), true);
      return;
    }
    try
    {
      if ((!this.this$0.d) && (this.this$0.f)) {
        RMVideoStateMgr.a().a(1102, anvx.a(2131712918) + 1102, true);
      }
      RMVideoStateMgr localRMVideoStateMgr = RMVideoStateMgr.a();
      if (QLog.isColorLevel()) {
        QLog.e("RMVideoInitState", 2, "[ERR_CODE_INIT_TIMEOUT]初始化失败,code=1102 mIsReadAVCodec=" + this.this$0.a + " mIsReadCamera=" + this.this$0.b + " black=" + bool + " rmStateMgr.mIsAudioReady=" + localRMVideoStateMgr.d + " rmStateMgr.mVideoFileDir=" + localRMVideoStateMgr.a);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.2
 * JD-Core Version:    0.7.0.1
 */