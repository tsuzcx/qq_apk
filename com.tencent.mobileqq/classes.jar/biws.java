import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Color;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenContainer;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenParams.FloatingBuilder;
import com.tencent.mobileqq.widget.qqfloatingscreen.FloatingScreenStatusReceiver;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingLocationWrapper.2;
import com.tencent.mobileqq.widget.qqfloatingscreen.uiwrapper.FloatingLocationWrapper.3;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class biws
  extends biwr
  implements awoh, biwf
{
  public biws(Context paramContext)
  {
    super(paramContext);
    f();
  }
  
  private awnx a()
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      return awnx.a((QQAppInterface)localAppRuntime);
    }
    return null;
  }
  
  private void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.setOnDragListener(this);
    if (a() != null) {
      a().a().a(this);
    }
  }
  
  private void g()
  {
    View localView = this.jdField_a_of_type_AndroidWidgetRelativeLayout.findViewById(2131374504);
    localView.setContentDescription("位置共享悬浮窗");
    if (blfw.a())
    {
      localView.setBackgroundColor(Color.parseColor("#4D000000"));
      return;
    }
    localView.setBackgroundColor(Color.parseColor("#00000000"));
  }
  
  public int a(FloatingScreenParams paramFloatingScreenParams, View paramView)
  {
    FloatingScreenParams localFloatingScreenParams = paramFloatingScreenParams;
    if (paramFloatingScreenParams == null)
    {
      if (this.jdField_a_of_type_AndroidContentContext != null) {
        localFloatingScreenParams = new FloatingScreenParams.FloatingBuilder().setCanZoom(false).build();
      }
    }
    else
    {
      paramFloatingScreenParams = new FloatingLocationWrapper.2(this, paramView, localFloatingScreenParams);
      ThreadManager.getUIHandlerV2().postDelayed(paramFloatingScreenParams, 500L);
      return 0;
    }
    return 2;
  }
  
  public void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d("FloatingLocationWrapper", 2, new Object[] { "onThemeChanged: invoked. ", " TAG: ", "FloatingLocationWrapper" });
    }
    g();
  }
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription("关闭位置共享悬浮窗");
    g();
  }
  
  public void a(FloatingScreenParams paramFloatingScreenParams)
  {
    SharedPreferences localSharedPreferences = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4);
    int i = localSharedPreferences.getInt("KEY_QQFS_LOCATION_SHARE_CENTER_X", -2147483648);
    int j = localSharedPreferences.getInt("KEY_QQFS_LOCATION_SHARE_CENTER_Y", -2147483648);
    if ((i != -2147483648) && (j != -2147483648))
    {
      paramFloatingScreenParams.setFloatingCenterX(i);
      paramFloatingScreenParams.setFloatingCenterY(j);
    }
    if (QLog.isColorLevel()) {
      QLog.d("FloatingLocationWrapper", 2, new Object[] { "restoreLastCenterPosition: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j) });
    }
  }
  
  public void b()
  {
    bdla.b(null, "CliOper", "", "", "0X800A977", "0X800A977", 0, 0, "", "0", "0", "");
  }
  
  public void b(int paramInt)
  {
    FloatingLocationWrapper.3 local3 = new FloatingLocationWrapper.3(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local3);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver = new FloatingScreenStatusReceiver(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenStatusReceiver.a(1, new biwt(this));
    }
  }
  
  public void e()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer != null)
    {
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b();
      SharedPreferences.Editor localEditor = BaseApplicationImpl.getContext().getSharedPreferences("qqfs_floating_sp", 4).edit();
      int i = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.a();
      int j = this.jdField_a_of_type_ComTencentMobileqqWidgetQqfloatingscreenFloatingScreenContainer.b();
      localEditor.putInt("KEY_QQFS_LOCATION_SHARE_CENTER_X", i);
      localEditor.putInt("KEY_QQFS_LOCATION_SHARE_CENTER_Y", j);
      localEditor.apply();
      if (QLog.isColorLevel()) {
        QLog.d("FloatingLocationWrapper", 2, new Object[] { "saveFloatingCenter: invoked. ", " centerX: ", Integer.valueOf(i), " centerY: ", Integer.valueOf(j), " isSmallFloating: ", Boolean.valueOf(bool) });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     biws
 * JD-Core Version:    0.7.0.1
 */