import java.io.File;
import java.io.FileFilter;

class bkbi
  implements FileFilter
{
  bkbi(bkbh parambkbh) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkbi
 * JD-Core Version:    0.7.0.1
 */