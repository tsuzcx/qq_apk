import java.util.Calendar;

public class bhno
{
  public static final String a = ajyc.a(2131702839);
  public static final String b = ajyc.a(2131702810);
  public static final String c = ajyc.a(2131702791);
  public static final String d = ajyc.a(2131702831);
  public static final String e = ajyc.a(2131702801);
  public static final String f = ajyc.a(2131702795);
  public static final String g = ajyc.a(2131702834);
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bhno
 * JD-Core Version:    0.7.0.1
 */