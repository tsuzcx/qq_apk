import java.text.SimpleDateFormat;
import java.util.Locale;

class azhj
  extends ThreadLocal<SimpleDateFormat>
{
  azhj(azhi paramazhi) {}
  
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azhj
 * JD-Core Version:    0.7.0.1
 */