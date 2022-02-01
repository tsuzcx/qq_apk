package com.tencent.mobileqq.activity.contact.addcontact.groupsearch;

class GroupSearchHistoryManager$GroupSearchHistoryBean
  implements Comparable<GroupSearchHistoryBean>
{
  private String b;
  private Long c;
  
  GroupSearchHistoryManager$GroupSearchHistoryBean(GroupSearchHistoryManager paramGroupSearchHistoryManager, String paramString, Long paramLong)
  {
    this.b = paramString;
    this.c = paramLong;
  }
  
  public int a(GroupSearchHistoryBean paramGroupSearchHistoryBean)
  {
    if (this.c.longValue() > paramGroupSearchHistoryBean.c.longValue()) {
      return -1;
    }
    return 1;
  }
  
  public String a()
  {
    return this.b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.addcontact.groupsearch.GroupSearchHistoryManager.GroupSearchHistoryBean
 * JD-Core Version:    0.7.0.1
 */