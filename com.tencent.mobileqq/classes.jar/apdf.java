import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class apdf
{
  private static final Map<String, Integer> a = new HashMap();
  
  public static int a(String arg0, String paramString2)
  {
    paramString2 = ??? + "_" + paramString2;
    synchronized (a)
    {
      if (a.containsKey(paramString2))
      {
        i = ((Integer)a.get(paramString2)).intValue();
        return i;
      }
      int i = BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4).getInt(paramString2, 0);
      a.put(paramString2, Integer.valueOf(i));
    }
  }
  
  public static String a(String paramString)
  {
    String str = paramString;
    if (paramString.length() > 4)
    {
      str = paramString.substring(4);
      if (QLog.isDevelopLevel()) {
        QLog.d("DiySecureFileHelper", 4, paramString + " -> " + str);
      }
    }
    return str;
  }
  
  public static void a(String arg0, String paramString2, int paramInt)
  {
    int i = -1;
    paramString2 = ??? + "_" + paramString2;
    synchronized (a)
    {
      if (a.containsKey(paramString2)) {
        i = ((Integer)a.get(paramString2)).intValue();
      }
      if (i != paramInt)
      {
        BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4).edit().putInt(paramString2, paramInt).commit();
        a.put(paramString2, Integer.valueOf(paramInt));
      }
      return;
    }
  }
  
  private static void b(String paramString1, String paramString2)
  {
    Object localObject1 = new File(paramString1);
    int i;
    if (((File)localObject1).exists())
    {
      if (!((File)localObject1).isFile()) {
        break label75;
      }
      i = bhmi.a(paramString1, paramString2);
      if (i != 0) {
        QLog.d("DiySecureFileHelper", 1, "Move [" + paramString1 + "] errorcode = " + i);
      }
    }
    for (;;)
    {
      bhmi.a(paramString1);
      return;
      label75:
      if (((File)localObject1).isDirectory())
      {
        localObject1 = b((File)localObject1);
        int j = localObject1.length;
        i = 0;
        while (i < j)
        {
          Object localObject2 = localObject1[i];
          b(localObject2.getAbsolutePath(), new File(paramString2, localObject2.getName()).getAbsolutePath());
          i += 1;
        }
      }
    }
  }
  
  private static File[] b(File paramFile)
  {
    File[] arrayOfFile = paramFile.listFiles();
    paramFile = arrayOfFile;
    if (arrayOfFile == null)
    {
      QLog.e("DiySecureFileHelper", 1, new Throwable(), new Object[0]);
      paramFile = new File[0];
    }
    return paramFile;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdf
 * JD-Core Version:    0.7.0.1
 */