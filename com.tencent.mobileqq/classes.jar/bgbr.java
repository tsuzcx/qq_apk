import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bgbr
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, bgbs> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(bgbs parambgbs, boolean paramBoolean)
  {
    if ((parambgbs != null) && (parambgbs.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      if (parambgbs.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (parambgbs.jdField_a_of_type_JavaIoFile == null)
        {
          File localFile = new File(parambgbs.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          parambgbs.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile, true);
          parambgbs.jdField_a_of_type_JavaIoFile = localFile;
        }
        parambgbs.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(parambgbs.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (parambgbs.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          parambgbs.jdField_a_of_type_JavaIoFileOutputStream.flush();
          parambgbs.jdField_a_of_type_JavaIoFileOutputStream.close();
          parambgbs.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        parambgbs.jdField_a_of_type_JavaIoFile = null;
      }
    }
  }
  
  public static void a(String paramString)
  {
    b(paramString);
  }
  
  public static boolean a(String paramString)
  {
    if ((bgbs)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      bgbs localbgbs = new bgbs();
      localbgbs.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localbgbs);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (bgbs)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    bgbs localbgbs = (bgbs)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbgbs == null) || (localbgbs.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localbgbs.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localbgbs.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localbgbs.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localbgbs.jdField_a_of_type_JavaIoFileOutputStream = null;
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
    bgbs localbgbs = (bgbs)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbgbs != null) && (localbgbs.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localbgbs, true);
      label29:
      localbgbs.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
      b(paramString);
      return true;
    }
    catch (IOException localIOException)
    {
      break label29;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgbr
 * JD-Core Version:    0.7.0.1
 */