package com.tencent.mobileqq.apollo.tmg_opensdk;

import com.tencent.qphone.base.util.QLog;
import com.tencent.qqavopensdk.AVEngineEventHandler;

class AVEngineWalper$2
  implements AVManager.EnterRoomCallback
{
  AVEngineWalper$2(AVEngineWalper paramAVEngineWalper) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      QLog.e("AVEngineWalper", 1, "EnterRoom successfully!!!");
    }
    for (;;)
    {
      if (this.a.a != null) {
        this.a.a.b(paramInt, paramString);
      }
      return;
      QLog.e("AVEngineWalper", 1, "enter room failed. result=" + paramInt + ", errorInfo=" + paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper.2
 * JD-Core Version:    0.7.0.1
 */