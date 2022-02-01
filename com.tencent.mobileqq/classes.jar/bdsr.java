import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class bdsr
  extends bdsx
{
  public static final boolean b;
  private static int c;
  private static boolean f;
  int a;
  protected long a;
  protected QQAppInterface a;
  protected String a;
  protected ArrayList<bdyf> a;
  protected boolean a;
  int jdField_b_of_type_Int = 0;
  protected long b;
  protected String b;
  ArrayList<ayxc> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected String c;
  public boolean c;
  protected String d;
  public boolean d;
  protected boolean e;
  
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
  
  public bdsr()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
  }
  
  public bdsr(bdzi parambdzi, bdzn parambdzn)
  {
    super(parambdzi, parambdzn);
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_JavaLangString = null;
    this.jdField_d_of_type_JavaLangString = null;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)this.a);
    if ((parambdzn != null) && (parambdzn.a != null)) {}
    try
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(parambdzn.a);
      this.jdField_a_of_type_Bdxv = bdta.jdField_a_of_type_Bdxv;
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
    if (!f) {}
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
    f = true;
    if (QLog.isColorLevel()) {
      QLog.d("BaseTransProcessor", 2, "getPicDownloadPort return " + jdField_c_of_type_Int);
    }
    return jdField_c_of_type_Int;
  }
  
  protected ArrayList<bdyf> a(ArrayList<bdyf> paramArrayList1, ArrayList<bdyf> paramArrayList2)
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0)) {
      this.jdField_c_of_type_Boolean = true;
    }
    paramArrayList1 = bdvz.a(paramArrayList1, paramArrayList2);
    if ((paramArrayList1 != null) && (paramArrayList1.size() > 0))
    {
      paramArrayList2 = (bdyf)paramArrayList1.get(0);
      if ((paramArrayList2 != null) && (paramArrayList2.a)) {
        this.jdField_d_of_type_Boolean = true;
      }
    }
    return paramArrayList1;
  }
  
  public void a(ayxc paramayxc)
  {
    try
    {
      if (this.jdField_b_of_type_JavaUtilArrayList != null) {
        this.jdField_b_of_type_JavaUtilArrayList.remove(paramayxc);
      }
      return;
    }
    finally {}
  }
  
  protected void a(bdwt parambdwt, boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject;
    if ((this.jdField_a_of_type_Bdws != null) && ((this.jdField_a_of_type_Bdws instanceof bdvs)) && (((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString != null))
    {
      localObject = ((bdvs)this.jdField_a_of_type_Bdws).jdField_a_of_type_JavaLangString;
      this.jdField_a_of_type_Bedj.h = ((String)localObject);
    }
    try
    {
      localObject = new URL((String)localObject);
      String str = ((URL)localObject).getHost();
      int i = ((URL)localObject).getPort();
      this.jdField_a_of_type_Bedj.jdField_a_of_type_JavaLangString = str;
      this.jdField_a_of_type_Bedj.b = String.valueOf(i);
      this.jdField_a_of_type_Bedj.i = (parambdwt.jdField_c_of_type_Int + "");
      this.jdField_a_of_type_Bedj.j = this.jdField_a_of_type_Bdzn.f;
      this.jdField_a_of_type_Bedj.k = paramString2;
      this.jdField_a_of_type_Bedj.jdField_c_of_type_JavaLangString = String.valueOf(parambdwt.jdField_b_of_type_Int);
      this.jdField_a_of_type_Bedj.e = parambdwt.jdField_a_of_type_JavaLangString;
      if (parambdwt.jdField_b_of_type_Int == -9527) {}
      for (parambdwt = (String)parambdwt.jdField_a_of_type_JavaUtilHashMap.get("netresp_param_reason");; parambdwt = null)
      {
        this.jdField_a_of_type_Bedj.jdField_d_of_type_JavaLangString = parambdwt;
        a(paramString1, paramBoolean);
        return;
      }
      return;
    }
    catch (Throwable parambdwt)
    {
      QLog.e("BaseTransProcessor", 1, "reportForServerMonitor err.", parambdwt);
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
  
  public void aN_()
  {
    try
    {
      if (this.jdField_a_of_type_Bduk != null)
      {
        this.jdField_a_of_type_Bduk.d = 2001;
        if (QLog.isColorLevel()) {
          QLog.d("PIC_TAG", 2, "start ");
        }
      }
      super.aN_();
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
  
  public void b(ayxc paramayxc)
  {
    try
    {
      this.jdField_b_of_type_JavaUtilArrayList.add(paramayxc);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdsr
 * JD-Core Version:    0.7.0.1
 */