import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class bany
  extends banv
{
  public static banv b()
  {
    return banz.a();
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (bang.b))
    {
      if (BaseActivity.sTopActivity == null) {
        break label42;
      }
      new bann(BaseActivity.sTopActivity, true).show();
    }
    for (;;)
    {
      bakl.a("HelloQQWake", "WakeServiceCallBackWithTips show tips");
      bang.b = false;
      return;
      label42:
      QQToast.a(BaseApplicationImpl.getApplication(), 2, BaseApplicationImpl.getApplication().getString(2131695072), 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bany
 * JD-Core Version:    0.7.0.1
 */