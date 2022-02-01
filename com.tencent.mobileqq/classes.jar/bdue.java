import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class bdue
{
  private bhpm a;
  
  public static boolean a(AppInterface paramAppInterface)
  {
    try
    {
      boolean bool = ((Boolean)bhhr.b(BaseApplicationImpl.context, paramAppInterface.getCurrentAccountUin(), "key_alphabetic_font_switch_status_", Boolean.valueOf(false))).booleanValue();
      return bool;
    }
    catch (Throwable paramAppInterface)
    {
      QLog.e("AlphabeticFontHelper", 1, paramAppInterface, new Object[0]);
    }
    return false;
  }
  
  public void a()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public boolean a(QQAppInterface paramQQAppInterface, ETTextView paramETTextView, int paramInt)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bdue
 * JD-Core Version:    0.7.0.1
 */