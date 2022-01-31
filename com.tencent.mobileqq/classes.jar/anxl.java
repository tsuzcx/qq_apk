import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import java.io.File;
import java.io.FileFilter;

public class anxl
  implements FileFilter
{
  public anxl(DoodleEmojiManager paramDoodleEmojiManager) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxl
 * JD-Core Version:    0.7.0.1
 */