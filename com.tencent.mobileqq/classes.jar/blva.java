import android.util.Pair;
import cooperation.qzone.util.QZLog;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class blva
  implements Closeable
{
  public blvc a;
  private final FileInputStream jdField_a_of_type_JavaIoFileInputStream;
  private final Map<String, blve> jdField_a_of_type_JavaUtilMap = new HashMap();
  public blvd[] a;
  public blve[] a;
  
  public blva(File paramFile)
  {
    this.jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(paramFile);
    Object localObject = this.jdField_a_of_type_JavaIoFileInputStream.getChannel();
    this.jdField_a_of_type_Blvc = new blvc((FileChannel)localObject, null);
    ByteBuffer localByteBuffer = ByteBuffer.allocate(128);
    localByteBuffer.limit(this.jdField_a_of_type_Blvc.d);
    if (this.jdField_a_of_type_Blvc.a[5] == 1) {}
    for (paramFile = ByteOrder.LITTLE_ENDIAN;; paramFile = ByteOrder.BIG_ENDIAN)
    {
      localByteBuffer.order(paramFile);
      ((FileChannel)localObject).position(this.jdField_a_of_type_Blvc.b);
      this.jdField_a_of_type_ArrayOfBlvd = new blvd[this.jdField_a_of_type_Blvc.e];
      i = 0;
      while (i < this.jdField_a_of_type_ArrayOfBlvd.length)
      {
        a((FileChannel)localObject, localByteBuffer, "failed to read phdr.");
        this.jdField_a_of_type_ArrayOfBlvd[i] = new blvd(localByteBuffer, this.jdField_a_of_type_Blvc.a[4], null);
        i += 1;
      }
    }
    ((FileChannel)localObject).position(this.jdField_a_of_type_Blvc.c);
    localByteBuffer.limit(this.jdField_a_of_type_Blvc.f);
    this.jdField_a_of_type_ArrayOfBlve = new blve[this.jdField_a_of_type_Blvc.g];
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfBlve.length)
    {
      a((FileChannel)localObject, localByteBuffer, "failed to read shdr.");
      this.jdField_a_of_type_ArrayOfBlve[i] = new blve(localByteBuffer, this.jdField_a_of_type_Blvc.a[4], null);
      i += 1;
    }
    if (this.jdField_a_of_type_Blvc.h > 0)
    {
      paramFile = a(this.jdField_a_of_type_ArrayOfBlve[this.jdField_a_of_type_Blvc.h]);
      localObject = this.jdField_a_of_type_ArrayOfBlve;
      int k = localObject.length;
      i = j;
      while (i < k)
      {
        localByteBuffer = localObject[i];
        paramFile.position(localByteBuffer.jdField_a_of_type_Int);
        localByteBuffer.jdField_a_of_type_JavaLangString = a(paramFile);
        this.jdField_a_of_type_JavaUtilMap.put(localByteBuffer.jdField_a_of_type_JavaLangString, localByteBuffer);
        i += 1;
      }
    }
  }
  
  public static Pair<Integer, Throwable> a(File paramFile)
  {
    int i = 0;
    for (;;)
    {
      try
      {
        paramFile = new blva(paramFile);
        if (paramFile == null) {}
      }
      catch (IOException paramFile)
      {
        Object localObject1 = paramFile.getMessage();
        if (localObject1 == null) {
          continue;
        }
        if (!((String)localObject1).startsWith("bad elf magic")) {
          continue;
        }
        i = -1;
        localObject1 = new Pair(Integer.valueOf(i), paramFile);
        paramFile = (File)localObject1;
        if (0 == 0) {
          continue;
        }
        try
        {
          throw new NullPointerException();
        }
        catch (IOException paramFile)
        {
          QZLog.e("ShareElfFile", "", paramFile);
          return localObject1;
        }
        if (!((String)localObject1).startsWith("bad elf class")) {
          continue;
        }
        i = -2;
        continue;
        if (!((String)localObject1).startsWith("bad elf data encoding")) {
          continue;
        }
        i = -3;
        continue;
        if (!((String)localObject1).startsWith("failed to read rest part of ehdr")) {
          continue;
        }
        i = -4;
        continue;
        if (!((String)localObject1).startsWith("bad elf version")) {
          continue;
        }
        i = -5;
        continue;
        if (!((String)localObject1).startsWith("Unexpected elf class")) {
          continue;
        }
        i = -6;
        continue;
        if (!((String)localObject1).startsWith("failed to read phdr")) {
          continue;
        }
        i = -7;
        continue;
        boolean bool = ((String)localObject1).startsWith("failed to read shdr");
        if (!bool) {
          continue;
        }
        i = -8;
        continue;
        i = -1000;
        continue;
      }
      finally
      {
        if (0 == 0) {
          break label232;
        }
      }
      try
      {
        paramFile.close();
        paramFile = new Pair(Integer.valueOf(0), null);
        return paramFile;
      }
      catch (IOException paramFile)
      {
        QZLog.e("ShareElfFile", "", paramFile);
      }
    }
    try
    {
      throw new NullPointerException();
      label232:
      throw localObject2;
    }
    catch (IOException paramFile)
    {
      for (;;)
      {
        QZLog.e("ShareElfFile", "", paramFile);
      }
    }
  }
  
  public static String a(ByteBuffer paramByteBuffer)
  {
    byte[] arrayOfByte = paramByteBuffer.array();
    int i = paramByteBuffer.position();
    while ((paramByteBuffer.hasRemaining()) && (arrayOfByte[paramByteBuffer.position()] != 0)) {
      paramByteBuffer.position(paramByteBuffer.position() + 1);
    }
    paramByteBuffer.position(paramByteBuffer.position() + 1);
    return new String(arrayOfByte, i, paramByteBuffer.position() - i - 1, Charset.forName("ASCII"));
  }
  
  public static void a(FileChannel paramFileChannel, ByteBuffer paramByteBuffer, String paramString)
  {
    paramByteBuffer.rewind();
    int i = paramFileChannel.read(paramByteBuffer);
    if (i != paramByteBuffer.limit()) {
      throw new IOException(paramString + " Rest bytes insufficient, expect to read " + paramByteBuffer.limit() + " bytes but only " + i + " bytes were read.");
    }
    paramByteBuffer.flip();
  }
  
  private static void b(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    if ((paramInt1 < paramInt2) || (paramInt1 > paramInt3)) {
      throw new IOException(paramString);
    }
  }
  
  public ByteBuffer a(blve paramblve)
  {
    ByteBuffer localByteBuffer = ByteBuffer.allocate((int)paramblve.d);
    this.jdField_a_of_type_JavaIoFileInputStream.getChannel().position(paramblve.c);
    a(this.jdField_a_of_type_JavaIoFileInputStream.getChannel(), localByteBuffer, "failed to read section: " + paramblve.jdField_a_of_type_JavaLangString);
    return localByteBuffer;
  }
  
  public void close()
  {
    this.jdField_a_of_type_JavaIoFileInputStream.close();
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_ArrayOfBlvd = null;
    this.jdField_a_of_type_ArrayOfBlve = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     blva
 * JD-Core Version:    0.7.0.1
 */