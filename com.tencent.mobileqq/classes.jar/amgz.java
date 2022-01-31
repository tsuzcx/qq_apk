import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

public class amgz
  implements Comparator<awge>
{
  private boolean a;
  
  public amgz(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public int a(awge paramawge1, awge paramawge2)
  {
    paramawge1 = (RecentUser)paramawge1;
    paramawge2 = (RecentUser)paramawge2;
    long l3 = Math.max(paramawge1.lastmsgtime, paramawge1.lastmsgdrafttime);
    long l2 = Math.max(paramawge2.lastmsgtime, paramawge2.lastmsgdrafttime);
    long l1;
    if (this.a) {
      if ((paramawge1.showUpTime > 0L) && (l3 == 0L))
      {
        l1 = Math.max(paramawge1.opTime, paramawge1.showUpTime);
        if ((paramawge2.showUpTime <= 0L) || (l2 != 0L)) {
          break label194;
        }
        l3 = Math.max(paramawge2.opTime, paramawge2.showUpTime);
        l2 = l1;
        l1 = l3;
      }
    }
    for (;;)
    {
      if (l2 > l1)
      {
        l1 = 3L;
        label117:
        l3 = l1;
        if (!this.a) {
          break label280;
        }
        l2 = l1;
        if (paramawge1.showUpTime > 0L) {
          l2 = l1 | 0x1000;
        }
        l3 = l2;
        if (paramawge2.showUpTime <= 0L) {
          break label280;
        }
        l1 = 0x2 | 0x1000;
        label167:
        if (l2 >= l1) {
          break label269;
        }
        return 1;
        l1 = l3;
        if (l3 != 0L) {
          break;
        }
        l1 = paramawge1.opTime;
        break;
        label194:
        if (l2 != 0L) {
          break label310;
        }
        l3 = paramawge2.opTime;
        l2 = l1;
        l1 = l3;
        continue;
        if (l3 != 0L) {
          break label304;
        }
      }
      label269:
      label280:
      label304:
      for (l1 = paramawge1.opTime;; l1 = l3)
      {
        if (l2 == 0L)
        {
          l3 = paramawge2.opTime;
          l2 = l1;
          l1 = l3;
          break;
          if (l2 < l1)
          {
            l1 = 1L;
            break label117;
          }
          l1 = 2L;
          break label117;
          if (l2 == l1) {
            return 0;
          }
          return -1;
          l2 = l3;
          l1 = 2L;
          break label167;
        }
        l3 = l1;
        l1 = l2;
        l2 = l3;
        break;
      }
      label310:
      l3 = l1;
      l1 = l2;
      l2 = l3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amgz
 * JD-Core Version:    0.7.0.1
 */