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

public class bjbc
{
  public attp a;
  public attr a;
  public attu a;
  public atug a;
  public atur a;
  atus jdField_a_of_type_Atus;
  bjbd jdField_a_of_type_Bjbd;
  bjbe jdField_a_of_type_Bjbe;
  bjbf jdField_a_of_type_Bjbf;
  String jdField_a_of_type_JavaLangString;
  public List<attp> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  public volatile boolean b = false;
  public volatile boolean c = false;
  
  public bjbc(bjbf parambjbf)
  {
    this.jdField_a_of_type_Attr = null;
    this.jdField_a_of_type_Bjbf = parambjbf;
    this.jdField_a_of_type_Attu = new attu();
    this.jdField_a_of_type_Atus = new atus();
  }
  
  public static attr a(String paramString1, String paramString2)
  {
    paramString1 = new atug(paramString2).a("receive.xml");
    if (paramString1 == null) {
      return null;
    }
    return new attu().a(paramString1);
  }
  
  public static String a(String paramString)
  {
    String str = bjdq.e();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private List<attp> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      attp localattp;
      if (localIterator.hasNext())
      {
        localattp = (attp)localIterator.next();
        if (localattp == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localattp.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          localArrayList.add(localattp);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localattp.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localattp);
      }
    }
  }
  
  private void a(attr paramattr)
  {
    if (this.jdField_a_of_type_Bjbd != null) {
      this.jdField_a_of_type_Bjbd.a(paramattr);
    }
    if ((paramattr != null) && (paramattr.a != null)) {
      paramattr.a();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_a_of_type_Atur.a();
    this.jdField_a_of_type_Atug = new atug(paramString);
    this.jdField_a_of_type_Atur.a(this.jdField_a_of_type_Atug);
    this.jdField_a_of_type_Atur.a(this.jdField_a_of_type_Atus);
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
    String str = bjdq.f();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private void b()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Attr == null) || ("non-ver".equals(this.jdField_a_of_type_Attr.b)))
    {
      this.jdField_a_of_type_JavaUtilList = a(false);
      return;
    }
    int[] arrayOfInt1 = a("8.3.3");
    int[] arrayOfInt2 = a(this.jdField_a_of_type_Attr.b);
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
  
  private void b(attr paramattr)
  {
    if (this.jdField_a_of_type_Bjbe != null) {
      this.jdField_a_of_type_Bjbe.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bjbd != null) {
      this.jdField_a_of_type_Bjbd.b(paramattr);
    }
  }
  
  public void a()
  {
    this.c = true;
    if (this.jdField_a_of_type_Attr != null) {
      this.jdField_a_of_type_Attr.a(null);
    }
    if (this.jdField_a_of_type_Atur != null)
    {
      this.jdField_a_of_type_Atur.a(null);
      this.jdField_a_of_type_Atur.c();
    }
    if (this.jdField_a_of_type_Atus != null)
    {
      this.jdField_a_of_type_Atus.a();
      this.jdField_a_of_type_Atus = null;
    }
    this.jdField_a_of_type_Bjbf = null;
  }
  
  public void a(atur paramatur)
  {
    this.jdField_a_of_type_Atur = paramatur;
  }
  
  public void a(bjbd parambjbd)
  {
    this.jdField_a_of_type_Bjbd = parambjbd;
  }
  
  public void a(bjbe parambjbe)
  {
    if (parambjbe != null) {
      this.jdField_a_of_type_Bjbe = parambjbe;
    }
    this.b = true;
    if (this.jdField_a_of_type_Attp != null) {
      this.jdField_a_of_type_Attp.d();
    }
    if (this.jdField_a_of_type_Attr != null) {
      this.jdField_a_of_type_Attr.a(null);
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
    if (this.jdField_a_of_type_Attr != null) {
      this.jdField_a_of_type_Attr.d = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjbc
 * JD-Core Version:    0.7.0.1
 */