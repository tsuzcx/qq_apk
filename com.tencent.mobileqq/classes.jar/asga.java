import com.tencent.mobileqq.fragment.MsgBackupSettingFragment;
import java.io.File;
import java.io.FileFilter;

public class asga
  implements FileFilter
{
  public asga(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public boolean accept(File paramFile)
  {
    if (paramFile.getName().endsWith(".png")) {}
    while (paramFile.getName().endsWith(".jpg")) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     asga
 * JD-Core Version:    0.7.0.1
 */