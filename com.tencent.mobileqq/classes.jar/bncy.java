import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
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

public class bncy
  extends bnbm
{
  private bnda jdField_a_of_type_Bnda;
  private bndc jdField_a_of_type_Bndc;
  private bndx jdField_a_of_type_Bndx;
  private bndy jdField_a_of_type_Bndy;
  private boym jdField_a_of_type_Boym;
  private boyn jdField_a_of_type_Boyn;
  private NoScrollViewPager jdField_a_of_type_DovComQqImAeViewNoScrollViewPager;
  private TabLayout jdField_a_of_type_DovComQqImAeViewTabLayout;
  private List<bndb> jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = bnzc.a();
  
  public bncy(boyn paramboyn, boym paramboym)
  {
    this.jdField_a_of_type_Boyn = paramboyn;
    this.jdField_a_of_type_Boym = paramboym;
    a();
  }
  
  private Activity a()
  {
    if (this.jdField_a_of_type_Boyn == null) {
      return null;
    }
    return this.jdField_a_of_type_Boyn.a();
  }
  
  private bnbm a()
  {
    int i = this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem();
    return bndb.a((bndb)this.jdField_a_of_type_JavaUtilList.get(i));
  }
  
  private void a()
  {
    if (a() == null) {
      return;
    }
    int i = a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bnqb.a.a());
    String str = a().getIntent().getStringExtra("VIDEO_STORY_ACTIVITY_ID");
    if (bnqb.a(i).a()) {
      bnyl.a().a(i, str);
    }
    str = a().getIntent().getStringExtra("intent_key_uid_for_report");
    bnyl.a().a(str);
    bnyl.a().a(true);
    bnyl.a().b();
    bnyl.a().a();
    bnyl.a().b(bnov.a(a()));
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
    String str = a().getIntent().getStringExtra("tab");
    int i;
    if ((!TextUtils.isEmpty(str)) && (str.equals("camera")))
    {
      i = 1;
      bnzb.b("AECircleMultiUnit", "[initBottomTab] choose camera tab");
    }
    for (;;)
    {
      localArrayList.add(this.jdField_a_of_type_Boyn.a().getResources().getString(2131694258));
      localArrayList.add(this.jdField_a_of_type_Boyn.a().getResources().getString(2131689669));
      this.jdField_a_of_type_DovComQqImAeViewTabLayout.a(this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager);
      this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabSelectedCallback(new bncz(this));
      if (!b())
      {
        if (i != 0) {
          g();
        }
        this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabs(localArrayList, 0);
        return;
      }
      this.jdField_a_of_type_DovComQqImAeViewTabLayout.setTabs(localArrayList, i);
      return;
      i = 0;
    }
  }
  
  private boolean b()
  {
    Activity localActivity = this.jdField_a_of_type_Boyn.a();
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
    bnvd.a().b();
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setCurrentItem(1, true);
    this.jdField_a_of_type_Bndy.p();
    this.jdField_a_of_type_Bndy.f();
  }
  
  private void g()
  {
    if (Build.VERSION.SDK_INT < 23) {
      break label8;
    }
    label8:
    while (!(this.jdField_a_of_type_Boyn.a() instanceof QIMCameraCaptureActivity)) {
      return;
    }
    QIMCameraCaptureActivity localQIMCameraCaptureActivity = (QIMCameraCaptureActivity)this.jdField_a_of_type_Boyn.a();
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
    bnzb.b("AECircleMultiUnit", "[sendMobileQQPeakCreate]");
    localIntent.setAction("peak_oncreate");
    localIntent.setPackage(BaseApplicationImpl.getContext().getPackageName());
    BaseApplicationImpl.getContext().sendBroadcast(localIntent);
  }
  
  public View a()
  {
    View localView = this.jdField_a_of_type_Boyn.a().getLayoutInflater().inflate(2131558504, null);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager = ((NoScrollViewPager)localView.findViewById(2131380863));
    this.jdField_a_of_type_DovComQqImAeViewTabLayout = ((TabLayout)localView.findViewById(2131378178));
    this.jdField_a_of_type_Bnda.a(this.jdField_a_of_type_DovComQqImAeViewTabLayout);
    this.jdField_a_of_type_Bndc = new bndc(null);
    this.jdField_a_of_type_JavaUtilList.add(new bndb(this.jdField_a_of_type_Bndx, this.jdField_a_of_type_Bndx.a()));
    this.jdField_a_of_type_JavaUtilList.add(new bndb(this.jdField_a_of_type_Bndy, this.jdField_a_of_type_Bndy.a()));
    this.jdField_a_of_type_Bndc.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.setAdapter(this.jdField_a_of_type_Bndc);
    b();
    return localView;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    bnzb.b("AECircleMultiUnit", "on activity result.");
    if ((paramInt2 != -1) || (a() == null) || (paramIntent == null)) {
      return;
    }
    String str1;
    String str2;
    ArrayList localArrayList;
    if (paramIntent.getBooleanExtra("h5_key_flag", false))
    {
      str1 = paramIntent.getStringExtra("h5_key_video_path");
      str2 = paramIntent.getStringExtra("h5_key_thumb_path");
      localArrayList = new ArrayList();
      localArrayList.add(str1);
      HashMap localHashMap = new HashMap();
      localHashMap.put(str1, bojb.a(bojb.a(str1, str2), paramIntent.getStringExtra("widgetinfo"), null, 1, null));
      boiv.a(a(), localArrayList, localHashMap, bnqb.a(a().getIntent()));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boyn.a().finish();
      return;
      if (paramIntent.getBooleanExtra("ae_editor_video_flag", false))
      {
        str1 = paramIntent.getStringExtra("ae_editor_video_path");
        str2 = paramIntent.getStringExtra("ae_editor_video_thumb_path");
        paramInt1 = paramIntent.getIntExtra("ae_editor_video_export_size_height", 0);
        paramInt2 = paramIntent.getIntExtra("ae_editor_video_export_size_width", 0);
        localArrayList = paramIntent.getStringArrayListExtra("ae_editor_video_text_cache");
        int i = paramIntent.getIntExtra("ae_editor_video_from", bnqb.a.a());
        paramIntent = (LocalMediaInfo)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap");
        boiv.a(BaseApplicationImpl.getContext(), str1, str2, new Size(paramInt2, paramInt1), localArrayList, paramIntent, i);
      }
      else
      {
        boiv.a(a(), paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS"), (HashMap)paramIntent.getSerializableExtra("PeakConstants.selectedMediaInfoHashMap"), a().getIntent().getIntExtra("VIDEO_STORY_FROM_TYPE", bnqb.a.a()));
      }
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    this.jdField_a_of_type_Bndy = new bndy(this.jdField_a_of_type_Boyn, this.jdField_a_of_type_Boym);
    this.jdField_a_of_type_Bndx = new bndx(this.jdField_a_of_type_Boyn, this.jdField_a_of_type_Boym);
    this.jdField_a_of_type_Bndy.a(paramBundle);
    this.jdField_a_of_type_Bndx.a(paramBundle);
    bqcd.b(this.jdField_a_of_type_Boyn.a());
    a(this.jdField_a_of_type_Boyn.a(), this.jdField_a_of_type_Boyn.a().getResources().getColor(2131167224), true);
    paramBundle = new IntentFilter();
    paramBundle.addAction("ae_editor_bottom_tab_show_hide");
    paramBundle.addAction("ae_editor_bottom_tab_change_style");
    Activity localActivity = this.jdField_a_of_type_Boyn.a();
    bnda localbnda = new bnda(null);
    this.jdField_a_of_type_Bnda = localbnda;
    localActivity.registerReceiver(localbnda, paramBundle);
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
    bnzb.b("AECircleMultiUnit", "on destroy");
    this.jdField_a_of_type_Boyn.a().unregisterReceiver(this.jdField_a_of_type_Bnda);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        bndb localbndb = (bndb)localIterator.next();
        if ((localbndb != null) && (bndb.a(localbndb) != null)) {
          bndb.a(localbndb).e();
        }
      }
    }
  }
  
  public void f()
  {
    super.f();
    a().f();
    if (this.jdField_a_of_type_DovComQqImAeViewNoScrollViewPager.getCurrentItem() == 0) {
      bnyh.a().Y();
    }
    for (;;)
    {
      h();
      bnzb.b("AECircleMultiUnit", "onResume.");
      if (this.jdField_a_of_type_Bndy != null) {
        this.jdField_a_of_type_Bndy.a();
      }
      return;
      bnyh.a().Z();
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
 * Qualified Name:     bncy
 * JD-Core Version:    0.7.0.1
 */