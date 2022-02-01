import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

public class aung
  implements Comparator<FileInfo>
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    if (paramFileInfo1.c())
    {
      if (!paramFileInfo2.c()) {
        return -1000;
      }
    }
    else if (paramFileInfo2.c()) {
      return 1000;
    }
    return paramFileInfo1.d().compareToIgnoreCase(paramFileInfo2.d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aung
 * JD-Core Version:    0.7.0.1
 */