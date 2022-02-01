import java.text.SimpleDateFormat;
import java.util.Locale;

class bfqm
  extends ThreadLocal<SimpleDateFormat>
{
  bfqm(bfql parambfql) {}
  
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfqm
 * JD-Core Version:    0.7.0.1
 */