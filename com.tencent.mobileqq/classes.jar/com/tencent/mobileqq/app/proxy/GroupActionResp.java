package com.tencent.mobileqq.app.proxy;

import friendlist.AddGroupResp;
import friendlist.DelGroupResp;
import friendlist.ReSortGroupResp;
import friendlist.RenameGroupResp;

public class GroupActionResp
{
  public int a;
  public AddGroupResp a;
  public DelGroupResp a;
  public ReSortGroupResp a;
  public RenameGroupResp a;
  public String a;
  public int b;
  
  public GroupActionResp(int paramInt, String paramString, AddGroupResp paramAddGroupResp)
  {
    this.jdField_a_of_type_Int = 1;
    this.b = paramInt;
    this.jdField_a_of_type_FriendlistAddGroupResp = paramAddGroupResp;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public GroupActionResp(int paramInt, String paramString, DelGroupResp paramDelGroupResp)
  {
    this.jdField_a_of_type_Int = 3;
    this.b = paramInt;
    this.jdField_a_of_type_FriendlistDelGroupResp = paramDelGroupResp;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public GroupActionResp(int paramInt, String paramString, ReSortGroupResp paramReSortGroupResp)
  {
    this.jdField_a_of_type_Int = 4;
    this.b = paramInt;
    this.jdField_a_of_type_FriendlistReSortGroupResp = paramReSortGroupResp;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public GroupActionResp(int paramInt, String paramString, RenameGroupResp paramRenameGroupResp)
  {
    this.jdField_a_of_type_Int = 2;
    this.b = paramInt;
    this.jdField_a_of_type_FriendlistRenameGroupResp = paramRenameGroupResp;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.app.proxy.GroupActionResp
 * JD-Core Version:    0.7.0.1
 */