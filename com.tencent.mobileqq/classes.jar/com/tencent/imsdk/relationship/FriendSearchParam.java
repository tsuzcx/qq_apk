package com.tencent.imsdk.relationship;

import java.util.List;

public class FriendSearchParam
{
  public static final int FIELD_ID_NICK_NAME = 2;
  public static final int FIELD_ID_REMARK = 4;
  public static final int FIELD_ID_USER_ID = 1;
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
 * Qualified Name:     com.tencent.imsdk.relationship.FriendSearchParam
 * JD-Core Version:    0.7.0.1
 */