import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class azte
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, aztf> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(aztf paramaztf, boolean paramBoolean)
  {
    if ((paramaztf != null) && (paramaztf.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      File localFile;
      if (paramaztf.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (paramaztf.jdField_a_of_type_JavaIoFile == null)
        {
          localFile = new File(paramaztf.jdField_a_of_type_JavaLangString + "~tmp");
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          paramaztf.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
          paramaztf.jdField_a_of_type_JavaIoFile = localFile;
        }
        paramaztf.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(paramaztf.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (paramaztf.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramaztf.jdField_a_of_type_JavaIoFileOutputStream.flush();
          paramaztf.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramaztf.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        if (paramaztf.jdField_a_of_type_JavaIoFile != null)
        {
          localFile = new File(paramaztf.jdField_a_of_type_JavaLangString);
          if (localFile.exists()) {
            localFile.delete();
          }
          if (!paramaztf.jdField_a_of_type_JavaIoFile.renameTo(localFile))
          {
            bgmg.a(paramaztf.jdField_a_of_type_JavaIoFile, localFile);
            paramaztf.jdField_a_of_type_JavaIoFile.delete();
          }
          paramaztf.jdField_a_of_type_JavaIoFile = null;
        }
      }
    }
  }
  
  public static void a(String paramString)
  {
    a(paramString, true);
  }
  
  private static void a(String paramString, boolean paramBoolean)
  {
    aztf localaztf = (aztf)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localaztf == null) || (localaztf.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localaztf.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localaztf.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localaztf.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localaztf.jdField_a_of_type_JavaIoFileOutputStream = null;
        if ((paramBoolean) && (localaztf.jdField_a_of_type_JavaIoFile != null))
        {
          localaztf.jdField_a_of_type_JavaIoFile.delete();
          localaztf.jdField_a_of_type_JavaIoFile = null;
        }
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
  
  public static boolean a(String paramString)
  {
    if ((aztf)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      aztf localaztf = new aztf();
      localaztf.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localaztf);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (aztf)jdField_a_of_type_JavaUtilMap.get(paramString);
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
  
  public static boolean b(String paramString)
  {
    aztf localaztf = (aztf)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localaztf != null) && (localaztf.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localaztf, true);
      label29:
      localaztf.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      a(paramString, true);
      return true;
    }
    catch (IOException localIOException)
    {
      break label29;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azte
 * JD-Core Version:    0.7.0.1
 */