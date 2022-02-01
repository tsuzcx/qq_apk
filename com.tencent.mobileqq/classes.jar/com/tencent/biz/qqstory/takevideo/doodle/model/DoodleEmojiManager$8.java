package com.tencent.biz.qqstory.takevideo.doodle.model;

import java.io.File;
import java.io.FilenameFilter;

final class DoodleEmojiManager$8
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager.8
 * JD-Core Version:    0.7.0.1
 */