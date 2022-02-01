import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.idlefish.flutterboost.containers.BoostFlutterActivity.SerializableMap;
import com.qflutter.native_resources.QFlutterSkinEnginePlugin;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate.1;
import com.tencent.mobileqq.flutter.container.QFlutterFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class auoa
  implements auod, auov
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private aunz jdField_a_of_type_Aunz;
  private auox jdField_a_of_type_Auox;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  private boolean e;
  private boolean f;
  
  public auoa(aunz paramaunz)
  {
    this.jdField_a_of_type_Aunz = paramaunz;
  }
  
  private void g()
  {
    Object localObject1 = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    ((FrameLayout)localObject1).setId(2131367244);
    Object localObject2 = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    this.jdField_a_of_type_AndroidViewViewGroup.bringChildToFront(this.jdField_a_of_type_AndroidViewView);
    String str = this.jdField_a_of_type_AndroidOsBundle.getString("url");
    localObject1 = null;
    if (this.jdField_a_of_type_AndroidOsBundle.getSerializable("params") != null) {
      localObject1 = ((BoostFlutterActivity.SerializableMap)this.jdField_a_of_type_AndroidOsBundle.getSerializable("params")).getMap();
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new HashMap();
    }
    a(this.jdField_a_of_type_Aunz, str, (Map)localObject2, 2131367244);
  }
  
  private void h()
  {
    if ((this.jdField_a_of_type_AndroidAppActivity instanceof BaseActivity))
    {
      BaseActivity localBaseActivity = (BaseActivity)this.jdField_a_of_type_AndroidAppActivity;
      if (this.e)
      {
        SystemBarCompact localSystemBarCompact = localBaseActivity.mSystemBarComp;
        if (localSystemBarCompact != null)
        {
          localSystemBarCompact.setStatusDrawable(null);
          localSystemBarCompact.setStatusBarColor(0);
          localSystemBarCompact.setStatusColor(0);
        }
      }
      ImmersiveUtils.a(this.f, localBaseActivity.getWindow());
    }
  }
  
  public View a()
  {
    QFlutterSkinEnginePlugin.setCurrentThemeId(ThemeUtil.getCurrentThemeId());
    this.jdField_a_of_type_AndroidViewViewGroup = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850034);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560884, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a()
  {
    if (auoy.a().a()) {
      this.jdField_a_of_type_Boolean = false;
    }
    auoy.a().a(this, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Boolean);
    aupk.a().a(this.jdField_a_of_type_JavaLangString);
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Boolean = false;
      paramBundle.remove("android:support:fragments");
    }
    if ((this.jdField_a_of_type_Aunz.a() == null) || (this.jdField_a_of_type_Aunz.a() == null)) {
      throw new RuntimeException("must specify Activity and FragmentManager!");
    }
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_Aunz.a();
    this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_Aunz.a();
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_AndroidOsBundle.getString("url");
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("click_millis", 0L);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("preload_process", false);
    this.e = this.jdField_a_of_type_AndroidOsBundle.getBoolean("need_status_bar_trans", false);
    this.f = this.jdField_a_of_type_AndroidOsBundle.getBoolean("need_status_text_dark", false);
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_b_of_type_Long == 0L)) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void a(aunz paramaunz, String paramString, Map paramMap, int paramInt)
  {
    paramString = new auob().a(paramString).a(paramMap).a();
    paramString.a(new auoc(this));
    paramaunz = (FragmentManager)paramaunz.a();
    if (paramaunz != null) {
      paramaunz.beginTransaction().add(paramInt, paramString).commitAllowingStateLoss();
    }
  }
  
  public void a(auow paramauow)
  {
    if ((paramauow != null) && (paramauow.a()))
    {
      this.jdField_c_of_type_Boolean = paramauow.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Auox = paramauow.jdField_a_of_type_Auox;
      this.d = true;
      this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
      g();
      if (paramauow.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131697979, 1).a();
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131693677, 1).a();
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void b()
  {
    QLog.d("QFlutter.fragment", 1, String.format("onFirstFrameRendered, mIsFirstLaunch: %s, mNeedReport: %s", new Object[] { Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.jdField_a_of_type_Boolean) }));
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      long l = SystemClock.elapsedRealtime();
      ThreadManager.getSubThreadHandler().post(new QFlutterContainerDelegate.1(this, l));
    }
    aupk.a().a(this.jdField_c_of_type_Boolean);
    h();
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    aupk.a().a();
  }
  
  public void e()
  {
    auoy.a().a(this);
    aupk.a().a(this.jdField_c_of_type_Boolean, this.d);
  }
  
  public void f()
  {
    QFlutterSkinEnginePlugin.setCurrentThemeId(ThemeUtil.getCurrentThemeId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auoa
 * JD-Core Version:    0.7.0.1
 */