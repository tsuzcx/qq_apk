import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.QQStoryFollowCaptureResManager.1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class bnpo
{
  private static bnpo jdField_a_of_type_Bnpo;
  private static File jdField_a_of_type_JavaIoFile;
  private static String jdField_a_of_type_JavaLangString = "QQStoryFollowCaptureResManager";
  private static File jdField_b_of_type_JavaIoFile = a(jdField_a_of_type_JavaIoFile, "follow_capture_template");
  private static File c = a(jdField_a_of_type_JavaIoFile, "follow_capture_original_video");
  private Boolean jdField_a_of_type_JavaLangBoolean;
  private String jdField_b_of_type_JavaLangString;
  
  static
  {
    jdField_a_of_type_JavaIoFile = a(new File(ajrx.d), "qqstroy_follow_capture");
    d();
  }
  
  public static bnpo a()
  {
    if (jdField_a_of_type_Bnpo == null) {}
    try
    {
      if (jdField_a_of_type_Bnpo == null) {
        jdField_a_of_type_Bnpo = new bnpo();
      }
      return jdField_a_of_type_Bnpo;
    }
    finally {}
  }
  
  public static File a()
  {
    if (!c.exists()) {
      c.mkdirs();
    }
    return c;
  }
  
  private static File a(File paramFile, String paramString)
  {
    paramFile = new File(paramFile, paramString);
    if (!paramFile.exists()) {
      paramFile.mkdirs();
    }
    return paramFile;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "template url is null");
      return null;
    }
    int i = paramString.lastIndexOf("/");
    int j = paramString.lastIndexOf(".");
    if ((i == -1) || (j == -1) || (i + 1 > j))
    {
      QLog.w(jdField_a_of_type_JavaLangString, 2, "template url is :" + paramString);
      return null;
    }
    return paramString.substring(i + 1, j);
  }
  
  private static List<File> a(File paramFile)
  {
    ArrayList localArrayList1 = new ArrayList();
    if ((paramFile != null) && (paramFile.exists()))
    {
      if (paramFile.isFile()) {
        return localArrayList1;
      }
      ArrayList localArrayList2 = new ArrayList();
      paramFile = paramFile.listFiles();
      int i;
      if ((paramFile != null) && (paramFile.length != 0))
      {
        int j = paramFile.length;
        i = 0;
        while (i < j)
        {
          localArrayList2.add(paramFile[i]);
          i += 1;
        }
      }
      while (localArrayList2.size() > 0)
      {
        paramFile = (File)localArrayList2.remove(0);
        localArrayList1.add(paramFile);
        if (paramFile.isDirectory())
        {
          paramFile = paramFile.listFiles();
          i = 0;
          while (i < paramFile.length)
          {
            localArrayList2.add(paramFile[i]);
            i += 1;
          }
        }
      }
    }
    return localArrayList1;
  }
  
  private static void a(File paramFile, boolean paramBoolean)
  {
    List localList = a(paramFile);
    int i = localList.size() - 1;
    while (i >= 0)
    {
      ((File)localList.get(i)).delete();
      i -= 1;
    }
    if (paramBoolean) {
      paramFile.delete();
    }
  }
  
  public static void a(String paramString, bnpq parambnpq)
  {
    String str1 = a(paramString);
    if (str1 == null) {}
    for (;;)
    {
      return;
      if (!jdField_b_of_type_JavaIoFile.exists()) {
        jdField_b_of_type_JavaIoFile.mkdirs();
      }
      String str2 = jdField_b_of_type_JavaIoFile.getPath() + File.separator + str1 + ".zip";
      if (!b(str2, str1))
      {
        baub localbaub = new baub();
        localbaub.jdField_a_of_type_Baug = new bnpp(str2, str1, parambnpq);
        localbaub.jdField_a_of_type_JavaLangString = paramString;
        localbaub.jdField_a_of_type_Int = 0;
        localbaub.jdField_c_of_type_JavaLangString = str2;
        localbaub.jdField_c_of_type_Int = bdin.a(bavg.a().a());
        try
        {
          parambnpq = BaseApplicationImpl.getApplication().getRuntime();
          if (QQAppInterface.class.isInstance(parambnpq))
          {
            ((QQAppInterface)parambnpq).getNetEngine(0).a(localbaub);
            if (QLog.isColorLevel())
            {
              QLog.i(jdField_a_of_type_JavaLangString, 2, "start download follow capture template, url: " + paramString);
              return;
            }
          }
        }
        catch (Exception paramString)
        {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "download follow capture template error", paramString);
        }
      }
    }
  }
  
  public static boolean a(String paramString)
  {
    boolean bool = true;
    if (paramString == null) {
      bool = false;
    }
    while (new File(jdField_b_of_type_JavaIoFile.getPath() + File.separator + paramString + File.separator + "complete").exists()) {
      return bool;
    }
    File localFile = new File(jdField_b_of_type_JavaIoFile.getPath() + File.separator + paramString + ".zip");
    bool = b(localFile, paramString);
    if (bool) {
      ThreadManagerV2.excute(new QQStoryFollowCaptureResManager.1(localFile, paramString), 16, null, true);
    }
    return bool;
  }
  
  public static String[] a(String paramString)
  {
    paramString = jdField_b_of_type_JavaIoFile.getPath() + File.separator + paramString + File.separator;
    return new String[] { paramString + "background.png", paramString + "foreground" };
  }
  
  public static void b()
  {
    a(c, false);
    a(jdField_b_of_type_JavaIoFile, false);
  }
  
  private static boolean b(File paramFile, String paramString)
  {
    boolean bool = true;
    if (!paramFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w(jdField_a_of_type_JavaLangString, 2, "template zip file not exists");
      }
      return false;
    }
    for (;;)
    {
      try
      {
        paramFile = bdhb.c(paramFile.getPath());
        if ((TextUtils.isEmpty(paramString)) || (!paramString.equalsIgnoreCase(paramFile))) {
          break label72;
        }
        return bool;
      }
      catch (UnsatisfiedLinkError paramFile) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e(jdField_a_of_type_JavaLangString, 1, "calculate follow capture template zip md5 error", paramFile);
      return false;
      label72:
      bool = false;
    }
  }
  
  private boolean b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, "parse config: " + paramString);
    }
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      try
      {
        paramString = new JSONObject(paramString);
        this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(paramString.optBoolean("enableFollowCapture"));
        this.jdField_b_of_type_JavaLangString = paramString.optString("guideVideoUrl");
        return true;
      }
      catch (JSONException paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.e(jdField_a_of_type_JavaLangString, 1, "parse follow capture config error", paramString);
        }
        return false;
      }
      finally
      {
        if (this.jdField_a_of_type_JavaLangBoolean == null) {
          this.jdField_a_of_type_JavaLangBoolean = Boolean.valueOf(false);
        }
      }
    }
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    paramString1 = new File(paramString1);
    if (b(paramString1, paramString2)) {
      return c(paramString1, paramString2);
    }
    paramString1.delete();
    if (QLog.isColorLevel()) {
      QLog.e(jdField_a_of_type_JavaLangString, 2, "template zip md5 is wrong");
    }
    return false;
  }
  
  public static void c()
  {
    if (jdField_a_of_type_JavaIoFile != null)
    {
      List localList = a(jdField_a_of_type_JavaIoFile);
      Iterator localIterator = localList.iterator();
      for (long l = 0L; localIterator.hasNext(); l = ((File)localIterator.next()).length() + l) {}
      if (l > 209715200L)
      {
        int i = localList.size() - 1;
        while (i >= 0)
        {
          ((File)localList.get(i)).delete();
          i -= 1;
        }
      }
      d();
    }
  }
  
  private static boolean c(File paramFile, String paramString)
  {
    try
    {
      paramString = jdField_b_of_type_JavaIoFile.getPath() + File.separator + paramString + File.separator;
      a(new File(paramString), true);
      File localFile = new File(paramString + "complete");
      if (localFile.exists()) {
        return true;
      }
      ndr.a(paramFile, paramString);
      localFile.createNewFile();
      return true;
    }
    catch (Exception paramFile)
    {
      if (QLog.isColorLevel()) {
        QLog.e(jdField_a_of_type_JavaLangString, 2, "uncompress template zip file error", paramFile);
      }
    }
    return false;
  }
  
  private static void d()
  {
    File localFile = new File(jdField_a_of_type_JavaIoFile, ".nomedia");
    if (!localFile.exists()) {}
    try
    {
      localFile.createNewFile();
      return;
    }
    catch (IOException localIOException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(jdField_a_of_type_JavaLangString, 2, "create .nomedia file error");
    }
  }
  
  private void e()
  {
    b(uvt.d());
  }
  
  public String a()
  {
    if (TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      e();
    }
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void a()
  {
    try
    {
      uvt.e();
      return;
    }
    finally {}
  }
  
  public boolean a()
  {
    return !TextUtils.isEmpty(uvt.d());
  }
  
  public boolean a(String paramString, QQAppInterface paramQQAppInterface)
  {
    if (!b(paramString)) {
      return false;
    }
    uvt.f(paramString);
    return true;
  }
  
  public boolean b()
  {
    if (this.jdField_a_of_type_JavaLangBoolean == null) {
      e();
    }
    if (this.jdField_a_of_type_JavaLangBoolean != null) {
      return this.jdField_a_of_type_JavaLangBoolean.booleanValue();
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bnpo
 * JD-Core Version:    0.7.0.1
 */