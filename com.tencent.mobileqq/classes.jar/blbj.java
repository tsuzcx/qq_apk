public class blbj
{
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private boolean jdField_a_of_type_Boolean;
  
  public blbj()
  {
    a();
  }
  
  private void a()
  {
    a(",");
  }
  
  private void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  public blbj a()
  {
    this.jdField_a_of_type_JavaLangStringBuilder = new StringBuilder();
    this.jdField_a_of_type_Boolean = false;
    return this;
  }
  
  public blbj a(int paramInt)
  {
    return a(String.format("%d", new Object[] { Integer.valueOf(paramInt) }));
  }
  
  public blbj a(String paramString)
  {
    a();
    paramString = paramString.replace(',', ';');
    this.jdField_a_of_type_JavaLangStringBuilder.append(paramString);
    return this;
  }
  
  public blbj a(byte[] paramArrayOfByte)
  {
    return a(bhml.a(paramArrayOfByte));
  }
  
  public String toString()
  {
    return this.jdField_a_of_type_JavaLangStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blbj
 * JD-Core Version:    0.7.0.1
 */