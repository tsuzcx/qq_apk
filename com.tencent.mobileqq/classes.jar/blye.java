import java.io.File;
import java.io.FileFilter;

class blye
  implements FileFilter
{
  blye(blya paramblya) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".ftf");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blye
 * JD-Core Version:    0.7.0.1
 */