import android.support.annotation.NonNull;
import com.tencent.commonsdk.pool.ByteArrayPool;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class bjvj
  extends FilterOutputStream
{
  private static final Object jdField_a_of_type_JavaLangObject = new Object();
  private static bjvj jdField_b_of_type_Bjvj;
  private static int c;
  protected int a;
  private bjvj jdField_a_of_type_Bjvj;
  private boolean jdField_a_of_type_Boolean;
  protected byte[] a;
  private final int jdField_b_of_type_Int = 4;
  
  private bjvj(@NonNull OutputStream paramOutputStream)
  {
    this(paramOutputStream, 8192);
  }
  
  private bjvj(@NonNull OutputStream paramOutputStream, int paramInt)
  {
    super(paramOutputStream);
    this.jdField_a_of_type_ArrayOfByte = ByteArrayPool.getGenericInstance().getBuf(paramInt);
    this.jdField_a_of_type_Boolean = true;
  }
  
  public static bjvj a(@NonNull OutputStream paramOutputStream)
  {
    bjvj localbjvj = null;
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (jdField_b_of_type_Bjvj != null)
      {
        localbjvj = jdField_b_of_type_Bjvj;
        jdField_b_of_type_Bjvj = localbjvj.jdField_a_of_type_Bjvj;
        localbjvj.jdField_a_of_type_Bjvj = null;
        c -= 1;
      }
      if (localbjvj != null)
      {
        localbjvj.out = paramOutputStream;
        localbjvj.jdField_a_of_type_Boolean = true;
        return localbjvj;
      }
    }
    return new bjvj(paramOutputStream);
  }
  
  private void a()
  {
    c();
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (c < 4)
      {
        this.jdField_a_of_type_Bjvj = jdField_b_of_type_Bjvj;
        jdField_b_of_type_Bjvj = this;
        c += 1;
      }
      return;
    }
  }
  
  public static void a(int paramInt1, int paramInt2, int paramInt3)
  {
    if (((paramInt2 | paramInt3) < 0) || (paramInt2 > paramInt1) || (paramInt1 - paramInt2 < paramInt3)) {
      throw new IndexOutOfBoundsException("length=" + paramInt1 + "; regionStart=" + paramInt2 + "; regionLength=" + paramInt3);
    }
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_Boolean) {
      throw new IOException("BufferedOutputStream is closed");
    }
  }
  
  private void c()
  {
    this.jdField_a_of_type_Int = 0;
    this.out = null;
    this.jdField_a_of_type_Boolean = false;
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_Int > 0)
    {
      this.out.write(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int);
      this.jdField_a_of_type_Int = 0;
    }
  }
  
  public void close()
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Boolean;
      if (bool) {
        break label14;
      }
    }
    finally
    {
      try
      {
        for (;;)
        {
          label14:
          super.close();
          a();
        }
      }
      finally
      {
        a();
      }
      localObject1 = finally;
    }
  }
  
  public void flush()
  {
    try
    {
      b();
      d();
      this.out.flush();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void write(int paramInt)
  {
    try
    {
      b();
      if (this.jdField_a_of_type_Int == this.jdField_a_of_type_ArrayOfByte.length)
      {
        this.out.write(this.jdField_a_of_type_ArrayOfByte, 0, this.jdField_a_of_type_Int);
        this.jdField_a_of_type_Int = 0;
      }
      byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
      int i = this.jdField_a_of_type_Int;
      this.jdField_a_of_type_Int = (i + 1);
      arrayOfByte[i] = ((byte)paramInt);
      return;
    }
    finally {}
  }
  
  public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    try
    {
      b();
      if (paramArrayOfByte == null) {
        throw new NullPointerException("buffer == null");
      }
    }
    finally {}
    byte[] arrayOfByte = this.jdField_a_of_type_ArrayOfByte;
    if (paramInt2 >= arrayOfByte.length)
    {
      d();
      this.out.write(paramArrayOfByte, paramInt1, paramInt2);
    }
    for (;;)
    {
      return;
      a(paramArrayOfByte.length, paramInt1, paramInt2);
      if (paramInt2 > arrayOfByte.length - this.jdField_a_of_type_Int) {
        d();
      }
      System.arraycopy(paramArrayOfByte, paramInt1, arrayOfByte, this.jdField_a_of_type_Int, paramInt2);
      this.jdField_a_of_type_Int += paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bjvj
 * JD-Core Version:    0.7.0.1
 */