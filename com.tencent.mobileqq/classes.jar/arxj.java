import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
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
import com.tencent.mobileqq.flutter.container.QFlutterFragment;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import io.flutter.embedding.engine.renderer.OnFirstFrameRenderedListener;
import java.util.HashMap;
import java.util.Map;

public class arxj
  implements arya, OnFirstFrameRenderedListener
{
  private long jdField_a_of_type_Long;
  private Activity jdField_a_of_type_AndroidAppActivity;
  private Bundle jdField_a_of_type_AndroidOsBundle;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private arxi jdField_a_of_type_Arxi;
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean;
  private long jdField_c_of_type_Long;
  private boolean jdField_c_of_type_Boolean;
  private long jdField_d_of_type_Long;
  private boolean jdField_d_of_type_Boolean;
  private boolean e;
  
  public arxj(arxi paramarxi)
  {
    this.jdField_a_of_type_Arxi = paramarxi;
  }
  
  private void f()
  {
    Object localObject1 = new FrameLayout(this.jdField_a_of_type_AndroidAppActivity);
    ((FrameLayout)localObject1).setId(2131366790);
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
    localObject1 = new arxk().a(str).a((Map)localObject2).a();
    ((QFlutterFragment)localObject1).a(new arxl(this));
    localObject2 = this.jdField_a_of_type_Arxi.a();
    if (localObject2 != null) {
      ((FragmentManager)localObject2).beginTransaction().add(2131366790, (Fragment)localObject1).commitAllowingStateLoss();
    }
  }
  
  public View a()
  {
    QFlutterSkinEnginePlugin.setCurrentThemeId(ThemeUtil.getCurrentThemeId());
    this.jdField_a_of_type_AndroidViewViewGroup = new RelativeLayout(this.jdField_a_of_type_AndroidAppActivity);
    this.jdField_a_of_type_AndroidViewViewGroup.setBackgroundResource(2130849461);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(this.jdField_a_of_type_AndroidAppActivity).inflate(2131560708, null);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    return this.jdField_a_of_type_AndroidViewViewGroup;
  }
  
  public void a()
  {
    if (aryd.a().a()) {
      this.jdField_a_of_type_Boolean = false;
    }
    this.jdField_c_of_type_Long = SystemClock.elapsedRealtime();
    aryd.a().a(this, this.jdField_b_of_type_Boolean, this.jdField_a_of_type_Boolean);
    aryg.a().a();
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null)
    {
      this.jdField_a_of_type_Boolean = false;
      paramBundle.remove("android:support:fragments");
    }
    if ((this.jdField_a_of_type_Arxi.a() == null) || (this.jdField_a_of_type_Arxi.a() == null)) {
      throw new RuntimeException("must specify Activity and FragmentManager!");
    }
    this.jdField_a_of_type_AndroidAppActivity = this.jdField_a_of_type_Arxi.a();
    this.jdField_a_of_type_AndroidOsBundle = this.jdField_a_of_type_Arxi.a();
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
  
  public void a(aryb paramaryb)
  {
    if ((paramaryb != null) && (paramaryb.a()))
    {
      this.jdField_c_of_type_Boolean = paramaryb.jdField_a_of_type_Boolean;
      this.jdField_d_of_type_Boolean = true;
      this.jdField_d_of_type_Long = SystemClock.elapsedRealtime();
      f();
      if (paramaryb.jdField_b_of_type_Boolean) {
        QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 0, 2131698547, 1).a();
      }
      return;
    }
    QQToast.a(this.jdField_a_of_type_AndroidAppActivity, 1, 2131694092, 1).a();
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void b() {}
  
  public void c()
  {
    aryg.a().b();
  }
  
  public void d()
  {
    aryd.a().a(this);
    aryg.a().a(this.jdField_c_of_type_Boolean, this.jdField_d_of_type_Boolean);
  }
  
  public void e()
  {
    QFlutterSkinEnginePlugin.setCurrentThemeId(ThemeUtil.getCurrentThemeId());
  }
  
  public void onFirstFrameRendered()
  {
    QLog.d("QFlutter.fragment", 1, String.format("onFirstFrameRendered, mIsFirstLaunch: %s, mIsFirstFrame: %s", new Object[] { Boolean.valueOf(this.jdField_c_of_type_Boolean), Boolean.valueOf(this.e) }));
    if ((!this.jdField_c_of_type_Boolean) && (!this.e))
    {
      this.e = true;
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.removeView(this.jdField_a_of_type_AndroidViewView);
    long l4 = SystemClock.elapsedRealtime();
    long l1 = l4 - this.jdField_a_of_type_Long;
    long l2 = l4 - this.jdField_b_of_type_Long;
    long l3 = this.jdField_d_of_type_Long - this.jdField_c_of_type_Long;
    l4 -= this.jdField_d_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutter.fragment", 2, String.format("[QFlutterFirstFrame], mIsPreloadProcess: %s, isFirstLaunch: %s, totalCost: %s, toolCost: %s, launchCost: %s, openPageCost: %s", new Object[] { Boolean.valueOf(this.jdField_b_of_type_Boolean), Boolean.valueOf(this.jdField_c_of_type_Boolean), Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4) }));
    }
    if (this.jdField_a_of_type_Boolean) {
      aryh.a(this.jdField_c_of_type_Boolean, l1, l2, l3, l4, this.jdField_b_of_type_Boolean);
    }
    aryg.a().a(this.jdField_c_of_type_Boolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     arxj
 * JD-Core Version:    0.7.0.1
 */