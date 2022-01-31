import java.util.Calendar;

public class bhof
{
  public static final String a = ajya.a(2131702850);
  public static final String b = ajya.a(2131702821);
  public static final String c = ajya.a(2131702802);
  public static final String d = ajya.a(2131702842);
  public static final String e = ajya.a(2131702812);
  public static final String f = ajya.a(2131702806);
  public static final String g = ajya.a(2131702845);
  
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
 * Qualified Name:     bhof
 * JD-Core Version:    0.7.0.1
 */