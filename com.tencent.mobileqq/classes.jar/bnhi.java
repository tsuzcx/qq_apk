import java.io.File;
import java.io.FileFilter;

class bnhi
  implements FileFilter
{
  bnhi(bnhh parambnhh) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnhi
 * JD-Core Version:    0.7.0.1
 */