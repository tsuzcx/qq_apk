import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class balu
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, balv> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(balv parambalv, boolean paramBoolean)
  {
    if ((parambalv != null) && (parambalv.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      File localFile;
      if (parambalv.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (parambalv.jdField_a_of_type_JavaIoFile == null)
        {
          localFile = new File(parambalv.jdField_a_of_type_JavaLangString + "~tmp");
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          parambalv.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
          parambalv.jdField_a_of_type_JavaIoFile = localFile;
        }
        parambalv.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(parambalv.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (parambalv.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          parambalv.jdField_a_of_type_JavaIoFileOutputStream.flush();
          parambalv.jdField_a_of_type_JavaIoFileOutputStream.close();
          parambalv.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        if (parambalv.jdField_a_of_type_JavaIoFile != null)
        {
          localFile = new File(parambalv.jdField_a_of_type_JavaLangString);
          if (localFile.exists()) {
            localFile.delete();
          }
          if (!parambalv.jdField_a_of_type_JavaIoFile.renameTo(localFile))
          {
            bhmi.a(parambalv.jdField_a_of_type_JavaIoFile, localFile);
            parambalv.jdField_a_of_type_JavaIoFile.delete();
          }
          parambalv.jdField_a_of_type_JavaIoFile = null;
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
    balv localbalv = (balv)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbalv == null) || (localbalv.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localbalv.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localbalv.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localbalv.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localbalv.jdField_a_of_type_JavaIoFileOutputStream = null;
        if ((paramBoolean) && (localbalv.jdField_a_of_type_JavaIoFile != null))
        {
          localbalv.jdField_a_of_type_JavaIoFile.delete();
          localbalv.jdField_a_of_type_JavaIoFile = null;
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
    if ((balv)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      balv localbalv = new balv();
      localbalv.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localbalv);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (balv)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    balv localbalv = (balv)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbalv != null) && (localbalv.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localbalv, true);
      label29:
      localbalv.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
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
 * Qualified Name:     balu
 * JD-Core Version:    0.7.0.1
 */