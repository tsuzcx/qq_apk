import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.widget.immersive.ImmersiveUtils;
import dov.com.qq.im.QIMCameraCaptureActivity;
import dov.com.qq.im.ae.view.NoScrollViewPager;
import dov.com.qq.im.ae.view.TabLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import mqq.app.QQPermissionDenied;
import mqq.app.QQPermissionGrant;

public class bkke
  extends bkis
{
  private bkkg jdField_a_of_type_Bkkg;
  private bkki jdField_a_of_type_Bkki;
  private bkld jdField_a_of_type_Bkld;
  private bkle jdField_a_of_type_Bkle;
  private bmcu jdField_a_of_type_Bmcu;
  private bmcv jdField_a_of_type_Bmcv;
  private NoScrollViewPager jdField_a_of_type_DovComQqImAeViewNoScrollViewPager;
  private TabLayout jdField_a_of_type_DovComQqImAeViewTabLayout;
  private List<bkkh> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bkke(bmcv parambmcv, bmcu parambmcu)
  {
    this.jdField_a_of_type_Bmcv = parambmcv;
    this.jdField_a_of_type_Bmcu = parambmcu;
    a();
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_Bmcv == null) {
      return null;
    }
    return this.jdField_a_of_type_Bmcv.a();
  }
  
  private bkis a()
  {
    int i = this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem();
    return bkkh.a((bkkh)this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a()
  {
    if (a() == null) {
      return;
    }
    int i = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bkwm.a.a());
    String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (bkwm.a(i).a()) {
      bler.a().a(i, str);
    }
    str = a().getIntent().getStringExtra("intent_key_uid_for_report");
    bler.a().a(str);
    bler.a().a(true);
    bler.a().b();
    bler.a().a();
    bler.a().b(bkvk.a(a()));
  }
  
  public static void a(Activity paramActivity, int paramInt, boolean paramBoolean)
  {
    if (paramActivity == null) {
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      Window localWindow = paramActivity.getWindow();
      localWindow.clearFlags(67108864);
      localWindow.getDecorView().setSystemUiVisibility(1280);
      localWindow.addFlags(-2147483648);
      localWindow.setStatusBarColor(paramInt);
    }
    for (;;)
    {
      ImmersiveUtils.a(paramBoolean, paramActivity.getWindow());
      return;
      if (Build.VERSION.SDK_INT >= 19) {
        paramActivity.getWindow().addFlags(67108864);
      }
    }
  }
  
  private void b()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.jdField_a_of_type_Bmcv.a().getResources().getString(2131695239));
    localArrayList.add(this.jdField_a_of_type_Bmcv.a().getResources().getString(2131689782));
    this.jdField_a_of_type_DovComQqImAeViewTabLayout.a(this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager);
    this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabs(localArrayList, 0);
    this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabSelectedCallback(new bkkf(this));
  }
  
  private boolean b()
  {
    Activity localActivity = this.jdField_a_of_type_Bmcv.a();
    if (Build.VERSION.SDK_INT < 23) {}
    int i;
    int j;
    do
    {
      return true;
      i = localActivity.checkSelfPermission("android.permission.CAMERA");
      j = localActivity.checkSelfPermission("android.permission.RECORD_AUDIO");
    } while ((i == 0) && (j == 0));
    return false;
  }
  
  private void c()
  {
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setCurrentItem(1, true);
    this.jdField_a_of_type_Bkle.b(false);
    this.jdField_a_of_type_Bkle.f();
  }
  
  private void g()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Bmcv.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Bmcv.a();
    int i;
    if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.CAMERA") != 0)
    {
      i = 1;
      label48:
      if (localQIMCameraCaptureActivity.checkSelfPermission("android.permission.RECORD_AUDIO") == 0) {
        break label132;
      }
    }
    label132:
    for (int j = 1;; j = 0)
    {
      LinkedList localLinkedList = new LinkedList();
      if (i != 0) {
        localLinkedList.add("android.permission.CAMERA");
      }
      if (j != 0) {
        localLinkedList.add("android.permission.RECORD_AUDIO");
      }
      if (localLinkedList.size() <= 0) {
        break;
      }
      localQIMCameraCaptureActivity.requestPermissions(this, 1, (String[])localLinkedList.toArray(new String[0]));
      return;
      i = 0;
      break label48;
    }
  }
  
  private void h()
  {
    Intent localIntent = new Intent();
    blfg.b("AECircleMultiUnit", "[sendMobileQQPeakCreate]");
    localIntent.setAction("peak_oncreate");
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public View a()
  {
    View localView = this.jdField_a_of_type_Bmcv.a().getLayoutInflater().inflate(2131558492, null);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localView.findViewById(2131379848).setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager = ((NoScrollViewPager)localView.findViewById(2131379848));
    this.jdField_a_of_type_DovComQqImAeViewTabLayout = ((TabLayout)localView.findViewById(2131377298));
    this.jdField_a_of_type_Bkkg.a(this.jdField_a_of_type_DovComQqImAeViewTabLayout);
    this.jdField_a_of_type_Bkki = new bkki(null);
    this.jdField_a_of_type_JavaUtilList.add(new bkkh(this.jdField_a_of_type_Bkld, this.jdField_a_of_type_Bkld.a()));
    this.jdField_a_of_type_JavaUtilList.add(new bkkh(this.jdField_a_of_type_Bkle, this.jdField_a_of_type_Bkle.a()));
    this.jdField_a_of_type_Bkle.b(true);
    this.jdField_a_of_type_Bkle.d();
    this.jdField_a_of_type_Bkki.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setAdapter(this.jdField_a_of_type_Bkki);
    b();
    return localView;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    blfg.b("AECircleMultiUnit", "on activity result.");
    if ((paramInt2 != -1) || (a() == null)) {
      return;
    }
    bllk.a(a(), paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"), (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"), a().getIntent().getIntExtra("editorFrom", -1));
    this.jdField_a_of_type_Bmcv.a().finish();
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_Bkle = new bkle(this.jdField_a_of_type_Bmcv, this.jdField_a_of_type_Bmcu);
    this.jdField_a_of_type_Bkld = new bkld(this.jdField_a_of_type_Bmcv, this.jdField_a_of_type_Bmcu);
    this.jdField_a_of_type_Bkle.a(paramBundle);
    this.jdField_a_of_type_Bkld.a(paramBundle);
    bngs.b(this.jdField_a_of_type_Bmcv.a());
    a(this.jdField_a_of_type_Bmcv.a(), this.jdField_a_of_type_Bmcv.a().getResources().getColor(2131167138), false);
    paramBundle = this.jdField_a_of_type_Bmcv.a();
    bkkg localbkkg = new bkkg(null);
    this.jdField_a_of_type_Bkkg = localbkkg;
    paramBundle.registerReceiver(localbkkg, new IntentFilter("ae_editor_bottom_tab_show_hide"));
  }
  
  public boolean a()
  {
    a().a();
    return super.a();
  }
  
  public boolean a(int paramInt, KeyEvent paramKeyEvent, boolean paramBoolean)
  {
    if (paramInt == 4) {
      a();
    }
    return super.a(paramInt, paramKeyEvent, paramBoolean);
  }
  
  public void b(Bundle paramBundle)
  {
    super.b(paramBundle);
    a().b(paramBundle);
  }
  
  public void b_(int paramInt1, int paramInt2)
  {
    super.b_(paramInt1, paramInt2);
    a().b_(paramInt1, paramInt2);
  }
  
  public void d()
  {
    super.d();
    a().d();
  }
  
  @QQPermissionDenied(1)
  public void denied() {}
  
  public void e()
  {
    super.e();
    blfg.b("AECircleMultiUnit", "on destroy");
    this.jdField_a_of_type_Bmcv.a().unregisterReceiver(this.jdField_a_of_type_Bkkg);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bkkh localbkkh = (bkkh)localIterator.next();
        if ((localbkkh != null) && (bkkh.a(localbkkh) != null)) {
          bkkh.a(localbkkh).e();
        }
      }
    }
  }
  
  public void f()
  {
    super.f();
    a().f();
    if (this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem() == 0) {
      blen.a().L();
    }
    for (;;)
    {
      h();
      blfg.b("AECircleMultiUnit", "onResume.");
      return;
      blen.a().M();
    }
  }
  
  @QQPermissionGrant(1)
  public void grant()
  {
    c();
  }
  
  public void p()
  {
    super.p();
    a().p();
  }
  
  public void t()
  {
    super.t();
    a().t();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     bkke
 * JD-Core Version:    0.7.0.1
 */