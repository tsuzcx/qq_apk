package com.tencent.avgame.qav;

import com.tencent.avgame.business.observer.IPCEventObserver;
import com.tencent.qphone.base.util.QLog;

class AVGameCameraAssistant$3$1
  extends IPCEventObserver
{
  AVGameCameraAssistant$3$1(AVGameCameraAssistant.3 param3) {}
  
  public void a(int paramInt, boolean paramBoolean, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("notifyEvent, id[");
      paramString.append(paramInt);
      paramString.append("], result[");
      paramString.append(paramBoolean);
      paramString.append("]");
      QLog.i("AVGameCameraAssistant", 2, paramString.toString());
    }
    if ((paramInt == 1) && (paramBoolean))
    {
      if (AVGameCameraAssistant.d(this.a.this$0) != null) {
        AVGameCameraAssistant.d(this.a.this$0).o();
      }
      AVGameCameraAssistant.i(this.a.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.avgame.qav.AVGameCameraAssistant.3.1
 * JD-Core Version:    0.7.0.1
 */