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

public class awwb
{
  ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private awvn jdField_a_of_type_Awvn;
  awvz jdField_a_of_type_Awvz = new awwc(this);
  public Conversation a;
  boolean jdField_a_of_type_Boolean = true;
  private ViewGroup b;
  
  public awwb(Conversation paramConversation, ViewGroup paramViewGroup)
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
      if (this.jdField_a_of_type_Awvn == null)
      {
        this.jdField_a_of_type_Awvn = new awvn("Login.Guide");
        this.jdField_a_of_type_Awvn.observerOnUiThread = true;
      }
      if (!bool1) {
        apch.a(this.jdField_a_of_type_Awvn);
      }
      return;
    }
  }
  
  private void a(awvw paramawvw)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityConversation.h_()) {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "mConversation is not Foreground");
      }
    }
    do
    {
      return;
      if (!TextUtils.isEmpty(paramawvw.jdField_a_of_type_JavaLangString)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LoginWelcomeManager", 2, "Bad url: " + paramawvw.jdField_a_of_type_JavaLangString);
    return;
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "show common guide web");
    }
    Object localObject = BaseActivity.sTopActivity;
    Intent localIntent = new Intent((Context)localObject, QQTranslucentBrowserActivity.class);
    localIntent.putExtra("url", paramawvw.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("flag_show_loading_dialog", false);
    localIntent.putExtra("hide_left_button", true);
    localIntent.setData(Uri.parse(paramawvw.jdField_a_of_type_JavaLangString));
    ((Activity)localObject).startActivity(localIntent);
    localObject = LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a);
    ((LoginWelcomeManager)localObject).c = false;
    ((LoginWelcomeManager)localObject).jdField_a_of_type_Boolean = true;
    LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a, paramawvw.jdField_a_of_type_Int);
  }
  
  private void a(URLDrawable paramURLDrawable)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginWelcomeManager", 2, "realShowContactsGuideLayer");
    }
    if (!this.jdField_a_of_type_ComTencentMobileqqActivityConversation.h_()) {
      if (QLog.isColorLevel()) {
        QLog.d("LoginWelcomeManager", 2, "mConversation is not Foreground");
      }
    }
    do
    {
      return;
      if ((this.b != null) && (this.b.findViewById(2131364997) == null) && (paramURLDrawable != null) && (paramURLDrawable.getStatus() == 1) && (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a != null)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("LoginWelcomeManager", 2, "view repeat or mDragHost==null or drawable status wrong");
    return;
    if (this.jdField_a_of_type_AndroidViewViewGroup == null)
    {
      this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)LayoutInflater.from(this.b.getContext()).inflate(2131558970, null));
      Object localObject1 = (ImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131364606);
      ((ImageView)localObject1).setContentDescription(anzj.a(2131705255));
      ((ImageView)localObject1).setOnClickListener(new awwd(this));
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a();
      Object localObject2 = (Button)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131366669);
      ((Button)localObject2).setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a().getString(2131697927));
      ((Button)localObject2).setOnClickListener(new awwe(this, (Activity)localObject1));
      localObject2 = (TextView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365658);
      ((TextView)localObject2).setContentDescription(((Activity)localObject1).getString(2131697926));
      ((TextView)localObject2).setOnClickListener(new awwf(this, (Activity)localObject1));
      localObject1 = (ThemeImageView)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131365047);
      ((ThemeImageView)localObject1).setMaskShape(blqj.b);
      ((ThemeImageView)localObject1).setImageDrawable(paramURLDrawable);
    }
    this.b.removeView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.b.addView(this.jdField_a_of_type_AndroidViewViewGroup);
    LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a);
    paramURLDrawable = LoginWelcomeManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a);
    paramURLDrawable.b = false;
    paramURLDrawable.jdField_a_of_type_Boolean = true;
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
      ((LoginWelcomeManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(146)).a(this.jdField_a_of_type_Awvz);
    }
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a != null) {
      ((LoginWelcomeManager)this.jdField_a_of_type_ComTencentMobileqqActivityConversation.a.getManager(146)).a(null);
    }
    if (this.jdField_a_of_type_Awvn != null)
    {
      apch.b(this.jdField_a_of_type_Awvn);
      this.jdField_a_of_type_Awvn = null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     awwb
 * JD-Core Version:    0.7.0.1
 */