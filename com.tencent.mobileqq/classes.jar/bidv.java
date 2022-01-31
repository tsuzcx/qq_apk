import android.text.TextUtils;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

public class bidv
{
  private long jdField_a_of_type_Long;
  private ayrv jdField_a_of_type_Ayrv;
  private final bidr jdField_a_of_type_Bidr;
  private final bidw jdField_a_of_type_Bidw;
  private biel jdField_a_of_type_Biel;
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private volatile boolean jdField_d_of_type_Boolean;
  
  private bidv(String paramString1, String paramString2, bidr parambidr, bidw parambidw)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bidr = parambidr;
    this.jdField_a_of_type_Bidw = parambidw;
  }
  
  public static ayrv a(Object paramObject, String paramString1, String paramString2, String paramString3, ayrz paramayrz, aysa paramaysa)
  {
    return a(paramObject, paramString1, paramString2, paramString3, paramayrz, paramaysa, null);
  }
  
  public static ayrv a(Object paramObject, String paramString1, String paramString2, String paramString3, ayrz paramayrz, aysa paramaysa, String paramString4)
  {
    ayrv localayrv = new ayrv();
    localayrv.jdField_a_of_type_Aysa = paramaysa;
    localayrv.jdField_a_of_type_JavaLangString = paramString1;
    localayrv.jdField_a_of_type_Int = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localayrv.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      localayrv.jdField_a_of_type_JavaUtilHashMap.put("Cookie", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localayrv.jdField_d_of_type_JavaLangString = paramString4;
    }
    localayrv.jdField_c_of_type_JavaLangString = paramString2;
    localayrv.e = 1;
    localayrv.a(paramObject);
    localayrv.jdField_a_of_type_Ayrz = paramayrz;
    return localayrv;
  }
  
  public static bidv a(String paramString1, bidr parambidr, String paramString2, bidw parambidw)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (parambidr == null) || (parambidw == null)) {
      throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
    }
    return new bidv(paramString1, IOUtils.getDirPathNoSeparator(paramString2), parambidr, parambidw);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public ayrv a()
  {
    return this.jdField_a_of_type_Ayrv;
  }
  
  public bidr a()
  {
    return this.jdField_a_of_type_Bidr;
  }
  
  public bidw a()
  {
    return this.jdField_a_of_type_Bidw;
  }
  
  public biel a()
  {
    return this.jdField_a_of_type_Biel;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(ayrv paramayrv)
  {
    this.jdField_a_of_type_Ayrv = paramayrv;
  }
  
  public void a(biel parambiel)
  {
    this.jdField_a_of_type_Biel = parambiel;
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
  
  public bidw b()
  {
    return this.jdField_a_of_type_Bidw.a();
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
 * Qualified Name:     bidv
 * JD-Core Version:    0.7.0.1
 */