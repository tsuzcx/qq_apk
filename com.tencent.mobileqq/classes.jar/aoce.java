import com.tencent.mobileqq.filemanager.activity.recentfile.QfileBaseRecentFileTabView;
import com.tencent.mobileqq.filemanager.data.OfflineFileInfo;
import java.util.Comparator;

public class aoce
  implements Comparator<OfflineFileInfo>
{
  public aoce(QfileBaseRecentFileTabView paramQfileBaseRecentFileTabView) {}
  
  public int a(OfflineFileInfo paramOfflineFileInfo1, OfflineFileInfo paramOfflineFileInfo2)
  {
    return Long.valueOf(paramOfflineFileInfo1.c).compareTo(Long.valueOf(paramOfflineFileInfo2.c));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aoce
 * JD-Core Version:    0.7.0.1
 */