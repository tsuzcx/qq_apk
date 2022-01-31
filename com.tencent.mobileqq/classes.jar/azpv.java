import java.text.SimpleDateFormat;

final class azpv
  extends ThreadLocal<SimpleDateFormat>
{
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azpv
 * JD-Core Version:    0.7.0.1
 */