import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bcbj
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, bcbk> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(bcbk parambcbk, boolean paramBoolean)
  {
    if ((parambcbk != null) && (parambcbk.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      if (parambcbk.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (parambcbk.jdField_a_of_type_JavaIoFile == null)
        {
          File localFile = new File(parambcbk.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          parambcbk.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile, true);
          parambcbk.jdField_a_of_type_JavaIoFile = localFile;
        }
        parambcbk.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(parambcbk.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (parambcbk.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          parambcbk.jdField_a_of_type_JavaIoFileOutputStream.flush();
          parambcbk.jdField_a_of_type_JavaIoFileOutputStream.close();
          parambcbk.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        parambcbk.jdField_a_of_type_JavaIoFile = null;
      }
    }
  }
  
  public static void a(String paramString)
  {
    b(paramString);
  }
  
  public static boolean a(String paramString)
  {
    if ((bcbk)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      bcbk localbcbk = new bcbk();
      localbcbk.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localbcbk);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (bcbk)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    bcbk localbcbk = (bcbk)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbcbk == null) || (localbcbk.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localbcbk.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localbcbk.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localbcbk.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localbcbk.jdField_a_of_type_JavaIoFileOutputStream = null;
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
    bcbk localbcbk = (bcbk)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbcbk != null) && (localbcbk.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localbcbk, true);
      label29:
      localbcbk.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
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
 * Qualified Name:     bcbj
 * JD-Core Version:    0.7.0.1
 */