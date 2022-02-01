import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.LinkedList;

public class bmfc
{
  private static bmfc jdField_a_of_type_Bmfc;
  private avyv jdField_a_of_type_Avyv = new avyv("ilive");
  private bihw jdField_a_of_type_Bihw = new bihw(BaseApplicationImpl.getApplication().getRuntime());
  private bmey jdField_a_of_type_Bmey;
  private bmfe jdField_a_of_type_Bmfe;
  private bmfl jdField_a_of_type_Bmfl;
  private LinkedList<bihu> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private bmfl b;
  
  private bihz a()
  {
    return this.jdField_a_of_type_Bihw.a(2);
  }
  
  public static bmfc a()
  {
    if (jdField_a_of_type_Bmfc == null) {}
    try
    {
      if (jdField_a_of_type_Bmfc == null) {
        jdField_a_of_type_Bmfc = new bmfc();
      }
      return jdField_a_of_type_Bmfc;
    }
    finally {}
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata" + File.separator + "vas" + File.separator + "qq_ilive";
  }
  
  private void a(bihu parambihu)
  {
    if (parambihu == null) {}
    while (this.jdField_a_of_type_Bmey == null) {
      return;
    }
    this.jdField_a_of_type_Bmey.onFail(105, "plugin download fail , type = " + parambihu.jdField_a_of_type_JavaLangString + " , msg = " + parambihu.b + " , code = " + parambihu.f + " , errorCode=" + parambihu.jdField_a_of_type_Int);
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_Bmfl != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bmfl.c()));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      a((bihu)this.jdField_a_of_type_JavaUtilLinkedList.get(0), this.jdField_a_of_type_Bmfe);
      return;
    }
    QLog.e("IlivePluginDownloadManager", 1, "runTask finish");
  }
  
  private boolean d()
  {
    boolean bool = false;
    File localFile = new File(c());
    if (QLog.isColorLevel()) {
      QLog.i("IlivePluginDownloadManager", 2, "checkPluginFileIsNeedDownload  pluginFilePath = " + localFile.getAbsolutePath());
    }
    if (!localFile.exists()) {
      bool = true;
    }
    do
    {
      do
      {
        return bool;
        if (this.jdField_a_of_type_Bmfl != null) {
          break;
        }
      } while (this.jdField_a_of_type_Bmey == null);
      this.jdField_a_of_type_Bmey.onFail(104, "preload check config bean = null");
      return false;
    } while (!TextUtils.isEmpty(this.jdField_a_of_type_Bmfl.b()));
    return false;
  }
  
  private String e()
  {
    String str2 = c();
    String str1 = str2;
    if (this.jdField_a_of_type_Boolean) {
      str1 = str2 + ".tmp";
    }
    return str1;
  }
  
  private void e()
  {
    if (this.jdField_a_of_type_Bmey == null) {
      return;
    }
    if (e())
    {
      g();
      j();
      h();
      f();
      this.jdField_a_of_type_Bmey.onSuccess();
      return;
    }
    this.jdField_a_of_type_Bmey.onFail(106, "file invalid , check file md5");
  }
  
  private boolean e()
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (this.jdField_a_of_type_Bmfl == null) {
      return bool2;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Bmfl.b())) {}
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("IlivePluginDownloadManager", 2, "download success check file valid , isPluginValid = " + bool1);
      return bool1;
      if (!this.jdField_a_of_type_Bmfl.b().equalsIgnoreCase(bjtz.a(e()))) {
        bool1 = false;
      }
    }
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    bmff.a(BaseApplicationImpl.getContext());
  }
  
  private void g()
  {
    try
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      String str = e();
      File localFile1 = new File(str);
      File localFile2 = new File(c());
      if (localFile2.exists()) {
        localFile2.delete();
      }
      if (localFile1.exists()) {
        localFile1.renameTo(localFile2);
      }
      if (QLog.isColorLevel())
      {
        QLog.i("IlivePluginDownloadManager", 2, "download success copy file , downloadFile = " + str);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  private void h()
  {
    if (this.b == null) {
      return;
    }
    i();
  }
  
  private void i()
  {
    if ((this.jdField_a_of_type_Bmfl == null) || (this.b == null)) {}
    File localFile;
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(this.b.c()));
        if (!this.b.c().equals(this.jdField_a_of_type_Bmfl.c())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("IlivePluginDownloadManager", 2, "stop deletePluginFile file equal ");
      return;
      localFile = new File(this.b.a());
      if (QLog.isColorLevel()) {
        QLog.i("IlivePluginDownloadManager", 2, "deletePluginFile , pluginFile = " + this.b.a());
      }
    } while (!localFile.exists());
    localFile.delete();
  }
  
  private void j()
  {
    if (this.jdField_a_of_type_Bmfl == null) {
      return;
    }
    QLog.i("IlivePluginDownloadManager", 2, "saveConfigBean , config = " + this.jdField_a_of_type_Bmfl.toString());
    bmfq.a(2, this.jdField_a_of_type_Bmfl);
  }
  
  public avyv a()
  {
    return this.jdField_a_of_type_Avyv;
  }
  
  public bihu a(File paramFile)
  {
    if (this.jdField_a_of_type_Bmfl == null) {
      return null;
    }
    String str = this.jdField_a_of_type_Bmfl.c();
    if (QLog.isColorLevel()) {
      QLog.i("IlivePluginDownloadManager", 2, "createDownloadTask url = " + str + " saveFile = " + paramFile.getAbsolutePath());
    }
    paramFile = new bihu(str, paramFile);
    paramFile.e = true;
    paramFile.p = true;
    paramFile.r = true;
    paramFile.q = true;
    paramFile.j = true;
    paramFile.n = false;
    paramFile.s = false;
    return paramFile;
  }
  
  public bmfl a()
  {
    return this.jdField_a_of_type_Bmfl;
  }
  
  public void a()
  {
    QLog.e("IlivePluginDownloadManager", 1, "cancelDownloadFile size = " + this.jdField_a_of_type_JavaUtilLinkedList.size());
    a().a(true, null);
  }
  
  public void a(bihu parambihu, biht parambiht)
  {
    if (parambihu == null) {
      return;
    }
    a().a(parambihu, parambiht, null);
  }
  
  public void a(bmey parambmey)
  {
    this.jdField_a_of_type_Bmey = parambmey;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    c();
  }
  
  public boolean a()
  {
    new File("/data/local/tmp/plugin-debug.zip");
    return false;
  }
  
  public bmfl b()
  {
    return bmfq.a(2);
  }
  
  public String b()
  {
    return a() + File.separator + "ilive_plugin_v6.apk";
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bmfl = bmfl.a();
    this.b = b();
    this.b.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bmfl.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Bmfl != null) {
      QLog.e("IlivePluginDownloadManager", 1, "readIliveConfig , current config = " + this.jdField_a_of_type_Bmfl.toString());
    }
    if (this.b != null) {
      QLog.e("IlivePluginDownloadManager", 1, "readIliveConfig , last config = " + this.b.toString());
    }
  }
  
  public boolean b()
  {
    if (a()) {}
    for (;;)
    {
      return true;
      File localFile = new File(b());
      if (!localFile.exists())
      {
        QLog.e("IlivePluginDownloadManager", 1, "isPluginFileExist copy apkFile");
        adki.a(BaseApplicationImpl.getContext(), "live_shopping_manager.apk", b());
      }
      boolean bool = localFile.exists();
      if (!d()) {}
      for (int i = 1; (!bool) || (i == 0); i = 0) {
        return false;
      }
    }
  }
  
  public String c()
  {
    if (this.jdField_a_of_type_Bmfl != null) {
      return this.jdField_a_of_type_Bmfl.a();
    }
    return "";
  }
  
  public void c()
  {
    if (!c()) {
      if (this.jdField_a_of_type_Bmey != null) {
        this.jdField_a_of_type_Bmey.onFail(103, "download fail , config data = null");
      }
    }
    do
    {
      do
      {
        return;
        if (!a()) {
          break;
        }
      } while (this.jdField_a_of_type_Bmey == null);
      this.jdField_a_of_type_Bmey.onSuccess();
      return;
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      if (d())
      {
        bihu localbihu = a(new File(e()));
        this.jdField_a_of_type_JavaUtilLinkedList.add(localbihu);
      }
      QLog.e("IlivePluginDownloadManager", 1, "downloadFile count = " + this.jdField_a_of_type_JavaUtilLinkedList.size());
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
      {
        this.jdField_a_of_type_Bmfe = new bmfe(this, null);
        d();
        return;
      }
    } while (this.jdField_a_of_type_Bmey == null);
    this.jdField_a_of_type_Bmey.onSuccess();
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Bmfl != null) {
      return this.jdField_a_of_type_Bmfl.b();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmfc
 * JD-Core Version:    0.7.0.1
 */