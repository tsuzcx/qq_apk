import android.app.Activity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class arzu
  extends bfvh
{
  arzu(arzs paramarzs) {}
  
  protected void a(boolean paramBoolean, HashMap<String, Object> paramHashMap)
  {
    this.a.x();
    if (arzs.a(this.a) != -1)
    {
      if ((!paramBoolean) || (paramHashMap == null)) {
        break label151;
      }
      String str = (String)paramHashMap.get("uin");
      paramHashMap = (String)paramHashMap.get("url");
      arzs.a(this.a, paramHashMap);
      arzs.b(this.a, paramHashMap);
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShareCardOption", 2, "mTroopVerifyLink=" + arzs.a(this.a) + " mTroopNotNeedVefifyLink=" + arzs.b(this.a));
      }
      if ((str != null) && (str.equals(arzs.c(this.a)))) {
        arzs.a(this.a);
      }
    }
    for (;;)
    {
      arzs.a(this.a, -1);
      return;
      label151:
      QQToast.a(this.a.a, 1, this.a.a.getString(2131693134), 0).b(((BaseActivity)this.a.a).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arzu
 * JD-Core Version:    0.7.0.1
 */