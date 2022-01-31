import java.util.Calendar;

public class bjpr
{
  public static final String a = alpo.a(2131703222);
  public static final String b = alpo.a(2131703193);
  public static final String c = alpo.a(2131703174);
  public static final String d = alpo.a(2131703214);
  public static final String e = alpo.a(2131703184);
  public static final String f = alpo.a(2131703178);
  public static final String g = alpo.a(2131703217);
  
  public static boolean a(long paramLong1, long paramLong2)
  {
    Calendar localCalendar1 = Calendar.getInstance();
    localCalendar1.setTimeInMillis(paramLong1);
    Calendar localCalendar2 = Calendar.getInstance();
    localCalendar2.setTimeInMillis(paramLong2);
    return (localCalendar1.get(1) == localCalendar2.get(1)) && (localCalendar1.get(6) == localCalendar2.get(6));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjpr
 * JD-Core Version:    0.7.0.1
 */