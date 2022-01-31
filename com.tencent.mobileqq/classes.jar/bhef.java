import java.io.File;
import java.io.FileFilter;

class bhef
  implements FileFilter
{
  bhef(bheb parambheb) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".ftf");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhef
 * JD-Core Version:    0.7.0.1
 */