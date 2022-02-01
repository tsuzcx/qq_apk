import java.io.File;
import java.io.FileFilter;

class bqph
  implements FileFilter
{
  bqph(bqpg parambqpg) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    return (paramFile.endsWith(".jpg")) || (paramFile.endsWith(".png")) || (paramFile.endsWith(".bmp")) || (paramFile.endsWith(".apng")) || (paramFile.endsWith(".gif"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bqph
 * JD-Core Version:    0.7.0.1
 */