import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class azyr
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, azys> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(azys paramazys, boolean paramBoolean)
  {
    if ((paramazys != null) && (paramazys.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      if (paramazys.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (paramazys.jdField_a_of_type_JavaIoFile == null)
        {
          File localFile = new File(paramazys.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          paramazys.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile, true);
          paramazys.jdField_a_of_type_JavaIoFile = localFile;
        }
        paramazys.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(paramazys.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (paramazys.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramazys.jdField_a_of_type_JavaIoFileOutputStream.flush();
          paramazys.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramazys.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        paramazys.jdField_a_of_type_JavaIoFile = null;
      }
    }
  }
  
  public static void a(String paramString)
  {
    b(paramString);
  }
  
  public static boolean a(String paramString)
  {
    if ((azys)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      azys localazys = new azys();
      localazys.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localazys);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (azys)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    azys localazys = (azys)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localazys == null) || (localazys.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localazys.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localazys.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localazys.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localazys.jdField_a_of_type_JavaIoFileOutputStream = null;
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
    azys localazys = (azys)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localazys != null) && (localazys.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localazys, true);
      label29:
      localazys.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      b(paramString);
      return true;
    }
    catch (IOException localIOException)
    {
      break label29;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azyr
 * JD-Core Version:    0.7.0.1
 */