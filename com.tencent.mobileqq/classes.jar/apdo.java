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

public class apdo
  implements View.OnClickListener
{
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final apdt jdField_a_of_type_Apdt;
  private final apdv jdField_a_of_type_Apdv;
  private final String jdField_a_of_type_JavaLangString;
  
  private apdo(Activity paramActivity, String paramString)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_Apdv = new apdv(paramActivity);
    paramActivity = apds.a(paramActivity, apxa.a());
    this.jdField_a_of_type_Apdv.a(paramActivity);
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Apdt = apdt.a(this.jdField_a_of_type_AndroidAppActivity, -1, -1);
    c();
  }
  
  private static int a(apdr paramapdr)
  {
    if (paramapdr.a()) {
      return 2;
    }
    return 1;
  }
  
  public static String a(String paramString)
  {
    paramString = (String)bfyz.a(BaseApplicationImpl.context, paramString, "key_selected_browser_name", "");
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
      if (!bjnn.a(BaseApplication.context, str))
      {
        a(apds.a(), "");
        paramString2 = "";
      }
    }
    if (TextUtils.isEmpty(paramString2))
    {
      new apdo(paramActivity, paramString1).b();
      return;
    }
    apds.a(paramActivity, paramString1, paramString2);
  }
  
  private void a(apdr paramapdr)
  {
    Object localObject = BaseApplication.context.getResources();
    apdp localapdp = new apdp(this, paramapdr);
    apdq localapdq = new apdq(this);
    localObject = String.format(((Resources)localObject).getString(2131690592), new Object[] { paramapdr.a() });
    bfur.a(this.jdField_a_of_type_AndroidAppActivity, 230, null, (String)localObject, localapdp, localapdq).show();
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, new Object[] { "[dialog] showDownloadBrowserConfirmDialog: invoked. ", " browser: ", paramapdr });
    }
    axvz.a("0X800ADEE");
  }
  
  private static void a(String paramString1, String paramString2)
  {
    bfyz.a(BaseApplicationImpl.context, paramString1, true, "key_selected_browser_name", paramString2);
    if (QLog.isColorLevel()) {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, new Object[] { "[sp] saveSpSelectedBrowserPackage: invoked. ", " pkg: ", paramString2 });
    }
  }
  
  private void b()
  {
    if (this.jdField_a_of_type_Apdv.getCount() <= 0)
    {
      yyi.a(1, 2131694779);
      if (QLog.isColorLevel()) {
        QLog.d("[BrowserOpt] BrowserDialogViewModel", 2, "[error] showPopupWindow: invoked. [没有任何浏览器时，对齐旧的错误toast]");
      }
      return;
    }
    Object localObject = this.jdField_a_of_type_Apdt.a();
    if (localObject != null) {
      ((XListView)localObject).setAdapter(this.jdField_a_of_type_Apdv);
    }
    localObject = this.jdField_a_of_type_AndroidAppActivity.getWindow();
    if (localObject != null)
    {
      ((Window)localObject).setDimAmount(0.5F);
      this.jdField_a_of_type_Apdt.showAtLocation(((Window)localObject).getDecorView(), 80, 0, 0);
    }
    axvz.a("0X800ADEA");
  }
  
  private void c()
  {
    Button localButton = this.jdField_a_of_type_Apdt.a();
    if (localButton != null) {
      localButton.setOnClickListener(this);
    }
    localButton = this.jdField_a_of_type_Apdt.b();
    if (localButton != null) {
      localButton.setOnClickListener(this);
    }
  }
  
  private void d()
  {
    e();
    apdr localapdr = this.jdField_a_of_type_Apdv.a();
    if (localapdr != null)
    {
      a(apds.a(), localapdr.e());
      axvz.a("0X800ADED", a(localapdr), "", localapdr.a());
    }
  }
  
  private void e()
  {
    a();
    apdr localapdr = this.jdField_a_of_type_Apdv.a();
    if (localapdr == null) {
      return;
    }
    if (localapdr.a()) {
      apds.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, localapdr.e());
    }
    for (;;)
    {
      QLog.d("[BrowserOpt] BrowserDialogViewModel", 1, new Object[] { "[action] onAnyButtonClicked: invoked. ", " browser: ", localapdr });
      return;
      if (bjnn.a(BaseApplication.context, localapdr.e())) {
        apds.a(this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_JavaLangString, localapdr.e());
      } else {
        a(localapdr);
      }
    }
  }
  
  private void f()
  {
    e();
    apdr localapdr = this.jdField_a_of_type_Apdv.a();
    if (localapdr != null) {
      axvz.a("0X800ADEC", a(localapdr), "", localapdr.a());
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Apdt.isShowing()) {}
    try
    {
      this.jdField_a_of_type_Apdt.dismiss();
      if (this.jdField_a_of_type_Apdv != null) {
        this.jdField_a_of_type_Apdv.a();
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
    if (paramView.getId() == 2131362671) {
      d();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == 2131372011) {
        f();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     apdo
 * JD-Core Version:    0.7.0.1
 */