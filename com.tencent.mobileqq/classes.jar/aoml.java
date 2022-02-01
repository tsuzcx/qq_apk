import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class aoml
  extends aojs
{
  public aoml(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    try
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      if (TextUtils.isEmpty(arag.a().h())) {}
      for (String str = "https://docs.qq.com/desktop/m/index.html?_from=1";; str = arag.a().h())
      {
        this.a.startActivity(localIntent.putExtra("url", str));
        break;
      }
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean a()
  {
    try
    {
      boolean bool = C();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("TeamWorkListAction", 1, "doAction error: " + localException.getMessage());
      a("TeamWorkListAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aoml
 * JD-Core Version:    0.7.0.1
 */