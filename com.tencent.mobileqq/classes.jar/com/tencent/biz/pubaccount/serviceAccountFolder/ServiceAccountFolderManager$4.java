package com.tencent.biz.pubaccount.serviceAccountFolder;

import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ServiceAccountFolderManager$4
  implements Runnable
{
  ServiceAccountFolderManager$4(ServiceAccountFolderManager paramServiceAccountFolderManager, QQAppInterface paramQQAppInterface, long paramLong) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(ServiceAccountFolderManager.a(this.this$0));
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      ServiceAccountFolderFeed localServiceAccountFolderFeed = (ServiceAccountFolderFeed)localIterator.next();
      this.this$0.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localServiceAccountFolderFeed, false);
    }
    localArrayList.clear();
    this.this$0.h(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.this$0.j(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.this$0.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.pubaccount.serviceAccountFolder.ServiceAccountFolderManager.4
 * JD-Core Version:    0.7.0.1
 */