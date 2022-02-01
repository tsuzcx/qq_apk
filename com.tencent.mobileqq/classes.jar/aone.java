public abstract class aone
{
  protected final byte a;
  protected final int a;
  private final int b;
  private final int c;
  private final int d;
  
  protected aone(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
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
  
  private byte[] a(aonf paramaonf)
  {
    if (paramaonf.jdField_a_of_type_ArrayOfByte == null)
    {
      paramaonf.jdField_a_of_type_ArrayOfByte = new byte[a()];
      paramaonf.b = 0;
      paramaonf.c = 0;
    }
    for (;;)
    {
      return paramaonf.jdField_a_of_type_ArrayOfByte;
      byte[] arrayOfByte = new byte[paramaonf.jdField_a_of_type_ArrayOfByte.length * 2];
      System.arraycopy(paramaonf.jdField_a_of_type_ArrayOfByte, 0, arrayOfByte, 0, paramaonf.jdField_a_of_type_ArrayOfByte.length);
      paramaonf.jdField_a_of_type_ArrayOfByte = arrayOfByte;
    }
  }
  
  protected int a()
  {
    return 8192;
  }
  
  int a(aonf paramaonf)
  {
    if (paramaonf.jdField_a_of_type_ArrayOfByte != null) {
      return paramaonf.b - paramaonf.c;
    }
    return 0;
  }
  
  int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, aonf paramaonf)
  {
    if (paramaonf.jdField_a_of_type_ArrayOfByte != null)
    {
      paramInt2 = Math.min(a(paramaonf), paramInt2);
      System.arraycopy(paramaonf.jdField_a_of_type_ArrayOfByte, paramaonf.c, paramArrayOfByte, paramInt1, paramInt2);
      paramaonf.c += paramInt2;
      if (paramaonf.c >= paramaonf.b) {
        paramaonf.jdField_a_of_type_ArrayOfByte = null;
      }
      return paramInt2;
    }
    if (paramaonf.jdField_a_of_type_Boolean) {
      return -1;
    }
    return 0;
  }
  
  abstract void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, aonf paramaonf);
  
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
  
  protected byte[] a(int paramInt, aonf paramaonf)
  {
    if ((paramaonf.jdField_a_of_type_ArrayOfByte == null) || (paramaonf.jdField_a_of_type_ArrayOfByte.length < paramaonf.b + paramInt)) {
      return a(paramaonf);
    }
    return paramaonf.jdField_a_of_type_ArrayOfByte;
  }
  
  public byte[] a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length == 0)) {
      return paramArrayOfByte;
    }
    aonf localaonf = new aonf();
    a(paramArrayOfByte, 0, paramArrayOfByte.length, localaonf);
    a(paramArrayOfByte, 0, -1, localaonf);
    paramArrayOfByte = new byte[localaonf.b];
    a(paramArrayOfByte, 0, paramArrayOfByte.length, localaonf);
    return paramArrayOfByte;
  }
  
  public byte[] b(String paramString)
  {
    return a(paramString.getBytes());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aone
 * JD-Core Version:    0.7.0.1
 */