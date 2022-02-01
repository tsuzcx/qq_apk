import com.tencent.mobileqq.data.QCallRecord;
import java.util.Comparator;

class azji
  implements Comparator<QCallRecord>
{
  azji(azjg paramazjg) {}
  
  public int a(QCallRecord paramQCallRecord1, QCallRecord paramQCallRecord2)
  {
    return (int)(paramQCallRecord2.time - paramQCallRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azji
 * JD-Core Version:    0.7.0.1
 */