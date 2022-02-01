import android.text.TextUtils;

public class bnby
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bnbx jdField_a_of_type_Bnbx;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e = "";
  private String f = "";
  private String g;
  
  public bnbx a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("moduleId can not be null");
    }
    return new bnbx(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.e, this.f, this.g, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_Bnbx);
  }
  
  public bnby a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public bnby a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public bnby a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bnby b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public bnby c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public bnby d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public bnby e(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public bnby f(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public bnby g(String paramString)
  {
    this.g = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bnby
 * JD-Core Version:    0.7.0.1
 */