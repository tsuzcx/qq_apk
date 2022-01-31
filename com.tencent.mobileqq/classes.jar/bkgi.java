import android.text.TextUtils;
import com.tencent.weiyun.utils.IOUtils;
import java.util.HashMap;

public class bkgi
{
  private long jdField_a_of_type_Long;
  private baps jdField_a_of_type_Baps;
  private final bkge jdField_a_of_type_Bkge;
  private final bkgj jdField_a_of_type_Bkgj;
  private bkgy jdField_a_of_type_Bkgy;
  private final String jdField_a_of_type_JavaLangString;
  private volatile boolean jdField_a_of_type_Boolean;
  private final String jdField_b_of_type_JavaLangString;
  private volatile boolean jdField_b_of_type_Boolean;
  private String jdField_c_of_type_JavaLangString;
  private volatile boolean jdField_c_of_type_Boolean;
  private String jdField_d_of_type_JavaLangString;
  private volatile boolean jdField_d_of_type_Boolean;
  
  private bkgi(String paramString1, String paramString2, bkge parambkge, bkgj parambkgj)
  {
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.jdField_b_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Bkge = parambkge;
    this.jdField_a_of_type_Bkgj = parambkgj;
  }
  
  public static baps a(Object paramObject, String paramString1, String paramString2, String paramString3, bapw parambapw, bapx parambapx)
  {
    return a(paramObject, paramString1, paramString2, paramString3, parambapw, parambapx, null);
  }
  
  public static baps a(Object paramObject, String paramString1, String paramString2, String paramString3, bapw parambapw, bapx parambapx, String paramString4)
  {
    baps localbaps = new baps();
    localbaps.jdField_a_of_type_Bapx = parambapx;
    localbaps.jdField_a_of_type_JavaLangString = paramString1;
    localbaps.jdField_a_of_type_Int = 0;
    if (!TextUtils.isEmpty(paramString3))
    {
      localbaps.jdField_a_of_type_JavaUtilHashMap = new HashMap();
      localbaps.jdField_a_of_type_JavaUtilHashMap.put("Cookie", paramString3);
    }
    if (!TextUtils.isEmpty(paramString4)) {
      localbaps.jdField_d_of_type_JavaLangString = paramString4;
    }
    localbaps.jdField_c_of_type_JavaLangString = paramString2;
    localbaps.e = 1;
    localbaps.a(paramObject);
    localbaps.jdField_a_of_type_Bapw = parambapw;
    return localbaps;
  }
  
  public static bkgi a(String paramString1, bkge parambkge, String paramString2, bkgj parambkgj)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (parambkge == null) || (parambkgj == null)) {
      throw new IllegalArgumentException("The params jobOwnerUid, localDir, file and statusInfo should be valid.");
    }
    return new bkgi(paramString1, IOUtils.getDirPathNoSeparator(paramString2), parambkge, parambkgj);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public baps a()
  {
    return this.jdField_a_of_type_Baps;
  }
  
  public bkge a()
  {
    return this.jdField_a_of_type_Bkge;
  }
  
  public bkgj a()
  {
    return this.jdField_a_of_type_Bkgj;
  }
  
  public bkgy a()
  {
    return this.jdField_a_of_type_Bkgy;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
  }
  
  public void a(baps parambaps)
  {
    this.jdField_a_of_type_Baps = parambaps;
  }
  
  public void a(bkgy parambkgy)
  {
    this.jdField_a_of_type_Bkgy = parambkgy;
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
  
  public bkgj b()
  {
    return this.jdField_a_of_type_Bkgj.a();
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
 * Qualified Name:     bkgi
 * JD-Core Version:    0.7.0.1
 */