import android.text.TextUtils;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

public class bkkp
{
  private long jdField_a_of_type_Long;
  private baub jdField_a_of_type_Baub;
  private final bkkl jdField_a_of_type_Bkkl;
  private final bkkq jdField_a_of_type_Bkkq;
  private bklf jdField_a_of_type_Bklf;
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private volatile boolean jdField_d_of_type_Boolean;
  
  private bkkp(String paramString1, String paramString2, bkkl parambkkl, bkkq parambkkq)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bkkl = parambkkl;
    this.jdField_a_of_type_Bkkq = parambkkq;
  }
  
  public static baub a(Object paramObject, String paramString1, String paramString2, String paramString3, bauf parambauf, baug parambaug)
  {
    return a(paramObject, paramString1, paramString2, paramString3, parambauf, parambaug, null);
  }
  
  public static baub a(Object paramObject, String paramString1, String paramString2, String paramString3, bauf parambauf, baug parambaug, String paramString4)
  {
    baub localbaub = new baub();
    localbaub.jdField_a_of_type_Baug = parambaug;
    localbaub.jdField_a_of_type_JavaLangString = paramString1;
    localbaub.jdField_a_of_type_Int = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localbaub.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      localbaub.jdField_a_of_type_JavaUtilHashMap.put("Cookie", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localbaub.jdField_d_of_type_JavaLangString = paramString4;
    }
    localbaub.jdField_c_of_type_JavaLangString = paramString2;
    localbaub.e = 1;
    localbaub.a(paramObject);
    localbaub.jdField_a_of_type_Bauf = parambauf;
    return localbaub;
  }
  
  public static bkkp a(String paramString1, bkkl parambkkl, String paramString2, bkkq parambkkq)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (parambkkl == null) || (parambkkq == null)) {
      throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
    }
    return new bkkp(paramString1, IOUtils.getDirPathNoSeparator(paramString2), parambkkl, parambkkq);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public baub a()
  {
    return this.jdField_a_of_type_Baub;
  }
  
  public bkkl a()
  {
    return this.jdField_a_of_type_Bkkl;
  }
  
  public bkkq a()
  {
    return this.jdField_a_of_type_Bkkq;
  }
  
  public bklf a()
  {
    return this.jdField_a_of_type_Bklf;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(baub parambaub)
  {
    this.jdField_a_of_type_Baub = parambaub;
  }
  
  public void a(bklf parambklf)
  {
    this.jdField_a_of_type_Bklf = parambklf;
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
  
  public bkkq b()
  {
    return this.jdField_a_of_type_Bkkq.a();
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
 * Qualified Name:     bkkp
 * JD-Core Version:    0.7.0.1
 */