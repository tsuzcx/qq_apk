package com.tencent.mobileqq.apollo.model;

import java.util.List;

public class ApolloSlaveInfo
{
  public int isCaptured;
  public List<Long> slaveList;
  public int slaveTotal;
  public long uin;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("uin,");
    localStringBuffer.append(this.uin);
    localStringBuffer.append(",slaveList:");
    localStringBuffer.append(this.slaveList);
    localStringBuffer.append(",slaveTotal:");
    localStringBuffer.append(this.slaveTotal);
    localStringBuffer.append(",isCaptured:");
    localStringBuffer.append(this.isCaptured);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloSlaveInfo
 * JD-Core Version:    0.7.0.1
 */