import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class bail
  extends InputStream
  implements baii
{
  protected int a;
  protected Context a;
  protected baij a;
  protected PipedInputStream a;
  protected PipedOutputStream a;
  protected byte[] a;
  protected byte[] b;
  protected byte[] c;
  protected byte[] d = new byte[1];
  
  public bail(Context paramContext)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    return read(paramArrayOfByte, paramInt, paramArrayOfByte.length);
  }
  
  public baij a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_Baij.jdField_a_of_type_Int = 0;
    int j = paramInt2;
    int i = paramInt1;
    paramInt1 = j;
    while (paramInt2 > 0)
    {
      if (paramInt2 > 1920 - this.jdField_a_of_type_JavaIoPipedInputStream.available()) {
        paramInt1 = 1920 - this.jdField_a_of_type_JavaIoPipedInputStream.available();
      }
      a(paramArrayOfByte, i, paramInt1);
      i += paramInt1;
      paramInt1 = paramInt2 - paramInt1;
      paramInt2 = paramInt1;
    }
    return this.jdField_a_of_type_Baij;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaIoPipedOutputStream != null)
    {
      this.jdField_a_of_type_JavaIoPipedOutputStream.close();
      this.jdField_a_of_type_JavaIoPipedOutputStream = null;
    }
    close();
  }
  
  @TargetApi(9)
  public void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaIoPipedOutputStream = new PipedOutputStream();
    if (Build.VERSION.SDK_INT <= 8)
    {
      this.jdField_a_of_type_JavaIoPipedInputStream = new bhgh(this.jdField_a_of_type_JavaIoPipedOutputStream, 1920);
      return;
    }
    this.jdField_a_of_type_JavaIoPipedInputStream = new PipedInputStream(this.jdField_a_of_type_JavaIoPipedOutputStream, 1920);
  }
  
  protected void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaIoPipedOutputStream.write(paramArrayOfByte, paramInt1, paramInt2);
    while (this.jdField_a_of_type_JavaIoPipedInputStream.available() >= this.jdField_a_of_type_Int)
    {
      paramInt1 = a(this.c, this.jdField_a_of_type_Baij.jdField_a_of_type_Int);
      paramArrayOfByte = this.jdField_a_of_type_Baij;
      paramArrayOfByte.jdField_a_of_type_Int = (paramInt1 + paramArrayOfByte.jdField_a_of_type_Int);
    }
  }
  
  public void close()
  {
    if (this.jdField_a_of_type_JavaIoPipedInputStream != null)
    {
      this.jdField_a_of_type_JavaIoPipedInputStream.close();
      this.jdField_a_of_type_JavaIoPipedInputStream = null;
    }
  }
  
  public int read()
  {
    if (read(this.d, 0, 1) == 1) {
      return this.d[0] & 0xFF;
    }
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bail
 * JD-Core Version:    0.7.0.1
 */