import com.tencent.mobileqq.app.QQAppInterface;

public class ayzn
{
  public static ayzj a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (ayzl)paramQQAppInterface.getBusinessHandler(191);
      if (paramQQAppInterface != null) {
        return paramQQAppInterface.a(paramString);
      }
    }
    return null;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (ayzl)paramQQAppInterface.getBusinessHandler(191);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayzn
 * JD-Core Version:    0.7.0.1
 */