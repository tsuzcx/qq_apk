import java.text.SimpleDateFormat;

final class axqb
  extends ThreadLocal<SimpleDateFormat>
{
  protected SimpleDateFormat a()
  {
    return new SimpleDateFormat("MM.dd HH:mm:ss.SSS");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axqb
 * JD-Core Version:    0.7.0.1
 */