import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class blzg
{
  private static final String jdField_a_of_type_JavaLangString = alud.a(2131706156);
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { alud.a(2131706164), alud.a(2131706157), alud.a(2131706163), alud.a(2131706162), alud.a(2131706161), alud.a(2131706165), alud.a(2131706159) };
  private static final String b = alud.a(2131706167);
  
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
      blzj localblzj = new blzj();
      localblzj.c = ((Calendar)localObject).get(1);
      localblzj.b = (((Calendar)localObject).get(2) + 1);
      localblzj.jdField_a_of_type_Int = ((Calendar)localObject).get(5);
      localObject = blzh.a(localblzj);
      arrayOfString = new String[4];
      arrayOfString[0] = new String(blzh.a(localblzj.c));
      if (!((blzi)localObject).jdField_a_of_type_Boolean) {
        break label210;
      }
      arrayOfString[1] = new String(alud.a(2131706166) + blzh.b(((blzi)localObject).b));
    }
    for (;;)
    {
      arrayOfString[2] = new String(String.valueOf(blzh.c(((blzi)localObject).jdField_a_of_type_Int).charAt(0)));
      arrayOfString[3] = new String(String.valueOf(blzh.c(((blzi)localObject).jdField_a_of_type_Int).charAt(1)));
      if (QLog.isColorLevel()) {
        QLog.d("InfoStickerUtils", 2, arrayOfString);
      }
      return arrayOfString;
      paramLong = System.currentTimeMillis();
      break;
      label210:
      arrayOfString[1] = new String(blzh.b(((blzi)localObject).b));
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
 * Qualified Name:     blzg
 * JD-Core Version:    0.7.0.1
 */