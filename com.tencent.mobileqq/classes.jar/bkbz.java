import java.io.File;
import java.io.FileFilter;

class bkbz
  implements FileFilter
{
  bkbz(bkby parambkby) {}
  
  public boolean accept(File paramFile)
  {
    return (paramFile.isDirectory()) && (paramFile.getName().startsWith("emoji_folder_"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkbz
 * JD-Core Version:    0.7.0.1
 */