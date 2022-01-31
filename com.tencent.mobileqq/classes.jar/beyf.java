import com.tencent.qphone.base.util.QLog;
import java.io.Closeable;
import java.io.FileDescriptor;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.zip.Adler32;

public class beyf
  implements Closeable
{
  private int jdField_a_of_type_Int;
  private RandomAccessFile jdField_a_of_type_JavaIoRandomAccessFile;
  private MappedByteBuffer jdField_a_of_type_JavaNioMappedByteBuffer;
  private FileChannel jdField_a_of_type_JavaNioChannelsFileChannel;
  private Adler32 jdField_a_of_type_JavaUtilZipAdler32 = new Adler32();
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[32];
  private int jdField_b_of_type_Int;
  private RandomAccessFile jdField_b_of_type_JavaIoRandomAccessFile;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[20];
  private int jdField_c_of_type_Int;
  private RandomAccessFile jdField_c_of_type_JavaIoRandomAccessFile;
  private int jdField_d_of_type_Int;
  private RandomAccessFile jdField_d_of_type_JavaIoRandomAccessFile;
  private int jdField_e_of_type_Int;
  private RandomAccessFile jdField_e_of_type_JavaIoRandomAccessFile;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  
  public beyf(String paramString, int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3)
  {
    this.jdField_a_of_type_JavaIoRandomAccessFile = new RandomAccessFile(paramString + ".idx", "rw");
    this.jdField_b_of_type_JavaIoRandomAccessFile = new RandomAccessFile(paramString + ".0", "rw");
    this.jdField_c_of_type_JavaIoRandomAccessFile = new RandomAccessFile(paramString + ".1", "rw");
    this.f = paramInt3;
    if ((!paramBoolean) && (a())) {}
    do
    {
      return;
      a(paramInt1, paramInt2);
    } while (a());
    c();
    throw new IOException("unable to load index");
  }
  
  static int a(byte[] paramArrayOfByte, int paramInt)
  {
    return paramArrayOfByte[paramInt] & 0xFF | (paramArrayOfByte[(paramInt + 1)] & 0xFF) << 8 | (paramArrayOfByte[(paramInt + 2)] & 0xFF) << 16 | (paramArrayOfByte[(paramInt + 3)] & 0xFF) << 24;
  }
  
  static long a(byte[] paramArrayOfByte, int paramInt)
  {
    long l = paramArrayOfByte[(paramInt + 7)] & 0xFF;
    int k = 6;
    while (k >= 0)
    {
      l = l << 8 | paramArrayOfByte[(paramInt + k)] & 0xFF;
      k -= 1;
    }
    return l;
  }
  
  private void a(int paramInt)
  {
    byte[] arrayOfByte = new byte[1024];
    this.jdField_a_of_type_JavaNioMappedByteBuffer.position(paramInt);
    paramInt = this.jdField_a_of_type_Int * 12;
    while (paramInt > 0)
    {
      int k = Math.min(paramInt, 1024);
      this.jdField_a_of_type_JavaNioMappedByteBuffer.put(arrayOfByte, 0, k);
      paramInt -= k;
    }
  }
  
  private void a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(0L);
    this.jdField_a_of_type_JavaIoRandomAccessFile.setLength(paramInt1 * 12 * 2 + 32);
    this.jdField_a_of_type_JavaIoRandomAccessFile.seek(0L);
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    a(arrayOfByte, 0, -1289277377);
    a(arrayOfByte, 4, paramInt1);
    a(arrayOfByte, 8, paramInt2);
    a(arrayOfByte, 12, 0);
    a(arrayOfByte, 16, 0);
    a(arrayOfByte, 20, 4);
    a(arrayOfByte, 24, this.f);
    a(arrayOfByte, 28, a(arrayOfByte, 0, 28));
    this.jdField_a_of_type_JavaIoRandomAccessFile.write(arrayOfByte);
    this.jdField_b_of_type_JavaIoRandomAccessFile.setLength(0L);
    this.jdField_c_of_type_JavaIoRandomAccessFile.setLength(0L);
    this.jdField_b_of_type_JavaIoRandomAccessFile.seek(0L);
    this.jdField_c_of_type_JavaIoRandomAccessFile.seek(0L);
    a(arrayOfByte, 0, -1121680097);
    this.jdField_b_of_type_JavaIoRandomAccessFile.write(arrayOfByte, 0, 4);
    this.jdField_c_of_type_JavaIoRandomAccessFile.write(arrayOfByte, 0, 4);
  }
  
  private void a(long paramLong, byte[] paramArrayOfByte, int paramInt)
  {
    byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    int k = a(paramArrayOfByte, 0, paramInt);
    a(arrayOfByte, 0, paramLong);
    a(arrayOfByte, 8, k);
    a(arrayOfByte, 12, this.jdField_e_of_type_Int);
    a(arrayOfByte, 16, paramInt);
    this.jdField_d_of_type_JavaIoRandomAccessFile.write(arrayOfByte);
    this.jdField_d_of_type_JavaIoRandomAccessFile.write(paramArrayOfByte, 0, paramInt);
    this.jdField_a_of_type_JavaNioMappedByteBuffer.putLong(this.i, paramLong);
    this.jdField_a_of_type_JavaNioMappedByteBuffer.putInt(this.i + 8, this.jdField_e_of_type_Int);
    this.jdField_e_of_type_Int += paramInt + 20;
    a(this.jdField_a_of_type_ArrayOfByte, 20, this.jdField_e_of_type_Int);
  }
  
  static void a(Closeable paramCloseable)
  {
    if (paramCloseable == null) {
      return;
    }
    try
    {
      paramCloseable.close();
      return;
    }
    catch (Throwable paramCloseable) {}
  }
  
  static void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int m = 0;
    int k = paramInt2;
    paramInt2 = m;
    while (paramInt2 < 4)
    {
      paramArrayOfByte[(paramInt1 + paramInt2)] = ((byte)(k & 0xFF));
      k >>= 8;
      paramInt2 += 1;
    }
  }
  
  static void a(byte[] paramArrayOfByte, int paramInt, long paramLong)
  {
    int k = 0;
    while (k < 8)
    {
      paramArrayOfByte[(paramInt + k)] = ((byte)(int)(0xFF & paramLong));
      paramLong >>= 8;
      k += 1;
    }
  }
  
  private boolean a()
  {
    try
    {
      this.jdField_a_of_type_JavaIoRandomAccessFile.seek(0L);
      this.jdField_b_of_type_JavaIoRandomAccessFile.seek(0L);
      this.jdField_c_of_type_JavaIoRandomAccessFile.seek(0L);
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      if (this.jdField_a_of_type_JavaIoRandomAccessFile.read(arrayOfByte) != 32) {
        return false;
      }
      if (a(arrayOfByte, 0) != -1289277377) {
        return false;
      }
      if (a(arrayOfByte, 24) != this.f) {
        return false;
      }
      this.jdField_a_of_type_Int = a(arrayOfByte, 4);
      this.jdField_b_of_type_Int = a(arrayOfByte, 8);
      this.jdField_c_of_type_Int = a(arrayOfByte, 12);
      this.jdField_d_of_type_Int = a(arrayOfByte, 16);
      this.jdField_e_of_type_Int = a(arrayOfByte, 20);
      int k = a(arrayOfByte, 28);
      if (a(arrayOfByte, 0, 28) != k) {
        return false;
      }
      if (this.jdField_a_of_type_Int <= 0) {
        return false;
      }
      if (this.jdField_b_of_type_Int <= 0) {
        return false;
      }
      if ((this.jdField_c_of_type_Int != 0) && (this.jdField_c_of_type_Int != 1)) {
        return false;
      }
      if ((this.jdField_d_of_type_Int >= 0) && (this.jdField_d_of_type_Int <= this.jdField_a_of_type_Int))
      {
        if ((this.jdField_e_of_type_Int < 4) || (this.jdField_e_of_type_Int > this.jdField_b_of_type_Int)) {
          break label365;
        }
        if (this.jdField_a_of_type_JavaIoRandomAccessFile.length() != this.jdField_a_of_type_Int * 12 * 2 + 32) {
          return false;
        }
        arrayOfByte = new byte[4];
        if (this.jdField_b_of_type_JavaIoRandomAccessFile.read(arrayOfByte) != 4) {
          return false;
        }
        if (a(arrayOfByte, 0) != -1121680097) {
          return false;
        }
        if (this.jdField_c_of_type_JavaIoRandomAccessFile.read(arrayOfByte) != 4) {
          return false;
        }
        if (a(arrayOfByte, 0) != -1121680097) {
          return false;
        }
        this.jdField_a_of_type_JavaNioChannelsFileChannel = this.jdField_a_of_type_JavaIoRandomAccessFile.getChannel();
        this.jdField_a_of_type_JavaNioMappedByteBuffer = this.jdField_a_of_type_JavaNioChannelsFileChannel.map(FileChannel.MapMode.READ_WRITE, 0L, this.jdField_a_of_type_JavaIoRandomAccessFile.length());
        this.jdField_a_of_type_JavaNioMappedByteBuffer.order(ByteOrder.LITTLE_ENDIAN);
        d();
        return true;
      }
    }
    catch (IOException localIOException)
    {
      QLog.e("BlobCache", 2, "loadIndex failed.", localIOException);
      return false;
    }
    return false;
    label365:
    return false;
  }
  
  private boolean a(long paramLong, int paramInt)
  {
    int m = (int)(paramLong % this.jdField_a_of_type_Int);
    int k = m;
    if (m < 0) {
      k = m + this.jdField_a_of_type_Int;
    }
    int n = k;
    for (;;)
    {
      m = n * 12 + paramInt;
      long l = this.jdField_a_of_type_JavaNioMappedByteBuffer.getLong(m);
      int i1 = this.jdField_a_of_type_JavaNioMappedByteBuffer.getInt(m + 8);
      if (i1 == 0)
      {
        this.i = m;
        return false;
      }
      if (l == paramLong)
      {
        this.i = m;
        this.j = i1;
        return true;
      }
      n += 1;
      m = n;
      if (n >= this.jdField_a_of_type_Int) {
        m = 0;
      }
      n = m;
      if (m == k)
      {
        this.jdField_a_of_type_JavaNioMappedByteBuffer.putInt(m * 12 + paramInt + 8, 0);
        n = m;
      }
    }
  }
  
  private boolean a(RandomAccessFile paramRandomAccessFile, int paramInt, beyg parambeyg)
  {
    byte[] arrayOfByte = this.jdField_b_of_type_ArrayOfByte;
    long l1 = paramRandomAccessFile.getFilePointer();
    long l2 = paramInt;
    try
    {
      paramRandomAccessFile.seek(l2);
      int k = paramRandomAccessFile.read(arrayOfByte);
      if (k != 20) {
        return false;
      }
      l2 = a(arrayOfByte, 0);
      long l3 = parambeyg.jdField_a_of_type_Long;
      if (l2 != l3) {
        return false;
      }
      k = a(arrayOfByte, 8);
      int m = a(arrayOfByte, 12);
      if (m != paramInt) {
        return false;
      }
      m = a(arrayOfByte, 16);
      if (m >= 0)
      {
        int n = this.jdField_b_of_type_Int;
        if (m <= n - paramInt - 20) {}
      }
      else
      {
        return false;
      }
      if ((parambeyg.jdField_a_of_type_ArrayOfByte == null) || (parambeyg.jdField_a_of_type_ArrayOfByte.length < m)) {
        parambeyg.jdField_a_of_type_ArrayOfByte = new byte[m];
      }
      arrayOfByte = parambeyg.jdField_a_of_type_ArrayOfByte;
      parambeyg.jdField_a_of_type_Int = m;
      paramInt = paramRandomAccessFile.read(arrayOfByte, 0, m);
      if (paramInt != m) {
        return false;
      }
      paramInt = a(arrayOfByte, 0, m);
      return paramInt == k;
    }
    catch (Throwable parambeyg)
    {
      QLog.e("BlobCache", 2, "getBlob failed.", parambeyg);
      return false;
    }
    finally
    {
      paramRandomAccessFile.seek(l1);
    }
  }
  
  private void c()
  {
    a(this.jdField_a_of_type_JavaNioChannelsFileChannel);
    a(this.jdField_a_of_type_JavaIoRandomAccessFile);
    a(this.jdField_b_of_type_JavaIoRandomAccessFile);
    a(this.jdField_c_of_type_JavaIoRandomAccessFile);
  }
  
  private void d()
  {
    if (this.jdField_c_of_type_Int == 0)
    {
      localRandomAccessFile = this.jdField_b_of_type_JavaIoRandomAccessFile;
      this.jdField_d_of_type_JavaIoRandomAccessFile = localRandomAccessFile;
      if (this.jdField_c_of_type_Int != 1) {
        break label103;
      }
    }
    label103:
    for (RandomAccessFile localRandomAccessFile = this.jdField_b_of_type_JavaIoRandomAccessFile;; localRandomAccessFile = this.jdField_c_of_type_JavaIoRandomAccessFile)
    {
      this.jdField_e_of_type_JavaIoRandomAccessFile = localRandomAccessFile;
      this.jdField_d_of_type_JavaIoRandomAccessFile.setLength(this.jdField_e_of_type_Int);
      this.jdField_d_of_type_JavaIoRandomAccessFile.seek(this.jdField_e_of_type_Int);
      this.g = 32;
      this.h = 32;
      if (this.jdField_c_of_type_Int != 0) {
        break label111;
      }
      this.h += this.jdField_a_of_type_Int * 12;
      return;
      localRandomAccessFile = this.jdField_c_of_type_JavaIoRandomAccessFile;
      break;
    }
    label111:
    this.g += this.jdField_a_of_type_Int * 12;
  }
  
  private void e()
  {
    this.jdField_c_of_type_Int = (1 - this.jdField_c_of_type_Int);
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 4;
    a(this.jdField_a_of_type_ArrayOfByte, 12, this.jdField_c_of_type_Int);
    a(this.jdField_a_of_type_ArrayOfByte, 16, this.jdField_d_of_type_Int);
    a(this.jdField_a_of_type_ArrayOfByte, 20, this.jdField_e_of_type_Int);
    f();
    d();
    a(this.g);
    a();
  }
  
  private void f()
  {
    a(this.jdField_a_of_type_ArrayOfByte, 28, a(this.jdField_a_of_type_ArrayOfByte, 0, 28));
    this.jdField_a_of_type_JavaNioMappedByteBuffer.position(0);
    this.jdField_a_of_type_JavaNioMappedByteBuffer.put(this.jdField_a_of_type_ArrayOfByte);
  }
  
  int a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaUtilZipAdler32.reset();
    this.jdField_a_of_type_JavaUtilZipAdler32.update(paramArrayOfByte, paramInt1, paramInt2);
    return (int)this.jdField_a_of_type_JavaUtilZipAdler32.getValue();
  }
  
  public void a()
  {
    try
    {
      this.jdField_a_of_type_JavaNioMappedByteBuffer.force();
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  public void a(long paramLong, byte[] paramArrayOfByte)
  {
    if (paramArrayOfByte.length + 24 > this.jdField_b_of_type_Int) {
      throw new RuntimeException("blob is too large!");
    }
    if ((this.jdField_e_of_type_Int + 20 + paramArrayOfByte.length > this.jdField_b_of_type_Int) || (this.jdField_d_of_type_Int * 2 >= this.jdField_a_of_type_Int)) {
      e();
    }
    if (!a(paramLong, this.g))
    {
      this.jdField_d_of_type_Int += 1;
      a(this.jdField_a_of_type_ArrayOfByte, 16, this.jdField_d_of_type_Int);
    }
    a(paramLong, paramArrayOfByte, paramArrayOfByte.length);
    f();
  }
  
  public boolean a(beyg parambeyg)
  {
    if ((a(parambeyg.jdField_a_of_type_Long, this.g)) && (a(this.jdField_d_of_type_JavaIoRandomAccessFile, this.j, parambeyg))) {}
    int k;
    do
    {
      return true;
      k = this.i;
      if ((!a(parambeyg.jdField_a_of_type_Long, this.h)) || (!a(this.jdField_e_of_type_JavaIoRandomAccessFile, this.j, parambeyg))) {
        break;
      }
    } while ((this.jdField_e_of_type_Int + 20 + parambeyg.jdField_a_of_type_Int > this.jdField_b_of_type_Int) || (this.jdField_d_of_type_Int * 2 >= this.jdField_a_of_type_Int));
    this.i = k;
    try
    {
      a(parambeyg.jdField_a_of_type_Long, parambeyg.jdField_a_of_type_ArrayOfByte, parambeyg.jdField_a_of_type_Int);
      this.jdField_d_of_type_Int += 1;
      a(this.jdField_a_of_type_ArrayOfByte, 16, this.jdField_d_of_type_Int);
      f();
      return true;
    }
    catch (Throwable parambeyg)
    {
      QLog.e("BlobCache", 2, "cannot copy over");
      return true;
    }
    return false;
  }
  
  public void b()
  {
    a();
    try
    {
      this.jdField_b_of_type_JavaIoRandomAccessFile.getFD().sync();
      try
      {
        label14:
        this.jdField_c_of_type_JavaIoRandomAccessFile.getFD().sync();
        return;
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      break label14;
    }
  }
  
  public void close()
  {
    b();
    c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     beyf
 * JD-Core Version:    0.7.0.1
 */