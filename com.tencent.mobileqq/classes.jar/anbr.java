import cooperation.qzone.font.FontManager;
import java.io.File;
import java.io.FileFilter;

public class anbr
  implements FileFilter
{
  public anbr(FontManager paramFontManager) {}
  
  public boolean accept(File paramFile)
  {
    return paramFile.getName().endsWith(".ftf");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     anbr
 * JD-Core Version:    0.7.0.1
 */