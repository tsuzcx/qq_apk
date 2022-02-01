package com.tencent.mobileqq.app;

import android.content.Context;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.ar.codeEngine.MiniCodeController;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class MiniCodePeakHandler
  extends BusinessHandler
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private MiniCodeController jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController;
  
  protected MiniCodePeakHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  public void a(Context paramContext)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController = MiniCodeController.a();
        this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController.a(paramContext, hashCode(), "MiniCodePeakHandler");
      }
      return;
    }
  }
  
  protected Class<? extends BusinessObserver> observerClass()
  {
    return null;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (QLog.isColorLevel()) {
      QLog.i("MiniCodePeakHandler", 2, "onDestroy");
    }
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController.a(hashCode(), "MiniCodePeakHandler");
        this.jdField_a_of_type_ComTencentMobileqqArCodeEngineMiniCodeController = null;
      }
      return;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.app.MiniCodePeakHandler
 * JD-Core Version:    0.7.0.1
 */