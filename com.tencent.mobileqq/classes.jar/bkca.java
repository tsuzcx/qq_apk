import java.io.File;
import java.io.FilenameFilter;

class bkca
  implements FilenameFilter
{
  bkca(bkby parambkby) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    return (paramString.endsWith(".png")) || (paramString.endsWith(".jpg")) || (paramString.endsWith(".bmp")) || (paramString.endsWith(".apng"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkca
 * JD-Core Version:    0.7.0.1
 */