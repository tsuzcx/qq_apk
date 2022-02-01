import java.io.File;
import java.io.FileFilter;

class bmzg
  implements FileFilter
{
  bmzg(bmzc parambmzc) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".ftf");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmzg
 * JD-Core Version:    0.7.0.1
 */