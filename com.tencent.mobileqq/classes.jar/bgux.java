import com.tencent.qphone.base.util.QLog;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class bgux
{
  public static String f;
  public int a;
  public long a;
  public bdxx a;
  private final bguz jdField_a_of_type_Bguz;
  public Object a;
  public String a;
  public HttpURLConnection a;
  HashMap<String, String> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  public AtomicBoolean a;
  final boolean jdField_a_of_type_Boolean;
  private byte[] jdField_a_of_type_ArrayOfByte;
  public String[] a;
  public int b;
  public long b;
  public String b;
  public HashMap<String, String> b;
  public AtomicBoolean b;
  public boolean b;
  private byte[] b;
  public int c;
  public long c;
  public String c;
  public AtomicBoolean c;
  public boolean c;
  public int d;
  public long d;
  public String d;
  public boolean d;
  public int e = -1;
  public long e;
  public String e;
  public boolean e;
  public int f;
  public long f;
  public boolean f;
  public int g;
  private String g;
  public boolean g;
  public int h;
  private String h;
  public boolean h;
  private int jdField_i_of_type_Int;
  private String jdField_i_of_type_JavaLangString = "GET";
  public boolean i;
  public boolean j;
  public boolean k;
  public boolean l;
  private boolean m;
  private boolean n = true;
  
  static
  {
    jdField_f_of_type_JavaLangString = "param_reason";
  }
  
  public bgux(String paramString, byte[] paramArrayOfByte, bguz parambguz)
  {
    this(paramString, paramArrayOfByte, parambguz, false);
  }
  
  public bgux(String paramString, byte[] paramArrayOfByte, bguz parambguz, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = 201;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_c_of_type_Boolean = true;
    this.g = paramString;
    if (paramString != null)
    {
      this.h = paramString.substring(0, paramString.length());
      this.jdField_a_of_type_Bguz = parambguz;
      if (paramArrayOfByte != null) {
        break label139;
      }
      this.jdField_a_of_type_ArrayOfByte = null;
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = paramBoolean;
      return;
      this.h = null;
      break;
      label139:
      this.jdField_a_of_type_ArrayOfByte = new byte[paramArrayOfByte.length];
      System.arraycopy(paramArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
    }
  }
  
  public int a()
  {
    return this.jdField_i_of_type_Int;
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public bguz a()
  {
    return this.jdField_a_of_type_Bguz;
  }
  
  public String a()
  {
    return this.g;
  }
  
  public String a(String paramString)
  {
    return (String)this.jdField_b_of_type_JavaUtilHashMap.get(paramString);
  }
  
  public HashMap<String, String> a()
  {
    return this.jdField_a_of_type_JavaUtilHashMap;
  }
  
  public void a()
  {
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    if (this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean != null) {
      this.jdField_c_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(false);
    }
    this.jdField_a_of_type_JavaNetHttpURLConnection = null;
  }
  
  public void a(int paramInt)
  {
    this.jdField_i_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString)
  {
    this.jdField_f_of_type_Int = paramInt1;
    this.e = paramInt2;
    this.jdField_b_of_type_JavaLangString = paramString;
    if ((this.jdField_a_of_type_Bguz instanceof bdsx)) {
      ((bdsx)this.jdField_a_of_type_Bguz).a(paramInt1, paramInt2, 0L, paramString);
    }
  }
  
  public void a(String paramString)
  {
    this.g = paramString;
    this.h = this.g.substring(0, this.g.length());
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    this.m = paramBoolean;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.jdField_b_of_type_ArrayOfByte = paramArrayOfByte;
  }
  
  public boolean a()
  {
    return this.m;
  }
  
  public byte[] a()
  {
    return this.jdField_b_of_type_ArrayOfByte;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public String b()
  {
    return this.h;
  }
  
  public void b()
  {
    a();
    this.jdField_f_of_type_Int = 0;
    this.e = 0;
    this.jdField_b_of_type_JavaLangString = null;
    this.jdField_b_of_type_ArrayOfByte = null;
  }
  
  public void b(int paramInt)
  {
    if (paramInt == 5)
    {
      this.jdField_a_of_type_Int = 201;
      return;
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Int = 202;
      return;
    }
    if (paramInt == 10)
    {
      this.jdField_a_of_type_Int = 200;
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void b(String paramString)
  {
    this.jdField_i_of_type_JavaLangString = paramString;
  }
  
  public void b(String paramString1, String paramString2)
  {
    if ((paramString1 == null) || (paramString2 == null)) {
      return;
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(paramString1, paramString2);
  }
  
  public void b(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public boolean b()
  {
    return this.n;
  }
  
  public byte[] b()
  {
    return this.jdField_a_of_type_ArrayOfByte;
  }
  
  public int c()
  {
    return this.e;
  }
  
  public String c()
  {
    String str2 = a();
    String str1 = str2;
    if (!this.jdField_c_of_type_Boolean) {
      str1 = bdxz.a(str2);
    }
    return str1;
  }
  
  public void c(int paramInt)
  {
    this.e = paramInt;
  }
  
  public boolean c()
  {
    if ((this.jdField_b_of_type_JavaUtilHashMap.containsKey("X-RtFlag")) && ("0".equals(this.jdField_b_of_type_JavaUtilHashMap.get("X-RtFlag")))) {
      if (QLog.isColorLevel()) {
        QLog.d("Q.richmedia.HttpMsg", 2, "permitRetry : X-RtFlag = 0");
      }
    }
    while ((this.jdField_f_of_type_Int == 9048) || (this.jdField_f_of_type_Int == 9057) || (this.jdField_f_of_type_Int == 9020) || (this.jdField_f_of_type_Int == 9022) || (this.jdField_f_of_type_Int == 9366) || (this.jdField_f_of_type_Int == 9058)) {
      return false;
    }
    return true;
  }
  
  public String d()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String e()
  {
    return this.jdField_i_of_type_JavaLangString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgux
 * JD-Core Version:    0.7.0.1
 */