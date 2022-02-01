import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.util.Pair;
import java.util.Comparator;

public class bbaf
  implements Comparator<Pair<Integer, Integer>>
{
  public bbaf(RichStatus paramRichStatus) {}
  
  public int a(Pair<Integer, Integer> paramPair1, Pair<Integer, Integer> paramPair2)
  {
    if (((Integer)paramPair1.second).intValue() < ((Integer)paramPair2.second).intValue()) {
      return -1;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbaf
 * JD-Core Version:    0.7.0.1
 */