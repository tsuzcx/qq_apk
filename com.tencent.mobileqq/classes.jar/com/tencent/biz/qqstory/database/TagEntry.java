package com.tencent.biz.qqstory.database;

import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.mobileqq.persistence.Entity;

public class TagEntry
  extends Entity
  implements Copyable
{
  public String desc;
  public String feedId;
  public long id;
  public String name;
  public int type;
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof TagEntry))
    {
      paramObject = (TagEntry)paramObject;
      this.feedId = paramObject.feedId;
      this.id = paramObject.id;
      this.name = paramObject.name;
      this.desc = paramObject.desc;
      this.type = paramObject.type;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.TagEntry
 * JD-Core Version:    0.7.0.1
 */