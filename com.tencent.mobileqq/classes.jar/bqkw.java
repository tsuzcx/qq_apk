import java.io.File;
import java.io.FileFilter;

class bqkw
  implements FileFilter
{
  bqkw(bqkv parambqkv) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqkw
 * JD-Core Version:    0.7.0.1
 */