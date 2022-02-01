import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.app.automator.step.EcShopFirstRunMsgConfigs;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class aoig
  extends bhyn
{
  public aoig(EcShopFirstRunMsgConfigs paramEcShopFirstRunMsgConfigs) {}
  
  public void onDone(bhyo parambhyo)
  {
    super.onDone(parambhyo);
    if ((parambhyo.a == 0) && (this.a.a.app != null))
    {
      str = parambhyo.a().getString("path");
      if ((this.a.a.app != null) && (!TextUtils.isEmpty(str)))
      {
        if (!onq.e.equals(str)) {
          break label143;
        }
        this.a.a.app.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_report_json", parambhyo.i).commit();
        ((ook)this.a.a.app.getBusinessHandler(BusinessHandlerFactory.EC_SHOP_REPORT_HANDLER)).a();
        if (QLog.isColorLevel()) {
          QLog.i("Ecshop", 2, "download report json success.");
        }
      }
    }
    label143:
    while (!QLog.isColorLevel())
    {
      do
      {
        String str;
        do
        {
          return;
        } while (!onq.f.equals(str));
        this.a.a.app.getApp().getSharedPreferences("ecshop_sp", 0).edit().putLong("last_modified_behaviors_json", parambhyo.i).commit();
      } while (!QLog.isColorLevel());
      QLog.i("Ecshop", 2, "download behaviors json success.");
      return;
    }
    QLog.i("Ecshop", 2, "download json failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     aoig
 * JD-Core Version:    0.7.0.1
 */