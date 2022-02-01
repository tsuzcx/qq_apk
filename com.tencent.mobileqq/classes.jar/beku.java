final class beku
  implements bell
{
  beku(int[] paramArrayOfInt1, int[] paramArrayOfInt2, beko parambeko, belr parambelr1, belr parambelr2, bekr parambekr, boolean paramBoolean) {}
  
  private void a(belm parambelm1, belm parambelm2)
  {
    if (parambelm2.jdField_a_of_type_Char == 0) {
      parambelm1.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (parambelm1.jdField_a_of_type_Int > parambelm2.jdField_a_of_type_Int) {
        break;
      }
      parambelm2.jdField_a_of_type_Int -= parambelm1.jdField_a_of_type_Int;
      parambelm2.b -= parambelm1.b;
      parambelm1.jdField_a_of_type_Char = '\000';
    } while (parambelm2.jdField_a_of_type_Int > 0);
    parambelm2.jdField_a_of_type_Char = '\000';
    return;
    parambelm1.jdField_a_of_type_Int -= parambelm2.jdField_a_of_type_Int;
    parambelm1.b -= parambelm2.b;
    parambelm2.jdField_a_of_type_Char = '\000';
  }
  
  private void b(belm parambelm1, belm parambelm2, belm parambelm3)
  {
    parambelm3.jdField_a_of_type_Char = '=';
    parambelm3.jdField_a_of_type_JavaLangString = beks.c(parambelm1.jdField_a_of_type_JavaLangString, parambelm2.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Beko);
    if (parambelm1.jdField_a_of_type_Int <= parambelm2.jdField_a_of_type_Int)
    {
      parambelm3.jdField_a_of_type_Int = parambelm1.jdField_a_of_type_Int;
      parambelm3.b = parambelm1.b;
      parambelm2.jdField_a_of_type_Int -= parambelm1.jdField_a_of_type_Int;
      parambelm2.b -= parambelm1.b;
      parambelm1.jdField_a_of_type_Char = '\000';
      if (parambelm2.jdField_a_of_type_Int == 0) {
        parambelm2.jdField_a_of_type_Char = '\000';
      }
      return;
    }
    parambelm3.jdField_a_of_type_Int = parambelm2.jdField_a_of_type_Int;
    parambelm3.b = parambelm2.b;
    parambelm1.jdField_a_of_type_Int -= parambelm2.jdField_a_of_type_Int;
    parambelm1.b -= parambelm2.b;
    parambelm2.jdField_a_of_type_Char = '\000';
  }
  
  private void c(belm parambelm1, belm parambelm2, belm parambelm3)
  {
    beks.a(parambelm2, parambelm3);
    if (parambelm1.jdField_a_of_type_Char == 0) {
      parambelm2.jdField_a_of_type_Char = '\000';
    }
    do
    {
      return;
      if (parambelm2.jdField_a_of_type_Int > parambelm1.jdField_a_of_type_Int) {
        break;
      }
      parambelm1.jdField_a_of_type_Int -= parambelm2.jdField_a_of_type_Int;
      parambelm1.b -= parambelm2.b;
      parambelm2.jdField_a_of_type_Char = '\000';
    } while (parambelm1.jdField_a_of_type_Int != 0);
    parambelm1.jdField_a_of_type_Char = '\000';
    return;
    parambelm3.b = parambelm1.b;
    parambelm3.jdField_a_of_type_Int = parambelm1.jdField_a_of_type_Int;
    parambelm2.b -= parambelm1.b;
    parambelm2.jdField_a_of_type_Int -= parambelm1.jdField_a_of_type_Int;
    parambelm1.jdField_a_of_type_Char = '\000';
  }
  
  private void d(belm parambelm1, belm parambelm2, belm parambelm3)
  {
    int j = 2;
    int i;
    if (parambelm2.jdField_a_of_type_Char != '+') {
      i = 1;
    }
    while (i == 1)
    {
      this.jdField_a_of_type_Belr.a(parambelm1.jdField_a_of_type_Int);
      parambelm3.jdField_a_of_type_Char = '=';
      parambelm3.b = parambelm1.b;
      parambelm3.jdField_a_of_type_Int = parambelm1.jdField_a_of_type_Int;
      parambelm3.jdField_a_of_type_JavaLangString = "";
      parambelm1.jdField_a_of_type_Char = '\000';
      return;
      i = j;
      if (parambelm1.jdField_a_of_type_Char == '+')
      {
        String str1 = this.jdField_a_of_type_Belr.b(1);
        String str2 = this.jdField_b_of_type_Belr.b(1);
        boolean bool1 = this.jdField_a_of_type_Bekr.a(parambelm1.jdField_a_of_type_JavaLangString);
        boolean bool2 = this.jdField_a_of_type_Bekr.a(parambelm2.jdField_a_of_type_JavaLangString);
        if ((bool1) && (!bool2))
        {
          i = 1;
        }
        else if (bool2)
        {
          i = j;
          if (!bool1) {}
        }
        else if (str1.equals("\n"))
        {
          i = j;
          if (!str2.equals("\n")) {}
        }
        else if ((!str1.equals("\n")) && (str2.equals("\n")))
        {
          i = 1;
        }
        else
        {
          i = j;
          if (!this.jdField_a_of_type_Boolean) {
            i = 1;
          }
        }
      }
    }
    this.jdField_b_of_type_Belr.a(parambelm2.jdField_a_of_type_Int);
    beks.a(parambelm2, parambelm3);
    parambelm2.jdField_a_of_type_Char = '\000';
  }
  
  public void a(belm parambelm1, belm parambelm2, belm parambelm3)
  {
    if ((parambelm1.jdField_a_of_type_Char == '+') || (parambelm2.jdField_a_of_type_Char == '+')) {
      d(parambelm1, parambelm2, parambelm3);
    }
    for (;;)
    {
      switch (parambelm3.jdField_a_of_type_Char)
      {
      default: 
        return;
        if (parambelm1.jdField_a_of_type_Char == '-')
        {
          a(parambelm1, parambelm2);
        }
        else if (parambelm2.jdField_a_of_type_Char == '-')
        {
          c(parambelm1, parambelm2, parambelm3);
        }
        else if (parambelm1.jdField_a_of_type_Char == 0)
        {
          beks.a(parambelm2, parambelm3);
          parambelm2.jdField_a_of_type_Char = '\000';
        }
        else if (parambelm2.jdField_a_of_type_Char == 0)
        {
          parambelm1.jdField_a_of_type_Char = '\000';
        }
        else
        {
          b(parambelm1, parambelm2, parambelm3);
        }
        break;
      }
    }
    parambelm1 = this.jdField_a_of_type_ArrayOfInt;
    parambelm1[0] += parambelm3.jdField_a_of_type_Int;
    parambelm1 = this.jdField_b_of_type_ArrayOfInt;
    parambelm1[0] += parambelm3.jdField_a_of_type_Int;
    return;
    parambelm1 = this.jdField_a_of_type_ArrayOfInt;
    parambelm1[0] += parambelm3.jdField_a_of_type_Int;
    return;
    parambelm1 = this.jdField_b_of_type_ArrayOfInt;
    parambelm1[0] += parambelm3.jdField_a_of_type_Int;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beku
 * JD-Core Version:    0.7.0.1
 */