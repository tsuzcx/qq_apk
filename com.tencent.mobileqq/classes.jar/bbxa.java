import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bbxa
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, bbxb> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(bbxb parambbxb, boolean paramBoolean)
  {
    if ((parambbxb != null) && (parambbxb.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      if (parambbxb.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (parambbxb.jdField_a_of_type_JavaIoFile == null)
        {
          File localFile = new File(parambbxb.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          parambbxb.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile, true);
          parambbxb.jdField_a_of_type_JavaIoFile = localFile;
        }
        parambbxb.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(parambbxb.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (parambbxb.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          parambbxb.jdField_a_of_type_JavaIoFileOutputStream.flush();
          parambbxb.jdField_a_of_type_JavaIoFileOutputStream.close();
          parambbxb.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        parambbxb.jdField_a_of_type_JavaIoFile = null;
      }
    }
  }
  
  public static void a(String paramString)
  {
    b(paramString);
  }
  
  public static boolean a(String paramString)
  {
    if ((bbxb)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      bbxb localbbxb = new bbxb();
      localbbxb.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localbbxb);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (bbxb)jdField_a_of_type_JavaUtilMap.get(paramString);
    if (paramString != null)
    {
      if (paramString.jdField_a_of_type_JavaIoByteArrayOutputStream == null) {
        paramString.jdField_a_of_type_JavaIoByteArrayOutputStream = new ByteArrayOutputStream(paramInt << 1);
      }
      paramString.jdField_a_of_type_JavaIoByteArrayOutputStream.write(paramArrayOfByte, 0, paramInt);
      if (paramString.jdField_a_of_type_JavaIoByteArrayOutputStream.size() < jdField_a_of_type_Int) {}
    }
    try
    {
      a(paramString, false);
      label66:
      paramString.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      return true;
    }
    catch (IOException paramArrayOfByte)
    {
      break label66;
    }
  }
  
  private static void b(String paramString)
  {
    bbxb localbbxb = (bbxb)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbbxb == null) || (localbbxb.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localbbxb.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localbbxb.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localbbxb.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localbbxb.jdField_a_of_type_JavaIoFileOutputStream = null;
        jdField_a_of_type_JavaUtilMap.remove(paramString);
        return;
      }
      catch (Exception localException1)
      {
        break label45;
      }
    }
    catch (Exception localException2)
    {
      break label31;
    }
  }
  
  public static boolean b(String paramString)
  {
    bbxb localbbxb = (bbxb)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbbxb != null) && (localbbxb.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localbbxb, true);
      label29:
      localbbxb.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      b(paramString);
      return true;
    }
    catch (IOException localIOException)
    {
      break label29;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bbxa
 * JD-Core Version:    0.7.0.1
 */