package com.tencent.mobileqq.activity.richmedia.view;

import java.util.ArrayList;

class LbsFilterStatusManager$LbsRequestStatus
{
  int jdField_a_of_type_Int = 3;
  long jdField_a_of_type_Long = 0L;
  LbsRequestStatus jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsRequestStatus = null;
  ArrayList<String> jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
  boolean jdField_a_of_type_Boolean = false;
  
  String a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i != 1)
    {
      if (i != 2) {
        return "LBS_REQ_OK";
      }
      return "LBS_REQ_PERM_OK";
    }
    return "LBS_REQ_PENDING";
  }
  
  void a()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_Int = 3;
  }
  
  boolean a(String paramString)
  {
    LbsFilterStatusManager.a("startLocation", String.format("filterId=%s , IdList=%s", new Object[] { paramString, this.jdField_a_of_type_JavaUtilArrayList.toString() }), null);
    return this.jdField_a_of_type_JavaUtilArrayList.contains(paramString);
  }
  
  void b()
  {
    LbsRequestStatus localLbsRequestStatus = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsRequestStatus;
    localLbsRequestStatus.jdField_a_of_type_Boolean = this.jdField_a_of_type_Boolean;
    localLbsRequestStatus.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsRequestStatus.jdField_a_of_type_JavaUtilArrayList.addAll(this.jdField_a_of_type_JavaUtilArrayList);
    localLbsRequestStatus = this.jdField_a_of_type_ComTencentMobileqqActivityRichmediaViewLbsFilterStatusManager$LbsRequestStatus;
    localLbsRequestStatus.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localLbsRequestStatus.jdField_a_of_type_Long = this.jdField_a_of_type_Long;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.activity.richmedia.view.LbsFilterStatusManager.LbsRequestStatus
 * JD-Core Version:    0.7.0.1
 */