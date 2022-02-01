import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.QZoneMsgActivity;

public class aolw
  extends aojs
{
  public aolw(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramQQAppInterface, paramContext);
  }
  
  private boolean C()
  {
    if (this.a == null) {
      return false;
    }
    long l = bkyx.a();
    if (l != 0L) {
      QZoneMsgActivity.a(l, this.a);
    }
    for (;;)
    {
      return true;
      Intent localIntent = new Intent(this.a, QZoneMsgActivity.class);
      localIntent.addFlags(67108864);
      this.a.startActivity(localIntent);
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
      QLog.e("QzonePublicAccountAction", 1, "doAction error: " + localException.getMessage());
      a("QzonePublicAccountAction");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aolw
 * JD-Core Version:    0.7.0.1
 */