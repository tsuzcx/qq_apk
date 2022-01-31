import com.tencent.mobileqq.data.QCallRecord;
import java.util.Comparator;

class awwl
  implements Comparator<QCallRecord>
{
  awwl(awwk paramawwk) {}
  
  public int a(QCallRecord paramQCallRecord1, QCallRecord paramQCallRecord2)
  {
    if (paramQCallRecord1.type == QCallRecord.TYPE_DATE) {
      return 0;
    }
    return (int)(paramQCallRecord2.time - paramQCallRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awwl
 * JD-Core Version:    0.7.0.1
 */