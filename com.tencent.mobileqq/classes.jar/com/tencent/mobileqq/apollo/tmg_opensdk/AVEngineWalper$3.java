package com.tencent.mobileqq.apollo.tmg_opensdk;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qqavopensdk.AVEngineEventHandler;
import com.tencent.qqavopensdk.PBuffer.SSOTunnelEvent.CsCmdCallback;
import mqq.os.MqqHandler;

class AVEngineWalper$3
  implements SSOTunnelEvent.CsCmdCallback
{
  AVEngineWalper$3(AVEngineWalper paramAVEngineWalper, String paramString, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVEngineWalper.a != null) {
      this.jdField_a_of_type_ComTencentMobileqqApolloTmg_opensdkAVEngineWalper.a.b(1, "ctrl Params download failed!!!!");
    }
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    ThreadManager.getUIHandler().post(new AVEngineWalper.3.1(this, paramArrayOfByte));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.tmg_opensdk.AVEngineWalper.3
 * JD-Core Version:    0.7.0.1
 */