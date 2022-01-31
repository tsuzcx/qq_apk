import dov.com.tencent.biz.qqstory.takevideo.doodle.model.DoodleEmojiManager;
import java.io.File;
import java.io.FilenameFilter;

public class anxm
  implements FilenameFilter
{
  public anxm(DoodleEmojiManager paramDoodleEmojiManager) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp")) || (paramString.endsWith(".apng"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     anxm
 * JD-Core Version:    0.7.0.1
 */