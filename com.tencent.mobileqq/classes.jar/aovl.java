import java.io.File;
import java.util.Comparator;

class aovl
  implements Comparator<File>
{
  aovl(aovk paramaovk) {}
  
  public int a(File paramFile1, File paramFile2)
  {
    if (paramFile2.lastModified() > paramFile1.lastModified()) {
      return 1;
    }
    if (paramFile2.lastModified() < paramFile1.lastModified()) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aovl
 * JD-Core Version:    0.7.0.1
 */