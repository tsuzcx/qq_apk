import com.tencent.qphone.base.util.QLog;

public final class bgwf
{
  public static void a(String paramString1, String paramString2)
  {
    QLog.e("ReadingCenter-" + paramString1, 1, paramString2);
  }
  
  public static void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.e("ReadingCenter-" + paramString1, 1, paramString2, paramThrowable);
  }
  
  public static void b(String paramString1, String paramString2)
  {
    QLog.w("ReadingCenter-" + paramString1, 1, paramString2);
  }
  
  public static void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    QLog.i("ReadingCenter-" + paramString1, 1, paramString2, paramThrowable);
  }
  
  public static void c(String paramString1, String paramString2)
  {
    QLog.i("ReadingCenter-" + paramString1, 1, paramString2);
  }
  
  public static void d(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ReadingCenter-" + paramString1, 2, paramString2);
    }
  }
  
  public static void e(String paramString1, String paramString2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadingCenter-" + paramString1, 2, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bgwf
 * JD-Core Version:    0.7.0.1
 */