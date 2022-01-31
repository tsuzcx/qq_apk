class avte
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  int b;
  
  public avte(avtd paramavtd, String paramString, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public int a()
  {
    if (this.jdField_a_of_type_Int > 0) {
      return this.b * 100 / this.jdField_a_of_type_Int;
    }
    return 0;
  }
  
  public void a()
  {
    this.b += 1;
  }
  
  public void b()
  {
    this.jdField_a_of_type_Int += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     avte
 * JD-Core Version:    0.7.0.1
 */