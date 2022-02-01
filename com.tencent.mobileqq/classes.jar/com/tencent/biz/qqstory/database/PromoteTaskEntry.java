package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="taskId")
public class PromoteTaskEntry
  extends Entity
{
  public long expireTime;
  public String feedId;
  public long limitPromoteCount;
  public long minimalVideoCount;
  public long promoteCount;
  public long taskId;
  public int type;
  public String unionId;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PromoteTaskEntry{taskId=");
    localStringBuilder.append(this.taskId);
    localStringBuilder.append(", type=");
    localStringBuilder.append(this.type);
    localStringBuilder.append(", unionId='");
    localStringBuilder.append(this.unionId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", feedId='");
    localStringBuilder.append(this.feedId);
    localStringBuilder.append('\'');
    localStringBuilder.append(", limitPromoteCount=");
    localStringBuilder.append(this.limitPromoteCount);
    localStringBuilder.append(", minimalVideoCount=");
    localStringBuilder.append(this.minimalVideoCount);
    localStringBuilder.append(", expireTime=");
    localStringBuilder.append(this.expireTime);
    localStringBuilder.append(", promoteCount=");
    localStringBuilder.append(this.promoteCount);
    localStringBuilder.append("} ");
    localStringBuilder.append(super.toString());
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.PromoteTaskEntry
 * JD-Core Version:    0.7.0.1
 */