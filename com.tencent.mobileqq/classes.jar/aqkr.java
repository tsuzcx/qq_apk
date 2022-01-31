import com.tencent.mobileqq.filemanager.activity.delDownloadFile.QfileLocalFileDelPicTabView.1;
import java.util.Comparator;

public class aqkr
  implements Comparator<Long>
{
  public aqkr(QfileLocalFileDelPicTabView.1 param1) {}
  
  public int a(Long paramLong1, Long paramLong2)
  {
    if (paramLong1.equals(paramLong2)) {
      return 1;
    }
    return (int)(paramLong1.longValue() - paramLong2.longValue());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqkr
 * JD-Core Version:    0.7.0.1
 */