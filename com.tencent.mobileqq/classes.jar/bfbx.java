import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bfbx
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, bfby> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(bfby parambfby, boolean paramBoolean)
  {
    if ((parambfby != null) && (parambfby.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      if (parambfby.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (parambfby.jdField_a_of_type_JavaIoFile == null)
        {
          File localFile = new File(parambfby.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          parambfby.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile, true);
          parambfby.jdField_a_of_type_JavaIoFile = localFile;
        }
        parambfby.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(parambfby.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (parambfby.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          parambfby.jdField_a_of_type_JavaIoFileOutputStream.flush();
          parambfby.jdField_a_of_type_JavaIoFileOutputStream.close();
          parambfby.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        parambfby.jdField_a_of_type_JavaIoFile = null;
      }
    }
  }
  
  public static void a(String paramString)
  {
    b(paramString);
  }
  
  public static boolean a(String paramString)
  {
    if ((bfby)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      bfby localbfby = new bfby();
      localbfby.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localbfby);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (bfby)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    bfby localbfby = (bfby)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbfby == null) || (localbfby.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localbfby.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localbfby.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localbfby.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localbfby.jdField_a_of_type_JavaIoFileOutputStream = null;
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
    bfby localbfby = (bfby)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbfby != null) && (localbfby.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localbfby, true);
      label29:
      localbfby.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
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
 * Qualified Name:     bfbx
 * JD-Core Version:    0.7.0.1
 */