package com.tencent.mobileqq.apollo.model;

import com.tencent.mobileqq.persistence.Entity;
import java.io.Serializable;

public class ApolloRelationTag
  extends Entity
  implements Serializable
{
  public String action;
  public String tag2D;
  public String tag3D;
  public int type;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("type:");
    localStringBuilder.append(this.type);
    localStringBuilder.append(" action:");
    localStringBuilder.append(this.action);
    localStringBuilder.append(" tag2D:");
    localStringBuilder.append(this.tag2D);
    localStringBuilder.append(" tag3D:");
    localStringBuilder.append(this.tag3D);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.model.ApolloRelationTag
 * JD-Core Version:    0.7.0.1
 */