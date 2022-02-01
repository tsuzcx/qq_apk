import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Arrays;
import java.util.Calendar;

public class aqel
  extends aptq<aqei>
{
  private static String a = "$time$";
  private static String b = "...";
  
  private static String a()
  {
    Calendar localCalendar = Calendar.getInstance();
    int i = localCalendar.get(1);
    int j = localCalendar.get(2);
    int k = localCalendar.get(5);
    return i + "年" + (j + 1) + "月" + k + "日";
  }
  
  private static String a(String paramString)
  {
    String str = a();
    return paramString.replace(a, str);
  }
  
  public static String a(String paramString, int paramInt)
  {
    char[] arrayOfChar = paramString.toCharArray();
    int j = 0;
    int i = 0;
    for (;;)
    {
      String str = paramString;
      if (j < arrayOfChar.length)
      {
        int k = Character.codePointAt(arrayOfChar, j);
        if ((k < 0) || (k > 255)) {
          break label80;
        }
        i += 1;
      }
      while (i > paramInt)
      {
        str = paramString.substring(0, j) + b;
        return str;
        label80:
        i += 2;
      }
      j += 1;
    }
  }
  
  public static int[] a(aqei paramaqei, long paramLong)
  {
    aqek[] arrayOfaqek = paramaqei.jdField_a_of_type_ArrayOfAqek;
    int k = arrayOfaqek.length;
    int i = 0;
    paramaqei = new int[0];
    for (;;)
    {
      Object localObject = paramaqei;
      long[] arrayOfLong;
      int m;
      int j;
      if (i < k)
      {
        localObject = arrayOfaqek[i];
        arrayOfLong = ((aqek)localObject).jdField_a_of_type_ArrayOfLong;
        m = arrayOfLong.length;
        j = 0;
      }
      while (j < m)
      {
        long l = arrayOfLong[j];
        if (l == paramLong)
        {
          localObject = ((aqek)localObject).jdField_a_of_type_ArrayOfInt;
          return localObject;
        }
        if (l == -1L) {
          paramaqei = ((aqek)localObject).jdField_a_of_type_ArrayOfInt;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public static aqej[] a(long paramLong)
  {
    aqei localaqei = (aqei)apub.a().a(680);
    if ((localaqei == null) || (localaqei.jdField_a_of_type_ArrayOfAqej.length == 0) || (localaqei.jdField_a_of_type_ArrayOfAqek.length == 0))
    {
      QLog.d("WriteTogetherTemplateConfProcessor", 1, "getTemplateList: no config" + localaqei);
      return null;
    }
    int[] arrayOfInt = a(localaqei, paramLong);
    aqej[] arrayOfaqej = new aqej[arrayOfInt.length];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      aqej localaqej = localaqei.jdField_a_of_type_ArrayOfAqej[(arrayOfInt[i] - 1)];
      localaqej.b = a(localaqej.b);
      localaqej.a = a(localaqej.a, 16);
      arrayOfaqej[i] = localaqej;
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherTemplateConfProcessor", 0, "getTemplateList: " + Arrays.toString(arrayOfaqej));
    }
    return arrayOfaqej;
  }
  
  public static aqej[] a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      return a(((behu)paramQQAppInterface.getManager(289)).a());
    }
    return null;
  }
  
  @NonNull
  public aqei a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherTemplateConfProcessor", 0, "migrateOldOrDefaultContent ");
    }
    return new aqei();
  }
  
  @Nullable
  public aqei a(aptx[] paramArrayOfaptx)
  {
    if ((paramArrayOfaptx != null) && (paramArrayOfaptx.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WriteTogetherTemplateConfProcessor", 0, "onParsed " + paramArrayOfaptx[0].a);
      }
      return aqei.a(paramArrayOfaptx[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherTemplateConfProcessor", 0, "onParsed no config");
    }
    return null;
  }
  
  public void a(aqei paramaqei) {}
  
  public Class<aqei> clazz()
  {
    return aqei.class;
  }
  
  public boolean isNeedCompressed()
  {
    return true;
  }
  
  public boolean isNeedStoreLargeFile()
  {
    return false;
  }
  
  public int migrateOldVersion()
  {
    return 0;
  }
  
  public void onReqFailed(int paramInt) {}
  
  public int type()
  {
    return 680;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aqel
 * JD-Core Version:    0.7.0.1
 */