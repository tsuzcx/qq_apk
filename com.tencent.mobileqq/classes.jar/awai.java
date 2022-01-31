import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;

public class awai
{
  private static final String a = arft.class.getSimpleName();
  
  public static void a(Throwable paramThrowable)
  {
    Throwable localThrowable = new Throwable(paramThrowable);
    try
    {
      arrayOfField = Class.forName("java.lang.Throwable").getDeclaredFields();
      j = arrayOfField.length;
      i = 0;
    }
    catch (Throwable paramThrowable)
    {
      for (;;)
      {
        Field[] arrayOfField;
        int j;
        int i;
        Field localField;
        label110:
        QLog.e(a, 2, "addStackTag failed", paramThrowable);
        continue;
        i += 1;
      }
    }
    if (i < j)
    {
      localField = arrayOfField[i];
      if (!localField.getName().equals("detailMessage")) {
        break label155;
      }
      localField.setAccessible(true);
      if ((paramThrowable.getCause() == null) || (localThrowable.getCause() == null)) {
        break label110;
      }
      localField.set(localThrowable.getCause(), "ShortVideoCatchedException:" + paramThrowable.getCause().getMessage());
    }
    for (;;)
    {
      axpu.a(localThrowable, "ShortVideo Fail");
      return;
      localField.set(localThrowable, "ShortVideoCatchedException:" + paramThrowable.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     awai
 * JD-Core Version:    0.7.0.1
 */