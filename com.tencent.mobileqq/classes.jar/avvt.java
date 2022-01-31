import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class avvt
{
  public static final String a = ajjy.a(2131637010);
  public static final String b = ajjy.a(2131637037);
  public static final String c = ajjy.a(2131637009);
  public static final String d = ajjy.a(2131637008);
  
  public static String a(long paramLong)
  {
    long l = System.currentTimeMillis() / 1000L - paramLong;
    if ((l >= 0L) && (l < 60L)) {
      return a;
    }
    if ((l >= 60L) && (l < 3600L)) {
      return l / 60L + b;
    }
    if ((l >= 3600L) && (l < 86400L)) {
      return l / 3600L + c;
    }
    if ((l >= 86400L) && (l < 432000L)) {
      return l / 86400L + d;
    }
    return new SimpleDateFormat("yyyy-MM-dd").format(Long.valueOf(paramLong * 1000L));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     avvt
 * JD-Core Version:    0.7.0.1
 */