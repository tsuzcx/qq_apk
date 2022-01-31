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

public class bfrb
{
  public argl a;
  public argn a;
  public argq a;
  public arhc a;
  public arhn a;
  arho jdField_a_of_type_Arho;
  bfrc jdField_a_of_type_Bfrc;
  bfrd jdField_a_of_type_Bfrd;
  bfre jdField_a_of_type_Bfre;
  String jdField_a_of_type_JavaLangString;
  public List<argl> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  public volatile boolean b = false;
  public volatile boolean c = false;
  
  public bfrb(bfre parambfre)
  {
    this.jdField_a_of_type_Argn = null;
    this.jdField_a_of_type_Bfre = parambfre;
    this.jdField_a_of_type_Argq = new argq();
    this.jdField_a_of_type_Arho = new arho();
  }
  
  public static argn a(String paramString1, String paramString2)
  {
    paramString1 = new arhc(paramString2).a("receive.xml");
    if (paramString1 == null) {
      return null;
    }
    return new argq().a(paramString1);
  }
  
  public static String a(String paramString)
  {
    String str = bftg.e();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private List<argl> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      argl localargl;
      if (localIterator.hasNext())
      {
        localargl = (argl)localIterator.next();
        if (localargl == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localargl.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          localArrayList.add(localargl);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localargl.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localargl);
      }
    }
  }
  
  private void a(argn paramargn)
  {
    if (this.jdField_a_of_type_Bfrc != null) {
      this.jdField_a_of_type_Bfrc.a(paramargn);
    }
    if ((paramargn != null) && (paramargn.a != null)) {
      paramargn.a();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_a_of_type_Arhn.a();
    this.jdField_a_of_type_Arhc = new arhc(paramString);
    this.jdField_a_of_type_Arhn.a(this.jdField_a_of_type_Arhc);
    this.jdField_a_of_type_Arhn.a(this.jdField_a_of_type_Arho);
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
    String str = bftg.f();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private void b()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Argn == null) || ("non-ver".equals(this.jdField_a_of_type_Argn.b)))
    {
      this.jdField_a_of_type_JavaUtilList = a(false);
      return;
    }
    int[] arrayOfInt1 = a("8.2.6");
    int[] arrayOfInt2 = a(this.jdField_a_of_type_Argn.b);
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
  
  private void b(argn paramargn)
  {
    if (this.jdField_a_of_type_Bfrd != null) {
      this.jdField_a_of_type_Bfrd.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bfrc != null) {
      this.jdField_a_of_type_Bfrc.b(paramargn);
    }
  }
  
  public void a()
  {
    this.c = true;
    if (this.jdField_a_of_type_Argn != null) {
      this.jdField_a_of_type_Argn.a(null);
    }
    if (this.jdField_a_of_type_Arhn != null)
    {
      this.jdField_a_of_type_Arhn.a(null);
      this.jdField_a_of_type_Arhn.c();
    }
    if (this.jdField_a_of_type_Arho != null)
    {
      this.jdField_a_of_type_Arho.a();
      this.jdField_a_of_type_Arho = null;
    }
    this.jdField_a_of_type_Bfre = null;
  }
  
  public void a(arhn paramarhn)
  {
    this.jdField_a_of_type_Arhn = paramarhn;
  }
  
  public void a(bfrc parambfrc)
  {
    this.jdField_a_of_type_Bfrc = parambfrc;
  }
  
  public void a(bfrd parambfrd)
  {
    if (parambfrd != null) {
      this.jdField_a_of_type_Bfrd = parambfrd;
    }
    this.b = true;
    if (this.jdField_a_of_type_Argl != null) {
      this.jdField_a_of_type_Argl.d();
    }
    if (this.jdField_a_of_type_Argn != null) {
      this.jdField_a_of_type_Argn.a(null);
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
    if (this.jdField_a_of_type_Argn != null) {
      this.jdField_a_of_type_Argn.d = true;
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
 * Qualified Name:     bfrb
 * JD-Core Version:    0.7.0.1
 */