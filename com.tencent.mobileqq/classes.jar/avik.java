import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.HandlerThread;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.logcathook.LogcatHook;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;

public class avik
{
  static avim jdField_a_of_type_Avim;
  private static BufferedWriter jdField_a_of_type_JavaIoBufferedWriter;
  static String jdField_a_of_type_JavaLangString = "";
  static SimpleDateFormat jdField_a_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yy.MM.dd.HH");
  private static boolean jdField_a_of_type_Boolean;
  private static final String[] jdField_a_of_type_ArrayOfJavaLangString = { "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_PHONE_STATE" };
  private static String jdField_b_of_type_JavaLangString = "";
  static SimpleDateFormat jdField_b_of_type_JavaTextSimpleDateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
  private static String c = "com.tencent.mobileqq";
  private static String d = a(BaseApplication.context) + File.separator + "tencent" + File.separator + "msflogs" + File.separator + c.replace(".", File.separator) + File.separator;
  
  public static String a()
  {
    long l = System.currentTimeMillis();
    Object localObject = Calendar.getInstance();
    ((Calendar)localObject).setTimeInMillis(l);
    localObject = jdField_a_of_type_JavaTextSimpleDateFormat.format(((Calendar)localObject).getTime());
    localObject = d + a((String)localObject);
    try
    {
      File localFile = new File(d);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File((String)localObject);
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      return localObject;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return localObject;
  }
  
  public static String a(Context paramContext)
  {
    if (paramContext == null) {
      return Environment.getExternalStorageDirectory().getPath();
    }
    File localFile = paramContext.getExternalFilesDir(null);
    if ((localFile != null) && (!a(paramContext))) {
      return localFile.getPath();
    }
    return Environment.getExternalStorageDirectory().getPath();
  }
  
  public static String a(String paramString)
  {
    return jdField_b_of_type_JavaLangString.replace(":", "_") + "_syslog_." + paramString + ".log";
  }
  
  static void a(long paramLong)
  {
    String str = jdField_b_of_type_JavaTextSimpleDateFormat.format(Long.valueOf(paramLong));
    Object localObject2 = Calendar.getInstance();
    ((Calendar)localObject2).setTimeInMillis(paramLong);
    localObject2 = jdField_a_of_type_JavaTextSimpleDateFormat.format(((Calendar)localObject2).getTime());
    localObject2 = d + a((String)localObject2);
    try
    {
      File localFile = new File(d);
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      localFile = new File((String)localObject2);
      if (!localFile.exists()) {
        localFile.createNewFile();
      }
      jdField_a_of_type_JavaIoBufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(localFile, true)));
      if (jdField_a_of_type_JavaIoBufferedWriter != null)
      {
        jdField_a_of_type_JavaIoBufferedWriter.write(str + "|" + jdField_b_of_type_JavaLangString + "|D||QQ_Version: " + jdField_a_of_type_JavaLangString + "\r\n");
        jdField_a_of_type_JavaIoBufferedWriter.write(str + "|" + jdField_b_of_type_JavaLangString + "|D|" + "LogcatHookThread" + "|" + Build.MODEL + " " + Build.VERSION.RELEASE + " create newLogFile " + localFile.getName() + " \n");
        jdField_a_of_type_JavaIoBufferedWriter.flush();
      }
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
        if (jdField_a_of_type_JavaIoBufferedWriter != null)
        {
          jdField_a_of_type_JavaIoBufferedWriter.close();
          jdField_a_of_type_JavaIoBufferedWriter = null;
        }
      }
    }
    finally
    {
      if (jdField_a_of_type_JavaIoBufferedWriter == null) {
        break label340;
      }
      jdField_a_of_type_JavaIoBufferedWriter.close();
      jdField_a_of_type_JavaIoBufferedWriter = null;
    }
    if (LogcatHook.jdField_a_of_type_Boolean) {
      LogcatHook.updateLogFilePath((String)localObject2);
    }
  }
  
  public static void a(String paramString1, String paramString2, String paramString3, long paramLong)
  {
    if (jdField_a_of_type_Avim == null)
    {
      jdField_b_of_type_JavaLangString = paramString2;
      c = paramString1;
      jdField_a_of_type_JavaLangString = paramString3;
      paramString1 = new HandlerThread("sysLogWriteThread");
      paramString1.start();
      jdField_a_of_type_Avim = new avim(paramString1.getLooper());
      jdField_a_of_type_Avim.sendEmptyMessageDelayed(1, paramLong);
      if (BaseApplicationImpl.sProcessId == 1) {
        jdField_a_of_type_Avim.sendEmptyMessageDelayed(2, paramLong);
      }
    }
  }
  
  public static boolean a(Context paramContext)
  {
    boolean bool2 = jdField_a_of_type_Boolean;
    boolean bool1 = bool2;
    if (!bool2)
    {
      if (Build.VERSION.SDK_INT < 23) {
        break label48;
      }
      bool1 = bool2;
      if (paramContext != null)
      {
        bool1 = bool2;
        if (paramContext.checkSelfPermission(jdField_a_of_type_ArrayOfJavaLangString[0]) == 0)
        {
          jdField_a_of_type_Boolean = true;
          bool1 = jdField_a_of_type_Boolean;
        }
      }
    }
    return bool1;
    label48:
    jdField_a_of_type_Boolean = true;
    return jdField_a_of_type_Boolean;
  }
  
  static void b(long paramLong)
  {
    Object localObject1 = new File(d);
    ArrayList localArrayList = new ArrayList();
    long l2 = 0L;
    long l1 = l2;
    int i;
    Object localObject2;
    if (((File)localObject1).exists())
    {
      l1 = l2;
      if (((File)localObject1).isDirectory())
      {
        localObject1 = ((File)localObject1).listFiles();
        int j = localObject1.length;
        i = 0;
        l1 = 0L;
        if (i < j)
        {
          localObject2 = localObject1[i];
          if ((!localObject2.exists()) || (!localObject2.isFile()) || (!localObject2.getName().contains("syslog"))) {
            break label253;
          }
          if (paramLong - localObject2.lastModified() > 86400000L) {
            localObject2.delete();
          }
        }
      }
    }
    label253:
    for (;;)
    {
      i += 1;
      break;
      localArrayList.add(new avil(localObject2.lastModified(), localObject2.length(), localObject2.getPath()));
      l1 = localObject2.length() + l1;
      continue;
      if (l1 > 104857600L)
      {
        Collections.sort(localArrayList);
        for (paramLong = l1; paramLong > 104857600L; paramLong -= l1)
        {
          localObject1 = new File(((avil)localArrayList.remove(0)).a());
          l1 = ((File)localObject1).length();
          if (((File)localObject1).exists()) {
            ((File)localObject1).delete();
          }
        }
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     avik
 * JD-Core Version:    0.7.0.1
 */