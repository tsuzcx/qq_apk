package com.tencent.av.wtogether;

import android.content.Intent;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.ConfigHandler;
import com.tencent.mobileqq.app.ConfigObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class WTogetherRealNameMainProcessHelper
{
  private ConfigObserver jdField_a_of_type_ComTencentMobileqqAppConfigObserver = null;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public WTogetherRealNameMainProcessHelper(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(boolean paramBoolean)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("tencent.video.q2v.avReceiveRealNameMsg");
    localIntent.putExtra("real_name_result", paramBoolean);
    localIntent.setPackage(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getPackageName());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(localIntent);
  }
  
  private boolean a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameMainProcessHelper", 2, "preCheckRealNameStatus");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogetherRealNameMainProcessHelper", 2, "preCheckRealNameStatus remove observer");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
    }
    return ((ConfigHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CONFIG_HANDLER)).c();
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.i("WTogetherRealNameMainProcessHelper", 2, "startMonitorRealNameResult");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("WTogetherRealNameMainProcessHelper", 2, "monitorRealNameResult remove observer");
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = null;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = new WTogetherRealNameMainProcessHelper.1(this);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
  }
  
  public boolean a(int paramInt)
  {
    boolean bool = false;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      bool = a();
    }
    a();
    return bool;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver);
      this.jdField_a_of_type_ComTencentMobileqqAppConfigObserver = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.av.wtogether.WTogetherRealNameMainProcessHelper
 * JD-Core Version:    0.7.0.1
 */