import com.tencent.mobileqq.config.QConfigureException;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

public class aokv
{
  private aoky jdField_a_of_type_Aoky = new aoky(null);
  private aokz jdField_a_of_type_Aokz = new aokz(null);
  private aola jdField_a_of_type_Aola = new aola(null);
  private List<Member> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public static aokv a()
  {
    return aokx.a;
  }
  
  private static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder(64);
    localStringBuilder.append("-----------------------------------------------\n");
    StackTraceElement[] arrayOfStackTraceElement = Thread.currentThread().getStackTrace();
    if (arrayOfStackTraceElement != null)
    {
      int j = arrayOfStackTraceElement.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfStackTraceElement[i].toString();
        if ((!str.contains("com.tencent.mobileqq.config.QConfigWatchDog")) && (!str.contains("com.qq.android.dexposed.DexposedBridge")) && (!str.contains("me.weishu.epic.art")) && (!str.contains("java.lang.reflect.Method.invoke")) && (!str.contains("dalvik.system.VMStack.getThreadStackTrace")) && (!str.contains("java.lang.Thread.getStackTrace")) && (!str.contains("org.json.JSONTokener")) && (!str.contains("org.json.JSONObject.<init>"))) {
          localStringBuilder.append(str).append("\n");
        }
        i += 1;
      }
    }
    return localStringBuilder.toString();
  }
  
  private void b(aokh paramaokh, aoko[] paramArrayOfaoko, int paramInt, Exception paramException) {}
  
  private void b(aoki paramaoki, File paramFile, Exception paramException) {}
  
  private void b(Class paramClass, Exception paramException) {}
  
  private static void b(Exception paramException, String paramString1, String paramString2)
  {
    azpo.a(new QConfigureException(paramException, "TAG: " + paramString2 + " Message: " + paramException.getMessage()), paramString1);
  }
  
  public void a(aokh paramaokh, aoko[] paramArrayOfaoko, int paramInt, Exception paramException)
  {
    int i = paramaokh.a();
    if (QLog.isColorLevel()) {
      QLog.d("QConfigWatchDog", 2, "handleParsedJsonOrXmlException, parsed type=" + i + ", version=" + paramInt, paramException);
    }
    b(paramException, "parsed config failed, type=" + i + ", version=" + paramInt, "QConfigWatchDog_parsedConfig");
    b(paramaokh, paramArrayOfaoko, paramInt, paramException);
  }
  
  public void a(aoki paramaoki, File paramFile, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QConfigWatchDog", 2, "handleParsedIOException", paramException);
    }
    b(paramException, "write\\read IO failed", "QConfigWatchDog_parsedIO");
    b(paramaoki, paramFile, paramException);
  }
  
  public void a(Class paramClass, Exception paramException)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QConfigWatchDog", 2, "handleParsedJsonOrXmlException", paramException);
    }
    b(paramException, "parsed json\\Xml failed", "QConfigWatchDog_parsedIO");
    b(paramClass, paramException);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aokv
 * JD-Core Version:    0.7.0.1
 */