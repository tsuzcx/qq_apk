import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import cooperation.qzone.QzoneGiftFullScreenActionManager.1;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class bgzi
{
  public ascn a;
  public ascp a;
  public ascs a;
  public asde a;
  public asdp a;
  asdq jdField_a_of_type_Asdq;
  bgzj jdField_a_of_type_Bgzj;
  bgzk jdField_a_of_type_Bgzk;
  bgzl jdField_a_of_type_Bgzl;
  String jdField_a_of_type_JavaLangString;
  public List<ascn> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  public volatile boolean b = false;
  public volatile boolean c = false;
  
  public bgzi(bgzl parambgzl)
  {
    this.jdField_a_of_type_Ascp = null;
    this.jdField_a_of_type_Bgzl = parambgzl;
    this.jdField_a_of_type_Ascs = new ascs();
    this.jdField_a_of_type_Asdq = new asdq();
  }
  
  public static ascp a(String paramString1, String paramString2)
  {
    paramString1 = new asde(paramString2).a("receive.xml");
    if (paramString1 == null) {
      return null;
    }
    return new ascs().a(paramString1);
  }
  
  public static String a(String paramString)
  {
    String str = bhbp.e();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private List<ascn> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      ascn localascn;
      if (localIterator.hasNext())
      {
        localascn = (ascn)localIterator.next();
        if (localascn == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localascn.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          localArrayList.add(localascn);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localascn.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localascn);
      }
    }
  }
  
  private void a(ascp paramascp)
  {
    if (this.jdField_a_of_type_Bgzj != null) {
      this.jdField_a_of_type_Bgzj.a(paramascp);
    }
    if ((paramascp != null) && (paramascp.a != null)) {
      paramascp.a();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_a_of_type_Asdp.a();
    this.jdField_a_of_type_Asde = new asde(paramString);
    this.jdField_a_of_type_Asdp.a(this.jdField_a_of_type_Asde);
    this.jdField_a_of_type_Asdp.a(this.jdField_a_of_type_Asdq);
  }
  
  private int[] a(String paramString)
  {
    int j = 0;
    if (TextUtils.isEmpty(paramString)) {
      paramString = null;
    }
    int[] arrayOfInt;
    for (;;)
    {
      return paramString;
      arrayOfInt = new int[3];
      int i = 0;
      while (i < 3)
      {
        arrayOfInt[i] = 0;
        i += 1;
      }
      String[] arrayOfString = paramString.split("\\.");
      paramString = arrayOfInt;
      if (arrayOfString != null)
      {
        paramString = arrayOfInt;
        if (arrayOfString.length > 1)
        {
          i = j;
          paramString = arrayOfInt;
          try
          {
            if (i < arrayOfInt.length)
            {
              arrayOfInt[i] = Integer.valueOf(arrayOfString[i]).intValue();
              i += 1;
            }
          }
          catch (Throwable paramString)
          {
            paramString.printStackTrace();
          }
        }
      }
    }
    return arrayOfInt;
  }
  
  public static String b(String paramString)
  {
    String str = bhbp.f();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private void b()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Ascp == null) || ("non-ver".equals(this.jdField_a_of_type_Ascp.b)))
    {
      this.jdField_a_of_type_JavaUtilList = a(false);
      return;
    }
    int[] arrayOfInt1 = a("8.2.8");
    int[] arrayOfInt2 = a(this.jdField_a_of_type_Ascp.b);
    int i;
    if ((arrayOfInt1 != null) && (arrayOfInt2 != null) && (arrayOfInt1.length == arrayOfInt2.length))
    {
      i = 0;
      if (i < arrayOfInt2.length) {
        if (arrayOfInt1[i] > arrayOfInt2[i]) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (i == 0) {
        bool = true;
      }
      this.jdField_a_of_type_JavaUtilList = a(bool);
      return;
      if (arrayOfInt1[i] < arrayOfInt2[i])
      {
        i = 0;
      }
      else
      {
        i += 1;
        break;
        i = 1;
      }
    }
  }
  
  private void b(ascp paramascp)
  {
    if (this.jdField_a_of_type_Bgzk != null) {
      this.jdField_a_of_type_Bgzk.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bgzj != null) {
      this.jdField_a_of_type_Bgzj.b(paramascp);
    }
  }
  
  public void a()
  {
    this.c = true;
    if (this.jdField_a_of_type_Ascp != null) {
      this.jdField_a_of_type_Ascp.a(null);
    }
    if (this.jdField_a_of_type_Asdp != null)
    {
      this.jdField_a_of_type_Asdp.a(null);
      this.jdField_a_of_type_Asdp.c();
    }
    if (this.jdField_a_of_type_Asdq != null)
    {
      this.jdField_a_of_type_Asdq.a();
      this.jdField_a_of_type_Asdq = null;
    }
    this.jdField_a_of_type_Bgzl = null;
  }
  
  public void a(asdp paramasdp)
  {
    this.jdField_a_of_type_Asdp = paramasdp;
  }
  
  public void a(bgzj parambgzj)
  {
    this.jdField_a_of_type_Bgzj = parambgzj;
  }
  
  public void a(bgzk parambgzk)
  {
    if (parambgzk != null) {
      this.jdField_a_of_type_Bgzk = parambgzk;
    }
    this.b = true;
    if (this.jdField_a_of_type_Ascn != null) {
      this.jdField_a_of_type_Ascn.d();
    }
    if (this.jdField_a_of_type_Ascp != null) {
      this.jdField_a_of_type_Ascp.a(null);
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = paramString1;
    ThreadManager.post(new QzoneGiftFullScreenActionManager.1(this, paramString2), 8, null, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Ascp != null) {
      this.jdField_a_of_type_Ascp.d = true;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean b()
  {
    return BaseApplicationImpl.getApplication().getRuntime().getPreferences().getBoolean("receiveSound", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     bgzi
 * JD-Core Version:    0.7.0.1
 */