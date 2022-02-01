import java.util.Calendar;

public class bmii
{
  public static final String a = anni.a(2131701641);
  public static final String b = anni.a(2131701612);
  public static final String c = anni.a(2131701593);
  public static final String d = anni.a(2131701633);
  public static final String e = anni.a(2131701603);
  public static final String f = anni.a(2131701597);
  public static final String g = anni.a(2131701636);
  
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
 * Qualified Name:     bmii
 * JD-Core Version:    0.7.0.1
 */