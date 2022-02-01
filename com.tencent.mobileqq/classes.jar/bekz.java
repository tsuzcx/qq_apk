import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class bekz
{
  private static int jdField_a_of_type_Int = 4000;
  private static final Map<String, bela> jdField_a_of_type_JavaUtilMap = new ConcurrentHashMap(2);
  
  private static void a(bela parambela, boolean paramBoolean)
  {
    if ((parambela != null) && (parambela.jdField_a_of_type_JavaIoByteArrayOutputStream != null))
    {
      if (parambela.jdField_a_of_type_JavaIoByteArrayOutputStream.size() > 0)
      {
        if (parambela.jdField_a_of_type_JavaIoFile == null)
        {
          File localFile = new File(parambela.jdField_a_of_type_JavaLangString);
          if (!localFile.exists()) {
            localFile.createNewFile();
          }
          parambela.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(localFile, true);
          parambela.jdField_a_of_type_JavaIoFile = localFile;
        }
        parambela.jdField_a_of_type_JavaIoByteArrayOutputStream.writeTo(parambela.jdField_a_of_type_JavaIoFileOutputStream);
      }
      if (paramBoolean)
      {
        if (parambela.jdField_a_of_type_JavaIoFileOutputStream != null)
        {
          parambela.jdField_a_of_type_JavaIoFileOutputStream.flush();
          parambela.jdField_a_of_type_JavaIoFileOutputStream.close();
          parambela.jdField_a_of_type_JavaIoFileOutputStream = null;
        }
        parambela.jdField_a_of_type_JavaIoFile = null;
      }
    }
  }
  
  public static void a(String paramString)
  {
    b(paramString);
  }
  
  public static boolean a(String paramString)
  {
    if ((bela)jdField_a_of_type_JavaUtilMap.get(paramString) == null)
    {
      bela localbela = new bela();
      localbela.jdField_a_of_type_JavaLangString = paramString;
      jdField_a_of_type_JavaUtilMap.put(paramString, localbela);
    }
    return true;
  }
  
  public static boolean a(String paramString, byte[] paramArrayOfByte, int paramInt)
  {
    paramString = (bela)jdField_a_of_type_JavaUtilMap.get(paramString);
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
    bela localbela = (bela)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbela == null) || (localbela.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      localbela.jdField_a_of_type_JavaIoByteArrayOutputStream.close();
      label31:
      if (localbela.jdField_a_of_type_JavaIoFileOutputStream != null) {}
      try
      {
        localbela.jdField_a_of_type_JavaIoFileOutputStream.close();
        label45:
        localbela.jdField_a_of_type_JavaIoFileOutputStream = null;
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
    bela localbela = (bela)jdField_a_of_type_JavaUtilMap.get(paramString);
    if ((localbela != null) && (localbela.jdField_a_of_type_JavaIoByteArrayOutputStream != null)) {}
    try
    {
      a(localbela, true);
      label29:
      localbela.jdField_a_of_type_JavaIoByteArrayOutputStream.reset();
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
 * Qualified Name:     bekz
 * JD-Core Version:    0.7.0.1
 */