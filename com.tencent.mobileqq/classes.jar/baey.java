import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;

public class baey
{
  public static baeu a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = (baew)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PROFILE_COMMON_HANDLER);
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
      paramQQAppInterface = (baew)paramQQAppInterface.getBusinessHandler(BusinessHandlerFactory.PROFILE_COMMON_HANDLER);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.b();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     baey
 * JD-Core Version:    0.7.0.1
 */