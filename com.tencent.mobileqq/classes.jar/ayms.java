import com.tencent.mobileqq.troop.data.TroopAioMsgNavigateBar.2;
import java.util.Comparator;

public class ayms
  implements Comparator<Long>
{
  public ayms(TroopAioMsgNavigateBar.2 param2) {}
  
  public int a(Long paramLong1, Long paramLong2)
  {
    int i = 0;
    if (paramLong1.longValue() - paramLong2.longValue() > 0L) {
      i = 1;
    }
    while (paramLong1.longValue() - paramLong2.longValue() >= 0L) {
      return i;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ayms
 * JD-Core Version:    0.7.0.1
 */