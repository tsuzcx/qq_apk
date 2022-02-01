package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class SquareFeedListEntry
  extends Entity
{
  @unique
  public String feedId;
  public int type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.SquareFeedListEntry
 * JD-Core Version:    0.7.0.1
 */