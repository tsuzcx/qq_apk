import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.util.Pair;
import java.util.Comparator;

public class avcp
  implements Comparator<Pair<Integer, Integer>>
{
  public avcp(RichStatus paramRichStatus) {}
  
  public int a(Pair<Integer, Integer> paramPair1, Pair<Integer, Integer> paramPair2)
  {
    if (((Integer)paramPair1.second).intValue() < ((Integer)paramPair2.second).intValue()) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avcp
 * JD-Core Version:    0.7.0.1
 */