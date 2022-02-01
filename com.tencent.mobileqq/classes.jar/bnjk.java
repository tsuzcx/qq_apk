import java.util.Calendar;

public class bnjk
{
  public static final String a = anzj.a(2131701748);
  public static final String b = anzj.a(2131701719);
  public static final String c = anzj.a(2131701700);
  public static final String d = anzj.a(2131701740);
  public static final String e = anzj.a(2131701710);
  public static final String f = anzj.a(2131701704);
  public static final String g = anzj.a(2131701743);
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnjk
 * JD-Core Version:    0.7.0.1
 */