import android.text.TextUtils;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

public class boak
{
  private long jdField_a_of_type_Long;
  private beum jdField_a_of_type_Beum;
  private final boag jdField_a_of_type_Boag;
  private final boal jdField_a_of_type_Boal;
  private boba jdField_a_of_type_Boba;
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private volatile boolean jdField_d_of_type_Boolean;
  
  private boak(String paramString1, String paramString2, boag paramboag, boal paramboal)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Boag = paramboag;
    this.jdField_a_of_type_Boal = paramboal;
  }
  
  public static beum a(Object paramObject, String paramString1, String paramString2, String paramString3, beup parambeup, beuq parambeuq)
  {
    return a(paramObject, paramString1, paramString2, paramString3, parambeup, parambeuq, null);
  }
  
  public static beum a(Object paramObject, String paramString1, String paramString2, String paramString3, beup parambeup, beuq parambeuq, String paramString4)
  {
    beum localbeum = new beum();
    localbeum.jdField_a_of_type_Beuq = parambeuq;
    localbeum.jdField_a_of_type_JavaLangString = paramString1;
    localbeum.jdField_a_of_type_Int = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localbeum.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      localbeum.jdField_a_of_type_JavaUtilHashMap.put("Cookie", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localbeum.jdField_d_of_type_JavaLangString = paramString4;
    }
    localbeum.jdField_c_of_type_JavaLangString = paramString2;
    localbeum.jdField_d_of_type_Int = 1;
    localbeum.a(paramObject);
    localbeum.jdField_a_of_type_Beup = parambeup;
    return localbeum;
  }
  
  public static boak a(String paramString1, boag paramboag, String paramString2, boal paramboal)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (paramboag == null) || (paramboal == null)) {
      throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
    }
    return new boak(paramString1, IOUtils.getDirPathNoSeparator(paramString2), paramboag, paramboal);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public beum a()
  {
    return this.jdField_a_of_type_Beum;
  }
  
  public boag a()
  {
    return this.jdField_a_of_type_Boag;
  }
  
  public boal a()
  {
    return this.jdField_a_of_type_Boal;
  }
  
  public boba a()
  {
    return this.jdField_a_of_type_Boba;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(beum parambeum)
  {
    this.jdField_a_of_type_Beum = parambeum;
  }
  
  public void a(boba paramboba)
  {
    this.jdField_a_of_type_Boba = paramboba;
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
  
  public boal b()
  {
    return this.jdField_a_of_type_Boal.a();
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
 * Qualified Name:     boak
 * JD-Core Version:    0.7.0.1
 */