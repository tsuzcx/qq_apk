package com.tencent.mobileqq.apollo.model;

import java.util.Arrays;

public class CheckApolloInfoResult
{
  public int apolloFeatureFlag;
  public int[] dressIds;
  public boolean needStatic;
  public int roleId;
  public int[] threeDressIds;
  public int threeRoleId;
  public int traceFeatureId;
  public int userStatus;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("userStatus:");
    localStringBuilder.append(this.userStatus);
    localStringBuilder.append(",roleId:");
    localStringBuilder.append(this.roleId);
    localStringBuilder.append(",dressIds:");
    localStringBuilder.append(Arrays.toString(this.dressIds));
    localStringBuilder.append(",threeRoleId:");
    localStringBuilder.append(this.threeRoleId);
    localStringBuilder.append(",threeDressIds:");
    localStringBuilder.append(Arrays.toString(this.threeDressIds));
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.CheckApolloInfoResult
 * JD-Core Version:    0.7.0.1
 */