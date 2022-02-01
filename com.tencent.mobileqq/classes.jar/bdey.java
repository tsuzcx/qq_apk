public class bdey
{
  int jdField_a_of_type_Int;
  private char[] jdField_a_of_type_ArrayOfChar;
  int b;
  int c;
  
  private int a()
  {
    int i = 0;
    while (this.jdField_a_of_type_Int + i < this.jdField_a_of_type_ArrayOfChar.length)
    {
      int j = this.jdField_a_of_type_ArrayOfChar[(this.jdField_a_of_type_Int + i)];
      if (((j < 48) || (j > 57)) && ((j < 97) || (j > 122))) {
        break;
      }
      i += 1;
    }
    return i;
  }
  
  void a()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_ArrayOfChar = null;
    this.b = 0;
    this.c = 0;
  }
  
  void a(String paramString)
  {
    int i = 1;
    this.jdField_a_of_type_ArrayOfChar = paramString.toCharArray();
    if ((this.jdField_a_of_type_ArrayOfChar[0] != 'Z') && (this.jdField_a_of_type_ArrayOfChar[1] != ':')) {
      throw new IllegalArgumentException("Not a exports: " + paramString);
    }
    this.jdField_a_of_type_Int += 2;
    int j = a();
    if (j <= 0) {
      throw new IllegalArgumentException("Not a exports: " + paramString);
    }
    this.b = bdej.a(paramString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + j));
    this.jdField_a_of_type_Int = (j + this.jdField_a_of_type_Int);
    char[] arrayOfChar = this.jdField_a_of_type_ArrayOfChar;
    j = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (j + 1);
    j = arrayOfChar[j];
    if ((j != 60) && (j != 62)) {
      throw new IllegalArgumentException("Not a exports: " + paramString);
    }
    if (62 == j) {}
    for (;;)
    {
      j = a();
      if (j > 0) {
        break;
      }
      throw new IllegalArgumentException("Not a exports: " + paramString);
      i = -1;
    }
    int k = bdej.a(paramString.substring(this.jdField_a_of_type_Int, this.jdField_a_of_type_Int + j));
    this.jdField_a_of_type_Int = (j + this.jdField_a_of_type_Int);
    this.c = (i * k + this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdey
 * JD-Core Version:    0.7.0.1
 */