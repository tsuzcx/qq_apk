import com.tencent.mobileqq.data.QCallRecord;
import java.util.Comparator;

class aufr
  implements Comparator<QCallRecord>
{
  aufr(aufp paramaufp) {}
  
  public int a(QCallRecord paramQCallRecord1, QCallRecord paramQCallRecord2)
  {
    return (int)(paramQCallRecord2.time - paramQCallRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     aufr
 * JD-Core Version:    0.7.0.1
 */