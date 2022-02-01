import com.tencent.mobileqq.troop.utils.TroopFileTransferManager.1;
import java.io.File;
import java.io.FilenameFilter;

public class bgjr
  implements FilenameFilter
{
  public bgjr(TroopFileTransferManager.1 param1) {}
  
  public boolean accept(File paramFile, String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("[Thumb]");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgjr
 * JD-Core Version:    0.7.0.1
 */