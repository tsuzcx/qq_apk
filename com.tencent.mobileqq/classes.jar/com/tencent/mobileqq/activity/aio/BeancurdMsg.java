package com.tencent.mobileqq.activity.aio;

import awge;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="busiid,frienduin")
public class BeancurdMsg
  extends awge
{
  public String buffer;
  public int busiid;
  public String frienduin;
  public boolean isNeedDelHistory;
  public boolean ispush;
  public long originTime;
  public long startTime;
  public long token;
  public long validTime;
  
  public String toString()
  {
    return String.format(" busiid:%d,frienduin:%s,ipush:%b,isNeedDelHistory:%b,buffer:%s,startTime:%d,validTime:%d", new Object[] { Integer.valueOf(this.busiid), this.frienduin, Boolean.valueOf(this.ispush), Boolean.valueOf(this.isNeedDelHistory), this.buffer, Long.valueOf(this.startTime), Long.valueOf(this.validTime) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.BeancurdMsg
 * JD-Core Version:    0.7.0.1
 */