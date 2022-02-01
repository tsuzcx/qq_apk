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

public class bmur
{
  public awxz a;
  public awyb a;
  public awye a;
  public awyq a;
  public awzb a;
  awzc jdField_a_of_type_Awzc;
  bmus jdField_a_of_type_Bmus;
  bmut jdField_a_of_type_Bmut;
  bmuu jdField_a_of_type_Bmuu;
  String jdField_a_of_type_JavaLangString;
  public List<awxz> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  public volatile boolean b = false;
  public volatile boolean c = false;
  
  public bmur(bmuu parambmuu)
  {
    this.jdField_a_of_type_Awyb = null;
    this.jdField_a_of_type_Bmuu = parambmuu;
    this.jdField_a_of_type_Awye = new awye();
    this.jdField_a_of_type_Awzc = new awzc();
  }
  
  public static awyb a(String paramString1, String paramString2)
  {
    paramString1 = new awyq(paramString2).a("receive.xml");
    if (paramString1 == null) {
      return null;
    }
    return new awye().a(paramString1);
  }
  
  public static String a(String paramString)
  {
    String str = bmxh.e();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private List<awxz> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      awxz localawxz;
      if (localIterator.hasNext())
      {
        localawxz = (awxz)localIterator.next();
        if (localawxz == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localawxz.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          localArrayList.add(localawxz);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localawxz.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localawxz);
      }
    }
  }
  
  private void a(awyb paramawyb)
  {
    if (this.jdField_a_of_type_Bmus != null) {
      this.jdField_a_of_type_Bmus.a(paramawyb);
    }
    if ((paramawyb != null) && (paramawyb.a != null)) {
      paramawyb.a();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_a_of_type_Awzb.a();
    this.jdField_a_of_type_Awyq = new awyq(paramString);
    this.jdField_a_of_type_Awzb.a(this.jdField_a_of_type_Awyq);
    this.jdField_a_of_type_Awzb.a(this.jdField_a_of_type_Awzc);
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
    String str = bmxh.f();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private void b()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Awyb == null) || ("non-ver".equals(this.jdField_a_of_type_Awyb.b)))
    {
      this.jdField_a_of_type_JavaUtilList = a(false);
      return;
    }
    int[] arrayOfInt1 = a("8.4.5");
    int[] arrayOfInt2 = a(this.jdField_a_of_type_Awyb.b);
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
  
  private void b(awyb paramawyb)
  {
    if (this.jdField_a_of_type_Bmut != null) {
      this.jdField_a_of_type_Bmut.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bmus != null) {
      this.jdField_a_of_type_Bmus.b(paramawyb);
    }
  }
  
  public void a()
  {
    this.c = true;
    if (this.jdField_a_of_type_Awyb != null) {
      this.jdField_a_of_type_Awyb.a(null);
    }
    if (this.jdField_a_of_type_Awzb != null)
    {
      this.jdField_a_of_type_Awzb.a(null);
      this.jdField_a_of_type_Awzb.c();
    }
    if (this.jdField_a_of_type_Awzc != null)
    {
      this.jdField_a_of_type_Awzc.a();
      this.jdField_a_of_type_Awzc = null;
    }
    this.jdField_a_of_type_Bmuu = null;
  }
  
  public void a(awzb paramawzb)
  {
    this.jdField_a_of_type_Awzb = paramawzb;
  }
  
  public void a(bmus parambmus)
  {
    this.jdField_a_of_type_Bmus = parambmus;
  }
  
  public void a(bmut parambmut)
  {
    if (parambmut != null) {
      this.jdField_a_of_type_Bmut = parambmut;
    }
    this.b = true;
    if (this.jdField_a_of_type_Awxz != null) {
      this.jdField_a_of_type_Awxz.d();
    }
    if (this.jdField_a_of_type_Awyb != null) {
      this.jdField_a_of_type_Awyb.a(null);
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
    if (this.jdField_a_of_type_Awyb != null) {
      this.jdField_a_of_type_Awyb.d = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bmur
 * JD-Core Version:    0.7.0.1
 */