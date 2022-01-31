import java.io.File;
import java.io.RandomAccessFile;

public class apif
  extends RandomAccessFile
{
  private final byte[] a = new byte[8];
  
  public apif(String paramString1, String paramString2)
  {
    super(new File(paramString1), paramString2);
  }
  
  public int read()
  {
    int i = -1;
    if (read(this.a, 0, 1) != -1) {
      i = this.a[0] & 0xFF;
    }
    return i;
  }
  
  public int read(byte[] paramArrayOfByte)
  {
    return read(paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    long l = super.getFilePointer();
    paramInt2 = super.read(paramArrayOfByte, paramInt1, paramInt2);
    if (paramInt2 > -1) {
      apih.a(paramArrayOfByte, paramInt1, paramInt2, l);
    }
    return paramInt2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apif
 * JD-Core Version:    0.7.0.1
 */