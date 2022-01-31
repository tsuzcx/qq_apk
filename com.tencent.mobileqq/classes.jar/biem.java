import android.text.TextUtils;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

public class biem
{
  private long jdField_a_of_type_Long;
  private ayrx jdField_a_of_type_Ayrx;
  private final biei jdField_a_of_type_Biei;
  private final bien jdField_a_of_type_Bien;
  private bifc jdField_a_of_type_Bifc;
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private volatile boolean jdField_d_of_type_Boolean;
  
  private biem(String paramString1, String paramString2, biei parambiei, bien parambien)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Biei = parambiei;
    this.jdField_a_of_type_Bien = parambien;
  }
  
  public static ayrx a(Object paramObject, String paramString1, String paramString2, String paramString3, aysb paramaysb, aysc paramaysc)
  {
    return a(paramObject, paramString1, paramString2, paramString3, paramaysb, paramaysc, null);
  }
  
  public static ayrx a(Object paramObject, String paramString1, String paramString2, String paramString3, aysb paramaysb, aysc paramaysc, String paramString4)
  {
    ayrx localayrx = new ayrx();
    localayrx.jdField_a_of_type_Aysc = paramaysc;
    localayrx.jdField_a_of_type_JavaLangString = paramString1;
    localayrx.jdField_a_of_type_Int = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localayrx.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      localayrx.jdField_a_of_type_JavaUtilHashMap.put("Cookie", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localayrx.jdField_d_of_type_JavaLangString = paramString4;
    }
    localayrx.jdField_c_of_type_JavaLangString = paramString2;
    localayrx.e = 1;
    localayrx.a(paramObject);
    localayrx.jdField_a_of_type_Aysb = paramaysb;
    return localayrx;
  }
  
  public static biem a(String paramString1, biei parambiei, String paramString2, bien parambien)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (parambiei == null) || (parambien == null)) {
      throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
    }
    return new biem(paramString1, IOUtils.getDirPathNoSeparator(paramString2), parambiei, parambien);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public ayrx a()
  {
    return this.jdField_a_of_type_Ayrx;
  }
  
  public biei a()
  {
    return this.jdField_a_of_type_Biei;
  }
  
  public bien a()
  {
    return this.jdField_a_of_type_Bien;
  }
  
  public bifc a()
  {
    return this.jdField_a_of_type_Bifc;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(ayrx paramayrx)
  {
    this.jdField_a_of_type_Ayrx = paramayrx;
  }
  
  public void a(bifc parambifc)
  {
    this.jdField_a_of_type_Bifc = parambifc;
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
  
  public bien b()
  {
    return this.jdField_a_of_type_Bien.a();
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
 * Qualified Name:     biem
 * JD-Core Version:    0.7.0.1
 */