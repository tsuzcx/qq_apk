package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class HotTopicEntry
  extends Entity
{
  public long databaseTime = System.currentTimeMillis();
  public boolean topicCanJoin;
  public int topicColor;
  public String topicCover;
  public String topicDesc;
  @unique
  public long topicId;
  public String topicLogo;
  public String topicName;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.HotTopicEntry
 * JD-Core Version:    0.7.0.1
 */