import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.io.InputStream;

public class bhcg
  extends InputStream
{
  private int jdField_a_of_type_Int;
  private InputStream jdField_a_of_type_JavaIoInputStream;
  private boolean jdField_a_of_type_Boolean = true;
  private int jdField_b_of_type_Int;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  public bhcg(InputStream paramInputStream)
  {
    this.jdField_a_of_type_JavaIoInputStream = paramInputStream;
  }
  
  private static int a(InputStream paramInputStream)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (paramInputStream == null) {
      return -1;
    }
    int i = 0;
    for (;;)
    {
      if (i != -1)
      {
        int j = paramInputStream.read();
        if (j == 123)
        {
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.d("ChunkedInputStream", 1, "Server did not return any chunk");
          return -1;
        }
        switch (i)
        {
        default: 
          break;
        case 0: 
          if (j == 13) {
            i = 1;
          } else {
            localStringBuilder.append((char)j);
          }
          break;
        case 1: 
          if (j == 10) {
            i = -1;
          } else {
            throw new IOException("Read CRLF invalid!");
          }
          break;
        }
      }
    }
    return Integer.parseInt(localStringBuilder.toString(), 16);
  }
  
  private boolean a()
  {
    if (!this.jdField_a_of_type_Boolean) {}
    for (boolean bool = b();; bool = false)
    {
      this.jdField_a_of_type_Int = a(this.jdField_a_of_type_JavaIoInputStream);
      this.jdField_a_of_type_Boolean = false;
      this.jdField_b_of_type_Int = 0;
      if (this.jdField_a_of_type_Int == 0) {
        this.jdField_b_of_type_Boolean = true;
      }
      return (this.jdField_a_of_type_Int >= 0) && (bool);
    }
  }
  
  private boolean b()
  {
    int i = this.jdField_a_of_type_JavaIoInputStream.read();
    int j = this.jdField_a_of_type_JavaIoInputStream.read();
    return (i == 13) && (j == 10);
  }
  
  public byte[] a()
  {
    boolean bool = true;
    if (!this.jdField_a_of_type_Boolean) {
      bool = b();
    }
    this.jdField_a_of_type_Boolean = false;
    if (this.jdField_a_of_type_JavaIoInputStream == null) {
      return new byte[0];
    }
    this.jdField_a_of_type_Int = a(this.jdField_a_of_type_JavaIoInputStream);
    if (4 == this.jdField_a_of_type_Int) {
      read(new byte[4], 0, 4);
    }
    if ((this.jdField_a_of_type_Int <= 0) || (!bool)) {
      return new byte[0];
    }
    byte[] arrayOfByte = new byte[this.jdField_a_of_type_Int];
    int i = this.jdField_a_of_type_Int;
    int j;
    do
    {
      j = read(arrayOfByte, this.jdField_b_of_type_Int, i);
      if (j < 0) {
        return new byte[0];
      }
      j = i - j;
      i = j;
    } while (j > 0);
    return arrayOfByte;
  }
  
  public int read()
  {
    if (this.c) {
      throw new IOException("Attempted read from closed stream.");
    }
    if (this.jdField_b_of_type_Boolean) {}
    do
    {
      return -1;
      if (this.jdField_b_of_type_Int < this.jdField_a_of_type_Int) {
        break;
      }
      a();
    } while (this.jdField_b_of_type_Boolean);
    this.jdField_b_of_type_Int += 1;
    return this.jdField_a_of_type_JavaIoInputStream.read();
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int j = -1;
    if (this.c) {
      throw new IOException("Attempted read from closed stream.");
    }
    int i;
    if (this.jdField_b_of_type_Boolean) {
      i = j;
    }
    do
    {
      boolean bool;
      do
      {
        do
        {
          return i;
          if (this.jdField_b_of_type_Int < this.jdField_a_of_type_Int) {
            break;
          }
          bool = a();
          i = j;
        } while (this.jdField_b_of_type_Boolean);
        i = j;
      } while (!bool);
      paramInt2 = Math.min(paramInt2, this.jdField_a_of_type_Int - this.jdField_b_of_type_Int);
      paramInt1 = this.jdField_a_of_type_JavaIoInputStream.read(paramArrayOfByte, paramInt1, paramInt2);
      this.jdField_b_of_type_Int += paramInt1;
      i = paramInt1;
    } while (this.jdField_b_of_type_Int != this.jdField_a_of_type_Int);
    this.jdField_b_of_type_Int = 0;
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhcg
 * JD-Core Version:    0.7.0.1
 */