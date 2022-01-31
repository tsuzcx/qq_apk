import java.util.Calendar;

public class bjty
{
  public static final String a = alud.a(2131703234);
  public static final String b = alud.a(2131703205);
  public static final String c = alud.a(2131703186);
  public static final String d = alud.a(2131703226);
  public static final String e = alud.a(2131703196);
  public static final String f = alud.a(2131703190);
  public static final String g = alud.a(2131703229);
  
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
 * Qualified Name:     bjty
 * JD-Core Version:    0.7.0.1
 */