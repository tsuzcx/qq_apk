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

public class bjfj
{
  public atxy a;
  public atya a;
  public atyd a;
  public atyp a;
  public atza a;
  atzb jdField_a_of_type_Atzb;
  bjfk jdField_a_of_type_Bjfk;
  bjfl jdField_a_of_type_Bjfl;
  bjfm jdField_a_of_type_Bjfm;
  String jdField_a_of_type_JavaLangString;
  public List<atxy> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  public volatile boolean b = false;
  public volatile boolean c = false;
  
  public bjfj(bjfm parambjfm)
  {
    this.jdField_a_of_type_Atya = null;
    this.jdField_a_of_type_Bjfm = parambjfm;
    this.jdField_a_of_type_Atyd = new atyd();
    this.jdField_a_of_type_Atzb = new atzb();
  }
  
  public static atya a(String paramString1, String paramString2)
  {
    paramString1 = new atyp(paramString2).a("receive.xml");
    if (paramString1 == null) {
      return null;
    }
    return new atyd().a(paramString1);
  }
  
  public static String a(String paramString)
  {
    String str = bjhx.e();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private List<atxy> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      atxy localatxy;
      if (localIterator.hasNext())
      {
        localatxy = (atxy)localIterator.next();
        if (localatxy == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localatxy.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          localArrayList.add(localatxy);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localatxy.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localatxy);
      }
    }
  }
  
  private void a(atya paramatya)
  {
    if (this.jdField_a_of_type_Bjfk != null) {
      this.jdField_a_of_type_Bjfk.a(paramatya);
    }
    if ((paramatya != null) && (paramatya.a != null)) {
      paramatya.a();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_a_of_type_Atza.a();
    this.jdField_a_of_type_Atyp = new atyp(paramString);
    this.jdField_a_of_type_Atza.a(this.jdField_a_of_type_Atyp);
    this.jdField_a_of_type_Atza.a(this.jdField_a_of_type_Atzb);
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
    String str = bjhx.f();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private void b()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Atya == null) || ("non-ver".equals(this.jdField_a_of_type_Atya.b)))
    {
      this.jdField_a_of_type_JavaUtilList = a(false);
      return;
    }
    int[] arrayOfInt1 = a("8.3.5");
    int[] arrayOfInt2 = a(this.jdField_a_of_type_Atya.b);
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
  
  private void b(atya paramatya)
  {
    if (this.jdField_a_of_type_Bjfl != null) {
      this.jdField_a_of_type_Bjfl.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bjfk != null) {
      this.jdField_a_of_type_Bjfk.b(paramatya);
    }
  }
  
  public void a()
  {
    this.c = true;
    if (this.jdField_a_of_type_Atya != null) {
      this.jdField_a_of_type_Atya.a(null);
    }
    if (this.jdField_a_of_type_Atza != null)
    {
      this.jdField_a_of_type_Atza.a(null);
      this.jdField_a_of_type_Atza.c();
    }
    if (this.jdField_a_of_type_Atzb != null)
    {
      this.jdField_a_of_type_Atzb.a();
      this.jdField_a_of_type_Atzb = null;
    }
    this.jdField_a_of_type_Bjfm = null;
  }
  
  public void a(atza paramatza)
  {
    this.jdField_a_of_type_Atza = paramatza;
  }
  
  public void a(bjfk parambjfk)
  {
    this.jdField_a_of_type_Bjfk = parambjfk;
  }
  
  public void a(bjfl parambjfl)
  {
    if (parambjfl != null) {
      this.jdField_a_of_type_Bjfl = parambjfl;
    }
    this.b = true;
    if (this.jdField_a_of_type_Atxy != null) {
      this.jdField_a_of_type_Atxy.d();
    }
    if (this.jdField_a_of_type_Atya != null) {
      this.jdField_a_of_type_Atya.a(null);
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
    if (this.jdField_a_of_type_Atya != null) {
      this.jdField_a_of_type_Atya.d = true;
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
 * Qualified Name:     bjfj
 * JD-Core Version:    0.7.0.1
 */