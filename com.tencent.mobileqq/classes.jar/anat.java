public class anat
{
  private static int jdField_a_of_type_Int = 0;
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static anat b;
  private anat jdField_a_of_type_Anat;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder = new StringBuilder(128);
  
  public static anat a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (b != null)
      {
        anat localanat = b;
        b = localanat.jdField_a_of_type_Anat;
        localanat.jdField_a_of_type_Anat = null;
        jdField_a_of_type_Int -= 1;
        return localanat;
      }
      return new anat();
    }
  }
  
  private void b()
  {
    this.jdField_a_of_type_JavaLangStringBuilder.delete(0, this.jdField_a_of_type_JavaLangStringBuilder.length());
  }
  
  public anat a(Object paramObject)
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
        this.jdField_a_of_type_Anat = b;
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
 * Qualified Name:     anat
 * JD-Core Version:    0.7.0.1
 */