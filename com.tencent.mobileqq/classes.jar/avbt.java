import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class avbt
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, avbu> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(avbu paramavbu, boolean paramBoolean)
  {
    if ((paramavbu != null) && (paramavbu.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      File localFile;
      if (paramavbu.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (paramavbu.jdField_a_of_type_JavaIoFile == null)
        {
          localFile = new File(paramavbu.jdField_a_of_type_JavaLangString + "~tmp");
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          paramavbu.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
          paramavbu.jdField_a_of_type_JavaIoFile = localFile;
        }
        paramavbu.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(paramavbu.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (paramavbu.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramavbu.jdField_a_of_type_JavaIoFileOutputStream.flush();
          paramavbu.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramavbu.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        if (paramavbu.jdField_a_of_type_JavaIoFile != null)
        {
          localFile = new File(paramavbu.jdField_a_of_type_JavaLangString);
          if (localFile.exists()) {
            localFile.delete();
          }
          if (!paramavbu.jdField_a_of_type_JavaIoFile.renameTo(localFile))
          {
            bbdx.a(paramavbu.jdField_a_of_type_JavaIoFile, localFile);
            paramavbu.jdField_a_of_type_JavaIoFile.delete();
          }
          paramavbu.jdField_a_of_type_JavaIoFile = null;
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
    avbu localavbu = (avbu)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localavbu == null) || (localavbu.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localavbu.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localavbu.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localavbu.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localavbu.jdField_a_of_type_JavaIoFileOutputStream = null;
        if ((paramBoolean) && (localavbu.jdField_a_of_type_JavaIoFile != null))
        {
          localavbu.jdField_a_of_type_JavaIoFile.delete();
          localavbu.jdField_a_of_type_JavaIoFile = null;
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
    if ((avbu)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      avbu localavbu = new avbu();
      localavbu.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localavbu);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (avbu)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    avbu localavbu = (avbu)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localavbu != null) && (localavbu.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localavbu, true);
      label29:
      localavbu.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
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
 * Qualified Name:     avbt
 * JD-Core Version:    0.7.0.1
 */