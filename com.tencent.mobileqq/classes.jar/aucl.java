import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class aucl
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, aucm> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(aucm paramaucm, boolean paramBoolean)
  {
    if ((paramaucm != null) && (paramaucm.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      File localFile;
      if (paramaucm.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (paramaucm.jdField_a_of_type_JavaIoFile == null)
        {
          localFile = new File(paramaucm.jdField_a_of_type_JavaLangString + "~tmp");
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          paramaucm.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile);
          paramaucm.jdField_a_of_type_JavaIoFile = localFile;
        }
        paramaucm.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(paramaucm.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (paramaucm.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          paramaucm.jdField_a_of_type_JavaIoFileOutputStream.flush();
          paramaucm.jdField_a_of_type_JavaIoFileOutputStream.close();
          paramaucm.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        if (paramaucm.jdField_a_of_type_JavaIoFile != null)
        {
          localFile = new File(paramaucm.jdField_a_of_type_JavaLangString);
          if (localFile.exists()) {
            localFile.delete();
          }
          if (!paramaucm.jdField_a_of_type_JavaIoFile.renameTo(localFile))
          {
            bace.a(paramaucm.jdField_a_of_type_JavaIoFile, localFile);
            paramaucm.jdField_a_of_type_JavaIoFile.delete();
          }
          paramaucm.jdField_a_of_type_JavaIoFile = null;
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
    aucm localaucm = (aucm)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localaucm == null) || (localaucm.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localaucm.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localaucm.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localaucm.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localaucm.jdField_a_of_type_JavaIoFileOutputStream = null;
        if ((paramBoolean) && (localaucm.jdField_a_of_type_JavaIoFile != null))
        {
          localaucm.jdField_a_of_type_JavaIoFile.delete();
          localaucm.jdField_a_of_type_JavaIoFile = null;
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
    if ((aucm)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      aucm localaucm = new aucm();
      localaucm.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localaucm);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (aucm)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    aucm localaucm = (aucm)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localaucm != null) && (localaucm.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localaucm, true);
      label29:
      localaucm.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
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
 * Qualified Name:     aucl
 * JD-Core Version:    0.7.0.1
 */