import com.tencent.qphone.base.util.QLog;

public class azsr
{
  public static int a;
  public static String a;
  public static int b = 1;
  public static int c = 2;
  
  static
  {
    jdField_a_of_type_JavaLangString = "<TroopFile> ";
  }
  
  private static int a(int paramInt)
  {
    int j = 2;
    int i;
    if (jdField_a_of_type_Int == paramInt) {
      i = 1;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (b == paramInt);
      i = j;
    } while (c != paramInt);
    return 4;
  }
  
  public static void a(String paramString1, int paramInt, String paramString2)
  {
    QLog.e(paramString1, a(paramInt), jdField_a_of_type_JavaLangString + paramString2);
  }
  
  public static void b(String paramString1, int paramInt, String paramString2)
  {
    QLog.w(paramString1, a(paramInt), jdField_a_of_type_JavaLangString + paramString2);
  }
  
  public static void c(String paramString1, int paramInt, String paramString2)
  {
    QLog.i(paramString1, a(paramInt), jdField_a_of_type_JavaLangString + paramString2);
  }
  
  public static void d(String paramString1, int paramInt, String paramString2)
  {
    QLog.d(paramString1, a(paramInt), jdField_a_of_type_JavaLangString + paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     azsr
 * JD-Core Version:    0.7.0.1
 */