import com.tencent.mobileqq.data.RecentUser;
import dov.com.tencent.biz.qqstory.takevideo.shareto.ShareToActivity;
import java.util.Comparator;

public class bkmx
  implements Comparator<RecentUser>
{
  public bkmx(ShareToActivity paramShareToActivity) {}
  
  public int a(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
  {
    if (paramRecentUser1.lastmsgtime > paramRecentUser2.lastmsgtime) {
      return -1;
    }
    if (paramRecentUser1.lastmsgtime < paramRecentUser2.lastmsgtime) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     bkmx
 * JD-Core Version:    0.7.0.1
 */