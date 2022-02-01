final class bdel
  implements bdfc
{
  bdel(bdfi parambdfi1, bdfi parambdfi2, bdei parambdei, boolean paramBoolean, bdef parambdef, int[] paramArrayOfInt1, int[] paramArrayOfInt2) {}
  
  public void a(bdfd parambdfd1, bdfd parambdfd2, bdfd parambdfd3)
  {
    if ((parambdfd1.jdField_a_of_type_Char == '+') || (parambdfd2.jdField_a_of_type_Char == '+')) {
      bdej.a(parambdfd1, parambdfd2, parambdfd3, this.jdField_a_of_type_Bdfi, this.jdField_b_of_type_Bdfi, this.jdField_a_of_type_Bdei, this.jdField_a_of_type_Boolean);
    }
    for (;;)
    {
      switch (parambdfd3.jdField_a_of_type_Char)
      {
      default: 
        return;
        if (parambdfd1.jdField_a_of_type_Char == '-')
        {
          bdej.b(parambdfd1, parambdfd2);
        }
        else if (parambdfd2.jdField_a_of_type_Char == '-')
        {
          bdej.a(parambdfd1, parambdfd2, parambdfd3);
        }
        else if (parambdfd1.jdField_a_of_type_Char == 0)
        {
          bdej.a(parambdfd2, parambdfd3);
          parambdfd2.jdField_a_of_type_Char = '\000';
        }
        else if (parambdfd2.jdField_a_of_type_Char == 0)
        {
          parambdfd1.jdField_a_of_type_Char = '\000';
        }
        else
        {
          bdej.b(parambdfd1, parambdfd2, parambdfd3, this.jdField_a_of_type_Bdef);
        }
        break;
      }
    }
    parambdfd1 = this.jdField_a_of_type_ArrayOfInt;
    parambdfd1[0] += parambdfd3.jdField_a_of_type_Int;
    parambdfd1 = this.jdField_b_of_type_ArrayOfInt;
    parambdfd1[0] += parambdfd3.jdField_a_of_type_Int;
    return;
    parambdfd1 = this.jdField_a_of_type_ArrayOfInt;
    parambdfd1[0] += parambdfd3.jdField_a_of_type_Int;
    return;
    parambdfd1 = this.jdField_b_of_type_ArrayOfInt;
    parambdfd1[0] += parambdfd3.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdel
 * JD-Core Version:    0.7.0.1
 */