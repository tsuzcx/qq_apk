import java.text.SimpleDateFormat;
import java.util.Locale;

class bclv
  extends ThreadLocal<SimpleDateFormat>
{
  bclv(bclu parambclu) {}
  
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bclv
 * JD-Core Version:    0.7.0.1
 */