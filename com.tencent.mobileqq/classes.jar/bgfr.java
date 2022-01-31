public class bgfr
{
  private static int jdField_a_of_type_Int = 0;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static bgfr b;
  private bgfr jdField_a_of_type_Bgfr;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(128);
  
  public static bgfr a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (b != null)
      {
        bgfr localbgfr = b;
        b = localbgfr.jdField_a_of_type_Bgfr;
        localbgfr.jdField_a_of_type_Bgfr = null;
        jdField_a_of_type_Int -= 1;
        return localbgfr;
      }
      return new bgfr();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
  }
  
  public bgfr a(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramObject);
    return this;
  }
  
  public void a()
  {
    b();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_a_of_type_Int < 50)
      {
        this.jdField_a_of_type_Bgfr = b;
        b = this;
        jdField_a_of_type_Int += 1;
      }
      return;
    }
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     bgfr
 * JD-Core Version:    0.7.0.1
 */