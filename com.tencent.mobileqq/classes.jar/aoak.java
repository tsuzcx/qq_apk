import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

class aoak
  implements FileFilter
{
  public boolean accept(File paramFile)
  {
    return Pattern.matches("cpu[0-9]+", paramFile.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoak
 * JD-Core Version:    0.7.0.1
 */