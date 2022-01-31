import com.tencent.qphone.base.util.QLog;

public class apsq
  implements apsp
{
  public void a(String paramString1, int paramInt, String paramString2)
  {
    if (a()) {
      QLog.d(paramString1, paramInt, paramString2);
    }
  }
  
  public boolean a()
  {
    return QLog.isColorLevel();
  }
  
  public void b(String paramString1, int paramInt, String paramString2)
  {
    if (a()) {
      QLog.i(paramString1, paramInt, paramString2);
    }
  }
  
  public void c(String paramString1, int paramInt, String paramString2)
  {
    if (a()) {
      QLog.e(paramString1, paramInt, paramString2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     apsq
 * JD-Core Version:    0.7.0.1
 */