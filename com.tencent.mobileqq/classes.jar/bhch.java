import java.io.DataOutputStream;
import java.io.OutputStream;

public class bhch
  extends DataOutputStream
{
  private static final byte[] c = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private static final byte[] d = { 13, 10 };
  private static final byte[] e = { 48, 13, 10 };
  protected int a;
  protected byte[] a;
  protected int b;
  protected byte[] b;
  
  public bhch(OutputStream paramOutputStream)
  {
    this(new byte[512], paramOutputStream);
  }
  
  public bhch(byte[] paramArrayOfByte, OutputStream paramOutputStream)
  {
    super(paramOutputStream);
    this.jdField_b_of_type_Int = -1;
    this.jdField_b_of_type_ArrayOfByte = new byte[32];
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_b_of_type_Int = paramArrayOfByte.length;
  }
  
  protected void a()
  {
    this.out.write(e, 0, 3);
    this.out.write(d, 0, 2);
    this.out.flush();
  }
  
  protected final void a(int paramInt)
  {
    if (this.jdField_a_of_type_Int + 1 >= this.jdField_b_of_type_Int) {
      b();
    }
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    int i = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_Int = (i + 1);
    arrayOfByte[i] = ((byte)(paramInt & 0xFF));
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      b();
      a();
      super.close();
      return;
    }
    b();
    a();
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 0) {
      return;
    }
    int i = 3;
    this.jdField_b_of_type_ArrayOfByte[30] = 13;
    this.jdField_b_of_type_ArrayOfByte[31] = 10;
    int j = paramInt2;
    while (j > 15)
    {
      this.jdField_b_of_type_ArrayOfByte[(32 - i)] = c[(j % 16)];
      j >>= 4;
      i += 1;
    }
    this.jdField_b_of_type_ArrayOfByte[(32 - i)] = c[j];
    this.out.write(this.jdField_b_of_type_ArrayOfByte, 32 - i, i);
    this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    this.out.write(d, 0, 2);
    this.out.flush();
  }
  
  protected void b()
  {
    if (this.jdField_a_of_type_Int == 0) {
      return;
    }
    a(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int);
    this.jdField_a_of_type_Int = 0;
  }
  
  public final void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_Int + paramInt2 >= this.jdField_b_of_type_Int) {
      b();
    }
    if (paramInt2 < this.jdField_a_of_type_ArrayOfByte.length)
    {
      System.arraycopy(paramArrayOfByte, paramInt1, this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, paramInt2);
      this.jdField_a_of_type_Int += paramInt2;
      return;
    }
    a(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public void close()
  {
    a(true);
  }
  
  public void flush()
  {
    b();
    super.flush();
  }
  
  public void write(int paramInt)
  {
    a(paramInt);
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    b(paramArrayOfByte, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhch
 * JD-Core Version:    0.7.0.1
 */