package com.tencent.mobileqq.apollo.api.model;

public class ApolloRoleInfo
{
  public float scale;
  public float xPos;
  public float yPos;
  
  public ApolloRoleInfo(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.scale = paramFloat1;
    this.xPos = paramFloat2;
    this.yPos = paramFloat3;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ApolloRoleInfo:").append("scale:").append(this.scale).append(",xPos:").append(this.xPos).append(",yPos:").append(this.yPos);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.api.model.ApolloRoleInfo
 * JD-Core Version:    0.7.0.1
 */