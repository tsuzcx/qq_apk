final class bdeq
  implements bdfc
{
  bdeq(bdfi parambdfi1, bdef parambdef, StringBuilder paramStringBuilder, bdfi parambdfi2) {}
  
  public void a(bdfd parambdfd1, bdfd parambdfd2, bdfd parambdfd3)
  {
    int i = parambdfd1.jdField_a_of_type_Char;
    int j = parambdfd2.jdField_a_of_type_Char;
    if ((i == 43) && (j == 45)) {
      this.jdField_a_of_type_Bdfi.a(Math.min(parambdfd1.jdField_a_of_type_Int, parambdfd2.jdField_a_of_type_Int));
    }
    bdej.a(parambdfd1, parambdfd2, parambdfd3, this.jdField_a_of_type_Bdef);
    if (parambdfd3.jdField_a_of_type_Char == '+')
    {
      if (j == 43) {
        this.jdField_a_of_type_JavaLangStringBuilder.append(this.b.a(parambdfd3.jdField_a_of_type_Int));
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_JavaLangStringBuilder.append(this.jdField_a_of_type_Bdfi.a(parambdfd3.jdField_a_of_type_Int));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdeq
 * JD-Core Version:    0.7.0.1
 */