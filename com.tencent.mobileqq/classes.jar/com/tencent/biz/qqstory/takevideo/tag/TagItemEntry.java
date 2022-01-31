package com.tencent.biz.qqstory.takevideo.tag;

import awge;
import ulj;

public class TagItemEntry
  extends awge
  implements ulj
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
      this.id = ((TagItemEntry)paramObject).id;
      this.name = ((TagItemEntry)paramObject).name;
      this.desc = ((TagItemEntry)paramObject).desc;
      this.type = ((TagItemEntry)paramObject).type;
      this.joinCount = ((TagItemEntry)paramObject).joinCount;
      this.wording = ((TagItemEntry)paramObject).wording;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.tag.TagItemEntry
 * JD-Core Version:    0.7.0.1
 */