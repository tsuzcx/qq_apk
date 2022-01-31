import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.LinkedList;

public class axsd
{
  public static LinkedList<axse> a = new LinkedList();
  
  public static axse a(Class paramClass, int paramInt)
  {
    if (paramClass == null) {
      return null;
    }
    int i = a.size() - 1;
    while (i >= 0)
    {
      axse localaxse = (axse)a.get(i);
      if ((paramClass == localaxse.jdField_a_of_type_JavaLangClass) && (paramInt == localaxse.jdField_a_of_type_Long))
      {
        a.remove(i);
        return localaxse;
      }
      i -= 1;
    }
    return null;
  }
  
  public static void a(long paramLong)
  {
    Iterator localIterator = a.iterator();
    while (localIterator.hasNext())
    {
      axse localaxse = (axse)localIterator.next();
      localaxse.b += paramLong;
    }
  }
  
  public static void a(AppInterface paramAppInterface, Class paramClass, int paramInt1, String paramString, int paramInt2)
  {
    a(paramAppInterface, paramClass, paramInt1, paramString, paramInt2, "");
  }
  
  public static void a(AppInterface paramAppInterface, Class paramClass, int paramInt1, String paramString1, int paramInt2, String paramString2)
  {
    if (paramClass == null) {
      return;
    }
    int i = a.size();
    if (i > 0)
    {
      i -= 1;
      if (i >= 0)
      {
        axse localaxse = (axse)a.get(i);
        if (localaxse.jdField_a_of_type_JavaLangClass == paramClass)
        {
          if (!(paramAppInterface instanceof QQAppInterface)) {
            break label123;
          }
          axqw.b((QQAppInterface)paramAppInterface, "CliOper", "", "", localaxse.jdField_a_of_type_JavaLangString, localaxse.jdField_a_of_type_JavaLangString, localaxse.jdField_a_of_type_Int, 0, paramString2, Long.toString(SystemClock.elapsedRealtime() - localaxse.b), "", "");
        }
        for (;;)
        {
          a.remove(i);
          i -= 1;
          break;
          label123:
          if (paramAppInterface != null) {
            paramAppInterface.reportClickEvent("CliOper", "", "", localaxse.jdField_a_of_type_JavaLangString, localaxse.jdField_a_of_type_JavaLangString, localaxse.jdField_a_of_type_Int, 0, paramString2, Long.toString(SystemClock.elapsedRealtime() - localaxse.b), "", "");
          } else {
            axqw.b(null, "CliOper", "", "", localaxse.jdField_a_of_type_JavaLangString, localaxse.jdField_a_of_type_JavaLangString, localaxse.jdField_a_of_type_Int, 0, paramString2, Long.toString(SystemClock.elapsedRealtime() - localaxse.b), "", "");
          }
        }
      }
    }
    paramAppInterface = new axse();
    paramAppInterface.jdField_a_of_type_JavaLangClass = paramClass;
    paramAppInterface.jdField_a_of_type_Long = paramInt1;
    paramAppInterface.b = SystemClock.elapsedRealtime();
    paramAppInterface.jdField_a_of_type_JavaLangString = paramString1;
    paramAppInterface.jdField_a_of_type_Int = paramInt2;
    a.add(paramAppInterface);
  }
  
  public static void a(Class<?> paramClass, int paramInt1, int paramInt2, String paramString)
  {
    if ((paramClass == null) || (paramString == null)) {
      return;
    }
    if (paramString.contains("/qunactivity/")) {}
    for (String str = "0X8004EC8";; str = null)
    {
      if (paramString.contains("/hotchat/"))
      {
        str = "0X8004410";
        paramInt2 = 2;
      }
      if (str == null) {
        break;
      }
      a(null, paramClass, paramInt1, str, paramInt2);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     axsd
 * JD-Core Version:    0.7.0.1
 */