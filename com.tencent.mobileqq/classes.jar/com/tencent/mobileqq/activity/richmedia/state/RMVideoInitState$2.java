package com.tencent.mobileqq.activity.richmedia.state;

import ahky;
import ajjy;
import awii;
import com.tencent.qphone.base.util.QLog;

public class RMVideoInitState$2
  implements Runnable
{
  public RMVideoInitState$2(ahky paramahky) {}
  
  public void run()
  {
    boolean bool = awii.a(awii.y);
    if (bool)
    {
      RMVideoStateMgr.a().a(1102, ajjy.a(2131647662), true);
      return;
    }
    try
    {
      if ((!this.this$0.d) && (this.this$0.f)) {
        RMVideoStateMgr.a().a(1102, ajjy.a(2131647668) + 1102, true);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.state.RMVideoInitState.2
 * JD-Core Version:    0.7.0.1
 */