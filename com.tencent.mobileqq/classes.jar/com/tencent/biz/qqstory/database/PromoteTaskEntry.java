package com.tencent.biz.qqstory.database;

import aukm;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="taskId")
public class PromoteTaskEntry
  extends aukm
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
    return "PromoteTaskEntry{taskId=" + this.taskId + ", type=" + this.type + ", unionId='" + this.unionId + '\'' + ", feedId='" + this.feedId + '\'' + ", limitPromoteCount=" + this.limitPromoteCount + ", minimalVideoCount=" + this.minimalVideoCount + ", expireTime=" + this.expireTime + ", promoteCount=" + this.promoteCount + "} " + super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.PromoteTaskEntry
 * JD-Core Version:    0.7.0.1
 */