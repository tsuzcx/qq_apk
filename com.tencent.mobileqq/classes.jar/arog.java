import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

public class arog
  implements Comparator<FileInfo>
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    if (paramFileInfo1.c()) {
      if (paramFileInfo2.c()) {
        break label25;
      }
    }
    label25:
    while (paramFileInfo1.b() > paramFileInfo2.b())
    {
      return -1;
      if (paramFileInfo2.c()) {
        return 1;
      }
    }
    if (paramFileInfo1.b() == paramFileInfo2.b()) {
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arog
 * JD-Core Version:    0.7.0.1
 */