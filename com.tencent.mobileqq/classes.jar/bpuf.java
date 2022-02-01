import com.tencent.qphone.base.util.QLog;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class bpuf
{
  private static final String jdField_a_of_type_JavaLangString = anzj.a(2131704664);
  static final String[] jdField_a_of_type_ArrayOfJavaLangString = { anzj.a(2131704672), anzj.a(2131704665), anzj.a(2131704671), anzj.a(2131704670), anzj.a(2131704669), anzj.a(2131704673), anzj.a(2131704667) };
  private static final String b = anzj.a(2131704675);
  
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
      bpui localbpui = new bpui();
      localbpui.c = ((Calendar)localObject).get(1);
      localbpui.b = (((Calendar)localObject).get(2) + 1);
      localbpui.jdField_a_of_type_Int = ((Calendar)localObject).get(5);
      localObject = bpug.a(localbpui);
      arrayOfString = new String[4];
      arrayOfString[0] = new String(bpug.a(localbpui.c));
      if (!((bpuh)localObject).jdField_a_of_type_Boolean) {
        break label210;
      }
      arrayOfString[1] = new String(anzj.a(2131704674) + bpug.b(((bpuh)localObject).b));
    }
    for (;;)
    {
      arrayOfString[2] = new String(String.valueOf(bpug.c(((bpuh)localObject).jdField_a_of_type_Int).charAt(0)));
      arrayOfString[3] = new String(String.valueOf(bpug.c(((bpuh)localObject).jdField_a_of_type_Int).charAt(1)));
      if (QLog.isColorLevel()) {
        QLog.d("InfoStickerUtils", 2, arrayOfString);
      }
      return arrayOfString;
      paramLong = System.currentTimeMillis();
      break;
      label210:
      arrayOfString[1] = new String(bpug.b(((bpuh)localObject).b));
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
 * Qualified Name:     bpuf
 * JD-Core Version:    0.7.0.1
 */