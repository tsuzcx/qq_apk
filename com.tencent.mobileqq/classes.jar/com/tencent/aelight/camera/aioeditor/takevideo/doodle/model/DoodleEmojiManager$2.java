package com.tencent.aelight.camera.aioeditor.takevideo.doodle.model;

import java.io.File;
import java.io.FilenameFilter;

class DoodleEmojiManager$2
  implements FilenameFilter
{
  DoodleEmojiManager$2(DoodleEmojiManager paramDoodleEmojiManager) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp")) || (paramString.endsWith(".apng"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.2
 * JD-Core Version:    0.7.0.1
 */