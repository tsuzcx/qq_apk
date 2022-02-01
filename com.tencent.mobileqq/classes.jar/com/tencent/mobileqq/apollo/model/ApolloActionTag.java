package com.tencent.mobileqq.apollo.model;

import com.tencent.mobileqq.persistence.Entity;

public class ApolloActionTag
  extends Entity
{
  public int actionId;
  public int packageId;
  public String tagName;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ApolloTagAction{");
    localStringBuffer.append(", tagName=");
    localStringBuffer.append(this.tagName);
    localStringBuffer.append(", packageId=");
    localStringBuffer.append(this.packageId);
    localStringBuffer.append(", actionId=");
    localStringBuffer.append(this.actionId);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloActionTag
 * JD-Core Version:    0.7.0.1
 */