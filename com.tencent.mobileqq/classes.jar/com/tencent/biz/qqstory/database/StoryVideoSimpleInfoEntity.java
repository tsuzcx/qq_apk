package com.tencent.biz.qqstory.database;

import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class StoryVideoSimpleInfoEntity
  extends Entity
{
  public byte[] data;
  @unique
  public String unionId;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.StoryVideoSimpleInfoEntity
 * JD-Core Version:    0.7.0.1
 */