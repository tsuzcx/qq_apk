import com.tencent.mobileqq.data.QCallRecord;
import java.util.Comparator;

class azjh
  implements Comparator<QCallRecord>
{
  azjh(azjg paramazjg) {}
  
  public int a(QCallRecord paramQCallRecord1, QCallRecord paramQCallRecord2)
  {
    if (paramQCallRecord1.type == QCallRecord.TYPE_DATE) {
      return 0;
    }
    return (int)(paramQCallRecord2.time - paramQCallRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azjh
 * JD-Core Version:    0.7.0.1
 */