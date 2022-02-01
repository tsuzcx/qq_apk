package com.tencent.mobileqq.apollo.model;

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
    localStringBuilder.append("actionId:");
    localStringBuilder.append(this.acitonId);
    localStringBuilder.append(" packageId:");
    localStringBuilder.append(this.packageId);
    localStringBuilder.append(" text:");
    localStringBuilder.append(this.text);
    localStringBuilder.append(" textType:");
    localStringBuilder.append(this.textType);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloActionPackageData
 * JD-Core Version:    0.7.0.1
 */