package com.tencent.aelight.camera.aioeditor.takevideo.doodle.model;

import java.io.File;
import java.io.FileFilter;

class DoodleEmojiManager$1
  implements FileFilter
{
  DoodleEmojiManager$1(DoodleEmojiManager paramDoodleEmojiManager) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes19.jar
 * Qualified Name:     com.tencent.aelight.camera.aioeditor.takevideo.doodle.model.DoodleEmojiManager.1
 * JD-Core Version:    0.7.0.1
 */