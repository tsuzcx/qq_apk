package com.tencent.biz.qqstory.takevideo.tag;

import com.tencent.biz.qqstory.base.Copyable;
import com.tencent.mobileqq.persistence.Entity;

public class TagItemEntry
  extends Entity
  implements Copyable
{
  public String desc;
  public long id;
  public int joinCount;
  public String name;
  public int type;
  public String wording;
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof TagItemEntry))
    {
      paramObject = (TagItemEntry)paramObject;
      this.id = paramObject.id;
      this.name = paramObject.name;
      this.desc = paramObject.desc;
      this.type = paramObject.type;
      this.joinCount = paramObject.joinCount;
      this.wording = paramObject.wording;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tag.TagItemEntry
 * JD-Core Version:    0.7.0.1
 */