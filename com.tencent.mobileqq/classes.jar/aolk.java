import android.content.Context;
import com.tencent.mobileqq.activity.qwallet.WXMiniProgramHelper;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aolk
  extends aojs
{
  public aolk(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    WXMiniProgramHelper.a().a(this.a);
    return true;
  }
  
  public boolean a()
  {
    try
    {
      if ((this.a.containsKey("user_name")) && (!bgsp.a((String)this.a.get("user_name"))))
      {
        boolean bool = C();
        return bool;
      }
      return false;
    }
    catch (Exception localException)
    {
      QLog.e("QwalletToLaunchWXMiniAppAction", 1, "doAction error: " + localException.getMessage());
      a("QwalletToLaunchWXMiniAppAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aolk
 * JD-Core Version:    0.7.0.1
 */