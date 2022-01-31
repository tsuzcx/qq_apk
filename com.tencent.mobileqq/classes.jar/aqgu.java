import java.io.File;
import java.util.Comparator;

final class aqgu
  implements Comparator<File>
{
  private int a(long paramLong1, long paramLong2)
  {
    if (paramLong1 < paramLong2) {
      return -1;
    }
    if (paramLong1 == paramLong2) {
      return 0;
    }
    return 1;
  }
  
  public int a(File paramFile1, File paramFile2)
  {
    return a(paramFile1.lastModified(), paramFile2.lastModified());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     aqgu
 * JD-Core Version:    0.7.0.1
 */