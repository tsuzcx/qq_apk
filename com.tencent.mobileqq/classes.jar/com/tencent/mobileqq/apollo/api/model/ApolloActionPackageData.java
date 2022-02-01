package com.tencent.mobileqq.apollo.api.model;

import com.tencent.mobileqq.persistence.Entity;

public class ApolloActionPackageData
  extends Entity
{
  public int acitonId;
  public int packageId;
  public String text;
  public int textType;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("actionId:").append(this.acitonId).append(" packageId:").append(this.packageId).append(" text:").append(this.text).append(" textType:").append(this.textType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloActionPackageData
 * JD-Core Version:    0.7.0.1
 */