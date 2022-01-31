import java.io.File;
import java.io.FileFilter;

class bjjw
  implements FileFilter
{
  bjjw(bjjs parambjjs) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".ftf");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjjw
 * JD-Core Version:    0.7.0.1
 */