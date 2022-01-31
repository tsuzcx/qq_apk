import com.tencent.mobileqq.data.QCallRecord;
import java.util.Comparator;

class awwm
  implements Comparator<QCallRecord>
{
  awwm(awwk paramawwk) {}
  
  public int a(QCallRecord paramQCallRecord1, QCallRecord paramQCallRecord2)
  {
    return (int)(paramQCallRecord2.time - paramQCallRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awwm
 * JD-Core Version:    0.7.0.1
 */