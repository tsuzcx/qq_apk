import android.text.Spanned;
import java.util.Comparator;

final class bcmd
  implements Comparator<Object>
{
  bcmd(Spanned paramSpanned) {}
  
  public int compare(Object paramObject1, Object paramObject2)
  {
    return this.a.getSpanStart(paramObject1) - this.a.getSpanStart(paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bcmd
 * JD-Core Version:    0.7.0.1
 */