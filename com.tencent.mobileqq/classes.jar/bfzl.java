import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.NotFoundException;
import android.provider.Settings.SettingNotFoundException;
import android.provider.Settings.System;
import android.text.TextUtils;
import android.text.format.Time;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class bfzl
{
  private static int jdField_a_of_type_Int;
  private static StringBuffer jdField_a_of_type_JavaLangStringBuffer;
  private static java.text.DateFormat jdField_a_of_type_JavaTextDateFormat;
  private static Calendar jdField_a_of_type_JavaUtilCalendar;
  private static int jdField_b_of_type_Int;
  private static java.text.DateFormat jdField_b_of_type_JavaTextDateFormat;
  
  private static int a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    GregorianCalendar localGregorianCalendar1 = new GregorianCalendar(paramInt1, paramInt2, paramInt3);
    GregorianCalendar localGregorianCalendar2 = new GregorianCalendar(paramInt4, paramInt5, paramInt6);
    return (int)((localGregorianCalendar1.getTimeInMillis() - localGregorianCalendar2.getTimeInMillis()) / 1000L / 60L / 60L / 24L);
  }
  
  public static int a(long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(jdField_b_of_type_Int + paramLong);
    return jdField_a_of_type_JavaUtilCalendar.get(11);
  }
  
  public static int a(long paramLong, Calendar paramCalendar)
  {
    paramCalendar = new Time();
    paramCalendar.set(paramLong);
    long l = System.currentTimeMillis();
    Time localTime = new Time();
    localTime.set(l);
    int i = localTime.yearDay - 1;
    int j = localTime.yearDay;
    if (paramCalendar.year == localTime.year) {
      if (localTime.yearDay >= paramCalendar.yearDay) {}
    }
    do
    {
      do
      {
        do
        {
          return -1;
          if (localTime.yearDay == paramCalendar.yearDay) {
            return 2131719016;
          }
          if (paramCalendar.yearDay == i) {
            return 2131719735;
          }
        } while ((paramCalendar.yearDay >= i) || (paramCalendar.yearDay <= j - 7));
        switch (paramCalendar.weekDay)
        {
        default: 
          return -1;
        case 0: 
          return 2131718744;
        case 1: 
          return 2131693842;
        case 2: 
          return 2131719331;
        case 3: 
          return 2131719622;
        case 4: 
          return 2131718942;
        case 5: 
          return 2131692459;
        }
        return 2131717763;
      } while (paramCalendar.year + 1 != localTime.year);
      paramLong = (l - paramLong + 86400000L - 1L) / 86400000L;
    } while ((paramLong <= 0L) || (paramLong > 7L));
    if (paramLong == 1L) {
      return 2131719735;
    }
    switch (paramCalendar.weekDay)
    {
    default: 
      return -1;
    case 0: 
      return 2131718744;
    case 1: 
      return 2131693842;
    case 2: 
      return 2131719331;
    case 3: 
      return 2131719622;
    case 4: 
      return 2131718942;
    case 5: 
      return 2131692459;
    }
    return 2131717763;
  }
  
  public static long a(long paramLong)
  {
    long l = paramLong;
    if (paramLong == 0L) {
      l = System.currentTimeMillis();
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(l / 1000L * 1000L);
    localCalendar.set(11, 0);
    localCalendar.set(12, 0);
    localCalendar.set(13, 0);
    return localCalendar.getTimeInMillis();
  }
  
  public static long a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      for (;;)
      {
        return -1L;
        SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try
        {
          paramString = localSimpleDateFormat.parse(paramString);
          if (paramString != null)
          {
            long l = paramString.getTime();
            return l;
          }
        }
        catch (ParseException paramString) {}
      }
    } while (!QLog.isColorLevel());
    paramString.printStackTrace();
    return -1L;
  }
  
  public static CharSequence a(Context paramContext, int paramInt, long paramLong)
  {
    return a(paramContext, paramInt, paramLong, true);
  }
  
  public static CharSequence a(Context paramContext, int paramInt, long paramLong, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    try
    {
      SimpleDateFormat localSimpleDateFormat1 = (SimpleDateFormat)a();
      if (paramInt == 0)
      {
        localStringBuilder.append(localSimpleDateFormat1.toLocalizedPattern());
        return android.text.format.DateFormat.format(localStringBuilder.append(" ").toString(), paramLong) + b().format(Long.valueOf(paramLong));
      }
    }
    catch (Resources.NotFoundException localNotFoundException)
    {
      SimpleDateFormat localSimpleDateFormat2;
      for (;;)
      {
        localSimpleDateFormat2 = new SimpleDateFormat("HH:mm");
      }
      return a(paramContext, paramLong, localStringBuilder, localSimpleDateFormat2, paramInt, paramBoolean);
    }
  }
  
  public static CharSequence a(Context paramContext, long paramLong)
  {
    if (jdField_a_of_type_JavaUtilCalendar == null) {
      jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    }
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    int i = jdField_a_of_type_JavaUtilCalendar.get(2);
    int j = jdField_a_of_type_JavaUtilCalendar.get(5);
    return String.format("%s%s%s%s", new Object[] { Integer.valueOf(i + 1), paramContext.getString(2131693843), Integer.valueOf(j), paramContext.getString(2131691333) });
  }
  
  private static CharSequence a(Context paramContext, long paramLong, StringBuilder paramStringBuilder, SimpleDateFormat paramSimpleDateFormat, int paramInt, boolean paramBoolean)
  {
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    Time localTime2 = new Time();
    localTime2.setToNow();
    int i;
    int j;
    if ((paramInt & 0x2) != 0)
    {
      i = 1;
      if ((paramInt & 0x1) == 0) {
        break label118;
      }
      j = 1;
      label49:
      if ((paramInt & 0x4) == 0) {
        break label124;
      }
      paramInt = 1;
      label59:
      if (localTime1.year == localTime2.year) {
        break label130;
      }
      paramStringBuilder.append(paramSimpleDateFormat.toLocalizedPattern()).append(" ");
      paramInt = 0;
    }
    for (;;)
    {
      if ((paramInt == 0) && (!paramBoolean))
      {
        return android.text.format.DateFormat.format(paramStringBuilder.toString().trim(), paramLong);
        i = 0;
        break;
        label118:
        j = 0;
        break label49;
        label124:
        paramInt = 0;
        break label59;
        label130:
        if (localTime1.yearDay == localTime2.yearDay) {
          break label472;
        }
        int m = Math.abs(localTime2.yearDay - localTime1.yearDay);
        if (localTime2.yearDay > localTime1.yearDay) {}
        for (int k = 1;; k = 0)
        {
          if (k != 0) {
            break label207;
          }
          paramStringBuilder.append(paramSimpleDateFormat.toLocalizedPattern()).append(" ");
          paramInt = 0;
          break;
        }
        label207:
        if ((m == 1) && (j != 0))
        {
          paramStringBuilder.append(paramContext.getString(2131689986)).append(" ");
          if (!paramBoolean) {
            return paramStringBuilder.toString().trim();
          }
          return paramStringBuilder.toString() + b().format(Long.valueOf(paramLong));
        }
        if ((m == 2) && (paramInt != 0))
        {
          paramStringBuilder.append(paramContext.getString(2131690526)).append(" ");
          if (!paramBoolean) {
            return paramStringBuilder.toString().trim();
          }
          return paramStringBuilder.toString() + b().format(Long.valueOf(paramLong));
        }
        if ((m > 1) && (m < 7) && (i != 0))
        {
          paramStringBuilder.append("EEEE").append(" ");
          paramInt = 0;
          continue;
        }
        if (localTime1.year == localTime2.year)
        {
          paramStringBuilder.append("MM-dd").append(" ");
          paramInt = 0;
          continue;
        }
        paramStringBuilder.append(paramSimpleDateFormat.toLocalizedPattern()).append(" ");
        paramInt = 0;
        continue;
      }
      return android.text.format.DateFormat.format(paramStringBuilder.toString(), paramLong) + b().format(Long.valueOf(paramLong));
      label472:
      paramInt = 1;
    }
  }
  
  public static String a(long paramLong)
  {
    int i = (int)((System.currentTimeMillis() + jdField_a_of_type_Int) / 86400000L);
    int j = (int)((jdField_a_of_type_Int + paramLong) / 86400000L);
    if (i - j > 365) {
      return (i - j) / 365 + amtj.a(2131713969);
    }
    if (i - j > 30) {
      return (i - j) / 30 + amtj.a(2131713974);
    }
    if (i - j >= 1) {
      return i - j + amtj.a(2131713973);
    }
    try
    {
      String str = a(paramLong, "HH:mm");
      return str;
    }
    catch (Exception localException)
    {
      if (QLog.isColorLevel()) {
        QLog.d("TimeFormatterUtils", 2, localException.getMessage());
      }
    }
    return "";
  }
  
  public static String a(long paramLong, String paramString)
  {
    if (paramLong <= 0L) {
      return null;
    }
    Date localDate = new Date(paramLong);
    return new SimpleDateFormat(paramString).format(localDate);
  }
  
  public static String a(long paramLong, boolean paramBoolean, String paramString)
  {
    return a(jdField_a_of_type_JavaLangStringBuffer, paramLong, paramBoolean, paramString);
  }
  
  public static String a(Context paramContext, long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    int i = jdField_a_of_type_JavaUtilCalendar.get(1);
    int j = jdField_a_of_type_JavaUtilCalendar.get(2);
    int k = jdField_a_of_type_JavaUtilCalendar.get(5);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    i = a(i, j, k, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(5));
    if (i == 0)
    {
      try
      {
        i = Settings.System.getInt(paramContext.getContentResolver(), "time_12_24");
        if (i == 12) {
          if (jdField_a_of_type_JavaUtilCalendar.get(11) < 12)
          {
            i = 2131718235;
            String str = paramContext.getString(i);
            paramContext = new SimpleDateFormat("hh:mm", paramContext.getResources().getConfiguration().locale);
            if (!amvi.a()) {
              break label189;
            }
            return String.format("%s %s", new Object[] { str, paramContext.format(new Date(paramLong)) });
          }
        }
      }
      catch (Settings.SettingNotFoundException localSettingNotFoundException)
      {
        for (;;)
        {
          i = 0;
          continue;
          i = 2131689822;
        }
        label189:
        return String.format("%s %s", new Object[] { paramContext.format(new Date(paramLong)), localSettingNotFoundException });
      }
      return new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    if (i == 1) {
      return paramContext.getString(2131719735);
    }
    if ((i < 7) && (i > 1)) {
      return new SimpleDateFormat("E", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    return a().format(new Date(paramLong));
  }
  
  public static String a(Context paramContext, long paramLong, boolean paramBoolean)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    int i = jdField_a_of_type_JavaUtilCalendar.get(1);
    int j = jdField_a_of_type_JavaUtilCalendar.get(2);
    int k = jdField_a_of_type_JavaUtilCalendar.get(6);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    switch (b(i, j, k, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(6)))
    {
    default: 
      return null;
    case 1: 
      if (paramBoolean) {}
      for (str = "HH:mm:ss";; str = "HH:mm") {
        return new SimpleDateFormat(str, paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
      }
    case 2: 
      if (paramBoolean) {}
      for (str = "HH:mm:ss";; str = "HH:mm")
      {
        paramContext = new SimpleDateFormat(str, paramContext.getResources().getConfiguration().locale);
        return String.format("%s %s", new Object[] { amtj.a(2131713976), paramContext.format(new Date(paramLong)) });
      }
    case 3: 
      if (paramBoolean) {}
      for (str = "HH:mm:ss";; str = "HH:mm")
      {
        paramContext = new SimpleDateFormat(str, paramContext.getResources().getConfiguration().locale);
        return String.format("%s %s", new Object[] { amtj.a(2131713982), paramContext.format(new Date(paramLong)) });
      }
    case 4: 
      if (paramBoolean) {}
      for (str = "MM-dd HH:mm:ss";; str = "MM-dd HH:mm") {
        return new SimpleDateFormat(str, paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
      }
    }
    if (paramBoolean) {}
    for (String str = "yyyy-MM-dd HH:mm:ss";; str = "yyyy-MM-dd HH:mm") {
      return new SimpleDateFormat(str, paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
  }
  
  public static String a(StringBuffer paramStringBuffer, long paramLong, boolean paramBoolean, String paramString)
  {
    int i = 0;
    Object localObject2;
    int j;
    int m;
    if (paramStringBuffer != null)
    {
      paramStringBuffer.setLength(0);
      localObject2 = Calendar.getInstance();
      ((Calendar)localObject2).setTimeInMillis(paramLong);
      int k = a(paramLong, (Calendar)localObject2);
      if (k != -1)
      {
        j = 1;
        i = j;
        if (k != 2131719016)
        {
          paramStringBuffer.append(BaseApplication.getContext().getString(k));
          i = j;
        }
      }
      m = ((Calendar)localObject2).get(11);
      j = ((Calendar)localObject2).get(12);
      if (i != 0)
      {
        boolean bool = android.text.format.DateFormat.is24HourFormat(BaseApplication.getContext());
        if (k == 2131719016) {
          if (!bool)
          {
            paramString = BaseApplication.getContext().getString(2131689822);
            if ((m < 0) || (m >= 12)) {
              break label471;
            }
            paramString = BaseApplication.getContext().getString(2131718235);
          }
        }
      }
    }
    label258:
    label471:
    for (;;)
    {
      Object localObject1;
      if (m == 12)
      {
        i = 12;
        localObject2 = String.valueOf(j);
        localObject1 = localObject2;
        if (j < 10) {
          localObject1 = "0" + (String)localObject2;
        }
        localObject1 = i + ":" + (String)localObject1;
        if (!amvi.a()) {
          break label258;
        }
        paramStringBuffer.append(paramString).append((String)localObject1);
      }
      for (;;)
      {
        return paramStringBuffer.toString();
        i = m % 12;
        break;
        paramStringBuffer.append((String)localObject1).append(paramString);
        continue;
        paramStringBuffer.append(m);
        paramStringBuffer.append(':');
        if (j < 10) {
          paramStringBuffer.append('0');
        }
        paramStringBuffer.append(j);
        continue;
        if (!paramBoolean)
        {
          paramStringBuffer.append(' ');
          paramStringBuffer.append(m);
          paramStringBuffer.append(':');
          if (j < 10) {
            paramStringBuffer.append('0');
          }
          paramStringBuffer.append(j);
          continue;
          localObject1 = paramString;
          if (TextUtils.isEmpty(paramString)) {
            localObject1 = "yyyy-MM-dd";
          }
          try
          {
            paramString = new SimpleDateFormat((String)localObject1);
            paramStringBuffer.append(paramString.format(((Calendar)localObject2).getTime()));
            if (!paramBoolean)
            {
              paramStringBuffer.append(' ');
              paramStringBuffer.append(m);
              paramStringBuffer.append(':');
              if (j < 10) {
                paramStringBuffer.append('0');
              }
              paramStringBuffer.append(j);
            }
          }
          catch (Exception paramString)
          {
            for (;;)
            {
              paramString = new SimpleDateFormat("yyyy-MM-dd");
            }
          }
        }
      }
      return null;
    }
  }
  
  private static java.text.DateFormat a()
  {
    try
    {
      if (jdField_b_of_type_JavaTextDateFormat == null) {
        jdField_b_of_type_JavaTextDateFormat = android.text.format.DateFormat.getDateFormat(BaseApplicationImpl.getApplication().getApplicationContext());
      }
      java.text.DateFormat localDateFormat = jdField_b_of_type_JavaTextDateFormat;
      return localDateFormat;
    }
    finally {}
  }
  
  public static void a()
  {
    TimeZone localTimeZone1 = TimeZone.getTimeZone("GMT+8");
    TimeZone localTimeZone2 = TimeZone.getDefault();
    jdField_a_of_type_Int = localTimeZone1.getRawOffset();
    int i = localTimeZone2.getRawOffset();
    jdField_b_of_type_Int = jdField_a_of_type_Int - i;
    jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
    jdField_a_of_type_JavaLangStringBuffer = new StringBuffer();
  }
  
  private static int b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6)
  {
    if (paramInt1 != paramInt4) {
      return 5;
    }
    if (paramInt3 == paramInt6) {
      return 1;
    }
    if (paramInt3 == paramInt6 + 1) {
      return 2;
    }
    if (paramInt3 == paramInt6 + 2) {
      return 3;
    }
    return 4;
  }
  
  public static int b(long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(jdField_b_of_type_Int + paramLong);
    return jdField_a_of_type_JavaUtilCalendar.get(12);
  }
  
  public static String b(long paramLong)
  {
    return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(paramLong));
  }
  
  public static String b(Context paramContext, long paramLong)
  {
    return a(paramContext, paramLong, false);
  }
  
  private static java.text.DateFormat b()
  {
    try
    {
      if (jdField_a_of_type_JavaTextDateFormat == null) {
        jdField_a_of_type_JavaTextDateFormat = android.text.format.DateFormat.getTimeFormat(BaseApplicationImpl.getApplication().getApplicationContext());
      }
      java.text.DateFormat localDateFormat = jdField_a_of_type_JavaTextDateFormat;
      return localDateFormat;
    }
    finally {}
  }
  
  public static int c(long paramLong)
  {
    int i = -1;
    int j = (int)((System.currentTimeMillis() + jdField_a_of_type_Int) / 86400000L);
    int k = (int)((jdField_a_of_type_Int + paramLong) / 86400000L);
    if (k == j) {
      i = 2131719016;
    }
    do
    {
      return i;
      if (k == j - 1) {
        return 2131719735;
      }
    } while (k != j - 2);
    return 2131690526;
  }
  
  public static String c(Context paramContext, long paramLong)
  {
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
    int i = jdField_a_of_type_JavaUtilCalendar.get(1);
    int j = jdField_a_of_type_JavaUtilCalendar.get(2);
    int k = jdField_a_of_type_JavaUtilCalendar.get(6);
    jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
    switch (b(i, j, k, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(6)))
    {
    default: 
      return null;
    case 1: 
      paramContext = new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale);
      return String.format("%s %s", new Object[] { amtj.a(2131713977), paramContext.format(new Date(paramLong)) });
    case 2: 
      paramContext = new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale);
      return String.format("%s %s", new Object[] { amtj.a(2131713984), paramContext.format(new Date(paramLong)) });
    case 3: 
      paramContext = new SimpleDateFormat("HH:mm", paramContext.getResources().getConfiguration().locale);
      return String.format("%s %s", new Object[] { amtj.a(2131713978), paramContext.format(new Date(paramLong)) });
    case 4: 
      return new SimpleDateFormat("MM-dd HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
    }
    return new SimpleDateFormat("yyyy-MM-dd HH:mm", paramContext.getResources().getConfiguration().locale).format(new Date(paramLong));
  }
  
  public static int d(long paramLong)
  {
    try
    {
      jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(System.currentTimeMillis());
      int i = jdField_a_of_type_JavaUtilCalendar.get(1);
      int j = jdField_a_of_type_JavaUtilCalendar.get(2);
      int k = jdField_a_of_type_JavaUtilCalendar.get(6);
      jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(paramLong);
      i = b(i, j, k, jdField_a_of_type_JavaUtilCalendar.get(1), jdField_a_of_type_JavaUtilCalendar.get(2), jdField_a_of_type_JavaUtilCalendar.get(6));
      return i;
    }
    catch (Exception localException)
    {
      QLog.e("calTimeInterval", 2, localException.getMessage());
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bfzl
 * JD-Core Version:    0.7.0.1
 */