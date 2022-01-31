import android.text.Editable;
import java.util.Comparator;

final class bcho
  implements Comparator
{
  bcho(Editable paramEditable) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return this.a.getSpanStart(paramObject1) - this.a.getSpanStart(paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcho
 * JD-Core Version:    0.7.0.1
 */