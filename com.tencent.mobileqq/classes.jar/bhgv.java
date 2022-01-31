import android.text.TextUtils;

public class bhgv
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bhgu jdField_a_of_type_Bhgu;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e = "";
  private String f = "";
  private String g;
  
  public bhgu a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("moduleId can not be null");
    }
    return new bhgu(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.e, this.f, this.g, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_Bhgu);
  }
  
  public bhgv a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public bhgv a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public bhgv a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bhgv b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public bhgv c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public bhgv d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public bhgv e(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public bhgv f(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public bhgv g(String paramString)
  {
    this.g = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhgv
 * JD-Core Version:    0.7.0.1
 */