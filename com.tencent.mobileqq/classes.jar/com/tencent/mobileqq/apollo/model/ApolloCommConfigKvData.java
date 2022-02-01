package com.tencent.mobileqq.apollo.model;

import com.tencent.mobileqq.persistence.Entity;

public class ApolloCommConfigKvData
  extends Entity
{
  public String key;
  public String value;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ApolloCommConfigKvData{");
    localStringBuffer.append(", key=");
    localStringBuffer.append(this.key);
    localStringBuffer.append(", value=");
    localStringBuffer.append(this.value);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloCommConfigKvData
 * JD-Core Version:    0.7.0.1
 */