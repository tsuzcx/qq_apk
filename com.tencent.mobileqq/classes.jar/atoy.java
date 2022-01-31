import java.io.File;
import java.util.Comparator;

final class atoy
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile1.lastModified() < paramFile2.lastModified()) {
      return -1;
    }
    if (paramFile1.lastModified() > paramFile2.lastModified()) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atoy
 * JD-Core Version:    0.7.0.1
 */