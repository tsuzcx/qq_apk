import com.tencent.mobileqq.utils.FileUtils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class azbu
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, azbv> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(azbv paramazbv, boolean paramBoolean)
  {
    if ((paramazbv != null) && (paramazbv.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      File localFile;
      if (paramazbv.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (paramazbv.jdField_a_of_type_JavaIoFile == null)
        {
          localFile = new File(paramazbv.jdField_a_of_type_JavaLangString + "~tmp");
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          paramazbv.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
          paramazbv.jdField_a_of_type_JavaIoFile = localFile;
        }
        paramazbv.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(paramazbv.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (paramazbv.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramazbv.jdField_a_of_type_JavaIoFileOutputStream.flush();
          paramazbv.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramazbv.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        if (paramazbv.jdField_a_of_type_JavaIoFile != null)
        {
          localFile = new File(paramazbv.jdField_a_of_type_JavaLangString);
          if (localFile.exists()) {
            localFile.delete();
          }
          if (!paramazbv.jdField_a_of_type_JavaIoFile.renameTo(localFile))
          {
            FileUtils.copyFile(paramazbv.jdField_a_of_type_JavaIoFile, localFile);
            paramazbv.jdField_a_of_type_JavaIoFile.delete();
          }
          paramazbv.jdField_a_of_type_JavaIoFile = null;
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
    azbv localazbv = (azbv)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localazbv == null) || (localazbv.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localazbv.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localazbv.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localazbv.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localazbv.jdField_a_of_type_JavaIoFileOutputStream = null;
        if ((paramBoolean) && (localazbv.jdField_a_of_type_JavaIoFile != null))
        {
          localazbv.jdField_a_of_type_JavaIoFile.delete();
          localazbv.jdField_a_of_type_JavaIoFile = null;
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
    if ((azbv)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      azbv localazbv = new azbv();
      localazbv.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localazbv);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (azbv)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    azbv localazbv = (azbv)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localazbv != null) && (localazbv.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localazbv, true);
      label29:
      localazbv.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
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
 * Qualified Name:     azbu
 * JD-Core Version:    0.7.0.1
 */