import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class awtg
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, awth> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(awth paramawth, boolean paramBoolean)
  {
    if ((paramawth != null) && (paramawth.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      File localFile;
      if (paramawth.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (paramawth.jdField_a_of_type_JavaIoFile == null)
        {
          localFile = new File(paramawth.jdField_a_of_type_JavaLangString + "~tmp");
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          paramawth.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
          paramawth.jdField_a_of_type_JavaIoFile = localFile;
        }
        paramawth.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(paramawth.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (paramawth.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramawth.jdField_a_of_type_JavaIoFileOutputStream.flush();
          paramawth.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramawth.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        if (paramawth.jdField_a_of_type_JavaIoFile != null)
        {
          localFile = new File(paramawth.jdField_a_of_type_JavaLangString);
          if (localFile.exists()) {
            localFile.delete();
          }
          if (!paramawth.jdField_a_of_type_JavaIoFile.renameTo(localFile))
          {
            bdcs.a(paramawth.jdField_a_of_type_JavaIoFile, localFile);
            paramawth.jdField_a_of_type_JavaIoFile.delete();
          }
          paramawth.jdField_a_of_type_JavaIoFile = null;
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
    awth localawth = (awth)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localawth == null) || (localawth.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localawth.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localawth.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localawth.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localawth.jdField_a_of_type_JavaIoFileOutputStream = null;
        if ((paramBoolean) && (localawth.jdField_a_of_type_JavaIoFile != null))
        {
          localawth.jdField_a_of_type_JavaIoFile.delete();
          localawth.jdField_a_of_type_JavaIoFile = null;
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
    if ((awth)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      awth localawth = new awth();
      localawth.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localawth);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (awth)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    awth localawth = (awth)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localawth != null) && (localawth.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localawth, true);
      label29:
      localawth.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
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
 * Qualified Name:     awtg
 * JD-Core Version:    0.7.0.1
 */