import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.messageclean.FileCleanManager.1;
import com.tencent.mobileqq.app.message.messageclean.FileCleanManager.2;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import mqq.os.MqqHandler;

public class amhr
{
  private int jdField_a_of_type_Int;
  private amhu jdField_a_of_type_Amhu;
  private String jdField_a_of_type_JavaLangString;
  private ConcurrentHashMap<String, amht> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  private volatile boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private String jdField_c_of_type_JavaLangString;
  
  public amhr(amhu paramamhu)
  {
    this.jdField_a_of_type_Amhu = paramamhu;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 1: 
      return this.jdField_a_of_type_Int;
    case 2: 
      return this.jdField_b_of_type_Int;
    }
    return this.jdField_c_of_type_Int;
  }
  
  private String a()
  {
    return bayb.a(bame.jdField_a_of_type_JavaLangString);
  }
  
  private String a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return "";
    case 1: 
      return this.jdField_a_of_type_JavaLangString;
    case 2: 
      return this.jdField_b_of_type_JavaLangString;
    }
    return this.jdField_c_of_type_JavaLangString;
  }
  
  private void a(String paramString, int paramInt)
  {
    paramString = new File(paramString);
    File[] arrayOfFile;
    if (paramString.exists())
    {
      arrayOfFile = paramString.listFiles();
      if ((arrayOfFile != null) && (arrayOfFile.length != 0)) {
        break label34;
      }
    }
    label34:
    File localFile;
    for (;;)
    {
      return;
      int j = arrayOfFile.length;
      int i = 0;
      while (i < j)
      {
        localFile = arrayOfFile[i];
        if (!localFile.isDirectory()) {
          break label78;
        }
        a(localFile.getAbsolutePath(), paramInt);
        label71:
        i += 1;
      }
    }
    label78:
    int k = a(paramInt);
    paramString = localFile.getAbsolutePath();
    int m = paramString.length();
    amht localamht = new amht();
    if (m > k) {}
    for (paramString = paramString.substring(k, m);; paramString = "")
    {
      localamht.jdField_a_of_type_JavaLangString = paramString;
      localamht.jdField_a_of_type_Long = localFile.length();
      localamht.jdField_a_of_type_Int = paramInt;
      localamht.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap == null) {
        break;
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localFile.getName(), localamht);
      break label71;
    }
  }
  
  private String b()
  {
    return ShortVideoUtils.b();
  }
  
  private String c()
  {
    return aljq.bm;
  }
  
  private void c()
  {
    if ((this.jdField_a_of_type_Amhu != null) && (a()))
    {
      this.jdField_a_of_type_Amhu.a();
      if (QLog.isColorLevel()) {
        QLog.e("FileCleanManager", 2, "fileScanNotify onScanFinish");
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_JavaLangString = a();
    this.jdField_b_of_type_JavaLangString = b();
    this.jdField_c_of_type_JavaLangString = c();
    this.jdField_a_of_type_Int = this.jdField_a_of_type_JavaLangString.length();
    this.jdField_b_of_type_Int = this.jdField_b_of_type_JavaLangString.length();
    this.jdField_c_of_type_Int = this.jdField_c_of_type_JavaLangString.length();
  }
  
  private void e()
  {
    a(this.jdField_a_of_type_JavaLangString, 1);
  }
  
  private void f()
  {
    a(this.jdField_b_of_type_JavaLangString, 2);
  }
  
  private void g()
  {
    a(this.jdField_c_of_type_JavaLangString, 3);
  }
  
  private void h()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)
    {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = null;
    }
  }
  
  public String a(amht paramamht)
  {
    if (paramamht == null) {
      return "";
    }
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append(a(paramamht.jdField_a_of_type_Int));
    localStringBuffer.append(paramamht.jdField_a_of_type_JavaLangString);
    return localStringBuffer.toString();
  }
  
  public ConcurrentHashMap<String, amht> a()
  {
    return this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap;
  }
  
  public void a()
  {
    h();
    this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
    d();
    ThreadManager.getFileThreadHandler().post(new FileCleanManager.1(this));
    ThreadManager.getFileThreadHandler().post(new FileCleanManager.2(this));
  }
  
  public void a(String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(paramString);
    }
  }
  
  public void a(String paramString, amht paramamht)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramamht != null) && (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null)) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, paramamht);
    }
  }
  
  public void a(List<String> paramList)
  {
    if ((paramList == null) || (paramList.isEmpty())) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        bdcs.d((String)paramList.next());
      }
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean);
  }
  
  public void b()
  {
    h();
    this.jdField_a_of_type_Amhu = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amhr
 * JD-Core Version:    0.7.0.1
 */