package com.tencent.biz.qqstory.model;

import com.tencent.image.URLDrawable;

public class TrimmableManager$URLDrawableTrimmer
  implements ITrimmable
{
  public void a(int paramInt)
  {
    if (paramInt != 0)
    {
      if ((paramInt != 1) && (paramInt != 2)) {
        return;
      }
      URLDrawable.clearMemoryCache();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TrimmableManager.URLDrawableTrimmer
 * JD-Core Version:    0.7.0.1
 */