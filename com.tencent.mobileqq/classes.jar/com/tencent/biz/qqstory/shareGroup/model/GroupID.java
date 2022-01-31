package com.tencent.biz.qqstory.shareGroup.model;

public class GroupID
{
  public String a;
  public String b;
  
  public GroupID(String paramString1, String paramString2)
  {
    this.a = paramString1;
    this.b = paramString2;
  }
  
  public String toString()
  {
    return "GroupID{groupUin='" + this.a + '\'' + ", groupUnionID='" + this.b + '\'' + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.shareGroup.model.GroupID
 * JD-Core Version:    0.7.0.1
 */