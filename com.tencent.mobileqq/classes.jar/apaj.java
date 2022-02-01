import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class apaj
  extends aoxg
{
  public apaj(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  public boolean a()
  {
    try
    {
      ueg.a(this.a, "from_search_rzh_ws", 2, false);
      return true;
    }
    catch (Exception localException)
    {
      QLog.e("WeishiPublicAccountAction", 1, "doAction error: " + localException.getMessage());
      a("WeishiPublicAccountAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apaj
 * JD-Core Version:    0.7.0.1
 */