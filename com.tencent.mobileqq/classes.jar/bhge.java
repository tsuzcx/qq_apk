import android.text.TextUtils;

public class bhge
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private bhgd jdField_a_of_type_Bhgd;
  private String jdField_a_of_type_JavaLangString;
  private String b;
  private String c;
  private String d;
  private String e = "";
  private String f = "";
  private String g;
  
  public bhgd a()
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      throw new IllegalArgumentException("moduleId can not be null");
    }
    return new bhgd(this.jdField_a_of_type_JavaLangString, this.b, this.c, this.d, this.e, this.f, this.g, this.jdField_a_of_type_Int, this.jdField_a_of_type_Long, this.jdField_a_of_type_Bhgd);
  }
  
  public bhge a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    return this;
  }
  
  public bhge a(long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    return this;
  }
  
  public bhge a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    return this;
  }
  
  public bhge b(String paramString)
  {
    this.b = paramString;
    return this;
  }
  
  public bhge c(String paramString)
  {
    this.c = paramString;
    return this;
  }
  
  public bhge d(String paramString)
  {
    this.d = paramString;
    return this;
  }
  
  public bhge e(String paramString)
  {
    this.e = paramString;
    return this;
  }
  
  public bhge f(String paramString)
  {
    this.f = paramString;
    return this;
  }
  
  public bhge g(String paramString)
  {
    this.g = paramString;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bhge
 * JD-Core Version:    0.7.0.1
 */