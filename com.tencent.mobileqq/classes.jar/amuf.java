import cooperation.qzone.font.FontManager;
import java.io.File;
import java.io.FileFilter;

public class amuf
  implements FileFilter
{
  public amuf(FontManager paramFontManager) {}
  
  public boolean accept(File paramFile)
  {
    paramFile = paramFile.getName();
    boolean bool1 = paramFile.endsWith(".ftf");
    boolean bool2 = paramFile.endsWith(".ttf");
    return (bool1) || (bool2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amuf
 * JD-Core Version:    0.7.0.1
 */