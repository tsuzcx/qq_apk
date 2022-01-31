import java.text.SimpleDateFormat;
import java.util.Locale;

class baja
  extends ThreadLocal<SimpleDateFormat>
{
  baja(baiz parambaiz) {}
  
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baja
 * JD-Core Version:    0.7.0.1
 */