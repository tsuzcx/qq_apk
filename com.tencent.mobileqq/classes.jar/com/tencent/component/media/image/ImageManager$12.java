package com.tencent.component.media.image;

import java.io.File;
import java.io.FilenameFilter;

final class ImageManager$12
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return !"imagelru.usetime".equals(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.component.media.image.ImageManager.12
 * JD-Core Version:    0.7.0.1
 */