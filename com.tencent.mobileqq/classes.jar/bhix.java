import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.mobileqq.activity.RegisterByNicknameAndPwdActivity;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.mobileqq.activity.RegisterPersonalInfoActivity;
import com.tencent.mobileqq.activity.RegisterQQNumberActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.vip.lianghao.RegisterLHAssistant.2;
import com.tencent.mobileqq.vip.lianghao.view.RegisterLiangHaoChoiceLayoutView;
import com.tencent.mobileqq.widget.ClearableEditText;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ScrollView;
import java.util.Locale;
import mqq.os.MqqHandler;

public class bhix
{
  public static int a;
  public static String a;
  private Intent jdField_a_of_type_AndroidContentIntent;
  private final View jdField_a_of_type_AndroidViewView;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public baim a;
  private bhja jdField_a_of_type_Bhja;
  private bhjb jdField_a_of_type_Bhjb;
  private final RegisterNewBaseActivity jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity;
  private ScrollView jdField_a_of_type_ComTencentWidgetScrollView;
  private MqqHandler jdField_a_of_type_MqqOsMqqHandler = new bhiy(this);
  public boolean a;
  private int jdField_b_of_type_Int;
  public String b;
  private boolean jdField_b_of_type_Boolean;
  private String c;
  private String d;
  private String e;
  private String f;
  
  static
  {
    jdField_a_of_type_JavaLangString = "RegisterLHAssistant";
  }
  
