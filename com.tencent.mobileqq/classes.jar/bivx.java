public class bivx
{
  public static final bivx a;
  private static final bivx[] jdField_a_of_type_ArrayOfBivx;
  public static final bivx b;
  private static final bivx[] b;
  public static final bivx c;
  private static final bivx[] c;
  private static final bivx[] d = { jdField_b_of_type_Bivx };
  private static final bivx[] e = { jdField_b_of_type_Bivx, jdField_c_of_type_Bivx };
  public final int a;
  private boolean jdField_a_of_type_Boolean;
  public final int b;
  
  static
  {
    jdField_a_of_type_Bivx = new bivx(0, 2131689819);
    jdField_b_of_type_Bivx = new bivx(1, 2131689820);
    jdField_c_of_type_Bivx = new bivx(2, 2131689818);
    jdField_a_of_type_ArrayOfBivx = new bivx[] { jdField_a_of_type_Bivx, jdField_b_of_type_Bivx, jdField_c_of_type_Bivx };
    jdField_b_of_type_ArrayOfBivx = new bivx[] { jdField_a_of_type_Bivx, jdField_b_of_type_Bivx };
    jdField_c_of_type_ArrayOfBivx = new bivx[] { jdField_a_of_type_Bivx, jdField_c_of_type_Bivx };
  }
  
  bivx(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public static bivx a(bivx parambivx)
  {
    return new bivx(parambivx.jdField_a_of_type_Int, parambivx.jdField_b_of_type_Int);
  }
  
  public static boolean a(bivx parambivx1, bivx parambivx2)
  {
    return parambivx1.jdField_a_of_type_Int == parambivx2.jdField_a_of_type_Int;
  }
  
  public static bivx[] a(biim parambiim)
  {
    int i = birc.a(parambiim);
    if (i == 204) {
      return jdField_b_of_type_ArrayOfBivx;
    }
    if (i == 205) {
      return jdField_c_of_type_ArrayOfBivx;
    }
    if (i == 206) {
      return d;
    }
    if (i == 207) {
      return e;
    }
    return jdField_a_of_type_ArrayOfBivx;
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
 * Qualified Name:     bivx
 * JD-Core Version:    0.7.0.1
 */