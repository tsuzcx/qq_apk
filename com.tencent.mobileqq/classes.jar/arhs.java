import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import java.util.Arrays;
import java.util.Calendar;

public class arhs
  extends aqwt<arhp>
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
  
  public static int[] a(arhp paramarhp, long paramLong)
  {
    arhr[] arrayOfarhr = paramarhp.jdField_a_of_type_ArrayOfArhr;
    int k = arrayOfarhr.length;
    int i = 0;
    paramarhp = new int[0];
    for (;;)
    {
      Object localObject = paramarhp;
      long[] arrayOfLong;
      int m;
      int j;
      if (i < k)
      {
        localObject = arrayOfarhr[i];
        arrayOfLong = ((arhr)localObject).jdField_a_of_type_ArrayOfLong;
        m = arrayOfLong.length;
        j = 0;
      }
      while (j < m)
      {
        long l = arrayOfLong[j];
        if (l == paramLong)
        {
          localObject = ((arhr)localObject).jdField_a_of_type_ArrayOfInt;
          return localObject;
        }
        if (l == -1L) {
          paramarhp = ((arhr)localObject).jdField_a_of_type_ArrayOfInt;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  public static arhq[] a(long paramLong)
  {
    arhp localarhp = (arhp)aqxe.a().a(680);
    if ((localarhp == null) || (localarhp.jdField_a_of_type_ArrayOfArhq.length == 0) || (localarhp.jdField_a_of_type_ArrayOfArhr.length == 0))
    {
      QLog.d("WriteTogetherTemplateConfProcessor", 1, "getTemplateList: no config" + localarhp);
      return null;
    }
    int[] arrayOfInt = a(localarhp, paramLong);
    arhq[] arrayOfarhq = new arhq[arrayOfInt.length];
    int i = 0;
    while (i < arrayOfInt.length)
    {
      arhq localarhq = localarhp.jdField_a_of_type_ArrayOfArhq[(arrayOfInt[i] - 1)];
      localarhq.b = a(localarhq.b);
      localarhq.a = a(localarhq.a, 16);
      arrayOfarhq[i] = localarhq;
      i += 1;
    }
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherTemplateConfProcessor", 0, "getTemplateList: " + Arrays.toString(arrayOfarhq));
    }
    return arrayOfarhq;
  }
  
  public static arhq[] a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null) {
      return a(((bfox)paramQQAppInterface.getManager(QQManagerFactory.TROOP_CLASS_CONTROLLER_MANAGER)).a());
    }
    return null;
  }
  
  @NonNull
  public arhp a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherTemplateConfProcessor", 0, "migrateOldOrDefaultContent ");
    }
    return new arhp();
  }
  
  @Nullable
  public arhp a(aqxa[] paramArrayOfaqxa)
  {
    if ((paramArrayOfaqxa != null) && (paramArrayOfaqxa.length > 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d("WriteTogetherTemplateConfProcessor", 0, "onParsed " + paramArrayOfaqxa[0].a);
      }
      return arhp.a(paramArrayOfaqxa[0].a);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WriteTogetherTemplateConfProcessor", 0, "onParsed no config");
    }
    return null;
  }
  
  public void a(arhp paramarhp) {}
  
  public Class<arhp> clazz()
  {
    return arhp.class;
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
 * Qualified Name:     arhs
 * JD-Core Version:    0.7.0.1
 */