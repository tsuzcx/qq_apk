package com.tencent.biz.qqstory.takevideo.slideshow.core;

import java.io.File;
import java.util.Comparator;

final class SlideShowProcessor$2
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    long l = paramFile1.lastModified() - paramFile2.lastModified();
    if (l > 0L) {
      return -1;
    }
    if (l == 0L) {
      return 0;
    }
    return 1;
  }
  
  public boolean equals(Object paramObject)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.2
 * JD-Core Version:    0.7.0.1
 */