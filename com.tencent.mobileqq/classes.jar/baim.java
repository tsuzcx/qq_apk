import java.text.SimpleDateFormat;
import java.util.Locale;

class baim
  extends ThreadLocal<SimpleDateFormat>
{
  baim(bail parambail) {}
  
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     baim
 * JD-Core Version:    0.7.0.1
 */