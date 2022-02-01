import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.1;
import java.io.File;
import java.io.FilenameFilter;

public class bgrx
  implements FilenameFilter
{
  public bgrx(TroopFileTransferManager.1 param1) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgrx
 * JD-Core Version:    0.7.0.1
 */