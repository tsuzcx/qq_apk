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

public class bgzz
{
  public ascp a;
  public ascr a;
  public ascu a;
  public asdg a;
  public asdr a;
  asds jdField_a_of_type_Asds;
  bhaa jdField_a_of_type_Bhaa;
  bhab jdField_a_of_type_Bhab;
  bhac jdField_a_of_type_Bhac;
  String jdField_a_of_type_JavaLangString;
  public List<ascp> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  public volatile boolean b = false;
  public volatile boolean c = false;
  
  public bgzz(bhac parambhac)
  {
    this.jdField_a_of_type_Ascr = null;
    this.jdField_a_of_type_Bhac = parambhac;
    this.jdField_a_of_type_Ascu = new ascu();
    this.jdField_a_of_type_Asds = new asds();
  }
  
  public static ascr a(String paramString1, String paramString2)
  {
    paramString1 = new asdg(paramString2).a("receive.xml");
    if (paramString1 == null) {
      return null;
    }
    return new ascu().a(paramString1);
  }
  
  public static String a(String paramString)
  {
    String str = bhcg.e();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private List<ascp> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      ascp localascp;
      if (localIterator.hasNext())
      {
        localascp = (ascp)localIterator.next();
        if (localascp == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localascp.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          localArrayList.add(localascp);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localascp.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localascp);
      }
    }
  }
  
  private void a(ascr paramascr)
  {
    if (this.jdField_a_of_type_Bhaa != null) {
      this.jdField_a_of_type_Bhaa.a(paramascr);
    }
    if ((paramascr != null) && (paramascr.a != null)) {
      paramascr.a();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_a_of_type_Asdr.a();
    this.jdField_a_of_type_Asdg = new asdg(paramString);
    this.jdField_a_of_type_Asdr.a(this.jdField_a_of_type_Asdg);
    this.jdField_a_of_type_Asdr.a(this.jdField_a_of_type_Asds);
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
    String str = bhcg.f();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private void b()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Ascr == null) || ("non-ver".equals(this.jdField_a_of_type_Ascr.b)))
    {
      this.jdField_a_of_type_JavaUtilList = a(false);
      return;
    }
    int[] arrayOfInt1 = a("8.3.0");
    int[] arrayOfInt2 = a(this.jdField_a_of_type_Ascr.b);
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
  
  private void b(ascr paramascr)
  {
    if (this.jdField_a_of_type_Bhab != null) {
      this.jdField_a_of_type_Bhab.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bhaa != null) {
      this.jdField_a_of_type_Bhaa.b(paramascr);
    }
  }
  
  public void a()
  {
    this.c = true;
    if (this.jdField_a_of_type_Ascr != null) {
      this.jdField_a_of_type_Ascr.a(null);
    }
    if (this.jdField_a_of_type_Asdr != null)
    {
      this.jdField_a_of_type_Asdr.a(null);
      this.jdField_a_of_type_Asdr.c();
    }
    if (this.jdField_a_of_type_Asds != null)
    {
      this.jdField_a_of_type_Asds.a();
      this.jdField_a_of_type_Asds = null;
    }
    this.jdField_a_of_type_Bhac = null;
  }
  
  public void a(asdr paramasdr)
  {
    this.jdField_a_of_type_Asdr = paramasdr;
  }
  
  public void a(bhaa parambhaa)
  {
    this.jdField_a_of_type_Bhaa = parambhaa;
  }
  
  public void a(bhab parambhab)
  {
    if (parambhab != null) {
      this.jdField_a_of_type_Bhab = parambhab;
    }
    this.b = true;
    if (this.jdField_a_of_type_Ascp != null) {
      this.jdField_a_of_type_Ascp.d();
    }
    if (this.jdField_a_of_type_Ascr != null) {
      this.jdField_a_of_type_Ascr.a(null);
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
    if (this.jdField_a_of_type_Ascr != null) {
      this.jdField_a_of_type_Ascr.d = true;
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
 * Qualified Name:     bgzz
 * JD-Core Version:    0.7.0.1
 */