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

public class azgy
  extends ReportDialog
{
  static boolean jdField_a_of_type_Boolean = true;
  static boolean b;
  int jdField_a_of_type_Int = 2;
  protected Context a;
  VoicePanelSlideContainer jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer;
  AppActivity jdField_a_of_type_MqqAppAppActivity;
  boolean c = false;
  
  public azgy(@NonNull AppActivity paramAppActivity)
  {
    super(paramAppActivity, 2131755206);
    this.jdField_a_of_type_AndroidContentContext = paramAppActivity;
    setCanceledOnTouchOutside(true);
    this.jdField_a_of_type_MqqAppAppActivity = paramAppActivity;
    if (a()) {
      b = true;
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    jdField_a_of_type_Boolean = paramBoolean;
    try
    {
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0).edit();
      localEditor.putBoolean("need_open_guider", paramBoolean);
      localEditor.apply();
      azeu.a("HelloQQWake", "setNeedOpenGuide:" + jdField_a_of_type_Boolean);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        azeu.a("HelloQQWake", localException.getMessage());
      }
    }
  }
  
  public static boolean a()
  {
    if (jdField_a_of_type_Boolean) {}
    try
    {
      jdField_a_of_type_Boolean = BaseApplicationImpl.getApplication().getSharedPreferences("qq_assistant_sp_key", 0).getBoolean("need_open_guider", true);
      azeu.a("HelloQQWake", "getNeedOpenGuide:" + jdField_a_of_type_Boolean);
      return jdField_a_of_type_Boolean;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        azeu.a("HelloQQWake", localException.getMessage());
      }
    }
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_Int > 0) {
      bcef.b(null, "dc00898", "", "", "0X800B44B", "0X800B44B", this.jdField_a_of_type_Int, 0, "", "", "", "");
    }
    if (this.c) {
      azhh.a().a("QQAssistantGuider dismiss");
    }
    super.dismiss();
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131560967, null);
    setContentView(paramBundle);
    Object localObject = paramBundle.getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = paramBundle.getResources().getDisplayMetrics().widthPixels;
    paramBundle.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = getWindow();
    ((Window)localObject).setWindowAnimations(2131755572);
    ((Window)localObject).setGravity(80);
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer = ((VoicePanelSlideContainer)paramBundle.findViewById(2131377554));
    this.jdField_a_of_type_ComTencentMobileqqQassistantViewVoicePanelSlideContainer.setPanelSlideListener(new azgz(this));
    ((ImageView)paramBundle.findViewById(2131362929)).setOnClickListener(new azha(this));
    if ((Build.VERSION.SDK_INT < 23) || (BaseApplicationImpl.getContext().checkSelfPermission("android.permission.RECORD_AUDIO") == 0)) {}
    boolean bool2;
    Button localButton;
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = FloatingScreenPermission.checkPermission(BaseApplicationImpl.getContext());
      localObject = (TextView)paramBundle.findViewById(2131377582);
      localButton = (Button)paramBundle.findViewById(2131363638);
      ((Button)paramBundle.findViewById(2131363637)).setOnClickListener(new azhb(this));
      if ((!bool1) || (!bool2)) {
        break;
      }
      ((TextView)localObject).setVisibility(8);
      localButton.setOnClickListener(new azhc(this));
      return;
    }
    localButton.setOnClickListener(new azhd(this, bool1, bool2));
  }
  
  public void show()
  {
    a(false);
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     azgy
 * JD-Core Version:    0.7.0.1
 */