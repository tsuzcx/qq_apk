public class bhpa
{
  private static int jdField_a_of_type_Int = 0;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static bhpa b;
  private bhpa jdField_a_of_type_Bhpa;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(128);
  
  public static bhpa a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (b != null)
      {
        bhpa localbhpa = b;
        b = localbhpa.jdField_a_of_type_Bhpa;
        localbhpa.jdField_a_of_type_Bhpa = null;
        jdField_a_of_type_Int -= 1;
        return localbhpa;
      }
      return new bhpa();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
  }
  
  public bhpa a(Object paramObject)
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
        this.jdField_a_of_type_Bhpa = b;
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
 * Qualified Name:     bhpa
 * JD-Core Version:    0.7.0.1
 */