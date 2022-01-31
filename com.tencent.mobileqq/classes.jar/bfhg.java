import com.tencent.qphone.base.util.QLog;

public class bfhg
{
  protected static String a;
  protected static boolean a;
  
  static
  {
    jdField_a_of_type_Boolean = true;
    jdField_a_of_type_JavaLangString = "";
    jdField_a_of_type_JavaLangString += ".*[S|s][I|i][D|d].*";
    jdField_a_of_type_JavaLangString += "|.*==.*";
    jdField_a_of_type_JavaLangString += "|.*[U|u][I|i][N|n].*";
    jdField_a_of_type_JavaLangString += "|.*%3d%3d.*";
    jdField_a_of_type_JavaLangString += "|.*[V|v][K|k][E|e][Y|y]";
  }
  
  protected static void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (jdField_a_of_type_Boolean) {
      if (paramInt == 1)
      {
        if (paramThrowable != null) {
          break label187;
        }
        if (QLog.isColorLevel()) {
          QLog.i(paramString1, 2, "" + "::" + paramString2);
        }
      }
    }
    label98:
    do
    {
      break label186;
      if ((paramInt == 2) || (paramInt == 0))
      {
        if (paramThrowable != null) {
          break label226;
        }
        if (QLog.isColorLevel()) {
          QLog.d(paramString1, 2, "" + "::" + paramString2);
        }
      }
      if (paramInt == 3)
      {
        if (paramThrowable != null) {
          break label265;
        }
        if (QLog.isColorLevel()) {
          QLog.w(paramString1, 2, "" + "::" + paramString2);
        }
      }
      for (;;)
      {
        if (paramInt == 4)
        {
          if (paramThrowable != null) {
            break label304;
          }
          if (QLog.isColorLevel()) {
            QLog.e(paramString1, 2, "" + "::" + paramString2);
          }
        }
        return;
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.i(paramString1, 2, "" + "::" + paramString2, paramThrowable);
        break;
        if (!QLog.isColorLevel()) {
          break label98;
        }
        QLog.d(paramString1, 2, "" + "::" + paramString2, paramThrowable);
        break label98;
        if (QLog.isColorLevel()) {
          QLog.w(paramString1, 2, "" + "::" + paramString2, paramThrowable);
        }
      }
    } while (!QLog.isColorLevel());
    label186:
    label187:
    label226:
    QLog.e(paramString1, 2, "" + "::" + paramString2, paramThrowable);
    label265:
    label304:
    return;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    a(0, paramString1, paramString2, null);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(2, paramString1, paramString2, paramThrowable);
  }
  
  public static boolean a()
  {
    return jdField_a_of_type_Boolean;
  }
  
  public static void b(String paramString1, String paramString2)
  {
    a(1, paramString1, paramString2, null);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(3, paramString1, paramString2, paramThrowable);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    a(2, paramString1, paramString2, null);
  }
  
  public static void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    a(4, paramString1, paramString2, paramThrowable);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    a(3, paramString1, paramString2, null);
  }
  
  public static void e(String paramString1, String paramString2)
  {
    a(4, paramString1, paramString2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bfhg
 * JD-Core Version:    0.7.0.1
 */