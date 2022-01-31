package com.tencent.biz.pubaccount.serviceAccountFolder;

import ahpf;
import akpc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import java.util.ArrayList;
import java.util.Iterator;
import sbc;

public class ServiceAccountFolderManager$5
  implements Runnable
{
  public ServiceAccountFolderManager$5(sbc paramsbc, ArrayList paramArrayList, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ahpf.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, str, 1008);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().c(str, 1008);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(str, 1008, true);
    }
    this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.5
 * JD-Core Version:    0.7.0.1
 */