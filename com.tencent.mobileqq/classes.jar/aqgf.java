import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aqgf
  extends bdvm
{
  aqgf(aqgd paramaqgd) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.a.x();
    if (aqgd.a(this.a) != -1)
    {
      if ((!paramBoolean) || (paramHashMap == null)) {
        break label151;
      }
      String str = (String)paramHashMap.get("uin");
      paramHashMap = (String)paramHashMap.get("url");
      aqgd.a(this.a, paramHashMap);
      aqgd.b(this.a, paramHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + aqgd.a(this.a) + " mTroopNotNeedVefifyLink=" + aqgd.b(this.a));
      }
      if ((str != null) && (str.equals(aqgd.c(this.a)))) {
        aqgd.a(this.a);
      }
    }
    for (;;)
    {
      aqgd.a(this.a, -1);
      return;
      label151:
      bcql.a(this.a.a, 1, this.a.a.getString(2131693033), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     aqgf
 * JD-Core Version:    0.7.0.1
 */