import com.tencent.qphone.base.util.QLog;

public class apro
  implements aprm
{
  public void a(String paramString1, String paramString2, String paramString3)
  {
    a(paramString1, paramString2, paramString3, null);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, Throwable paramThrowable)
  {
    if ("i".equals(paramString2)) {
      if (QLog.isColorLevel()) {
        QLog.i(paramString1, 2, paramString3, paramThrowable);
      }
    }
    do
    {
      do
      {
        return;
        if (!"d".equals(paramString2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d(paramString1, 2, paramString3, paramThrowable);
      return;
      if ("w".equals(paramString2))
      {
        QLog.w(paramString1, 2, paramString3, paramThrowable);
        return;
      }
      if ("e".equals(paramString2))
      {
        QLog.e(paramString1, 2, paramString3, paramThrowable);
        return;
      }
    } while (!QLog.isColorLevel());
    QLog.i(paramString1, 2, paramString3, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apro
 * JD-Core Version:    0.7.0.1
 */