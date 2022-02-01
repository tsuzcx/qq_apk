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
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate.1;
import com.tencent.mobileqq.flutter.container.QFlutterFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;
import mqq.os.MqqHandler;

public class auwo
  implements auwr, auxg
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private auwn jdField_a_of_type_Auwn;
  private auxi jdField_a_of_type_Auxi;
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private boolean d;
  
  public auwo(auwn paramauwn)
  {
    this.jdField_a_of_type_Auwn = paramauwn;
  }
  
  private void g()
  {
    Object localObject1 = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    ((FrameLayout)localObject1).setId(2131367109);
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
    a(this.jdField_a_of_type_Auwn, str, (Map)localObject2, 2131367109);
  }
  
  public View a()
  {
    QFlutterSkinEnginePlugin.setCurrentThemeId(ThemeUtil.getCurrentThemeId());
    this.jdField_a_of_type_AndroidViewViewGroup = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130850024);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560944, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a()
  {
    if (auxj.a().a()) {
      this.jdField_a_of_type_Boolean = false;
    }
    auxj.a().a(this, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Boolean);
    auxm.a().a();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Boolean = false;
      paramBundle.remove("android:support:fragments");
    }
    if ((this.jdField_a_of_type_Auwn.a() == null) || (this.jdField_a_of_type_Auwn.a() == null)) {
      throw new RuntimeException("must specify Activity and FragmentManager!");
    }
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_Auwn.a();
    this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_Auwn.a();
    if (this.jdField_a_of_type_AndroidOsBundle == null) {
      this.jdField_a_of_type_AndroidOsBundle = new Bundle();
    }
    this.jdField_a_of_type_Long = this.jdField_a_of_type_AndroidOsBundle.getLong("click_millis", 0L);
    this.jdField_b_of_type_Boolean = this.jdField_a_of_type_AndroidOsBundle.getBoolean("preload_process", false);
    this.jdField_b_of_type_Long = SystemClock.elapsedRealtime();
    if ((this.jdField_a_of_type_Long == 0L) || (this.jdField_b_of_type_Long == 0L)) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
  
  protected void a(auwn paramauwn, String paramString, Map paramMap, int paramInt)
  {
    paramString = new auwp().a(paramString).a(paramMap).a();
    paramString.a(new auwq(this));
    paramauwn = (FragmentManager)paramauwn.a();
    if (paramauwn != null) {
      paramauwn.beginTransaction().add(paramInt, paramString).commitAllowingStateLoss();
    }
  }
  
  public void a(auxh paramauxh)
  {
    if ((paramauxh != null) && (paramauxh.a()))
    {
      this.jdField_c_of_type_Boolean = paramauxh.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Auxi = paramauxh.jdField_a_of_type_Auxi;
      this.d = true;
      this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
      g();
      if (paramauxh.jdField_b_of_type_Boolean)
      {
        this.jdField_a_of_type_Boolean = false;
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131697551, 1).a();
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131693401, 1).a();
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
    auxm.a().a(this.jdField_c_of_type_Boolean);
  }
  
  public void c() {}
  
  public void d()
  {
    this.jdField_a_of_type_Boolean = false;
    auxm.a().b();
  }
  
  public void e()
  {
    auxj.a().a(this);
    auxm.a().a(this.jdField_c_of_type_Boolean, this.d);
  }
  
  public void f()
  {
    QFlutterSkinEnginePlugin.setCurrentThemeId(ThemeUtil.getCurrentThemeId());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     auwo
 * JD-Core Version:    0.7.0.1
 */