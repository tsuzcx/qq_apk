import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class amdh
  extends bdvu
{
  public amdh(EcShopFirstRunMsgConfigs paramEcShopFirstRunMsgConfigs) {}
  
  public void onDone(bdvv parambdvv)
  {
    super.onDone(parambdvv);
    if ((parambdvv.a == 0) && (this.a.a.app != null))
    {
      str = parambdvv.a().getString("path");
      if ((this.a.a.app != null) && (!TextUtils.isEmpty(str)))
      {
        if (!ntw.e.equals(str)) {
          break label142;
        }
        this.a.a.app.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_report_json", parambdvv.i).commit();
        ((nup)this.a.a.app.a(88)).a();
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop", 2, "download report json success.");
        }
      }
    }
    label142:
    while (!QLog.isColorLevel())
    {
      do
      {
        String str;
        do
        {
          return;
        } while (!ntw.f.equals(str));
        this.a.a.app.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_behaviors_json", parambdvv.i).commit();
      } while (!QLog.isColorLevel());
      QLog.i("Ecshop", 2, "download behaviors json success.");
      return;
    }
    QLog.i("Ecshop", 2, "download json failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     amdh
 * JD-Core Version:    0.7.0.1
 */