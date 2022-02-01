package com.tencent.biz.qqstory.takevideo.slideshow.core;

import java.io.File;
import java.io.FilenameFilter;

final class SlideShowProcessor$1
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return paramString.endsWith(".mp4");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.slideshow.core.SlideShowProcessor.1
 * JD-Core Version:    0.7.0.1
 */