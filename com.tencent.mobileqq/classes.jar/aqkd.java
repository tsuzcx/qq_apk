import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;

public class aqkd
  implements View.OnClickListener
{
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final aqki jdField_a_of_type_Aqki;
  private final aqkk jdField_a_of_type_Aqkk;
  private final String jdField_a_of_type_JavaLangString;
  
  private aqkd(Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Aqkk = new aqkk(paramActivity);
    paramActivity = aqkh.a(paramActivity, ardk.a());
    this.jdField_a_of_type_Aqkk.a(paramActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Aqki = aqki.a(this.jdField_a_of_type_AndroidAppActivity, -1, -1);
    c();
  }
  
  private static int a(aqkg paramaqkg)
  {
    if (paramaqkg.a()) {
      return 2;
    }
    return 1;
  }
  
  public static String a(String paramString)
  {
    paramString = (String)bhsi.a(BaseApplicationImpl.context, paramString, "key_selected_browser_name", "");
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
      if (!blhx.a(BaseApplication.context, str))
      {
        a(aqkh.a(), "");
        paramString2 = "";
      }
    }
    if (TextUtils.isEmpty(paramString2))
    {
      new aqkd(paramActivity, paramString1).b();
      return;
    }
    aqkh.a(paramActivity, paramString1, paramString2);
  }
  
  private void a(aqkg paramaqkg)
  {
    Object localObject = BaseApplication.context.getResources();
    aqke localaqke = new aqke(this, paramaqkg);
    aqkf localaqkf = new aqkf(this);
    localObject = String.format(((Resources)localObject).getString(2131690552), new Object[] { paramaqkg.a() });
    bhlq.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, (String)localObject, localaqke, localaqkf).show();
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, new Object[] { "[dialog] showDownloadBrowserConfirmDialog: invoked. ", " browser: ", paramaqkg });
    }
    azir.a("0X800ADEE");
  }
  
  private static void a(String paramString1, String paramString2)
  {
    bhsi.a(BaseApplicationImpl.context, paramString1, true, "key_selected_browser_name", paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, new Object[] { "[sp] saveSpSelectedBrowserPackage: invoked. ", " pkg: ", paramString2 });
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Aqkk.getCount() <= 0)
    {
      zyx.a(1, 2131694663);
      if (QLog.isColorLevel()) {
        QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, "[error] showPopupWindow: invoked. [没有任何浏览器时，对齐旧的错误toast]");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_Aqki.a();
    if (localObject != null) {
      ((XListView)localObject).setAdapter(this.jdField_a_of_type_Aqkk);
    }
    localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setDimAmount(0.5F);
      this.jdField_a_of_type_Aqki.showAtLocation(((Window)localObject).getDecorView(), 80, 0, 0);
    }
    azir.a("0X800ADEA");
  }
  
  private void c()
  {
    Button localButton = this.jdField_a_of_type_Aqki.a();
    if (localButton != null) {
      localButton.setOnClickListener(this);
    }
    localButton = this.jdField_a_of_type_Aqki.b();
    if (localButton != null) {
      localButton.setOnClickListener(this);
    }
  }
  
  private void d()
  {
    e();
    aqkg localaqkg = this.jdField_a_of_type_Aqkk.a();
    if (localaqkg != null)
    {
      a(aqkh.a(), localaqkg.e());
      azir.a("0X800ADED", a(localaqkg), "", localaqkg.a());
    }
  }
  
  private void e()
  {
    a();
    aqkg localaqkg = this.jdField_a_of_type_Aqkk.a();
    if (localaqkg == null) {
      return;
    }
    if (localaqkg.a()) {
      aqkh.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, localaqkg.e());
    }
    for (;;)
    {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 1, new Object[] { "[action] onAnyButtonClicked: invoked. ", " browser: ", localaqkg });
      return;
      if (blhx.a(BaseApplication.context, localaqkg.e())) {
        aqkh.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, localaqkg.e());
      } else {
        a(localaqkg);
      }
    }
  }
  
  private void f()
  {
    e();
    aqkg localaqkg = this.jdField_a_of_type_Aqkk.a();
    if (localaqkg != null) {
      azir.a("0X800ADEC", a(localaqkg), "", localaqkg.a());
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Aqki.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Aqki.dismiss();
      if (this.jdField_a_of_type_Aqkk != null) {
        this.jdField_a_of_type_Aqkk.a();
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
    if (paramView.getId() == 2131362667) {
      d();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131372046) {
        f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     aqkd
 * JD-Core Version:    0.7.0.1
 */