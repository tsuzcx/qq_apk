import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.Comparator;

final class arrm
  implements Comparator<FileInfo>
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    return (int)(paramFileInfo2.b() / 1000L - paramFileInfo1.b() / 1000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arrm
 * JD-Core Version:    0.7.0.1
 */