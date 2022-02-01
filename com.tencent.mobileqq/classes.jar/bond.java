import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class bond
{
  private static final String jdField_a_of_type_JavaLangString = anvx.a(2131705245);
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { anvx.a(2131705253), anvx.a(2131705246), anvx.a(2131705252), anvx.a(2131705251), anvx.a(2131705250), anvx.a(2131705254), anvx.a(2131705248) };
  private static final String b = anvx.a(2131705256);
  
  public static String a()
  {
    long l = System.currentTimeMillis();
    return new SimpleDateFormat("MM/dd").format(new Date(l));
  }
  
  public static String a(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("yyyy MMMM dd", Locale.US).format(new Date(paramLong)).toUpperCase();
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String[] a(long paramLong)
  {
    Object localObject;
    String[] arrayOfString;
    if (paramLong != -1L)
    {
      localObject = Calendar.getInstance();
      ((Calendar)localObject).setTime(new Date(paramLong));
      bong localbong = new bong();
      localbong.c = ((Calendar)localObject).get(1);
      localbong.b = (((Calendar)localObject).get(2) + 1);
      localbong.jdField_a_of_type_Int = ((Calendar)localObject).get(5);
      localObject = bone.a(localbong);
      arrayOfString = new String[4];
      arrayOfString[0] = new String(bone.a(localbong.c));
      if (!((bonf)localObject).jdField_a_of_type_Boolean) {
        break label210;
      }
      arrayOfString[1] = new String(anvx.a(2131705255) + bone.b(((bonf)localObject).b));
    }
    for (;;)
    {
      arrayOfString[2] = new String(String.valueOf(bone.c(((bonf)localObject).jdField_a_of_type_Int).charAt(0)));
      arrayOfString[3] = new String(String.valueOf(bone.c(((bonf)localObject).jdField_a_of_type_Int).charAt(1)));
      if (QLog.isColorLevel()) {
        QLog.d("InfoStickerUtils", 2, arrayOfString);
      }
      return arrayOfString;
      paramLong = System.currentTimeMillis();
      break;
      label210:
      arrayOfString[1] = new String(bone.b(((bonf)localObject).b));
    }
  }
  
  public static String b(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("HH:mm").format(new Date(paramLong));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String c(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("dd").format(new Date(paramLong));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String d(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("MMM", Locale.US).format(new Date(paramLong)).toUpperCase();
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String e(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("yyyy").format(new Date(paramLong));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String f(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("MMM dd HH:mm", Locale.US).format(new Date(paramLong)).toUpperCase();
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String g(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      SimpleDateFormat localSimpleDateFormat = new SimpleDateFormat("yy MM dd", Locale.US);
      Date localDate = new Date(paramLong);
      return "'" + localSimpleDateFormat.format(localDate).toUpperCase();
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String h(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("HHmm").format(new Date(paramLong));
      paramLong = System.currentTimeMillis();
    }
  }
  
  public static String i(long paramLong)
  {
    if (paramLong != -1L) {}
    for (;;)
    {
      return new SimpleDateFormat("HHmm").format(new Date(paramLong - 60000L));
      paramLong = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bond
 * JD-Core Version:    0.7.0.1
 */