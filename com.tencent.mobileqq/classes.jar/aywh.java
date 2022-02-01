import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;

public class aywh
{
  private static void a(InputStream paramInputStream)
  {
    if (paramInputStream != null) {}
    try
    {
      paramInputStream.close();
      return;
    }
    catch (IOException paramInputStream) {}
  }
  
  public static void a(InputStream paramInputStream, OutputStream paramOutputStream)
  {
    try
    {
      paramInputStream = new GZIPInputStream(paramInputStream);
      try
      {
        byte[] arrayOfByte = new byte[1024];
        for (;;)
        {
          int i = paramInputStream.read(arrayOfByte, 0, 1024);
          if (i == -1) {
            break;
          }
          paramOutputStream.write(arrayOfByte, 0, i);
        }
        a(paramOutputStream);
      }
      finally
      {
        paramOutputStream = paramInputStream;
        paramInputStream = localObject;
      }
    }
    finally
    {
      for (;;)
      {
        paramOutputStream = null;
      }
    }
    throw paramInputStream;
    a(paramInputStream);
  }
  
  public static byte[] a(byte[] paramArrayOfByte)
  {
    paramArrayOfByte = new ByteArrayInputStream(paramArrayOfByte);
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
    a(paramArrayOfByte, localByteArrayOutputStream);
    byte[] arrayOfByte = localByteArrayOutputStream.toByteArray();
    localByteArrayOutputStream.flush();
    localByteArrayOutputStream.close();
    paramArrayOfByte.close();
    return arrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aywh
 * JD-Core Version:    0.7.0.1
 */