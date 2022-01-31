import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class apmp
  extends bcqu
{
  apmp(apmn paramapmn) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.a.x();
    if (apmn.a(this.a) != -1)
    {
      if ((!paramBoolean) || (paramHashMap == null)) {
        break label151;
      }
      String str = (String)paramHashMap.get("uin");
      paramHashMap = (String)paramHashMap.get("url");
      apmn.a(this.a, paramHashMap);
      apmn.b(this.a, paramHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + apmn.a(this.a) + " mTroopNotNeedVefifyLink=" + apmn.b(this.a));
      }
      if ((str != null) && (str.equals(apmn.c(this.a)))) {
        apmn.a(this.a);
      }
    }
    for (;;)
    {
      apmn.a(this.a, -1);
      return;
      label151:
      bbmy.a(this.a.a, 1, this.a.a.getString(2131627392), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     apmp
 * JD-Core Version:    0.7.0.1
 */