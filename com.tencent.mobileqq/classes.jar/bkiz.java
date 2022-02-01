import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.open.base.MD5Utils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.LinkedList;

public class bkiz
{
  private static bkiz jdField_a_of_type_Bkiz;
  private aulv jdField_a_of_type_Aulv = new aulv("ilive");
  private bgog jdField_a_of_type_Bgog = new bgog(BaseApplicationImpl.getApplication().getRuntime());
  private bkiv jdField_a_of_type_Bkiv;
  private bkjb jdField_a_of_type_Bkjb;
  private bkji jdField_a_of_type_Bkji;
  private LinkedList<bgoe> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private boolean jdField_a_of_type_Boolean;
  private bkji b;
  
  private bgoj a()
  {
    return this.jdField_a_of_type_Bgog.a(2);
  }
  
  public static bkiz a()
  {
    if (jdField_a_of_type_Bkiz == null) {}
    try
    {
      if (jdField_a_of_type_Bkiz == null) {
        jdField_a_of_type_Bkiz = new bkiz();
      }
      return jdField_a_of_type_Bkiz;
    }
    finally {}
  }
  
  public static String a()
  {
    return BaseApplicationImpl.getContext().getFilesDir() + File.separator + "pddata" + File.separator + "vas" + File.separator + "qq_ilive";
  }
  
  private void a(bgoe parambgoe)
  {
    if (parambgoe == null) {}
    while (this.jdField_a_of_type_Bkiv == null) {
      return;
    }
    this.jdField_a_of_type_Bkiv.onFail(105, "plugin download fail , type = " + parambgoe.jdField_a_of_type_JavaLangString + " , msg = " + parambgoe.b + " , code = " + parambgoe.f + " , errorCode=" + parambgoe.jdField_a_of_type_Int);
  }
  
  private boolean c()
  {
    return (this.jdField_a_of_type_Bkji != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_Bkji.c()));
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
    {
      a((bgoe)this.jdField_a_of_type_JavaUtilLinkedList.get(0), this.jdField_a_of_type_Bkjb);
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
        if (this.jdField_a_of_type_Bkji != null) {
          break;
        }
      } while (this.jdField_a_of_type_Bkiv == null);
      this.jdField_a_of_type_Bkiv.onFail(104, "preload check config bean = null");
      return false;
    } while (!TextUtils.isEmpty(this.jdField_a_of_type_Bkji.b()));
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
    if (this.jdField_a_of_type_Bkiv == null) {
      return;
    }
    if (e())
    {
      g();
      j();
      h();
      f();
      this.jdField_a_of_type_Bkiv.onSuccess();
      return;
    }
    this.jdField_a_of_type_Bkiv.onFail(106, "file invalid , check file md5");
  }
  
  private boolean e()
  {
    boolean bool1 = true;
    boolean bool2 = true;
    if (this.jdField_a_of_type_Bkji == null) {
      return bool2;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_Bkji.b())) {}
    for (;;)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("IlivePluginDownloadManager", 2, "download success check file valid , isPluginValid = " + bool1);
      return bool1;
      if (!this.jdField_a_of_type_Bkji.b().equalsIgnoreCase(MD5Utils.encodeFileHexStr(e()))) {
        bool1 = false;
      }
    }
  }
  
  private void f()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    bkjc.a(BaseApplicationImpl.getContext());
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
    if ((this.jdField_a_of_type_Bkji == null) || (this.b == null)) {}
    File localFile;
    do
    {
      do
      {
        do
        {
          return;
        } while (TextUtils.isEmpty(this.b.c()));
        if (!this.b.c().equals(this.jdField_a_of_type_Bkji.c())) {
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
    if (this.jdField_a_of_type_Bkji == null) {
      return;
    }
    QLog.i("IlivePluginDownloadManager", 2, "saveConfigBean , config = " + this.jdField_a_of_type_Bkji.toString());
    bkjx.a(2, this.jdField_a_of_type_Bkji);
  }
  
  public aulv a()
  {
    return this.jdField_a_of_type_Aulv;
  }
  
  public bgoe a(File paramFile)
  {
    if (this.jdField_a_of_type_Bkji == null) {
      return null;
    }
    String str = this.jdField_a_of_type_Bkji.c();
    if (QLog.isColorLevel()) {
      QLog.i("IlivePluginDownloadManager", 2, "createDownloadTask url = " + str + " saveFile = " + paramFile.getAbsolutePath());
    }
    paramFile = new bgoe(str, paramFile);
    paramFile.e = true;
    paramFile.p = true;
    paramFile.r = true;
    paramFile.q = true;
    paramFile.j = true;
    paramFile.n = false;
    paramFile.s = false;
    return paramFile;
  }
  
  public bkji a()
  {
    return this.jdField_a_of_type_Bkji;
  }
  
  public void a()
  {
    QLog.e("IlivePluginDownloadManager", 1, "cancelDownloadFile size = " + this.jdField_a_of_type_JavaUtilLinkedList.size());
    a().a(true, null);
  }
  
  public void a(bgoe parambgoe, bgod parambgod)
  {
    if (parambgoe == null) {
      return;
    }
    a().a(parambgoe, parambgod, null);
  }
  
  public void a(bkiv parambkiv)
  {
    this.jdField_a_of_type_Bkiv = parambkiv;
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
  
  public bkji b()
  {
    return bkjx.a(2);
  }
  
  public String b()
  {
    return a() + File.separator + "ilive_plugin_v6.apk";
  }
  
  public void b()
  {
    this.jdField_a_of_type_Bkji = bkji.a();
    this.b = b();
    this.b.jdField_a_of_type_Boolean = this.jdField_a_of_type_Bkji.jdField_a_of_type_Boolean;
    if (this.jdField_a_of_type_Bkji != null) {
      QLog.e("IlivePluginDownloadManager", 1, "readIliveConfig , current config = " + this.jdField_a_of_type_Bkji.toString());
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
        achc.a(BaseApplicationImpl.getContext(), "live_shopping_manager.apk", b());
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
    if (this.jdField_a_of_type_Bkji != null) {
      return this.jdField_a_of_type_Bkji.a();
    }
    return "";
  }
  
  public void c()
  {
    if (!c()) {
      if (this.jdField_a_of_type_Bkiv != null) {
        this.jdField_a_of_type_Bkiv.onFail(103, "download fail , config data = null");
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
      } while (this.jdField_a_of_type_Bkiv == null);
      this.jdField_a_of_type_Bkiv.onSuccess();
      return;
      this.jdField_a_of_type_JavaUtilLinkedList.clear();
      if (d())
      {
        bgoe localbgoe = a(new File(e()));
        this.jdField_a_of_type_JavaUtilLinkedList.add(localbgoe);
      }
      QLog.e("IlivePluginDownloadManager", 1, "downloadFile count = " + this.jdField_a_of_type_JavaUtilLinkedList.size());
      if (this.jdField_a_of_type_JavaUtilLinkedList.size() > 0)
      {
        this.jdField_a_of_type_Bkjb = new bkjb(this, null);
        d();
        return;
      }
    } while (this.jdField_a_of_type_Bkiv == null);
    this.jdField_a_of_type_Bkiv.onSuccess();
  }
  
  public String d()
  {
    if (this.jdField_a_of_type_Bkji != null) {
      return this.jdField_a_of_type_Bkji.b();
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkiz
 * JD-Core Version:    0.7.0.1
 */