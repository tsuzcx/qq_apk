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
import com.tencent.tavcut.bean.Size;
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

public class bkol
  extends bkmz
{
  private bkon jdField_a_of_type_Bkon;
  private bkop jdField_a_of_type_Bkop;
  private bkpk jdField_a_of_type_Bkpk;
  private bkpl jdField_a_of_type_Bkpl;
  private bmhg jdField_a_of_type_Bmhg;
  private bmhh jdField_a_of_type_Bmhh;
  private NoScrollViewPager jdField_a_of_type_DovComQqImAeViewNoScrollViewPager;
  private TabLayout jdField_a_of_type_DovComQqImAeViewTabLayout;
  private List<bkoo> jdField_a_of_type_JavaUtilList = new ArrayList();
  
  public bkol(bmhh parambmhh, bmhg parambmhg)
  {
    this.jdField_a_of_type_Bmhh = parambmhh;
    this.jdField_a_of_type_Bmhg = parambmhg;
    a();
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_Bmhh == null) {
      return null;
    }
    return this.jdField_a_of_type_Bmhh.a();
  }
  
  private bkmz a()
  {
    int i = this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem();
    return bkoo.a((bkoo)this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a()
  {
    if (a() == null) {}
    long l2;
    long l1;
    do
    {
      return;
      int i = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", blat.a.a());
      String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
      if (blat.a(i).a()) {
        bliy.a().a(i, str);
      }
      str = a().getIntent().getStringExtra("intent_key_uid_for_report");
      bliy.a().a(str);
      bliy.a().a(true);
      bliy.a().b();
      bliy.a().a();
      bliy.a().b(bkzr.a(a()));
      l2 = System.currentTimeMillis();
      l1 = l2 - a().getIntent().getLongExtra("PhotoConst.timestamp", 0L);
      l2 -= a().getIntent().getLongExtra("PhotoConst.timestamp_last_activity", 0L);
    } while ((l1 > 60000L) || (l2 > 60000L) || (l1 < 0L) || (l2 < 0L));
    bliu.a().a(l1, l2);
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
    localArrayList.add(this.jdField_a_of_type_Bmhh.a().getResources().getString(2131695241));
    localArrayList.add(this.jdField_a_of_type_Bmhh.a().getResources().getString(2131689782));
    this.jdField_a_of_type_DovComQqImAeViewTabLayout.a(this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager);
    this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabs(localArrayList, 0);
    this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabSelectedCallback(new bkom(this));
  }
  
  private boolean b()
  {
    Activity localActivity = this.jdField_a_of_type_Bmhh.a();
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
    this.jdField_a_of_type_Bkpl.b(false);
    this.jdField_a_of_type_Bkpl.f();
  }
  
  private void g()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Bmhh.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Bmhh.a();
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
    bljn.b("AECircleMultiUnit", "[sendMobileQQPeakCreate]");
    localIntent.setAction("peak_oncreate");
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public View a()
  {
    View localView = this.jdField_a_of_type_Bmhh.a().getLayoutInflater().inflate(2131558492, null);
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      localView.findViewById(2131379906).setFitsSystemWindows(true);
    }
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager = ((NoScrollViewPager)localView.findViewById(2131379906));
    this.jdField_a_of_type_DovComQqImAeViewTabLayout = ((TabLayout)localView.findViewById(2131377352));
    this.jdField_a_of_type_Bkon.a(this.jdField_a_of_type_DovComQqImAeViewTabLayout);
    this.jdField_a_of_type_Bkop = new bkop(null);
    this.jdField_a_of_type_JavaUtilList.add(new bkoo(this.jdField_a_of_type_Bkpk, this.jdField_a_of_type_Bkpk.a()));
    this.jdField_a_of_type_JavaUtilList.add(new bkoo(this.jdField_a_of_type_Bkpl, this.jdField_a_of_type_Bkpl.a()));
    this.jdField_a_of_type_Bkpl.b(true);
    this.jdField_a_of_type_Bkpl.d();
    this.jdField_a_of_type_Bkop.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setAdapter(this.jdField_a_of_type_Bkop);
    b();
    return localView;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    bljn.b("AECircleMultiUnit", "on activity result.");
    if ((paramInt2 != -1) || (a() == null) || (paramIntent == null)) {
      return;
    }
    if (paramIntent.getBooleanExtra("ae_editor_video_flag", false))
    {
      String str1 = paramIntent.getStringExtra("ae_editor_video_path");
      String str2 = paramIntent.getStringExtra("ae_editor_video_thumb_path");
      String str3 = paramIntent.getStringExtra("ae_editor_video_session_id");
      paramInt1 = paramIntent.getIntExtra("ae_editor_video_export_size_height", 0);
      paramInt2 = paramIntent.getIntExtra("ae_editor_video_export_size_width", 0);
      ArrayList localArrayList = paramIntent.getStringArrayListExtra("ae_editor_video_text_cache");
      int i = paramIntent.getIntExtra("ae_editor_video_from", blat.a.a());
      blpw.a(BaseApplicationImpl.getContext(), str1, str2, str3, new Size(paramInt2, paramInt1), localArrayList, i);
    }
    for (;;)
    {
      this.jdField_a_of_type_Bmhh.a().finish();
      return;
      blpw.a(a(), paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"), (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"), a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", blat.a.a()));
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_Bkpl = new bkpl(this.jdField_a_of_type_Bmhh, this.jdField_a_of_type_Bmhg);
    this.jdField_a_of_type_Bkpk = new bkpk(this.jdField_a_of_type_Bmhh, this.jdField_a_of_type_Bmhg);
    this.jdField_a_of_type_Bkpl.a(paramBundle);
    this.jdField_a_of_type_Bkpk.a(paramBundle);
    bnle.b(this.jdField_a_of_type_Bmhh.a());
    a(this.jdField_a_of_type_Bmhh.a(), this.jdField_a_of_type_Bmhh.a().getResources().getColor(2131167140), false);
    paramBundle = this.jdField_a_of_type_Bmhh.a();
    bkon localbkon = new bkon(null);
    this.jdField_a_of_type_Bkon = localbkon;
    paramBundle.registerReceiver(localbkon, new IntentFilter("ae_editor_bottom_tab_show_hide"));
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
    bljn.b("AECircleMultiUnit", "on destroy");
    this.jdField_a_of_type_Bmhh.a().unregisterReceiver(this.jdField_a_of_type_Bkon);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bkoo localbkoo = (bkoo)localIterator.next();
        if ((localbkoo != null) && (bkoo.a(localbkoo) != null)) {
          bkoo.a(localbkoo).e();
        }
      }
    }
  }
  
  public void f()
  {
    super.f();
    a().f();
    if (this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem() == 0) {
      bliu.a().L();
    }
    for (;;)
    {
      h();
      bljn.b("AECircleMultiUnit", "onResume.");
      return;
      bliu.a().M();
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
 * Qualified Name:     bkol
 * JD-Core Version:    0.7.0.1
 */