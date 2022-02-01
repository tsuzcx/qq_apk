package com.tencent.imsdk.v2;

import com.tencent.imsdk.group.GroupMemberOperationResult;

public class V2TIMGroupMemberOperationResult
{
  public static final int OPERATION_RESULT_FAIL = 0;
  public static final int OPERATION_RESULT_INVALID = 2;
  public static final int OPERATION_RESULT_PENDING = 3;
  public static final int OPERATION_RESULT_SUCC = 1;
  GroupMemberOperationResult groupMemberOperationResult = new GroupMemberOperationResult();
  
  public String getMemberID()
  {
    return this.groupMemberOperationResult.getUserID();
  }
  
  public int getResult()
  {
    int i = this.groupMemberOperationResult.getStatus();
    if (i == GroupMemberOperationResult.OPERATION_RESULT_FAIL) {
      return 0;
    }
    if (i == GroupMemberOperationResult.OPERATION_RESULT_INVALID) {
      return 2;
    }
    if (i == GroupMemberOperationResult.OPERATION_RESULT_PENDING) {
      return 3;
    }
    if (i == GroupMemberOperationResult.OPERATION_RESULT_SUCCESS) {
      return 1;
    }
    return 0;
  }
  
  void setGroupMemberOperationResult(GroupMemberOperationResult paramGroupMemberOperationResult)
  {
    this.groupMemberOperationResult = paramGroupMemberOperationResult;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.imsdk.v2.V2TIMGroupMemberOperationResult
 * JD-Core Version:    0.7.0.1
 */