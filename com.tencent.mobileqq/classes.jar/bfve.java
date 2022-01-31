import java.io.File;
import java.io.FileFilter;

class bfve
  implements FileFilter
{
  bfve(bfva parambfva) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".ftf");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bfve
 * JD-Core Version:    0.7.0.1
 */