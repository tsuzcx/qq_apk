import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class avbr
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, avbs> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(avbs paramavbs, boolean paramBoolean)
  {
    if ((paramavbs != null) && (paramavbs.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      File localFile;
      if (paramavbs.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (paramavbs.jdField_a_of_type_JavaIoFile == null)
        {
          localFile = new File(paramavbs.jdField_a_of_type_JavaLangString + "~tmp");
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          paramavbs.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
          paramavbs.jdField_a_of_type_JavaIoFile = localFile;
        }
        paramavbs.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(paramavbs.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (paramavbs.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramavbs.jdField_a_of_type_JavaIoFileOutputStream.flush();
          paramavbs.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramavbs.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        if (paramavbs.jdField_a_of_type_JavaIoFile != null)
        {
          localFile = new File(paramavbs.jdField_a_of_type_JavaLangString);
          if (localFile.exists()) {
            localFile.delete();
          }
          if (!paramavbs.jdField_a_of_type_JavaIoFile.renameTo(localFile))
          {
            bbdj.a(paramavbs.jdField_a_of_type_JavaIoFile, localFile);
            paramavbs.jdField_a_of_type_JavaIoFile.delete();
          }
          paramavbs.jdField_a_of_type_JavaIoFile = null;
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
    avbs localavbs = (avbs)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localavbs == null) || (localavbs.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localavbs.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localavbs.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localavbs.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localavbs.jdField_a_of_type_JavaIoFileOutputStream = null;
        if ((paramBoolean) && (localavbs.jdField_a_of_type_JavaIoFile != null))
        {
          localavbs.jdField_a_of_type_JavaIoFile.delete();
          localavbs.jdField_a_of_type_JavaIoFile = null;
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
    if ((avbs)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      avbs localavbs = new avbs();
      localavbs.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localavbs);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (avbs)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    avbs localavbs = (avbs)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localavbs != null) && (localavbs.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localavbs, true);
      label29:
      localavbs.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      a(paramString, true);
      return true;
    }
    catch (IOException localIOException)
    {
      break label29;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     avbr
 * JD-Core Version:    0.7.0.1
 */