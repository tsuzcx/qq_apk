import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

class amem
  implements Comparator<awbv>
{
  amem(amel paramamel) {}
  
  public int a(awbv paramawbv1, awbv paramawbv2)
  {
    int j = -1;
    paramawbv1 = (RecentUser)paramawbv1;
    paramawbv2 = (RecentUser)paramawbv2;
    long l1 = Math.max(paramawbv1.lastmsgtime, paramawbv1.lastmsgdrafttime);
    long l2 = Math.max(paramawbv2.lastmsgtime, paramawbv2.lastmsgdrafttime);
    int i;
    if (l1 < l2)
    {
      i = 1;
      if (paramawbv1.getType() != paramawbv2.getType()) {
        break label80;
      }
    }
    label80:
    do
    {
      do
      {
        return i;
        if (l1 == l2)
        {
          i = 0;
          break;
        }
        i = -1;
        break;
        i = j;
      } while (paramawbv1.getType() == 0);
      if (paramawbv2.getType() == 0) {
        return 1;
      }
      i = j;
    } while (paramawbv1.getType() - paramawbv2.getType() > 0);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amem
 * JD-Core Version:    0.7.0.1
 */