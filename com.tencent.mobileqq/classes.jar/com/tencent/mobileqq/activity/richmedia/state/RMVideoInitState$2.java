package com.tencent.mobileqq.activity.richmedia.state;

import ahxo;
import ajya;
import axhq;
import com.tencent.qphone.base.util.QLog;

public class RMVideoInitState$2
  implements Runnable
{
  public RMVideoInitState$2(ahxo paramahxo) {}
  
  public void run()
  {
    boolean bool = axhq.a(axhq.y);
    if (bool)
    {
      RMVideoStateMgr.a().a(1102, ajya.a(2131713461), true);
      return;
    }
    try
    {
      if ((!this.this$0.d) && (this.this$0.f)) {
        RMVideoStateMgr.a().a(1102, ajya.a(2131713467) + 1102, true);
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