import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class awxp
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, awxq> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(awxq paramawxq, boolean paramBoolean)
  {
    if ((paramawxq != null) && (paramawxq.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      File localFile;
      if (paramawxq.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (paramawxq.jdField_a_of_type_JavaIoFile == null)
        {
          localFile = new File(paramawxq.jdField_a_of_type_JavaLangString + "~tmp");
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          paramawxq.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
          paramawxq.jdField_a_of_type_JavaIoFile = localFile;
        }
        paramawxq.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(paramawxq.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (paramawxq.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramawxq.jdField_a_of_type_JavaIoFileOutputStream.flush();
          paramawxq.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramawxq.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        if (paramawxq.jdField_a_of_type_JavaIoFile != null)
        {
          localFile = new File(paramawxq.jdField_a_of_type_JavaLangString);
          if (localFile.exists()) {
            localFile.delete();
          }
          if (!paramawxq.jdField_a_of_type_JavaIoFile.renameTo(localFile))
          {
            bdhb.a(paramawxq.jdField_a_of_type_JavaIoFile, localFile);
            paramawxq.jdField_a_of_type_JavaIoFile.delete();
          }
          paramawxq.jdField_a_of_type_JavaIoFile = null;
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
    awxq localawxq = (awxq)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localawxq == null) || (localawxq.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localawxq.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localawxq.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localawxq.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localawxq.jdField_a_of_type_JavaIoFileOutputStream = null;
        if ((paramBoolean) && (localawxq.jdField_a_of_type_JavaIoFile != null))
        {
          localawxq.jdField_a_of_type_JavaIoFile.delete();
          localawxq.jdField_a_of_type_JavaIoFile = null;
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
    if ((awxq)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      awxq localawxq = new awxq();
      localawxq.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localawxq);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (awxq)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    awxq localawxq = (awxq)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localawxq != null) && (localawxq.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localawxq, true);
      label29:
      localawxq.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      a(paramString, true);
      return true;
    }
    catch (IOException localIOException)
    {
      break label29;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     awxp
 * JD-Core Version:    0.7.0.1
 */