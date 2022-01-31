public class amko
{
  private static int jdField_a_of_type_Int = 0;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static amko b;
  private amko jdField_a_of_type_Amko;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(128);
  
  public static amko a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (b != null)
      {
        amko localamko = b;
        b = localamko.jdField_a_of_type_Amko;
        localamko.jdField_a_of_type_Amko = null;
        jdField_a_of_type_Int -= 1;
        return localamko;
      }
      return new amko();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
  }
  
  public amko a(Object paramObject)
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
        this.jdField_a_of_type_Amko = b;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     amko
 * JD-Core Version:    0.7.0.1
 */