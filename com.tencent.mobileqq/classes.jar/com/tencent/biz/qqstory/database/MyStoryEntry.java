package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class MyStoryEntry
  extends Entity
{
  public String createTime;
  public long duration;
  public int state;
  @unique
  public int uid;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.MyStoryEntry
 * JD-Core Version:    0.7.0.1
 */