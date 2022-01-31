public class bjql
{
  private static int jdField_a_of_type_Int = 0;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static bjql b;
  private bjql jdField_a_of_type_Bjql;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(128);
  
  public static bjql a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (b != null)
      {
        bjql localbjql = b;
        b = localbjql.jdField_a_of_type_Bjql;
        localbjql.jdField_a_of_type_Bjql = null;
        jdField_a_of_type_Int -= 1;
        return localbjql;
      }
      return new bjql();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
  }
  
  public bjql a(Object paramObject)
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
        this.jdField_a_of_type_Bjql = b;
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
 * Qualified Name:     bjql
 * JD-Core Version:    0.7.0.1
 */