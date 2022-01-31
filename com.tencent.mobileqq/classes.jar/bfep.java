import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.qqmini.sdk.core.MiniAppEnv;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bfep
{
  public static int a(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(11);
  }
  
  public static long a(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    try
    {
      long l = localSimpleDateFormat.parse(paramString).getTime();
      return l;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return 0L;
  }
  
  public static Date a(String paramString)
  {
    SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("HH:mm");
    try
    {
      paramString = localSimpleDateFormat.parse(paramString);
      return paramString;
    }
    catch (ParseException paramString)
    {
      paramString.printStackTrace();
    }
    return null;
  }
  
  public static int b(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(12);
  }
  
  public static Date b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    SimpleDateFormat localSimpleDateFormat;
    if (paramString.length() >= 10) {
      if (Pattern.compile(MiniAppEnv.g().getContext().getResources().getString(2131694205)).matcher(paramString).matches()) {
        localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
      }
    }
    for (;;)
    {
      if (localSimpleDateFormat == null)
      {
        return null;
        localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        continue;
        if (paramString.length() >= 7)
        {
          localSimpleDateFormat = new SimpleDateFormat("yyyy-MM");
          continue;
        }
        if (paramString.length() >= 4) {
          localSimpleDateFormat = new SimpleDateFormat("yyyy");
        }
      }
      else
      {
        try
        {
          paramString = localSimpleDateFormat.parse(paramString);
          return paramString;
        }
        catch (ParseException paramString)
        {
          paramString.printStackTrace();
          betc.d("DateUtils", "getDateByStrTime exception." + paramString);
          return null;
        }
      }
      localSimpleDateFormat = null;
    }
  }
  
  public static int c(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(1);
  }
  
  public static int d(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(2);
  }
  
  public static int e(Date paramDate)
  {
    if (paramDate == null) {
      return -1;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTime(paramDate);
    return localCalendar.get(5);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bfep
 * JD-Core Version:    0.7.0.1
 */