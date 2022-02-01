public abstract class aorq
{
  protected final byte a;
  protected final int a;
  private final int b;
  private final int c;
  private final int d;
  
  protected aorq(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.jdField_a_of_type_Byte = 61;
    this.b = paramInt1;
    this.c = paramInt2;
    if ((paramInt3 > 0) && (paramInt4 > 0)) {}
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      if (paramInt1 != 0) {
        i = paramInt3 / paramInt2 * paramInt2;
      }
      this.jdField_a_of_type_Int = i;
      this.d = paramInt4;
      return;
    }
  }
  
  private byte[] a(aorr paramaorr)
  {
    if (paramaorr.jdField_a_of_type_ArrayOfByte == null)
    {
      paramaorr.jdField_a_of_type_ArrayOfByte = new byte[a()];
      paramaorr.b = 0;
      paramaorr.c = 0;
    }
    for (;;)
    {
      return paramaorr.jdField_a_of_type_ArrayOfByte;
      byte[] arrayOfByte = new byte[paramaorr.jdField_a_of_type_ArrayOfByte.length * 2];
      System.arraycopy(paramaorr.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, paramaorr.jdField_a_of_type_ArrayOfByte.length);
      paramaorr.jdField_a_of_type_ArrayOfByte = arrayOfByte;
    }
  }
  
  protected int a()
  {
    return 8192;
  }
  
  int a(aorr paramaorr)
  {
    if (paramaorr.jdField_a_of_type_ArrayOfByte != null) {
      return paramaorr.b - paramaorr.c;
    }
    return 0;
  }
  
  int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, aorr paramaorr)
  {
    if (paramaorr.jdField_a_of_type_ArrayOfByte != null)
    {
      paramInt2 = Math.min(a(paramaorr), paramInt2);
      System.arraycopy(paramaorr.jdField_a_of_type_ArrayOfByte, paramaorr.c, paramArrayOfByte, paramInt1, paramInt2);
      paramaorr.c += paramInt2;
      if (paramaorr.c >= paramaorr.b) {
        paramaorr.jdField_a_of_type_ArrayOfByte = null;
      }
      return paramInt2;
    }
    if (paramaorr.jdField_a_of_type_Boolean) {
      return -1;
    }
    return 0;
  }
  
  abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, aorr paramaorr);
  
  protected abstract boolean a(byte paramByte);
  
  protected boolean a(byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte == null) {}
    for (;;)
    {
      return false;
      int j = paramArrayOfByte.length;
      int i = 0;
      while (i < j)
      {
        byte b1 = paramArrayOfByte[i];
        if ((61 == b1) || (a(b1))) {
          return true;
        }
        i += 1;
      }
    }
  }
  
  protected byte[] a(int paramInt, aorr paramaorr)
  {
    if ((paramaorr.jdField_a_of_type_ArrayOfByte == null) || (paramaorr.jdField_a_of_type_ArrayOfByte.length < paramaorr.b + paramInt)) {
      return a(paramaorr);
    }
    return paramaorr.jdField_a_of_type_ArrayOfByte;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    aorr localaorr = new aorr();
    a(paramArrayOfByte, 0, paramArrayOfByte.length, localaorr);
    a(paramArrayOfByte, 0, -1, localaorr);
    paramArrayOfByte = new byte[localaorr.b];
    a(paramArrayOfByte, 0, paramArrayOfByte.length, localaorr);
    return paramArrayOfByte;
  }
  
  public byte[] b(String paramString)
  {
    return a(paramString.getBytes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aorq
 * JD-Core Version:    0.7.0.1
 */