import com.tencent.mobileqq.data.QCallRecord;
import java.util.Comparator;

class azwk
  implements Comparator<QCallRecord>
{
  azwk(azwi paramazwi) {}
  
  public int a(QCallRecord paramQCallRecord1, QCallRecord paramQCallRecord2)
  {
    return (int)(paramQCallRecord2.time - paramQCallRecord1.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azwk
 * JD-Core Version:    0.7.0.1
 */