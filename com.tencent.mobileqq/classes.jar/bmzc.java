import android.text.TextUtils;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

public class bmzc
{
  private long jdField_a_of_type_Long;
  private bdvs jdField_a_of_type_Bdvs;
  private final bmyy jdField_a_of_type_Bmyy;
  private final bmzd jdField_a_of_type_Bmzd;
  private bmzs jdField_a_of_type_Bmzs;
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private volatile boolean jdField_d_of_type_Boolean;
  
  private bmzc(String paramString1, String paramString2, bmyy parambmyy, bmzd parambmzd)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bmyy = parambmyy;
    this.jdField_a_of_type_Bmzd = parambmzd;
  }
  
  public static bdvs a(Object paramObject, String paramString1, String paramString2, String paramString3, bdvv parambdvv, bdvw parambdvw)
  {
    return a(paramObject, paramString1, paramString2, paramString3, parambdvv, parambdvw, null);
  }
  
  public static bdvs a(Object paramObject, String paramString1, String paramString2, String paramString3, bdvv parambdvv, bdvw parambdvw, String paramString4)
  {
    bdvs localbdvs = new bdvs();
    localbdvs.jdField_a_of_type_Bdvw = parambdvw;
    localbdvs.jdField_a_of_type_JavaLangString = paramString1;
    localbdvs.jdField_a_of_type_Int = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localbdvs.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      localbdvs.jdField_a_of_type_JavaUtilHashMap.put("Cookie", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localbdvs.jdField_d_of_type_JavaLangString = paramString4;
    }
    localbdvs.jdField_c_of_type_JavaLangString = paramString2;
    localbdvs.jdField_d_of_type_Int = 1;
    localbdvs.a(paramObject);
    localbdvs.jdField_a_of_type_Bdvv = parambdvv;
    return localbdvs;
  }
  
  public static bmzc a(String paramString1, bmyy parambmyy, String paramString2, bmzd parambmzd)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (parambmyy == null) || (parambmzd == null)) {
      throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
    }
    return new bmzc(paramString1, IOUtils.getDirPathNoSeparator(paramString2), parambmyy, parambmzd);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public bdvs a()
  {
    return this.jdField_a_of_type_Bdvs;
  }
  
  public bmyy a()
  {
    return this.jdField_a_of_type_Bmyy;
  }
  
  public bmzd a()
  {
    return this.jdField_a_of_type_Bmzd;
  }
  
  public bmzs a()
  {
    return this.jdField_a_of_type_Bmzs;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(bdvs parambdvs)
  {
    this.jdField_a_of_type_Bdvs = parambdvs;
  }
  
  public void a(bmzs parambmzs)
  {
    this.jdField_a_of_type_Bmzs = parambmzs;
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
  
  public bmzd b()
  {
    return this.jdField_a_of_type_Bmzd.a();
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
 * Qualified Name:     bmzc
 * JD-Core Version:    0.7.0.1
 */