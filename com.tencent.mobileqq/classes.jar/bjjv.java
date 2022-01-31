import java.io.File;
import java.io.FileFilter;

class bjjv
  implements FileFilter
{
  bjjv(bjjs parambjjs) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    boolean bool1 = paramFile.endsWith(".ftf");
    boolean bool2 = paramFile.endsWith(".ttf");
    return (bool1) || (bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjjv
 * JD-Core Version:    0.7.0.1
 */