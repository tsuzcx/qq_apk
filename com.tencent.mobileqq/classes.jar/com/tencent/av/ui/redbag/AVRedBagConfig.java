package com.tencent.av.ui.redbag;

import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.service.IAVRedPacketCallback;

public class AVRedBagConfig
  extends SubHandleBase
{
  public IAVRedPacketCallback a;
  public AVRedBagConfig.Info a;
  
  AVRedBagConfig(AVRedBagMgr paramAVRedBagMgr)
  {
    super(paramAVRedBagMgr);
    this.jdField_a_of_type_ComTencentAvUiRedbagAVRedBagConfig$Info = null;
    this.jdField_a_of_type_ComTencentAvServiceIAVRedPacketCallback = new AVRedBagConfig.1(this);
  }
  
  void a()
  {
    AVRedBagConfig.2 local2 = new AVRedBagConfig.2(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(local2);
  }
  
  void a(AVRedBagConfig.Info paramInfo)
  {
    AVRedBagMgr localAVRedBagMgr = a();
    if (localAVRedBagMgr == null) {
      return;
    }
    localAVRedBagMgr.a(paramInfo);
  }
  
  void b(AVRedBagConfig.Info paramInfo)
  {
    AVRedBagMgr localAVRedBagMgr = a();
    if (localAVRedBagMgr == null) {
      return;
    }
    localAVRedBagMgr.b(paramInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.ui.redbag.AVRedBagConfig
 * JD-Core Version:    0.7.0.1
 */