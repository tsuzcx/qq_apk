package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class TopicInfoEntry
  extends Entity
{
  @unique
  public long topicId;
  public byte[] topicPbData;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.TopicInfoEntry
 * JD-Core Version:    0.7.0.1
 */