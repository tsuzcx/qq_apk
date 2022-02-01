package com.tencent.mobileqq.ar.ARPromotionMgr;

import android.content.res.Resources;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.utils.QQAudioHelper;
import com.tencent.mobileqq.utils.SyncLoadTask;
import com.tencent.mobileqq.utils.configsp.ARPromotionConfigSP;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

class ReadConfigTask
  extends SyncLoadTask
{
  PromotionConfigInfo jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo;
  final String jdField_a_of_type_JavaLangString;
  WeakReference<AppInterface> jdField_a_of_type_JavaLangRefWeakReference;
  
  ReadConfigTask(String paramString1, String paramString2, AppInterface paramAppInterface)
  {
    super(paramString1);
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramAppInterface);
  }
  
  public void innerClean()
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = null;
  }
  
  public boolean runOnSubThread(Resources paramResources)
  {
    this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo = ARPromotionConfigSP.a(this.jdField_a_of_type_JavaLangString, null);
    paramResources = this.TAG;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ReadConfigTask,ConfigInfo[");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqArARPromotionMgrPromotionConfigInfo);
    localStringBuilder.append("]");
    QLog.w(paramResources, 1, localStringBuilder.toString());
    PromotionDevice.c();
    QQAudioHelper.a((AppInterface)this.jdField_a_of_type_JavaLangRefWeakReference.get());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARPromotionMgr.ReadConfigTask
 * JD-Core Version:    0.7.0.1
 */