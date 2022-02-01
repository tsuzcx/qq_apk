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

public class bltp
{
  public awfh a;
  public awfj a;
  public awfm a;
  public awfy a;
  public awgj a;
  awgk jdField_a_of_type_Awgk;
  bltq jdField_a_of_type_Bltq;
  bltr jdField_a_of_type_Bltr;
  blts jdField_a_of_type_Blts;
  String jdField_a_of_type_JavaLangString;
  public List<awfh> a;
  volatile boolean jdField_a_of_type_Boolean = false;
  public volatile boolean b = false;
  public volatile boolean c = false;
  
  public bltp(blts paramblts)
  {
    this.jdField_a_of_type_Awfj = null;
    this.jdField_a_of_type_Blts = paramblts;
    this.jdField_a_of_type_Awfm = new awfm();
    this.jdField_a_of_type_Awgk = new awgk();
  }
  
  public static awfj a(String paramString1, String paramString2)
  {
    paramString1 = new awfy(paramString2).a("receive.xml");
    if (paramString1 == null) {
      return null;
    }
    return new awfm().a(paramString1);
  }
  
  public static String a(String paramString)
  {
    String str = blwf.e();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private List<awfh> a(boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      awfh localawfh;
      if (localIterator.hasNext())
      {
        localawfh = (awfh)localIterator.next();
        if (localawfh == null) {
          continue;
        }
        if (paramBoolean)
        {
          if (!"default".equals(localawfh.jdField_a_of_type_JavaLangString)) {
            continue;
          }
          localArrayList.add(localawfh);
        }
      }
      else
      {
        return localArrayList;
      }
      if (!"default".equals(localawfh.jdField_a_of_type_JavaLangString)) {
        localArrayList.add(localawfh);
      }
    }
  }
  
  private void a(awfj paramawfj)
  {
    if (this.jdField_a_of_type_Bltq != null) {
      this.jdField_a_of_type_Bltq.a(paramawfj);
    }
    if ((paramawfj != null) && (paramawfj.a != null)) {
      paramawfj.a();
    }
  }
  
  private void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = true;
    this.b = false;
    this.jdField_a_of_type_Awgj.a();
    this.jdField_a_of_type_Awfy = new awfy(paramString);
    this.jdField_a_of_type_Awgj.a(this.jdField_a_of_type_Awfy);
    this.jdField_a_of_type_Awgj.a(this.jdField_a_of_type_Awgk);
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
    String str = blwf.f();
    File localFile = new File(str);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    return str + File.separator + paramString + File.separator;
  }
  
  private void b()
  {
    boolean bool = false;
    if ((this.jdField_a_of_type_Awfj == null) || ("non-ver".equals(this.jdField_a_of_type_Awfj.b)))
    {
      this.jdField_a_of_type_JavaUtilList = a(false);
      return;
    }
    int[] arrayOfInt1 = a("8.4.1");
    int[] arrayOfInt2 = a(this.jdField_a_of_type_Awfj.b);
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
  
  private void b(awfj paramawfj)
  {
    if (this.jdField_a_of_type_Bltr != null) {
      this.jdField_a_of_type_Bltr.a();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_Bltq != null) {
      this.jdField_a_of_type_Bltq.b(paramawfj);
    }
  }
  
  public void a()
  {
    this.c = true;
    if (this.jdField_a_of_type_Awfj != null) {
      this.jdField_a_of_type_Awfj.a(null);
    }
    if (this.jdField_a_of_type_Awgj != null)
    {
      this.jdField_a_of_type_Awgj.a(null);
      this.jdField_a_of_type_Awgj.c();
    }
    if (this.jdField_a_of_type_Awgk != null)
    {
      this.jdField_a_of_type_Awgk.a();
      this.jdField_a_of_type_Awgk = null;
    }
    this.jdField_a_of_type_Blts = null;
  }
  
  public void a(awgj paramawgj)
  {
    this.jdField_a_of_type_Awgj = paramawgj;
  }
  
  public void a(bltq parambltq)
  {
    this.jdField_a_of_type_Bltq = parambltq;
  }
  
  public void a(bltr parambltr)
  {
    if (parambltr != null) {
      this.jdField_a_of_type_Bltr = parambltr;
    }
    this.b = true;
    if (this.jdField_a_of_type_Awfh != null) {
      this.jdField_a_of_type_Awfh.d();
    }
    if (this.jdField_a_of_type_Awfj != null) {
      this.jdField_a_of_type_Awfj.a(null);
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
    if (this.jdField_a_of_type_Awfj != null) {
      this.jdField_a_of_type_Awfj.d = true;
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
 * Qualified Name:     bltp
 * JD-Core Version:    0.7.0.1
 */