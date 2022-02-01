package com.tencent.imsdk.group;

import java.util.List;

public class GroupSearchParam
{
  private List<String> keywordList;
  private List<Integer> searchFieldList;
  
  public List<String> getKeywordList()
  {
    return this.keywordList;
  }
  
  public List<Integer> getSearchFieldList()
  {
    return this.searchFieldList;
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
 * Qualified Name:     com.tencent.imsdk.group.GroupSearchParam
 * JD-Core Version:    0.7.0.1
 */