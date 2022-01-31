import java.util.Calendar;

public class bgez
{
  public static final String a = ajjy.a(2131637055);
  public static final String b = ajjy.a(2131637026);
  public static final String c = ajjy.a(2131637007);
  public static final String d = ajjy.a(2131637047);
  public static final String e = ajjy.a(2131637017);
  public static final String f = ajjy.a(2131637011);
  public static final String g = ajjy.a(2131637050);
  
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
 * Qualified Name:     bgez
 * JD-Core Version:    0.7.0.1
 */