  public bhix(RegisterNewBaseActivity paramRegisterNewBaseActivity, View paramView, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity = paramRegisterNewBaseActivity;
    this.jdField_a_of_type_Bhjb = new bhjb(paramRegisterNewBaseActivity, this);
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_ComTencentWidgetScrollView = ((ScrollView)this.jdField_a_of_type_AndroidViewView.findViewById(2131376807));
    this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131380998));
    jdField_a_of_type_Int = paramInt;
    e();
  }
  
  public static void a(Context paramContext, boolean paramBoolean, String paramString1, String paramString2, Intent paramIntent)
  {
    if ((paramContext == null) || (TextUtils.isEmpty(paramString1)) || (paramIntent == null)) {
      return;
    }
    boolean bool;
    if (jdField_a_of_type_Int == 1)
    {
      if (paramBoolean) {}
      for (str = "1";; str = "2")
      {
        bcst.a(null, "new_reg", "setting_page_yes", "result", "", 1, "", "", str, "", "", "", "", "", "");
        if (QLog.isColorLevel()) {
          a("gotoNextAfterPaidLH-register", paramIntent);
        }
        bool = paramIntent.getBooleanExtra("key_register_chose_bind_phone", false);
        paramIntent = new Intent(paramIntent);
        if (!paramBoolean) {
          break label211;
        }
        paramIntent.setComponent(new ComponentName(paramContext, RegisterQQNumberActivity.class));
        paramIntent.putExtra("uin", paramString1);
        paramIntent.putExtra("key_register_is_lh", true);
        paramContext.startActivity(paramIntent);
        if (!QLog.isColorLevel()) {
          break;
        }
        a("gotoNextAfterPaidLH-intent", paramIntent);
        return;
      }
    }
    if (paramBoolean) {}
    for (String str = "1";; str = "2")
    {
      bcst.a(null, "new_reg", "setting_page_no", "result", "", 1, "", "", str, "", "", "", "", "", "");
      break;
    }
    label211:
    if (bool) {
      paramIntent.setComponent(new ComponentName(paramContext, RegisterPersonalInfoActivity.class));
    }
    for (;;)
    {
      paramIntent.putExtra("key_register_from_fail_pay_lh", true);
      paramIntent.putExtra("key_register_fail_paid_lh", paramString1);
      paramIntent.putExtra("lh_uin", paramString1);
      paramIntent.putExtra("lh_light", paramString2);
      break;
      paramIntent.setComponent(new ComponentName(paramContext, RegisterByNicknameAndPwdActivity.class));
    }
  }
  
  public static void a(String paramString, Intent paramIntent)
  {
    if ((QLog.isColorLevel()) && (paramIntent != null)) {}
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(500);
      localStringBuilder.append("--------------").append(paramString).append("---------------------\r\n");
      if (paramIntent.hasExtra("phonenum")) {
        localStringBuilder.append("phoneNum: ").append(bgoc.a(paramIntent.getStringExtra("phonenum"))).append("\r\n");
      }
      if (paramIntent.hasExtra("key")) {
        localStringBuilder.append("countryCode: ").append(paramIntent.getStringExtra("key")).append("\r\n");
      }
      if (paramIntent.hasExtra("uin")) {
        localStringBuilder.append("uin: ").append(paramIntent.getStringExtra("uin")).append("\r\n");
      }
      if (paramIntent.hasExtra("invite_code")) {
        localStringBuilder.append("inviteCode: ").append(paramIntent.getStringExtra("uin")).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_sign")) {
        localStringBuilder.append("sign: ").append(MD5.toMD5(paramIntent.getByteArrayExtra("key_register_sign"))).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_smscode")) {
        localStringBuilder.append("smsCode: ").append(paramIntent.getStringExtra("key_register_smscode")).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_nick")) {
        localStringBuilder.append("nick: ").append(paramIntent.getStringExtra("key_register_nick")).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_is_phone_num_registered")) {
        localStringBuilder.append("isPhoneNumRegistered: ").append(paramIntent.getBooleanExtra("key_register_is_phone_num_registered", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_chose_bind_phone")) {
        localStringBuilder.append("isChooseBindPhoneNum: ").append(paramIntent.getBooleanExtra("key_register_chose_bind_phone", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_unbind")) {
        localStringBuilder.append("unbind: ").append(paramIntent.getBooleanExtra("key_register_unbind", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_has_pwd")) {
        localStringBuilder.append("hasPwd: ").append(paramIntent.getBooleanExtra("key_register_has_pwd", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_from_send_sms")) {
        localStringBuilder.append("fromSendSmsCode: ").append(paramIntent.getBooleanExtra("key_register_from_send_sms", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_from_quick_register")) {
        localStringBuilder.append("quickRegister: ").append(paramIntent.getBooleanExtra("key_register_from_quick_register", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_is_lh")) {
        localStringBuilder.append("isLH: ").append(paramIntent.getBooleanExtra("key_register_is_lh", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_from_fail_pay_lh")) {
        localStringBuilder.append("isFromFailPayLh: ").append(paramIntent.getBooleanExtra("key_register_from_fail_pay_lh", false)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_fail_paid_lh")) {
        localStringBuilder.append("failPayLH: ").append(paramIntent.getStringExtra("key_register_fail_paid_lh")).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_result")) {
        localStringBuilder.append("registerResult: ").append(paramIntent.getBooleanExtra("key_register_result", true)).append("\r\n");
      }
      if (paramIntent.hasExtra("key_register_password")) {
        localStringBuilder.append("pwd: ").append(MD5.toMD5(paramIntent.getStringExtra("key_register_password"))).append("\r\n");
      }
      localStringBuilder.append("-------------------------end---------------------------------\r\n");
      QLog.i(jdField_a_of_type_JavaLangString, 2, localStringBuilder.toString());
      return;
    }
    catch (Exception paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  private void e()
  {
    Intent localIntent = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent();
    this.jdField_a_of_type_AndroidContentIntent = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent());
    this.e = localIntent.getStringExtra("phonenum");
    this.f = localIntent.getStringExtra("key");
    this.jdField_a_of_type_Boolean = localIntent.getBooleanExtra("key_register_from_fail_pay_lh", false);
    this.jdField_b_of_type_JavaLangString = localIntent.getStringExtra("key_register_fail_paid_lh");
    this.c = localIntent.getStringExtra("key_register_nick");
    this.d = localIntent.getStringExtra("key_register_password");
    if (QLog.isColorLevel()) {
      a("RegisterLHAssistant init-from", localIntent);
    }
    ClearableEditText localClearableEditText1;
    if (jdField_a_of_type_Int == 1)
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_unbind", true);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_chose_bind_phone", false);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363887));
      this.jdField_a_of_type_AndroidWidgetButton.setText(2131715766);
      if (!this.jdField_a_of_type_Boolean) {
        break label412;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.b(false);
      if (jdField_a_of_type_Int != 1) {
        break label375;
      }
      ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131372188)).setVisibility(0);
      localClearableEditText1 = (ClearableEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371724);
      ClearableEditText localClearableEditText2 = (ClearableEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131372187);
      localClearableEditText1.setText(this.c);
      localClearableEditText1.setEnabled(false);
      localClearableEditText2.setText(this.d);
      localClearableEditText2.setEnabled(false);
      label250:
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumHeight(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_AndroidWidgetFrameLayout.scrollTo(0, 0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Bhjb.a(new bhjf(localIntent)));
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.app.setHandler(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getClass(), this.jdField_a_of_type_MqqOsMqqHandler);
      return;
      if (jdField_a_of_type_Int != 2) {
        break;
      }
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_unbind", false);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_chose_bind_phone", true);
      this.jdField_a_of_type_AndroidWidgetButton = ((Button)this.jdField_a_of_type_AndroidViewView.findViewById(2131363785));
      break;
      label375:
      if (jdField_a_of_type_Int != 2) {
        break label250;
      }
      localClearableEditText1 = (ClearableEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371724);
      localClearableEditText1.setText(this.c);
      localClearableEditText1.setEnabled(false);
      break label250;
      label412:
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumHeight(0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
      this.jdField_a_of_type_ComTencentWidgetScrollView.scrollTo(0, 0);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      d();
    }
  }
  
  public Intent a()
  {
    ClearableEditText localClearableEditText1;
    if (jdField_a_of_type_Int == 1)
    {
      localClearableEditText1 = (ClearableEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371724);
      ClearableEditText localClearableEditText2 = (ClearableEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131372187);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_nick", localClearableEditText1.getText().toString());
      this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_password", localClearableEditText2.getText().toString());
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        a("getRegisterData-registerData", this.jdField_a_of_type_AndroidContentIntent);
      }
      return this.jdField_a_of_type_AndroidContentIntent;
      if (jdField_a_of_type_Int == 2)
      {
        localClearableEditText1 = (ClearableEditText)this.jdField_a_of_type_AndroidViewView.findViewById(2131371724);
        this.jdField_a_of_type_AndroidContentIntent.putExtra("key_register_nick", localClearableEditText1.getText().toString());
      }
    }
  }
  
  public void a()
  {
    b();
    e();
  }
  
  public void a(boolean paramBoolean)
  {
    Intent localIntent;
    if (this.jdField_a_of_type_Baim == null)
    {
      this.jdField_a_of_type_Baim = new baim(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity);
      localIntent = new Intent();
      localIntent.putExtra("key_register_from_fail_pay_lh", this.jdField_a_of_type_Boolean);
      localIntent.putExtra("key_register_fail_paid_lh", this.jdField_b_of_type_JavaLangString);
      localIntent.putExtra("key_register_nick", this.c);
      localIntent.putExtra("key_register_password", this.d);
      if (jdField_a_of_type_Int != 2) {
        break label117;
      }
    }
    label117:
    for (boolean bool = true;; bool = false)
    {
      localIntent.putExtra("key_register_chose_bind_phone", bool);
      localIntent.putExtra("key_register_phonenum_bindnewqq", paramBoolean);
      this.jdField_a_of_type_Baim.a(localIntent);
      this.jdField_a_of_type_Baim.b();
      return;
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_Baim != null) {
      this.jdField_a_of_type_Baim.a();
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.app.removeHandler(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getClass());
    if (this.jdField_a_of_type_AndroidWidgetFrameLayout != null)
    {
      if (this.jdField_a_of_type_Bhja != null) {
        this.jdField_a_of_type_AndroidWidgetFrameLayout.removeOnLayoutChangeListener(this.jdField_a_of_type_Bhja);
      }
      this.jdField_a_of_type_Bhja = null;
      this.jdField_a_of_type_AndroidWidgetFrameLayout.removeAllViews();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      do
      {
        return;
        i = this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility();
        if (this.jdField_b_of_type_Boolean) {
          break;
        }
        if (this.jdField_a_of_type_ComTencentWidgetScrollView.getScrollY() != 0) {
          this.jdField_a_of_type_ComTencentWidgetScrollView.scrollTo(0, 0);
        }
      } while (this.jdField_a_of_type_AndroidWidgetFrameLayout.getVisibility() == 8);
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(8);
      return;
      if ((i == 0) && (paramBoolean))
      {
        this.jdField_a_of_type_Bhjb.a().a(true);
        return;
      }
      if (i == 0)
      {
        this.jdField_a_of_type_Bhjb.a().a(false);
        return;
      }
    } while ((i != 8) || (!paramBoolean));
    int[] arrayOfInt = new int[2];
    int j = this.jdField_a_of_type_AndroidWidgetButton.getContext().getResources().getDisplayMetrics().heightPixels;
    this.jdField_a_of_type_AndroidWidgetButton.getLocationOnScreen(arrayOfInt);
    int i = j - (arrayOfInt[1] + this.jdField_a_of_type_AndroidWidgetButton.getHeight());
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, String.format(Locale.getDefault(), "screen: %d, top: %d, height: %d, left: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(arrayOfInt[1]), Integer.valueOf(this.jdField_a_of_type_AndroidWidgetButton.getHeight()), Integer.valueOf(i) }));
    }
    this.jdField_a_of_type_AndroidViewView.findViewById(2131374642).getLocationOnScreen(arrayOfInt);
    j = arrayOfInt[1];
    this.jdField_a_of_type_AndroidViewView.findViewById(2131371724).getLocationOnScreen(arrayOfInt);
    int k = arrayOfInt[1];
    this.jdField_b_of_type_Int = (k - j);
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, String.format(Locale.getDefault(), "lineA: %d, lineB: %d, scrollHeight: %d", new Object[] { Integer.valueOf(j), Integer.valueOf(k), Integer.valueOf(this.jdField_b_of_type_Int) }));
    }
    i = this.jdField_b_of_type_Int + i;
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.setMinimumHeight(i);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_Bhjb.a());
    if (QLog.isColorLevel()) {
      QLog.i(jdField_a_of_type_JavaLangString, 2, String.format(Locale.getDefault(), "miniHeight: %d", new Object[] { Integer.valueOf(i) }));
    }
    if (this.jdField_a_of_type_Bhja == null) {
      this.jdField_a_of_type_Bhja = new bhja(this.jdField_a_of_type_ComTencentWidgetScrollView, this.jdField_b_of_type_Int, null);
    }
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addOnLayoutChangeListener(this.jdField_a_of_type_Bhja);
  }
  
  public void c()
  {
    if (jdField_a_of_type_Int == 1) {
      bcst.a(null, "new_reg", "setting_page_yes", "lianghao_clk", "", 1, "");
    }
    while (jdField_a_of_type_Int != 2) {
      return;
    }
    bcst.a(null, "new_reg", "setting_page_no", "lianghao_clk", "", 1, "");
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterNewBaseActivity.getIntent().getBooleanExtra("key_register_from_quick_register", false))
    {
      this.jdField_b_of_type_Boolean = false;
      if (QLog.isDevelopLevel()) {
        QLog.i(jdField_a_of_type_JavaLangString, 4, "checkVipQQStatus isQuickRegister = true");
      }
      return;
    }
    ThreadManager.excute(new RegisterLHAssistant.2(this), 16, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bhix
 * JD-Core Version:    0.7.0.1
 */