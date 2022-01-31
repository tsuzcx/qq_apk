import android.text.TextUtils;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

public class bgut
{
  private long jdField_a_of_type_Long;
  private axro jdField_a_of_type_Axro;
  private final bgup jdField_a_of_type_Bgup;
  private final bguu jdField_a_of_type_Bguu;
  private bgvj jdField_a_of_type_Bgvj;
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private volatile boolean jdField_d_of_type_Boolean;
  
  private bgut(String paramString1, String paramString2, bgup parambgup, bguu parambguu)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bgup = parambgup;
    this.jdField_a_of_type_Bguu = parambguu;
  }
  
  public static axro a(Object paramObject, String paramString1, String paramString2, String paramString3, axrs paramaxrs, axrt paramaxrt)
  {
    return a(paramObject, paramString1, paramString2, paramString3, paramaxrs, paramaxrt, null);
  }
  
  public static axro a(Object paramObject, String paramString1, String paramString2, String paramString3, axrs paramaxrs, axrt paramaxrt, String paramString4)
  {
    axro localaxro = new axro();
    localaxro.jdField_a_of_type_Axrt = paramaxrt;
    localaxro.jdField_a_of_type_JavaLangString = paramString1;
    localaxro.jdField_a_of_type_Int = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localaxro.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      localaxro.jdField_a_of_type_JavaUtilHashMap.put("Cookie", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localaxro.jdField_d_of_type_JavaLangString = paramString4;
    }
    localaxro.jdField_c_of_type_JavaLangString = paramString2;
    localaxro.e = 1;
    localaxro.a(paramObject);
    localaxro.jdField_a_of_type_Axrs = paramaxrs;
    return localaxro;
  }
  
  public static bgut a(String paramString1, bgup parambgup, String paramString2, bguu parambguu)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (parambgup == null) || (parambguu == null)) {
      throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
    }
    return new bgut(paramString1, IOUtils.getDirPathNoSeparator(paramString2), parambgup, parambguu);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public axro a()
  {
    return this.jdField_a_of_type_Axro;
  }
  
  public bgup a()
  {
    return this.jdField_a_of_type_Bgup;
  }
  
  public bguu a()
  {
    return this.jdField_a_of_type_Bguu;
  }
  
  public bgvj a()
  {
    return this.jdField_a_of_type_Bgvj;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(axro paramaxro)
  {
    this.jdField_a_of_type_Axro = paramaxro;
  }
  
  public void a(bgvj parambgvj)
  {
    this.jdField_a_of_type_Bgvj = parambgvj;
  }
  
  public void a(String paramString)
  {
    this.jdField_c_of_type_JavaLangString = paramString;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public bguu b()
  {
    return this.jdField_a_of_type_Bguu.a();
  }
  
  public String b()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public void b(String paramString)
  {
    this.jdField_d_of_type_JavaLangString = paramString;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String c()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public String d()
  {
    return this.jdField_d_of_type_JavaLangString;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public boolean d()
  {
    return this.jdField_d_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgut
 * JD-Core Version:    0.7.0.1
 */