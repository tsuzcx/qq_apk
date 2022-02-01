import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class aomu
  extends aojt
{
  public aojs a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, aojw paramaojw)
  {
    if (paramString.startsWith("mqqapi://gamecenter/install"))
    {
      paramQQAppInterface = new aomt(paramQQAppInterface, paramContext);
      paramQQAppInterface.a = paramString;
      paramQQAppInterface.b = "gamecenter";
      paramQQAppInterface.c = "install";
      return paramQQAppInterface;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aomu
 * JD-Core Version:    0.7.0.1
 */