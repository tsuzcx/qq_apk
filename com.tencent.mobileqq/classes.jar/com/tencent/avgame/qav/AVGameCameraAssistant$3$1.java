package com.tencent.avgame.qav;

import com.tencent.avgame.business.observer.IPCEventObserver;
import com.tencent.qphone.base.util.QLog;

class AVGameCameraAssistant$3$1
  extends IPCEventObserver
{
  AVGameCameraAssistant$3$1(AVGameCameraAssistant.3 param3) {}
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameCameraAssistant", 2, "notifyEvent, id[" + paramInt + "], result[" + paramBoolean + "]");
    }
    if ((paramInt == 1) && (paramBoolean))
    {
      if (AVGameCameraAssistant.a(this.a.this$0) != null) {
        AVGameCameraAssistant.a(this.a.this$0).g();
      }
      AVGameCameraAssistant.a(this.a.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant.3.1
 * JD-Core Version:    0.7.0.1
 */