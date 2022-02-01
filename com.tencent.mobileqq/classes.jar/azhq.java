import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;

public class azhq
  extends azhn
{
  public static azhn b()
  {
    return azhr.a();
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (BaseActivity.sTopActivity == null) {
        break label36;
      }
      new azhf(BaseActivity.sTopActivity, true).show();
    }
    for (;;)
    {
      azeu.a("HelloQQWake", "WakeServiceCallBackWithTips show tips");
      azgy.b = false;
      return;
      label36:
      QQToast.a(BaseApplicationImpl.getApplication(), 2, BaseApplicationImpl.getApplication().getString(2131694858), 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azhq
 * JD-Core Version:    0.7.0.1
 */