import java.io.File;
import java.io.FileFilter;

class bkgk
  implements FileFilter
{
  bkgk(bkgj parambkgj) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp")) || (paramFile.endsWith(".apng")) || (paramFile.endsWith(".gif"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkgk
 * JD-Core Version:    0.7.0.1
 */