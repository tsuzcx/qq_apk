import java.io.File;
import java.util.Comparator;

class bdil
  implements Comparator<File>
{
  public int a(File paramFile1, File paramFile2)
  {
    return paramFile1.getName().compareTo(paramFile2.getName());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bdil
 * JD-Core Version:    0.7.0.1
 */