import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

public class aqgs
  implements View.OnClickListener
{
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final aqgx jdField_a_of_type_Aqgx;
  private final aqgz jdField_a_of_type_Aqgz;
  private final String jdField_a_of_type_JavaLangString;
  
  private aqgs(Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Aqgz = new aqgz(paramActivity);
    paramActivity = aqgw.a(paramActivity, arad.a());
    this.jdField_a_of_type_Aqgz.a(paramActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aqgx = aqgx.a(this.jdField_a_of_type_AndroidAppActivity, -1, -1);
    c();
  }
  
  private static int a(aqgv paramaqgv)
  {
    if (paramaqgv.a()) {
      return 2;
    }
    return 1;
  }
  
  public static String a(String paramString)
  {
    paramString = (String)bhhr.a(BaseApplicationImpl.context, paramString, "key_selected_browser_name", "");
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, new Object[] { "[sp] getSpSelectedBrowserPackage: invoked. ", " pkg: ", paramString });
    }
    return paramString;
  }
  
  public static void a(Activity paramActivity, String paramString1, String paramString2)
  {
    String str = a(paramString2);
    paramString2 = str;
    if (!TextUtils.isEmpty(str))
    {
      paramString2 = str;
      if (!bkyz.a(BaseApplication.context, str))
      {
        a(aqgw.a(), "");
        paramString2 = "";
      }
    }
    if (TextUtils.isEmpty(paramString2))
    {
      new aqgs(paramActivity, paramString1).b();
      return;
    }
    aqgw.a(paramActivity, paramString1, paramString2);
  }
  
  private void a(aqgv paramaqgv)
  {
    Object localObject = BaseApplication.context.getResources();
    aqgt localaqgt = new aqgt(this, paramaqgv);
    aqgu localaqgu = new aqgu(this);
    localObject = String.format(((Resources)localObject).getString(2131690669), new Object[] { paramaqgv.a() });
    bhdj.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, (String)localObject, localaqgt, localaqgu).show();
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, new Object[] { "[dialog] showDownloadBrowserConfirmDialog: invoked. ", " browser: ", paramaqgv });
    }
    azcl.a("0X800ADEE");
  }
  
  private static void a(String paramString1, String paramString2)
  {
    bhhr.a(BaseApplicationImpl.context, paramString1, true, "key_selected_browser_name", paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, new Object[] { "[sp] saveSpSelectedBrowserPackage: invoked. ", " pkg: ", paramString2 });
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Aqgz.getCount() <= 0)
    {
      znl.a(1, 2131694987);
      if (QLog.isColorLevel()) {
        QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, "[error] showPopupWindow: invoked. [没有任何浏览器时，对齐旧的错误toast]");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_Aqgx.a();
    if (localObject != null) {
      ((XListView)localObject).setAdapter(this.jdField_a_of_type_Aqgz);
    }
    localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setDimAmount(0.5F);
      this.jdField_a_of_type_Aqgx.showAtLocation(((Window)localObject).getDecorView(), 80, 0, 0);
    }
    azcl.a("0X800ADEA");
  }
  
  private void c()
  {
    Button localButton = this.jdField_a_of_type_Aqgx.a();
    if (localButton != null) {
      localButton.setOnClickListener(this);
    }
    localButton = this.jdField_a_of_type_Aqgx.b();
    if (localButton != null) {
      localButton.setOnClickListener(this);
    }
  }
  
  private void d()
  {
    e();
    aqgv localaqgv = this.jdField_a_of_type_Aqgz.a();
    if (localaqgv != null)
    {
      a(aqgw.a(), localaqgv.e());
      azcl.a("0X800ADED", a(localaqgv), "", localaqgv.a());
    }
  }
  
  private void e()
  {
    a();
    aqgv localaqgv = this.jdField_a_of_type_Aqgz.a();
    if (localaqgv == null) {
      return;
    }
    if (localaqgv.a()) {
      aqgw.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, localaqgv.e());
    }
    for (;;)
    {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 1, new Object[] { "[action] onAnyButtonClicked: invoked. ", " browser: ", localaqgv });
      return;
      if (bkyz.a(BaseApplication.context, localaqgv.e())) {
        aqgw.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, localaqgv.e());
      } else {
        a(localaqgv);
      }
    }
  }
  
  private void f()
  {
    e();
    aqgv localaqgv = this.jdField_a_of_type_Aqgz.a();
    if (localaqgv != null) {
      azcl.a("0X800ADEC", a(localaqgv), "", localaqgv.a());
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqgx.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Aqgx.dismiss();
      if (this.jdField_a_of_type_Aqgz != null) {
        this.jdField_a_of_type_Aqgz.a();
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("[BrowserOpt] BrowserDialogViewModel", 1, "dismissPopupWindow: failed. ", localException);
      }
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131362686) {
      d();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131372203) {
        f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqgs
 * JD-Core Version:    0.7.0.1
 */