package com.tencent.biz.qqstory.base.preload;

import com.tencent.biz.qqstory.base.Copyable;

public class FileCacheUtils$StringObj
  implements Copyable
{
  public String a;
  
  public void copy(Object paramObject)
  {
    if ((paramObject instanceof StringObj)) {
      this.a = ((StringObj)paramObject).a;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.biz.qqstory.base.preload.FileCacheUtils.StringObj
 * JD-Core Version:    0.7.0.1
 */