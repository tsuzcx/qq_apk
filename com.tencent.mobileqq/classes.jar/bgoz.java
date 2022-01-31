import com.tencent.qqmini.sdk.core.utils.FileInfo;
import java.util.Comparator;

public class bgoz
  implements Comparator<FileInfo>
{
  public int a(FileInfo paramFileInfo1, FileInfo paramFileInfo2)
  {
    if (paramFileInfo1.a())
    {
      if (!paramFileInfo2.a()) {
        return -1000;
      }
    }
    else if (paramFileInfo2.a()) {
      return 1000;
    }
    return paramFileInfo1.b().compareToIgnoreCase(paramFileInfo2.b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bgoz
 * JD-Core Version:    0.7.0.1
 */