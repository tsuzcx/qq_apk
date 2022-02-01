package com.tencent.aelight.camera.aioeditor.takevideo.doodle.model;

import java.io.File;
import java.io.FilenameFilter;

final class DoodleEmojiManager$6
  implements FilenameFilter
{
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp")) || (paramString.endsWith(".apng"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.6
 * JD-Core Version:    0.7.0.1
 */