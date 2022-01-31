import java.io.File;
import java.io.FileFilter;

class bhdo
  implements FileFilter
{
  bhdo(bhdk parambhdk) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".ftf");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhdo
 * JD-Core Version:    0.7.0.1
 */