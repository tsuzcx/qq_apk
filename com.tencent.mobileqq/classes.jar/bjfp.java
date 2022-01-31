import java.io.File;
import java.io.FileFilter;

class bjfp
  implements FileFilter
{
  bjfp(bjfl parambjfl) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".ftf");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjfp
 * JD-Core Version:    0.7.0.1
 */