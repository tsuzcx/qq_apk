import com.tencent.mobileqq.data.RecentUser;
import java.util.Comparator;

class amjb
  implements Comparator<awge>
{
  amjb(amja paramamja) {}
  
  public int a(awge paramawge1, awge paramawge2)
  {
    int j = -1;
    paramawge1 = (RecentUser)paramawge1;
    paramawge2 = (RecentUser)paramawge2;
    long l1 = Math.max(paramawge1.lastmsgtime, paramawge1.lastmsgdrafttime);
    long l2 = Math.max(paramawge2.lastmsgtime, paramawge2.lastmsgdrafttime);
    int i;
    if (l1 < l2)
    {
      i = 1;
      if (paramawge1.getType() != paramawge2.getType()) {
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
      } while (paramawge1.getType() == 0);
      if (paramawge2.getType() == 0) {
        return 1;
      }
      i = j;
    } while (paramawge1.getType() - paramawge2.getType() > 0);
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amjb
 * JD-Core Version:    0.7.0.1
 */