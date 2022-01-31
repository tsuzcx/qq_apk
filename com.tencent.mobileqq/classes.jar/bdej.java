import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

class bdej
  implements Closeable
{
  private int jdField_a_of_type_Int;
  private final InputStream jdField_a_of_type_JavaIoInputStream;
  private final Charset jdField_a_of_type_JavaNioCharsetCharset;
  private byte[] jdField_a_of_type_ArrayOfByte;
  private int b;
  
  public bdej(InputStream paramInputStream, int paramInt, Charset paramCharset)
  {
    if ((paramInputStream == null) || (paramCharset == null)) {
      throw new NullPointerException();
    }
    if (paramInt < 0) {
      throw new IllegalArgumentException("capacity <= 0");
    }
    if (!paramCharset.equals(bdef.jdField_a_of_type_JavaNioCharsetCharset)) {
      throw new IllegalArgumentException("Unsupported encoding");
    }
    this.jdField_a_of_type_JavaIoInputStream = paramInputStream;
    this.jdField_a_of_type_JavaNioCharsetCharset = paramCharset;
    this.jdField_a_of_type_ArrayOfByte = new byte[paramInt];
  }
  
  public bdej(InputStream paramInputStream, Charset paramCharset)
  {
    this(paramInputStream, 8192, paramCharset);
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_JavaIoInputStream.read(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_ArrayOfByte.length);
    if (i == -1) {
      throw new EOFException();
    }
    this.jdField_a_of_type_Int = 0;
    this.b = i;
  }
  
  public String a()
  {
    synchronized (this.jdField_a_of_type_JavaIoInputStream)
    {
      if (this.jdField_a_of_type_ArrayOfByte == null) {
        throw new IOException("LineReader is closed");
      }
    }
    if (this.jdField_a_of_type_Int >= this.b) {
      a();
    }
    int i = this.jdField_a_of_type_Int;
    for (;;)
    {
      if (i != this.b)
      {
        if (this.jdField_a_of_type_ArrayOfByte[i] != 10) {
          break label272;
        }
        if ((i == this.jdField_a_of_type_Int) || (this.jdField_a_of_type_ArrayOfByte[(i - 1)] != 13)) {
          break label267;
        }
      }
      label267:
      for (int j = i - 1;; j = i)
      {
        Object localObject2 = new String(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, j - this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaNioCharsetCharset.name());
        this.jdField_a_of_type_Int = (i + 1);
        return localObject2;
        localObject2 = new bdek(this, this.b - this.jdField_a_of_type_Int + 80);
        for (;;)
        {
          ((ByteArrayOutputStream)localObject2).write(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, this.b - this.jdField_a_of_type_Int);
          this.b = -1;
          a();
          i = this.jdField_a_of_type_Int;
          while (i != this.b)
          {
            if (this.jdField_a_of_type_ArrayOfByte[i] == 10)
            {
              if (i != this.jdField_a_of_type_Int) {
                ((ByteArrayOutputStream)localObject2).write(this.jdField_a_of_type_ArrayOfByte, this.jdField_a_of_type_Int, i - this.jdField_a_of_type_Int);
              }
              this.jdField_a_of_type_Int = (i + 1);
              localObject2 = ((ByteArrayOutputStream)localObject2).toString();
              return localObject2;
            }
            i += 1;
          }
        }
      }
      label272:
      i += 1;
    }
  }
  
  public boolean a()
  {
    return this.b == -1;
  }
  
  public void close()
  {
    synchronized (this.jdField_a_of_type_JavaIoInputStream)
    {
      if (this.jdField_a_of_type_ArrayOfByte != null)
      {
        this.jdField_a_of_type_ArrayOfByte = null;
        this.jdField_a_of_type_JavaIoInputStream.close();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     bdej
 * JD-Core Version:    0.7.0.1
 */