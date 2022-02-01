package com.tencent.imsdk.group;

public class GroupMemberOperationResult
{
  public static int OPERATION_RESULT_FAIL = 1;
  public static int OPERATION_RESULT_INVALID = 3;
  public static int OPERATION_RESULT_PENDING = 4;
  public static int OPERATION_RESULT_SUCCESS = 2;
  private int status;
  private String userID;
  
  public int getStatus()
  {
    return this.status;
  }
  
  public String getUserID()
  {
    return this.userID;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.group.GroupMemberOperationResult
 * JD-Core Version:    0.7.0.1
 */