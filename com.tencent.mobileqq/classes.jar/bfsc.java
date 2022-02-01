import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bfsc
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, bfsd> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(bfsd parambfsd, boolean paramBoolean)
  {
    if ((parambfsd != null) && (parambfsd.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      if (parambfsd.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (parambfsd.jdField_a_of_type_JavaIoFile == null)
        {
          File localFile = new File(parambfsd.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          parambfsd.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile, true);
          parambfsd.jdField_a_of_type_JavaIoFile = localFile;
        }
        parambfsd.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(parambfsd.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (parambfsd.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          parambfsd.jdField_a_of_type_JavaIoFileOutputStream.flush();
          parambfsd.jdField_a_of_type_JavaIoFileOutputStream.close();
          parambfsd.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        parambfsd.jdField_a_of_type_JavaIoFile = null;
      }
    }
  }
  
  public static void a(String paramString)
  {
    b(paramString);
  }
  
  public static boolean a(String paramString)
  {
    if ((bfsd)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      bfsd localbfsd = new bfsd();
      localbfsd.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localbfsd);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (bfsd)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    bfsd localbfsd = (bfsd)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbfsd == null) || (localbfsd.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localbfsd.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localbfsd.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localbfsd.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localbfsd.jdField_a_of_type_JavaIoFileOutputStream = null;
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
    bfsd localbfsd = (bfsd)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbfsd != null) && (localbfsd.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localbfsd, true);
      label29:
      localbfsd.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      b(paramString);
      return true;
    }
    catch (IOException localIOException)
    {
      break label29;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bfsc
 * JD-Core Version:    0.7.0.1
 */