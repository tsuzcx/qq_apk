import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aqgd
  extends bduv
{
  aqgd(aqgb paramaqgb) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.a.x();
    if (aqgb.a(this.a) != -1)
    {
      if ((!paramBoolean) || (paramHashMap == null)) {
        break label151;
      }
      String str = (String)paramHashMap.get("uin");
      paramHashMap = (String)paramHashMap.get("url");
      aqgb.a(this.a, paramHashMap);
      aqgb.b(this.a, paramHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + aqgb.a(this.a) + " mTroopNotNeedVefifyLink=" + aqgb.b(this.a));
      }
      if ((str != null) && (str.equals(aqgb.c(this.a)))) {
        aqgb.a(this.a);
      }
    }
    for (;;)
    {
      aqgb.a(this.a, -1);
      return;
      label151:
      bcpw.a(this.a.a, 1, this.a.a.getString(2131693032), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgd
 * JD-Core Version:    0.7.0.1
 */