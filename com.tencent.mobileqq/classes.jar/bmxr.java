import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

public class bmxr
  implements Comparator<RecentUser>
{
  public int a(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
  {
    long l2 = Math.max(paramRecentUser1.lastmsgtime, paramRecentUser1.lastmsgdrafttime);
    long l3 = Math.max(paramRecentUser2.lastmsgtime, paramRecentUser2.lastmsgdrafttime);
    long l1 = l2;
    if (paramRecentUser1.lastmsgtime <= 0L)
    {
      l1 = l2;
      if (paramRecentUser1.lastmsgdrafttime <= 0L) {
        l1 = Math.max(l2, paramRecentUser1.opTime);
      }
    }
    l2 = l3;
    if (paramRecentUser2.lastmsgtime <= 0L)
    {
      l2 = l3;
      if (paramRecentUser2.lastmsgdrafttime <= 0L) {
        l2 = Math.max(l3, paramRecentUser2.opTime);
      }
    }
    if (l1 > l2) {
      return -1;
    }
    if (l1 < l2) {
      return 1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmxr
 * JD-Core Version:    0.7.0.1
 */