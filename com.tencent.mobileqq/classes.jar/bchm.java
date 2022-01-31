import java.text.SimpleDateFormat;
import java.util.Locale;

class bchm
  extends ThreadLocal<SimpleDateFormat>
{
  bchm(bchl parambchl) {}
  
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bchm
 * JD-Core Version:    0.7.0.1
 */