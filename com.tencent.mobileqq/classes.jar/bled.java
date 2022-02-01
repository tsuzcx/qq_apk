import android.os.Build;
import android.os.Build.VERSION;
import java.util.HashMap;

public class bled
{
  public static int a;
  public String a;
  public HashMap<Integer, String> a;
  public int b;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  
  static
  {
    jdField_a_of_type_Int = 51;
  }
  
  public bled()
  {
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(1), "55801");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(3), "1");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(11), "4");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(12), "430");
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(14), Build.MODEL);
    this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(15), Build.VERSION.RELEASE);
  }
  
  public bled a(int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    return this;
  }
  
  public bled a(int paramInt, String paramString)
  {
    if ((paramInt >= 1) && (paramInt <= jdField_a_of_type_Int)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(Integer.valueOf(paramInt), paramString);
    }
    return this;
  }
  
  public bled a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bled b(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public bled c(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bled d(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public bled e(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public bled f(String paramString)
  {
    this.f = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bled
 * JD-Core Version:    0.7.0.1
 */