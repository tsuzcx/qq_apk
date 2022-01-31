package com.tencent.mobileqq.apollo.utils;

import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import mqq.manager.Manager;

public class ApolloRecentManager
  implements Manager
{
  public QQAppInterface a;
  public List a;
  public List b = Collections.synchronizedList(new ArrayList());
  
  public ApolloRecentManager(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a(paramQQAppInterface);
  }
  
  private void a(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_JavaUtilList = ApolloDaoManager.a(paramQQAppInterface, "recent_c2c");
    this.b = ApolloDaoManager.a(paramQQAppInterface, "recent_troop");
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    }
    if (this.b == null) {
      this.b = Collections.synchronizedList(new ArrayList());
    }
    int i;
    if (this.jdField_a_of_type_JavaUtilList.size() > 8)
    {
      i = this.jdField_a_of_type_JavaUtilList.size();
      this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(i - 8, this.jdField_a_of_type_JavaUtilList.size());
    }
    if (this.b.size() > 8)
    {
      i = this.b.size();
      this.b = this.b.subList(i - 8, this.b.size());
    }
  }
  
  public void onDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloRecentManager
 * JD-Core Version:    0.7.0.1
 */