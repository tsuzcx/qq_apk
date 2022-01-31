public class biwo
{
  public static final biwo a;
  private static final biwo[] jdField_a_of_type_ArrayOfBiwo;
  public static final biwo b;
  private static final biwo[] b;
  public static final biwo c;
  private static final biwo[] c;
  private static final biwo[] d = { jdField_b_of_type_Biwo };
  private static final biwo[] e = { jdField_b_of_type_Biwo, jdField_c_of_type_Biwo };
  public final int a;
  private boolean jdField_a_of_type_Boolean;
  public final int b;
  
  static
  {
    jdField_a_of_type_Biwo = new biwo(0, 2131689819);
    jdField_b_of_type_Biwo = new biwo(1, 2131689820);
    jdField_c_of_type_Biwo = new biwo(2, 2131689818);
    jdField_a_of_type_ArrayOfBiwo = new biwo[] { jdField_a_of_type_Biwo, jdField_b_of_type_Biwo, jdField_c_of_type_Biwo };
    jdField_b_of_type_ArrayOfBiwo = new biwo[] { jdField_a_of_type_Biwo, jdField_b_of_type_Biwo };
    jdField_c_of_type_ArrayOfBiwo = new biwo[] { jdField_a_of_type_Biwo, jdField_c_of_type_Biwo };
  }
  
  biwo(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static biwo a(biwo parambiwo)
  {
    return new biwo(parambiwo.jdField_a_of_type_Int, parambiwo.jdField_b_of_type_Int);
  }
  
  public static boolean a(biwo parambiwo1, biwo parambiwo2)
  {
    return parambiwo1.jdField_a_of_type_Int == parambiwo2.jdField_a_of_type_Int;
  }
  
  public static biwo[] a(bijd parambijd)
  {
    int i = birt.a(parambijd);
    if (i == 204) {
      return jdField_b_of_type_ArrayOfBiwo;
    }
    if (i == 205) {
      return jdField_c_of_type_ArrayOfBiwo;
    }
    if (i == 206) {
      return d;
    }
    if (i == 207) {
      return e;
    }
    return jdField_a_of_type_ArrayOfBiwo;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public String toString()
  {
    return "AE_CAPTURE_MODE{index=" + this.jdField_a_of_type_Int + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     biwo
 * JD-Core Version:    0.7.0.1
 */