import android.os.Handler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.unifiedebug.UnifiedTraceRouter.1;
import com.tencent.qphone.base.util.QLog;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class bavd
{
  public float a;
  public final int a;
  public Handler a;
  public QQAppInterface a;
  public String a;
  public List<bave> a;
  public int b;
  public String b;
  
  public bavd(QQAppInterface paramQQAppInterface, Handler paramHandler)
  {
    this.jdField_a_of_type_Int = 32;
    this.jdField_b_of_type_Int = 1;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public String a(String paramString)
  {
    Object localObject = String.format("/system/bin/ping -i 0.2 -c 1 -s 0 -t %d -W 4 %s", new Object[] { Integer.valueOf(this.jdField_b_of_type_Int), paramString });
    long l = System.currentTimeMillis();
    Process localProcess = Runtime.getRuntime().exec((String)localObject);
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(localProcess.getInputStream()));
    localObject = "";
    for (;;)
    {
      String str2 = localBufferedReader.readLine();
      if (str2 == null) {
        break;
      }
      String str1 = (String)localObject + str2 + "\n";
      if (!str2.contains("From"))
      {
        localObject = str1;
        if (!str2.contains("from")) {}
      }
      else
      {
        this.jdField_a_of_type_Float = ((float)(System.currentTimeMillis() - l));
        localObject = str1;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UnifiedTraceRouter", 2, "ping url = " + paramString + " result = " + (String)localObject);
    }
    try
    {
      localProcess.destroy();
      label190:
      if (((String)localObject).equals("")) {
        throw new IllegalArgumentException("ping result is empty");
      }
      if (this.jdField_b_of_type_Int == 1)
      {
        this.jdField_a_of_type_JavaLangString = c((String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d("UnifiedTraceRouter", 2, "final ip: " + this.jdField_a_of_type_JavaLangString);
        }
      }
      return localObject;
    }
    catch (Exception paramString)
    {
      break label190;
    }
  }
  
  public void a(long paramLong, String paramString, Map<String, Object> paramMap)
  {
    this.jdField_a_of_type_AndroidOsHandler.post(new UnifiedTraceRouter.1(this, paramString, paramLong, paramMap));
  }
  
  public String b(String paramString)
  {
    Object localObject2 = null;
    int i;
    int j;
    Object localObject1;
    if (paramString.contains("From"))
    {
      paramString = paramString.substring(paramString.indexOf("From") + 5);
      if (paramString.contains("("))
      {
        i = paramString.indexOf("(");
        j = paramString.indexOf(")");
        localObject1 = paramString;
        if (i >= 0)
        {
          localObject1 = paramString;
          if (j >= 0) {
            localObject1 = paramString.substring(i + 1, j);
          }
        }
      }
    }
    do
    {
      do
      {
        return localObject1;
        paramString = paramString.substring(0, paramString.indexOf("\n"));
        if (paramString.contains(":")) {}
        for (i = paramString.indexOf(":");; i = paramString.indexOf(" "))
        {
          localObject1 = paramString;
          if (i <= 0) {
            break;
          }
          return paramString.substring(0, i);
        }
        i = paramString.indexOf("(");
        j = paramString.indexOf(")");
        localObject1 = localObject2;
      } while (i < 0);
      localObject1 = localObject2;
    } while (j < 0);
    return paramString.substring(i + 1, j);
  }
  
  public String c(String paramString)
  {
    String str = "";
    if (paramString.contains("PING")) {
      str = paramString.substring(paramString.indexOf("(") + 1, paramString.indexOf(")"));
    }
    return str;
  }
  
  public String d(String paramString)
  {
    String str = "";
    if (paramString.contains("time="))
    {
      paramString = paramString.substring(paramString.indexOf("time=") + 5);
      str = paramString.substring(0, paramString.indexOf(" "));
    }
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     bavd
 * JD-Core Version:    0.7.0.1
 */