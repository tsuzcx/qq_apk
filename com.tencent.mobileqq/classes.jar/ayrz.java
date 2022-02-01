import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

class ayrz
  implements bghj
{
  ayrz(ayrt paramayrt) {}
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, "ZanDoubleDialog: onLeftClick: ");
    }
    if (ayrt.e(this.a).getIntent().hasExtra("troopUin")) {}
    for (Object localObject = "1";; localObject = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(ayrt.d(this.a).getCurrentAccountUin(), "thumbup", "click_getit", "", 1, 0, 0, "", (String)localObject, "");
      localObject = new Intent(ayrt.f(this.a), QQBrowserActivity.class);
      ((Intent)localObject).putExtra("fragmentStyle", 3);
      ((Intent)localObject).putExtra("url", "https://m.vip.qq.com/freedom/dbzan.html?_nav_alpha=0");
      ((Intent)localObject).putExtra("isTransparentTitle", true);
      ((Intent)localObject).putExtra("startOpenPageTime", System.currentTimeMillis());
      ayrt.g(this.a).startActivity((Intent)localObject);
      return;
    }
  }
  
  public void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AbsProfileHeaderComponent", 2, "ZanDoubleDialog: onRightClick: ");
    }
    if (ayrt.h(this.a).getIntent().hasExtra("troopUin")) {}
    for (String str = "1";; str = "0")
    {
      VasWebviewUtil.reportCommercialDrainage(ayrt.e(this.a).getCurrentAccountUin(), "thumbup", "click_pay", "", 1, 0, 0, "", str, "");
      bgge.a(ayrt.i(this.a), "mvip.n.a.dbzan_dbzan", "CJCLUBT", 3, false, true);
      ayrt.a(this.a).set(true);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ayrz
 * JD-Core Version:    0.7.0.1
 */