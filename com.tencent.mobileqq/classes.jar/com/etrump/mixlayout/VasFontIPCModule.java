package com.etrump.mixlayout;

import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.qipc.QIPCModule;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import java.util.concurrent.atomic.AtomicBoolean;
import qh;
import qi;

public class VasFontIPCModule
  extends QIPCModule
{
  private static VasFontIPCModule jdField_a_of_type_ComEtrumpMixlayoutVasFontIPCModule;
  public static String a;
  private int jdField_a_of_type_Int;
  public VasQuickUpdateManager.CallBacker a;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  
  static
  {
    jdField_a_of_type_JavaLangString = "action_download_hy_so";
  }
  
  private VasFontIPCModule(String paramString)
  {
    super(paramString);
    this.jdField_a_of_type_ComTencentMobileqqVasVasQuickUpdateManager$CallBacker = new qi(this);
  }
  
  public static VasFontIPCModule a()
  {
    try
    {
      if (jdField_a_of_type_ComEtrumpMixlayoutVasFontIPCModule == null) {
        jdField_a_of_type_ComEtrumpMixlayoutVasFontIPCModule = new VasFontIPCModule("VasFontIPCModule");
      }
      VasFontIPCModule localVasFontIPCModule = jdField_a_of_type_ComEtrumpMixlayoutVasFontIPCModule;
      return localVasFontIPCModule;
    }
    finally {}
  }
  
  public EIPCResult onCall(String paramString, Bundle paramBundle, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VasFont.VasFontIPCModule", 2, "onCall action = " + paramString);
    }
    if (jdField_a_of_type_JavaLangString.equals(paramString)) {
      if ((BaseApplicationImpl.getApplication() != null) && ((BaseApplicationImpl.getApplication().getRuntime() instanceof QQAppInterface))) {
        ThreadManager.executeOnSubThread(new qh(this, paramInt, (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()));
      }
    }
    for (;;)
    {
      return null;
      if (QLog.isColorLevel()) {
        QLog.d("VasFont.VasFontIPCModule", 2, "onCall action = " + paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.etrump.mixlayout.VasFontIPCModule
 * JD-Core Version:    0.7.0.1
 */