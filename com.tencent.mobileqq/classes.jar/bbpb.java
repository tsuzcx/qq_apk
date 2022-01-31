class bbpb
{
  private static bbpb jdField_a_of_type_Bbpb;
  private static bbpb jdField_b_of_type_Bbpb;
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int = 0;
  private int c = 9000;
  private int d = 1800;
  private int e;
  
  public bbpb(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_b_of_type_Int = 0;
    if (this.jdField_a_of_type_Int == 0) {
      this.c = 9000;
    }
    for (this.d = 1800;; this.d = 1200)
    {
      this.jdField_a_of_type_Long = 0L;
      this.e = 0;
      this.jdField_a_of_type_ArrayOfInt = new int[3];
      paramInt = 0;
      while (paramInt < 3)
      {
        this.jdField_a_of_type_ArrayOfInt[paramInt] = 0;
        paramInt += 1;
      }
      this.c = 6000;
    }
  }
  
  public static bbpb a(int paramInt)
  {
    if (paramInt == 0)
    {
      if (jdField_a_of_type_Bbpb == null) {
        jdField_a_of_type_Bbpb = new bbpb(0);
      }
      return jdField_a_of_type_Bbpb;
    }
    if (jdField_b_of_type_Bbpb == null) {
      jdField_b_of_type_Bbpb = new bbpb(1);
    }
    return jdField_b_of_type_Bbpb;
  }
  
  private void b()
  {
    int i = 0;
    while (i < 3)
    {
      this.jdField_a_of_type_ArrayOfInt[i] = 0;
      i += 1;
    }
    this.e = 0;
  }
  
  private int c()
  {
    int i = 0;
    int j = 0;
    int m;
    for (int k = 0; i < 3; k = m)
    {
      int n = j;
      m = k;
      if (this.jdField_a_of_type_ArrayOfInt[i] > 0)
      {
        m = k + 1;
        n = j + this.jdField_a_of_type_ArrayOfInt[i];
      }
      i += 1;
      j = n;
    }
    if (k > 0) {
      return j / k;
    }
    return 0;
  }
  
  public int a()
  {
    if (2 == this.jdField_b_of_type_Int) {
      return this.c;
    }
    return this.d;
  }
  
  public void a()
  {
    int j = (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
    int k = c();
    int i;
    if (this.jdField_b_of_type_Int == 2)
    {
      i = this.c;
      if (k != 0) {
        break label90;
      }
      i *= 3;
      label36:
      if (j > 100) {
        if (j <= i) {
          break label97;
        }
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ArrayOfInt[this.e] = ((int)(i * 1.2F));
      i = this.e + 1;
      this.e = i;
      this.e = (i % 3);
      return;
      i = this.d;
      break;
      label90:
      i = k * 3;
      break label36;
      label97:
      i = j;
    }
  }
  
  public int b()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    int j = mpl.a();
    int i;
    if (this.jdField_b_of_type_Int != j)
    {
      i = 1;
      this.jdField_b_of_type_Int = j;
      if (i == 0) {
        break label62;
      }
      if (this.jdField_b_of_type_Int != 2) {
        break label54;
      }
      i = this.c;
      label43:
      b();
    }
    label54:
    label62:
    do
    {
      return i;
      i = 0;
      break;
      i = this.d;
      break label43;
      j = c();
      i = j;
    } while (j > 0);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     bbpb
 * JD-Core Version:    0.7.0.1
 */