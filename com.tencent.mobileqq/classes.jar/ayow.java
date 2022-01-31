import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class ayow
  extends aypb
{
  public static final boolean b;
  private static int jdField_c_of_type_Int;
  private static boolean jdField_c_of_type_Boolean;
  int a;
  protected long a;
  protected QQAppInterface a;
  protected String a;
  protected ArrayList<ayuq> a;
  protected boolean a;
  int jdField_b_of_type_Int = 0;
  protected long b;
  protected String b;
  ArrayList<auna> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
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
  
  public ayow()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = null;
  }
  
  public ayow(ayvx paramayvx, aywc paramaywc)
  {
    super(paramayvx, paramaywc);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    if ((paramaywc != null) && (paramaywc.a != null)) {}
    try
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramaywc.a);
      this.jdField_a_of_type_Ayug = aype.jdField_a_of_type_Ayug;
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
      return ayuk.a(paramString, str + "/");
      if (paramString.startsWith("https://")) {
        str = "https://" + this.jdField_b_of_type_JavaLangString;
      }
    }
  }
  
  public void a(auna paramauna)
  {
    try
    {
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramauna);
      }
      return;
    }
    finally {}
  }
  
  protected void a(aysz paramaysz, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    HashMap localHashMap = new HashMap();
    String str1;
    if ((this.jdField_a_of_type_Aysy != null) && ((this.jdField_a_of_type_Aysy instanceof ayrx)) && (((ayrx)this.jdField_a_of_type_Aysy).a != null)) {
      str1 = ((ayrx)this.jdField_a_of_type_Aysy).a;
    }
    try
    {
      URL localURL = new URL(str1);
      String str2 = localURL.getHost();
      int i = localURL.getPort();
      localHashMap.put("file_url", str1);
      localHashMap.put("http_errorCode", paramaysz.jdField_c_of_type_Int + "");
      localHashMap.put("md5", paramString2);
      localHashMap.put("uuid", paramString3);
      if (paramString4 != null) {
        localHashMap.put("business_type", paramString4);
      }
      a(paramBoolean, str2, String.valueOf(i), String.valueOf(paramaysz.jdField_b_of_type_Int), paramString1, localHashMap);
      return;
    }
    catch (Throwable paramaysz)
    {
      QLog.e("BaseTransProcessor", 1, "reportForServerMonitor err.", paramaysz);
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
          break label85;
        }
        paramString1 = a(str);
      }
    }
    label85:
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
  
  public void aR_()
  {
    try
    {
      if (this.jdField_a_of_type_Ayqo != null)
      {
        this.jdField_a_of_type_Ayqo.d = 2001;
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "start ");
        }
      }
      super.aR_();
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
  
  public void b(auna paramauna)
  {
    try
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramauna);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     ayow
 * JD-Core Version:    0.7.0.1
 */