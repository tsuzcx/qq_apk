package com.tencent.biz.pubaccount.util;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.DataLineHandler;
import com.tencent.mobileqq.app.DataLineObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.fileassistant.forward.QFileAssistantForwardManager;
import com.tencent.mobileqq.filemanager.fileassistant.util.QFileAssistantUtils;

public class ShareToComputerHelper
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private DataLineObserver jdField_a_of_type_ComTencentMobileqqAppDataLineObserver;
  private String jdField_a_of_type_JavaLangString;
  
  public ShareToComputerHelper(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver = new ShareToComputerHelper.1(this);
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
  }
  
  public long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return 0L;
    }
    long l;
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      if (QFileAssistantUtils.a((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface))
      {
        new QFileAssistantForwardManager((QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface).a(paramString);
        l = 1L;
      }
    }
    for (;;)
    {
      return l;
      DataLineHandler localDataLineHandler = (DataLineHandler)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getBusinessHandler(BusinessHandlerFactory.DATALINE_HANDLER);
      if (localDataLineHandler != null)
      {
        this.jdField_a_of_type_JavaLangString = paramString;
        l = localDataLineHandler.a(paramString, 0).longValue();
      }
      else
      {
        l = 0L;
      }
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppDataLineObserver);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.ShareToComputerHelper
 * JD-Core Version:    0.7.0.1
 */