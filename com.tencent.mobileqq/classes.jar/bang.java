import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.qassistant.view.VoicePanelSlideContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenPermission;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import mqq.app.AppActivity;

public class bang
  extends ReportDialog
{
  static boolean jdField_a_of_type_Boolean = true;
  static boolean b;
  public static volatile boolean c;
  int jdField_a_of_type_Int = 2;
  protected Context a;
  VoicePanelSlideContainer jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer;
  AppActivity jdField_a_of_type_MqqAppAppActivity;
  boolean d = false;
  
  public bang(@NonNull AppActivity paramAppActivity)
  {
    super(paramAppActivity, 2131755206);
    this.jdField_a_of_type_AndroidContentContext = paramAppActivity;
    setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_MqqAppAppActivity = paramAppActivity;
    banp.a().b("QQAssistantGuider()");
    if (a()) {
      b = true;
    }
    this.d = true;
  }
  
  public static void a()
  {
    c = false;
    b = false;
    a(true);
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    try
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0).edit();
      localEditor.putBoolean("need_open_guider", paramBoolean);
      localEditor.apply();
      bakl.a("HelloQQWake", "setNeedOpenGuide:" + jdField_a_of_type_Boolean);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bakl.a("HelloQQWake", localException.getMessage());
      }
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Boolean) {}
    try
    {
      jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0).getBoolean("need_open_guider", true);
      bakl.a("HelloQQWake", "getNeedOpenGuide:" + jdField_a_of_type_Boolean);
      return jdField_a_of_type_Boolean;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        bakl.a("HelloQQWake", localException.getMessage());
      }
    }
  }
  
  public void dismiss()
  {
    c = false;
    if (this.jdField_a_of_type_Int > 0) {
      bdla.b(null, "dc00898", "", "", "0X800B44B", "0X800B44B", this.jdField_a_of_type_Int, 0, "", "", "", "");
    }
    if (this.d) {
      banp.a().a("QQAssistantGuider dismiss");
    }
    super.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561028, null);
    setContentView(paramBundle);
    Object localObject = paramBundle.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramBundle.getResources().getDisplayMetrics().widthPixels;
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = getWindow();
    ((Window)localObject).setWindowAnimations(2131755575);
    ((Window)localObject).setGravity(80);
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer = ((VoicePanelSlideContainer)paramBundle.findViewById(2131377828));
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer.setPanelSlideListener(new banh(this));
    ((ImageView)paramBundle.findViewById(2131362946)).setOnClickListener(new bani(this));
    if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0)) {}
    boolean bool2;
    Button localButton;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = FloatingScreenPermission.checkPermission(BaseApplicationImpl.getContext());
      localObject = (TextView)paramBundle.findViewById(2131377856);
      localButton = (Button)paramBundle.findViewById(2131363707);
      ((Button)paramBundle.findViewById(2131363706)).setOnClickListener(new banj(this));
      if ((!bool1) || (!bool2)) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      localButton.setOnClickListener(new bank(this));
      return;
    }
    localButton.setOnClickListener(new banl(this, bool1, bool2));
  }
  
  public void show()
  {
    c = true;
    a(false);
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     bang
 * JD-Core Version:    0.7.0.1
 */