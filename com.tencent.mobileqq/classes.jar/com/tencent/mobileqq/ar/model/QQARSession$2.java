package com.tencent.mobileqq.ar.model;

import aolr;
import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

public class QQARSession$2
  implements Runnable
{
  public QQARSession$2(aolr paramaolr, long paramLong, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    QLog.d("AREngine_QQARSession", 1, "ARTransferDoorLogicManager startModelRender in AREngine." + this.this$0.a + ";" + aolr.a(this.this$0));
    if ((this.this$0.a == 2) && (aolr.a(this.this$0)) && (!this.this$0.e()))
    {
      aolr.a(this.this$0, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, -1, 0.0F, 0.0F, 0.0F);
      QLog.d("AREngine_QQARSession", 1, "startModelRender. recogType for external ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.2
 * JD-Core Version:    0.7.0.1
 */