package com.tencent.mobileqq.ar.model;

import com.tencent.mobileqq.ar.aidl.ArCloudConfigInfo;
import com.tencent.mobileqq.ar.arengine.AREngineCallback;

class QQARSession$26
  implements Runnable
{
  QQARSession$26(QQARSession paramQQARSession, ArCloudConfigInfo paramArCloudConfigInfo, int paramInt1, int paramInt2, Object paramObject) {}
  
  public void run()
  {
    ArCloudConfigInfo localArCloudConfigInfo = this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo;
    if ((localArCloudConfigInfo != null) && (localArCloudConfigInfo.a()))
    {
      int i = this.jdField_a_of_type_Int;
      if ((i != 100) && (i != 101)) {
        QQARSession.a(this.this$0).a(null, this.jdField_a_of_type_ComTencentMobileqqArAidlArCloudConfigInfo, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_JavaLangObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.model.QQARSession.26
 * JD-Core Version:    0.7.0.1
 */