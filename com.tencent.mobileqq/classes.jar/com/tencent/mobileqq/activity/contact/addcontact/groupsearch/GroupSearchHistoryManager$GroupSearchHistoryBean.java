package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

class GroupSearchHistoryManager$GroupSearchHistoryBean
  implements Comparable<GroupSearchHistoryBean>
{
  private Long jdField_a_of_type_JavaLangLong;
  private String jdField_a_of_type_JavaLangString;
  
  GroupSearchHistoryManager$GroupSearchHistoryBean(GroupSearchHistoryManager paramGroupSearchHistoryManager, String paramString, Long paramLong)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_JavaLangLong = paramLong;
  }
  
  public int a(GroupSearchHistoryBean paramGroupSearchHistoryBean)
  {
    if (this.jdField_a_of_type_JavaLangLong.longValue() > paramGroupSearchHistoryBean.jdField_a_of_type_JavaLangLong.longValue()) {
      return -1;
    }
    return 1;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchHistoryManager.GroupSearchHistoryBean
 * JD-Core Version:    0.7.0.1
 */