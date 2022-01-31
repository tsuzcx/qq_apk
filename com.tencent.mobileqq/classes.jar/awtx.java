import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

final class awtx
  implements Comparator<RecentUser>
{
  public int a(RecentUser paramRecentUser1, RecentUser paramRecentUser2)
  {
    return Long.signum(paramRecentUser2.lastmsgtime - paramRecentUser1.lastmsgtime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awtx
 * JD-Core Version:    0.7.0.1
 */