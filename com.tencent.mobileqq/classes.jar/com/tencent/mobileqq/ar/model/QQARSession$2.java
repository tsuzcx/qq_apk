package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.qphone.base.util.QLog;

class QQARSession$2
  implements Runnable
{
  QQARSession$2(QQARSession paramQQARSession, long paramLong, ArCloudConfigInfo paramArCloudConfigInfo) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ARTransferDoorLogicManager startModelRender in AREngine.");
    localStringBuilder.append(this.this$0.a);
    localStringBuilder.append(";");
    localStringBuilder.append(QQARSession.a(this.this$0));
    QLog.d("AREngine_QQARSession", 1, localStringBuilder.toString());
    if ((this.this$0.a == 2) && (QQARSession.a(this.this$0)) && (!this.this$0.e()))
    {
      QQARSession.a(this.this$0, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, -1, 0.0F, 0.0F, 0.0F);
      QLog.d("AREngine_QQARSession", 1, "startModelRender. recogType for external ");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.2
 * JD-Core Version:    0.7.0.1
 */