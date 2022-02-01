import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mm.vfs.FileSchemeResolver;
import com.tencent.mm.vfs.FileSystem;
import com.tencent.mm.vfs.FileSystemManager;
import com.tencent.mm.vfs.FileSystemManager.Editor;
import com.tencent.mm.vfs.MigrationFileSystem;
import com.tencent.mm.vfs.NativeFileSystem;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class bhgh
{
  private bhgf jdField_a_of_type_Bhgf = new bhgf();
  private String jdField_a_of_type_JavaLangString;
  private String b;
  
  public static bhgh a()
  {
    return bhgj.a;
  }
  
  private List<String> a(QQAppInterface paramQQAppInterface)
  {
    ArrayList localArrayList = new ArrayList();
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    localArrayList.add(anhk.ba + paramQQAppInterface + File.separator);
    return localArrayList;
  }
  
  private void a(String paramString)
  {
    File localFile1 = new File(paramString);
    if (localFile1.isDirectory())
    {
      paramString = new File(bhgg.a(paramString));
      File localFile2 = paramString.getParentFile();
      if ((localFile2 != null) && (!localFile2.exists())) {
        localFile2.mkdirs();
      }
      if ((localFile1.renameTo(paramString)) && (QLog.isColorLevel())) {
        QLog.i("VFSRegisterProxy", 2, "executeLightMigrate Fast moved '" + localFile1 + "' -> '" + paramString + "'");
      }
    }
  }
  
  private void a(boolean paramBoolean) {}
  
  private boolean a()
  {
    boolean bool = false;
    if (BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4).getInt("vfs_version", 0) < 10) {
      bool = true;
    }
    QLog.d("VFSRegisterProxy", 1, "initConfig checkSP is called, return val = " + bool);
    return bool;
  }
  
  private void b()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4).edit().putInt("vfs_version", 10).apply();
    QLog.d("VFSRegisterProxy", 1, "initConfig updateSP is called, version = 10");
  }
  
  private boolean b()
  {
    boolean bool = BaseApplicationImpl.sApplication.getSharedPreferences("VFS_Config_Register_Proxy", 4).getBoolean("state_account_registered", true);
    if (QLog.isColorLevel()) {
      QLog.d("VFSRegisterProxy", 2, "isFirstRegisterAccount is called, return val = " + bool);
    }
    return bool;
  }
  
  private void c()
  {
    BaseApplicationImpl.sApplication.getSharedPreferences("VFS_Config_Register_Proxy", 4).edit().putBoolean("state_account_registered", false).apply();
  }
  
  private void c(Context paramContext)
  {
    b(paramContext);
    FileSystemManager.Editor localEditor = FileSystemManager.instance().edit();
    localEditor.scheme("", FileSchemeResolver.instance());
    localEditor.scheme("file", FileSchemeResolver.instance());
    localEditor.scheme(null, FileSchemeResolver.instance());
    Iterator localIterator = bhgk.a.iterator();
    while (localIterator.hasNext())
    {
      String str1 = (String)localIterator.next();
      if (!TextUtils.isEmpty(str1))
      {
        if ((str1.startsWith("/")) || (str1.indexOf(":") > 0)) {}
        for (paramContext = str1;; paramContext = b() + File.separator + str1)
        {
          String str2 = bhgg.a(str1);
          Object localObject = new File(str2).getParentFile();
          if ((localObject != null) && (!((File)localObject).exists())) {
            ((File)localObject).mkdirs();
          }
          localObject = new MigrationFileSystem(true, new NativeFileSystem(str2, false), new FileSystem[] { new NativeFileSystem(paramContext, false) });
          if (QLog.isColorLevel()) {
            QLog.d("VFSRegisterProxy", 2, "initConfig filesystem key is " + str1);
          }
          localEditor.install(str1, (FileSystem)localObject).mount(str2, str1).mount(paramContext, str1);
          break;
        }
      }
    }
    localEditor.commit();
  }
  
  private void d()
  {
    for (;;)
    {
      try
      {
        File[] arrayOfFile = new File(anhk.ba).listFiles();
        if (arrayOfFile == null) {
          return;
        }
        int j = arrayOfFile.length;
        i = 0;
        if (i >= j) {
          break;
        }
        localFile = arrayOfFile[i];
        str = localFile.getName().trim();
        int k = str.length();
        if (k >= 5) {
          if (k <= 15) {
            continue;
          }
        }
      }
      catch (Exception localException)
      {
        try
        {
          int i;
          String str;
          Long.parseLong(str);
          File localFile = new File(localFile, "ppt");
          if (!localFile.exists()) {
            continue;
          }
          a(localFile.getAbsolutePath());
        }
        catch (NumberFormatException localNumberFormatException) {}
        localException = localException;
        localException.printStackTrace();
        return;
      }
      i += 1;
    }
  }
  
  @Nullable
  public final String a()
  {
    if (this.jdField_a_of_type_JavaLangString == null)
    {
      File localFile = BaseApplicationImpl.sApplication.getExternalCacheDir();
      if (localFile != null) {
        this.jdField_a_of_type_JavaLangString = localFile.getParent();
      }
    }
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a()
  {
    Iterator localIterator = bhgk.b.iterator();
    while (localIterator.hasNext()) {
      a((String)localIterator.next());
    }
  }
  
  public void a(Context paramContext)
  {
    b(paramContext);
    QLog.d("VFSRegisterProxy", 1, "initConfig start!");
    try
    {
      if (a())
      {
        c(paramContext);
        if (!FileSystemManager.instance().isValidConfigFile(paramContext)) {
          c(paramContext);
        }
        if (FileSystemManager.instance().isValidConfigFile(paramContext)) {
          b();
        }
        a();
        d();
      }
    }
    catch (Throwable paramContext)
    {
      for (;;)
      {
        this.jdField_a_of_type_Bhgf.reportError(new Throwable("FileSystemManager proxy", paramContext));
        QLog.e("VFSRegisterProxy", 1, paramContext, new Object[0]);
      }
    }
    QLog.d("VFSRegisterProxy", 1, "initConfig end!");
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if ((b()) && (paramQQAppInterface != null))
    {
      Object localObject = a(paramQQAppInterface);
      if (QLog.isColorLevel()) {
        QLog.d("VFSRegisterProxy", 2, "registerAccountPath is called later! account relate length = " + ((List)localObject).size());
      }
      paramQQAppInterface = FileSystemManager.instance().edit();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        String str2 = bhgg.a(str1);
        File localFile = new File(str2).getParentFile();
        if ((localFile != null) && (!localFile.exists())) {
          localFile.mkdirs();
        }
        paramQQAppInterface.install(str1, new MigrationFileSystem(true, new NativeFileSystem(str2, false), new FileSystem[] { new NativeFileSystem(str1, false) })).mount(str2, str1).mount(str1, str1);
      }
      paramQQAppInterface.commit();
      c();
    }
    this.jdField_a_of_type_Bhgf.a();
  }
  
  public final String b()
  {
    if (this.b == null) {
      this.b = Environment.getExternalStorageDirectory().getPath();
    }
    return this.b;
  }
  
  public void b(Context paramContext)
  {
    boolean bool = true;
    FileSystemManager.setContext(paramContext);
    if (BaseApplicationImpl.sProcessId == 1) {
      FileSystemManager.setStatisticsCallback(this.jdField_a_of_type_Bhgf);
    }
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      a(bool);
      return;
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhgh
 * JD-Core Version:    0.7.0.1
 */