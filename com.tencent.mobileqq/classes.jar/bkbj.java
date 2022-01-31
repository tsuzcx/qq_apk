import java.io.File;
import java.io.FilenameFilter;

class bkbj
  implements FilenameFilter
{
  bkbj(bkbh parambkbh) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp")) || (paramString.endsWith(".apng"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkbj
 * JD-Core Version:    0.7.0.1
 */