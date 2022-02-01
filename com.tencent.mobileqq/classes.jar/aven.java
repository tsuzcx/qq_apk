import com.tencent.mobileqq.fragment.MsgBackupSettingFragment;
import java.io.File;
import java.io.FileFilter;

public class aven
  implements FileFilter
{
  public aven(MsgBackupSettingFragment paramMsgBackupSettingFragment) {}
  
  public boolean accept(File paramFile)
  {
    if (paramFile.getName().endsWith(".png")) {}
    while (paramFile.getName().endsWith(".jpg")) {
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aven
 * JD-Core Version:    0.7.0.1
 */