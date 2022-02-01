package com.tencent.imsdk.group;

import java.util.List;

public class GroupMemberSearchParam
{
  private List<String> groupIDList;
  private List<String> keywordList;
  private List<Integer> searchFieldList;
  
  public List<String> getGroupIDList()
  {
    return this.groupIDList;
  }
  
  public List<String> getKeywordList()
  {
    return this.keywordList;
  }
  
  public void setGroupIDList(List<String> paramList)
  {
    this.groupIDList = paramList;
  }
  
  public void setKeywordList(List<String> paramList)
  {
    this.keywordList = paramList;
  }
  
  public void setSearchFieldList(List<Integer> paramList)
  {
    this.searchFieldList = paramList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupMemberSearchParam
 * JD-Core Version:    0.7.0.1
 */