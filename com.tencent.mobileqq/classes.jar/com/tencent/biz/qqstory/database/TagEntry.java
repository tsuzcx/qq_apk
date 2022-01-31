package com.tencent.biz.qqstory.database;

import auko;
import ssi;

public class TagEntry
  extends auko
  implements ssi
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
      this.feedId = ((TagEntry)paramObject).feedId;
      this.id = ((TagEntry)paramObject).id;
      this.name = ((TagEntry)paramObject).name;
      this.desc = ((TagEntry)paramObject).desc;
      this.type = ((TagEntry)paramObject).type;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.biz.qqstory.database.TagEntry
 * JD-Core Version:    0.7.0.1
 */