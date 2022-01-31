import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.loginwelcome.LoginWelcomeManager;
import com.tencent.mobileqq.loginwelcome.LoginwelcomeHelper.2;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ThemeImageView;

public class atwa
{
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private atvm jdField_a_of_type_Atvm;
  atvy jdField_a_of_type_Atvy = new atwb(this);
  public Conversation a;
  boolean jdField_a_of_type_Boolean = true;
  private ViewGroup b;
  
  public atwa(Conversation paramConversation, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityConversation = paramConversation;
    this.b = paramViewGroup;
  }
  
  private void a(Context paramContext)
  {
    boolean bool2 = false;
    if ((Build.VERSION.SDK_INT >= 23) && (paramContext.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") != 0)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel())
      {
        if (Build.VERSION.SDK_INT >= 23) {
          bool2 = true;
        }
        QLog.i("LoginUserGuideHelper", 2, String.format("requestLocation [%s, %s]", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
      }
      if (this.jdField_a_of_type_Atvm == null)
      {
        this.jdField_a_of_type_Atvm = new atvm("Login.Guide");
        this.jdField_a_of_type_Atvm.observerOnUiThread = true;
      }
      if (!bool1) {
        ampk.a(this.jdField_a_of_type_Atvm);
      }
      return;
    }
  }
  
  private void a(atvv paramatvv)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c()) {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "mConversation is not Foreground");
      }
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramatvv.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LoginWelcomeManager", 2, "Bad url: " + paramatvv.jdField_a_of_type_JavaLangString);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "show common guide web");
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Intent localIntent = new Intent(localBaseActivity, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("url", paramatvv.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("flag_show_loading_dialog", false);
    localIntent.putExtra("hide_left_button", true);
    localIntent.setData(Uri.parse(paramatvv.jdField_a_of_type_JavaLangString));
    localBaseActivity.startActivity(localIntent);
    LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a).c = false;
    LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a, paramatvv.jdField_a_of_type_Int);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realShowContactsGuideLayer");
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityConversation.c()) {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "mConversation is not Foreground");
      }
    }
    do
    {
      return;
      if ((this.b != null) && (this.b.findViewById(2131364724) == null) && (paramURLDrawable != null) && (paramURLDrawable.getStatus() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LoginWelcomeManager", 2, "view repeat or mDragHost==null or drawable status wrong");
    return;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.b.getContext()).inflate(2131558905, null));
      Object localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364350);
      ((ImageView)localObject1).setContentDescription(alud.a(2131706757));
      ((ImageView)localObject1).setOnClickListener(new atwc(this));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
      Object localObject2 = (Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366368);
      ((Button)localObject2).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getString(2131699026));
      ((Button)localObject2).setOnClickListener(new atwd(this, (Activity)localObject1));
      localObject2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365380);
      ((TextView)localObject2).setContentDescription(((Activity)localObject1).getString(2131699025));
      ((TextView)localObject2).setOnClickListener(new atwe(this, (Activity)localObject1));
      localObject1 = (ThemeImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364772);
      ((ThemeImageView)localObject1).setMaskShape(bibv.b);
      ((ThemeImageView)localObject1).setImageDrawable(paramURLDrawable);
    }
    this.b.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.b.addView(this.jdField_a_of_type_AndroidViewViewGroup);
    LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a);
    LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a).b = false;
    a(this.b.getContext());
  }
  
  private boolean a()
  {
    LoginWelcomeManager localLoginWelcomeManager = LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a);
    return (localLoginWelcomeManager.b) || (localLoginWelcomeManager.c);
  }
  
  private void h()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, String.format("isFirstLoginEnter=%s, shouldCheckOnResume=%s", new Object[] { Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(a()) }));
    }
    if ((!this.jdField_a_of_type_Boolean) && (a())) {
      ThreadManagerV2.postImmediately(new LoginwelcomeHelper.2(this), null, true);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void a()
  {
    h();
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a != null) {
      ((LoginWelcomeManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(146)).a(this.jdField_a_of_type_Atvy);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a != null) {
      ((LoginWelcomeManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(146)).a(null);
    }
    if (this.jdField_a_of_type_Atvm != null)
    {
      ampk.b(this.jdField_a_of_type_Atvm);
      this.jdField_a_of_type_Atvm = null;
    }
  }
  
  public void d()
  {
    g();
    c();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void e()
  {
    LoginWelcomeManager.b(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a);
  }
  
  public void f()
  {
    g();
    c();
  }
  
  public void g()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "removeContactsGuidelayer");
    }
    if ((this.b != null) && (this.jdField_a_of_type_AndroidViewViewGroup != null)) {
      this.b.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     atwa
 * JD-Core Version:    0.7.0.1
 */