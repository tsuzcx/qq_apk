import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class bara
  extends barf
{
  public static final boolean b;
  private static int jdField_c_of_type_Int;
  private static boolean jdField_c_of_type_Boolean;
  int a;
  protected long a;
  protected QQAppInterface a;
  protected String a;
  protected ArrayList<bawy> a;
  protected boolean a;
  int jdField_b_of_type_Int = 0;
  protected long b;
  protected String b;
  ArrayList<awiq> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected String c;
  protected String d = null;
  
  static
  {
    boolean bool = true;
    jdField_c_of_type_Int = 80;
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      jdField_b_of_type_Boolean = bool;
      return;
      bool = false;
    }
  }
  
  public bara()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = null;
  }
  
  public bara(bayf parambayf, bayk parambayk)
  {
    super(parambayf, parambayk);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    if ((parambayk != null) && (parambayk.a != null)) {}
    try
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(parambayk.a);
      this.jdField_a_of_type_Bawo = bari.jdField_a_of_type_Bawo;
      return;
    }
    finally {}
  }
  
  public static byte[] a(String paramString)
  {
    if (paramString.length() % 2 != 0) {}
    do
    {
      return null;
      try
      {
        byte[] arrayOfByte = new byte[paramString.length() / 2];
        paramString = paramString.toCharArray();
        int i = 0;
        while (i < paramString.length)
        {
          StringBuilder localStringBuilder = new StringBuilder(2);
          localStringBuilder.append(paramString[i]).append(paramString[(i + 1)]);
          arrayOfByte[(i / 2)] = ((byte)Integer.parseInt(localStringBuilder.toString(), 16));
          i += 2;
        }
        return arrayOfByte;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("PIC_TAG", 2, "bytesFromHexString Exception=" + paramString.getMessage());
    return null;
  }
  
  public static int d()
  {
    if (!jdField_c_of_type_Boolean) {}
    try
    {
      Object localObject = DeviceProfileManager.a().a(DeviceProfileManager.DpcNames.aio_config.name(), "");
      if (QLog.isColorLevel()) {
        QLog.d("BaseTransProcessor", 2, "getPicDownloadPort:" + (String)localObject);
      }
      localObject = ((String)localObject).split("\\|");
      if (localObject.length > 9) {
        jdField_c_of_type_Int = Integer.valueOf(localObject[9]).intValue();
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("BaseTransProcessor", 2, "getPicDownloadPort e:" + localException.toString());
        }
      }
    }
    jdField_c_of_type_Boolean = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "getPicDownloadPort return " + jdField_c_of_type_Int);
    }
    return jdField_c_of_type_Int;
  }
  
  public String a(String paramString)
  {
    String str = null;
    if (paramString.startsWith("http://")) {
      str = "http://" + this.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      return baws.a(paramString, str + "/");
      if (paramString.startsWith("https://")) {
        str = "https://" + this.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  protected ArrayList<bawy> a(ArrayList<bawy> paramArrayList1, ArrayList<bawy> paramArrayList2)
  {
    return bauj.a(paramArrayList1, paramArrayList2);
  }
  
  public void a(awiq paramawiq)
  {
    try
    {
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramawiq);
      }
      return;
    }
    finally {}
  }
  
  protected void a(bavf parambavf, boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Bave != null) && ((this.jdField_a_of_type_Bave instanceof baub)) && (((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString != null))
    {
      localObject = ((baub)this.jdField_a_of_type_Bave).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bawi.h = ((String)localObject);
    }
    try
    {
      localObject = new URL((String)localObject);
      String str = ((URL)localObject).getHost();
      int i = ((URL)localObject).getPort();
      this.jdField_a_of_type_Bawi.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Bawi.jdField_b_of_type_JavaLangString = String.valueOf(i);
      this.jdField_a_of_type_Bawi.i = (parambavf.jdField_c_of_type_Int + "");
      this.jdField_a_of_type_Bawi.j = this.jdField_a_of_type_Bayk.f;
      this.jdField_a_of_type_Bawi.k = paramString2;
      this.jdField_a_of_type_Bawi.jdField_c_of_type_JavaLangString = String.valueOf(parambavf.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bawi.e = parambavf.jdField_a_of_type_JavaLangString;
      if (parambavf.jdField_b_of_type_Int == -9527) {}
      for (parambavf = (String)parambavf.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");; parambavf = null)
      {
        this.jdField_a_of_type_Bawi.d = parambavf;
        a(paramString1, paramBoolean);
        return;
      }
      return;
    }
    catch (Throwable parambavf)
    {
      QLog.e("BaseTransProcessor", 1, "reportForServerMonitor err.", parambavf);
    }
  }
  
  protected byte[] a(String paramString1, String paramString2)
  {
    String str = null;
    Object localObject = str;
    if (paramString1 != null)
    {
      localObject = str;
      if (paramString1.length() == 32) {
        localObject = a(paramString1);
      }
    }
    paramString1 = (String)localObject;
    if (localObject == null)
    {
      paramString1 = (String)localObject;
      if (paramString2 != null)
      {
        int i = paramString2.indexOf(".");
        str = paramString2;
        if (i > 0) {
          str = paramString2.substring(0, i);
        }
        if (str.length() != 32) {
          break label86;
        }
        paramString1 = a(str);
      }
    }
    label86:
    do
    {
      do
      {
        do
        {
          return paramString1;
          if (str.length() != 38) {
            break;
          }
          paramString2 = str.substring(1, 37).replace("-", "");
          paramString1 = (String)localObject;
        } while (paramString2.length() != 32);
        return a(paramString2);
        paramString1 = (String)localObject;
      } while (str.length() != 34);
      paramString2 = str.substring(1, 33);
      paramString1 = (String)localObject;
    } while (paramString2.length() != 32);
    return a(paramString2);
  }
  
  public void aP_()
  {
    try
    {
      if (this.jdField_a_of_type_Bass != null)
      {
        this.jdField_a_of_type_Bass.d = 2001;
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "start ");
        }
      }
      super.aP_();
      return;
    }
    finally {}
  }
  
  public void b()
  {
    b(9366, "transfileController destroy");
    d();
    if (QLog.isColorLevel()) {
      QLog.d("PIC_TAG", 2, "accountChanged transfileController destroy");
    }
    super.b();
  }
  
  public void b(awiq paramawiq)
  {
    try
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramawiq);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bara
 * JD-Core Version:    0.7.0.1
 */