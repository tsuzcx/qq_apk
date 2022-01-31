import java.io.File;
import java.util.Comparator;

class aqzd
  implements Comparator<File>
{
  aqzd(aqzc paramaqzc) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() > paramFile2.lastModified()) {}
    do
    {
      return -1;
      if (paramFile1.lastModified() != paramFile2.lastModified()) {
        break;
      }
      if (paramFile1.length() > paramFile2.length()) {
        return 1;
      }
    } while (paramFile1.length() < paramFile2.length());
    return 0;
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqzd
 * JD-Core Version:    0.7.0.1
 */